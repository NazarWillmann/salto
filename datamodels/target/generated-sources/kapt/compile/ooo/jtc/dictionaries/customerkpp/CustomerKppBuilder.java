package ooo.jtc.dictionaries.customerkpp;

import java.lang.String;
import java.time.Instant;
import java.util.UUID;

public final class CustomerKppBuilder {
  private UUID id;

  private int version;

  private UUID idCustomer;

  private String unitName;

  private String kpp;

  private boolean isDefault;

  private Instant createdAt;

  private Instant deletedAt;

  public CustomerKppBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CustomerKppBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CustomerKppBuilder setIdCustomer(UUID idCustomer) {
    this.idCustomer = idCustomer;
    return this;
  }

  public CustomerKppBuilder setUnitName(String unitName) {
    this.unitName = unitName;
    return this;
  }

  public CustomerKppBuilder setKpp(String kpp) {
    this.kpp = kpp;
    return this;
  }

  public CustomerKppBuilder setIsDefault(boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  public CustomerKppBuilder setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public CustomerKppBuilder setDeletedAt(Instant deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public CustomerKpp create() {
    return new CustomerKpp(id, version, idCustomer, unitName, kpp, isDefault, createdAt, deletedAt);
  }

  public static CustomerKppBuilder builder() {
    return new CustomerKppBuilder();
  }
}
