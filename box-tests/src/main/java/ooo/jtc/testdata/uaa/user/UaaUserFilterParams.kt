package ooo.jtc.testdata.uaa.user

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.uaa.user.dto.UaaUserDto

enum class UaaUserFilterParams(
    override var field: String,
    override var fieldDataProvider: (UaaUserDto) -> Any
) : IFilterParams<UaaUserDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    BLOCK_REASON("blockReason", fieldDataProvider = { it.blockReason!! }),
    BLOCK_USER("blockUser", fieldDataProvider = { it.blockUser!! }),
    PERMANENT_BLOCKED("permanentBlocked", fieldDataProvider = { it.permanentBlocked }),
    PREFERRED_LOCALE("preferredLocale", fieldDataProvider = { it.preferredLocale!! }),
    TEMPORARY_BLOCKED("temporaryBlocked", fieldDataProvider = { it.temporaryBlocked }),
    TEMPORARY_BLOCKED_UNTIL("temporaryBlockedUntil", fieldDataProvider = { it.temporaryBlockedUntil!! }),
    USER_DETAILS_FIRST_NAME("userDetails.firstName", fieldDataProvider = { it.userDetails!!.firstName!! }),
    USER_DETAILS_MIDDLE_NAME("userDetails.middleName", fieldDataProvider = { it.userDetails!!.middleName!! }),
    USER_DETAILS_LAST_NAME("userDetails.lastName", fieldDataProvider = { it.userDetails!!.lastName!! }),
    USER_DETAILS_EMAIL("userDetails.email", fieldDataProvider = { it.userDetails!!.email!! }),
    USER_DETAILS_PHONE("userDetails.phoneNumber", fieldDataProvider = { it.userDetails!!.phoneNumber!! }),
    ;
}