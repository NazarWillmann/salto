package ooo.jtc.dictionaries.salarypaymenttype;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class SalaryPaymentTypeMapperImpl implements SalaryPaymentTypeMapper {

    @Override
    public SalaryPaymentType toDomainModel(SalaryPaymentTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        SalaryPaymentTypeBuilder salaryPaymentType = SalaryPaymentTypeBuilder.builder();

        salaryPaymentType.setId( dto.getId() );
        salaryPaymentType.setVersion( dto.getVersion() );
        salaryPaymentType.setCode( dto.getCode() );
        salaryPaymentType.setName( dto.getName() );
        salaryPaymentType.setIncomeTypeCode( dto.getIncomeTypeCode() );

        return salaryPaymentType.create();
    }

    @Override
    public SalaryPaymentTypeDto toDto(SalaryPaymentType domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        SalaryPaymentTypeDtoBuilder salaryPaymentTypeDto = SalaryPaymentTypeDtoBuilder.builder();

        salaryPaymentTypeDto.setId( domainModel.getId() );
        salaryPaymentTypeDto.setVersion( domainModel.getVersion() );
        salaryPaymentTypeDto.setCode( domainModel.getCode() );
        salaryPaymentTypeDto.setName( domainModel.getName() );
        salaryPaymentTypeDto.setIncomeTypeCode( domainModel.getIncomeTypeCode() );

        return salaryPaymentTypeDto.create();
    }
}
