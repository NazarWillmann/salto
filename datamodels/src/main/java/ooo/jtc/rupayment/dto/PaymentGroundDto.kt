package ooo.jtc.rupayment.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PaymentGroundDto(
    var operationCode: String? = null,  //Код вида валютной операции
    var description: String? = null,    //Назначение платежа
    var nds: BigDecimal? = null,        //Сумма НДС
    var ndsCalculation: Int? = null,    //Тип расчета НДС
    var ndsPercent: String? = null      //Ставка для расчета НДС
)