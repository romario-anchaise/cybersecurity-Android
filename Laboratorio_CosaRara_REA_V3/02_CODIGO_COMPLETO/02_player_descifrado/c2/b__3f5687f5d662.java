// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f402d;

    public b(c cVar, long j3) {
        this.f402d = cVar;
        this.f401c = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f402d) {
            try {
                boolean z2 = this.f402d.f406c;
                c cVar = this.f402d;
                ScreenMirrorService screenMirrorService = cVar.f405b;
                boolean z3 = false;
                if (z2 && (screenMirrorService != null) && this.f401c == cVar.f408e) {
                    boolean zG = c.g(screenMirrorService);
                    if (!zG && c.f(this.f402d.f405b)) {
                        this.f402d.i("own-ui-foreground");
                        return;
                    }
                    if (zG) {
                        Log.d("AbeTouch", "passive heartbeat src=heartbeat");
                    } else {
                        this.f402d.a("heartbeat");
                    }
                    synchronized (this.f402d) {
                        try {
                            boolean z4 = this.f402d.f406c;
                            c cVar2 = this.f402d;
                            boolean z5 = cVar2.f405b != null;
                            long j3 = this.f401c;
                            long j4 = cVar2.f408e;
                            if (z4 && z5 && j3 == j4) {
                                z3 = true;
                            }
                            if (z3) {
                                cVar2.f404a.postDelayed(this, cVar2.d());
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
