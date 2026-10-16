// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import k1.C0193i;
import k1.C0196l;
import k1.I;
import k1.K;

/* JADX INFO: loaded from: classes.dex */
public final class r implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k1.C f2351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2356f;

    public r(k1.C c2) {
        F0.i.e(c2, "source");
        this.f2351a = c2;
    }

    @Override // k1.I
    public final K c() {
        return this.f2351a.f3441a.c();
    }

    @Override // k1.I
    public final long m(C0193i c0193i, long j2) throws IOException {
        int i2;
        int iR;
        F0.i.e(c0193i, "sink");
        do {
            int i3 = this.f2355e;
            k1.C c2 = this.f2351a;
            if (i3 != 0) {
                long jM = c2.m(c0193i, Math.min(j2, i3));
                if (jM == -1) {
                    return -1L;
                }
                this.f2355e -= (int) jM;
                return jM;
            }
            c2.A(this.f2356f);
            this.f2356f = 0;
            if ((this.f2353c & 4) != 0) {
                return -1L;
            }
            i2 = this.f2354d;
            int iS = Y0.b.s(c2);
            this.f2355e = iS;
            this.f2352b = iS;
            int iJ = c2.j() & 255;
            this.f2353c = c2.j() & 255;
            Logger logger = s.f2357d;
            if (logger.isLoggable(Level.FINE)) {
                C0196l c0196l = f.f2300a;
                logger.fine(f.a(this.f2354d, this.f2352b, iJ, this.f2353c, true));
            }
            iR = c2.r() & Integer.MAX_VALUE;
            this.f2354d = iR;
            if (iJ != 9) {
                throw new IOException(iJ + " != TYPE_CONTINUATION");
            }
        } while (iR == i2);
        throw new IOException("TYPE_CONTINUATION streamId changed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
