package ooo.jtc.dictionaries.stmntoperationtype;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class StatementOperationTypeViewMapperImpl implements StatementOperationTypeViewMapper {

    @Override
    public StatementOperationTypeView toView(StatementOperationTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        StatementOperationTypeView statementOperationTypeView = new StatementOperationTypeView();

        statementOperationTypeView.setCode( dto.getCode() );
        statementOperationTypeView.setDescription( dto.getDescription() );

        return statementOperationTypeView;
    }

    @Override
    public StatementOperationTypeDto toDto(StatementOperationTypeView view) {
        if ( view == null ) {
            return null;
        }

        StatementOperationTypeDtoBuilder statementOperationTypeDto = StatementOperationTypeDtoBuilder.builder();

        statementOperationTypeDto.setCode( view.getCode() );
        statementOperationTypeDto.setDescription( view.getDescription() );

        return statementOperationTypeDto.create();
    }
}
