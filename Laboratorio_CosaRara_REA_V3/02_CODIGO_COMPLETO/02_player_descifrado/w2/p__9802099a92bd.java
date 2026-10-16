// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends i1.d implements RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k[] f5793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f5794d;

    public p(k[] kVarArr, int[] iArr) {
        this.f5793c = kVarArr;
        this.f5794d = iArr;
    }

    @Override // i1.d
    public final int a() {
        return this.f5793c.length;
    }

    @Override // i1.d, java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof k) {
            return super.contains((k) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        return this.f5793c[i3];
    }

    @Override // i1.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof k) {
            return super.indexOf((k) obj);
        }
        return -1;
    }

    @Override // i1.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof k) {
            return super.lastIndexOf((k) obj);
        }
        return -1;
    }
}
