package ooo.jtc.uaa.application.mapper

import ooo.jtc.interfaces.AbstractDtoMapper
import ooo.jtc.uaa.application.dto.ApplicationDto
import ooo.jtc.uaa.application.model.Application
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper
interface ApplicationMapper : AbstractDtoMapper<Application, ApplicationDto> {

    @Mappings(
        Mapping(source = "autoApprove", target = "autoApproveScopes"),
        Mapping(source = "baseUrl", target = "loginSite.baseUrl"),
        Mapping(source = "loginPath", target = "loginSite.loginPath"),
        Mapping(source = "approvePath", target = "loginSite.approvePath"),
        Mapping(source = "mfaPath", target = "loginSite.mfaPath"),
        Mapping(source = "smsMfaPath", target = "loginSite.smsMfaPath"),
        Mapping(source = "paramsViaFragment", target = "loginSite.paramsViaFragment")
    )
    override fun toDto(domainModel: Application): ApplicationDto

    @InheritInverseConfiguration
    override fun toDomainModel(dto: ApplicationDto): Application
}