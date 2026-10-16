// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: renamed from: N0.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0040l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final E0.l f443b;

    public C0040l(Object obj, E0.l lVar) {
        this.f442a = obj;
        this.f443b = lVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0040l)) {
            return false;
        }
        C0040l c0040l = (C0040l) obj;
        return F0.i.a(this.f442a, c0040l.f442a) && F0.i.a(this.f443b, c0040l.f443b);
    }

    public final int hashCode() {
        Object obj = this.f442a;
        return this.f443b.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public final String toString() {
        return "CompletedWithCancellation(result=" + this.f442a + ", onCancellation=" + this.f443b + ')';
    }
}
