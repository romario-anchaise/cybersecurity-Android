// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z1 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e2 f5659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ y.e f5660e;

    public /* synthetic */ z1(e2 e2Var, y.e eVar, int i3) {
        this.f5658c = i3;
        this.f5659d = e2Var;
        this.f5660e = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d2.t tVar;
        d2.t tVar2;
        switch (this.f5658c) {
            case 0:
                e2 e2Var = this.f5659d;
                y.e eVar = this.f5660e;
                a2.o oVar = e2Var.f3850d;
                AtomicBoolean atomicBoolean = e2Var.f3853g;
                d2.t tVar3 = (d2.t) eVar.f5976c;
                d2.t tVar4 = (d2.t) eVar.f5977d;
                if (tVar3 == null) {
                    if (atomicBoolean.get() || tVar4 == null || !oVar.a(tVar4)) {
                        return;
                    }
                    e2Var.s(tVar4.f612c);
                    return;
                }
                a2.b bVar = new a2.b(14, eVar);
                z1 z1Var = new z1(e2Var, eVar, 1);
                try {
                    bVar.run();
                    break;
                } catch (Throwable unused) {
                }
                boolean zT = e2Var.t(tVar3.f612c);
                if (zT) {
                    if ((e2Var.f3853g.get() || (tVar2 = (d2.t) eVar.f5977d) == null || !e2Var.f3850d.a(tVar2)) ? false : true) {
                        z1Var.run();
                    }
                }
                if (zT) {
                    return;
                }
                Log.w("CameraServer", "camera thread retirement pending; delaying next lease");
                long j3 = tVar3.f612c;
                while (!e2Var.t(j3)) {
                    if (atomicBoolean.get() || Thread.currentThread().isInterrupted()) {
                        Log.w("CameraServer", "camera retirement retry interrupted generation=" + j3);
                        return;
                    }
                }
                synchronized (oVar) {
                    tVar = (d2.t) oVar.f124c;
                }
                if (atomicBoolean.get() || tVar == null) {
                    return;
                }
                a2.h hVar = new a2.h(e2Var, tVar, 17);
                if (e2Var.f3850d.a(tVar)) {
                    hVar.run();
                    return;
                }
                return;
            default:
                this.f5659d.s(((d2.t) this.f5660e.f5977d).f612c);
                return;
        }
    }
}
