// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Z;

import W.o;

/* JADX INFO: loaded from: classes.dex */
public final class m extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f1153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final W.g f1155c;

    public m(o oVar, String str, W.g gVar) {
        this.f1153a = oVar;
        this.f1154b = str;
        this.f1155c = gVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (F0.i.a(this.f1153a, mVar.f1153a) && F0.i.a(this.f1154b, mVar.f1154b) && this.f1155c == mVar.f1155c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f1153a.hashCode() * 31;
        String str = this.f1154b;
        return this.f1155c.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31);
    }
}
