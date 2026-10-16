// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

import android.content.Context;
import android.os.Build;
import w1.ba;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f6258i = p.m.f("WorkForegroundRunnable");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0.l f6259c = new a0.l();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f6260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y.o f6261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p.l f6262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r f6263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y.r f6264h;

    public p(Context context, y.o oVar, p.l lVar, r rVar, y.r rVar2) {
        this.f6260d = context;
        this.f6261e = oVar;
        this.f6262f = lVar;
        this.f6263g = rVar;
        this.f6264h = rVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f6261e.f6014q || Build.VERSION.SDK_INT >= 31) {
            this.f6259c.i(null);
            return;
        }
        a0.l lVar = new a0.l();
        y.r rVar = this.f6264h;
        ((b0.a) rVar.f6034c).execute(new ba(this, lVar, 19));
        lVar.b(new g0.j(this, lVar, 17), (b0.a) rVar.f6034c);
    }
}
