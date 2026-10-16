// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import lyr.stable.runtime.ScreenMirrorService;
import w1.fc;
import w1.o2;
import w1.rd;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final y f701j = new y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d2.o f702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicLong f706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f707f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v0 f708g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x0 f709h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final s f710i;

    public a0(fc fcVar, d2.o oVar, o1 o1Var, o1 o1Var2) {
        int i3;
        u uVar = new u();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new a2.l(7));
        executorServiceNewSingleThreadExecutor.getClass();
        x xVar = x.f1071k;
        z zVar = new z(1, f701j, y.class, "logEncodeTiming", "logEncodeTiming(Llyr/stable/runtime/rtc/AccessibilityWebpEncodeTimingSample;)V", 4);
        this.f702a = oVar;
        this.f703b = uVar;
        this.f704c = new AtomicBoolean(false);
        this.f705d = new AtomicBoolean(false);
        this.f706e = new AtomicLong(0L);
        this.f707f = new Object();
        this.f708g = new v0(o1Var, o1Var2);
        int i4 = 1;
        this.f709h = new x0(executorServiceNewSingleThreadExecutor, new z(3, uVar, u.class, "encode", "encode(Llyr/stable/runtime/rtc/AccessibilityVideoCapturer$CapturedArgb;Llyr/stable/runtime/rtc/DisplayTarget;J)Llyr/stable/runtime/rtc/WebpFrame;", 0), new z(i4, this, a0.class, "publishEncodedFrame", "publishEncodedFrame(Llyr/stable/runtime/rtc/EncodedWebpFrame;)V", 6), xVar, zVar);
        j jVar = s.L;
        d2.o oVar2 = new d2.o(2, this);
        z zVar2 = new z(i4, this, a0.class, "acceptFrame", "acceptFrame(Llyr/stable/runtime/rtc/AccessibilityVideoCapturer$CapturedArgb;)V", 5);
        z zVar3 = new z(i4, jVar, j.class, "logCaptureTiming", "logCaptureTiming(Llyr/stable/runtime/rtc/AccessibilityVideoCapturer$CaptureTimingSample;)V", 1);
        fc fcVar2 = fcVar instanceof fc ? fcVar : null;
        rd rdVar = fcVar2 != null ? ScreenMirrorService.n6 : new rd();
        synchronized (rdVar) {
            int iCeil = (int) Math.ceil(1000.0d / rdVar.f5019a);
            i3 = iCeil < 1 ? 1 : iCeil > 3 ? 3 : iCeil;
        }
        boolean z2 = fcVar2 == null;
        i iVar = i.f818k;
        s sVar = new s(i3, rdVar, z2, new b2.a(3), new h(fcVar2, oVar2, fcVar), zVar2, zVar3);
        sVar.f977r = fcVar;
        this.f710i = sVar;
    }

    public final void a() {
        w0 w0Var;
        f fVar;
        n0 n0Var;
        long jIncrementAndGet = this.f706e.incrementAndGet();
        if (jIncrementAndGet <= 0) {
            o2.k("interaction revision exhausted");
            return;
        }
        v0 v0Var = this.f708g;
        if (jIncrementAndGet <= 0) {
            v0Var.getClass();
            o2.i("interaction revision must be positive");
            return;
        }
        synchronized (v0Var.f1032f) {
            w0Var = null;
            if (!v0Var.f1047v && jIncrementAndGet > v0Var.f1046u) {
                v0Var.f1046u = jIncrementAndGet;
                t0 t0Var = v0Var.f1035i;
                if (t0Var != null && (n0Var = t0Var.f999a) != null && (!v0Var.b(n0Var))) {
                    v0Var.f1035i = null;
                    v0Var.f1040o++;
                }
            }
        }
        x0 x0Var = this.f709h;
        if (jIncrementAndGet <= 0) {
            x0Var.getClass();
            o2.i("interaction revision must be positive");
            return;
        }
        synchronized (x0Var.f1077f) {
            if (!x0Var.f1081j && jIncrementAndGet > x0Var.f1085o) {
                x0Var.f1085o = jIncrementAndGet;
                w0 w0Var2 = x0Var.f1080i;
                if (w0Var2 != null) {
                    if (x0Var.a(w0Var2.f1064a)) {
                        w0Var2 = null;
                    }
                    if (w0Var2 != null) {
                        x0Var.f1080i = null;
                        x0Var.f1084m++;
                        w0Var = w0Var2;
                    }
                }
                if (w0Var != null && (fVar = w0Var.f1064a) != null) {
                    fVar.b();
                }
            }
        }
        s sVar = this.f710i;
        if (jIncrementAndGet <= 0) {
            sVar.getClass();
            o2.i("interaction revision must be positive");
        } else {
            synchronized (sVar.f983x) {
                if (jIncrementAndGet > sVar.f984y.f866a) {
                    sVar.f984y = new m(jIncrementAndGet, ((Number) i.f818k.d()).longValue());
                }
            }
            sVar.l(b.f714e);
        }
    }

    public final void b() {
        f fVar;
        o oVarB;
        if (this.f704c.compareAndSet(false, true)) {
            if (this.f705d.compareAndSet(false, true)) {
                v0 v0Var = this.f708g;
                synchronized (v0Var.f1032f) {
                    if (!v0Var.f1047v) {
                        v0Var.f1047v = true;
                        v0Var.f1033g = 0L;
                        v0Var.f1035i = null;
                    }
                }
            }
            x0 x0Var = this.f709h;
            synchronized (x0Var.f1077f) {
                if (!x0Var.f1081j) {
                    x0Var.f1081j = true;
                    x0Var.f1078g++;
                    w0 w0Var = x0Var.f1080i;
                    x0Var.f1080i = null;
                    if (w0Var != null && (fVar = w0Var.f1064a) != null) {
                        fVar.b();
                    }
                    try {
                        x0Var.f1072a.shutdown();
                    } catch (Throwable unused) {
                    }
                }
            }
            s sVar = this.f710i;
            synchronized (sVar.f968h) {
                oVarB = sVar.b();
            }
            s.c(oVarB);
            s sVar2 = this.f710i;
            synchronized (sVar2.f968h) {
                if (sVar2.f976q) {
                    return;
                }
                sVar2.f976q = true;
                o oVarB2 = sVar2.b();
                fc fcVar = sVar2.f977r;
                sVar2.f977r = null;
                s.c(oVarB2);
                if (fcVar != null) {
                    try {
                        fcVar.b();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    public final b0 c() {
        v vVar;
        d2 d2Var;
        x0 x0Var = this.f709h;
        synchronized (x0Var.f1077f) {
            vVar = new v(x0Var.f1082k, x0Var.f1083l, x0Var.f1084m, x0Var.n, x0Var.f1079h, x0Var.f1080i != null, x0Var.f1081j);
        }
        v0 v0Var = this.f708g;
        synchronized (v0Var.f1032f) {
            d2Var = new d2(v0Var.f1036j, v0Var.f1037k, v0Var.f1038l, v0Var.f1039m, v0Var.n, v0Var.f1033g != 0, v0Var.f1035i != null, v0Var.f1041p, v0Var.f1042q, v0Var.f1043r, v0Var.f1040o, v0Var.f1044s, v0Var.f1045t);
        }
        return new b0(vVar, d2Var, this.f706e.get(), this.f704c.get());
    }

    public final void d() {
        if (this.f704c.get()) {
            return;
        }
        m0 m0Var = (m0) this.f702a.d();
        s sVar = this.f710i;
        int i3 = m0Var.f868a;
        int i4 = m0Var.f869b;
        synchronized (sVar.f968h) {
            if (!sVar.f976q && !sVar.f969i) {
                sVar.f969i = true;
                if (i3 < 2) {
                    i3 = 2;
                }
                int i5 = (i3 / 2) * 2;
                if (i4 < 2) {
                    i4 = 2;
                }
                int i6 = (i4 / 2) * 2;
                if (i5 <= 0 || i6 <= 0) {
                    throw new IllegalArgumentException("width, height, and densityDpi must be positive");
                }
                sVar.f972l++;
                sVar.f973m = Long.MIN_VALUE;
                sVar.f974o = Long.MIN_VALUE;
                sVar.f970j.set(0L);
                ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = null;
                sVar.J = null;
                sVar.f979t = false;
                sVar.f980u = Long.MIN_VALUE;
                sVar.f981v.set(false);
                sVar.f982w.set(false);
                sVar.f985z = sVar.f984y.f866a;
                sVar.A = 0L;
                sVar.B = Long.MIN_VALUE;
                sVar.C = Long.MIN_VALUE;
                g gVarG = sVar.g();
                sVar.f975p.set(false);
                if (sVar.f977r != null) {
                    scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new a2.l(6));
                    scheduledExecutorServiceNewSingleThreadScheduledExecutor.getClass();
                    sVar.f964d = new d2.o(1, scheduledExecutorServiceNewSingleThreadScheduledExecutor);
                    sVar.f978s = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
                }
                if (gVarG != null) {
                    try {
                        gVarG.f806b.cancel(false);
                    } catch (Throwable unused) {
                    }
                }
                if (scheduledExecutorServiceNewSingleThreadScheduledExecutor != null) {
                    try {
                        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(new a2.b(9, sVar), 0L, 50L, TimeUnit.MILLISECONDS);
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }
}
