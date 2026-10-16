// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class y extends p036u0.c implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0196l[] f3515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f3516b;

    public y(C0196l[] c0196lArr, int[] iArr) {
        this.f3515a = c0196lArr;
        this.f3516b = iArr;
    }

    @Override // p036u0.c
    public final int a() {
        return this.f3515a.length;
    }

    @Override // p036u0.c, java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof C0196l) {
            return super.contains((C0196l) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        return this.f3515a[i2];
    }

    @Override // p036u0.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof C0196l) {
            return super.indexOf((C0196l) obj);
        }
        return -1;
    }

    @Override // p036u0.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof C0196l) {
            return super.lastIndexOf((C0196l) obj);
        }
        return -1;
    }
}
