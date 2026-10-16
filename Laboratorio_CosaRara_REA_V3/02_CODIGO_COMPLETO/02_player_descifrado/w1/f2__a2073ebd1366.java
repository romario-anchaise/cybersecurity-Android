// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f2 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h2 f3963d;

    public /* synthetic */ f2(h2 h2Var, int i3) {
        this.f3962c = i3;
        this.f3963d = h2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zE;
        switch (this.f3962c) {
            case 0:
                h2 h2Var = this.f3963d;
                synchronized (h2Var) {
                    try {
                        int i3 = h2Var.f4173j;
                        if (i3 == 1 || i3 == 2 || i3 == 3) {
                            h2Var.f4173j = 4;
                            try {
                                zE = h2Var.f4164a.e(new g2(0, h2Var));
                                break;
                            } catch (Throwable unused) {
                                zE = false;
                            }
                            synchronized (h2Var) {
                                try {
                                    if (h2Var.f4173j == 4) {
                                        h2Var.f4173j = zE ? 5 : 9;
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                                break;
                            }
                            if (zE) {
                                return;
                            }
                            h2Var.b();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            default:
                h2 h2Var2 = this.f3963d;
                synchronized (h2Var2) {
                    try {
                        if (h2Var2.f4173j != 6) {
                            return;
                        }
                        boolean z2 = h2Var2.f4174k;
                        h2Var2.f4173j = 7;
                        h2Var2.b();
                        d2.t tVar = h2Var2.f4164a;
                        boolean zA = z2 ? m4.a((m4) tVar.f614e, (f4) tVar.f613d, tVar.f612c, true) : m4.a((m4) tVar.f614e, (f4) tVar.f613d, tVar.f612c, false);
                        synchronized (h2Var2) {
                            try {
                                if (h2Var2.f4173j != 9) {
                                    h2Var2.f4173j = 8;
                                }
                            } catch (Throwable th3) {
                                throw th3;
                            }
                            break;
                        }
                        if (zA) {
                            Runnable runnable = z2 ? h2Var2.f4167d : h2Var2.f4168e;
                            if (runnable != null) {
                                runnable.run();
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
        }
    }
}
