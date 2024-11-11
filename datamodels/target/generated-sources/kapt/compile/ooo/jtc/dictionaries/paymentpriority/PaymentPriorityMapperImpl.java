package ooo.jtc.dictionaries.paymentpriority;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class PaymentPriorityMapperImpl implements PaymentPriorityMapper {

    @Override
    public PaymentPriority toDomainModel(PaymentPriorityDto dto) {
        if ( dto == null ) {
            return null;
        }

        PaymentPriorityBuilder paymentPriority = PaymentPriorityBuilder.builder();

        paymentPriority.setId( dto.getId() );
        paymentPriority.setVersion( dto.getVersion() );
        paymentPriority.setCode( dto.getCode() );
        paymentPriority.setDescription( dto.getDescription() );

        return paymentPriority.create();
    }

    @Override
    public PaymentPriorityDto toDto(PaymentPriority domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        PaymentPriorityDtoBuilder paymentPriorityDto = PaymentPriorityDtoBuilder.builder();

        paymentPriorityDto.setId( domainModel.getId() );
        paymentPriorityDto.setVersion( domainModel.getVersion() );
        paymentPriorityDto.setCode( domainModel.getCode() );
        paymentPriorityDto.setDescription( domainModel.getDescription() );

        return paymentPriorityDto.create();
    }
}
