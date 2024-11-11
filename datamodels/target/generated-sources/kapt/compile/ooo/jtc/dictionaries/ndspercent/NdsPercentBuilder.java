package ooo.jtc.dictionaries.ndspercent;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public final class NdsPercentBuilder {
  private UUID id;

  private int version;

  private BigDecimal percent;

  private boolean isDefaultRuPayment;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public NdsPercentBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public NdsPercentBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public NdsPercentBuilder setPercent(BigDecimal percent) {
    this.percent = percent;
    return this;
  }

  public NdsPercentBuilder setIsDefaultRuPayment(boolean isDefaultRuPayment) {
    this.isDefaultRuPayment = isDefaultRuPayment;
    return this;
  }

  public NdsPercentBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public NdsPercentBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public NdsPercent create() {
    return new NdsPercent(id, version, percent, isDefaultRuPayment, createdAt, deletedAt);
  }

  public static NdsPercentBuilder builder() {
    return new NdsPercentBuilder();
  }
}
