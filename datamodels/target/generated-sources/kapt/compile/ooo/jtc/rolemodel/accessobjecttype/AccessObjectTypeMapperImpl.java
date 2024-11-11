package ooo.jtc.rolemodel.accessobjecttype;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class AccessObjectTypeMapperImpl implements AccessObjectTypeMapper {

    @Override
    public AccessObjectType toDomainModel(AccessObjectTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        AccessObjectTypeBuilder accessObjectType = AccessObjectTypeBuilder.builder();

        accessObjectType.setId( dto.getId() );
        accessObjectType.setVersion( dto.getVersion() );
        accessObjectType.setName( dto.getName() );

        return accessObjectType.create();
    }

    @Override
    public AccessObjectTypeDto toDto(AccessObjectType domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        AccessObjectTypeDtoBuilder accessObjectTypeDto = AccessObjectTypeDtoBuilder.builder();

        accessObjectTypeDto.setId( domainModel.getId() );
        accessObjectTypeDto.setVersion( domainModel.getVersion() );
        accessObjectTypeDto.setName( domainModel.getName() );

        return accessObjectTypeDto.create();
    }
}
