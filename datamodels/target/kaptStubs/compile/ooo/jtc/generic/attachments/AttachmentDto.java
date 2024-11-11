package ooo.jtc.generic.attachments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\b\u0017\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\rR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d\u00a8\u0006$"}, d2 = {"Looo/jtc/generic/attachments/AttachmentDto;", "", "id", "Ljava/util/UUID;", "documentId", "fileId", "fileName", "", "contentType", "dataSize", "", "dataHash", "accessToken", "(Ljava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "getContentType", "setContentType", "getDataHash", "setDataHash", "getDataSize", "()I", "setDataSize", "(I)V", "getDocumentId", "()Ljava/util/UUID;", "setDocumentId", "(Ljava/util/UUID;)V", "getFileId", "setFileId", "getFileName", "setFileName", "getId", "setId", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.github.pozo.KotlinBuilder()
public class AttachmentDto {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID documentId;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID fileId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fileName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String contentType;
    private int dataSize;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String dataHash;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String accessToken;
    
    @org.jetbrains.annotations.Nullable()
    public java.util.UUID getId() {
        return null;
    }
    
    public void setId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.util.UUID getDocumentId() {
        return null;
    }
    
    public void setDocumentId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.util.UUID getFileId() {
        return null;
    }
    
    public void setFileId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getFileName() {
        return null;
    }
    
    public void setFileName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getContentType() {
        return null;
    }
    
    public void setContentType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public int getDataSize() {
        return 0;
    }
    
    public void setDataSize(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getDataHash() {
        return null;
    }
    
    public void setDataHash(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getAccessToken() {
        return null;
    }
    
    public void setAccessToken(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public AttachmentDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, @org.jetbrains.annotations.Nullable()
    java.util.UUID documentId, @org.jetbrains.annotations.Nullable()
    java.util.UUID fileId, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName, @org.jetbrains.annotations.Nullable()
    java.lang.String contentType, int dataSize, @org.jetbrains.annotations.Nullable()
    java.lang.String dataHash, @org.jetbrains.annotations.Nullable()
    java.lang.String accessToken) {
        super();
    }
}