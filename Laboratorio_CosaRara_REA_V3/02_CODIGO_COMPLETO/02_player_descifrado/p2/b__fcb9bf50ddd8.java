// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w2.k f2876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final w2.k f2877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final w2.k f2878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final w2.k f2879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final w2.k f2880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final w2.k f2881i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2.k f2882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w2.k f2883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2884c;

    static {
        w2.k kVar = w2.k.f5778f;
        f2876d = e0.i.d(":");
        f2877e = e0.i.d(":status");
        f2878f = e0.i.d(":method");
        f2879g = e0.i.d(":path");
        f2880h = e0.i.d(":scheme");
        f2881i = e0.i.d(":authority");
    }

    public b(w2.k kVar, w2.k kVar2) {
        kVar.getClass();
        kVar2.getClass();
        this.f2882a = kVar;
        this.f2883b = kVar2;
        this.f2884c = kVar2.c() + kVar.c() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return q1.e.a(this.f2882a, bVar.f2882a) && q1.e.a(this.f2883b, bVar.f2883b);
    }

    public final int hashCode() {
        return this.f2883b.hashCode() + (this.f2882a.hashCode() * 31);
    }

    public final String toString() {
        return this.f2882a.k() + ": " + this.f2883b.k();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str, String str2) {
        this(e0.i.d(str), e0.i.d(str2));
        str.getClass();
        str2.getClass();
        w2.k kVar = w2.k.f5778f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(w2.k kVar, String str) {
        this(kVar, e0.i.d(str));
        kVar.getClass();
        str.getClass();
        w2.k kVar2 = w2.k.f5778f;
    }
}
