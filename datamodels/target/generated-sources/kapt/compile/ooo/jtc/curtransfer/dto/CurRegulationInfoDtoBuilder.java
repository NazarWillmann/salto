package ooo.jtc.curtransfer.dto;

import java.lang.String;
import java.time.LocalDate;
import java.util.UUID;

public final class CurRegulationInfoDtoBuilder {
  private UUID id;

  private UUID documentId;

  private String operCode;

  private String ucNumber;

  private LocalDate expectDate;

  private String amount;

  public CurRegulationInfoDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CurRegulationInfoDtoBuilder setDocumentId(UUID documentId) {
    this.documentId = documentId;
    return this;
  }

  public CurRegulationInfoDtoBuilder setOperCode(String operCode) {
    this.operCode = operCode;
    return this;
  }

  public CurRegulationInfoDtoBuilder setUcNumber(String ucNumber) {
    this.ucNumber = ucNumber;
    return this;
  }

  public CurRegulationInfoDtoBuilder setExpectDate(LocalDate expectDate) {
    this.expectDate = expectDate;
    return this;
  }

  public CurRegulationInfoDtoBuilder setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public CurRegulationInfoDto create() {
    return new CurRegulationInfoDto(id, documentId, operCode, ucNumber, expectDate, amount);
  }

  public static CurRegulationInfoDtoBuilder builder() {
    return new CurRegulationInfoDtoBuilder();
  }
}
