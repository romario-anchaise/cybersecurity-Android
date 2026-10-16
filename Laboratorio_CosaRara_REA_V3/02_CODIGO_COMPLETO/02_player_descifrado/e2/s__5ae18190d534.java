// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import w1.fc;
import w1.rd;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class s {
    public static final j L = new j();
    public long A;
    public long B;
    public long C;
    public g D;
    public long E;
    public long F;
    public final ArrayDeque G;
    public l H;
    public n I;
    public n J;
    public l K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rd f961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b2.a f963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d2.o f964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z f966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p1.l f967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f969i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicLong f970j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f971k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f972l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f973m;
    public long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f974o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f975p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f976q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public fc f977r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ScheduledExecutorService f978s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f979t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f980u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicBoolean f981v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicBoolean f982w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f983x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile m f984y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f985z;

    public s(int i3, rd rdVar, boolean z2, b2.a aVar, h hVar, z zVar, p1.l lVar) {
        i iVar = i.f818k;
        this.f961a = rdVar;
        this.f962b = z2;
        this.f963c = aVar;
        this.f964d = null;
        this.f965e = hVar;
        this.f966f = zVar;
        this.f967g = lVar;
        this.f968h = new Object();
        this.f970j = new AtomicLong(0L);
        this.f973m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
        this.f974o = Long.MIN_VALUE;
        this.f975p = new AtomicBoolean(false);
        this.f980u = Long.MIN_VALUE;
        this.f981v = new AtomicBoolean(false);
        this.f982w = new AtomicBoolean(false);
        this.f983x = new Object();
        this.f984y = new m(0L, Long.MIN_VALUE);
        this.B = Long.MIN_VALUE;
        this.C = Long.MIN_VALUE;
        this.E = Long.MIN_VALUE;
        this.G = new ArrayDeque();
    }

    public static final void a(s sVar, n nVar, int i3) {
        a aVar;
        synchronized (sVar.f968h) {
            try {
                if (sVar.f970j.get() == nVar.f894a && sVar.K == null) {
                    if (sVar.f962b) {
                        sVar.f961a.c(i3, ((Number) sVar.f963c.d()).longValue());
                    }
                    if (sVar.f970j.compareAndSet(nVar.f894a, 0L)) {
                        n nVar2 = sVar.J;
                        if (nVar2 != null && nVar2.f894a == nVar.f894a) {
                            sVar.J = null;
                        }
                        sVar.f974o = Long.MIN_VALUE;
                        sVar.m(nVar, ((Number) i.f818k.d()).longValue(), false);
                        a aVarJ = sVar.j(false);
                        aVar = new a(aVarJ.f699a, aVarJ.f700b);
                    } else {
                        aVar = new a(null, null, 5);
                    }
                    sVar.e(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(o oVar) {
        ScheduledExecutorService scheduledExecutorService = oVar.f906a;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        g gVar = oVar.f908c;
        if (gVar != null) {
            try {
                gVar.f806b.cancel(false);
            } catch (Throwable unused) {
            }
        }
        ArrayList arrayList = oVar.f907b;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            l lVar = (l) obj;
            if (lVar.f849a != Thread.currentThread()) {
                boolean z2 = false;
                while (true) {
                    try {
                        lVar.f850b.await();
                        break;
                    } catch (InterruptedException unused2) {
                        z2 = true;
                    }
                }
                if (z2) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static long d(long j3, long j4) {
        if (j3 == Long.MIN_VALUE || j4 <= j3) {
            return 0L;
        }
        return (j4 - j3) / 1000000;
    }

    public final o b() {
        boolean z2 = this.f969i;
        this.f969i = false;
        if (z2) {
            this.f972l++;
        }
        this.f970j.set(0L);
        this.J = null;
        this.f979t = false;
        this.f980u = Long.MIN_VALUE;
        this.f981v.set(false);
        this.f982w.set(false);
        this.A = 0L;
        this.B = Long.MIN_VALUE;
        this.C = Long.MIN_VALUE;
        this.I = null;
        g gVarG = g();
        ScheduledExecutorService scheduledExecutorService = this.f978s;
        this.f978s = null;
        if (this.f977r != null) {
            this.f964d = null;
        }
        return new o(scheduledExecutorService, i1.j.z(this.H, this.K), gVarG);
    }

    public final void e(a aVar) {
        g gVar;
        l lVar;
        a aVar2;
        a aVar3;
        p pVar = aVar.f700b;
        g gVar2 = pVar.f914a;
        if (gVar2 != null) {
            try {
                gVar2.f806b.cancel(false);
            } catch (Throwable unused) {
            }
        }
        q qVar = pVar.f915b;
        if (qVar != null) {
            try {
                gVar = new g(((ScheduledExecutorService) qVar.f922a.f603d).schedule(new a2.b(10, new d2.c(this, qVar, 1)), qVar.f925d, TimeUnit.NANOSECONDS), 0);
            } catch (Throwable unused2) {
                gVar = null;
            }
            if (gVar != null) {
                synchronized (this.f968h) {
                    if (qVar.f923b == this.F && qVar.f924c == this.f972l && this.f969i && !this.f976q) {
                        this.D = gVar;
                        gVar = null;
                    }
                }
                if (gVar != null) {
                    try {
                        gVar.f806b.cancel(false);
                    } catch (Throwable unused3) {
                    }
                }
            }
        }
        n nVar = aVar.f699a;
        if (nVar != null) {
            synchronized (this.f968h) {
                try {
                    if (!this.f969i || this.f976q || this.f972l != nVar.f895b || this.f970j.get() != nVar.f894a) {
                        lVar = null;
                    } else if (this.H == null) {
                        lVar = new l();
                        this.H = lVar;
                    } else {
                        this.I = nVar;
                        lVar = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (lVar != null) {
                try {
                    this.f965e.e(new c(nVar.f896c, nVar.f897d), new r(this, nVar));
                    synchronized (this.f968h) {
                        try {
                            if (this.H == lVar) {
                                this.H = null;
                            }
                            lVar.f850b.countDown();
                            n nVar2 = this.I;
                            this.I = null;
                            aVar3 = (nVar2 != null && this.f969i && !this.f976q && this.f972l == nVar2.f895b && this.f970j.get() == nVar2.f894a) ? new a(nVar2, null, 6) : new a(null, null, 7);
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    e(aVar3);
                } catch (Throwable unused4) {
                    synchronized (this.f968h) {
                        try {
                            if (this.H == lVar) {
                                this.H = null;
                            }
                            lVar.f850b.countDown();
                            if (this.f970j.compareAndSet(nVar.f894a, 0L)) {
                                n nVar3 = this.J;
                                if (nVar3 != null && nVar3.f894a == nVar.f894a) {
                                    this.J = null;
                                }
                                this.f974o = Long.MIN_VALUE;
                                m(nVar, ((Number) i.f818k.d()).longValue(), false);
                                aVar2 = j(false);
                            } else {
                                n nVar4 = this.I;
                                this.I = null;
                                aVar2 = (nVar4 != null && this.f969i && !this.f976q && this.f972l == nVar4.f895b && this.f970j.get() == nVar4.f894a) ? new a(nVar4, null, 6) : new a(null, null, 7);
                            }
                            e(aVar2);
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            }
        }
        f();
    }

    public final void f() {
        e eVar;
        if (Thread.holdsLock(this.f968h)) {
            return;
        }
        while (true) {
            synchronized (this.f968h) {
                eVar = (e) this.G.pollFirst();
            }
            if (eVar == null) {
                return;
            } else {
                this.f967g.f(eVar);
            }
        }
    }

    public final g g() {
        this.F++;
        g gVar = this.D;
        this.D = null;
        this.E = Long.MIN_VALUE;
        return gVar;
    }

    public final void h(long j3) {
        if (this.A > 0) {
            return;
        }
        if (!this.f979t) {
            this.f980u = j3;
        }
        this.f979t = true;
    }

    public final long i(long j3) {
        synchronized (this.f968h) {
            long j4 = this.n;
            if (j4 != Long.MIN_VALUE) {
                j3 = Math.max(j3, j4 + 1);
            }
            this.n = j3;
        }
        return j3;
    }

    public final a j(boolean z2) {
        b bVar;
        long j3;
        long j4;
        long j5;
        long j6;
        long jK;
        long jL;
        g gVar = null;
        if (!this.f969i || this.f976q) {
            return new a(null, null, 7);
        }
        long jLongValue = ((Number) i.f818k.d()).longValue();
        n();
        long j7 = this.f970j.get();
        if (j7 != 0) {
            long j8 = this.f974o;
            if (j8 != Long.MIN_VALUE) {
                long j9 = jLongValue - j8;
                rd rdVar = this.f961a;
                synchronized (rdVar) {
                    jL = rdVar.l() * 1000000;
                }
                if (j9 > jL) {
                    if (this.f962b) {
                        this.f961a.e(((Number) this.f963c.d()).longValue());
                    }
                    if (jLongValue - this.f974o < 6000000000L) {
                        return new a(null, null, 5);
                    }
                    if (!this.f970j.compareAndSet(j7, 0L)) {
                        return new a(null, null, 7);
                    }
                    n nVar = this.J;
                    if (nVar == null || nVar.f894a != j7) {
                        nVar = null;
                    }
                    this.J = null;
                    this.f973m = jLongValue;
                    this.f974o = Long.MIN_VALUE;
                    if (nVar != null) {
                        m(nVar, jLongValue, true);
                    } else {
                        h(jLongValue);
                    }
                    rd rdVar2 = this.f961a;
                    ((Number) this.f963c.d()).longValue();
                    return new a(null, k(rdVar2.k() + jLongValue), 1);
                }
            }
            return new a(null, null, 7);
        }
        if (this.A > 0) {
            bVar = b.f714e;
        } else if (this.f979t) {
            bVar = b.f713d;
        } else {
            if (!z2) {
                return new a(null, null, 5);
            }
            bVar = b.f712c;
        }
        boolean z3 = bVar != b.f712c;
        long j10 = this.C;
        int i3 = 3;
        if (j10 != Long.MIN_VALUE) {
            if (jLongValue < j10) {
                return new a(null, z3 ? k(j10) : new p(gVar, i3), 1);
            }
            this.C = Long.MIN_VALUE;
        }
        int iOrdinal = bVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                rd rdVar3 = this.f961a;
                ((Number) this.f963c.d()).longValue();
                jK = rdVar3.k();
            } else {
                if (iOrdinal != 2) {
                    throw new h1.a();
                }
                rd rdVar4 = this.f961a;
                ((Number) this.f963c.d()).longValue();
                synchronized (rdVar4) {
                    jK = rdVar4.f() * 1000000;
                }
            }
            j4 = jK;
        } else {
            rd rdVar5 = this.f961a;
            synchronized (rdVar5) {
                j3 = rdVar5.f5019a;
            }
            j4 = j3 * 1000000;
        }
        long j11 = this.f973m;
        if (j11 != r14 && jLongValue >= j11 && jLongValue - j11 < j4) {
            return new a(null, z3 ? k(j11 + j4) : new p(gVar, i3), 1);
        }
        int iOrdinal2 = bVar.ordinal();
        if (iOrdinal2 == 0) {
            j5 = Long.MIN_VALUE;
            j6 = this.f985z;
        } else if (iOrdinal2 == 1) {
            long j12 = this.f985z;
            long j13 = this.f980u;
            this.f979t = false;
            this.f980u = Long.MIN_VALUE;
            j6 = j12;
            j5 = j13;
        } else {
            if (iOrdinal2 != 2) {
                throw new h1.a();
            }
            long j14 = this.A;
            j5 = this.B;
            this.A = 0L;
            this.B = Long.MIN_VALUE;
            j6 = j14;
        }
        long jD = d(j5, jLongValue);
        long j15 = this.f971k + 1;
        this.f971k = j15;
        boolean z4 = z3;
        n nVar2 = new n(j15, this.f972l, bVar, j6, j5, jD, bVar == b.f714e ? jD : 0L, jLongValue);
        if (!this.f970j.compareAndSet(0L, j15)) {
            m(nVar2, jLongValue, true);
            return new a(null, null, 5);
        }
        this.J = nVar2;
        p pVar = z4 ? new p(g(), 2) : new p(gVar, 3);
        this.f973m = jLongValue;
        this.f974o = jLongValue;
        return new a(nVar2, pVar);
    }

    public final p k(long j3) {
        d2.o oVar = this.f964d;
        int i3 = 3;
        g gVar = null;
        if (oVar == null) {
            return new p(gVar, i3);
        }
        long j4 = this.E;
        if (j4 != Long.MIN_VALUE && j4 <= j3) {
            return new p(gVar, i3);
        }
        g gVar2 = this.D;
        this.D = null;
        long j5 = this.F + 1;
        this.F = j5;
        this.E = j3;
        long jLongValue = j3 - ((Number) i.f818k.d()).longValue();
        return new p(gVar2, new q(oVar, j5, this.f972l, jLongValue < 0 ? 0L : jLongValue));
    }

    public final void l(b bVar) {
        d2.o oVar;
        s sVar;
        if (bVar == b.f713d) {
            this.f981v.set(true);
        }
        synchronized (this.f968h) {
            oVar = (!this.f969i || this.f976q) ? null : this.f964d;
        }
        if (oVar == null || !this.f982w.compareAndSet(false, true)) {
            return;
        }
        try {
            sVar = this;
            try {
                ((ScheduledExecutorService) oVar.f603d).schedule(new a2.b(10, new z(0, sVar, s.class, "runPostedNotifications", "runPostedNotifications()V", 2)), 0L, TimeUnit.NANOSECONDS);
            } catch (Throwable unused) {
                sVar.f982w.set(false);
            }
        } catch (Throwable unused2) {
            sVar = this;
        }
    }

    public final void m(n nVar, long j3, boolean z2) {
        Long lValueOf;
        n();
        b bVar = nVar.f896c;
        long j4 = nVar.f898e;
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0) {
            if (z2) {
                h(j3);
                return;
            }
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                throw new h1.a();
            }
            long j5 = nVar.f897d;
            if (j5 >= this.A) {
                this.A = j5;
                lValueOf = j4 != Long.MIN_VALUE ? Long.valueOf(j4) : null;
                if (lValueOf != null) {
                    j3 = lValueOf.longValue();
                }
                this.B = j3;
                return;
            }
            return;
        }
        if (!z2 || this.A > 0) {
            return;
        }
        n nVar2 = this.J;
        if (nVar2 != null && nVar2.f896c == b.f714e && nVar2.f897d >= this.f985z) {
            return;
        }
        lValueOf = j4 != Long.MIN_VALUE ? Long.valueOf(j4) : null;
        if (lValueOf != null) {
            j3 = lValueOf.longValue();
        }
        h(j3);
    }

    public final void n() {
        m mVar = this.f984y;
        long j3 = mVar.f866a;
        if (j3 <= this.f985z) {
            return;
        }
        this.f985z = j3;
        this.A = j3;
        this.B = mVar.f867b;
        this.f979t = false;
        this.f980u = Long.MIN_VALUE;
    }
}
