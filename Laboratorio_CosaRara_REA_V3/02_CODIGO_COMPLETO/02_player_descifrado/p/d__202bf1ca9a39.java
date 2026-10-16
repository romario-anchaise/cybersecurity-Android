// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f2832i = new d(1, false, false, false, false, -1, -1, i1.s.f2106c);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f2838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f2839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set f2840h;

    public d(int i3, boolean z2, boolean z3, boolean z4, boolean z5, long j3, long j4, Set set) {
        if (i3 == 0) {
            throw null;
        }
        set.getClass();
        this.f2833a = i3;
        this.f2834b = z2;
        this.f2835c = z3;
        this.f2836d = z4;
        this.f2837e = z5;
        this.f2838f = j3;
        this.f2839g = j4;
        this.f2840h = set;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !d.class.equals(obj.getClass())) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f2834b == dVar.f2834b && this.f2835c == dVar.f2835c && this.f2836d == dVar.f2836d && this.f2837e == dVar.f2837e && this.f2838f == dVar.f2838f && this.f2839g == dVar.f2839g && this.f2833a == dVar.f2833a) {
            return q1.e.a(this.f2840h, dVar.f2840h);
        }
        return false;
    }

    public final int hashCode() {
        int iA = ((((((((g.d.a(this.f2833a) * 31) + (this.f2834b ? 1 : 0)) * 31) + (this.f2835c ? 1 : 0)) * 31) + (this.f2836d ? 1 : 0)) * 31) + (this.f2837e ? 1 : 0)) * 31;
        long j3 = this.f2838f;
        int i3 = (iA + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.f2839g;
        return this.f2840h.hashCode() + ((i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31);
    }
}
