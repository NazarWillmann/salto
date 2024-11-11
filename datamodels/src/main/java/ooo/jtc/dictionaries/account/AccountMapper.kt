package ooo.jtc.dictionaries.account

import ooo.jtc.generic.CUSTOM_CONVERTER
import ooo.jtc.generic.CustomConverter
import ooo.jtc.generic.TIMESTAMP_TO_ZONEDDATE_TIME
import ooo.jtc.generic.ZONEDDATE_TIME_TO_TIMESTAMP
import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(uses = [CustomConverter::class])
interface AccountMapper : AbstractDtoMapper<Account, AccountDto> {

    @Mappings(
        Mapping(source = "isBlock", target = "block.isBlock"),
        Mapping(source = "blockUserId", target = "block.blockUser"),
        Mapping(
            source = "blockDate", target = "block.blockDate",
            qualifiedByName = [CUSTOM_CONVERTER, TIMESTAMP_TO_ZONEDDATE_TIME]
        ),
        Mapping(
            source = "reserveBeginDate", target = "reserveBeginDate",
            qualifiedByName = [CUSTOM_CONVERTER, ZONEDDATE_TIME_TO_TIMESTAMP]
        ),
        Mapping(
            source = "reserveEndDate", target = "reserveEndDate",
            qualifiedByName = [CUSTOM_CONVERTER, ZONEDDATE_TIME_TO_TIMESTAMP]
        ),
        Mapping(
            source = "openDate", target = "openDate",
            qualifiedByName = [CUSTOM_CONVERTER, TIMESTAMP_TO_ZONEDDATE_TIME]
        ),
        Mapping(
            source = "closeDate", target = "closeDate",
            qualifiedByName = [CUSTOM_CONVERTER, TIMESTAMP_TO_ZONEDDATE_TIME]
        ),
        Mapping(
            source = "actualDate", target = "actualDate",
            qualifiedByName = [CUSTOM_CONVERTER, TIMESTAMP_TO_ZONEDDATE_TIME]
        )
    )
    override fun toDto(domainModel: Account): AccountDto

    @InheritInverseConfiguration
    @Mappings(
        Mapping(
            source = "block.blockDate", target = "blockDate",
            qualifiedByName = [CUSTOM_CONVERTER, ZONEDDATE_TIME_TO_TIMESTAMP]
        ),
        Mapping(
            source = "reserveBeginDate", target = "reserveBeginDate",
            qualifiedByName = [CUSTOM_CONVERTER, ZONEDDATE_TIME_TO_TIMESTAMP]
        ),
        Mapping(
            source = "reserveEndDate", target = "reserveEndDate",
            qualifiedByName = [CUSTOM_CONVERTER, ZONEDDATE_TIME_TO_TIMESTAMP]
        ),
        Mapping(
            source = "openDate", target = "openDate",
            qualifiedByName = [CUSTOM_CONVERTER, ZONEDDATE_TIME_TO_TIMESTAMP]
        ),
        Mapping(
            source = "closeDate", target = "closeDate",
            qualifiedByName = [CUSTOM_CONVERTER, ZONEDDATE_TIME_TO_TIMESTAMP]
        ),
        Mapping(
            source = "actualDate", target = "actualDate",
            qualifiedByName = [CUSTOM_CONVERTER, ZONEDDATE_TIME_TO_TIMESTAMP]
        )
    )
    override fun toDomainModel(dto: AccountDto): Account
}