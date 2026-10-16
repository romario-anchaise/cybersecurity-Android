// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p014i0;

import W.g;
import p010f0.j;
import p010f0.q;

/* JADX INFO: loaded from: classes.dex */
public final class a implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3008c = false;

    public a(int i2) {
        this.f3007b = i2;
        if (i2 <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
    }

    @Override // p014i0.e
    public final f a(p012h0.a aVar, j jVar) {
        if (jVar instanceof q) {
            return ((q) jVar).f2685c == g.f749a ? new d(aVar, jVar) : new b(aVar, jVar, this.f3007b, this.f3008c);
        }
        return new d(aVar, jVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f3007b == aVar.f3007b && this.f3008c == aVar.f3008c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f3008c) + (this.f3007b * 31);
    }
}
