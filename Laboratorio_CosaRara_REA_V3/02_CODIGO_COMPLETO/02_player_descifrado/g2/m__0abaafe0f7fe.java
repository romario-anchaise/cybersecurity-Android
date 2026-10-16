// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import android.os.SystemClock;
import e2.k1;
import e2.m1;
import e2.r1;
import e2.s1;
import lyr.stable.runtime.ScreenMirrorService;
import w1.f9;
import w1.rd;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f1679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f1680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f1681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1682g;

    public /* synthetic */ m(a0 a0Var, String str, long j3, Runnable runnable) {
        this.f1678c = 0;
        this.f1681f = a0Var;
        this.f1680e = str;
        this.f1679d = j3;
        this.f1682g = runnable;
    }

    private final void a() {
        a0 a0Var = (a0) this.f1681f;
        String str = this.f1680e;
        long j3 = this.f1679d;
        Runnable runnable = (Runnable) this.f1682g;
        a0Var.f1516h.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jMax = Math.max(0L, jElapsedRealtime - j3);
        synchronized (a0Var.n) {
            try {
                if (jMax > a0Var.Z || a0Var.f1503a0.isEmpty()) {
                    a0Var.Z = jMax;
                    a0Var.f1503a0 = str;
                }
                a0Var.X = str;
                a0Var.Y = jElapsedRealtime;
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            runnable.run();
            synchronized (a0Var.n) {
                a0Var.X = "";
                a0Var.Y = -1L;
            }
        } catch (Throwable th2) {
            synchronized (a0Var.n) {
                a0Var.X = "";
                a0Var.Y = -1L;
                throw th2;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zEquals;
        switch (this.f1678c) {
            case 0:
                a();
                return;
            case 1:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f1681f;
                f9 f9Var = (f9) this.f1682g;
                long j3 = this.f1679d;
                String str = this.f1680e;
                d2.t tVar = screenMirrorService.e4;
                synchronized (tVar) {
                    zEquals = f9Var.equals((f9) tVar.f613d);
                }
                if (zEquals) {
                    screenMirrorService.Y();
                    m1 m1Var = screenMirrorService.b4;
                    if (m1Var != null) {
                        m1Var.g(j3, str, e2.l0.f853f);
                        return;
                    }
                    return;
                }
                return;
            default:
                d2.t tVar2 = (d2.t) this.f1681f;
                m1 m1Var2 = (m1) this.f1682g;
                long j4 = this.f1679d;
                String str2 = this.f1680e;
                ScreenMirrorService screenMirrorService2 = (ScreenMirrorService) tVar2.f614e;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService2.Y();
                ((ScreenMirrorService) tVar2.f614e).c4 = null;
                synchronized (m1Var2) {
                    if (!m1Var2.n && j4 == m1Var2.f875f) {
                        k1 k1VarF = m1Var2.f();
                        m1Var2.f876g = null;
                        m1Var2.k();
                        m1.c(k1VarF);
                        s1 s1Var = m1Var2.f870a;
                        synchronized (s1Var) {
                            if (!s1Var.f997k && j4 == s1Var.f989c) {
                                r1 r1VarD = s1Var.d();
                                s1Var.f989c = -1L;
                                s1Var.h(r1VarD, str2);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
        }
    }

    public /* synthetic */ m(Object obj, Object obj2, long j3, String str, int i3) {
        this.f1678c = i3;
        this.f1681f = obj;
        this.f1682g = obj2;
        this.f1679d = j3;
        this.f1680e = str;
    }
}
