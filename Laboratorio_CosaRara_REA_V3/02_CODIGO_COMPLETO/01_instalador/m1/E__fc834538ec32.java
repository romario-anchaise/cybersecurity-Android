// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class E extends W {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3757d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f3758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3759f;
    public final InterfaceC0209m g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f3760h;

    public E(Method method, int i2, X0.n nVar, InterfaceC0209m interfaceC0209m) {
        this.f3758e = method;
        this.f3759f = i2;
        this.f3760h = nVar;
        this.g = interfaceC0209m;
    }

    @Override // m1.W
    public final void a(L l2, Object obj) {
        switch (this.f3757d) {
            case 0:
                if (obj == null) {
                    return;
                }
                try {
                    l2.c((X0.n) this.f3760h, (X0.B) this.g.p(obj));
                    return;
                } catch (IOException e2) {
                    throw W.o(this.f3758e, this.f3759f, "Unable to convert " + obj + " to RequestBody", e2);
                }
            default:
                Map map = (Map) obj;
                int i2 = this.f3759f;
                Method method = this.f3758e;
                if (map == null) {
                    throw W.o(method, i2, "Part map was null.", new Object[0]);
                }
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str == null) {
                        throw W.o(method, i2, "Part map contained null key.", new Object[0]);
                    }
                    Object value = entry.getValue();
                    if (value == null) {
                        throw W.o(method, i2, F0.h.e("Part map contained null value for key '", str, "'."), new Object[0]);
                    }
                    l2.c(f1.l.G("Content-Disposition", F0.h.e("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", (String) this.f3760h), (X0.B) this.g.p(value));
                }
                return;
        }
    }

    public E(Method method, int i2, InterfaceC0209m interfaceC0209m, String str) {
        this.f3758e = method;
        this.f3759f = i2;
        this.g = interfaceC0209m;
        this.f3760h = str;
    }
}
