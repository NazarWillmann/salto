package ooo.jtc.dictionaries.incometype;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class IncomeTypeMapperImpl implements IncomeTypeMapper {

    @Override
    public IncomeType toDomainModel(IncomeTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        IncomeTypeBuilder incomeType = IncomeTypeBuilder.builder();

        incomeType.setId( dto.getId() );
        incomeType.setVersion( dto.getVersion() );
        incomeType.setCode( dto.getCode() );
        incomeType.setName( dto.getName() );
        incomeType.setDescription( dto.getDescription() );

        return incomeType.create();
    }

    @Override
    public IncomeTypeDto toDto(IncomeType domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        IncomeTypeDtoBuilder incomeTypeDto = IncomeTypeDtoBuilder.builder();

        incomeTypeDto.setId( domainModel.getId() );
        incomeTypeDto.setVersion( domainModel.getVersion() );
        incomeTypeDto.setCode( domainModel.getCode() );
        incomeTypeDto.setName( domainModel.getName() );
        incomeTypeDto.setDescription( domainModel.getDescription() );

        return incomeTypeDto.create();
    }
}
