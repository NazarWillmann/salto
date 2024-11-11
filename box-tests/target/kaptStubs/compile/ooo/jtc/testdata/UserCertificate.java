package ooo.jtc.testdata;

import java.lang.System;

/**
 * Link between user and his certificate.
 * All certificates stores in resource/[ooo.jtc.api.platform.crypto.certificate.CertificatePrepareSteps.CERTIFICATE_DIR].
 * @param user - function that returns some [User]. Usually from [Users].
 * @param certFile - function that returns certificate file.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB#\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\u0002\u0010\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000b\u00a8\u0006\r"}, d2 = {"Looo/jtc/testdata/UserCertificate;", "", "user", "Lkotlin/Function0;", "Looo/jtc/uaa/User;", "certFile", "Ljava/io/File;", "(Ljava/lang/String;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getCertFile", "()Lkotlin/jvm/functions/Function0;", "getUser", "AT_OPERATOR_CERT", "Companion", "box-tests"})
public enum UserCertificate {
    /*public static final*/ AT_OPERATOR_CERT /* = new AT_OPERATOR_CERT(null, null) */;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<ooo.jtc.uaa.User> user = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<java.io.File> certFile = null;
    public static final ooo.jtc.testdata.UserCertificate.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<ooo.jtc.uaa.User> getUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<java.io.File> getCertFile() {
        return null;
    }
    
    UserCertificate(kotlin.jvm.functions.Function0<? extends ooo.jtc.uaa.User> user, kotlin.jvm.functions.Function0<? extends java.io.File> certFile) {
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2 = {"Looo/jtc/testdata/UserCertificate$Companion;", "", "()V", "getCertFilesByUser", "", "Ljava/io/File;", "user", "Looo/jtc/uaa/User;", "box-tests"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.io.File> getCertFilesByUser(@org.jetbrains.annotations.NotNull()
        ooo.jtc.uaa.User user) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}