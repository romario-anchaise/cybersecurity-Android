// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f4397b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Runnable f4398c;

    public k6(String str) {
        this.f4396a = str;
    }

    public final void a() {
        this.f4397b.set(false);
        Runnable runnable = this.f4398c;
        if (runnable != null) {
            Handler handler = l6.f4450c;
            if (handler != null) {
                handler.removeCallbacks(runnable);
            }
            Handler handler2 = l6.f4451d;
            if (handler2 != null) {
                handler2.removeCallbacks(runnable);
            }
        }
    }

    public final void b(Throwable th) {
        this.f4397b.set(false);
        synchronized (l6.f4448a) {
            try {
                LinkedHashMap linkedHashMap = l6.f4449b;
                if (linkedHashMap.get(this.f4396a) == this) {
                    linkedHashMap.remove(this.f4396a);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        try {
            Log.e("P90n4iTtpm", "[" + this.f4396a + "] Delayed error: " + th.getMessage(), th);
        } catch (Throwable unused) {
        }
    }
}
