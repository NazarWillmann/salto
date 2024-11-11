package ooo.jtc.random;

import java.lang.System;

@kotlin.Suppress(names = {"UNCHECKED_CAST"})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b \b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00016B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0005J\u001c\u0010\u0019\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u0017J\u0012\u0010\u001c\u001a\u00020\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\u0010\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u0017J\u0006\u0010\u001e\u001a\u00020\u0005J\u0010\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0002J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\'\u001a\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0002J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010-\u001a\u00020\u0005H\u0002J\u001c\u0010.\u001a\u00020\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0010\u0010/\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0006\u00100\u001a\u00020\u0005J\u0010\u00101\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0006\u00102\u001a\u00020\u0005J\u0006\u00103\u001a\u00020\u0005J\u0006\u00104\u001a\u00020\u0005J\u0006\u00105\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Looo/jtc/random/RandomNameUtils;", "", "()V", "addressData", "", "", "companyData", "companyInternationalSuffixData", "", "companyPrefixData", "nameData", "randData", "", "anyFirstName", "anyFullName", "order", "Looo/jtc/random/FullNameOrder;", "anyLastName", "anyMiddleName", "bankFullName", "shortName", "bankShortName", "isChild", "", "city", "companyFullName", "companyShortName", "isIP", "companyInternationalFullName", "companyInternationalShortName", "femaleFirstName", "femaleFullName", "femaleLastName", "femaleMiddleName", "getCompanyInternationalNameList", "getCompanyInternationalSuffix", "suffixType", "getCompanyNameList", "getCompanyPrefix", "prefixType", "getFullCompanyPrefix", "shortPrefixName", "getFullInternationalCompanySuffix", "shortSuffixName", "getNameList", "listName", "ipFullName", "ipShortName", "maleFirstName", "maleFullName", "maleLastName", "maleMiddleName", "state", "street", "AffixType", "qa-utils"})
public final class RandomNameUtils {
    private static final java.util.Map<java.lang.String, java.lang.Object> randData = null;
    private static final java.util.Map<java.lang.String, java.util.List<java.lang.String>> nameData = null;
    private static final java.util.Map<java.lang.String, java.lang.Object> companyData = null;
    private static final java.util.List<java.util.Map<java.lang.String, java.lang.String>> companyPrefixData = null;
    private static final java.util.List<java.util.Map<java.lang.String, java.lang.String>> companyInternationalSuffixData = null;
    private static final java.util.Map<java.lang.String, java.lang.Object> addressData = null;
    public static final ooo.jtc.random.RandomNameUtils INSTANCE = null;
    
    private final java.util.List<java.lang.String> getNameList(java.lang.String listName) {
        return null;
    }
    
    private final java.lang.String getCompanyPrefix(java.lang.String prefixType) {
        return null;
    }
    
    private final java.lang.String getCompanyInternationalSuffix(java.lang.String suffixType) {
        return null;
    }
    
    private final java.lang.String getFullCompanyPrefix(java.lang.String shortPrefixName) {
        return null;
    }
    
    private final java.lang.String getFullInternationalCompanySuffix(java.lang.String shortSuffixName) {
        return null;
    }
    
    private final java.util.List<java.lang.String> getCompanyNameList() {
        return null;
    }
    
    private final java.util.List<java.lang.String> getCompanyInternationalNameList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String anyFirstName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String maleFirstName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String femaleFirstName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String anyMiddleName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String maleMiddleName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String femaleMiddleName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String anyLastName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String maleLastName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String femaleLastName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String anyFullName(@org.jetbrains.annotations.NotNull()
    ooo.jtc.random.FullNameOrder order) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String maleFullName(@org.jetbrains.annotations.NotNull()
    ooo.jtc.random.FullNameOrder order) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String femaleFullName(@org.jetbrains.annotations.NotNull()
    ooo.jtc.random.FullNameOrder order) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String companyShortName(boolean isIP) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String companyFullName(@org.jetbrains.annotations.Nullable()
    java.lang.String companyShortName, boolean isIP) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String ipShortName(@org.jetbrains.annotations.NotNull()
    ooo.jtc.random.FullNameOrder order) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String ipFullName(@org.jetbrains.annotations.Nullable()
    java.lang.String ipShortName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.random.FullNameOrder order) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String companyInternationalShortName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String companyInternationalFullName(@org.jetbrains.annotations.Nullable()
    java.lang.String companyInternationalShortName) {
        return null;
    }
    
    /**
     * Prepare correct bank short name.
     * [isChild] - flag for filial (sub-branch)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String bankShortName(boolean isChild) {
        return null;
    }
    
    /**
     * Prepare correct bank full name by [shortName].
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String bankFullName(@org.jetbrains.annotations.NotNull()
    java.lang.String shortName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String city() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String state() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String street() {
        return null;
    }
    
    private RandomNameUtils() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Looo/jtc/random/RandomNameUtils$AffixType;", "", "()V", "full", "", "short", "qa-utils"})
    static final class AffixType {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String full = "full";
        public static final ooo.jtc.random.RandomNameUtils.AffixType INSTANCE = null;
        
        private AffixType() {
            super();
        }
    }
}