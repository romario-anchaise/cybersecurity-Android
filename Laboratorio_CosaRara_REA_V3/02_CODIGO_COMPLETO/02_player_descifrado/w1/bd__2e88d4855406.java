// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.SystemClock;
import java.io.DataOutputStream;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g2.m0 f3605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v8 f3606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j2 f3607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g2.m0 f3609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f3610f = new AtomicBoolean();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataOutputStream f3611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedBlockingQueue f3612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f3613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f3614j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f3615k;

    public bd(ScreenMirrorService screenMirrorService, g2.m0 m0Var, v8 v8Var, j2 j2Var, int i3) {
        this.f3615k = screenMirrorService;
        this.f3612h = new LinkedBlockingQueue(Arrays.equals(screenMirrorService.g4, ScreenMirrorService.r6) ? 2 : 8);
        this.f3613i = true;
        this.f3605a = m0Var;
        this.f3606b = v8Var;
        this.f3607c = j2Var;
        this.f3608d = i3;
        this.f3609e = m0Var;
    }

    public final void a() {
        if (this.f3610f.compareAndSet(false, true)) {
            this.f3613i = false;
            v8 v8Var = this.f3606b;
            if (v8Var != null) {
                try {
                    v8Var.run();
                } catch (Exception unused) {
                }
            }
            this.f3615k.L3.remove(this);
        }
    }

    public final boolean b() {
        j2 j2Var = this.f3607c;
        return j2Var == null || j2Var.b(this.f3608d, this.f3609e);
    }

    public final void c(boolean z2) {
        if (z2) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (jUptimeMillis - this.f3614j < 500) {
            return;
        }
        this.f3614j = jUptimeMillis;
        this.f3615k.W5();
    }
}
