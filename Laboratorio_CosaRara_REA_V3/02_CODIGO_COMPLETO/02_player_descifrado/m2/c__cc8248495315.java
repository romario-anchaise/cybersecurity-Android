// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m2;

import java.io.IOException;
import java.net.ProtocolException;
import w1.o2;
import w2.v;
import w2.z;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f2688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f2689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g0.k f2693h;

    public c(g0.k kVar, v vVar, long j3) {
        vVar.getClass();
        this.f2693h = kVar;
        this.f2688c = vVar;
        this.f2689d = j3;
    }

    @Override // w2.v
    public final z a() {
        return this.f2688c.a();
    }

    @Override // w2.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f2692g) {
            return;
        }
        this.f2692g = true;
        long j3 = this.f2689d;
        if (j3 != -1 && this.f2691f != j3) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            d();
            w(null);
        } catch (IOException e3) {
            throw w(e3);
        }
    }

    public final void d() {
        this.f2688c.close();
    }

    @Override // w2.v, java.io.Flushable
    public final void flush() throws IOException {
        try {
            y();
        } catch (IOException e3) {
            throw w(e3);
        }
    }

    @Override // w2.v
    public final void t(long j3, w2.h hVar) throws IOException {
        if (this.f2692g) {
            o2.k("closed");
            return;
        }
        long j4 = this.f2689d;
        if (j4 != -1 && this.f2691f + j3 > j4) {
            StringBuilder sbJ = a0.a.j(j4, "expected ", " bytes but received ");
            sbJ.append(this.f2691f + j3);
            throw new ProtocolException(sbJ.toString());
        }
        try {
            this.f2688c.t(j3, hVar);
            this.f2691f += j3;
        } catch (IOException e3) {
            throw w(e3);
        }
    }

    public final String toString() {
        return c.class.getSimpleName() + '(' + this.f2688c + ')';
    }

    public final IOException w(IOException iOException) {
        if (this.f2690e) {
            return iOException;
        }
        this.f2690e = true;
        return this.f2693h.b(false, true, iOException);
    }

    public final void y() {
        this.f2688c.flush();
    }
}
