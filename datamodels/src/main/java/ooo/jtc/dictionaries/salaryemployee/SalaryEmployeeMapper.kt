package ooo.jtc.dictionaries.salaryemployee

import ooo.jtc.generic.CUSTOM_CONVERTER
import ooo.jtc.generic.CustomConverter
import ooo.jtc.generic.LOCALDATE_TIME_TO_TIMESTAMP
import ooo.jtc.generic.TIMESTAMP_TO_LOCALDATE_TIME
import ooo.jtc.generic.TIMESTAMP_TO_ZONEDDATE_TIME
import ooo.jtc.generic.ZONEDDATE_TIME_TO_TIMESTAMP
import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(uses = [CustomConverter::class])
interface SalaryEmployeeMapper : AbstractDtoMapper<SalaryEmployee, SalaryEmployeeDto>
