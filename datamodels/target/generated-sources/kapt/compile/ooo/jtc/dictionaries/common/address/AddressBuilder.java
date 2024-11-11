package ooo.jtc.dictionaries.common.address;

import java.lang.String;

public final class AddressBuilder {
  private String addressType;

  private RuAddress ruAddress;

  private ForeignAddress foreignAddress;

  public AddressBuilder setAddressType(String addressType) {
    this.addressType = addressType;
    return this;
  }

  public AddressBuilder setRuAddress(RuAddress ruAddress) {
    this.ruAddress = ruAddress;
    return this;
  }

  public AddressBuilder setForeignAddress(ForeignAddress foreignAddress) {
    this.foreignAddress = foreignAddress;
    return this;
  }

  public Address create() {
    return new Address(addressType, ruAddress, foreignAddress);
  }

  public static AddressBuilder builder() {
    return new AddressBuilder();
  }
}
