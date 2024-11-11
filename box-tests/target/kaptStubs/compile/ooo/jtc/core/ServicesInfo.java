package ooo.jtc.core;

import java.lang.System;

/**
 * Object for store list of services
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0012J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\u009f\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010F\u001a\u00020GH\u00d6\u0001J\t\u0010H\u001a\u00020IH\u00d6\u0001R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u0016\u00a8\u0006J"}, d2 = {"Looo/jtc/core/ServicesInfo;", "", "oauth", "Looo/jtc/core/ServiceInfo;", "uaa", "uaaManagement", "sign", "dictionary", "rkoDictionary", "rkoRupayment", "rkoStatement", "letter", "fsSystem", "crypto", "news", "curRko", "salary", "domainController", "(Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;Looo/jtc/core/ServiceInfo;)V", "getCrypto", "()Looo/jtc/core/ServiceInfo;", "setCrypto", "(Looo/jtc/core/ServiceInfo;)V", "getCurRko", "setCurRko", "getDictionary", "setDictionary", "getDomainController", "setDomainController", "getFsSystem", "setFsSystem", "getLetter", "setLetter", "getNews", "setNews", "getOauth", "setOauth", "getRkoDictionary", "setRkoDictionary", "getRkoRupayment", "setRkoRupayment", "getRkoStatement", "setRkoStatement", "getSalary", "setSalary", "getSign", "setSign", "getUaa", "setUaa", "getUaaManagement", "setUaaManagement", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "box-tests"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public final class ServicesInfo {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo oauth;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo uaa;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo uaaManagement;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo sign;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo dictionary;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo rkoDictionary;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo rkoRupayment;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo rkoStatement;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo letter;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo fsSystem;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo crypto;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo news;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo curRko;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo salary;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.ServiceInfo domainController;
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getOauth() {
        return null;
    }
    
    public final void setOauth(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getUaa() {
        return null;
    }
    
    public final void setUaa(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getUaaManagement() {
        return null;
    }
    
    public final void setUaaManagement(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getSign() {
        return null;
    }
    
    public final void setSign(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getDictionary() {
        return null;
    }
    
    public final void setDictionary(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getRkoDictionary() {
        return null;
    }
    
    public final void setRkoDictionary(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getRkoRupayment() {
        return null;
    }
    
    public final void setRkoRupayment(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getRkoStatement() {
        return null;
    }
    
    public final void setRkoStatement(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getLetter() {
        return null;
    }
    
    public final void setLetter(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getFsSystem() {
        return null;
    }
    
    public final void setFsSystem(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getCrypto() {
        return null;
    }
    
    public final void setCrypto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getNews() {
        return null;
    }
    
    public final void setNews(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getCurRko() {
        return null;
    }
    
    public final void setCurRko(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getSalary() {
        return null;
    }
    
    public final void setSalary(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo getDomainController() {
        return null;
    }
    
    public final void setDomainController(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo p0) {
    }
    
    public ServicesInfo(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo oauth, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo uaa, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo uaaManagement, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo sign, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo dictionary, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo rkoDictionary, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo rkoRupayment, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo rkoStatement, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo letter, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo fsSystem, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo crypto, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo news, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo curRko, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo salary, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo domainController) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServiceInfo component15() {
        return null;
    }
    
    /**
     * Object for store list of services
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServicesInfo copy(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo oauth, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo uaa, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo uaaManagement, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo sign, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo dictionary, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo rkoDictionary, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo rkoRupayment, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo rkoStatement, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo letter, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo fsSystem, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo crypto, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo news, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo curRko, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo salary, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo domainController) {
        return null;
    }
    
    /**
     * Object for store list of services
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Object for store list of services
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Object for store list of services
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}