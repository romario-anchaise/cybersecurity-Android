// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.net.IDN;
import java.net.URI;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f3462a = Pattern.compile("(?i)^(?:0x[0-9a-f]+|[0-9]+)(?:\\.(?:0x[0-9a-f]+|[0-9]+)){0,3}$");

    public static String a(String str) {
        p2.a0 a0VarC;
        if (str == null || str.isEmpty() || str.length() > 2048 || !str.equals(str.trim())) {
            return null;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (Character.isWhitespace(cCharAt) || Character.isSpaceChar(cCharAt)) {
                return null;
            }
        }
        try {
            URI uri = new URI(str);
            if (!uri.isOpaque() && "wss".equalsIgnoreCase(uri.getScheme()) && uri.getRawUserInfo() == null && uri.getRawFragment() == null && (a0VarC = c(uri.getRawAuthority())) != null) {
                int i4 = a0VarC.f2874a;
                String str2 = (String) a0VarC.f2875b;
                if (!str2.endsWith(".") && !str2.startsWith(".")) {
                    String lowerCase = IDN.toASCII(str2, 2).toLowerCase(Locale.ROOT);
                    if (!lowerCase.isEmpty() && lowerCase.length() <= 253 && !lowerCase.endsWith(".") && !lowerCase.startsWith(".") && b(lowerCase)) {
                        StringBuilder sb = new StringBuilder("wss://");
                        sb.append(lowerCase);
                        if (i4 >= 0) {
                            sb.append(':');
                            sb.append(i4);
                        }
                        String rawPath = uri.getRawPath();
                        if (rawPath != null) {
                            sb.append(rawPath);
                        }
                        String rawQuery = uri.getRawQuery();
                        if (rawQuery != null) {
                            sb.append('?');
                            sb.append(rawQuery);
                        }
                        String string = sb.toString();
                        if (string.length() > 2048) {
                            return null;
                        }
                        return new URI(string).toASCIIString();
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean b(String str) {
        if (str.indexOf(46) >= 1 && !"localhost".equals(str) && !str.endsWith(".localhost") && !"local".equals(str) && !str.endsWith(".local") && !f3462a.matcher(str).matches()) {
            String[] strArrSplit = str.split("\\.", -1);
            if (strArrSplit.length >= 2) {
                for (String str2 : strArrSplit) {
                    if (!str2.isEmpty() && str2.length() <= 63) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static p2.a0 c(String str) {
        int i3;
        if (str == null || str.isEmpty() || str.indexOf(64) >= 0 || str.indexOf(37) >= 0 || str.indexOf(91) >= 0 || str.indexOf(93) >= 0) {
            return null;
        }
        int iIndexOf = str.indexOf(58);
        int iLastIndexOf = str.lastIndexOf(58);
        if (iIndexOf != iLastIndexOf) {
            return null;
        }
        if (iLastIndexOf >= 0) {
            String strSubstring = str.substring(0, iLastIndexOf);
            String strSubstring2 = str.substring(iLastIndexOf + 1);
            if (strSubstring2.isEmpty()) {
                return null;
            }
            for (int i4 = 0; i4 < strSubstring2.length(); i4++) {
                if (!Character.isDigit(strSubstring2.charAt(i4))) {
                    return null;
                }
            }
            int i5 = Integer.parseInt(strSubstring2);
            if (i5 < 1 || i5 > 65535) {
                return null;
            }
            i3 = i5;
            str = strSubstring;
        } else {
            i3 = -1;
        }
        if (str.isEmpty()) {
            return null;
        }
        return new p2.a0(i3, str);
    }
}
