package ooo.jtc.dictionaries.bankinfo.applicationurl;

import java.lang.Integer;
import java.lang.String;
import java.util.UUID;

public final class BankInfoApplicationUrlDtoBuilder {
  private UUID id;

  private int version;

  private UUID bankId;

  private String name;

  private String appType;

  private String storeType;

  private String downloadUrl;

  private Integer ordering;

  public BankInfoApplicationUrlDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankInfoApplicationUrlDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankInfoApplicationUrlDtoBuilder setBankId(UUID bankId) {
    this.bankId = bankId;
    return this;
  }

  public BankInfoApplicationUrlDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public BankInfoApplicationUrlDtoBuilder setAppType(String appType) {
    this.appType = appType;
    return this;
  }

  public BankInfoApplicationUrlDtoBuilder setStoreType(String storeType) {
    this.storeType = storeType;
    return this;
  }

  public BankInfoApplicationUrlDtoBuilder setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
    return this;
  }

  public BankInfoApplicationUrlDtoBuilder setOrdering(Integer ordering) {
    this.ordering = ordering;
    return this;
  }

  public BankInfoApplicationUrlDto create() {
    return new BankInfoApplicationUrlDto(id, version, bankId, name, appType, storeType, downloadUrl, ordering);
  }

  public static BankInfoApplicationUrlDtoBuilder builder() {
    return new BankInfoApplicationUrlDtoBuilder();
  }
}
