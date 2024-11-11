package ooo.jtc.dictionaries.branch;

import java.lang.String;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsBicDto;
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsSwiftDto;
import ooo.jtc.dictionaries.common.address.RuAddressDto;
import ooo.jtc.dictionaries.common.extid.ExtIdDto;
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfoDto;

public final class BranchDtoBuilder {
  private UUID id;

  private int version;

  private String branchType;

  private String kpp;

  private String shortName;

  private String fullName;

  private String uiName;

  private PaymentDetailsBicDto paymentDetailsBic;

  private PaymentDetailsSwiftDto paymentDetailsSwift;

  private UUID bankId;

  private List<PhoneInfoDto> phoneSupports;

  private String email;

  private String description;

  private RuAddressDto addressRegistration;

  private RuAddressDto addressLocation;

  private List<ExtIdDto> extIds;

  private UUID parentBranchId;

  public BranchDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BranchDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BranchDtoBuilder setBranchType(String branchType) {
    this.branchType = branchType;
    return this;
  }

  public BranchDtoBuilder setKpp(String kpp) {
    this.kpp = kpp;
    return this;
  }

  public BranchDtoBuilder setShortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

  public BranchDtoBuilder setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public BranchDtoBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public BranchDtoBuilder setPaymentDetailsBic(PaymentDetailsBicDto paymentDetailsBic) {
    this.paymentDetailsBic = paymentDetailsBic;
    return this;
  }

  public BranchDtoBuilder setPaymentDetailsSwift(PaymentDetailsSwiftDto paymentDetailsSwift) {
    this.paymentDetailsSwift = paymentDetailsSwift;
    return this;
  }

  public BranchDtoBuilder setBankId(UUID bankId) {
    this.bankId = bankId;
    return this;
  }

  public BranchDtoBuilder setPhoneSupports(List<PhoneInfoDto> phoneSupports) {
    this.phoneSupports = phoneSupports;
    return this;
  }

  public BranchDtoBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public BranchDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BranchDtoBuilder setAddressRegistration(RuAddressDto addressRegistration) {
    this.addressRegistration = addressRegistration;
    return this;
  }

  public BranchDtoBuilder setAddressLocation(RuAddressDto addressLocation) {
    this.addressLocation = addressLocation;
    return this;
  }

  public BranchDtoBuilder setExtIds(List<ExtIdDto> extIds) {
    this.extIds = extIds;
    return this;
  }

  public BranchDtoBuilder setParentBranchId(UUID parentBranchId) {
    this.parentBranchId = parentBranchId;
    return this;
  }

  public BranchDto create() {
    return new BranchDto(id, version, branchType, kpp, shortName, fullName, uiName, paymentDetailsBic, paymentDetailsSwift, bankId, phoneSupports, email, description, addressRegistration, addressLocation, extIds, parentBranchId);
  }

  public static BranchDtoBuilder builder() {
    return new BranchDtoBuilder();
  }
}
