package ooo.jtc.uaa.catalog.mapper;

import javax.annotation.processing.Generated;
import ooo.jtc.uaa.catalog.dto.CatalogDto;
import ooo.jtc.uaa.catalog.dto.CatalogDtoBuilder;
import ooo.jtc.uaa.catalog.model.Catalog;
import ooo.jtc.uaa.catalog.model.CatalogBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class CatalogMapperImpl implements CatalogMapper {

    @Override
    public Catalog toDomainModel(CatalogDto dto) {
        if ( dto == null ) {
            return null;
        }

        CatalogBuilder catalog = CatalogBuilder.builder();

        catalog.setId( dto.getId() );
        catalog.setVersion( dto.getVersion() );
        catalog.setName( dto.getName() );
        catalog.setCatalogKind( dto.getCatalogKind() );
        catalog.setCatalogType( dto.getCatalogType() );
        catalog.setAppearance( dto.getAppearance() );
        catalog.setTitle( dto.getTitle() );
        catalog.setDescription( dto.getDescription() );
        catalog.setEnabled( dto.getEnabled() );

        return catalog.create();
    }

    @Override
    public CatalogDto toDto(Catalog domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        CatalogDtoBuilder catalogDto = CatalogDtoBuilder.builder();

        catalogDto.setId( domainModel.getId() );
        catalogDto.setVersion( domainModel.getVersion() );
        catalogDto.setCatalogType( domainModel.getCatalogType() );
        catalogDto.setCatalogKind( domainModel.getCatalogKind() );
        catalogDto.setName( domainModel.getName() );
        catalogDto.setTitle( domainModel.getTitle() );
        catalogDto.setAppearance( domainModel.getAppearance() );
        catalogDto.setDescription( domainModel.getDescription() );
        catalogDto.setEnabled( domainModel.getEnabled() );

        return catalogDto.create();
    }
}
