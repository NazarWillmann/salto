package ooo.jtc.dictionaries.customer;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import ooo.jtc.dictionaries.common.BlockingInfoDto;
import ooo.jtc.dictionaries.common.BlockingInfoDtoBuilder;
import ooo.jtc.dictionaries.common.address.Address;
import ooo.jtc.dictionaries.common.address.AddressBuilder;
import ooo.jtc.dictionaries.common.address.AddressDto;
import ooo.jtc.dictionaries.common.address.AddressDtoBuilder;
import ooo.jtc.dictionaries.customerkpp.CustomerKpp;
import ooo.jtc.dictionaries.customerkpp.CustomerKppBuilder;
import ooo.jtc.dictionaries.customerkpp.CustomerKppDto;
import ooo.jtc.dictionaries.customerkpp.CustomerKppDtoBuilder;
import ooo.jtc.dictionaries.customertype.CustomerType;
import ooo.jtc.dictionaries.customertype.CustomerTypeBuilder;
import ooo.jtc.dictionaries.customertype.CustomerTypeDto;
import ooo.jtc.dictionaries.customertype.CustomerTypeDtoBuilder;
import ooo.jtc.generic.CustomConverter;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class CustomerMapperImpl implements CustomerMapper {

    private final CustomConverter customConverter = new CustomConverter();

    @Override
    public CustomerDto toDto(Customer domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        CustomerDtoBuilder customerDto = CustomerDtoBuilder.builder();

        customerDto.setBlock( customerToBlockingInfoDto( domainModel ) );
        customerDto.setId( domainModel.getId() );
        customerDto.setVersion( domainModel.getVersion() );
        customerDto.setFullName( domainModel.getFullName() );
        customerDto.setShortName( domainModel.getShortName() );
        customerDto.setIntName( domainModel.getIntName() );
        customerDto.setIsResident( domainModel.isResident );
        customerDto.setInn( domainModel.getInn() );
        customerDto.setOkpo( domainModel.getOkpo() );
        customerDto.setOgrn( domainModel.getOgrn() );
        customerDto.setOgrnDate( domainModel.getOgrnDate() );
        customerDto.setEmail( domainModel.getEmail() );
        customerDto.setPhone( domainModel.getPhone() );
        customerDto.setDescription( domainModel.getDescription() );
        customerDto.setIsAgreed( domainModel.isAgreed );
        customerDto.setCountryDigitCode( domainModel.getCountryDigitCode() );
        customerDto.setOkopf( domainModel.getOkopf() );
        customerDto.setKpp( customerKppListToCustomerKppDtoList( domainModel.getKpp() ) );
        customerDto.setOkfs( domainModel.getOkfs() );
        customerDto.setAddressRegistration( addressToAddressDto( domainModel.getAddressRegistration() ) );
        customerDto.setAddressLocation( addressToAddressDto( domainModel.getAddressLocation() ) );
        customerDto.setCustomerTypeId( domainModel.getCustomerTypeId() );
        customerDto.setCustomerType( customerTypeToCustomerTypeDto( domainModel.getCustomerType() ) );

        return customerDto.create();
    }

    @Override
    public Customer toDomainModel(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        CustomerBuilder customer = CustomerBuilder.builder();

        customer.setBlockUserId( dtoBlockBlockUser( dto ) );
        customer.setBlockDate( customConverter.zonedDateTimeToTimestamp( dtoBlockBlockDate( dto ) ) );
        customer.setIsBlock( dtoBlockIsBlock( dto ) );
        customer.setId( dto.getId() );
        customer.setVersion( dto.getVersion() );
        customer.setShortName( dto.getShortName() );
        customer.setFullName( dto.getFullName() );
        customer.setIntName( dto.getIntName() );
        customer.setIsResident( dto.isResident );
        customer.setInn( dto.getInn() );
        customer.setOkopf( dto.getOkopf() );
        customer.setOkfs( dto.getOkfs() );
        customer.setOkpo( dto.getOkpo() );
        customer.setOgrn( dto.getOgrn() );
        customer.setOgrnDate( dto.getOgrnDate() );
        customer.setEmail( dto.getEmail() );
        customer.setPhone( dto.getPhone() );
        customer.setDescription( dto.getDescription() );
        customer.setIsAgreed( dto.isAgreed );
        customer.setCountryDigitCode( dto.getCountryDigitCode() );
        customer.setAddressLocation( addressDtoToAddress( dto.getAddressLocation() ) );
        customer.setAddressRegistration( addressDtoToAddress( dto.getAddressRegistration() ) );
        customer.setCustomerTypeId( dto.getCustomerTypeId() );
        customer.setCustomerType( customerTypeDtoToCustomerType( dto.getCustomerType() ) );
        customer.setKpp( customerKppDtoListToCustomerKppList( dto.getKpp() ) );

        return customer.create();
    }

    protected BlockingInfoDto customerToBlockingInfoDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        BlockingInfoDtoBuilder blockingInfoDto = BlockingInfoDtoBuilder.builder();

        blockingInfoDto.setIsBlock( customer.isBlock );
        blockingInfoDto.setBlockUser( customer.getBlockUserId() );
        blockingInfoDto.setBlockDate( customConverter.timestampToZonedDateTime( customer.getBlockDate() ) );

        return blockingInfoDto.create();
    }

    protected CustomerKppDto customerKppToCustomerKppDto(CustomerKpp customerKpp) {
        if ( customerKpp == null ) {
            return null;
        }

        CustomerKppDtoBuilder customerKppDto = CustomerKppDtoBuilder.builder();

        customerKppDto.setId( customerKpp.getId() );
        customerKppDto.setVersion( customerKpp.getVersion() );
        customerKppDto.setUnitName( customerKpp.getUnitName() );
        customerKppDto.setKpp( customerKpp.getKpp() );
        customerKppDto.setIsDefault( customerKpp.isDefault );

        return customerKppDto.create();
    }

    protected List<CustomerKppDto> customerKppListToCustomerKppDtoList(List<CustomerKpp> list) {
        if ( list == null ) {
            return null;
        }

        List<CustomerKppDto> list1 = new ArrayList<CustomerKppDto>( list.size() );
        for ( CustomerKpp customerKpp : list ) {
            list1.add( customerKppToCustomerKppDto( customerKpp ) );
        }

        return list1;
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDtoBuilder addressDto = AddressDtoBuilder.builder();

        addressDto.setAddressType( address.getAddressType() );

        return addressDto.create();
    }

    protected CustomerTypeDto customerTypeToCustomerTypeDto(CustomerType customerType) {
        if ( customerType == null ) {
            return null;
        }

        CustomerTypeDtoBuilder customerTypeDto = CustomerTypeDtoBuilder.builder();

        customerTypeDto.setId( customerType.getId() );
        customerTypeDto.setVersion( customerType.getVersion() );
        customerTypeDto.setName( customerType.getName() );
        customerTypeDto.setSystemName( customerType.getSystemName() );

        return customerTypeDto.create();
    }

    private UUID dtoBlockBlockUser(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }
        BlockingInfoDto block = customerDto.getBlock();
        if ( block == null ) {
            return null;
        }
        UUID blockUser = block.getBlockUser();
        if ( blockUser == null ) {
            return null;
        }
        return blockUser;
    }

    private ZonedDateTime dtoBlockBlockDate(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }
        BlockingInfoDto block = customerDto.getBlock();
        if ( block == null ) {
            return null;
        }
        ZonedDateTime blockDate = block.getBlockDate();
        if ( blockDate == null ) {
            return null;
        }
        return blockDate;
    }

    private boolean dtoBlockIsBlock(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return false;
        }
        BlockingInfoDto block = customerDto.getBlock();
        if ( block == null ) {
            return false;
        }
        boolean isBlock = block.isBlock;
        return isBlock;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        AddressBuilder address = AddressBuilder.builder();

        address.setAddressType( addressDto.getAddressType() );

        return address.create();
    }

    protected CustomerType customerTypeDtoToCustomerType(CustomerTypeDto customerTypeDto) {
        if ( customerTypeDto == null ) {
            return null;
        }

        CustomerTypeBuilder customerType = CustomerTypeBuilder.builder();

        customerType.setId( customerTypeDto.getId() );
        customerType.setVersion( customerTypeDto.getVersion() );
        customerType.setName( customerTypeDto.getName() );
        customerType.setSystemName( customerTypeDto.getSystemName() );

        return customerType.create();
    }

    protected CustomerKpp customerKppDtoToCustomerKpp(CustomerKppDto customerKppDto) {
        if ( customerKppDto == null ) {
            return null;
        }

        CustomerKppBuilder customerKpp = CustomerKppBuilder.builder();

        customerKpp.setId( customerKppDto.getId() );
        customerKpp.setVersion( customerKppDto.getVersion() );
        customerKpp.setUnitName( customerKppDto.getUnitName() );
        customerKpp.setKpp( customerKppDto.getKpp() );
        customerKpp.setIsDefault( customerKppDto.isDefault );

        return customerKpp.create();
    }

    protected List<CustomerKpp> customerKppDtoListToCustomerKppList(List<CustomerKppDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CustomerKpp> list1 = new ArrayList<CustomerKpp>( list.size() );
        for ( CustomerKppDto customerKppDto : list ) {
            list1.add( customerKppDtoToCustomerKpp( customerKppDto ) );
        }

        return list1;
    }
}
