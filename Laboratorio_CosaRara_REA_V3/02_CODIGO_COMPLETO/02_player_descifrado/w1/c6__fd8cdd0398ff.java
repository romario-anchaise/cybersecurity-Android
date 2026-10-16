// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f3659a = Pattern.compile("(?:^|/)(?:key|digit|num|button|pinentry|passwordentry)([0-9])$|(?:^|/)(?:key_pad_|dial_num_)([0-9])$", 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f3660b = {"enter", "ok", "done", "确定", "完成", "确认"};

    public static void a(z5 z5Var, String str, String str2, String str3, String str4, boolean z2, int i3, Rect rect) {
        Rect rectO = n4.O(rect, z5Var.f5692a, z5Var.f5693b);
        if (rectO == null) {
            return;
        }
        int iY0 = n4.Y0(str);
        if (iY0 > 0) {
            b(z5Var, rectO, iY0 + 400, "viewId");
            return;
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        if (lowerCase.contains("lockpattern") || lowerCase.contains("pattern_view") || lowerCase.contains("keyguard_pattern")) {
            b(z5Var, rectO, 300, "className");
            return;
        }
        if (!str3.isEmpty() && str4.isEmpty() && "android.view.View".equals(str2) && i3 == 0 && !z2 && n8.e(rect.left, rect.top, rect.right, rect.bottom, z5Var.f5692a, z5Var.f5693b)) {
            b(z5Var, rectO, 200, "systemUiSquare");
        } else if (z2 && i3 == 0) {
            b(z5Var, rectO, 100, "clickableSquare");
        }
    }

    public static void b(z5 z5Var, Rect rect, int i3, String str) {
        a6 a6Var = z5Var.f5696e;
        int i4 = a6Var.f3468b;
        long j3 = a6Var.f3469c;
        a6Var.a(i3, rect, true);
        if (a6Var.f3468b == i4 && a6Var.f3469c == j3) {
            return;
        }
        z5Var.f5701j = str;
    }

    public static Integer c(String str, String str2, String str3) {
        Matcher matcher = f3659a.matcher(str);
        if (matcher.find()) {
            return Integer.valueOf((matcher.group(1) != null ? matcher.group(1) : matcher.group(2)).charAt(0) - '0');
        }
        if (str2.length() != 1) {
            str2 = str3;
        }
        if (str2.length() != 1 || str2.charAt(0) < '0' || str2.charAt(0) > '9') {
            return null;
        }
        return Integer.valueOf(str2.charAt(0) - '0');
    }

    public static long d(int i3, long j3) {
        return (j3 ^ ((long) i3)) * 1099511628211L;
    }

    public static long e(String str, long j3) {
        if (str == null) {
            return d(0, j3);
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            j3 = (j3 ^ ((long) str.charAt(i3))) * 1099511628211L;
        }
        return j3;
    }

    public static boolean f(String str, String str2, String str3) {
        String lowerCase = str.toLowerCase(Locale.US);
        for (String str4 : f3660b) {
            if (lowerCase.endsWith("/" + str4)) {
                return true;
            }
            if (lowerCase.endsWith("/key_" + str4)) {
                return true;
            }
            if (lowerCase.endsWith("/btn_" + str4)) {
                return true;
            }
            Locale locale = Locale.US;
            if (str4.equals(str2.toLowerCase(locale)) || str4.equals(str3.toLowerCase(locale))) {
                return true;
            }
        }
        return lowerCase.endsWith("/keyguard_enter_button") || lowerCase.endsWith("/passwordentry_enter");
    }

    public static boolean g(String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        return lowerCase.contains("systemui") || lowerCase.contains("keyguard") || lowerCase.contains("oplus") || lowerCase.contains("coloros") || lowerCase.contains("lockscreen") || lowerCase.contains("huawei.systemmanager");
    }

    public static void h(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        try {
            accessibilityNodeInfo.recycle();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d8  */
    public static void i(AccessibilityNodeInfo accessibilityNodeInfo, String str, int i3, z5 z5Var, n0 n0Var) {
        boolean zIsClickable;
        int iMax;
        int i4;
        AccessibilityNodeInfo child;
        boolean zIsPassword;
        boolean zIsEditable;
        boolean zIsFocusable;
        boolean z2;
        if (accessibilityNodeInfo != null && n0Var.c(i3) && z5Var.f5697f.add(accessibilityNodeInfo)) {
            String strJ = j(accessibilityNodeInfo.getPackageName());
            String str2 = strJ.isEmpty() ? str : strJ;
            try {
                String strJ2 = j(accessibilityNodeInfo.getViewIdResourceName());
                String strJ3 = j(accessibilityNodeInfo.getClassName());
                String strTrim = j(accessibilityNodeInfo.getContentDescription()).trim();
                String strTrim2 = j(accessibilityNodeInfo.getText()).trim();
                Rect rect = new Rect();
                try {
                    accessibilityNodeInfo.getBoundsInScreen(rect);
                } catch (Throwable unused) {
                }
                try {
                    zIsClickable = accessibilityNodeInfo.isClickable();
                } catch (Throwable unused2) {
                    zIsClickable = false;
                }
                try {
                    iMax = Math.max(0, accessibilityNodeInfo.getChildCount());
                } catch (Throwable unused3) {
                    iMax = 0;
                }
                long jE = e(str2, z5Var.f5702k);
                z5Var.f5702k = jE;
                long jE2 = e(strJ2, jE);
                z5Var.f5702k = jE2;
                long jE3 = e(strJ3, jE2);
                z5Var.f5702k = jE3;
                long jD = d(iMax, jE3);
                z5Var.f5702k = jD;
                long jD2 = d(rect.left / 4, jD);
                z5Var.f5702k = jD2;
                long jD3 = d(rect.top / 4, jD2);
                z5Var.f5702k = jD3;
                long jD4 = d(rect.right / 4, jD3);
                z5Var.f5702k = jD4;
                z5Var.f5702k = d(rect.bottom / 4, jD4);
                if (g(str2)) {
                    boolean zC = k2.c(strJ2);
                    if (!zC) {
                        try {
                            zIsPassword = accessibilityNodeInfo.isPassword();
                        } catch (Throwable unused4) {
                            zIsPassword = false;
                        }
                        if (!zIsPassword) {
                            try {
                                zIsEditable = accessibilityNodeInfo.isEditable();
                            } catch (Throwable unused5) {
                                zIsEditable = false;
                            }
                            if (zIsEditable) {
                                try {
                                    zIsFocusable = accessibilityNodeInfo.isFocusable();
                                } catch (Throwable unused6) {
                                    zIsFocusable = false;
                                }
                                z2 = zIsFocusable;
                            }
                        }
                    }
                    z5Var.f5699h = zC | z5Var.f5699h;
                    z5Var.f5698g |= z2;
                    boolean z3 = z5Var.f5700i;
                    String lowerCase = strJ2.toLowerCase(Locale.US);
                    z5Var.f5700i = z3 | (lowerCase.endsWith("/keyguard_bouncer_container") || lowerCase.endsWith("/keyguard_sec_pin_view") || lowerCase.endsWith("/keyguard_pin_view") || lowerCase.endsWith("/colorsimplelock"));
                    Integer numC = c(strJ2, strTrim, strTrim2);
                    if (numC != null && k(rect)) {
                        ((a6) z5Var.f5694c.computeIfAbsent(numC, new d2.i(7))).a(zIsClickable ? 2 : 1, rect, false);
                    }
                    if (f(strJ2, strTrim, strTrim2)) {
                        i4 = 0;
                        z5Var.f5695d.a(zIsClickable ? 2 : 1, rect, false);
                    } else {
                        i4 = 0;
                    }
                    a(z5Var, strJ2, strJ3, strTrim, strTrim2, zIsClickable, iMax, rect);
                } else {
                    i4 = 0;
                }
                for (int i5 = i4; i5 < iMax && n0Var.a(); i5++) {
                    try {
                        child = accessibilityNodeInfo.getChild(i5);
                        try {
                            i(child, str2, i3 + 1, z5Var, n0Var);
                        } catch (Throwable unused7) {
                        }
                    } catch (Throwable unused8) {
                        child = null;
                    }
                    h(child);
                }
            } catch (Throwable unused9) {
            }
        }
    }

    public static String j(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString();
    }

    public static boolean k(Rect rect) {
        return rect.width() > 0 && rect.height() > 0;
    }
}
