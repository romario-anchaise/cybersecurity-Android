// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import H.x;
import X0.InterfaceC0058e;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0058e f2126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile AtomicInteger f2127b = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f2128c;

    public g(j jVar, InterfaceC0058e interfaceC0058e) {
        this.f2128c = jVar;
        this.f2126a = interfaceC0058e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar;
        String strConcat = "OkHttp ".concat(((X0.p) this.f2128c.f2132b.f1099c).g());
        j jVar = this.f2128c;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(strConcat);
        try {
            jVar.f2134d.h();
            boolean z2 = false;
            try {
                try {
                    try {
                        this.f2126a.h(jVar.i());
                        xVar = jVar.f2131a.f1066a;
                    } catch (IOException e2) {
                        e = e2;
                        z2 = true;
                        if (z2) {
                            f1.n nVar = f1.n.f2736a;
                            f1.n nVar2 = f1.n.f2736a;
                            String str = "Callback failure for " + j.b(jVar);
                            nVar2.getClass();
                            f1.n.i(str, 4, e);
                        } else {
                            this.f2126a.g(jVar, e);
                        }
                        xVar = jVar.f2131a.f1066a;
                    } catch (Throwable th) {
                        th = th;
                        z2 = true;
                        jVar.cancel();
                        if (!z2) {
                            IOException iOException = new IOException("canceled due to " + th);
                            p029q.j.a(iOException, th);
                            this.f2126a.g(jVar, iOException);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    jVar.f2131a.f1066a.d(this);
                    throw th2;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
            }
            xVar.d(this);
            threadCurrentThread.setName(name);
        } catch (Throwable th4) {
            threadCurrentThread.setName(name);
            throw th4;
        }
    }
}
