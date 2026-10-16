// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package u2;

import i1.q;
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
import q1.e;
import q1.i;
import v1.d;
import v1.l;
import w1.j4;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f3266a = new c();

    public static List a(X509Certificate x509Certificate, int i3) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                ArrayList arrayList = new ArrayList();
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && list.size() >= 2 && e.a(list.get(0), Integer.valueOf(i3)) && (obj = list.get(1)) != null) {
                        arrayList.add((String) obj);
                    }
                }
                return arrayList;
            }
        } catch (CertificateParsingException unused) {
        }
        return q.f2104c;
    }

    public static boolean b(String str) {
        int i3;
        int length = str.length();
        int length2 = str.length();
        if (length2 < 0) {
            o2.h(j4.c(length2, "endIndex < beginIndex: ", " < 0"));
            return false;
        }
        if (length2 > str.length()) {
            StringBuilder sbI = a0.a.i(length2, "endIndex > string.length: ", " > ");
            sbI.append(str.length());
            throw new IllegalArgumentException(sbI.toString().toString());
        }
        long j3 = 0;
        int i4 = 0;
        while (i4 < length2) {
            char cCharAt = str.charAt(i4);
            if (cCharAt < 128) {
                j3++;
            } else {
                if (cCharAt < 2048) {
                    i3 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i3 = 3;
                } else {
                    int i5 = i4 + 1;
                    char cCharAt2 = i5 < length2 ? str.charAt(i5) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j3++;
                        i4 = i5;
                    } else {
                        j3 += (long) 4;
                        i4 += 2;
                    }
                }
                j3 += (long) i3;
            }
            i4++;
        }
        return length == ((int) j3);
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00f6  */
    public static boolean c(String str, X509Certificate x509Certificate) {
        boolean zEquals;
        int length;
        str.getClass();
        i iVar = j2.b.f2366f;
        iVar.getClass();
        if (((Pattern) iVar.f3129d).matcher(str).matches()) {
            String strC = q2.c.C(str);
            List listA = a(x509Certificate, 7);
            if (!listA.isEmpty()) {
                Iterator it = listA.iterator();
                while (it.hasNext()) {
                    if (e.a(strC, q2.c.C((String) it.next()))) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (b(str)) {
            Locale locale = Locale.US;
            locale.getClass();
            str = str.toLowerCase(locale);
            str.getClass();
        }
        List<String> listA2 = a(x509Certificate, 2);
        if (!listA2.isEmpty()) {
            for (String lowerCase : listA2) {
                if (str.length() == 0 || l.z(str, ".", false) || str.endsWith("..") || lowerCase == null || lowerCase.length() == 0 || l.z(lowerCase, ".", false) || lowerCase.endsWith("..")) {
                    zEquals = false;
                } else {
                    String strConcat = !str.endsWith(".") ? str.concat(".") : str;
                    if (!lowerCase.endsWith(".")) {
                        lowerCase = lowerCase.concat(".");
                    }
                    if (b(lowerCase)) {
                        Locale locale2 = Locale.US;
                        locale2.getClass();
                        lowerCase = lowerCase.toLowerCase(locale2);
                        lowerCase.getClass();
                    }
                    if (!d.B(lowerCase, "*")) {
                        zEquals = strConcat.equals(lowerCase);
                    } else if (!l.z(lowerCase, "*.", false) || d.D(lowerCase, '*', 1, 4) != -1 || strConcat.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                        zEquals = false;
                    } else {
                        String strSubstring = lowerCase.substring(1);
                        if (strConcat.endsWith(strSubstring) && ((length = strConcat.length() - strSubstring.length()) <= 0 || d.G(strConcat, '.', length - 1, 4) == -1)) {
                            zEquals = true;
                        } else {
                            zEquals = false;
                        }
                    }
                }
                if (zEquals) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        str.getClass();
        sSLSession.getClass();
        if (b(str)) {
            try {
                Certificate certificate = sSLSession.getPeerCertificates()[0];
                certificate.getClass();
                return c(str, (X509Certificate) certificate);
            } catch (SSLException unused) {
            }
        }
        return false;
    }
}
