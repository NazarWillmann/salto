package ooo.jtc.dictionaries.bankinfo;

import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import ooo.jtc.dictionaries.bankinfo.applicationurl.BankInfoApplicationUrlDto;
import ooo.jtc.dictionaries.bankinfo.socialurl.BankInfoSocialUrlDto;
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfoDto;

public final class BankInfoDtoBuilder {
  private UUID id;

  private int version;

  private String fullName;

  private String shortName;

  private List<PhoneInfoDto> phoneSupports;

  private String licenseType;

  private String license;

  private String inn;

  private UUID logoFileId;

  private String logoAccessToken;

  private String website;

  private Map<String, ?> uiSettings;

  private List<BankInfoApplicationUrlDto> applicationUrls;

  private List<BankInfoSocialUrlDto> socialUrls;

  private String description;

  public BankInfoDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankInfoDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankInfoDtoBuilder setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public BankInfoDtoBuilder setShortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

  public BankInfoDtoBuilder setPhoneSupports(List<PhoneInfoDto> phoneSupports) {
    this.phoneSupports = phoneSupports;
    return this;
  }

  public BankInfoDtoBuilder setLicenseType(String licenseType) {
    this.licenseType = licenseType;
    return this;
  }

  public BankInfoDtoBuilder setLicense(String license) {
    this.license = license;
    return this;
  }

  public BankInfoDtoBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public BankInfoDtoBuilder setLogoFileId(UUID logoFileId) {
    this.logoFileId = logoFileId;
    return this;
  }

  public BankInfoDtoBuilder setLogoAccessToken(String logoAccessToken) {
    this.logoAccessToken = logoAccessToken;
    return this;
  }

  public BankInfoDtoBuilder setWebsite(String website) {
    this.website = website;
    return this;
  }

  public BankInfoDtoBuilder setUiSettings(Map<String, ?> uiSettings) {
    this.uiSettings = uiSettings;
    return this;
  }

  public BankInfoDtoBuilder setApplicationUrls(List<BankInfoApplicationUrlDto> applicationUrls) {
    this.applicationUrls = applicationUrls;
    return this;
  }

  public BankInfoDtoBuilder setSocialUrls(List<BankInfoSocialUrlDto> socialUrls) {
    this.socialUrls = socialUrls;
    return this;
  }

  public BankInfoDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BankInfoDto create() {
    return new BankInfoDto(id, version, fullName, shortName, phoneSupports, licenseType, license, inn, logoFileId, logoAccessToken, website, uiSettings, applicationUrls, socialUrls, description);
  }

  public static BankInfoDtoBuilder builder() {
    return new BankInfoDtoBuilder();
  }
}
