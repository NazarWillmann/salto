package ooo.jtc.dictionaries.currency;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class CurrencyBuilder {
  private UUID id;

  private int version;

  private String digitCode;

  private String alphaCode;

  private String name;

  private String nameInOkv;

  private int minorUnitCount;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public CurrencyBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CurrencyBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CurrencyBuilder setDigitCode(String digitCode) {
    this.digitCode = digitCode;
    return this;
  }

  public CurrencyBuilder setAlphaCode(String alphaCode) {
    this.alphaCode = alphaCode;
    return this;
  }

  public CurrencyBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CurrencyBuilder setNameInOkv(String nameInOkv) {
    this.nameInOkv = nameInOkv;
    return this;
  }

  public CurrencyBuilder setMinorUnitCount(int minorUnitCount) {
    this.minorUnitCount = minorUnitCount;
    return this;
  }

  public CurrencyBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public CurrencyBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Currency create() {
    return new Currency(id, version, digitCode, alphaCode, name, nameInOkv, minorUnitCount, createdAt, deletedAt);
  }

  public static CurrencyBuilder builder() {
    return new CurrencyBuilder();
  }
}
