// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.SystemClock;
import android.util.Log;
import androidx.work.WorkerParameters;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import d2.w;
import g2.m0;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import lyr.stable.runtime.A11yBridgeService;
import lyr.stable.runtime.ConfirmCredentialActivity;
import lyr.stable.runtime.DeviceAdminRequestActivity;
import lyr.stable.runtime.MediaProjectionRequestActivity;
import lyr.stable.runtime.engine.CompanionService;
import lyr.stable.runtime.engine.KeepAliveDreamService;
import lyr.stable.runtime.keepalive.WatchdogService;
import lyr.stable.runtime.setup.PreA11yGuideActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w1.b6;
import w1.d4;
import w1.dc;
import w1.e2;
import w1.g6;
import w1.ie;
import w1.l2;
import w1.m3;
import w1.m4;
import w1.n3;
import w1.o3;
import w1.r4;
import w1.v7;
import w1.w7;
import w1.x5;
import w1.y5;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f50c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f51d;

    public /* synthetic */ b(int i3, Object obj) {
        this.f50c = i3;
        this.f51d = obj;
    }

    private final void a() {
        l2 l2Var = (l2) this.f51d;
        while (true) {
            try {
                try {
                    byte[] bArrY = l2Var.y();
                    if (bArrY == null) {
                        l2Var.w();
                        return;
                    }
                    synchronized (l2Var.f4438e) {
                        l2Var.f4438e.write(bArrY);
                        l2Var.f4438e.flush();
                    }
                } catch (Throwable th) {
                    l2Var.w();
                    throw th;
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                l2Var.w();
                return;
            } catch (Throwable th2) {
                l2Var.w();
                l2Var.f4439f.accept(th2);
                l2Var.w();
                return;
            }
        }
    }

    private final void b() {
        o3 o3Var = (o3) this.f51d;
        synchronized (o3Var) {
            try {
                if (o3Var.f4707h) {
                    return;
                }
                o3Var.f4705f = null;
                try {
                    n3 n3VarU5 = o3Var.f4703d.f3491d.u5();
                    synchronized (o3Var) {
                        if (o3Var.f4707h) {
                            synchronized (o3Var) {
                                try {
                                    if (!o3Var.f4707h) {
                                        o3Var.d(1000L);
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            return;
                        }
                        ((m3) o3Var.f4704e.f603d).d(n3VarU5);
                        synchronized (o3Var) {
                            try {
                                if (!o3Var.f4707h) {
                                    o3Var.d(1000L);
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                } catch (Throwable unused) {
                    synchronized (o3Var) {
                        try {
                            if (!o3Var.f4707h) {
                                o3Var.d(1000L);
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    private final void c() {
        m4 m4Var = (m4) this.f51d;
        synchronized (m4Var) {
            try {
                m4Var.f4516m = null;
                if (m4Var.f4510g) {
                    return;
                }
                boolean z2 = true;
                if (m4Var.f4513j.m() < m4Var.f4520r) {
                    m4Var.l();
                    if (m4Var.f4520r != 0) {
                        z2 = false;
                    }
                } else {
                    m4Var.f4520r = 0L;
                }
                if (z2) {
                    m4Var.g();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void d() {
        r4 r4Var = (r4) this.f51d;
        synchronized (r4Var.f4983g) {
            int i3 = 0;
            try {
                r4Var.f4984h = false;
                if (r4Var.f4983g.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList(r4Var.f4983g.values());
                r4Var.f4983g.clear();
                try {
                    JSONArray jSONArray = new JSONArray();
                    int size = arrayList.size();
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        jSONArray.put((JSONObject) obj);
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("items", jSONArray);
                    r4.d("report:activity_obs:" + jSONObject.toString());
                } catch (Throwable th) {
                    a0.a.q(th, new StringBuilder("obs flush failed: "), "InjectionTrigger");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void e() {
        long j3;
        long j4;
        b6 b6VarG;
        long j5;
        boolean z2;
        boolean z3;
        boolean z4;
        g6 g6Var = (g6) this.f51d;
        synchronized (g6Var.f4082c) {
            j3 = g6Var.f4104z;
            j4 = g6Var.f4101w;
        }
        try {
            b6VarG = g6Var.f4083d.g();
        } catch (Throwable unused) {
            b6VarG = b6.f3556m;
        }
        b6 b6Var = b6VarG;
        g6Var.f4092m.incrementAndGet();
        if (!b6Var.f3560d.isEmpty()) {
            g6Var.f4094p.incrementAndGet();
        }
        g6Var.f4087h.getClass();
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j6 = jUptimeMillis < j4 ? 0L : jUptimeMillis - j4;
        AtomicLong atomicLong = g6Var.f4096r;
        long jMax = Math.max(b6Var.f3558b, j6);
        do {
            j5 = atomicLong.get();
            if (jMax <= j5) {
                break;
            }
        } while (!atomicLong.compareAndSet(j5, jMax));
        boolean z5 = !b6Var.f3560d.isEmpty() || j6 > g6Var.f4089j;
        synchronized (g6Var.f4082c) {
            try {
                d0.d dVar = g6Var.D;
                g6Var.D = null;
                g6Var.f4103y = false;
                g6Var.f4104z = Long.MIN_VALUE;
                g6Var.f4101w = 0L;
                boolean z6 = g6Var.A || j6 > g6Var.f4089j;
                if (z5) {
                    long j7 = g6Var.f4090k;
                    g6Var.f4102x = jUptimeMillis <= Long.MAX_VALUE - j7 ? jUptimeMillis + j7 : Long.MAX_VALUE;
                }
                boolean z7 = g6Var.B;
                g6Var.A = false;
                g6Var.B = false;
                if (g6Var.C) {
                    if (dVar != null) {
                        g6Var.f4095q.incrementAndGet();
                    }
                    return;
                }
                long j8 = g6Var.f4086g.f5726a.f2536r2;
                if (z6) {
                    if (!z7) {
                        g6Var.f4095q.incrementAndGet();
                    }
                    g6Var.f4098t = b6.f3556m;
                    g6Var.f4099u = j8;
                    g6Var.f4100v = jUptimeMillis;
                    z3 = dVar != null;
                    z2 = false;
                } else {
                    z2 = j3 == j8;
                    z3 = false;
                }
                if (z6 || z2) {
                    z4 = false;
                } else {
                    g6Var.f4095q.incrementAndGet();
                    if (dVar == null || dVar.f531a != j8) {
                        z4 = false;
                    } else {
                        g6Var.D = dVar;
                        z4 = true;
                        g6Var.f4103y = true;
                        g6Var.f4104z = j8;
                        g6Var.f4087h.getClass();
                        g6Var.f4101w = SystemClock.uptimeMillis();
                        g6Var.A = false;
                        g6Var.B = false;
                    }
                    dVar = null;
                }
                if (z2) {
                    g6Var.f4098t = b6Var;
                    g6Var.f4099u = j3;
                    g6Var.f4087h.getClass();
                    g6Var.f4100v = SystemClock.uptimeMillis();
                }
                if (!z4) {
                    if (z3 && dVar != null) {
                        g6Var.d(dVar, b6.f3556m);
                        return;
                    }
                    if (z2 && dVar != null) {
                        g6Var.d(dVar, b6Var);
                        return;
                    } else {
                        if (dVar != null) {
                            g6Var.f4095q.incrementAndGet();
                            return;
                        }
                        return;
                    }
                }
                try {
                    g6Var.f4084e.f3875c.execute(new b(25, g6Var));
                } catch (Throwable unused2) {
                    synchronized (g6Var.f4082c) {
                        try {
                            g6Var.f4103y = false;
                            g6Var.f4104z = Long.MIN_VALUE;
                            g6Var.f4101w = 0L;
                            g6Var.A = false;
                            g6Var.B = false;
                            if (g6Var.D != null) {
                                g6Var.f4095q.incrementAndGet();
                            }
                            g6Var.D = null;
                            g6Var.f4093o.incrementAndGet();
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

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        w wVar;
        boolean z2;
        String str;
        e2.a aVarJ;
        w1.o oVar;
        StringBuilder sb;
        int i3 = 1;
        int i4 = 0;
        switch (this.f50c) {
            case 0:
                CompanionService companionService = (CompanionService) this.f51d;
                int i5 = CompanionService.f2584d;
                CompanionService.d(companionService.getApplicationContext(), false, 0L);
                return;
            case 1:
                KeepAliveDreamService keepAliveDreamService = (KeepAliveDreamService) this.f51d;
                if (KeepAliveDreamService.f2603d.get() != keepAliveDreamService) {
                    return;
                }
                try {
                    keepAliveDreamService.wakeUp();
                    Log.i("KeepAliveDream", "event=remote_wake requested=true");
                    return;
                } catch (Throwable unused) {
                    return;
                }
            case 2:
                v vVar = (v) this.f51d;
                vVar.f147d = false;
                ServiceConnection[] serviceConnectionArr = vVar.f146c;
                if (r.k(vVar)) {
                    vVar.f();
                    Log.i("TrioKeepAlive", "peer bind suppressed by mesh fuse");
                    return;
                }
                Class[] clsArrA = vVar.a();
                while (i4 < clsArrA.length) {
                    serviceConnectionArr[i4] = new u(vVar);
                    try {
                        vVar.bindService(new Intent(vVar, (Class<?>) clsArrA[i4]), serviceConnectionArr[i4], 9);
                    } catch (Throwable th) {
                        Log.w("TrioKeepAlive", "bind " + clsArrA[i4].getSimpleName() + " failed: " + th.getMessage());
                        serviceConnectionArr[i4] = null;
                    }
                    i4++;
                }
                return;
            case 3:
                ((b2.g) this.f51d).t();
                return;
            case 4:
                ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.f51d;
                if (constraintTrackingWorker.f245h.f32c instanceof a0.b) {
                    return;
                }
                Object obj = constraintTrackingWorker.f2851b.f207b.f2843a.get("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
                String str2 = obj instanceof String ? (String) obj : null;
                p.m mVarD = p.m.d();
                mVarD.getClass();
                if (str2 == null || str2.length() == 0) {
                    mVarD.b(c0.a.f396a, "No worker to delegate to.");
                    a0.l lVar = constraintTrackingWorker.f245h;
                    lVar.getClass();
                    lVar.i(new p.h());
                    return;
                }
                p.v vVar2 = constraintTrackingWorker.f2851b.f209d;
                Context context = constraintTrackingWorker.f2850a;
                WorkerParameters workerParameters = constraintTrackingWorker.f242e;
                vVar2.getClass();
                p.l lVarA = p.v.a(context, str2, workerParameters);
                constraintTrackingWorker.f246i = lVarA;
                if (lVarA == null) {
                    mVarD.a(c0.a.f396a, "No worker to delegate to.");
                    a0.l lVar2 = constraintTrackingWorker.f245h;
                    lVar2.getClass();
                    lVar2.i(new p.h());
                    return;
                }
                q.q qVarA = q.q.a(constraintTrackingWorker.f2850a);
                y.p pVarT = qVarA.f3057c.t();
                String string = constraintTrackingWorker.f2851b.f206a.toString();
                string.getClass();
                y.o oVarH = pVarT.h(string);
                if (oVarH == null) {
                    a0.l lVar3 = constraintTrackingWorker.f245h;
                    lVar3.getClass();
                    String str3 = c0.a.f396a;
                    lVar3.i(new p.h());
                    return;
                }
                y.i iVar = qVarA.f3064j;
                iVar.getClass();
                y.m mVar = new y.m(iVar, constraintTrackingWorker);
                mVar.r(m0.a.k(oVarH));
                String string2 = constraintTrackingWorker.f2851b.f206a.toString();
                string2.getClass();
                if (!mVar.b(string2)) {
                    mVarD.a(c0.a.f396a, "Constraints not met for delegate " + str2 + ". Requesting retry.");
                    a0.l lVar4 = constraintTrackingWorker.f245h;
                    lVar4.getClass();
                    lVar4.i(new p.i());
                    return;
                }
                mVarD.a(c0.a.f396a, "Constraints met for delegate ".concat(str2));
                try {
                    p.l lVar5 = constraintTrackingWorker.f246i;
                    lVar5.getClass();
                    a0.l lVarE = lVar5.e();
                    lVarE.getClass();
                    lVarE.b(new h(constraintTrackingWorker, lVarE, i3), constraintTrackingWorker.f2851b.f208c);
                    return;
                } catch (Throwable th2) {
                    String str4 = c0.a.f396a;
                    String strH = a0.a.h("Delegated worker ", str2, " threw exception in startWork.");
                    if (mVarD.f2856a <= 3) {
                        Log.d(str4, strH, th2);
                    }
                    synchronized (constraintTrackingWorker.f243f) {
                        try {
                            if (!constraintTrackingWorker.f244g) {
                                a0.l lVar6 = constraintTrackingWorker.f245h;
                                lVar6.getClass();
                                lVar6.i(new p.h());
                                return;
                            } else {
                                mVarD.a(str4, "Constraints were unmet, Retrying.");
                                a0.l lVar7 = constraintTrackingWorker.f245h;
                                lVar7.getClass();
                                lVar7.i(new p.i());
                                return;
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            case 5:
                WatchdogService watchdogService = (WatchdogService) this.f51d;
                boolean z3 = WatchdogService.f2639e;
                if (WatchdogService.f2639e) {
                    try {
                        watchdogService.c();
                        return;
                    } catch (Throwable th4) {
                        a0.a.p(th4, new StringBuilder("tick failed: "), "Watchdog");
                        return;
                    }
                }
                return;
            case 6:
                d2.g gVar = (d2.g) this.f51d;
                ArrayList arrayList = new ArrayList(gVar.f566g);
                long jNanoTime = System.nanoTime() + gVar.f568i;
                d2.e eVarD = null;
                while (true) {
                    try {
                        if (gVar.f580v && gVar.f565f.isEmpty()) {
                            gVar.d();
                            gVar.w(eVarD, null);
                            gVar.y(null, 0L);
                            synchronized (gVar) {
                                gVar.f581w = true;
                                gVar.notifyAll();
                                break;
                            }
                            if (gVar.f572m.a()) {
                                gVar.F();
                                return;
                            }
                            return;
                        }
                        try {
                            wVar = (w) gVar.f565f.poll(Math.min(gVar.f567h, Math.max(0L, jNanoTime - System.nanoTime())), TimeUnit.NANOSECONDS);
                        } catch (InterruptedException unused2) {
                            wVar = null;
                        }
                        if (wVar != null) {
                            ArrayBlockingQueue arrayBlockingQueue = gVar.f565f;
                            int i6 = gVar.f566g;
                            arrayList.clear();
                            arrayList.add(wVar);
                            arrayBlockingQueue.drainTo(arrayList, i6 - 1);
                        }
                        int size = arrayList.size();
                        int i7 = 0;
                        while (i7 < size) {
                            int i8 = i7 + 1;
                            w wVar2 = (w) arrayList.get(i7);
                            String string3 = Instant.ofEpochMilli(wVar2.f634b).plusSeconds(((long) wVar2.f635c) * 60).atZone(ZoneOffset.UTC).toLocalDate().toString();
                            String str5 = gVar.f584z.f546a;
                            if (!string3.equals(str5)) {
                                boolean z4 = str5 != null;
                                gVar.d();
                                gVar.w(eVarD, null);
                                if (z4) {
                                    try {
                                        gVar.f572m.b(string3);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        eVarD = null;
                                        gVar.d();
                                        gVar.w(eVarD, null);
                                        gVar.y(null, 0L);
                                        synchronized (gVar) {
                                            gVar.f581w = true;
                                            gVar.notifyAll();
                                            break;
                                        }
                                        if (gVar.f572m.a()) {
                                            gVar.F();
                                        }
                                        throw th;
                                    }
                                }
                                eVarD = gVar.D(string3);
                                if (eVarD == null) {
                                    string3 = null;
                                }
                                gVar.y(string3, eVarD == null ? 0L : eVarD.f554e);
                            }
                            if (eVarD != null) {
                                try {
                                    eVarD.f553d.write(wVar2.a().toString().getBytes(StandardCharsets.UTF_8));
                                    eVarD.f553d.write(10);
                                    eVarD.f555f++;
                                } catch (IOException | JSONException e3) {
                                    IOException iOException = e3 instanceof IOException ? (IOException) e3 : new IOException("encode keylog record", e3);
                                    gVar.d();
                                    gVar.w(eVarD, iOException);
                                    gVar.y(null, 0L);
                                    eVarD = null;
                                }
                            }
                            i7 = i8;
                            break;
                        }
                        arrayList.clear();
                        if (System.nanoTime() >= jNanoTime) {
                            if (eVarD != null) {
                                try {
                                    gVar.A(eVarD);
                                } catch (IOException e4) {
                                    gVar.d();
                                    gVar.w(eVarD, e4);
                                    gVar.y(null, 0L);
                                    eVarD = null;
                                }
                            }
                            jNanoTime = System.nanoTime() + gVar.f568i;
                            break;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                    break;
                }
                break;
            case 7:
                d2.f fVar = (d2.f) this.f51d;
                while (true) {
                    try {
                        synchronized (fVar.f559d) {
                            while (true) {
                                z2 = fVar.f557b;
                                if (!z2 && !fVar.f558c) {
                                    try {
                                        Object obj2 = fVar.f559d;
                                        d2.g gVar2 = (d2.g) fVar.f561f;
                                        Clock clock = gVar2.f563d;
                                        gVar2.f570k.getClass();
                                        obj2.wait(d2.g.B(clock, ZoneId.systemDefault()));
                                        break;
                                    } catch (InterruptedException unused3) {
                                    }
                                    if (!fVar.f557b && !fVar.f558c) {
                                        fVar.f557b = true;
                                    }
                                }
                            }
                            if (fVar.f558c && !z2) {
                                ((d2.g) fVar.f561f).F();
                                return;
                            } else {
                                fVar.f557b = false;
                                str = fVar.f556a;
                            }
                            ((d2.g) fVar.f561f).F();
                            throw th;
                        }
                        try {
                            ((d2.g) fVar.f561f).f571l.f(str);
                        } catch (Throwable th7) {
                            ((d2.g) fVar.f561f).E(th7);
                        }
                    } catch (Throwable th8) {
                        ((d2.g) fVar.f561f).F();
                        throw th8;
                    }
                }
                break;
            case 8:
                d2.s sVar = (d2.s) this.f51d;
                while (true) {
                    try {
                        Runnable runnable = (Runnable) sVar.f609a.take();
                        if (runnable == d2.s.f608d) {
                            return;
                        } else {
                            runnable.run();
                        }
                    } catch (InterruptedException | RuntimeException unused4) {
                    }
                }
                break;
            case 9:
                e2.s sVar2 = (e2.s) this.f51d;
                synchronized (sVar2.f968h) {
                    aVarJ = sVar2.j(true);
                }
                sVar2.e(aVarJ);
                return;
            case 10:
                ((p1.a) this.f51d).d();
                return;
            case 11:
                ((PreA11yGuideActivity) this.f51d).finish();
                return;
            case 12:
                A11yBridgeService a11yBridgeService = (A11yBridgeService) this.f51d;
                ArrayDeque arrayDeque = a11yBridgeService.f2431a;
                a11yBridgeService.f2434d = false;
                if (a11yBridgeService.f2432b == null || arrayDeque.isEmpty()) {
                    return;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                int size2 = arrayDeque.size();
                while (i4 < size2) {
                    w1.p pVar = (w1.p) arrayDeque.removeFirst();
                    if (jElapsedRealtime - pVar.f4768c > 30000) {
                        Log.w("A11yBridgeService", "expired command waiting for accessibility what=" + pVar.f4766a);
                    } else if (!a11yBridgeService.a(pVar)) {
                        arrayDeque.addLast(pVar);
                    }
                    i4++;
                }
                if (arrayDeque.isEmpty() || a11yBridgeService.f2434d || (oVar = a11yBridgeService.f2432b) == null) {
                    return;
                }
                a11yBridgeService.f2434d = true;
                oVar.postDelayed(new b(12, a11yBridgeService), 250L);
                return;
            case 13:
                ((e2) this.f51d).u();
                return;
            case 14:
                d2.t tVar = (d2.t) ((y.e) this.f51d).f5976c;
                try {
                    ((m0) tVar.f613d).close();
                    break;
                } catch (IOException unused5) {
                }
                try {
                    ((ie) tVar.f614e).run();
                    return;
                } catch (Throwable unused6) {
                    return;
                }
            case 15:
                ConfirmCredentialActivity confirmCredentialActivity = (ConfirmCredentialActivity) this.f51d;
                int i9 = ConfirmCredentialActivity.f2442d;
                ConfirmCredentialActivity.f2441c = -1500L;
                if (confirmCredentialActivity.f2443a != null && confirmCredentialActivity.f2444b) {
                    w1.m mVar2 = confirmCredentialActivity.f2443a;
                    mVar2.getClass();
                    mVar2.f(5, w1.n.r());
                    confirmCredentialActivity.f2444b = false;
                }
                if (confirmCredentialActivity.isFinishing()) {
                    return;
                }
                confirmCredentialActivity.finish();
                return;
            case 16:
                a();
                return;
            case 17:
                f2.a aVar = (f2.a) this.f51d;
                String str6 = (String) aVar.f1115a;
                String str7 = (String) aVar.f1116b;
                String str8 = (String) aVar.f1117c;
                aVar.f1115a = "";
                aVar.f1116b = "";
                aVar.c(str6, str7, str8);
                return;
            case 18:
                ((DeviceAdminRequestActivity) this.f51d).finish();
                return;
            case 19:
                b();
                return;
            case 20:
                c();
                return;
            case 21:
                ((d4) this.f51d).b();
                return;
            case 22:
                d();
                return;
            case 23:
                ((y5) this.f51d).b();
                return;
            case 24:
                x5 x5Var = (x5) this.f51d;
                x5Var.f5496d.clear();
                x5Var.invalidate();
                return;
            case 25:
                e();
                return;
            case 26:
                MediaProjectionRequestActivity mediaProjectionRequestActivity = (MediaProjectionRequestActivity) this.f51d;
                int i10 = MediaProjectionRequestActivity.f2448d;
                mediaProjectionRequestActivity.finish();
                mediaProjectionRequestActivity.overridePendingTransition(0, 0);
                return;
            case 27:
                for (v7 v7Var : ((w7) this.f51d).f5405e) {
                    if (v7Var.f()) {
                        v7Var.e();
                    } else {
                        v7Var.a();
                    }
                }
                return;
            case 28:
                v7 v7Var2 = (v7) this.f51d;
                try {
                    byte[] bArr = new byte[4];
                    while (v7Var2.f5317k.f5402b.get() && !v7Var2.f5316j) {
                        v7Var2.f5312f.readFully(bArr);
                        if (bArr[0] == 78 && bArr[1] == 79 && bArr[2] == 84 && bArr[3] == 49) {
                            int i11 = v7Var2.f5312f.readByte() & 255;
                            int i12 = v7Var2.f5312f.readInt();
                            if (i12 >= 0 && i12 <= 1000000) {
                                byte[] bArr2 = new byte[i12];
                                if (i12 > 0) {
                                    v7Var2.f5312f.readFully(bArr2);
                                }
                                v7Var2.c(i11, bArr2);
                            }
                            Log.w("MirrorNotifSrv", "bad payload len: " + i12);
                        } else {
                            Log.w("MirrorNotifSrv", "bad magic from PC: " + new String(bArr));
                        }
                        sb = new StringBuilder("Notif client reader exit, peer=");
                        sb.append(v7Var2.f5307a);
                        String string4 = sb.toString();
                        return;
                    }
                    sb = new StringBuilder("Notif client reader exit, peer=");
                } catch (IOException unused7) {
                    sb = new StringBuilder("Notif client reader exit, peer=");
                } finally {
                    Log.i("MirrorNotifSrv", "Notif client reader exit, peer=" + v7Var2.f5307a);
                    v7Var2.a();
                    v7Var2.f5317k.f5405e.remove(v7Var2);
                }
                sb.append(v7Var2.f5307a);
                String string5 = sb.toString();
                return;
            default:
                f2.a aVar2 = (f2.a) this.f51d;
                ((ArrayList) aVar2.f1121g).clear();
                int i13 = 0;
                while (true) {
                    boolean[] zArr = (boolean[]) aVar2.f1120f;
                    if (i13 >= zArr.length) {
                        ((dc) aVar2.f1116b).f3821a.Z0.removeCallbacks((b) aVar2.f1119e);
                        return;
                    } else {
                        zArr[i13] = false;
                        i13++;
                    }
                }
                break;
        }
    }
}
