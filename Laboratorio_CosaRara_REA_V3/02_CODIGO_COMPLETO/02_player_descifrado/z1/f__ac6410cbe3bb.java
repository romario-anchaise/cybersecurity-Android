// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import w1.vf;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f6313a = Collections.unmodifiableSet(new HashSet(Arrays.asList("com.android.settings", "com.samsung.android.settings", "com.miui.securitycenter", "com.miui.permcenter", "com.coloros.safecenter", "com.coloros.appmanager", "com.coloros.oppoguardelf", "com.oplus.safecenter", "com.oplus.app", "com.oppo.safe", "com.huawei.systemmanager", "com.huawei.permissionmanager", "com.vivo.permissionmanager", "com.vivo.permission.manager", "com.vivo.abe", "com.samsung.android.sm", "com.samsung.android.lool", "com.lge.settings")));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f6314b = Collections.unmodifiableSet(new HashSet(Arrays.asList("com.android.packageinstaller", "com.google.android.packageinstaller", "com.samsung.android.packageinstaller", "com.android.permissioncontroller", "com.google.android.permissioncontroller", "com.miui.packageinstaller", "com.huawei.packageinstaller")));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f6315c = Collections.unmodifiableSet(new HashSet(Arrays.asList("com.android.vending", "com.sec.android.app.samsungapps", "com.huawei.appmarket")));

    public static int a(String str) {
        if ("com.android.systemui".equals(str)) {
            return 4;
        }
        if (f6313a.contains(str)) {
            return 1;
        }
        if (f6314b.contains(str)) {
            return 2;
        }
        return f6315c.contains(str) ? 3 : 5;
    }

    public static boolean b(g gVar) {
        if (gVar == null || !gVar.f6324i || !gVar.f6325j || !gVar.f6326k) {
            return false;
        }
        if (gVar.f6323h == 4) {
            return true;
        }
        String strD = d(gVar.f6317b);
        return strD.endsWith("button") || strD.contains(".button");
    }

    public static boolean c(CharSequence charSequence) {
        return a(d(charSequence == null ? "" : charSequence.toString())) != 5;
    }

    public static String d(String str) {
        return str == null ? "" : str.trim().toLowerCase(Locale.ROOT);
    }

    public static vf e(j jVar) {
        jVar.b();
        return new vf(11, 4, 4, 4, 1, (d) null);
    }

    public static int f(int i3, int i4) {
        if (i3 == 0) {
            i3 = 1;
        }
        if (i4 == 0) {
            i4 = 1;
        }
        return g.d.a(i4) > g.d.a(i3) ? i4 : i3;
    }

    public static int g(int i3, int i4) {
        char c3;
        if (i3 != 0 && i3 != 8) {
            if (i4 != 0 && i4 != 8) {
                char c4 = 7;
                switch (g.d.a(i4)) {
                    case 0:
                        c3 = 7;
                        break;
                    case 1:
                        c3 = 5;
                        break;
                    case 2:
                        c3 = 4;
                        break;
                    case 3:
                        c3 = 3;
                        break;
                    case 4:
                        c3 = 2;
                        break;
                    case 5:
                        c3 = 6;
                        break;
                    case 6:
                        c3 = 1;
                        break;
                    default:
                        c3 = 0;
                        break;
                }
                switch (g.d.a(i3)) {
                    case 0:
                        break;
                    case 1:
                        c4 = 5;
                        break;
                    case 2:
                        c4 = 4;
                        break;
                    case 3:
                        c4 = 3;
                        break;
                    case 4:
                        c4 = 2;
                        break;
                    case 5:
                        c4 = 6;
                        break;
                    case 6:
                        c4 = 1;
                        break;
                    default:
                        c4 = 0;
                        break;
                }
                if (c3 > c4) {
                }
            }
            return i3;
        }
        if (i4 == 0) {
            return 8;
        }
        return i4;
    }
}
