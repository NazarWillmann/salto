package ooo.jtc.dictionaries.bankinfo.applicationurl;

import java.lang.Integer;
import java.lang.String;
import java.util.UUID;

public final class BankInfoApplicationUrlBuilder {
  private UUID id;

  private int version;

  private UUID bankId;

  private String name;

  private String appType;

  private String storeType;

  private String downloadUrl;

  private Integer ordering;

  public BankInfoApplicationUrlBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankInfoApplicationUrlBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankInfoApplicationUrlBuilder setBankId(UUID bankId) {
    this.bankId = bankId;
    return this;
  }

  public BankInfoApplicationUrlBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public BankInfoApplicationUrlBuilder setAppType(String appType) {
    this.appType = appType;
    return this;
  }

  public BankInfoApplicationUrlBuilder setStoreType(String storeType) {
    this.storeType = storeType;
    return this;
  }

  public BankInfoApplicationUrlBuilder setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
    return this;
  }

  public BankInfoApplicationUrlBuilder setOrdering(Integer ordering) {
    this.ordering = ordering;
    return this;
  }

  public BankInfoApplicationUrl create() {
    return new BankInfoApplicationUrl(id, version, bankId, name, appType, storeType, downloadUrl, ordering);
  }

  public static BankInfoApplicationUrlBuilder builder() {
    return new BankInfoApplicationUrlBuilder();
  }
}
