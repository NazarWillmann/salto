package ooo.jtc.testdata.dictionaries.bankinfo

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.bankinfo.BankInfoDto

enum class BankInfoSortingParams(
    override var field: String,
    override var fieldDataProvider: (BankInfoDto) -> Any?
) : ISortingParams<BankInfoDto> {
    ID("id", fieldDataProvider = { it.id }),
    FULL_NAME("fullName", { it.fullName }),
    SHORT_NAME("shortName", { it.shortName }),
    LICENSE("license", { it.license }),
    LICENSE_TYPE("licenseType", { it.licenseType }),
    LOGO_FILE_ID("logoFileId", { it.logoFileId }),
    WEBSITE("website", { it.website }),
    DESCRIPTION("description", { it.description }),

    //UI_SETTINGS("uiSettings", { it.uiSettings }),
    // NESTED: phoneSupports: List<PhoneInfoDto>
    // NESTED: applicationUrls: List<BankInfoApplicationUrlDto>
    // NESTED: socialUrls: List<BankInfoSocialUrlDto>
    ;
}
