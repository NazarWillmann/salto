package ooo.jtc.dictionaries.branchrepresentative;

import java.lang.String;
import java.util.UUID;
import ooo.jtc.dictionaries.common.BlockingInfoDto;

public final class BranchRepresentativeDtoBuilder {
  private UUID id;

  private int version;

  private UUID branchId;

  private UUID userId;

  private String position;

  private String email;

  private String phone;

  private BlockingInfoDto block;

  private String description;

  public BranchRepresentativeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BranchRepresentativeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BranchRepresentativeDtoBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public BranchRepresentativeDtoBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public BranchRepresentativeDtoBuilder setPosition(String position) {
    this.position = position;
    return this;
  }

  public BranchRepresentativeDtoBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public BranchRepresentativeDtoBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public BranchRepresentativeDtoBuilder setBlock(BlockingInfoDto block) {
    this.block = block;
    return this;
  }

  public BranchRepresentativeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BranchRepresentativeDto create() {
    return new BranchRepresentativeDto(id, version, branchId, userId, position, email, phone, block, description);
  }

  public static BranchRepresentativeDtoBuilder builder() {
    return new BranchRepresentativeDtoBuilder();
  }
}
