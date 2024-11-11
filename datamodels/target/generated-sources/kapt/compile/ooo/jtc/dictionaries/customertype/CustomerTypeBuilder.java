package ooo.jtc.dictionaries.customertype;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class CustomerTypeBuilder {
  private UUID id;

  private int version;

  private String name;

  private String systemName;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public CustomerTypeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CustomerTypeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CustomerTypeBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CustomerTypeBuilder setSystemName(String systemName) {
    this.systemName = systemName;
    return this;
  }

  public CustomerTypeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public CustomerTypeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public CustomerType create() {
    return new CustomerType(id, version, name, systemName, createdAt, deletedAt);
  }

  public static CustomerTypeBuilder builder() {
    return new CustomerTypeBuilder();
  }
}
