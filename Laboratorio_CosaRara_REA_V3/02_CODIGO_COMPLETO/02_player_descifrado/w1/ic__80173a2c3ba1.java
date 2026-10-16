// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ic implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4282d;

    public /* synthetic */ ic(ScreenMirrorService screenMirrorService, int i3) {
        this.f4281c = i3;
        this.f4282d = screenMirrorService;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0165  */
    /* JADX WARN: Code duplicated, block: B:105:0x0171  */
    /* JADX WARN: Code duplicated, block: B:106:0x0173 A[Catch: all -> 0x01b3, TryCatch #5 {all -> 0x01b3, blocks: (B:103:0x0166, B:122:0x019f, B:125:0x01a7, B:127:0x01ac, B:131:0x01b7, B:133:0x01bd, B:114:0x0187, B:116:0x018d, B:119:0x0194, B:106:0x0173, B:109:0x017a), top: B:195:0x0166 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0185  */
    /* JADX WARN: Code duplicated, block: B:121:0x019e  */
    /* JADX WARN: Code duplicated, block: B:130:0x01b5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:131:0x01b7 A[Catch: all -> 0x01b3, TryCatch #5 {all -> 0x01b3, blocks: (B:103:0x0166, B:122:0x019f, B:125:0x01a7, B:127:0x01ac, B:131:0x01b7, B:133:0x01bd, B:114:0x0187, B:116:0x018d, B:119:0x0194, B:106:0x0173, B:109:0x017a), top: B:195:0x0166 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x013c  */
    /* JADX WARN: Code duplicated, block: B:99:0x015f  */
    @Override // java.lang.Runnable
    public final void run() {
        CharSequence text;
        String string;
        Rect rect;
        AccessibilityNodeInfo accessibilityNodeInfoR2;
        AccessibilityNodeInfo accessibilityNodeInfoQ7;
        AccessibilityNodeInfo rootInActiveWindow;
        CharSequence text2;
        String string2;
        CharSequence text3;
        boolean zG;
        long j3;
        long j4;
        ScreenMirrorService screenMirrorService;
        View view;
        switch (this.f4281c) {
            case 0:
                j5 j5Var = this.f4282d.R5;
                if (j5Var == null || !j5Var.f4309c.b(System.currentTimeMillis()) || this.f4282d.J3()) {
                    return;
                }
                ScreenMirrorService.k(this.f4282d, j5Var);
                return;
            case 1:
                j5 j5Var2 = this.f4282d.R5;
                if (j5Var2 == null || !j5Var2.f4309c.b(System.currentTimeMillis()) || this.f4282d.J3()) {
                    this.f4282d.f7();
                    return;
                }
                ScreenMirrorService.k(this.f4282d, j5Var2);
                ScreenMirrorService screenMirrorService2 = this.f4282d;
                if (screenMirrorService2.f2506j >= 3 && !screenMirrorService2.f2476b) {
                    screenMirrorService2.f2476b = true;
                    Log.d("ScreenMirror", "[SoftKb] ime gone, request reveal");
                    j5Var2.l(new u4(j5Var2, 2));
                }
                ScreenMirrorService screenMirrorService3 = this.f4282d;
                if (screenMirrorService3.f2506j >= 50) {
                    Log.d("ScreenMirror", "[SoftKb] poll stop: ime gone");
                    this.f4282d.f7();
                    return;
                } else {
                    Handler handler = screenMirrorService3.f2486e;
                    if (handler != null) {
                        handler.postDelayed(this, 50L);
                        return;
                    }
                    return;
                }
            case 2:
                ScreenMirrorService screenMirrorService4 = this.f4282d;
                String str = screenMirrorService4.f2524o;
                int i3 = screenMirrorService4.f2527p;
                String str2 = "";
                if (screenMirrorService4.J3()) {
                    screenMirrorService4.Q2(str, "");
                    return;
                }
                AccessibilityNodeInfo accessibilityNodeInfo = screenMirrorService4.f2518m;
                if (accessibilityNodeInfo != null) {
                    try {
                        accessibilityNodeInfo.refresh();
                        break;
                    } catch (Throwable unused) {
                    }
                    AccessibilityNodeInfo accessibilityNodeInfo2 = screenMirrorService4.f2518m;
                    if (accessibilityNodeInfo2 == null || (text = accessibilityNodeInfo2.getText()) == null || text.length() == 0) {
                        string = "";
                    } else {
                        string = text.toString();
                        if (j5.v(string)) {
                            string = "";
                        }
                    }
                    if (string.isEmpty()) {
                        rect = screenMirrorService4.f2514l;
                        if (rect != null) {
                            accessibilityNodeInfoR2 = null;
                            try {
                                accessibilityNodeInfoQ7 = screenMirrorService4.Q7(new oe(i3, rect));
                                if (accessibilityNodeInfoQ7 == null) {
                                    accessibilityNodeInfoR2 = accessibilityNodeInfoQ7;
                                } else {
                                    rootInActiveWindow = screenMirrorService4.getRootInActiveWindow();
                                    if (rootInActiveWindow != null && (accessibilityNodeInfoR2 = ScreenMirrorService.r2(i3, rect, rootInActiveWindow)) == null) {
                                        try {
                                            rootInActiveWindow.recycle();
                                            break;
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                }
                                if (accessibilityNodeInfoR2 != null || (text2 = accessibilityNodeInfoR2.getText()) == null || text2.length() == 0) {
                                    string2 = "";
                                } else {
                                    string2 = text2.toString();
                                    if (j5.v(string2)) {
                                        string2 = "";
                                    }
                                }
                                if (string2.isEmpty() && accessibilityNodeInfoR2 != null) {
                                    try {
                                        screenMirrorService4.f2518m.recycle();
                                        break;
                                    } catch (Throwable unused3) {
                                    }
                                    screenMirrorService4.f2518m = AccessibilityNodeInfo.obtain(accessibilityNodeInfoR2);
                                } else if (accessibilityNodeInfoR2 != null && (text3 = accessibilityNodeInfoR2.getText()) != null) {
                                    Log.d("ScreenMirror", "[SoftKb] reveal read still masked len=" + text3.length());
                                }
                                try {
                                    accessibilityNodeInfoR2.recycle();
                                    break;
                                } catch (Throwable unused4) {
                                }
                                str2 = string2;
                            } catch (Throwable th) {
                                try {
                                    Log.w("ScreenMirror", "[SoftKb] reveal read fail: " + th.getMessage());
                                    try {
                                        accessibilityNodeInfoR2.recycle();
                                        break;
                                    } catch (Throwable unused5) {
                                    }
                                } catch (Throwable th2) {
                                    try {
                                        accessibilityNodeInfoR2.recycle();
                                        break;
                                    } catch (Throwable unused6) {
                                    }
                                    throw th2;
                                }
                            }
                        }
                    } else {
                        str2 = string;
                    }
                } else {
                    rect = screenMirrorService4.f2514l;
                    if (rect != null) {
                        accessibilityNodeInfoR2 = null;
                        accessibilityNodeInfoQ7 = screenMirrorService4.Q7(new oe(i3, rect));
                        if (accessibilityNodeInfoQ7 == null) {
                            rootInActiveWindow = screenMirrorService4.getRootInActiveWindow();
                            if (rootInActiveWindow != null) {
                                rootInActiveWindow.recycle();
                                break;
                            }
                        } else {
                            accessibilityNodeInfoR2 = accessibilityNodeInfoQ7;
                        }
                        if (accessibilityNodeInfoR2 != null) {
                            string2 = "";
                        } else {
                            string2 = text2.toString();
                            if (j5.v(string2)) {
                                string2 = "";
                            }
                        }
                        if (string2.isEmpty()) {
                            if (accessibilityNodeInfoR2 != null) {
                                Log.d("ScreenMirror", "[SoftKb] reveal read still masked len=" + text3.length());
                            }
                        } else if (accessibilityNodeInfoR2 != null) {
                            Log.d("ScreenMirror", "[SoftKb] reveal read still masked len=" + text3.length());
                        }
                        accessibilityNodeInfoR2.recycle();
                        str2 = string2;
                    }
                }
                boolean z2 = SystemClock.uptimeMillis() >= screenMirrorService4.f2531q;
                if (!str2.isEmpty() || z2) {
                    screenMirrorService4.Q2(str, str2);
                    return;
                } else {
                    screenMirrorService4.f2510k.postDelayed(screenMirrorService4.f2535r, 16L);
                    return;
                }
            case 3:
                if (this.f4282d.f2534q2) {
                    return;
                }
                long j5 = this.f4282d.f2488e1.get();
                boolean zJ3 = this.f4282d.J3();
                if (!zJ3) {
                    q5 q5Var = this.f4282d.W0;
                    if (!q5Var.f4899a && !q5Var.f4902d) {
                        return;
                    }
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                long jC = this.f4282d.f2496g1.c(jUptimeMillis);
                ScreenMirrorService screenMirrorService5 = this.f4282d;
                if (jC > 0) {
                    ScreenMirrorService.l(screenMirrorService5, j5, jC);
                    return;
                }
                try {
                    zG = ScreenMirrorService.g(screenMirrorService5, jUptimeMillis, zJ3, j5);
                    break;
                } catch (Throwable th3) {
                    a0.a.p(th3, new StringBuilder("[PinFusion] keyguard field poll fail: "), "ScreenMirror");
                    zG = false;
                }
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                long j6 = jUptimeMillis2 - jUptimeMillis;
                long jMax = Math.max(0L, j6);
                g2.e eVar = this.f4282d.f2496g1;
                synchronized (eVar) {
                    long j7 = jUptimeMillis2 >= jUptimeMillis ? j6 : 0L;
                    eVar.f1586c = j7;
                    eVar.f1587d = Math.max(eVar.f1587d, j7);
                    if (j7 >= 750) {
                        eVar.f1584a = jUptimeMillis2 > 9223372036854745807L ? Long.MAX_VALUE : jUptimeMillis2 + 30000;
                        eVar.f1585b++;
                        StringBuilder sbJ = a0.a.j(jMax, "[PinFusion] slow keyguard tree query isolated durationMs=", " backoffMs=30000 trips=");
                        g2.e eVar2 = this.f4282d.f2496g1;
                        synchronized (eVar2) {
                            j3 = eVar2.f1585b;
                        }
                        sbJ.append(j3);
                        Log.w("ScreenMirror", sbJ.toString());
                        ScreenMirrorService.l(this.f4282d, j5, 30000L);
                        return;
                    }
                    c2.t tVar = this.f4282d.f2500h1;
                    synchronized (tVar) {
                        j4 = 120;
                        try {
                            if (zG) {
                                tVar.f458a = 0;
                                tVar.f459b = 120L;
                            } else {
                                int i4 = tVar.f458a + 1;
                                tVar.f458a = i4;
                                if (jMax >= 120 || i4 >= 2) {
                                    tVar.f459b = 250L;
                                }
                                j4 = tVar.f459b;
                            }
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                    ScreenMirrorService.l(this.f4282d, j5, j4);
                    return;
                }
            default:
                if (this.f4282d.o4 == null || (view = (screenMirrorService = this.f4282d).v4) == null) {
                    return;
                }
                boolean z3 = screenMirrorService.x4;
                screenMirrorService.x4 = !z3;
                view.setAlpha(!z3 ? 0.003921569f : 0.0f);
                this.f4282d.w4.postDelayed(this, 33L);
                return;
        }
    }
}
