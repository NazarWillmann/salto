package ooo.jtc.api.dictionaries.branchindividual

import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.dictionaries.branchindividual.BranchIndividualDto
import ooo.jtc.extensions.getOrException
import ooo.jtc.extensions.ifNotEmpty
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchindividal.BranchIndividualData
import ooo.jtc.testdata.dictionaries.individual.IndividualData
import ooo.jtc.uaa.User
import java.util.*

object BranchIndividualPrepareSteps {
    fun getBranchIndividualDtoForCreate(
        individualUser: User = Users.individual,
        idIndividual: UUID = IndividualData.getOrCreate(individualUser).id!!
    ): BranchIndividualDto {
        individualUser.checkIsClientUser("Для создания связи от банковского пользователя, используйте функцию с передечей `idBranch`.")
        val linkedBranches = BranchIndividualData.searchByIndividualsIds(idIndividual)
        val linkedBranchesIds = linkedBranches.map { it.branchId }.distinct()
        val unlinkedBranchIds = BranchData.get { it.id !in linkedBranchesIds }.map { it.id!! }
        var availableBranchId = unlinkedBranchIds.ifNotEmpty { it.random() }
        if (unlinkedBranchIds.isEmpty()) {
            val linkedBranchIndividual = linkedBranches.random()
            BranchIndividualSteps().delete(linkedBranchIndividual.id!!)
            availableBranchId = linkedBranchIndividual.branchId
        }
        return getBranchIndividualDtoForCreate(availableBranchId!!, idIndividual).attachToAllure("result")
    }

    fun getBranchIndividualDtoForCreate(
        idBranch: UUID,
        idIndividual: UUID
    ): BranchIndividualDto {
        return BranchIndividualDto(
            id = null,
            version = 0,
            branchId = idBranch,
            individualId = idIndividual
        )
    }

    @Step("Создать связь Клиента ФЛ [{dtoForCreate.individualId}] и подразделения [{dtoForCreate.branchId}] ")
    fun createBranchIndividual(dtoForCreate: BranchIndividualDto = getBranchIndividualDtoForCreate()): BranchIndividualDto {
        return BranchIndividualSteps().create(dtoForCreate).data.getOrException()
    }
}