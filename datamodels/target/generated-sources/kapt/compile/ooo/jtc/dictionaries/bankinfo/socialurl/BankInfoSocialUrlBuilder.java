package ooo.jtc.dictionaries.bankinfo.socialurl;

import java.lang.Integer;
import java.lang.String;
import java.util.UUID;

public final class BankInfoSocialUrlBuilder {
  private UUID id;

  private int version;

  private String name;

  private UUID bankId;

  private String socialType;

  private String socialUrl;

  private Integer ordering;

  public BankInfoSocialUrlBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankInfoSocialUrlBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankInfoSocialUrlBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public BankInfoSocialUrlBuilder setBankId(UUID bankId) {
    this.bankId = bankId;
    return this;
  }

  public BankInfoSocialUrlBuilder setSocialType(String socialType) {
    this.socialType = socialType;
    return this;
  }

  public BankInfoSocialUrlBuilder setSocialUrl(String socialUrl) {
    this.socialUrl = socialUrl;
    return this;
  }

  public BankInfoSocialUrlBuilder setOrdering(Integer ordering) {
    this.ordering = ordering;
    return this;
  }

  public BankInfoSocialUrl create() {
    return new BankInfoSocialUrl(id, version, name, bankId, socialType, socialUrl, ordering);
  }

  public static BankInfoSocialUrlBuilder builder() {
    return new BankInfoSocialUrlBuilder();
  }
}
