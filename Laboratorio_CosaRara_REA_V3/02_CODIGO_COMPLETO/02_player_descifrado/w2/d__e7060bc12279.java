// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5755c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f5756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f5757e;

    public d(OutputStream outputStream, w wVar) {
        this.f5757e = outputStream;
        this.f5756d = wVar;
    }

    @Override // w2.v
    public final z a() {
        switch (this.f5755c) {
            case 0:
                break;
        }
        return this.f5756d;
    }

    @Override // w2.v, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f5755c) {
            case 0:
                d dVar = (d) this.f5757e;
                w wVar = this.f5756d;
                wVar.i();
                try {
                    try {
                        dVar.close();
                        if (wVar.j()) {
                            throw wVar.l(null);
                        }
                        return;
                    } catch (IOException e3) {
                        if (!wVar.j()) {
                            throw e3;
                        }
                        throw wVar.l(e3);
                    }
                } catch (Throwable th) {
                    wVar.j();
                    throw th;
                }
            default:
                ((OutputStream) this.f5757e).close();
                return;
        }
    }

    @Override // w2.v, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f5755c) {
            case 0:
                d dVar = (d) this.f5757e;
                w wVar = this.f5756d;
                wVar.i();
                try {
                    try {
                        dVar.flush();
                        if (wVar.j()) {
                            throw wVar.l(null);
                        }
                        return;
                    } catch (IOException e3) {
                        if (!wVar.j()) {
                            throw e3;
                        }
                        throw wVar.l(e3);
                    }
                } catch (Throwable th) {
                    wVar.j();
                    throw th;
                }
            default:
                ((OutputStream) this.f5757e).flush();
                return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x008f A[LOOP:1: B:12:0x0058->B:25:0x008f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:49:0x0091 A[SYNTHETIC] */
    @Override // w2.v
    public final void t(long j3, h hVar) throws IOException {
        w wVar;
        switch (this.f5755c) {
            case 0:
                b.c(hVar.f5777d, 0L, j3);
                long j4 = j3;
                while (true) {
                    long j5 = 0;
                    if (j4 <= 0) {
                        return;
                    }
                    s sVar = hVar.f5776c;
                    sVar.getClass();
                    try {
                        try {
                            while (j5 < 65536) {
                                j5 += (long) (sVar.f5803c - sVar.f5802b);
                                if (j5 >= j4) {
                                    j5 = j4;
                                    d dVar = (d) this.f5757e;
                                    wVar = this.f5756d;
                                    wVar.i();
                                    dVar.t(j5, hVar);
                                    if (!wVar.j()) {
                                        throw wVar.l(null);
                                    }
                                    j4 -= j5;
                                } else {
                                    sVar = sVar.f5806f;
                                    sVar.getClass();
                                }
                            }
                            dVar.t(j5, hVar);
                            if (!wVar.j()) {
                                throw wVar.l(null);
                            }
                            j4 -= j5;
                        } catch (IOException e3) {
                            if (!wVar.j()) {
                                throw e3;
                            }
                            throw wVar.l(e3);
                        }
                    } catch (Throwable th) {
                        wVar.j();
                        throw th;
                    }
                    d dVar2 = (d) this.f5757e;
                    wVar = this.f5756d;
                    wVar.i();
                }
                break;
            default:
                b.c(hVar.f5777d, 0L, j3);
                while (j3 > 0) {
                    this.f5756d.f();
                    s sVar2 = hVar.f5776c;
                    sVar2.getClass();
                    int iMin = (int) Math.min(j3, sVar2.f5803c - sVar2.f5802b);
                    ((OutputStream) this.f5757e).write(sVar2.f5801a, sVar2.f5802b, iMin);
                    int i3 = sVar2.f5802b + iMin;
                    sVar2.f5802b = i3;
                    long j6 = iMin;
                    j3 -= j6;
                    hVar.f5777d -= j6;
                    if (i3 == sVar2.f5803c) {
                        hVar.f5776c = sVar2.a();
                        t.a(sVar2);
                    }
                }
                return;
        }
    }

    public final String toString() {
        switch (this.f5755c) {
            case 0:
                return "AsyncTimeout.sink(" + ((d) this.f5757e) + ')';
            default:
                return "sink(" + ((OutputStream) this.f5757e) + ')';
        }
    }

    public d(w wVar, d dVar) {
        this.f5756d = wVar;
        this.f5757e = dVar;
    }
}
