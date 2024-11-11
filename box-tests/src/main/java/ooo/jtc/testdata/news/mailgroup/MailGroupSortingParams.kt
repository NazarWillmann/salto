package ooo.jtc.testdata.news.mailgroup

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.news.mailgroup.MailGroupDto

/**
 * Numbers are a reference to https://confluence.jtc.ooo/pages/viewpage.action?pageId=21733426
 */
enum class MailGroupSortingParams(
    override var field: String,
    override var fieldDataProvider: (MailGroupDto) -> Any?
) : ISortingParams<MailGroupDto> {

    ID("id", fieldDataProvider = { it.id!! }),                                          //1.1
    NAME("name", fieldDataProvider = { it.name }),                                      //1.2

    BRANCH_ID("branchId", fieldDataProvider = { it.branchId }),                         //2.1
    BRANCH_NAME("branchName", fieldDataProvider = { it.branchName }),                   //2.2

    CREATED_AT("createdAt", fieldDataProvider = { it.createdAt }),                      //3.1
    //CREATED_USER_ID("createdUserId", fieldDataProvider = { it.??? }),                 //3.2
    CREATED_USER_NAME("createdUserName", fieldDataProvider = { it.createdUserName }),   //3.3
    //CHANNEL("channel", fieldDataProvider = { it.??? }),                               //3.4
    //EDITED_AT("editedAt", fieldDataProvider = { it.??? }),                            //3.5
    //EDITED_USER_ID("editedUserId", fieldDataProvider = { it.??? }),                   //3.6
    //EDITED_USER_NAME("editedUserName", fieldDataProvider = { it.??? }),               //3.7

    //Not sortable by CUSTOMER_NESTED_* fields
    ;
}