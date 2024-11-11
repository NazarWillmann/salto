package ooo.jtc.dictionaries.bankbic.acc;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrCodeIEnum;
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction;
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionBuilder;
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto;
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDtoBuilder;
import ooo.jtc.dictionaries.bankbic.ed807.ED807Account;
import ooo.jtc.dictionaries.bankbic.ed807.ED807AccountBuilder;
import ooo.jtc.dictionaries.bankbic.ed807.ED807AccountRestriction;
import ooo.jtc.dictionaries.bankbic.ed807.ED807AccountRestrictionBuilder;
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BankBicAccountMapperImpl implements BankBicAccountMapper {

    @Override
    public BankBicAccountDto toDto(BankBicAccount domainModel) {
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
    public BankBicAccount toDomainModel(BankBicAccountDto dto) {
        if ( dto == null ) {
            return null;
        }

        BankBicAccountBuilder bankBicAccount = BankBicAccountBuilder.builder();

        bankBicAccount.setAccountType( dtoAccountTypeValue( dto ) );
        bankBicAccount.setStatus( dtoStatusValue( dto ) );
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
    public BankBicAccRestrictionDto nestedListOfRestrictionsToDto(BankBicAccRestriction domainModel) {
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
    public BankBicAccRestriction nestedListOfRestrictionsToDomainModel(BankBicAccRestrictionDto dto) {
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

    @Override
    public ED807Account toED807Account(BankBicAccountDto dto) {
        if ( dto == null ) {
            return null;
        }

        ED807AccountBuilder eD807Account = ED807AccountBuilder.builder();

        eD807Account.setAccountStatus( dtoStatusValue( dto ) );
        eD807Account.setRestrictionList( bankBicAccRestrictionDtoListToED807AccountRestrictionList( dto.getRestrictions() ) );
        eD807Account.setAccountCbrBic( dto.getAccountBic() );
        eD807Account.setRegulationAccountType( dtoAccountTypeValue( dto ) );
        eD807Account.setAccount( dto.getAccount() );
        eD807Account.setDateIn( dto.getDateIn() );
        eD807Account.setDateOut( dto.getDateOut() );

        return eD807Account.create();
    }

    @Override
    public ED807AccountRestriction accRestrToED807AccRestr(BankBicAccRestrictionDto restrictionDto) {
        if ( restrictionDto == null ) {
            return null;
        }

        ED807AccountRestrictionBuilder eD807AccountRestriction = ED807AccountRestrictionBuilder.builder();

        eD807AccountRestriction.setAccRstrDate( restrictionDto.getRestrictionDate() );
        eD807AccountRestriction.setAccRstr( dtoRestrictionCodeValue( restrictionDto ) );

        return eD807AccountRestriction.create();
    }

    protected List<BankBicAccRestrictionDto> bankBicAccRestrictionListToBankBicAccRestrictionDtoList(List<BankBicAccRestriction> list) {
        if ( list == null ) {
            return null;
        }

        List<BankBicAccRestrictionDto> list1 = new ArrayList<BankBicAccRestrictionDto>( list.size() );
        for ( BankBicAccRestriction bankBicAccRestriction : list ) {
            list1.add( nestedListOfRestrictionsToDto( bankBicAccRestriction ) );
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

    private String dtoStatusValue(BankBicAccountDto bankBicAccountDto) {
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
            list1.add( nestedListOfRestrictionsToDomainModel( bankBicAccRestrictionDto ) );
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

    protected List<ED807AccountRestriction> bankBicAccRestrictionDtoListToED807AccountRestrictionList(List<BankBicAccRestrictionDto> list) {
        if ( list == null ) {
            return null;
        }

        List<ED807AccountRestriction> list1 = new ArrayList<ED807AccountRestriction>( list.size() );
        for ( BankBicAccRestrictionDto bankBicAccRestrictionDto : list ) {
            list1.add( accRestrToED807AccRestr( bankBicAccRestrictionDto ) );
        }

        return list1;
    }
}
