package ooo.jtc.dictionaries.bankinfo;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.bankinfo.applicationurl.BankInfoApplicationUrl;
import ooo.jtc.dictionaries.bankinfo.applicationurl.BankInfoApplicationUrlBuilder;
import ooo.jtc.dictionaries.bankinfo.applicationurl.BankInfoApplicationUrlDto;
import ooo.jtc.dictionaries.bankinfo.applicationurl.BankInfoApplicationUrlDtoBuilder;
import ooo.jtc.dictionaries.bankinfo.socialurl.BankInfoSocialUrl;
import ooo.jtc.dictionaries.bankinfo.socialurl.BankInfoSocialUrlBuilder;
import ooo.jtc.dictionaries.bankinfo.socialurl.BankInfoSocialUrlDto;
import ooo.jtc.dictionaries.bankinfo.socialurl.BankInfoSocialUrlDtoBuilder;
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfo;
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfoBuilder;
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfoDto;
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfoDtoBuilder;
import ooo.jtc.generic.CustomConverter;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BankInfoMapperImpl implements BankInfoMapper {

    private final CustomConverter customConverter = new CustomConverter();

    @Override
    public BankInfoDto toDto(BankInfo domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BankInfoDtoBuilder bankInfoDto = BankInfoDtoBuilder.builder();

        bankInfoDto.setUiSettings( customConverter.stringToMap( domainModel.getUiSettings() ) );
        bankInfoDto.setId( domainModel.getId() );
        bankInfoDto.setVersion( domainModel.getVersion() );
        bankInfoDto.setFullName( domainModel.getFullName() );
        bankInfoDto.setShortName( domainModel.getShortName() );
        bankInfoDto.setPhoneSupports( phoneInfoListToPhoneInfoDtoList( domainModel.getPhoneSupports() ) );
        bankInfoDto.setLicenseType( domainModel.getLicenseType() );
        bankInfoDto.setLicense( domainModel.getLicense() );
        bankInfoDto.setInn( domainModel.getInn() );
        bankInfoDto.setLogoFileId( domainModel.getLogoFileId() );
        bankInfoDto.setWebsite( domainModel.getWebsite() );
        bankInfoDto.setApplicationUrls( bankInfoApplicationUrlListToBankInfoApplicationUrlDtoList( domainModel.getApplicationUrls() ) );
        bankInfoDto.setSocialUrls( bankInfoSocialUrlListToBankInfoSocialUrlDtoList( domainModel.getSocialUrls() ) );
        bankInfoDto.setDescription( domainModel.getDescription() );

        return bankInfoDto.create();
    }

    @Override
    public BankInfo toDomainModel(BankInfoDto dto) {
        if ( dto == null ) {
            return null;
        }

        BankInfoBuilder bankInfo = BankInfoBuilder.builder();

        bankInfo.setUiSettings( customConverter.mapToString( dto.getUiSettings() ) );
        bankInfo.setId( dto.getId() );
        bankInfo.setVersion( dto.getVersion() );
        bankInfo.setFullName( dto.getFullName() );
        bankInfo.setShortName( dto.getShortName() );
        bankInfo.setLicenseType( dto.getLicenseType() );
        bankInfo.setLicense( dto.getLicense() );
        bankInfo.setInn( dto.getInn() );
        bankInfo.setLogoFileId( dto.getLogoFileId() );
        bankInfo.setWebsite( dto.getWebsite() );
        bankInfo.setDescription( dto.getDescription() );
        bankInfo.setPhoneSupports( phoneInfoDtoListToPhoneInfoList( dto.getPhoneSupports() ) );
        bankInfo.setSocialUrls( bankInfoSocialUrlDtoListToBankInfoSocialUrlList( dto.getSocialUrls() ) );
        bankInfo.setApplicationUrls( bankInfoApplicationUrlDtoListToBankInfoApplicationUrlList( dto.getApplicationUrls() ) );

        return bankInfo.create();
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

    protected BankInfoApplicationUrlDto bankInfoApplicationUrlToBankInfoApplicationUrlDto(BankInfoApplicationUrl bankInfoApplicationUrl) {
        if ( bankInfoApplicationUrl == null ) {
            return null;
        }

        BankInfoApplicationUrlDtoBuilder bankInfoApplicationUrlDto = BankInfoApplicationUrlDtoBuilder.builder();

        bankInfoApplicationUrlDto.setId( bankInfoApplicationUrl.getId() );
        bankInfoApplicationUrlDto.setVersion( bankInfoApplicationUrl.getVersion() );
        bankInfoApplicationUrlDto.setBankId( bankInfoApplicationUrl.getBankId() );
        bankInfoApplicationUrlDto.setName( bankInfoApplicationUrl.getName() );
        bankInfoApplicationUrlDto.setAppType( bankInfoApplicationUrl.getAppType() );
        bankInfoApplicationUrlDto.setStoreType( bankInfoApplicationUrl.getStoreType() );
        bankInfoApplicationUrlDto.setDownloadUrl( bankInfoApplicationUrl.getDownloadUrl() );
        bankInfoApplicationUrlDto.setOrdering( bankInfoApplicationUrl.getOrdering() );

        return bankInfoApplicationUrlDto.create();
    }

    protected List<BankInfoApplicationUrlDto> bankInfoApplicationUrlListToBankInfoApplicationUrlDtoList(List<BankInfoApplicationUrl> list) {
        if ( list == null ) {
            return null;
        }

        List<BankInfoApplicationUrlDto> list1 = new ArrayList<BankInfoApplicationUrlDto>( list.size() );
        for ( BankInfoApplicationUrl bankInfoApplicationUrl : list ) {
            list1.add( bankInfoApplicationUrlToBankInfoApplicationUrlDto( bankInfoApplicationUrl ) );
        }

        return list1;
    }

    protected BankInfoSocialUrlDto bankInfoSocialUrlToBankInfoSocialUrlDto(BankInfoSocialUrl bankInfoSocialUrl) {
        if ( bankInfoSocialUrl == null ) {
            return null;
        }

        BankInfoSocialUrlDtoBuilder bankInfoSocialUrlDto = BankInfoSocialUrlDtoBuilder.builder();

        bankInfoSocialUrlDto.setId( bankInfoSocialUrl.getId() );
        bankInfoSocialUrlDto.setVersion( bankInfoSocialUrl.getVersion() );
        bankInfoSocialUrlDto.setName( bankInfoSocialUrl.getName() );
        bankInfoSocialUrlDto.setBankId( bankInfoSocialUrl.getBankId() );
        bankInfoSocialUrlDto.setSocialType( bankInfoSocialUrl.getSocialType() );
        bankInfoSocialUrlDto.setSocialUrl( bankInfoSocialUrl.getSocialUrl() );
        bankInfoSocialUrlDto.setOrdering( bankInfoSocialUrl.getOrdering() );

        return bankInfoSocialUrlDto.create();
    }

    protected List<BankInfoSocialUrlDto> bankInfoSocialUrlListToBankInfoSocialUrlDtoList(List<BankInfoSocialUrl> list) {
        if ( list == null ) {
            return null;
        }

        List<BankInfoSocialUrlDto> list1 = new ArrayList<BankInfoSocialUrlDto>( list.size() );
        for ( BankInfoSocialUrl bankInfoSocialUrl : list ) {
            list1.add( bankInfoSocialUrlToBankInfoSocialUrlDto( bankInfoSocialUrl ) );
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

    protected BankInfoSocialUrl bankInfoSocialUrlDtoToBankInfoSocialUrl(BankInfoSocialUrlDto bankInfoSocialUrlDto) {
        if ( bankInfoSocialUrlDto == null ) {
            return null;
        }

        BankInfoSocialUrlBuilder bankInfoSocialUrl = BankInfoSocialUrlBuilder.builder();

        bankInfoSocialUrl.setId( bankInfoSocialUrlDto.getId() );
        bankInfoSocialUrl.setVersion( bankInfoSocialUrlDto.getVersion() );
        bankInfoSocialUrl.setName( bankInfoSocialUrlDto.getName() );
        bankInfoSocialUrl.setBankId( bankInfoSocialUrlDto.getBankId() );
        bankInfoSocialUrl.setSocialType( bankInfoSocialUrlDto.getSocialType() );
        bankInfoSocialUrl.setSocialUrl( bankInfoSocialUrlDto.getSocialUrl() );
        bankInfoSocialUrl.setOrdering( bankInfoSocialUrlDto.getOrdering() );

        return bankInfoSocialUrl.create();
    }

    protected List<BankInfoSocialUrl> bankInfoSocialUrlDtoListToBankInfoSocialUrlList(List<BankInfoSocialUrlDto> list) {
        if ( list == null ) {
            return null;
        }

        List<BankInfoSocialUrl> list1 = new ArrayList<BankInfoSocialUrl>( list.size() );
        for ( BankInfoSocialUrlDto bankInfoSocialUrlDto : list ) {
            list1.add( bankInfoSocialUrlDtoToBankInfoSocialUrl( bankInfoSocialUrlDto ) );
        }

        return list1;
    }

    protected BankInfoApplicationUrl bankInfoApplicationUrlDtoToBankInfoApplicationUrl(BankInfoApplicationUrlDto bankInfoApplicationUrlDto) {
        if ( bankInfoApplicationUrlDto == null ) {
            return null;
        }

        BankInfoApplicationUrlBuilder bankInfoApplicationUrl = BankInfoApplicationUrlBuilder.builder();

        bankInfoApplicationUrl.setId( bankInfoApplicationUrlDto.getId() );
        bankInfoApplicationUrl.setVersion( bankInfoApplicationUrlDto.getVersion() );
        bankInfoApplicationUrl.setBankId( bankInfoApplicationUrlDto.getBankId() );
        bankInfoApplicationUrl.setName( bankInfoApplicationUrlDto.getName() );
        bankInfoApplicationUrl.setAppType( bankInfoApplicationUrlDto.getAppType() );
        bankInfoApplicationUrl.setStoreType( bankInfoApplicationUrlDto.getStoreType() );
        bankInfoApplicationUrl.setDownloadUrl( bankInfoApplicationUrlDto.getDownloadUrl() );
        bankInfoApplicationUrl.setOrdering( bankInfoApplicationUrlDto.getOrdering() );

        return bankInfoApplicationUrl.create();
    }

    protected List<BankInfoApplicationUrl> bankInfoApplicationUrlDtoListToBankInfoApplicationUrlList(List<BankInfoApplicationUrlDto> list) {
        if ( list == null ) {
            return null;
        }

        List<BankInfoApplicationUrl> list1 = new ArrayList<BankInfoApplicationUrl>( list.size() );
        for ( BankInfoApplicationUrlDto bankInfoApplicationUrlDto : list ) {
            list1.add( bankInfoApplicationUrlDtoToBankInfoApplicationUrl( bankInfoApplicationUrlDto ) );
        }

        return list1;
    }
}
