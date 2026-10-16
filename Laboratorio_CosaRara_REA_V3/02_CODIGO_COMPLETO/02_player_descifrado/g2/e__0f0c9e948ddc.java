// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1587d;

    public e(long j3, long j4, long j5, long j6) {
        this.f1584a = y.l.b(j3);
        this.f1585b = y.l.b(j4);
        this.f1586c = y.l.b(j5);
        this.f1587d = y.l.b(j6);
    }

    public synchronized long a() {
        return this.f1586c;
    }

    public synchronized long b() {
        return this.f1587d;
    }

    public synchronized long c(long j3) {
        long j4 = this.f1584a;
        if (j4 == Long.MIN_VALUE || j3 >= j4 || j3 < j4 - 30000) {
            return 0L;
        }
        return j4 - j3;
    }
}
