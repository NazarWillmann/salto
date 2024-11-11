package ooo.jtc.dictionaries.agreement;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:42+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class AgreementMapperImpl implements AgreementMapper {

    @Override
    public Agreement toDomainModel(AgreementDto dto) {
        if ( dto == null ) {
            return null;
        }

        AgreementBuilder agreement = AgreementBuilder.builder();

        agreement.setId( dto.getId() );
        agreement.setVersion( dto.getVersion() );
        agreement.setAgreementDate( dto.getAgreementDate() );
        agreement.setAgreementNumber( dto.getAgreementNumber() );
        if ( dto.getAgreementType() != null ) {
            agreement.setAgreementType( Enum.valueOf( AgreementType.class, dto.getAgreementType() ) );
        }
        agreement.setEndDate( dto.getEndDate() );
        agreement.setDescription( dto.getDescription() );
        agreement.setCustomerId( dto.getCustomerId() );
        agreement.setCustomerShortName( dto.getCustomerShortName() );
        agreement.setCustomerFullName( dto.getCustomerFullName() );
        agreement.setStatus( dto.getStatus() );

        return agreement.create();
    }

    @Override
    public AgreementDto toDto(Agreement domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        AgreementDtoBuilder agreementDto = AgreementDtoBuilder.builder();

        agreementDto.setId( domainModel.getId() );
        agreementDto.setVersion( domainModel.getVersion() );
        agreementDto.setAgreementDate( domainModel.getAgreementDate() );
        agreementDto.setAgreementNumber( domainModel.getAgreementNumber() );
        if ( domainModel.getAgreementType() != null ) {
            agreementDto.setAgreementType( domainModel.getAgreementType().name() );
        }
        agreementDto.setEndDate( domainModel.getEndDate() );
        agreementDto.setDescription( domainModel.getDescription() );
        agreementDto.setCustomerId( domainModel.getCustomerId() );
        agreementDto.setCustomerShortName( domainModel.getCustomerShortName() );
        agreementDto.setCustomerFullName( domainModel.getCustomerFullName() );
        agreementDto.setStatus( domainModel.getStatus() );

        return agreementDto.create();
    }
}
