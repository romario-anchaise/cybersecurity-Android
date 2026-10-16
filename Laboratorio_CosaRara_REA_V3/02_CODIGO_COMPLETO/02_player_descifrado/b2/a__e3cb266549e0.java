// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b2;

import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import e2.y1;
import f2.i0;
import java.io.IOException;
import java.util.Locale;
import p1.p;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements p1.a, p, i2.l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f255c;

    public /* synthetic */ a(int i3) {
        this.f255c = i3;
    }

    public static /* synthetic */ void b(Object obj) {
        throw new IllegalStateException(obj.toString());
    }

    public static /* synthetic */ void f(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void g(String str, int i3) {
        throw new IllegalStateException((str + i3).toString());
    }

    public static /* synthetic */ void h(String str, int i3, Object obj, int i4, Object obj2, int i5) {
        throw new IndexOutOfBoundsException(str + i3 + obj + i4 + obj2 + i5);
    }

    public static /* synthetic */ void i(String str, Object obj, Object obj2) {
        throw new IllegalStateException((str + obj + obj2).toString());
    }

    public static /* synthetic */ void j(Object obj, String str) {
        throw new IllegalArgumentException((str + obj + '\"').toString());
    }

    public static /* synthetic */ void k(String str, int i3) throws IOException {
        throw new IOException(str + i3);
    }

    public static /* synthetic */ void l(Object obj, String str) {
        throw new IllegalArgumentException((str + obj).toString());
    }

    public static /* synthetic */ void m(Object obj, String str) {
        throw new SQLiteException(str + obj);
    }

    public boolean a(String str, String str2) {
        switch (this.f255c) {
            case 6:
                return f2.l.F(str);
            case 7:
                return f2.l.j(str, "com.miui.securitycenter", "com.vivo.permissionmanager", "com.coloros.safecenter", "com.oplus.safecenter", "com.huawei.systemmanager", "permission") || f2.l.j(str, "popup", "float", "display", "overlay", "background") || f2.l.j(str2, "com.miui.securitycenter", "com.vivo.permissionmanager", "com.coloros.safecenter", "com.oplus.safecenter", "com.huawei.systemmanager", "permission") || f2.l.j(str2, "popup", "float", "display", "overlay", "background");
            case 8:
                return f2.l.K(str) || f2.l.K(str2);
            case 9:
                return f2.l.F(str) || f2.l.F(str2);
            case 10:
                if (str == null) {
                    str = "";
                }
                if (str2 == null) {
                    str2 = "";
                }
                String[] strArr = i0.f1210i;
                for (int i3 = 0; i3 < 6; i3++) {
                    String str3 = strArr[i3];
                    if (str3.equals(str) || str3.equals(str2)) {
                        return true;
                    }
                }
                String lowerCase = (str + " " + str2).toLowerCase(Locale.ROOT);
                String[] strArr2 = i0.f1211j;
                for (int i4 = 0; i4 < 15; i4++) {
                    if (lowerCase.contains(strArr2[i4])) {
                        return true;
                    }
                }
                return false;
            case 11:
                return f2.l.j(str, "com.miui.securitycenter", "com.vivo.permissionmanager", "com.coloros.safecenter", "com.oplus.safecenter", "com.huawei.systemmanager", "permission") || f2.l.j(str, "com.android.settings", "com.google.android.permissioncontroller", "com.android.permissioncontroller", "com.samsung.android.permissioncontroller") || f2.l.j(str2, "com.miui.securitycenter", "com.vivo.permissionmanager", "com.coloros.safecenter", "com.oplus.safecenter", "com.huawei.systemmanager", "permission") || f2.l.j(str2, "com.android.settings", "com.google.android.permissioncontroller", "com.android.permissioncontroller", "com.samsung.android.permissioncontroller");
            case 12:
                return f2.l.K(str) || f2.l.K(str2);
            default:
                return f2.l.K(str) || f2.l.K(str2);
        }
    }

    @Override // i2.l
    public i2.m c(m2.i iVar) {
        return i2.m.f2184a;
    }

    @Override // p1.a
    public Object d() {
        switch (this.f255c) {
            case 3:
                return Long.valueOf(SystemClock.uptimeMillis());
            default:
                return new y1();
        }
    }

    @Override // p1.p
    public Object e(Object obj, Object obj2) {
        return h1.e.f1953c;
    }

    public long n() {
        switch (this.f255c) {
            case 0:
                Object obj = g.f277o;
                return 0L;
            default:
                return SystemClock.uptimeMillis();
        }
    }
}
