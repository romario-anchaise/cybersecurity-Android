// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package o2;

import java.io.IOException;
import java.util.zip.Deflater;
import w1.o2;
import w2.h;
import w2.i;
import w2.l;
import w2.q;
import w2.s;
import w2.t;
import w2.v;
import w2.z;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2801c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f2803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f2804f;

    public e(g gVar) {
        this.f2804f = gVar;
        this.f2803e = new l(((i) gVar.f2810e).a());
    }

    @Override // w2.v
    public final z a() {
        switch (this.f2801c) {
            case 0:
                return (l) this.f2803e;
            default:
                return ((q) this.f2803e).f5795c.a();
        }
    }

    @Override // w2.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        switch (this.f2801c) {
            case 0:
                g gVar = (g) this.f2804f;
                if (this.f2802d) {
                    return;
                }
                this.f2802d = true;
                l lVar = (l) this.f2803e;
                z zVar = lVar.f5782e;
                lVar.f5782e = z.f5814d;
                zVar.a();
                zVar.b();
                gVar.f2806a = 3;
                return;
            default:
                Deflater deflater = (Deflater) this.f2804f;
                if (this.f2802d) {
                    return;
                }
                deflater.finish();
                d(false);
                th = null;
                try {
                    deflater.end();
                    break;
                } catch (Throwable th) {
                    if (th == null) {
                        th = th;
                    }
                }
                try {
                    ((q) this.f2803e).close();
                    break;
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    }
                }
                this.f2802d = true;
                if (th != null) {
                    throw th;
                }
                return;
        }
    }

    public void d(boolean z2) throws IOException {
        s sVarF;
        int iDeflate;
        Deflater deflater = (Deflater) this.f2804f;
        q qVar = (q) this.f2803e;
        h hVar = qVar.f5796d;
        while (true) {
            sVarF = hVar.F(1);
            byte[] bArr = sVarF.f5801a;
            int i3 = sVarF.f5803c;
            if (z2) {
                try {
                    iDeflate = deflater.deflate(bArr, i3, 8192 - i3, 2);
                } catch (NullPointerException e3) {
                    throw new IOException("Deflater already closed", e3);
                }
            } else {
                iDeflate = deflater.deflate(bArr, i3, 8192 - i3);
            }
            if (iDeflate > 0) {
                sVarF.f5803c += iDeflate;
                hVar.f5777d += (long) iDeflate;
                qVar.d();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (sVarF.f5802b == sVarF.f5803c) {
            hVar.f5776c = sVarF.a();
            t.a(sVarF);
        }
    }

    @Override // w2.v, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f2801c) {
            case 0:
                if (!this.f2802d) {
                    ((i) ((g) this.f2804f).f2810e).flush();
                    break;
                }
                break;
            default:
                d(true);
                ((q) this.f2803e).flush();
                break;
        }
    }

    @Override // w2.v
    public final void t(long j3, h hVar) throws IOException {
        switch (this.f2801c) {
            case 0:
                if (!this.f2802d) {
                    j2.b.c(hVar.f5777d, 0L, j3);
                    ((i) ((g) this.f2804f).f2810e).t(j3, hVar);
                } else {
                    o2.k("closed");
                }
                break;
            default:
                w2.b.c(hVar.f5777d, 0L, j3);
                while (j3 > 0) {
                    s sVar = hVar.f5776c;
                    sVar.getClass();
                    int iMin = (int) Math.min(j3, sVar.f5803c - sVar.f5802b);
                    ((Deflater) this.f2804f).setInput(sVar.f5801a, sVar.f5802b, iMin);
                    d(false);
                    long j4 = iMin;
                    hVar.f5777d -= j4;
                    int i3 = sVar.f5802b + iMin;
                    sVar.f5802b = i3;
                    if (i3 == sVar.f5803c) {
                        hVar.f5776c = sVar.a();
                        t.a(sVar);
                    }
                    j3 -= j4;
                }
                break;
        }
    }

    public String toString() {
        switch (this.f2801c) {
            case 1:
                return "DeflaterSink(" + ((q) this.f2803e) + ')';
            default:
                return super.toString();
        }
    }

    public e(h hVar, Deflater deflater) {
        this.f2803e = new q(hVar);
        this.f2804f = deflater;
    }
}
