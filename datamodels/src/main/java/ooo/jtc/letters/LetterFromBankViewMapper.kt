package ooo.jtc.letters

import ooo.jtc.generic.KJavaConverter
import ooo.jtc.generic.LOCALDATE_TO_STRING
import ooo.jtc.generic.VIEW_CONVERTER
import ooo.jtc.generic.ViewConverter
import ooo.jtc.interfaces.AbstractViewMapper
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankStatus
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.NullValuePropertyMappingStrategy.IGNORE
import org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL

@Mapper(
    uses = [ViewConverter::class],
    imports = [LetterFromBankStatus::class, KJavaConverter::class],
    nullValuePropertyMappingStrategy = IGNORE
)
interface LetterFromBankViewMapper : AbstractViewMapper<LetterFromBankDto, LetterFromBankView> {

    @InheritInverseConfiguration
    override fun toDto(view: LetterFromBankView): LetterFromBankDto

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
            expression = "java(KJavaConverter.INSTANCE.convertToStatusClient(LetterFromBankStatus.values(),dto.getStatus()))"
        ),
        Mapping(
            target = "statusBank",
            expression = "java(KJavaConverter.INSTANCE.convertToStatusBank(LetterFromBankStatus.values(),dto.getStatus()))"
        ),
        Mapping(source = "createdAt", target = "createdAt", defaultValue = ""),
        Mapping(source = "customerName", target = "customerName", defaultValue = ""),
        Mapping(source = "branchName", target = "branchName", defaultValue = ""),
        Mapping(source = "contactName", target = "contactName", defaultValue = ""),
        Mapping(source = "contactPhone", target = "contactPhone", defaultValue = ""),
        Mapping(source = "docType", target = "docType", defaultValue = ""),
        Mapping(source = "docTypeDescription", target = "docTypeDescription", defaultValue = ""),
        Mapping(source = "docTheme", target = "docTheme", defaultValue = ""),
        Mapping(source = "docText", target = "docText", defaultValue = ""),

        Mapping(source = "branchId", target = "branchId", nullValuePropertyMappingStrategy = SET_TO_NULL),
        Mapping(source = "customerId", target = "customerId", nullValuePropertyMappingStrategy = SET_TO_NULL),
        Mapping(source = "letterToBankId", target = "letterToBankId", nullValuePropertyMappingStrategy = SET_TO_NULL),
    )
    override fun toView(dto: LetterFromBankDto): LetterFromBankView
}