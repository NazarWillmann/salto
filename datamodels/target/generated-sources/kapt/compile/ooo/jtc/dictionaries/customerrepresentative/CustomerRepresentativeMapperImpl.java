package ooo.jtc.dictionaries.customerrepresentative;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.common.BlockingInfoDto;
import ooo.jtc.dictionaries.common.BlockingInfoDtoBuilder;
import ooo.jtc.generic.CustomConverter;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class CustomerRepresentativeMapperImpl implements CustomerRepresentativeMapper {

    private final CustomConverter customConverter = new CustomConverter();

    @Override
    public CustomerRepresentativeDto toDto(CustomerRepresentative domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        CustomerRepresentativeDtoBuilder customerRepresentativeDto = CustomerRepresentativeDtoBuilder.builder();

        customerRepresentativeDto.setBlock( customerRepresentativeToBlockingInfoDto( domainModel ) );
        customerRepresentativeDto.setId( domainModel.getId() );
        customerRepresentativeDto.setVersion( domainModel.getVersion() );
        customerRepresentativeDto.setCustomerId( domainModel.getCustomerId() );
        customerRepresentativeDto.setUserId( domainModel.getUserId() );
        customerRepresentativeDto.setPosition( domainModel.getPosition() );
        customerRepresentativeDto.setEmail( domainModel.getEmail() );
        customerRepresentativeDto.setPhone( domainModel.getPhone() );
        customerRepresentativeDto.setDescription( domainModel.getDescription() );

        return customerRepresentativeDto.create();
    }

    @Override
    public CustomerRepresentative toDomainModel(CustomerRepresentativeDto dto) {
        if ( dto == null ) {
            return null;
        }

        CustomerRepresentativeBuilder customerRepresentative = CustomerRepresentativeBuilder.builder();

        customerRepresentative.setBlockUserId( dtoBlockBlockUser( dto ) );
        customerRepresentative.setBlockDate( customConverter.zonedDateTimeToTimestamp( dtoBlockBlockDate( dto ) ) );
        customerRepresentative.setIsBlock( dtoBlockIsBlock( dto ) );
        customerRepresentative.setId( dto.getId() );
        customerRepresentative.setVersion( dto.getVersion() );
        customerRepresentative.setCustomerId( dto.getCustomerId() );
        customerRepresentative.setUserId( dto.getUserId() );
        customerRepresentative.setPosition( dto.getPosition() );
        customerRepresentative.setEmail( dto.getEmail() );
        customerRepresentative.setPhone( dto.getPhone() );
        customerRepresentative.setDescription( dto.getDescription() );

        return customerRepresentative.create();
    }

    protected BlockingInfoDto customerRepresentativeToBlockingInfoDto(CustomerRepresentative customerRepresentative) {
        if ( customerRepresentative == null ) {
            return null;
        }

        BlockingInfoDtoBuilder blockingInfoDto = BlockingInfoDtoBuilder.builder();

        blockingInfoDto.setIsBlock( customerRepresentative.isBlock );
        blockingInfoDto.setBlockUser( customerRepresentative.getBlockUserId() );
        blockingInfoDto.setBlockDate( customConverter.timestampToZonedDateTime( customerRepresentative.getBlockDate() ) );

        return blockingInfoDto.create();
    }

    private UUID dtoBlockBlockUser(CustomerRepresentativeDto customerRepresentativeDto) {
        if ( customerRepresentativeDto == null ) {
            return null;
        }
        BlockingInfoDto block = customerRepresentativeDto.getBlock();
        if ( block == null ) {
            return null;
        }
        UUID blockUser = block.getBlockUser();
        if ( blockUser == null ) {
            return null;
        }
        return blockUser;
    }

    private ZonedDateTime dtoBlockBlockDate(CustomerRepresentativeDto customerRepresentativeDto) {
        if ( customerRepresentativeDto == null ) {
            return null;
        }
        BlockingInfoDto block = customerRepresentativeDto.getBlock();
        if ( block == null ) {
            return null;
        }
        ZonedDateTime blockDate = block.getBlockDate();
        if ( blockDate == null ) {
            return null;
        }
        return blockDate;
    }

    private boolean dtoBlockIsBlock(CustomerRepresentativeDto customerRepresentativeDto) {
        if ( customerRepresentativeDto == null ) {
            return false;
        }
        BlockingInfoDto block = customerRepresentativeDto.getBlock();
        if ( block == null ) {
            return false;
        }
        boolean isBlock = block.isBlock;
        return isBlock;
    }
}
