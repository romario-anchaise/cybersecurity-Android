// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package D;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f119f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f121i;

    public final float a(long j2) {
        long j3 = this.f118e;
        if (j2 < j3) {
            return 0.0f;
        }
        long j4 = this.g;
        if (j4 < 0 || j2 < j4) {
            return h.b((j2 - j3) / this.f114a, 0.0f, 1.0f) * 0.5f;
        }
        float f2 = this.f120h;
        return (h.b((j2 - j4) / this.f121i, 0.0f, 1.0f) * f2) + (1.0f - f2);
    }
}
