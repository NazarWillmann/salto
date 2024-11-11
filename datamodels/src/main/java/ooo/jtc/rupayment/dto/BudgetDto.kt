package ooo.jtc.rupayment.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import ooo.jtc.rupayment.model.BudgetType

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class BudgetDto(
    var budgetType: BudgetType? = null,         //Признак бюджетного платежа
    var kbk: String? = null,                    //Код бюджетной классификации (КБК)
    var oktmo: String? = null,                  //Код ОКТМО
    var payerStatus: String? = null,            //Статус составителя документа
    var reasonCode: String? = null,             //Значение основания платежа
    var reasonDocumentDate: String? = null,     //Дата документа основания платежа
    var reasonDocumentNumber: String? = null,   //Номер документа основания платежа
    var budgetField107: String? = null          //Показатель налогового периода/код таможенного органа
)
