package ooo.jtc.crypto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Looo/jtc/crypto/CertificateState;", "", "()V", "DISABLED", "", "ENABLED", "FORBIDDEN", "TRANSITION", "datamodels"})
public final class CertificateState {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ENABLED = "Enabled";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DISABLED = "Disabled";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FORBIDDEN = "Forbidden";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TRANSITION = "Transition";
    public static final ooo.jtc.crypto.CertificateState INSTANCE = null;
    
    private CertificateState() {
        super();
    }
}