package ooo.jtc.letters;

import java.io.File;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.UUID;
import ooo.jtc.generic.attachments.AttachmentDto;

public final class LetterToBankViewBuilder {
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

  private String contactPhoneMasked;

  private String docType;

  private String docTypeDescription;

  private String docTheme;

  private String docText;

  private UUID branchId;

  private UUID letterFromBankId;

  private Boolean isFavorites;

  private Boolean isHasAttach;

  private List<? extends AttachmentDto> attachments;

  private List<? extends File> attachmentFiles;

  public LetterToBankViewBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public LetterToBankViewBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public LetterToBankViewBuilder setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  public LetterToBankViewBuilder setDocumentDate(String documentDate) {
    this.documentDate = documentDate;
    return this;
  }

  public LetterToBankViewBuilder setStatusSystem(String statusSystem) {
    this.statusSystem = statusSystem;
    return this;
  }

  public LetterToBankViewBuilder setStatusClient(String statusClient) {
    this.statusClient = statusClient;
    return this;
  }

  public LetterToBankViewBuilder setStatusBank(String statusBank) {
    this.statusBank = statusBank;
    return this;
  }

  public LetterToBankViewBuilder setCustomerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  public LetterToBankViewBuilder setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public LetterToBankViewBuilder setBranchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  public LetterToBankViewBuilder setContactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

  public LetterToBankViewBuilder setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  public LetterToBankViewBuilder setContactPhoneMasked(String contactPhoneMasked) {
    this.contactPhoneMasked = contactPhoneMasked;
    return this;
  }

  public LetterToBankViewBuilder setDocType(String docType) {
    this.docType = docType;
    return this;
  }

  public LetterToBankViewBuilder setDocTypeDescription(String docTypeDescription) {
    this.docTypeDescription = docTypeDescription;
    return this;
  }

  public LetterToBankViewBuilder setDocTheme(String docTheme) {
    this.docTheme = docTheme;
    return this;
  }

  public LetterToBankViewBuilder setDocText(String docText) {
    this.docText = docText;
    return this;
  }

  public LetterToBankViewBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public LetterToBankViewBuilder setLetterFromBankId(UUID letterFromBankId) {
    this.letterFromBankId = letterFromBankId;
    return this;
  }

  public LetterToBankViewBuilder setIsFavorites(Boolean isFavorites) {
    this.isFavorites = isFavorites;
    return this;
  }

  public LetterToBankViewBuilder setIsHasAttach(Boolean isHasAttach) {
    this.isHasAttach = isHasAttach;
    return this;
  }

  public LetterToBankViewBuilder setAttachments(List<? extends AttachmentDto> attachments) {
    this.attachments = attachments;
    return this;
  }

  public LetterToBankViewBuilder setAttachmentFiles(List<? extends File> attachmentFiles) {
    this.attachmentFiles = attachmentFiles;
    return this;
  }

  public LetterToBankView create() {
    return new LetterToBankView(id, customerId, documentNumber, documentDate, statusSystem, statusClient, statusBank, customerName, createdAt, branchName, contactName, contactPhone, contactPhoneMasked, docType, docTypeDescription, docTheme, docText, branchId, letterFromBankId, isFavorites, isHasAttach, attachments, attachmentFiles);
  }

  public static LetterToBankViewBuilder builder() {
    return new LetterToBankViewBuilder();
  }
}
