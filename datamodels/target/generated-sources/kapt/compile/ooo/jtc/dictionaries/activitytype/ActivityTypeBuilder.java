package ooo.jtc.dictionaries.activitytype;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class ActivityTypeBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public ActivityTypeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ActivityTypeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ActivityTypeBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public ActivityTypeBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ActivityTypeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public ActivityTypeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public ActivityType create() {
    return new ActivityType(id, version, code, description, createdAt, deletedAt);
  }

  public static ActivityTypeBuilder builder() {
    return new ActivityTypeBuilder();
  }
}
