package ooo.jtc.dictionaries.budgetreasoncode;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BudgetReasonCodeMapperImpl implements BudgetReasonCodeMapper {

    @Override
    public BudgetReasonCode toDomainModel(BudgetReasonCodeDto dto) {
        if ( dto == null ) {
            return null;
        }

        BudgetReasonCodeBuilder budgetReasonCode = BudgetReasonCodeBuilder.builder();

        budgetReasonCode.setId( dto.getId() );
        budgetReasonCode.setVersion( dto.getVersion() );
        budgetReasonCode.setCode( dto.getCode() );
        budgetReasonCode.setDescription( dto.getDescription() );
        budgetReasonCode.setPayType( dto.getPayType() );
        budgetReasonCode.setHint108( dto.getHint108() );
        budgetReasonCode.setHint109( dto.getHint109() );

        return budgetReasonCode.create();
    }

    @Override
    public BudgetReasonCodeDto toDto(BudgetReasonCode domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BudgetReasonCodeDtoBuilder budgetReasonCodeDto = BudgetReasonCodeDtoBuilder.builder();

        budgetReasonCodeDto.setId( domainModel.getId() );
        budgetReasonCodeDto.setVersion( domainModel.getVersion() );
        budgetReasonCodeDto.setCode( domainModel.getCode() );
        budgetReasonCodeDto.setDescription( domainModel.getDescription() );
        budgetReasonCodeDto.setPayType( domainModel.getPayType() );
        budgetReasonCodeDto.setHint108( domainModel.getHint108() );
        budgetReasonCodeDto.setHint109( domainModel.getHint109() );

        return budgetReasonCodeDto.create();
    }
}
