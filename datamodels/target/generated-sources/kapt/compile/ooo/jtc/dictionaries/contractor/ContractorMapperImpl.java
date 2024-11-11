package ooo.jtc.dictionaries.contractor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.contractorcontact.ContractorContact;
import ooo.jtc.dictionaries.contractorcontact.ContractorContactBuilder;
import ooo.jtc.dictionaries.contractorcontact.ContractorContactDto;
import ooo.jtc.dictionaries.contractorcontact.ContractorContactDtoBuilder;
import ooo.jtc.dictionaries.contractorpayment.ContractorPayment;
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentBuilder;
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto;
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDtoBuilder;
import ooo.jtc.dictionaries.ground.Ground;
import ooo.jtc.dictionaries.ground.GroundBuilder;
import ooo.jtc.dictionaries.ground.GroundDto;
import ooo.jtc.dictionaries.ground.GroundDtoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class ContractorMapperImpl implements ContractorMapper {

    @Override
    public Contractor toDomainModel(ContractorDto dto) {
        if ( dto == null ) {
            return null;
        }

        ContractorBuilder contractor = ContractorBuilder.builder();

        contractor.setId( dto.getId() );
        contractor.setVersion( dto.getVersion() );
        contractor.setCustomerId( dto.getCustomerId() );
        contractor.setName( dto.getName() );
        contractor.setInn( dto.getInn() );
        contractor.setKpp( dto.getKpp() );
        contractor.setDescription( dto.getDescription() );
        contractor.setPayments( contractorPaymentDtoListToContractorPaymentList( dto.getPayments() ) );
        contractor.setGrounds( groundDtoListToGroundList( dto.getGrounds() ) );
        contractor.setContacts( contractorContactDtoListToContractorContactList( dto.getContacts() ) );

        return contractor.create();
    }

    @Override
    public ContractorDto toDto(Contractor domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        ContractorDtoBuilder contractorDto = ContractorDtoBuilder.builder();

        contractorDto.setId( domainModel.getId() );
        contractorDto.setVersion( domainModel.getVersion() );
        contractorDto.setCustomerId( domainModel.getCustomerId() );
        contractorDto.setName( domainModel.getName() );
        contractorDto.setKpp( domainModel.getKpp() );
        contractorDto.setInn( domainModel.getInn() );
        contractorDto.setDescription( domainModel.getDescription() );
        contractorDto.setPayments( contractorPaymentListToContractorPaymentDtoList( domainModel.getPayments() ) );
        contractorDto.setGrounds( groundListToGroundDtoList( domainModel.getGrounds() ) );
        contractorDto.setContacts( contractorContactListToContractorContactDtoList( domainModel.getContacts() ) );

        return contractorDto.create();
    }

    protected ContractorPayment contractorPaymentDtoToContractorPayment(ContractorPaymentDto contractorPaymentDto) {
        if ( contractorPaymentDto == null ) {
            return null;
        }

        ContractorPaymentBuilder contractorPayment = ContractorPaymentBuilder.builder();

        contractorPayment.setId( contractorPaymentDto.getId() );
        contractorPayment.setVersion( contractorPaymentDto.getVersion() );
        contractorPayment.setContractorId( contractorPaymentDto.getContractorId() );
        contractorPayment.setBankName( contractorPaymentDto.getBankName() );
        contractorPayment.setBankAddress( contractorPaymentDto.getBankAddress() );
        contractorPayment.setCorrAccount( contractorPaymentDto.getCorrAccount() );
        contractorPayment.setIsDefault( contractorPaymentDto.isDefault );
        contractorPayment.setAccount( contractorPaymentDto.getAccount() );
        contractorPayment.setBic( contractorPaymentDto.getBic() );

        return contractorPayment.create();
    }

    protected List<ContractorPayment> contractorPaymentDtoListToContractorPaymentList(List<ContractorPaymentDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ContractorPayment> list1 = new ArrayList<ContractorPayment>( list.size() );
        for ( ContractorPaymentDto contractorPaymentDto : list ) {
            list1.add( contractorPaymentDtoToContractorPayment( contractorPaymentDto ) );
        }

        return list1;
    }

    protected Ground groundDtoToGround(GroundDto groundDto) {
        if ( groundDto == null ) {
            return null;
        }

        GroundBuilder ground = GroundBuilder.builder();

        ground.setId( groundDto.getId() );
        ground.setVersion( groundDto.getVersion() );
        ground.setCustomerId( groundDto.getCustomerId() );
        ground.setContractorId( groundDto.getContractorId() );
        ground.setDescription( groundDto.getDescription() );

        return ground.create();
    }

    protected List<Ground> groundDtoListToGroundList(List<GroundDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Ground> list1 = new ArrayList<Ground>( list.size() );
        for ( GroundDto groundDto : list ) {
            list1.add( groundDtoToGround( groundDto ) );
        }

        return list1;
    }

    protected ContractorContact contractorContactDtoToContractorContact(ContractorContactDto contractorContactDto) {
        if ( contractorContactDto == null ) {
            return null;
        }

        ContractorContactBuilder contractorContact = ContractorContactBuilder.builder();

        contractorContact.setId( contractorContactDto.getId() );
        contractorContact.setVersion( contractorContactDto.getVersion() );
        contractorContact.setContractorId( contractorContactDto.getContractorId() );
        contractorContact.setName( contractorContactDto.getName() );
        contractorContact.setPosition( contractorContactDto.getPosition() );
        contractorContact.setEmail( contractorContactDto.getEmail() );
        contractorContact.setTelephone( contractorContactDto.getTelephone() );
        contractorContact.setComment( contractorContactDto.getComment() );

        return contractorContact.create();
    }

    protected List<ContractorContact> contractorContactDtoListToContractorContactList(List<ContractorContactDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ContractorContact> list1 = new ArrayList<ContractorContact>( list.size() );
        for ( ContractorContactDto contractorContactDto : list ) {
            list1.add( contractorContactDtoToContractorContact( contractorContactDto ) );
        }

        return list1;
    }

    protected ContractorPaymentDto contractorPaymentToContractorPaymentDto(ContractorPayment contractorPayment) {
        if ( contractorPayment == null ) {
            return null;
        }

        ContractorPaymentDtoBuilder contractorPaymentDto = ContractorPaymentDtoBuilder.builder();

        contractorPaymentDto.setId( contractorPayment.getId() );
        contractorPaymentDto.setVersion( contractorPayment.getVersion() );
        contractorPaymentDto.setContractorId( contractorPayment.getContractorId() );
        contractorPaymentDto.setAccount( contractorPayment.getAccount() );
        contractorPaymentDto.setBankName( contractorPayment.getBankName() );
        contractorPaymentDto.setBankAddress( contractorPayment.getBankAddress() );
        contractorPaymentDto.setCorrAccount( contractorPayment.getCorrAccount() );
        contractorPaymentDto.setBic( contractorPayment.getBic() );
        contractorPaymentDto.setIsDefault( contractorPayment.isDefault );

        return contractorPaymentDto.create();
    }

    protected List<ContractorPaymentDto> contractorPaymentListToContractorPaymentDtoList(List<ContractorPayment> list) {
        if ( list == null ) {
            return null;
        }

        List<ContractorPaymentDto> list1 = new ArrayList<ContractorPaymentDto>( list.size() );
        for ( ContractorPayment contractorPayment : list ) {
            list1.add( contractorPaymentToContractorPaymentDto( contractorPayment ) );
        }

        return list1;
    }

    protected GroundDto groundToGroundDto(Ground ground) {
        if ( ground == null ) {
            return null;
        }

        GroundDtoBuilder groundDto = GroundDtoBuilder.builder();

        groundDto.setId( ground.getId() );
        groundDto.setVersion( ground.getVersion() );
        groundDto.setCustomerId( ground.getCustomerId() );
        groundDto.setContractorId( ground.getContractorId() );
        groundDto.setDescription( ground.getDescription() );

        return groundDto.create();
    }

    protected List<GroundDto> groundListToGroundDtoList(List<Ground> list) {
        if ( list == null ) {
            return null;
        }

        List<GroundDto> list1 = new ArrayList<GroundDto>( list.size() );
        for ( Ground ground : list ) {
            list1.add( groundToGroundDto( ground ) );
        }

        return list1;
    }

    protected ContractorContactDto contractorContactToContractorContactDto(ContractorContact contractorContact) {
        if ( contractorContact == null ) {
            return null;
        }

        ContractorContactDtoBuilder contractorContactDto = ContractorContactDtoBuilder.builder();

        contractorContactDto.setId( contractorContact.getId() );
        contractorContactDto.setVersion( contractorContact.getVersion() );
        contractorContactDto.setContractorId( contractorContact.getContractorId() );
        contractorContactDto.setName( contractorContact.getName() );
        contractorContactDto.setPosition( contractorContact.getPosition() );
        contractorContactDto.setEmail( contractorContact.getEmail() );
        contractorContactDto.setTelephone( contractorContact.getTelephone() );
        contractorContactDto.setComment( contractorContact.getComment() );

        return contractorContactDto.create();
    }

    protected List<ContractorContactDto> contractorContactListToContractorContactDtoList(List<ContractorContact> list) {
        if ( list == null ) {
            return null;
        }

        List<ContractorContactDto> list1 = new ArrayList<ContractorContactDto>( list.size() );
        for ( ContractorContact contractorContact : list ) {
            list1.add( contractorContactToContractorContactDto( contractorContact ) );
        }

        return list1;
    }
}
