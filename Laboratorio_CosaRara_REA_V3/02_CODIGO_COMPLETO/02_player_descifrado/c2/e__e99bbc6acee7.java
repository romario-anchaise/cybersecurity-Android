// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f412d;

    public /* synthetic */ e(f fVar, int i3) {
        this.f411c = i3;
        this.f412d = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        ScreenMirrorService screenMirrorService;
        Handler handler;
        switch (this.f411c) {
            case 0:
                if (this.f412d.f417d) {
                    f fVar2 = this.f412d;
                    if (fVar2.f416c == null) {
                        return;
                    }
                    try {
                        f.a(fVar2);
                        break;
                    } catch (Throwable th) {
                        a0.a.p(th, new StringBuilder("tick failed: "), "A11yHealth");
                    }
                    if (this.f412d.f417d) {
                        this.f412d.f414a.postDelayed(this, 15000L);
                        return;
                    }
                    return;
                }
                return;
            default:
                synchronized (this.f412d) {
                    if (this.f412d.f417d && (screenMirrorService = (fVar = this.f412d).f416c) != null && (handler = fVar.f420g) != null) {
                        try {
                            Object obj = w1.f.f3944a;
                            w1.f.a(screenMirrorService, new w1.c(Process.myPid(), 2, SystemClock.elapsedRealtime()));
                            break;
                        } catch (Throwable th2) {
                            a0.a.p(th2, new StringBuilder("bind lease heartbeat failed: "), "A11yHealth");
                        }
                        synchronized (this.f412d) {
                            try {
                                if (this.f412d.f417d && this.f412d.f420g == handler) {
                                    handler.postDelayed(this, 5000L);
                                }
                            } catch (Throwable th3) {
                                throw th3;
                            }
                            break;
                        }
                        return;
                    }
                    return;
                }
        }
    }
}
