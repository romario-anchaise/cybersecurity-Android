// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package K;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f302b;

    public e(long j2, long j3) {
        if (j3 == 0) {
            this.f301a = 0L;
            this.f302b = 1L;
        } else {
            this.f301a = j2;
            this.f302b = j3;
        }
    }

    public final String toString() {
        return this.f301a + "/" + this.f302b;
    }
}
