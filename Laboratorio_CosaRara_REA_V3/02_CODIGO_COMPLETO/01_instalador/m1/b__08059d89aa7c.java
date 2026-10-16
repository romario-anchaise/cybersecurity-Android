// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import k1.C0193i;

/* JADX INFO: renamed from: m1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0198b implements InterfaceC0209m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0198b f3833b = new C0198b(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0198b f3834c = new C0198b(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0198b f3835d = new C0198b(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0198b f3836e = new C0198b(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0198b f3837f = new C0198b(4);
    public static final C0198b g = new C0198b(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3838a;

    public /* synthetic */ C0198b(int i2) {
        this.f3838a = i2;
    }

    public List a(ExecutorC0197a executorC0197a) {
        return Collections.singletonList(new C0211o(executorC0197a));
    }

    public List b() {
        return Collections.emptyList();
    }

    public String c(Method method, int i2) {
        return "parameter #" + (i2 + 1);
    }

    public Object d(Object obj, Method method, Object[] objArr) {
        throw new AssertionError();
    }

    public boolean e(Method method) {
        return false;
    }

    @Override // m1.InterfaceC0209m
    public Object p(Object obj) {
        switch (this.f3838a) {
            case 0:
                return obj.toString();
            case 1:
                X0.G g2 = (X0.G) obj;
                try {
                    C0193i c0193i = new C0193i();
                    g2.j().g(c0193i);
                    return new X0.F(g2.f(), g2.a(), c0193i, 0);
                } finally {
                    g2.close();
                }
            case 2:
                return (X0.B) obj;
            case 3:
                return (X0.G) obj;
            case 4:
                ((X0.G) obj).close();
                return p034t0.h.f4132b;
            default:
                ((X0.G) obj).close();
                return null;
        }
    }
}
