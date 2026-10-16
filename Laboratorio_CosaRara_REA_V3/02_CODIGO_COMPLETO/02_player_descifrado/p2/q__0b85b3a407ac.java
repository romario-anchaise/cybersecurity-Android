// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements w2.x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w2.j f2956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2961h;

    public q(w2.j jVar) {
        jVar.getClass();
        this.f2956c = jVar;
    }

    @Override // w2.x
    public final w2.z a() {
        return this.f2956c.a();
    }

    @Override // w2.x
    public final long f(long j3, w2.h hVar) throws IOException {
        int i3;
        int i4;
        do {
            int i5 = this.f2960g;
            w2.j jVar = this.f2956c;
            if (i5 == 0) {
                jVar.skip(this.f2961h);
                this.f2961h = 0;
                if ((this.f2958e & 4) == 0) {
                    i3 = this.f2959f;
                    int iT = j2.b.t(jVar);
                    this.f2960g = iT;
                    this.f2957d = iT;
                    int i6 = jVar.readByte() & 255;
                    this.f2958e = jVar.readByte() & 255;
                    Logger logger = r.f2962f;
                    if (logger.isLoggable(Level.FINE)) {
                        w2.k kVar = f.f2903a;
                        logger.fine(f.a(true, this.f2959f, this.f2957d, i6, this.f2958e));
                    }
                    i4 = jVar.readInt() & Integer.MAX_VALUE;
                    this.f2959f = i4;
                    if (i6 != 9) {
                        throw new IOException(i6 + " != TYPE_CONTINUATION");
                    }
                }
            } else {
                long jF = jVar.f(Math.min(8192L, i5), hVar);
                if (jF != -1) {
                    this.f2960g -= (int) jF;
                    return jF;
                }
            }
            return -1L;
        } while (i4 == i3);
        o2.l("TYPE_CONTINUATION streamId changed");
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
