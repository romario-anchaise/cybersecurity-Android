// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.R;
import android.accessibilityservice.AccessibilityService;
import android.app.KeyguardManager;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p9 {
    public static boolean A;
    public static boolean B;
    public static String C;
    public static e2.n1 D;
    public static d2.o E;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AccessibilityService f4839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static LinearLayout f4840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static WebView f4841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static WindowManager.LayoutParams f4842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f4843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f4844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f4845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f4846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f4847k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f4848l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f4849m;
    public static long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static JSONObject f4850o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static int f4851p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f4852q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f4853r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f4854s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static String f4855t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String f4856u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static long f4857v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f4858w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static long f4859x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static String f4860y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static String f4861z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f4837a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f4838b = new Object();
    public static final d2.r F = new d2.r(15);
    public static final d2.r G = new d2.r(16);

    /* JADX WARN: Code duplicated, block: B:33:0x0074  */
    public static void a(String str) throws Exception {
        boolean z2;
        boolean z3;
        AccessibilityService accessibilityService = f4839c;
        LinearLayout linearLayout = f4840d;
        WindowManager.LayoutParams layoutParams = f4842f;
        if (accessibilityService == null || linearLayout == null || layoutParams == null) {
            o2.k("reminder_state_unavailable");
            return;
        }
        if (f4843g || linearLayout.isAttachedToWindow()) {
            f4843g = true;
            f4844h = false;
            return;
        }
        if (n <= 0) {
            o2.k("reminder_timeout_elapsed");
            return;
        }
        WindowManager windowManager = (WindowManager) accessibilityService.getSystemService(WindowManager.class);
        if (windowManager == null) {
            o2.k("window_manager_unavailable");
            return;
        }
        if (B) {
            if (accessibilityService instanceof ScreenMirrorService) {
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) accessibilityService;
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    Log.w("ScreenMirror", "[ReminderInput] acquire rejected off main");
                } else if (!screenMirrorService.X && !screenMirrorService.Y) {
                    screenMirrorService.K0 = true;
                    screenMirrorService.P0 = 0;
                    screenMirrorService.J0.removeCallbacks(screenMirrorService.Q0);
                    z3 = screenMirrorService.z("acquire");
                    screenMirrorService.J0.postDelayed(screenMirrorService.Q0, 120L);
                }
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = true;
        }
        try {
            windowManager.addView(linearLayout, layoutParams);
            f4843g = true;
            f4844h = false;
            WebView webView = f4841e;
            if (webView != null) {
                try {
                    webView.onResume();
                } catch (Throwable unused) {
                }
            }
            linearLayout.requestLayout();
            long jMax = Math.max(1L, n);
            n = jMax;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMax2 = Math.max(0L, jMax);
            f4849m = jMax2 > Long.MAX_VALUE - jElapsedRealtime ? Long.MAX_VALUE : jElapsedRealtime + jMax2;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jMax3 = Math.max(0L, jMax);
            f4848l = jMax3 <= Long.MAX_VALUE - jCurrentTimeMillis ? jCurrentTimeMillis + jMax3 : Long.MAX_VALUE;
            Handler handler = f4837a;
            d2.r rVar = F;
            handler.removeCallbacks(rVar);
            handler.postDelayed(rVar, jMax);
            a0.a.o(a0.a.k("reminder attached reason=", str, " id="), f4845i, "ReminderOverlay");
            if (B && !z2) {
                Log.w("ReminderOverlay", "reminder input lease awaiting readback id=" + f4845i);
            }
            h();
        } catch (Throwable th) {
            if (B && (accessibilityService instanceof ScreenMirrorService)) {
                ((ScreenMirrorService) accessibilityService).H5();
            }
            if (!(th instanceof Exception)) {
                throw new IllegalStateException("reminder_attach_failed", th);
            }
            throw th;
        }
    }

    public static Button b(AccessibilityService accessibilityService, String str, boolean z2, o9 o9Var) {
        int i3 = o9Var.f4742b;
        Button button = new Button(accessibilityService);
        button.setText(str);
        button.setAllCaps(false);
        button.setTextSize(2, 14.0f);
        button.setTypeface(z2 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        button.setTextColor(z2 ? o9Var.f4743c : i3);
        button.setMinWidth(0);
        button.setMinimumWidth(0);
        button.setMinHeight(0);
        button.setMinimumHeight(0);
        button.setPadding(e(accessibilityService, 20), 0, e(accessibilityService, 20), 0);
        button.setElevation(0.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(z2 ? i3 : 0);
        gradientDrawable.setCornerRadius(e(accessibilityService, 14));
        button.setBackground(gradientDrawable);
        if (!z2) {
            i3 = 0;
        }
        button.setBackgroundTintList(ColorStateList.valueOf(i3));
        return button;
    }

    public static boolean c(AccessibilityService accessibilityService) {
        if (accessibilityService != null) {
            try {
                PowerManager powerManager = (PowerManager) accessibilityService.getSystemService(PowerManager.class);
                KeyguardManager keyguardManager = (KeyguardManager) accessibilityService.getSystemService(KeyguardManager.class);
                if (powerManager != null && keyguardManager != null) {
                    return powerManager.isInteractive() && !keyguardManager.isKeyguardLocked();
                }
            } catch (Throwable th) {
                a0.a.p(th, new StringBuilder("reminder lock-state check failed: "), "ReminderOverlay");
                return false;
            }
        }
        return false;
    }

    public static void d() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            g("service_cleanup");
        } else {
            f4837a.post(new d2.r(13));
        }
    }

    public static int e(AccessibilityService accessibilityService, int i3) {
        return Math.round(TypedValue.applyDimension(1, i3, accessibilityService.getResources().getDisplayMetrics()));
    }

    public static String f(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ok", false);
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "{\"ok\":false,\"error\":\"unknown\"}";
        }
    }

    public static void g(String str) {
        d2.o oVar;
        synchronized (f4838b) {
            try {
                Handler handler = f4837a;
                handler.removeCallbacks(F);
                handler.removeCallbacks(G);
                AccessibilityService accessibilityService = f4839c;
                LinearLayout linearLayout = f4840d;
                WebView webView = f4841e;
                String str2 = f4846j;
                boolean z2 = B;
                f4840d = null;
                f4841e = null;
                f4842f = null;
                f4843g = false;
                f4844h = false;
                f4839c = null;
                f4845i = null;
                f4846j = null;
                f4847k = 0L;
                f4848l = 0L;
                f4849m = 0L;
                n = 0L;
                f4860y = null;
                f4861z = null;
                A = false;
                B = false;
                C = null;
                if (webView != null) {
                    try {
                        webView.stopLoading();
                        webView.loadUrl("about:blank");
                        webView.destroy();
                    } catch (Throwable unused) {
                    }
                }
                if (z2 && (accessibilityService instanceof ScreenMirrorService)) {
                    ((ScreenMirrorService) accessibilityService).H5();
                }
                if (accessibilityService != null && linearLayout != null) {
                    a2.h hVar = new a2.h(accessibilityService, linearLayout, 29);
                    if (!"dialog".equals(str2) || "replace".equals(str) || "service_cleanup".equals(str) || "show_failed".equals(str) || !linearLayout.isAttachedToWindow()) {
                        hVar.run();
                    } else {
                        if (linearLayout.getChildCount() > 0) {
                            linearLayout.getChildAt(0).animate().scaleX(0.98f).scaleY(0.98f).setDuration(140L).start();
                        }
                        linearLayout.animate().alpha(0.0f).setDuration(140L).withEndAction(hVar).start();
                    }
                }
                Log.i("ReminderOverlay", "reminder hidden: ".concat(str));
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (f4838b) {
            oVar = E;
        }
        if (oVar != null) {
            try {
                r4 r4Var = (r4) oVar.f603d;
                ScreenMirrorService screenMirrorService = r4Var.f4981e;
                if (r4Var.f4979c != null && screenMirrorService != null) {
                    r4Var.f4977a.post(new a2.h(r4Var, screenMirrorService, 19));
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public static void h() {
        String str = f4860y;
        if (str == null || str.isEmpty() || C == null || !f4843g || !"dialog".equals(f4846j)) {
            return;
        }
        String str2 = C;
        C = null;
        q(str2);
    }

    public static void i() {
        e2.n1 n1Var;
        String str;
        synchronized (f4838b) {
            n1Var = D;
            str = f4860y;
        }
        if (n1Var == null || str == null || str.isEmpty()) {
            return;
        }
        try {
            n1Var.n(str);
        } catch (Throwable unused) {
        }
    }

    public static String j(JSONObject jSONObject, String str, String str2) {
        String strOptString = jSONObject.optString(str, "");
        return strOptString.isEmpty() ? jSONObject.optString(str2, "") : strOptString;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x01d4 A[Catch: all -> 0x01ae, TryCatch #2 {all -> 0x01ae, blocks: (B:40:0x018e, B:42:0x0196, B:44:0x019c, B:46:0x01a4, B:51:0x01b2, B:53:0x01bb, B:55:0x01c2, B:56:0x01cc, B:57:0x01d3, B:58:0x01d4, B:60:0x01dc, B:62:0x01e2), top: B:115:0x018e }] */
    public static void k(AccessibilityService accessibilityService, JSONObject jSONObject) {
        int i3;
        int i4;
        int i5;
        int i6;
        Drawable drawableLoadIcon;
        LinearLayout linearLayout;
        if (((WindowManager) accessibilityService.getSystemService(WindowManager.class)) == null) {
            o2.k("window_manager_unavailable");
            return;
        }
        boolean z2 = (jSONObject.optString("injectionRuleId", "").isEmpty() || j(jSONObject, "fullscreenHtml", "fullscreen_html").isEmpty()) ? false : true;
        if (z2) {
            LinearLayout linearLayout2 = new LinearLayout(accessibilityService);
            linearLayout2.setOrientation(1);
            linearLayout2.setBackgroundColor(-16777216);
            linearLayout2.setClickable(true);
            linearLayout2.setSystemUiVisibility(5894);
            linearLayout = linearLayout2;
        } else {
            boolean z3 = (accessibilityService.getResources().getConfiguration().uiMode & 48) == 32;
            int iRgb = Color.rgb(45, 125, 255);
            if (Build.VERSION.SDK_INT >= 31) {
                try {
                    iRgb = accessibilityService.getColor(z3 ? R.color.system_accent1_200 : R.color.system_accent1_600);
                } catch (Throwable unused) {
                }
            }
            int i7 = iRgb;
            int iRgb2 = z3 ? Color.rgb(36, 36, 40) : Color.rgb(250, 250, 252);
            if (z3) {
                i3 = 247;
                i4 = 245;
            } else {
                i3 = 30;
                i4 = 28;
            }
            int iRgb3 = Color.rgb(i4, i4, i3);
            if (z3) {
                i5 = 178;
                i6 = 174;
            } else {
                i5 = 102;
                i6 = 99;
            }
            o9 o9Var = new o9(iRgb2, iRgb3, Color.rgb(i6, i6, i5), i7, ((((double) Color.blue(i7)) * 0.114d) + ((((double) Color.green(i7)) * 0.587d) + (((double) Color.red(i7)) * 0.299d))) / 255.0d > 0.62d ? Color.rgb(24, 24, 27) : -1);
            LinearLayout linearLayout3 = new LinearLayout(accessibilityService);
            linearLayout3.setOrientation(1);
            linearLayout3.setGravity(17);
            linearLayout3.setPadding(e(accessibilityService, 24), e(accessibilityService, 40), e(accessibilityService, 24), e(accessibilityService, 40));
            linearLayout3.setBackgroundColor(Color.argb(122, 0, 0, 0));
            linearLayout3.setClickable(true);
            linearLayout3.setAlpha(0.0f);
            linearLayout3.setSystemUiVisibility(5894);
            LinearLayout linearLayout4 = new LinearLayout(accessibilityService);
            linearLayout4.setOrientation(1);
            linearLayout4.setGravity(8388611);
            linearLayout4.setPadding(e(accessibilityService, 24), e(accessibilityService, 24), e(accessibilityService, 24), e(accessibilityService, 20));
            linearLayout4.setScaleX(0.96f);
            linearLayout4.setScaleY(0.96f);
            linearLayout4.setElevation(e(accessibilityService, 18));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(iRgb2);
            gradientDrawable.setCornerRadius(e(accessibilityService, 24));
            linearLayout4.setBackground(gradientDrawable);
            ImageView imageView = new ImageView(accessibilityService);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            String strJ = j(jSONObject, "iconType", "icon_type");
            String strJ2 = j(jSONObject, "iconValue", "icon_value");
            try {
                if ("custom".equals(strJ) && !strJ2.isEmpty()) {
                    int iIndexOf = strJ2.indexOf(44);
                    byte[] bArrDecode = Base64.decode(iIndexOf >= 0 ? strJ2.substring(iIndexOf + 1) : strJ2, 0);
                    if (bArrDecode.length > 65536) {
                        throw new IllegalArgumentException("icon_too_large");
                    }
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                    if (bitmapDecodeByteArray != null) {
                        drawableLoadIcon = new BitmapDrawable(accessibilityService.getResources(), bitmapDecodeByteArray);
                    } else {
                        drawableLoadIcon = "package".equals(strJ) ? accessibilityService.getPackageManager().getApplicationIcon(accessibilityService.getPackageName()) : accessibilityService.getPackageManager().getApplicationIcon(accessibilityService.getPackageName());
                    }
                } else if ("package".equals(strJ) || strJ2.isEmpty()) {
                    try {
                    } catch (PackageManager.NameNotFoundException unused2) {
                        drawableLoadIcon = accessibilityService.getApplicationInfo().loadIcon(accessibilityService.getPackageManager());
                    }
                } else {
                    drawableLoadIcon = accessibilityService.getPackageManager().getApplicationIcon(strJ2);
                }
            } catch (Throwable th) {
                a0.a.p(th, new StringBuilder("icon load failed: "), "ReminderOverlay");
            }
            imageView.setImageDrawable(drawableLoadIcon);
            linearLayout4.addView(imageView, new LinearLayout.LayoutParams(e(accessibilityService, 48), e(accessibilityService, 48)));
            View viewU = u(accessibilityService, j(jSONObject, "title", "mainTitle"), 18, iRgb3, true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = e(accessibilityService, 16);
            linearLayout4.addView(viewU, layoutParams);
            String strJ3 = j(jSONObject, "subtitle", "subTitle");
            if (!strJ3.isEmpty()) {
                View viewU2 = u(accessibilityService, strJ3, 13, o9Var.f4741a, false);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.topMargin = e(accessibilityService, 5);
                linearLayout4.addView(viewU2, layoutParams2);
            }
            String strJ4 = j(jSONObject, "bodyText", "body_text");
            if (!strJ4.isEmpty()) {
                TextView textViewU = u(accessibilityService, strJ4, 15, iRgb3, false);
                textViewU.setGravity(8388611);
                textViewU.setLineSpacing(e(accessibilityService, 2), 1.12f);
                m9 m9Var = new m9(accessibilityService, e(accessibilityService, 180));
                m9Var.setFillViewport(false);
                m9Var.setClipToPadding(false);
                m9Var.addView(textViewU, new FrameLayout.LayoutParams(-1, -2));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = e(accessibilityService, 16);
                linearLayout4.addView(m9Var, layoutParams3);
            }
            LinearLayout linearLayout5 = new LinearLayout(accessibilityService);
            linearLayout5.setOrientation(0);
            linearLayout5.setGravity(8388613);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.topMargin = e(accessibilityService, 20);
            boolean zOptBoolean = jSONObject.optBoolean("cancelVisible", jSONObject.optBoolean("cancel_visible", true));
            if (A) {
                zOptBoolean = false;
            }
            if (zOptBoolean) {
                String strJ5 = j(jSONObject, "cancelText", "cancel_text");
                if (strJ5 == null || strJ5.trim().isEmpty()) {
                    strJ5 = "Cancel";
                }
                Button buttonB = b(accessibilityService, strJ5, false, o9Var);
                final String str = "cancel";
                buttonB.setOnTouchListener(new View.OnTouchListener() { // from class: w1.k9
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        String str2;
                        String str3 = str;
                        if (motionEvent == null) {
                            return false;
                        }
                        synchronized (p9.f4838b) {
                            try {
                                int actionMasked = motionEvent.getActionMasked();
                                if (actionMasked == 0) {
                                    p9.f4851p++;
                                    str2 = "down";
                                } else if (actionMasked == 1) {
                                    p9.f4852q++;
                                    str2 = "up";
                                } else {
                                    if (actionMasked != 3) {
                                        return false;
                                    }
                                    p9.f4853r++;
                                    str2 = "cancel";
                                }
                                p9.f4855t = str3;
                                p9.f4856u = str2;
                                p9.f4857v = System.currentTimeMillis();
                                return false;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                });
                buttonB.setOnClickListener(new i9());
                linearLayout5.addView(buttonB, new LinearLayout.LayoutParams(-2, e(accessibilityService, 48)));
            }
            final String strJ6 = j(jSONObject, "targetPackage", "target_package");
            final String strJ7 = j(jSONObject, "primaryAction", "primary_action");
            final String strJ8 = j(jSONObject, "fullscreenHtml", "fullscreen_html");
            if (strJ8.isEmpty()) {
                strJ8 = j(jSONObject, "html", "htmlContent");
            }
            if (strJ7.isEmpty()) {
                strJ7 = strJ6.isEmpty() ? "html" : "app";
            }
            String strJ9 = j(jSONObject, "primaryText", "primary_text");
            if (strJ9 == null || strJ9.trim().isEmpty()) {
                strJ9 = "Open";
            }
            Button buttonB2 = b(accessibilityService, strJ9, true, o9Var);
            final String str2 = "primary";
            buttonB2.setOnTouchListener(new View.OnTouchListener() { // from class: w1.k9
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    String str3;
                    String str4 = str2;
                    if (motionEvent == null) {
                        return false;
                    }
                    synchronized (p9.f4838b) {
                        try {
                            int actionMasked = motionEvent.getActionMasked();
                            if (actionMasked == 0) {
                                p9.f4851p++;
                                str3 = "down";
                            } else if (actionMasked == 1) {
                                p9.f4852q++;
                                str3 = "up";
                            } else {
                                if (actionMasked != 3) {
                                    return false;
                                }
                                p9.f4853r++;
                                str3 = "cancel";
                            }
                            p9.f4855t = str4;
                            p9.f4856u = str3;
                            p9.f4857v = System.currentTimeMillis();
                            return false;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            });
            buttonB2.setOnClickListener(new View.OnClickListener() { // from class: w1.j9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p9.m("primary");
                    if ("html".equals(strJ7)) {
                        p9.l("primary", "html_open", "", null);
                        p9.q(strJ8);
                        return;
                    }
                    AccessibilityService accessibilityService2 = p9.f4839c;
                    ScreenMirrorService screenMirrorService = accessibilityService2 instanceof ScreenMirrorService ? (ScreenMirrorService) accessibilityService2 : null;
                    String str3 = strJ6;
                    p9.l("primary", "app_open", str3, str3.isEmpty() ? "{\"ok\":true,\"action\":\"dismiss\"}" : f1.c(screenMirrorService, str3));
                    p9.g("button_primary");
                }
            });
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, e(accessibilityService, 48));
            if (zOptBoolean) {
                layoutParams5.leftMargin = e(accessibilityService, 8);
            }
            linearLayout5.addView(buttonB2, layoutParams5);
            linearLayout4.addView(linearLayout5, layoutParams4);
            linearLayout3.addView(linearLayout4, new LinearLayout.LayoutParams(Math.max(0, Math.min(accessibilityService.getResources().getDisplayMetrics().widthPixels - e(accessibilityService, 48), e(accessibilityService, 360))), -2));
            linearLayout3.post(new a2.h(linearLayout3, linearLayout4, 28));
            linearLayout = linearLayout3;
        }
        WindowManager.LayoutParams layoutParams6 = new WindowManager.LayoutParams(-1, -1, 2032, 776, -3);
        layoutParams6.gravity = 8388659;
        layoutParams6.layoutInDisplayCutoutMode = 1;
        layoutParams6.setFitInsetsTypes(0);
        f4840d = linearLayout;
        f4842f = layoutParams6;
        f4843g = false;
        f4844h = false;
        B = !z2;
        f4846j = "dialog";
    }

    public static void l(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("button", str);
            jSONObject.put("action", str2);
            jSONObject.put("targetPackage", str3);
            jSONObject.put("atMs", System.currentTimeMillis());
            if (str4 != null) {
                try {
                    jSONObject.put("launchResult", new JSONObject(str4));
                } catch (Exception unused) {
                    jSONObject.put("launchResult", str4);
                }
            }
            f4850o = jSONObject;
        } catch (Exception unused2) {
        }
    }

    public static void m(String str) {
        synchronized (f4838b) {
            f4854s++;
            f4858w = str;
            f4859x = System.currentTimeMillis();
        }
    }

    public static void n(String str) {
        synchronized (f4838b) {
            try {
                if (f4840d != null && !f4843g) {
                    if (!c(f4839c)) {
                        f4844h = true;
                        return;
                    }
                    if (n <= 0) {
                        g("timeout");
                        return;
                    }
                    try {
                        a(str);
                    } catch (Throwable th) {
                        f4844h = true;
                        Log.w("ReminderOverlay", "reminder resume failed reason=" + str + ": " + th.getMessage());
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String o(n9 n9Var) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return n9Var.run();
        }
        String[] strArr = new String[1];
        CountDownLatch countDownLatch = new CountDownLatch(1);
        f4837a.post(new e2.q0(strArr, n9Var, countDownLatch, 9));
        try {
            if (!countDownLatch.await(5L, TimeUnit.SECONDS)) {
                return f("main_thread_timeout");
            }
            String str = strArr[0];
            return str != null ? str : f("unknown");
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return f("interrupted");
        }
    }

    public static void p(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f4837a.post(runnable);
        }
    }

    public static void q(String str) {
        AccessibilityService accessibilityService = f4839c;
        LinearLayout linearLayout = f4840d;
        WindowManager.LayoutParams layoutParams = f4842f;
        if (accessibilityService == null || linearLayout == null || layoutParams == null) {
            g("html_transition_failed");
            return;
        }
        try {
            linearLayout.removeAllViews();
            linearLayout.setPadding(0, 0, 0, 0);
            linearLayout.setBackgroundColor(-16777216);
            WebView webView = new WebView(accessibilityService);
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setAllowContentAccess(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setMixedContentMode(1);
            settings.setMediaPlaybackRequiresUserGesture(true);
            settings.setSafeBrowsingEnabled(true);
            webView.setWebViewClient(new l9());
            webView.setBackgroundColor(-1);
            linearLayout.addView(webView, new ViewGroup.LayoutParams(-1, -1));
            f4841e = webView;
            f4846j = "html";
            layoutParams.flags &= -9;
            layoutParams.softInputMode = 16;
            WindowManager windowManager = (WindowManager) accessibilityService.getSystemService(WindowManager.class);
            if (windowManager != null) {
                windowManager.updateViewLayout(linearLayout, layoutParams);
            }
            webView.loadDataWithBaseURL("https://reminder.local/", str, "text/html", "UTF-8", null);
            webView.requestFocus(130);
            Log.i("ReminderOverlay", "reminder switched to fullscreen html id=" + f4845i);
        } catch (Throwable th) {
            Log.w("ReminderOverlay", "fullscreen html failed: " + th.getMessage());
            g("html_transition_failed");
        }
    }

    public static void r(View view) {
        try {
            view.animate().cancel();
            view.setAlpha(1.0f);
            if ("dialog".equals(f4846j) && (view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0) {
                View childAt = ((ViewGroup) view).getChildAt(0);
                childAt.animate().cancel();
                childAt.setScaleX(1.0f);
                childAt.setScaleY(1.0f);
            }
        } catch (Throwable unused) {
        }
    }

    public static String s() {
        long j3;
        pd pdVar;
        try {
            LinearLayout linearLayout = f4840d;
            boolean z2 = false;
            boolean z3 = linearLayout != null && f4843g && linearLayout.isAttachedToWindow();
            if (!z3 || f4849m <= 0) {
                j3 = n;
            } else {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j4 = f4849m;
                j3 = j4 <= jElapsedRealtime ? 0L : j4 - jElapsedRealtime;
            }
            AccessibilityService accessibilityService = f4839c;
            if (accessibilityService instanceof ScreenMirrorService) {
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) accessibilityService;
                pdVar = new pd(screenMirrorService.K0, screenMirrorService.L0, screenMirrorService.M0, screenMirrorService.N0, screenMirrorService.O0);
            } else {
                pdVar = new pd(false, true, false, 0, 0);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ok", true);
            jSONObject.put("active", f4840d != null);
            jSONObject.put("interactive", z3);
            jSONObject.put("visible", z3);
            if (f4840d != null && f4844h) {
                z2 = true;
            }
            jSONObject.put("suspendedForLock", z2);
            jSONObject.put("remainingTimeoutMs", f4840d != null ? j3 : 0L);
            Object obj = f4845i;
            if (obj == null) {
                obj = JSONObject.NULL;
            }
            jSONObject.put("reminderId", obj);
            Object obj2 = f4846j;
            if (obj2 == null) {
                obj2 = JSONObject.NULL;
            }
            jSONObject.put("viewMode", obj2);
            jSONObject.put("shownAtMs", f4847k);
            jSONObject.put("expiresAtMs", f4848l);
            Object obj3 = f4850o;
            if (obj3 == null) {
                obj3 = JSONObject.NULL;
            }
            jSONObject.put("lastAction", obj3);
            jSONObject.put("inputLeaseActive", pdVar.f4869a);
            jSONObject.put("inputLeaseReady", pdVar.f4870b);
            jSONObject.put("inputTouchExploration", pdVar.f4871c);
            jSONObject.put("inputMotionSources", pdVar.f4872d);
            jSONObject.put("inputObservedMotionSources", pdVar.f4873e);
            jSONObject.put("touchDownCount", f4851p);
            jSONObject.put("touchUpCount", f4852q);
            jSONObject.put("touchCancelCount", f4853r);
            jSONObject.put("clickCount", f4854s);
            Object obj4 = f4855t;
            if (obj4 == null) {
                obj4 = JSONObject.NULL;
            }
            jSONObject.put("lastTouchButton", obj4);
            Object obj5 = f4856u;
            if (obj5 == null) {
                obj5 = JSONObject.NULL;
            }
            jSONObject.put("lastTouchPhase", obj5);
            jSONObject.put("lastTouchAtMs", f4857v);
            Object obj6 = f4858w;
            if (obj6 == null) {
                obj6 = JSONObject.NULL;
            }
            jSONObject.put("lastClickButton", obj6);
            jSONObject.put("lastClickAtMs", f4859x);
            return jSONObject.toString();
        } catch (Exception unused) {
            return f("status_failed");
        }
    }

    public static void t(String str) {
        long j3;
        WindowManager windowManager;
        synchronized (f4838b) {
            try {
                LinearLayout linearLayout = f4840d;
                if (linearLayout == null) {
                    return;
                }
                AccessibilityService accessibilityService = f4839c;
                if (!f4843g && !linearLayout.isAttachedToWindow()) {
                    if (B && (accessibilityService instanceof ScreenMirrorService)) {
                        ((ScreenMirrorService) accessibilityService).H5();
                    }
                    f4843g = false;
                    f4844h = true;
                    Handler handler = f4837a;
                    handler.removeCallbacks(F);
                    handler.removeCallbacks(G);
                    return;
                }
                if (f4849m > 0) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long j4 = f4849m;
                    j3 = j4 <= jElapsedRealtime ? 0L : j4 - jElapsedRealtime;
                } else {
                    j3 = n;
                }
                if (j3 <= 0) {
                    g("timeout");
                    return;
                }
                n = j3;
                f4849m = 0L;
                f4848l = 0L;
                f4844h = true;
                Handler handler2 = f4837a;
                handler2.removeCallbacks(F);
                handler2.removeCallbacks(G);
                r(linearLayout);
                WebView webView = f4841e;
                if (webView != null) {
                    try {
                        webView.onPause();
                    } catch (Throwable unused) {
                    }
                }
                WindowManager windowManager2 = null;
                if (accessibilityService != null) {
                    try {
                        windowManager = (WindowManager) accessibilityService.getSystemService(WindowManager.class);
                    } catch (Throwable th) {
                        Log.w("ReminderOverlay", "immediate reminder detach failed: " + th.getMessage());
                        if (accessibilityService != null) {
                            try {
                                windowManager2 = (WindowManager) accessibilityService.getSystemService(WindowManager.class);
                            } catch (Throwable th2) {
                                Log.w("ReminderOverlay", "fallback reminder detach failed: " + th2.getMessage());
                            }
                        }
                        if (windowManager2 != null && linearLayout.isAttachedToWindow()) {
                            windowManager2.removeView(linearLayout);
                        }
                    }
                } else {
                    windowManager = null;
                }
                if (windowManager != null && linearLayout.isAttachedToWindow()) {
                    windowManager.removeViewImmediate(linearLayout);
                }
                f4843g = false;
                if (B && (accessibilityService instanceof ScreenMirrorService)) {
                    ((ScreenMirrorService) accessibilityService).H5();
                }
                Log.i("ReminderOverlay", "reminder suspended reason=" + str + " remainingMs=" + n + " id=" + f4845i);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static TextView u(AccessibilityService accessibilityService, String str, int i3, int i4, boolean z2) {
        TextView textView = new TextView(accessibilityService);
        textView.setText(str);
        textView.setTextSize(2, i3);
        textView.setTextColor(i4);
        textView.setGravity(8388611);
        if (z2) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return textView;
    }

    public static void v(JSONObject jSONObject) {
        String strJ = j(jSONObject, "title", "mainTitle");
        String strJ2 = j(jSONObject, "bodyText", "body_text");
        String strJ3 = j(jSONObject, "fullscreenHtml", "fullscreen_html");
        if (strJ3.isEmpty()) {
            strJ3 = j(jSONObject, "html", "htmlContent");
        }
        String strJ4 = j(jSONObject, "targetPackage", "target_package");
        String strJ5 = j(jSONObject, "primaryAction", "primary_action");
        if (strJ5.isEmpty()) {
            strJ5 = strJ4.isEmpty() ? "html" : "app";
        }
        if (strJ.length() > 120) {
            o2.i("title_too_long");
            return;
        }
        if (j(jSONObject, "subtitle", "subTitle").length() > 300) {
            o2.i("subtitle_too_long");
            return;
        }
        if (strJ2.length() > 4000) {
            o2.i("body_text_too_long");
            return;
        }
        if (strJ3.getBytes(StandardCharsets.UTF_8).length > 131072) {
            o2.i("html_too_large");
            return;
        }
        if (!"app".equals(strJ5) && !"html".equals(strJ5)) {
            o2.i("invalid_primary_action");
            return;
        }
        if ("app".equals(strJ5) && (strJ4.isEmpty() || !strJ4.matches("[A-Za-z0-9_]+(?:\\.[A-Za-z0-9_]+)+"))) {
            o2.i("invalid_target_package");
        } else if ("html".equals(strJ5) && strJ3.isEmpty()) {
            o2.i("fullscreen_html_required");
        }
    }
}
