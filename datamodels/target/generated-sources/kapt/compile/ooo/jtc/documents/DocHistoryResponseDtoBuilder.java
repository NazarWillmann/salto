package ooo.jtc.documents;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.time.ZonedDateTime;
import java.util.UUID;

public final class DocHistoryResponseDtoBuilder {
  private Integer version;

  private ZonedDateTime eventTime;

  private UUID userId;

  private String targetStatus;

  private Boolean statusChanged;

  public DocHistoryResponseDtoBuilder setVersion(Integer version) {
    this.version = version;
    return this;
  }

  public DocHistoryResponseDtoBuilder setEventTime(ZonedDateTime eventTime) {
    this.eventTime = eventTime;
    return this;
  }

  public DocHistoryResponseDtoBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public DocHistoryResponseDtoBuilder setTargetStatus(String targetStatus) {
    this.targetStatus = targetStatus;
    return this;
  }

  public DocHistoryResponseDtoBuilder setStatusChanged(Boolean statusChanged) {
    this.statusChanged = statusChanged;
    return this;
  }

  public DocHistoryResponseDto create() {
    return new DocHistoryResponseDto(version, eventTime, userId, targetStatus, statusChanged);
  }

  public static DocHistoryResponseDtoBuilder builder() {
    return new DocHistoryResponseDtoBuilder();
  }
}
