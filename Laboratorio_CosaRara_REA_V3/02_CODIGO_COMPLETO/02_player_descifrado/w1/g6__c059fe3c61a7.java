// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import android.os.SystemClock;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g6 implements AutoCloseable {
    public boolean A;
    public boolean B;
    public boolean C;
    public d0.d D;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final aa f4083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e6 f4084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final aa f4085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final za f4086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h2.a f4087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f4088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f4089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f4090k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicLong f4091l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicLong f4092m;
    public final AtomicLong n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicLong f4093o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicLong f4094p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicLong f4095q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicLong f4096r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicLong f4097s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile b6 f4098t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile long f4099u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile long f4100v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile long f4101w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile long f4102x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f4103y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f4104z;

    public g6(aa aaVar, aa aaVar2, za zaVar, h2.a aVar) {
        e6 e6Var = new e6(Executors.newSingleThreadExecutor(new d6()));
        this.f4082c = new Object();
        this.f4091l = new AtomicLong();
        this.f4092m = new AtomicLong();
        this.n = new AtomicLong();
        this.f4093o = new AtomicLong();
        this.f4094p = new AtomicLong();
        this.f4095q = new AtomicLong();
        this.f4096r = new AtomicLong();
        this.f4097s = new AtomicLong();
        this.f4098t = b6.f3556m;
        this.f4099u = Long.MIN_VALUE;
        this.f4104z = Long.MIN_VALUE;
        this.f4083d = aaVar;
        this.f4084e = e6Var;
        this.f4085f = aaVar2;
        this.f4086g = zaVar;
        this.f4087h = aVar;
        this.f4088i = 350L;
        this.f4089j = 500L;
        this.f4090k = 5000L;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f4082c) {
            try {
                if (this.C) {
                    return;
                }
                this.C = true;
                if (this.D != null) {
                    this.f4095q.incrementAndGet();
                }
                this.D = null;
                this.f4084e.close();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(d0.d dVar, b6 b6Var) {
        try {
            aa aaVar = this.f4085f;
            e2.q0 q0Var = new e2.q0(this, dVar, b6Var, 7);
            ScreenMirrorService screenMirrorService = aaVar.f3491d;
            Handler handler = screenMirrorService.f2541t;
            if (handler == null || screenMirrorService.X || screenMirrorService.Y) {
                return;
            }
            handler.post(q0Var);
        } catch (Throwable unused) {
            this.f4095q.incrementAndGet();
        }
    }

    public final b6 w(long j3) {
        b6 b6Var = this.f4098t;
        long j4 = this.f4099u;
        long j5 = this.f4100v;
        this.f4087h.getClass();
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (b6Var == b6.f3556m || j4 != j3 || j5 <= 0 || jUptimeMillis < j5 || jUptimeMillis - j5 > this.f4088i) {
            return null;
        }
        return b6Var;
    }

    public final boolean y(long j3, Consumer consumer) {
        d0.d dVar;
        d0.d dVar2;
        this.f4091l.incrementAndGet();
        synchronized (this.f4082c) {
            try {
                if (this.C) {
                    this.f4093o.incrementAndGet();
                    return false;
                }
                b6 b6VarW = w(j3);
                if (b6VarW != null) {
                    d(new d0.d(j3, consumer), b6VarW);
                    return true;
                }
                synchronized (this.f4082c) {
                    try {
                        if (this.C) {
                            this.f4093o.incrementAndGet();
                            return false;
                        }
                        this.f4087h.getClass();
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        if (!this.f4103y && jUptimeMillis >= 0 && jUptimeMillis < this.f4102x) {
                            this.f4097s.incrementAndGet();
                            dVar2 = new d0.d(j3, consumer);
                            dVar = null;
                        } else if (this.f4103y) {
                            this.n.incrementAndGet();
                            if (jUptimeMillis < this.f4101w || jUptimeMillis - this.f4101w <= this.f4089j) {
                                d0.d dVar3 = this.D;
                                if (dVar3 != null && dVar3.f531a != j3) {
                                    this.f4095q.incrementAndGet();
                                }
                                this.D = new d0.d(j3, consumer);
                                return true;
                            }
                            d0.d dVar4 = this.D;
                            d0.d dVar5 = new d0.d(j3, consumer);
                            this.D = null;
                            if (!this.A) {
                                this.f4095q.incrementAndGet();
                                this.B = true;
                            }
                            this.A = true;
                            this.f4098t = b6.f3556m;
                            this.f4099u = j3;
                            this.f4100v = jUptimeMillis;
                            dVar = dVar4;
                            dVar2 = dVar5;
                        } else {
                            this.f4103y = true;
                            this.f4104z = j3;
                            this.f4087h.getClass();
                            this.f4101w = SystemClock.uptimeMillis();
                            this.A = false;
                            this.B = false;
                            this.D = new d0.d(j3, consumer);
                            dVar = null;
                            dVar2 = null;
                        }
                        if (dVar2 != null) {
                            if (dVar != null) {
                                d(dVar, b6.f3556m);
                            }
                            d(dVar2, b6.f3556m);
                            return true;
                        }
                        try {
                            this.f4084e.f3875c.execute(new a2.b(25, this));
                            return true;
                        } catch (Throwable unused) {
                            synchronized (this.f4082c) {
                                this.f4103y = false;
                                this.f4104z = Long.MIN_VALUE;
                                this.f4101w = 0L;
                                this.A = false;
                                this.B = false;
                                this.D = null;
                                this.f4093o.incrementAndGet();
                                return false;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
