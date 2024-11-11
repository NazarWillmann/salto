package ooo.jtc.uaa.scope.mapper;

import javax.annotation.processing.Generated;
import ooo.jtc.uaa.scope.dto.ScopeDto;
import ooo.jtc.uaa.scope.dto.ScopeDtoBuilder;
import ooo.jtc.uaa.scope.model.Scope;
import ooo.jtc.uaa.scope.model.ScopeBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class ScopeMapperImpl implements ScopeMapper {

    @Override
    public Scope toDomainModel(ScopeDto dto) {
        if ( dto == null ) {
            return null;
        }

        ScopeBuilder scope = ScopeBuilder.builder();

        scope.setId( dto.getId() );
        scope.setVersion( dto.getVersion() );
        scope.setName( dto.getName() );
        scope.setUiName( dto.getUiName() );
        scope.setDescription( dto.getDescription() );
        scope.setResourceId( dto.getResourceId() );
        scope.setNeedApprove( dto.getNeedApprove() );

        return scope.create();
    }

    @Override
    public ScopeDto toDto(Scope domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        ScopeDtoBuilder scopeDto = ScopeDtoBuilder.builder();

        scopeDto.setId( domainModel.getId() );
        scopeDto.setVersion( domainModel.getVersion() );
        scopeDto.setResourceId( domainModel.getResourceId() );
        scopeDto.setName( domainModel.getName() );
        scopeDto.setUiName( domainModel.getUiName() );
        scopeDto.setDescription( domainModel.getDescription() );
        scopeDto.setNeedApprove( domainModel.getNeedApprove() );

        return scopeDto.create();
    }
}
