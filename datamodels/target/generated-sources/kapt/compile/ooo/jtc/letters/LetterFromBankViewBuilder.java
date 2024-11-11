package ooo.jtc.letters;

import java.io.File;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.UUID;
import ooo.jtc.generic.attachments.AttachmentDto;

public final class LetterFromBankViewBuilder {
  private UUID id;

  private UUID customerId;

  private String documentNumber;

  private String documentDate;

  private String statusSystem;

  private String statusClient;

  private String statusBank;

  private String customerName;

  private String createdAt;

  private String branchName;

  private String contactName;

  private String contactPhone;

  private String docType;

  private String docTypeDescription;

  private String docTheme;

  private String docText;

  private UUID branchId;

  private UUID letterToBankId;

  private Boolean isFavorites;

  private Boolean isHasAttach;

  private List<? extends AttachmentDto> attachments;

  private List<? extends File> attachmentFiles;

  public LetterFromBankViewBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public LetterFromBankViewBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public LetterFromBankViewBuilder setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  public LetterFromBankViewBuilder setDocumentDate(String documentDate) {
    this.documentDate = documentDate;
    return this;
  }

  public LetterFromBankViewBuilder setStatusSystem(String statusSystem) {
    this.statusSystem = statusSystem;
    return this;
  }

  public LetterFromBankViewBuilder setStatusClient(String statusClient) {
    this.statusClient = statusClient;
    return this;
  }

  public LetterFromBankViewBuilder setStatusBank(String statusBank) {
    this.statusBank = statusBank;
    return this;
  }

  public LetterFromBankViewBuilder setCustomerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  public LetterFromBankViewBuilder setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public LetterFromBankViewBuilder setBranchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  public LetterFromBankViewBuilder setContactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

  public LetterFromBankViewBuilder setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  public LetterFromBankViewBuilder setDocType(String docType) {
    this.docType = docType;
    return this;
  }

  public LetterFromBankViewBuilder setDocTypeDescription(String docTypeDescription) {
    this.docTypeDescription = docTypeDescription;
    return this;
  }

  public LetterFromBankViewBuilder setDocTheme(String docTheme) {
    this.docTheme = docTheme;
    return this;
  }

  public LetterFromBankViewBuilder setDocText(String docText) {
    this.docText = docText;
    return this;
  }

  public LetterFromBankViewBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public LetterFromBankViewBuilder setLetterToBankId(UUID letterToBankId) {
    this.letterToBankId = letterToBankId;
    return this;
  }

  public LetterFromBankViewBuilder setIsFavorites(Boolean isFavorites) {
    this.isFavorites = isFavorites;
    return this;
  }

  public LetterFromBankViewBuilder setIsHasAttach(Boolean isHasAttach) {
    this.isHasAttach = isHasAttach;
    return this;
  }

  public LetterFromBankViewBuilder setAttachments(List<? extends AttachmentDto> attachments) {
    this.attachments = attachments;
    return this;
  }

  public LetterFromBankViewBuilder setAttachmentFiles(List<? extends File> attachmentFiles) {
    this.attachmentFiles = attachmentFiles;
    return this;
  }

  public LetterFromBankView create() {
    return new LetterFromBankView(id, customerId, documentNumber, documentDate, statusSystem, statusClient, statusBank, customerName, createdAt, branchName, contactName, contactPhone, docType, docTypeDescription, docTheme, docText, branchId, letterToBankId, isFavorites, isHasAttach, attachments, attachmentFiles);
  }

  public static LetterFromBankViewBuilder builder() {
    return new LetterFromBankViewBuilder();
  }
}
