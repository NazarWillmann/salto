package ooo.jtc.dictionaries.timezone;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class TimezoneMapperImpl implements TimezoneMapper {

    @Override
    public Timezone toDomainModel(TimezoneDto dto) {
        if ( dto == null ) {
            return null;
        }

        TimezoneBuilder timezone = TimezoneBuilder.builder();

        timezone.setId( dto.getId() );
        timezone.setVersion( dto.getVersion() );
        timezone.setName( dto.getName() );
        timezone.setShift( dto.getShift() );

        return timezone.create();
    }

    @Override
    public TimezoneDto toDto(Timezone domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        TimezoneDtoBuilder timezoneDto = TimezoneDtoBuilder.builder();

        timezoneDto.setId( domainModel.getId() );
        timezoneDto.setVersion( domainModel.getVersion() );
        timezoneDto.setName( domainModel.getName() );
        timezoneDto.setShift( domainModel.getShift() );

        return timezoneDto.create();
    }
}
