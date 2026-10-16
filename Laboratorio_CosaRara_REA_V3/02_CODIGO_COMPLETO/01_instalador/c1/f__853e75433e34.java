// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c1;

import F0.i;
import X0.D;
import X0.p;
import X0.q;
import X0.r;
import X0.y;
import b1.j;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f2184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f2185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b1.e f2187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y f2188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2189f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2190h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2191i;

    public f(j jVar, ArrayList arrayList, int i2, b1.e eVar, y yVar, int i3, int i4, int i5) {
        i.e(jVar, "call");
        i.e(yVar, "request");
        this.f2184a = jVar;
        this.f2185b = arrayList;
        this.f2186c = i2;
        this.f2187d = eVar;
        this.f2188e = yVar;
        this.f2189f = i3;
        this.g = i4;
        this.f2190h = i5;
    }

    public static f a(f fVar, int i2, b1.e eVar, y yVar, int i3) {
        if ((i3 & 1) != 0) {
            i2 = fVar.f2186c;
        }
        int i4 = i2;
        if ((i3 & 2) != 0) {
            eVar = fVar.f2187d;
        }
        b1.e eVar2 = eVar;
        if ((i3 & 4) != 0) {
            yVar = fVar.f2188e;
        }
        y yVar2 = yVar;
        int i5 = fVar.f2189f;
        int i6 = fVar.g;
        int i7 = fVar.f2190h;
        fVar.getClass();
        i.e(yVar2, "request");
        return new f(fVar.f2184a, fVar.f2185b, i4, eVar2, yVar2, i5, i6, i7);
    }

    public final D b(y yVar) {
        i.e(yVar, "request");
        ArrayList arrayList = this.f2185b;
        int size = arrayList.size();
        int i2 = this.f2186c;
        if (i2 >= size) {
            throw new IllegalStateException("Check failed.");
        }
        this.f2191i++;
        b1.e eVar = this.f2187d;
        if (eVar != null) {
            if (!eVar.f2114b.b((p) yVar.f1099c)) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i2 - 1) + " must retain the same host and port").toString());
            }
            if (this.f2191i != 1) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i2 - 1) + " must call proceed() exactly once").toString());
            }
        }
        int i3 = i2 + 1;
        f fVarA = a(this, i3, null, yVar, 58);
        r rVar = (r) arrayList.get(i2);
        D dA = rVar.a(fVarA);
        if (dA == null) {
            throw new NullPointerException("interceptor " + rVar + " returned null");
        }
        if (eVar != null && i3 < arrayList.size() && fVarA.f2191i != 1) {
            throw new IllegalStateException(("network interceptor " + rVar + " must call proceed() exactly once").toString());
        }
        if (dA.g != null) {
            return dA;
        }
        throw new IllegalStateException(("interceptor " + rVar + " returned a response with no body").toString());
    }
}
