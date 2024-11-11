package ooo.jtc.testdata.news.publication

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.generic.attachments.concatFileNames
import ooo.jtc.news.dto.PublicationDto
import java.time.Instant

/**
 * Numbers are a reference to https://confluence.jtc.ooo/pages/viewpage.action?pageId=21733403
 */
enum class PublicationFilterParams(
    override var field: String,
    override var fieldDataProvider: (PublicationDto) -> Any
) : IFilterParams<PublicationDto> {

    // common document filter-params
    ID("id", fieldDataProvider = { it.id!! }),                                          //1.1
    DOCUMENT_NUMBER("documentNumber", fieldDataProvider = { it.documentNumber }),       //1.2
    DOCUMENT_DATE("documentDate", fieldDataProvider = { it.documentDate }),             //1.3

    // other filter-params
    STATUS("status", fieldDataProvider = { it.status!! }),                              //1.4
    DESCRIPTION("description", { it.description ?: "" }),                               //1.5
    PUBL_TYPE("publicationType", fieldDataProvider = { it.publicationType ?: "" }),     //1.6
    TARGET_TYPE("targetType", fieldDataProvider = { it.targetType ?: "" }),             //1.7
    IS_MUST_KNOW("isMustKnow", fieldDataProvider = { it.isMustKnow ?: false }),         //1.8
    IS_IMPORTANT("isImportant", fieldDataProvider = { it.isImportant ?: false }),       //1.9
    START_AT("startAt", fieldDataProvider = { it.startAt ?: Instant.MIN }),             //1.10
    END_AT("endAt", fieldDataProvider = { it.endAt ?: Instant.MIN }),                   //1.11
    MAILING_CHANNEL("mailingChannel", fieldDataProvider = { it.mailingChannel!! }),     //1.12
    IS_FOR_ALL_BRANCHES("isForAllBranches", fieldDataProvider = { it.isForAllBranches ?: false }),  //1.13

    HEADER("header", fieldDataProvider = { it.header ?: "" }),                          //2.1
    TEXT("text", fieldDataProvider = { it.text ?: "" }),                                //2.2
    LINK("link", fieldDataProvider = { it.link ?: "" }),                                //2.3
    LINK_TEXT("linkText", fieldDataProvider = { it.linkText ?: "" }),                   //2.4
    PICTURE("picture", fieldDataProvider = { it.picture ?: "" }),                       //2.5

    BRANCH_ID("branchId", fieldDataProvider = { it.branchId!! }),                       //3.1
    BRANCH_NAME("branchName", fieldDataProvider = { it.branchName ?: "" }),             //3.2

    CREATED_AT("createdAt", fieldDataProvider = { it.createdAt!! }),                    //4.1
    //CHANNEL("channel", fieldDataProvider = { it.??? }),                               //4.2

    IS_HAS_ATTACH("isHasAttach", fieldDataProvider = { it.isHasAttach ?: "" }),         //5.1
    ATTACH_FILE_NAME("attachName", { it.attachments?.concatFileNames() ?: "" }),        //5.2
    POSTED_AT("postedAt", fieldDataProvider = { it.postedAt ?: Instant.MIN }),          //5.3


    IS_FAVORITES("isFavorites", fieldDataProvider = { it.isFavorites ?: false }),
    ;
}