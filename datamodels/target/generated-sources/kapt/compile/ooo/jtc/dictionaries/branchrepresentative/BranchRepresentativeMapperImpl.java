package ooo.jtc.dictionaries.branchrepresentative;

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
public class BranchRepresentativeMapperImpl implements BranchRepresentativeMapper {

    private final CustomConverter customConverter = new CustomConverter();

    @Override
    public BranchRepresentativeDto toDto(BranchRepresentative domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        BranchRepresentativeDtoBuilder branchRepresentativeDto = BranchRepresentativeDtoBuilder.builder();

        branchRepresentativeDto.setBlock( branchRepresentativeToBlockingInfoDto( domainModel ) );
        branchRepresentativeDto.setId( domainModel.getId() );
        branchRepresentativeDto.setVersion( domainModel.getVersion() );
        branchRepresentativeDto.setBranchId( domainModel.getBranchId() );
        branchRepresentativeDto.setUserId( domainModel.getUserId() );
        branchRepresentativeDto.setPosition( domainModel.getPosition() );
        branchRepresentativeDto.setEmail( domainModel.getEmail() );
        branchRepresentativeDto.setPhone( domainModel.getPhone() );
        branchRepresentativeDto.setDescription( domainModel.getDescription() );

        return branchRepresentativeDto.create();
    }

    @Override
    public BranchRepresentative toDomainModel(BranchRepresentativeDto dto) {
        if ( dto == null ) {
            return null;
        }

        BranchRepresentativeBuilder branchRepresentative = BranchRepresentativeBuilder.builder();

        branchRepresentative.setBlockUserId( dtoBlockBlockUser( dto ) );
        branchRepresentative.setBlockDate( customConverter.zonedDateTimeToTimestamp( dtoBlockBlockDate( dto ) ) );
        branchRepresentative.setIsBlock( dtoBlockIsBlock( dto ) );
        branchRepresentative.setId( dto.getId() );
        branchRepresentative.setVersion( dto.getVersion() );
        branchRepresentative.setBranchId( dto.getBranchId() );
        branchRepresentative.setUserId( dto.getUserId() );
        branchRepresentative.setPosition( dto.getPosition() );
        branchRepresentative.setEmail( dto.getEmail() );
        branchRepresentative.setPhone( dto.getPhone() );
        branchRepresentative.setDescription( dto.getDescription() );

        return branchRepresentative.create();
    }

    protected BlockingInfoDto branchRepresentativeToBlockingInfoDto(BranchRepresentative branchRepresentative) {
        if ( branchRepresentative == null ) {
            return null;
        }

        BlockingInfoDtoBuilder blockingInfoDto = BlockingInfoDtoBuilder.builder();

        blockingInfoDto.setIsBlock( branchRepresentative.isBlock );
        blockingInfoDto.setBlockUser( branchRepresentative.getBlockUserId() );
        blockingInfoDto.setBlockDate( customConverter.timestampToZonedDateTime( branchRepresentative.getBlockDate() ) );

        return blockingInfoDto.create();
    }

    private UUID dtoBlockBlockUser(BranchRepresentativeDto branchRepresentativeDto) {
        if ( branchRepresentativeDto == null ) {
            return null;
        }
        BlockingInfoDto block = branchRepresentativeDto.getBlock();
        if ( block == null ) {
            return null;
        }
        UUID blockUser = block.getBlockUser();
        if ( blockUser == null ) {
            return null;
        }
        return blockUser;
    }

    private ZonedDateTime dtoBlockBlockDate(BranchRepresentativeDto branchRepresentativeDto) {
        if ( branchRepresentativeDto == null ) {
            return null;
        }
        BlockingInfoDto block = branchRepresentativeDto.getBlock();
        if ( block == null ) {
            return null;
        }
        ZonedDateTime blockDate = block.getBlockDate();
        if ( blockDate == null ) {
            return null;
        }
        return blockDate;
    }

    private boolean dtoBlockIsBlock(BranchRepresentativeDto branchRepresentativeDto) {
        if ( branchRepresentativeDto == null ) {
            return false;
        }
        BlockingInfoDto block = branchRepresentativeDto.getBlock();
        if ( block == null ) {
            return false;
        }
        boolean isBlock = block.isBlock;
        return isBlock;
    }
}
