// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package o2;

import w1.o2;
import w2.h;
import w2.i;
import w2.l;
import w2.v;
import w2.z;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f2792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g f2794e;

    public b(g gVar) {
        this.f2794e = gVar;
        this.f2792c = new l(((i) gVar.f2810e).a());
    }

    @Override // w2.v
    public final z a() {
        return this.f2792c;
    }

    @Override // w2.v, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f2793d) {
            return;
        }
        this.f2793d = true;
        ((i) this.f2794e.f2810e).q("0\r\n\r\n");
        l lVar = this.f2792c;
        z zVar = lVar.f5782e;
        lVar.f5782e = z.f5814d;
        zVar.a();
        zVar.b();
        this.f2794e.f2806a = 3;
    }

    @Override // w2.v, java.io.Flushable
    public final synchronized void flush() {
        if (this.f2793d) {
            return;
        }
        ((i) this.f2794e.f2810e).flush();
    }

    @Override // w2.v
    public final void t(long j3, h hVar) {
        i iVar = (i) this.f2794e.f2810e;
        if (this.f2793d) {
            o2.k("closed");
        } else {
            if (j3 == 0) {
                return;
            }
            iVar.c(j3);
            iVar.q("\r\n");
            iVar.t(j3, hVar);
            iVar.q("\r\n");
        }
    }
}
