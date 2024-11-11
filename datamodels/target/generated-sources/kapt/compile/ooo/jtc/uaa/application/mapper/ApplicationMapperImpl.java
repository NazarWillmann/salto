package ooo.jtc.uaa.application.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import ooo.jtc.uaa.application.dto.AllowedFlows;
import ooo.jtc.uaa.application.dto.ApplicationDto;
import ooo.jtc.uaa.application.dto.ApplicationDtoBuilder;
import ooo.jtc.uaa.application.dto.ApplicationLoginSiteDto;
import ooo.jtc.uaa.application.dto.ApplicationLoginSiteDtoBuilder;
import ooo.jtc.uaa.application.model.Application;
import ooo.jtc.uaa.application.model.ApplicationBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class ApplicationMapperImpl implements ApplicationMapper {

    @Override
    public ApplicationDto toDto(Application domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        ApplicationDtoBuilder applicationDto = ApplicationDtoBuilder.builder();

        applicationDto.setLoginSite( applicationToApplicationLoginSiteDto( domainModel ) );
        applicationDto.setAutoApproveScopes( domainModel.getAutoApprove() );
        applicationDto.setId( domainModel.getId() );
        applicationDto.setVersion( domainModel.getVersion() );
        applicationDto.setName( domainModel.getName() );
        applicationDto.setDescription( domainModel.getDescription() );
        List<AllowedFlows> list = domainModel.getAllowedFlows();
        if ( list != null ) {
            applicationDto.setAllowedFlows( new ArrayList<AllowedFlows>( list ) );
        }
        applicationDto.setRedirectUrls( domainModel.getRedirectUrls() );
        List<UUID> list1 = domainModel.getAvailableResources();
        if ( list1 != null ) {
            applicationDto.setAvailableResources( new ArrayList<UUID>( list1 ) );
        }
        List<UUID> list2 = domainModel.getAvailableCatalogs();
        if ( list2 != null ) {
            applicationDto.setAvailableCatalogs( new ArrayList<UUID>( list2 ) );
        }
        applicationDto.setAccessTokenLifeTime( domainModel.getAccessTokenLifeTime() );
        applicationDto.setRefreshTokenLifeTime( domainModel.getRefreshTokenLifeTime() );
        applicationDto.setSessionLifeTime( domainModel.getSessionLifeTime() );
        applicationDto.setClientId( domainModel.getClientId() );
        applicationDto.setClientSecret( domainModel.getClientSecret() );

        return applicationDto.create();
    }

    @Override
    public Application toDomainModel(ApplicationDto dto) {
        if ( dto == null ) {
            return null;
        }

        ApplicationBuilder application = ApplicationBuilder.builder();

        application.setBaseUrl( dtoLoginSiteBaseUrl( dto ) );
        application.setParamsViaFragment( dtoLoginSiteParamsViaFragment( dto ) );
        application.setApprovePath( dtoLoginSiteApprovePath( dto ) );
        application.setSmsMfaPath( dtoLoginSiteSmsMfaPath( dto ) );
        application.setLoginPath( dtoLoginSiteLoginPath( dto ) );
        application.setAutoApprove( dto.getAutoApproveScopes() );
        application.setMfaPath( dtoLoginSiteMfaPath( dto ) );
        application.setId( dto.getId() );
        application.setVersion( dto.getVersion() );
        application.setName( dto.getName() );
        application.setClientId( dto.getClientId() );
        application.setClientSecret( dto.getClientSecret() );
        application.setRedirectUrls( dto.getRedirectUrls() );
        application.setAccessTokenLifeTime( dto.getAccessTokenLifeTime() );
        application.setDescription( dto.getDescription() );
        application.setSessionLifeTime( dto.getSessionLifeTime() );
        application.setRefreshTokenLifeTime( dto.getRefreshTokenLifeTime() );
        List<AllowedFlows> list = dto.getAllowedFlows();
        if ( list != null ) {
            application.setAllowedFlows( new ArrayList<AllowedFlows>( list ) );
        }
        List<UUID> list1 = dto.getAvailableResources();
        if ( list1 != null ) {
            application.setAvailableResources( new ArrayList<UUID>( list1 ) );
        }
        List<UUID> list2 = dto.getAvailableCatalogs();
        if ( list2 != null ) {
            application.setAvailableCatalogs( new ArrayList<UUID>( list2 ) );
        }

        return application.create();
    }

    protected ApplicationLoginSiteDto applicationToApplicationLoginSiteDto(Application application) {
        if ( application == null ) {
            return null;
        }

        ApplicationLoginSiteDtoBuilder applicationLoginSiteDto = ApplicationLoginSiteDtoBuilder.builder();

        applicationLoginSiteDto.setBaseUrl( application.getBaseUrl() );
        applicationLoginSiteDto.setMfaPath( application.getMfaPath() );
        applicationLoginSiteDto.setApprovePath( application.getApprovePath() );
        applicationLoginSiteDto.setLoginPath( application.getLoginPath() );
        applicationLoginSiteDto.setParamsViaFragment( application.getParamsViaFragment() );
        applicationLoginSiteDto.setSmsMfaPath( application.getSmsMfaPath() );

        return applicationLoginSiteDto.create();
    }

    private String dtoLoginSiteBaseUrl(ApplicationDto applicationDto) {
        if ( applicationDto == null ) {
            return null;
        }
        ApplicationLoginSiteDto loginSite = applicationDto.getLoginSite();
        if ( loginSite == null ) {
            return null;
        }
        String baseUrl = loginSite.getBaseUrl();
        if ( baseUrl == null ) {
            return null;
        }
        return baseUrl;
    }

    private Boolean dtoLoginSiteParamsViaFragment(ApplicationDto applicationDto) {
        if ( applicationDto == null ) {
            return null;
        }
        ApplicationLoginSiteDto loginSite = applicationDto.getLoginSite();
        if ( loginSite == null ) {
            return null;
        }
        Boolean paramsViaFragment = loginSite.getParamsViaFragment();
        if ( paramsViaFragment == null ) {
            return null;
        }
        return paramsViaFragment;
    }

    private String dtoLoginSiteApprovePath(ApplicationDto applicationDto) {
        if ( applicationDto == null ) {
            return null;
        }
        ApplicationLoginSiteDto loginSite = applicationDto.getLoginSite();
        if ( loginSite == null ) {
            return null;
        }
        String approvePath = loginSite.getApprovePath();
        if ( approvePath == null ) {
            return null;
        }
        return approvePath;
    }

    private String dtoLoginSiteSmsMfaPath(ApplicationDto applicationDto) {
        if ( applicationDto == null ) {
            return null;
        }
        ApplicationLoginSiteDto loginSite = applicationDto.getLoginSite();
        if ( loginSite == null ) {
            return null;
        }
        String smsMfaPath = loginSite.getSmsMfaPath();
        if ( smsMfaPath == null ) {
            return null;
        }
        return smsMfaPath;
    }

    private String dtoLoginSiteLoginPath(ApplicationDto applicationDto) {
        if ( applicationDto == null ) {
            return null;
        }
        ApplicationLoginSiteDto loginSite = applicationDto.getLoginSite();
        if ( loginSite == null ) {
            return null;
        }
        String loginPath = loginSite.getLoginPath();
        if ( loginPath == null ) {
            return null;
        }
        return loginPath;
    }

    private String dtoLoginSiteMfaPath(ApplicationDto applicationDto) {
        if ( applicationDto == null ) {
            return null;
        }
        ApplicationLoginSiteDto loginSite = applicationDto.getLoginSite();
        if ( loginSite == null ) {
            return null;
        }
        String mfaPath = loginSite.getMfaPath();
        if ( mfaPath == null ) {
            return null;
        }
        return mfaPath;
    }
}
