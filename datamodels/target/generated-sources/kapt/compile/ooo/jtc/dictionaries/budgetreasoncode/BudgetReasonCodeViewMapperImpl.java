package ooo.jtc.dictionaries.budgetreasoncode;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BudgetReasonCodeViewMapperImpl implements BudgetReasonCodeViewMapper {

    @Override
    public BudgetReasonCodeView toView(BudgetReasonCodeDto dto) {
        if ( dto == null ) {
            return null;
        }

        BudgetReasonCodeView budgetReasonCodeView = new BudgetReasonCodeView();

        budgetReasonCodeView.setCode( dto.getCode() );
        budgetReasonCodeView.setDescription( dto.getDescription() );
        if ( dto.getPayType() != null ) {
            budgetReasonCodeView.setPayType( dto.getPayType().name() );
        }

        return budgetReasonCodeView;
    }

    @Override
    public BudgetReasonCodeDto toDto(BudgetReasonCodeView view) {
        if ( view == null ) {
            return null;
        }

        BudgetReasonCodeDtoBuilder budgetReasonCodeDto = BudgetReasonCodeDtoBuilder.builder();

        budgetReasonCodeDto.setCode( view.getCode() );
        budgetReasonCodeDto.setDescription( view.getDescription() );
        if ( view.getPayType() != null ) {
            budgetReasonCodeDto.setPayType( Enum.valueOf( PayType.class, view.getPayType() ) );
        }

        return budgetReasonCodeDto.create();
    }
}
