// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r2 extends n {
    public final /* synthetic */ s2 P;
    public final /* synthetic */ int Q;
    public final /* synthetic */ t2 R;

    public r2(t2 t2Var, s2 s2Var, int i3) {
        this.R = t2Var;
        this.P = s2Var;
        this.Q = i3;
    }

    @Override // w1.n
    public final void Y() {
        this.R.j(this.P, 6, this.Q, 11);
    }

    @Override // w1.n
    public final void Z() {
        this.R.j(this.P, 4, this.Q, 0);
    }

    @Override // w1.n
    public final void a0() {
        int i3;
        t2 t2Var = this.R;
        s2 s2Var = this.P;
        int i4 = this.Q;
        synchronized (t2Var) {
            i3 = s2Var.f5045g;
        }
        int i5 = i3 == 0 ? 5 : 6;
        if (i3 == 0) {
            i3 = 10;
        }
        t2Var.j(s2Var, i5, i4, i3);
    }

    @Override // w1.n
    public final void b0() {
        int i3;
        t2 t2Var = this.R;
        s2 s2Var = this.P;
        int i4 = this.Q;
        synchronized (t2Var) {
            i3 = s2Var.f5045g;
        }
        int i5 = i3 == 0 ? 5 : 6;
        if (i3 == 0) {
            i3 = 10;
        }
        t2Var.j(s2Var, i5, i4, i3);
    }

    @Override // w1.n
    public final void c0(int i3) {
        int i4;
        int i5;
        t2 t2Var = this.R;
        s2 s2Var = this.P;
        synchronized (t2Var) {
            i4 = s2Var.f5045g;
        }
        int i6 = i4 != 0 ? 6 : 5;
        int i7 = this.Q;
        if (i4 == 0) {
            if (i3 == 3) {
                i5 = 13;
            } else if (i3 == 2) {
                i4 = 6;
            } else {
                i5 = i3 == 4 ? 14 : 12;
            }
            i4 = i5;
        }
        t2Var.j(s2Var, i6, i7, i4);
    }

    @Override // w1.n
    public final void d0(int i3) {
        this.R.j(this.P, 5, this.Q, i3);
    }

    @Override // w1.n
    public final void e0() {
        s2 s2Var = this.P;
        t2 t2Var = this.R;
        try {
            t2Var.f5132b.g(s2Var.f5039a);
        } catch (Throwable unused) {
        }
        t2Var.j(s2Var, 6, this.Q, 14);
    }
}
