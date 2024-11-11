package ooo.jtc.news.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public final class PublicationDtoBuilder {
  private UUID id;

  private int version;

  private LocalDate documentDate;

  private String documentNumber;

  private String status;

  private UUID customerId;

  private Instant createdAt;

  private UUID branchId;

  private String branchName;

  private String description;

  private String publicationType;

  private String targetType;

  private Boolean isMustKnow;

  private Boolean isImportant;

  private Instant startAt;

  private Instant postedAt;

  private Boolean isFavorites;

  private Instant endAt;

  private PublicationMailingChannel mailingChannel;

  private String header;

  private String text;

  private String link;

  private String linkText;

  private UUID picture;

  private Boolean isHasAttach;

  private Boolean isForAllBranches;

  private List<NewsAttachmentDto> attachments;

  private String attachName;

  private List<ReceiverCustomerDto> customers;

  private List<MustKnowDto> mustKnows;

  private Integer totalReceiverCustomers;

  private Integer totalMustKnows;

  public PublicationDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PublicationDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public PublicationDtoBuilder setDocumentDate(LocalDate documentDate) {
    this.documentDate = documentDate;
    return this;
  }

  public PublicationDtoBuilder setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  public PublicationDtoBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public PublicationDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public PublicationDtoBuilder setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public PublicationDtoBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public PublicationDtoBuilder setBranchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  public PublicationDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public PublicationDtoBuilder setPublicationType(String publicationType) {
    this.publicationType = publicationType;
    return this;
  }

  public PublicationDtoBuilder setTargetType(String targetType) {
    this.targetType = targetType;
    return this;
  }

  public PublicationDtoBuilder setIsMustKnow(Boolean isMustKnow) {
    this.isMustKnow = isMustKnow;
    return this;
  }

  public PublicationDtoBuilder setIsImportant(Boolean isImportant) {
    this.isImportant = isImportant;
    return this;
  }

  public PublicationDtoBuilder setStartAt(Instant startAt) {
    this.startAt = startAt;
    return this;
  }

  public PublicationDtoBuilder setPostedAt(Instant postedAt) {
    this.postedAt = postedAt;
    return this;
  }

  public PublicationDtoBuilder setIsFavorites(Boolean isFavorites) {
    this.isFavorites = isFavorites;
    return this;
  }

  public PublicationDtoBuilder setEndAt(Instant endAt) {
    this.endAt = endAt;
    return this;
  }

  public PublicationDtoBuilder setMailingChannel(PublicationMailingChannel mailingChannel) {
    this.mailingChannel = mailingChannel;
    return this;
  }

  public PublicationDtoBuilder setHeader(String header) {
    this.header = header;
    return this;
  }

  public PublicationDtoBuilder setText(String text) {
    this.text = text;
    return this;
  }

  public PublicationDtoBuilder setLink(String link) {
    this.link = link;
    return this;
  }

  public PublicationDtoBuilder setLinkText(String linkText) {
    this.linkText = linkText;
    return this;
  }

  public PublicationDtoBuilder setPicture(UUID picture) {
    this.picture = picture;
    return this;
  }

  public PublicationDtoBuilder setIsHasAttach(Boolean isHasAttach) {
    this.isHasAttach = isHasAttach;
    return this;
  }

  public PublicationDtoBuilder setIsForAllBranches(Boolean isForAllBranches) {
    this.isForAllBranches = isForAllBranches;
    return this;
  }

  public PublicationDtoBuilder setAttachments(List<NewsAttachmentDto> attachments) {
    this.attachments = attachments;
    return this;
  }

  public PublicationDtoBuilder setAttachName(String attachName) {
    this.attachName = attachName;
    return this;
  }

  public PublicationDtoBuilder setCustomers(List<ReceiverCustomerDto> customers) {
    this.customers = customers;
    return this;
  }

  public PublicationDtoBuilder setMustKnows(List<MustKnowDto> mustKnows) {
    this.mustKnows = mustKnows;
    return this;
  }

  public PublicationDtoBuilder setTotalReceiverCustomers(Integer totalReceiverCustomers) {
    this.totalReceiverCustomers = totalReceiverCustomers;
    return this;
  }

  public PublicationDtoBuilder setTotalMustKnows(Integer totalMustKnows) {
    this.totalMustKnows = totalMustKnows;
    return this;
  }

  public PublicationDto create() {
    return new PublicationDto(id, version, documentDate, documentNumber, status, customerId, createdAt, branchId, branchName, description, publicationType, targetType, isMustKnow, isImportant, startAt, postedAt, isFavorites, endAt, mailingChannel, header, text, link, linkText, picture, isHasAttach, isForAllBranches, attachments, attachName, customers, mustKnows, totalReceiverCustomers, totalMustKnows);
  }

  public static PublicationDtoBuilder builder() {
    return new PublicationDtoBuilder();
  }
}
