package ooo.jtc.rolemodel.trees;

import java.lang.String;
import java.util.List;
import java.util.UUID;

public final class ProductTreeDtoBuilder {
  private UUID id;

  private String name;

  private String uiName;

  private String description;

  private boolean included;

  private List<AccessObjectTreeDto> accessObjects;

  public ProductTreeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ProductTreeDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ProductTreeDtoBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public ProductTreeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ProductTreeDtoBuilder setIncluded(boolean included) {
    this.included = included;
    return this;
  }

  public ProductTreeDtoBuilder setAccessObjects(List<AccessObjectTreeDto> accessObjects) {
    this.accessObjects = accessObjects;
    return this;
  }

  public ProductTreeDto create() {
    return new ProductTreeDto(id, name, uiName, description, included, accessObjects);
  }

  public static ProductTreeDtoBuilder builder() {
    return new ProductTreeDtoBuilder();
  }
}
