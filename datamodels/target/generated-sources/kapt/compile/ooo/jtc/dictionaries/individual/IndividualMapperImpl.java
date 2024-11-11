package ooo.jtc.dictionaries.individual;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.common.BlockingInfoDto;
import ooo.jtc.dictionaries.common.BlockingInfoDtoBuilder;
import ooo.jtc.dictionaries.common.address.Address;
import ooo.jtc.dictionaries.common.address.AddressBuilder;
import ooo.jtc.dictionaries.common.address.AddressDto;
import ooo.jtc.dictionaries.common.address.AddressDtoBuilder;
import ooo.jtc.generic.CustomConverter;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class IndividualMapperImpl implements IndividualMapper {

    private final CustomConverter customConverter = new CustomConverter();

    @Override
    public IndividualDto toDto(Individual domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        IndividualDtoBuilder individualDto = IndividualDtoBuilder.builder();

        individualDto.setBlock( individualToBlockingInfoDto( domainModel ) );
        individualDto.setId( domainModel.getId() );
        individualDto.setVersion( domainModel.getVersion() );
        individualDto.setAddressRegistration( addressToAddressDto( domainModel.getAddressRegistration() ) );
        individualDto.setAddressLocation( addressToAddressDto( domainModel.getAddressLocation() ) );

        return individualDto.create();
    }

    @Override
    public Individual toDomainModel(IndividualDto dto) {
        if ( dto == null ) {
            return null;
        }

        IndividualBuilder individual = IndividualBuilder.builder();

        individual.setBlockDate( customConverter.zonedDateTimeToTimestamp( dtoBlockBlockDate( dto ) ) );
        individual.setIsBlock( dtoBlockIsBlock( dto ) );
        individual.setBlockUser( dtoBlockBlockUser( dto ) );
        individual.setId( dto.getId() );
        individual.setVersion( dto.getVersion() );
        individual.setAddressLocation( addressDtoToAddress( dto.getAddressLocation() ) );
        individual.setAddressRegistration( addressDtoToAddress( dto.getAddressRegistration() ) );

        return individual.create();
    }

    protected BlockingInfoDto individualToBlockingInfoDto(Individual individual) {
        if ( individual == null ) {
            return null;
        }

        BlockingInfoDtoBuilder blockingInfoDto = BlockingInfoDtoBuilder.builder();

        blockingInfoDto.setIsBlock( individual.isBlock );
        blockingInfoDto.setBlockUser( individual.getBlockUser() );
        blockingInfoDto.setBlockDate( customConverter.timestampToZonedDateTime( individual.getBlockDate() ) );

        return blockingInfoDto.create();
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDtoBuilder addressDto = AddressDtoBuilder.builder();

        addressDto.setAddressType( address.getAddressType() );

        return addressDto.create();
    }

    private ZonedDateTime dtoBlockBlockDate(IndividualDto individualDto) {
        if ( individualDto == null ) {
            return null;
        }
        BlockingInfoDto block = individualDto.getBlock();
        if ( block == null ) {
            return null;
        }
        ZonedDateTime blockDate = block.getBlockDate();
        if ( blockDate == null ) {
            return null;
        }
        return blockDate;
    }

    private boolean dtoBlockIsBlock(IndividualDto individualDto) {
        if ( individualDto == null ) {
            return false;
        }
        BlockingInfoDto block = individualDto.getBlock();
        if ( block == null ) {
            return false;
        }
        boolean isBlock = block.isBlock;
        return isBlock;
    }

    private UUID dtoBlockBlockUser(IndividualDto individualDto) {
        if ( individualDto == null ) {
            return null;
        }
        BlockingInfoDto block = individualDto.getBlock();
        if ( block == null ) {
            return null;
        }
        UUID blockUser = block.getBlockUser();
        if ( blockUser == null ) {
            return null;
        }
        return blockUser;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        AddressBuilder address = AddressBuilder.builder();

        address.setAddressType( addressDto.getAddressType() );

        return address.create();
    }
}
