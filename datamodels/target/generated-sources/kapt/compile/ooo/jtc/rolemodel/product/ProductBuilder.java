package ooo.jtc.rolemodel.product;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class ProductBuilder {
  private UUID id;

  private int version;

  private String name;

  private String uiName;

  private String description;

  private String path;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public ProductBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ProductBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ProductBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ProductBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public ProductBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ProductBuilder setPath(String path) {
    this.path = path;
    return this;
  }

  public ProductBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public ProductBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Product create() {
    return new Product(id, version, name, uiName, description, path, createdAt, deletedAt);
  }

  public static ProductBuilder builder() {
    return new ProductBuilder();
  }
}
