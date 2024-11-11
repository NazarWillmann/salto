package ooo.jtc.crypto;

import java.lang.String;
import java.time.Instant;
import java.util.UUID;

public final class CertificateDtoBuilder {
  private UUID id;

  private int version;

  private String certificateData;

  private String serialNumber;

  private String thumbprint;

  private String userName;

  private Instant validFrom;

  private Instant validTo;

  private String state;

  private String certificateType;

  private UUID cryptoProfileId;

  public CertificateDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CertificateDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CertificateDtoBuilder setCertificateData(String certificateData) {
    this.certificateData = certificateData;
    return this;
  }

  public CertificateDtoBuilder setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

  public CertificateDtoBuilder setThumbprint(String thumbprint) {
    this.thumbprint = thumbprint;
    return this;
  }

  public CertificateDtoBuilder setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public CertificateDtoBuilder setValidFrom(Instant validFrom) {
    this.validFrom = validFrom;
    return this;
  }

  public CertificateDtoBuilder setValidTo(Instant validTo) {
    this.validTo = validTo;
    return this;
  }

  public CertificateDtoBuilder setState(String state) {
    this.state = state;
    return this;
  }

  public CertificateDtoBuilder setCertificateType(String certificateType) {
    this.certificateType = certificateType;
    return this;
  }

  public CertificateDtoBuilder setCryptoProfileId(UUID cryptoProfileId) {
    this.cryptoProfileId = cryptoProfileId;
    return this;
  }

  public CertificateDto create() {
    return new CertificateDto(id, version, certificateData, serialNumber, thumbprint, userName, validFrom, validTo, state, certificateType, cryptoProfileId);
  }

  public static CertificateDtoBuilder builder() {
    return new CertificateDtoBuilder();
  }
}
