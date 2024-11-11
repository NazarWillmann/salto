package ooo.jtc.generic.print;

import java.lang.String;

public final class PrintResponseDtoBuilder {
  private String source;

  private String fileName;

  private int contentLength;

  private String contentType;

  private PrintRange range;

  public PrintResponseDtoBuilder setSource(String source) {
    this.source = source;
    return this;
  }

  public PrintResponseDtoBuilder setFileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  public PrintResponseDtoBuilder setContentLength(int contentLength) {
    this.contentLength = contentLength;
    return this;
  }

  public PrintResponseDtoBuilder setContentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  public PrintResponseDtoBuilder setRange(PrintRange range) {
    this.range = range;
    return this;
  }

  public PrintResponseDto create() {
    return new PrintResponseDto(source, fileName, contentLength, contentType, range);
  }

  public static PrintResponseDtoBuilder builder() {
    return new PrintResponseDtoBuilder();
  }
}
