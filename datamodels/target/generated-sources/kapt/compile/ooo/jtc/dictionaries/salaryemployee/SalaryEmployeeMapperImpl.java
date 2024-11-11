package ooo.jtc.dictionaries.salaryemployee;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.common.address.RuAddress;
import ooo.jtc.dictionaries.common.address.RuAddressBuilder;
import ooo.jtc.dictionaries.common.address.RuAddressDto;
import ooo.jtc.dictionaries.common.address.RuAddressDtoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class SalaryEmployeeMapperImpl implements SalaryEmployeeMapper {

    @Override
    public SalaryEmployee toDomainModel(SalaryEmployeeDto dto) {
        if ( dto == null ) {
            return null;
        }

        SalaryEmployeeBuilder salaryEmployee = SalaryEmployeeBuilder.builder();

        salaryEmployee.setId( dto.getId() );
        salaryEmployee.setVersion( dto.getVersion() );
        salaryEmployee.setLastName( dto.getLastName() );
        salaryEmployee.setFirstName( dto.getFirstName() );
        salaryEmployee.setMiddleName( dto.getMiddleName() );
        salaryEmployee.setFio( dto.getFio() );
        salaryEmployee.setSex( dto.getSex() );
        salaryEmployee.setBirthday( dto.getBirthday() );
        salaryEmployee.setNationalityCode( dto.getNationalityCode() );
        salaryEmployee.setInn( dto.getInn() );
        salaryEmployee.setSnils( dto.getSnils() );
        salaryEmployee.setPersonnelNumber( dto.getPersonnelNumber() );
        salaryEmployee.setPosition( dto.getPosition() );
        salaryEmployee.setStatus( dto.getStatus() );
        salaryEmployee.setCustomerId( dto.getCustomerId() );
        salaryEmployee.setCustomerName( dto.getCustomerName() );
        salaryEmployee.setUserId( dto.getUserId() );
        salaryEmployee.setPhone( dto.getPhone() );
        salaryEmployee.setHomePhone( dto.getHomePhone() );
        salaryEmployee.setWorkPhone( dto.getWorkPhone() );
        salaryEmployee.setMobilePhone( dto.getMobilePhone() );
        salaryEmployee.setEmail( dto.getEmail() );
        salaryEmployee.setCreatingDate( dto.getCreatingDate() );
        salaryEmployee.setInclusionDate( dto.getInclusionDate() );
        salaryEmployee.setExcludingDate( dto.getExcludingDate() );
        salaryEmployee.setPaymentDetails( salaryEmployeePaymentDetailsDtoListToSalaryEmployeePaymentDetailsList( dto.getPaymentDetails() ) );
        salaryEmployee.setAddressInfo( ruAddressDtoToRuAddress( dto.getAddressInfo() ) );
        salaryEmployee.setAddressLocation( ruAddressDtoToRuAddress( dto.getAddressLocation() ) );
        salaryEmployee.setAddressRegistration( ruAddressDtoToRuAddress( dto.getAddressRegistration() ) );
        salaryEmployee.setIdentityDocument( salaryEmployeeIdentityDocumentDtoToSalaryEmployeeIdentityDocument( dto.getIdentityDocument() ) );
        salaryEmployee.setResidencyPermitDocument( salaryEmployeeResidencyPermitDocumentDtoToSalaryEmployeeResidencyPermitDocument( dto.getResidencyPermitDocument() ) );

        return salaryEmployee.create();
    }

    @Override
    public SalaryEmployeeDto toDto(SalaryEmployee domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        SalaryEmployeeDtoBuilder salaryEmployeeDto = SalaryEmployeeDtoBuilder.builder();

        salaryEmployeeDto.setId( domainModel.getId() );
        salaryEmployeeDto.setVersion( domainModel.getVersion() );
        salaryEmployeeDto.setLastName( domainModel.getLastName() );
        salaryEmployeeDto.setFirstName( domainModel.getFirstName() );
        salaryEmployeeDto.setMiddleName( domainModel.getMiddleName() );
        salaryEmployeeDto.setFio( domainModel.getFio() );
        salaryEmployeeDto.setSex( domainModel.getSex() );
        salaryEmployeeDto.setBirthday( domainModel.getBirthday() );
        salaryEmployeeDto.setNationalityCode( domainModel.getNationalityCode() );
        salaryEmployeeDto.setInn( domainModel.getInn() );
        salaryEmployeeDto.setSnils( domainModel.getSnils() );
        salaryEmployeeDto.setPersonnelNumber( domainModel.getPersonnelNumber() );
        salaryEmployeeDto.setPosition( domainModel.getPosition() );
        salaryEmployeeDto.setStatus( domainModel.getStatus() );
        salaryEmployeeDto.setCustomerId( domainModel.getCustomerId() );
        salaryEmployeeDto.setCustomerName( domainModel.getCustomerName() );
        salaryEmployeeDto.setUserId( domainModel.getUserId() );
        salaryEmployeeDto.setPhone( domainModel.getPhone() );
        salaryEmployeeDto.setMobilePhone( domainModel.getMobilePhone() );
        salaryEmployeeDto.setWorkPhone( domainModel.getWorkPhone() );
        salaryEmployeeDto.setHomePhone( domainModel.getHomePhone() );
        salaryEmployeeDto.setEmail( domainModel.getEmail() );
        salaryEmployeeDto.setCreatingDate( domainModel.getCreatingDate() );
        salaryEmployeeDto.setInclusionDate( domainModel.getInclusionDate() );
        salaryEmployeeDto.setExcludingDate( domainModel.getExcludingDate() );
        salaryEmployeeDto.setIdentityDocument( salaryEmployeeIdentityDocumentToSalaryEmployeeIdentityDocumentDto( domainModel.getIdentityDocument() ) );
        salaryEmployeeDto.setResidencyPermitDocument( salaryEmployeeResidencyPermitDocumentToSalaryEmployeeResidencyPermitDocumentDto( domainModel.getResidencyPermitDocument() ) );
        salaryEmployeeDto.setPaymentDetails( salaryEmployeePaymentDetailsListToSalaryEmployeePaymentDetailsDtoList( domainModel.getPaymentDetails() ) );
        salaryEmployeeDto.setAddressRegistration( ruAddressToRuAddressDto( domainModel.getAddressRegistration() ) );
        salaryEmployeeDto.setAddressLocation( ruAddressToRuAddressDto( domainModel.getAddressLocation() ) );
        salaryEmployeeDto.setAddressInfo( ruAddressToRuAddressDto( domainModel.getAddressInfo() ) );

        return salaryEmployeeDto.create();
    }

    protected SalaryEmployeePaymentDetails salaryEmployeePaymentDetailsDtoToSalaryEmployeePaymentDetails(SalaryEmployeePaymentDetailsDto salaryEmployeePaymentDetailsDto) {
        if ( salaryEmployeePaymentDetailsDto == null ) {
            return null;
        }

        SalaryEmployeePaymentDetailsBuilder salaryEmployeePaymentDetails = SalaryEmployeePaymentDetailsBuilder.builder();

        salaryEmployeePaymentDetails.setId( salaryEmployeePaymentDetailsDto.getId() );
        salaryEmployeePaymentDetails.setVersion( salaryEmployeePaymentDetailsDto.getVersion() );
        salaryEmployeePaymentDetails.setEmployeeId( salaryEmployeePaymentDetailsDto.getEmployeeId() );
        salaryEmployeePaymentDetails.setAccount( salaryEmployeePaymentDetailsDto.getAccount() );
        salaryEmployeePaymentDetails.setBic( salaryEmployeePaymentDetailsDto.getBic() );
        salaryEmployeePaymentDetails.setCorrAccount( salaryEmployeePaymentDetailsDto.getCorrAccount() );
        salaryEmployeePaymentDetails.setBankName( salaryEmployeePaymentDetailsDto.getBankName() );
        salaryEmployeePaymentDetails.setBankPlace( salaryEmployeePaymentDetailsDto.getBankPlace() );

        return salaryEmployeePaymentDetails.create();
    }

    protected List<SalaryEmployeePaymentDetails> salaryEmployeePaymentDetailsDtoListToSalaryEmployeePaymentDetailsList(List<SalaryEmployeePaymentDetailsDto> list) {
        if ( list == null ) {
            return null;
        }

        List<SalaryEmployeePaymentDetails> list1 = new ArrayList<SalaryEmployeePaymentDetails>( list.size() );
        for ( SalaryEmployeePaymentDetailsDto salaryEmployeePaymentDetailsDto : list ) {
            list1.add( salaryEmployeePaymentDetailsDtoToSalaryEmployeePaymentDetails( salaryEmployeePaymentDetailsDto ) );
        }

        return list1;
    }

    protected RuAddress ruAddressDtoToRuAddress(RuAddressDto ruAddressDto) {
        if ( ruAddressDto == null ) {
            return null;
        }

        RuAddressBuilder ruAddress = RuAddressBuilder.builder();

        ruAddress.setCountryDigitCode( ruAddressDto.getCountryDigitCode() );
        ruAddress.setIndex( ruAddressDto.getIndex() );
        ruAddress.setRegionCode( ruAddressDto.getRegionCode() );
        ruAddress.setDistrict( ruAddressDto.getDistrict() );
        ruAddress.setCity( ruAddressDto.getCity() );
        ruAddress.setInhabitedLocality( ruAddressDto.getInhabitedLocality() );
        ruAddress.setStreet( ruAddressDto.getStreet() );
        ruAddress.setHouseNumber( ruAddressDto.getHouseNumber() );
        ruAddress.setHousingNumber( ruAddressDto.getHousingNumber() );
        ruAddress.setBuildingNumber( ruAddressDto.getBuildingNumber() );
        ruAddress.setApartmentNumber( ruAddressDto.getApartmentNumber() );
        ruAddress.setRoomNumber( ruAddressDto.getRoomNumber() );
        ruAddress.setFullAddress( ruAddressDto.getFullAddress() );

        return ruAddress.create();
    }

    protected SalaryEmployeeIdentityDocument salaryEmployeeIdentityDocumentDtoToSalaryEmployeeIdentityDocument(SalaryEmployeeIdentityDocumentDto salaryEmployeeIdentityDocumentDto) {
        if ( salaryEmployeeIdentityDocumentDto == null ) {
            return null;
        }

        SalaryEmployeeIdentityDocumentBuilder salaryEmployeeIdentityDocument = SalaryEmployeeIdentityDocumentBuilder.builder();

        salaryEmployeeIdentityDocument.setDocTypeCode( salaryEmployeeIdentityDocumentDto.getDocTypeCode() );
        salaryEmployeeIdentityDocument.setDocType( salaryEmployeeIdentityDocumentDto.getDocType() );
        salaryEmployeeIdentityDocument.setDocTypeName( salaryEmployeeIdentityDocumentDto.getDocTypeName() );
        salaryEmployeeIdentityDocument.setSeries( salaryEmployeeIdentityDocumentDto.getSeries() );
        salaryEmployeeIdentityDocument.setNumber( salaryEmployeeIdentityDocumentDto.getNumber() );
        salaryEmployeeIdentityDocument.setIssuingAuthority( salaryEmployeeIdentityDocumentDto.getIssuingAuthority() );
        salaryEmployeeIdentityDocument.setIssuingDate( salaryEmployeeIdentityDocumentDto.getIssuingDate() );
        salaryEmployeeIdentityDocument.setDepartmentCode( salaryEmployeeIdentityDocumentDto.getDepartmentCode() );
        salaryEmployeeIdentityDocument.setCountryDigitCode( salaryEmployeeIdentityDocumentDto.getCountryDigitCode() );
        salaryEmployeeIdentityDocument.setEndDate( salaryEmployeeIdentityDocumentDto.getEndDate() );

        return salaryEmployeeIdentityDocument.create();
    }

    protected SalaryEmployeeResidencyPermitDocument salaryEmployeeResidencyPermitDocumentDtoToSalaryEmployeeResidencyPermitDocument(SalaryEmployeeResidencyPermitDocumentDto salaryEmployeeResidencyPermitDocumentDto) {
        if ( salaryEmployeeResidencyPermitDocumentDto == null ) {
            return null;
        }

        SalaryEmployeeResidencyPermitDocumentBuilder salaryEmployeeResidencyPermitDocument = SalaryEmployeeResidencyPermitDocumentBuilder.builder();

        salaryEmployeeResidencyPermitDocument.setDocType( salaryEmployeeResidencyPermitDocumentDto.getDocType() );
        salaryEmployeeResidencyPermitDocument.setDocTypeName( salaryEmployeeResidencyPermitDocumentDto.getDocTypeName() );
        salaryEmployeeResidencyPermitDocument.setSeries( salaryEmployeeResidencyPermitDocumentDto.getSeries() );
        salaryEmployeeResidencyPermitDocument.setNumber( salaryEmployeeResidencyPermitDocumentDto.getNumber() );
        salaryEmployeeResidencyPermitDocument.setIssuingDate( salaryEmployeeResidencyPermitDocumentDto.getIssuingDate() );
        salaryEmployeeResidencyPermitDocument.setIssuingAuthority( salaryEmployeeResidencyPermitDocumentDto.getIssuingAuthority() );
        salaryEmployeeResidencyPermitDocument.setDepartmentCode( salaryEmployeeResidencyPermitDocumentDto.getDepartmentCode() );
        salaryEmployeeResidencyPermitDocument.setBeginDate( salaryEmployeeResidencyPermitDocumentDto.getBeginDate() );
        salaryEmployeeResidencyPermitDocument.setEndDate( salaryEmployeeResidencyPermitDocumentDto.getEndDate() );

        return salaryEmployeeResidencyPermitDocument.create();
    }

    protected SalaryEmployeeIdentityDocumentDto salaryEmployeeIdentityDocumentToSalaryEmployeeIdentityDocumentDto(SalaryEmployeeIdentityDocument salaryEmployeeIdentityDocument) {
        if ( salaryEmployeeIdentityDocument == null ) {
            return null;
        }

        SalaryEmployeeIdentityDocumentDtoBuilder salaryEmployeeIdentityDocumentDto = SalaryEmployeeIdentityDocumentDtoBuilder.builder();

        salaryEmployeeIdentityDocumentDto.setDocTypeCode( salaryEmployeeIdentityDocument.getDocTypeCode() );
        salaryEmployeeIdentityDocumentDto.setDocType( salaryEmployeeIdentityDocument.getDocType() );
        salaryEmployeeIdentityDocumentDto.setDocTypeName( salaryEmployeeIdentityDocument.getDocTypeName() );
        salaryEmployeeIdentityDocumentDto.setSeries( salaryEmployeeIdentityDocument.getSeries() );
        salaryEmployeeIdentityDocumentDto.setNumber( salaryEmployeeIdentityDocument.getNumber() );
        salaryEmployeeIdentityDocumentDto.setIssuingAuthority( salaryEmployeeIdentityDocument.getIssuingAuthority() );
        salaryEmployeeIdentityDocumentDto.setIssuingDate( salaryEmployeeIdentityDocument.getIssuingDate() );
        salaryEmployeeIdentityDocumentDto.setDepartmentCode( salaryEmployeeIdentityDocument.getDepartmentCode() );
        salaryEmployeeIdentityDocumentDto.setCountryDigitCode( salaryEmployeeIdentityDocument.getCountryDigitCode() );
        salaryEmployeeIdentityDocumentDto.setEndDate( salaryEmployeeIdentityDocument.getEndDate() );

        return salaryEmployeeIdentityDocumentDto.create();
    }

    protected SalaryEmployeeResidencyPermitDocumentDto salaryEmployeeResidencyPermitDocumentToSalaryEmployeeResidencyPermitDocumentDto(SalaryEmployeeResidencyPermitDocument salaryEmployeeResidencyPermitDocument) {
        if ( salaryEmployeeResidencyPermitDocument == null ) {
            return null;
        }

        SalaryEmployeeResidencyPermitDocumentDtoBuilder salaryEmployeeResidencyPermitDocumentDto = SalaryEmployeeResidencyPermitDocumentDtoBuilder.builder();

        salaryEmployeeResidencyPermitDocumentDto.setDocType( salaryEmployeeResidencyPermitDocument.getDocType() );
        salaryEmployeeResidencyPermitDocumentDto.setDocTypeName( salaryEmployeeResidencyPermitDocument.getDocTypeName() );
        salaryEmployeeResidencyPermitDocumentDto.setSeries( salaryEmployeeResidencyPermitDocument.getSeries() );
        salaryEmployeeResidencyPermitDocumentDto.setNumber( salaryEmployeeResidencyPermitDocument.getNumber() );
        salaryEmployeeResidencyPermitDocumentDto.setIssuingDate( salaryEmployeeResidencyPermitDocument.getIssuingDate() );
        salaryEmployeeResidencyPermitDocumentDto.setIssuingAuthority( salaryEmployeeResidencyPermitDocument.getIssuingAuthority() );
        salaryEmployeeResidencyPermitDocumentDto.setDepartmentCode( salaryEmployeeResidencyPermitDocument.getDepartmentCode() );
        salaryEmployeeResidencyPermitDocumentDto.setBeginDate( salaryEmployeeResidencyPermitDocument.getBeginDate() );
        salaryEmployeeResidencyPermitDocumentDto.setEndDate( salaryEmployeeResidencyPermitDocument.getEndDate() );

        return salaryEmployeeResidencyPermitDocumentDto.create();
    }

    protected SalaryEmployeePaymentDetailsDto salaryEmployeePaymentDetailsToSalaryEmployeePaymentDetailsDto(SalaryEmployeePaymentDetails salaryEmployeePaymentDetails) {
        if ( salaryEmployeePaymentDetails == null ) {
            return null;
        }

        SalaryEmployeePaymentDetailsDtoBuilder salaryEmployeePaymentDetailsDto = SalaryEmployeePaymentDetailsDtoBuilder.builder();

        salaryEmployeePaymentDetailsDto.setId( salaryEmployeePaymentDetails.getId() );
        salaryEmployeePaymentDetailsDto.setVersion( salaryEmployeePaymentDetails.getVersion() );
        salaryEmployeePaymentDetailsDto.setEmployeeId( salaryEmployeePaymentDetails.getEmployeeId() );
        salaryEmployeePaymentDetailsDto.setAccount( salaryEmployeePaymentDetails.getAccount() );
        salaryEmployeePaymentDetailsDto.setBic( salaryEmployeePaymentDetails.getBic() );
        salaryEmployeePaymentDetailsDto.setCorrAccount( salaryEmployeePaymentDetails.getCorrAccount() );
        salaryEmployeePaymentDetailsDto.setBankName( salaryEmployeePaymentDetails.getBankName() );
        salaryEmployeePaymentDetailsDto.setBankPlace( salaryEmployeePaymentDetails.getBankPlace() );

        return salaryEmployeePaymentDetailsDto.create();
    }

    protected List<SalaryEmployeePaymentDetailsDto> salaryEmployeePaymentDetailsListToSalaryEmployeePaymentDetailsDtoList(List<SalaryEmployeePaymentDetails> list) {
        if ( list == null ) {
            return null;
        }

        List<SalaryEmployeePaymentDetailsDto> list1 = new ArrayList<SalaryEmployeePaymentDetailsDto>( list.size() );
        for ( SalaryEmployeePaymentDetails salaryEmployeePaymentDetails : list ) {
            list1.add( salaryEmployeePaymentDetailsToSalaryEmployeePaymentDetailsDto( salaryEmployeePaymentDetails ) );
        }

        return list1;
    }

    protected RuAddressDto ruAddressToRuAddressDto(RuAddress ruAddress) {
        if ( ruAddress == null ) {
            return null;
        }

        RuAddressDtoBuilder ruAddressDto = RuAddressDtoBuilder.builder();

        ruAddressDto.setCountryDigitCode( ruAddress.getCountryDigitCode() );
        ruAddressDto.setIndex( ruAddress.getIndex() );
        ruAddressDto.setRegionCode( ruAddress.getRegionCode() );
        ruAddressDto.setDistrict( ruAddress.getDistrict() );
        ruAddressDto.setCity( ruAddress.getCity() );
        ruAddressDto.setInhabitedLocality( ruAddress.getInhabitedLocality() );
        ruAddressDto.setStreet( ruAddress.getStreet() );
        ruAddressDto.setHouseNumber( ruAddress.getHouseNumber() );
        ruAddressDto.setHousingNumber( ruAddress.getHousingNumber() );
        ruAddressDto.setBuildingNumber( ruAddress.getBuildingNumber() );
        ruAddressDto.setApartmentNumber( ruAddress.getApartmentNumber() );
        ruAddressDto.setRoomNumber( ruAddress.getRoomNumber() );
        ruAddressDto.setFullAddress( ruAddress.getFullAddress() );

        return ruAddressDto.create();
    }
}
