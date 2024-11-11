package ooo.jtc.dictionaries.bankbic;

import com.mifmif.common.regex.Generex;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccAccountTypeIEnum;
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccStatusIEnum;
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccount;
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccountBuilder;
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccountDto;
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccountDtoBuilder;
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrCodeIEnum;
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction;
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionBuilder;
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto;
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDtoBuilder;
import ooo.jtc.dictionaries.bankbic.ed807.ED807ParticipantInfo;
import ooo.jtc.dictionaries.bankbic.ed807.ED807ParticipantInfoBuilder;
import ooo.jtc.dictionaries.bankbic.ed807.ED807ParticipantRestriction;
import ooo.jtc.dictionaries.bankbic.ed807.ED807ParticipantRestrictionBuilder;
import ooo.jtc.dictionaries.bankbic.innerenum.BankBicAllowedServicesIEnumDto;
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto;
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestrCodeIEnum;
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction;
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionBuilder;
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionDto;
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionDtoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:42+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BankBicMapperImpl implements BankBicMapper {

    @Override
    public BankBicDto toDto(BankBic domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BankBicDtoBuilder bankBicDto = BankBicDtoBuilder.builder();

        bankBicDto.setId( domainModel.getId() );
        bankBicDto.setVersion( domainModel.getVersion() );
        bankBicDto.setBic( domainModel.getBic() );
        bankBicDto.setName( domainModel.getName() );
        bankBicDto.setCountryAlpha2Code( domainModel.getCountryAlpha2Code() );
        bankBicDto.setZip( domainModel.getZip() );
        bankBicDto.setLocationType( domainModel.getLocationType() );
        bankBicDto.setLocation( domainModel.getLocation() );
        bankBicDto.setAddress( domainModel.getAddress() );
        bankBicDto.setParentBic( domainModel.getParentBic() );
        bankBicDto.setDateIn( domainModel.getDateIn() );
        bankBicDto.setDateOut( domainModel.getDateOut() );
        bankBicDto.setAccounts( bankBicAccountListToBankBicAccountDtoList( domainModel.getAccounts() ) );
        bankBicDto.setRestrictions( bankBicRestrictionListToBankBicRestrictionDtoList( domainModel.getRestrictions() ) );

        bankBicDto.setParticipantType( BankBicParticipantTypeIEnum.Companion.ofStr(domainModel.getParticipantType()) );
        bankBicDto.setParticipantTransferType( BankBicParticipantTransferTypeIEnum.Companion.ofStr(domainModel.getParticipantTransferType()) );
        bankBicDto.setAllowedServices( BankBicAllowedServicesIEnum.Companion.ofStr(domainModel.getAllowedServices()) );
        bankBicDto.setStatus( BankBicStatusesIEnum.Companion.ofStr(domainModel.getStatus()) );

        return bankBicDto.create();
    }

    @Override
    public BankBic toDomainModel(BankBicDto dto) {
        if ( dto == null ) {
            return null;
        }

        BankBicBuilder bankBic = BankBicBuilder.builder();

        bankBic.setParticipantType( dtoParticipantTypeValue( dto ) );
        bankBic.setParticipantTransferType( dtoParticipantTransferTypeValue( dto ) );
        bankBic.setAllowedServices( dtoAllowedServicesValue( dto ) );
        bankBic.setStatus( dtoStatusValue( dto ) );
        bankBic.setId( dto.getId() );
        bankBic.setVersion( dto.getVersion() );
        bankBic.setBic( dto.getBic() );
        bankBic.setName( dto.getName() );
        bankBic.setCountryAlpha2Code( dto.getCountryAlpha2Code() );
        bankBic.setZip( dto.getZip() );
        bankBic.setLocationType( dto.getLocationType() );
        bankBic.setLocation( dto.getLocation() );
        bankBic.setAddress( dto.getAddress() );
        bankBic.setParentBic( dto.getParentBic() );
        bankBic.setDateIn( dto.getDateIn() );
        bankBic.setDateOut( dto.getDateOut() );
        bankBic.setAccounts( bankBicAccountDtoListToBankBicAccountList( dto.getAccounts() ) );
        bankBic.setRestrictions( bankBicRestrictionDtoListToBankBicRestrictionList( dto.getRestrictions() ) );

        return bankBic.create();
    }

    @Override
    public ED807ParticipantInfo toED807ParticipantInfo(BankBicDto dto) {
        if ( dto == null ) {
            return null;
        }

        ED807ParticipantInfoBuilder eD807ParticipantInfo = ED807ParticipantInfoBuilder.builder();

        eD807ParticipantInfo.setXchType( dtoParticipantTypeValue( dto ) );
        eD807ParticipantInfo.setSrvcs( dtoAllowedServicesValue( dto ) );
        eD807ParticipantInfo.setAdr( dto.getAddress() );
        eD807ParticipantInfo.setNnp( dto.getLocation() );
        eD807ParticipantInfo.setPrntBic( dto.getParentBic() );
        eD807ParticipantInfo.setTnp( dto.getLocationType() );
        eD807ParticipantInfo.setPtType( dtoParticipantTransferTypeValue( dto ) );
        eD807ParticipantInfo.setParticipantStatus( dtoStatusValue( dto ) );
        eD807ParticipantInfo.setRestrictionList( bankBicRestrictionDtoListToED807ParticipantRestrictionList( dto.getRestrictions() ) );
        eD807ParticipantInfo.setNameP( dto.getName() );
        eD807ParticipantInfo.setCntrCd( dto.getCountryAlpha2Code() );
        eD807ParticipantInfo.setInd( dto.getZip() );
        eD807ParticipantInfo.setDateIn( dto.getDateIn() );
        eD807ParticipantInfo.setDateOut( dto.getDateOut() );

        eD807ParticipantInfo.setUid( new Generex("\\d*").random(10, 10) );
        eD807ParticipantInfo.setRgn( "47" );

        return eD807ParticipantInfo.create();
    }

    @Override
    public ED807ParticipantRestriction partRestrToED807PartRestr(BankBicRestrictionDto restrictionDto) {
        if ( restrictionDto == null ) {
            return null;
        }

        ED807ParticipantRestrictionBuilder eD807ParticipantRestriction = ED807ParticipantRestrictionBuilder.builder();

        eD807ParticipantRestriction.setRstrDate( restrictionDto.getRestrictionDate() );
        eD807ParticipantRestriction.setRstr( restrictionDtoRestrictionCodeValue( restrictionDto ) );

        return eD807ParticipantRestriction.create();
    }

    @Override
    public BankBicRestrictionDto nestedRestrictionsToDto(BankBicRestriction domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BankBicRestrictionDtoBuilder bankBicRestrictionDto = BankBicRestrictionDtoBuilder.builder();

        bankBicRestrictionDto.setId( domainModel.getId() );
        bankBicRestrictionDto.setVersion( domainModel.getVersion() );
        bankBicRestrictionDto.setRestrictionDate( domainModel.getRestrictionDate() );

        bankBicRestrictionDto.setRestrictionCode( BankBicRestrCodeIEnum.Companion.ofStr(domainModel.getRestrictionCode()) );

        return bankBicRestrictionDto.create();
    }

    @Override
    public BankBicRestriction nestedRestrictionsToDomainModel(BankBicRestrictionDto dto) {
        if ( dto == null ) {
            return null;
        }

        BankBicRestrictionBuilder bankBicRestriction = BankBicRestrictionBuilder.builder();

        bankBicRestriction.setRestrictionCode( restrictionDtoRestrictionCodeValue( dto ) );
        bankBicRestriction.setId( dto.getId() );
        bankBicRestriction.setVersion( dto.getVersion() );
        bankBicRestriction.setRestrictionDate( dto.getRestrictionDate() );

        return bankBicRestriction.create();
    }

    @Override
    public BankBicAccountDto nestedAccountsToDto(BankBicAccount domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BankBicAccountDtoBuilder bankBicAccountDto = BankBicAccountDtoBuilder.builder();

        bankBicAccountDto.setId( domainModel.getId() );
        bankBicAccountDto.setVersion( domainModel.getVersion() );
        bankBicAccountDto.setAccount( domainModel.getAccount() );
        bankBicAccountDto.setAccountBic( domainModel.getAccountBic() );
        bankBicAccountDto.setDateIn( domainModel.getDateIn() );
        bankBicAccountDto.setDateOut( domainModel.getDateOut() );
        bankBicAccountDto.setRestrictions( bankBicAccRestrictionListToBankBicAccRestrictionDtoList( domainModel.getRestrictions() ) );

        bankBicAccountDto.setAccountType( BankBicAccAccountTypeIEnum.Companion.ofStr(domainModel.getAccountType()) );
        bankBicAccountDto.setStatus( BankBicAccStatusIEnum.Companion.ofStr(domainModel.getStatus()) );

        return bankBicAccountDto.create();
    }

    @Override
    public BankBicAccount nestedAccountsToDomainModel(BankBicAccountDto dto) {
        if ( dto == null ) {
            return null;
        }

        BankBicAccountBuilder bankBicAccount = BankBicAccountBuilder.builder();

        bankBicAccount.setAccountType( dtoAccountTypeValue( dto ) );
        bankBicAccount.setStatus( dtoStatusValue1( dto ) );
        bankBicAccount.setId( dto.getId() );
        bankBicAccount.setVersion( dto.getVersion() );
        bankBicAccount.setAccount( dto.getAccount() );
        bankBicAccount.setAccountBic( dto.getAccountBic() );
        bankBicAccount.setDateIn( dto.getDateIn() );
        bankBicAccount.setDateOut( dto.getDateOut() );
        bankBicAccount.setRestrictions( bankBicAccRestrictionDtoListToBankBicAccRestrictionList( dto.getRestrictions() ) );

        return bankBicAccount.create();
    }

    @Override
    public BankBicAccRestrictionDto nestedAccountsNestedRestrictionsToDto(BankBicAccRestriction domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BankBicAccRestrictionDtoBuilder bankBicAccRestrictionDto = BankBicAccRestrictionDtoBuilder.builder();

        bankBicAccRestrictionDto.setId( domainModel.getId() );
        bankBicAccRestrictionDto.setVersion( domainModel.getVersion() );
        bankBicAccRestrictionDto.setRestrictionDate( domainModel.getRestrictionDate() );

        bankBicAccRestrictionDto.setRestrictionCode( BankBicAccRestrCodeIEnum.Companion.ofStr(domainModel.getRestrictionCode()) );

        return bankBicAccRestrictionDto.create();
    }

    @Override
    public BankBicAccRestriction nestedAccountsNestedRestrictionsToDomainModel(BankBicAccRestrictionDto dto) {
        if ( dto == null ) {
            return null;
        }

        BankBicAccRestrictionBuilder bankBicAccRestriction = BankBicAccRestrictionBuilder.builder();

        bankBicAccRestriction.setRestrictionCode( dtoRestrictionCodeValue( dto ) );
        bankBicAccRestriction.setId( dto.getId() );
        bankBicAccRestriction.setVersion( dto.getVersion() );
        bankBicAccRestriction.setRestrictionDate( dto.getRestrictionDate() );

        return bankBicAccRestriction.create();
    }

    protected List<BankBicAccountDto> bankBicAccountListToBankBicAccountDtoList(List<BankBicAccount> list) {
        if ( list == null ) {
            return null;
        }

        List<BankBicAccountDto> list1 = new ArrayList<BankBicAccountDto>( list.size() );
        for ( BankBicAccount bankBicAccount : list ) {
            list1.add( nestedAccountsToDto( bankBicAccount ) );
        }

        return list1;
    }

    protected List<BankBicRestrictionDto> bankBicRestrictionListToBankBicRestrictionDtoList(List<BankBicRestriction> list) {
        if ( list == null ) {
            return null;
        }

        List<BankBicRestrictionDto> list1 = new ArrayList<BankBicRestrictionDto>( list.size() );
        for ( BankBicRestriction bankBicRestriction : list ) {
            list1.add( nestedRestrictionsToDto( bankBicRestriction ) );
        }

        return list1;
    }

    private String dtoParticipantTypeValue(BankBicDto bankBicDto) {
        if ( bankBicDto == null ) {
            return null;
        }
        ValDescIEnumDto participantType = bankBicDto.getParticipantType();
        if ( participantType == null ) {
            return null;
        }
        String value = participantType.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    private String dtoParticipantTransferTypeValue(BankBicDto bankBicDto) {
        if ( bankBicDto == null ) {
            return null;
        }
        ValDescIEnumDto participantTransferType = bankBicDto.getParticipantTransferType();
        if ( participantTransferType == null ) {
            return null;
        }
        String value = participantTransferType.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    private String dtoAllowedServicesValue(BankBicDto bankBicDto) {
        if ( bankBicDto == null ) {
            return null;
        }
        BankBicAllowedServicesIEnumDto allowedServices = bankBicDto.getAllowedServices();
        if ( allowedServices == null ) {
            return null;
        }
        String value = allowedServices.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    private String dtoStatusValue(BankBicDto bankBicDto) {
        if ( bankBicDto == null ) {
            return null;
        }
        ValDescIEnumDto status = bankBicDto.getStatus();
        if ( status == null ) {
            return null;
        }
        String value = status.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    protected List<BankBicAccount> bankBicAccountDtoListToBankBicAccountList(List<BankBicAccountDto> list) {
        if ( list == null ) {
            return null;
        }

        List<BankBicAccount> list1 = new ArrayList<BankBicAccount>( list.size() );
        for ( BankBicAccountDto bankBicAccountDto : list ) {
            list1.add( nestedAccountsToDomainModel( bankBicAccountDto ) );
        }

        return list1;
    }

    protected List<BankBicRestriction> bankBicRestrictionDtoListToBankBicRestrictionList(List<BankBicRestrictionDto> list) {
        if ( list == null ) {
            return null;
        }

        List<BankBicRestriction> list1 = new ArrayList<BankBicRestriction>( list.size() );
        for ( BankBicRestrictionDto bankBicRestrictionDto : list ) {
            list1.add( nestedRestrictionsToDomainModel( bankBicRestrictionDto ) );
        }

        return list1;
    }

    protected List<ED807ParticipantRestriction> bankBicRestrictionDtoListToED807ParticipantRestrictionList(List<BankBicRestrictionDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ED807ParticipantRestriction> list1 = new ArrayList<ED807ParticipantRestriction>( list.size() );
        for ( BankBicRestrictionDto bankBicRestrictionDto : list ) {
            list1.add( partRestrToED807PartRestr( bankBicRestrictionDto ) );
        }

        return list1;
    }

    private String restrictionDtoRestrictionCodeValue(BankBicRestrictionDto bankBicRestrictionDto) {
        if ( bankBicRestrictionDto == null ) {
            return null;
        }
        ValDescIEnumDto restrictionCode = bankBicRestrictionDto.getRestrictionCode();
        if ( restrictionCode == null ) {
            return null;
        }
        String value = restrictionCode.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    protected List<BankBicAccRestrictionDto> bankBicAccRestrictionListToBankBicAccRestrictionDtoList(List<BankBicAccRestriction> list) {
        if ( list == null ) {
            return null;
        }

        List<BankBicAccRestrictionDto> list1 = new ArrayList<BankBicAccRestrictionDto>( list.size() );
        for ( BankBicAccRestriction bankBicAccRestriction : list ) {
            list1.add( nestedAccountsNestedRestrictionsToDto( bankBicAccRestriction ) );
        }

        return list1;
    }

    private String dtoAccountTypeValue(BankBicAccountDto bankBicAccountDto) {
        if ( bankBicAccountDto == null ) {
            return null;
        }
        ValDescIEnumDto accountType = bankBicAccountDto.getAccountType();
        if ( accountType == null ) {
            return null;
        }
        String value = accountType.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    private String dtoStatusValue1(BankBicAccountDto bankBicAccountDto) {
        if ( bankBicAccountDto == null ) {
            return null;
        }
        ValDescIEnumDto status = bankBicAccountDto.getStatus();
        if ( status == null ) {
            return null;
        }
        String value = status.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    protected List<BankBicAccRestriction> bankBicAccRestrictionDtoListToBankBicAccRestrictionList(List<BankBicAccRestrictionDto> list) {
        if ( list == null ) {
            return null;
        }

        List<BankBicAccRestriction> list1 = new ArrayList<BankBicAccRestriction>( list.size() );
        for ( BankBicAccRestrictionDto bankBicAccRestrictionDto : list ) {
            list1.add( nestedAccountsNestedRestrictionsToDomainModel( bankBicAccRestrictionDto ) );
        }

        return list1;
    }

    private String dtoRestrictionCodeValue(BankBicAccRestrictionDto bankBicAccRestrictionDto) {
        if ( bankBicAccRestrictionDto == null ) {
            return null;
        }
        ValDescIEnumDto restrictionCode = bankBicAccRestrictionDto.getRestrictionCode();
        if ( restrictionCode == null ) {
            return null;
        }
        String value = restrictionCode.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }
}
