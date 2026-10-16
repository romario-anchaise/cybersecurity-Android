// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f2748c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f1.d f2749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f1.d f2750b;

    static {
        b bVar = b.f2739m;
        f2748c = new h(bVar, bVar);
    }

    public h(f1.d dVar, f1.d dVar2) {
        this.f2749a = dVar;
        this.f2750b = dVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return F0.i.a(this.f2749a, hVar.f2749a) && F0.i.a(this.f2750b, hVar.f2750b);
    }

    public final int hashCode() {
        return this.f2750b.hashCode() + (this.f2749a.hashCode() * 31);
    }

    public final String toString() {
        return "Size(width=" + this.f2749a + ", height=" + this.f2750b + ')';
    }
}
