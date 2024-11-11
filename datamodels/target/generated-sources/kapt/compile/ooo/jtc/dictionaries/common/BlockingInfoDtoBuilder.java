package ooo.jtc.dictionaries.common;

import java.time.ZonedDateTime;
import java.util.UUID;

public final class BlockingInfoDtoBuilder {
  private boolean isBlock;

  private UUID blockUser;

  private ZonedDateTime blockDate;

  public BlockingInfoDtoBuilder setIsBlock(boolean isBlock) {
    this.isBlock = isBlock;
    return this;
  }

  public BlockingInfoDtoBuilder setBlockUser(UUID blockUser) {
    this.blockUser = blockUser;
    return this;
  }

  public BlockingInfoDtoBuilder setBlockDate(ZonedDateTime blockDate) {
    this.blockDate = blockDate;
    return this;
  }

  public BlockingInfoDto create() {
    return new BlockingInfoDto(isBlock, blockUser, blockDate);
  }

  public static BlockingInfoDtoBuilder builder() {
    return new BlockingInfoDtoBuilder();
  }
}
