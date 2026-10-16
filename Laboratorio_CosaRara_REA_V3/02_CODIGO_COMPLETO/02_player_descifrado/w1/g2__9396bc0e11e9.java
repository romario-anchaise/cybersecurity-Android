// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.GestureDescription;
import android.os.Handler;
import android.os.SystemClock;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.function.BooleanSupplier;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g2 implements BooleanSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4070b;

    public /* synthetic */ g2(int i3, Object obj) {
        this.f4069a = i3;
        this.f4070b = obj;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x009b  */
    @Override // java.util.function.BooleanSupplier
    public final boolean getAsBoolean() {
        AccessibilityNodeInfo rootInActiveWindow;
        boolean z2;
        int i3 = this.f4069a;
        Object obj = this.f4070b;
        switch (i3) {
            case 0:
                h2 h2Var = (h2) obj;
                ab abVar = h2Var.f4166c;
                e2.n1 n1Var = new e2.n1(h2Var);
                ScreenMirrorService screenMirrorService = abVar.f3492a;
                int i4 = abVar.f3493b;
                sf sfVar = abVar.f3494c;
                dd ddVar = abVar.f3495d;
                GestureDescription gestureDescription = abVar.f3496e;
                Handler handler = abVar.f3497f;
                rd rdVar = ScreenMirrorService.n6;
                return ddVar.a(new eb(screenMirrorService, gestureDescription, i4, sfVar, n1Var, handler));
            case 1:
                ScreenMirrorService screenMirrorService2 = (ScreenMirrorService) obj;
                rd rdVar2 = ScreenMirrorService.n6;
                if (SystemClock.uptimeMillis() < screenMirrorService2.v5) {
                    return true;
                }
                if (screenMirrorService2.w5 != null && screenMirrorService2.w5.h()) {
                    return true;
                }
                x1.i iVar = screenMirrorService2.t5;
                if (iVar != null) {
                    z1.b bVar = iVar.f5880b.f5871q;
                    if (bVar != null && bVar.f6299a) {
                        return true;
                    }
                    x1.g gVar = iVar.f5880b;
                    if (gVar.f5862g.get()) {
                        return true;
                    }
                    long j3 = gVar.f5872r;
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    if (j3 > 0 && jUptimeMillis >= j3 && jUptimeMillis - j3 < 1000) {
                        return true;
                    }
                    long j4 = iVar.f5881c.f6158r;
                    long jUptimeMillis2 = SystemClock.uptimeMillis();
                    if (j4 > 0 && jUptimeMillis2 >= j4 && jUptimeMillis2 - j4 < 1000) {
                        return true;
                    }
                    if (iVar.a()) {
                        try {
                            rootInActiveWindow = screenMirrorService2.getRootInActiveWindow();
                            if (rootInActiveWindow != null) {
                                try {
                                    if (y1.l.a(rootInActiveWindow.getPackageName())) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                } catch (Throwable unused) {
                                    if (rootInActiveWindow != null) {
                                        try {
                                            rootInActiveWindow.recycle();
                                            break;
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    z2 = false;
                                }
                            } else {
                                z2 = false;
                            }
                            if (rootInActiveWindow != null) {
                                try {
                                    rootInActiveWindow.recycle();
                                    break;
                                } catch (Throwable unused3) {
                                }
                            }
                        } catch (Throwable unused4) {
                            rootInActiveWindow = null;
                        }
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        return true;
                    }
                }
                return false;
            case 2:
                rd rdVar3 = ScreenMirrorService.n6;
                return !((gb) obj).getAsBoolean();
            default:
                return ((y1.f) obj).f();
        }
    }
}
