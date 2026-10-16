// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y[] f2391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2393c;

    public y() {
        this.f2391a = new y[256];
        this.f2392b = 0;
        this.f2393c = 0;
    }

    public y(int i2, int i3) {
        this.f2391a = null;
        this.f2392b = i2;
        int i4 = i3 & 7;
        this.f2393c = i4 == 0 ? 8 : i4;
    }
}
