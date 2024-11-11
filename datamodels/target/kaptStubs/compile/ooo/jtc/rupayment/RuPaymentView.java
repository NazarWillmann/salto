package ooo.jtc.rupayment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b|\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00f9\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\u0010 \u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010\"\u001a\u00020\u0006\u0012\b\b\u0002\u0010#\u001a\u00020\u0006\u0012\b\b\u0002\u0010$\u001a\u00020\u0006\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\b\b\u0002\u0010&\u001a\u00020\u0006\u0012\b\b\u0002\u0010\'\u001a\u00020\u0006\u0012\b\b\u0002\u0010(\u001a\u00020\u0006\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u00a2\u0006\u0002\u0010+J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0006H\u00c6\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010!H\u00c6\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0006H\u00c6\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010*H\u00c6\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u00a0\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u00a1\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u00a2\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u00a3\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u00a4\u0001\u001a\u00020\u0006H\u00c6\u0003J\u0082\u0003\u0010\u00a5\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020\u00062\b\b\u0002\u0010\'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u00c6\u0001J\u0017\u0010\u00a6\u0001\u001a\u00030\u00a7\u00012\n\u0010\u00a8\u0001\u001a\u0005\u0018\u00010\u00a9\u0001H\u00d6\u0003J\u000b\u0010\u00aa\u0001\u001a\u00030\u00ab\u0001H\u00d6\u0001J\n\u0010\u00ac\u0001\u001a\u00020\u0006H\u00d6\u0001R\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u001c\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R\u001a\u0010\u001b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\u001a\u0010&\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\u001a\u0010#\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010-\"\u0004\b7\u0010/R\u001a\u0010$\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010-\"\u0004\b9\u0010/R\u001a\u0010\"\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R\u001a\u0010%\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010-\"\u0004\b=\u0010/R\u001a\u0010(\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010-\"\u0004\b?\u0010/R\u001a\u0010\'\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010-\"\u0004\bA\u0010/R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010\u0007\u001a\u00020\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010-\"\u0004\bK\u0010/R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010-\"\u0004\bM\u0010/R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010G\"\u0004\bO\u0010IR\u001a\u0010\u001e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010-\"\u0004\bQ\u0010/R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010-\"\u0004\bS\u0010/R\u001a\u0010\u0016\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010-\"\u0004\bU\u0010/R\u001a\u0010\u0018\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010-\"\u0004\bW\u0010/R\u001a\u0010\u0019\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010-\"\u0004\bY\u0010/R\u001a\u0010\u0015\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010-\"\u0004\b[\u0010/R\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010-\"\u0004\b]\u0010/R\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010-\"\u0004\b_\u0010/R\u001a\u0010\u001f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010-\"\u0004\ba\u0010/R\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010-\"\u0004\bc\u0010/R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010-\"\u0004\be\u0010/R\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010-\"\u0004\bg\u0010/R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010-\"\u0004\bi\u0010/R\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010-\"\u0004\bk\u0010/R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010-\"\u0004\bm\u0010/R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010-\"\u0004\bo\u0010/R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010-\"\u0004\bq\u0010/R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010-\"\u0004\bs\u0010/R\u0014\u0010t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bu\u0010-R\u001a\u0010\n\u001a\u00020\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010-\"\u0004\bw\u0010/R\u001a\u0010\t\u001a\u00020\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bx\u0010-\"\u0004\by\u0010/R\u001a\u0010\b\u001a\u00020\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u0010-\"\u0004\b{\u0010/R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007f\u00a8\u0006\u00ad\u0001"}, d2 = {"Looo/jtc/rupayment/RuPaymentView;", "Looo/jtc/interfaces/IDocumentView;", "id", "Ljava/util/UUID;", "customerId", "documentNumber", "", "documentDate", "statusSystem", "statusClient", "statusBank", "receiverName", "receiverInn", "receiverKpp", "receiverBankBic", "receiverBankName", "receiverBankCorrAccount", "receiverBankMaskedCorrAccount", "receiverAccount", "receiverMaskedAccount", "payerAccount", "payerMaskedAccount", "payerHiddenMaskedAccount", "payerName", "payerInn", "payerKpp", "amount", "amountMasked", "amountAntie", "paymentGroundDescription", "nds", "priority", "userPaymentType", "Looo/jtc/rupayment/model/UserPaymentType;", "budgetPayerStatus", "budgetKbk", "budgetOktmo", "budgetReasonCode", "budgetBudgetField107", "budgetReasonDocumentNumber", "budgetReasonDocumentDate", "budgetType", "Looo/jtc/rupayment/model/BudgetType;", "(Ljava/util/UUID;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Looo/jtc/rupayment/model/UserPaymentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Looo/jtc/rupayment/model/BudgetType;)V", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "getAmountAntie", "setAmountAntie", "getAmountMasked", "setAmountMasked", "getBudgetBudgetField107", "setBudgetBudgetField107", "getBudgetKbk", "setBudgetKbk", "getBudgetOktmo", "setBudgetOktmo", "getBudgetPayerStatus", "setBudgetPayerStatus", "getBudgetReasonCode", "setBudgetReasonCode", "getBudgetReasonDocumentDate", "setBudgetReasonDocumentDate", "getBudgetReasonDocumentNumber", "setBudgetReasonDocumentNumber", "getBudgetType", "()Looo/jtc/rupayment/model/BudgetType;", "setBudgetType", "(Looo/jtc/rupayment/model/BudgetType;)V", "getCustomerId", "()Ljava/util/UUID;", "setCustomerId", "(Ljava/util/UUID;)V", "getDocumentDate", "setDocumentDate", "getDocumentNumber", "setDocumentNumber", "getId", "setId", "getNds", "setNds", "getPayerAccount", "setPayerAccount", "getPayerHiddenMaskedAccount", "setPayerHiddenMaskedAccount", "getPayerInn", "setPayerInn", "getPayerKpp", "setPayerKpp", "getPayerMaskedAccount", "setPayerMaskedAccount", "getPayerName", "setPayerName", "getPaymentGroundDescription", "setPaymentGroundDescription", "getPriority", "setPriority", "getReceiverAccount", "setReceiverAccount", "getReceiverBankBic", "setReceiverBankBic", "getReceiverBankCorrAccount", "setReceiverBankCorrAccount", "getReceiverBankMaskedCorrAccount", "setReceiverBankMaskedCorrAccount", "getReceiverBankName", "setReceiverBankName", "getReceiverInn", "setReceiverInn", "getReceiverKpp", "setReceiverKpp", "getReceiverMaskedAccount", "setReceiverMaskedAccount", "getReceiverName", "setReceiverName", "searchField", "getSearchField", "getStatusBank", "setStatusBank", "getStatusClient", "setStatusClient", "getStatusSystem", "setStatusSystem", "getUserPaymentType", "()Looo/jtc/rupayment/model/UserPaymentType;", "setUserPaymentType", "(Looo/jtc/rupayment/model/UserPaymentType;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "datamodels"})
@com.github.pozo.KotlinBuilder()
public final class RuPaymentView implements ooo.jtc.interfaces.IDocumentView {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    @org.jetbrains.annotations.NotNull()
    private java.util.UUID customerId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String documentNumber;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String documentDate;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String statusSystem;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String statusClient;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String statusBank;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String receiverName;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String receiverInn;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String receiverKpp;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String receiverBankBic;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String receiverBankName;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String receiverBankCorrAccount;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String receiverBankMaskedCorrAccount;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String receiverAccount;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String receiverMaskedAccount;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String payerAccount;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String payerMaskedAccount;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String payerHiddenMaskedAccount;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String payerName;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String payerInn;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String payerKpp;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String amount;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String amountMasked;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String amountAntie;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String paymentGroundDescription;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String nds;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String priority;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.rupayment.model.UserPaymentType userPaymentType;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String budgetPayerStatus;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String budgetKbk;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String budgetOktmo;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String budgetReasonCode;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String budgetBudgetField107;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String budgetReasonDocumentNumber;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String budgetReasonDocumentDate;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.rupayment.model.BudgetType budgetType;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getSearchField() {
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
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.UUID getCustomerId() {
        return null;
    }
    
    @java.lang.Override()
    public void setCustomerId(@org.jetbrains.annotations.NotNull()
    java.util.UUID p0) {
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
    public java.lang.String getDocumentDate() {
        return null;
    }
    
    @java.lang.Override()
    public void setDocumentDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getStatusSystem() {
        return null;
    }
    
    @java.lang.Override()
    public void setStatusSystem(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getStatusClient() {
        return null;
    }
    
    @java.lang.Override()
    public void setStatusClient(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getStatusBank() {
        return null;
    }
    
    @java.lang.Override()
    public void setStatusBank(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReceiverName() {
        return null;
    }
    
    public final void setReceiverName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReceiverInn() {
        return null;
    }
    
    public final void setReceiverInn(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReceiverKpp() {
        return null;
    }
    
    public final void setReceiverKpp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReceiverBankBic() {
        return null;
    }
    
    public final void setReceiverBankBic(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReceiverBankName() {
        return null;
    }
    
    public final void setReceiverBankName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReceiverBankCorrAccount() {
        return null;
    }
    
    public final void setReceiverBankCorrAccount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReceiverBankMaskedCorrAccount() {
        return null;
    }
    
    public final void setReceiverBankMaskedCorrAccount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReceiverAccount() {
        return null;
    }
    
    public final void setReceiverAccount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReceiverMaskedAccount() {
        return null;
    }
    
    public final void setReceiverMaskedAccount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPayerAccount() {
        return null;
    }
    
    public final void setPayerAccount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPayerMaskedAccount() {
        return null;
    }
    
    public final void setPayerMaskedAccount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPayerHiddenMaskedAccount() {
        return null;
    }
    
    public final void setPayerHiddenMaskedAccount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPayerName() {
        return null;
    }
    
    public final void setPayerName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPayerInn() {
        return null;
    }
    
    public final void setPayerInn(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPayerKpp() {
        return null;
    }
    
    public final void setPayerKpp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAmount() {
        return null;
    }
    
    public final void setAmount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAmountMasked() {
        return null;
    }
    
    public final void setAmountMasked(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAmountAntie() {
        return null;
    }
    
    public final void setAmountAntie(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPaymentGroundDescription() {
        return null;
    }
    
    public final void setPaymentGroundDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNds() {
        return null;
    }
    
    public final void setNds(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPriority() {
        return null;
    }
    
    public final void setPriority(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.model.UserPaymentType getUserPaymentType() {
        return null;
    }
    
    public final void setUserPaymentType(@org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.model.UserPaymentType p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBudgetPayerStatus() {
        return null;
    }
    
    public final void setBudgetPayerStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBudgetKbk() {
        return null;
    }
    
    public final void setBudgetKbk(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBudgetOktmo() {
        return null;
    }
    
    public final void setBudgetOktmo(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBudgetReasonCode() {
        return null;
    }
    
    public final void setBudgetReasonCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBudgetBudgetField107() {
        return null;
    }
    
    public final void setBudgetBudgetField107(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBudgetReasonDocumentNumber() {
        return null;
    }
    
    public final void setBudgetReasonDocumentNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBudgetReasonDocumentDate() {
        return null;
    }
    
    public final void setBudgetReasonDocumentDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.model.BudgetType getBudgetType() {
        return null;
    }
    
    public final void setBudgetType(@org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.model.BudgetType p0) {
    }
    
    public RuPaymentView(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String documentDate, @org.jetbrains.annotations.NotNull()
    java.lang.String statusSystem, @org.jetbrains.annotations.NotNull()
    java.lang.String statusClient, @org.jetbrains.annotations.NotNull()
    java.lang.String statusBank, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverName, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverInn, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverKpp, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverBankBic, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverBankName, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverBankCorrAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverBankMaskedCorrAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverMaskedAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String payerAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String payerMaskedAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String payerHiddenMaskedAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String payerName, @org.jetbrains.annotations.NotNull()
    java.lang.String payerInn, @org.jetbrains.annotations.NotNull()
    java.lang.String payerKpp, @org.jetbrains.annotations.NotNull()
    java.lang.String amount, @org.jetbrains.annotations.NotNull()
    java.lang.String amountMasked, @org.jetbrains.annotations.NotNull()
    java.lang.String amountAntie, @org.jetbrains.annotations.NotNull()
    java.lang.String paymentGroundDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String nds, @org.jetbrains.annotations.NotNull()
    java.lang.String priority, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.model.UserPaymentType userPaymentType, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetPayerStatus, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetKbk, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetOktmo, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetReasonCode, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetBudgetField107, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetReasonDocumentNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetReasonDocumentDate, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.model.BudgetType budgetType) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
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
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component27() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.model.UserPaymentType component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component31() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component32() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component33() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component34() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component35() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component36() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.rupayment.model.BudgetType component37() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rupayment.RuPaymentView copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String documentDate, @org.jetbrains.annotations.NotNull()
    java.lang.String statusSystem, @org.jetbrains.annotations.NotNull()
    java.lang.String statusClient, @org.jetbrains.annotations.NotNull()
    java.lang.String statusBank, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverName, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverInn, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverKpp, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverBankBic, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverBankName, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverBankCorrAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverBankMaskedCorrAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverMaskedAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String payerAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String payerMaskedAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String payerHiddenMaskedAccount, @org.jetbrains.annotations.NotNull()
    java.lang.String payerName, @org.jetbrains.annotations.NotNull()
    java.lang.String payerInn, @org.jetbrains.annotations.NotNull()
    java.lang.String payerKpp, @org.jetbrains.annotations.NotNull()
    java.lang.String amount, @org.jetbrains.annotations.NotNull()
    java.lang.String amountMasked, @org.jetbrains.annotations.NotNull()
    java.lang.String amountAntie, @org.jetbrains.annotations.NotNull()
    java.lang.String paymentGroundDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String nds, @org.jetbrains.annotations.NotNull()
    java.lang.String priority, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.model.UserPaymentType userPaymentType, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetPayerStatus, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetKbk, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetOktmo, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetReasonCode, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetBudgetField107, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetReasonDocumentNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String budgetReasonDocumentDate, @org.jetbrains.annotations.Nullable()
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