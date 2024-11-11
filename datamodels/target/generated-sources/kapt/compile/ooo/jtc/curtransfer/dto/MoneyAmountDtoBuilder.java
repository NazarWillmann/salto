package ooo.jtc.curtransfer.dto;

import java.math.BigDecimal;
import ooo.jtc.dictionaries.currency.ReducedCurrencyDto;

public final class MoneyAmountDtoBuilder {
  private BigDecimal amount;

  private ReducedCurrencyDto currency;

  public MoneyAmountDtoBuilder setAmount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  public MoneyAmountDtoBuilder setCurrency(ReducedCurrencyDto currency) {
    this.currency = currency;
    return this;
  }

  public MoneyAmountDto create() {
    return new MoneyAmountDto(amount, currency);
  }

  public static MoneyAmountDtoBuilder builder() {
    return new MoneyAmountDtoBuilder();
  }
}
