package ooo.jtc.rolemodel.product;

import java.lang.String;
import java.util.UUID;

public final class ProductDtoBuilder {
  private UUID id;

  private int version;

  private String name;

  private String uiName;

  private String description;

  private String path;

  public ProductDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ProductDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ProductDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ProductDtoBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public ProductDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ProductDtoBuilder setPath(String path) {
    this.path = path;
    return this;
  }

  public ProductDto create() {
    return new ProductDto(id, version, name, uiName, description, path);
  }

  public static ProductDtoBuilder builder() {
    return new ProductDtoBuilder();
  }
}
