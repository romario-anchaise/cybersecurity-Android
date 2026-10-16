// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p044y0;

import F0.f;
import F0.o;
import F0.p;
import p040w0.d;
import p040w0.i;
import p040w0.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4201b;

    public g(d dVar) {
        super(dVar);
        if (dVar != null && dVar.g() != j.f4165a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
        this.f4201b = 2;
    }

    @Override // F0.f
    public final int e() {
        return this.f4201b;
    }

    @Override // p040w0.d
    public final i g() {
        return j.f4165a;
    }

    @Override // p044y0.a
    public final String toString() {
        if (this.f4195a != null) {
            return super.toString();
        }
        o.f181a.getClass();
        String strA = p.a(this);
        F0.i.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
