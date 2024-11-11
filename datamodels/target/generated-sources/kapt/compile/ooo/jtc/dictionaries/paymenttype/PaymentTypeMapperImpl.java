package ooo.jtc.dictionaries.paymenttype;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class PaymentTypeMapperImpl implements PaymentTypeMapper {

    @Override
    public PaymentType toDomainModel(PaymentTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        PaymentTypeBuilder paymentType = PaymentTypeBuilder.builder();

        paymentType.setId( dto.getId() );
        paymentType.setVersion( dto.getVersion() );
        paymentType.setCode( dto.getCode() );
        paymentType.setDescription( dto.getDescription() );

        return paymentType.create();
    }

    @Override
    public PaymentTypeDto toDto(PaymentType domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        PaymentTypeDtoBuilder paymentTypeDto = PaymentTypeDtoBuilder.builder();

        paymentTypeDto.setId( domainModel.getId() );
        paymentTypeDto.setVersion( domainModel.getVersion() );
        paymentTypeDto.setCode( domainModel.getCode() );
        paymentTypeDto.setDescription( domainModel.getDescription() );

        return paymentTypeDto.create();
    }
}
