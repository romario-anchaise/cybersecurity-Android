// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f4539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f4540g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f4541h;

    public m7(String str, long j3, long j4, long j5, long j6, long j7, int i3, String str2) {
        this.f4534a = o7.c(str, 96);
        this.f4535b = Math.max(0L, j3);
        this.f4536c = Math.max(0L, j4);
        this.f4537d = Math.max(0L, j5);
        this.f4538e = Math.max(0L, j6);
        this.f4539f = Math.max(0L, j7);
        this.f4540g = Math.max(0, i3);
        this.f4541h = o7.c(str2, 48);
    }

    public m7(String str, int i3) {
        this("", 0L, 0L, 0L, 0L, 0L, i3, str);
    }
}
