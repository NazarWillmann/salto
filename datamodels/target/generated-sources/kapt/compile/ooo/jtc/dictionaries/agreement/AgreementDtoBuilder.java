package ooo.jtc.dictionaries.agreement;

import java.lang.String;
import java.time.LocalDate;
import java.util.UUID;

public final class AgreementDtoBuilder {
  private UUID id;

  private int version;

  private LocalDate agreementDate;

  private String agreementNumber;

  private String agreementType;

  private LocalDate endDate;

  private String description;

  private UUID customerId;

  private String customerShortName;

  private String customerFullName;

  private String status;

  public AgreementDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public AgreementDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public AgreementDtoBuilder setAgreementDate(LocalDate agreementDate) {
    this.agreementDate = agreementDate;
    return this;
  }

  public AgreementDtoBuilder setAgreementNumber(String agreementNumber) {
    this.agreementNumber = agreementNumber;
    return this;
  }

  public AgreementDtoBuilder setAgreementType(String agreementType) {
    this.agreementType = agreementType;
    return this;
  }

  public AgreementDtoBuilder setEndDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  public AgreementDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public AgreementDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public AgreementDtoBuilder setCustomerShortName(String customerShortName) {
    this.customerShortName = customerShortName;
    return this;
  }

  public AgreementDtoBuilder setCustomerFullName(String customerFullName) {
    this.customerFullName = customerFullName;
    return this;
  }

  public AgreementDtoBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public AgreementDto create() {
    return new AgreementDto(id, version, agreementDate, agreementNumber, agreementType, endDate, description, customerId, customerShortName, customerFullName, status);
  }

  public static AgreementDtoBuilder builder() {
    return new AgreementDtoBuilder();
  }
}
