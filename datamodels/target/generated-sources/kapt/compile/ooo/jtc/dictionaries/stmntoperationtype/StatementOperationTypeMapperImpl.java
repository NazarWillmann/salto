package ooo.jtc.dictionaries.stmntoperationtype;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class StatementOperationTypeMapperImpl implements StatementOperationTypeMapper {

    @Override
    public StatementOperationType toDomainModel(StatementOperationTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        StatementOperationTypeBuilder statementOperationType = StatementOperationTypeBuilder.builder();

        statementOperationType.setId( dto.getId() );
        statementOperationType.setVersion( dto.getVersion() );
        statementOperationType.setCode( dto.getCode() );
        statementOperationType.setDescription( dto.getDescription() );

        return statementOperationType.create();
    }

    @Override
    public StatementOperationTypeDto toDto(StatementOperationType domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        StatementOperationTypeDtoBuilder statementOperationTypeDto = StatementOperationTypeDtoBuilder.builder();

        statementOperationTypeDto.setId( domainModel.getId() );
        statementOperationTypeDto.setVersion( domainModel.getVersion() );
        statementOperationTypeDto.setCode( domainModel.getCode() );
        statementOperationTypeDto.setDescription( domainModel.getDescription() );

        return statementOperationTypeDto.create();
    }
}
