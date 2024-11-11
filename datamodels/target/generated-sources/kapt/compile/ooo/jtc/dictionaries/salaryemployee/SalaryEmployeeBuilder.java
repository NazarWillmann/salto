package ooo.jtc.dictionaries.salaryemployee;

import java.lang.String;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.common.address.RuAddress;

public final class SalaryEmployeeBuilder {
  private UUID id;

  private int version;

  private String lastName;

  private String firstName;

  private String middleName;

  private String fio;

  private String sex;

  private LocalDate birthday;

  private boolean isResident;

  private String nationalityCode;

  private String inn;

  private String snils;

  private String personnelNumber;

  private String position;

  private String status;

  private boolean isAgreement;

  private UUID customerId;

  private String customerName;

  private UUID userId;

  private String phone;

  private String homePhone;

  private String workPhone;

  private String mobilePhone;

  private String email;

  private Instant creatingDate;

  private Instant inclusionDate;

  private Instant excludingDate;

  private List<SalaryEmployeePaymentDetails> paymentDetails;

  private RuAddress addressInfo;

  private RuAddress addressLocation;

  private RuAddress addressRegistration;

  private SalaryEmployeeIdentityDocument identityDocument;

  private SalaryEmployeeResidencyPermitDocument residencyPermitDocument;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public SalaryEmployeeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public SalaryEmployeeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public SalaryEmployeeBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public SalaryEmployeeBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public SalaryEmployeeBuilder setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public SalaryEmployeeBuilder setFio(String fio) {
    this.fio = fio;
    return this;
  }

  public SalaryEmployeeBuilder setSex(String sex) {
    this.sex = sex;
    return this;
  }

  public SalaryEmployeeBuilder setBirthday(LocalDate birthday) {
    this.birthday = birthday;
    return this;
  }

  public SalaryEmployeeBuilder setIsResident(boolean isResident) {
    this.isResident = isResident;
    return this;
  }

  public SalaryEmployeeBuilder setNationalityCode(String nationalityCode) {
    this.nationalityCode = nationalityCode;
    return this;
  }

  public SalaryEmployeeBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public SalaryEmployeeBuilder setSnils(String snils) {
    this.snils = snils;
    return this;
  }

  public SalaryEmployeeBuilder setPersonnelNumber(String personnelNumber) {
    this.personnelNumber = personnelNumber;
    return this;
  }

  public SalaryEmployeeBuilder setPosition(String position) {
    this.position = position;
    return this;
  }

  public SalaryEmployeeBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public SalaryEmployeeBuilder setIsAgreement(boolean isAgreement) {
    this.isAgreement = isAgreement;
    return this;
  }

  public SalaryEmployeeBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public SalaryEmployeeBuilder setCustomerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  public SalaryEmployeeBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public SalaryEmployeeBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public SalaryEmployeeBuilder setHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public SalaryEmployeeBuilder setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public SalaryEmployeeBuilder setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public SalaryEmployeeBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public SalaryEmployeeBuilder setCreatingDate(Instant creatingDate) {
    this.creatingDate = creatingDate;
    return this;
  }

  public SalaryEmployeeBuilder setInclusionDate(Instant inclusionDate) {
    this.inclusionDate = inclusionDate;
    return this;
  }

  public SalaryEmployeeBuilder setExcludingDate(Instant excludingDate) {
    this.excludingDate = excludingDate;
    return this;
  }

  public SalaryEmployeeBuilder setPaymentDetails(
      List<SalaryEmployeePaymentDetails> paymentDetails) {
    this.paymentDetails = paymentDetails;
    return this;
  }

  public SalaryEmployeeBuilder setAddressInfo(RuAddress addressInfo) {
    this.addressInfo = addressInfo;
    return this;
  }

  public SalaryEmployeeBuilder setAddressLocation(RuAddress addressLocation) {
    this.addressLocation = addressLocation;
    return this;
  }

  public SalaryEmployeeBuilder setAddressRegistration(RuAddress addressRegistration) {
    this.addressRegistration = addressRegistration;
    return this;
  }

  public SalaryEmployeeBuilder setIdentityDocument(
      SalaryEmployeeIdentityDocument identityDocument) {
    this.identityDocument = identityDocument;
    return this;
  }

  public SalaryEmployeeBuilder setResidencyPermitDocument(
      SalaryEmployeeResidencyPermitDocument residencyPermitDocument) {
    this.residencyPermitDocument = residencyPermitDocument;
    return this;
  }

  public SalaryEmployeeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public SalaryEmployeeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public SalaryEmployee create() {
    return new SalaryEmployee(id, version, lastName, firstName, middleName, fio, sex, birthday, isResident, nationalityCode, inn, snils, personnelNumber, position, status, isAgreement, customerId, customerName, userId, phone, homePhone, workPhone, mobilePhone, email, creatingDate, inclusionDate, excludingDate, paymentDetails, addressInfo, addressLocation, addressRegistration, identityDocument, residencyPermitDocument, createdAt, deletedAt);
  }

  public static SalaryEmployeeBuilder builder() {
    return new SalaryEmployeeBuilder();
  }
}
