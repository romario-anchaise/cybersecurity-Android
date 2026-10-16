// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X;

import M0.o;
import java.io.EOFException;
import java.io.IOException;
import k1.C0193i;
import k1.G;
import k1.p;

/* JADX INFO: loaded from: classes.dex */
public final class h extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f884c;

    public h(G g, o oVar) {
        super(g);
        this.f883b = oVar;
    }

    @Override // k1.p, k1.G, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            super.close();
        } catch (IOException e2) {
            this.f884c = true;
            this.f883b.d(e2);
        }
    }

    @Override // k1.p, k1.G, java.io.Flushable
    public final void flush() {
        try {
            super.flush();
        } catch (IOException e2) {
            this.f884c = true;
            this.f883b.d(e2);
        }
    }

    @Override // k1.p, k1.G
    public final void i(C0193i c0193i, long j2) throws EOFException {
        if (this.f884c) {
            c0193i.K(j2);
            return;
        }
        try {
            super.i(c0193i, j2);
        } catch (IOException e2) {
            this.f884c = true;
            this.f883b.d(e2);
        }
    }
}
