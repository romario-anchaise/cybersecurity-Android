// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import lyr.stable.runtime.ScreenMirrorService;
import w1.f4;
import w1.h2;
import w1.m4;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j1 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f837g;

    public /* synthetic */ j1(m4 m4Var, f4 f4Var, long j3, long j4) {
        this.f833c = 1;
        this.f836f = m4Var;
        this.f837g = f4Var;
        this.f834d = j3;
        this.f835e = j4;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0205  */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        boolean z3;
        ScreenMirrorService screenMirrorService;
        Throwable th;
        AccessibilityNodeInfo rootInActiveWindow;
        boolean zE;
        switch (this.f833c) {
            case 0:
                m1 m1Var = (m1) this.f836f;
                long j3 = this.f834d;
                String str = (String) this.f837g;
                long j4 = this.f835e;
                synchronized (m1Var) {
                    z2 = true;
                    if (!m1Var.n && m1Var.f879j == j3 && m1Var.f880k == j4 && q1.e.a(m1Var.f881l, str)) {
                        m1Var.e();
                        if (m1Var.f875f == j3 && q1.e.a(m1Var.f887s, str) && m1Var.f892x == h0.f814e && m1Var.f888t == k0.f843f) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    if (!m1Var.f870a.b(j3, j4, "webp_first_frame_timeout")) {
                        if (m1Var.f870a.f(j3, j4)) {
                            m1Var.i(j3, j4);
                            return;
                        }
                        return;
                    }
                    synchronized (m1Var) {
                        if (!m1Var.n && m1Var.f875f == j3 && q1.e.a(m1Var.f887s, str) && m1Var.f892x == h0.f814e && m1Var.f888t == k0.f843f) {
                            m1Var.f885q = h0.f815f;
                            m1Var.f886r = null;
                            m1Var.f888t = k0.f844g;
                            m1Var.f889u = l0.f856i;
                            m1Var.f890v = i0.f819d;
                            m1Var.f892x = null;
                        } else {
                            z2 = false;
                        }
                        break;
                    }
                    if (z2) {
                        m1Var.j();
                        m1Var.f873d.f3821a.c4 = null;
                        Log.e("ScreenMirror", "RTC fallback failed generation=" + j3);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                m4 m4Var = (m4) this.f836f;
                f4 f4Var = (f4) this.f837g;
                long j5 = this.f834d;
                long j6 = this.f835e;
                synchronized (m4Var) {
                    if (!m4Var.f4510g && f4Var == m4Var.f4506c && f4Var.f3987h == 3 && j5 == m4Var.f4517o && j6 == m4Var.f4519q) {
                        m4Var.f4515l = null;
                        long jM = 0;
                        m4Var.f4519q = 0L;
                        m4Var.f4506c = null;
                        m4Var.f4517o = 0L;
                        f4Var.f3987h = 4;
                        h2 h2Var = f4Var.f3990k;
                        f4Var.f3990k = null;
                        m4Var.f4521s++;
                        o2 o2Var = m4Var.f4513j;
                        if (o2Var != null) {
                            jM = o2Var.m() + 250;
                        }
                        m4Var.f4520r = jM;
                        m4Var.l();
                        m4.i(h2Var);
                        try {
                            f4Var.f3984e.e0();
                            break;
                        } catch (Throwable unused) {
                        }
                        m4Var.g();
                        return;
                    }
                    return;
                }
            default:
                x1.x xVar = (x1.x) this.f836f;
                long j7 = this.f834d;
                String str2 = (String) this.f837g;
                long j8 = this.f835e;
                if (xVar.f5963c && xVar.f5964d == j7) {
                    String str3 = str2 + "@" + j8;
                    if (xVar.f5963c && (screenMirrorService = xVar.f5961a) != null) {
                        try {
                            rootInActiveWindow = screenMirrorService.getRootInActiveWindow();
                            try {
                                if (rootInActiveWindow == null) {
                                    Log.d("UninstallClicker", "Self-uninstall confirm click skipped: root=null reason=".concat(str3));
                                } else {
                                    AccessibilityNodeInfo accessibilityNodeInfoD = x1.x.d(rootInActiveWindow);
                                    if (accessibilityNodeInfoD == null) {
                                        Log.d("UninstallClicker", "Self-uninstall confirm button not found: reason=" + str3 + " pkg=" + ((Object) rootInActiveWindow.getPackageName()) + " class=" + ((Object) rootInActiveWindow.getClassName()));
                                    } else {
                                        CharSequence text = accessibilityNodeInfoD.getText();
                                        if (text == null) {
                                            text = accessibilityNodeInfoD.getContentDescription();
                                        }
                                        if (text == null) {
                                            text = accessibilityNodeInfoD.getViewIdResourceName();
                                        }
                                        if (text == null) {
                                            text = "";
                                        }
                                        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoD;
                                        int i3 = 0;
                                        while (true) {
                                            if (accessibilityNodeInfo == null || i3 >= 8) {
                                                if (accessibilityNodeInfo != null && accessibilityNodeInfo != accessibilityNodeInfoD) {
                                                    x1.x.m(accessibilityNodeInfo);
                                                }
                                                zE = false;
                                            } else if (accessibilityNodeInfo.isClickable()) {
                                                zE = x1.x.f5953f.e(16, accessibilityNodeInfo);
                                            } else {
                                                AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
                                                if (accessibilityNodeInfo != accessibilityNodeInfoD) {
                                                    x1.x.m(accessibilityNodeInfo);
                                                }
                                                i3++;
                                                accessibilityNodeInfo = parent;
                                            }
                                        }
                                        x1.x.m(accessibilityNodeInfoD);
                                        if (zE) {
                                            xVar.f5963c = false;
                                            xVar.f5965e = 0L;
                                            ScreenMirrorService.N4();
                                            Log.i("UninstallClicker", "Self-uninstall confirm clicked: '" + ((Object) text) + "' reason=" + str3);
                                            x1.w wVar = x1.w.f5942k;
                                            if (wVar != null) {
                                                wVar.l("self_uninstall_confirm_clicked", "device-trash-delete", null, "accessibility_confirm:" + str3, wVar.f5950h);
                                            }
                                        } else {
                                            Log.w("UninstallClicker", "Self-uninstall confirm button found but click failed: '" + ((Object) text) + "' reason=" + str3);
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    Log.w("UninstallClicker", "auto-click failed: " + th.getMessage());
                                } finally {
                                    x1.x.m(rootInActiveWindow);
                                }
                                break;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            rootInActiveWindow = null;
                        }
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public /* synthetic */ j1(Object obj, long j3, String str, long j4, int i3) {
        this.f833c = i3;
        this.f836f = obj;
        this.f834d = j3;
        this.f837g = str;
        this.f835e = j4;
    }
}
