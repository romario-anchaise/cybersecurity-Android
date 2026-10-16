// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d1;

import F0.h;
import F0.i;
import b1.m;
import b1.q;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import k1.C0193i;

/* JADX INFO: loaded from: classes.dex */
public final class d extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q f2220e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(q qVar, long j2) {
        super(qVar);
        this.f2220e = qVar;
        this.f2219d = j2;
        if (j2 == 0) {
            a();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f2211b) {
            return;
        }
        if (this.f2219d != 0 && !Y0.b.h(this, TimeUnit.MILLISECONDS)) {
            ((m) this.f2220e.f2174c).k();
            a();
        }
        this.f2211b = true;
    }

    @Override // d1.a, k1.I
    public final long m(C0193i c0193i, long j2) throws ProtocolException {
        i.e(c0193i, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(h.d("byteCount < 0: ", j2).toString());
        }
        if (this.f2211b) {
            throw new IllegalStateException("closed");
        }
        long j3 = this.f2219d;
        if (j3 == 0) {
            return -1L;
        }
        long jM = super.m(c0193i, Math.min(j3, j2));
        if (jM == -1) {
            ((m) this.f2220e.f2174c).k();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a();
            throw protocolException;
        }
        long j4 = this.f2219d - jM;
        this.f2219d = j4;
        if (j4 == 0) {
            a();
        }
        return jM;
    }
}
