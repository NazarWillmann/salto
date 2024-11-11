package ooo.jtc.dictionaries.customertype;

import java.lang.String;
import java.util.UUID;

public final class CustomerTypeDtoBuilder {
  private UUID id;

  private int version;

  private String name;

  private String systemName;

  public CustomerTypeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CustomerTypeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CustomerTypeDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CustomerTypeDtoBuilder setSystemName(String systemName) {
    this.systemName = systemName;
    return this;
  }

  public CustomerTypeDto create() {
    return new CustomerTypeDto(id, version, name, systemName);
  }

  public static CustomerTypeDtoBuilder builder() {
    return new CustomerTypeDtoBuilder();
  }
}
