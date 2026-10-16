// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static void a(String str) {
        if (str.length() <= 0) {
            o2.i("name is empty");
            return;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if ('!' > cCharAt || cCharAt >= 127) {
                o2.h(j2.b.i("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i3), str));
                return;
            }
        }
    }

    public static void b(String str, String str2) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                o2.h(j2.b.i("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i3), str2).concat(j2.b.q(str2) ? "" : ": ".concat(str)));
                return;
            }
        }
    }

    public static int c(String str, int i3, int i4, boolean z2) {
        while (i3 < i4) {
            char cCharAt = str.charAt(i3);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z2)) {
                return i3;
            }
            i3++;
        }
        return i4;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static c0 d(String str) {
        str.getClass();
        int iHashCode = str.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            return c0.f2125f;
                        }
                        break;
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            return c0.f2124e;
                        }
                        break;
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            return c0.f2123d;
                        }
                        break;
                }
            } else if (str.equals("TLSv1")) {
                return c0.f2126g;
            }
        } else if (str.equals("SSLv3")) {
            return c0.f2127h;
        }
        o2.i("Unexpected TLS version: ".concat(str));
        return null;
    }

    public static n e(SSLSession sSLSession) throws IOException {
        List listL;
        List listL2 = i1.q.f2104c;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            o2.k("cipherSuite == null");
            return null;
        }
        if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") ? true : cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            o2.l("cipherSuite == ".concat(cipherSuite));
            return null;
        }
        h hVarC = h.f2146b.c(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            o2.k("tlsVersion == null");
            return null;
        }
        if ("NONE".equals(protocol)) {
            o2.l("tlsVersion == NONE");
            return null;
        }
        c0 c0VarD = d(protocol);
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            listL = peerCertificates != null ? j2.b.l(Arrays.copyOf(peerCertificates, peerCertificates.length)) : listL2;
        } catch (SSLPeerUnverifiedException unused) {
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listL2 = j2.b.l(Arrays.copyOf(localCertificates, localCertificates.length));
        }
        return new n(c0VarD, hVarC, listL2, new k.b(2, listL));
    }

    public static s f(String str) {
        str.getClass();
        Matcher matcher = s.f2209c.matcher(str);
        if (!matcher.lookingAt()) {
            b2.a.j(str, "No subtype found for: \"");
            return null;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        Locale locale = Locale.US;
        locale.getClass();
        strGroup.toLowerCase(locale).getClass();
        String strGroup2 = matcher.group(2);
        strGroup2.getClass();
        strGroup2.toLowerCase(locale).getClass();
        ArrayList arrayList = new ArrayList();
        Matcher matcher2 = s.f2210d.matcher(str);
        int iEnd = matcher.end();
        while (iEnd < str.length()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException(("Parameter is not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + '\"').toString());
            }
            String strGroup3 = matcher2.group(1);
            if (strGroup3 == null) {
                iEnd = matcher2.end();
            } else {
                String strGroup4 = matcher2.group(2);
                if (strGroup4 == null) {
                    strGroup4 = matcher2.group(3);
                } else if (v1.l.z(strGroup4, "'", false) && strGroup4.endsWith("'") && strGroup4.length() > 2) {
                    strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                }
                arrayList.add(strGroup3);
                arrayList.add(strGroup4);
                iEnd = matcher2.end();
            }
        }
        return new s(str, (String[]) arrayList.toArray(new String[0]));
    }

    public static v g(String str) throws IOException {
        if (str.equals("http/1.0")) {
            return v.f2261d;
        }
        if (str.equals("http/1.1")) {
            return v.f2262e;
        }
        if (str.equals("h2_prior_knowledge")) {
            return v.f2265h;
        }
        if (str.equals("h2")) {
            return v.f2264g;
        }
        if (str.equals("spdy/3.1")) {
            return v.f2263f;
        }
        if (str.equals("quic")) {
            return v.f2266i;
        }
        o2.l("Unexpected protocol: ".concat(str));
        return null;
    }

    public static o h(String... strArr) {
        if (strArr.length % 2 != 0) {
            o2.i("Expected alternating header names and values");
            return null;
        }
        String[] strArr2 = (String[]) strArr.clone();
        int length = strArr2.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            String str = strArr2[i4];
            if (str == null) {
                o2.i("Headers cannot be null");
                return null;
            }
            strArr2[i4] = v1.d.J(str).toString();
        }
        int i5 = m0.a.i(0, strArr2.length - 1, 2);
        if (i5 >= 0) {
            while (true) {
                String str2 = strArr2[i3];
                String str3 = strArr2[i3 + 1];
                a(str2);
                b(str3, str2);
                if (i3 == i5) {
                    break;
                }
                i3 += 2;
            }
        }
        return new o(strArr2);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0099  */
    public static long o(String str, int i3) {
        int iC = c(str, 0, i3, false);
        Matcher matcher = j.f2174m.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int iC2 = -1;
        int i7 = -1;
        int i8 = -1;
        while (iC < i3) {
            int iC3 = c(str, iC + 1, i3, true);
            matcher.region(iC, iC3);
            if (i5 == -1 && matcher.usePattern(j.f2174m).matches()) {
                String strGroup = matcher.group(1);
                strGroup.getClass();
                i5 = Integer.parseInt(strGroup);
                String strGroup2 = matcher.group(2);
                strGroup2.getClass();
                i7 = Integer.parseInt(strGroup2);
                String strGroup3 = matcher.group(3);
                strGroup3.getClass();
                i8 = Integer.parseInt(strGroup3);
            } else if (i6 == -1 && matcher.usePattern(j.f2173l).matches()) {
                String strGroup4 = matcher.group(1);
                strGroup4.getClass();
                i6 = Integer.parseInt(strGroup4);
            } else if (iC2 == -1) {
                Pattern pattern = j.f2172k;
                if (matcher.usePattern(pattern).matches()) {
                    String strGroup5 = matcher.group(1);
                    strGroup5.getClass();
                    Locale locale = Locale.US;
                    locale.getClass();
                    String lowerCase = strGroup5.toLowerCase(locale);
                    lowerCase.getClass();
                    String strPattern = pattern.pattern();
                    strPattern.getClass();
                    iC2 = v1.d.C(strPattern, lowerCase, 0, false) / 4;
                } else if (i4 != -1 && matcher.usePattern(j.f2171j).matches()) {
                    String strGroup6 = matcher.group(1);
                    strGroup6.getClass();
                    i4 = Integer.parseInt(strGroup6);
                }
            } else if (i4 != -1) {
            }
            iC = c(str, iC3 + 1, i3, false);
        }
        if (70 <= i4 && i4 < 100) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 < 70) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            o2.i("Failed requirement.");
            return 0L;
        }
        if (iC2 == -1) {
            o2.i("Failed requirement.");
            return 0L;
        }
        if (1 > i6 || i6 >= 32) {
            o2.i("Failed requirement.");
            return 0L;
        }
        if (i5 < 0 || i5 >= 24) {
            o2.i("Failed requirement.");
            return 0L;
        }
        if (i7 < 0 || i7 >= 60) {
            o2.i("Failed requirement.");
            return 0L;
        }
        if (i8 < 0 || i8 >= 60) {
            o2.i("Failed requirement.");
            return 0L;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(j2.b.f2365e);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i4);
        gregorianCalendar.set(2, iC2 - 1);
        gregorianCalendar.set(5, i6);
        gregorianCalendar.set(11, i5);
        gregorianCalendar.set(12, i7);
        gregorianCalendar.set(13, i8);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    public abstract void i(v2.g gVar, int i3, String str);

    public void j(v2.g gVar, int i3, String str) {
        gVar.getClass();
    }

    public abstract void k(v2.g gVar, Exception exc, y yVar);

    public abstract void l(String str, v2.g gVar);

    public abstract void m(v2.g gVar, w2.k kVar);

    public abstract void n(v2.g gVar, y yVar);
}
