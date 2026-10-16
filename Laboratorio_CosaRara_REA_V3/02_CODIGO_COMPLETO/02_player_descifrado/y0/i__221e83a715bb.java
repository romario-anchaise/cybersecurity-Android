// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y0;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements x0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean[] f6060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f6061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o[] f6062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l f6063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Runnable[] f6064e;

    public i(boolean[] zArr, String str, o[] oVarArr, l lVar, Runnable[] runnableArr) {
        this.f6060a = zArr;
        this.f6061b = str;
        this.f6062c = oVarArr;
        this.f6063d = lVar;
        this.f6064e = runnableArr;
    }

    @Override // x0.a
    public final void a(Object... objArr) {
        if (this.f6060a[0]) {
            return;
        }
        Logger logger = l.A;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("probe transport '" + this.f6061b + "' opened");
        }
        a1.b bVar = new a1.b("probe", "ping");
        o[] oVarArr = this.f6062c;
        o oVar = oVarArr[0];
        oVar.getClass();
        f1.b.a(new g0.j(oVar, new a1.b[]{bVar}, 15));
        oVarArr[0].d("packet", new h(0, this));
    }
}
