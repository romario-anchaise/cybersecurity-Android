// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class x6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h2.a f5505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5507f = "";

    public x6(int i3, int i4, long j3, h2.a aVar) {
        this.f5502a = Math.max(1, i3);
        this.f5503b = Math.max(1, i4);
        this.f5504c = j3;
        this.f5505d = aVar;
    }

    public final boolean a(int i3) {
        if (!this.f5507f.isEmpty()) {
            return false;
        }
        if (i3 >= this.f5502a) {
            this.f5507f = "output_limit";
            return false;
        }
        if (this.f5506e >= this.f5503b) {
            this.f5507f = "visited_limit";
            return false;
        }
        this.f5505d.getClass();
        if (System.nanoTime() < this.f5504c) {
            return true;
        }
        this.f5507f = "deadline";
        return false;
    }
}
