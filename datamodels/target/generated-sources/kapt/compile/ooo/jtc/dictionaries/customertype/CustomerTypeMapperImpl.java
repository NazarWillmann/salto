package ooo.jtc.dictionaries.customertype;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class CustomerTypeMapperImpl implements CustomerTypeMapper {

    @Override
    public CustomerType toDomainModel(CustomerTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        CustomerTypeBuilder customerType = CustomerTypeBuilder.builder();

        customerType.setId( dto.getId() );
        customerType.setVersion( dto.getVersion() );
        customerType.setName( dto.getName() );
        customerType.setSystemName( dto.getSystemName() );

        return customerType.create();
    }

    @Override
    public CustomerTypeDto toDto(CustomerType domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        CustomerTypeDtoBuilder customerTypeDto = CustomerTypeDtoBuilder.builder();

        customerTypeDto.setId( domainModel.getId() );
        customerTypeDto.setVersion( domainModel.getVersion() );
        customerTypeDto.setName( domainModel.getName() );
        customerTypeDto.setSystemName( domainModel.getSystemName() );

        return customerTypeDto.create();
    }
}
