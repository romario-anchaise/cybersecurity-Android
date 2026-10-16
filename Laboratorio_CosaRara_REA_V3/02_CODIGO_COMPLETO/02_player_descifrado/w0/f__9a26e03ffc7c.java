// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

import android.os.SystemClock;
import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;
import w1.aa;
import w1.z8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3384c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f3385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f3386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f3387f;

    public f(z8 z8Var, String str, long j3) {
        this.f3387f = z8Var;
        this.f3386e = str;
        this.f3385d = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3384c) {
            case 0:
                k.f3393r.fine(String.format("connect attempt timed out after %d", Long.valueOf(this.f3385d)));
                ((l) this.f3386e).destroy();
                y0.l lVar = (y0.l) this.f3387f;
                lVar.getClass();
                f1.b.a(new y0.e(lVar, 3));
                lVar.a("error", new t("timeout"));
                return;
            default:
                synchronized (((z8) this.f3387f).f5720e) {
                    try {
                        if (((z8) this.f3387f).f5723h) {
                            return;
                        }
                        boolean zEquals = "immediate".equals((String) this.f3386e);
                        z8 z8Var = (z8) this.f3387f;
                        if (zEquals) {
                            if (z8Var.f5721f != this) {
                                return;
                            } else {
                                z8Var.f5721f = null;
                            }
                        } else if (z8Var.f5722g != this) {
                            return;
                        } else {
                            z8Var.f5722g = null;
                        }
                        aa aaVar = z8Var.f5719d;
                        long j3 = this.f3385d;
                        String str = (String) this.f3386e;
                        ScreenMirrorService screenMirrorService = aaVar.f3491d;
                        synchronized (screenMirrorService.f2543u) {
                            if (!screenMirrorService.X && !screenMirrorService.Y) {
                                Log.d("MirrorPerf", "event=post_control_refresh_fire interaction=" + j3 + " phase=" + str + " uptimeMs=" + SystemClock.uptimeMillis());
                                screenMirrorService.P2.incrementAndGet();
                                StringBuilder sb = new StringBuilder("post_control_");
                                sb.append(str);
                                sb.append("_");
                                sb.append(j3);
                                screenMirrorService.Y5(sb.toString(), false);
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
        }
    }

    public f(long j3, l lVar, j jVar) {
        this.f3385d = j3;
        this.f3386e = lVar;
        this.f3387f = jVar;
    }
}
