package ooo.jtc.dictionaries.budgetpayerstatus;

import java.lang.String;
import java.util.UUID;

public final class BudgetPayerStatusDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  public BudgetPayerStatusDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BudgetPayerStatusDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BudgetPayerStatusDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public BudgetPayerStatusDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BudgetPayerStatusDto create() {
    return new BudgetPayerStatusDto(id, version, code, description);
  }

  public static BudgetPayerStatusDtoBuilder builder() {
    return new BudgetPayerStatusDtoBuilder();
  }
}
