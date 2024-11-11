package ooo.jtc.dictionaries.budgetpayerstatus;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BudgetPayerStatusViewMapperImpl implements BudgetPayerStatusViewMapper {

    @Override
    public BudgetPayerStatusView toView(BudgetPayerStatusDto dto) {
        if ( dto == null ) {
            return null;
        }

        BudgetPayerStatusView budgetPayerStatusView = new BudgetPayerStatusView();

        budgetPayerStatusView.setCode( dto.getCode() );
        budgetPayerStatusView.setDescription( dto.getDescription() );

        return budgetPayerStatusView;
    }

    @Override
    public BudgetPayerStatusDto toDto(BudgetPayerStatusView view) {
        if ( view == null ) {
            return null;
        }

        BudgetPayerStatusDtoBuilder budgetPayerStatusDto = BudgetPayerStatusDtoBuilder.builder();

        budgetPayerStatusDto.setCode( view.getCode() );
        budgetPayerStatusDto.setDescription( view.getDescription() );

        return budgetPayerStatusDto.create();
    }
}
