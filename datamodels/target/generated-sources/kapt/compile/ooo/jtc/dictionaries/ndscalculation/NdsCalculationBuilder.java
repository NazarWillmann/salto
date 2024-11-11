package ooo.jtc.dictionaries.ndscalculation;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class NdsCalculationBuilder {
  private UUID id;

  private int version;

  private int code;

  private String description;

  private String template;

  private boolean isDefaultRuPayment;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public NdsCalculationBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public NdsCalculationBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public NdsCalculationBuilder setCode(int code) {
    this.code = code;
    return this;
  }

  public NdsCalculationBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public NdsCalculationBuilder setTemplate(String template) {
    this.template = template;
    return this;
  }

  public NdsCalculationBuilder setIsDefaultRuPayment(boolean isDefaultRuPayment) {
    this.isDefaultRuPayment = isDefaultRuPayment;
    return this;
  }

  public NdsCalculationBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public NdsCalculationBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public NdsCalculation create() {
    return new NdsCalculation(id, version, code, description, template, isDefaultRuPayment, createdAt, deletedAt);
  }

  public static NdsCalculationBuilder builder() {
    return new NdsCalculationBuilder();
  }
}
