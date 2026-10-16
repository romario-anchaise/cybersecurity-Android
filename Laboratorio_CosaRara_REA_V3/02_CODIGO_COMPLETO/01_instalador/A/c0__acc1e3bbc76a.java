// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends p044y0.g implements E0.p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f30c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f31d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f32e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(View view, p040w0.d dVar) {
        super(dVar);
        this.f32e = view;
    }

    @Override // p044y0.a
    public final p040w0.d a(Object obj, p040w0.d dVar) {
        c0 c0Var = new c0(this.f32e, dVar);
        c0Var.f31d = obj;
        return c0Var;
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) {
        return ((c0) a((L0.d) obj, (p040w0.d) obj2)).f(p034t0.h.f4132b);
    }

    @Override // p044y0.a
    public final Object f(Object obj) {
        Object obj2;
        p042x0.a aVar = p042x0.a.f4189a;
        int i2 = this.f30c;
        View view = this.f32e;
        if (i2 == 0) {
            p029q.j.o(obj);
            L0.d dVar = (L0.d) this.f31d;
            this.f31d = dVar;
            this.f30c = 1;
            dVar.f348b = view;
            dVar.f347a = 3;
            dVar.f350d = this;
            return aVar;
        }
        p034t0.h hVar = p034t0.h.f4132b;
        if (i2 == 1) {
            L0.d dVar2 = (L0.d) this.f31d;
            p029q.j.o(obj);
            if (view instanceof ViewGroup) {
                b0 b0Var = new b0((ViewGroup) view, null);
                this.f31d = null;
                this.f30c = 2;
                dVar2.getClass();
                L0.d dVar3 = new L0.d();
                dVar3.f350d = b0Var.a(dVar3, dVar3);
                if (dVar3.hasNext()) {
                    dVar2.f349c = dVar3;
                    dVar2.f347a = 2;
                    dVar2.f350d = this;
                    obj2 = aVar;
                } else {
                    obj2 = hVar;
                }
                if (obj2 != aVar) {
                    obj2 = hVar;
                }
                if (obj2 == aVar) {
                    return aVar;
                }
            }
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p029q.j.o(obj);
        }
        return hVar;
    }
}
