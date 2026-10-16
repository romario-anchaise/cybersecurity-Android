// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m2;

import java.io.IOException;
import java.net.ProtocolException;
import w1.o2;
import w2.x;
import w2.z;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f2694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f2695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2699h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ g0.k f2700i;

    public d(g0.k kVar, x xVar, long j3) {
        xVar.getClass();
        this.f2700i = kVar;
        this.f2694c = xVar;
        this.f2695d = j3;
        this.f2697f = true;
        if (j3 == 0) {
            w(null);
        }
    }

    @Override // w2.x
    public final z a() {
        return this.f2694c.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f2699h) {
            return;
        }
        this.f2699h = true;
        try {
            d();
            w(null);
        } catch (IOException e3) {
            throw w(e3);
        }
    }

    public final void d() throws IOException {
        this.f2694c.close();
    }

    @Override // w2.x
    public final long f(long j3, w2.h hVar) throws IOException {
        if (this.f2699h) {
            o2.k("closed");
            return 0L;
        }
        try {
            long jF = this.f2694c.f(8192L, hVar);
            if (this.f2697f) {
                this.f2697f = false;
                ((i2.m) this.f2700i.f1474e).getClass();
            }
            if (jF == -1) {
                w(null);
                return -1L;
            }
            long j4 = this.f2696e + jF;
            long j5 = this.f2695d;
            if (j5 == -1 || j4 <= j5) {
                this.f2696e = j4;
                if (j4 == j5) {
                    w(null);
                }
                return jF;
            }
            throw new ProtocolException("expected " + j5 + " bytes but received " + j4);
        } catch (IOException e3) {
            throw w(e3);
        }
    }

    public final String toString() {
        return d.class.getSimpleName() + '(' + this.f2694c + ')';
    }

    public final IOException w(IOException iOException) {
        if (this.f2698g) {
            return iOException;
        }
        this.f2698g = true;
        g0.k kVar = this.f2700i;
        if (iOException == null && this.f2697f) {
            this.f2697f = false;
            ((i2.m) kVar.f1474e).getClass();
        }
        return kVar.b(true, false, iOException);
    }
}
