// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f5553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f5554e;

    public final int a(long j3) {
        if (j3 < this.f5551b) {
            this.f5554e++;
            return 3;
        }
        long j4 = this.f5550a;
        if (j4 == Long.MIN_VALUE || j3 < j4 || j3 - j4 >= 250) {
            this.f5550a = j3;
            this.f5552c = 0;
        }
        int i3 = this.f5552c + 1;
        this.f5552c = i3;
        if (i3 <= 64) {
            return 1;
        }
        this.f5551b = j3 + 500;
        this.f5553d++;
        this.f5554e++;
        return 2;
    }
}
