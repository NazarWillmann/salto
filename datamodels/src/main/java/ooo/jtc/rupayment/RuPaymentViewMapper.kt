package ooo.jtc.rupayment

import ooo.jtc.generic.AMOUNT_TO_STRING
import ooo.jtc.generic.KJavaConverter
import ooo.jtc.generic.LOCALDATE_TO_STRING
import ooo.jtc.generic.MASK_ACCOUNT
import ooo.jtc.generic.VIEW_CONVERTER
import ooo.jtc.generic.ViewConverter
import ooo.jtc.interfaces.AbstractViewMapper
import ooo.jtc.rupayment.dto.RuPaymentDto
import ooo.jtc.rupayment.model.RuPaymentStatus
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.NullValuePropertyMappingStrategy

@Mapper(
    uses = [ViewConverter::class],
    imports = [RuPaymentStatus::class, KJavaConverter::class],
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT
)
interface RuPaymentViewMapper : AbstractViewMapper<RuPaymentDto, RuPaymentView> {

    override fun toDto(view: RuPaymentView): RuPaymentDto

    @Mappings(
        Mapping(
            source = "documentDate", target = "documentDate",
            qualifiedByName = [VIEW_CONVERTER, LOCALDATE_TO_STRING], defaultValue = ""
        ),
        Mapping(source = "status", target = "statusSystem", defaultValue = ""),
        Mapping(
            target = "statusClient",
            expression = "java(KJavaConverter.INSTANCE.convertToStatusClient(RuPaymentStatus.values(),dto.getStatus()))"
        ),
        Mapping(
            target = "statusBank",
            expression = "java(KJavaConverter.INSTANCE.convertToStatusBank(RuPaymentStatus.values(),dto.getStatus()))"
        ),
        Mapping(source = "id", target = "id", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL),
        Mapping(source = "receiver.name", target = "receiverName", defaultValue = ""),
        Mapping(source = "receiver.inn", target = "receiverInn", defaultValue = ""),
        Mapping(source = "receiver.kpp", target = "receiverKpp", defaultValue = ""),
        Mapping(source = "receiver.account", target = "receiverAccount", defaultValue = ""),
        Mapping(source = "receiver.bank.name", target = "receiverBankName", defaultValue = ""),
        Mapping(source = "receiver.bank.corrAccount", target = "receiverBankCorrAccount", defaultValue = ""),
        Mapping(
            source = "receiver.bank.corrAccount",
            target = "receiverBankMaskedCorrAccount",
            defaultValue = "",
            qualifiedByName = [VIEW_CONVERTER, MASK_ACCOUNT]
        ),
        Mapping(source = "receiver.bank.bic", target = "receiverBankBic", defaultValue = ""),
        Mapping(source = "payer.account", target = "payerAccount", defaultValue = ""),
        Mapping(source = "payer.name", target = "payerName", defaultValue = ""),
        Mapping(source = "payer.inn", target = "payerInn", defaultValue = ""),
        Mapping(source = "payer.kpp", target = "payerKpp", defaultValue = ""),
        Mapping(
            source = "amount", target = "amount",
            qualifiedByName = [VIEW_CONVERTER, AMOUNT_TO_STRING], defaultValue = ""
        ),
        Mapping(
            target = "amountMasked",
            expression = "java(KJavaConverter.INSTANCE.amountToMaskedString(dto.getAmount()))"
        ),
        Mapping(
            target = "amountAntie",
            expression = "java(KJavaConverter.INSTANCE.amountToMaskedAntieString(dto.getAmount()))"
        ),
        Mapping(source = "paymentGround.description", target = "paymentGroundDescription", defaultValue = ""),
        Mapping(source = "paymentGround.nds", target = "nds", qualifiedByName = [VIEW_CONVERTER, AMOUNT_TO_STRING], defaultValue = ""),
        Mapping(source = "priority", target = "priority", defaultValue = ""),
        Mapping(source = "receiver.account", target = "receiverMaskedAccount", qualifiedByName = [VIEW_CONVERTER, MASK_ACCOUNT], defaultValue = ""),
        Mapping(source = "payer.account", target = "payerMaskedAccount", qualifiedByName = [VIEW_CONVERTER, MASK_ACCOUNT], defaultValue = ""),
        Mapping(
            target = "payerHiddenMaskedAccount",
            expression = "java(KJavaConverter.INSTANCE.hiddenMaskAccount(dto.getPayer().getAccount()))"
        ),
        Mapping(source = "userPaymentType", target = "userPaymentType"),
        Mapping(source = "budget.payerStatus", target = "budgetPayerStatus", defaultValue = ""),
        Mapping(source = "budget.kbk", target = "budgetKbk", defaultValue = ""),
        Mapping(source = "budget.oktmo", target = "budgetOktmo", defaultValue = ""),
        Mapping(source = "budget.reasonCode", target = "budgetReasonCode", defaultValue = ""),
        Mapping(source = "budget.budgetField107", target = "budgetBudgetField107", defaultValue = ""),
        Mapping(source = "budget.reasonDocumentNumber", target = "budgetReasonDocumentNumber", defaultValue = ""),
        Mapping(source = "budget.reasonDocumentDate", target = "budgetReasonDocumentDate", defaultValue = ""),
        Mapping(source = "budgetType", target = "budgetType")

    )
    override fun toView(dto: RuPaymentDto): RuPaymentView


}