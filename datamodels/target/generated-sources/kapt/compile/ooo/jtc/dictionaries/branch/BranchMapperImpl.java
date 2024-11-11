package ooo.jtc.dictionaries.branch;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsBic;
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsBicBuilder;
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsBicDto;
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsBicDtoBuilder;
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsSwift;
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsSwiftBuilder;
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsSwiftDto;
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsSwiftDtoBuilder;
import ooo.jtc.dictionaries.common.address.RuAddress;
import ooo.jtc.dictionaries.common.address.RuAddressBuilder;
import ooo.jtc.dictionaries.common.address.RuAddressDto;
import ooo.jtc.dictionaries.common.address.RuAddressDtoBuilder;
import ooo.jtc.dictionaries.common.extid.ExtId;
import ooo.jtc.dictionaries.common.extid.ExtIdBuilder;
import ooo.jtc.dictionaries.common.extid.ExtIdDto;
import ooo.jtc.dictionaries.common.extid.ExtIdDtoBuilder;
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfo;
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfoBuilder;
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfoDto;
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfoDtoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BranchMapperImpl implements BranchMapper {

    @Override
    public Branch toDomainModel(BranchDto dto) {
        if ( dto == null ) {
            return null;
        }

        BranchBuilder branch = BranchBuilder.builder();

        branch.setId( dto.getId() );
        branch.setVersion( dto.getVersion() );
        branch.setBranchType( dto.getBranchType() );
        branch.setKpp( dto.getKpp() );
        branch.setShortName( dto.getShortName() );
        branch.setFullName( dto.getFullName() );
        branch.setUiName( dto.getUiName() );
        branch.setBankId( dto.getBankId() );
        branch.setEmail( dto.getEmail() );
        branch.setDescription( dto.getDescription() );
        branch.setParentBranchId( dto.getParentBranchId() );
        branch.setPaymentDetailsBic( paymentDetailsBicDtoToPaymentDetailsBic( dto.getPaymentDetailsBic() ) );
        branch.setPaymentDetailsSwift( paymentDetailsSwiftDtoToPaymentDetailsSwift( dto.getPaymentDetailsSwift() ) );
        branch.setAddressLocation( ruAddressDtoToRuAddress( dto.getAddressLocation() ) );
        branch.setAddressRegistration( ruAddressDtoToRuAddress( dto.getAddressRegistration() ) );
        branch.setExtIds( extIdDtoListToExtIdList( dto.getExtIds() ) );
        branch.setPhoneSupports( phoneInfoDtoListToPhoneInfoList( dto.getPhoneSupports() ) );

        return branch.create();
    }

    @Override
    public BranchDto toDto(Branch domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BranchDtoBuilder branchDto = BranchDtoBuilder.builder();

        branchDto.setId( domainModel.getId() );
        branchDto.setVersion( domainModel.getVersion() );
        branchDto.setBranchType( domainModel.getBranchType() );
        branchDto.setKpp( domainModel.getKpp() );
        branchDto.setShortName( domainModel.getShortName() );
        branchDto.setFullName( domainModel.getFullName() );
        branchDto.setUiName( domainModel.getUiName() );
        branchDto.setPaymentDetailsBic( paymentDetailsBicToPaymentDetailsBicDto( domainModel.getPaymentDetailsBic() ) );
        branchDto.setPaymentDetailsSwift( paymentDetailsSwiftToPaymentDetailsSwiftDto( domainModel.getPaymentDetailsSwift() ) );
        branchDto.setBankId( domainModel.getBankId() );
        branchDto.setPhoneSupports( phoneInfoListToPhoneInfoDtoList( domainModel.getPhoneSupports() ) );
        branchDto.setEmail( domainModel.getEmail() );
        branchDto.setDescription( domainModel.getDescription() );
        branchDto.setAddressRegistration( ruAddressToRuAddressDto( domainModel.getAddressRegistration() ) );
        branchDto.setAddressLocation( ruAddressToRuAddressDto( domainModel.getAddressLocation() ) );
        branchDto.setExtIds( extIdListToExtIdDtoList( domainModel.getExtIds() ) );
        branchDto.setParentBranchId( domainModel.getParentBranchId() );

        return branchDto.create();
    }

    protected PaymentDetailsBic paymentDetailsBicDtoToPaymentDetailsBic(PaymentDetailsBicDto paymentDetailsBicDto) {
        if ( paymentDetailsBicDto == null ) {
            return null;
        }

        PaymentDetailsBicBuilder paymentDetailsBic = PaymentDetailsBicBuilder.builder();

        paymentDetailsBic.setBic( paymentDetailsBicDto.getBic() );
        paymentDetailsBic.setCorrAccount( paymentDetailsBicDto.getCorrAccount() );
        paymentDetailsBic.setBankName( paymentDetailsBicDto.getBankName() );
        paymentDetailsBic.setBankPlace( paymentDetailsBicDto.getBankPlace() );

        return paymentDetailsBic.create();
    }

    protected PaymentDetailsSwift paymentDetailsSwiftDtoToPaymentDetailsSwift(PaymentDetailsSwiftDto paymentDetailsSwiftDto) {
        if ( paymentDetailsSwiftDto == null ) {
            return null;
        }

        PaymentDetailsSwiftBuilder paymentDetailsSwift = PaymentDetailsSwiftBuilder.builder();

        paymentDetailsSwift.setSwift( paymentDetailsSwiftDto.getSwift() );
        paymentDetailsSwift.setBankName( paymentDetailsSwiftDto.getBankName() );
        paymentDetailsSwift.setCountryDigitCode( paymentDetailsSwiftDto.getCountryDigitCode() );
        paymentDetailsSwift.setBankCity( paymentDetailsSwiftDto.getBankCity() );
        paymentDetailsSwift.setBankAddress( paymentDetailsSwiftDto.getBankAddress() );

        return paymentDetailsSwift.create();
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

    protected ExtId extIdDtoToExtId(ExtIdDto extIdDto) {
        if ( extIdDto == null ) {
            return null;
        }

        ExtIdBuilder extId = ExtIdBuilder.builder();

        extId.setId( extIdDto.getId() );
        extId.setVersion( extIdDto.getVersion() );
        extId.setOwnerId( extIdDto.getOwnerId() );
        extId.setExtSystemId( extIdDto.getExtSystemId() );
        extId.setExternalId( extIdDto.getExternalId() );

        return extId.create();
    }

    protected List<ExtId> extIdDtoListToExtIdList(List<ExtIdDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ExtId> list1 = new ArrayList<ExtId>( list.size() );
        for ( ExtIdDto extIdDto : list ) {
            list1.add( extIdDtoToExtId( extIdDto ) );
        }

        return list1;
    }

    protected PhoneInfo phoneInfoDtoToPhoneInfo(PhoneInfoDto phoneInfoDto) {
        if ( phoneInfoDto == null ) {
            return null;
        }

        PhoneInfoBuilder phoneInfo = PhoneInfoBuilder.builder();

        phoneInfo.setId( phoneInfoDto.getId() );
        phoneInfo.setVersion( phoneInfoDto.getVersion() );
        phoneInfo.setOwnerId( phoneInfoDto.getOwnerId() );
        phoneInfo.setSupportType( phoneInfoDto.getSupportType() );
        phoneInfo.setPhoneType( phoneInfoDto.getPhoneType() );
        phoneInfo.setPhone( phoneInfoDto.getPhone() );

        return phoneInfo.create();
    }

    protected List<PhoneInfo> phoneInfoDtoListToPhoneInfoList(List<PhoneInfoDto> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneInfo> list1 = new ArrayList<PhoneInfo>( list.size() );
        for ( PhoneInfoDto phoneInfoDto : list ) {
            list1.add( phoneInfoDtoToPhoneInfo( phoneInfoDto ) );
        }

        return list1;
    }

    protected PaymentDetailsBicDto paymentDetailsBicToPaymentDetailsBicDto(PaymentDetailsBic paymentDetailsBic) {
        if ( paymentDetailsBic == null ) {
            return null;
        }

        PaymentDetailsBicDtoBuilder paymentDetailsBicDto = PaymentDetailsBicDtoBuilder.builder();

        paymentDetailsBicDto.setBic( paymentDetailsBic.getBic() );
        paymentDetailsBicDto.setCorrAccount( paymentDetailsBic.getCorrAccount() );
        paymentDetailsBicDto.setBankName( paymentDetailsBic.getBankName() );
        paymentDetailsBicDto.setBankPlace( paymentDetailsBic.getBankPlace() );

        return paymentDetailsBicDto.create();
    }

    protected PaymentDetailsSwiftDto paymentDetailsSwiftToPaymentDetailsSwiftDto(PaymentDetailsSwift paymentDetailsSwift) {
        if ( paymentDetailsSwift == null ) {
            return null;
        }

        PaymentDetailsSwiftDtoBuilder paymentDetailsSwiftDto = PaymentDetailsSwiftDtoBuilder.builder();

        paymentDetailsSwiftDto.setSwift( paymentDetailsSwift.getSwift() );
        paymentDetailsSwiftDto.setBankName( paymentDetailsSwift.getBankName() );
        paymentDetailsSwiftDto.setCountryDigitCode( paymentDetailsSwift.getCountryDigitCode() );
        paymentDetailsSwiftDto.setBankCity( paymentDetailsSwift.getBankCity() );
        paymentDetailsSwiftDto.setBankAddress( paymentDetailsSwift.getBankAddress() );

        return paymentDetailsSwiftDto.create();
    }

    protected PhoneInfoDto phoneInfoToPhoneInfoDto(PhoneInfo phoneInfo) {
        if ( phoneInfo == null ) {
            return null;
        }

        PhoneInfoDtoBuilder phoneInfoDto = PhoneInfoDtoBuilder.builder();

        phoneInfoDto.setId( phoneInfo.getId() );
        phoneInfoDto.setVersion( phoneInfo.getVersion() );
        phoneInfoDto.setOwnerId( phoneInfo.getOwnerId() );
        phoneInfoDto.setSupportType( phoneInfo.getSupportType() );
        phoneInfoDto.setPhoneType( phoneInfo.getPhoneType() );
        phoneInfoDto.setPhone( phoneInfo.getPhone() );

        return phoneInfoDto.create();
    }

    protected List<PhoneInfoDto> phoneInfoListToPhoneInfoDtoList(List<PhoneInfo> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneInfoDto> list1 = new ArrayList<PhoneInfoDto>( list.size() );
        for ( PhoneInfo phoneInfo : list ) {
            list1.add( phoneInfoToPhoneInfoDto( phoneInfo ) );
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

    protected ExtIdDto extIdToExtIdDto(ExtId extId) {
        if ( extId == null ) {
            return null;
        }

        ExtIdDtoBuilder extIdDto = ExtIdDtoBuilder.builder();

        extIdDto.setId( extId.getId() );
        extIdDto.setVersion( extId.getVersion() );
        extIdDto.setOwnerId( extId.getOwnerId() );
        extIdDto.setExtSystemId( extId.getExtSystemId() );
        extIdDto.setExternalId( extId.getExternalId() );

        return extIdDto.create();
    }

    protected List<ExtIdDto> extIdListToExtIdDtoList(List<ExtId> list) {
        if ( list == null ) {
            return null;
        }

        List<ExtIdDto> list1 = new ArrayList<ExtIdDto>( list.size() );
        for ( ExtId extId : list ) {
            list1.add( extIdToExtIdDto( extId ) );
        }

        return list1;
    }
}
