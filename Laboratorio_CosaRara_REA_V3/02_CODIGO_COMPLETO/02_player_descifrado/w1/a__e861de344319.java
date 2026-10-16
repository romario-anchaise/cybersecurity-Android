// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f3438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f3439e;

    public /* synthetic */ a(Context context, boolean z2, int i3) {
        this.f3437c = i3;
        this.f3438d = context;
        this.f3439e = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3437c) {
            case 0:
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                final boolean z2 = this.f3439e;
                f.a(this.f3438d, new d() { // from class: w1.b
                    @Override // w1.d
                    public final e a(e eVar) {
                        boolean z3 = z2;
                        long j3 = jElapsedRealtime;
                        if (z3 || !eVar.b(j3)) {
                            return new e(true, false, eVar.f3825c, 0, z3 ? 0L : eVar.f3827e, j3, j3 > 9223372036854715807L ? Long.MAX_VALUE : 60000 + j3, eVar.f3830h, eVar.f3831i);
                        }
                        return eVar;
                    }
                });
                break;
            default:
                s8.f(this.f3438d, this.f3439e);
                break;
        }
    }
}
