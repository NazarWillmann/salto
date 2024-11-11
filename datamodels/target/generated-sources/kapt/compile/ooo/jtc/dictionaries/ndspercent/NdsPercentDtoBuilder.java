package ooo.jtc.dictionaries.ndspercent;

import java.math.BigDecimal;
import java.util.UUID;

public final class NdsPercentDtoBuilder {
  private UUID id;

  private int version;

  private BigDecimal percent;

  private boolean isDefaultRuPayment;

  public NdsPercentDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public NdsPercentDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public NdsPercentDtoBuilder setPercent(BigDecimal percent) {
    this.percent = percent;
    return this;
  }

  public NdsPercentDtoBuilder setIsDefaultRuPayment(boolean isDefaultRuPayment) {
    this.isDefaultRuPayment = isDefaultRuPayment;
    return this;
  }

  public NdsPercentDto create() {
    return new NdsPercentDto(id, version, percent, isDefaultRuPayment);
  }

  public static NdsPercentDtoBuilder builder() {
    return new NdsPercentDtoBuilder();
  }
}
