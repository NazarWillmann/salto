package ooo.jtc.api.platform.crypto.certificate;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u001c\u0010\u000f\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Looo/jtc/api/platform/crypto/certificate/CertificatePrepareSteps;", "", "()V", "CERTIFICATE_DIR", "", "certFileByName", "Lkotlin/Function1;", "Ljava/io/File;", "getCertFileByName", "()Lkotlin/jvm/functions/Function1;", "getCertificateByThumbprint", "Looo/jtc/crypto/CertificateDto;", "user", "Looo/jtc/uaa/User;", "thumbprint", "getCertificateDtoByFilePath", "cryptoProfileId", "Ljava/util/UUID;", "x509CertFile", "box-tests"})
public final class CertificatePrepareSteps {
    private static final java.lang.String CERTIFICATE_DIR = "/crypto";
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<java.lang.String, java.io.File> certFileByName = null;
    public static final ooo.jtc.api.platform.crypto.certificate.CertificatePrepareSteps INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, java.io.File> getCertFileByName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0421\u0435\u0440\u0442\u0438\u0444\u0438\u043a\u0430\u0442 DTO \u043d\u0430 \u043e\u0441\u043d\u043e\u0432\u0435 \u0441\u0435\u0440\u0442\u0438\u0444\u0438\u043a\u0430\u0442\u0430 {x509CertFile}")
    public final ooo.jtc.crypto.CertificateDto getCertificateDtoByFilePath(@org.jetbrains.annotations.Nullable()
    java.util.UUID cryptoProfileId, @org.jetbrains.annotations.NotNull()
    java.io.File x509CertFile) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0439 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e \'{user.login}\' \u0441\u0435\u0440\u0442\u0438\u0444\u0438\u043a\u0430\u0442 \u043f\u043e \u043e\u0442\u043f\u0435\u0447\u0430\u0442\u043a\u0443 [{thumbprint}]")
    public final ooo.jtc.crypto.CertificateDto getCertificateByThumbprint(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    java.lang.String thumbprint) {
        return null;
    }
    
    private CertificatePrepareSteps() {
        super();
    }
}