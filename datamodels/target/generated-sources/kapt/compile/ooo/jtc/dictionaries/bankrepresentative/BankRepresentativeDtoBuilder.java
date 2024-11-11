package ooo.jtc.dictionaries.bankrepresentative;

import java.lang.String;
import java.util.UUID;
import ooo.jtc.dictionaries.common.BlockingInfoDto;

public final class BankRepresentativeDtoBuilder {
  private UUID id;

  private int version;

  private UUID bankId;

  private UUID userId;

  private String position;

  private String email;

  private String phone;

  private BlockingInfoDto block;

  private String description;

  public BankRepresentativeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankRepresentativeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankRepresentativeDtoBuilder setBankId(UUID bankId) {
    this.bankId = bankId;
    return this;
  }

  public BankRepresentativeDtoBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public BankRepresentativeDtoBuilder setPosition(String position) {
    this.position = position;
    return this;
  }

  public BankRepresentativeDtoBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public BankRepresentativeDtoBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public BankRepresentativeDtoBuilder setBlock(BlockingInfoDto block) {
    this.block = block;
    return this;
  }

  public BankRepresentativeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BankRepresentativeDto create() {
    return new BankRepresentativeDto(id, version, bankId, userId, position, email, phone, block, description);
  }

  public static BankRepresentativeDtoBuilder builder() {
    return new BankRepresentativeDtoBuilder();
  }
}
