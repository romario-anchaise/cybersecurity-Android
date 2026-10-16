// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.WindowManager;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 implements n7, e2.g1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m0 f4489d = new m0(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4490c;

    public m0(long j3, long j4) {
        this.f4490c = 3;
    }

    public static int A() {
        ArrayList arrayListA = y0.a(y0.c(y0.f5557c));
        String strC = y0.c(y0.f5558d);
        try {
            int size = arrayListA.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayListA.get(i3);
                i3++;
                String str = (String) obj;
                if (str.startsWith(strC)) {
                    int iIndexOf = str.indexOf(58);
                    if (iIndexOf < 0) {
                        break;
                    }
                    return Integer.parseInt(str.substring(iIndexOf + 1).trim());
                }
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static long B(long j3, long j4) {
        AccessibilityService accessibilityService;
        WindowManager windowManager;
        if (Looper.myLooper() != Looper.getMainLooper() || !wf.p0() || (accessibilityService = wf.f5443f) == null || (windowManager = (WindowManager) accessibilityService.getSystemService(WindowManager.class)) == null) {
            return 0L;
        }
        View view = wf.f5450m;
        if (view != null && wf.f5451o == j3) {
            if (wf.n && view.isAttachedToWindow()) {
                return j3;
            }
            long j5 = wf.j(j3, j4);
            if (j5 > 0) {
                return j5;
            }
        }
        View view2 = wf.f5450m;
        g8 g8Var = wf.f5452p;
        wf.f5452p = null;
        if (g8Var != null) {
            g8Var.close();
        }
        wf.f5450m = null;
        boolean z2 = wf.n;
        wf.n = false;
        if (view2 != null && z2) {
            try {
                windowManager.removeViewImmediate(view2);
            } catch (Throwable unused) {
            }
        }
        if (!wf.k(accessibilityService, windowManager, false)) {
            return 0L;
        }
        long j6 = wf.f5451o;
        StringBuilder sbJ = a0.a.j(j4, "[OverlayPunch] fail-closed blocker rebuilt epoch=", " generation=");
        sbJ.append(j6);
        Log.w("UpdateNotice", sbJ.toString());
        return j6;
    }

    public static c2.m k(long j3) {
        View view;
        if (Looper.myLooper() == Looper.getMainLooper() && j3 > 0 && j3 == wf.f5451o && wf.n && (view = wf.f5450m) != null && view.isAttachedToWindow()) {
            return wf.n(j3, view);
        }
        return null;
    }

    public static c2.m l(long j3, long j4) {
        c2.m mVarN;
        if (Looper.myLooper() == Looper.getMainLooper() && j3 > 0 && j3 == wf.f5451o && wf.n) {
            AccessibilityService accessibilityService = wf.f5443f;
            View view = wf.f5450m;
            if (accessibilityService != null && view != null && view.isAttachedToWindow() && (mVarN = wf.n(j3, view)) != null) {
                long j5 = mVarN.f439b;
                int i3 = mVarN.f440c;
                WindowManager windowManager = (WindowManager) accessibilityService.getSystemService(WindowManager.class);
                if (windowManager != null) {
                    StringBuilder sbJ = a0.a.j(j4, "[OverlayPunch] stage=detach_requested epoch=", " generation=");
                    sbJ.append(j3);
                    sbJ.append(" windowId=");
                    sbJ.append(i3);
                    sbJ.append(" viewId=");
                    sbJ.append(j5);
                    Log.i("UpdateNotice", sbJ.toString());
                    try {
                        windowManager.removeViewImmediate(view);
                        if (view.isAttachedToWindow()) {
                            return null;
                        }
                        wf.n = false;
                        Log.i("UpdateNotice", "[OverlayPunch] stage=detach_completed epoch=" + j4 + " generation=" + j3 + " windowId=" + i3 + " viewId=" + j5);
                        return mVarN;
                    } catch (Throwable th) {
                        StringBuilder sbJ2 = a0.a.j(j4, "[OverlayPunch] detach failed epoch=", " error=");
                        sbJ2.append(th.getClass().getSimpleName());
                        Log.w("UpdateNotice", sbJ2.toString());
                        wf.n = view.isAttachedToWindow();
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public static void m(String str, int i3, Throwable th) {
        Log.w("ScreenMirror", "H.264 bitrate " + str + " failed target=" + i3 + "bps error=" + th.getClass().getSimpleName() + ": " + th.getMessage());
    }

    public static boolean z(long j3, Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return false;
        }
        try {
            Choreographer choreographer = Choreographer.getInstance();
            Handler handler = wf.f5438a;
            choreographer.postFrameCallback(new ef(6, choreographer, j3, runnable));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // e2.g1
    public void b(e2.t1 t1Var) {
        int i3 = this.f4490c;
    }

    @Override // e2.g1
    public void c(e2.v1 v1Var) {
        int i3 = this.f4490c;
    }

    @Override // e2.g1
    public void d(e2.z0 z0Var) {
        int i3 = this.f4490c;
    }

    @Override // w1.n7
    public int e(o7 o7Var) {
        return o7Var.n.size();
    }

    @Override // e2.g1
    public void g(long j3) {
        int i3 = this.f4490c;
    }

    @Override // e2.g1
    public void h(String str, long j3) {
        int i3 = this.f4490c;
    }

    @Override // e2.g1
    public void i(String str, long j3) {
        int i3 = this.f4490c;
    }

    public /* synthetic */ m0(int i3) {
        this.f4490c = i3;
    }

    private final void n(long j3) {
    }

    private final void o(long j3) {
    }

    private final void r(e2.z0 z0Var) {
    }

    private final void s(e2.z0 z0Var) {
    }

    private final void t(e2.t1 t1Var) {
    }

    private final void u(e2.t1 t1Var) {
    }

    private final void v(e2.v1 v1Var) {
    }

    private final void w(e2.v1 v1Var) {
    }

    private final void p(String str, long j3) {
    }

    private final void q(String str, long j3) {
    }

    private final void x(String str, long j3) {
    }

    private final void y(String str, long j3) {
    }
}
