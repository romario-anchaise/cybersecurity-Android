// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package o2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import m2.m;
import w1.o2;
import w2.h;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g f2800g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(g gVar, long j3) {
        super(gVar);
        this.f2800g = gVar;
        this.f2799f = j3;
        if (j3 == 0) {
            d();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zU;
        if (this.f2790d) {
            return;
        }
        if (this.f2799f != 0) {
            byte[] bArr = j2.b.f2361a;
            TimeUnit.MILLISECONDS.getClass();
            try {
                zU = j2.b.u(this, 100);
            } catch (IOException unused) {
                zU = false;
            }
            if (!zU) {
                ((m) this.f2800g.f2808c).k();
                d();
            }
        }
        this.f2790d = true;
    }

    @Override // o2.a, w2.x
    public final long f(long j3, h hVar) throws ProtocolException {
        if (this.f2790d) {
            o2.k("closed");
            return 0L;
        }
        long j4 = this.f2799f;
        if (j4 == 0) {
            return -1L;
        }
        long jF = super.f(Math.min(j4, 8192L), hVar);
        if (jF == -1) {
            ((m) this.f2800g.f2808c).k();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            d();
            throw protocolException;
        }
        long j5 = this.f2799f - jF;
        this.f2799f = j5;
        if (j5 == 0) {
            d();
        }
        return jF;
    }
}
