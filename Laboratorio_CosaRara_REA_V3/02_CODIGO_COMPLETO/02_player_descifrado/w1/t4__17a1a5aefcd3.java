// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f5149a = Pattern.compile("(?i)(?:dot|cell|celda|punkt|punto|点|圆点|格子)\\s*([1-9])\\b");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f5150b = Pattern.compile("(\\d+)");

    public static s4 a(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return new s4(1, (char) 0, 0);
        }
        if (strTrim.length() == 1 && strTrim.charAt(0) >= '0' && strTrim.charAt(0) <= '9') {
            return new s4(2, strTrim.charAt(0), 0);
        }
        if (strTrim.length() == 1 && y8.q(strTrim.charAt(0))) {
            return new s4(3, strTrim.charAt(0), 0);
        }
        Integer numF = f(strTrim);
        return numF != null ? new s4(4, (char) 0, numF.intValue()) : new s4(1, (char) 0, 0);
    }

    public static String b(s4 s4Var, String str) {
        char c3 = s4Var.f5050b;
        int iA = g.d.a(s4Var.f5049a);
        if (iA == 1) {
            return "d:" + c3;
        }
        if (iA == 2) {
            return "c:" + c3;
        }
        if (iA != 3) {
            return str.isEmpty() ? "" : "n:".concat(str);
        }
        return "p:" + s4Var.f5051c;
    }

    public static boolean c(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        return lowerCase.contains("systemui") || lowerCase.contains("keyguard") || lowerCase.contains("oplus") || lowerCase.contains("lockscreen") || lowerCase.contains("settings") || lowerCase.contains("biometric");
    }

    public static boolean d(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("systemui") || lowerCase.contains("keyguard") || lowerCase.contains("oplus");
    }

    public static Integer e(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        return strTrim.matches("[1-9]") ? Integer.valueOf(Integer.parseInt(strTrim)) : g(strTrim);
    }

    public static Integer f(String str) {
        int i3;
        if (k2.e(str) != null) {
            return null;
        }
        Integer numE = e(str);
        if (numE != null) {
            return numE;
        }
        if (str == null) {
            return null;
        }
        Matcher matcher = f5150b.matcher(str.trim());
        if (!matcher.find() || (i3 = Integer.parseInt(matcher.group(1))) < 1 || i3 > 9) {
            return null;
        }
        return Integer.valueOf(i3);
    }

    public static Integer g(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f5149a.matcher(str.trim());
        if (matcher.find()) {
            return Integer.valueOf(Integer.parseInt(matcher.group(1)));
        }
        return null;
    }
}
