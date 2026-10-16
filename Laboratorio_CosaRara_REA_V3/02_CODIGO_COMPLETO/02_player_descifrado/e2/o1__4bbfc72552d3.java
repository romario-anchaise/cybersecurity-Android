// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import java.util.List;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o1 implements p1.l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s1 f911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ v1 f912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q1.h f913e;

    public /* synthetic */ o1(s1 s1Var, v1 v1Var, q1.h hVar) {
        this.f911c = s1Var;
        this.f912d = v1Var;
        this.f913e = hVar;
    }

    public void a(b2 b2Var, h hVar) {
        y1 y1Var;
        boolean z2;
        h hVar2;
        s1 s1Var = this.f911c;
        v1 v1Var = this.f912d;
        q1.h hVar3 = this.f913e;
        long j3 = v1Var.f1051a;
        long j4 = hVar3.f3127c;
        List list = b2Var.f723b;
        list.getClass();
        synchronized (s1Var) {
            y1Var = (!s1Var.f997k && j3 == s1Var.f989c && j4 == s1Var.f994h) ? s1Var.f991e : null;
        }
        if (y1Var == null || list.isEmpty()) {
            hVar.f(Boolean.FALSE);
            return;
        }
        synchronized (s1Var) {
            z2 = !s1Var.f997k && j3 == s1Var.f989c && j4 == s1Var.f994h && s1Var.f991e == y1Var;
        }
        if (!z2) {
            hVar.f(Boolean.FALSE);
            return;
        }
        try {
            hVar2 = hVar;
            try {
                y1Var.c(list, new p1(s1Var, hVar2, j3, j4, y1Var));
            } catch (Throwable unused) {
                hVar2.f(Boolean.FALSE);
            }
        } catch (Throwable unused2) {
            hVar2 = hVar;
        }
    }

    @Override // p1.l
    public Object f(Object obj) {
        boolean z2;
        boolean z3;
        s1 s1Var = this.f911c;
        v1 v1Var = this.f912d;
        q1.h hVar = this.f913e;
        c2 c2Var = (c2) obj;
        c2Var.getClass();
        final long j3 = v1Var.f1051a;
        final long j4 = hVar.f3127c;
        synchronized (s1Var) {
            z2 = false;
            if (s1Var.f997k || j3 != s1Var.f989c || j4 != s1Var.f994h || s1Var.f991e == null) {
                z3 = false;
            } else {
                if (c2Var == c2.f737c) {
                    q1 q1Var = s1Var.f990d;
                    q1 q1Var2 = q1.f932e;
                    if (q1Var != q1Var2) {
                        s1Var.f990d = q1Var2;
                        z2 = true;
                    }
                }
                z3 = z2;
                z2 = true;
            }
        }
        if (z2) {
            int iOrdinal = c2Var.ordinal();
            if (iOrdinal == 0) {
                d2.t tVar = s1Var.f987a;
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) tVar.f614e;
                long j5 = tVar.f612c;
                final m1[] m1VarArr = (m1[]) tVar.f613d;
                final int i3 = 1;
                ScreenMirrorService.h(screenMirrorService, j5, new Runnable() { // from class: w1.xc
                    @Override // java.lang.Runnable
                    public final void run() {
                        e2.g gVar;
                        switch (i3) {
                            case 0:
                                e2.m1[] m1VarArr2 = m1VarArr;
                                long j6 = j3;
                                long j7 = j4;
                                boolean z4 = false;
                                e2.m1 m1Var = m1VarArr2[0];
                                if (m1Var != null) {
                                    synchronized (m1Var) {
                                        if (!m1Var.n && j6 == m1Var.f875f && m1Var.f870a.f(j6, j7)) {
                                            e2.g gVarE = m1Var.e();
                                            m1Var.f888t = e2.k0.f844g;
                                            m1Var.f889u = e2.l0.f858k;
                                            gVar = gVarE;
                                            z4 = true;
                                        } else {
                                            gVar = null;
                                        }
                                    }
                                    if (gVar != null) {
                                        gVar.a();
                                    }
                                    m1Var.f870a.b(j6, j7, "webp_publish_failed");
                                    if (z4) {
                                        m1Var.j();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            default:
                                e2.m1[] m1VarArr3 = m1VarArr;
                                long j8 = j3;
                                long j9 = j4;
                                e2.m1 m1Var2 = m1VarArr3[0];
                                if (m1Var2 != null) {
                                    m1Var2.i(j8, j9);
                                    return;
                                }
                                return;
                        }
                    }
                });
                if (z3) {
                    d2.t tVar2 = s1Var.f987a;
                    ScreenMirrorService.h((ScreenMirrorService) tVar2.f614e, tVar2.f612c, new b2.b(tVar2, j3, (m1[]) tVar2.f613d, 9));
                    d2.t tVar3 = s1Var.f987a;
                    ScreenMirrorService.h((ScreenMirrorService) tVar3.f614e, tVar3.f612c, new b2.b((m1[]) tVar3.f613d, j3, h0.f814e, 8));
                }
            } else {
                if (iOrdinal != 1) {
                    throw new h1.a();
                }
                d2.t tVar4 = s1Var.f987a;
                ScreenMirrorService screenMirrorService2 = (ScreenMirrorService) tVar4.f614e;
                long j6 = tVar4.f612c;
                final m1[] m1VarArr2 = (m1[]) tVar4.f613d;
                final int i4 = 0;
                ScreenMirrorService.h(screenMirrorService2, j6, new Runnable() { // from class: w1.xc
                    @Override // java.lang.Runnable
                    public final void run() {
                        e2.g gVar;
                        switch (i4) {
                            case 0:
                                e2.m1[] m1VarArr3 = m1VarArr2;
                                long j7 = j3;
                                long j8 = j4;
                                boolean z4 = false;
                                e2.m1 m1Var = m1VarArr3[0];
                                if (m1Var != null) {
                                    synchronized (m1Var) {
                                        if (!m1Var.n && j7 == m1Var.f875f && m1Var.f870a.f(j7, j8)) {
                                            e2.g gVarE = m1Var.e();
                                            m1Var.f888t = e2.k0.f844g;
                                            m1Var.f889u = e2.l0.f858k;
                                            gVar = gVarE;
                                            z4 = true;
                                        } else {
                                            gVar = null;
                                        }
                                    }
                                    if (gVar != null) {
                                        gVar.a();
                                    }
                                    m1Var.f870a.b(j7, j8, "webp_publish_failed");
                                    if (z4) {
                                        m1Var.j();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            default:
                                e2.m1[] m1VarArr4 = m1VarArr2;
                                long j9 = j3;
                                long j10 = j4;
                                e2.m1 m1Var2 = m1VarArr4[0];
                                if (m1Var2 != null) {
                                    m1Var2.i(j9, j10);
                                    return;
                                }
                                return;
                        }
                    }
                });
            }
        }
        return h1.e.f1953c;
    }
}
