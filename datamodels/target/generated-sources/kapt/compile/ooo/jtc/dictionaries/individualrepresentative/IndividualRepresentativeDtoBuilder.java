package ooo.jtc.dictionaries.individualrepresentative;

import java.lang.String;
import java.util.UUID;
import ooo.jtc.dictionaries.common.BlockingInfoDto;

public final class IndividualRepresentativeDtoBuilder {
  private UUID id;

  private int version;

  private UUID userId;

  private UUID individualId;

  private BlockingInfoDto block;

  private String description;

  public IndividualRepresentativeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public IndividualRepresentativeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public IndividualRepresentativeDtoBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public IndividualRepresentativeDtoBuilder setIndividualId(UUID individualId) {
    this.individualId = individualId;
    return this;
  }

  public IndividualRepresentativeDtoBuilder setBlock(BlockingInfoDto block) {
    this.block = block;
    return this;
  }

  public IndividualRepresentativeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public IndividualRepresentativeDto create() {
    return new IndividualRepresentativeDto(id, version, userId, individualId, block, description);
  }

  public static IndividualRepresentativeDtoBuilder builder() {
    return new IndividualRepresentativeDtoBuilder();
  }
}
