package ooo.jtc.rupayment.dto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bk\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u00a1\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\"\u0012\b\u0010&\u001a\u0004\u0018\u00010\'\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u00a2\u0006\u0002\u0010*J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003J\t\u0010x\u001a\u00020\u0016H\u00c6\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u001bH\u00c6\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u0010~\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010PJ\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0012\u0010\u0083\u0001\u001a\u0004\u0018\u00010\"H\u00c6\u0003\u00a2\u0006\u0003\u0010\u0084\u0001J\u0012\u0010\u0085\u0001\u001a\u0004\u0018\u00010\"H\u00c6\u0003\u00a2\u0006\u0003\u0010\u0084\u0001J\u0012\u0010\u0086\u0001\u001a\u0004\u0018\u00010\"H\u00c6\u0003\u00a2\u0006\u0003\u0010\u0084\u0001J\u0012\u0010\u0087\u0001\u001a\u0004\u0018\u00010\"H\u00c6\u0003\u00a2\u0006\u0003\u0010\u0084\u0001J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\'H\u00c6\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010)H\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0007H\u00c6\u0003J\n\u0010\u008b\u0001\u001a\u00020\tH\u00c6\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u00cc\u0002\u0010\u0091\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)H\u00c6\u0001\u00a2\u0006\u0003\u0010\u0092\u0001J\u0016\u0010\u0093\u0001\u001a\u00020\"2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u00d6\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0005H\u00d6\u0001J\n\u0010\u0097\u0001\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R \u0010(\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010&\u001a\u0004\u0018\u00010\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u00102\"\u0004\bF\u00104R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u00102\"\u0004\bN\u00104R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010S\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010%\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010TR\u0016\u0010$\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010TR\u0016\u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010TR\u0016\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010TR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010>\"\u0004\bV\u0010@R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010>\"\u0004\b`\u0010@R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010>\"\u0004\bf\u0010@R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010>\"\u0004\bh\u0010@R\u001c\u0010 \u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010>\"\u0004\bj\u0010@R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010>\"\u0004\bl\u0010@R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t\u00a8\u0006\u0098\u0001"}, d2 = {"Looo/jtc/rupayment/dto/RuPaymentDto;", "Looo/jtc/interfaces/UpdateIDocument;", "id", "Ljava/util/UUID;", "version", "", "documentNumber", "", "documentDate", "Ljava/time/LocalDate;", "customerId", "status", "branchId", "payer", "Looo/jtc/rupayment/dto/PayerDto;", "receiver", "Looo/jtc/rupayment/dto/ReceiverDto;", "budget", "Looo/jtc/rupayment/dto/BudgetDto;", "paymentGround", "Looo/jtc/rupayment/dto/PaymentGroundDto;", "amount", "Ljava/math/BigDecimal;", "operationType", "priority", "uinUip", "userPaymentType", "Looo/jtc/rupayment/model/UserPaymentType;", "channel", "incomeTypeCode", "amountRecovery", "transferTermCode", "transferTermDescription", "isFavorites", "", "isReceived", "isExecuted", "isDeclined", "createdAt", "Ljava/time/ZonedDateTime;", "budgetType", "Looo/jtc/rupayment/model/BudgetType;", "(Ljava/util/UUID;ILjava/lang/String;Ljava/time/LocalDate;Ljava/util/UUID;Ljava/lang/String;Ljava/util/UUID;Looo/jtc/rupayment/dto/PayerDto;Looo/jtc/rupayment/dto/ReceiverDto;Looo/jtc/rupayment/dto/BudgetDto;Looo/jtc/rupayment/dto/PaymentGroundDto;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Looo/jtc/rupayment/model/UserPaymentType;Ljava/lang/String;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/time/ZonedDateTime;Looo/jtc/rupayment/model/BudgetType;)V", "getAmount", "()Ljava/math/BigDecimal;", "setAmount", "(Ljava/math/BigDecimal;)V", "getAmountRecovery", "setAmountRecovery", "getBranchId", "()Ljava/util/UUID;", "setBranchId", "(Ljava/util/UUID;)V", "getBudget", "()Looo/jtc/rupayment/dto/BudgetDto;", "setBudget", "(Looo/jtc/rupayment/dto/BudgetDto;)V", "getBudgetType", "()Looo/jtc/rupayment/model/BudgetType;", "setBudgetType", "(Looo/jtc/rupayment/model/BudgetType;)V", "getChannel", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", "getCreatedAt", "()Ljava/time/ZonedDateTime;", "setCreatedAt", "(Ljava/time/ZonedDateTime;)V", "getCustomerId", "setCustomerId", "getDocumentDate", "()Ljava/time/LocalDate;", "setDocumentDate", "(Ljava/time/LocalDate;)V", "getDocumentNumber", "setDocumentNumber", "getId", "setId", "getIncomeTypeCode", "()Ljava/lang/Integer;", "setIncomeTypeCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "getOperationType", "setOperationType", "getPayer", "()Looo/jtc/rupayment/dto/PayerDto;", "setPayer", "(Looo/jtc/rupayment/dto/PayerDto;)V", "getPaymentGround", "()Looo/jtc/rupayment/dto/PaymentGroundDto;", "setPaymentGround", "(Looo/jtc/rupayment/dto/PaymentGroundDto;)V", "getPriority", "setPriority", "getReceiver", "()Looo/jtc/rupayment/dto/ReceiverDto;", "setReceiver", "(Looo/jtc/rupayment/dto/ReceiverDto;)V", "getStatus", "setStatus", "getTransferTermCode", "setTransferTermCode", "getTransferTermDescription", "setTransferTermDescription", "getUinUip", "setUinUip", "getUserPaymentType", "()Looo/jtc/rupayment/model/UserPaymentType;", "setUserPaymentType", "(Looo/jtc/rupayment/model/UserPaymentType;)V", "getVersion", "()I", "setVersion", "(I)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "()Ljava/lang/Boolean;", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/UUID;ILjava/lang/String;Ljava/time/LocalDate;Ljava/util/UUID;Ljava/lang/String;Ljava/util/UUID;Looo/jtc/rupayment/dto/PayerDto;Looo/jtc/rupayment/dto/ReceiverDto;Looo/jtc/rupayment/dto/BudgetDto;Looo/jtc/rupayment/dto/PaymentGroundDto;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Looo/jtc/rupayment/model/UserPaymentType;Ljava/lang/String;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/time/ZonedDateTime;Looo/jtc/rupayment/model/BudgetType;)Looo/jtc/rupayment/dto/RuPaymentDto;", "equals", "other", "", "hashCode", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@ooo.jtc.annotations.EntityName(name = "\u0420\u0443\u0431\u043b\u0435\u0432\u043e\u0435 \u041f\u041f")
@com.github.pozo.KotlinBuilder()
public final class RuPaymentDto implements ooo.jtc.interfaces.UpdateIDocument<ooo.jtc.rupayment.dto.RuPaymentDto> {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String documentNumber;
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDate documentDate;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID customerId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String status;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID branchId;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.rupayment.dto.PayerDto payer;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.rupayment.dto.ReceiverDto receiver;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.rupayment.dto.BudgetDto budget;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.rupayment.dto.PaymentGroundDto paymentGround;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal amount;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String operationType;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String priority;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String uinUip;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.rupayment.model.UserPaymentType userPaymentType;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String channel;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer incomeTypeCode;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal amountRecovery;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String transferTermCode;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String transferTermDescription;
    @org.jetbrains.annotations.Nullable()
    public java.lang.Boolean isFavorites;
    @org.jetbrains.annotations.Nullable()
    public java.lang.Boolean isReceived;
    @org.jetbrains.annotations.Nullable()
    public java.lang.Boolean isExecuted;
    @org.jetbrains.annotations.Nullable()
    public java.lang.Boolean isDeclined;
    @org.jetbrains.annotations.Nullable()
    private java.time.ZonedDateTime createdAt;
    @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    private ooo.jtc.rupayment.model.BudgetType budgetType;
    
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
    @java.lang.Override()
    public java.lang.String getDocumentNumber() {
        return null;
    }
    
    @java.lang.Override()
    public void setDocumentNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.time.LocalDate getDocumentDate() {
        return null;
    }
    
    @java.lang.Override()
    public void setDocumentDate(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.util.UUID getCustomerId() {
        return null;
    }
    
    @java.lang.Override()
    public void setCustomerId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getStatus() {
        return null;
    }
    
    @java.lang.Override()
    public void setStatus(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getBranchId() {
        return null;
    }
    
    public final void setBranchId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.dto.PayerDto getPayer() {
        return null;
    }
    
    public final void setPayer(@org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.dto.PayerDto p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.dto.ReceiverDto getReceiver() {
        return null;
    }
    
    public final void setReceiver(@org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.dto.ReceiverDto p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.dto.BudgetDto getBudget() {
        return null;
    }
    
    public final void setBudget(@org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.dto.BudgetDto p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.dto.PaymentGroundDto getPaymentGround() {
        return null;
    }
    
    public final void setPaymentGround(@org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.dto.PaymentGroundDto p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getAmount() {
        return null;
    }
    
    public final void setAmount(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOperationType() {
        return null;
    }
    
    public final void setOperationType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPriority() {
        return null;
    }
    
    public final void setPriority(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUinUip() {
        return null;
    }
    
    public final void setUinUip(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.model.UserPaymentType getUserPaymentType() {
        return null;
    }
    
    public final void setUserPaymentType(@org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.model.UserPaymentType p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getChannel() {
        return null;
    }
    
    public final void setChannel(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getIncomeTypeCode() {
        return null;
    }
    
    public final void setIncomeTypeCode(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getAmountRecovery() {
        return null;
    }
    
    public final void setAmountRecovery(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTransferTermCode() {
        return null;
    }
    
    public final void setTransferTermCode(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTransferTermDescription() {
        return null;
    }
    
    public final void setTransferTermDescription(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.model.BudgetType getBudgetType() {
        return null;
    }
    
    public final void setBudgetType(@org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.model.BudgetType p0) {
    }
    
    public RuPaymentDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate documentDate, @org.jetbrains.annotations.Nullable()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchId, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.dto.PayerDto payer, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.dto.ReceiverDto receiver, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.dto.BudgetDto budget, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.dto.PaymentGroundDto paymentGround, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal amount, @org.jetbrains.annotations.Nullable()
    java.lang.String operationType, @org.jetbrains.annotations.Nullable()
    java.lang.String priority, @org.jetbrains.annotations.Nullable()
    java.lang.String uinUip, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.model.UserPaymentType userPaymentType, @org.jetbrains.annotations.Nullable()
    java.lang.String channel, @org.jetbrains.annotations.Nullable()
    java.lang.Integer incomeTypeCode, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal amountRecovery, @org.jetbrains.annotations.Nullable()
    java.lang.String transferTermCode, @org.jetbrains.annotations.Nullable()
    java.lang.String transferTermDescription, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavorites, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isReceived, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isExecuted, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isDeclined, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime createdAt, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.model.BudgetType budgetType) {
        super();
    }
    
    @java.lang.Override()
    public boolean isInStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String... statuses) {
        return false;
    }
    
    @java.lang.Override()
    public boolean isInStatus(@org.jetbrains.annotations.NotNull()
    ooo.jtc.documents.IDocumentStatus<? extends ooo.jtc.interfaces.IDocument>... statuses) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    public java.lang.String getEntityName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    public ooo.jtc.interfaces.ITransferEntity toModel() {
        return null;
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
    public final java.time.LocalDate component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.dto.PayerDto component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.dto.ReceiverDto component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.dto.BudgetDto component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.dto.PaymentGroundDto component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.model.UserPaymentType component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.model.BudgetType component27() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rupayment.dto.RuPaymentDto copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate documentDate, @org.jetbrains.annotations.Nullable()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchId, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.dto.PayerDto payer, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.dto.ReceiverDto receiver, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.dto.BudgetDto budget, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.dto.PaymentGroundDto paymentGround, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal amount, @org.jetbrains.annotations.Nullable()
    java.lang.String operationType, @org.jetbrains.annotations.Nullable()
    java.lang.String priority, @org.jetbrains.annotations.Nullable()
    java.lang.String uinUip, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.model.UserPaymentType userPaymentType, @org.jetbrains.annotations.Nullable()
    java.lang.String channel, @org.jetbrains.annotations.Nullable()
    java.lang.Integer incomeTypeCode, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal amountRecovery, @org.jetbrains.annotations.Nullable()
    java.lang.String transferTermCode, @org.jetbrains.annotations.Nullable()
    java.lang.String transferTermDescription, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavorites, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isReceived, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isExecuted, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isDeclined, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime createdAt, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.model.BudgetType budgetType) {
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