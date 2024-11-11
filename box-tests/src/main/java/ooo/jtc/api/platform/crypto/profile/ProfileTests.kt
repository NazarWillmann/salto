package ooo.jtc.api.platform.crypto.profile

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.platform.ProfileTaskIdsCommon
import ooo.jtc.api.platform.crypto.profile.ProfilePrepareSteps.getProfileDtoForUserForCreate
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.crypto.ProfileDto
import ooo.jtc.generic.CryptoNames
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.crypto.ProfileData
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "${FolderPrefix.CRYPTO} \"${CryptoNames.PROFILE}\" (profile)"

@Folder("$baseFolder/${SubFolder.CRUD}")        annotation class ProfileFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")     annotation class ProfileFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}")  annotation class ProfileFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")    annotation class ProfileFolderControls
//@formatter:on

@ProfileTaskIdsCommon
@ProfileFolderCrud
@HighPriority
class ProfileCreateTest(
    creatorUser: User = bankAdmin,
    createForUser: User
) : CreateTestTemplate<ProfileDto>(
    preExecution = { getProfileDtoForUserForCreate(createForUser) },
    steps = ProfileSteps(creatorUser)
)

@ProfileTaskIdsCommon
@ProfileFolderCrud
@HighPriority
class ProfileGetTest(user: User) :
    GetTestTemplate<ProfileDto>(
        preExecution = { ProfileData.randomOrException().toDto() },
        steps = ProfileSteps(user)
    )

@ProfileTaskIdsCommon
@ProfileFolderCrud
@HighPriority
class ProfileGetPageTest(user: User) :
    GetPageTestTemplate<ProfileDto>(
        steps = ProfileSteps(user)
    )

@ProfileTaskIdsCommon
@ProfileFolderCrud
@HighPriority
class ProfileDeleteTest(
    creatorUser: User = bankAdmin,
    createForUser: User
) : DeleteTestTemplate<ProfileDto>(
    preExecution = {
        val createdResponse = ProfileSteps(creatorUser).create(getProfileDtoForUserForCreate(createForUser))
        createdResponse.data!!
    },
    steps = ProfileSteps(creatorUser)
)

@ProfileTaskIdsCommon
@ProfileFolderCrud
@HighPriority
class ProfileUpdateTest(
    creatorUser: User = bankAdmin,
    createForUser: User
) : UpdateTestTemplate<ProfileDto, ProfileDto>(
    preExecution = {
        val createdDto = ProfileSteps(creatorUser).create(getProfileDtoForUserForCreate(createForUser)).data!!
        ProfilePrepareSteps.getProfileDtoForUpdate(createdDto)
    },
    steps = ProfileSteps(creatorUser)
)

//TODO Sergeyev [2020.09.03]: this
//@ProfileTaskIdsCommon
//@ProfileFolderSorting
//@LowPriority
//class ProfileSortingTest(
//    user: User = defaultBankAdminUser,
//    sortRequestFunction: () -> List<Sort>,
//    limit: Int
//) : SortingTestTemplate<ProfileDto, ProfileSortingParams, Any>(
//    sortList = sortRequestFunction.invoke(),
//    steps = ProfileSteps(user),
//    clazz = ProfileSortingParams::class.java,
//    limit = limit
//)
//
//@ProfileTaskIdsCommon
//@ProfileFolderFiltration
//@NormalPriority
//class ProfileFiltrationTest(
//    name: String,
//    user: User = defaultBankAdminUser,
//    preExecution: (() -> ProfileDto)?,
//    filterRequestFunction: (ProfileDto?) -> FilterData
//) : FiltrationTestTemplate<ProfileDto, ProfileFilterParams, Any>(
//    name = name,
//    filterRequestFunction = filterRequestFunction,
//    steps = ProfileSteps(user),
//    clazz = ProfileFilterParams::class.java,
//    preExecution = preExecution
//)
