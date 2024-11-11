package ooo.jtc.letters

import ooo.jtc.generic.KJavaConverter
import ooo.jtc.generic.LOCALDATE_TO_STRING
import ooo.jtc.generic.VIEW_CONVERTER
import ooo.jtc.generic.ViewConverter
import ooo.jtc.interfaces.AbstractViewMapper
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.NullValuePropertyMappingStrategy
import org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL

@Mapper(
    uses = [ViewConverter::class],
    imports = [LetterToBankStatus::class, KJavaConverter::class],
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
interface LetterToBankViewMapper : AbstractViewMapper<LetterToBankDto, LetterToBankView> {

    @InheritInverseConfiguration
    override fun toDto(view: LetterToBankView): LetterToBankDto

    @Mappings(
        Mapping(
            source = "documentDate", target = "documentDate",
            qualifiedByName = [VIEW_CONVERTER, LOCALDATE_TO_STRING], defaultValue = ""
        ),
        Mapping(source = "id", target = "id", nullValuePropertyMappingStrategy = SET_TO_NULL),
        Mapping(source = "documentNumber", target = "documentNumber", defaultValue = ""),
        Mapping(source = "status", target = "statusSystem", defaultValue = ""),
        Mapping(
            target = "statusClient",
            expression = "java(KJavaConverter.INSTANCE.convertToStatusClient(LetterToBankStatus.values(),dto.getStatus()))"
        ),
        Mapping(
            target = "statusBank",
            expression = "java(KJavaConverter.INSTANCE.convertToStatusBank(LetterToBankStatus.values(),dto.getStatus()))"
        ),
        Mapping(source = "createdAt", target = "createdAt", defaultValue = ""),
        Mapping(source = "customerName", target = "customerName", defaultValue = ""),
        Mapping(source = "branchName", target = "branchName", defaultValue = ""),
        Mapping(source = "contactName", target = "contactName", defaultValue = ""),
        Mapping(source = "contactPhone", target = "contactPhone", defaultValue = ""),
        Mapping(
            target = "contactPhoneMasked",
            expression = "java(KJavaConverter.INSTANCE.getUiMaskedPhone(dto.getContactPhone()))"
        ),
        Mapping(source = "docType", target = "docType", defaultValue = ""),
        Mapping(source = "docTypeDescription", target = "docTypeDescription", defaultValue = ""),
        Mapping(source = "docTheme", target = "docTheme", defaultValue = ""),
        Mapping(source = "docText", target = "docText", defaultValue = ""),

        Mapping(source = "branchId", target = "branchId", nullValuePropertyMappingStrategy = SET_TO_NULL),
        Mapping(source = "customerId", target = "customerId", nullValuePropertyMappingStrategy = SET_TO_NULL),
        Mapping(source = "letterFromBankId", target = "letterFromBankId", nullValuePropertyMappingStrategy = SET_TO_NULL),
        Mapping(source = "attachments", target = "attachments")
    )
    override fun toView(dto: LetterToBankDto): LetterToBankView
}