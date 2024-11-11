package ooo.jtc.news.dto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bv\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u00d7\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0016\u0012\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010&\u0012\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010&\u0012\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010&\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010.J\u000b\u0010~\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003\u00a2\u0006\u0002\u0010SJ\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003\u00a2\u0006\u0002\u0010SJ\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003\u00a2\u0006\u0002\u0010SJ\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0007H\u00c6\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003\u00a2\u0006\u0002\u0010SJ\u0011\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003\u00a2\u0006\u0002\u0010SJ\u0012\u0010\u0091\u0001\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010&H\u00c6\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u0012\u0010\u0093\u0001\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010&H\u00c6\u0003J\n\u0010\u0094\u0001\u001a\u00020\tH\u00c6\u0003J\u0012\u0010\u0095\u0001\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010&H\u00c6\u0003J\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010tJ\u0011\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010tJ\n\u0010\u0098\u0001\u001a\u00020\u000bH\u00c6\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u009c\u0003\u0010\u009e\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010&2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010&2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010&2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0003\u0010\u009f\u0001J\u0016\u0010\u00a0\u0001\u001a\u00020\u00162\n\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u00a2\u0001H\u00d6\u0003J\n\u0010\u00a3\u0001\u001a\u00020\u0007H\u00d6\u0001J\u0007\u0010\u00a4\u0001\u001a\u00020\u0000J\u0007\u0010\u00a5\u0001\u001a\u00020\u0000J\t\u0010\u00a6\u0001\u001a\u00020\u000bH\u0016R\u001c\u0010\'\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010&X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u00100\"\u0004\b<\u00102R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u00108\"\u0004\bB\u0010:R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u00104\"\u0004\bD\u00106R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u00100\"\u0004\bF\u00102R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u00100\"\u0004\bL\u00102R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010>\"\u0004\bN\u0010@R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u00100\"\u0004\bP\u00102R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u00108\"\u0004\bR\u0010:R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010V\u001a\u0004\b\u001a\u0010S\"\u0004\bT\u0010UR\u001e\u0010$\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010V\u001a\u0004\b$\u0010S\"\u0004\bW\u0010UR\u001e\u0010#\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010V\u001a\u0004\b#\u0010S\"\u0004\bX\u0010UR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010V\u001a\u0004\b\u0017\u0010S\"\u0004\bY\u0010UR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010V\u001a\u0004\b\u0015\u0010S\"\u0004\bZ\u0010UR\u001c\u0010 \u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u00100\"\u0004\b\\\u00102R\u001c\u0010!\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u00100\"\u0004\b^\u00102R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u00104\"\u0004\bd\u00106R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u00108\"\u0004\bf\u0010:R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010>\"\u0004\bh\u0010@R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u00100\"\u0004\bj\u00102R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010>\"\u0004\bl\u0010@R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u00100\"\u0004\bn\u00102R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u00100\"\u0004\bp\u00102R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u00100\"\u0004\br\u00102R\u001e\u0010-\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010w\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001e\u0010,\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010w\u001a\u0004\bx\u0010t\"\u0004\by\u0010vR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}\u00a8\u0006\u00a7\u0001"}, d2 = {"Looo/jtc/news/dto/PublicationDto;", "Looo/jtc/interfaces/UpdateIDocument;", "Looo/jtc/interfaces/IWithAttachments;", "Looo/jtc/news/dto/NewsAttachmentDto;", "id", "Ljava/util/UUID;", "version", "", "documentDate", "Ljava/time/LocalDate;", "documentNumber", "", "status", "customerId", "createdAt", "Ljava/time/Instant;", "branchId", "branchName", "description", "publicationType", "targetType", "isMustKnow", "", "isImportant", "startAt", "postedAt", "isFavorites", "endAt", "mailingChannel", "Looo/jtc/news/dto/PublicationMailingChannel;", "header", "text", "link", "linkText", "picture", "isHasAttach", "isForAllBranches", "attachments", "", "attachName", "customers", "Looo/jtc/news/dto/ReceiverCustomerDto;", "mustKnows", "Looo/jtc/news/dto/MustKnowDto;", "totalReceiverCustomers", "totalMustKnows", "(Ljava/util/UUID;ILjava/time/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Ljava/time/Instant;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/time/Instant;Ljava/time/Instant;Ljava/lang/Boolean;Ljava/time/Instant;Looo/jtc/news/dto/PublicationMailingChannel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAttachName", "()Ljava/lang/String;", "setAttachName", "(Ljava/lang/String;)V", "getAttachments", "()Ljava/util/List;", "setAttachments", "(Ljava/util/List;)V", "getBranchId", "()Ljava/util/UUID;", "setBranchId", "(Ljava/util/UUID;)V", "getBranchName", "setBranchName", "getCreatedAt", "()Ljava/time/Instant;", "setCreatedAt", "(Ljava/time/Instant;)V", "getCustomerId", "setCustomerId", "getCustomers", "setCustomers", "getDescription", "setDescription", "getDocumentDate", "()Ljava/time/LocalDate;", "setDocumentDate", "(Ljava/time/LocalDate;)V", "getDocumentNumber", "setDocumentNumber", "getEndAt", "setEndAt", "getHeader", "setHeader", "getId", "setId", "()Ljava/lang/Boolean;", "setFavorites", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setForAllBranches", "setHasAttach", "setImportant", "setMustKnow", "getLink", "setLink", "getLinkText", "setLinkText", "getMailingChannel", "()Looo/jtc/news/dto/PublicationMailingChannel;", "setMailingChannel", "(Looo/jtc/news/dto/PublicationMailingChannel;)V", "getMustKnows", "setMustKnows", "getPicture", "setPicture", "getPostedAt", "setPostedAt", "getPublicationType", "setPublicationType", "getStartAt", "setStartAt", "getStatus", "setStatus", "getTargetType", "setTargetType", "getText", "setText", "getTotalMustKnows", "()Ljava/lang/Integer;", "setTotalMustKnows", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTotalReceiverCustomers", "setTotalReceiverCustomers", "getVersion", "()I", "setVersion", "(I)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/UUID;ILjava/time/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Ljava/time/Instant;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/time/Instant;Ljava/time/Instant;Ljava/lang/Boolean;Ljava/time/Instant;Looo/jtc/news/dto/PublicationMailingChannel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Looo/jtc/news/dto/PublicationDto;", "equals", "other", "", "hashCode", "toClientDto", "toReducedDto", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@ooo.jtc.annotations.EntityName(name = "\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f")
@com.github.pozo.KotlinBuilder()
public final class PublicationDto implements ooo.jtc.interfaces.UpdateIDocument<ooo.jtc.news.dto.PublicationDto>, ooo.jtc.interfaces.IWithAttachments<ooo.jtc.news.dto.NewsAttachmentDto> {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDate documentDate;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String documentNumber;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String status;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID customerId;
    @org.jetbrains.annotations.Nullable()
    private java.time.Instant createdAt;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID branchId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String branchName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String description;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String publicationType;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String targetType;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean isMustKnow;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean isImportant;
    @org.jetbrains.annotations.Nullable()
    private java.time.Instant startAt;
    @org.jetbrains.annotations.Nullable()
    private java.time.Instant postedAt;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean isFavorites;
    @org.jetbrains.annotations.Nullable()
    private java.time.Instant endAt;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.news.dto.PublicationMailingChannel mailingChannel;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String header;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String text;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String link;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String linkText;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID picture;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean isHasAttach;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean isForAllBranches;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<ooo.jtc.news.dto.NewsAttachmentDto> attachments;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String attachName;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<ooo.jtc.news.dto.ReceiverCustomerDto> customers;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<ooo.jtc.news.dto.MustKnowDto> mustKnows;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer totalReceiverCustomers;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer totalMustKnows;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Reduced DTO is used on bank scroller page and in several API responses (i.e. '/post')
     * Has [customers] and [mustKnows] set to [null]
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto toReducedDto() {
        return null;
    }
    
    /**
     * Publications on client side have less fields
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto toClientDto() {
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
    public java.lang.String getStatus() {
        return null;
    }
    
    @java.lang.Override()
    public void setStatus(@org.jetbrains.annotations.Nullable()
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
    public final java.time.Instant getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getBranchId() {
        return null;
    }
    
    public final void setBranchId(@org.jetbrains.annotations.Nullable()
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
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPublicationType() {
        return null;
    }
    
    public final void setPublicationType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTargetType() {
        return null;
    }
    
    public final void setTargetType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isMustKnow() {
        return null;
    }
    
    public final void setMustKnow(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isImportant() {
        return null;
    }
    
    public final void setImportant(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant getStartAt() {
        return null;
    }
    
    public final void setStartAt(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant getPostedAt() {
        return null;
    }
    
    public final void setPostedAt(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isFavorites() {
        return null;
    }
    
    public final void setFavorites(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant getEndAt() {
        return null;
    }
    
    public final void setEndAt(@org.jetbrains.annotations.Nullable()
    java.time.Instant p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.news.dto.PublicationMailingChannel getMailingChannel() {
        return null;
    }
    
    public final void setMailingChannel(@org.jetbrains.annotations.Nullable()
    ooo.jtc.news.dto.PublicationMailingChannel p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHeader() {
        return null;
    }
    
    public final void setHeader(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getText() {
        return null;
    }
    
    public final void setText(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLink() {
        return null;
    }
    
    public final void setLink(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLinkText() {
        return null;
    }
    
    public final void setLinkText(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getPicture() {
        return null;
    }
    
    public final void setPicture(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isHasAttach() {
        return null;
    }
    
    public final void setHasAttach(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isForAllBranches() {
        return null;
    }
    
    public final void setForAllBranches(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.util.List<ooo.jtc.news.dto.NewsAttachmentDto> getAttachments() {
        return null;
    }
    
    @java.lang.Override()
    public void setAttachments(@org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.news.dto.NewsAttachmentDto> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAttachName() {
        return null;
    }
    
    public final void setAttachName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.news.dto.ReceiverCustomerDto> getCustomers() {
        return null;
    }
    
    public final void setCustomers(@org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.news.dto.ReceiverCustomerDto> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.news.dto.MustKnowDto> getMustKnows() {
        return null;
    }
    
    public final void setMustKnows(@org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.news.dto.MustKnowDto> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getTotalReceiverCustomers() {
        return null;
    }
    
    public final void setTotalReceiverCustomers(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getTotalMustKnows() {
        return null;
    }
    
    public final void setTotalMustKnows(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public PublicationDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate documentDate, @org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.time.Instant createdAt, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchId, @org.jetbrains.annotations.Nullable()
    java.lang.String branchName, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String publicationType, @org.jetbrains.annotations.Nullable()
    java.lang.String targetType, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isMustKnow, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isImportant, @org.jetbrains.annotations.Nullable()
    java.time.Instant startAt, @org.jetbrains.annotations.Nullable()
    java.time.Instant postedAt, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavorites, @org.jetbrains.annotations.Nullable()
    java.time.Instant endAt, @org.jetbrains.annotations.Nullable()
    ooo.jtc.news.dto.PublicationMailingChannel mailingChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String header, @org.jetbrains.annotations.Nullable()
    java.lang.String text, @org.jetbrains.annotations.Nullable()
    java.lang.String link, @org.jetbrains.annotations.Nullable()
    java.lang.String linkText, @org.jetbrains.annotations.Nullable()
    java.util.UUID picture, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isHasAttach, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isForAllBranches, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.news.dto.NewsAttachmentDto> attachments, @org.jetbrains.annotations.Nullable()
    java.lang.String attachName, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.news.dto.ReceiverCustomerDto> customers, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.news.dto.MustKnowDto> mustKnows, @org.jetbrains.annotations.Nullable()
    java.lang.Integer totalReceiverCustomers, @org.jetbrains.annotations.Nullable()
    java.lang.Integer totalMustKnows) {
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
    public final java.time.LocalDate component3() {
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
    public final java.util.UUID component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component8() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.Instant component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.news.dto.PublicationMailingChannel component19() {
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
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.news.dto.NewsAttachmentDto> component27() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.news.dto.ReceiverCustomerDto> component29() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.news.dto.MustKnowDto> component30() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component31() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component32() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate documentDate, @org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.time.Instant createdAt, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchId, @org.jetbrains.annotations.Nullable()
    java.lang.String branchName, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String publicationType, @org.jetbrains.annotations.Nullable()
    java.lang.String targetType, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isMustKnow, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isImportant, @org.jetbrains.annotations.Nullable()
    java.time.Instant startAt, @org.jetbrains.annotations.Nullable()
    java.time.Instant postedAt, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavorites, @org.jetbrains.annotations.Nullable()
    java.time.Instant endAt, @org.jetbrains.annotations.Nullable()
    ooo.jtc.news.dto.PublicationMailingChannel mailingChannel, @org.jetbrains.annotations.Nullable()
    java.lang.String header, @org.jetbrains.annotations.Nullable()
    java.lang.String text, @org.jetbrains.annotations.Nullable()
    java.lang.String link, @org.jetbrains.annotations.Nullable()
    java.lang.String linkText, @org.jetbrains.annotations.Nullable()
    java.util.UUID picture, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isHasAttach, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isForAllBranches, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.news.dto.NewsAttachmentDto> attachments, @org.jetbrains.annotations.Nullable()
    java.lang.String attachName, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.news.dto.ReceiverCustomerDto> customers, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.news.dto.MustKnowDto> mustKnows, @org.jetbrains.annotations.Nullable()
    java.lang.Integer totalReceiverCustomers, @org.jetbrains.annotations.Nullable()
    java.lang.Integer totalMustKnows) {
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