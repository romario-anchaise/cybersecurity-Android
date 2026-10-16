// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import A.C0005e;
import android.content.Context;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;
import m1.C0210n;
import m1.InterfaceC0204h;
import m1.O;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f218d;

    public /* synthetic */ n(Object obj, Object obj2, Object obj3, int i2) {
        this.f215a = i2;
        this.f216b = obj;
        this.f217c = obj2;
        this.f218d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f215a) {
            case 0:
                C0005e c0005e = (C0005e) this.f216b;
                f1.l lVar = (f1.l) this.f217c;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f218d;
                c0005e.getClass();
                try {
                    v vVarK = f1.d.k((Context) c0005e.f34b);
                    if (vVarK == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    u uVar = (u) ((k) vVarK.f200b);
                    synchronized (uVar.f239d) {
                        uVar.f241f = threadPoolExecutor;
                        break;
                    }
                    ((k) vVarK.f200b).v(new o(lVar, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    lVar.I(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 1:
                C0210n c0210n = (C0210n) ((s) this.f216b).f233c;
                boolean zN = c0210n.f3844b.n();
                InterfaceC0204h interfaceC0204h = (InterfaceC0204h) this.f217c;
                if (zN) {
                    interfaceC0204h.j(c0210n, new IOException("Canceled"));
                    return;
                } else {
                    interfaceC0204h.b(c0210n, (O) this.f218d);
                    return;
                }
            default:
                ((InterfaceC0204h) this.f217c).j((C0210n) ((s) this.f216b).f233c, (Throwable) this.f218d);
                return;
        }
    }
}
