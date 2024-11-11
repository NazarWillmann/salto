package ooo.jtc.uaa.user.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import ooo.jtc.generic.CustomConverter;
import ooo.jtc.uaa.user.dto.UaaUserDto;
import ooo.jtc.uaa.user.dto.UaaUserDtoBuilder;
import ooo.jtc.uaa.user.dto.UserDetails;
import ooo.jtc.uaa.user.model.UaaUser;
import ooo.jtc.uaa.user.model.UaaUserBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class UaaUserMapperImpl implements UaaUserMapper {

    private final CustomConverter customConverter = new CustomConverter();

    @Override
    public UaaUserDto toDto(UaaUser domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        UaaUserDtoBuilder uaaUserDto = UaaUserDtoBuilder.builder();

        uaaUserDto.setUserDetails( uaaUserToUserDetails( domainModel ) );
        uaaUserDto.setPermanentBlocked( domainModel.getPermBlock() );
        uaaUserDto.setTemporaryBlockedUntil( customConverter.timestampToZonedDateTime( domainModel.getTempBlockUntil() ) );
        uaaUserDto.setTemporaryBlocked( domainModel.getTempBlock() );
        uaaUserDto.setPreferredLocale( domainModel.getPrefLocale() );
        uaaUserDto.setId( domainModel.getId() );
        uaaUserDto.setVersion( domainModel.getVersion() );
        uaaUserDto.setBlockReason( domainModel.getBlockReason() );
        uaaUserDto.setBlockUser( domainModel.getBlockUser() );
        List<UUID> list = domainModel.getScopes();
        if ( list != null ) {
            uaaUserDto.setScopes( new ArrayList<UUID>( list ) );
        }

        return uaaUserDto.create();
    }

    @Override
    public UaaUser toDomainModel(UaaUserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UaaUserBuilder uaaUser = UaaUserBuilder.builder();

        uaaUser.setFirstName( dtoUserDetailsFirstName( dto ) );
        uaaUser.setLastName( dtoUserDetailsLastName( dto ) );
        uaaUser.setTempBlockUntil( customConverter.zonedDateTimeToTimestamp( dto.getTemporaryBlockedUntil() ) );
        uaaUser.setPhoneNumber( dtoUserDetailsPhoneNumber( dto ) );
        uaaUser.setPrefLocale( dto.getPreferredLocale() );
        uaaUser.setMiddleName( dtoUserDetailsMiddleName( dto ) );
        uaaUser.setTempBlock( dto.getTemporaryBlocked() );
        uaaUser.setEmail( dtoUserDetailsEmail( dto ) );
        uaaUser.setPermBlock( dto.getPermanentBlocked() );
        uaaUser.setId( dto.getId() );
        uaaUser.setVersion( dto.getVersion() );
        uaaUser.setBlockReason( dto.getBlockReason() );
        uaaUser.setBlockUser( dto.getBlockUser() );
        List<UUID> list = dto.getScopes();
        if ( list != null ) {
            uaaUser.setScopes( new ArrayList<UUID>( list ) );
        }

        return uaaUser.create();
    }

    protected UserDetails uaaUserToUserDetails(UaaUser uaaUser) {
        if ( uaaUser == null ) {
            return null;
        }

        UserDetails userDetails = new UserDetails();

        userDetails.setFirstName( uaaUser.getFirstName() );
        userDetails.setEmail( uaaUser.getEmail() );
        userDetails.setLastName( uaaUser.getLastName() );
        userDetails.setPhoneNumber( uaaUser.getPhoneNumber() );
        userDetails.setMiddleName( uaaUser.getMiddleName() );

        return userDetails;
    }

    private String dtoUserDetailsFirstName(UaaUserDto uaaUserDto) {
        if ( uaaUserDto == null ) {
            return null;
        }
        UserDetails userDetails = uaaUserDto.getUserDetails();
        if ( userDetails == null ) {
            return null;
        }
        String firstName = userDetails.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String dtoUserDetailsLastName(UaaUserDto uaaUserDto) {
        if ( uaaUserDto == null ) {
            return null;
        }
        UserDetails userDetails = uaaUserDto.getUserDetails();
        if ( userDetails == null ) {
            return null;
        }
        String lastName = userDetails.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String dtoUserDetailsPhoneNumber(UaaUserDto uaaUserDto) {
        if ( uaaUserDto == null ) {
            return null;
        }
        UserDetails userDetails = uaaUserDto.getUserDetails();
        if ( userDetails == null ) {
            return null;
        }
        String phoneNumber = userDetails.getPhoneNumber();
        if ( phoneNumber == null ) {
            return null;
        }
        return phoneNumber;
    }

    private String dtoUserDetailsMiddleName(UaaUserDto uaaUserDto) {
        if ( uaaUserDto == null ) {
            return null;
        }
        UserDetails userDetails = uaaUserDto.getUserDetails();
        if ( userDetails == null ) {
            return null;
        }
        String middleName = userDetails.getMiddleName();
        if ( middleName == null ) {
            return null;
        }
        return middleName;
    }

    private String dtoUserDetailsEmail(UaaUserDto uaaUserDto) {
        if ( uaaUserDto == null ) {
            return null;
        }
        UserDetails userDetails = uaaUserDto.getUserDetails();
        if ( userDetails == null ) {
            return null;
        }
        String email = userDetails.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }
}
