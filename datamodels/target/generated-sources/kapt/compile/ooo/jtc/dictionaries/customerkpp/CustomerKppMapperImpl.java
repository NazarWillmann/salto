package ooo.jtc.dictionaries.customerkpp;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class CustomerKppMapperImpl implements CustomerKppMapper {

    @Override
    public CustomerKpp toDomainModel(CustomerKppDto dto) {
        if ( dto == null ) {
            return null;
        }

        CustomerKppBuilder customerKpp = CustomerKppBuilder.builder();

        customerKpp.setId( dto.getId() );
        customerKpp.setVersion( dto.getVersion() );
        customerKpp.setUnitName( dto.getUnitName() );
        customerKpp.setKpp( dto.getKpp() );
        customerKpp.setIsDefault( dto.isDefault );

        return customerKpp.create();
    }

    @Override
    public CustomerKppDto toDto(CustomerKpp domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        CustomerKppDtoBuilder customerKppDto = CustomerKppDtoBuilder.builder();

        customerKppDto.setId( domainModel.getId() );
        customerKppDto.setVersion( domainModel.getVersion() );
        customerKppDto.setUnitName( domainModel.getUnitName() );
        customerKppDto.setKpp( domainModel.getKpp() );
        customerKppDto.setIsDefault( domainModel.isDefault );

        return customerKppDto.create();
    }
}
