package ooo.jtc.news.dto;

import java.lang.String;
import java.util.UUID;

public final class NewsAttachmentDtoBuilder {
  private UUID id;

  private UUID documentId;

  private UUID fileId;

  private String fileName;

  private int dataSize;

  private String accessToken;

  private String contentType;

  private String dataHash;

  private String fileLinkText;

  public NewsAttachmentDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public NewsAttachmentDtoBuilder setDocumentId(UUID documentId) {
    this.documentId = documentId;
    return this;
  }

  public NewsAttachmentDtoBuilder setFileId(UUID fileId) {
    this.fileId = fileId;
    return this;
  }

  public NewsAttachmentDtoBuilder setFileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  public NewsAttachmentDtoBuilder setDataSize(int dataSize) {
    this.dataSize = dataSize;
    return this;
  }

  public NewsAttachmentDtoBuilder setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  public NewsAttachmentDtoBuilder setContentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  public NewsAttachmentDtoBuilder setDataHash(String dataHash) {
    this.dataHash = dataHash;
    return this;
  }

  public NewsAttachmentDtoBuilder setFileLinkText(String fileLinkText) {
    this.fileLinkText = fileLinkText;
    return this;
  }

  public NewsAttachmentDto create() {
    return new NewsAttachmentDto(id, documentId, fileId, fileName, dataSize, accessToken, contentType, dataHash, fileLinkText);
  }

  public static NewsAttachmentDtoBuilder builder() {
    return new NewsAttachmentDtoBuilder();
  }
}
