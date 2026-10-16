// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScreenMirrorService f1122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x1.r f1123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0.d f1124c = new d0.d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1130i;

    public a0(ScreenMirrorService screenMirrorService, x1.r rVar) {
        this.f1122a = screenMirrorService;
        this.f1123b = rVar;
    }

    public static StringBuilder b(int i3, AccessibilityNodeInfo accessibilityNodeInfo, StringBuilder sb) throws Throwable {
        AccessibilityNodeInfo child;
        if (accessibilityNodeInfo != null && i3 <= 40 && sb.length() < 8192) {
            String strM = m(accessibilityNodeInfo.getText());
            if (!strM.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(strM);
            }
            String strM2 = m(accessibilityNodeInfo.getContentDescription());
            if (!strM2.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(strM2);
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                try {
                    child = accessibilityNodeInfo.getChild(i4);
                    try {
                        b(i3 + 1, child, sb);
                        j(child);
                    } catch (Throwable th) {
                        th = th;
                        j(child);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    child = null;
                }
            }
        }
        return sb;
    }

    public static AccessibilityNodeInfo c(int i3, AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo != null && i3 <= 40) {
            if (accessibilityNodeInfo.isVisibleToUser() && (i0.j(m(accessibilityNodeInfo.getText()), arrayList) || i0.j(m(accessibilityNodeInfo.getContentDescription()), arrayList))) {
                return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                try {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                    try {
                        AccessibilityNodeInfo accessibilityNodeInfoC = c(i3 + 1, child, arrayList);
                        if (accessibilityNodeInfoC != null) {
                            j(child);
                            return accessibilityNodeInfoC;
                        }
                        j(child);
                    } catch (Throwable th) {
                        th = th;
                        accessibilityNodeInfo2 = child;
                        j(accessibilityNodeInfo2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo d(int i3, AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo != null && i3 <= 8) {
            if (accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isCheckable()) {
                return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                try {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                    try {
                        AccessibilityNodeInfo accessibilityNodeInfoD = d(i3 + 1, child);
                        if (accessibilityNodeInfoD != null) {
                            j(child);
                            return accessibilityNodeInfoD;
                        }
                        j(child);
                    } catch (Throwable th) {
                        th = th;
                        accessibilityNodeInfo2 = child;
                        j(accessibilityNodeInfo2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo e(int i3, AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo != null && i3 <= 40) {
            if (accessibilityNodeInfo.isEnabled()) {
                String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                if ("android:id/button1".equals(viewIdResourceName) || "com.oplus.battery:id/button1".equals(viewIdResourceName)) {
                    return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                }
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                try {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                    try {
                        AccessibilityNodeInfo accessibilityNodeInfoE = e(i3 + 1, child);
                        if (accessibilityNodeInfoE != null) {
                            j(child);
                            return accessibilityNodeInfoE;
                        }
                        j(child);
                    } catch (Throwable th) {
                        th = th;
                        accessibilityNodeInfo2 = child;
                        j(accessibilityNodeInfo2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo f(int i3, AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo != null && i3 <= 40) {
            if (accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isScrollable()) {
                return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                try {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                    try {
                        AccessibilityNodeInfo accessibilityNodeInfoF = f(i3 + 1, child);
                        if (accessibilityNodeInfoF != null) {
                            j(child);
                            return accessibilityNodeInfoF;
                        }
                        j(child);
                    } catch (Throwable th) {
                        th = th;
                        accessibilityNodeInfo2 = child;
                        j(accessibilityNodeInfo2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo g(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
        int i3 = 0;
        while (i3 < 6 && accessibilityNodeInfoObtain != null) {
            AccessibilityNodeInfo accessibilityNodeInfoD = d(0, accessibilityNodeInfoObtain);
            if (accessibilityNodeInfoD != null) {
                j(accessibilityNodeInfoObtain);
                return accessibilityNodeInfoD;
            }
            AccessibilityNodeInfo parent = accessibilityNodeInfoObtain.getParent();
            j(accessibilityNodeInfoObtain);
            i3++;
            accessibilityNodeInfoObtain = parent;
        }
        j(accessibilityNodeInfoObtain);
        return null;
    }

    public static void j(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        try {
            accessibilityNodeInfo.recycle();
        } catch (Throwable unused) {
        }
    }

    public static String m(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString().trim();
    }

    public final boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
        x1.r rVar;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 < 7 && accessibilityNodeInfoObtain != null) {
                if (accessibilityNodeInfoObtain.isClickable() && accessibilityNodeInfoObtain.isEnabled() && accessibilityNodeInfoObtain.isVisibleToUser()) {
                    break;
                }
                AccessibilityNodeInfo parent = accessibilityNodeInfoObtain.getParent();
                j(accessibilityNodeInfoObtain);
                i3++;
                accessibilityNodeInfoObtain = parent;
            } else {
                j(accessibilityNodeInfoObtain);
                accessibilityNodeInfoObtain = null;
                break;
            }
        }
        if (accessibilityNodeInfoObtain != null) {
            accessibilityNodeInfo = accessibilityNodeInfoObtain;
        }
        try {
            if (accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && (this.f1124c.e(16, accessibilityNodeInfo) || ((rVar = this.f1123b) != null && rVar.f(accessibilityNodeInfo)))) {
                z2 = true;
            }
            return z2;
        } finally {
            j(accessibilityNodeInfoObtain);
        }
    }

    public final int h(AccessibilityNodeInfo accessibilityNodeInfo, long j3) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfoC = c(0, accessibilityNodeInfo, l.B(this.f1122a, "com.android.settings", l.n, "advanced_battery_preference_title", "power_management"));
        if (accessibilityNodeInfoC != null) {
            try {
                if (!a(accessibilityNodeInfoC)) {
                    return 2;
                }
                this.f1125d = j3;
                Log.i("ColorOsVendorBattery", "opened package-scoped Battery usage");
                return 1;
            } finally {
                j(accessibilityNodeInfoC);
            }
        }
        if (this.f1126e >= 5 || !l(accessibilityNodeInfo)) {
            return 2;
        }
        this.f1126e++;
        this.f1125d = j3;
        Log.i("ColorOsVendorBattery", "scrolled App info for Battery usage");
        return 1;
    }

    public final int i(AccessibilityNodeInfo accessibilityNodeInfo, long j3) throws Throwable {
        ScreenMirrorService screenMirrorService = this.f1122a;
        AccessibilityNodeInfo accessibilityNodeInfoC = c(0, accessibilityNodeInfo, l.B(screenMirrorService, "com.oplus.battery", l.f1244o, "background_act_title", "power_control_allow_15", "mark_pref_title_allow_background_run"));
        if (accessibilityNodeInfoC == null) {
            if (!l(accessibilityNodeInfo)) {
                return 2;
            }
            this.f1125d = j3;
            return 1;
        }
        try {
            AccessibilityNodeInfo accessibilityNodeInfoG = g(accessibilityNodeInfoC);
            if (accessibilityNodeInfoG != null) {
                try {
                    if (accessibilityNodeInfoG.isCheckable() && accessibilityNodeInfoG.isChecked()) {
                        l.S(screenMirrorService, this.f1128g ? "coloros_unrestricted_confirmed" : "coloros_unrestricted_already_on");
                        Log.i("ColorOsVendorBattery", "verified ColorOS unrestricted background activity");
                        j(accessibilityNodeInfoG);
                        j(accessibilityNodeInfoC);
                        return 3;
                    }
                } catch (Throwable th) {
                    j(accessibilityNodeInfoG);
                    throw th;
                }
            }
            j(accessibilityNodeInfoG);
            if (!a(accessibilityNodeInfoC)) {
                j(accessibilityNodeInfoC);
                return 2;
            }
            this.f1127f = true;
            this.f1125d = j3;
            Log.i("ColorOsVendorBattery", "requested ColorOS unrestricted background activity");
            j(accessibilityNodeInfoC);
            return 1;
        } catch (Throwable th2) {
            j(accessibilityNodeInfoC);
            throw th2;
        }
    }

    public final void k() {
        this.f1125d = 0L;
        this.f1126e = 0;
        this.f1127f = false;
        this.f1128g = false;
        this.f1129h = false;
        this.f1130i = 0;
    }

    public final boolean l(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfoF = f(0, accessibilityNodeInfo);
        if (accessibilityNodeInfoF == null) {
            return false;
        }
        try {
            return this.f1124c.e(4096, accessibilityNodeInfoF);
        } finally {
            j(accessibilityNodeInfoF);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0086, code lost:
    
        if (r10.f(r2) == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean n(android.view.accessibility.AccessibilityNodeInfo r10, long r11) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "ignored unmatched ColorOS confirmation ownLabels="
            r1 = 0
            android.view.accessibility.AccessibilityNodeInfo r2 = e(r1, r10)
            if (r2 != 0) goto La
            return r1
        La:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            b(r1, r10, r3)
            java.lang.String r10 = r3.toString()
            lyr.stable.runtime.ScreenMirrorService r3 = r9.f1122a
            java.util.ArrayList r4 = y.m.o(r3)
            java.lang.String[] r5 = f2.l.f1244o
            java.lang.String r6 = "power_control_allow_15"
            java.lang.String r7 = "mark_pref_title_allow_background_run"
            java.lang.String r8 = "background_act_title"
            java.lang.String[] r6 = new java.lang.String[]{r8, r6, r7}
            java.lang.String r7 = "com.oplus.battery"
            java.util.ArrayList r3 = f2.l.B(r3, r7, r5, r6)
            boolean r5 = f2.i0.r(r10, r4, r3)     // Catch: java.lang.Throwable -> L60
            java.lang.String r6 = "ColorOsVendorBattery"
            if (r5 != 0) goto L66
            int r11 = r10.hashCode()     // Catch: java.lang.Throwable -> L60
            int r12 = r9.f1130i     // Catch: java.lang.Throwable -> L60
            if (r11 == r12) goto L62
            r9.f1130i = r11     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L60
            r9.append(r4)     // Catch: java.lang.Throwable -> L60
            java.lang.String r11 = " allowLabels="
            r9.append(r11)     // Catch: java.lang.Throwable -> L60
            r9.append(r3)     // Catch: java.lang.Throwable -> L60
            java.lang.String r11 = " pageText="
            r9.append(r11)     // Catch: java.lang.Throwable -> L60
            r9.append(r10)     // Catch: java.lang.Throwable -> L60
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L60
            android.util.Log.d(r6, r9)     // Catch: java.lang.Throwable -> L60
            goto L62
        L60:
            r9 = move-exception
            goto L9a
        L62:
            j(r2)
            return r1
        L66:
            boolean r10 = r2.isEnabled()     // Catch: java.lang.Throwable -> L60
            if (r10 != 0) goto L6d
            goto L96
        L6d:
            d0.d r10 = r9.f1124c     // Catch: java.lang.Throwable -> L60
            r0 = 16
            boolean r10 = r10.e(r0, r2)     // Catch: java.lang.Throwable -> L60
            if (r10 == 0) goto L78
            goto L88
        L78:
            boolean r10 = r2.isVisibleToUser()     // Catch: java.lang.Throwable -> L60
            if (r10 == 0) goto L96
            x1.r r10 = r9.f1123b     // Catch: java.lang.Throwable -> L60
            if (r10 == 0) goto L96
            boolean r10 = r10.f(r2)     // Catch: java.lang.Throwable -> L60
            if (r10 == 0) goto L96
        L88:
            r10 = 1
            r9.f1128g = r10     // Catch: java.lang.Throwable -> L60
            r9.f1125d = r11     // Catch: java.lang.Throwable -> L60
            java.lang.String r9 = "accepted ColorOS unrestricted-background confirmation"
            android.util.Log.i(r6, r9)     // Catch: java.lang.Throwable -> L60
            j(r2)
            return r10
        L96:
            j(r2)
            return r1
        L9a:
            j(r2)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.a0.n(android.view.accessibility.AccessibilityNodeInfo, long):boolean");
    }
}
