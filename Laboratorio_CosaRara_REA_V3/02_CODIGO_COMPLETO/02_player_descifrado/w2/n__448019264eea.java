// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f5788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Inflater f5789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5791f;

    public n(r rVar, Inflater inflater) {
        this.f5788c = rVar;
        this.f5789d = inflater;
    }

    @Override // w2.x
    public final z a() {
        return this.f5788c.f5798c.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f5791f) {
            return;
        }
        this.f5789d.end();
        this.f5791f = true;
        this.f5788c.close();
    }

    public final long d(long j3, h hVar) throws IOException {
        Inflater inflater = this.f5789d;
        if (j3 < 0) {
            o2.j("byteCount < 0: ", j3);
            return 0L;
        }
        if (this.f5791f) {
            o2.k("closed");
            return 0L;
        }
        if (j3 != 0) {
            try {
                s sVarF = hVar.F(1);
                int iMin = (int) Math.min(j3, 8192 - sVarF.f5803c);
                boolean zNeedsInput = inflater.needsInput();
                r rVar = this.f5788c;
                if (zNeedsInput && !rVar.d()) {
                    s sVar = rVar.f5799d.f5776c;
                    sVar.getClass();
                    int i3 = sVar.f5803c;
                    int i4 = sVar.f5802b;
                    int i5 = i3 - i4;
                    this.f5790e = i5;
                    inflater.setInput(sVar.f5801a, i4, i5);
                }
                int iInflate = inflater.inflate(sVarF.f5801a, sVarF.f5803c, iMin);
                int i6 = this.f5790e;
                if (i6 != 0) {
                    int remaining = i6 - inflater.getRemaining();
                    this.f5790e -= remaining;
                    rVar.skip(remaining);
                }
                if (iInflate > 0) {
                    sVarF.f5803c += iInflate;
                    long j4 = iInflate;
                    hVar.f5777d += j4;
                    return j4;
                }
                if (sVarF.f5802b == sVarF.f5803c) {
                    hVar.f5776c = sVarF.a();
                    t.a(sVarF);
                }
            } catch (DataFormatException e3) {
                throw new IOException(e3);
            }
        }
        return 0L;
    }

    @Override // w2.x
    public final long f(long j3, h hVar) {
        do {
            long jD = d(8192L, hVar);
            if (jD > 0) {
                return jD;
            }
            Inflater inflater = this.f5789d;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.f5788c.d());
        throw new EOFException("source exhausted prematurely");
    }
}
