package ooo.jtc.generic;

import java.lang.System;

@org.mapstruct.Named(value = "CustomConverter")
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tH\u0007J\"\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0007J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\rH\u0007\u00a8\u0006\u000f"}, d2 = {"Looo/jtc/generic/CustomConverter;", "", "()V", "localDateTimeToTimestamp", "Ljava/sql/Timestamp;", "source", "Ljava/time/LocalDateTime;", "mapToString", "", "", "stringToMap", "timestampToLocalDateTime", "timestampToZonedDateTime", "Ljava/time/ZonedDateTime;", "zonedDateTimeToTimestamp", "datamodels"})
public final class CustomConverter {
    
    @org.jetbrains.annotations.Nullable()
    @org.mapstruct.Named(value = "TimestampToLocalDateTime")
    public final java.time.LocalDateTime timestampToLocalDateTime(@org.jetbrains.annotations.Nullable()
    java.sql.Timestamp source) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.mapstruct.Named(value = "LocalDateTimeToTimestamp")
    public final java.sql.Timestamp localDateTimeToTimestamp(@org.jetbrains.annotations.Nullable()
    java.time.LocalDateTime source) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.mapstruct.Named(value = "TimestampToZonedDateTime")
    public final java.time.ZonedDateTime timestampToZonedDateTime(@org.jetbrains.annotations.Nullable()
    java.sql.Timestamp source) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.mapstruct.Named(value = "ZonedDateTimeToTimestamp")
    public final java.sql.Timestamp zonedDateTimeToTimestamp(@org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime source) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.mapstruct.Named(value = "StringToMap")
    public final java.util.Map<java.lang.String, java.lang.Object> stringToMap(@org.jetbrains.annotations.Nullable()
    java.lang.String source) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @org.mapstruct.Named(value = "MapToString")
    public final java.lang.String mapToString(@org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, ? extends java.lang.Object> source) {
        return null;
    }
    
    public CustomConverter() {
        super();
    }
}