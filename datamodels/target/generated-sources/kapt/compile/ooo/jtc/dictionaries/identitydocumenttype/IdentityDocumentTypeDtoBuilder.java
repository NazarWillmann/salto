package ooo.jtc.dictionaries.identitydocumenttype;

import java.lang.String;
import java.util.UUID;

public final class IdentityDocumentTypeDtoBuilder {
  private UUID id;

  private int version;

  private String typeCode;

  private String name;

  private String systemName;

  private UsageLimit usageLimit;

  private boolean isHidden;

  public IdentityDocumentTypeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public IdentityDocumentTypeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public IdentityDocumentTypeDtoBuilder setTypeCode(String typeCode) {
    this.typeCode = typeCode;
    return this;
  }

  public IdentityDocumentTypeDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public IdentityDocumentTypeDtoBuilder setSystemName(String systemName) {
    this.systemName = systemName;
    return this;
  }

  public IdentityDocumentTypeDtoBuilder setUsageLimit(UsageLimit usageLimit) {
    this.usageLimit = usageLimit;
    return this;
  }

  public IdentityDocumentTypeDtoBuilder setIsHidden(boolean isHidden) {
    this.isHidden = isHidden;
    return this;
  }

  public IdentityDocumentTypeDto create() {
    return new IdentityDocumentTypeDto(id, version, typeCode, name, systemName, usageLimit, isHidden);
  }

  public static IdentityDocumentTypeDtoBuilder builder() {
    return new IdentityDocumentTypeDtoBuilder();
  }
}
