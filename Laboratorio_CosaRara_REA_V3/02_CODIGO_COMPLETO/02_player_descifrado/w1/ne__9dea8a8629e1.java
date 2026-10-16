// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ne implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ cf f4662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4663e;

    public /* synthetic */ ne(cf cfVar, int i3, int i4) {
        this.f4661c = i4;
        this.f4662d = cfVar;
        this.f4663e = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = null;
        int i3 = 0;
        switch (this.f4661c) {
            case 0:
                cf cfVar = this.f4662d;
                int i4 = this.f4663e;
                cfVar.K0();
                Context context = cfVar.B0;
                if (context == null) {
                    return;
                }
                f3 f3Var = new f3(context, new oa(cfVar), new oa(cfVar), new oa(cfVar), new oe(i4, cfVar));
                cfVar.f3733v0 = f3Var;
                synchronized (f3Var.f3974j) {
                    try {
                        if (f3Var.f3976l == null) {
                            long j3 = f3Var.f3979p + 1;
                            f3Var.f3979p = j3;
                            f3Var.f3976l = new e2.g(((ScheduledThreadPoolExecutor) f3Var.f3969e.f905c).scheduleAtFixedRate(new d3(f3Var, j3, i3), 0L, 10000L, TimeUnit.MILLISECONDS), 3);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
                cf cfVar2 = this.f4662d;
                int i5 = this.f4663e;
                cfVar2.J0();
                Context context2 = cfVar2.B0;
                if (context2 == null) {
                    return;
                }
                y2.y(context2);
                q.t tVar = new q.t(context2, new oe(i5, cfVar2));
                cfVar2.f3738y = tVar;
                Handler handler = (Handler) tVar.f3079c;
                if (((AtomicBoolean) tVar.f3081e).compareAndSet(false, true)) {
                    handler.post(new x2(tVar, i3));
                    handler.postDelayed((a2.i) tVar.f3083g, 60000L);
                    return;
                }
                return;
            case 2:
                this.f4662d.F0(this.f4663e);
                return;
            case 3:
                cf cfVar3 = this.f4662d;
                int i6 = this.f4663e;
                if (cfVar3.f3706h == h2.c.f1965h || cfVar3.f3706h == h2.c.f1967j) {
                    if (cfVar3.U.f4635b || cfVar3.f3712k.get() != i6) {
                        Log.i("TunnelManager", "network grace: internet available again, skip teardown");
                        return;
                    }
                    cfVar3.T();
                    int i7 = cfVar3.f3708i.get();
                    cfVar3.f3725r.d(i7);
                    int iIncrementAndGet = cfVar3.f3708i.incrementAndGet();
                    cfVar3.f3725r.e(iIncrementAndGet);
                    cfVar3.L0(1, i7, "network_changed");
                    h2.g gVar = cfVar3.f3729t0;
                    cfVar3.f3729t0 = null;
                    cfVar3.f3694b.set(false);
                    cfVar3.f3721p = Integer.MIN_VALUE;
                    cfVar3.f3719o = Integer.MIN_VALUE;
                    h2.c cVar = cfVar3.f3706h;
                    h2.c cVar2 = h2.c.f1961d;
                    if (cVar != cVar2) {
                        cfVar3.N0(cVar2, 1, gVar);
                    }
                    cfVar3.h0(1, gVar, false, false, 0, 0L);
                    Log.i("TunnelManager", "network unusable after grace; invalidated tunnel generation=" + iIncrementAndGet);
                    return;
                }
                return;
            default:
                cf cfVar4 = this.f4662d;
                if (this.f4663e == cfVar4.f3708i.get() && cfVar4.f3694b.get() && cfVar4.f3706h == h2.c.f1965h) {
                    if ((cfVar4.f3735w0 > 0 ? Math.max(0L, SystemClock.elapsedRealtime() - cfVar4.f3735w0) : 0L) < 30000) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    d0.d dVarC = cfVar4.c();
                    if (dVarC != null && cfVar4.B0 != null) {
                        try {
                            if (k3.z(cfVar4.B0).w((String) dVarC.f532b, jCurrentTimeMillis)) {
                                cfVar4.f3707h0 = null;
                                Context context3 = cfVar4.B0;
                                AtomicBoolean atomicBoolean = i3.f4238a;
                                if (context3 != null) {
                                    applicationContext = context3.getApplicationContext();
                                }
                                if (applicationContext != null) {
                                    i3.a(applicationContext);
                                }
                            }
                        } catch (Throwable unused) {
                            Log.w("TunnelManager", "close reconnect instability episode failed");
                        }
                        break;
                    }
                    cfVar4.j("stable_online");
                    return;
                }
                return;
        }
    }
}
