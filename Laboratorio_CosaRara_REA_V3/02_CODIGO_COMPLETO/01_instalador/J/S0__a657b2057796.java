// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

/* JADX INFO: loaded from: classes.dex */
public final class S0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3113f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3114h;

    public final void a(int i2, int i3) {
        this.f3110c = i2;
        this.f3111d = i3;
        this.f3114h = true;
        if (this.g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f3108a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f3109b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f3108a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f3109b = i3;
        }
    }
}
