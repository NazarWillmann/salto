package ooo.jtc.rupayment.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0003\b\u00f1\u0001\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u00e9\u0006\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010*\u001a\u00020\u0014\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u00100\u001a\u00020\u0014\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010RJ\f\u0010\u00f4\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00f5\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00f6\u0001\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\f\u0010\u00f7\u0001\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\f\u0010\u00f8\u0001\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\n\u0010\u00f9\u0001\u001a\u00020\u0014H\u00c6\u0003J\f\u0010\u00fa\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\n\u0010\u00fb\u0001\u001a\u00020\u0014H\u00c6\u0003J\f\u0010\u00fc\u0001\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00fd\u0001\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\f\u0010\u00fe\u0001\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\f\u0010\u00ff\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0083\u0002\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\f\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0085\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0087\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u008f\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\n\u0010\u0091\u0002\u001a\u00020\u0014H\u00c6\u0003J\f\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\n\u0010\u0098\u0002\u001a\u00020\u0014H\u00c6\u0003J\u0012\u0010\u0099\u0002\u001a\u0004\u0018\u000102H\u00c6\u0003\u00a2\u0006\u0003\u0010\u00ae\u0001J\f\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u009b\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u009e\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00a0\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00a1\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00a2\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00a3\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00a4\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00a5\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00a6\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00a7\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00a8\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00a9\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00aa\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00ab\u0002\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\f\u0010\u00ac\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00ae\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00af\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00b0\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00b1\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00b2\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00b3\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00b4\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00b5\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00b6\u0002\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\f\u0010\u00b7\u0002\u001a\u0004\u0018\u00010NH\u00c6\u0003J\f\u0010\u00b8\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00b9\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00ba\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u00bb\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\f\u0010\u00bc\u0002\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u00f4\u0006\u0010\u00bd\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010*\u001a\u00020\u00142\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u00100\u001a\u00020\u00142\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0003\u0010\u00be\u0002J\u0016\u0010\u00bf\u0002\u001a\u00030\u00c0\u00022\t\u0010\u00c1\u0002\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u00c2\u0002\u001a\u000202H\u00d6\u0001J\n\u0010\u00c3\u0002\u001a\u00020\u0007H\u00d6\u0001R\u001c\u0010$\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010T\"\u0004\b\\\u0010VR\u001c\u0010!\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010T\"\u0004\b^\u0010VR\u001c\u0010L\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010T\"\u0004\b`\u0010VR\u001c\u0010I\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010T\"\u0004\bb\u0010VR\u001c\u0010F\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010T\"\u0004\bd\u0010VR\u001c\u0010G\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010T\"\u0004\bf\u0010VR\u001c\u0010E\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010T\"\u0004\bh\u0010VR\u001c\u0010H\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010T\"\u0004\bj\u0010VR\u001c\u0010J\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010T\"\u0004\bl\u0010VR\u001c\u0010K\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010T\"\u0004\bn\u0010VR\u001c\u0010D\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010T\"\u0004\bp\u0010VR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010T\"\u0004\br\u0010VR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bs\u0010T\"\u0004\bt\u0010VR\u001c\u0010-\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010T\"\u0004\bv\u0010VR\u001c\u0010.\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010T\"\u0004\bx\u0010VR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010T\"\u0004\bz\u0010VR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001d\u0010 \u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010T\"\u0005\b\u0080\u0001\u0010VR \u0010\u0018\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010|\"\u0005\b\u0086\u0001\u0010~R \u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0082\u0001\"\u0006\b\u0088\u0001\u0010\u0084\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010T\"\u0005\b\u008a\u0001\u0010VR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010T\"\u0005\b\u008c\u0001\u0010VR \u0010\u001d\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u0082\u0001\"\u0006\b\u008e\u0001\u0010\u0084\u0001R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010T\"\u0005\b\u0090\u0001\u0010VR \u0010\u0019\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0082\u0001\"\u0006\b\u0092\u0001\u0010\u0084\u0001R\u001e\u0010)\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010T\"\u0005\b\u0094\u0001\u0010VR\u001e\u0010,\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010T\"\u0005\b\u0096\u0001\u0010VR\u001e\u0010*\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001e\u0010+\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010T\"\u0005\b\u009c\u0001\u0010VR\u001e\u0010(\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010T\"\u0005\b\u009e\u0001\u0010VR \u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0001\u0010\u00a0\u0001\"\u0006\b\u00a1\u0001\u0010\u00a2\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00a3\u0001\u0010\u00a0\u0001\"\u0006\b\u00a4\u0001\u0010\u00a2\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00a5\u0001\u0010\u00a0\u0001\"\u0006\b\u00a6\u0001\u0010\u00a2\u0001R \u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00a7\u0001\u0010\u00a0\u0001\"\u0006\b\u00a8\u0001\u0010\u00a2\u0001R \u0010Q\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00a9\u0001\u0010\u00a0\u0001\"\u0006\b\u00aa\u0001\u0010\u00a2\u0001R \u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00ab\u0001\u0010\u00a0\u0001\"\u0006\b\u00ac\u0001\u0010\u00a2\u0001R#\u00101\u001a\u0004\u0018\u000102X\u0086\u000e\u00a2\u0006\u0015\n\u0003\u0010\u00b1\u0001\u001a\u0006\b\u00ad\u0001\u0010\u00ae\u0001\"\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b2\u0001\u0010|\"\u0005\b\u00b3\u0001\u0010~R\u001e\u0010/\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b4\u0001\u0010T\"\u0005\b\u00b5\u0001\u0010VR\u001e\u0010&\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b6\u0001\u0010T\"\u0005\b\u00b7\u0001\u0010VR\u001e\u00105\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b8\u0001\u0010T\"\u0005\b\u00b9\u0001\u0010VR\u001e\u00109\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ba\u0001\u0010T\"\u0005\b\u00bb\u0001\u0010VR\u001e\u0010:\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00bc\u0001\u0010T\"\u0005\b\u00bd\u0001\u0010VR\u001e\u0010;\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00be\u0001\u0010T\"\u0005\b\u00bf\u0001\u0010VR\u001e\u00108\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c0\u0001\u0010T\"\u0005\b\u00c1\u0001\u0010VR\u001e\u00106\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c2\u0001\u0010T\"\u0005\b\u00c3\u0001\u0010VR\u001e\u00107\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c4\u0001\u0010T\"\u0005\b\u00c5\u0001\u0010VR\u001e\u00104\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00c6\u0001\u0010T\"\u0005\b\u00c7\u0001\u0010VR\u001e\u00100\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00c8\u0001\u0010\u0098\u0001\"\u0006\b\u00c9\u0001\u0010\u009a\u0001R\u001e\u0010\'\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ca\u0001\u0010T\"\u0005\b\u00cb\u0001\u0010VR\u001e\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00cc\u0001\u0010T\"\u0005\b\u00cd\u0001\u0010VR\u001e\u0010#\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ce\u0001\u0010T\"\u0005\b\u00cf\u0001\u0010VR \u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00d0\u0001\u0010\u0082\u0001\"\u0006\b\u00d1\u0001\u0010\u0084\u0001R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d2\u0001\u0010T\"\u0005\b\u00d3\u0001\u0010VR\u001e\u0010=\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d4\u0001\u0010T\"\u0005\b\u00d5\u0001\u0010VR\u001e\u0010A\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d6\u0001\u0010T\"\u0005\b\u00d7\u0001\u0010VR\u001e\u0010B\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d8\u0001\u0010T\"\u0005\b\u00d9\u0001\u0010VR\u001e\u0010C\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00da\u0001\u0010T\"\u0005\b\u00db\u0001\u0010VR\u001e\u0010@\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00dc\u0001\u0010T\"\u0005\b\u00dd\u0001\u0010VR\u001e\u0010>\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00de\u0001\u0010T\"\u0005\b\u00df\u0001\u0010VR\u001e\u0010?\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e0\u0001\u0010T\"\u0005\b\u00e1\u0001\u0010VR\u001e\u0010<\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e2\u0001\u0010T\"\u0005\b\u00e3\u0001\u0010VR\u001e\u0010\u0016\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00e4\u0001\u0010\u0098\u0001\"\u0006\b\u00e5\u0001\u0010\u009a\u0001R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e6\u0001\u0010T\"\u0005\b\u00e7\u0001\u0010VR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e8\u0001\u0010T\"\u0005\b\u00e9\u0001\u0010VR\u001e\u0010O\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ea\u0001\u0010T\"\u0005\b\u00eb\u0001\u0010VR\u001e\u0010P\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ec\u0001\u0010T\"\u0005\b\u00ed\u0001\u0010VR\u001e\u0010%\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ee\u0001\u0010T\"\u0005\b\u00ef\u0001\u0010VR\u001e\u00103\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00f0\u0001\u0010T\"\u0005\b\u00f1\u0001\u0010VR\u001e\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00f2\u0001\u0010\u0098\u0001\"\u0006\b\u00f3\u0001\u0010\u009a\u0001\u00a8\u0006\u00c4\u0002"}, d2 = {"Looo/jtc/rupayment/model/RuPayment;", "", "id", "Ljava/util/UUID;", "id_Customer", "id_Branch", "document_Number", "", "document_Number_Sort", "receive_Date", "Ljava/time/LocalDate;", "document_Date", "client_Status", "bank_Status", "channel", "created_At", "Ljava/sql/Timestamp;", "deleted_At", "modified_At", "version", "", "status", "scheme_Version", "cpm", "debit_Date", "expected_Execution_Date", "sign_Check_Message", "execution_Message", "id_Execution_User", "execution_Date", "receive_Message", "id_Receiver_User", "customer_Name", "branch_Name", "payment_Type", "payment_Type_Code", "amount", "uin_Uip", "operation_Type", "payment_Priority", "ground_Operation_Code", "ground_Description", "ground_Nds_Calculation", "ground_Nds_Percent", "ground_Nds", "commission", "commission_Type", "note_From_Receiver", "payment_Code", "income_Type_Code", "", "user_Payment_Type", "payer_Name", "payer_Account", "payer_Inn", "payer_Kpp", "payer_Bank_Name", "payer_Bank_Address", "payer_Bank_Bic", "payer_Bank_Corr_Account", "receiver_Name", "receiver_Account", "receiver_Inn", "receiver_Kpp", "receiver_Bank_Name", "receiver_Bank_Address", "receiver_Bank_Bic", "receiver_Bank_Corr_Account", "budget_Type", "budget_Payer_Status", "budget_Kbk", "budget_Oktmo", "budget_Reason_Code", "budget_Field_107", "budget_Reason_Date", "budget_Reason_Number", "budget_Customs_Code", "amount_Recovery", "Ljava/math/BigDecimal;", "transfer_Term_Code", "transfer_Term_Description", "id_Import", "(Ljava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/time/LocalDate;Ljava/time/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/sql/Timestamp;Ljava/sql/Timestamp;Ljava/sql/Timestamp;JLjava/lang/String;JLjava/lang/String;Ljava/time/LocalDate;Ljava/time/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Ljava/time/LocalDate;Ljava/lang/String;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;)V", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "getAmount_Recovery", "()Ljava/math/BigDecimal;", "setAmount_Recovery", "(Ljava/math/BigDecimal;)V", "getBank_Status", "setBank_Status", "getBranch_Name", "setBranch_Name", "getBudget_Customs_Code", "setBudget_Customs_Code", "getBudget_Field_107", "setBudget_Field_107", "getBudget_Kbk", "setBudget_Kbk", "getBudget_Oktmo", "setBudget_Oktmo", "getBudget_Payer_Status", "setBudget_Payer_Status", "getBudget_Reason_Code", "setBudget_Reason_Code", "getBudget_Reason_Date", "setBudget_Reason_Date", "getBudget_Reason_Number", "setBudget_Reason_Number", "getBudget_Type", "setBudget_Type", "getChannel", "setChannel", "getClient_Status", "setClient_Status", "getCommission", "setCommission", "getCommission_Type", "setCommission_Type", "getCpm", "setCpm", "getCreated_At", "()Ljava/sql/Timestamp;", "setCreated_At", "(Ljava/sql/Timestamp;)V", "getCustomer_Name", "setCustomer_Name", "getDebit_Date", "()Ljava/time/LocalDate;", "setDebit_Date", "(Ljava/time/LocalDate;)V", "getDeleted_At", "setDeleted_At", "getDocument_Date", "setDocument_Date", "getDocument_Number", "setDocument_Number", "getDocument_Number_Sort", "setDocument_Number_Sort", "getExecution_Date", "setExecution_Date", "getExecution_Message", "setExecution_Message", "getExpected_Execution_Date", "setExpected_Execution_Date", "getGround_Description", "setGround_Description", "getGround_Nds", "setGround_Nds", "getGround_Nds_Calculation", "()J", "setGround_Nds_Calculation", "(J)V", "getGround_Nds_Percent", "setGround_Nds_Percent", "getGround_Operation_Code", "setGround_Operation_Code", "getId", "()Ljava/util/UUID;", "setId", "(Ljava/util/UUID;)V", "getId_Branch", "setId_Branch", "getId_Customer", "setId_Customer", "getId_Execution_User", "setId_Execution_User", "getId_Import", "setId_Import", "getId_Receiver_User", "setId_Receiver_User", "getIncome_Type_Code", "()Ljava/lang/Integer;", "setIncome_Type_Code", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getModified_At", "setModified_At", "getNote_From_Receiver", "setNote_From_Receiver", "getOperation_Type", "setOperation_Type", "getPayer_Account", "setPayer_Account", "getPayer_Bank_Address", "setPayer_Bank_Address", "getPayer_Bank_Bic", "setPayer_Bank_Bic", "getPayer_Bank_Corr_Account", "setPayer_Bank_Corr_Account", "getPayer_Bank_Name", "setPayer_Bank_Name", "getPayer_Inn", "setPayer_Inn", "getPayer_Kpp", "setPayer_Kpp", "getPayer_Name", "setPayer_Name", "getPayment_Code", "setPayment_Code", "getPayment_Priority", "setPayment_Priority", "getPayment_Type", "setPayment_Type", "getPayment_Type_Code", "setPayment_Type_Code", "getReceive_Date", "setReceive_Date", "getReceive_Message", "setReceive_Message", "getReceiver_Account", "setReceiver_Account", "getReceiver_Bank_Address", "setReceiver_Bank_Address", "getReceiver_Bank_Bic", "setReceiver_Bank_Bic", "getReceiver_Bank_Corr_Account", "setReceiver_Bank_Corr_Account", "getReceiver_Bank_Name", "setReceiver_Bank_Name", "getReceiver_Inn", "setReceiver_Inn", "getReceiver_Kpp", "setReceiver_Kpp", "getReceiver_Name", "setReceiver_Name", "getScheme_Version", "setScheme_Version", "getSign_Check_Message", "setSign_Check_Message", "getStatus", "setStatus", "getTransfer_Term_Code", "setTransfer_Term_Code", "getTransfer_Term_Description", "setTransfer_Term_Description", "getUin_Uip", "setUin_Uip", "getUser_Payment_Type", "setUser_Payment_Type", "getVersion", "setVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component7", "component70", "component71", "component72", "component73", "component8", "component9", "copy", "(Ljava/util/UUID;Ljava/util/UUID;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/time/LocalDate;Ljava/time/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/sql/Timestamp;Ljava/sql/Timestamp;Ljava/sql/Timestamp;JLjava/lang/String;JLjava/lang/String;Ljava/time/LocalDate;Ljava/time/LocalDate;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Ljava/time/LocalDate;Ljava/lang/String;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;)Looo/jtc/rupayment/model/RuPayment;", "equals", "", "other", "hashCode", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@ooo.jtc.annotations.EntityName(name = "\u0420\u0443\u0431\u043b\u0435\u0432\u043e\u0435 \u041f\u041f")
@com.github.pozo.KotlinBuilder()
public final class RuPayment {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id_Customer;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id_Branch;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String document_Number;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String document_Number_Sort;
    @org.jetbrains.annotations.Nullable()
    private java.time.LocalDate receive_Date;
    @org.jetbrains.annotations.Nullable()
    private java.time.LocalDate document_Date;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String client_Status;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String bank_Status;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String channel;
    @org.jetbrains.annotations.Nullable()
    private java.sql.Timestamp created_At;
    @org.jetbrains.annotations.Nullable()
    private java.sql.Timestamp deleted_At;
    @org.jetbrains.annotations.Nullable()
    private java.sql.Timestamp modified_At;
    private long version;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String status;
    private long scheme_Version;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String cpm;
    @org.jetbrains.annotations.Nullable()
    private java.time.LocalDate debit_Date;
    @org.jetbrains.annotations.Nullable()
    private java.time.LocalDate expected_Execution_Date;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String sign_Check_Message;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String execution_Message;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id_Execution_User;
    @org.jetbrains.annotations.Nullable()
    private java.time.LocalDate execution_Date;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String receive_Message;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id_Receiver_User;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String customer_Name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String branch_Name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payment_Type;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payment_Type_Code;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String amount;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String uin_Uip;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String operation_Type;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payment_Priority;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String ground_Operation_Code;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String ground_Description;
    private long ground_Nds_Calculation;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String ground_Nds_Percent;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String ground_Nds;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String commission;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String commission_Type;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String note_From_Receiver;
    private long payment_Code;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer income_Type_Code;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String user_Payment_Type;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payer_Name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payer_Account;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payer_Inn;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payer_Kpp;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payer_Bank_Name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payer_Bank_Address;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payer_Bank_Bic;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payer_Bank_Corr_Account;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String receiver_Name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String receiver_Account;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String receiver_Inn;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String receiver_Kpp;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String receiver_Bank_Name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String receiver_Bank_Address;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String receiver_Bank_Bic;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String receiver_Bank_Corr_Account;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String budget_Type;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String budget_Payer_Status;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String budget_Kbk;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String budget_Oktmo;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String budget_Reason_Code;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String budget_Field_107;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String budget_Reason_Date;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String budget_Reason_Number;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String budget_Customs_Code;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal amount_Recovery;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String transfer_Term_Code;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String transfer_Term_Description;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id_Import;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getId_Customer() {
        return null;
    }
    
    public final void setId_Customer(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getId_Branch() {
        return null;
    }
    
    public final void setId_Branch(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDocument_Number() {
        return null;
    }
    
    public final void setDocument_Number(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDocument_Number_Sort() {
        return null;
    }
    
    public final void setDocument_Number_Sort(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate getReceive_Date() {
        return null;
    }
    
    public final void setReceive_Date(@org.jetbrains.annotations.Nullable()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate getDocument_Date() {
        return null;
    }
    
    public final void setDocument_Date(@org.jetbrains.annotations.Nullable()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getClient_Status() {
        return null;
    }
    
    public final void setClient_Status(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBank_Status() {
        return null;
    }
    
    public final void setBank_Status(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getChannel() {
        return null;
    }
    
    public final void setChannel(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp getCreated_At() {
        return null;
    }
    
    public final void setCreated_At(@org.jetbrains.annotations.Nullable()
    java.sql.Timestamp p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp getDeleted_At() {
        return null;
    }
    
    public final void setDeleted_At(@org.jetbrains.annotations.Nullable()
    java.sql.Timestamp p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp getModified_At() {
        return null;
    }
    
    public final void setModified_At(@org.jetbrains.annotations.Nullable()
    java.sql.Timestamp p0) {
    }
    
    public final long getVersion() {
        return 0L;
    }
    
    public final void setVersion(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final long getScheme_Version() {
        return 0L;
    }
    
    public final void setScheme_Version(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCpm() {
        return null;
    }
    
    public final void setCpm(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate getDebit_Date() {
        return null;
    }
    
    public final void setDebit_Date(@org.jetbrains.annotations.Nullable()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate getExpected_Execution_Date() {
        return null;
    }
    
    public final void setExpected_Execution_Date(@org.jetbrains.annotations.Nullable()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSign_Check_Message() {
        return null;
    }
    
    public final void setSign_Check_Message(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getExecution_Message() {
        return null;
    }
    
    public final void setExecution_Message(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getId_Execution_User() {
        return null;
    }
    
    public final void setId_Execution_User(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate getExecution_Date() {
        return null;
    }
    
    public final void setExecution_Date(@org.jetbrains.annotations.Nullable()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReceive_Message() {
        return null;
    }
    
    public final void setReceive_Message(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getId_Receiver_User() {
        return null;
    }
    
    public final void setId_Receiver_User(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCustomer_Name() {
        return null;
    }
    
    public final void setCustomer_Name(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBranch_Name() {
        return null;
    }
    
    public final void setBranch_Name(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayment_Type() {
        return null;
    }
    
    public final void setPayment_Type(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayment_Type_Code() {
        return null;
    }
    
    public final void setPayment_Type_Code(@org.jetbrains.annotations.Nullable()
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
    public final java.lang.String getUin_Uip() {
        return null;
    }
    
    public final void setUin_Uip(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOperation_Type() {
        return null;
    }
    
    public final void setOperation_Type(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayment_Priority() {
        return null;
    }
    
    public final void setPayment_Priority(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGround_Operation_Code() {
        return null;
    }
    
    public final void setGround_Operation_Code(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGround_Description() {
        return null;
    }
    
    public final void setGround_Description(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final long getGround_Nds_Calculation() {
        return 0L;
    }
    
    public final void setGround_Nds_Calculation(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGround_Nds_Percent() {
        return null;
    }
    
    public final void setGround_Nds_Percent(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGround_Nds() {
        return null;
    }
    
    public final void setGround_Nds(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCommission() {
        return null;
    }
    
    public final void setCommission(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCommission_Type() {
        return null;
    }
    
    public final void setCommission_Type(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNote_From_Receiver() {
        return null;
    }
    
    public final void setNote_From_Receiver(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final long getPayment_Code() {
        return 0L;
    }
    
    public final void setPayment_Code(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getIncome_Type_Code() {
        return null;
    }
    
    public final void setIncome_Type_Code(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUser_Payment_Type() {
        return null;
    }
    
    public final void setUser_Payment_Type(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayer_Name() {
        return null;
    }
    
    public final void setPayer_Name(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayer_Account() {
        return null;
    }
    
    public final void setPayer_Account(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayer_Inn() {
        return null;
    }
    
    public final void setPayer_Inn(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayer_Kpp() {
        return null;
    }
    
    public final void setPayer_Kpp(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayer_Bank_Name() {
        return null;
    }
    
    public final void setPayer_Bank_Name(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayer_Bank_Address() {
        return null;
    }
    
    public final void setPayer_Bank_Address(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayer_Bank_Bic() {
        return null;
    }
    
    public final void setPayer_Bank_Bic(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayer_Bank_Corr_Account() {
        return null;
    }
    
    public final void setPayer_Bank_Corr_Account(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReceiver_Name() {
        return null;
    }
    
    public final void setReceiver_Name(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReceiver_Account() {
        return null;
    }
    
    public final void setReceiver_Account(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReceiver_Inn() {
        return null;
    }
    
    public final void setReceiver_Inn(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReceiver_Kpp() {
        return null;
    }
    
    public final void setReceiver_Kpp(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReceiver_Bank_Name() {
        return null;
    }
    
    public final void setReceiver_Bank_Name(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReceiver_Bank_Address() {
        return null;
    }
    
    public final void setReceiver_Bank_Address(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReceiver_Bank_Bic() {
        return null;
    }
    
    public final void setReceiver_Bank_Bic(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReceiver_Bank_Corr_Account() {
        return null;
    }
    
    public final void setReceiver_Bank_Corr_Account(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBudget_Type() {
        return null;
    }
    
    public final void setBudget_Type(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBudget_Payer_Status() {
        return null;
    }
    
    public final void setBudget_Payer_Status(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBudget_Kbk() {
        return null;
    }
    
    public final void setBudget_Kbk(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBudget_Oktmo() {
        return null;
    }
    
    public final void setBudget_Oktmo(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBudget_Reason_Code() {
        return null;
    }
    
    public final void setBudget_Reason_Code(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBudget_Field_107() {
        return null;
    }
    
    public final void setBudget_Field_107(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBudget_Reason_Date() {
        return null;
    }
    
    public final void setBudget_Reason_Date(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBudget_Reason_Number() {
        return null;
    }
    
    public final void setBudget_Reason_Number(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBudget_Customs_Code() {
        return null;
    }
    
    public final void setBudget_Customs_Code(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getAmount_Recovery() {
        return null;
    }
    
    public final void setAmount_Recovery(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTransfer_Term_Code() {
        return null;
    }
    
    public final void setTransfer_Term_Code(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTransfer_Term_Description() {
        return null;
    }
    
    public final void setTransfer_Term_Description(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getId_Import() {
        return null;
    }
    
    public final void setId_Import(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    public RuPayment(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, @org.jetbrains.annotations.Nullable()
    java.util.UUID id_Customer, @org.jetbrains.annotations.Nullable()
    java.util.UUID id_Branch, @org.jetbrains.annotations.Nullable()
    java.lang.String document_Number, @org.jetbrains.annotations.Nullable()
    java.lang.String document_Number_Sort, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate receive_Date, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate document_Date, @org.jetbrains.annotations.Nullable()
    java.lang.String client_Status, @org.jetbrains.annotations.Nullable()
    java.lang.String bank_Status, @org.jetbrains.annotations.Nullable()
    java.lang.String channel, @org.jetbrains.annotations.Nullable()
    java.sql.Timestamp created_At, @org.jetbrains.annotations.Nullable()
    java.sql.Timestamp deleted_At, @org.jetbrains.annotations.Nullable()
    java.sql.Timestamp modified_At, long version, @org.jetbrains.annotations.Nullable()
    java.lang.String status, long scheme_Version, @org.jetbrains.annotations.Nullable()
    java.lang.String cpm, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate debit_Date, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate expected_Execution_Date, @org.jetbrains.annotations.Nullable()
    java.lang.String sign_Check_Message, @org.jetbrains.annotations.Nullable()
    java.lang.String execution_Message, @org.jetbrains.annotations.Nullable()
    java.util.UUID id_Execution_User, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate execution_Date, @org.jetbrains.annotations.Nullable()
    java.lang.String receive_Message, @org.jetbrains.annotations.Nullable()
    java.util.UUID id_Receiver_User, @org.jetbrains.annotations.Nullable()
    java.lang.String customer_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String branch_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String payment_Type, @org.jetbrains.annotations.Nullable()
    java.lang.String payment_Type_Code, @org.jetbrains.annotations.Nullable()
    java.lang.String amount, @org.jetbrains.annotations.Nullable()
    java.lang.String uin_Uip, @org.jetbrains.annotations.Nullable()
    java.lang.String operation_Type, @org.jetbrains.annotations.Nullable()
    java.lang.String payment_Priority, @org.jetbrains.annotations.Nullable()
    java.lang.String ground_Operation_Code, @org.jetbrains.annotations.Nullable()
    java.lang.String ground_Description, long ground_Nds_Calculation, @org.jetbrains.annotations.Nullable()
    java.lang.String ground_Nds_Percent, @org.jetbrains.annotations.Nullable()
    java.lang.String ground_Nds, @org.jetbrains.annotations.Nullable()
    java.lang.String commission, @org.jetbrains.annotations.Nullable()
    java.lang.String commission_Type, @org.jetbrains.annotations.Nullable()
    java.lang.String note_From_Receiver, long payment_Code, @org.jetbrains.annotations.Nullable()
    java.lang.Integer income_Type_Code, @org.jetbrains.annotations.Nullable()
    java.lang.String user_Payment_Type, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Account, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Inn, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Kpp, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Bank_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Bank_Address, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Bank_Bic, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Bank_Corr_Account, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Account, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Inn, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Kpp, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Bank_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Bank_Address, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Bank_Bic, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Bank_Corr_Account, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Type, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Payer_Status, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Kbk, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Oktmo, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Reason_Code, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Field_107, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Reason_Date, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Reason_Number, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Customs_Code, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal amount_Recovery, @org.jetbrains.annotations.Nullable()
    java.lang.String transfer_Term_Code, @org.jetbrains.annotations.Nullable()
    java.lang.String transfer_Term_Description, @org.jetbrains.annotations.Nullable()
    java.util.UUID id_Import) {
        super();
    }
    
    public RuPayment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate component7() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp component13() {
        return null;
    }
    
    public final long component14() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    public final long component16() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate component19() {
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
    public final java.util.UUID component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component25() {
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
    public final java.lang.String component34() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component35() {
        return null;
    }
    
    public final long component36() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component37() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component38() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component39() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component40() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component41() {
        return null;
    }
    
    public final long component42() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component43() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component44() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component45() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component46() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component47() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component48() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component49() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component50() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component51() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component52() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component53() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component54() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component55() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component56() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component57() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component58() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component59() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component60() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component61() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component62() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component63() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component64() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component65() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component66() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component67() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component68() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component69() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component70() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component71() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component72() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component73() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rupayment.model.RuPayment copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, @org.jetbrains.annotations.Nullable()
    java.util.UUID id_Customer, @org.jetbrains.annotations.Nullable()
    java.util.UUID id_Branch, @org.jetbrains.annotations.Nullable()
    java.lang.String document_Number, @org.jetbrains.annotations.Nullable()
    java.lang.String document_Number_Sort, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate receive_Date, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate document_Date, @org.jetbrains.annotations.Nullable()
    java.lang.String client_Status, @org.jetbrains.annotations.Nullable()
    java.lang.String bank_Status, @org.jetbrains.annotations.Nullable()
    java.lang.String channel, @org.jetbrains.annotations.Nullable()
    java.sql.Timestamp created_At, @org.jetbrains.annotations.Nullable()
    java.sql.Timestamp deleted_At, @org.jetbrains.annotations.Nullable()
    java.sql.Timestamp modified_At, long version, @org.jetbrains.annotations.Nullable()
    java.lang.String status, long scheme_Version, @org.jetbrains.annotations.Nullable()
    java.lang.String cpm, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate debit_Date, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate expected_Execution_Date, @org.jetbrains.annotations.Nullable()
    java.lang.String sign_Check_Message, @org.jetbrains.annotations.Nullable()
    java.lang.String execution_Message, @org.jetbrains.annotations.Nullable()
    java.util.UUID id_Execution_User, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate execution_Date, @org.jetbrains.annotations.Nullable()
    java.lang.String receive_Message, @org.jetbrains.annotations.Nullable()
    java.util.UUID id_Receiver_User, @org.jetbrains.annotations.Nullable()
    java.lang.String customer_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String branch_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String payment_Type, @org.jetbrains.annotations.Nullable()
    java.lang.String payment_Type_Code, @org.jetbrains.annotations.Nullable()
    java.lang.String amount, @org.jetbrains.annotations.Nullable()
    java.lang.String uin_Uip, @org.jetbrains.annotations.Nullable()
    java.lang.String operation_Type, @org.jetbrains.annotations.Nullable()
    java.lang.String payment_Priority, @org.jetbrains.annotations.Nullable()
    java.lang.String ground_Operation_Code, @org.jetbrains.annotations.Nullable()
    java.lang.String ground_Description, long ground_Nds_Calculation, @org.jetbrains.annotations.Nullable()
    java.lang.String ground_Nds_Percent, @org.jetbrains.annotations.Nullable()
    java.lang.String ground_Nds, @org.jetbrains.annotations.Nullable()
    java.lang.String commission, @org.jetbrains.annotations.Nullable()
    java.lang.String commission_Type, @org.jetbrains.annotations.Nullable()
    java.lang.String note_From_Receiver, long payment_Code, @org.jetbrains.annotations.Nullable()
    java.lang.Integer income_Type_Code, @org.jetbrains.annotations.Nullable()
    java.lang.String user_Payment_Type, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Account, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Inn, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Kpp, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Bank_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Bank_Address, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Bank_Bic, @org.jetbrains.annotations.Nullable()
    java.lang.String payer_Bank_Corr_Account, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Account, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Inn, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Kpp, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Bank_Name, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Bank_Address, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Bank_Bic, @org.jetbrains.annotations.Nullable()
    java.lang.String receiver_Bank_Corr_Account, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Type, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Payer_Status, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Kbk, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Oktmo, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Reason_Code, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Field_107, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Reason_Date, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Reason_Number, @org.jetbrains.annotations.Nullable()
    java.lang.String budget_Customs_Code, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal amount_Recovery, @org.jetbrains.annotations.Nullable()
    java.lang.String transfer_Term_Code, @org.jetbrains.annotations.Nullable()
    java.lang.String transfer_Term_Description, @org.jetbrains.annotations.Nullable()
    java.util.UUID id_Import) {
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