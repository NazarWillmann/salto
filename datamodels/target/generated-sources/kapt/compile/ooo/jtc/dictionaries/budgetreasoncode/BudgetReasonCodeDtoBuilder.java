package ooo.jtc.dictionaries.budgetreasoncode;

import java.lang.String;
import java.util.UUID;

public final class BudgetReasonCodeDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private PayType payType;

  private String hint108;

  private String hint109;

  public BudgetReasonCodeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BudgetReasonCodeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BudgetReasonCodeDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public BudgetReasonCodeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BudgetReasonCodeDtoBuilder setPayType(PayType payType) {
    this.payType = payType;
    return this;
  }

  public BudgetReasonCodeDtoBuilder setHint108(String hint108) {
    this.hint108 = hint108;
    return this;
  }

  public BudgetReasonCodeDtoBuilder setHint109(String hint109) {
    this.hint109 = hint109;
    return this;
  }

  public BudgetReasonCodeDto create() {
    return new BudgetReasonCodeDto(id, version, code, description, payType, hint108, hint109);
  }

  public static BudgetReasonCodeDtoBuilder builder() {
    return new BudgetReasonCodeDtoBuilder();
  }
}
