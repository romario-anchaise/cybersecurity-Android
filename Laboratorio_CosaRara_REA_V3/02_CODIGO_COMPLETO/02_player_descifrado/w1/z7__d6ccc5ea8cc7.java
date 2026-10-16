// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z7 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d8 f5716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5717e;

    public /* synthetic */ z7(d8 d8Var, long j3, int i3) {
        this.f5715c = i3;
        this.f5716d = d8Var;
        this.f5717e = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jB;
        long j3;
        switch (this.f5715c) {
            case 0:
                d8 d8Var = this.f5716d;
                d8Var.r();
                if (this.f5717e == d8Var.f3802e && !d8Var.f3799b.isEmpty()) {
                    d8Var.d(14);
                    break;
                }
                break;
            case 1:
                this.f5716d.n(2, this.f5717e);
                break;
            case 2:
                d8 d8Var2 = this.f5716d;
                d8Var2.r();
                long j4 = d8Var2.f3802e;
                long j5 = this.f5717e;
                if (j5 == j4 && d8Var2.f3800c == 2) {
                    c2.m mVar = d8Var2.f3804g;
                    if (mVar == null || d8Var2.t(mVar)) {
                        d8Var2.f3805h = false;
                        d8Var2.f();
                        d8Var2.g();
                        d8Var2.y();
                        if (!d8Var2.v(2, j5)) {
                            d8Var2.d(4);
                        }
                    } else {
                        d2.o oVar = d8Var2.f3810m;
                        if (oVar != null) {
                            try {
                                wf.f5438a.removeCallbacks((Runnable) oVar.f603d);
                                break;
                            } catch (Throwable unused) {
                            }
                        }
                        d8Var2.f3810m = null;
                        if (!d8Var2.f3799b.isEmpty()) {
                            d8Var2.f3800c = 3;
                            d8Var2.f();
                            d8Var2.g();
                            d8Var2.y();
                            d8Var2.p();
                        } else {
                            d8Var2.x();
                        }
                    }
                } else {
                    d8Var2.f();
                    d8Var2.g();
                    d8Var2.y();
                }
                break;
            case 3:
                this.f5716d.n(8, this.f5717e);
                break;
            case 4:
                d8 d8Var3 = this.f5716d;
                d8Var3.r();
                if (d8Var3.f3800c == 8) {
                    long j6 = d8Var3.f3802e;
                    long j7 = this.f5717e;
                    if (j6 == j7) {
                        try {
                            m0 m0Var = d8Var3.f3798a;
                            long j8 = d8Var3.f3801d;
                            m0Var.getClass();
                            jB = m0.B(j8, j7);
                        } catch (Throwable unused2) {
                            jB = 0;
                        }
                        if (jB > 0) {
                            d8Var3.f3801d = jB;
                            d8Var3.y();
                            d8Var3.j();
                        } else {
                            d8Var3.q("recovery_attach_failed");
                        }
                        break;
                    }
                }
                break;
            case 5:
                d8 d8Var4 = this.f5716d;
                d8Var4.r();
                long j9 = d8Var4.f3802e;
                long j10 = this.f5717e;
                if (j10 == j9 && d8Var4.f3800c == 6) {
                    c2.m mVar2 = d8Var4.f3804g;
                    if (mVar2 != null && d8Var4.t(mVar2)) {
                        d8Var4.f3806i = false;
                        if (!d8Var4.v(6, j10)) {
                            d8Var4.d(4);
                        }
                    } else {
                        d8Var4.f3800c = 7;
                        d2.o oVar2 = d8Var4.f3810m;
                        if (oVar2 != null) {
                            try {
                                wf.f5438a.removeCallbacks((Runnable) oVar2.f603d);
                                break;
                            } catch (Throwable unused3) {
                            }
                        }
                        d8Var4.f3810m = null;
                        d2.o oVar3 = d8Var4.n;
                        if (oVar3 != null) {
                            try {
                                wf.f5438a.removeCallbacks((Runnable) oVar3.f603d);
                                break;
                            } catch (Throwable unused4) {
                            }
                        }
                        d8Var4.n = null;
                        d8Var4.f3811o = 16L;
                        d2.o oVarU = d8Var4.u(1000L, new z7(d8Var4, j10, 6));
                        d8Var4.f3810m = oVarU;
                        if (oVarU != null) {
                            try {
                                m0 m0Var2 = d8Var4.f3798a;
                                long j11 = d8Var4.f3801d;
                                m0Var2.getClass();
                                j3 = wf.j(j11, j10);
                            } catch (Throwable unused5) {
                                j3 = 0;
                            }
                            if (j3 > 0) {
                                d8Var4.f3801d = j3;
                                d8Var4.f();
                                d8Var4.g();
                                d8Var4.y();
                                d8Var4.j();
                            } else {
                                d8Var4.d(4);
                            }
                        } else {
                            d8Var4.d(4);
                        }
                    }
                    break;
                }
                break;
            case 6:
                this.f5716d.n(7, this.f5717e);
                break;
            default:
                this.f5716d.n(6, this.f5717e);
                break;
        }
    }
}
