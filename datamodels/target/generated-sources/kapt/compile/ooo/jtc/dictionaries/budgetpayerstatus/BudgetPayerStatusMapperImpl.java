package ooo.jtc.dictionaries.budgetpayerstatus;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BudgetPayerStatusMapperImpl implements BudgetPayerStatusMapper {

    @Override
    public BudgetPayerStatus toDomainModel(BudgetPayerStatusDto dto) {
        if ( dto == null ) {
            return null;
        }

        BudgetPayerStatusBuilder budgetPayerStatus = BudgetPayerStatusBuilder.builder();

        budgetPayerStatus.setId( dto.getId() );
        budgetPayerStatus.setVersion( dto.getVersion() );
        budgetPayerStatus.setCode( dto.getCode() );
        budgetPayerStatus.setDescription( dto.getDescription() );

        return budgetPayerStatus.create();
    }

    @Override
    public BudgetPayerStatusDto toDto(BudgetPayerStatus domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BudgetPayerStatusDtoBuilder budgetPayerStatusDto = BudgetPayerStatusDtoBuilder.builder();

        budgetPayerStatusDto.setId( domainModel.getId() );
        budgetPayerStatusDto.setVersion( domainModel.getVersion() );
        budgetPayerStatusDto.setCode( domainModel.getCode() );
        budgetPayerStatusDto.setDescription( domainModel.getDescription() );

        return budgetPayerStatusDto.create();
    }
}
