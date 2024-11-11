package ooo.jtc.rolemodel.accessobject;

import java.lang.Boolean;
import java.lang.String;
import java.util.UUID;
import ooo.jtc.rolemodel.accessobjecttype.AccessObjectTypeDto;
import ooo.jtc.rolemodel.product.ProductDto;

public final class AccessObjectDtoBuilder {
  private UUID id;

  private int version;

  private String name;

  private String uiName;

  private String description;

  private UUID objectTypeId;

  private AccessObjectTypeDto objectType;

  private UUID productId;

  private ProductDto product;

  private String path;

  private Boolean hasControls;

  public AccessObjectDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public AccessObjectDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public AccessObjectDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public AccessObjectDtoBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public AccessObjectDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public AccessObjectDtoBuilder setObjectTypeId(UUID objectTypeId) {
    this.objectTypeId = objectTypeId;
    return this;
  }

  public AccessObjectDtoBuilder setObjectType(AccessObjectTypeDto objectType) {
    this.objectType = objectType;
    return this;
  }

  public AccessObjectDtoBuilder setProductId(UUID productId) {
    this.productId = productId;
    return this;
  }

  public AccessObjectDtoBuilder setProduct(ProductDto product) {
    this.product = product;
    return this;
  }

  public AccessObjectDtoBuilder setPath(String path) {
    this.path = path;
    return this;
  }

  public AccessObjectDtoBuilder setHasControls(Boolean hasControls) {
    this.hasControls = hasControls;
    return this;
  }

  public AccessObjectDto create() {
    return new AccessObjectDto(id, version, name, uiName, description, objectTypeId, objectType, productId, product, path, hasControls);
  }

  public static AccessObjectDtoBuilder builder() {
    return new AccessObjectDtoBuilder();
  }
}
