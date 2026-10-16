// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lyr.stable.runtime.ScreenMirrorService;
import w1.aa;
import w1.e4;
import w1.wf;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile c f403f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f404a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScreenMirrorService f405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f408e;

    public static c b() {
        c cVar;
        c cVar2 = f403f;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (c.class) {
            try {
                if (f403f == null) {
                    f403f = new c();
                }
                cVar = f403f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public static long c(String str, boolean z2, boolean z3, boolean z4) {
        if ("aggressive_oppo".equals(str)) {
            return 1000L;
        }
        return (z2 || !z3 || z4) ? 3000L : 60000L;
    }

    public static void e(Context context, String str, boolean z2) {
        ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
        if (screenMirrorServiceU2 == null) {
            if (context != null) {
                w1.m mVarC = w1.m.c(context);
                mVarC.getClass();
                Bundle bundleH0 = w1.n.h0(str);
                bundleH0.putBoolean("recovery", z2);
                mVarC.f(22, bundleH0);
            }
            Log.d("AbeTouch", "request routed to :a11y reason=" + str);
            return;
        }
        c cVarB = b();
        if (cVarB.f405b == null) {
            synchronized (cVarB) {
                cVarB.f405b = screenMirrorServiceU2;
            }
        }
        cVarB.f407d = z2;
        boolean zG = g(screenMirrorServiceU2);
        if (!zG && f(screenMirrorServiceU2)) {
            cVarB.i("own-ui-foreground:" + str);
            Log.d("AbeTouch", "request paused (own UI) reason=" + str);
            return;
        }
        cVarB.h(str);
        if (!zG) {
            cVarB.a(str);
            return;
        }
        Log.d("AbeTouch", "passive heartbeat src=" + str);
    }

    public static boolean f(Context context) {
        boolean z2;
        if (context == null) {
            return false;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(KeyguardManager.class);
            boolean z3 = powerManager != null && powerManager.isInteractive();
            boolean z4 = keyguardManager != null && keyguardManager.isKeyguardLocked();
            AtomicInteger atomicInteger = s.f457a;
            if (atomicInteger.get() > 0) {
                z2 = atomicInteger.get() > 0;
            } else {
                try {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
                    if (runningAppProcesses != null) {
                        String packageName = context.getPackageName();
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                ActivityManager.RunningAppProcessInfo next = it.next();
                                if (next != null && packageName.equals(next.processName)) {
                                    if (next.importance == 100) {
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            String strO = u.o();
            if ((!z3 || (!z4 && !z2)) && (!z3 || !"aggressive_oppo".equals(strO))) {
                return false;
            }
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0004  */
    public static boolean g(Context context) {
        boolean z2;
        if (context == null) {
            z2 = true;
        } else {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
                if (powerManager == null || powerManager.isInteractive()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (Throwable unused) {
            }
        }
        return z2 && "aggressive_oppo".equals(u.o());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(String str) {
        boolean z2;
        boolean z3;
        ScreenMirrorService screenMirrorService = this.f405b;
        if (screenMirrorService == null) {
            return;
        }
        int i3 = 0;
        try {
            PowerManager powerManager = (PowerManager) screenMirrorService.getSystemService(PowerManager.class);
            z2 = powerManager == null || powerManager.isInteractive();
        } catch (Throwable unused) {
        }
        synchronized (wf.f5439b) {
            try {
                z3 = wf.f5455s && wf.p0();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z3 && !z2) {
            Log.d("AbeTouch", "gesture skipped (active mask non-interactive) src=" + str);
            return;
        }
        ScreenMirrorService screenMirrorService2 = this.f405b;
        if (f(screenMirrorService2)) {
            Log.d("AbeTouch", "gesture skipped (own UI) src=" + str);
            return;
        }
        ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
        if ((screenMirrorServiceU2 == null || screenMirrorServiceU2.G0) && screenMirrorService2 != null) {
            try {
                PowerManager powerManager2 = (PowerManager) screenMirrorService2.getSystemService(PowerManager.class);
                KeyguardManager keyguardManager = (KeyguardManager) screenMirrorService2.getSystemService(KeyguardManager.class);
                boolean z4 = powerManager2 != null && powerManager2.isInteractive();
                boolean z5 = keyguardManager != null && keyguardManager.isKeyguardLocked();
                if (z4 && !z5) {
                    v vVarF = p.f(screenMirrorService2, 2);
                    if (!vVarF.f463a) {
                        StringBuilder sbK = a0.a.k("abe touch denied src=", str, " used=");
                        sbK.append(vVarF.f464b);
                        sbK.append("/");
                        sbK.append(vVarF.f465c);
                        Log.d("AbeTouch", sbK.toString());
                        return;
                    }
                    int i4 = q.f456b;
                    q.b(p.e(screenMirrorService2, "keepalive_prefs"), "abe_touch_wake_times");
                }
            } catch (Throwable unused2) {
            }
        }
        DisplayMetrics displayMetrics = screenMirrorService2.getResources().getDisplayMetrics();
        int i5 = displayMetrics.widthPixels;
        int i6 = displayMetrics.heightPixels;
        float f3 = i5;
        float f4 = new float[]{0.04f * f3, 0.96f * f3, 0.08f * f3, f3 * 0.92f}[((int) (System.currentTimeMillis() / 10000)) % 4];
        float f5 = i6 * 0.5f;
        Path path = new Path();
        path.moveTo(f4, f5);
        path.lineTo(f4, f5 + 3.0f);
        GestureDescription gestureDescriptionBuild = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 50L)).build();
        try {
            AccessibilityService.GestureResultCallback aVar = new a(i3, str);
            ScreenMirrorService screenMirrorService3 = this.f405b;
            if (screenMirrorService3 != null ? screenMirrorService3.V0(screenMirrorService3, e4.f3871f, gestureDescriptionBuild, aVar, null, new aa(screenMirrorService3, 16), ScreenMirrorService.Z6, null, -1, 0L) : screenMirrorService3.dispatchGesture(gestureDescriptionBuild, aVar, null)) {
                return;
            }
            Log.d("AbeTouch", "gesture rejected src=" + str);
        } catch (Throwable th2) {
            a0.a.p(th2, a0.a.k("gesture fail src=", str, ": "), "AbeTouch");
        }
    }

    public final long d() {
        String strO = u.o();
        ScreenMirrorService screenMirrorService = this.f405b;
        if (screenMirrorService == null) {
            return c(strO, this.f407d, false, true);
        }
        try {
            PowerManager powerManager = (PowerManager) screenMirrorService.getSystemService(PowerManager.class);
            KeyguardManager keyguardManager = (KeyguardManager) screenMirrorService.getSystemService(KeyguardManager.class);
            return c(strO, this.f407d, powerManager != null && powerManager.isInteractive(), keyguardManager != null && keyguardManager.isKeyguardLocked());
        } catch (Throwable unused) {
            return c(strO, this.f407d, false, true);
        }
    }

    public final void h(String str) {
        ScreenMirrorService screenMirrorService = this.f405b;
        if (screenMirrorService == null) {
            return;
        }
        if (!g(screenMirrorService) && f(this.f405b)) {
            i("own-ui-foreground:" + str);
            Log.d("AbeTouch", "start paused (own UI) reason=" + str);
            return;
        }
        this.f406c = true;
        this.f408e++;
        this.f404a.removeCallbacksAndMessages(null);
        this.f404a.postDelayed(new b(this, this.f408e), d());
        Log.i("AbeTouch", "started reason=" + str + " recoveryMode=" + this.f407d);
    }

    public final synchronized void i(String str) {
        this.f406c = false;
        this.f408e++;
        this.f404a.removeCallbacksAndMessages(null);
        Log.i("AbeTouch", "stopped reason=".concat(str));
    }
}
