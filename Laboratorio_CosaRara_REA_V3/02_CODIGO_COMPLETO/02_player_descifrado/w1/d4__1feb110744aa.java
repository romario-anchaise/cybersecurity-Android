// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f3770d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile c4 f3771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ m4 f3772f;

    public d4(m4 m4Var, boolean z2, Object obj, long j3) {
        this.f3772f = m4Var;
        this.f3767a = z2;
        this.f3768b = obj;
        this.f3769c = j3;
    }

    public final void a(long j3) {
        if (j3 <= 0) {
            o2.i("lease must be finite");
            return;
        }
        try {
            c4 c4VarC = this.f3772f.f4514k.c(j3, new a2.b(21, this));
            this.f3771e = c4VarC;
            if (this.f3770d.get()) {
                this.f3771e = null;
                m4.i(c4VarC);
            }
        } catch (Throwable unused) {
            b();
        }
    }

    public final void b() {
        if (this.f3770d.compareAndSet(false, true)) {
            c4 c4Var = this.f3771e;
            this.f3771e = null;
            m4.i(c4Var);
            synchronized (this.f3772f) {
                try {
                    boolean z2 = this.f3767a;
                    m4 m4Var = this.f3772f;
                    if (!z2) {
                        if (m4Var.f4509f == this.f3769c && m4Var.f4508e == this.f3768b) {
                            m4Var.f4509f = 0L;
                            m4Var.f4508e = null;
                        }
                        return;
                    }
                    if (m4Var.f4507d != this.f3769c) {
                        return;
                    } else {
                        m4Var.f4507d = 0L;
                    }
                    m4Var.g();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
