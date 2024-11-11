package ooo.jtc.dictionaries.agreement;

import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public final class AgreementBuilder {
  private UUID id;

  private int version;

  private LocalDate agreementDate;

  private String agreementNumber;

  private AgreementType agreementType;

  private LocalDate endDate;

  private String description;

  private UUID customerId;

  private String customerShortName;

  private String customerFullName;

  private String status;

  private Instant createdAt;

  private Instant deletedAt;

  public AgreementBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public AgreementBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public AgreementBuilder setAgreementDate(LocalDate agreementDate) {
    this.agreementDate = agreementDate;
    return this;
  }

  public AgreementBuilder setAgreementNumber(String agreementNumber) {
    this.agreementNumber = agreementNumber;
    return this;
  }

  public AgreementBuilder setAgreementType(AgreementType agreementType) {
    this.agreementType = agreementType;
    return this;
  }

  public AgreementBuilder setEndDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  public AgreementBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public AgreementBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public AgreementBuilder setCustomerShortName(String customerShortName) {
    this.customerShortName = customerShortName;
    return this;
  }

  public AgreementBuilder setCustomerFullName(String customerFullName) {
    this.customerFullName = customerFullName;
    return this;
  }

  public AgreementBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public AgreementBuilder setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public AgreementBuilder setDeletedAt(Instant deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Agreement create() {
    return new Agreement(id, version, agreementDate, agreementNumber, agreementType, endDate, description, customerId, customerShortName, customerFullName, status, createdAt, deletedAt);
  }

  public static AgreementBuilder builder() {
    return new AgreementBuilder();
  }
}
