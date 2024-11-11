package ooo.jtc.api.uaa.steps

import ooo.jtc.api.common.steps.AbstractUaaManagementSteps
import ooo.jtc.uaa.catalog.dto.CatalogDto

class CatalogSteps : AbstractUaaManagementSteps<CatalogDto, CatalogDto>(
    entity = CatalogDto::class.java,
    managementName = "Catalog"
)