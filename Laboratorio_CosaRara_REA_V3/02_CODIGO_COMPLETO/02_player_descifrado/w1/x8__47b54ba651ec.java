// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class x8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f5520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f5523i;

    public final synchronized void a() {
        this.f5520f++;
        this.f5523i++;
        this.f5515a = false;
        this.f5516b = false;
        this.f5517c = 0L;
        this.f5518d = false;
        this.f5519e = false;
        this.f5521g = false;
        this.f5522h = false;
    }

    public final synchronized long b() {
        long j3;
        j3 = this.f5523i + 1;
        this.f5523i = j3;
        return j3;
    }

    public final synchronized long c() {
        long j3;
        j3 = this.f5520f + 1;
        this.f5520f = j3;
        return j3;
    }

    public final synchronized w8 d() {
        return new w8(this.f5515a, this.f5516b, this.f5517c, this.f5518d, this.f5519e, this.f5521g, this.f5522h);
    }
}
