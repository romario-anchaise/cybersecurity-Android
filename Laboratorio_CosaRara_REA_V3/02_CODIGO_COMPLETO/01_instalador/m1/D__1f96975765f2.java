// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import A.C0005e;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class D extends W {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f3755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3756f;

    public /* synthetic */ D(Method method, int i2, int i3) {
        this.f3754d = i3;
        this.f3755e = method;
        this.f3756f = i2;
    }

    @Override // m1.W
    public final void a(L l2, Object obj) {
        switch (this.f3754d) {
            case 0:
                X0.n nVar = (X0.n) obj;
                if (nVar == null) {
                    int i2 = this.f3756f;
                    throw W.o(this.f3755e, i2, "Headers parameter must not be null.", new Object[0]);
                }
                C0005e c0005e = l2.f3779f;
                c0005e.getClass();
                int size = nVar.size();
                for (int i3 = 0; i3 < size; i3++) {
                    c0005e.z(nVar.b(i3), nVar.d(i3));
                }
                return;
            default:
                if (obj != null) {
                    l2.f3776c = obj.toString();
                    return;
                } else {
                    int i4 = this.f3756f;
                    throw W.o(this.f3755e, i4, "@Url parameter is null.", new Object[0]);
                }
        }
    }
}
