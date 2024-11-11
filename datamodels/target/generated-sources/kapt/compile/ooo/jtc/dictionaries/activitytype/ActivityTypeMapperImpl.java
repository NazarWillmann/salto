package ooo.jtc.dictionaries.activitytype;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class ActivityTypeMapperImpl implements ActivityTypeMapper {

    @Override
    public ActivityType toDomainModel(ActivityTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        ActivityTypeBuilder activityType = ActivityTypeBuilder.builder();

        activityType.setId( dto.getId() );
        activityType.setVersion( dto.getVersion() );
        activityType.setCode( dto.getCode() );
        activityType.setDescription( dto.getDescription() );

        return activityType.create();
    }

    @Override
    public ActivityTypeDto toDto(ActivityType domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        ActivityTypeDtoBuilder activityTypeDto = ActivityTypeDtoBuilder.builder();

        activityTypeDto.setId( domainModel.getId() );
        activityTypeDto.setVersion( domainModel.getVersion() );
        activityTypeDto.setCode( domainModel.getCode() );
        activityTypeDto.setDescription( domainModel.getDescription() );

        return activityTypeDto.create();
    }
}
