// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p044y0;

import F0.f;
import F0.i;
import F0.o;
import F0.p;
import p040w0.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends c implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4202d;

    public h(d dVar) {
        super(dVar);
        this.f4202d = 2;
    }

    @Override // F0.f
    public final int e() {
        return this.f4202d;
    }

    @Override // p044y0.a
    public final String toString() {
        if (this.f4195a != null) {
            return super.toString();
        }
        o.f181a.getClass();
        String strA = p.a(this);
        i.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
