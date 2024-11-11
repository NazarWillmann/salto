package ooo.jtc.dictionaries.timezone;

import java.lang.String;
import java.util.UUID;

public final class TimezoneDtoBuilder {
  private UUID id;

  private int version;

  private String name;

  private int shift;

  public TimezoneDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public TimezoneDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public TimezoneDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public TimezoneDtoBuilder setShift(int shift) {
    this.shift = shift;
    return this;
  }

  public TimezoneDto create() {
    return new TimezoneDto(id, version, name, shift);
  }

  public static TimezoneDtoBuilder builder() {
    return new TimezoneDtoBuilder();
  }
}
