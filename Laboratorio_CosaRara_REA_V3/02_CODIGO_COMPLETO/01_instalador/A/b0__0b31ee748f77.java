// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class b0 extends p044y0.g implements E0.p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f21c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f22d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f23e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f24f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f25h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f26i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(ViewGroup viewGroup, p040w0.d dVar) {
        super(dVar);
        this.f26i = viewGroup;
    }

    @Override // p044y0.a
    public final p040w0.d a(Object obj, p040w0.d dVar) {
        b0 b0Var = new b0(this.f26i, dVar);
        b0Var.f25h = obj;
        return b0Var;
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) {
        return ((b0) a((L0.d) obj, (p040w0.d) obj2)).f(p034t0.h.f4132b);
    }

    @Override // p044y0.a
    public final Object f(Object obj) {
        L0.d dVar;
        ViewGroup viewGroup;
        int childCount;
        int i2;
        int i3;
        Object obj2;
        int i4;
        ViewGroup viewGroup2;
        L0.d dVar2;
        p042x0.a aVar = p042x0.a.f4189a;
        int i5 = this.g;
        p034t0.h hVar = p034t0.h.f4132b;
        if (i5 != 0) {
            if (i5 == 1) {
                childCount = this.f24f;
                i3 = this.f23e;
                View view = this.f22d;
                viewGroup = this.f21c;
                dVar = (L0.d) this.f25h;
                p029q.j.o(obj);
                if (view instanceof ViewGroup) {
                    b0 b0Var = new b0((ViewGroup) view, null);
                    this.f25h = dVar;
                    this.f21c = viewGroup;
                    this.f22d = null;
                    this.f23e = i3;
                    this.f24f = childCount;
                    this.g = 2;
                    dVar.getClass();
                    L0.d dVar3 = new L0.d();
                    dVar3.f350d = b0Var.a(dVar3, dVar3);
                    if (dVar3.hasNext()) {
                        dVar.f349c = dVar3;
                        dVar.f347a = 2;
                        dVar.f350d = this;
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
                    i4 = i3;
                    viewGroup2 = viewGroup;
                    dVar2 = dVar;
                }
                i2 = i3 + 1;
            } else {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                childCount = this.f24f;
                i4 = this.f23e;
                viewGroup2 = this.f21c;
                dVar2 = (L0.d) this.f25h;
                p029q.j.o(obj);
            }
            viewGroup = viewGroup2;
            dVar = dVar2;
            i3 = i4;
            i2 = i3 + 1;
        } else {
            p029q.j.o(obj);
            dVar = (L0.d) this.f25h;
            viewGroup = this.f26i;
            childCount = viewGroup.getChildCount();
            i2 = 0;
        }
        if (i2 >= childCount) {
            return hVar;
        }
        View childAt = viewGroup.getChildAt(i2);
        this.f25h = dVar;
        this.f21c = viewGroup;
        this.f22d = childAt;
        this.f23e = i2;
        this.f24f = childCount;
        this.g = 1;
        dVar.f348b = childAt;
        dVar.f347a = 3;
        dVar.f350d = this;
        return aVar;
    }
}
