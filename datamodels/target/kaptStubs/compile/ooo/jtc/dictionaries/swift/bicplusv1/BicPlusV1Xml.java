package ooo.jtc.dictionaries.swift.bicplusv1;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J=\u0010\u001a\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011\u00a8\u0006!"}, d2 = {"Looo/jtc/dictionaries/swift/bicplusv1/BicPlusV1Xml;", "", "product", "", "filetype", "filedate", "bicPlusV1NodeList", "", "Looo/jtc/dictionaries/swift/bicplusv1/BicPlusV1Node;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBicPlusV1NodeList", "()Ljava/util/List;", "setBicPlusV1NodeList", "(Ljava/util/List;)V", "getFiledate", "()Ljava/lang/String;", "setFiledate", "(Ljava/lang/String;)V", "getFiletype", "setFiletype", "getProduct", "setProduct", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.github.pozo.KotlinBuilder()
@com.fasterxml.jackson.annotation.JsonRootName(value = "dataexport")
public final class BicPlusV1Xml {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String product;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String filetype;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String filedate;
    @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper(useWrapping = false)
    private java.util.List<ooo.jtc.dictionaries.swift.bicplusv1.BicPlusV1Node> bicPlusV1NodeList;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProduct() {
        return null;
    }
    
    public final void setProduct(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFiletype() {
        return null;
    }
    
    public final void setFiletype(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFiledate() {
        return null;
    }
    
    public final void setFiledate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.dictionaries.swift.bicplusv1.BicPlusV1Node> getBicPlusV1NodeList() {
        return null;
    }
    
    public final void setBicPlusV1NodeList(@org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.dictionaries.swift.bicplusv1.BicPlusV1Node> p0) {
    }
    
    public BicPlusV1Xml(@org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty(isAttribute = true)
    java.lang.String product, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty(isAttribute = true)
    java.lang.String filetype, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty(isAttribute = true)
    java.lang.String filedate, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "bicplus_v1")
    java.util.List<ooo.jtc.dictionaries.swift.bicplusv1.BicPlusV1Node> bicPlusV1NodeList) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.dictionaries.swift.bicplusv1.BicPlusV1Node> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.swift.bicplusv1.BicPlusV1Xml copy(@org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty(isAttribute = true)
    java.lang.String product, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty(isAttribute = true)
    java.lang.String filetype, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty(isAttribute = true)
    java.lang.String filedate, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "bicplus_v1")
    java.util.List<ooo.jtc.dictionaries.swift.bicplusv1.BicPlusV1Node> bicPlusV1NodeList) {
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