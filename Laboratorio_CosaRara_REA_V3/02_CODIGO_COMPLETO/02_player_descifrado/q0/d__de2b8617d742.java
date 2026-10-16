// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient int f3107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f3108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e f3109g;

    public d(e eVar, int i3, int i4) {
        this.f3109g = eVar;
        this.f3107e = i3;
        this.f3108f = i4;
    }

    @Override // q0.a
    public final Object[] a() {
        return this.f3109g.a();
    }

    @Override // q0.a
    public final int b() {
        return this.f3109g.b() + this.f3107e;
    }

    @Override // q0.a
    public final int c() {
        return this.f3109g.b() + this.f3107e + this.f3108f;
    }

    @Override // q0.e, java.util.List
    /* JADX INFO: renamed from: f */
    public final e subList(int i3, int i4) {
        y.f.q(i3, i4, this.f3108f);
        int i5 = this.f3107e;
        return this.f3109g.subList(i3 + i5, i4 + i5);
    }

    @Override // java.util.List
    public final Object get(int i3) {
        y.f.p(i3, this.f3108f);
        return this.f3109g.get(i3 + this.f3107e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3108f;
    }
}
