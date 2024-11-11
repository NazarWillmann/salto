package ooo.jtc.dictionaries.bankrepresentative;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.common.BlockingInfoDto;
import ooo.jtc.dictionaries.common.BlockingInfoDtoBuilder;
import ooo.jtc.generic.CustomConverter;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class BankRepresentativeMapperImpl implements BankRepresentativeMapper {

    private final CustomConverter customConverter = new CustomConverter();

    @Override
    public BankRepresentativeDto toDto(BankRepresentative domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BankRepresentativeDtoBuilder bankRepresentativeDto = BankRepresentativeDtoBuilder.builder();

        bankRepresentativeDto.setBlock( bankRepresentativeToBlockingInfoDto( domainModel ) );
        bankRepresentativeDto.setId( domainModel.getId() );
        bankRepresentativeDto.setVersion( domainModel.getVersion() );
        bankRepresentativeDto.setBankId( domainModel.getBankId() );
        bankRepresentativeDto.setUserId( domainModel.getUserId() );
        bankRepresentativeDto.setPosition( domainModel.getPosition() );
        bankRepresentativeDto.setEmail( domainModel.getEmail() );
        bankRepresentativeDto.setPhone( domainModel.getPhone() );
        bankRepresentativeDto.setDescription( domainModel.getDescription() );

        return bankRepresentativeDto.create();
    }

    @Override
    public BankRepresentative toDomainModel(BankRepresentativeDto dto) {
        if ( dto == null ) {
            return null;
        }

        BankRepresentativeBuilder bankRepresentative = BankRepresentativeBuilder.builder();

        bankRepresentative.setBlockUserId( dtoBlockBlockUser( dto ) );
        bankRepresentative.setBlockDate( customConverter.zonedDateTimeToTimestamp( dtoBlockBlockDate( dto ) ) );
        bankRepresentative.setIsBlock( dtoBlockIsBlock( dto ) );
        bankRepresentative.setId( dto.getId() );
        bankRepresentative.setVersion( dto.getVersion() );
        bankRepresentative.setBankId( dto.getBankId() );
        bankRepresentative.setUserId( dto.getUserId() );
        bankRepresentative.setPosition( dto.getPosition() );
        bankRepresentative.setEmail( dto.getEmail() );
        bankRepresentative.setPhone( dto.getPhone() );
        bankRepresentative.setDescription( dto.getDescription() );

        return bankRepresentative.create();
    }

    protected BlockingInfoDto bankRepresentativeToBlockingInfoDto(BankRepresentative bankRepresentative) {
        if ( bankRepresentative == null ) {
            return null;
        }

        BlockingInfoDtoBuilder blockingInfoDto = BlockingInfoDtoBuilder.builder();

        blockingInfoDto.setIsBlock( bankRepresentative.isBlock );
        blockingInfoDto.setBlockUser( bankRepresentative.getBlockUserId() );
        blockingInfoDto.setBlockDate( customConverter.timestampToZonedDateTime( bankRepresentative.getBlockDate() ) );

        return blockingInfoDto.create();
    }

    private UUID dtoBlockBlockUser(BankRepresentativeDto bankRepresentativeDto) {
        if ( bankRepresentativeDto == null ) {
            return null;
        }
        BlockingInfoDto block = bankRepresentativeDto.getBlock();
        if ( block == null ) {
            return null;
        }
        UUID blockUser = block.getBlockUser();
        if ( blockUser == null ) {
            return null;
        }
        return blockUser;
    }

    private ZonedDateTime dtoBlockBlockDate(BankRepresentativeDto bankRepresentativeDto) {
        if ( bankRepresentativeDto == null ) {
            return null;
        }
        BlockingInfoDto block = bankRepresentativeDto.getBlock();
        if ( block == null ) {
            return null;
        }
        ZonedDateTime blockDate = block.getBlockDate();
        if ( blockDate == null ) {
            return null;
        }
        return blockDate;
    }

    private boolean dtoBlockIsBlock(BankRepresentativeDto bankRepresentativeDto) {
        if ( bankRepresentativeDto == null ) {
            return false;
        }
        BlockingInfoDto block = bankRepresentativeDto.getBlock();
        if ( block == null ) {
            return false;
        }
        boolean isBlock = block.isBlock;
        return isBlock;
    }
}
