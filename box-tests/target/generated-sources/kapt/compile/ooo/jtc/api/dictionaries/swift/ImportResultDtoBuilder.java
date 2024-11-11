package ooo.jtc.api.dictionaries.swift;

public final class ImportResultDtoBuilder {
  private int total;

  public ImportResultDtoBuilder setTotal(int total) {
    this.total = total;
    return this;
  }

  public ImportResultDto create() {
    return new ImportResultDto(total);
  }

  public static ImportResultDtoBuilder builder() {
    return new ImportResultDtoBuilder();
  }
}
