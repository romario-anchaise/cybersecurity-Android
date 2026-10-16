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
public final class b implements G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f2213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q f2215c;

    public b(q qVar) {
        this.f2215c = qVar;
        this.f2213a = new r(((B) qVar.f2176e).f3438a.c());
    }

    @Override // k1.G
    public final K c() {
        return this.f2213a;
    }

    @Override // k1.G, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f2214b) {
            return;
        }
        this.f2214b = true;
        ((B) this.f2215c.f2176e).k("0\r\n\r\n");
        q qVar = this.f2215c;
        r rVar = this.f2213a;
        qVar.getClass();
        K k2 = rVar.f3500e;
        rVar.f3500e = K.f3456d;
        k2.a();
        k2.b();
        this.f2215c.f2172a = 3;
    }

    @Override // k1.G, java.io.Flushable
    public final synchronized void flush() {
        if (this.f2214b) {
            return;
        }
        ((B) this.f2215c.f2176e).flush();
    }

    @Override // k1.G
    public final void i(C0193i c0193i, long j2) {
        i.e(c0193i, "source");
        if (this.f2214b) {
            throw new IllegalStateException("closed");
        }
        if (j2 == 0) {
            return;
        }
        q qVar = this.f2215c;
        B b2 = (B) qVar.f2176e;
        if (b2.f3440c) {
            throw new IllegalStateException("closed");
        }
        b2.f3439b.S(j2);
        b2.a();
        B b3 = (B) qVar.f2176e;
        b3.k("\r\n");
        b3.i(c0193i, j2);
        b3.k("\r\n");
    }
}
