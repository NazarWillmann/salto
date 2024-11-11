package ooo.jtc.dictionaries.incometype;

import java.lang.Integer;
import java.lang.String;
import java.util.UUID;

public final class IncomeTypeDtoBuilder {
  private UUID id;

  private int version;

  private Integer code;

  private String name;

  private String description;

  public IncomeTypeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public IncomeTypeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public IncomeTypeDtoBuilder setCode(Integer code) {
    this.code = code;
    return this;
  }

  public IncomeTypeDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public IncomeTypeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public IncomeTypeDto create() {
    return new IncomeTypeDto(id, version, code, name, description);
  }

  public static IncomeTypeDtoBuilder builder() {
    return new IncomeTypeDtoBuilder();
  }
}
