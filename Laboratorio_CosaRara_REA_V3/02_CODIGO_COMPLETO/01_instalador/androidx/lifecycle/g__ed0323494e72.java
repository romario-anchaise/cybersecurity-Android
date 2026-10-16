// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: androidx.lifecycle.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0069g implements InterfaceC0080s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1677a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1679c;

    public C0069g(InterfaceC0067e interfaceC0067e, InterfaceC0080s interfaceC0080s) {
        F0.i.e(interfaceC0067e, "defaultLifecycleObserver");
        this.f1678b = interfaceC0067e;
        this.f1679c = interfaceC0080s;
    }

    @Override // androidx.lifecycle.InterfaceC0080s
    public final void g(InterfaceC0082u interfaceC0082u, EnumC0076n enumC0076n) {
        switch (this.f1677a) {
            case 0:
                int i2 = AbstractC0068f.f1676a[enumC0076n.ordinal()];
                InterfaceC0067e interfaceC0067e = (InterfaceC0067e) this.f1678b;
                switch (i2) {
                    case 1:
                        interfaceC0067e.getClass();
                        break;
                    case 2:
                        interfaceC0067e.f(interfaceC0082u);
                        break;
                    case 3:
                        interfaceC0067e.b(interfaceC0082u);
                        break;
                    case 4:
                        interfaceC0067e.getClass();
                        break;
                    case 5:
                        interfaceC0067e.e(interfaceC0082u);
                        break;
                    case 6:
                        interfaceC0067e.c(interfaceC0082u);
                        break;
                    case 7:
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                }
                InterfaceC0080s interfaceC0080s = (InterfaceC0080s) this.f1679c;
                if (interfaceC0080s != null) {
                    interfaceC0080s.g(interfaceC0082u, enumC0076n);
                    return;
                }
                return;
            case 1:
                if (enumC0076n == EnumC0076n.ON_START) {
                    ((AbstractC0078p) this.f1678b).c(this);
                    ((Q.e) this.f1679c).d();
                    return;
                }
                return;
            default:
                HashMap map = ((C0064b) this.f1679c).f1669a;
                List list = (List) map.get(enumC0076n);
                InterfaceC0081t interfaceC0081t = (InterfaceC0081t) this.f1678b;
                C0064b.a(list, interfaceC0082u, enumC0076n, interfaceC0081t);
                C0064b.a((List) map.get(EnumC0076n.ON_ANY), interfaceC0082u, enumC0076n, interfaceC0081t);
                return;
        }
    }

    public C0069g(InterfaceC0081t interfaceC0081t) {
        this.f1678b = interfaceC0081t;
        C0066d c0066d = C0066d.f1673c;
        Class<?> cls = interfaceC0081t.getClass();
        C0064b c0064b = (C0064b) c0066d.f1674a.get(cls);
        this.f1679c = c0064b == null ? c0066d.a(cls, null) : c0064b;
    }

    public C0069g(Q.e eVar, AbstractC0078p abstractC0078p) {
        this.f1678b = abstractC0078p;
        this.f1679c = eVar;
    }
}
