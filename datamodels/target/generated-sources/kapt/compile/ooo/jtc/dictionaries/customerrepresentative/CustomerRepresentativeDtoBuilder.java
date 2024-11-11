package ooo.jtc.dictionaries.customerrepresentative;

import java.lang.String;
import java.util.UUID;
import ooo.jtc.dictionaries.common.BlockingInfoDto;

public final class CustomerRepresentativeDtoBuilder {
  private UUID id;

  private int version;

  private UUID customerId;

  private UUID userId;

  private String position;

  private String email;

  private String phone;

  private String description;

  private BlockingInfoDto block;

  public CustomerRepresentativeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CustomerRepresentativeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CustomerRepresentativeDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public CustomerRepresentativeDtoBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public CustomerRepresentativeDtoBuilder setPosition(String position) {
    this.position = position;
    return this;
  }

  public CustomerRepresentativeDtoBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerRepresentativeDtoBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public CustomerRepresentativeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public CustomerRepresentativeDtoBuilder setBlock(BlockingInfoDto block) {
    this.block = block;
    return this;
  }

  public CustomerRepresentativeDto create() {
    return new CustomerRepresentativeDto(id, version, customerId, userId, position, email, phone, description, block);
  }

  public static CustomerRepresentativeDtoBuilder builder() {
    return new CustomerRepresentativeDtoBuilder();
  }
}
