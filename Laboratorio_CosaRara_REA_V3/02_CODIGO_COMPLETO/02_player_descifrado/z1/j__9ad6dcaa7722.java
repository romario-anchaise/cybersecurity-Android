// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z1;

import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f6329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6334f;

    public j(i iVar) {
        if (iVar == null) {
            o2.i("limits == null");
            throw null;
        }
        this.f6329a = iVar;
        this.f6330b = System.nanoTime();
    }

    public final boolean a() {
        if (!this.f6334f) {
            long jNanoTime = System.nanoTime() - this.f6330b;
            if (jNanoTime < 0) {
                jNanoTime = Long.MAX_VALUE;
            }
            this.f6329a.getClass();
            if (jNanoTime >= 8000000) {
                this.f6334f = true;
            }
        }
        return this.f6333e || this.f6334f;
    }

    public final i b() {
        a();
        return new i();
    }
}
