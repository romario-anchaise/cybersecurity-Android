// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0.d f1468b;

    public /* synthetic */ i(a aVar, e0.d dVar) {
        this.f1467a = aVar;
        this.f1468b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return h0.o.e(this.f1467a, iVar.f1467a) && h0.o.e(this.f1468b, iVar.f1468b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1467a, this.f1468b});
    }

    public final String toString() {
        y.c cVar = new y.c(this);
        cVar.a(this.f1467a, "key");
        cVar.a(this.f1468b, "feature");
        return cVar.toString();
    }
}
