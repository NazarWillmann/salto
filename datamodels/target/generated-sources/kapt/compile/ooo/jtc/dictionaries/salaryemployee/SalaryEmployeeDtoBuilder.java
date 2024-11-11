package ooo.jtc.dictionaries.salaryemployee;

import java.lang.String;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.common.address.RuAddressDto;

public final class SalaryEmployeeDtoBuilder {
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

  private String mobilePhone;

  private String workPhone;

  private String homePhone;

  private String email;

  private Instant creatingDate;

  private Instant inclusionDate;

  private Instant excludingDate;

  private SalaryEmployeeIdentityDocumentDto identityDocument;

  private SalaryEmployeeResidencyPermitDocumentDto residencyPermitDocument;

  private List<SalaryEmployeePaymentDetailsDto> paymentDetails;

  private RuAddressDto addressRegistration;

  private RuAddressDto addressLocation;

  private RuAddressDto addressInfo;

  private boolean isFavorites;

  public SalaryEmployeeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public SalaryEmployeeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public SalaryEmployeeDtoBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public SalaryEmployeeDtoBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public SalaryEmployeeDtoBuilder setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public SalaryEmployeeDtoBuilder setFio(String fio) {
    this.fio = fio;
    return this;
  }

  public SalaryEmployeeDtoBuilder setSex(String sex) {
    this.sex = sex;
    return this;
  }

  public SalaryEmployeeDtoBuilder setBirthday(LocalDate birthday) {
    this.birthday = birthday;
    return this;
  }

  public SalaryEmployeeDtoBuilder setIsResident(boolean isResident) {
    this.isResident = isResident;
    return this;
  }

  public SalaryEmployeeDtoBuilder setNationalityCode(String nationalityCode) {
    this.nationalityCode = nationalityCode;
    return this;
  }

  public SalaryEmployeeDtoBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public SalaryEmployeeDtoBuilder setSnils(String snils) {
    this.snils = snils;
    return this;
  }

  public SalaryEmployeeDtoBuilder setPersonnelNumber(String personnelNumber) {
    this.personnelNumber = personnelNumber;
    return this;
  }

  public SalaryEmployeeDtoBuilder setPosition(String position) {
    this.position = position;
    return this;
  }

  public SalaryEmployeeDtoBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public SalaryEmployeeDtoBuilder setIsAgreement(boolean isAgreement) {
    this.isAgreement = isAgreement;
    return this;
  }

  public SalaryEmployeeDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public SalaryEmployeeDtoBuilder setCustomerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  public SalaryEmployeeDtoBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public SalaryEmployeeDtoBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public SalaryEmployeeDtoBuilder setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public SalaryEmployeeDtoBuilder setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public SalaryEmployeeDtoBuilder setHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public SalaryEmployeeDtoBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public SalaryEmployeeDtoBuilder setCreatingDate(Instant creatingDate) {
    this.creatingDate = creatingDate;
    return this;
  }

  public SalaryEmployeeDtoBuilder setInclusionDate(Instant inclusionDate) {
    this.inclusionDate = inclusionDate;
    return this;
  }

  public SalaryEmployeeDtoBuilder setExcludingDate(Instant excludingDate) {
    this.excludingDate = excludingDate;
    return this;
  }

  public SalaryEmployeeDtoBuilder setIdentityDocument(
      SalaryEmployeeIdentityDocumentDto identityDocument) {
    this.identityDocument = identityDocument;
    return this;
  }

  public SalaryEmployeeDtoBuilder setResidencyPermitDocument(
      SalaryEmployeeResidencyPermitDocumentDto residencyPermitDocument) {
    this.residencyPermitDocument = residencyPermitDocument;
    return this;
  }

  public SalaryEmployeeDtoBuilder setPaymentDetails(
      List<SalaryEmployeePaymentDetailsDto> paymentDetails) {
    this.paymentDetails = paymentDetails;
    return this;
  }

  public SalaryEmployeeDtoBuilder setAddressRegistration(RuAddressDto addressRegistration) {
    this.addressRegistration = addressRegistration;
    return this;
  }

  public SalaryEmployeeDtoBuilder setAddressLocation(RuAddressDto addressLocation) {
    this.addressLocation = addressLocation;
    return this;
  }

  public SalaryEmployeeDtoBuilder setAddressInfo(RuAddressDto addressInfo) {
    this.addressInfo = addressInfo;
    return this;
  }

  public SalaryEmployeeDtoBuilder setIsFavorites(boolean isFavorites) {
    this.isFavorites = isFavorites;
    return this;
  }

  public SalaryEmployeeDto create() {
    return new SalaryEmployeeDto(id, version, lastName, firstName, middleName, fio, sex, birthday, isResident, nationalityCode, inn, snils, personnelNumber, position, status, isAgreement, customerId, customerName, userId, phone, mobilePhone, workPhone, homePhone, email, creatingDate, inclusionDate, excludingDate, identityDocument, residencyPermitDocument, paymentDetails, addressRegistration, addressLocation, addressInfo, isFavorites);
  }

  public static SalaryEmployeeDtoBuilder builder() {
    return new SalaryEmployeeDtoBuilder();
  }
}
