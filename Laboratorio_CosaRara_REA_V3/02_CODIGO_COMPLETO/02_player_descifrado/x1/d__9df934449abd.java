// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import e2.n1;
import w1.kc;
import w1.vf;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f5847d;

    public /* synthetic */ d(g gVar, int i3) {
        this.f5846c = i3;
        this.f5847d = gVar;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003a  */
    @Override // java.lang.Runnable
    public final void run() {
        char c3;
        switch (this.f5846c) {
            case 0:
                g gVar = this.f5847d;
                long j3 = gVar.f5865j.get();
                boolean z2 = gVar.f5866k;
                boolean z3 = gVar.f5868m;
                boolean z4 = gVar.f5867l;
                if (z2 && !z3 && z4) {
                    AccessibilityNodeInfo rootInActiveWindow = null;
                    try {
                        rootInActiveWindow = gVar.f5856a.getRootInActiveWindow();
                        if (rootInActiveWindow != null && gVar.l(rootInActiveWindow)) {
                            long jUptimeMillis = SystemClock.uptimeMillis();
                            long j4 = gVar.f5872r;
                            if (j4 <= 0 || jUptimeMillis < j4 || jUptimeMillis - j4 >= 250) {
                                gVar.f5872r = jUptimeMillis;
                                if (gVar.n(j3, 80L)) {
                                    gVar.f5872r = SystemClock.uptimeMillis();
                                    Log.i("CoreProtectionGuard", "continuous poll blocked protected destructive page");
                                }
                            }
                        }
                        break;
                    } catch (Throwable th) {
                        try {
                            Log.d("CoreProtectionGuard", "continuous poll failed: " + th.getMessage());
                        } finally {
                            g.p(rootInActiveWindow);
                        }
                        break;
                    }
                    return;
                }
                return;
            default:
                g gVar2 = this.f5847d;
                long j5 = gVar2.f5865j.get();
                z1.b bVarT = gVar2.f5871q;
                if (bVarT == null || !bVarT.f6299a || gVar2.f5868m || !gVar2.f5866k) {
                    return;
                }
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                n1 n1Var = gVar2.f5858c;
                boolean z5 = gVar2.f5867l;
                n1Var.getClass();
                boolean z6 = true;
                if (bVarT.f6299a) {
                    if (jUptimeMillis2 >= bVarT.f6301c) {
                        c3 = 4;
                    } else if (jUptimeMillis2 < bVarT.f6302d) {
                        c3 = 2;
                    } else {
                        c3 = !z5 ? (char) 3 : (char) 1;
                    }
                } else if (bVarT.f6306h == 3) {
                    c3 = 4;
                } else {
                    c3 = 5;
                }
                if (c3 == 2) {
                    gVar2.s();
                    return;
                }
                if (c3 == 3) {
                    gVar2.f5858c.getClass();
                    if (bVarT.f6299a) {
                        long j6 = bVarT.f6301c;
                        bVarT = jUptimeMillis2 >= j6 ? n1.t(bVarT, 3) : new z1.b(true, bVarT.f6300b, j6, Math.min(j6, n1.r(jUptimeMillis2, 1000L)), bVarT.f6303e, bVarT.f6304f, bVarT.f6305g, 1);
                    }
                    gVar2.f5871q = bVarT;
                    gVar2.s();
                    return;
                }
                if (c3 == 4) {
                    gVar2.f5858c.getClass();
                    if (bVarT.f6299a && jUptimeMillis2 >= bVarT.f6301c) {
                        bVarT = n1.t(bVarT, 3);
                    }
                    gVar2.f5871q = bVarT;
                    return;
                }
                if (c3 != 1) {
                    return;
                }
                boolean z7 = false;
                try {
                    try {
                        kc kcVarZ = gVar2.z(null, gVar2.f5873s, gVar2.f5874t);
                        try {
                            if (gVar2.a(j5) && gVar2.f5871q == bVarT) {
                                try {
                                    if (gVar2.j(kcVarZ.f4415d)) {
                                        gVar2.f5858c.getClass();
                                        gVar2.f(kcVarZ.f4415d, bVarT.f6304f >= 2 ? 3 : 2, 4, null, j5);
                                        Log.i("CoreProtectionGuard", "poll fast blocked Samsung app-info");
                                    } else {
                                        vf vfVarK = gVar2.k((z1.k) kcVarZ.f4416e);
                                        int i3 = vfVarK.f5340b;
                                        z6 = i3 != 4;
                                        if (z6) {
                                            gVar2.f5858c.getClass();
                                            if (i3 == 0) {
                                                i3 = 4;
                                            } else if (i3 == 2 && bVarT.f6304f >= 2) {
                                                i3 = 3;
                                            }
                                            gVar2.f(kcVarZ.f4415d, i3, vfVarK.f5341c, (z1.d) vfVarK.f5344f, j5);
                                        }
                                    }
                                    kcVarZ.close();
                                    if (gVar2.a(j5) || gVar2.f5871q != bVarT) {
                                        return;
                                    }
                                    gVar2.f5871q = gVar2.f5858c.f(bVarT, SystemClock.uptimeMillis(), z6);
                                    gVar2.s();
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    Throwable th3 = th;
                                    try {
                                        kcVarZ.close();
                                        throw th3;
                                    } catch (Throwable th4) {
                                        th3.addSuppressed(th4);
                                        throw th3;
                                    }
                                }
                            }
                            kcVarZ.close();
                            return;
                        } catch (Throwable th5) {
                            th = th5;
                            z6 = false;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        z7 = z6;
                        a0.a.q(th, new StringBuilder("poll match failed: "), "CoreProtectionGuard");
                        z6 = z7;
                        if (gVar2.a(j5)) {
                            return;
                        } else {
                            return;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    a0.a.q(th, new StringBuilder("poll match failed: "), "CoreProtectionGuard");
                    z6 = z7;
                }
                break;
        }
    }
}
