// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y.l f1426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0.j f1427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1428d;

    public a(y.l lVar, h0.j jVar, String str) {
        this.f1426b = lVar;
        this.f1427c = jVar;
        this.f1428d = str;
        this.f1425a = Arrays.hashCode(new Object[]{lVar, jVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return h0.o.e(this.f1426b, aVar.f1426b) && h0.o.e(this.f1427c, aVar.f1427c) && h0.o.e(this.f1428d, aVar.f1428d);
    }

    public final int hashCode() {
        return this.f1425a;
    }
}
