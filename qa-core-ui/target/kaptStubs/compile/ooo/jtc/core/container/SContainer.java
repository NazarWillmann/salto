package ooo.jtc.core.container;

import java.lang.System;

/**
 * Контейнер-обертка для [SelenideElement].
 * Позволяет создавать новые сложные элементы в контексте текущего элемента.
 * Добавляет возможность человеко-читаемого наименования элементов.
 *
 * Основные элементы контейнера: [selenideElement] и [ctx].
 *
 * @param sName - наименование элемента. Используется для формирования [title], который используется в [toString], в т.ч. для отчета.
 * @param sElement - основной [SelenideElement] находящийся в контейнере.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00d2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0018\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010&\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J!\u0010&\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u00042\u0006\u0010)\u001a\u00020*H\u0097\u0001J\u0019\u0010&\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010+0+H\u0097\u0001J!\u0010&\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010+0+2\u0006\u0010)\u001a\u00020*H\u0097\u0001J\u0019\u0010,\u001a\u00020-2\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J\u0019\u0010,\u001a\u00020-2\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010+0+H\u0097\u0001J\u0019\u0010.\u001a\u00020-2\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J\u0019\u0010/\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J!\u0010/\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u00042\u0006\u0010)\u001a\u00020*H\u0097\u0001J\u0019\u00100\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J\u001b\u00101\u001a\u0004\u0018\u00010\u00042\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J\t\u00102\u001a\u000203H\u0096\u0001J\t\u00104\u001a\u000203H\u0096\u0001J\u0019\u00104\u001a\u0002032\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010505H\u0096\u0001J\u0010\u00104\u001a\u0002032\b\b\u0002\u00106\u001a\u00020\bJ\u0019\u00104\u001a\u0002032\u0006\u0010\'\u001a\u00020*2\u0006\u0010)\u001a\u00020*H\u0097\u0001J\u0019\u00107\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J\t\u00108\u001a\u00020\u0001H\u0097\u0001J\u001b\u00109\u001a\u0004\u0018\u00010\u00042\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J\t\u0010:\u001a\u00020\u0001H\u0097\u0001J\t\u0010;\u001a\u00020<H\u0097\u0001J\u0019\u0010;\u001a\u00020<2\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010=0=H\u0097\u0001J\u0019\u0010;\u001a\u00020<2\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010>0>H\u0097\u0001J\u0011\u0010;\u001a\u00020<2\u0006\u0010\'\u001a\u00020\u0011H\u0097\u0001J!\u0010;\u001a\u00020<2\u0006\u0010\'\u001a\u00020\u00112\u000e\u0010)\u001a\n (*\u0004\u0018\u00010>0>H\u0097\u0001J\u0019\u0010?\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J\u0019\u0010?\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010@0@H\u0097\u0001JT\u0010A\u001a\n (*\u0004\u0018\u0001HBHB\"\u0010\b\u0000\u0010B*\n (*\u0004\u0018\u00010C0C2*\u0010\'\u001a&\u0012\f\u0012\n (*\u0004\u0018\u0001HBHB (*\u0012\u0012\f\u0012\n (*\u0004\u0018\u0001HBHB\u0018\u00010D0DH\u0096\u0001\u00a2\u0006\u0002\u0010EJ\u000e\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0004J\t\u0010H\u001a\u00020\bH\u0097\u0001J\u0019\u0010I\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J!\u0010I\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u00042\u0006\u0010)\u001a\u00020*H\u0097\u0001J!\u0010I\u001a\n (*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010+0+H\u0097\u0001J!\u0010I\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010+0+2\u0006\u0010)\u001a\u00020*H\u0097\u0001J\u0019\u0010J\u001a\u00020-2\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J\u0019\u0010J\u001a\u00020-2\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010+0+H\u0097\u0001J\u000e\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u0004J!\u0010M\u001a\n (*\u0004\u0018\u00010@0@2\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010+0+H\u0096\u0001J=\u0010N\u001a&\u0012\f\u0012\n (*\u0004\u0018\u00010@0@ (*\u0012\u0012\f\u0012\n (*\u0004\u0018\u00010@0@\u0018\u00010P0O2\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010+0+H\u0096\u0001J\u001b\u0010Q\u001a\u0004\u0018\u00010\u00042\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J\u0011\u0010R\u001a\n (*\u0004\u0018\u00010S0SH\u0096\u0001J\u0019\u0010T\u001a\u00020\u00042\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J\u0011\u0010U\u001a\n (*\u0004\u0018\u00010V0VH\u0096\u0001J\t\u0010W\u001a\u00020\u0004H\u0097\u0001J\u0011\u0010X\u001a\n (*\u0004\u0018\u00010Y0YH\u0096\u0001JT\u0010Z\u001a\n (*\u0004\u0018\u0001H[H[\"\u0010\b\u0000\u0010[*\n (*\u0004\u0018\u00010C0C2*\u0010\'\u001a&\u0012\f\u0012\n (*\u0004\u0018\u0001H[H[ (*\u0012\u0012\f\u0012\n (*\u0004\u0018\u0001H[H[\u0018\u00010\\0\\H\u0096\u0001\u00a2\u0006\u0002\u0010]J\t\u0010^\u001a\u00020\u0004H\u0097\u0001J\t\u0010_\u001a\u00020\u0001H\u0097\u0001J\t\u0010`\u001a\u00020-H\u0097\u0001J\t\u0010a\u001a\u00020\u0004H\u0097\u0001J\u000b\u0010b\u001a\u0004\u0018\u00010\u0004H\u0097\u0001J\u0011\u0010c\u001a\n (*\u0004\u0018\u00010d0dH\u0096\u0001J\u0011\u0010e\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\t\u0010f\u001a\u00020\u0004H\u0097\u0001J\u000e\u0010g\u001a\u00020\u00042\u0006\u0010h\u001a\u00020\u0004J\u000b\u0010i\u001a\u0004\u0018\u00010\u0004H\u0097\u0001J\u0011\u0010j\u001a\n (*\u0004\u0018\u00010k0kH\u0096\u0001J\t\u0010l\u001a\u00020@H\u0097\u0001J\u0019\u0010m\u001a\u00020\b2\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010n0nH\u0097\u0001J\t\u0010o\u001a\u00020\u0001H\u0097\u0001J\t\u0010p\u001a\u00020\u0004H\u0097\u0001J\t\u0010q\u001a\u00020\u0004H\u0097\u0001J\u0019\u0010r\u001a\u00020\b2\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010n0nH\u0097\u0001J\t\u0010s\u001a\u00020\bH\u0097\u0001J\t\u0010t\u001a\u00020\bH\u0096\u0001J\t\u0010u\u001a\u00020\bH\u0096\u0001J\t\u0010v\u001a\u00020\bH\u0096\u0001J\t\u0010w\u001a\u00020\u0001H\u0097\u0001J\u000b\u0010x\u001a\u0004\u0018\u00010\u0004H\u0097\u0001J\t\u0010y\u001a\u00020\u0001H\u0097\u0001J\u0011\u0010z\u001a\u00020\u00012\u0006\u0010\'\u001a\u00020*H\u0097\u0001J\t\u0010{\u001a\u00020\u0001H\u0097\u0001J\t\u0010|\u001a\u00020\u0001H\u0097\u0001J\t\u0010}\u001a\u00020\u0001H\u0097\u0001J\u0019\u0010~\u001a\u00020\u00042\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J)\u0010~\u001a\u00020\u00042\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u00042\u000e\u0010)\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J\u000b\u0010\u007f\u001a\u0004\u0018\u00010<H\u0097\u0001J\r\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0097\u0001J\u0012\u0010\u0082\u0001\u001a\u00020\u00012\u0006\u0010\'\u001a\u00020\bH\u0097\u0001J\u001a\u0010\u0082\u0001\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001J\n\u0010\u0083\u0001\u001a\u00020\u0001H\u0097\u0001JL\u0010\u0084\u0001\u001a\u0002032:\u0010\'\u001a*\u0012\f\u0012\n (*\u0004\u0018\u00010\u00040\u0004 (*\u0015\u0012\u000e\b\u0001\u0012\n (*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0085\u00010\u0085\u0001\"\n (*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001\u00a2\u0006\u0003\u0010\u0086\u0001J \u0010\u0084\u0001\u001a\u0002032\u0014\u0010\'\u001a\f (*\u0005\u0018\u00010\u0087\u00010\u0087\u0001\"\u00020*H\u0096\u0001JL\u0010\u0088\u0001\u001a\u0002032:\u0010\'\u001a*\u0012\f\u0012\n (*\u0004\u0018\u00010\u00040\u0004 (*\u0015\u0012\u000e\b\u0001\u0012\n (*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0085\u00010\u0085\u0001\"\n (*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001\u00a2\u0006\u0003\u0010\u0086\u0001J\u001a\u0010\u0089\u0001\u001a\u0002032\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u001a\u0010\u008a\u0001\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001JR\u0010\u008b\u0001\u001a\u0002032@\u0010\'\u001a.\u0012\u000e\u0012\f (*\u0005\u0018\u00010\u008c\u00010\u008c\u0001 (*\u0017\u0012\u0010\b\u0001\u0012\f (*\u0005\u0018\u00010\u008c\u00010\u008c\u0001\u0018\u00010\u0085\u00010\u0085\u0001\"\f (*\u0005\u0018\u00010\u008c\u00010\u008c\u0001H\u0096\u0001\u00a2\u0006\u0003\u0010\u008d\u0001J\u0012\u0010\u008e\u0001\u001a\u00020\u00012\u0006\u0010\'\u001a\u00020\bH\u0097\u0001J\u0014\u0010\u008f\u0001\u001a\u00020\u00012\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0004H\u0016JL\u0010\u0091\u0001\u001a\u00020\u00012:\u0010\'\u001a*\u0012\f\u0012\n (*\u0004\u0018\u00010n0n (*\u0015\u0012\u000e\b\u0001\u0012\n (*\u0004\u0018\u00010n0n\u0018\u00010\u0085\u00010\u0085\u0001\"\n (*\u0004\u0018\u00010n0nH\u0097\u0001\u00a2\u0006\u0003\u0010\u0092\u0001JL\u0010\u0093\u0001\u001a\u00020\u00012:\u0010\'\u001a*\u0012\f\u0012\n (*\u0004\u0018\u00010n0n (*\u0015\u0012\u000e\b\u0001\u0012\n (*\u0004\u0018\u00010n0n\u0018\u00010\u0085\u00010\u0085\u0001\"\n (*\u0004\u0018\u00010n0nH\u0097\u0001\u00a2\u0006\u0003\u0010\u0092\u0001JL\u0010\u0094\u0001\u001a\u00020\u00012:\u0010\'\u001a*\u0012\f\u0012\n (*\u0004\u0018\u00010n0n (*\u0015\u0012\u000e\b\u0001\u0012\n (*\u0004\u0018\u00010n0n\u0018\u00010\u0085\u00010\u0085\u0001\"\n (*\u0004\u0018\u00010n0nH\u0097\u0001\u00a2\u0006\u0003\u0010\u0092\u0001JL\u0010\u0095\u0001\u001a\u00020\u00012:\u0010\'\u001a*\u0012\f\u0012\n (*\u0004\u0018\u00010n0n (*\u0015\u0012\u000e\b\u0001\u0012\n (*\u0004\u0018\u00010n0n\u0018\u00010\u0085\u00010\u0085\u0001\"\n (*\u0004\u0018\u00010n0nH\u0097\u0001\u00a2\u0006\u0003\u0010\u0092\u0001JL\u0010\u0096\u0001\u001a\u00020\u00012:\u0010\'\u001a*\u0012\f\u0012\n (*\u0004\u0018\u00010n0n (*\u0015\u0012\u000e\b\u0001\u0012\n (*\u0004\u0018\u00010n0n\u0018\u00010\u0085\u00010\u0085\u0001\"\n (*\u0004\u0018\u00010n0nH\u0097\u0001\u00a2\u0006\u0003\u0010\u0092\u0001JL\u0010\u0097\u0001\u001a\u00020\u00012:\u0010\'\u001a*\u0012\f\u0012\n (*\u0004\u0018\u00010n0n (*\u0015\u0012\u000e\b\u0001\u0012\n (*\u0004\u0018\u00010n0n\u0018\u00010\u0085\u00010\u0085\u0001\"\n (*\u0004\u0018\u00010n0nH\u0097\u0001\u00a2\u0006\u0003\u0010\u0092\u0001J\u0012\u0010\u0098\u0001\u001a\u00020\u00012\u0006\u0010\'\u001a\u00020*H\u0097\u0001J\n\u0010\u0099\u0001\u001a\u000203H\u0096\u0001J\n\u0010\u0090\u0001\u001a\u00020\u0004H\u0097\u0001J\t\u0010\u009a\u0001\u001a\u00020\u0004H\u0016J\n\u0010\u009b\u0001\u001a\u00020@H\u0097\u0001JL\u0010\u009c\u0001\u001a\u00020<2:\u0010\'\u001a*\u0012\f\u0012\n (*\u0004\u0018\u00010<0< (*\u0015\u0012\u000e\b\u0001\u0012\n (*\u0004\u0018\u00010<0<\u0018\u00010\u0085\u00010\u0085\u0001\"\n (*\u0004\u0018\u00010<0<H\u0097\u0001\u00a2\u0006\u0003\u0010\u009d\u0001JL\u0010\u009e\u0001\u001a\u00020<2:\u0010\'\u001a*\u0012\f\u0012\n (*\u0004\u0018\u00010\u00040\u0004 (*\u0015\u0012\u000e\b\u0001\u0012\n (*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0085\u00010\u0085\u0001\"\n (*\u0004\u0018\u00010\u00040\u0004H\u0097\u0001\u00a2\u0006\u0003\u0010\u009f\u0001J\f\u0010\u00a0\u0001\u001a\u0004\u0018\u00010\u0004H\u0097\u0001J\u0016\u0010\u00a0\u0001\u001a\u00020\u00012\n\b\u0001\u0010\'\u001a\u0004\u0018\u00010\u0004H\u0097\u0001J\"\u0010\u00a1\u0001\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010n0n2\u0006\u0010)\u001a\u00020\u0011H\u0097\u0001J+\u0010\u00a1\u0001\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010n0n2\u0006\u0010)\u001a\u00020\u00112\u0007\u0010\u00a2\u0001\u001a\u00020\u0011H\u0097\u0001J\"\u0010\u00a3\u0001\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010n0n2\u0006\u0010)\u001a\u00020\u0011H\u0097\u0001J+\u0010\u00a3\u0001\u001a\u00020\u00012\u000e\u0010\'\u001a\n (*\u0004\u0018\u00010n0n2\u0006\u0010)\u001a\u00020\u00112\u0007\u0010\u00a2\u0001\u001a\u00020\u0011H\u0097\u0001R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u0001X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0011X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00048VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\"\u001a\u00020\bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010%\u00a8\u0006\u00a4\u0001"}, d2 = {"Looo/jtc/core/container/SContainer;", "Lcom/codeborne/selenide/SelenideElement;", "Looo/jtc/core/container/SContext;", "sName", "", "sElement", "(Ljava/lang/String;Lcom/codeborne/selenide/SelenideElement;)V", "isNotDisplayed", "", "()Z", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "pollingInterval", "", "getPollingInterval", "()J", "setPollingInterval", "(J)V", "getSElement", "()Lcom/codeborne/selenide/SelenideElement;", "getSName", "()Ljava/lang/String;", "setSName", "(Ljava/lang/String;)V", "timeout", "getTimeout", "setTimeout", "title", "getTitle", "setTitle", "useJs", "getUseJs", "setUseJs", "(Z)V", "$", "p0", "kotlin.jvm.PlatformType", "p1", "", "Lorg/openqa/selenium/By;", "$$", "Lcom/codeborne/selenide/ElementsCollection;", "$$x", "$x", "append", "attr", "clear", "", "click", "Lcom/codeborne/selenide/ClickOptions;", "ignoreStep", "closest", "contextClick", "data", "doubleClick", "download", "Ljava/io/File;", "Lcom/codeborne/selenide/DownloadOptions;", "Lcom/codeborne/selenide/files/FileFilter;", "dragAndDropTo", "Lorg/openqa/selenium/WebElement;", "execute", "ReturnType", "", "Lcom/codeborne/selenide/Command;", "(Lcom/codeborne/selenide/Command;)Ljava/lang/Object;", "executeJS", "script", "exists", "find", "findAll", "findByDataField", "dataFieldName", "findElement", "findElements", "", "", "getAttribute", "getCoordinates", "Lorg/openqa/selenium/interactions/Coordinates;", "getCssValue", "getLocation", "Lorg/openqa/selenium/Point;", "getOwnText", "getRect", "Lorg/openqa/selenium/Rectangle;", "getScreenshotAs", "X", "Lorg/openqa/selenium/OutputType;", "(Lorg/openqa/selenium/OutputType;)Ljava/lang/Object;", "getSearchCriteria", "getSelectedOption", "getSelectedOptions", "getSelectedText", "getSelectedValue", "getSize", "Lorg/openqa/selenium/Dimension;", "getTagName", "getText", "getTextByDataName", "dataName", "getValue", "getWrappedDriver", "Lorg/openqa/selenium/WebDriver;", "getWrappedElement", "has", "Lcom/codeborne/selenide/Condition;", "hover", "innerHtml", "innerText", "is", "isDisplayed", "isEnabled", "isImage", "isSelected", "lastChild", "name", "parent", "preceding", "pressEnter", "pressEscape", "pressTab", "pseudo", "screenshot", "screenshotAsImage", "Ljava/awt/image/BufferedImage;", "scrollIntoView", "scrollTo", "selectOption", "", "([Ljava/lang/String;)V", "", "selectOptionByValue", "selectOptionContainingText", "selectRadio", "sendKeys", "", "([Ljava/lang/CharSequence;)V", "setSelected", "setValue", "text", "should", "([Lcom/codeborne/selenide/Condition;)Lcom/codeborne/selenide/SelenideElement;", "shouldBe", "shouldHave", "shouldNot", "shouldNotBe", "shouldNotHave", "sibling", "submit", "toString", "toWebElement", "uploadFile", "([Ljava/io/File;)Ljava/io/File;", "uploadFromClasspath", "([Ljava/lang/String;)Ljava/io/File;", "val", "waitUntil", "p2", "waitWhile", "qa-core-ui"})
@ooo.jtc.core.elements.ElementType(name = "\u042d\u043b\u0435\u043c\u0435\u043d\u0442")
public class SContainer implements com.codeborne.selenide.SelenideElement, ooo.jtc.core.container.SContext {
    private final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    
    /**
     * Время ожидания элемента на странице.
     * Используется преимущественно в ожиданиях и проверках [ooo.jtc.core.container.wait].
     */
    private long timeout;
    
    /**
     * Интервал выполнения проверки для элемента.
     */
    private long pollingInterval;
    
    /**
     * Флаг для выполнения действия с элементом через JS.
     */
    private boolean useJs;
    
    /**
     * Наименование элемента (контейнера) для отчета.
     * Формируется динамически. Состоит значения в аннотации [ElementType] над классом элемента
     * и [sName]/либо заданным значением через экстеншн-функцию [withTitle].
     * Если для элемента вызвана функция [withTitle], то значение [sName] (оно же [field])
     * будет заменено на значение из [withTitle].
     *
     * e.g. Для элемента [ooo.jtc.core.elements.Input]:
     * ```
     * @ElementType("Текстовое поле ввода")
     * open class Input(val name: String, sElement: SelenideElement) : SContainer(sName = name, sElement = sElement) {...
     * ```
     * Если создать этот элемент `val code get() = input["code"]`
     * то title будет иметь значение => ` "Текстовое поле ввода": 'code'" `
     *
     * Если создать этот элемент с [withTitle] `val code get() = input["code"].withTitle("КБК")`
     * то title будет иметь значение => ` "Текстовое поле ввода: 'КБК'" `
     */
    @org.jetbrains.annotations.Nullable()
    private java.lang.String title;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String sName;
    @org.jetbrains.annotations.NotNull()
    private final com.codeborne.selenide.SelenideElement sElement = null;
    
    private final org.slf4j.Logger getLog() {
        return null;
    }
    
    public long getTimeout() {
        return 0L;
    }
    
    public void setTimeout(long p0) {
    }
    
    public long getPollingInterval() {
        return 0L;
    }
    
    public void setPollingInterval(long p0) {
    }
    
    public boolean getUseJs() {
        return false;
    }
    
    public void setUseJs(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getTitle() {
        return null;
    }
    
    @java.lang.Override()
    public void setTitle(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Находим элемент от текущего по атрибуту `data-field`.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.codeborne.selenide.SelenideElement findByDataField(@org.jetbrains.annotations.NotNull()
    java.lang.String dataFieldName) {
        return null;
    }
    
    /**
     * Получить текст из элемента по [dataName]
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTextByDataName(@org.jetbrains.annotations.NotNull()
    java.lang.String dataName) {
        return null;
    }
    
    public final boolean isNotDisplayed() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.codeborne.selenide.SelenideElement setValue(@org.jetbrains.annotations.Nullable()
    java.lang.String text) {
        return null;
    }
    
    public final void click(boolean ignoreStep) {
    }
    
    /**
     * Simple wrapper.
     * For actions with the element call `arguments[0]`
     * e.g. - `arguments[0].click()`
     * `selenideElement.wrappedElement` means `arguments[0]` in script.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SContainer executeJS(@org.jetbrains.annotations.NotNull()
    java.lang.String script) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSName() {
        return null;
    }
    
    public final void setSName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.codeborne.selenide.SelenideElement getSElement() {
        return null;
    }
    
    public SContainer(@org.jetbrains.annotations.NotNull()
    java.lang.String sName, @org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super();
    }
    
    public SContainer() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public com.codeborne.selenide.SelenideElement getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement $(java.lang.String p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement $(java.lang.String p0, int p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement $(org.openqa.selenium.By p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement $(org.openqa.selenium.By p0, int p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.ElementsCollection $$(java.lang.String p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.ElementsCollection $$(org.openqa.selenium.By p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.ElementsCollection $$x(java.lang.String p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement $x(java.lang.String p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement $x(java.lang.String p0, int p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement append(java.lang.String p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    @javax.annotation.Nullable()
    @javax.annotation.CheckReturnValue()
    public java.lang.String attr(java.lang.String p0) {
        return null;
    }
    
    @java.lang.Override()
    public void clear() {
    }
    
    @java.lang.Override()
    public void click() {
    }
    
    @java.lang.Override()
    public void click(com.codeborne.selenide.ClickOptions p0) {
    }
    
    @java.lang.Override()
    @java.lang.Deprecated()
    public void click(int p0, int p1) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement closest(java.lang.String p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement contextClick() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    @javax.annotation.Nullable()
    @javax.annotation.CheckReturnValue()
    public java.lang.String data(java.lang.String p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement doubleClick() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.io.File download() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.io.File download(com.codeborne.selenide.DownloadOptions p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.io.File download(com.codeborne.selenide.files.FileFilter p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.io.File download(long p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.io.File download(long p0, com.codeborne.selenide.files.FileFilter p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement dragAndDropTo(java.lang.String p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement dragAndDropTo(org.openqa.selenium.WebElement p0) {
        return null;
    }
    
    @java.lang.Override()
    public <ReturnType extends java.lang.Object>ReturnType execute(com.codeborne.selenide.Command<ReturnType> p0) {
        return null;
    }
    
    @java.lang.Override()
    @javax.annotation.CheckReturnValue()
    public boolean exists() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement find(java.lang.String p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement find(java.lang.String p0, int p1) {
        return null;
    }
    
    @java.lang.Override()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement find(org.openqa.selenium.By p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement find(org.openqa.selenium.By p0, int p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.ElementsCollection findAll(java.lang.String p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.ElementsCollection findAll(org.openqa.selenium.By p0) {
        return null;
    }
    
    @java.lang.Override()
    public org.openqa.selenium.WebElement findElement(org.openqa.selenium.By p0) {
        return null;
    }
    
    @java.lang.Override()
    public java.util.List<org.openqa.selenium.WebElement> findElements(org.openqa.selenium.By p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    @javax.annotation.CheckReturnValue()
    @javax.annotation.Nullable()
    public java.lang.String getAttribute(java.lang.String p0) {
        return null;
    }
    
    @java.lang.Override()
    public org.openqa.selenium.interactions.Coordinates getCoordinates() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.CheckReturnValue()
    @javax.annotation.Nonnull()
    public java.lang.String getCssValue(java.lang.String p0) {
        return null;
    }
    
    @java.lang.Override()
    public org.openqa.selenium.Point getLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.lang.String getOwnText() {
        return null;
    }
    
    @java.lang.Override()
    public org.openqa.selenium.Rectangle getRect() {
        return null;
    }
    
    @java.lang.Override()
    public <X extends java.lang.Object>X getScreenshotAs(org.openqa.selenium.OutputType<X> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.lang.String getSearchCriteria() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement getSelectedOption() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.ElementsCollection getSelectedOptions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.lang.String getSelectedText() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    @javax.annotation.Nullable()
    @javax.annotation.CheckReturnValue()
    public java.lang.String getSelectedValue() {
        return null;
    }
    
    @java.lang.Override()
    public org.openqa.selenium.Dimension getSize() {
        return null;
    }
    
    @java.lang.Override()
    public java.lang.String getTagName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.lang.String getText() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    @javax.annotation.Nullable()
    @javax.annotation.CheckReturnValue()
    public java.lang.String getValue() {
        return null;
    }
    
    @java.lang.Override()
    public org.openqa.selenium.WebDriver getWrappedDriver() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public org.openqa.selenium.WebElement getWrappedElement() {
        return null;
    }
    
    @java.lang.Override()
    @javax.annotation.CheckReturnValue()
    public boolean has(com.codeborne.selenide.Condition p0) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement hover() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.lang.String innerHtml() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.lang.String innerText() {
        return null;
    }
    
    @java.lang.Override()
    @javax.annotation.CheckReturnValue()
    public boolean is(com.codeborne.selenide.Condition p0) {
        return false;
    }
    
    @java.lang.Override()
    @javax.annotation.CheckReturnValue()
    public boolean isDisplayed() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isImage() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isSelected() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement lastChild() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    @javax.annotation.Nullable()
    @javax.annotation.CheckReturnValue()
    public java.lang.String name() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement parent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement preceding(int p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement pressEnter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement pressEscape() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement pressTab() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.lang.String pseudo(java.lang.String p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.lang.String pseudo(java.lang.String p0, java.lang.String p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    @javax.annotation.Nullable()
    @javax.annotation.CheckReturnValue()
    public java.io.File screenshot() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    @javax.annotation.Nullable()
    @javax.annotation.CheckReturnValue()
    public java.awt.image.BufferedImage screenshotAsImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement scrollIntoView(boolean p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement scrollIntoView(java.lang.String p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement scrollTo() {
        return null;
    }
    
    @java.lang.Override()
    public void selectOption(java.lang.String... p0) {
    }
    
    @java.lang.Override()
    public void selectOption(int... p0) {
    }
    
    @java.lang.Override()
    public void selectOptionByValue(java.lang.String... p0) {
    }
    
    @java.lang.Override()
    public void selectOptionContainingText(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement selectRadio(java.lang.String p0) {
        return null;
    }
    
    @java.lang.Override()
    public void sendKeys(java.lang.CharSequence... p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement setSelected(boolean p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement should(com.codeborne.selenide.Condition... p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement shouldBe(com.codeborne.selenide.Condition... p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement shouldHave(com.codeborne.selenide.Condition... p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement shouldNot(com.codeborne.selenide.Condition... p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement shouldNotBe(com.codeborne.selenide.Condition... p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement shouldNotHave(com.codeborne.selenide.Condition... p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public com.codeborne.selenide.SelenideElement sibling(int p0) {
        return null;
    }
    
    @java.lang.Override()
    public void submit() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public java.lang.String text() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    @javax.annotation.CheckReturnValue()
    public org.openqa.selenium.WebElement toWebElement() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public java.io.File uploadFile(java.io.File... p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public java.io.File uploadFromClasspath(java.lang.String... p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    @javax.annotation.Nullable()
    @javax.annotation.CheckReturnValue()
    public java.lang.String val() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement val(@org.jetbrains.annotations.Nullable()
    @javax.annotation.Nullable()
    java.lang.String p0) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement waitUntil(com.codeborne.selenide.Condition p0, long p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement waitUntil(com.codeborne.selenide.Condition p0, long p1, long p2) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement waitWhile(com.codeborne.selenide.Condition p0, long p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @com.google.errorprone.annotations.CanIgnoreReturnValue()
    @java.lang.Override()
    @javax.annotation.Nonnull()
    public com.codeborne.selenide.SelenideElement waitWhile(com.codeborne.selenide.Condition p0, long p1, long p2) {
        return null;
    }
}