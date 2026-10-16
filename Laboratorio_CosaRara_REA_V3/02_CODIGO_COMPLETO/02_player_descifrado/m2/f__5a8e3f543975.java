// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m2;

import i2.q;
import i2.u;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i2.e f2711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile AtomicInteger f2712d = new AtomicInteger(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i f2713e;

    public f(i iVar, i2.e eVar) {
        this.f2713e = iVar;
        this.f2711c = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u uVar;
        String strConcat = "OkHttp ".concat(((q) this.f2713e.f2717d.f266c).f());
        i iVar = this.f2713e;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(strConcat);
        try {
            iVar.f2721h.i();
            boolean z2 = false;
            try {
                try {
                    try {
                        this.f2711c.b(iVar, iVar.g());
                        uVar = iVar.f2716c;
                    } catch (IOException e3) {
                        e = e3;
                        z2 = true;
                        if (z2) {
                            q2.m mVar = q2.m.f3156a;
                            q2.m mVar2 = q2.m.f3156a;
                            String strConcat2 = "Callback failure for ".concat(i.a(iVar));
                            mVar2.getClass();
                            q2.m.g(strConcat2, 4, e);
                        } else {
                            this.f2711c.c(iVar, e);
                        }
                        uVar = iVar.f2716c;
                    } catch (Throwable th) {
                        th = th;
                        z2 = true;
                        iVar.d();
                        if (!z2) {
                            IOException iOException = new IOException("canceled due to " + th);
                            y.f.a(iOException, th);
                            this.f2711c.c(iVar, iOException);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    iVar.f2716c.f2238c.a(this);
                    throw th2;
                }
            } catch (IOException e4) {
                e = e4;
            } catch (Throwable th3) {
                th = th3;
            }
            uVar.f2238c.a(this);
            threadCurrentThread.setName(name);
        } catch (Throwable th4) {
            threadCurrentThread.setName(name);
            throw th4;
        }
    }
}
