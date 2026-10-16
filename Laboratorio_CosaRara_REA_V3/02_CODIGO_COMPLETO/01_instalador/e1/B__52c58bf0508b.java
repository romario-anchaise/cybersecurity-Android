// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

/* JADX INFO: loaded from: classes.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f2274b = new int[10];

    public final int a() {
        if ((this.f2273a & 128) != 0) {
            return this.f2274b[7];
        }
        return 65535;
    }

    public final void b(B b2) {
        F0.i.e(b2, "other");
        for (int i2 = 0; i2 < 10; i2++) {
            if (((1 << i2) & b2.f2273a) != 0) {
                c(i2, b2.f2274b[i2]);
            }
        }
    }

    public final void c(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.f2274b;
            if (i2 >= iArr.length) {
                return;
            }
            this.f2273a = (1 << i2) | this.f2273a;
            iArr[i2] = i3;
        }
    }
}
