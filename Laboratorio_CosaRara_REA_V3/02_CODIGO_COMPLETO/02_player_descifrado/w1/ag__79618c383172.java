// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.SystemClock;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicLong;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.keepalive.WakeScreenActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ag implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q.c f3522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dc f3523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayDeque f3524e = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public yf f3525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3526g;

    public ag(q.c cVar, dc dcVar) {
        this.f3522c = cVar;
        this.f3523d = dcVar;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f3522c.f3005a.post(new xf(this, 1));
    }

    public final void d(yf yfVar, boolean z2) {
        boolean zD;
        if (this.f3526g || this.f3525f != yfVar) {
            return;
        }
        this.f3522c.getClass();
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis > yfVar.f5652a) {
            w(yfVar, false);
            return;
        }
        boolean z3 = yfVar.f5654c;
        if (!z2) {
            if (!z3) {
                yfVar.f5654c = true;
                try {
                    ScreenMirrorService screenMirrorService = this.f3523d.f3821a;
                    n4.Z0(screenMirrorService);
                    WakeScreenActivity.b(screenMirrorService, "remote-wake-gesture");
                } catch (Throwable unused) {
                }
            }
            if (jUptimeMillis >= yfVar.f5652a) {
                w(yfVar, false);
                return;
            } else {
                y(yfVar);
                return;
            }
        }
        if (z3) {
            try {
                this.f3523d.getClass();
                AtomicLong atomicLong = WakeScreenActivity.f2633f;
                long j3 = atomicLong.get();
                if (j3 != 0) {
                    if (SystemClock.uptimeMillis() <= WakeScreenActivity.f2634g) {
                        yfVar.f5655d = -1L;
                        if (jUptimeMillis >= yfVar.f5652a) {
                            w(yfVar, false);
                            return;
                        } else {
                            y(yfVar);
                            return;
                        }
                    }
                    if (j3 != 0) {
                        atomicLong.compareAndSet(j3, 0L);
                    }
                }
            } catch (Throwable unused2) {
            }
            if (yfVar.f5655d < 0) {
                yfVar.f5655d = jUptimeMillis;
            }
            if (jUptimeMillis - yfVar.f5655d < 250) {
                if (jUptimeMillis >= yfVar.f5652a) {
                    w(yfVar, false);
                    return;
                } else {
                    y(yfVar);
                    return;
                }
            }
        }
        try {
            zD = this.f3523d.d();
        } catch (Throwable unused3) {
            zD = false;
        }
        if (!zD) {
            w(yfVar, true);
            return;
        }
        if (!yfVar.f5656e) {
            yfVar.f5656e = true;
            try {
                this.f3523d.n();
            } catch (Throwable unused4) {
            }
        }
        if (jUptimeMillis >= yfVar.f5652a) {
            w(yfVar, false);
        } else {
            y(yfVar);
        }
    }

    public final void w(yf yfVar, boolean z2) {
        n3 n3VarU5;
        yf yfVar2;
        if (this.f3525f != yfVar) {
            return;
        }
        ba baVar = yfVar.f5653b;
        if (baVar != null) {
            this.f3522c.f3005a.removeCallbacks(baVar);
        }
        zf zfVar = null;
        this.f3525f = null;
        boolean zB4 = false;
        if (z2) {
            try {
                dc dcVar = this.f3523d;
                dcVar.getClass();
                try {
                    n3VarU5 = dcVar.f3821a.u5();
                } catch (Throwable unused) {
                    n3VarU5 = dcVar.f3821a.R3;
                }
                k8 k8Var = n3VarU5 == null ? null : new k8(n3VarU5.f4617a, n3VarU5.f4618b);
                if (k8Var != null) {
                    int i3 = k8Var.f4407b;
                    int i4 = k8Var.f4406a;
                    if (i4 > 0 && i3 > 0) {
                        int i5 = i4 / 2;
                        zfVar = new zf(i5, i3 <= 0 ? 0 : Math.min((int) (Math.max(0.0f, Math.min(1.0f, 0.95f)) * i3), i3 - 1), i5, i3 <= 0 ? 0 : Math.min((int) (Math.max(0.0f, Math.min(1.0f, 0.25f)) * i3), i3 - 1));
                    }
                }
                if (zfVar != null) {
                    this.f3523d.b(zfVar);
                }
            } catch (Throwable unused2) {
            }
        }
        if (this.f3526g || this.f3525f != null || (yfVar2 = (yf) this.f3524e.pollFirst()) == null) {
            return;
        }
        this.f3525f = yfVar2;
        try {
            ScreenMirrorService screenMirrorService = this.f3523d.f3821a;
            rd rdVar = ScreenMirrorService.n6;
            zB4 = screenMirrorService.b4();
        } catch (Throwable unused3) {
        }
        d(yfVar2, zB4);
    }

    public final void y(yf yfVar) {
        if (yfVar.f5653b == null) {
            yfVar.f5653b = new ba(this, yfVar, 17);
        }
        long j3 = yfVar.f5652a;
        q.c cVar = this.f3522c;
        cVar.getClass();
        long jMin = Math.min(50L, Math.max(0L, j3 - SystemClock.uptimeMillis()));
        if (cVar.f3005a.postDelayed(yfVar.f5653b, jMin)) {
            return;
        }
        w(yfVar, false);
    }
}
