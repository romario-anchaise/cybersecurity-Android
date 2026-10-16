// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class fc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f4034a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f4035b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f4036c = new AtomicLong();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4037d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f4040g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f4041h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4042i;

    public fc(ScreenMirrorService screenMirrorService, long j3) {
        this.f4042i = screenMirrorService;
        this.f4041h = j3;
        rd rdVar = ScreenMirrorService.n6;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, new a2.l(25));
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
        scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        this.f4040g = scheduledThreadPoolExecutor;
    }

    public static long a(fc fcVar, boolean z2) {
        long jF;
        long jMax;
        if (z2) {
            x7 x7Var = ScreenMirrorService.o6;
            synchronized (x7Var) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (x7Var.f5510c != 0) {
                    jF = x7Var.d(jUptimeMillis, true);
                } else {
                    long j3 = x7Var.f5514g;
                    if (j3 == Long.MIN_VALUE) {
                        jMax = 0;
                    } else {
                        jMax = Math.max(0L, x7Var.f5508a.f() - x7.c(j3, jUptimeMillis));
                    }
                    jF = Math.max(0L, jMax);
                }
            }
        } else {
            jF = ScreenMirrorService.o6.f();
        }
        return Math.max(1L, jF);
    }

    public final void b() {
        synchronized (this.f4037d) {
            try {
                boolean z2 = true;
                if (this.f4034a.compareAndSet(false, true)) {
                    if (this.f4038e != 0 || this.f4039f) {
                        z2 = false;
                    } else {
                        this.f4039f = true;
                    }
                    if (z2) {
                        this.f4040g.shutdown();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        boolean z2;
        synchronized (this.f4037d) {
            try {
                int i3 = this.f4038e;
                z2 = true;
                if (i3 > 0) {
                    this.f4038e = i3 - 1;
                }
                if (this.f4034a.get() && this.f4038e == 0 && !this.f4039f) {
                    this.f4039f = true;
                } else {
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            this.f4040g.shutdown();
        }
    }

    public final void d(e2.c cVar, e2.d dVar, e2.r rVar) {
        ScreenMirrorService screenMirrorService;
        d0.d dVarG;
        boolean z2;
        e2.r rVar2 = rVar;
        ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
        if (this.f4034a.get() || screenMirrorServiceU2 == null || screenMirrorServiceU2 != (screenMirrorService = this.f4042i) || !screenMirrorService.f2537s.get() || this.f4042i.Z.get() != this.f4041h) {
            rVar2.b();
            return;
        }
        boolean z3 = cVar.f727a == e2.b.f714e;
        synchronized (this.f4037d) {
            try {
                if (this.f4034a.get()) {
                    z2 = false;
                } else if (this.f4038e >= 2) {
                    z2 = true;
                } else {
                    if (z3) {
                        x7 x7Var = ScreenMirrorService.o6;
                        synchronized (x7Var) {
                            dVarG = x7Var.g(true);
                        }
                    } else {
                        x7 x7Var2 = ScreenMirrorService.o6;
                        synchronized (x7Var2) {
                            dVarG = x7Var2.g(false);
                        }
                    }
                    if (((p5) dVarG.f532b) != null) {
                        this.f4038e++;
                    }
                    z2 = false;
                }
                dVarG = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            rVar2.a(50L);
            return;
        }
        if (dVarG == null) {
            rVar2.b();
            return;
        }
        p5 p5Var = (p5) dVarG.f532b;
        if (p5Var == null) {
            long jIncrementAndGet = this.f4036c.incrementAndGet();
            if (jIncrementAndGet == 1 || jIncrementAndGet % 32 == 0) {
                StringBuilder sbJ = a0.a.j(jIncrementAndGet, "stage=admission source=rtc deferredCount=", " retryAfterMs=");
                sbJ.append(dVarG.f531a);
                sbJ.append(" sharedIntervalMs=");
                sbJ.append(ScreenMirrorService.o6.b());
                Log.d("MirrorScreenshotPerf", sbJ.toString());
            }
            rVar2.a(dVarG.f531a);
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicReference atomicReference = new AtomicReference();
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f4040g;
            try {
                u3 u3Var = new u3(this, atomicReference, atomicBoolean, p5Var, rVar2, 1);
                atomicBoolean = atomicBoolean;
                p5Var = p5Var;
                try {
                    atomicReference.set(scheduledThreadPoolExecutor.schedule(u3Var, 6000L, TimeUnit.MILLISECONDS));
                    rVar2 = rVar;
                    screenMirrorServiceU2.takeScreenshot(0, this.f4040g, new ec(this, atomicReference, p5Var, atomicBoolean, rVar2, z3, dVar));
                } catch (Throwable th2) {
                    th = th2;
                    rVar2 = rVar;
                    ScheduledFuture scheduledFuture = (ScheduledFuture) atomicReference.getAndSet(null);
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    p5Var.b();
                    if (this.f4035b.compareAndSet(false, true)) {
                        Log.w("ScreenMirror", "RTC accessibility screenshot request failed", th);
                    }
                    try {
                        rVar2.a(200L);
                    } finally {
                        if (atomicBoolean.compareAndSet(true, false)) {
                            c();
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                atomicBoolean = atomicBoolean;
                p5Var = p5Var;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
