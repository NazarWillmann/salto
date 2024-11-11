package ooo.jtc.dictionaries.common.address;

import java.lang.String;

public final class AddressDtoBuilder {
  private String addressType;

  private RuAddressDto russian;

  private ForeignAddressDto foreign;

  public AddressDtoBuilder setAddressType(String addressType) {
    this.addressType = addressType;
    return this;
  }

  public AddressDtoBuilder setRussian(RuAddressDto russian) {
    this.russian = russian;
    return this;
  }

  public AddressDtoBuilder setForeign(ForeignAddressDto foreign) {
    this.foreign = foreign;
    return this;
  }

  public AddressDto create() {
    return new AddressDto(addressType, russian, foreign);
  }

  public static AddressDtoBuilder builder() {
    return new AddressDtoBuilder();
  }
}
