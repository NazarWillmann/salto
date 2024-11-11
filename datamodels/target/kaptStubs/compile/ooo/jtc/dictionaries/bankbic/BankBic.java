package ooo.jtc.dictionaries.bankbic;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bN\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00dd\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0017\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0002\u0010\u001eJ\u000b\u0010U\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010W\u001a\u00020\u0007H\u00c6\u0003J\t\u0010X\u001a\u00020\u0007H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0007H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0013H\u00c6\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\t\u0010\\\u001a\u00020\u0007H\u00c6\u0003J\u0011\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u00c6\u0003J\u0011\u0010^\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0017H\u00c6\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u001cH\u00c6\u0003J\t\u0010`\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u001cH\u00c6\u0003J\t\u0010b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010c\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u00f5\u0001\u0010i\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\u000f\u001a\u00020\u00072\b\b\u0003\u0010\u0010\u001a\u00020\u00072\b\b\u0003\u0010\u0011\u001a\u00020\u00072\b\b\u0003\u0010\u0012\u001a\u00020\u00132\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00072\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00172\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u00c6\u0001J\u0013\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010mH\u00d6\u0003J\n\u0010n\u001a\u0004\u0018\u00010\u0018H\u0007J\t\u0010o\u001a\u00020\u0005H\u00d6\u0001J\b\u0010p\u001a\u00020qH\u0016J\t\u0010r\u001a\u00020\u0007H\u00d6\u0001R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010$\"\u0004\b(\u0010&R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00102\"\u0004\b6\u00104R \u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010.\"\u0004\b8\u00100R\u0016\u00109\u001a\u00020\u00078\u0016X\u0097D\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010$\"\u0004\bD\u0010&R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010$\"\u0004\bF\u0010&R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010$\"\u0004\bH\u0010&R\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010&R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010 \"\u0004\bL\u0010\"R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010$\"\u0004\bN\u0010&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010$\"\u0004\bT\u0010&\u00a8\u0006s"}, d2 = {"Looo/jtc/dictionaries/bankbic/BankBic;", "Looo/jtc/interfaces/ITransferEntity;", "id", "Ljava/util/UUID;", "version", "", "bic", "", "name", "countryAlpha2Code", "zip", "locationType", "location", "address", "parentBic", "participantTransferType", "participantType", "allowedServices", "dateIn", "Ljava/time/LocalDate;", "dateOut", "status", "accounts", "", "Looo/jtc/dictionaries/bankbic/acc/BankBicAccount;", "restrictions", "Looo/jtc/dictionaries/bankbic/restr/BankBicRestriction;", "createdAt", "Ljava/sql/Timestamp;", "deletedAt", "(Ljava/util/UUID;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/time/LocalDate;Ljava/time/LocalDate;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/sql/Timestamp;Ljava/sql/Timestamp;)V", "getAccounts", "()Ljava/util/List;", "setAccounts", "(Ljava/util/List;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getAllowedServices", "setAllowedServices", "getBic", "setBic", "getCountryAlpha2Code", "setCountryAlpha2Code", "getCreatedAt", "()Ljava/sql/Timestamp;", "setCreatedAt", "(Ljava/sql/Timestamp;)V", "getDateIn", "()Ljava/time/LocalDate;", "setDateIn", "(Ljava/time/LocalDate;)V", "getDateOut", "setDateOut", "getDeletedAt", "setDeletedAt", "entityName", "getEntityName", "getId", "()Ljava/util/UUID;", "setId", "(Ljava/util/UUID;)V", "getLocation", "setLocation", "getLocationType", "setLocationType", "getName", "setName", "getParentBic", "setParentBic", "getParticipantTransferType", "setParticipantTransferType", "getParticipantType", "setParticipantType", "getRestrictions", "setRestrictions", "getStatus", "setStatus", "getVersion", "()I", "setVersion", "(I)V", "getZip", "setZip", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "getSingleOrNullActiveAccount", "hashCode", "toDto", "Looo/jtc/dictionaries/bankbic/BankBicDto;", "toString", "datamodels"})
@com.github.pozo.KotlinBuilder()
public final class BankBic implements ooo.jtc.interfaces.ITransferEntity {
    @org.jetbrains.annotations.NotNull()
    @ooo.jtc.annotations.NotRequiredForTest()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    private final java.lang.String entityName = "\u0411\u0418\u041a \u0420\u0424";
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String bic;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String countryAlpha2Code;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String zip;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String locationType;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String location;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String address;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String parentBic;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String participantTransferType;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String participantType;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String allowedServices;
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDate dateIn;
    @org.jetbrains.annotations.Nullable()
    private java.time.LocalDate dateOut;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String status;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<ooo.jtc.dictionaries.bankbic.acc.BankBicAccount> accounts;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction> restrictions;
    @org.jetbrains.annotations.Nullable()
    @ooo.jtc.annotations.NotRequiredForTest()
    private java.sql.Timestamp createdAt;
    @org.jetbrains.annotations.Nullable()
    @ooo.jtc.annotations.NotRequiredForTest()
    private java.sql.Timestamp deletedAt;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getEntityName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.dictionaries.bankbic.BankBicDto toDto() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    public final ooo.jtc.dictionaries.bankbic.acc.BankBicAccount getSingleOrNullActiveAccount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.util.UUID getId() {
        return null;
    }
    
    @java.lang.Override()
    public void setId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @java.lang.Override()
    public int getVersion() {
        return 0;
    }
    
    @java.lang.Override()
    public void setVersion(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBic() {
        return null;
    }
    
    public final void setBic(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCountryAlpha2Code() {
        return null;
    }
    
    public final void setCountryAlpha2Code(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getZip() {
        return null;
    }
    
    public final void setZip(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLocationType() {
        return null;
    }
    
    public final void setLocationType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAddress() {
        return null;
    }
    
    public final void setAddress(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParentBic() {
        return null;
    }
    
    public final void setParentBic(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getParticipantTransferType() {
        return null;
    }
    
    public final void setParticipantTransferType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getParticipantType() {
        return null;
    }
    
    public final void setParticipantType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAllowedServices() {
        return null;
    }
    
    public final void setAllowedServices(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getDateIn() {
        return null;
    }
    
    public final void setDateIn(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate getDateOut() {
        return null;
    }
    
    public final void setDateOut(@org.jetbrains.annotations.Nullable()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.dictionaries.bankbic.acc.BankBicAccount> getAccounts() {
        return null;
    }
    
    public final void setAccounts(@org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.dictionaries.bankbic.acc.BankBicAccount> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction> getRestrictions() {
        return null;
    }
    
    public final void setRestrictions(@org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.sql.Timestamp p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp getDeletedAt() {
        return null;
    }
    
    public final void setDeletedAt(@org.jetbrains.annotations.Nullable()
    java.sql.Timestamp p0) {
    }
    
    public BankBic(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String bic, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "country_alpha2_code")
    java.lang.String countryAlpha2Code, @org.jetbrains.annotations.Nullable()
    java.lang.String zip, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "location_type")
    java.lang.String locationType, @org.jetbrains.annotations.Nullable()
    java.lang.String location, @org.jetbrains.annotations.Nullable()
    java.lang.String address, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "parent_bic")
    java.lang.String parentBic, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "transfer_type")
    java.lang.String participantTransferType, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "participant_type")
    java.lang.String participantType, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "allowed_services")
    java.lang.String allowedServices, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "date_in")
    java.time.LocalDate dateIn, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "date_out")
    java.time.LocalDate dateOut, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.dictionaries.bankbic.acc.BankBicAccount> accounts, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction> restrictions, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "created_at")
    java.sql.Timestamp createdAt, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "deleted_at")
    java.sql.Timestamp deletedAt) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.dictionaries.bankbic.acc.BankBicAccount> component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction> component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.bankbic.BankBic copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String bic, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "country_alpha2_code")
    java.lang.String countryAlpha2Code, @org.jetbrains.annotations.Nullable()
    java.lang.String zip, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "location_type")
    java.lang.String locationType, @org.jetbrains.annotations.Nullable()
    java.lang.String location, @org.jetbrains.annotations.Nullable()
    java.lang.String address, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "parent_bic")
    java.lang.String parentBic, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "transfer_type")
    java.lang.String participantTransferType, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "participant_type")
    java.lang.String participantType, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "allowed_services")
    java.lang.String allowedServices, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "date_in")
    java.time.LocalDate dateIn, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "date_out")
    java.time.LocalDate dateOut, @org.jetbrains.annotations.NotNull()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.dictionaries.bankbic.acc.BankBicAccount> accounts, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction> restrictions, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "created_at")
    java.sql.Timestamp createdAt, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "deleted_at")
    java.sql.Timestamp deletedAt) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}