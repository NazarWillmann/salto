package ooo.jtc.dictionaries.bankru;

import java.lang.String;
import java.time.ZonedDateTime;
import java.util.UUID;
import ooo.jtc.dictionaries.controlcode.ControlCodeDto;
import ooo.jtc.dictionaries.locationtype.LocationTypeDto;
import ooo.jtc.dictionaries.uer.UerDto;

public final class BankRuDtoBuilder {
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

  private ZonedDateTime controlDate;

  private UUID idLocationType;

  private UUID idControlCode;

  private UUID idUer;

  private LocationTypeDto locationType;

  private ControlCodeDto controlCode;

  private UerDto uer;

  public BankRuDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankRuDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankRuDtoBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public BankRuDtoBuilder setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public BankRuDtoBuilder setCorrAccount(String corrAccount) {
    this.corrAccount = corrAccount;
    return this;
  }

  public BankRuDtoBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public BankRuDtoBuilder setZip(String zip) {
    this.zip = zip;
    return this;
  }

  public BankRuDtoBuilder setLocation(String location) {
    this.location = location;
    return this;
  }

  public BankRuDtoBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public BankRuDtoBuilder setRegNumber(String regNumber) {
    this.regNumber = regNumber;
    return this;
  }

  public BankRuDtoBuilder setControlDate(ZonedDateTime controlDate) {
    this.controlDate = controlDate;
    return this;
  }

  public BankRuDtoBuilder setIdLocationType(UUID idLocationType) {
    this.idLocationType = idLocationType;
    return this;
  }

  public BankRuDtoBuilder setIdControlCode(UUID idControlCode) {
    this.idControlCode = idControlCode;
    return this;
  }

  public BankRuDtoBuilder setIdUer(UUID idUer) {
    this.idUer = idUer;
    return this;
  }

  public BankRuDtoBuilder setLocationType(LocationTypeDto locationType) {
    this.locationType = locationType;
    return this;
  }

  public BankRuDtoBuilder setControlCode(ControlCodeDto controlCode) {
    this.controlCode = controlCode;
    return this;
  }

  public BankRuDtoBuilder setUer(UerDto uer) {
    this.uer = uer;
    return this;
  }

  public BankRuDto create() {
    return new BankRuDto(id, version, bic, bankName, corrAccount, address, zip, location, phone, regNumber, controlDate, idLocationType, idControlCode, idUer, locationType, controlCode, uer);
  }

  public static BankRuDtoBuilder builder() {
    return new BankRuDtoBuilder();
  }
}
