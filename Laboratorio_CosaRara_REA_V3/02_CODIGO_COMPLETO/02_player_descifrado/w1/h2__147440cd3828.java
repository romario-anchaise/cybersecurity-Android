// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h2 implements c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d2.t f4164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sc f4165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ab f4166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f4167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f4168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f2.u f4169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f2 f4170g = new f2(this, 0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f2 f4171h = new f2(this, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f4172i = new AtomicBoolean();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4173j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4174k;

    public h2(d2.t tVar, sc scVar, ab abVar, bb bbVar, bb bbVar2, f2.u uVar) {
        if (tVar == null) {
            o2.i("dispatch dependencies required");
            throw null;
        }
        this.f4164a = tVar;
        this.f4165b = scVar;
        this.f4166c = abVar;
        this.f4167d = bbVar;
        this.f4168e = bbVar2;
        this.f4169f = uVar;
    }

    public static void a(h2 h2Var, boolean z2) {
        boolean zA;
        synchronized (h2Var) {
            try {
                int i3 = h2Var.f4173j;
                if (i3 == 4 || i3 == 5) {
                    h2Var.f4174k = z2;
                    h2Var.f4173j = 6;
                    try {
                        zA = h2Var.f4165b.a(h2Var.f4171h);
                    } catch (Throwable unused) {
                        zA = false;
                    }
                    synchronized (h2Var) {
                        if (zA) {
                            try {
                                if (h2Var.f4173j != 9) {
                                    return;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (h2Var.f4173j == 6) {
                            h2Var.f4173j = 9;
                        }
                        h2Var.b();
                        d2.t tVar = h2Var.f4164a;
                        m4.a((m4) tVar.f614e, (f4) tVar.f613d, tVar.f612c, false);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b() {
        if (this.f4172i.compareAndSet(false, true)) {
            try {
                this.f4169f.run();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // w1.c4
    public final void cancel() {
        synchronized (this) {
            int i3 = this.f4173j;
            if (i3 != 8 && i3 != 9) {
                boolean z2 = true;
                boolean z3 = i3 == 2 || i3 == 3;
                boolean z4 = i3 == 3;
                if (i3 != 6) {
                    z2 = false;
                }
                this.f4173j = 9;
                if (z3) {
                    sc scVar = this.f4165b;
                    f2 f2Var = this.f4170g;
                    if (z4) {
                        sf sfVar = scVar.f5090b;
                        if (sfVar.f5107i != null) {
                            wf.b(new ba(sfVar, f2Var, 15));
                        }
                    } else {
                        scVar.f5089a.removeCallbacks(f2Var);
                    }
                }
                if (z2) {
                    sc scVar2 = this.f4165b;
                    f2 f2Var2 = this.f4171h;
                    sf sfVar2 = scVar2.f5090b;
                    if (sfVar2.f5107i != null) {
                        wf.b(new ba(sfVar2, f2Var2, 16));
                    }
                }
                b();
            }
        }
    }
}
