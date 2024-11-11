package ooo.jtc.dictionaries.residencypermitdocumenttype;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class ResidencyPermitDocumentTypeBuilder {
  private UUID id;

  private int version;

  private String name;

  private String systemName;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public ResidencyPermitDocumentTypeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ResidencyPermitDocumentTypeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ResidencyPermitDocumentTypeBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ResidencyPermitDocumentTypeBuilder setSystemName(String systemName) {
    this.systemName = systemName;
    return this;
  }

  public ResidencyPermitDocumentTypeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public ResidencyPermitDocumentTypeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public ResidencyPermitDocumentType create() {
    return new ResidencyPermitDocumentType(id, version, name, systemName, createdAt, deletedAt);
  }

  public static ResidencyPermitDocumentTypeBuilder builder() {
    return new ResidencyPermitDocumentTypeBuilder();
  }
}
