package ooo.jtc.dictionaries.common.extid;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:40+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class ExtIdMapperImpl implements ExtIdMapper {

    @Override
    public ExtId toDomainModel(ExtIdDto dto) {
        if ( dto == null ) {
            return null;
        }

        ExtIdBuilder extId = ExtIdBuilder.builder();

        extId.setId( dto.getId() );
        extId.setVersion( dto.getVersion() );
        extId.setOwnerId( dto.getOwnerId() );
        extId.setExtSystemId( dto.getExtSystemId() );
        extId.setExternalId( dto.getExternalId() );

        return extId.create();
    }

    @Override
    public ExtIdDto toDto(ExtId domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        ExtIdDtoBuilder extIdDto = ExtIdDtoBuilder.builder();

        extIdDto.setId( domainModel.getId() );
        extIdDto.setVersion( domainModel.getVersion() );
        extIdDto.setOwnerId( domainModel.getOwnerId() );
        extIdDto.setExtSystemId( domainModel.getExtSystemId() );
        extIdDto.setExternalId( domainModel.getExternalId() );

        return extIdDto.create();
    }
}
