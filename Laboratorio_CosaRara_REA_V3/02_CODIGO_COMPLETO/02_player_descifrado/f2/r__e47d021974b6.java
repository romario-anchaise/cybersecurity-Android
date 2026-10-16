// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.app.KeyguardManager;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import lyr.stable.runtime.ScreenMirrorService;
import w1.aa;
import w1.rd;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScreenMirrorService f1311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f1312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y.m f1313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a0 f1314d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final aa f1316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1319i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1320j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f1321k;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f1315e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1322l = -1;

    public r(ScreenMirrorService screenMirrorService, x1.r rVar, aa aaVar) {
        this.f1311a = screenMirrorService;
        this.f1312b = new x(screenMirrorService, rVar);
        this.f1313c = new y.m(screenMirrorService);
        this.f1314d = new a0(screenMirrorService, rVar);
        this.f1316f = aaVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    public final void a(AccessibilityEvent accessibilityEvent) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean zA;
        AccessibilityNodeInfo accessibilityNodeInfoG;
        boolean z5;
        char c3;
        AccessibilityNodeInfo accessibilityNodeInfoObtain;
        boolean zIsChecked;
        char c4;
        char c5;
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 32 || eventType == 2048) {
            ScreenMirrorService screenMirrorService = this.f1311a;
            int iN = l.n(screenMirrorService);
            String str = Build.MANUFACTURER;
            boolean zJ = i0.J(l.k(), iN);
            final int i3 = 1;
            a0 a0Var = this.f1314d;
            if (zJ && !this.f1317g) {
                a0Var.k();
                this.f1317g = true;
            } else if (!zJ && this.f1317g) {
                a0Var.k();
                this.f1317g = false;
            }
            boolean zQ = l.q(screenMirrorService);
            try {
                PowerManager powerManager = (PowerManager) screenMirrorService.getSystemService("power");
                z2 = powerManager == null || powerManager.isInteractive();
                try {
                    KeyguardManager keyguardManager = (KeyguardManager) screenMirrorService.getSystemService("keyguard");
                    z3 = keyguardManager != null && keyguardManager.isKeyguardLocked();
                } catch (Throwable unused) {
                    z3 = false;
                }
            } catch (Throwable unused2) {
                z2 = true;
            }
            b2.e eVarI = i0.i(w1.n.p0(screenMirrorService).a(), true, false, l.m(screenMirrorService), System.currentTimeMillis(), z2, z3, c2.p.e(screenMirrorService, "auto_setup_prefs").getLong("permission_automation_accessibility_destroyed_at", 0L), c2.p.e(screenMirrorService, "auto_setup_prefs").getString("permission_automation_accessibility_destroy_reason", ""));
            if (zQ && i0.o(iN) >= 0 && eVarI.f272b) {
                AccessibilityNodeInfo accessibilityNodeInfoK = i0.k(screenMirrorService, "auto-setup", accessibilityEvent, new b2.a(10));
                if (accessibilityNodeInfoK != null) {
                    try {
                        String string = accessibilityNodeInfoK.getPackageName() == null ? "" : accessibilityNodeInfoK.getPackageName().toString();
                        String string2 = accessibilityEvent.getPackageName() == null ? "" : accessibilityEvent.getPackageName().toString();
                        StringBuilder sb = new StringBuilder();
                        if (accessibilityNodeInfoK.getClassName() != null) {
                            sb.append(accessibilityNodeInfoK.getClassName());
                        }
                        sb.append(' ');
                        if (accessibilityEvent.getClassName() != null) {
                            sb.append(accessibilityEvent.getClassName());
                        }
                        if (l.E(string, string2, sb.toString(), y.m.n(accessibilityNodeInfoK), screenMirrorService.getPackageName())) {
                            Log.i("AutoSetupClick", "skip clicks — still on a11y page");
                            y.m.q(accessibilityNodeInfoK);
                            return;
                        }
                    } catch (Throwable th) {
                        y.m.q(accessibilityNodeInfoK);
                        throw th;
                    }
                }
                y.m.q(accessibilityNodeInfoK);
                x xVar = this.f1312b;
                if (iN == 0 || iN == 1 || iN == 3) {
                    AccessibilityNodeInfo accessibilityNodeInfoK2 = i0.k(xVar.f1358c, "system-dialog", accessibilityEvent, new b2.a(10));
                    if (accessibilityNodeInfoK2 == null) {
                        zA = false;
                    } else {
                        String strM = x.m(accessibilityNodeInfoK2);
                        if (strM != null) {
                            String[] strArr = i0.f1210i;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= 6) {
                                    z4 = false;
                                    break;
                                } else {
                                    if (strArr[i4].equals(strM)) {
                                        z4 = true;
                                        break;
                                    }
                                    i4++;
                                }
                            }
                        } else {
                            z4 = false;
                            break;
                        }
                        if (!z4 && i0.v(strM) && (accessibilityNodeInfoG = xVar.g(strM)) != null) {
                            x.n(accessibilityNodeInfoK2);
                            try {
                                Log.i("CalisePopSysDialog", "switched to dialog window pkg=" + x.m(accessibilityNodeInfoG));
                                accessibilityNodeInfoK2 = accessibilityNodeInfoG;
                            } catch (Throwable th2) {
                                th = th2;
                                accessibilityNodeInfoK2 = accessibilityNodeInfoG;
                                try {
                                    Log.e("CalisePopSysDialog", "tryAutoClickSystemDialog error", th);
                                    x.n(accessibilityNodeInfoK2);
                                    zA = false;
                                } catch (Throwable th3) {
                                    x.n(accessibilityNodeInfoK2);
                                    throw th3;
                                }
                            }
                        }
                        if (xVar.c(accessibilityNodeInfoK2) || xVar.b(accessibilityNodeInfoK2)) {
                            x.n(accessibilityNodeInfoK2);
                            zA = true;
                        } else {
                            zA = xVar.a(accessibilityNodeInfoK2);
                            x.n(accessibilityNodeInfoK2);
                        }
                    }
                    z5 = zA;
                } else {
                    z5 = false;
                }
                int i5 = 5;
                ?? r11 = z5;
                if (iN == 0) {
                    AccessibilityNodeInfo accessibilityNodeInfoK3 = i0.k(xVar.f1358c, "settings-switch", accessibilityEvent, new b2.a(10));
                    if (accessibilityNodeInfoK3 == null) {
                        c5 = 0;
                    } else {
                        try {
                            String strM2 = x.m(accessibilityNodeInfoK3);
                            if (i0.v(strM2) || strM2.toLowerCase(Locale.ROOT).contains("permission")) {
                                Iterator it = x.f1352f.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        String str2 = (String) it.next();
                                        try {
                                            List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfoK3.findAccessibilityNodeInfosByViewId(str2);
                                            if (listFindAccessibilityNodeInfosByViewId != null && !listFindAccessibilityNodeInfosByViewId.isEmpty()) {
                                                Iterator<AccessibilityNodeInfo> it2 = listFindAccessibilityNodeInfosByViewId.iterator();
                                                while (true) {
                                                    if (it2.hasNext()) {
                                                        AccessibilityNodeInfo next = it2.next();
                                                        try {
                                                            if (next.isCheckable() && next.isEnabled()) {
                                                                if (next.isChecked()) {
                                                                    Log.i("CalisePopSysDialog", "Switch already enabled: " + str2);
                                                                } else {
                                                                    AccessibilityNodeInfo parent = next.getParent();
                                                                    int i6 = 0;
                                                                    while (true) {
                                                                        if (parent == null || i6 >= i5) {
                                                                            x.n(parent);
                                                                            if (xVar.d(next)) {
                                                                                Log.i("CalisePopSysDialog", "Auto-click settings switch: " + str2);
                                                                            }
                                                                        } else if (x.f(x.l(parent), x.f1355i)) {
                                                                            x.n(parent);
                                                                            Log.d("CalisePopSysDialog", "skip switch near dangerous label: " + str2);
                                                                        } else {
                                                                            AccessibilityNodeInfo parent2 = parent.getParent();
                                                                            x.n(parent);
                                                                            i6++;
                                                                            parent = parent2;
                                                                            i5 = 5;
                                                                        }
                                                                    }
                                                                }
                                                                x.n(next);
                                                                x.n(accessibilityNodeInfoK3);
                                                                c5 = 1;
                                                            }
                                                            x.n(next);
                                                            i5 = 5;
                                                        } catch (Throwable th4) {
                                                            x.n(next);
                                                            throw th4;
                                                        }
                                                    } else {
                                                        continue;
                                                    }
                                                }
                                            }
                                        } catch (Exception unused3) {
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            try {
                                Log.e("CalisePopSysDialog", "tryAutoClickSettingsSwitch error", th5);
                                x.n(accessibilityNodeInfoK3);
                                c5 = 0;
                            } catch (Throwable th6) {
                                x.n(accessibilityNodeInfoK3);
                                throw th6;
                            }
                        }
                        x.n(accessibilityNodeInfoK3);
                        c5 = 0;
                    }
                    r11 = (z5 ? 1 : 0) | c5;
                }
                if (iN == 1) {
                    ScreenMirrorService screenMirrorService2 = xVar.f1358c;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - xVar.f1357b >= 1500) {
                        if (!i0.B(screenMirrorService2)) {
                            AccessibilityNodeInfo accessibilityNodeInfoK4 = i0.k(screenMirrorService2, "installed-apps-permission", accessibilityEvent, new b2.a(11));
                            if (accessibilityNodeInfoK4 != null) {
                                try {
                                    AccessibilityNodeInfo accessibilityNodeInfoJ = x.j(accessibilityNodeInfoK4);
                                    if (accessibilityNodeInfoJ == null) {
                                        accessibilityNodeInfoObtain = null;
                                    } else {
                                        accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfoJ);
                                        int i7 = 0;
                                        while (true) {
                                            if (accessibilityNodeInfoObtain != null && i7 < 6) {
                                                if (x.h(accessibilityNodeInfoObtain) != null || accessibilityNodeInfoObtain.isClickable()) {
                                                    break;
                                                    break;
                                                }
                                                AccessibilityNodeInfo parent3 = accessibilityNodeInfoObtain.getParent();
                                                x.n(accessibilityNodeInfoObtain);
                                                i7++;
                                                accessibilityNodeInfoObtain = parent3;
                                            } else {
                                                x.n(accessibilityNodeInfoObtain);
                                                accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfoJ);
                                                break;
                                            }
                                        }
                                        if (accessibilityNodeInfoObtain != accessibilityNodeInfoJ) {
                                            x.n(accessibilityNodeInfoJ);
                                        }
                                    }
                                    if (accessibilityNodeInfoObtain != null) {
                                        try {
                                            AccessibilityNodeInfo accessibilityNodeInfoH = x.h(accessibilityNodeInfoObtain);
                                            if (accessibilityNodeInfoH == null) {
                                                zIsChecked = false;
                                            } else {
                                                try {
                                                    zIsChecked = accessibilityNodeInfoH.isChecked();
                                                    x.n(accessibilityNodeInfoH);
                                                } catch (Throwable th7) {
                                                    x.n(accessibilityNodeInfoH);
                                                    throw th7;
                                                }
                                            }
                                            if (zIsChecked) {
                                                Log.i("CalisePopSysDialog", "installed-apps row UI-checked but native query still restricted");
                                            } else if (xVar.d(accessibilityNodeInfoObtain)) {
                                                xVar.f1357b = jCurrentTimeMillis;
                                                Log.i("CalisePopSysDialog", "clicked installed-apps permission row");
                                                x.n(accessibilityNodeInfoObtain);
                                                x.n(accessibilityNodeInfoK4);
                                            }
                                            x.n(accessibilityNodeInfoObtain);
                                        } catch (Throwable th8) {
                                            x.n(accessibilityNodeInfoObtain);
                                            throw th8;
                                        }
                                    }
                                } catch (Throwable th9) {
                                    try {
                                        Log.e("CalisePopSysDialog", "tryAutoClickInstalledAppsPermission error", th9);
                                    } catch (Throwable th10) {
                                        x.n(accessibilityNodeInfoK4);
                                        throw th10;
                                    }
                                }
                                x.n(accessibilityNodeInfoK4);
                            }
                            c4 = 0;
                        }
                        c4 = 1;
                    } else {
                        c4 = 0;
                    }
                    r11 = (r11 == true ? 1 : 0) | c4;
                }
                boolean z6 = iN == 2;
                aa aaVar = this.f1316f;
                Handler handler = this.f1315e;
                y.m mVar = this.f1313c;
                ?? r12 = r11;
                if (z6) {
                    int iN2 = l.n(screenMirrorService);
                    String str3 = Build.MANUFACTURER;
                    if (!i0.J(l.k(), iN2)) {
                        AccessibilityNodeInfo accessibilityNodeInfoK5 = i0.k(screenMirrorService, "vendor-battery", accessibilityEvent, new b2.a(8));
                        if (accessibilityNodeInfoK5 == null) {
                            c3 = 0;
                        } else {
                            try {
                                final int iD = mVar.d(accessibilityNodeInfoK5, y.m.o(screenMirrorService), 2, false);
                                if (iD == 2 || iD == 1) {
                                    handler.postDelayed(new Runnable(this) { // from class: f2.p

                                        /* JADX INFO: renamed from: d, reason: collision with root package name */
                                        public final /* synthetic */ r f1280d;

                                        {
                                            this.f1280d = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            switch (i3) {
                                                case 0:
                                                    ScreenMirrorService screenMirrorService3 = this.f1280d.f1311a;
                                                    String lowerCase = a0.a.t(iD).toLowerCase(Locale.ROOT);
                                                    SharedPreferences.Editor editorPutBoolean = l.Y(screenMirrorService3).edit().putBoolean("background_popup_step_verified", true);
                                                    if (lowerCase == null) {
                                                        lowerCase = "";
                                                    }
                                                    editorPutBoolean.putString("background_popup_done_reason", lowerCase).apply();
                                                    break;
                                                default:
                                                    l.S(this.f1280d.f1311a, a0.a.t(iD).toLowerCase(Locale.ROOT));
                                                    break;
                                            }
                                        }
                                    }, 900L);
                                    y.m.q(accessibilityNodeInfoK5);
                                } else {
                                    if (iD == 5 || iD == 6) {
                                        b(2, accessibilityEvent, a0.a.t(iD));
                                    }
                                    c3 = iD == 4 ? (char) 1 : (char) 0;
                                    y.m.q(accessibilityNodeInfoK5);
                                }
                            } catch (Throwable th11) {
                                y.m.q(accessibilityNodeInfoK5);
                                throw th11;
                            }
                        }
                        r12 = (r11 == true ? 1 : 0) | c3;
                    } else if (d(accessibilityEvent) != 3 && !this.f1318h) {
                        this.f1318h = true;
                        q qVar = new q(this, 0);
                        ScreenMirrorService screenMirrorService3 = aaVar.f3491d;
                        rd rdVar = ScreenMirrorService.n6;
                        if (!screenMirrorService3.d5(600L, qVar)) {
                            this.f1318h = false;
                        }
                    }
                    c3 = 1;
                    r12 = (r11 == true ? 1 : 0) | c3;
                }
                ?? r13 = r12;
                if (iN == 4) {
                    if (!this.f1319i) {
                        this.f1319i = true;
                        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(accessibilityEvent);
                        a2.h hVar = new a2.h(this, accessibilityEventObtain, 7);
                        ScreenMirrorService screenMirrorService4 = aaVar.f3491d;
                        rd rdVar2 = ScreenMirrorService.n6;
                        if (!screenMirrorService4.d5(300L, hVar)) {
                            this.f1319i = false;
                            try {
                                accessibilityEventObtain.recycle();
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                    r13 = 1;
                }
                if (iN == 5) {
                    if (!l.Y(screenMirrorService).getBoolean("background_popup_step_verified", false)) {
                        AccessibilityNodeInfo accessibilityNodeInfoK6 = i0.k(screenMirrorService, "background-popup", accessibilityEvent, new b2.a(7));
                        if (accessibilityNodeInfoK6 == null) {
                            i3 = 0;
                        } else {
                            try {
                                final int iD2 = mVar.d(accessibilityNodeInfoK6, y.m.o(screenMirrorService), 5, false);
                                if (iD2 == 2 || iD2 == 1) {
                                    final int i8 = 0;
                                    handler.postDelayed(new Runnable(this) { // from class: f2.p

                                        /* JADX INFO: renamed from: d, reason: collision with root package name */
                                        public final /* synthetic */ r f1280d;

                                        {
                                            this.f1280d = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            switch (i8) {
                                                case 0:
                                                    ScreenMirrorService screenMirrorService5 = this.f1280d.f1311a;
                                                    String lowerCase = a0.a.t(iD2).toLowerCase(Locale.ROOT);
                                                    SharedPreferences.Editor editorPutBoolean = l.Y(screenMirrorService5).edit().putBoolean("background_popup_step_verified", true);
                                                    if (lowerCase == null) {
                                                        lowerCase = "";
                                                    }
                                                    editorPutBoolean.putString("background_popup_done_reason", lowerCase).apply();
                                                    break;
                                                default:
                                                    l.S(this.f1280d.f1311a, a0.a.t(iD2).toLowerCase(Locale.ROOT));
                                                    break;
                                            }
                                        }
                                    }, 900L);
                                } else {
                                    if (iD2 == 5 || iD2 == 6) {
                                        b(5, accessibilityEvent, a0.a.t(iD2));
                                    }
                                    if (iD2 != 4) {
                                        i3 = 0;
                                    }
                                }
                                y.m.q(accessibilityNodeInfoK6);
                            } catch (Throwable th12) {
                                y.m.q(accessibilityNodeInfoK6);
                                throw th12;
                            }
                        }
                    }
                    r13 = (r13 == true ? 1 : 0) | i3;
                }
                if (r13 == 0) {
                    b(iN, accessibilityEvent, "all_strategies_missed");
                }
            }
        }
    }

    public final void b(int i3, AccessibilityEvent accessibilityEvent, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i3 != this.f1322l || jCurrentTimeMillis - this.f1321k >= 4000) {
            this.f1322l = i3;
            this.f1321k = jCurrentTimeMillis;
            b2.a aVar = new b2.a(10);
            ScreenMirrorService screenMirrorService = this.f1311a;
            AccessibilityNodeInfo accessibilityNodeInfoK = i0.k(screenMirrorService, "snapshot", accessibilityEvent, aVar);
            try {
                i0.P(screenMirrorService, i3, str, accessibilityNodeInfoK);
            } finally {
                y.m.q(accessibilityNodeInfoK);
            }
        }
    }

    public final void c(AccessibilityEvent accessibilityEvent) {
        y.m mVar = this.f1313c;
        ScreenMirrorService screenMirrorService = this.f1311a;
        int iE = i0.E(screenMirrorService);
        if (iE == 1) {
            l.N(screenMirrorService, "miui_appop_allowed");
            return;
        }
        AccessibilityNodeInfo accessibilityNodeInfoK = i0.k(screenMirrorService, "auto-start", accessibilityEvent, new b2.a(9));
        if (accessibilityNodeInfoK == null) {
            b(4, accessibilityEvent, "no_root");
            return;
        }
        try {
            String str = Build.MODEL;
            String lowerCase = str == null ? "" : str.toLowerCase();
            int iD = mVar.d(accessibilityNodeInfoK, y.m.o(screenMirrorService), 4, lowerCase.contains("mi 8") || lowerCase.contains("mi8") || "mi 8".equals(lowerCase));
            if (iD == 2 && iE != 2) {
                l.N(screenMirrorService, "checked");
                return;
            }
            aa aaVar = this.f1316f;
            if (iD == 2) {
                if (!mVar.c(accessibilityNodeInfoK, y.m.o(screenMirrorService))) {
                    Log.w("AutoSetupClick", "auto-start row checked but MIUI AppOp denied");
                    return;
                }
                c0.i(12);
                mVar.t();
                if (!this.f1320j) {
                    this.f1320j = true;
                    q qVar = new q(this, 1);
                    ScreenMirrorService screenMirrorService2 = aaVar.f3491d;
                    rd rdVar = ScreenMirrorService.n6;
                    if (!screenMirrorService2.d5(1800L, qVar)) {
                        this.f1320j = false;
                    }
                }
                Log.w("AutoSetupClick", "reconciling checked auto-start row with denied AppOp");
                return;
            }
            if (iD != 1 && iD != 3) {
                if (iD == 5 || iD == 6) {
                    b(4, accessibilityEvent, a0.a.t(iD));
                }
                return;
            }
            if (!this.f1320j) {
                this.f1320j = true;
                q qVar2 = new q(this, 1);
                ScreenMirrorService screenMirrorService3 = aaVar.f3491d;
                rd rdVar2 = ScreenMirrorService.n6;
                if (!screenMirrorService3.d5(1800L, qVar2)) {
                    this.f1320j = false;
                }
            }
        } finally {
            y.m.q(accessibilityNodeInfoK);
        }
    }

    public final int d(AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo root;
        AccessibilityNodeInfo accessibilityNodeInfo;
        boolean zN;
        String str;
        String strB0;
        boolean z2 = this.f1317g;
        int i3 = 1;
        a0 a0Var = this.f1314d;
        if (!z2) {
            a0Var.k();
            this.f1317g = true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ScreenMirrorService screenMirrorService = a0Var.f1122a;
        String str2 = Build.MANUFACTURER;
        boolean z3 = false;
        if (l.k() == 2) {
            AccessibilityNodeInfo accessibilityNodeInfoK = i0.k(screenMirrorService, "miui-vendor-battery", accessibilityEvent, new b2.a(13));
            if (accessibilityNodeInfoK == null) {
                return 2;
            }
            try {
                if ("com.miui.securitycenter".equals(a0.m(accessibilityNodeInfoK.getPackageName())) && jCurrentTimeMillis - a0Var.f1125d >= 500) {
                    AccessibilityNodeInfo accessibilityNodeInfoC = a0.c(0, accessibilityNodeInfoK, y.m.o(screenMirrorService));
                    if (accessibilityNodeInfoC == null) {
                        a0.j(accessibilityNodeInfoK);
                        return 2;
                    }
                    a0.j(accessibilityNodeInfoC);
                    String[] strArr = l.f1246q;
                    int i4 = 0;
                    while (true) {
                        str = "";
                        if (i4 >= 2) {
                            strB0 = "";
                            break;
                        }
                        strB0 = l.b0(screenMirrorService, "com.miui.securitycenter", strArr[i4]);
                        if (!strB0.isEmpty()) {
                            break;
                        }
                        i4++;
                    }
                    AccessibilityNodeInfo accessibilityNodeInfoC2 = a0.c(0, accessibilityNodeInfoK, l.C(strB0, l.f1248s));
                    if (accessibilityNodeInfoC2 != null) {
                        try {
                            AccessibilityNodeInfo accessibilityNodeInfoG = a0.g(accessibilityNodeInfoC2);
                            if (accessibilityNodeInfoG != null) {
                                try {
                                    if (accessibilityNodeInfoG.isCheckable() && accessibilityNodeInfoG.isChecked()) {
                                        l.S(screenMirrorService, a0Var.f1129h ? "miui_unrestricted_selected" : "miui_unrestricted_already_on");
                                        Log.i("ColorOsVendorBattery", "verified MIUI unrestricted background activity");
                                        a0.j(accessibilityNodeInfoG);
                                        a0.j(accessibilityNodeInfoC2);
                                        a0.j(accessibilityNodeInfoK);
                                        return 3;
                                    }
                                } catch (Throwable th) {
                                    a0.j(accessibilityNodeInfoG);
                                    throw th;
                                }
                            }
                            a0.j(accessibilityNodeInfoG);
                            if (!a0Var.a(accessibilityNodeInfoC2)) {
                                a0.j(accessibilityNodeInfoC2);
                                a0.j(accessibilityNodeInfoK);
                                return 2;
                            }
                            a0Var.f1129h = true;
                            a0Var.f1125d = jCurrentTimeMillis;
                            Log.i("ColorOsVendorBattery", "requested MIUI unrestricted background activity");
                            a0.j(accessibilityNodeInfoC2);
                            a0.j(accessibilityNodeInfoK);
                            return 1;
                        } catch (Throwable th2) {
                            a0.j(accessibilityNodeInfoC2);
                            throw th2;
                        }
                    }
                    String[] strArr2 = l.f1245p;
                    for (int i5 = 0; i5 < 3; i5++) {
                        String strB1 = l.b0(screenMirrorService, "com.miui.securitycenter", strArr2[i5]);
                        if (!strB1.isEmpty()) {
                            str = strB1;
                            break;
                        }
                    }
                    AccessibilityNodeInfo accessibilityNodeInfoC3 = a0.c(0, accessibilityNodeInfoK, l.C(str, l.f1247r));
                    if (accessibilityNodeInfoC3 == null) {
                        if (a0Var.f1126e >= 5 || !a0Var.l(accessibilityNodeInfoK)) {
                            a0.j(accessibilityNodeInfoK);
                            return 2;
                        }
                        a0Var.f1126e++;
                        a0Var.f1125d = jCurrentTimeMillis;
                        Log.i("ColorOsVendorBattery", "scrolled MIUI App info for battery policy");
                        a0.j(accessibilityNodeInfoK);
                        return 1;
                    }
                    try {
                        if (!a0Var.a(accessibilityNodeInfoC3)) {
                            a0.j(accessibilityNodeInfoC3);
                            a0.j(accessibilityNodeInfoK);
                            return 2;
                        }
                        a0Var.f1125d = jCurrentTimeMillis;
                        Log.i("ColorOsVendorBattery", "opened package-scoped MIUI battery policy");
                        a0.j(accessibilityNodeInfoC3);
                        a0.j(accessibilityNodeInfoK);
                        return 1;
                    } catch (Throwable th3) {
                        a0.j(accessibilityNodeInfoC3);
                        throw th3;
                    }
                    try {
                        Log.w("ColorOsVendorBattery", "MIUI vendor battery automation failed", th);
                    } finally {
                        a0.j(accessibilityNodeInfoK);
                    }
                }
                a0.j(accessibilityNodeInfoK);
                return 2;
            } catch (Throwable th4) {
                Log.w("ColorOsVendorBattery", "MIUI vendor battery automation failed", th4);
            }
        } else {
            if (a0Var.f1127f) {
                if (accessibilityEvent == null) {
                    zN = false;
                } else {
                    try {
                        AccessibilityNodeInfo source = accessibilityEvent.getSource();
                        if (source == null) {
                            a0.j(source);
                            zN = false;
                        } else {
                            accessibilityNodeInfo = source;
                            int i6 = 0;
                            while (i6 < 40) {
                                try {
                                    AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
                                    if (parent == null) {
                                        break;
                                    }
                                    a0.j(accessibilityNodeInfo);
                                    i6++;
                                    accessibilityNodeInfo = parent;
                                } catch (Throwable th5) {
                                    th = th5;
                                    try {
                                        Log.d("ColorOsVendorBattery", "confirmation-event scan failed", th);
                                        a0.j(accessibilityNodeInfo);
                                        zN = false;
                                    } catch (Throwable th6) {
                                        a0.j(accessibilityNodeInfo);
                                        throw th6;
                                    }
                                }
                            }
                            zN = a0Var.n(accessibilityNodeInfo, jCurrentTimeMillis);
                            a0.j(accessibilityNodeInfo);
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        accessibilityNodeInfo = null;
                    }
                }
                if (zN) {
                    return 1;
                }
            }
            if (a0Var.f1127f) {
                List<AccessibilityWindowInfo> list = Collections.EMPTY_LIST;
                try {
                    List<AccessibilityWindowInfo> windows = screenMirrorService.getWindows();
                    if (windows != null) {
                        list = windows;
                    }
                } catch (Throwable unused) {
                }
                for (AccessibilityWindowInfo accessibilityWindowInfo : list) {
                    if (accessibilityWindowInfo != null && accessibilityWindowInfo.getType() != 4 && accessibilityWindowInfo.getType() != 2) {
                        try {
                            root = accessibilityWindowInfo.getRoot();
                            if (root != null) {
                                try {
                                    String strM = a0.m(root.getPackageName());
                                    if (("com.oplus.battery".equals(strM) || "android".equals(strM)) && a0Var.n(root, jCurrentTimeMillis)) {
                                        a0.j(root);
                                        z3 = true;
                                        break;
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    try {
                                        Log.d("ColorOsVendorBattery", "confirmation-window scan failed", th);
                                    } catch (Throwable th9) {
                                        a0.j(root);
                                        throw th9;
                                    }
                                }
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            root = null;
                        }
                        a0.j(root);
                    }
                }
                if (z3) {
                    return 1;
                }
            }
            AccessibilityNodeInfo accessibilityNodeInfoK2 = i0.k(screenMirrorService, "coloros-vendor-battery", accessibilityEvent, new b2.a(12));
            if (accessibilityNodeInfoK2 != null) {
                try {
                    String strM2 = a0.m(accessibilityNodeInfoK2.getPackageName());
                    if (!a0Var.f1127f || !a0Var.n(accessibilityNodeInfoK2, jCurrentTimeMillis)) {
                        if (jCurrentTimeMillis - a0Var.f1125d >= 500) {
                            if ("com.android.settings".equals(strM2)) {
                                i3 = a0Var.h(accessibilityNodeInfoK2, jCurrentTimeMillis);
                            } else if ("com.oplus.battery".equals(strM2)) {
                                i3 = a0Var.i(accessibilityNodeInfoK2, jCurrentTimeMillis);
                            }
                        }
                    }
                    a0.j(accessibilityNodeInfoK2);
                    return i3;
                } catch (Throwable th11) {
                    try {
                        Log.w("ColorOsVendorBattery", "ColorOS vendor battery automation failed", th11);
                    } finally {
                        a0.j(accessibilityNodeInfoK2);
                    }
                }
            }
        }
        return 2;
    }
}
