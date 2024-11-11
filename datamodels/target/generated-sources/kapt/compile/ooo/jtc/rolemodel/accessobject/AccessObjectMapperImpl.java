package ooo.jtc.rolemodel.accessobject;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class AccessObjectMapperImpl implements AccessObjectMapper {

    @Override
    public AccessObject toDomainModel(AccessObjectDto dto) {
        if ( dto == null ) {
            return null;
        }

        AccessObjectBuilder accessObject = AccessObjectBuilder.builder();

        accessObject.setId( dto.getId() );
        accessObject.setVersion( dto.getVersion() );
        accessObject.setName( dto.getName() );
        accessObject.setUiName( dto.getUiName() );
        accessObject.setDescription( dto.getDescription() );
        accessObject.setObjectTypeId( dto.getObjectTypeId() );
        accessObject.setProductId( dto.getProductId() );
        accessObject.setPath( dto.getPath() );
        accessObject.setHasControls( dto.getHasControls() );

        return accessObject.create();
    }

    @Override
    public AccessObjectDto toDto(AccessObject domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        AccessObjectDtoBuilder accessObjectDto = AccessObjectDtoBuilder.builder();

        accessObjectDto.setId( domainModel.getId() );
        accessObjectDto.setVersion( domainModel.getVersion() );
        accessObjectDto.setName( domainModel.getName() );
        accessObjectDto.setUiName( domainModel.getUiName() );
        accessObjectDto.setDescription( domainModel.getDescription() );
        accessObjectDto.setObjectTypeId( domainModel.getObjectTypeId() );
        accessObjectDto.setProductId( domainModel.getProductId() );
        accessObjectDto.setPath( domainModel.getPath() );
        accessObjectDto.setHasControls( domainModel.getHasControls() );

        return accessObjectDto.create();
    }
}
