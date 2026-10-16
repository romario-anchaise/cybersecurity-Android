// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f459b;

    public t(int i3) {
        switch (i3) {
            case 5:
                this.f459b = System.nanoTime();
                break;
            default:
                this.f459b = System.nanoTime();
                break;
        }
    }

    public synchronized boolean a(long j3) {
        int i3 = this.f458a;
        if (i3 == 1 && this.f459b == j3) {
            this.f458a = 2;
            return true;
        }
        if (i3 == 1) {
            this.f458a = 4;
        }
        return false;
    }

    public synchronized boolean b(long j3, boolean z2) {
        if (this.f458a != 2) {
            return false;
        }
        if (z2 && this.f459b == j3) {
            this.f458a = 3;
            return true;
        }
        this.f458a = 4;
        return false;
    }

    public synchronized boolean c() {
        return this.f458a == 4;
    }

    public t(long j3) {
        this.f458a = 1;
        this.f459b = j3;
    }

    public t(int i3, long j3) {
        this.f458a = i3;
        this.f459b = j3;
    }
}
