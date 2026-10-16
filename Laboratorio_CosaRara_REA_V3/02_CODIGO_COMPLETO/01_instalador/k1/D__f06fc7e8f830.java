// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

/* JADX INFO: loaded from: classes.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public D f3449f;
    public D g;

    public D() {
        this.f3444a = new byte[8192];
        this.f3448e = true;
        this.f3447d = false;
    }

    public final D a() {
        D d2 = this.f3449f;
        if (d2 == this) {
            d2 = null;
        }
        D d3 = this.g;
        F0.i.b(d3);
        d3.f3449f = this.f3449f;
        D d4 = this.f3449f;
        F0.i.b(d4);
        d4.g = this.g;
        this.f3449f = null;
        this.g = null;
        return d2;
    }

    public final void b(D d2) {
        F0.i.e(d2, "segment");
        d2.g = this;
        d2.f3449f = this.f3449f;
        D d3 = this.f3449f;
        F0.i.b(d3);
        d3.g = d2;
        this.f3449f = d2;
    }

    public final D c() {
        this.f3447d = true;
        return new D(this.f3444a, this.f3445b, this.f3446c, true);
    }

    public final void d(D d2, int i2) {
        F0.i.e(d2, "sink");
        if (!d2.f3448e) {
            throw new IllegalStateException("only owner can write");
        }
        int i3 = d2.f3446c;
        int i4 = i3 + i2;
        byte[] bArr = d2.f3444a;
        if (i4 > 8192) {
            if (d2.f3447d) {
                throw new IllegalArgumentException();
            }
            int i5 = d2.f3445b;
            if (i4 - i5 > 8192) {
                throw new IllegalArgumentException();
            }
            p036u0.e.r(0, i5, i3, bArr, bArr);
            d2.f3446c -= d2.f3445b;
            d2.f3445b = 0;
        }
        int i6 = d2.f3446c;
        int i7 = this.f3445b;
        p036u0.e.r(i6, i7, i7 + i2, this.f3444a, bArr);
        d2.f3446c += i2;
        this.f3445b += i2;
    }

    public D(byte[] bArr, int i2, int i3, boolean z2) {
        F0.i.e(bArr, "data");
        this.f3444a = bArr;
        this.f3445b = i2;
        this.f3446c = i3;
        this.f3447d = z2;
        this.f3448e = false;
    }
}
