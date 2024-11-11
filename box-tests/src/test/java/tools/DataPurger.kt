package tools

import io.qameta.allure.Step
import ooo.jtc.UTILS_CLEAN_AT_DATA
import ooo.jtc.UTILS_PURGE_DATABASE
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeSteps
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeSteps
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeSteps
import ooo.jtc.api.dictionaries.individualrepresentative.IndividualRepresentativeSteps
import ooo.jtc.api.uaa.steps.UaaUserSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.core.applicationProperties
import ooo.jtc.db.DbExecutorJdbi
import ooo.jtc.logging.LoggerDelegate
import ooo.jtc.news.dto.PublicationTargetType
import ooo.jtc.scripts.invoke
import ooo.jtc.scripts.soft
import ooo.jtc.sign.SignToolType
import ooo.jtc.testdata.DbSchemas
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeData
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.branchindividal.BranchIndividualData
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeData
import ooo.jtc.testdata.dictionaries.individual.IndividualData
import ooo.jtc.testdata.dictionaries.individualrepresentative.IndividualRepresentativeData
import ooo.jtc.testdata.getDbConnect
import ooo.jtc.testdata.uaa.user.StoredUserData
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.UUID

object DataPurger {
    private val log by LoggerDelegate()
    private fun checkEnvironment() {
        if (!applicationProperties.server.api.host.contains("salto-test"))
            throw RuntimeException("Database manipulation is allowed ONLY in 'salto-test' environment!")
    }

    @Test
    @DisplayName("Удаление всех таблиц в известных АТ-проекту схемах БД")
    @UTILS_PURGE_DATABASE
    internal fun dropTablesCascade() {
        checkEnvironment()

        val schemes = DbSchemas.values().toList()
        val getTablesInSchemeSqlQueryTemplate =
                "SELECT table_name FROM information_schema.tables" +
                " WHERE table_catalog = '%s' AND table_schema = 'public';"
        val dropTablesCascadeSqlQueryTemplate =
                "DROP TABLE %s CASCADE;"

        var dbConnect: DbExecutorJdbi
        var getTablesInSchemeSqlQuery: String
        var tablesInScheme: List<String>
        var dropTablesCascadeSqlQuery: String
        for (dbScheme in schemes) {
            log.info("Checking scheme '${dbScheme.dbSchemaName}'...")
            dbConnect = dbScheme.getDbConnect()
            getTablesInSchemeSqlQuery = getTablesInSchemeSqlQueryTemplate.format(dbScheme.dbSchemaName)
            tablesInScheme = dbConnect.execSql(getTablesInSchemeSqlQuery, String::class.java).sorted()
            log.info("List of tables found: $tablesInScheme")

            if (tablesInScheme.isEmpty()) {
                log.info("No tables found; skipping scheme ${dbScheme.dbSchemaName}.")
                continue
            }

            dropTablesCascadeSqlQuery = dropTablesCascadeSqlQueryTemplate
                .format(tablesInScheme.joinToString(separator = "\", \"", prefix = "\"", postfix = "\""))
            log.info("Attempting to drop tables (query length is ${dropTablesCascadeSqlQuery.length})")
            dbConnect.execute(dropTablesCascadeSqlQuery)
        }
    }


    //region Clean AT-created data
    private fun <T> Iterable<T>.joinToStringForSql(): String = this.joinToString(separator = "', '", prefix = "'", postfix = "'")

    private val existingUsers: Map<UUID, String>
        get() = StoredUserData.get()
            .map { Pair(it.uaaUserId!!, it.login) }
            .sortedBy { it.second }
            .toMap()

    //@Test
    @DisplayName("Получение существующих пользователей")
    internal fun logExistingUsers() {
        existingUsers.forEach {
            log.info("User [${it.key}] '${it.value}'")
        }
    }

    @Test
    @DisplayName("Удаление пользователей и связанных сущностей (Клиентов, Представителей, Подразделений, Счетов, документов)")
    @UTILS_CLEAN_AT_DATA
    internal fun cleanAtUsersAndRelatedEntities() {
        checkEnvironment()

        cleanUsers()
        cleanCryptoOfNonexistentUsers()
        cleanRepresentativesOfNonexistentUsers()

        //Accounts, Representatives and relations to Branches are deleted as well
        cleanCustomersAndRelatedEntitiesOfNonexistentUsers()
        cleanIndividualsAndRelatedEntitiesOfNonexistentUsers()

        cleanNonAccessibleBranches()

        // Sergeyev [2021.08.04]: !!! NEEDS TESTING !!!
        cleanLettersNonexistentCustomersAndBranches()
        cleanCurRkoDocsOfNonexistentCustomersAndBranches()
        cleanRuRkoOfNonexistentCustomersAndBranches()
        cleanMailGroupsOfNonexistentCustomersAndBranches()
        cleanPublicationsOfNonexistentCustomersAndBranches()
        // Add: salary_register, account_reservation when tests added
    }

    //region Clean user-related entities in 'dictionary' service
    //@Test
    @DisplayName("Удаление пользователей по их id")
    internal fun cleanUsers(
        usersToDelete: List<UUID> = existingUsers
            .filter { it.value.endsWith(TestConstants.AT_POSTFIX) }
            .keys.toList()
    ) {
        if (usersToDelete.isEmpty())
            return

        val userIdsInSql = usersToDelete.joinToStringForSql()
        val getDeleteQuery: (String) -> String =
            { tableName -> "DELETE FROM $tableName WHERE id_user IN ($userIdsInSql)" }

        val dbConnect = Services.UAA_MANAGEMENT.db
        dbConnect.execute(getDeleteQuery("sso_session"))
        dbConnect.execute(getDeleteQuery("oauth_scope_approve"))
        dbConnect.execute(getDeleteQuery("oauth_user_scope"))
        dbConnect.execute(getDeleteQuery("tech_user"))
        dbConnect.execute(getDeleteQuery("cat_ldap_user"))
        dbConnect.execute(getDeleteQuery("cat_openid_user"))
        dbConnect.execute(getDeleteQuery("cat_stored_user"))

        val steps = UaaUserSteps()
        usersToDelete.forEach { steps.delete(it) }
    }

    //@Test
    @DisplayName("Удаление крипто-записей несуществующих пользователей")
    internal fun cleanCryptoOfNonexistentUsers() {
        /* Sergeyev [2021.08.02]:
         * Запросы к БД, их очерёдность и условия поиска записей повторяют логику работы БД,
         * то есть то, как связаны записи и какие что используют
         */
        val signDbConnect = Services.SIGN.db
        val cryptoDbConnect = Services.CRYPTO.db
        val currentExistingUsersIds = existingUsers.keys.joinToStringForSql()

        "Delete SMS sign tools" {
            val deleteSignToolsSmsSql = "DELETE FROM sign_tool" +
                    " WHERE id_user NOT IN ($currentExistingUsersIds)" +
                    " AND tool_type = '${SignToolType.SMS.type}'"
            signDbConnect.execute(deleteSignToolsSmsSql)
        }

        "Delete CryptoAuto sign tools" {
            val selectCryptoAutoRefIdsSql = "SELECT id_ref FROM sign_tool" +
                    " WHERE id_user NOT IN ($currentExistingUsersIds)" +
                    " AND tool_type = '${SignToolType.CRYPTO_AUTO.type}'"
            val cryptoAutoIds = signDbConnect.execSql(selectCryptoAutoRefIdsSql, String::class.java)
            if (cryptoAutoIds.isNotEmpty()) {
                val cryptoAutoIdsInSql = cryptoAutoIds.joinToStringForSql()
                val deleteBankKeysSql = "DELETE FROM bank_key" +
                        " WHERE id IN ($cryptoAutoIdsInSql)"
                cryptoDbConnect.execute(deleteBankKeysSql)
            }
            val deleteSignToolsCryptoAutoSql = "DELETE FROM sign_tool" +
                    " WHERE id_user NOT IN ($currentExistingUsersIds)" +
                    " AND tool_type = '${SignToolType.CRYPTO_AUTO.type}'"
            signDbConnect.execute(deleteSignToolsCryptoAutoSql)
        }

        "Delete Crypto sign tools" {
            val selectCryptoRefIdsSql = "SELECT id_ref FROM sign_tool" +
                    " WHERE id_user NOT IN ($currentExistingUsersIds)" +
                    " AND tool_type = '${SignToolType.CRYPTO.type}'"
            val cryptoIds = signDbConnect.execSql(selectCryptoRefIdsSql, String::class.java)
            if (cryptoIds.isNotEmpty()) {
                val cryptoIdsInSql = cryptoIds.joinToStringForSql()
                val selectCryptoProfilesSql = "SELECT id_crypto_profile FROM certificate" +
                        " WHERE id IN ($cryptoIdsInSql)"
                val cryptoProfilesIds = cryptoDbConnect.execSql(selectCryptoProfilesSql, String::class.java)
                if (cryptoProfilesIds.isNotEmpty()) {
                    val cryptoProfilesIdsInSql = cryptoProfilesIds.joinToStringForSql()
                    val deleteCryptoProfilesSql = "DELETE FROM crypto_profile" +
                            " WHERE id IN ($cryptoProfilesIdsInSql)"
                    cryptoDbConnect.execute(deleteCryptoProfilesSql)
                }
                val deleteCertificatesSql = "DELETE FROM certificate" +
                        " WHERE id IN ($cryptoIdsInSql)"
                cryptoDbConnect.execute(deleteCertificatesSql)
            }
            val deleteSignToolsCryptoSql = "DELETE FROM sign_tool" +
                    " WHERE id_user NOT IN ($currentExistingUsersIds)" +
                    " AND tool_type = '${SignToolType.CRYPTO.type}'"
            signDbConnect.execute(deleteSignToolsCryptoSql)
        }
    }

    //@Test
    @DisplayName("Удаление записей о представителях несуществующих пользователей")
    internal fun cleanRepresentativesOfNonexistentUsers() {
        val currentExistingUsersIds = existingUsers.keys

        "Delete bank representatives" {
            val bankRepresentatives = BankRepresentativeData.get(fromCache = false) { it.userId!! !in currentExistingUsersIds }
            val brSteps = BankRepresentativeSteps()
            bankRepresentatives.forEach { brSteps.delete(it.id!!) }
        }

        "Delete branch representatives" {
            val branchRepresentatives = BranchRepresentativeData.get(fromCache = false) { it.userId!! !in currentExistingUsersIds }
            val brSteps = BranchRepresentativeSteps()
            branchRepresentatives.forEach { brSteps.delete(it.id!!) }
        }

        "Delete customer representatives" {
            val customerRepresentatives = CustomerRepresentativeData.get(fromCache = false) { it.userId!! !in currentExistingUsersIds }
            val crSteps = CustomerRepresentativeSteps()
            customerRepresentatives.forEach { crSteps.delete(it.id!!) }
        }

        "Delete individual representatives" {
            val individualRepresentatives = IndividualRepresentativeData.get(fromCache = false) { it.userId !in currentExistingUsersIds }
            val irSteps = IndividualRepresentativeSteps()
            individualRepresentatives.forEach { irSteps.delete(it.id!!) }
        }
    }

    //@Test
    @DisplayName("Удаление Клиентов ЮЛ не связанных ни с одним пользователем")
    internal fun cleanCustomersAndRelatedEntitiesOfNonexistentUsers() {
        val clientAccessibleCustomers = CustomerRepresentativeData.get(fromCache = false)
            .map { it.customerId!! }
            .distinct()
        val clientsToDelete = CustomerData.get(fromCache = false, seekAtCreated = true) { it.id!! !in clientAccessibleCustomers }
        clientsToDelete.forEach {
            // Sergeyev [2021.08.03]: deletes BranchCustomers, Representatives and Accounts too
            soft { CustomerPrepareSteps.deleteCustomerAndRelatedEntitiesIfPossible(it.id!!) }
        }
    }

    //@Test
    @DisplayName("Удаление Клиентов ФЛ не связанных ни с одним пользователем")
    internal fun cleanIndividualsAndRelatedEntitiesOfNonexistentUsers() {
        val clientAccessibleIndividuals = IndividualRepresentativeData.get(fromCache = false)
            .map { it.individualId }
            .distinct()
        val clientsToDelete = IndividualData.get(fromCache = false, seekAtCreated = true) { it.id!! !in clientAccessibleIndividuals }
        // TODO Sergeyev [2021.08.04]: add deletion to PrepareSteps
        // clientsToDelete.forEach { soft { IndividualPrepareSteps.deleteIndividualAndRelatedEntitiesIfPossible(it.id!!) } }
    }

    //@Test
    @DisplayName("Удаление подразделений, не связанных ни с одним Клиентом или Пользователем")
    internal fun cleanNonAccessibleBranches(onlyAtCreated: Boolean? = true) {
        val bankAccessibleBranchesIds = BranchRepresentativeData.get(fromCache = false).map { it.branchId!! }
        val customerAccessibleBranchesIds = BranchCustomerData.get(fromCache = false).map { it.branchId }
        val individualAccessibleBranchesIds = BranchIndividualData.get(fromCache = false).map { it.branchId }
        val accessibleBranchesIds = bankAccessibleBranchesIds
            .plus(customerAccessibleBranchesIds)
            .plus(individualAccessibleBranchesIds)
            .distinct()

        //Sergeyev [2021.08.03]: when this method is run, client Representatives, Accounts and relations to Branches are deleted already
        val branchesToDelete = BranchData.get(fromCache = false, seekAtCreated = onlyAtCreated) { it.id!! !in accessibleBranchesIds }
        branchesToDelete.forEach {
            soft { BranchPrepareSteps.deleteBranchAndRelatedEntities(it.id!!, deleteChildren = false) }
        }
    }
    //endregion

    //region Clean documents of non-existent clients and branches
    private fun getDocumentIdsQuery(docTableName: String): String {
        val existingCustomersIds = CustomerData.get(fromCache = false).map { it.id!! }
        val existingBranchesIds = BranchData.get(fromCache = false).map { it.id!! }

        // no checking for empty ids list: at least non-AT data should always be present
        return "SELECT id FROM $docTableName" +
                " WHERE id_customer NOT IN (${existingCustomersIds.joinToStringForSql()})" +
                " OR id_branch NOT IN (${existingBranchesIds.joinToStringForSql()})"
    }

    val getDeleteWhereInQuery: (String, String, String) -> String =
        { tableName, fieldName, docIds -> "DELETE FROM $tableName WHERE $fieldName IN ($docIds)" }

    @Step("Удаление документов таблицы {docTableName}")
    private fun deleteFromDocumentsTable(
        dbService: DbExecutorJdbi,
        docTableName: String,
        additionalQueriesBeforeDeletion: ((String) -> List<String>)? = null,
        deletionQueryParams: Map<String, String> = mapOf(
            Pair("${docTableName}_signatures", "id_document"),
            Pair("${docTableName}_history", "id_document"),
            Pair("${docTableName}_favorites", "id_entity"),
            Pair(docTableName, "id")
        ),
        additionalQueriesAfterDeletion: ((String) -> List<String>)? = null // Sergeyev [2021.08.04]: delete from <document>_docnum_gen?
    ) {
        // get document 'id's for deletion
        val docIds = dbService.execSql(getDocumentIdsQuery(docTableName), String::class.java)
        if (docIds.isEmpty()) {
            log.info("No $docTableName documents of non-existent customers/branches found")
            return
        } else log.info("These documents will be deleted:\n $docIds")

        // prepare
        val docIdsForSql = docIds.joinToStringForSql()
        val getDeleteInTableQuery: (String, String) -> String =
            { tableName, fieldName -> getDeleteWhereInQuery(tableName, fieldName, docIdsForSql) }

        // perform deletion
        additionalQueriesBeforeDeletion?.invoke(docIdsForSql)?.forEach { dbService.execute(it) }
        deletionQueryParams.forEach { (tableName, fieldName) -> dbService.execute(getDeleteInTableQuery(tableName, fieldName)) }
        additionalQueriesAfterDeletion?.invoke(docIdsForSql)?.forEach { dbService.execute(it) }
    }


    @Test
    @DisplayName("Удаление Писем несуществующих Клиентов ЮЛ и Подразделений")
    internal fun cleanLettersNonexistentCustomersAndBranches() {
        // Letters To Bank
        val ltbDocTableName = "letter_to_bank"
        val ltbRemoveAnswerRelationsQuery: (String) -> String =
            { docIds -> "UPDATE $ltbDocTableName SET id_letter_from_bank = NULL WHERE id IN ($docIds)" }
        deleteFromDocumentsTable(
            dbService = Services.LETTER.db,
            docTableName = ltbDocTableName,
            additionalQueriesBeforeDeletion = { docIds -> listOf(ltbRemoveAnswerRelationsQuery(docIds)) },
            deletionQueryParams = mapOf(
                Pair("attachment_$ltbDocTableName", "id_$ltbDocTableName"),
                Pair("${ltbDocTableName}_signatures", "id_document"),
                Pair("${ltbDocTableName}_history", "id_document"),
                Pair("${ltbDocTableName}_favorites", "id_entity"),
                Pair(ltbDocTableName, "id")
            )
        )

        // Letters From Bank
        val lfbDocTableName = "letter_from_bank"
        val lfbRemoveAnswerRelationsQuery: (String) -> String =
            { docIds -> "UPDATE $lfbDocTableName SET id_letter_to_bank = NULL WHERE id IN ($docIds)" }
        deleteFromDocumentsTable(
            dbService = Services.LETTER.db,
            docTableName = lfbDocTableName,
            additionalQueriesBeforeDeletion = { docIds -> listOf(lfbRemoveAnswerRelationsQuery(docIds)) },
            deletionQueryParams = mapOf(
                Pair("attachment_$lfbDocTableName", "id_$lfbDocTableName"),
                Pair("${lfbDocTableName}_signatures", "id_document"),
                Pair("${lfbDocTableName}_history", "id_document"),
                Pair("${lfbDocTableName}_favorites", "id_entity"),
                Pair(lfbDocTableName, "id")
            )
        )
    }

    //@Test
    @DisplayName("Удаление документов ВРКО несуществующих Клиентов ЮЛ и Подразделений")
    internal fun cleanCurRkoDocsOfNonexistentCustomersAndBranches() {
        listOf(
            "curconversion",    // Currency Conversion
            "curtransfer"       // Currency Transfer
        ).forEach { docTable ->
            deleteFromDocumentsTable(
                dbService = Services.CUR_RKO.db,
                docTableName = docTable
            )
        }
    }

    //@Test
    @DisplayName("Удаление документов РРКО (в т.ч. выписок) от несуществующих Клиентов ЮЛ и Подразделений")
    internal fun cleanRuRkoOfNonexistentCustomersAndBranches() {
        listOf(
            "ruaccept_request",
            "rucollection_order",
            "rupayment",
            "rupayment_request_in",
            "rupayment_request_out"
        ).forEach { docTable ->
            deleteFromDocumentsTable(
                dbService = Services.RKO_RU_PAYMENT.db,
                docTableName = docTable)
        }

        // Statements
        val stmntDocTableName = "statement"
        val deleteStmntDocFavsQuery: (String) -> String = { stmntIds ->
            "DELETE FROM statement_doc_favorites WHERE id_entity IN (" +
                    " SELECT id FROM statement_doc WHERE id_statement IN ($stmntIds)" +
                    " )"
        }
        deleteFromDocumentsTable(
            dbService = Services.RKO_STATEMENT.db,
            docTableName = stmntDocTableName,
            additionalQueriesBeforeDeletion = { stmntIds -> listOf(deleteStmntDocFavsQuery(stmntIds))},
            deletionQueryParams = mapOf(
                Pair("${stmntDocTableName}_signatures", "id_document"),
                Pair("${stmntDocTableName}_history", "id_document"),
                Pair("${stmntDocTableName}_favorites", "id_entity"),
                Pair("${stmntDocTableName}_doc", "id_statement"),
                Pair(stmntDocTableName, "id")
            )
        )
    }

    //@Test
    @DisplayName("Удаление Групп рассылок Клиентов несуществующих Клиентов ЮЛ и Подразделений")
    internal fun cleanMailGroupsOfNonexistentCustomersAndBranches() {
        val dbService = Services.NEWS.db
        val dictTableName = "mail_group"
        val dictCustomerTableName = "receiver_customer_mail_group"
        val existingBranchesIds = BranchData.get(fromCache = false).map { it.id!! }
        val existingCustomersIds = CustomerData.get(fromCache = false).map { it.id!! }

        // delete MailGroups' customer relations of non-existent Branches
        val getMailGroupIdsByBranchesQuery = "SELECT id FROM $dictTableName" +
                " WHERE id_branch NOT IN (${existingBranchesIds.joinToStringForSql()})"
        val mgIds = dbService.execSql(getMailGroupIdsByBranchesQuery, String::class.java)
        var mgIdsInSql: String
        if (mgIds.isNotEmpty()) {
            mgIdsInSql = mgIds.joinToStringForSql()
            dbService.execute(getDeleteWhereInQuery(dictCustomerTableName, "id_$dictTableName", mgIdsInSql))
        }

        // delete MailGroups' customer relations of non-existent Customers
        val deleteInvalidRelationsQuery = "DELETE FROM $dictCustomerTableName" +
                " WHERE id_customer NOT IN (${existingCustomersIds.joinToStringForSql()})"
        dbService.execute(deleteInvalidRelationsQuery)

        // delete all empty MailGroups
        val getEmptyMailGroupIds = "SELECT id FROM $dictTableName" +
                " WHERE id NOT IN (SELECT distinct(id_$dictTableName) FROM $dictCustomerTableName)"
        val emptyMgIds = dbService.execSql(getEmptyMailGroupIds, String::class.java)
        if (mgIds.isNotEmpty()) {
            mgIdsInSql = emptyMgIds.joinToStringForSql()
            dbService.execute(getDeleteWhereInQuery("${dictTableName}_favorites", "id_entity", mgIdsInSql))
            dbService.execute(getDeleteWhereInQuery(dictTableName, "id", mgIdsInSql))
        }
    }

    //@Test
    @DisplayName("Удаление Публикаций от несуществующих  Клиентов ЮЛ и Подразделений")
    internal fun cleanPublicationsOfNonexistentCustomersAndBranches() {
        val dbService = Services.NEWS.db
        val dictTableName = "publication"
        val dictCustomerTableName = "receiver_customer_publication"
        val existingBranchesIds = BranchData.get(fromCache = false).map { it.id!! }
        val existingCustomersIds = CustomerData.get(fromCache = false).map { it.id!! }

        // delete 'DIRECT' Publications' and mustKnow's relations to non-existent Customers
        val deleteInvalidRelationsQueryFilter = "id_customer NOT IN (${existingCustomersIds.joinToStringForSql()})"
        dbService.execute("DELETE FROM $dictCustomerTableName WHERE $deleteInvalidRelationsQueryFilter")
        dbService.execute("DELETE FROM must_know WHERE $deleteInvalidRelationsQueryFilter")

        // get empty 'DIRECT' Publications' ids
        val getEmptyDirectPublicationsIds = "SELECT id FROM $dictTableName" +
                " WHERE target_type = '${PublicationTargetType.DIRECT.type}'" +
                " AND id NOT IN (SELECT distinct(id_$dictTableName) FROM $dictCustomerTableName)"
        var publIds = dbService.execSql(getEmptyDirectPublicationsIds, String::class.java)

        // add Publications' ids of non-existent Branches ('DIRECT' and 'GENERAL')
        val getPublicationsIdsByBranchesQuery = "SELECT id FROM $dictTableName" +
                " WHERE id_branch NOT IN (${existingBranchesIds.joinToStringForSql()})"
        val publIdsByBranches = dbService.execSql(getPublicationsIdsByBranchesQuery, String::class.java)
        publIds = publIds.plus(publIdsByBranches).distinct()
        if (publIds.isNotEmpty()) {
            val publIdsInSql = publIds.joinToStringForSql()
            dbService.execute(getDeleteWhereInQuery(dictCustomerTableName, "id_$dictTableName", publIdsInSql))
            dbService.execute(getDeleteWhereInQuery("must_know", "i_$dictTableName", publIdsInSql))
            dbService.execute(getDeleteWhereInQuery("${dictTableName}_estimate", "id_entity", publIdsInSql))
            dbService.execute(getDeleteWhereInQuery("${dictTableName}_favorites", "id_entity", publIdsInSql))
            dbService.execute(getDeleteWhereInQuery("${dictTableName}_history", "id_$dictTableName", publIdsInSql))
            dbService.execute(getDeleteWhereInQuery(dictTableName, "id", publIdsInSql))
        }
    }
    //endregion
    //endregion
}