package ooo.jtc.dictionaries.ndscalculation;

import java.lang.String;
import java.util.UUID;

public final class NdsCalculationDtoBuilder {
  private UUID id;

  private int version;

  private int code;

  private String description;

  private String template;

  private boolean isDefaultRuPayment;

  public NdsCalculationDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public NdsCalculationDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public NdsCalculationDtoBuilder setCode(int code) {
    this.code = code;
    return this;
  }

  public NdsCalculationDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public NdsCalculationDtoBuilder setTemplate(String template) {
    this.template = template;
    return this;
  }

  public NdsCalculationDtoBuilder setIsDefaultRuPayment(boolean isDefaultRuPayment) {
    this.isDefaultRuPayment = isDefaultRuPayment;
    return this;
  }

  public NdsCalculationDto create() {
    return new NdsCalculationDto(id, version, code, description, template, isDefaultRuPayment);
  }

  public static NdsCalculationDtoBuilder builder() {
    return new NdsCalculationDtoBuilder();
  }
}
