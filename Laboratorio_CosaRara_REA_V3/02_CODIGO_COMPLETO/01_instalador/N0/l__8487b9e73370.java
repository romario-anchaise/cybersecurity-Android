// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import F0.h;
import java.io.IOException;
import p018k0.p;
import p018k0.x;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: renamed from: n0.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0230l extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0229k f3934b = new C0229k(0, new C0230l(x.f3430b));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f3935a;

    public C0230l(x xVar) {
        this.f3935a = xVar;
    }

    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        int iJ = aVar.J();
        int iB = androidx.fragment.app.y.b(iJ);
        if (iB == 5 || iB == 6) {
            return this.f3935a.a(aVar);
        }
        if (iB == 8) {
            aVar.F();
            return null;
        }
        throw new p("Expecting number, got: " + h.i(iJ) + "; at path " + aVar.v(false));
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        bVar.C((Number) obj);
    }
}
