// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Build;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[] f4383a = {0.28f, 0.5f, 0.72f};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f4384b = {0.61f, 0.71f, 0.81f, 0.9f};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f4385c = Pattern.compile("(?i)(?:entered|已输入|已輸入)\\s*(\\d+)\\s*(?:digit|位)?");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f4386d = Pattern.compile("(?i)(?:need to enter|共需|共要|需要输入|需要輸入)\\s*(\\d+)\\s*(?:digit|位)?");

    public static Character a(int i3, int i4) {
        if (i3 < 0 || i4 < 0) {
            return null;
        }
        if (i4 == 3) {
            return i3 == 1 ? '0' : null;
        }
        return Character.valueOf((char) ((i4 * 3) + 49 + i3));
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (str == null || str.isEmpty()) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        return lowerCase.contains("oppo") || lowerCase.contains("oplus") || lowerCase.contains("realme") || lowerCase.contains("oneplus");
    }

    public static boolean c(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        return lowerCase.endsWith(":id/colorsimplelock") || lowerCase.endsWith(":id/color_simple_lock");
    }

    public static boolean d(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (e(str) != null) {
            return true;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        return lowerCase.contains("password input area") || lowerCase.contains("密码输入区域") || lowerCase.contains("密碼輸入區域");
    }

    public static Integer e(String str) {
        int i3;
        if (str != null && !str.isEmpty()) {
            Matcher matcher = f4385c.matcher(str);
            if (matcher.find() && (i3 = Integer.parseInt(matcher.group(1))) >= 0 && i3 <= 16) {
                return Integer.valueOf(i3);
            }
        }
        return null;
    }
}
