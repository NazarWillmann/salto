package ooo.jtc.dictionaries.contractorcontact;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class ContractorContactMapperImpl implements ContractorContactMapper {

    @Override
    public ContractorContact toDomainModel(ContractorContactDto dto) {
        if ( dto == null ) {
            return null;
        }

        ContractorContactBuilder contractorContact = ContractorContactBuilder.builder();

        contractorContact.setId( dto.getId() );
        contractorContact.setVersion( dto.getVersion() );
        contractorContact.setContractorId( dto.getContractorId() );
        contractorContact.setName( dto.getName() );
        contractorContact.setPosition( dto.getPosition() );
        contractorContact.setEmail( dto.getEmail() );
        contractorContact.setTelephone( dto.getTelephone() );
        contractorContact.setComment( dto.getComment() );

        return contractorContact.create();
    }

    @Override
    public ContractorContactDto toDto(ContractorContact domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        ContractorContactDtoBuilder contractorContactDto = ContractorContactDtoBuilder.builder();

        contractorContactDto.setId( domainModel.getId() );
        contractorContactDto.setVersion( domainModel.getVersion() );
        contractorContactDto.setContractorId( domainModel.getContractorId() );
        contractorContactDto.setName( domainModel.getName() );
        contractorContactDto.setPosition( domainModel.getPosition() );
        contractorContactDto.setEmail( domainModel.getEmail() );
        contractorContactDto.setTelephone( domainModel.getTelephone() );
        contractorContactDto.setComment( domainModel.getComment() );

        return contractorContactDto.create();
    }
}
