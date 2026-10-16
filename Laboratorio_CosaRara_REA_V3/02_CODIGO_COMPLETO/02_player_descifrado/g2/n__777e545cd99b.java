// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import w1.bc;
import w1.cf;
import w1.y9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a0 f1691d;

    public /* synthetic */ n(int i3, a0 a0Var) {
        this.f1690c = i3;
        this.f1691d = a0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar;
        String str;
        g.j jVar;
        StringBuilder sb;
        switch (this.f1690c) {
            case 0:
                a0 a0Var = this.f1691d;
                if (!a0Var.f1528s.get() || a0Var.f1529t.get()) {
                    return;
                }
                a0Var.f1516h.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                y.l lVar = a0Var.f1518i;
                synchronized (lVar) {
                    e eVarK = lVar.k();
                    e eVar = (e) lVar.f5992d;
                    lVar.f5992d = eVarK;
                    cVar = eVar == null ? c.f1551e : new c(y.l.h(eVarK.f1584a, eVar.f1584a), y.l.h(eVarK.f1585b, eVar.f1585b), y.l.h(eVarK.f1586c, eVar.f1586c), y.l.h(eVarK.f1587d, eVar.f1587d));
                }
                long andSet = a0Var.J.getAndSet(jElapsedRealtime);
                if (andSet > 0 && jElapsedRealtime >= andSet) {
                    long jMax = Math.max(0L, (jElapsedRealtime - andSet) - 1000);
                    AtomicReference atomicReference = a0Var.K;
                    v vVar = new v(jMax, cVar);
                    while (true) {
                        v vVar2 = (v) atomicReference.get();
                        if (vVar.f1764a > vVar2.f1764a) {
                            while (true) {
                                if (atomicReference.compareAndSet(vVar2, vVar)) {
                                    if (jMax >= 5000) {
                                        StringBuilder sbJ = a0.a.j(jMax, "control health scheduler delayed lagMs=", " phase=");
                                        sbJ.append(((t) a0Var.M.get()).f1742c);
                                        sbJ.append(" powerIdle=");
                                        sbJ.append(a0Var.B());
                                        Log.w("SocketControlClient", sbJ.toString());
                                    }
                                } else if (atomicReference.get() != vVar2) {
                                }
                            }
                        }
                    }
                }
                h2.e eVar2 = (h2.e) a0Var.N.get();
                t tVar = (t) a0Var.M.get();
                long jA = a0.a(a0Var.L.get(), jElapsedRealtime);
                t tVar2 = t.f1740j;
                if (tVar != tVar2 && jA >= 15000 && a0Var.f1531v.compareAndSet(false, true)) {
                    Log.w("SocketControlClient", "control pre-registration stall phase=" + tVar.f1742c + " phaseAgeMs=" + jA + " registrationAttempt=" + a0Var.f1533x.get() + " socketConnected=" + a0Var.f1514g.f3425b);
                }
                if (eVar2 != null && a0Var.f1514g.f3425b && jElapsedRealtime - a0Var.F.get() >= 8000) {
                    long jIncrementAndGet = a0Var.C.incrementAndGet();
                    a0Var.F.set(jElapsedRealtime);
                    a0Var.G.set(jIncrementAndGet);
                    a0Var.j("heartbeat", a0.n(eVar2.f1982d, jIncrementAndGet, jElapsedRealtime), jIncrementAndGet, jElapsedRealtime);
                }
                long j3 = a0Var.E.get();
                if (j3 > 0 && jElapsedRealtime >= j3) {
                    long j4 = jElapsedRealtime - j3;
                    if (j4 >= 45000 && a0Var.f1530u.compareAndSet(false, true) && (jVar = a0Var.f1508d) != null) {
                        ((cf) jVar.f1415d).f3702f.execute(new bc(jVar, jVar.f1413b, (AtomicReference) jVar.f1414c, Math.max(0L, j4)));
                    }
                }
                if (j3 <= 0 || jElapsedRealtime < j3 || jElapsedRealtime - j3 < 53000) {
                    return;
                }
                long j5 = jElapsedRealtime - j3;
                if (a0Var.f1529t.compareAndSet(false, true)) {
                    a0Var.f1528s.set(false);
                    a0Var.f1516h.getClass();
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    t tVar3 = (t) a0Var.M.get();
                    if (tVar3 == t.f1739i) {
                        str = "socket.io registration timeout";
                    } else {
                        str = tVar3 == tVar2 ? "socket.io application heartbeat timeout" : "socket.io transport connect timeout";
                    }
                    IOException iOException = new IOException(str);
                    int i3 = tVar3 == tVar2 ? 3 : 2;
                    h2.g gVarQ = a0Var.Q(h2.g.l(5, iOException, a0Var.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime2 - a0Var.V), j5), jElapsedRealtime2);
                    a0Var.U = gVarQ;
                    a0Var.f(iOException);
                    a0Var.E();
                    ((AtomicBoolean) a0Var.f1520j.f5972d).set(true);
                    a0Var.f1514g.i();
                    a0Var.K();
                    g.j jVar2 = a0Var.f1508d;
                    if (jVar2 != null) {
                        ((cf) jVar2.f1415d).f3702f.execute(new y9(jVar2, jVar2.f1413b, i3, iOException, gVarQ));
                        return;
                    }
                    return;
                }
                return;
            default:
                d0 d0VarW = null;
                try {
                    try {
                        d0VarW = this.f1691d.w();
                        c0 c0Var = d0VarW.f1578k;
                        c0Var.write("event:keepalive_uninstall_reinstall\n".getBytes(StandardCharsets.UTF_8));
                        c0Var.flush();
                        Log.i("TunnelManager", "keepalive_uninstall_reinstall reported to gateway");
                        try {
                            d0VarW.close();
                            return;
                        } catch (IOException e3) {
                            e = e3;
                            sb = new StringBuilder("stream close failed: ");
                            a0.a.m(e, sb, "TunnelManager");
                            return;
                        }
                    } catch (Exception e4) {
                        Log.w("TunnelManager", "keepalive event report failed: " + e4.getMessage());
                        if (d0VarW != null) {
                            try {
                                d0VarW.close();
                                return;
                            } catch (IOException e5) {
                                e = e5;
                                sb = new StringBuilder("stream close failed: ");
                                a0.a.m(e, sb, "TunnelManager");
                                return;
                            }
                        }
                        return;
                    }
                } catch (Throwable th) {
                    if (d0VarW == null) {
                        throw th;
                    }
                    try {
                        d0VarW.close();
                        throw th;
                    } catch (IOException e6) {
                        a0.a.m(e6, new StringBuilder("stream close failed: "), "TunnelManager");
                        throw th;
                    }
                }
        }
    }
}
