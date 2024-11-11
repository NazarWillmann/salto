package ooo.jtc.crypto

import ooo.jtc.extensions.getOrException
import ooo.jtc.extensions.toHexString
import org.apache.commons.codec.binary.Hex.encodeHexString
import java.io.ByteArrayInputStream
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.security.cert.CertificateEncodingException
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate

object CryptoUtils {
    //TODO Sergeyev [2020.08.29]: general improvement
    // + add DER-formatted certificate parser
    // + check DER-formatted certificate operations
    // + better way of reading certificate (from path ?/ from file ?/ from byteArray)

    /**
     * Get X509Certificate from .cer (PEM format) file.
     *
     * @param file .cer (base64) file
     * @return X509Certificate
     */
    fun getCertFromPemFile(file: File): X509Certificate {
        val certInString = getStringFromPemFile(file)
        return getCertFromPem(certInString.toByteArray())
    }

    fun getCertFromPem(pemCert: ByteArray): X509Certificate {
        return try {
            val cf = CertificateFactory.getInstance("X.509")
            val inStream: InputStream = ByteArrayInputStream(pemCert)
            cf.generateCertificate(inStream) as X509Certificate
        } catch (exc: Exception) {
            throw RuntimeException("Can't create certificate from byteArray:\n${String(pemCert)}", exc)
        } catch (err: Error) {
            throw RuntimeException("Can't create certificate from byteArray:\n${String(pemCert)}", err)
        }
    }

    fun getStringFromPemFile(certFile: File): String {
        var certAsString: String = readFile(certFile.path, StandardCharsets.UTF_8)
        if (!certAsString.startsWith("-----BEGIN CERTIFICATE-----"))
            certAsString = "-----BEGIN CERTIFICATE-----\n$certAsString"
        if (!certAsString.contains("-----END CERTIFICATE-----"))
            certAsString = "$certAsString\n-----END CERTIFICATE-----"

        return certAsString
    }

    @Throws(IOException::class)
    fun readFile(path: String, encoding: Charset): String {
        val encoded = Files.readAllBytes(Paths.get(path))
        return String(encoded, encoding)
    }

    //https://stackoverflow.com/questions/1270703/how-to-retrieve-compute-an-x509-certificates-thumbprint-in-java
    @Throws(NoSuchAlgorithmException::class, CertificateEncodingException::class)
    fun getThumbprint(cert: X509Certificate): String {
        val md = MessageDigest.getInstance("SHA-1")
        val der = cert.encoded
        md.update(der)
        val digest = md.digest()
        val digestHex: String = encodeHexString(digest)
        return digestHex.toLowerCase()
    }

    fun getCommonName(cert: X509Certificate): String {
        return cert.subjectDN.name
            .split(",")
            .find { it.trim().startsWith("CN") }.getOrException("Can't find CN field in certificate: $cert")
            .substringAfter("CN=")
    }

    fun getSerialNumber(cert: X509Certificate): String {
        return cert.serialNumber.toHexString()
    }
}