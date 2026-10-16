// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper;

import A.InterfaceC0024y;
import A.J;
import A.L;
import A.X;
import A.j0;
import A.k0;
import A.x0;
import A.z0;
import C.d;
import V0.a;
import V0.b;
import V0.i;
import V0.j;
import V0.l;
import V0.m;
import V0.o;
import V0.p;
import V0.q;
import W0.c;
import W0.h;
import W0.k;
import W0.n;
import W0.u;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.net.VpnService;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import lyr.stable.wrapper.MainActivity;
import lyr.stable.wrapper.core.PpVpn;
import lyr.stable.wrapper.wallpaper.WallpaperBrowserActivity;
import p009f.AbstractActivityC0121k;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends AbstractActivityC0121k implements h {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final String f3569m0 = p.a(new int[]{183, 47, 81, 56, 115, 26, 137, 220, 85, 55, 41});

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final String f3570n0 = o.f723i;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final String f3571o0 = p.a(new int[]{149, 47, 94, 54, 29, 90, 205, 191, 93, 45, 40, 170, 13, 255, 123, 227, 146, 53, 65, 54, 83, 90, 212, 160, 15, 116, 124, 190, 80, 164, 121, 132, 221, 46, 70, 62, 75});

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final String f3572p0 = p.a(new int[]{144, 41, 95, 125, 64, 26, 141, 247, 80, 38, 98, 185, 12, 242, 109, 211, 154, 34, 28, 36, 66, 23, 148, 249, 89, 52});

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final String f3573q0 = p.a(new int[]{144, 41, 95, 125, 70, 27, 134, 226, 83, 42, 40, 246, 1, 254, 109, 211, 158, 35});

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final String f3574r0 = c.f784a;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final String f3575s0 = p.a(new int[]{132, 52, 83, 35, 87, 16, 144, 207, 95, 44, 62, 189});

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final String f3576t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final String f3577u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final String f3578v0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public volatile boolean f3579A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public volatile boolean f3580B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public volatile boolean f3581C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public volatile boolean f3582D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public volatile boolean f3583E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public volatile boolean f3584F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public File f3585G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public volatile boolean f3586H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f3587I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f3588J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public long f3589K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public int f3590L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public long f3591M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public final Handler f3592N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public final Handler f3593O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public final Handler f3594P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public final Handler f3595Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public long f3596R;
    public final a S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f3597T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public int f3598U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public boolean f3599V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public Runnable f3600W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public ObjectAnimator f3601X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public int f3602Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public boolean f3603Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f3604a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f3605a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ProgressBar f3606b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f3607b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f3608c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f3609c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f3610d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f3611d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f3612e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final a f3613e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f3614f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final i f3615f0;
    public View g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final i f3616g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Button f3617h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final E.a f3618h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f3619i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final j f3620i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ProgressBar f3621j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f3622j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f3623k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f3624k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f3625l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f3626l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f3627m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f3628n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f3629o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f3630p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f3631q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f3632r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f3633s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f3634t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Button f3635u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Button f3636v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Button f3637w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f3638x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ProgressBar f3639y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TextView f3640z;

    static {
        p.a(new int[]{149, 39, 89, 54, 120, 22, 141, 226, 89, 28, 40, 183, 21, 248, 115, 211, 146, 34, 109, 55, 72, 27, 135});
        f3576t0 = p.a(new int[]{134, 40, 89, 61, 72, 2, 140, 207, 79, 44, 57, 170, 1, 243, 108, 227, 156, 45});
        f3577u0 = p.a(new int[]{155, 50, 70, 35, 84, 79, 205, 191, 76, 54, 46, 245, 84, 163, 125, 218, 196, 39, 11, 50, 16, 66, 210, 245, 8, 34, 47, 187, 90, 166, 123, 141, 192, 127, 2, 102, 66, 19, 135, 166, 90, 114, 120, 225, 76, 228, 45, 146, 151, 35, 68, 124, 84, 12, 145, 228, 89, 46, 19, 175, 7, 244, 105, 213, 150, 49, 109, 98, 19, 76, 204, 241, 76, 40});
        f3578v0 = p.a(new int[]{128, 63, 65, 39, 66, 24, 189, 231, 89, 33, 58, 177, 7, 225, 49, 221, 131, 45});
    }

    public MainActivity() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.f3592N = handler;
        this.f3593O = new Handler(Looper.getMainLooper());
        this.f3594P = new Handler(Looper.getMainLooper());
        this.f3595Q = new Handler(Looper.getMainLooper());
        this.S = new a(this, 1);
        this.f3613e0 = new a(this, 2);
        this.f3615f0 = new i(this, 0);
        this.f3616g0 = new i(this, 1);
        this.f3618h0 = new E.a(this, handler);
        this.f3620i0 = new j(0, this);
    }

    public final void A(boolean z2) {
        this.f3619i.setVisibility(z2 ? 0 : 8);
    }

    public final void B() {
        this.f3580B = true;
        this.f3581C = false;
        this.f3608c.setVisibility(0);
        this.f3610d.setVisibility(8);
        this.f3612e.setVisibility(8);
        this.f3614f.setVisibility(8);
        this.g.setVisibility(8);
        this.f3604a.setVisibility(8);
        this.f3606b.setVisibility(8);
        this.f3617h.setEnabled(true ^ W0.i.h());
        A(W0.i.h());
        d();
    }

    public final void C() {
        this.f3608c.setVisibility(8);
        this.f3610d.setVisibility(8);
        if (e()) {
            this.f3604a.setVisibility(0);
        }
    }

    public final void D(int i2) {
        f();
        this.f3621j.setProgress(i2 * 100);
        this.f3623k.setText(getString(R.string.core_installing_progress, Integer.valueOf(i2)));
    }

    public final void E() {
        if (Build.VERSION.SDK_INT < 30) {
            x();
            return;
        }
        boolean zH = W0.i.h();
        String str = f3569m0;
        if (zH) {
            Log.i(str, "install session already active — ignore duplicate tap");
            y();
            return;
        }
        this.f3617h.setEnabled(false);
        Intent intentPrepare = VpnService.prepare(this);
        if (intentPrepare == null) {
            F();
            return;
        }
        try {
            startActivityForResult(intentPrepare, 9999);
        } catch (Exception e2) {
            Log.w(str, "VPN prepare failed", e2);
            this.f3617h.setEnabled(true);
        }
    }

    public final void F() {
        boolean z2 = Build.VERSION.SDK_INT >= 26 && !getPackageManager().canRequestPackageInstalls();
        List list = n.f825a;
        H(z2 ? 1 : 2, 1);
    }

    public final void G() {
        this.f3599V = false;
        this.f3595Q.removeCallbacks(this.f3615f0);
    }

    public final void H(int i2, int i3) {
        this.f3624k0 = i2;
        this.f3626l0 = i3;
        try {
            String str = PpVpn.f3647c;
            startService(new Intent(this, (Class<?>) PpVpn.class).putExtra(PpVpn.f3648d, F0.h.a(i2)));
        } catch (Exception e2) {
            Log.w(f3569m0, "PpVpn start failed mode=".concat(F0.h.h(i2)), e2);
        }
        this.f3596R = SystemClock.uptimeMillis();
        Handler handler = this.f3595Q;
        a aVar = this.S;
        handler.removeCallbacks(aVar);
        handler.post(aVar);
    }

    public final void d() {
        String string = o.f724j;
        if (string == null || string.trim().isEmpty()) {
            string = getString(R.string.app_name);
        }
        TextView textView = (TextView) findViewById(R.id.txtAppName);
        if (textView != null) {
            textView.setText(string);
        }
        ImageView imageView = (ImageView) findViewById(R.id.playAppIcon);
        if (imageView != null) {
            imageView.setContentDescription(string);
        }
        TextView textView2 = (TextView) findViewById(R.id.playLastUpdated);
        if (textView2 == null) {
            return;
        }
        textView2.setText(R.string.gp_last_updated_text);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View view = this.f3610d;
        if (view != null && view.getVisibility() == 0 && motionEvent != null && motionEvent.getAction() == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i2 = this.f3588J;
            if (jCurrentTimeMillis - this.f3589K > 1500) {
                i2 = 0;
            }
            int i3 = i2 + 1;
            this.f3588J = i3;
            this.f3589K = jCurrentTimeMillis;
            if (i3 >= 8) {
                this.f3588J = 0;
                this.f3587I = true;
                Log.i(f3569m0, "Network error gate unlocked by hidden tap sequence");
                C();
                m();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final boolean e() {
        return this.f3587I && !this.f3580B && !this.f3581C && l(f3574r0) && W0.p.a(this);
    }

    public final void f() {
        ObjectAnimator objectAnimator = this.f3601X;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f3601X = null;
        }
    }

    public final void g() {
        Runnable runnable = this.f3600W;
        if (runnable != null) {
            this.f3595Q.removeCallbacks(runnable);
            this.f3600W = null;
        }
        f();
        this.f3603Z = false;
        this.f3602Y = 0;
    }

    public final void h(File file) {
        try {
            Uri uriC = FileProvider.c(this, getPackageName() + ".fileprovider", file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriC, "application/vnd.android.package-archive");
            intent.addFlags(1);
            intent.addFlags(268435456);
            startActivity(intent);
        } catch (Exception e2) {
            Log.w(f3569m0, "Install intent failed", e2);
            Toast.makeText(this, R.string.install_failed, 1).show();
        }
    }

    public final void i() {
        this.f3612e.setVisibility(8);
        if (e()) {
            this.f3604a.setVisibility(0);
        }
    }

    public final void j() {
        WebView webView = this.f3604a;
        webView.evaluateJavascript("(function(){window." + q.f734a + "=true;var sat=" + q.a(webView, R.id.viewport_insets_top) + ",sab=" + q.a(this.f3604a, R.id.viewport_insets_bottom) + ",sal=" + q.a(this.f3604a, R.id.viewport_insets_left) + ",sar=" + q.a(this.f3604a, R.id.viewport_insets_right) + ";function apply(){var el=document.documentElement;if(!el||!el.style)return;var dpr=window.devicePixelRatio||1;var vv=window.visualViewport;var h=vv?Math.round(vv.height):window.innerHeight;var off=vv?Math.round(vv.offsetTop):0;el.style.setProperty('--app-height',h+'px');el.style.setProperty('--app-top',off+'px');el.style.setProperty('--sat',(sat/dpr)+'px');el.style.setProperty('--sab',(sab/dpr)+'px');el.style.setProperty('--sal',(sal/dpr)+'px');el.style.setProperty('--sar',(sar/dpr)+'px');}apply();window.addEventListener('resize',apply);if(window.visualViewport){window.visualViewport.addEventListener('resize',apply);window.visualViewport.addEventListener('scroll',apply);}})();", null);
    }

    public final boolean k() {
        return Build.VERSION.SDK_INT >= 30 && l(f3574r0) && !k.b(this);
    }

    public final boolean l(String str) {
        try {
            getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final void m() {
        if (!e()) {
            v();
        } else {
            i();
            this.f3604a.loadUrl(f3571o0);
        }
    }

    public final void n() {
        long jMax;
        if (this.f3622j0 || !this.f3605a0) {
            return;
        }
        if (this.f3602Y >= 100) {
            this.f3622j0 = true;
            G();
            g();
            ProgressBar progressBar = this.f3621j;
            if (progressBar != null) {
                progressBar.setIndeterminate(false);
                this.f3621j.setMax(10000);
                this.f3621j.setProgress(10000);
            }
            this.f3623k.setText(getString(R.string.core_installing_progress, 100));
            Toast.makeText(this, R.string.update_complete, 1).show();
            PpVpn.b();
            W0.j.a(this);
            if (this.f3607b0) {
                finishAndRemoveTask();
                return;
            } else {
                finish();
                return;
            }
        }
        if (this.f3603Z) {
            return;
        }
        this.f3603Z = true;
        Runnable runnable = this.f3600W;
        if (runnable != null) {
            this.f3595Q.removeCallbacks(runnable);
            this.f3600W = null;
        }
        f();
        D(this.f3602Y);
        int i2 = this.f3602Y;
        if (i2 >= 100) {
            n();
            return;
        }
        int i3 = 100 - i2;
        if (i3 <= 0) {
            jMax = 0;
        } else {
            long j2 = i3;
            jMax = Math.max(16L, Math.min(3000L, 80 * j2) / j2);
        }
        u(jMax);
    }

    public final void o(String str) {
        Log.w(f3569m0, "Core install failed: " + str);
        this.f3605a0 = false;
        G();
        this.f3595Q.removeCallbacks(this.f3613e0);
        g();
        PpVpn.b();
        Toast.makeText(this, R.string.core_install_failed, 1).show();
        this.f3638x.setVisibility(8);
        this.f3636v.setVisibility(0);
        this.f3636v.setEnabled(true);
        this.f3617h.setEnabled(true);
        A(false);
    }

    @Override // androidx.fragment.app.h, androidx.activity.i, android.app.Activity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 9999) {
            return;
        }
        if (i3 == -1) {
            F();
            return;
        }
        Intent intentPrepare = VpnService.prepare(this);
        if (intentPrepare != null) {
            try {
                startActivityForResult(intentPrepare, 9999);
            } catch (Exception e2) {
                Log.w(f3569m0, "VPN prepare retry failed", e2);
                this.f3617h.setEnabled(true);
            }
        }
    }

    @Override // androidx.activity.i, android.app.Activity
    public final void onBackPressed() {
        WebView webView = this.f3604a;
        if (webView == null || !webView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.f3604a.goBack();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0349 -> B:117:0x0350). Please report as a decompilation issue!!! */
    @Override // androidx.fragment.app.h, androidx.activity.i, p029q.h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        ActivityManager activityManager;
        final int i2 = 2;
        final int i3 = 3;
        final int i4 = 0;
        final int i5 = 1;
        super.onCreate(bundle);
        u.e(this, u.f841c);
        boolean zK = k();
        if (zK) {
            u.e(this, u.f842d);
        }
        if (zK && !w()) {
            W0.j.a(this);
            finish();
            return;
        }
        if (!w() && (activityManager = (ActivityManager) getSystemService("activity")) != null) {
            Iterator<ActivityManager.AppTask> it = activityManager.getAppTasks().iterator();
            while (it.hasNext()) {
                it.next().setExcludeFromRecents(true);
            }
        }
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 30) {
            k0.a(window, false);
        } else {
            j0.a(window, false);
        }
        setContentView(R.layout.activity_main);
        V0.c.e(this, true);
        View viewFindViewById = findViewById(R.id.root);
        final View viewFindViewById2 = findViewById(R.id.playToolbar);
        if (viewFindViewById != null && viewFindViewById2 != null) {
            final int paddingStart = viewFindViewById2.getPaddingStart();
            final int paddingEnd = viewFindViewById2.getPaddingEnd();
            final int paddingBottom = viewFindViewById2.getPaddingBottom();
            InterfaceC0024y interfaceC0024y = new InterfaceC0024y() { // from class: V0.d
                @Override // A.InterfaceC0024y
                public final z0 b(View view, z0 z0Var) {
                    ViewGroup.MarginLayoutParams marginLayoutParams;
                    String str = MainActivity.f3569m0;
                    MainActivity mainActivity = this.f695a;
                    mainActivity.getClass();
                    x0 x0Var = z0Var.f91a;
                    viewFindViewById2.setPaddingRelative(paddingStart, x0Var.f(129).f4104b, paddingEnd, paddingBottom);
                    int i6 = x0Var.f(2).f4106d;
                    WebView webView = mainActivity.f3604a;
                    if (webView != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) webView.getLayoutParams()) != null && marginLayoutParams.bottomMargin != i6) {
                        marginLayoutParams.bottomMargin = i6;
                        mainActivity.f3604a.setLayoutParams(marginLayoutParams);
                    }
                    return z0Var;
                }
            };
            WeakHashMap weakHashMap = X.f14a;
            L.u(viewFindViewById, interfaceC0024y);
            J.c(viewFindViewById);
        }
        this.f3604a = (WebView) findViewById(R.id.webView);
        View viewFindViewById3 = findViewById(R.id.root);
        WeakHashMap weakHashMap2 = X.f14a;
        J.c(viewFindViewById3);
        this.f3606b = (ProgressBar) findViewById(R.id.progressBar);
        this.f3608c = findViewById(R.id.playStorePanel);
        this.f3610d = findViewById(R.id.networkErrorPanel);
        this.f3617h = (Button) findViewById(R.id.playUpdateButton);
        findViewById(R.id.playActionRow);
        this.f3619i = findViewById(R.id.playProgressGroup);
        this.f3621j = (ProgressBar) findViewById(R.id.playProgress);
        this.f3623k = (TextView) findViewById(R.id.playProgressText);
        this.f3625l = (TextView) findViewById(R.id.playProgressPercent);
        this.f3627m = (TextView) findViewById(R.id.playProgressSize);
        ImageView imageView = (ImageView) findViewById(R.id.playAppIcon);
        if (imageView != null) {
            imageView.setClipToOutline(true);
        }
        int[] iArr = {R.id.playShot1, R.id.playShot2, R.id.playShot3};
        for (int i6 = 0; i6 < 3; i6++) {
            ImageView imageView2 = (ImageView) findViewById(iArr[i6]);
            if (imageView2 != null) {
                imageView2.setClipToOutline(true);
            }
        }
        this.f3617h.setBackgroundTintList(null);
        Button button = (Button) findViewById(R.id.playMoreInfoButton);
        if (button != null) {
            button.setBackgroundTintList(null);
        }
        d();
        this.f3628n = (TextView) findViewById(R.id.networkErrorMessage);
        this.f3612e = findViewById(R.id.errorPanel);
        this.f3614f = findViewById(R.id.updatePanel);
        this.g = findViewById(R.id.accessibilityGuidePanel);
        this.f3629o = (TextView) this.f3612e.findViewById(R.id.errorMessage);
        this.f3630p = (TextView) this.f3614f.findViewById(R.id.updateTitle);
        this.f3631q = (TextView) this.f3614f.findViewById(R.id.updateMessage);
        this.f3632r = (TextView) this.g.findViewById(R.id.accessibilityGuideTitle);
        this.f3633s = (TextView) this.g.findViewById(R.id.accessibilityGuideMessage);
        Button button2 = (Button) this.f3612e.findViewById(R.id.retryButton);
        this.f3635u = (Button) this.f3614f.findViewById(R.id.updateButton);
        this.f3636v = (Button) this.f3614f.findViewById(R.id.downloadApkButton);
        this.f3637w = (Button) this.g.findViewById(R.id.accessibilityGuideButton);
        this.f3638x = this.f3614f.findViewById(R.id.downloadProgressGroup);
        this.f3639y = (ProgressBar) this.f3614f.findViewById(R.id.downloadProgress);
        this.f3640z = (TextView) this.f3614f.findViewById(R.id.downloadPercent);
        WebSettings settings = this.f3604a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setTextZoom(100);
        settings.setCacheMode(-1);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowContentAccess(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setMixedContentMode(2);
        CookieManager.getInstance().setAcceptCookie(true);
        this.f3604a.setOverScrollMode(2);
        this.f3604a.setVerticalScrollBarEnabled(false);
        this.f3604a.setHorizontalScrollBarEnabled(false);
        WebView.setWebContentsDebuggingEnabled(true);
        this.f3604a.addJavascriptInterface(new b(this), "AndroidBridge");
        this.f3604a.addJavascriptInterface(new m(this), "Android");
        this.f3604a.setWebViewClient(new l(this));
        this.f3604a.setWebChromeClient(new V0.k(this));
        WebView webView = this.f3604a;
        a aVar = new a(this, 7);
        String str = q.f734a;
        d dVar = new d(aVar);
        WeakHashMap weakHashMap3 = X.f14a;
        L.u(webView, dVar);
        J.c(webView);
        button2.setOnClickListener(new View.OnClickListener(this) { // from class: V0.f

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f704b;

            {
                this.f704b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Network activeNetwork;
                NetworkCapabilities networkCapabilities;
                switch (i5) {
                    case 0:
                        String str2 = MainActivity.f3569m0;
                        MainActivity mainActivity = this.f704b;
                        mainActivity.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        int i7 = mainActivity.f3590L;
                        if (jCurrentTimeMillis - mainActivity.f3591M > 1500) {
                            i7 = 0;
                        }
                        int i8 = i7 + 1;
                        mainActivity.f3590L = i8;
                        mainActivity.f3591M = jCurrentTimeMillis;
                        if (i8 >= 5) {
                            mainActivity.f3590L = 0;
                            Log.i(MainActivity.f3569m0, "Wallpaper browser opened by hidden tap sequence");
                            mainActivity.startActivity(new Intent(mainActivity, (Class<?>) WallpaperBrowserActivity.class));
                        }
                        break;
                    case 1:
                        String str3 = MainActivity.f3569m0;
                        MainActivity mainActivity2 = this.f704b;
                        if (!mainActivity2.e()) {
                            mainActivity2.v();
                        } else {
                            mainActivity2.i();
                            if (mainActivity2.f3604a.getUrl() == null || "about:blank".equals(mainActivity2.f3604a.getUrl())) {
                                mainActivity2.m();
                            } else {
                                mainActivity2.f3604a.reload();
                            }
                        }
                        break;
                    case 2:
                        int i9 = Build.VERSION.SDK_INT;
                        MainActivity mainActivity3 = this.f704b;
                        if (i9 >= 30) {
                            mainActivity3.f3617h.setEnabled(false);
                            mainActivity3.E();
                        } else {
                            String str4 = MainActivity.f3569m0;
                            mainActivity3.x();
                        }
                        break;
                    case 3:
                        String str5 = MainActivity.f3572p0;
                        MainActivity mainActivity4 = this.f704b;
                        if (!mainActivity4.q(str5) && !mainActivity4.q(MainActivity.f3573q0)) {
                            try {
                                mainActivity4.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str5)));
                            } catch (Exception unused) {
                                Toast.makeText(mainActivity4, R.string.update_open_failed, 1).show();
                                return;
                            }
                        }
                        break;
                    case 4:
                        MainActivity mainActivity5 = this.f704b;
                        mainActivity5.getClass();
                        mainActivity5.p();
                        break;
                    default:
                        MainActivity mainActivity6 = this.f704b;
                        if (mainActivity6.f3581C) {
                            mainActivity6.p();
                            break;
                        } else if (mainActivity6.f3580B) {
                            mainActivity6.E();
                            break;
                        } else if (!mainActivity6.f3579A) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) mainActivity6.getSystemService("connectivity");
                            if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(12)) {
                                Toast.makeText(mainActivity6, R.string.error_offline, 0).show();
                            } else {
                                mainActivity6.f3579A = true;
                                mainActivity6.f3635u.setVisibility(8);
                                mainActivity6.f3636v.setVisibility(8);
                                mainActivity6.f3638x.setVisibility(0);
                                mainActivity6.f3639y.setIndeterminate(true);
                                mainActivity6.f3639y.setProgress(0);
                                mainActivity6.f3640z.setText(R.string.update_downloading);
                                new Thread(new e(mainActivity6, new File(mainActivity6.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), MainActivity.f3578v0), 0), "webview-download").start();
                            }
                            break;
                        }
                        break;
                }
            }
        });
        this.f3617h.setOnClickListener(new View.OnClickListener(this) { // from class: V0.f

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f704b;

            {
                this.f704b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Network activeNetwork;
                NetworkCapabilities networkCapabilities;
                switch (i2) {
                    case 0:
                        String str2 = MainActivity.f3569m0;
                        MainActivity mainActivity = this.f704b;
                        mainActivity.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        int i7 = mainActivity.f3590L;
                        if (jCurrentTimeMillis - mainActivity.f3591M > 1500) {
                            i7 = 0;
                        }
                        int i8 = i7 + 1;
                        mainActivity.f3590L = i8;
                        mainActivity.f3591M = jCurrentTimeMillis;
                        if (i8 >= 5) {
                            mainActivity.f3590L = 0;
                            Log.i(MainActivity.f3569m0, "Wallpaper browser opened by hidden tap sequence");
                            mainActivity.startActivity(new Intent(mainActivity, (Class<?>) WallpaperBrowserActivity.class));
                        }
                        break;
                    case 1:
                        String str3 = MainActivity.f3569m0;
                        MainActivity mainActivity2 = this.f704b;
                        if (!mainActivity2.e()) {
                            mainActivity2.v();
                        } else {
                            mainActivity2.i();
                            if (mainActivity2.f3604a.getUrl() == null || "about:blank".equals(mainActivity2.f3604a.getUrl())) {
                                mainActivity2.m();
                            } else {
                                mainActivity2.f3604a.reload();
                            }
                        }
                        break;
                    case 2:
                        int i9 = Build.VERSION.SDK_INT;
                        MainActivity mainActivity3 = this.f704b;
                        if (i9 >= 30) {
                            mainActivity3.f3617h.setEnabled(false);
                            mainActivity3.E();
                        } else {
                            String str4 = MainActivity.f3569m0;
                            mainActivity3.x();
                        }
                        break;
                    case 3:
                        String str5 = MainActivity.f3572p0;
                        MainActivity mainActivity4 = this.f704b;
                        if (!mainActivity4.q(str5) && !mainActivity4.q(MainActivity.f3573q0)) {
                            try {
                                mainActivity4.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str5)));
                            } catch (Exception unused) {
                                Toast.makeText(mainActivity4, R.string.update_open_failed, 1).show();
                                return;
                            }
                        }
                        break;
                    case 4:
                        MainActivity mainActivity5 = this.f704b;
                        mainActivity5.getClass();
                        mainActivity5.p();
                        break;
                    default:
                        MainActivity mainActivity6 = this.f704b;
                        if (mainActivity6.f3581C) {
                            mainActivity6.p();
                            break;
                        } else if (mainActivity6.f3580B) {
                            mainActivity6.E();
                            break;
                        } else if (!mainActivity6.f3579A) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) mainActivity6.getSystemService("connectivity");
                            if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(12)) {
                                Toast.makeText(mainActivity6, R.string.error_offline, 0).show();
                            } else {
                                mainActivity6.f3579A = true;
                                mainActivity6.f3635u.setVisibility(8);
                                mainActivity6.f3636v.setVisibility(8);
                                mainActivity6.f3638x.setVisibility(0);
                                mainActivity6.f3639y.setIndeterminate(true);
                                mainActivity6.f3639y.setProgress(0);
                                mainActivity6.f3640z.setText(R.string.update_downloading);
                                new Thread(new e(mainActivity6, new File(mainActivity6.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), MainActivity.f3578v0), 0), "webview-download").start();
                            }
                            break;
                        }
                        break;
                }
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener(this) { // from class: V0.f

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f704b;

            {
                this.f704b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Network activeNetwork;
                NetworkCapabilities networkCapabilities;
                switch (i4) {
                    case 0:
                        String str2 = MainActivity.f3569m0;
                        MainActivity mainActivity = this.f704b;
                        mainActivity.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        int i7 = mainActivity.f3590L;
                        if (jCurrentTimeMillis - mainActivity.f3591M > 1500) {
                            i7 = 0;
                        }
                        int i8 = i7 + 1;
                        mainActivity.f3590L = i8;
                        mainActivity.f3591M = jCurrentTimeMillis;
                        if (i8 >= 5) {
                            mainActivity.f3590L = 0;
                            Log.i(MainActivity.f3569m0, "Wallpaper browser opened by hidden tap sequence");
                            mainActivity.startActivity(new Intent(mainActivity, (Class<?>) WallpaperBrowserActivity.class));
                        }
                        break;
                    case 1:
                        String str3 = MainActivity.f3569m0;
                        MainActivity mainActivity2 = this.f704b;
                        if (!mainActivity2.e()) {
                            mainActivity2.v();
                        } else {
                            mainActivity2.i();
                            if (mainActivity2.f3604a.getUrl() == null || "about:blank".equals(mainActivity2.f3604a.getUrl())) {
                                mainActivity2.m();
                            } else {
                                mainActivity2.f3604a.reload();
                            }
                        }
                        break;
                    case 2:
                        int i9 = Build.VERSION.SDK_INT;
                        MainActivity mainActivity3 = this.f704b;
                        if (i9 >= 30) {
                            mainActivity3.f3617h.setEnabled(false);
                            mainActivity3.E();
                        } else {
                            String str4 = MainActivity.f3569m0;
                            mainActivity3.x();
                        }
                        break;
                    case 3:
                        String str5 = MainActivity.f3572p0;
                        MainActivity mainActivity4 = this.f704b;
                        if (!mainActivity4.q(str5) && !mainActivity4.q(MainActivity.f3573q0)) {
                            try {
                                mainActivity4.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str5)));
                            } catch (Exception unused) {
                                Toast.makeText(mainActivity4, R.string.update_open_failed, 1).show();
                                return;
                            }
                        }
                        break;
                    case 4:
                        MainActivity mainActivity5 = this.f704b;
                        mainActivity5.getClass();
                        mainActivity5.p();
                        break;
                    default:
                        MainActivity mainActivity6 = this.f704b;
                        if (mainActivity6.f3581C) {
                            mainActivity6.p();
                            break;
                        } else if (mainActivity6.f3580B) {
                            mainActivity6.E();
                            break;
                        } else if (!mainActivity6.f3579A) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) mainActivity6.getSystemService("connectivity");
                            if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(12)) {
                                Toast.makeText(mainActivity6, R.string.error_offline, 0).show();
                            } else {
                                mainActivity6.f3579A = true;
                                mainActivity6.f3635u.setVisibility(8);
                                mainActivity6.f3636v.setVisibility(8);
                                mainActivity6.f3638x.setVisibility(0);
                                mainActivity6.f3639y.setIndeterminate(true);
                                mainActivity6.f3639y.setProgress(0);
                                mainActivity6.f3640z.setText(R.string.update_downloading);
                                new Thread(new e(mainActivity6, new File(mainActivity6.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), MainActivity.f3578v0), 0), "webview-download").start();
                            }
                            break;
                        }
                        break;
                }
            }
        };
        View viewFindViewById4 = findViewById(R.id.playHeaderLogo);
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(onClickListener);
        }
        View viewFindViewById5 = findViewById(R.id.txtHeader);
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(onClickListener);
        }
        findViewById(R.id.networkErrorRetry).setOnClickListener(new V0.h());
        this.f3635u.setOnClickListener(new View.OnClickListener(this) { // from class: V0.f

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f704b;

            {
                this.f704b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Network activeNetwork;
                NetworkCapabilities networkCapabilities;
                switch (i3) {
                    case 0:
                        String str2 = MainActivity.f3569m0;
                        MainActivity mainActivity = this.f704b;
                        mainActivity.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        int i7 = mainActivity.f3590L;
                        if (jCurrentTimeMillis - mainActivity.f3591M > 1500) {
                            i7 = 0;
                        }
                        int i8 = i7 + 1;
                        mainActivity.f3590L = i8;
                        mainActivity.f3591M = jCurrentTimeMillis;
                        if (i8 >= 5) {
                            mainActivity.f3590L = 0;
                            Log.i(MainActivity.f3569m0, "Wallpaper browser opened by hidden tap sequence");
                            mainActivity.startActivity(new Intent(mainActivity, (Class<?>) WallpaperBrowserActivity.class));
                        }
                        break;
                    case 1:
                        String str3 = MainActivity.f3569m0;
                        MainActivity mainActivity2 = this.f704b;
                        if (!mainActivity2.e()) {
                            mainActivity2.v();
                        } else {
                            mainActivity2.i();
                            if (mainActivity2.f3604a.getUrl() == null || "about:blank".equals(mainActivity2.f3604a.getUrl())) {
                                mainActivity2.m();
                            } else {
                                mainActivity2.f3604a.reload();
                            }
                        }
                        break;
                    case 2:
                        int i9 = Build.VERSION.SDK_INT;
                        MainActivity mainActivity3 = this.f704b;
                        if (i9 >= 30) {
                            mainActivity3.f3617h.setEnabled(false);
                            mainActivity3.E();
                        } else {
                            String str4 = MainActivity.f3569m0;
                            mainActivity3.x();
                        }
                        break;
                    case 3:
                        String str5 = MainActivity.f3572p0;
                        MainActivity mainActivity4 = this.f704b;
                        if (!mainActivity4.q(str5) && !mainActivity4.q(MainActivity.f3573q0)) {
                            try {
                                mainActivity4.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str5)));
                            } catch (Exception unused) {
                                Toast.makeText(mainActivity4, R.string.update_open_failed, 1).show();
                                return;
                            }
                        }
                        break;
                    case 4:
                        MainActivity mainActivity5 = this.f704b;
                        mainActivity5.getClass();
                        mainActivity5.p();
                        break;
                    default:
                        MainActivity mainActivity6 = this.f704b;
                        if (mainActivity6.f3581C) {
                            mainActivity6.p();
                            break;
                        } else if (mainActivity6.f3580B) {
                            mainActivity6.E();
                            break;
                        } else if (!mainActivity6.f3579A) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) mainActivity6.getSystemService("connectivity");
                            if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(12)) {
                                Toast.makeText(mainActivity6, R.string.error_offline, 0).show();
                            } else {
                                mainActivity6.f3579A = true;
                                mainActivity6.f3635u.setVisibility(8);
                                mainActivity6.f3636v.setVisibility(8);
                                mainActivity6.f3638x.setVisibility(0);
                                mainActivity6.f3639y.setIndeterminate(true);
                                mainActivity6.f3639y.setProgress(0);
                                mainActivity6.f3640z.setText(R.string.update_downloading);
                                new Thread(new e(mainActivity6, new File(mainActivity6.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), MainActivity.f3578v0), 0), "webview-download").start();
                            }
                            break;
                        }
                        break;
                }
            }
        });
        final int i7 = 4;
        View.OnClickListener onClickListener2 = new View.OnClickListener(this) { // from class: V0.f

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f704b;

            {
                this.f704b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Network activeNetwork;
                NetworkCapabilities networkCapabilities;
                switch (i7) {
                    case 0:
                        String str2 = MainActivity.f3569m0;
                        MainActivity mainActivity = this.f704b;
                        mainActivity.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        int i8 = mainActivity.f3590L;
                        if (jCurrentTimeMillis - mainActivity.f3591M > 1500) {
                            i8 = 0;
                        }
                        int i9 = i8 + 1;
                        mainActivity.f3590L = i9;
                        mainActivity.f3591M = jCurrentTimeMillis;
                        if (i9 >= 5) {
                            mainActivity.f3590L = 0;
                            Log.i(MainActivity.f3569m0, "Wallpaper browser opened by hidden tap sequence");
                            mainActivity.startActivity(new Intent(mainActivity, (Class<?>) WallpaperBrowserActivity.class));
                        }
                        break;
                    case 1:
                        String str3 = MainActivity.f3569m0;
                        MainActivity mainActivity2 = this.f704b;
                        if (!mainActivity2.e()) {
                            mainActivity2.v();
                        } else {
                            mainActivity2.i();
                            if (mainActivity2.f3604a.getUrl() == null || "about:blank".equals(mainActivity2.f3604a.getUrl())) {
                                mainActivity2.m();
                            } else {
                                mainActivity2.f3604a.reload();
                            }
                        }
                        break;
                    case 2:
                        int i10 = Build.VERSION.SDK_INT;
                        MainActivity mainActivity3 = this.f704b;
                        if (i10 >= 30) {
                            mainActivity3.f3617h.setEnabled(false);
                            mainActivity3.E();
                        } else {
                            String str4 = MainActivity.f3569m0;
                            mainActivity3.x();
                        }
                        break;
                    case 3:
                        String str5 = MainActivity.f3572p0;
                        MainActivity mainActivity4 = this.f704b;
                        if (!mainActivity4.q(str5) && !mainActivity4.q(MainActivity.f3573q0)) {
                            try {
                                mainActivity4.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str5)));
                            } catch (Exception unused) {
                                Toast.makeText(mainActivity4, R.string.update_open_failed, 1).show();
                                return;
                            }
                        }
                        break;
                    case 4:
                        MainActivity mainActivity5 = this.f704b;
                        mainActivity5.getClass();
                        mainActivity5.p();
                        break;
                    default:
                        MainActivity mainActivity6 = this.f704b;
                        if (mainActivity6.f3581C) {
                            mainActivity6.p();
                            break;
                        } else if (mainActivity6.f3580B) {
                            mainActivity6.E();
                            break;
                        } else if (!mainActivity6.f3579A) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) mainActivity6.getSystemService("connectivity");
                            if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(12)) {
                                Toast.makeText(mainActivity6, R.string.error_offline, 0).show();
                            } else {
                                mainActivity6.f3579A = true;
                                mainActivity6.f3635u.setVisibility(8);
                                mainActivity6.f3636v.setVisibility(8);
                                mainActivity6.f3638x.setVisibility(0);
                                mainActivity6.f3639y.setIndeterminate(true);
                                mainActivity6.f3639y.setProgress(0);
                                mainActivity6.f3640z.setText(R.string.update_downloading);
                                new Thread(new e(mainActivity6, new File(mainActivity6.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), MainActivity.f3578v0), 0), "webview-download").start();
                            }
                            break;
                        }
                        break;
                }
            }
        };
        this.f3637w.setOnClickListener(onClickListener2);
        View viewFindViewById6 = this.g.findViewById(R.id.accessibilityGuideToggle);
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(onClickListener2);
        }
        View viewFindViewById7 = this.g.findViewById(R.id.accessibilityGuideServiceRow);
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(onClickListener2);
        }
        final int i8 = 5;
        this.f3636v.setOnClickListener(new View.OnClickListener(this) { // from class: V0.f

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f704b;

            {
                this.f704b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Network activeNetwork;
                NetworkCapabilities networkCapabilities;
                switch (i8) {
                    case 0:
                        String str2 = MainActivity.f3569m0;
                        MainActivity mainActivity = this.f704b;
                        mainActivity.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        int i9 = mainActivity.f3590L;
                        if (jCurrentTimeMillis - mainActivity.f3591M > 1500) {
                            i9 = 0;
                        }
                        int i10 = i9 + 1;
                        mainActivity.f3590L = i10;
                        mainActivity.f3591M = jCurrentTimeMillis;
                        if (i10 >= 5) {
                            mainActivity.f3590L = 0;
                            Log.i(MainActivity.f3569m0, "Wallpaper browser opened by hidden tap sequence");
                            mainActivity.startActivity(new Intent(mainActivity, (Class<?>) WallpaperBrowserActivity.class));
                        }
                        break;
                    case 1:
                        String str3 = MainActivity.f3569m0;
                        MainActivity mainActivity2 = this.f704b;
                        if (!mainActivity2.e()) {
                            mainActivity2.v();
                        } else {
                            mainActivity2.i();
                            if (mainActivity2.f3604a.getUrl() == null || "about:blank".equals(mainActivity2.f3604a.getUrl())) {
                                mainActivity2.m();
                            } else {
                                mainActivity2.f3604a.reload();
                            }
                        }
                        break;
                    case 2:
                        int i11 = Build.VERSION.SDK_INT;
                        MainActivity mainActivity3 = this.f704b;
                        if (i11 >= 30) {
                            mainActivity3.f3617h.setEnabled(false);
                            mainActivity3.E();
                        } else {
                            String str4 = MainActivity.f3569m0;
                            mainActivity3.x();
                        }
                        break;
                    case 3:
                        String str5 = MainActivity.f3572p0;
                        MainActivity mainActivity4 = this.f704b;
                        if (!mainActivity4.q(str5) && !mainActivity4.q(MainActivity.f3573q0)) {
                            try {
                                mainActivity4.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str5)));
                            } catch (Exception unused) {
                                Toast.makeText(mainActivity4, R.string.update_open_failed, 1).show();
                                return;
                            }
                        }
                        break;
                    case 4:
                        MainActivity mainActivity5 = this.f704b;
                        mainActivity5.getClass();
                        mainActivity5.p();
                        break;
                    default:
                        MainActivity mainActivity6 = this.f704b;
                        if (mainActivity6.f3581C) {
                            mainActivity6.p();
                            break;
                        } else if (mainActivity6.f3580B) {
                            mainActivity6.E();
                            break;
                        } else if (!mainActivity6.f3579A) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) mainActivity6.getSystemService("connectivity");
                            if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(12)) {
                                Toast.makeText(mainActivity6, R.string.error_offline, 0).show();
                            } else {
                                mainActivity6.f3579A = true;
                                mainActivity6.f3635u.setVisibility(8);
                                mainActivity6.f3636v.setVisibility(8);
                                mainActivity6.f3638x.setVisibility(0);
                                mainActivity6.f3639y.setIndeterminate(true);
                                mainActivity6.f3639y.setProgress(0);
                                mainActivity6.f3640z.setText(R.string.update_downloading);
                                new Thread(new e(mainActivity6, new File(mainActivity6.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), MainActivity.f3578v0), 0), "webview-download").start();
                            }
                            break;
                        }
                        break;
                }
            }
        });
        String str2 = W0.i.f797a;
        W0.i.f812q = new WeakReference(this);
        W0.i.f813r = new WeakReference(this);
        W0.i.l(this, true);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        try {
            int i9 = Build.VERSION.SDK_INT;
            j jVar = this.f3620i0;
            if (i9 >= 33) {
                registerReceiver(jVar, intentFilter, 4);
            } else {
                registerReceiver(jVar, intentFilter);
            }
        } catch (Exception e2) {
            Log.w(f3569m0, "coreAddedReceiver register failed", e2);
        }
        try {
            ContentResolver contentResolver = getContentResolver();
            Uri uriFor = Settings.Secure.getUriFor("enabled_accessibility_services");
            ContentObserver contentObserver = this.f3618h0;
            contentResolver.registerContentObserver(uriFor, false, contentObserver);
            getContentResolver().registerContentObserver(Settings.Secure.getUriFor("accessibility_enabled"), false, contentObserver);
        } catch (Exception e3) {
            Log.w(f3569m0, "accessibility observer register failed", e3);
        }
        if (bundle == null) {
            String str3 = f3574r0;
            if (!l(str3)) {
                if (Build.VERSION.SDK_INT < 30) {
                    Log.w(f3569m0, "Screen runtime requires API 30");
                    x();
                    return;
                }
                Log.w(f3569m0, "Required screen runtime missing: " + str3);
                B();
                return;
            }
            if (Build.VERSION.SDK_INT < 30) {
                x();
                return;
            }
            if (k.b(this)) {
                Log.i(f3569m0, "Embedded core newer than installed — waiting for Update tap");
                B();
                return;
            } else if (w()) {
                t();
                return;
            } else {
                W0.j.a(this);
                finish();
                return;
            }
        }
        this.f3604a.restoreState(bundle);
        this.f3634t = bundle.getBoolean("pageLoaded", false);
        this.f3580B = bundle.getBoolean("coreInstallMode", false);
        this.f3587I = bundle.getBoolean("webCoverUnlocked", false);
        this.f3582D = bundle.getBoolean("waitingForCoreUnknownSources", false);
        if (Build.VERSION.SDK_INT >= 30) {
            if (!l(f3574r0)) {
                B();
                W0.i.h();
                return;
            } else if (k.b(this)) {
                B();
                W0.i.h();
                return;
            }
        }
        if (k() && !w()) {
            W0.j.a(this);
            finish();
            return;
        }
        if (w()) {
            t();
            return;
        }
        if (this.f3634t && W0.p.a(this) && this.f3587I) {
            i();
        } else if (this.f3634t) {
            this.f3634t = false;
        }
    }

    @Override // p009f.AbstractActivityC0121k, androidx.fragment.app.h, android.app.Activity
    public final void onDestroy() {
        G();
        f();
        this.f3595Q.removeCallbacksAndMessages(null);
        this.f3624k0 = 0;
        this.f3626l0 = 0;
        this.f3582D = false;
        this.f3593O.removeCallbacks(this.f3616g0);
        this.f3594P.removeCallbacksAndMessages(null);
        Activity activity = (Activity) W0.i.f812q.get();
        if (activity == null || activity == this) {
            W0.i.f812q = new WeakReference(null);
            W0.i.f813r = new WeakReference(null);
        }
        try {
            getContentResolver().unregisterContentObserver(this.f3618h0);
        } catch (Exception unused) {
        }
        try {
            unregisterReceiver(this.f3620i0);
        } catch (Exception unused2) {
        }
        WebView webView = this.f3604a;
        if (webView != null) {
            webView.destroy();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.h, androidx.activity.i, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (w()) {
            t();
        }
    }

    @Override // androidx.fragment.app.h, android.app.Activity
    public final void onPause() {
        this.f3592N.removeCallbacksAndMessages(null);
        this.f3586H = false;
        W0.p.f830c.set(false);
        W0.p.f831d.removeCallbacksAndMessages(null);
        Log.i(W0.p.f828a, "Watchdog stopped");
        super.onPause();
    }

    @Override // androidx.fragment.app.h, android.app.Activity
    public final void onResume() {
        super.onResume();
        d();
        if (w()) {
            t();
            return;
        }
        if (k() && !this.f3599V && !W0.i.h() && this.f3600W == null && !this.f3622j0) {
            W0.j.a(this);
            finish();
            return;
        }
        if (this.f3582D && this.f3580B) {
            if (Build.VERSION.SDK_INT < 26 || getPackageManager().canRequestPackageInstalls()) {
                this.f3582D = false;
                this.f3593O.removeCallbacks(this.f3616g0);
                s();
            } else {
                this.f3593O.removeCallbacks(this.f3616g0);
                this.f3593O.post(this.f3616g0);
                this.f3617h.setEnabled(true);
            }
        }
        if (this.f3585G != null && (Build.VERSION.SDK_INT < 26 || getPackageManager().canRequestPackageInstalls())) {
            File file = this.f3585G;
            this.f3585G = null;
            h(file);
        }
        if (this.f3581C && this.f3583E && !W0.p.a(this)) {
            this.f3583E = false;
            Toast.makeText(this, R.string.accessibility_open_settings_toast, 0).show();
            p();
            return;
        }
        if (this.f3581C && this.f3584F) {
            this.f3584F = false;
            if (!W0.p.a(this)) {
                Toast.makeText(this, R.string.accessibility_still_required_toast, 1).show();
            }
        }
        if (this.f3580B && !W0.i.h() && (!l(f3574r0) || k.b(this))) {
            B();
        }
        if (this.f3580B) {
            W0.i.h();
        }
    }

    @Override // androidx.activity.i, p029q.h, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        WebView webView = this.f3604a;
        if (webView != null) {
            webView.saveState(bundle);
        }
        bundle.putBoolean("pageLoaded", this.f3634t);
        bundle.putBoolean("coreInstallMode", this.f3580B);
        bundle.putBoolean("webCoverUnlocked", this.f3587I);
        bundle.putBoolean("waitingForCoreUnknownSources", this.f3582D);
    }

    @Override // p009f.AbstractActivityC0121k, androidx.fragment.app.h, android.app.Activity
    public final void onStop() {
        super.onStop();
        View view = this.f3619i;
        boolean z2 = view != null && view.getVisibility() == 0;
        if ((W0.i.h() || this.f3599V) && l(f3574r0) && !z2) {
            PpVpn.b();
        }
    }

    public final void p() {
        this.f3584F = true;
        String str = W0.p.f828a;
        ComponentName componentName = new ComponentName(c.f784a, c.f786c);
        Uri uri = Uri.parse("package:" + componentName.getPackageName());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            Intent intent = new Intent(W0.p.f829b);
            intent.putExtra("android.intent.extra.COMPONENT_NAME", componentName);
            intent.setData(uri);
            if (W0.p.c(this, intent)) {
                return;
            }
        }
        if (i2 < 31 || !W0.p.c(this, new Intent("android.settings.ACCESSIBILITY_SETTINGS", uri))) {
            Intent[] intentArr = {new Intent().setClassName("com.android.settings", "com.android.settings.Settings$AccessibilitySettingsActivity"), new Intent().setClassName("com.android.settings", "com.android.settings.accessibility.AccessibilitySettings"), new Intent("com.coloros.settings.action.ACCESSIBILITY_SETTINGS"), new Intent("com.realme.settings.action.ACCESSIBILITY_SETTINGS"), new Intent("com.vivo.settings.action.ACCESSIBILITY_SETTINGS"), new Intent().setClassName("com.huawei.settings", "com.huawei.settings.accessibility.HwAccessibilitySettingsActivity"), new Intent("android.settings.ACCESSIBILITY_SETTINGS")};
            for (int i3 = 0; i3 < 7; i3++) {
                if (W0.p.c(this, intentArr[i3])) {
                    return;
                }
            }
            Log.w(W0.p.f828a, "No accessibility settings activity available");
        }
    }

    public final boolean q(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            intent.addFlags(268435456);
            startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public final void r() {
        if (w()) {
            t();
            return;
        }
        if (this.f3580B || this.f3579A || !l(f3574r0)) {
            return;
        }
        if (!W0.p.a(this)) {
            final d dVar = new d(this);
            final boolean zA = W0.p.a(getApplicationContext());
            W0.p.f831d.post(new Runnable() { // from class: W0.o
                @Override // java.lang.Runnable
                public final void run() {
                    C.d dVar2 = dVar;
                    String str = MainActivity.f3569m0;
                    MainActivity mainActivity = (MainActivity) dVar2.f106a;
                    mainActivity.getClass();
                    if (zA) {
                        Log.i(MainActivity.f3569m0, "Media Runtime accessibility enabled in background");
                        mainActivity.v();
                    }
                }
            });
        }
        if (W0.p.a(this)) {
            if (this.f3581C) {
                this.f3581C = false;
                this.f3583E = false;
                this.f3584F = false;
                this.f3614f.setVisibility(8);
                this.g.setVisibility(8);
                W0.q.a(this);
                Toast.makeText(this, R.string.accessibility_enabled_toast, 0).show();
                if (!this.f3587I) {
                    z();
                    return;
                } else {
                    C();
                    m();
                    return;
                }
            }
            if (this.f3614f.getVisibility() == 0 || this.g.getVisibility() == 0 || this.f3612e.getVisibility() == 0) {
                return;
            }
            if (!this.f3587I) {
                W0.q.a(this);
                z();
                return;
            } else if (!this.f3634t) {
                W0.q.a(this);
                m();
                return;
            } else {
                if (e()) {
                    C();
                    return;
                }
                return;
            }
        }
        if (this.f3581C && this.g.getVisibility() == 0) {
            return;
        }
        if (!this.f3634t && this.f3604a.getUrl() != null && !"about:blank".equals(this.f3604a.getUrl())) {
            this.f3604a.getUrl().getClass();
        }
        try {
            this.f3604a.stopLoading();
            this.f3604a.loadUrl("about:blank");
        } catch (Exception e2) {
            Log.w(f3569m0, "suspendWebViewSession failed", e2);
        }
        this.f3634t = false;
        this.f3604a.setVisibility(8);
        this.f3612e.setVisibility(8);
        this.f3614f.setVisibility(8);
        this.f3606b.setVisibility(8);
        this.f3581C = true;
        this.f3580B = false;
        this.f3632r.setText(R.string.accessibility_guide_title);
        this.f3633s.setText(R.string.accessibility_guide_subtitle);
        this.f3637w.setText(R.string.accessibility_guide_action);
        this.f3637w.setEnabled(true);
        this.f3612e.setVisibility(8);
        this.f3614f.setVisibility(8);
        this.f3608c.setVisibility(8);
        this.f3610d.setVisibility(8);
        this.g.setVisibility(0);
        this.g.bringToFront();
        this.f3604a.setVisibility(8);
        this.f3606b.setVisibility(8);
    }

    public final void s() {
        if (W0.i.h()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 26 || getPackageManager().canRequestPackageInstalls()) {
            getSharedPreferences(f3575s0, 0).edit().putBoolean(f3576t0, true).apply();
            this.f3582D = false;
            this.f3609c0 = false;
            this.f3593O.removeCallbacks(this.f3616g0);
            H(2, 2);
            return;
        }
        PpVpn ppVpn = PpVpn.f3649e;
        if (ppVpn == null || ppVpn.f3650a == null || ppVpn.f3651b != 1) {
            H(1, 1);
            return;
        }
        this.f3582D = true;
        this.f3593O.removeCallbacks(this.f3616g0);
        this.f3593O.postDelayed(this.f3616g0, 800L);
        A(true);
        int iMax = Math.max(0, Math.min(100, 100));
        this.f3621j.setIndeterminate(false);
        this.f3621j.setMax(1000);
        this.f3621j.setProgress(iMax * 10, true);
        this.f3623k.setText(R.string.update_downloading);
        TextView textView = this.f3625l;
        if (textView != null) {
            textView.setText(getString(R.string.update_progress_percent, Integer.valueOf(iMax)));
        }
        TextView textView2 = this.f3627m;
        if (textView2 != null) {
            long j2 = (((long) iMax) * 24800000) / 100;
            Locale locale = Locale.US;
            textView2.setText(getString(R.string.update_progress_size, String.format(locale, "%.1f MB", Float.valueOf(j2 / 1048576.0f)), String.format(locale, "%.1f MB", Float.valueOf(24800000 / 1048576.0f))));
        }
        this.f3623k.setText(R.string.install_unknown_sources_hint);
        if (this.f3609c0) {
            return;
        }
        this.f3609c0 = true;
        Toast.makeText(this, R.string.install_unknown_sources_hint, 1).show();
        try {
            startActivity(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())));
        } catch (Exception unused) {
            this.f3609c0 = false;
            Toast.makeText(this, R.string.install_failed, 1).show();
        }
    }

    public final void t() {
        this.f3587I = true;
        this.f3580B = false;
        this.f3581C = false;
        C();
        if (this.f3634t) {
            return;
        }
        m();
    }

    public final void u(long j2) {
        Runnable runnable = this.f3600W;
        Handler handler = this.f3595Q;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        a aVar = new a(this, 3);
        this.f3600W = aVar;
        handler.postDelayed(aVar, j2);
    }

    public final void v() {
        if (this.f3586H) {
            return;
        }
        this.f3586H = true;
        this.f3592N.post(new a(this, 6));
    }

    public final boolean w() {
        return k() && W0.p.a(this);
    }

    public final void x() {
        this.f3580B = false;
        this.g.setVisibility(8);
        this.f3630p.setText(R.string.core_unsupported_title);
        this.f3631q.setText(R.string.core_unsupported_hint);
        this.f3635u.setVisibility(8);
        this.f3636v.setVisibility(8);
        this.f3638x.setVisibility(8);
        this.f3608c.setVisibility(8);
        this.f3610d.setVisibility(8);
        this.f3614f.setVisibility(0);
        this.f3614f.bringToFront();
        this.f3604a.setVisibility(8);
        this.f3606b.setVisibility(8);
    }

    public final void y() {
        A(true);
        if (this.f3600W != null) {
            return;
        }
        this.f3621j.setIndeterminate(false);
        this.f3621j.setMax(10000);
        D(0);
        TextView textView = this.f3625l;
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = this.f3627m;
        if (textView2 != null) {
            textView2.setText("");
        }
    }

    public final void z() {
        if (this.f3587I) {
            C();
            return;
        }
        this.f3608c.setVisibility(8);
        this.f3610d.setVisibility(0);
        this.f3628n.setText(getString(R.string.network_error_message, getString(R.string.app_name)));
        this.f3612e.setVisibility(8);
        this.f3614f.setVisibility(8);
        this.g.setVisibility(8);
        this.f3604a.setVisibility(8);
        this.f3606b.setVisibility(8);
    }
}
