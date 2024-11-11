package ooo.jtc.uaa.resource.mapper;

import javax.annotation.processing.Generated;
import ooo.jtc.uaa.resource.dto.ResourceDto;
import ooo.jtc.uaa.resource.dto.ResourceDtoBuilder;
import ooo.jtc.uaa.resource.model.Resource;
import ooo.jtc.uaa.resource.model.ResourceBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class ResourceMapperImpl implements ResourceMapper {

    @Override
    public Resource toDomainModel(ResourceDto dto) {
        if ( dto == null ) {
            return null;
        }

        ResourceBuilder resource = ResourceBuilder.builder();

        resource.setId( dto.getId() );
        resource.setVersion( dto.getVersion() );
        resource.setName( dto.getName() );
        resource.setAudience( dto.getAudience() );
        resource.setDescription( dto.getDescription() );

        return resource.create();
    }

    @Override
    public ResourceDto toDto(Resource domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        ResourceDtoBuilder resourceDto = ResourceDtoBuilder.builder();

        resourceDto.setId( domainModel.getId() );
        resourceDto.setVersion( domainModel.getVersion() );
        resourceDto.setName( domainModel.getName() );
        resourceDto.setDescription( domainModel.getDescription() );
        resourceDto.setAudience( domainModel.getAudience() );

        return resourceDto.create();
    }
}
