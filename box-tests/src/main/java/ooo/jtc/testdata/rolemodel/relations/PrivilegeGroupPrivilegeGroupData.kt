package ooo.jtc.testdata.rolemodel.relations

import ooo.jtc.rolemodel.relations.PrivilegeGroupPrivilegeGroup
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData
import java.util.UUID

/**
 * PrivilegeGroupPrivilegeGroupData data, that loaded from testDataProvider
 * as [PrivilegeGroupPrivilegeGroupData] in [PrivilegeGroupPrivilegeGroup] format.
 */
object PrivilegeGroupPrivilegeGroupData : TestData<PrivilegeGroupPrivilegeGroup>(PrivilegeGroupPrivilegeGroup::class.java) {
    override var atMarkerPredicate: (PrivilegeGroupPrivilegeGroup) -> Boolean = { false }
    override val dbDataConsumer = { Services.DOMAIN_CONTROLLER.db.execSql("SELECT * FROM privilege_group_group") }
    override val dataFileName = "privilegeGroup_privilegeGroup.json"

    override var createRecord: (() -> PrivilegeGroupPrivilegeGroup)? = null
        get() { throw RuntimeException("This should be created by PrivilegeGroup API!") }

    override var removeRecord: ((PrivilegeGroupPrivilegeGroup) -> Unit)? = null
        get() { throw RuntimeException("This should be deleted by PrivilegeGroup API!") }

    fun getAllPrGroupsIdsContainingPrGroupsIds(prGroupId: UUID): List<UUID> {
        var allPrGroupsIds = mutableListOf<UUID>()
        var fullIterationResult = mutableListOf(prGroupId)

        do {
            allPrGroupsIds.addAll(fullIterationResult)
            allPrGroupsIds = allPrGroupsIds.distinct().toMutableList()
            fullIterationResult = mutableListOf()

            allPrGroupsIds.forEach { groupId ->
                fullIterationResult.addAll(getPrGroupsIdsContainingPrGroupId(groupId))
            }
            fullIterationResult = fullIterationResult.distinct().toMutableList()

        } while (fullIterationResult.isNotEmpty() && !allPrGroupsIds.containsAll(fullIterationResult))

        return allPrGroupsIds.minus(prGroupId)
    }

    private fun getPrGroupsIdsContainingPrGroupId(prGroupId: UUID): List<UUID> {
        return get { it.idChild == prGroupId }.map { it.idParent }
    }
}