// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class sc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f5089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ sf f5090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f5092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5093e;

    public sc(Handler handler, sf sfVar, int i3, long j3, int i4) {
        this.f5089a = handler;
        this.f5090b = sfVar;
        this.f5091c = i3;
        this.f5092d = j3;
        this.f5093e = i4;
    }

    public final boolean a(f2 f2Var) {
        boolean z2;
        sf sfVar = this.f5090b;
        if (sfVar.f5104f.get() || Looper.myLooper() != Looper.getMainLooper()) {
            return false;
        }
        if (sfVar.f5106h) {
            f2Var.run();
            return true;
        }
        c8 c8Var = sfVar.f5108j;
        b8 b8Var = sfVar.f5107i;
        if (b8Var == null || c8Var == null || c8Var.f3666c != this.f5091c || c8Var.f3667d != this.f5092d) {
            return false;
        }
        d8 d8Var = wf.P;
        d8Var.r();
        if (d8Var.c(b8Var) && b8Var == d8Var.f3803f && b8Var.f3583h && d8Var.f3800c == 4 && c8Var.equals(b8Var.f3576a) && b8Var.f3580e == null) {
            b8Var.f3580e = f2Var;
            b8Var.f3581f = c8Var;
            d8Var.f3800c = 5;
            long j3 = d8Var.f3802e;
            d8Var.y();
            try {
                m0 m0Var = d8Var.f3798a;
                g2.j jVar = new g2.j(d8Var, b8Var, c8Var, f2Var, j3);
                m0Var.getClass();
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    Choreographer choreographer = Choreographer.getInstance();
                    choreographer.postFrameCallback(new mf(Long.MIN_VALUE, choreographer, j3, 2, jVar));
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (Throwable unused) {
            }
            if (!z2) {
                b8Var.f3580e = null;
                b8Var.f3581f = null;
                d8Var.d(4);
            }
        } else {
            z2 = false;
        }
        return z2;
    }

    public final boolean b(f2 f2Var) {
        int i3;
        sf sfVar = this.f5090b;
        if (sfVar.f5104f.get() || Looper.myLooper() != Looper.getMainLooper()) {
            return false;
        }
        if (sfVar.f5106h) {
            f2Var.run();
            return true;
        }
        b8 b8Var = sfVar.f5107i;
        if (b8Var == null) {
            return false;
        }
        long j3 = b8Var.f3576a.f3664a;
        long j4 = sfVar.f5101c;
        c8 c8Var = new c8(j3, j4, this.f5091c, this.f5092d);
        sfVar.f5108j = c8Var;
        d8 d8Var = wf.P;
        d8Var.r();
        if (!d8Var.c(b8Var) || j3 != d8Var.f3801d || j4 != b8Var.f3576a.f3665b || (i3 = this.f5093e) < 1 || b8Var.f3579d != null || b8Var.f3583h) {
            return false;
        }
        b8Var.f3576a = c8Var;
        b8Var.f3584i = i3;
        b8Var.f3579d = f2Var;
        d8Var.p();
        return true;
    }
}
