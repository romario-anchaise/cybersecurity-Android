// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d1;

import F0.i;
import b1.q;
import k1.B;
import k1.C0193i;
import k1.G;
import k1.K;
import k1.r;

/* JADX INFO: loaded from: classes.dex */
public final class e implements G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f2221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q f2223c;

    public e(q qVar) {
        this.f2223c = qVar;
        this.f2221a = new r(((B) qVar.f2176e).f3438a.c());
    }

    @Override // k1.G
    public final K c() {
        return this.f2221a;
    }

    @Override // k1.G, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f2222b) {
            return;
        }
        this.f2222b = true;
        q qVar = this.f2223c;
        qVar.getClass();
        r rVar = this.f2221a;
        K k2 = rVar.f3500e;
        rVar.f3500e = K.f3456d;
        k2.a();
        k2.b();
        qVar.f2172a = 3;
    }

    @Override // k1.G, java.io.Flushable
    public final void flush() {
        if (this.f2222b) {
            return;
        }
        ((B) this.f2223c.f2176e).flush();
    }

    @Override // k1.G
    public final void i(C0193i c0193i, long j2) {
        i.e(c0193i, "source");
        if (this.f2222b) {
            throw new IllegalStateException("closed");
        }
        Y0.b.c(c0193i.f3482b, 0L, j2);
        ((B) this.f2223c.f2176e).i(c0193i, j2);
    }
}
