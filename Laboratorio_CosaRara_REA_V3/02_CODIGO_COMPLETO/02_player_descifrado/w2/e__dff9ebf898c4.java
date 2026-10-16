// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f5759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f5760e;

    public /* synthetic */ e(Object obj, Object obj2, int i3) {
        this.f5758c = i3;
        this.f5759d = obj;
        this.f5760e = obj2;
    }

    @Override // w2.x
    public final z a() {
        switch (this.f5758c) {
            case 0:
                return (w) this.f5759d;
            default:
                return (z) this.f5760e;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f5758c) {
            case 0:
                w wVar = (w) this.f5759d;
                e eVar = (e) this.f5760e;
                wVar.i();
                try {
                    try {
                        eVar.close();
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
                ((InputStream) this.f5759d).close();
                return;
        }
    }

    @Override // w2.x
    public final long f(long j3, h hVar) throws IOException {
        switch (this.f5758c) {
            case 0:
                w wVar = (w) this.f5759d;
                e eVar = (e) this.f5760e;
                wVar.i();
                try {
                    try {
                        long jF = eVar.f(8192L, hVar);
                        if (wVar.j()) {
                            throw wVar.l(null);
                        }
                        return jF;
                    } catch (IOException e3) {
                        if (wVar.j()) {
                            throw wVar.l(e3);
                        }
                        throw e3;
                    }
                } catch (Throwable th) {
                    wVar.j();
                    throw th;
                }
            default:
                try {
                    ((z) this.f5760e).f();
                    s sVarF = hVar.F(1);
                    int i3 = ((InputStream) this.f5759d).read(sVarF.f5801a, sVarF.f5803c, (int) Math.min(8192L, 8192 - sVarF.f5803c));
                    if (i3 == -1) {
                        if (sVarF.f5802b == sVarF.f5803c) {
                            hVar.f5776c = sVarF.a();
                            t.a(sVarF);
                        }
                        return -1L;
                    }
                    sVarF.f5803c += i3;
                    long j4 = i3;
                    hVar.f5777d += j4;
                    return j4;
                } catch (AssertionError e4) {
                    if (b.d(e4)) {
                        throw new IOException(e4);
                    }
                    throw e4;
                }
        }
    }

    public final String toString() {
        switch (this.f5758c) {
            case 0:
                return "AsyncTimeout.source(" + ((e) this.f5760e) + ')';
            default:
                return "source(" + ((InputStream) this.f5759d) + ')';
        }
    }
}
