// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import android.util.Log;
import androidx.work.impl.WorkDatabase;
import g2.a0;
import g2.c0;
import g2.d0;
import g2.k0;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.ScreenMirrorService;
import w1.b1;
import w1.cf;
import w1.k6;
import w1.me;
import w1.p4;
import w1.r4;
import w1.t0;
import w1.ve;
import w1.x;
import w1.ye;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f3067e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f3068f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f3069g;

    public /* synthetic */ r(Object obj, Object obj2, Object obj3, Object obj4, int i3) {
        this.f3065c = i3;
        this.f3066d = obj;
        this.f3067e = obj2;
        this.f3068f = obj3;
        this.f3069g = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        StringBuilder sb;
        boolean zCommit;
        switch (this.f3065c) {
            case 0:
                q qVar = (q) this.f3066d;
                y.c cVar = (y.c) this.f3067e;
                m2.k kVar = (m2.k) this.f3068f;
                p.u uVar = (p.u) this.f3069g;
                uVar.getClass();
                y.p pVarT = qVar.f3057c.t();
                ArrayList arrayListI = pVarT.i("connection_keep_alive");
                if (arrayListI.size() > 1) {
                    cVar.j(new p.p(new UnsupportedOperationException("Can't apply UPDATE policy to the chains of work.")));
                    return;
                }
                y.n nVar = (y.n) (arrayListI.isEmpty() ? null : arrayListI.get(0));
                if (nVar == null) {
                    kVar.d();
                    return;
                }
                String str = nVar.f5996a;
                y.o oVarH = pVarT.h(str);
                if (oVarH == null) {
                    cVar.j(new p.p(new IllegalStateException(a0.a.h("WorkSpec with ", str, ", that matches a name \"connection_keep_alive\", wasn't found"))));
                    return;
                }
                if (!oVarH.d()) {
                    cVar.j(new p.p(new UnsupportedOperationException("Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.")));
                    return;
                }
                if (nVar.f5997b == 6) {
                    pVarT.a(str);
                    kVar.d();
                    return;
                }
                y.o oVarB = y.o.b(uVar.f2866b, nVar.f5996a, 0, 0, 0L, 0, 1048574);
                try {
                    h hVar = qVar.f3060f;
                    hVar.getClass();
                    WorkDatabase workDatabase = qVar.f3057c;
                    workDatabase.getClass();
                    p.b bVar = qVar.f3056b;
                    bVar.getClass();
                    List list = qVar.f3059e;
                    list.getClass();
                    q2.c.D(hVar, workDatabase, bVar, list, oVarB, uVar.f2867c);
                    cVar.j(p.s.f2863a);
                    return;
                } catch (Throwable th) {
                    cVar.j(new p.p(th));
                    return;
                }
            case 1:
                x xVar = (x) this.f3066d;
                Runnable runnable = (Runnable) this.f3067e;
                Runnable[] runnableArr = (Runnable[]) this.f3068f;
                long[] jArr = (long[]) this.f3069g;
                synchronized (xVar.f5463c) {
                    Runnable runnable2 = runnableArr[0];
                    IdentityHashMap identityHashMap = xVar.f5472l;
                    List list2 = (List) identityHashMap.get(runnable);
                    if (list2 != null) {
                        list2.remove(runnable2);
                        if (list2.isEmpty()) {
                            identityHashMap.remove(runnable);
                        }
                    }
                    if (!xVar.f5480u && jArr[0] == xVar.f5474o) {
                        long jNanoTime = System.nanoTime();
                        try {
                            runnable.run();
                            xVar.J(xVar.f5471k, jNanoTime);
                            synchronized (xVar.f5463c) {
                                xVar.f5463c.notifyAll();
                                break;
                            }
                            return;
                        } catch (Throwable th2) {
                            try {
                                Log.e("A11yEventPipeline", "collection task failed", th2);
                                xVar.B(xVar.f5471k);
                                synchronized (obj) {
                                    return;
                                }
                            } finally {
                                xVar.J(xVar.f5471k, jNanoTime);
                                synchronized (xVar.f5463c) {
                                    xVar.f5463c.notifyAll();
                                }
                            }
                        }
                    }
                    xVar.f5463c.notifyAll();
                    return;
                }
            case 2:
                r4 r4Var = (r4) this.f3066d;
                b1 b1Var = (b1) this.f3067e;
                String str2 = (String) this.f3068f;
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f3069g;
                p4 p4VarF = b1Var.f(str2);
                if (p4VarF == null || !p4VarF.b()) {
                    return;
                }
                r4Var.e(screenMirrorService, b1Var, p4VarF);
                return;
            case 3:
                k6 k6Var = (k6) this.f3066d;
                d2.o oVar = (d2.o) this.f3067e;
                Handler handler = (Handler) this.f3068f;
                String str3 = (String) this.f3069g;
                AtomicBoolean atomicBoolean = k6Var.f4397b;
                if (atomicBoolean.get()) {
                    try {
                        oVar.h(k6Var, handler);
                        return;
                    } catch (Throwable th3) {
                        if (atomicBoolean.get()) {
                            StringBuilder sbK = a0.a.k("[", str3, "] Error: ");
                            sbK.append(th3.getMessage());
                            Log.e("P90n4iTtpm", sbK.toString(), th3);
                            return;
                        }
                        return;
                    }
                }
                return;
            case 4:
                cf cfVar = (cf) this.f3066d;
                a0 a0Var = (a0) this.f3067e;
                Context context = (Context) this.f3068f;
                Context context2 = (Context) this.f3069g;
                AtomicBoolean atomicBoolean2 = cfVar.f3696c;
                AutoCloseable autoCloseable = null;
                try {
                    try {
                        d0 d0VarW = a0Var.w();
                        c0 c0Var = d0VarW.f1578k;
                        c0Var.write(w1.n.w(t0.b(context)).concat("\n").getBytes(StandardCharsets.UTF_8));
                        c0Var.flush();
                        String strE0 = cf.e0(d0VarW);
                        if (!"ack:a11y_enabled:v1".equals(strE0)) {
                            throw new IOException("invalid a11y_enabled ACK: " + strE0);
                        }
                        try {
                            zCommit = c2.p.e(context2, "a11y_telemetry").edit().putBoolean("enabled_reported_v2", true).commit();
                        } catch (Throwable unused) {
                            zCommit = false;
                        }
                        if (!zCommit) {
                            throw new IOException("persist a11y_enabled ACK failed");
                        }
                        Log.i("TunnelManager", "a11y_enabled reported to gateway");
                        atomicBoolean2.set(false);
                        try {
                            d0VarW.close();
                            return;
                        } catch (IOException e3) {
                            e = e3;
                            sb = new StringBuilder("a11y_enabled stream close failed: ");
                            a0.a.m(e, sb, "TunnelManager");
                            return;
                        }
                    } catch (Exception e4) {
                        Log.w("TunnelManager", "a11y_enabled report failed: " + e4.getMessage());
                        if (cfVar.f3698d.compareAndSet(false, true)) {
                            cfVar.a0(5000L, new me(cfVar, context2, 1));
                        }
                        atomicBoolean2.set(false);
                        if (0 != 0) {
                            try {
                                autoCloseable.close();
                                return;
                            } catch (IOException e5) {
                                e = e5;
                                sb = new StringBuilder("a11y_enabled stream close failed: ");
                                a0.a.m(e, sb, "TunnelManager");
                                return;
                            }
                        }
                        return;
                    }
                    break;
                } catch (Throwable th4) {
                    atomicBoolean2.set(false);
                    if (0 == 0) {
                        throw th4;
                    }
                    try {
                        autoCloseable.close();
                        throw th4;
                    } catch (IOException e6) {
                        a0.a.m(e6, new StringBuilder("a11y_enabled stream close failed: "), "TunnelManager");
                        throw th4;
                    }
                }
            case 5:
                ve veVar = (ve) this.f3066d;
                k0 k0Var = (k0) this.f3067e;
                String str4 = (String) this.f3068f;
                IOException iOException = (IOException) this.f3069g;
                cf cfVar2 = veVar.f5338c;
                if (k0Var == cfVar2.D && !k0Var.C()) {
                    cfVar2.q0(k0Var);
                    Log.w("TunnelManager", "Socket.IO media disconnected reason=" + str4 + " cause=" + iOException.getClass().getSimpleName());
                    return;
                }
                return;
            default:
                ye yeVar = (ye) this.f3066d;
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f3067e;
                Network network = (Network) this.f3068f;
                NetworkCapabilities networkCapabilities = (NetworkCapabilities) this.f3069g;
                cf cfVar3 = yeVar.f5651b;
                cf.a(cfVar3, cf.b(cfVar3, connectivityManager, network, networkCapabilities));
                return;
        }
    }
}
