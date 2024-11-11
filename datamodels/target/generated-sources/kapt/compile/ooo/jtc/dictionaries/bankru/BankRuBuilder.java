package ooo.jtc.dictionaries.bankru;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;
import ooo.jtc.dictionaries.controlcode.ControlCode;
import ooo.jtc.dictionaries.locationtype.LocationType;
import ooo.jtc.dictionaries.uer.Uer;

public final class BankRuBuilder {
  private UUID id;

  private int version;

  private String bic;

  private String bankName;

  private String corrAccount;

  private String address;

  private String zip;

  private String location;

  private String phone;

  private String regNumber;

  private Timestamp controlDate;

  private UUID idLocationType;

  private UUID idControlCode;

  private UUID idUer;

  private LocationType locationType;

  private ControlCode controlCode;

  private Uer uer;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public BankRuBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankRuBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankRuBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public BankRuBuilder setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public BankRuBuilder setCorrAccount(String corrAccount) {
    this.corrAccount = corrAccount;
    return this;
  }

  public BankRuBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public BankRuBuilder setZip(String zip) {
    this.zip = zip;
    return this;
  }

  public BankRuBuilder setLocation(String location) {
    this.location = location;
    return this;
  }

  public BankRuBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public BankRuBuilder setRegNumber(String regNumber) {
    this.regNumber = regNumber;
    return this;
  }

  public BankRuBuilder setControlDate(Timestamp controlDate) {
    this.controlDate = controlDate;
    return this;
  }

  public BankRuBuilder setIdLocationType(UUID idLocationType) {
    this.idLocationType = idLocationType;
    return this;
  }

  public BankRuBuilder setIdControlCode(UUID idControlCode) {
    this.idControlCode = idControlCode;
    return this;
  }

  public BankRuBuilder setIdUer(UUID idUer) {
    this.idUer = idUer;
    return this;
  }

  public BankRuBuilder setLocationType(LocationType locationType) {
    this.locationType = locationType;
    return this;
  }

  public BankRuBuilder setControlCode(ControlCode controlCode) {
    this.controlCode = controlCode;
    return this;
  }

  public BankRuBuilder setUer(Uer uer) {
    this.uer = uer;
    return this;
  }

  public BankRuBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public BankRuBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public BankRu create() {
    return new BankRu(id, version, bic, bankName, corrAccount, address, zip, location, phone, regNumber, controlDate, idLocationType, idControlCode, idUer, locationType, controlCode, uer, createdAt, deletedAt);
  }

  public static BankRuBuilder builder() {
    return new BankRuBuilder();
  }
}
