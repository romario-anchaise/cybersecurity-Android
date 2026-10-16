// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d0;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import e2.h;
import e2.n1;
import i2.o;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import w1.c1;
import w2.j;
import x1.k;
import x1.l;
import x1.m;
import x1.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f532b;

    public d() {
        this.f532b = new q.c(new Handler(Looper.getMainLooper()));
        this.f531a = 1000L;
    }

    public boolean a(AccessibilityService accessibilityService, GestureDescription gestureDescription, AccessibilityService.GestureResultCallback gestureResultCallback) {
        return (accessibilityService == null || gestureDescription == null || !h(new h(accessibilityService, gestureDescription, gestureResultCallback))) ? false : true;
    }

    public void b(Exception exc) {
        e0.b bVar;
        e eVar = (e) this.f532b;
        long j3 = this.f531a;
        eVar.getClass();
        Log.i("AdvertisingIdClient", "getting error as ".concat(String.valueOf(exc.getMessage())));
        if ((exc instanceof f0.a) && (bVar = ((f0.a) exc).f1105c.f475f) != null && bVar.f659d == 24) {
            eVar.f536b.set(j3);
        }
    }

    public void c(AccessibilityService accessibilityService) {
        d(accessibilityService, 1, new k());
    }

    public boolean d(AccessibilityService accessibilityService, int i3, BooleanSupplier booleanSupplier) {
        return accessibilityService != null && h(new l(booleanSupplier, accessibilityService, i3, 1));
    }

    public boolean e(int i3, AccessibilityNodeInfo accessibilityNodeInfo) {
        return f(accessibilityNodeInfo, i3, new k());
    }

    public boolean f(AccessibilityNodeInfo accessibilityNodeInfo, int i3, BooleanSupplier booleanSupplier) {
        return accessibilityNodeInfo != null && h(new l(booleanSupplier, accessibilityNodeInfo, i3, 0));
    }

    public o g() {
        n1 n1Var = new n1(9);
        while (true) {
            String strG = ((j) this.f532b).g(this.f531a);
            this.f531a -= (long) strG.length();
            if (strG.length() == 0) {
                return n1Var.g();
            }
            int iD = v1.d.D(strG, ':', 1, 4);
            if (iD != -1) {
                n1Var.d(strG.substring(0, iD), strG.substring(iD + 1));
            } else if (strG.charAt(0) == ':') {
                n1Var.d("", strG.substring(1));
            } else {
                n1Var.d("", strG);
            }
        }
    }

    public boolean h(m mVar) {
        q.c cVar = (q.c) this.f532b;
        cVar.getClass();
        Looper looperMyLooper = Looper.myLooper();
        Handler handler = cVar.f3005a;
        if (looperMyLooper == handler.getLooper()) {
            return mVar.mo0run();
        }
        n nVar = new n(mVar, TimeUnit.MILLISECONDS.toNanos(this.f531a) + System.nanoTime());
        boolean zPost = handler.post(nVar);
        AtomicInteger atomicInteger = nVar.f5904e;
        if (!zPost) {
            atomicInteger.compareAndSet(0, 3);
            return false;
        }
        try {
            long jNanoTime = nVar.f5905f - System.nanoTime();
            if (jNanoTime > 0 && nVar.f5903d.await(jNanoTime, TimeUnit.NANOSECONDS)) {
                return nVar.b();
            }
            if (atomicInteger.compareAndSet(0, 3)) {
                handler.removeCallbacks(nVar);
                return false;
            }
            nVar.a(false);
            return nVar.b();
        } catch (InterruptedException unused) {
            if (!atomicInteger.compareAndSet(0, 3)) {
                nVar.a(true);
                return nVar.b();
            }
            handler.removeCallbacks(nVar);
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public /* synthetic */ d(Object obj, long j3) {
        this.f532b = obj;
        this.f531a = j3;
    }

    public d(long j3, Consumer consumer) {
        this.f531a = j3;
        this.f532b = consumer;
    }

    public d(long j3, c1 c1Var) {
        this.f531a = j3 <= 0 ? 1L : j3;
        this.f532b = c1Var;
    }
}
