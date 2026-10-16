// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r1 f4972d = new r1(false, 0L, 0L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4975c;

    public r1(boolean z2, long j3, long j4) {
        this.f4975c = z2;
        this.f4973a = j3;
        this.f4974b = j4;
    }

    public static r1 b(long j3, long j4, long j5, boolean z2) {
        return (!z2 || j3 <= 0 || j4 <= j3 || j4 - j3 != 3600000 || j5 >= j4) ? f4972d : new r1(true, j3, j4);
    }

    public boolean a(long j3) {
        if (!this.f4975c) {
            return false;
        }
        long j4 = this.f4973a;
        if (j4 <= 0) {
            return false;
        }
        long j5 = this.f4974b;
        return j5 > j4 && j3 < j5;
    }

    public r1(long j3, long j4, boolean z2) {
        this.f4973a = j3;
        this.f4974b = j4;
        this.f4975c = z2;
    }
}
