// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q0;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f3111g = new f(new Object[0], 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient Object[] f3112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f3113f;

    public f(Object[] objArr, int i3) {
        this.f3112e = objArr;
        this.f3113f = i3;
    }

    @Override // q0.a
    public final Object[] a() {
        return this.f3112e;
    }

    @Override // q0.a
    public final int b() {
        return 0;
    }

    @Override // q0.a
    public final int c() {
        return this.f3113f;
    }

    @Override // q0.e, q0.a
    public final int d(Object[] objArr) {
        Object[] objArr2 = this.f3112e;
        int i3 = this.f3113f;
        System.arraycopy(objArr2, 0, objArr, 0, i3);
        return i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        y.f.p(i3, this.f3113f);
        Object obj = this.f3112e[i3];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3113f;
    }
}
