package ooo.jtc.api.news.mailgroup

import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.dictionaries.branch.BranchSteps
import ooo.jtc.api.dictionaries.customer.CustomerSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.core.kexensions.checkIsBankUser
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.news.dto.toReceiverCustomer
import ooo.jtc.news.mailgroup.MailGroupChannel
import ooo.jtc.news.mailgroup.MailGroupDto
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.uaa.User
import java.util.UUID

object MailGroupPrepareSteps {

    /** Retrieve (MailGroup) client user. */
    fun retrieveClientUser(user: User): User =
        if (user.isClient) user else Users.client

    /** Retrieve (MailGroup) bank user. */
    fun retrieveBankUser(user: User): User =
        if (user.isBank) user else Users.bankOperator

    fun getGeneralMailGroupDtoForCreate(
        creatorBankUser: User,
        receiverClientUser: User = Users.client,
        customerIds: List<UUID>? = null
    ): MailGroupDto {
        val branchCustomer = BranchCustomerData
            .getOrCreateCommonBranchCustomer(clientUser = receiverClientUser, bankUser = creatorBankUser)
        val branch = BranchSteps(creatorBankUser).getById(branchCustomer.branchId).data.getOrException()
        val preparedDto = getMailGroupDtoForCreate(
            branchId = branch.id!!, branchName = branch.shortName,
        )
        if (customerIds.isNullOrEmpty()) {
            val customer = CustomerSteps(receiverClientUser).getById(branchCustomer.customerId).data.getOrException()
            preparedDto.customers = listOf(customer.toReceiverCustomer())
        } else {
            val customers = CustomerData.get()
                .filter { it.id!! in customerIds }
                .map { it.toDto() }
                .map { it.toReceiverCustomer() }
            preparedDto.customers = customers
        }
        return preparedDto
    }

    private fun getMailGroupDtoForCreate(
        branchId: UUID? = null,
        branchName: String? = null,
    ): MailGroupDto {
        return MailGroupDto(
            id = null,
            name = "MailGroup " + digits.random(6, 6) + TestConstants.AT_POSTFIX,

            branchId = branchId,
            branchName = branchName,
            customers = emptyList(),
            channel = MailGroupChannel.WEB,
            version = 0
        )
    }

    @Step("Создать сущность '${DictionaryNames.MAIL_GROUP}', доступную пользователям {creatorBankUser.login}, {receiverClientUser.login}")
    fun createMailGroup(
        creatorBankUser: User = Users.bankOperator,
        receiverClientUser: User = Users.client,
        dtoForCreate: MailGroupDto = getGeneralMailGroupDtoForCreate(creatorBankUser, receiverClientUser)
    ): MailGroupDto {
        return MailGroupSteps(creatorBankUser).create(dtoForCreate).data.getOrException()
    }

    @Step(
        "Найти набор разных сущностей '${DictionaryNames.MAIL_GROUP}' или создать их необходимое количество," +
                " доступное пользователю {searchingUser.login}"
    )
    fun getOrCreateDifferentMailGroupDtoList(
        searchingUser: User,
        creatorBankUser: User = retrieveBankUser(searchingUser),
        getPageRequest: () -> GetPageRequest = { GetPageRequest() },
        additionalFilter: (MailGroupDto) -> Boolean = { true },
        createDocFunc: () -> MailGroupDto = {
            if (searchingUser.isBank) createMailGroup(creatorBankUser = searchingUser)
            else createMailGroup(creatorBankUser = creatorBankUser, receiverClientUser = searchingUser)
        },
        amount: Long = REQUIRED_DATA_COUNT
    ): List<MailGroupDto> {
        creatorBankUser.checkIsBankUser()
        val resultDocsList: MutableList<MailGroupDto> = mutableListOf()

        val existingAvailableDocs = MailGroupSteps(searchingUser)
            .getPage(getPageRequest = getPageRequest.invoke())
            .page?.filter(additionalFilter)

        existingAvailableDocs?.let { resultDocsList.addAll(it.take(amount.toInt())) }
        while (resultDocsList.size < amount) {
            val newDocument = createDocFunc.invoke()
            resultDocsList.add(newDocument)
        }
        return resultDocsList.attachToAllure()
    }

    fun getMailGroupDtoForUpdate(mailGroupDto: MailGroupDto): MailGroupDto {
        return mailGroupDto.copy(
            name = "Upd. ${mailGroupDto.name}",
        )
    }
}