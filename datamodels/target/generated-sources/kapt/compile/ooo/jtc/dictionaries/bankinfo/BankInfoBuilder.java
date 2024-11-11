package ooo.jtc.dictionaries.bankinfo;

import java.lang.String;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.bankinfo.applicationurl.BankInfoApplicationUrl;
import ooo.jtc.dictionaries.bankinfo.socialurl.BankInfoSocialUrl;
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfo;

public final class BankInfoBuilder {
  private UUID id;

  private int version;

  private String fullName;

  private String shortName;

  private String licenseType;

  private String license;

  private String inn;

  private UUID logoFileId;

  private String website;

  private String uiSettings;

  private String description;

  private List<PhoneInfo> phoneSupports;

  private List<BankInfoSocialUrl> socialUrls;

  private List<BankInfoApplicationUrl> applicationUrls;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public BankInfoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankInfoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankInfoBuilder setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public BankInfoBuilder setShortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

  public BankInfoBuilder setLicenseType(String licenseType) {
    this.licenseType = licenseType;
    return this;
  }

  public BankInfoBuilder setLicense(String license) {
    this.license = license;
    return this;
  }

  public BankInfoBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public BankInfoBuilder setLogoFileId(UUID logoFileId) {
    this.logoFileId = logoFileId;
    return this;
  }

  public BankInfoBuilder setWebsite(String website) {
    this.website = website;
    return this;
  }

  public BankInfoBuilder setUiSettings(String uiSettings) {
    this.uiSettings = uiSettings;
    return this;
  }

  public BankInfoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BankInfoBuilder setPhoneSupports(List<PhoneInfo> phoneSupports) {
    this.phoneSupports = phoneSupports;
    return this;
  }

  public BankInfoBuilder setSocialUrls(List<BankInfoSocialUrl> socialUrls) {
    this.socialUrls = socialUrls;
    return this;
  }

  public BankInfoBuilder setApplicationUrls(List<BankInfoApplicationUrl> applicationUrls) {
    this.applicationUrls = applicationUrls;
    return this;
  }

  public BankInfoBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public BankInfoBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public BankInfo create() {
    return new BankInfo(id, version, fullName, shortName, licenseType, license, inn, logoFileId, website, uiSettings, description, phoneSupports, socialUrls, applicationUrls, createdAt, deletedAt);
  }

  public static BankInfoBuilder builder() {
    return new BankInfoBuilder();
  }
}
