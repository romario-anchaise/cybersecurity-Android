// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class x0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z0 f88b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0 f89a;

    static {
        q0 o0Var;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            o0Var = new p0();
        } else {
            o0Var = i2 >= 29 ? new o0() : new m0();
        }
        f88b = o0Var.b().f91a.a().f91a.b().f91a.c();
    }

    public x0(z0 z0Var) {
        this.f89a = z0Var;
    }

    public z0 a() {
        return this.f89a;
    }

    public z0 b() {
        return this.f89a;
    }

    public z0 c() {
        return this.f89a;
    }

    public C0012l e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return n() == x0Var.n() && m() == x0Var.m() && p045z.b.a(j(), x0Var.j()) && p045z.b.a(h(), x0Var.h()) && p045z.b.a(e(), x0Var.e());
    }

    public p033t.c f(int i2) {
        return p033t.c.f4102e;
    }

    public p033t.c g() {
        return j();
    }

    public p033t.c h() {
        return p033t.c.f4102e;
    }

    public int hashCode() {
        return p045z.b.b(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e());
    }

    public p033t.c i() {
        return j();
    }

    public p033t.c j() {
        return p033t.c.f4102e;
    }

    public p033t.c k() {
        return j();
    }

    public z0 l(int i2, int i3, int i4, int i5) {
        return f88b;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public void d(View view) {
    }

    public void o(p033t.c[] cVarArr) {
    }

    public void p(z0 z0Var) {
    }

    public void q(p033t.c cVar) {
    }
}
