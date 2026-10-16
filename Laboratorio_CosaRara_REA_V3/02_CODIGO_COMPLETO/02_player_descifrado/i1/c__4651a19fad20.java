// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i1;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends d implements RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f2098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2100e;

    public c(d dVar, int i3, int i4) {
        this.f2098c = dVar;
        this.f2099d = i3;
        q2.k.d(i3, i4, dVar.a());
        this.f2100e = i4 - i3;
    }

    @Override // i1.d
    public final int a() {
        return this.f2100e;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        int i4 = this.f2100e;
        if (i3 < 0 || i3 >= i4) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, i4, "index: ", ", size: "));
        }
        return this.f2098c.get(this.f2099d + i3);
    }

    @Override // i1.d, java.util.List
    public final List subList(int i3, int i4) {
        q2.k.d(i3, i4, this.f2100e);
        int i5 = this.f2099d;
        return new c(this.f2098c, i3 + i5, i5 + i4);
    }
}
