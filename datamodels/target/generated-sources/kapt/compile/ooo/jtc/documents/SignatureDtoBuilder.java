package ooo.jtc.documents;

import java.lang.Boolean;
import java.lang.String;
import java.time.ZonedDateTime;
import java.util.UUID;

public final class SignatureDtoBuilder {
  private ZonedDateTime createdAt;

  private String digest;

  private int digestVersion;

  private UUID documentId;

  private UUID id;

  private Boolean isOwnSignature;

  private String signTool;

  private UUID signToolId;

  private String signToolType;

  private UUID signToolRef;

  private String signKind;

  private UUID signKindId;

  private String signStage;

  private String signature;

  private String userName;

  public SignatureDtoBuilder setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public SignatureDtoBuilder setDigest(String digest) {
    this.digest = digest;
    return this;
  }

  public SignatureDtoBuilder setDigestVersion(int digestVersion) {
    this.digestVersion = digestVersion;
    return this;
  }

  public SignatureDtoBuilder setDocumentId(UUID documentId) {
    this.documentId = documentId;
    return this;
  }

  public SignatureDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public SignatureDtoBuilder setIsOwnSignature(Boolean isOwnSignature) {
    this.isOwnSignature = isOwnSignature;
    return this;
  }

  public SignatureDtoBuilder setSignTool(String signTool) {
    this.signTool = signTool;
    return this;
  }

  public SignatureDtoBuilder setSignToolId(UUID signToolId) {
    this.signToolId = signToolId;
    return this;
  }

  public SignatureDtoBuilder setSignToolType(String signToolType) {
    this.signToolType = signToolType;
    return this;
  }

  public SignatureDtoBuilder setSignToolRef(UUID signToolRef) {
    this.signToolRef = signToolRef;
    return this;
  }

  public SignatureDtoBuilder setSignKind(String signKind) {
    this.signKind = signKind;
    return this;
  }

  public SignatureDtoBuilder setSignKindId(UUID signKindId) {
    this.signKindId = signKindId;
    return this;
  }

  public SignatureDtoBuilder setSignStage(String signStage) {
    this.signStage = signStage;
    return this;
  }

  public SignatureDtoBuilder setSignature(String signature) {
    this.signature = signature;
    return this;
  }

  public SignatureDtoBuilder setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public SignatureDto create() {
    return new SignatureDto(createdAt, digest, digestVersion, documentId, id, isOwnSignature, signTool, signToolId, signToolType, signToolRef, signKind, signKindId, signStage, signature, userName);
  }

  public static SignatureDtoBuilder builder() {
    return new SignatureDtoBuilder();
  }
}
