package ooo.jtc.letters.dto;

import java.lang.Boolean;
import java.lang.String;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import ooo.jtc.generic.attachments.AttachmentDto;

public final class LetterToBankDtoBuilder {
  private UUID id;

  private int version;

  private String documentNumber;

  private LocalDate documentDate;

  private UUID customerId;

  private String status;

  private ZonedDateTime receiveDate;

  private ZonedDateTime executionDate;

  private String executionMessage;

  private ZonedDateTime createdAt;

  private ZonedDateTime modifiedAt;

  private String customerName;

  private UUID branchId;

  private String branchName;

  private String contactName;

  private String contactPhone;

  private String docType;

  private String docTypeDescription;

  private String docTheme;

  private String docText;

  private UUID letterFromBankId;

  private Boolean isFavorites;

  private Boolean isHasAttach;

  private List<? extends AttachmentDto> attachments;

  public LetterToBankDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public LetterToBankDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public LetterToBankDtoBuilder setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  public LetterToBankDtoBuilder setDocumentDate(LocalDate documentDate) {
    this.documentDate = documentDate;
    return this;
  }

  public LetterToBankDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public LetterToBankDtoBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public LetterToBankDtoBuilder setReceiveDate(ZonedDateTime receiveDate) {
    this.receiveDate = receiveDate;
    return this;
  }

  public LetterToBankDtoBuilder setExecutionDate(ZonedDateTime executionDate) {
    this.executionDate = executionDate;
    return this;
  }

  public LetterToBankDtoBuilder setExecutionMessage(String executionMessage) {
    this.executionMessage = executionMessage;
    return this;
  }

  public LetterToBankDtoBuilder setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public LetterToBankDtoBuilder setModifiedAt(ZonedDateTime modifiedAt) {
    this.modifiedAt = modifiedAt;
    return this;
  }

  public LetterToBankDtoBuilder setCustomerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  public LetterToBankDtoBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public LetterToBankDtoBuilder setBranchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  public LetterToBankDtoBuilder setContactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

  public LetterToBankDtoBuilder setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  public LetterToBankDtoBuilder setDocType(String docType) {
    this.docType = docType;
    return this;
  }

  public LetterToBankDtoBuilder setDocTypeDescription(String docTypeDescription) {
    this.docTypeDescription = docTypeDescription;
    return this;
  }

  public LetterToBankDtoBuilder setDocTheme(String docTheme) {
    this.docTheme = docTheme;
    return this;
  }

  public LetterToBankDtoBuilder setDocText(String docText) {
    this.docText = docText;
    return this;
  }

  public LetterToBankDtoBuilder setLetterFromBankId(UUID letterFromBankId) {
    this.letterFromBankId = letterFromBankId;
    return this;
  }

  public LetterToBankDtoBuilder setIsFavorites(Boolean isFavorites) {
    this.isFavorites = isFavorites;
    return this;
  }

  public LetterToBankDtoBuilder setIsHasAttach(Boolean isHasAttach) {
    this.isHasAttach = isHasAttach;
    return this;
  }

  public LetterToBankDtoBuilder setAttachments(List<? extends AttachmentDto> attachments) {
    this.attachments = attachments;
    return this;
  }

  public LetterToBankDto create() {
    return new LetterToBankDto(id, version, documentNumber, documentDate, customerId, status, receiveDate, executionDate, executionMessage, createdAt, modifiedAt, customerName, branchId, branchName, contactName, contactPhone, docType, docTypeDescription, docTheme, docText, letterFromBankId, isFavorites, isHasAttach, attachments);
  }

  public static LetterToBankDtoBuilder builder() {
    return new LetterToBankDtoBuilder();
  }
}
