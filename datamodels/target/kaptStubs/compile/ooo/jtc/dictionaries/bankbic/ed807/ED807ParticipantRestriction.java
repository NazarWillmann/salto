package ooo.jtc.dictionaries.bankbic.ed807;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Looo/jtc/dictionaries/bankbic/ed807/ED807ParticipantRestriction;", "", "rstr", "", "rstrDate", "Ljava/time/LocalDate;", "(Ljava/lang/String;Ljava/time/LocalDate;)V", "getRstr", "()Ljava/lang/String;", "setRstr", "(Ljava/lang/String;)V", "getRstrDate", "()Ljava/time/LocalDate;", "setRstrDate", "(Ljava/time/LocalDate;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.github.pozo.KotlinBuilder()
@javax.xml.bind.annotation.XmlRootElement(name = "RstrList")
public final class ED807ParticipantRestriction {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String rstr;
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDate rstrDate;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRstr() {
        return null;
    }
    
    public final void setRstr(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getRstrDate() {
        return null;
    }
    
    public final void setRstrDate(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate p0) {
    }
    
    public ED807ParticipantRestriction(@org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty(isAttribute = true, localName = "Rstr")
    java.lang.String rstr, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty(isAttribute = true, localName = "RstrDate")
    java.time.LocalDate rstrDate) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.bankbic.ed807.ED807ParticipantRestriction copy(@org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty(isAttribute = true, localName = "Rstr")
    java.lang.String rstr, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty(isAttribute = true, localName = "RstrDate")
    java.time.LocalDate rstrDate) {
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