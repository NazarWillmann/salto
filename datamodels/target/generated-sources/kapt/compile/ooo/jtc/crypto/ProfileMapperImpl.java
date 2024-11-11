package ooo.jtc.crypto;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public Profile toDomainModel(ProfileDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProfileBuilder profile = ProfileBuilder.builder();

        profile.setId( dto.getId() );
        profile.setVersion( dto.getVersion() );
        profile.setAuthOnly( dto.getAuthOnly() );
        profile.setProfileType( dto.getProfileType() );
        profile.setState( dto.getState() );
        profile.setUserId( dto.getUserId() );

        return profile.create();
    }

    @Override
    public ProfileDto toDto(Profile domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        ProfileDtoBuilder profileDto = ProfileDtoBuilder.builder();

        profileDto.setId( domainModel.getId() );
        profileDto.setVersion( domainModel.getVersion() );
        profileDto.setAuthOnly( domainModel.getAuthOnly() );
        profileDto.setProfileType( domainModel.getProfileType() );
        profileDto.setState( domainModel.getState() );
        profileDto.setUserId( domainModel.getUserId() );

        return profileDto.create();
    }
}
