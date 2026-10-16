// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.activity;

import androidx.lifecycle.AbstractC0078p;
import androidx.lifecycle.EnumC0076n;
import androidx.lifecycle.InterfaceC0080s;
import androidx.lifecycle.InterfaceC0082u;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class m implements InterfaceC0080s, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0078p f1254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.fragment.app.m f1255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f1256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o f1257d;

    public m(o oVar, AbstractC0078p abstractC0078p, androidx.fragment.app.m mVar) {
        this.f1257d = oVar;
        this.f1254a = abstractC0078p;
        this.f1255b = mVar;
        abstractC0078p.a(this);
    }

    @Override // androidx.activity.a
    public final void cancel() {
        this.f1254a.c(this);
        this.f1255b.f1561b.remove(this);
        n nVar = this.f1256c;
        if (nVar != null) {
            nVar.cancel();
            this.f1256c = null;
        }
    }

    @Override // androidx.lifecycle.InterfaceC0080s
    public final void g(InterfaceC0082u interfaceC0082u, EnumC0076n enumC0076n) {
        if (enumC0076n != EnumC0076n.ON_START) {
            if (enumC0076n != EnumC0076n.ON_STOP) {
                if (enumC0076n == EnumC0076n.ON_DESTROY) {
                    cancel();
                    return;
                }
                return;
            } else {
                n nVar = this.f1256c;
                if (nVar != null) {
                    nVar.cancel();
                    return;
                }
                return;
            }
        }
        o oVar = this.f1257d;
        ArrayDeque arrayDeque = oVar.f1261b;
        androidx.fragment.app.m mVar = this.f1255b;
        arrayDeque.add(mVar);
        n nVar2 = new n(oVar, mVar);
        mVar.f1561b.add(nVar2);
        if (p039w.b.a()) {
            oVar.b();
            mVar.f1562c = oVar.f1262c;
        }
        this.f1256c = nVar2;
    }
}
