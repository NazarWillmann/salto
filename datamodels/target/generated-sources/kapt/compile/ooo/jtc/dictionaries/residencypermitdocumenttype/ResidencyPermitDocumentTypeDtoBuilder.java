package ooo.jtc.dictionaries.residencypermitdocumenttype;

import java.lang.String;
import java.util.UUID;

public final class ResidencyPermitDocumentTypeDtoBuilder {
  private UUID id;

  private int version;

  private String name;

  private String systemName;

  public ResidencyPermitDocumentTypeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ResidencyPermitDocumentTypeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ResidencyPermitDocumentTypeDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ResidencyPermitDocumentTypeDtoBuilder setSystemName(String systemName) {
    this.systemName = systemName;
    return this;
  }

  public ResidencyPermitDocumentTypeDto create() {
    return new ResidencyPermitDocumentTypeDto(id, version, name, systemName);
  }

  public static ResidencyPermitDocumentTypeDtoBuilder builder() {
    return new ResidencyPermitDocumentTypeDtoBuilder();
  }
}
