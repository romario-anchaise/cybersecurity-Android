// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m3 implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final aa f4495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final aa f4496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n3 f4497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n3 f4498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l3 f4499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4501i;

    public m3(n3 n3Var, aa aaVar, aa aaVar2) {
        this.f4497e = n3Var;
        this.f4496d = aaVar;
        this.f4495c = aaVar2;
    }

    @Override // java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.f4501i) {
                return;
            }
            this.f4501i = true;
            this.f4500h++;
            l3 l3Var = this.f4499g;
            if (l3Var != null) {
                l3Var.cancel();
                this.f4499g = null;
            }
            this.f4498f = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void d(n3 n3Var) throws Throwable {
        m3 m3Var;
        Throwable th;
        l3 cVar;
        try {
            try {
                if (!this.f4501i) {
                    n3 n3Var2 = this.f4498f;
                    if (n3Var2 == null) {
                        n3Var2 = this.f4497e;
                    }
                    if (!n3Var.equals(n3Var2)) {
                        long j3 = this.f4500h + 1;
                        this.f4500h = j3;
                        l3 l3Var = this.f4499g;
                        if (l3Var != null) {
                            try {
                                l3Var.cancel();
                            } catch (Throwable th2) {
                                th = th2;
                                m3Var = this;
                                throw th;
                            }
                        }
                        this.f4498f = n3Var;
                        aa aaVar = this.f4496d;
                        m3Var = this;
                        b2.b bVar = new b2.b(m3Var, n3Var, j3, 1);
                        try {
                            Handler handler = aaVar.f3491d.T3;
                            if (handler == null) {
                                cVar = new o2(14);
                            } else {
                                handler.postDelayed(bVar, 300L);
                                cVar = new d2.c(handler, bVar, 8);
                            }
                            m3Var.f4499g = cVar;
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            m3Var = this;
            th = th;
            throw th;
        }
    }
}
