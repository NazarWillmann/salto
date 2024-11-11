package ooo.jtc.dictionaries.bankru

import ooo.jtc.generic.CUSTOM_CONVERTER
import ooo.jtc.generic.CustomConverter
import ooo.jtc.generic.TIMESTAMP_TO_ZONEDDATE_TIME
import ooo.jtc.generic.ZONEDDATE_TIME_TO_TIMESTAMP
import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(uses = [CustomConverter::class])
interface BankRuMapper : AbstractDtoMapper<BankRu, BankRuDto> {

    @Mapping(source = "controlDate", target = "controlDate", qualifiedByName = [CUSTOM_CONVERTER, TIMESTAMP_TO_ZONEDDATE_TIME])
    override fun toDto(domainModel: BankRu): BankRuDto

    @Mapping(source = "controlDate", target = "controlDate", qualifiedByName = [CUSTOM_CONVERTER, ZONEDDATE_TIME_TO_TIMESTAMP])
    override fun toDomainModel(dto: BankRuDto): BankRu
}