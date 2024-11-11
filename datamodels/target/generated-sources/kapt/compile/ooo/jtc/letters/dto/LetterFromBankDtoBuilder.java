package ooo.jtc.letters.dto;

import java.lang.Boolean;
import java.lang.String;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import ooo.jtc.documents.SignatureDto;
import ooo.jtc.generic.attachments.AttachmentDto;

public final class LetterFromBankDtoBuilder {
  private UUID id;

  private int version;

  private String documentNumber;

  private LocalDate documentDate;

  private UUID customerId;

  private String status;

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

  private UUID letterToBankId;

  private Boolean isFavorites;

  private Boolean isHasAttach;

  private List<? extends AttachmentDto> attachments;

  private ZonedDateTime sendDate;

  private List<SignatureDto> signatures;

  public LetterFromBankDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public LetterFromBankDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public LetterFromBankDtoBuilder setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  public LetterFromBankDtoBuilder setDocumentDate(LocalDate documentDate) {
    this.documentDate = documentDate;
    return this;
  }

  public LetterFromBankDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public LetterFromBankDtoBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public LetterFromBankDtoBuilder setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public LetterFromBankDtoBuilder setModifiedAt(ZonedDateTime modifiedAt) {
    this.modifiedAt = modifiedAt;
    return this;
  }

  public LetterFromBankDtoBuilder setCustomerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  public LetterFromBankDtoBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public LetterFromBankDtoBuilder setBranchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  public LetterFromBankDtoBuilder setContactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

  public LetterFromBankDtoBuilder setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  public LetterFromBankDtoBuilder setDocType(String docType) {
    this.docType = docType;
    return this;
  }

  public LetterFromBankDtoBuilder setDocTypeDescription(String docTypeDescription) {
    this.docTypeDescription = docTypeDescription;
    return this;
  }

  public LetterFromBankDtoBuilder setDocTheme(String docTheme) {
    this.docTheme = docTheme;
    return this;
  }

  public LetterFromBankDtoBuilder setDocText(String docText) {
    this.docText = docText;
    return this;
  }

  public LetterFromBankDtoBuilder setLetterToBankId(UUID letterToBankId) {
    this.letterToBankId = letterToBankId;
    return this;
  }

  public LetterFromBankDtoBuilder setIsFavorites(Boolean isFavorites) {
    this.isFavorites = isFavorites;
    return this;
  }

  public LetterFromBankDtoBuilder setIsHasAttach(Boolean isHasAttach) {
    this.isHasAttach = isHasAttach;
    return this;
  }

  public LetterFromBankDtoBuilder setAttachments(List<? extends AttachmentDto> attachments) {
    this.attachments = attachments;
    return this;
  }

  public LetterFromBankDtoBuilder setSendDate(ZonedDateTime sendDate) {
    this.sendDate = sendDate;
    return this;
  }

  public LetterFromBankDtoBuilder setSignatures(List<SignatureDto> signatures) {
    this.signatures = signatures;
    return this;
  }

  public LetterFromBankDto create() {
    return new LetterFromBankDto(id, version, documentNumber, documentDate, customerId, status, createdAt, modifiedAt, customerName, branchId, branchName, contactName, contactPhone, docType, docTypeDescription, docTheme, docText, letterToBankId, isFavorites, isHasAttach, attachments, sendDate, signatures);
  }

  public static LetterFromBankDtoBuilder builder() {
    return new LetterFromBankDtoBuilder();
  }
}
