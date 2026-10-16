// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f2854b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile m f2855c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2856a;

    public m(int i3) {
        this.f2856a = i3;
    }

    public static m d() {
        m mVar;
        synchronized (f2854b) {
            try {
                if (f2855c == null) {
                    f2855c = new m(3);
                }
                mVar = f2855c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            sb.append(str.substring(0, 20));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public final void a(String str, String str2) {
        if (this.f2856a <= 3) {
            Log.d(str, str2);
        }
    }

    public final void b(String str, String str2) {
        if (this.f2856a <= 6) {
            Log.e(str, str2);
        }
    }

    public final void c(String str, String str2, Throwable th) {
        if (this.f2856a <= 6) {
            Log.e(str, str2, th);
        }
    }

    public final void e(String str, String str2) {
        if (this.f2856a <= 4) {
            Log.i(str, str2);
        }
    }

    public final void g(String str, String str2) {
        if (this.f2856a <= 5) {
            Log.w(str, str2);
        }
    }
}
