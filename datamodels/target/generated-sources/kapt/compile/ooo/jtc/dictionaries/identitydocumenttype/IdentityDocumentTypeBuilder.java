package ooo.jtc.dictionaries.identitydocumenttype;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class IdentityDocumentTypeBuilder {
  private UUID id;

  private int version;

  private String name;

  private String systemName;

  private UsageLimit usageLimit;

  private String typeCode;

  private boolean isHidden;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public IdentityDocumentTypeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public IdentityDocumentTypeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public IdentityDocumentTypeBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public IdentityDocumentTypeBuilder setSystemName(String systemName) {
    this.systemName = systemName;
    return this;
  }

  public IdentityDocumentTypeBuilder setUsageLimit(UsageLimit usageLimit) {
    this.usageLimit = usageLimit;
    return this;
  }

  public IdentityDocumentTypeBuilder setTypeCode(String typeCode) {
    this.typeCode = typeCode;
    return this;
  }

  public IdentityDocumentTypeBuilder setIsHidden(boolean isHidden) {
    this.isHidden = isHidden;
    return this;
  }

  public IdentityDocumentTypeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public IdentityDocumentTypeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public IdentityDocumentType create() {
    return new IdentityDocumentType(id, version, name, systemName, usageLimit, typeCode, isHidden, createdAt, deletedAt);
  }

  public static IdentityDocumentTypeBuilder builder() {
    return new IdentityDocumentTypeBuilder();
  }
}
