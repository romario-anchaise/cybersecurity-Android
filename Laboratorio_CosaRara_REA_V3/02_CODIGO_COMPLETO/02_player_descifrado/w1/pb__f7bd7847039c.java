// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.SystemClock;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pb implements l4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f4865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f4866e;

    public /* synthetic */ pb(Object obj, long j3, int i3) {
        this.f4864c = i3;
        this.f4865d = obj;
        this.f4866e = j3;
    }

    public void a(g2.u0 u0Var, String str, byte[] bArr) {
        g2.k0 k0Var = (g2.k0) this.f4865d;
        if (k0Var.C() && k0Var.f1663q.get() == this.f4866e) {
            AtomicBoolean atomicBoolean = k0Var.f1665s;
            boolean z2 = false;
            try {
                g2.z0 z0Var = k0Var.f1652e;
                g2.r0 r0Var = (g2.r0) k0Var.f1666t.get();
                boolean zI = z0Var.i((r0Var.f1723a && u0Var == g2.u0.f1753l) ? new g2.p0(u0Var, "camera:frame:v2", Collections.singletonList(q2.k.f(3, Collections.singletonList(bArr), r0Var.f1724b)), null) : new g2.p0(u0Var, str, Collections.singletonList(bArr), null));
                g2.u0 u0Var2 = g2.u0.f1750i;
                if (zI && u0Var == u0Var2) {
                    atomicBoolean.set(false);
                } else if (!zI && u0Var == u0Var2) {
                    atomicBoolean.set(false);
                    k0Var.N();
                }
                k0Var.E();
                z2 = zI;
            } catch (IllegalArgumentException unused) {
            }
            if (z2) {
                k0Var.O();
            }
        }
    }

    @Override // w1.l4
    public k4 e() {
        switch (this.f4864c) {
            case 0:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f4865d;
                return (screenMirrorService.X || screenMirrorService.Y || SystemClock.uptimeMillis() > this.f4866e) ? k4.a(12) : k4.f4389c;
            default:
                ScreenMirrorService screenMirrorService2 = (ScreenMirrorService) this.f4865d;
                return (this.f4866e == screenMirrorService2.f2536r2 && screenMirrorService2.b4() && screenMirrorService2.J3()) ? k4.f4389c : k4.a(13);
        }
    }
}
