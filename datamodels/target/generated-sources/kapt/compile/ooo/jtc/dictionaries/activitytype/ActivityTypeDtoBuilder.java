package ooo.jtc.dictionaries.activitytype;

import java.lang.String;
import java.util.UUID;

public final class ActivityTypeDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  public ActivityTypeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ActivityTypeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ActivityTypeDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public ActivityTypeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ActivityTypeDto create() {
    return new ActivityTypeDto(id, version, code, description);
  }

  public static ActivityTypeDtoBuilder builder() {
    return new ActivityTypeDtoBuilder();
  }
}
