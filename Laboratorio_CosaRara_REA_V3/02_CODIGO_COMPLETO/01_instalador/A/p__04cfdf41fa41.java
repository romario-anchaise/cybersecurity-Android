// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import androidx.lifecycle.EnumC0076n;
import androidx.lifecycle.InterfaceC0080s;
import androidx.lifecycle.InterfaceC0082u;

/* JADX INFO: renamed from: A.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0016p implements InterfaceC0080s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f60a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f61b;

    public /* synthetic */ C0016p(int i2, Object obj) {
        this.f60a = i2;
        this.f61b = obj;
    }

    @Override // androidx.lifecycle.InterfaceC0080s
    public final void g(InterfaceC0082u interfaceC0082u, EnumC0076n enumC0076n) {
        switch (this.f60a) {
            case 0:
                EnumC0076n enumC0076n2 = EnumC0076n.ON_DESTROY;
                r rVar = (r) this.f61b;
                if (enumC0076n != enumC0076n2) {
                    rVar.getClass();
                } else {
                    rVar.a();
                }
                break;
            default:
                Q.e eVar = (Q.e) this.f61b;
                F0.i.e(eVar, "this$0");
                if (enumC0076n == EnumC0076n.ON_START) {
                    eVar.f525f = true;
                } else if (enumC0076n == EnumC0076n.ON_STOP) {
                    eVar.f525f = false;
                }
                break;
        }
    }
}
