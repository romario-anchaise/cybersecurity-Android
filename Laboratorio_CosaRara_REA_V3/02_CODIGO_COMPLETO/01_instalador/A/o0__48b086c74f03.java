// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public class o0 extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowInsets.Builder f59a;

    public o0() {
        this.f59a = n0.e();
    }

    @Override // A.q0
    public z0 b() {
        a();
        z0 z0VarC = z0.c(this.f59a.build(), null);
        z0VarC.f91a.o(null);
        return z0VarC;
    }

    @Override // A.q0
    public void c(p033t.c cVar) {
        this.f59a.setStableInsets(cVar.c());
    }

    @Override // A.q0
    public void d(p033t.c cVar) {
        this.f59a.setSystemWindowInsets(cVar.c());
    }

    public o0(z0 z0Var) {
        WindowInsets.Builder builderE;
        super(z0Var);
        WindowInsets windowInsetsB = z0Var.b();
        if (windowInsetsB != null) {
            builderE = n0.f(windowInsetsB);
        } else {
            builderE = n0.e();
        }
        this.f59a = builderE;
    }
}
