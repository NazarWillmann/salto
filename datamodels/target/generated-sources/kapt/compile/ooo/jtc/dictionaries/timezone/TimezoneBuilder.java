package ooo.jtc.dictionaries.timezone;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class TimezoneBuilder {
  private UUID id;

  private int version;

  private String name;

  private int shift;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public TimezoneBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public TimezoneBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public TimezoneBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public TimezoneBuilder setShift(int shift) {
    this.shift = shift;
    return this;
  }

  public TimezoneBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public TimezoneBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Timezone create() {
    return new Timezone(id, version, name, shift, createdAt, deletedAt);
  }

  public static TimezoneBuilder builder() {
    return new TimezoneBuilder();
  }
}
