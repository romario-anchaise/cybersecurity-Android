// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j1;

import F0.i;
import M0.e;
import M0.m;
import f1.l;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import p036u0.n;

/* JADX INFO: loaded from: classes.dex */
public final class c implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f3401a = new c();

    public static List a(X509Certificate x509Certificate, int i2) {
        Object obj;
        n nVar = n.f4146a;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return nVar;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && i.a(list.get(0), Integer.valueOf(i2)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return nVar;
        }
    }

    public static boolean b(String str) {
        int i2;
        int length = str.length();
        int length2 = str.length();
        if (length2 < 0) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + length2 + " < 0").toString());
        }
        if (length2 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + length2 + " > " + str.length()).toString());
        }
        long j2 = 0;
        int i3 = 0;
        while (i3 < length2) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < 128) {
                j2++;
            } else {
                if (cCharAt < 2048) {
                    i2 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i2 = 3;
                } else {
                    int i4 = i3 + 1;
                    char cCharAt2 = i4 < length2 ? str.charAt(i4) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j2++;
                        i3 = i4;
                    } else {
                        j2 += (long) 4;
                        i3 += 2;
                    }
                }
                j2 += (long) i2;
            }
            i3++;
        }
        return length == ((int) j2);
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00fe  */
    public static boolean c(String str, X509Certificate x509Certificate) {
        boolean zA;
        int length;
        i.e(str, "host");
        byte[] bArr = Y0.b.f1119a;
        M0.d dVar = Y0.b.f1124f;
        dVar.getClass();
        if (((Pattern) dVar.f374b).matcher(str).matches()) {
            String strZ = l.Z(str);
            List listA = a(x509Certificate, 7);
            if (!listA.isEmpty()) {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    if (i.a(strZ, l.Z((String) it.next()))) {
                        return true;
                    }
                }
            }
        } else {
            if (b(str)) {
                Locale locale = Locale.US;
                i.d(locale, "US");
                str = str.toLowerCase(locale);
                i.d(str, "this as java.lang.String).toLowerCase(locale)");
            }
            List<String> listA2 = a(x509Certificate, 2);
            if (!listA2.isEmpty()) {
                for (String lowerCase : listA2) {
                    if (str.length() == 0 || m.R(str, ".", false) || m.L(str, "..", false) || lowerCase == null || lowerCase.length() == 0 || m.R(lowerCase, ".", false) || m.L(lowerCase, "..", false)) {
                        zA = false;
                    } else {
                        String strConcat = !m.L(str, ".", false) ? str.concat(".") : str;
                        if (!m.L(lowerCase, ".", false)) {
                            lowerCase = lowerCase.concat(".");
                        }
                        if (b(lowerCase)) {
                            Locale locale2 = Locale.US;
                            i.d(locale2, "US");
                            lowerCase = lowerCase.toLowerCase(locale2);
                            i.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                        }
                        if (!e.T(lowerCase, "*")) {
                            zA = i.a(strConcat, lowerCase);
                        } else if (!m.R(lowerCase, "*.", false) || e.X(lowerCase, '*', 1, false, 4) != -1 || strConcat.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                            zA = false;
                        } else {
                            String strSubstring = lowerCase.substring(1);
                            i.d(strSubstring, "this as java.lang.String).substring(startIndex)");
                            if (m.L(strConcat, strSubstring, false) && ((length = strConcat.length() - strSubstring.length()) <= 0 || e.a0(strConcat, '.', length - 1, 4) == -1)) {
                                zA = true;
                            } else {
                                zA = false;
                            }
                        }
                    }
                    if (zA) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        i.e(str, "host");
        i.e(sSLSession, "session");
        if (!b(str)) {
            return false;
        }
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            i.c(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return c(str, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }
}
