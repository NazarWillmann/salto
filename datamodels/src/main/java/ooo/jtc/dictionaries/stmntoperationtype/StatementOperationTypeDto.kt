package ooo.jtc.dictionaries.stmntoperationtype

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@EntityName(DictionaryNames.STATEMENT_OPERATION_TYPE)
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class StatementOperationTypeDto(
    override var id: UUID?,
    override var version: Int,
    var code: String,       // up to  2 symbols (digits only); unique
    var description: String // up to 30 symbols (cyrillic, '(', ')'); unique
) : UpdateIEntityDto<StatementOperationTypeDto> {

    override fun toModel(): StatementOperationType = Mappers.statementOperationTypeMapper.toDomainModel(this)
}