package ooo.jtc.dictionaries.account;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.accountype.AccountType;
import ooo.jtc.dictionaries.accountype.AccountTypeBuilder;
import ooo.jtc.dictionaries.accountype.AccountTypeDto;
import ooo.jtc.dictionaries.accountype.AccountTypeDtoBuilder;
import ooo.jtc.dictionaries.common.BlockingInfoDto;
import ooo.jtc.dictionaries.common.BlockingInfoDtoBuilder;
import ooo.jtc.dictionaries.common.extid.ExtId;
import ooo.jtc.dictionaries.common.extid.ExtIdBuilder;
import ooo.jtc.dictionaries.common.extid.ExtIdDto;
import ooo.jtc.dictionaries.common.extid.ExtIdDtoBuilder;
import ooo.jtc.generic.CustomConverter;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class AccountMapperImpl implements AccountMapper {

    private final CustomConverter customConverter = new CustomConverter();

    @Override
    public AccountDto toDto(Account domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        AccountDtoBuilder accountDto = AccountDtoBuilder.builder();

        accountDto.setBlock( accountToBlockingInfoDto( domainModel ) );
        accountDto.setCloseDate( customConverter.timestampToZonedDateTime( domainModel.getCloseDate() ) );
        accountDto.setReserveEndDate( customConverter.timestampToZonedDateTime( domainModel.getReserveEndDate() ) );
        accountDto.setActualDate( customConverter.timestampToZonedDateTime( domainModel.getActualDate() ) );
        accountDto.setReserveBeginDate( customConverter.timestampToZonedDateTime( domainModel.getReserveBeginDate() ) );
        accountDto.setOpenDate( customConverter.timestampToZonedDateTime( domainModel.getOpenDate() ) );
        accountDto.setId( domainModel.getId() );
        accountDto.setVersion( domainModel.getVersion() );
        accountDto.setBranchCustomerId( domainModel.getBranchCustomerId() );
        accountDto.setCustomerId( domainModel.getCustomerId() );
        accountDto.setBranchIndividualId( domainModel.getBranchIndividualId() );
        accountDto.setIndividualId( domainModel.getIndividualId() );
        accountDto.setBranchId( domainModel.getBranchId() );
        accountDto.setAccountNumber( domainModel.getAccountNumber() );
        accountDto.setAccountKind( domainModel.getAccountKind() );
        accountDto.setAccountTypeId( domainModel.getAccountTypeId() );
        accountDto.setState( domainModel.getState() );
        accountDto.setName( domainModel.getName() );
        accountDto.setCurrencyAlphaCode( domainModel.getCurrencyAlphaCode() );
        accountDto.setCurrencyDigitCode( domainModel.getCurrencyDigitCode() );
        accountDto.setIsMarkInfo( domainModel.isMarkInfo );
        accountDto.setActualBalance( domainModel.getActualBalance() );
        accountDto.setPlanBalance( domainModel.getPlanBalance() );
        accountDto.setBlockedAmount( domainModel.getBlockedAmount() );
        accountDto.setDescription( domainModel.getDescription() );
        accountDto.setCardAmount( domainModel.getCardAmount() );
        accountDto.setExtIds( extIdListToExtIdDtoList( domainModel.getExtIds() ) );
        accountDto.setAccountType( accountTypeToAccountTypeDto( domainModel.getAccountType() ) );

        return accountDto.create();
    }

    @Override
    public Account toDomainModel(AccountDto dto) {
        if ( dto == null ) {
            return null;
        }

        AccountBuilder account = AccountBuilder.builder();

        account.setCloseDate( customConverter.zonedDateTimeToTimestamp( dto.getCloseDate() ) );
        account.setBlockUserId( dtoBlockBlockUser( dto ) );
        account.setBlockDate( customConverter.zonedDateTimeToTimestamp( dtoBlockBlockDate( dto ) ) );
        account.setIsBlock( dtoBlockIsBlock( dto ) );
        account.setReserveEndDate( customConverter.zonedDateTimeToTimestamp( dto.getReserveEndDate() ) );
        account.setActualDate( customConverter.zonedDateTimeToTimestamp( dto.getActualDate() ) );
        account.setReserveBeginDate( customConverter.zonedDateTimeToTimestamp( dto.getReserveBeginDate() ) );
        account.setOpenDate( customConverter.zonedDateTimeToTimestamp( dto.getOpenDate() ) );
        account.setId( dto.getId() );
        account.setVersion( dto.getVersion() );
        account.setBranchCustomerId( dto.getBranchCustomerId() );
        account.setBranchIndividualId( dto.getBranchIndividualId() );
        account.setAccountNumber( dto.getAccountNumber() );
        account.setAccountKind( dto.getAccountKind() );
        account.setAccountTypeId( dto.getAccountTypeId() );
        account.setState( dto.getState() );
        account.setName( dto.getName() );
        account.setCurrencyAlphaCode( dto.getCurrencyAlphaCode() );
        account.setCurrencyDigitCode( dto.getCurrencyDigitCode() );
        account.setIsMarkInfo( dto.isMarkInfo );
        account.setDescription( dto.getDescription() );
        account.setActualBalance( dto.getActualBalance() );
        account.setPlanBalance( dto.getPlanBalance() );
        account.setBlockedAmount( dto.getBlockedAmount() );
        account.setCardAmount( dto.getCardAmount() );
        account.setCustomerId( dto.getCustomerId() );
        account.setBranchId( dto.getBranchId() );
        account.setIndividualId( dto.getIndividualId() );
        account.setAccountType( accountTypeDtoToAccountType( dto.getAccountType() ) );
        account.setExtIds( extIdDtoListToExtIdList( dto.getExtIds() ) );

        return account.create();
    }

    protected BlockingInfoDto accountToBlockingInfoDto(Account account) {
        if ( account == null ) {
            return null;
        }

        BlockingInfoDtoBuilder blockingInfoDto = BlockingInfoDtoBuilder.builder();

        blockingInfoDto.setIsBlock( account.isBlock );
        blockingInfoDto.setBlockUser( account.getBlockUserId() );
        blockingInfoDto.setBlockDate( customConverter.timestampToZonedDateTime( account.getBlockDate() ) );

        return blockingInfoDto.create();
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

    protected AccountTypeDto accountTypeToAccountTypeDto(AccountType accountType) {
        if ( accountType == null ) {
            return null;
        }

        AccountTypeDtoBuilder accountTypeDto = AccountTypeDtoBuilder.builder();

        accountTypeDto.setId( accountType.getId() );
        accountTypeDto.setVersion( accountType.getVersion() );
        accountTypeDto.setFullName( accountType.getFullName() );
        accountTypeDto.setShortName( accountType.getShortName() );
        accountTypeDto.setSystemName( accountType.getSystemName() );
        accountTypeDto.setClientType( accountType.getClientType() );
        accountTypeDto.setDescription( accountType.getDescription() );

        return accountTypeDto.create();
    }

    private UUID dtoBlockBlockUser(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }
        BlockingInfoDto block = accountDto.getBlock();
        if ( block == null ) {
            return null;
        }
        UUID blockUser = block.getBlockUser();
        if ( blockUser == null ) {
            return null;
        }
        return blockUser;
    }

    private ZonedDateTime dtoBlockBlockDate(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }
        BlockingInfoDto block = accountDto.getBlock();
        if ( block == null ) {
            return null;
        }
        ZonedDateTime blockDate = block.getBlockDate();
        if ( blockDate == null ) {
            return null;
        }
        return blockDate;
    }

    private boolean dtoBlockIsBlock(AccountDto accountDto) {
        if ( accountDto == null ) {
            return false;
        }
        BlockingInfoDto block = accountDto.getBlock();
        if ( block == null ) {
            return false;
        }
        boolean isBlock = block.isBlock;
        return isBlock;
    }

    protected AccountType accountTypeDtoToAccountType(AccountTypeDto accountTypeDto) {
        if ( accountTypeDto == null ) {
            return null;
        }

        AccountTypeBuilder accountType = AccountTypeBuilder.builder();

        accountType.setId( accountTypeDto.getId() );
        accountType.setVersion( accountTypeDto.getVersion() );
        accountType.setFullName( accountTypeDto.getFullName() );
        accountType.setShortName( accountTypeDto.getShortName() );
        accountType.setSystemName( accountTypeDto.getSystemName() );
        accountType.setDescription( accountTypeDto.getDescription() );
        accountType.setClientType( accountTypeDto.getClientType() );

        return accountType.create();
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
}
