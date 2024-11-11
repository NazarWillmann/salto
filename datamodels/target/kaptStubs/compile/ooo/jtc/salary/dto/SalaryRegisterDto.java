package ooo.jtc.salary.dto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0003\b\u0085\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u00d5\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u0005\u0012\b\u0010\'\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010(\u001a\u0004\u0018\u00010\t\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010+J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010|\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010~\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0017H\u00c6\u0003J\u0010\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\n\u0010\u0097\u0001\u001a\u00020\tH\u00c6\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0007H\u00c6\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0096\u0003\u0010\u009d\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010&\u001a\u00020\u00052\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0016\u0010\u009e\u0001\u001a\u00020\u00172\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u00a0\u0001H\u00d6\u0003J\n\u0010\u00a1\u0001\u001a\u00020\u0005H\u00d6\u0001J\n\u0010\u00a2\u0001\u001a\u00020\u0007H\u00d6\u0001R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010$\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010-\"\u0004\b9\u0010/R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010-\"\u0004\b=\u0010/R\u001c\u0010%\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010-\"\u0004\b?\u0010/R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u00101\"\u0004\bA\u00103R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010-\"\u0004\bC\u0010/R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010-\"\u0004\bE\u0010/R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010-\"\u0004\bG\u0010/R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010\n\u001a\u00020\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010-\"\u0004\bM\u0010/R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010-\"\u0004\bO\u0010/R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010-\"\u0004\bQ\u0010/R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u00101\"\u0004\bS\u00103R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010T\"\u0004\bU\u0010VR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010-\"\u0004\bX\u0010/R\u001c\u0010 \u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010-\"\u0004\bZ\u0010/R\u001c\u0010!\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010-\"\u0004\b\\\u0010/R\u001c\u0010(\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010I\"\u0004\b^\u0010KR\u001c\u0010)\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010-\"\u0004\b`\u0010/R\u001c\u0010\'\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010-\"\u0004\bb\u0010/R\u001c\u0010*\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010-\"\u0004\bd\u0010/R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010-\"\u0004\bj\u0010/R\u001c\u0010#\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010-\"\u0004\bl\u0010/R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010-\"\u0004\bn\u0010/R\u001a\u0010&\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bs\u0010-\"\u0004\bt\u0010/R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010-\"\u0004\bv\u0010/R\u001a\u0010\u001b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u00101\"\u0004\bx\u00103R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010p\"\u0004\bz\u0010r\u00a8\u0006\u00a3\u0001"}, d2 = {"Looo/jtc/salary/dto/SalaryRegisterDto;", "Looo/jtc/interfaces/UpdateIDocument;", "id", "Ljava/util/UUID;", "version", "", "status", "", "documentDate", "Ljava/time/LocalDate;", "documentNumber", "customerId", "createdAt", "modifiedAt", "schemeVersion", "channel", "customerName", "branchId", "branchName", "receiveDate", "executionDate", "executionMessage", "isFavorites", "", "payrolls", "", "Looo/jtc/salary/dto/SalaryRegisterPayrollDto;", "userId", "customerInn", "customerOkpo", "accountDebet", "accountId", "official", "officialPhone", "periodMonth", "periodYear", "amount", "currencyCode", "recordsTotal", "payDocumentNumber", "payDocumentDate", "payDocumentGround", "paymentId", "(Ljava/util/UUID;ILjava/lang/String;Ljava/time/LocalDate;Ljava/lang/String;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/time/LocalDate;Ljava/lang/String;Ljava/lang/String;)V", "getAccountDebet", "()Ljava/lang/String;", "setAccountDebet", "(Ljava/lang/String;)V", "getAccountId", "()Ljava/util/UUID;", "setAccountId", "(Ljava/util/UUID;)V", "getAmount", "setAmount", "getBranchId", "setBranchId", "getBranchName", "setBranchName", "getChannel", "setChannel", "getCreatedAt", "setCreatedAt", "getCurrencyCode", "setCurrencyCode", "getCustomerId", "setCustomerId", "getCustomerInn", "setCustomerInn", "getCustomerName", "setCustomerName", "getCustomerOkpo", "setCustomerOkpo", "getDocumentDate", "()Ljava/time/LocalDate;", "setDocumentDate", "(Ljava/time/LocalDate;)V", "getDocumentNumber", "setDocumentNumber", "getExecutionDate", "setExecutionDate", "getExecutionMessage", "setExecutionMessage", "getId", "setId", "()Z", "setFavorites", "(Z)V", "getModifiedAt", "setModifiedAt", "getOfficial", "setOfficial", "getOfficialPhone", "setOfficialPhone", "getPayDocumentDate", "setPayDocumentDate", "getPayDocumentGround", "setPayDocumentGround", "getPayDocumentNumber", "setPayDocumentNumber", "getPaymentId", "setPaymentId", "getPayrolls", "()Ljava/util/List;", "setPayrolls", "(Ljava/util/List;)V", "getPeriodMonth", "setPeriodMonth", "getPeriodYear", "setPeriodYear", "getReceiveDate", "setReceiveDate", "getRecordsTotal", "()I", "setRecordsTotal", "(I)V", "getSchemeVersion", "setSchemeVersion", "getStatus", "setStatus", "getUserId", "setUserId", "getVersion", "setVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@ooo.jtc.annotations.EntityName(name = "\u0417\u0430\u0440\u043f\u043b\u0430\u0442\u043d\u044b\u0439 \u0440\u0435\u0435\u0441\u0442\u0440")
@com.github.pozo.KotlinBuilder()
public final class SalaryRegisterDto implements ooo.jtc.interfaces.UpdateIDocument<ooo.jtc.salary.dto.SalaryRegisterDto> {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String status;
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDate documentDate;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String documentNumber;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID customerId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String createdAt;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String modifiedAt;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String schemeVersion;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String channel;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String customerName;
    @org.jetbrains.annotations.NotNull()
    private java.util.UUID branchId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String branchName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String receiveDate;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String executionDate;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String executionMessage;
    private boolean isFavorites;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<ooo.jtc.salary.dto.SalaryRegisterPayrollDto> payrolls;
    @org.jetbrains.annotations.NotNull()
    private java.util.UUID userId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String customerInn;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String customerOkpo;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String accountDebet;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID accountId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String official;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String officialPhone;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String periodMonth;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String periodYear;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String amount;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String currencyCode;
    private int recordsTotal;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payDocumentNumber;
    @org.jetbrains.annotations.Nullable()
    private java.time.LocalDate payDocumentDate;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payDocumentGround;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String paymentId;
    
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
    @java.lang.Override()
    public java.lang.String getStatus() {
        return null;
    }
    
    @java.lang.Override()
    public void setStatus(@org.jetbrains.annotations.Nullable()
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
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getDocumentNumber() {
        return null;
    }
    
    @java.lang.Override()
    public void setDocumentNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    public final java.lang.String getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getModifiedAt() {
        return null;
    }
    
    public final void setModifiedAt(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSchemeVersion() {
        return null;
    }
    
    public final void setSchemeVersion(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChannel() {
        return null;
    }
    
    public final void setChannel(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCustomerName() {
        return null;
    }
    
    public final void setCustomerName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getBranchId() {
        return null;
    }
    
    public final void setBranchId(@org.jetbrains.annotations.NotNull()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBranchName() {
        return null;
    }
    
    public final void setBranchName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReceiveDate() {
        return null;
    }
    
    public final void setReceiveDate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getExecutionDate() {
        return null;
    }
    
    public final void setExecutionDate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getExecutionMessage() {
        return null;
    }
    
    public final void setExecutionMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean isFavorites() {
        return false;
    }
    
    public final void setFavorites(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.salary.dto.SalaryRegisterPayrollDto> getPayrolls() {
        return null;
    }
    
    public final void setPayrolls(@org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.salary.dto.SalaryRegisterPayrollDto> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCustomerInn() {
        return null;
    }
    
    public final void setCustomerInn(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCustomerOkpo() {
        return null;
    }
    
    public final void setCustomerOkpo(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAccountDebet() {
        return null;
    }
    
    public final void setAccountDebet(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getAccountId() {
        return null;
    }
    
    public final void setAccountId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOfficial() {
        return null;
    }
    
    public final void setOfficial(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOfficialPhone() {
        return null;
    }
    
    public final void setOfficialPhone(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPeriodMonth() {
        return null;
    }
    
    public final void setPeriodMonth(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPeriodYear() {
        return null;
    }
    
    public final void setPeriodYear(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAmount() {
        return null;
    }
    
    public final void setAmount(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrencyCode() {
        return null;
    }
    
    public final void setCurrencyCode(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int getRecordsTotal() {
        return 0;
    }
    
    public final void setRecordsTotal(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayDocumentNumber() {
        return null;
    }
    
    public final void setPayDocumentNumber(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate getPayDocumentDate() {
        return null;
    }
    
    public final void setPayDocumentDate(@org.jetbrains.annotations.Nullable()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayDocumentGround() {
        return null;
    }
    
    public final void setPayDocumentGround(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPaymentId() {
        return null;
    }
    
    public final void setPaymentId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public SalaryRegisterDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate documentDate, @org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber, @org.jetbrains.annotations.Nullable()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.lang.String createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String modifiedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String schemeVersion, @org.jetbrains.annotations.NotNull()
    java.lang.String channel, @org.jetbrains.annotations.Nullable()
    java.lang.String customerName, @org.jetbrains.annotations.NotNull()
    java.util.UUID branchId, @org.jetbrains.annotations.Nullable()
    java.lang.String branchName, @org.jetbrains.annotations.Nullable()
    java.lang.String receiveDate, @org.jetbrains.annotations.Nullable()
    java.lang.String executionDate, @org.jetbrains.annotations.Nullable()
    java.lang.String executionMessage, boolean isFavorites, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.salary.dto.SalaryRegisterPayrollDto> payrolls, @org.jetbrains.annotations.NotNull()
    java.util.UUID userId, @org.jetbrains.annotations.Nullable()
    java.lang.String customerInn, @org.jetbrains.annotations.Nullable()
    java.lang.String customerOkpo, @org.jetbrains.annotations.Nullable()
    java.lang.String accountDebet, @org.jetbrains.annotations.Nullable()
    java.util.UUID accountId, @org.jetbrains.annotations.Nullable()
    java.lang.String official, @org.jetbrains.annotations.Nullable()
    java.lang.String officialPhone, @org.jetbrains.annotations.Nullable()
    java.lang.String periodMonth, @org.jetbrains.annotations.Nullable()
    java.lang.String periodYear, @org.jetbrains.annotations.Nullable()
    java.lang.String amount, @org.jetbrains.annotations.Nullable()
    java.lang.String currencyCode, int recordsTotal, @org.jetbrains.annotations.Nullable()
    java.lang.String payDocumentNumber, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate payDocumentDate, @org.jetbrains.annotations.Nullable()
    java.lang.String payDocumentGround, @org.jetbrains.annotations.Nullable()
    java.lang.String paymentId) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component6() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component12() {
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
    public final java.lang.String component16() {
        return null;
    }
    
    public final boolean component17() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.salary.dto.SalaryRegisterPayrollDto> component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component19() {
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
    public final java.lang.String component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component27() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component29() {
        return null;
    }
    
    public final int component30() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component31() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate component32() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component33() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component34() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.salary.dto.SalaryRegisterDto copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate documentDate, @org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber, @org.jetbrains.annotations.Nullable()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.lang.String createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.String modifiedAt, @org.jetbrains.annotations.Nullable()
    java.lang.String schemeVersion, @org.jetbrains.annotations.NotNull()
    java.lang.String channel, @org.jetbrains.annotations.Nullable()
    java.lang.String customerName, @org.jetbrains.annotations.NotNull()
    java.util.UUID branchId, @org.jetbrains.annotations.Nullable()
    java.lang.String branchName, @org.jetbrains.annotations.Nullable()
    java.lang.String receiveDate, @org.jetbrains.annotations.Nullable()
    java.lang.String executionDate, @org.jetbrains.annotations.Nullable()
    java.lang.String executionMessage, boolean isFavorites, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.salary.dto.SalaryRegisterPayrollDto> payrolls, @org.jetbrains.annotations.NotNull()
    java.util.UUID userId, @org.jetbrains.annotations.Nullable()
    java.lang.String customerInn, @org.jetbrains.annotations.Nullable()
    java.lang.String customerOkpo, @org.jetbrains.annotations.Nullable()
    java.lang.String accountDebet, @org.jetbrains.annotations.Nullable()
    java.util.UUID accountId, @org.jetbrains.annotations.Nullable()
    java.lang.String official, @org.jetbrains.annotations.Nullable()
    java.lang.String officialPhone, @org.jetbrains.annotations.Nullable()
    java.lang.String periodMonth, @org.jetbrains.annotations.Nullable()
    java.lang.String periodYear, @org.jetbrains.annotations.Nullable()
    java.lang.String amount, @org.jetbrains.annotations.Nullable()
    java.lang.String currencyCode, int recordsTotal, @org.jetbrains.annotations.Nullable()
    java.lang.String payDocumentNumber, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate payDocumentDate, @org.jetbrains.annotations.Nullable()
    java.lang.String payDocumentGround, @org.jetbrains.annotations.Nullable()
    java.lang.String paymentId) {
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