package ooo.jtc.dictionaries.account;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bf\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0089\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u0012\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010!\u001a\u00020\"\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$\u0012\b\u0010&\u001a\u0004\u0018\u00010\'\u00a2\u0006\u0002\u0010(J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010p\u001a\u00020\u0003H\u00c6\u0003J\t\u0010q\u001a\u00020\fH\u00c6\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\t\u0010u\u001a\u00020\u0012H\u00c6\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\t\u0010x\u001a\u00020\fH\u00c6\u0003J\t\u0010y\u001a\u00020\u0019H\u00c6\u0003J\t\u0010z\u001a\u00020\u0005H\u00c6\u0003J\t\u0010{\u001a\u00020\u001bH\u00c6\u0003J\t\u0010|\u001a\u00020\u001bH\u00c6\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u001bH\u00c6\u0003J\t\u0010~\u001a\u00020\u0012H\u00c6\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001bH\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\"H\u00c6\u0003J\u0010\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020%0$H\u00c6\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\'H\u00c6\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\n\u0010\u0089\u0001\u001a\u00020\fH\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\fH\u00c6\u0003J\u00c6\u0002\u0010\u008b\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010!\u001a\u00020\"2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\'H\u00c6\u0001J\u0016\u0010\u008c\u0001\u001a\u00020\u00192\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u00d6\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0005H\u00d6\u0001J\n\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0016J\u0007\u0010\u0092\u0001\u001a\u00020\u0000J\n\u0010\u0093\u0001\u001a\u00020\fH\u00d6\u0001R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u001c\u0010&\u001a\u0004\u0018\u00010\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u001e\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u00108\"\u0004\bD\u0010:R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u00104\"\u0004\bF\u00106R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u00104\"\u0004\bH\u00106R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u00104\"\u0004\bJ\u00106R\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u00108\"\u0004\bL\u0010:R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010<\"\u0004\bN\u0010>R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010*\"\u0004\bP\u0010,R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010*\"\u0004\bR\u0010,R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u00104\"\u0004\bT\u00106R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010*\"\u0004\bV\u0010,R \u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u00104\"\u0004\b\\\u00106R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u00104\"\u0004\b^\u00106R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010*\"\u0004\b`\u0010,R\u001a\u0010\u0014\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010<\"\u0004\bb\u0010>R\u001a\u0010\u001c\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u00108\"\u0004\bd\u0010:R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010<\"\u0004\bf\u0010>R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010<\"\u0004\bh\u0010>R\u001a\u0010\u000f\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010*\"\u0004\bj\u0010,R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010n\u00a8\u0006\u0094\u0001"}, d2 = {"Looo/jtc/dictionaries/account/AccountDto;", "Looo/jtc/interfaces/UpdateIEntityDto;", "id", "Ljava/util/UUID;", "version", "", "branchCustomerId", "customerId", "branchIndividualId", "individualId", "branchId", "accountNumber", "", "accountKind", "accountTypeId", "state", "name", "reserveBeginDate", "Ljava/time/ZonedDateTime;", "reserveEndDate", "openDate", "closeDate", "currencyAlphaCode", "currencyDigitCode", "isMarkInfo", "", "actualBalance", "Ljava/math/BigDecimal;", "planBalance", "blockedAmount", "actualDate", "description", "cardAmount", "block", "Looo/jtc/dictionaries/common/BlockingInfoDto;", "extIds", "", "Looo/jtc/dictionaries/common/extid/ExtIdDto;", "accountType", "Looo/jtc/dictionaries/accountype/AccountTypeDto;", "(Ljava/util/UUID;ILjava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/time/ZonedDateTime;Ljava/time/ZonedDateTime;Ljava/time/ZonedDateTime;Ljava/time/ZonedDateTime;Ljava/lang/String;Ljava/lang/String;ZLjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/time/ZonedDateTime;Ljava/lang/String;Ljava/math/BigDecimal;Looo/jtc/dictionaries/common/BlockingInfoDto;Ljava/util/List;Looo/jtc/dictionaries/accountype/AccountTypeDto;)V", "getAccountKind", "()Ljava/lang/String;", "setAccountKind", "(Ljava/lang/String;)V", "getAccountNumber", "setAccountNumber", "getAccountType", "()Looo/jtc/dictionaries/accountype/AccountTypeDto;", "setAccountType", "(Looo/jtc/dictionaries/accountype/AccountTypeDto;)V", "getAccountTypeId", "()Ljava/util/UUID;", "setAccountTypeId", "(Ljava/util/UUID;)V", "getActualBalance", "()Ljava/math/BigDecimal;", "setActualBalance", "(Ljava/math/BigDecimal;)V", "getActualDate", "()Ljava/time/ZonedDateTime;", "setActualDate", "(Ljava/time/ZonedDateTime;)V", "getBlock", "()Looo/jtc/dictionaries/common/BlockingInfoDto;", "setBlock", "(Looo/jtc/dictionaries/common/BlockingInfoDto;)V", "getBlockedAmount", "setBlockedAmount", "getBranchCustomerId", "setBranchCustomerId", "getBranchId", "setBranchId", "getBranchIndividualId", "setBranchIndividualId", "getCardAmount", "setCardAmount", "getCloseDate", "setCloseDate", "getCurrencyAlphaCode", "setCurrencyAlphaCode", "getCurrencyDigitCode", "setCurrencyDigitCode", "getCustomerId", "setCustomerId", "getDescription", "setDescription", "getExtIds", "()Ljava/util/List;", "setExtIds", "(Ljava/util/List;)V", "getId", "setId", "getIndividualId", "setIndividualId", "getName", "setName", "getOpenDate", "setOpenDate", "getPlanBalance", "setPlanBalance", "getReserveBeginDate", "setReserveBeginDate", "getReserveEndDate", "setReserveEndDate", "getState", "setState", "getVersion", "()I", "setVersion", "(I)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toModel", "Looo/jtc/dictionaries/account/Account;", "toReducedDto", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@ooo.jtc.annotations.EntityName(name = "\u0421\u0447\u0435\u0442")
@com.github.pozo.KotlinBuilder()
public final class AccountDto implements ooo.jtc.interfaces.UpdateIEntityDto<ooo.jtc.dictionaries.account.AccountDto> {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID branchCustomerId;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID customerId;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID branchIndividualId;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID individualId;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID branchId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String accountNumber;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String accountKind;
    @org.jetbrains.annotations.NotNull()
    private java.util.UUID accountTypeId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String state;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    private java.time.ZonedDateTime reserveBeginDate;
    @org.jetbrains.annotations.Nullable()
    private java.time.ZonedDateTime reserveEndDate;
    @org.jetbrains.annotations.NotNull()
    private java.time.ZonedDateTime openDate;
    @org.jetbrains.annotations.Nullable()
    private java.time.ZonedDateTime closeDate;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String currencyAlphaCode;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currencyDigitCode;
    public boolean isMarkInfo;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal actualBalance;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal planBalance;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal blockedAmount;
    @org.jetbrains.annotations.NotNull()
    private java.time.ZonedDateTime actualDate;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String description;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal cardAmount;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.dictionaries.common.BlockingInfoDto block;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<ooo.jtc.dictionaries.common.extid.ExtIdDto> extIds;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.dictionaries.accountype.AccountTypeDto accountType;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.dictionaries.account.Account toModel() {
        return null;
    }
    
    /**
     * Null fields [branchId, customerId, individualId, accountType].
     * These don't return in responses when editing account dictionary (calling Create/Update/Delete methods)
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.account.AccountDto toReducedDto() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getBranchCustomerId() {
        return null;
    }
    
    public final void setBranchCustomerId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getCustomerId() {
        return null;
    }
    
    public final void setCustomerId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getBranchIndividualId() {
        return null;
    }
    
    public final void setBranchIndividualId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getIndividualId() {
        return null;
    }
    
    public final void setIndividualId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getBranchId() {
        return null;
    }
    
    public final void setBranchId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAccountNumber() {
        return null;
    }
    
    public final void setAccountNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAccountKind() {
        return null;
    }
    
    public final void setAccountKind(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getAccountTypeId() {
        return null;
    }
    
    public final void setAccountTypeId(@org.jetbrains.annotations.NotNull()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime getReserveBeginDate() {
        return null;
    }
    
    public final void setReserveBeginDate(@org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime getReserveEndDate() {
        return null;
    }
    
    public final void setReserveEndDate(@org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.ZonedDateTime getOpenDate() {
        return null;
    }
    
    public final void setOpenDate(@org.jetbrains.annotations.NotNull()
    java.time.ZonedDateTime p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime getCloseDate() {
        return null;
    }
    
    public final void setCloseDate(@org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrencyAlphaCode() {
        return null;
    }
    
    public final void setCurrencyAlphaCode(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrencyDigitCode() {
        return null;
    }
    
    public final void setCurrencyDigitCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getActualBalance() {
        return null;
    }
    
    public final void setActualBalance(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getPlanBalance() {
        return null;
    }
    
    public final void setPlanBalance(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getBlockedAmount() {
        return null;
    }
    
    public final void setBlockedAmount(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.ZonedDateTime getActualDate() {
        return null;
    }
    
    public final void setActualDate(@org.jetbrains.annotations.NotNull()
    java.time.ZonedDateTime p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getCardAmount() {
        return null;
    }
    
    public final void setCardAmount(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.common.BlockingInfoDto getBlock() {
        return null;
    }
    
    public final void setBlock(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.common.BlockingInfoDto p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.dictionaries.common.extid.ExtIdDto> getExtIds() {
        return null;
    }
    
    public final void setExtIds(@org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.dictionaries.common.extid.ExtIdDto> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.dictionaries.accountype.AccountTypeDto getAccountType() {
        return null;
    }
    
    public final void setAccountType(@org.jetbrains.annotations.Nullable()
    ooo.jtc.dictionaries.accountype.AccountTypeDto p0) {
    }
    
    public AccountDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchCustomerId, @org.jetbrains.annotations.Nullable()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchIndividualId, @org.jetbrains.annotations.Nullable()
    java.util.UUID individualId, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchId, @org.jetbrains.annotations.NotNull()
    java.lang.String accountNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String accountKind, @org.jetbrains.annotations.NotNull()
    java.util.UUID accountTypeId, @org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime reserveBeginDate, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime reserveEndDate, @org.jetbrains.annotations.NotNull()
    java.time.ZonedDateTime openDate, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime closeDate, @org.jetbrains.annotations.Nullable()
    java.lang.String currencyAlphaCode, @org.jetbrains.annotations.NotNull()
    java.lang.String currencyDigitCode, boolean isMarkInfo, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal actualBalance, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal planBalance, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal blockedAmount, @org.jetbrains.annotations.NotNull()
    java.time.ZonedDateTime actualDate, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal cardAmount, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.common.BlockingInfoDto block, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.dictionaries.common.extid.ExtIdDto> extIds, @org.jetbrains.annotations.Nullable()
    ooo.jtc.dictionaries.accountype.AccountTypeDto accountType) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    public java.lang.String getEntityName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.ZonedDateTime component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    public final boolean component19() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.ZonedDateTime component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.common.BlockingInfoDto component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.dictionaries.common.extid.ExtIdDto> component27() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.dictionaries.accountype.AccountTypeDto component28() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.account.AccountDto copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchCustomerId, @org.jetbrains.annotations.Nullable()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchIndividualId, @org.jetbrains.annotations.Nullable()
    java.util.UUID individualId, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchId, @org.jetbrains.annotations.NotNull()
    java.lang.String accountNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String accountKind, @org.jetbrains.annotations.NotNull()
    java.util.UUID accountTypeId, @org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime reserveBeginDate, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime reserveEndDate, @org.jetbrains.annotations.NotNull()
    java.time.ZonedDateTime openDate, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime closeDate, @org.jetbrains.annotations.Nullable()
    java.lang.String currencyAlphaCode, @org.jetbrains.annotations.NotNull()
    java.lang.String currencyDigitCode, boolean isMarkInfo, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal actualBalance, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal planBalance, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal blockedAmount, @org.jetbrains.annotations.NotNull()
    java.time.ZonedDateTime actualDate, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal cardAmount, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.common.BlockingInfoDto block, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.dictionaries.common.extid.ExtIdDto> extIds, @org.jetbrains.annotations.Nullable()
    ooo.jtc.dictionaries.accountype.AccountTypeDto accountType) {
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