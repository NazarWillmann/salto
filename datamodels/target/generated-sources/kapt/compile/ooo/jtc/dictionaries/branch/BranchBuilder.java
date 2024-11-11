package ooo.jtc.dictionaries.branch;

import java.lang.String;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsBic;
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsSwift;
import ooo.jtc.dictionaries.common.address.RuAddress;
import ooo.jtc.dictionaries.common.extid.ExtId;
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfo;

public final class BranchBuilder {
  private UUID id;

  private int version;

  private String branchType;

  private String kpp;

  private String shortName;

  private String fullName;

  private String uiName;

  private UUID bankId;

  private String email;

  private String description;

  private UUID parentBranchId;

  private PaymentDetailsBic paymentDetailsBic;

  private PaymentDetailsSwift paymentDetailsSwift;

  private RuAddress addressLocation;

  private RuAddress addressRegistration;

  private List<ExtId> extIds;

  private List<PhoneInfo> phoneSupports;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public BranchBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BranchBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BranchBuilder setBranchType(String branchType) {
    this.branchType = branchType;
    return this;
  }

  public BranchBuilder setKpp(String kpp) {
    this.kpp = kpp;
    return this;
  }

  public BranchBuilder setShortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

  public BranchBuilder setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public BranchBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public BranchBuilder setBankId(UUID bankId) {
    this.bankId = bankId;
    return this;
  }

  public BranchBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public BranchBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BranchBuilder setParentBranchId(UUID parentBranchId) {
    this.parentBranchId = parentBranchId;
    return this;
  }

  public BranchBuilder setPaymentDetailsBic(PaymentDetailsBic paymentDetailsBic) {
    this.paymentDetailsBic = paymentDetailsBic;
    return this;
  }

  public BranchBuilder setPaymentDetailsSwift(PaymentDetailsSwift paymentDetailsSwift) {
    this.paymentDetailsSwift = paymentDetailsSwift;
    return this;
  }

  public BranchBuilder setAddressLocation(RuAddress addressLocation) {
    this.addressLocation = addressLocation;
    return this;
  }

  public BranchBuilder setAddressRegistration(RuAddress addressRegistration) {
    this.addressRegistration = addressRegistration;
    return this;
  }

  public BranchBuilder setExtIds(List<ExtId> extIds) {
    this.extIds = extIds;
    return this;
  }

  public BranchBuilder setPhoneSupports(List<PhoneInfo> phoneSupports) {
    this.phoneSupports = phoneSupports;
    return this;
  }

  public BranchBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public BranchBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Branch create() {
    return new Branch(id, version, branchType, kpp, shortName, fullName, uiName, bankId, email, description, parentBranchId, paymentDetailsBic, paymentDetailsSwift, addressLocation, addressRegistration, extIds, phoneSupports, createdAt, deletedAt);
  }

  public static BranchBuilder builder() {
    return new BranchBuilder();
  }
}
