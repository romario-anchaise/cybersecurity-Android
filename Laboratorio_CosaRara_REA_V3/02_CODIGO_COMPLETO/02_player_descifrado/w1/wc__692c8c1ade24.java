// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wc implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e2.m1[] f5432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5433e;

    public /* synthetic */ wc(e2.m1[] m1VarArr, long j3) {
        this.f5431c = 1;
        this.f5432d = m1VarArr;
        this.f5433e = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e2.g gVar;
        switch (this.f5431c) {
            case 0:
                long j3 = this.f5433e;
                e2.m1[] m1VarArr = this.f5432d;
                Log.i("ScreenMirror", "RTC projection grant required generation=" + j3);
                e2.m1 m1Var = m1VarArr[0];
                if (m1Var != null) {
                    m1Var.a(j3, e2.l0.f851d, e2.i0.f820e);
                    return;
                }
                return;
            case 1:
                e2.m1[] m1VarArr2 = this.f5432d;
                long j4 = this.f5433e;
                boolean z2 = false;
                e2.m1 m1Var2 = m1VarArr2[0];
                if (m1Var2 != null) {
                    synchronized (m1Var2) {
                        gVar = null;
                        if (!m1Var2.n && j4 == m1Var2.f875f) {
                            e2.g gVarE = m1Var2.e();
                            m1Var2.f885q = e2.h0.f815f;
                            m1Var2.f886r = null;
                            m1Var2.f888t = e2.k0.f844g;
                            m1Var2.f889u = e2.l0.f856i;
                            m1Var2.f890v = e2.i0.f819d;
                            m1Var2.f892x = null;
                            gVar = gVarE;
                            z2 = true;
                        }
                    }
                    if (gVar != null) {
                        gVar.a();
                    }
                    if (z2) {
                        m1Var2.j();
                        return;
                    }
                    return;
                }
                return;
            default:
                long j5 = this.f5433e;
                e2.m1[] m1VarArr3 = this.f5432d;
                Log.w("ScreenMirror", "RTC active projection stopped generation=" + j5);
                e2.m1 m1Var3 = m1VarArr3[0];
                if (m1Var3 != null) {
                    m1Var3.a(j5, e2.l0.f855h, e2.i0.f819d);
                    return;
                }
                return;
        }
    }

    public /* synthetic */ wc(long j3, e2.m1[] m1VarArr, int i3) {
        this.f5431c = i3;
        this.f5433e = j3;
        this.f5432d = m1VarArr;
    }
}
