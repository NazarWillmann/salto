package ooo.jtc.dictionaries.common.address;

import java.lang.String;

public final class RuAddressBuilder {
  private String countryDigitCode;

  private String index;

  private String regionCode;

  private String district;

  private String city;

  private String inhabitedLocality;

  private String street;

  private String houseNumber;

  private String housingNumber;

  private String buildingNumber;

  private String apartmentNumber;

  private String roomNumber;

  private String fullAddress;

  public RuAddressBuilder setCountryDigitCode(String countryDigitCode) {
    this.countryDigitCode = countryDigitCode;
    return this;
  }

  public RuAddressBuilder setIndex(String index) {
    this.index = index;
    return this;
  }

  public RuAddressBuilder setRegionCode(String regionCode) {
    this.regionCode = regionCode;
    return this;
  }

  public RuAddressBuilder setDistrict(String district) {
    this.district = district;
    return this;
  }

  public RuAddressBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public RuAddressBuilder setInhabitedLocality(String inhabitedLocality) {
    this.inhabitedLocality = inhabitedLocality;
    return this;
  }

  public RuAddressBuilder setStreet(String street) {
    this.street = street;
    return this;
  }

  public RuAddressBuilder setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
    return this;
  }

  public RuAddressBuilder setHousingNumber(String housingNumber) {
    this.housingNumber = housingNumber;
    return this;
  }

  public RuAddressBuilder setBuildingNumber(String buildingNumber) {
    this.buildingNumber = buildingNumber;
    return this;
  }

  public RuAddressBuilder setApartmentNumber(String apartmentNumber) {
    this.apartmentNumber = apartmentNumber;
    return this;
  }

  public RuAddressBuilder setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
    return this;
  }

  public RuAddressBuilder setFullAddress(String fullAddress) {
    this.fullAddress = fullAddress;
    return this;
  }

  public RuAddress create() {
    return new RuAddress(countryDigitCode, index, regionCode, district, city, inhabitedLocality, street, houseNumber, housingNumber, buildingNumber, apartmentNumber, roomNumber, fullAddress);
  }

  public static RuAddressBuilder builder() {
    return new RuAddressBuilder();
  }
}
