package ooo.jtc.uaa.catalog.mapper

import ooo.jtc.interfaces.AbstractDtoMapper
import ooo.jtc.uaa.catalog.dto.CatalogDto
import ooo.jtc.uaa.catalog.model.Catalog
import org.mapstruct.Mapper

@Mapper
interface CatalogMapper : AbstractDtoMapper<Catalog, CatalogDto>