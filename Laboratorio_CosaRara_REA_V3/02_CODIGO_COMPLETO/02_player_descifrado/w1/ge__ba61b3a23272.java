// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ge implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ cf f4152d;

    public /* synthetic */ ge(cf cfVar, int i3) {
        this.f4151c = i3;
        this.f4152d = cfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        int i3 = this.f4151c;
        cf cfVar = this.f4152d;
        switch (i3) {
            case 0:
                int i4 = cfVar.f3708i.get();
                cfVar.I0(i4);
                if (cfVar.f3694b.get() && cfVar.f3705g0) {
                    cfVar.a0(Math.max(0L, Math.max(0L, 30000 - (cfVar.f3735w0 > 0 ? Math.max(0L, SystemClock.elapsedRealtime() - cfVar.f3735w0) : 0L))), new ne(cfVar, i4, 4));
                    return;
                }
                return;
            case 1:
                cfVar.s0();
                return;
            case 2:
                g2.a0 a0Var = cfVar.f3727s0;
                if (a0Var == null || !cfVar.f3694b.get()) {
                    return;
                }
                new Thread(new ba(cfVar, a0Var, 10), "tunnel-stats-report").start();
                return;
            case 3:
                while (true) {
                    long jMin = 250;
                    while (true) {
                        try {
                            if (Thread.currentThread().isInterrupted()) {
                                cfVar.f3736x.set(false);
                                if (cfVar.f3734w.get() == null || !cfVar.f3694b.get() || cfVar.f3727s0 == null) {
                                    return;
                                }
                            } else {
                                str = (String) cfVar.f3734w.get();
                                if (str == null || !cfVar.f3694b.get() || cfVar.f3727s0 == null) {
                                    cfVar.f3736x.set(false);
                                    if (cfVar.f3734w.get() == null || !cfVar.f3694b.get() || cfVar.f3727s0 == null) {
                                        return;
                                    }
                                } else {
                                    String strX0 = cfVar.x0(str);
                                    boolean zOptBoolean = true;
                                    if (strX0 != null && !strX0.isEmpty()) {
                                        try {
                                            JSONObject jSONObject = new JSONObject(strX0);
                                            zOptBoolean = !jSONObject.optBoolean("ok", false) ? jSONObject.optBoolean("retry", true) : false;
                                            break;
                                        } catch (JSONException unused) {
                                        }
                                    }
                                    if (zOptBoolean) {
                                        try {
                                            Thread.sleep(jMin);
                                            jMin = Math.min(5000L, jMin * 2);
                                        } catch (InterruptedException unused2) {
                                            Thread.currentThread().interrupt();
                                            cfVar.f3736x.set(false);
                                            if (cfVar.f3734w.get() == null || !cfVar.f3694b.get() || cfVar.f3727s0 == null) {
                                                return;
                                            }
                                            cfVar.s0();
                                            return;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            cfVar.f3736x.set(false);
                            if (cfVar.f3734w.get() != null && cfVar.f3694b.get() && cfVar.f3727s0 != null) {
                                cfVar.s0();
                            }
                            throw th;
                        }
                    }
                    AtomicReference atomicReference = cfVar.f3734w;
                    while (!atomicReference.compareAndSet(str, null) && atomicReference.get() == str) {
                    }
                }
                cfVar.s0();
                return;
            case 4:
                cfVar.Q.j();
                return;
            case 5:
                cfVar.A.set(false);
                int i5 = cfVar.f3708i.get();
                if (cfVar.f3740z == null && cfVar.f3694b.get() && !cfVar.O()) {
                    cfVar.F0(i5);
                    return;
                }
                return;
            case 6:
                if (cfVar.f3694b.get() && cfVar.f3706h == h2.c.f1965h) {
                    return;
                }
                cfVar.J("screen_off_recovery_deadline", false);
                return;
            default:
                cfVar.Q.g(Long.MAX_VALUE);
                return;
        }
    }
}
