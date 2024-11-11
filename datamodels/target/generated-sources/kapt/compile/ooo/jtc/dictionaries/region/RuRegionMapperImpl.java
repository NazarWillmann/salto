package ooo.jtc.dictionaries.region;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class RuRegionMapperImpl implements RuRegionMapper {

    @Override
    public RuRegion toDomainModel(RuRegionDto dto) {
        if ( dto == null ) {
            return null;
        }

        RuRegionBuilder ruRegion = RuRegionBuilder.builder();

        ruRegion.setId( dto.getId() );
        ruRegion.setVersion( dto.getVersion() );
        ruRegion.setCode( dto.getCode() );
        ruRegion.setName( dto.getName() );

        return ruRegion.create();
    }

    @Override
    public RuRegionDto toDto(RuRegion domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        RuRegionDtoBuilder ruRegionDto = RuRegionDtoBuilder.builder();

        ruRegionDto.setId( domainModel.getId() );
        ruRegionDto.setVersion( domainModel.getVersion() );
        ruRegionDto.setCode( domainModel.getCode() );
        ruRegionDto.setName( domainModel.getName() );

        return ruRegionDto.create();
    }
}
