package ooo.jtc.curtransfer.dto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0003\b\u0092\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0093\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020\'\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010)\u001a\u0004\u0018\u00010*\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0002\u00108J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u0012\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003\u00a2\u0006\u0003\u0010\u009c\u0001J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u00a0\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\n\u0010\u00a1\u0001\u001a\u00020\u0018H\u00c6\u0003J\f\u0010\u00a2\u0001\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\n\u0010\u00a3\u0001\u001a\u00020\u0007H\u00c6\u0003J\n\u0010\u00a4\u0001\u001a\u00020\u0018H\u00c6\u0003J\n\u0010\u00a5\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u00a6\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0012\u0010\u00a7\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0003\u0010\u0081\u0001J\n\u0010\u00a8\u0001\u001a\u00020\u001fH\u00c6\u0003J\n\u0010\u00a9\u0001\u001a\u00020!H\u00c6\u0003J\n\u0010\u00aa\u0001\u001a\u00020#H\u00c6\u0003J\n\u0010\u00ab\u0001\u001a\u00020%H\u00c6\u0003J\n\u0010\u00ac\u0001\u001a\u00020\'H\u00c6\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00ae\u0001\u001a\u0004\u0018\u00010*H\u00c6\u0003J\f\u0010\u00af\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\n\u0010\u00b0\u0001\u001a\u00020\u0007H\u00c6\u0003J\f\u0010\u00b1\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00b2\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00b3\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00b4\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0012\u0010\u00b5\u0001\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101H\u00c6\u0003J\u0012\u0010\u00b6\u0001\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003\u00a2\u0006\u0003\u0010\u009c\u0001J\u0012\u0010\u00b7\u0001\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003\u00a2\u0006\u0003\u0010\u009c\u0001J\u0012\u0010\u00b8\u0001\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003\u00a2\u0006\u0003\u0010\u009c\u0001J\u0012\u0010\u00b9\u0001\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003\u00a2\u0006\u0003\u0010\u009c\u0001J\u0012\u0010\u00ba\u0001\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003\u00a2\u0006\u0003\u0010\u009c\u0001J\n\u0010\u00bb\u0001\u001a\u00020\tH\u00c6\u0003J\f\u0010\u00bc\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00bd\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00be\u0001\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\f\u0010\u00bf\u0001\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\f\u0010\u00c0\u0001\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u00d2\u0003\u0010\u00c1\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00182\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u0001012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0012H\u00c6\u0001\u00a2\u0006\u0003\u0010\u00c2\u0001J\u0016\u0010\u00c3\u0001\u001a\u00020\u00122\n\u0010\u00c4\u0001\u001a\u0005\u0018\u00010\u00c5\u0001H\u00d6\u0003J\n\u0010\u00c6\u0001\u001a\u00020\u0005H\u00d6\u0001J\n\u0010\u00c7\u0001\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010+\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010F\"\u0004\bJ\u0010HR\u001c\u0010,\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010F\"\u0004\bL\u0010HR\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010.\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010F\"\u0004\bR\u0010HR\u001c\u0010/\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010F\"\u0004\bT\u0010HR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010B\"\u0004\bZ\u0010DR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010F\"\u0004\b\\\u0010HR\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010F\"\u0004\bf\u0010HR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010V\"\u0004\bh\u0010XR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010B\"\u0004\bj\u0010DR\u001a\u0010&\u001a\u00020\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0016\u00105\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010oR\u0016\u00104\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010oR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010oR\u0016\u00106\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010oR\u0016\u00107\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010oR\u0016\u00103\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010oR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010F\"\u0004\bq\u0010HR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010V\"\u0004\bs\u0010XR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u001c\u0010-\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u0010F\"\u0004\b}\u0010HR\u001c\u0010(\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b~\u0010F\"\u0004\b\u007f\u0010HR#\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010F\"\u0005\b\u0086\u0001\u0010HR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010V\"\u0005\b\u0088\u0001\u0010XR&\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010F\"\u0005\b\u008e\u0001\u0010HR\u001c\u0010\u001b\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010^\"\u0005\b\u0090\u0001\u0010`R\u001c\u0010\u001a\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010F\"\u0005\b\u0092\u0001\u0010HR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010b\"\u0005\b\u0094\u0001\u0010dR\u001e\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001\u00a8\u0006\u00c8\u0001"}, d2 = {"Looo/jtc/curtransfer/dto/CurTransferDto;", "Looo/jtc/interfaces/UpdateIDocument;", "id", "Ljava/util/UUID;", "version", "", "documentNumber", "", "documentDate", "Ljava/time/LocalDate;", "customerId", "status", "createdAt", "Ljava/time/ZonedDateTime;", "modifiedAt", "receiveDate", "executionDate", "isFavorites", "", "messageFromBank", "customerName", "branchId", "branchName", "debit", "Looo/jtc/curtransfer/dto/MoneyAmountDto;", "valueDate", "urgency", "transfer", "rateType", "rate", "payer", "Looo/jtc/curtransfer/dto/CurTrPayerDto;", "payerBank", "Looo/jtc/curtransfer/dto/CurTrPayerBankDto;", "beneficiary", "Looo/jtc/curtransfer/dto/CurTrBeneficiaryDto;", "beneficiaryBank", "Looo/jtc/curtransfer/dto/CurTrBeneficiaryBankDto;", "intermediaryBank", "Looo/jtc/curtransfer/dto/CurTrIntermediaryBankDto;", "paymentInformation", "chargeType", "Looo/jtc/curtransfer/model/CurTrChargeType;", "chargeAccount", "chargeBic", "paymentAddInformation", "contactName", "contactPhone", "regulationInfos", "", "Looo/jtc/curtransfer/dto/CurRegulationInfoDto;", "isReceived", "isExecuted", "isDeclined", "isNotReceived", "isRecalled", "(Ljava/util/UUID;ILjava/lang/String;Ljava/time/LocalDate;Ljava/util/UUID;Ljava/lang/String;Ljava/time/ZonedDateTime;Ljava/time/ZonedDateTime;Ljava/time/ZonedDateTime;Ljava/time/ZonedDateTime;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Ljava/lang/String;Looo/jtc/curtransfer/dto/MoneyAmountDto;Ljava/time/LocalDate;Ljava/lang/String;Looo/jtc/curtransfer/dto/MoneyAmountDto;Ljava/lang/String;Ljava/lang/Integer;Looo/jtc/curtransfer/dto/CurTrPayerDto;Looo/jtc/curtransfer/dto/CurTrPayerBankDto;Looo/jtc/curtransfer/dto/CurTrBeneficiaryDto;Looo/jtc/curtransfer/dto/CurTrBeneficiaryBankDto;Looo/jtc/curtransfer/dto/CurTrIntermediaryBankDto;Ljava/lang/String;Looo/jtc/curtransfer/model/CurTrChargeType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getBeneficiary", "()Looo/jtc/curtransfer/dto/CurTrBeneficiaryDto;", "setBeneficiary", "(Looo/jtc/curtransfer/dto/CurTrBeneficiaryDto;)V", "getBeneficiaryBank", "()Looo/jtc/curtransfer/dto/CurTrBeneficiaryBankDto;", "setBeneficiaryBank", "(Looo/jtc/curtransfer/dto/CurTrBeneficiaryBankDto;)V", "getBranchId", "()Ljava/util/UUID;", "setBranchId", "(Ljava/util/UUID;)V", "getBranchName", "()Ljava/lang/String;", "setBranchName", "(Ljava/lang/String;)V", "getChargeAccount", "setChargeAccount", "getChargeBic", "setChargeBic", "getChargeType", "()Looo/jtc/curtransfer/model/CurTrChargeType;", "setChargeType", "(Looo/jtc/curtransfer/model/CurTrChargeType;)V", "getContactName", "setContactName", "getContactPhone", "setContactPhone", "getCreatedAt", "()Ljava/time/ZonedDateTime;", "setCreatedAt", "(Ljava/time/ZonedDateTime;)V", "getCustomerId", "setCustomerId", "getCustomerName", "setCustomerName", "getDebit", "()Looo/jtc/curtransfer/dto/MoneyAmountDto;", "setDebit", "(Looo/jtc/curtransfer/dto/MoneyAmountDto;)V", "getDocumentDate", "()Ljava/time/LocalDate;", "setDocumentDate", "(Ljava/time/LocalDate;)V", "getDocumentNumber", "setDocumentNumber", "getExecutionDate", "setExecutionDate", "getId", "setId", "getIntermediaryBank", "()Looo/jtc/curtransfer/dto/CurTrIntermediaryBankDto;", "setIntermediaryBank", "(Looo/jtc/curtransfer/dto/CurTrIntermediaryBankDto;)V", "Ljava/lang/Boolean;", "getMessageFromBank", "setMessageFromBank", "getModifiedAt", "setModifiedAt", "getPayer", "()Looo/jtc/curtransfer/dto/CurTrPayerDto;", "setPayer", "(Looo/jtc/curtransfer/dto/CurTrPayerDto;)V", "getPayerBank", "()Looo/jtc/curtransfer/dto/CurTrPayerBankDto;", "setPayerBank", "(Looo/jtc/curtransfer/dto/CurTrPayerBankDto;)V", "getPaymentAddInformation", "setPaymentAddInformation", "getPaymentInformation", "setPaymentInformation", "getRate", "()Ljava/lang/Integer;", "setRate", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRateType", "setRateType", "getReceiveDate", "setReceiveDate", "getRegulationInfos", "()Ljava/util/List;", "setRegulationInfos", "(Ljava/util/List;)V", "getStatus", "setStatus", "getTransfer", "setTransfer", "getUrgency", "setUrgency", "getValueDate", "setValueDate", "getVersion", "()I", "setVersion", "(I)V", "component1", "component10", "component11", "()Ljava/lang/Boolean;", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/UUID;ILjava/lang/String;Ljava/time/LocalDate;Ljava/util/UUID;Ljava/lang/String;Ljava/time/ZonedDateTime;Ljava/time/ZonedDateTime;Ljava/time/ZonedDateTime;Ljava/time/ZonedDateTime;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Ljava/lang/String;Looo/jtc/curtransfer/dto/MoneyAmountDto;Ljava/time/LocalDate;Ljava/lang/String;Looo/jtc/curtransfer/dto/MoneyAmountDto;Ljava/lang/String;Ljava/lang/Integer;Looo/jtc/curtransfer/dto/CurTrPayerDto;Looo/jtc/curtransfer/dto/CurTrPayerBankDto;Looo/jtc/curtransfer/dto/CurTrBeneficiaryDto;Looo/jtc/curtransfer/dto/CurTrBeneficiaryBankDto;Looo/jtc/curtransfer/dto/CurTrIntermediaryBankDto;Ljava/lang/String;Looo/jtc/curtransfer/model/CurTrChargeType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Looo/jtc/curtransfer/dto/CurTransferDto;", "equals", "other", "", "hashCode", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@ooo.jtc.annotations.EntityName(name = "\u0412\u0430\u043b\u044e\u0442\u043d\u044b\u0439 \u043f\u0435\u0440\u0435\u0432\u043e\u0434")
@com.github.pozo.KotlinBuilder()
public final class CurTransferDto implements ooo.jtc.interfaces.UpdateIDocument<ooo.jtc.curtransfer.dto.CurTransferDto> {
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
    private java.time.ZonedDateTime createdAt;
    @org.jetbrains.annotations.Nullable()
    private java.time.ZonedDateTime modifiedAt;
    @org.jetbrains.annotations.Nullable()
    private java.time.ZonedDateTime receiveDate;
    @org.jetbrains.annotations.Nullable()
    private java.time.ZonedDateTime executionDate;
    @org.jetbrains.annotations.Nullable()
    public java.lang.Boolean isFavorites;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String messageFromBank;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String customerName;
    @org.jetbrains.annotations.NotNull()
    private java.util.UUID branchId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String branchName;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.curtransfer.dto.MoneyAmountDto debit;
    @org.jetbrains.annotations.Nullable()
    private java.time.LocalDate valueDate;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String urgency;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.curtransfer.dto.MoneyAmountDto transfer;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String rateType;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer rate;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.curtransfer.dto.CurTrPayerDto payer;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.curtransfer.dto.CurTrPayerBankDto payerBank;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.curtransfer.dto.CurTrBeneficiaryDto beneficiary;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.curtransfer.dto.CurTrBeneficiaryBankDto beneficiaryBank;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.curtransfer.dto.CurTrIntermediaryBankDto intermediaryBank;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String paymentInformation;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.curtransfer.model.CurTrChargeType chargeType;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String chargeAccount;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String chargeBic;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String paymentAddInformation;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String contactName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String contactPhone;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<ooo.jtc.curtransfer.dto.CurRegulationInfoDto> regulationInfos;
    @org.jetbrains.annotations.Nullable()
    public java.lang.Boolean isReceived;
    @org.jetbrains.annotations.Nullable()
    public java.lang.Boolean isExecuted;
    @org.jetbrains.annotations.Nullable()
    public java.lang.Boolean isDeclined;
    @org.jetbrains.annotations.Nullable()
    public java.lang.Boolean isNotReceived;
    @org.jetbrains.annotations.Nullable()
    public java.lang.Boolean isRecalled;
    
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
    public final java.time.ZonedDateTime getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime getModifiedAt() {
        return null;
    }
    
    public final void setModifiedAt(@org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime getReceiveDate() {
        return null;
    }
    
    public final void setReceiveDate(@org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime getExecutionDate() {
        return null;
    }
    
    public final void setExecutionDate(@org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMessageFromBank() {
        return null;
    }
    
    public final void setMessageFromBank(@org.jetbrains.annotations.Nullable()
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
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.MoneyAmountDto getDebit() {
        return null;
    }
    
    public final void setDebit(@org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.MoneyAmountDto p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate getValueDate() {
        return null;
    }
    
    public final void setValueDate(@org.jetbrains.annotations.Nullable()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrgency() {
        return null;
    }
    
    public final void setUrgency(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.MoneyAmountDto getTransfer() {
        return null;
    }
    
    public final void setTransfer(@org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.MoneyAmountDto p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRateType() {
        return null;
    }
    
    public final void setRateType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRate() {
        return null;
    }
    
    public final void setRate(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.CurTrPayerDto getPayer() {
        return null;
    }
    
    public final void setPayer(@org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrPayerDto p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.CurTrPayerBankDto getPayerBank() {
        return null;
    }
    
    public final void setPayerBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrPayerBankDto p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.CurTrBeneficiaryDto getBeneficiary() {
        return null;
    }
    
    public final void setBeneficiary(@org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrBeneficiaryDto p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.CurTrBeneficiaryBankDto getBeneficiaryBank() {
        return null;
    }
    
    public final void setBeneficiaryBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrBeneficiaryBankDto p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.CurTrIntermediaryBankDto getIntermediaryBank() {
        return null;
    }
    
    public final void setIntermediaryBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrIntermediaryBankDto p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPaymentInformation() {
        return null;
    }
    
    public final void setPaymentInformation(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.curtransfer.model.CurTrChargeType getChargeType() {
        return null;
    }
    
    public final void setChargeType(@org.jetbrains.annotations.Nullable()
    ooo.jtc.curtransfer.model.CurTrChargeType p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getChargeAccount() {
        return null;
    }
    
    public final void setChargeAccount(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getChargeBic() {
        return null;
    }
    
    public final void setChargeBic(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPaymentAddInformation() {
        return null;
    }
    
    public final void setPaymentAddInformation(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContactName() {
        return null;
    }
    
    public final void setContactName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContactPhone() {
        return null;
    }
    
    public final void setContactPhone(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.curtransfer.dto.CurRegulationInfoDto> getRegulationInfos() {
        return null;
    }
    
    public final void setRegulationInfos(@org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.curtransfer.dto.CurRegulationInfoDto> p0) {
    }
    
    public CurTransferDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate documentDate, @org.jetbrains.annotations.Nullable()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime createdAt, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime modifiedAt, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime receiveDate, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime executionDate, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavorites, @org.jetbrains.annotations.Nullable()
    java.lang.String messageFromBank, @org.jetbrains.annotations.Nullable()
    java.lang.String customerName, @org.jetbrains.annotations.NotNull()
    java.util.UUID branchId, @org.jetbrains.annotations.Nullable()
    java.lang.String branchName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.MoneyAmountDto debit, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate valueDate, @org.jetbrains.annotations.NotNull()
    java.lang.String urgency, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.MoneyAmountDto transfer, @org.jetbrains.annotations.Nullable()
    java.lang.String rateType, @org.jetbrains.annotations.Nullable()
    java.lang.Integer rate, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrPayerDto payer, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrPayerBankDto payerBank, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrBeneficiaryDto beneficiary, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrBeneficiaryBankDto beneficiaryBank, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrIntermediaryBankDto intermediaryBank, @org.jetbrains.annotations.Nullable()
    java.lang.String paymentInformation, @org.jetbrains.annotations.Nullable()
    ooo.jtc.curtransfer.model.CurTrChargeType chargeType, @org.jetbrains.annotations.Nullable()
    java.lang.String chargeAccount, @org.jetbrains.annotations.Nullable()
    java.lang.String chargeBic, @org.jetbrains.annotations.Nullable()
    java.lang.String paymentAddInformation, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.lang.String contactPhone, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.curtransfer.dto.CurRegulationInfoDto> regulationInfos, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isReceived, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isExecuted, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isDeclined, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isNotReceived, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRecalled) {
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
    public final java.time.ZonedDateTime component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.MoneyAmountDto component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.MoneyAmountDto component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.CurTrPayerDto component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.CurTrPayerBankDto component23() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.CurTrBeneficiaryDto component24() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.CurTrBeneficiaryBankDto component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.CurTrIntermediaryBankDto component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component27() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.curtransfer.model.CurTrChargeType component28() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component30() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component31() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component32() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component33() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.curtransfer.dto.CurRegulationInfoDto> component34() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component35() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component36() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component37() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component38() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component39() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.CurTransferDto copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate documentDate, @org.jetbrains.annotations.Nullable()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime createdAt, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime modifiedAt, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime receiveDate, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime executionDate, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isFavorites, @org.jetbrains.annotations.Nullable()
    java.lang.String messageFromBank, @org.jetbrains.annotations.Nullable()
    java.lang.String customerName, @org.jetbrains.annotations.NotNull()
    java.util.UUID branchId, @org.jetbrains.annotations.Nullable()
    java.lang.String branchName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.MoneyAmountDto debit, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate valueDate, @org.jetbrains.annotations.NotNull()
    java.lang.String urgency, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.MoneyAmountDto transfer, @org.jetbrains.annotations.Nullable()
    java.lang.String rateType, @org.jetbrains.annotations.Nullable()
    java.lang.Integer rate, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrPayerDto payer, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrPayerBankDto payerBank, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrBeneficiaryDto beneficiary, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrBeneficiaryBankDto beneficiaryBank, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTrIntermediaryBankDto intermediaryBank, @org.jetbrains.annotations.Nullable()
    java.lang.String paymentInformation, @org.jetbrains.annotations.Nullable()
    ooo.jtc.curtransfer.model.CurTrChargeType chargeType, @org.jetbrains.annotations.Nullable()
    java.lang.String chargeAccount, @org.jetbrains.annotations.Nullable()
    java.lang.String chargeBic, @org.jetbrains.annotations.Nullable()
    java.lang.String paymentAddInformation, @org.jetbrains.annotations.Nullable()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.lang.String contactPhone, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.curtransfer.dto.CurRegulationInfoDto> regulationInfos, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isReceived, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isExecuted, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isDeclined, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isNotReceived, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRecalled) {
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