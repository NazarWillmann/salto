package ooo.jtc.dictionaries.budgetreasoncode;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class BudgetReasonCodeBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private PayType payType;

  private String hint108;

  private String hint109;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public BudgetReasonCodeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BudgetReasonCodeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BudgetReasonCodeBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public BudgetReasonCodeBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BudgetReasonCodeBuilder setPayType(PayType payType) {
    this.payType = payType;
    return this;
  }

  public BudgetReasonCodeBuilder setHint108(String hint108) {
    this.hint108 = hint108;
    return this;
  }

  public BudgetReasonCodeBuilder setHint109(String hint109) {
    this.hint109 = hint109;
    return this;
  }

  public BudgetReasonCodeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public BudgetReasonCodeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public BudgetReasonCode create() {
    return new BudgetReasonCode(id, version, code, description, payType, hint108, hint109, createdAt, deletedAt);
  }

  public static BudgetReasonCodeBuilder builder() {
    return new BudgetReasonCodeBuilder();
  }
}
