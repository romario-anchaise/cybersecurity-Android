// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import java.io.IOException;
import java.net.ProtocolException;
import k1.C0193i;
import k1.G;

/* JADX INFO: loaded from: classes.dex */
public final class c extends k1.p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e f2107f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, G g, long j2) {
        super(g);
        F0.i.e(g, "delegate");
        this.f2107f = eVar;
        this.f2103b = j2;
    }

    public final IOException a(IOException iOException) {
        if (this.f2104c) {
            return iOException;
        }
        this.f2104c = true;
        return this.f2107f.a(false, true, iOException);
    }

    @Override // k1.p, k1.G, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f2106e) {
            return;
        }
        this.f2106e = true;
        long j2 = this.f2103b;
        if (j2 != -1 && this.f2105d != j2) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            super.close();
            a(null);
        } catch (IOException e2) {
            throw a(e2);
        }
    }

    @Override // k1.p, k1.G, java.io.Flushable
    public final void flush() throws IOException {
        try {
            super.flush();
        } catch (IOException e2) {
            throw a(e2);
        }
    }

    @Override // k1.p, k1.G
    public final void i(C0193i c0193i, long j2) throws IOException {
        F0.i.e(c0193i, "source");
        if (this.f2106e) {
            throw new IllegalStateException("closed");
        }
        long j3 = this.f2103b;
        if (j3 == -1 || this.f2105d + j2 <= j3) {
            try {
                super.i(c0193i, j2);
                this.f2105d += j2;
                return;
            } catch (IOException e2) {
                throw a(e2);
            }
        }
        throw new ProtocolException("expected " + j3 + " bytes but received " + (this.f2105d + j2));
    }
}
