package ooo.jtc.dictionaries.paymentpriority;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class PaymentPriorityViewMapperImpl implements PaymentPriorityViewMapper {

    @Override
    public PaymentPriorityView toView(PaymentPriorityDto dto) {
        if ( dto == null ) {
            return null;
        }

        PaymentPriorityView paymentPriorityView = new PaymentPriorityView();

        paymentPriorityView.setCode( dto.getCode() );
        paymentPriorityView.setDescription( dto.getDescription() );

        return paymentPriorityView;
    }

    @Override
    public PaymentPriorityDto toDto(PaymentPriorityView view) {
        if ( view == null ) {
            return null;
        }

        PaymentPriorityDtoBuilder paymentPriorityDto = PaymentPriorityDtoBuilder.builder();

        paymentPriorityDto.setCode( view.getCode() );
        paymentPriorityDto.setDescription( view.getDescription() );

        return paymentPriorityDto.create();
    }
}
