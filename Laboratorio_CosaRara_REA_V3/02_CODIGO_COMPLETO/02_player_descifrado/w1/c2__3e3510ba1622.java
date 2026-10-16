// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3653d;

    public final synchronized d2 a(float f3, float f4, String str) {
        float f5;
        float fG;
        long j3;
        try {
            f5 = "front".equals(str) ? this.f3650a : this.f3651b;
            fG = e2.g(f3, f4);
            if ("front".equals(str)) {
                this.f3650a = fG;
                j3 = this.f3652c + 1;
                this.f3652c = j3;
            } else {
                this.f3651b = fG;
                j3 = this.f3653d + 1;
                this.f3653d = j3;
            }
        } catch (Throwable th) {
            throw th;
        }
        return new d2(str, f5, fG, j3);
    }

    public final synchronized void b(d2 d2Var) {
        if (d2Var == null) {
            return;
        }
        try {
            if ("front".equals(d2Var.f3760a)) {
                long j3 = this.f3652c;
                if (j3 != d2Var.f3763d) {
                    return;
                }
                this.f3650a = d2Var.f3761b;
                this.f3652c = j3 + 1;
            } else {
                long j4 = this.f3653d;
                if (j4 != d2Var.f3763d) {
                    return;
                }
                this.f3651b = d2Var.f3761b;
                this.f3653d = j4 + 1;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
