// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f589c;

    public j(long j3, long j4, String str) {
        this.f587a = str;
        this.f588b = j3;
        this.f589c = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f588b == jVar.f588b && this.f589c == jVar.f589c && this.f587a.equals(jVar.f587a);
    }

    public final int hashCode() {
        return Long.hashCode(this.f589c) + j4.b(this.f587a.hashCode() * 31, 31, this.f588b);
    }
}
