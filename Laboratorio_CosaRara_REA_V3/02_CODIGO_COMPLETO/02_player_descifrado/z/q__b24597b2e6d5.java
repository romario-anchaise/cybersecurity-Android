// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

import android.content.Context;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a0.l f6265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ UUID f6266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p.f f6267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Context f6268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ r f6269g;

    public q(r rVar, a0.l lVar, UUID uuid, p.f fVar, Context context) {
        this.f6269g = rVar;
        this.f6265c = lVar;
        this.f6266d = uuid;
        this.f6267e = fVar;
        this.f6268f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (!(this.f6265c.f32c instanceof a0.b)) {
                String string = this.f6266d.toString();
                y.o oVarH = this.f6269g.f6272c.h(string);
                if (oVarH == null || a0.a.b(oVarH.f6000b)) {
                    throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                }
                this.f6269g.f6271b.f(string, this.f6267e);
                this.f6268f.startService(x.a.a(this.f6268f, m0.a.h(oVarH), this.f6267e));
            }
            this.f6265c.i(null);
        } catch (Throwable th) {
            this.f6265c.j(th);
        }
    }
}
