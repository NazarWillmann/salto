package ooo.jtc.dictionaries.budgetpayerstatus;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class BudgetPayerStatusBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public BudgetPayerStatusBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BudgetPayerStatusBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BudgetPayerStatusBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public BudgetPayerStatusBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BudgetPayerStatusBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public BudgetPayerStatusBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public BudgetPayerStatus create() {
    return new BudgetPayerStatus(id, version, code, description, createdAt, deletedAt);
  }

  public static BudgetPayerStatusBuilder builder() {
    return new BudgetPayerStatusBuilder();
  }
}
