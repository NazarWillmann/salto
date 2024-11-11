package ooo.jtc.dictionaries.locationtype;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class LocationTypeMapperImpl implements LocationTypeMapper {

    @Override
    public LocationType toDomainModel(LocationTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        LocationTypeBuilder locationType = LocationTypeBuilder.builder();

        locationType.setId( dto.getId() );
        locationType.setVersion( dto.getVersion() );
        locationType.setLocationType( dto.getLocationType() );
        locationType.setName( dto.getName() );
        locationType.setNameShort( dto.getNameShort() );

        return locationType.create();
    }

    @Override
    public LocationTypeDto toDto(LocationType domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        LocationTypeDtoBuilder locationTypeDto = LocationTypeDtoBuilder.builder();

        locationTypeDto.setId( domainModel.getId() );
        locationTypeDto.setVersion( domainModel.getVersion() );
        locationTypeDto.setLocationType( domainModel.getLocationType() );
        locationTypeDto.setName( domainModel.getName() );
        locationTypeDto.setNameShort( domainModel.getNameShort() );

        return locationTypeDto.create();
    }
}
