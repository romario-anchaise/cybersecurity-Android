// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class te implements p1.a, p1.l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ cf f5206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q9 f5207d;

    public /* synthetic */ te(cf cfVar, q9 q9Var) {
        this.f5206c = cfVar;
        this.f5207d = q9Var;
    }

    @Override // p1.a
    public Object d() {
        boolean zB;
        cf cfVar = this.f5206c;
        q9 q9Var = this.f5207d;
        r9 r9Var = cfVar.S;
        synchronized (r9Var) {
            zB = r9Var.b(q9Var);
        }
        return Boolean.valueOf(zB && q9Var.f4928b == cfVar.f3708i.get() && q9Var.f4929c == cfVar.f3727s0);
    }

    @Override // p1.l
    public Object f(Object obj) {
        cf cfVar = this.f5206c;
        q9 q9Var = this.f5207d;
        e2.h1 h1Var = (e2.h1) obj;
        if ((h1Var instanceof e2.c1) && ((e2.c1) h1Var).f735e) {
            q9Var.f4932f = true;
        }
        r9 r9Var = cfVar.S;
        ba baVar = new ba(cfVar, h1Var, 12);
        synchronized (r9Var) {
            try {
                if (r9Var.b(q9Var)) {
                    q9Var.f4933g++;
                    try {
                        baVar.run();
                        synchronized (r9Var) {
                            try {
                                int i3 = q9Var.f4933g - 1;
                                q9Var.f4933g = i3;
                                if (i3 == 0) {
                                    r9Var.notifyAll();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        r9Var.a();
                    } catch (Throwable th2) {
                        synchronized (r9Var) {
                            try {
                                q9Var.f4933g--;
                                if (q9Var.f4933g == 0) {
                                    r9Var.notifyAll();
                                }
                                r9Var.a();
                                throw th2;
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        return h1.e.f1953c;
    }
}
