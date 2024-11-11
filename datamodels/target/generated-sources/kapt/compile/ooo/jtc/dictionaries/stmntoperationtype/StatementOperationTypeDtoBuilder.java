package ooo.jtc.dictionaries.stmntoperationtype;

import java.lang.String;
import java.util.UUID;

public final class StatementOperationTypeDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  public StatementOperationTypeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public StatementOperationTypeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public StatementOperationTypeDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public StatementOperationTypeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public StatementOperationTypeDto create() {
    return new StatementOperationTypeDto(id, version, code, description);
  }

  public static StatementOperationTypeDtoBuilder builder() {
    return new StatementOperationTypeDtoBuilder();
  }
}
