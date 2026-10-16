// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class le implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f4476f;

    public /* synthetic */ le(Object obj, int i3, int i4, int i5) {
        this.f4473c = i5;
        this.f4476f = obj;
        this.f4474d = i3;
        this.f4475e = i4;
    }

    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d6  */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4473c) {
            case 0:
                cf cfVar = (cf) this.f4476f;
                int i3 = this.f4474d;
                int i4 = this.f4475e;
                if (i3 == cfVar.n && i4 == cfVar.f3712k.get()) {
                    cfVar.J("network_changed", false);
                    return;
                }
                return;
            case 1:
                x1.g gVar = (x1.g) this.f4476f;
                int i5 = this.f4474d;
                int i6 = this.f4475e;
                long j3 = gVar.f5865j.get();
                if (i5 != gVar.f5864i.get() || !gVar.f5866k || gVar.f5868m || !gVar.f5867l) {
                    if (i5 == gVar.f5864i.get()) {
                        gVar.f5863h.set(false);
                        return;
                    }
                    return;
                }
                String str = gVar.f5875u;
                String str2 = gVar.f5876v;
                try {
                    kc kcVarZ = gVar.z(null, str, str2);
                    try {
                        if (gVar.j(kcVarZ.f4415d)) {
                            gVar.c();
                            gVar.f5873s = str;
                            gVar.f5874t = str2;
                            gVar.n(j3, 0L);
                            if (gVar.a(j3)) {
                                gVar.b(j3);
                            }
                            Log.i("CoreProtectionGuard", "settle fast blocked Samsung app-info attempt=" + i6);
                        } else {
                            vf vfVarK = gVar.k((z1.k) kcVarZ.f4416e);
                            if (!(vfVarK.f5340b != 4)) {
                                kcVarZ.close();
                                if (i5 == gVar.f5864i.get() && i6 < 32) {
                                    gVar.t(i5, i6 + 1, j3);
                                    return;
                                } else {
                                    if (i5 == gVar.f5864i.get()) {
                                        gVar.f5863h.set(false);
                                        return;
                                    }
                                    return;
                                }
                            }
                            gVar.c();
                            gVar.f5873s = str;
                            gVar.f5874t = str2;
                            gVar.g(kcVarZ.f4415d, vfVarK.f5340b, vfVarK.f5341c, (z1.d) vfVarK.f5344f, true, j3);
                            if (gVar.a(j3)) {
                                gVar.b(j3);
                            }
                            Log.i("CoreProtectionGuard", "settle blocked page=" + j4.k(vfVarK.f5339a) + " signal=" + j4.e(vfVarK.f5342d) + " identity=" + j4.f(vfVarK.f5343e) + " attempt=" + i6);
                        }
                        kcVarZ.close();
                        return;
                    } catch (Throwable th) {
                        try {
                            kcVarZ.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    a0.a.q(th3, new StringBuilder("settle match failed: "), "CoreProtectionGuard");
                    if (i5 == gVar.f5864i.get()) {
                        gVar.f5863h.set(false);
                        return;
                    }
                    return;
                }
            default:
                y1.f fVar = (y1.f) this.f4476f;
                int i7 = this.f4474d;
                int i8 = this.f4475e;
                if (i7 != fVar.f6152k.get() || !y.f.i(fVar.n, fVar.f6155o, fVar.f6156p, fVar.e())) {
                    if (i7 == fVar.f6152k.get()) {
                        fVar.f6151j.set(false);
                        return;
                    }
                    return;
                }
                try {
                    y1.d dVarC = fVar.c(null, false);
                    try {
                        dVarC.w();
                        y1.a aVarC = y1.j.c(dVarC.f6139f, fVar.f6154m);
                        if (!(aVarC.f6123a != 1)) {
                            dVarC.close();
                            if (i8 < 8 && i7 == fVar.f6152k.get()) {
                                int i9 = i8 + 1;
                                fVar.f6144c.postDelayed(new le(fVar, i7, i9, 2), ((long) i9) * 16);
                                return;
                            } else {
                                if (i7 == fVar.f6152k.get()) {
                                    fVar.f6151j.set(false);
                                    return;
                                }
                                return;
                            }
                        }
                        fVar.a();
                        fVar.h(aVarC.f6123a);
                        Log.i("A11ySelfDefense", "settle defense page=" + j4.j(aVarC.f6123a) + " action=" + j4.i(fVar.d(dVarC, aVarC)) + " attempt=" + i8);
                        fVar.f6146e.a(aVarC.f6123a);
                        dVarC.close();
                        return;
                    } catch (Throwable th4) {
                        try {
                            dVarC.close();
                            throw th4;
                        } catch (Throwable th5) {
                            th4.addSuppressed(th5);
                            throw th4;
                        }
                    }
                } catch (Throwable th6) {
                    a0.a.q(th6, new StringBuilder("settle inspection failed: "), "A11ySelfDefense");
                    if (i7 == fVar.f6152k.get()) {
                        fVar.f6151j.set(false);
                        return;
                    }
                    return;
                }
                a0.a.q(th6, new StringBuilder("settle inspection failed: "), "A11ySelfDefense");
                if (i7 == fVar.f6152k.get()) {
                    fVar.f6151j.set(false);
                    return;
                }
                return;
        }
    }
}
