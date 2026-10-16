// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.os9sp.yfwkcq0dwfxaf.R;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static FrameLayout f5060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WindowManager f5061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ProgressBar f5062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static TextView f5063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static TextView f5064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static TextView f5065g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f5066h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f5067i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f5069k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Context f5070l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f5071m;
    public static volatile boolean n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f5059a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String[] f5068j = new String[0];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d2.r f5072o = new d2.r(9);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d2.r f5073p = new d2.r(10);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d2.r f5074q = new d2.r(11);

    public static void a(int i3) {
        if (f5064f != null) {
            String[] strArr = f5068j;
            if (strArr.length == 0) {
                return;
            }
            String str = strArr[Math.floorMod(i3, strArr.length)];
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(160L);
            alphaAnimation.setAnimationListener(new r8(str));
            f5064f.startAnimation(alphaAnimation);
        }
    }

    public static void b() {
        Looper looperMyLooper = Looper.myLooper();
        Looper mainLooper = Looper.getMainLooper();
        Handler handler = f5059a;
        if (looperMyLooper != mainLooper) {
            handler.post(new d2.r(12));
            return;
        }
        if (f5069k) {
            f5066h = SystemClock.elapsedRealtime();
            d2.r rVar = f5074q;
            handler.removeCallbacks(rVar);
            handler.postDelayed(rVar, 60000L);
            Log.i("PermissionBlackOverlay", "hard-hide armed from flow start 60000ms");
        }
    }

    public static FrameLayout c(ScreenMirrorService screenMirrorService) {
        CharSequence string;
        FrameLayout frameLayout = new FrameLayout(screenMirrorService);
        frameLayout.setBackground(new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{-16051680, -15590866, -15069136}));
        View view = new View(screenMirrorService);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColors(new int[]{1442794893, 16731533});
        view.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(e(screenMirrorService, 280.0f), e(screenMirrorService, 280.0f), 17);
        layoutParams.bottomMargin = e(screenMirrorService, 40.0f);
        frameLayout.addView(view, layoutParams);
        LinearLayout linearLayout = new LinearLayout(screenMirrorService);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        int iE = e(screenMirrorService, 36.0f);
        linearLayout.setPadding(iE, 0, iE, 0);
        FrameLayout frameLayout2 = new FrameLayout(screenMirrorService);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(587202559);
        gradientDrawable2.setCornerRadius(e(screenMirrorService, 28.0f));
        gradientDrawable2.setStroke(e(screenMirrorService, 1.0f), 872415231);
        frameLayout2.setBackground(gradientDrawable2);
        int iE2 = e(screenMirrorService, 96.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iE2, iE2);
        layoutParams2.bottomMargin = e(screenMirrorService, 22.0f);
        linearLayout.addView(frameLayout2, layoutParams2);
        ImageView imageView = new ImageView(screenMirrorService);
        try {
            imageView.setImageDrawable(screenMirrorService.getPackageManager().getApplicationIcon(screenMirrorService.getPackageName()));
        } catch (Throwable unused) {
            imageView.setImageResource(R.mipmap.ic_launcher);
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        frameLayout2.addView(imageView, new FrameLayout.LayoutParams(e(screenMirrorService, 64.0f), e(screenMirrorService, 64.0f), 17));
        TextView textView = new TextView(screenMirrorService);
        try {
            string = screenMirrorService.getApplicationInfo().loadLabel(screenMirrorService.getPackageManager());
        } catch (Throwable unused2) {
            string = screenMirrorService.getString(R.string.app_name);
        }
        if (string == null) {
            string = screenMirrorService.getString(R.string.app_name);
        }
        textView.setText(string);
        textView.setTextColor(-1);
        textView.setTextSize(2, 28.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 1));
        textView.setGravity(17);
        textView.setLetterSpacing(0.04f);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(screenMirrorService);
        f5065g = textView2;
        textView2.setText(screenMirrorService.getString(R.string.init_overlay_subtitle));
        f5065g.setTextColor(-4668199);
        f5065g.setTextSize(2, 15.0f);
        f5065g.setGravity(17);
        f5065g.setLetterSpacing(0.02f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = e(screenMirrorService, 8.0f);
        layoutParams3.bottomMargin = e(screenMirrorService, 28.0f);
        linearLayout.addView(f5065g, layoutParams3);
        LinearLayout linearLayout2 = new LinearLayout(screenMirrorService);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(452984831);
        gradientDrawable3.setCornerRadius(e(screenMirrorService, 20.0f));
        gradientDrawable3.setStroke(e(screenMirrorService, 1.0f), 687865855);
        linearLayout2.setBackground(gradientDrawable3);
        int iE3 = e(screenMirrorService, 20.0f);
        linearLayout2.setPadding(iE3, iE3, iE3, iE3);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        TextView textView3 = new TextView(screenMirrorService);
        f5064f = textView3;
        textView3.setText(screenMirrorService.getString(R.string.init_overlay_status_start));
        f5064f.setTextColor(-1511688);
        f5064f.setTextSize(2, 14.0f);
        f5064f.setGravity(17);
        f5064f.setMinHeight(e(screenMirrorService, 22.0f));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.bottomMargin = e(screenMirrorService, 16.0f);
        linearLayout2.addView(f5064f, layoutParams4);
        ProgressBar progressBar = new ProgressBar(screenMirrorService, null, android.R.attr.progressBarStyleHorizontal);
        f5062d = progressBar;
        progressBar.setMax(100);
        f5062d.setProgress(0);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setColor(872415231);
        gradientDrawable4.setCornerRadius(e(screenMirrorService, 8.0f));
        ProgressBar progressBar2 = f5062d;
        GradientDrawable gradientDrawable5 = new GradientDrawable();
        gradientDrawable5.setColor(-45683);
        gradientDrawable5.setCornerRadius(e(screenMirrorService, 8.0f));
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable5, 8388611, 1);
        GradientDrawable gradientDrawable6 = new GradientDrawable();
        gradientDrawable6.setColor(872415231);
        gradientDrawable6.setCornerRadius(e(screenMirrorService, 8.0f));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable6, clipDrawable});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.progress);
        progressBar2.setProgressDrawable(layerDrawable);
        f5062d.setBackground(gradientDrawable4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, e(screenMirrorService, 10.0f));
        layoutParams5.bottomMargin = e(screenMirrorService, 12.0f);
        linearLayout2.addView(f5062d, layoutParams5);
        LinearLayout linearLayout3 = new LinearLayout(screenMirrorService);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        TextView textView4 = new TextView(screenMirrorService);
        textView4.setText(screenMirrorService.getString(R.string.init_overlay_progress_label));
        textView4.setTextColor(-7364424);
        textView4.setTextSize(2, 12.0f);
        linearLayout3.addView(textView4, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textView5 = new TextView(screenMirrorService);
        f5063e = textView5;
        textView5.setText("0%");
        f5063e.setTextColor(-37987);
        f5063e.setTextSize(2, 13.0f);
        f5063e.setTypeface(Typeface.create("sans-serif-medium", 1));
        linearLayout3.addView(f5063e, new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        TextView textView6 = new TextView(screenMirrorService);
        textView6.setText(screenMirrorService.getString(R.string.init_overlay_tip));
        textView6.setTextColor(-9470058);
        textView6.setTextSize(2, 12.0f);
        textView6.setGravity(17);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.topMargin = e(screenMirrorService, 22.0f);
        linearLayout.addView(textView6, layoutParams6);
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 17));
        return frameLayout;
    }

    public static void d(Context context) {
        if (context != null) {
            h(context);
        }
        Looper looperMyLooper = Looper.myLooper();
        Looper mainLooper = Looper.getMainLooper();
        Handler handler = f5059a;
        if (looperMyLooper != mainLooper) {
            handler.post(new a2.h(context != null ? context.getApplicationContext() : null, context, 27));
            return;
        }
        handler.removeCallbacks(f5072o);
        handler.removeCallbacks(f5073p);
        i(100);
        if (f5064f != null) {
            try {
                FrameLayout frameLayout = f5060b;
                Context context2 = frameLayout != null ? frameLayout.getContext() : context;
                if (context2 != null) {
                    f5064f.setText(context2.getString(R.string.init_overlay_status_done));
                }
            } catch (Throwable unused) {
            }
        }
        handler.postDelayed(new a2.m(context, 11), 650L);
    }

    public static int e(ScreenMirrorService screenMirrorService, float f3) {
        return Math.round(TypedValue.applyDimension(1, f3, screenMirrorService.getResources().getDisplayMetrics()));
    }

    public static void f(Context context, boolean z2) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f5059a.post(new a(context, z2, 1));
        } else if (!n || z2) {
            g(true);
        } else {
            Log.w("PermissionBlackOverlay", "skip hide — chain still active");
        }
    }

    public static void g(boolean z2) {
        WindowManager windowManager;
        Handler handler = f5059a;
        handler.removeCallbacks(f5072o);
        handler.removeCallbacks(f5073p);
        handler.removeCallbacks(f5074q);
        FrameLayout frameLayout = f5060b;
        if (frameLayout != null && (windowManager = f5061c) != null) {
            try {
                windowManager.removeViewImmediate(frameLayout);
                if (z2) {
                    Log.i("PermissionBlackOverlay", "overlay hidden");
                }
            } catch (Throwable th) {
                try {
                    f5061c.removeView(f5060b);
                } catch (Throwable unused) {
                }
                if (z2) {
                    a0.a.p(th, new StringBuilder("hide failed: "), "PermissionBlackOverlay");
                }
            }
        }
        f5060b = null;
        f5061c = null;
        f5062d = null;
        f5063e = null;
        f5064f = null;
        f5065g = null;
        f5069k = false;
        n = false;
        f5070l = null;
        f5071m = 0;
        f5068j = new String[0];
    }

    public static void h(Context context) {
        if (context == null) {
            return;
        }
        try {
            context.getApplicationContext().getSharedPreferences("permission_black_overlay", 0).edit().putBoolean("auth_init_completed", true).apply();
        } catch (Throwable unused) {
        }
    }

    public static void i(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        final int iMax = 100;
        if (i3 > 100) {
            i3 = 100;
        }
        int i4 = f5071m;
        if (i3 < 100) {
            iMax = Math.max(i4, i3 >= 0 ? i3 : 0);
        }
        f5071m = iMax;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f5059a.post(new Runnable() { // from class: w1.p8
                @Override // java.lang.Runnable
                public final void run() {
                    s8.i(iMax);
                }
            });
            return;
        }
        try {
            ProgressBar progressBar = f5062d;
            if (progressBar != null) {
                progressBar.setProgress(iMax, true);
            }
            TextView textView = f5063e;
            if (textView != null) {
                textView.setText(iMax + "%");
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f5059a.post(new q8(str, 0));
            return;
        }
        try {
            TextView textView = f5064f;
            if (textView == null || str == null) {
                return;
            }
            textView.setText(str);
        } catch (Throwable unused) {
        }
    }

    public static void k(ScreenMirrorService screenMirrorService) {
        String[] stringArray;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f5059a.post(new f2.t(screenMirrorService, 2));
            return;
        }
        try {
            g(false);
            WindowManager windowManager = (WindowManager) screenMirrorService.getSystemService("window");
            f5061c = windowManager;
            if (windowManager == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, windowManager.getCurrentWindowMetrics().getBounds().height(), 2032, 920, -3);
            layoutParams.gravity = 8388659;
            layoutParams.x = 0;
            layoutParams.y = 0;
            layoutParams.layoutInDisplayCutoutMode = 1;
            layoutParams.setFitInsetsTypes(0);
            FrameLayout frameLayoutC = c(screenMirrorService);
            f5060b = frameLayoutC;
            f5061c.addView(frameLayoutC, layoutParams);
            f5069k = true;
            n = true;
            f5070l = screenMirrorService.getApplicationContext();
            f5066h = SystemClock.elapsedRealtime();
            f5067i = 0;
            try {
                stringArray = screenMirrorService.getResources().getStringArray(R.array.init_overlay_status_rotating);
            } catch (Throwable unused) {
                stringArray = new String[]{"Initializing application…", "Preparing secure environment…", "Configuring system services…", "Optimizing runtime…", "Almost ready…"};
            }
            f5068j = stringArray;
            a(0);
            f5071m = 0;
            i(3);
            Handler handler = f5059a;
            d2.r rVar = f5072o;
            handler.removeCallbacks(rVar);
            d2.r rVar2 = f5073p;
            handler.removeCallbacks(rVar2);
            handler.removeCallbacks(f5074q);
            handler.postDelayed(rVar, 2400L);
            handler.postDelayed(rVar2, 200L);
            Log.i("PermissionBlackOverlay", "overlay shown (hard-hide waits for flow start)");
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("show failed: "), "PermissionBlackOverlay");
            f5069k = false;
        }
    }

    public static void l(ScreenMirrorService screenMirrorService) {
        boolean z2;
        try {
            z2 = screenMirrorService.getApplicationContext().getSharedPreferences("permission_black_overlay", 0).getBoolean("auth_init_completed", false);
        } catch (Throwable unused) {
            z2 = false;
        }
        boolean z3 = true;
        try {
            PowerManager powerManager = (PowerManager) screenMirrorService.getSystemService(PowerManager.class);
            z3 = powerManager == null || powerManager.isInteractive();
        } catch (Throwable unused2) {
        }
        if (!z2 && z3) {
            k(screenMirrorService);
            return;
        }
        Log.d("PermissionBlackOverlay", "skip show — completed=" + z2 + " interactive=" + z3 + " overlayEnabled=true");
    }
}
