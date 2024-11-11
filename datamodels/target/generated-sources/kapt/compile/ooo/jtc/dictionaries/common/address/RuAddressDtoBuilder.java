package ooo.jtc.dictionaries.common.address;

import java.lang.String;

public final class RuAddressDtoBuilder {
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

  public RuAddressDtoBuilder setCountryDigitCode(String countryDigitCode) {
    this.countryDigitCode = countryDigitCode;
    return this;
  }

  public RuAddressDtoBuilder setIndex(String index) {
    this.index = index;
    return this;
  }

  public RuAddressDtoBuilder setRegionCode(String regionCode) {
    this.regionCode = regionCode;
    return this;
  }

  public RuAddressDtoBuilder setDistrict(String district) {
    this.district = district;
    return this;
  }

  public RuAddressDtoBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public RuAddressDtoBuilder setInhabitedLocality(String inhabitedLocality) {
    this.inhabitedLocality = inhabitedLocality;
    return this;
  }

  public RuAddressDtoBuilder setStreet(String street) {
    this.street = street;
    return this;
  }

  public RuAddressDtoBuilder setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
    return this;
  }

  public RuAddressDtoBuilder setHousingNumber(String housingNumber) {
    this.housingNumber = housingNumber;
    return this;
  }

  public RuAddressDtoBuilder setBuildingNumber(String buildingNumber) {
    this.buildingNumber = buildingNumber;
    return this;
  }

  public RuAddressDtoBuilder setApartmentNumber(String apartmentNumber) {
    this.apartmentNumber = apartmentNumber;
    return this;
  }

  public RuAddressDtoBuilder setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
    return this;
  }

  public RuAddressDtoBuilder setFullAddress(String fullAddress) {
    this.fullAddress = fullAddress;
    return this;
  }

  public RuAddressDto create() {
    return new RuAddressDto(countryDigitCode, index, regionCode, district, city, inhabitedLocality, street, houseNumber, housingNumber, buildingNumber, apartmentNumber, roomNumber, fullAddress);
  }

  public static RuAddressDtoBuilder builder() {
    return new RuAddressDtoBuilder();
  }
}
