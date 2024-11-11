package ooo.jtc.crypto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014\u00a8\u0006\u0015"}, d2 = {"Looo/jtc/crypto/CryptoUtils;", "", "()V", "getCertFromPem", "Ljava/security/cert/X509Certificate;", "pemCert", "", "getCertFromPemFile", "file", "Ljava/io/File;", "getCommonName", "", "cert", "getSerialNumber", "getStringFromPemFile", "certFile", "getThumbprint", "readFile", "path", "encoding", "Ljava/nio/charset/Charset;", "qa-utils"})
public final class CryptoUtils {
    public static final ooo.jtc.crypto.CryptoUtils INSTANCE = null;
    
    /**
     * Get X509Certificate from .cer (PEM format) file.
     *
     * @param file .cer (base64) file
     * @return X509Certificate
     */
    @org.jetbrains.annotations.NotNull()
    public final java.security.cert.X509Certificate getCertFromPemFile(@org.jetbrains.annotations.NotNull()
    java.io.File file) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.security.cert.X509Certificate getCertFromPem(@org.jetbrains.annotations.NotNull()
    byte[] pemCert) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStringFromPemFile(@org.jetbrains.annotations.NotNull()
    java.io.File certFile) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String readFile(@org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.nio.charset.Charset encoding) throws java.io.IOException {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThumbprint(@org.jetbrains.annotations.NotNull()
    java.security.cert.X509Certificate cert) throws java.security.NoSuchAlgorithmException, java.security.cert.CertificateEncodingException {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCommonName(@org.jetbrains.annotations.NotNull()
    java.security.cert.X509Certificate cert) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSerialNumber(@org.jetbrains.annotations.NotNull()
    java.security.cert.X509Certificate cert) {
        return null;
    }
    
    private CryptoUtils() {
        super();
    }
}