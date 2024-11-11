package ooo.jtc.dictionaries.common.phoneinfo;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class PhoneInfoMapperImpl implements PhoneInfoMapper {

    @Override
    public PhoneInfo toDomainModel(PhoneInfoDto dto) {
        if ( dto == null ) {
            return null;
        }

        PhoneInfoBuilder phoneInfo = PhoneInfoBuilder.builder();

        phoneInfo.setId( dto.getId() );
        phoneInfo.setVersion( dto.getVersion() );
        phoneInfo.setOwnerId( dto.getOwnerId() );
        phoneInfo.setSupportType( dto.getSupportType() );
        phoneInfo.setPhoneType( dto.getPhoneType() );
        phoneInfo.setPhone( dto.getPhone() );

        return phoneInfo.create();
    }

    @Override
    public PhoneInfoDto toDto(PhoneInfo domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        PhoneInfoDtoBuilder phoneInfoDto = PhoneInfoDtoBuilder.builder();

        phoneInfoDto.setId( domainModel.getId() );
        phoneInfoDto.setVersion( domainModel.getVersion() );
        phoneInfoDto.setOwnerId( domainModel.getOwnerId() );
        phoneInfoDto.setSupportType( domainModel.getSupportType() );
        phoneInfoDto.setPhoneType( domainModel.getPhoneType() );
        phoneInfoDto.setPhone( domainModel.getPhone() );

        return phoneInfoDto.create();
    }
}
