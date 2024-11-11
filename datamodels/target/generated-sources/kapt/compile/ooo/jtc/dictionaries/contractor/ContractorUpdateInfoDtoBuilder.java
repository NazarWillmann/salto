package ooo.jtc.dictionaries.contractor;

import java.lang.Boolean;
import java.lang.String;
import java.util.UUID;

public final class ContractorUpdateInfoDtoBuilder {
  private UUID id;

  private int version;

  private String name;

  private String kpp;

  private String inn;

  private String description;

  private Boolean isFavorites;

  public ContractorUpdateInfoDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ContractorUpdateInfoDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ContractorUpdateInfoDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ContractorUpdateInfoDtoBuilder setKpp(String kpp) {
    this.kpp = kpp;
    return this;
  }

  public ContractorUpdateInfoDtoBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public ContractorUpdateInfoDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ContractorUpdateInfoDtoBuilder setIsFavorites(Boolean isFavorites) {
    this.isFavorites = isFavorites;
    return this;
  }

  public ContractorUpdateInfoDto create() {
    return new ContractorUpdateInfoDto(id, version, name, kpp, inn, description, isFavorites);
  }

  public static ContractorUpdateInfoDtoBuilder builder() {
    return new ContractorUpdateInfoDtoBuilder();
  }
}
