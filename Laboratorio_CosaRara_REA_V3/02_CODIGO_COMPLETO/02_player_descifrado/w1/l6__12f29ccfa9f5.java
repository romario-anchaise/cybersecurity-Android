// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f4448a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f4449b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Handler f4450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Handler f4451d;

    public static void a(String str) {
        synchronized (f4448a) {
            try {
                LinkedHashMap linkedHashMap = f4449b;
                k6 k6Var = (k6) linkedHashMap.get(str);
                if (k6Var == null) {
                    return;
                }
                if (k6Var.f4397b.get()) {
                    k6Var.a();
                    Log.d("P90n4iTtpm", "[" + str + "] Cancelled manually");
                }
                linkedHashMap.remove(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Handler b(int i3) {
        Handler handler;
        Handler handler2;
        if (i3 != 1) {
            Handler handler3 = f4451d;
            if (handler3 != null) {
                return handler3;
            }
            synchronized (f4448a) {
                try {
                    if (f4451d == null) {
                        HandlerThread handlerThread = new HandlerThread("NamedJobRegistry");
                        handlerThread.start();
                        f4451d = new Handler(handlerThread.getLooper());
                    }
                    handler = f4451d;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return handler;
        }
        Handler handler4 = f4450c;
        if (handler4 != null) {
            return handler4;
        }
        synchronized (f4448a) {
            try {
                if (f4450c == null) {
                    Looper mainLooper = Looper.getMainLooper();
                    if (mainLooper == null) {
                        HandlerThread handlerThread2 = new HandlerThread("NamedJobRegistry-MainFallback");
                        handlerThread2.start();
                        f4450c = new Handler(handlerThread2.getLooper());
                    } else {
                        f4450c = new Handler(mainLooper);
                    }
                }
                handler2 = f4450c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handler2;
    }

    public static boolean c(String str) {
        boolean z2;
        synchronized (f4448a) {
            try {
                k6 k6Var = (k6) f4449b.get(str);
                z2 = k6Var != null && k6Var.f4397b.get();
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public static void d(String str, int i3, Runnable runnable) {
        synchronized (f4448a) {
            try {
                LinkedHashMap linkedHashMap = f4449b;
                k6 k6Var = (k6) linkedHashMap.get(str);
                if (k6Var != null && k6Var.f4397b.get()) {
                    k6Var.a();
                }
                k6 k6Var2 = new k6(str);
                linkedHashMap.put(str, k6Var2);
                Handler handlerB = b(i3);
                k6Var2.f4398c = new e2.q0(k6Var2, runnable, str, 8);
                handlerB.post(k6Var2.f4398c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void e(String str, int i3, d2.o oVar) {
        synchronized (f4448a) {
            try {
                LinkedHashMap linkedHashMap = f4449b;
                k6 k6Var = (k6) linkedHashMap.get(str);
                if (k6Var != null && k6Var.f4397b.get()) {
                    k6Var.a();
                }
                k6 k6Var2 = new k6(str);
                linkedHashMap.put(str, k6Var2);
                Handler handlerB = b(i3);
                k6Var2.f4398c = new q.r(k6Var2, oVar, handlerB, str, 3);
                handlerB.post(k6Var2.f4398c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
