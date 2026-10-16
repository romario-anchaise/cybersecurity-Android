// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s f3416d;

    public /* synthetic */ p(s sVar, int i3) {
        this.f3415c = i3;
        this.f3416d = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3415c) {
            case 0:
                if (!this.f3416d.f3425b) {
                    s sVar = this.f3416d;
                    k kVar = sVar.f3428e;
                    if (!kVar.f3396d) {
                        if (sVar.f3431h == null) {
                            sVar.f3431h = new o(sVar, kVar);
                        }
                        k kVar2 = this.f3416d.f3428e;
                        kVar2.getClass();
                        f1.b.a(new g0.j(kVar2, null, 6));
                        s sVar2 = this.f3416d;
                        if (3 == sVar2.f3428e.f3408q) {
                            s.e(sVar2);
                        }
                        break;
                    }
                }
                break;
            default:
                if (this.f3416d.f3425b) {
                    Logger logger = s.f3424m;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine("performing disconnect (" + this.f3416d.f3427d + ")");
                    }
                    this.f3416d.l(new e1.d(1));
                }
                this.f3416d.h();
                if (this.f3416d.f3425b) {
                    this.f3416d.j("io client disconnect");
                }
                break;
        }
    }
}
