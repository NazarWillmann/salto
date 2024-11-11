package ooo.jtc.uaa.application.dto;

import java.lang.Boolean;
import java.lang.String;

public final class ApplicationLoginSiteDtoBuilder {
  private String baseUrl;

  private String loginPath;

  private String approvePath;

  private String mfaPath;

  private String smsMfaPath;

  private Boolean paramsViaFragment;

  public ApplicationLoginSiteDtoBuilder setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
    return this;
  }

  public ApplicationLoginSiteDtoBuilder setLoginPath(String loginPath) {
    this.loginPath = loginPath;
    return this;
  }

  public ApplicationLoginSiteDtoBuilder setApprovePath(String approvePath) {
    this.approvePath = approvePath;
    return this;
  }

  public ApplicationLoginSiteDtoBuilder setMfaPath(String mfaPath) {
    this.mfaPath = mfaPath;
    return this;
  }

  public ApplicationLoginSiteDtoBuilder setSmsMfaPath(String smsMfaPath) {
    this.smsMfaPath = smsMfaPath;
    return this;
  }

  public ApplicationLoginSiteDtoBuilder setParamsViaFragment(Boolean paramsViaFragment) {
    this.paramsViaFragment = paramsViaFragment;
    return this;
  }

  public ApplicationLoginSiteDto create() {
    return new ApplicationLoginSiteDto(baseUrl, loginPath, approvePath, mfaPath, smsMfaPath, paramsViaFragment);
  }

  public static ApplicationLoginSiteDtoBuilder builder() {
    return new ApplicationLoginSiteDtoBuilder();
  }
}
