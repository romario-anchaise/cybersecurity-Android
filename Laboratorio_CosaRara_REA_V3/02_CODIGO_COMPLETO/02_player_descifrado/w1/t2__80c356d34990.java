// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import android.os.SystemClock;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t2 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile long f5127p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ScheduledExecutorService f5128q = Executors.newSingleThreadScheduledExecutor(new a2.l(16));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AtomicLong f5129r = new AtomicLong();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final o2 f5130s = new o2(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m4 f5131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dc f5132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final aa f5133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o2 f5134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g.j f5135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o2 f5136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o2 f5137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f5138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f5139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayDeque f5140j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public s2 f5141k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public sf f5142l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5143m;
    public boolean n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f5144o;

    public t2(m4 m4Var, dc dcVar, aa aaVar, o2 o2Var, ib ibVar) {
        o2 o2Var2 = new o2(0);
        this.f5140j = new ArrayDeque();
        if (m4Var == null) {
            o2.i("executor dependencies required");
            throw null;
        }
        o2 o2Var3 = f5130s;
        if (o2Var3 == null) {
            o2.i("capacities must be positive");
            throw null;
        }
        this.f5131a = m4Var;
        this.f5132b = dcVar;
        this.f5133c = aaVar;
        this.f5134d = o2Var;
        this.f5135e = new g.j(new d2.o(9, ibVar));
        this.f5136f = o2Var3;
        this.f5137g = o2Var2;
        this.f5138h = 4;
        this.f5139i = f5129r.incrementAndGet();
    }

    public static int a(n2 n2Var) {
        int i3 = n2Var.f4599a;
        if (i3 == 6) {
            return 3;
        }
        return i3 == 3 ? 4 : 2;
    }

    public static void b(s2 s2Var) {
        e2.g gVar = s2Var.f5047i;
        s2Var.f5047i = null;
        if (gVar != null) {
            gVar.f806b.cancel(false);
        }
    }

    public static void e(sf sfVar) {
        if (sfVar == null) {
            return;
        }
        try {
            sfVar.close();
        } catch (Throwable unused) {
        }
    }

    public final void c(f4 f4Var, int i3, int i4) {
        boolean z2;
        o0 o0Var;
        if (this.f5131a.c(f4Var, i3)) {
            return;
        }
        m4 m4Var = this.f5131a;
        synchronized (m4Var) {
            z2 = m4Var.f4506c == f4Var && f4Var.f3987h == 3;
        }
        if (z2) {
            return;
        }
        synchronized (this) {
            try {
                s2 s2Var = this.f5141k;
                o0Var = null;
                if (s2Var != null && s2Var.f5046h == f4Var) {
                    q0 q0Var = s2Var.f5040b;
                    if (q0Var.f4878b == 1) {
                        o0 o0VarL = l(q0Var, 5, q0Var.f4881e, i4);
                        b(this.f5141k);
                        this.f5141k = null;
                        r();
                        o0Var = o0VarL;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g(o0Var);
    }

    public final void d() {
        f4 f4Var;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                if (this.n) {
                    return;
                }
                this.n = true;
                sf sfVar = this.f5142l;
                f4 f4Var2 = null;
                this.f5142l = null;
                while (!this.f5140j.isEmpty()) {
                    s2 s2Var = (s2) this.f5140j.removeFirst();
                    b(s2Var);
                    q0 q0Var = s2Var.f5040b;
                    arrayList.add(l(q0Var, 5, q0Var.f4881e, 13));
                }
                s2 s2Var2 = this.f5141k;
                if (s2Var2 != null && (f4Var = s2Var2.f5046h) != null) {
                    f4Var2 = f4Var;
                } else if (s2Var2 != null) {
                    b(s2Var2);
                    q0 q0Var2 = this.f5141k.f5040b;
                    arrayList.add(l(q0Var2, 5, q0Var2.f4881e, 13));
                    this.f5141k = null;
                }
                r();
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    g((o0) obj);
                }
                if (f4Var2 != null) {
                    p2 p2Var = new p2(this, f4Var2, 1);
                    try {
                        Handler handler = this.f5133c.f3491d.f2541t;
                        if (handler == null || !handler.post(p2Var)) {
                            p2Var.run();
                        }
                    } catch (Throwable unused) {
                    }
                }
                e(sfVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int f(s2 s2Var) {
        synchronized (this) {
            try {
                if (s2Var.f5040b.f4878b == 2) {
                    return 13;
                }
                if (this.n) {
                    return 13;
                }
                if (!s2Var.f5043e && this.f5141k == s2Var) {
                    if (i(s2Var)) {
                        return 15;
                    }
                    s2Var.f5044f = true;
                    b(s2Var);
                    return 0;
                }
                return 6;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(o0 o0Var) {
        g.j jVar = this.f5135e;
        if (o0Var == null) {
            jVar.getClass();
            return;
        }
        d2.o oVar = (d2.o) jVar.f1414c;
        int i3 = o0Var.f4671a;
        int i4 = o0Var.f4672b;
        int i5 = o0Var.f4673c;
        int i6 = o0Var.f4674d;
        int i7 = o0Var.f4675e;
        int i8 = o0Var.f4676f;
        ib ibVar = (ib) oVar.f603d;
        ScreenMirrorService screenMirrorService = ibVar.f4279a;
        OutputStream outputStream = ibVar.f4280b;
        rd rdVar = ScreenMirrorService.n6;
        screenMirrorService.F6(outputStream, i3, i4, i5, i6, i7, i8);
    }

    public final void h(s2 s2Var, int i3, int i4) {
        synchronized (this) {
            try {
                if (s2Var.f5040b.f4878b != 2 && !s2Var.f5044f) {
                    this.f5140j.remove(s2Var);
                    if (this.f5141k == s2Var) {
                        this.f5141k = null;
                    }
                    f4 f4Var = s2Var.f5046h;
                    q0 q0Var = s2Var.f5040b;
                    o0 o0VarL = l(q0Var, i3, q0Var.f4881e, i4);
                    b(s2Var);
                    boolean z2 = false;
                    if (this.f5141k == null && this.f5140j.isEmpty() && this.f5143m) {
                        this.f5143m = false;
                        this.f5144o++;
                    }
                    r();
                    if (!this.n && this.f5141k == null && !this.f5140j.isEmpty()) {
                        z2 = true;
                    }
                    if (f4Var != null) {
                        try {
                            this.f5131a.c(f4Var, 4);
                        } catch (Throwable unused) {
                        }
                    }
                    g(o0VarL);
                    if (z2) {
                        n();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean i(s2 s2Var) {
        this.f5134d.getClass();
        return SystemClock.uptimeMillis() - s2Var.f5041c >= s2Var.f5042d;
    }

    public final void j(s2 s2Var, int i3, int i4, int i5) {
        synchronized (this) {
            try {
                q0 q0Var = s2Var.f5040b;
                if (q0Var.f4878b == 2) {
                    return;
                }
                o0 o0VarL = l(q0Var, i3, i4, i5);
                b(s2Var);
                sf sfVar = null;
                if (this.f5141k == s2Var) {
                    this.f5141k = null;
                }
                r();
                boolean z2 = (this.n || this.f5140j.isEmpty()) ? false : true;
                if (this.f5141k == null && this.f5140j.isEmpty()) {
                    sf sfVar2 = this.f5142l;
                    this.f5142l = null;
                    sfVar = sfVar2;
                }
                g(o0VarL);
                e(sfVar);
                if (z2) {
                    n();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k(s2 s2Var, f4 f4Var) {
        synchronized (this) {
            if (this.f5141k == s2Var && s2Var.f5040b.f4878b != 2 && !this.n) {
                s2Var.f5046h = f4Var;
                this.f5131a.m(f4Var);
            }
        }
    }

    public final o0 l(q0 q0Var, int i3, int i4, int i5) {
        this.f5135e.getClass();
        q0Var.f4878b = 2;
        q0Var.f4879c = i3;
        q0Var.f4880d = 100;
        q0Var.f4881e = i4;
        q0Var.f4882f = i5;
        return q0Var.a();
    }

    public final int m(n2 n2Var) {
        try {
            ScreenMirrorService screenMirrorService = this.f5132b.f3821a;
            rd rdVar = ScreenMirrorService.n6;
            if (n2Var.f4599a == 6 || !screenMirrorService.G3()) {
                return 0;
            }
            screenMirrorService.w5();
            return 39;
        } catch (Throwable unused) {
            return 4;
        }
    }

    public final void n() {
        synchronized (this) {
            try {
                if (!this.f5143m && (!this.n || !this.f5140j.isEmpty())) {
                    this.f5143m = true;
                    long j3 = this.f5144o + 1;
                    this.f5144o = j3;
                    try {
                        aa aaVar = this.f5133c;
                        e2.i1 i1Var = new e2.i1(this, j3, 1);
                        Handler handler = aaVar.f3491d.f2541t;
                        if (handler != null && handler.post(i1Var)) {
                            return;
                        }
                    } catch (Throwable unused) {
                    }
                    ArrayList arrayList = new ArrayList();
                    synchronized (this) {
                        try {
                            if (this.f5143m && this.f5144o == j3) {
                                int i3 = 0;
                                this.f5143m = false;
                                while (!this.f5140j.isEmpty()) {
                                    arrayList.add((s2) this.f5140j.removeFirst());
                                }
                                int size = arrayList.size();
                                while (i3 < size) {
                                    Object obj = arrayList.get(i3);
                                    i3++;
                                    h((s2) obj, 6, 13);
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized k4 o(s2 s2Var) {
        if (!this.n && this.f5141k == s2Var && s2Var.f5040b.f4878b != 2) {
            if (s2Var.f5043e) {
                return k4.a(6);
            }
            return k4.f4389c;
        }
        return k4.a(13);
    }

    public final void p(byte[] bArr, int i3, int i4) {
        n2 n2Var;
        long jMin;
        long j3;
        long j4;
        boolean z2;
        boolean z3;
        s2 s2Var;
        o0 o0VarA;
        o0 o0VarA2;
        boolean z4;
        if (i3 == -1) {
            return;
        }
        f5127p = System.currentTimeMillis();
        synchronized (this) {
            try {
                p0 p0Var = new p0(i3, i4);
                q0 q0Var = (q0) ((LinkedHashMap) this.f5135e.f1415d).get(p0Var);
                if (q0Var != null) {
                    if (q0Var.f4878b == 1) {
                        this.f5135e.getClass();
                        p0 p0Var2 = q0Var.f4877a;
                        o0VarA = new o0(p0Var2.f4769a, p0Var2.f4770b, 0, 0, q0Var.f4881e, 0);
                    } else {
                        o0VarA = q0Var.a();
                    }
                } else if (this.n) {
                    o0VarA = q(p0Var, 5, 0, 13).a();
                } else {
                    try {
                        n2 n2VarD = n2.d(bArr);
                        int iA = n2VarD.c() ? 1 : a(n2VarD);
                        int iM = m(n2VarD);
                        if (iM == 0) {
                            try {
                                long j5 = n2VarD.f4602d;
                                o2 o2Var = this.f5137g;
                                long j6 = n2VarD.f4603e;
                                o2Var.getClass();
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                y.l lVar = n.B;
                                z3 z3Var = lVar == null ? null : (z3) lVar.f5992d;
                                if (z3Var == null || j6 <= 0) {
                                    n2Var = n2VarD;
                                } else {
                                    n2Var = n2VarD;
                                    try {
                                        long jM0 = n.m0(z3Var.f5686a, Math.max(0L, jElapsedRealtime - z3Var.f5687b));
                                        if (j6 > jM0) {
                                            j4 = j6 - jM0;
                                        }
                                        jMin = Math.min(j5, j4);
                                    } catch (Throwable unused) {
                                        jMin = -1;
                                    }
                                    j3 = jMin;
                                }
                                j4 = 0;
                                jMin = Math.min(j5, j4);
                            } catch (Throwable unused2) {
                                n2Var = n2VarD;
                            }
                            j3 = jMin;
                        } else {
                            n2Var = n2VarD;
                            j3 = 0;
                        }
                        if (iM != 0) {
                            o0VarA2 = q(p0Var, 5, iA, iM).a();
                        } else if (j3 < 0) {
                            o0VarA2 = q(p0Var, 6, iA, 4).a();
                        } else if (j3 == 0) {
                            o0VarA2 = q(p0Var, 5, iA, 15).a();
                        } else {
                            if (this.f5140j.size() + (this.f5141k == null ? 0 : 1) >= this.f5138h) {
                                o0VarA2 = q(p0Var, 5, iA, 12).a();
                            } else {
                                z2 = true;
                                q0 q0Var2 = new q0(p0Var, 1, iA);
                                ((LinkedHashMap) this.f5135e.f1415d).put(p0Var, q0Var2);
                                this.f5134d.getClass();
                                s2 s2Var2 = new s2(n2Var, q0Var2, SystemClock.uptimeMillis(), j3);
                                this.f5140j.addLast(s2Var2);
                                this.f5135e.getClass();
                                o0 o0Var = new o0(p0Var.f4769a, p0Var.f4770b, 0, 0, q0Var2.f4881e, 0);
                                z3 = this.f5141k == null;
                                s2Var = s2Var2;
                                o0VarA = o0Var;
                            }
                            r();
                        }
                        o0VarA = o0VarA2;
                        z3 = false;
                        z2 = true;
                        s2Var = null;
                        r();
                    } catch (m2 e3) {
                        o0 o0VarA3 = q(p0Var, 5, 0, e3.f4494c).a();
                        r();
                        g(o0VarA3);
                        return;
                    }
                }
                z2 = true;
                z3 = false;
                s2Var = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        g(o0VarA);
        if (s2Var != null) {
            try {
                o2 o2Var2 = this.f5136f;
                a2.h hVar = new a2.h(this, s2Var, 18);
                long j7 = s2Var.f5042d;
                o2Var2.getClass();
                ScheduledFuture<?> scheduledFutureSchedule = f5128q.schedule(hVar, Math.max(0L, j7), TimeUnit.MILLISECONDS);
                e2.g gVar = new e2.g(scheduledFutureSchedule, 2);
                synchronized (this) {
                    try {
                        if (s2Var.f5040b.f4878b == 2 || s2Var.f5044f) {
                            scheduledFutureSchedule.cancel(false);
                            z4 = s2Var.f5044f;
                        } else {
                            s2Var.f5047i = gVar;
                            z4 = z2;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable unused3) {
                h(s2Var, 6, 4);
                z4 = false;
            }
            if (!z4) {
                return;
            }
        }
        if (z3) {
            n();
        }
    }

    public final q0 q(p0 p0Var, int i3, int i4, int i5) {
        g.j jVar = this.f5135e;
        jVar.getClass();
        q0 q0Var = new q0(p0Var, 2, i4);
        q0Var.f4879c = i3;
        q0Var.f4880d = 100;
        q0Var.f4882f = i5;
        ((LinkedHashMap) jVar.f1415d).put(p0Var, q0Var);
        return q0Var;
    }

    public final void r() {
        p0 p0Var;
        g.j jVar = this.f5135e;
        LinkedHashMap linkedHashMap = (LinkedHashMap) jVar.f1415d;
        while (linkedHashMap.size() > jVar.f1413b) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    p0Var = null;
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((q0) entry.getValue()).f4878b == 2) {
                    p0Var = (p0) entry.getKey();
                    break;
                }
            }
            if (p0Var == null) {
                return;
            } else {
                linkedHashMap.remove(p0Var);
            }
        }
    }
}
