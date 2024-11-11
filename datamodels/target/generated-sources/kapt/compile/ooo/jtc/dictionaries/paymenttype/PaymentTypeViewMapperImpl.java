package ooo.jtc.dictionaries.paymenttype;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class PaymentTypeViewMapperImpl implements PaymentTypeViewMapper {

    @Override
    public PaymentTypeView toView(PaymentTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        PaymentTypeView paymentTypeView = new PaymentTypeView();

        paymentTypeView.setCode( dto.getCode() );
        paymentTypeView.setDescription( dto.getDescription() );

        return paymentTypeView;
    }

    @Override
    public PaymentTypeDto toDto(PaymentTypeView view) {
        if ( view == null ) {
            return null;
        }

        PaymentTypeDtoBuilder paymentTypeDto = PaymentTypeDtoBuilder.builder();

        paymentTypeDto.setCode( view.getCode() );
        paymentTypeDto.setDescription( view.getDescription() );

        return paymentTypeDto.create();
    }
}
