package ooo.jtc.dictionaries.uer;

import java.lang.String;
import java.util.UUID;
import ooo.jtc.dictionaries.bankru.BankType;

public final class UerDtoBuilder {
  private UUID id;

  private int version;

  private String uer;

  private BankType bankType;

  private String description;

  public UerDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public UerDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public UerDtoBuilder setUer(String uer) {
    this.uer = uer;
    return this;
  }

  public UerDtoBuilder setBankType(BankType bankType) {
    this.bankType = bankType;
    return this;
  }

  public UerDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public UerDto create() {
    return new UerDto(id, version, uer, bankType, description);
  }

  public static UerDtoBuilder builder() {
    return new UerDtoBuilder();
  }
}
