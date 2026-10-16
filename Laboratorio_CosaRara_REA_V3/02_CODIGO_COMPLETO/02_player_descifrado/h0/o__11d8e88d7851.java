// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.os.Handler;
import android.os.Looper;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f1918a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f1920c;

    public static void a(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + String.valueOf(name2).length() + 35 + 1);
            sb.append("Must be called on ");
            sb.append(name2);
            sb.append(" thread, but got ");
            sb.append(name);
            sb.append(".");
            throw new IllegalStateException(sb.toString());
        }
    }

    public static void b(String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return;
        }
        o2.k(str);
    }

    public static void c(Object obj) {
        if (obj == null) {
            throw new NullPointerException("null reference");
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static boolean e(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
