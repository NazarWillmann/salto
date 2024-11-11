package ooo.jtc.documents;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class SignatureBuilder {
  private UUID id;

  private UUID documentId;

  private int version;

  private UUID signToolId;

  private UUID signToolRef;

  private UUID signKindId;

  private String digest;

  private String signature;

  private Timestamp createdAt;

  public SignatureBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public SignatureBuilder setDocumentId(UUID documentId) {
    this.documentId = documentId;
    return this;
  }

  public SignatureBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public SignatureBuilder setSignToolId(UUID signToolId) {
    this.signToolId = signToolId;
    return this;
  }

  public SignatureBuilder setSignToolRef(UUID signToolRef) {
    this.signToolRef = signToolRef;
    return this;
  }

  public SignatureBuilder setSignKindId(UUID signKindId) {
    this.signKindId = signKindId;
    return this;
  }

  public SignatureBuilder setDigest(String digest) {
    this.digest = digest;
    return this;
  }

  public SignatureBuilder setSignature(String signature) {
    this.signature = signature;
    return this;
  }

  public SignatureBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Signature create() {
    return new Signature(id, documentId, version, signToolId, signToolRef, signKindId, digest, signature, createdAt);
  }

  public static SignatureBuilder builder() {
    return new SignatureBuilder();
  }
}
