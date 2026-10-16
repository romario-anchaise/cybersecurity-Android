// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import f2.c0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.function.BooleanSupplier;
import lyr.stable.runtime.ScreenMirrorService;
import w1.e4;
import w1.l6;
import w1.t8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List f5917g = Arrays.asList("com.android.settings:id/left_button", "com.android.permissioncontroller:id/permission_allow_button", "com.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.android.permissioncontroller:id/permission_allow_all_button", "com.android.packageinstaller:id/permission_allow_always_button", "com.android.packageinstaller:id/permission_allow_button", "com.android.packageinstaller:id/permission_allow_foreground_only_button", "com.oplus.securitypermission:id/permission_allow_button", "android:id/button1", "com.huawei.systemmanager:id/btn_allow", "com.huawei.packageinstaller:id/permission_allow_button", "com.oplus.securitypermission:id/permission_allow_foreground_only_button", "com.samsung.android.packageinstaller:id/permission_allow_button", "com.samsung.android.permissioncontroller:id/permission_allow_button", "com.samsung.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.lbe.security.miui:id/permission_allow_foreground_only_button", "com.miui.securitycenter:id/accept", "miui:id/grant", "miui:id/button2", "miui:id/action_positive");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f5918h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScreenMirrorService f5919a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f5923e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.d f5920b = new d0.d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f5922d = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f5924f = Long.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5921c = new ArrayList(f5917g);

    public r(ScreenMirrorService screenMirrorService) {
        this.f5919a = screenMirrorService;
    }

    public static boolean h(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        return lowerCase.contains("uninstall") || lowerCase.contains("deletepackage") || lowerCase.contains("packagedelete") || lowerCase.contains("installedappdetails") || lowerCase.contains("appstorage") || lowerCase.contains("deviceadminadd");
    }

    public static boolean i(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        String lowerCase = charSequence.toString().trim().toLowerCase(Locale.ROOT);
        if (lowerCase.isEmpty()) {
            return false;
        }
        return lowerCase.equals("uninstall") || lowerCase.equals("uninstall app") || lowerCase.equals("force stop") || lowerCase.equals("clear data") || lowerCase.equals("clear storage") || lowerCase.equals("disable") || lowerCase.equals("deactivate") || lowerCase.equals("卸载") || lowerCase.equals("卸載") || lowerCase.equals("强制停止") || lowerCase.equals("強制停止") || lowerCase.equals("清除数据") || lowerCase.equals("清除資料") || lowerCase.equals("清除存储空间") || lowerCase.equals("清除儲存空間") || lowerCase.equals("停用") || lowerCase.equals("desinstalar") || lowerCase.equals("forzar detención") || lowerCase.equals("forzar cierre") || lowerCase.equals("borrar datos") || lowerCase.equals("borrar almacenamiento") || lowerCase.equals("inhabilitar") || lowerCase.equals("desactivar") || lowerCase.equals("forçar parada") || lowerCase.equals("forçar interrupção") || lowerCase.equals("limpar dados") || lowerCase.equals("limpar armazenamento") || lowerCase.equals("desativar") || lowerCase.equals("удалить") || lowerCase.equals("принудительно остановить") || lowerCase.equals("очистить данные") || lowerCase.equals("очистить хранилище") || lowerCase.equals("отключить") || lowerCase.equals("إلغاء التثبيت") || lowerCase.equals("فرض الإيقاف") || lowerCase.equals("إيقاف إجباري") || lowerCase.equals("محو البيانات") || lowerCase.equals("محو مساحة التخزين") || lowerCase.equals("تعطيل") || lowerCase.equals("アンインストール") || lowerCase.equals("強制停止") || lowerCase.equals("データを消去") || lowerCase.equals("ストレージを消去") || lowerCase.equals("無効にする") || lowerCase.equals("제거") || lowerCase.equals("강제 종료") || lowerCase.equals("데이터 삭제") || lowerCase.equals("저장공간 삭제") || lowerCase.equals("사용 중지") || lowerCase.equals("사용 안 함");
    }

    public static boolean j(String str, String str2) {
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.ROOT);
        String lowerCase2 = str2 != null ? str2.toLowerCase(Locale.ROOT) : "";
        if (h(lowerCase2)) {
            return false;
        }
        return (lowerCase.contains("permissioncontroller") || lowerCase.contains("securitypermission") || lowerCase.contains("packageinstaller")) && (lowerCase2.contains("grantpermission") || lowerCase2.contains("runtimepermission") || lowerCase2.contains("requestpermission") || lowerCase2.contains("permissiondialog"));
    }

    public static boolean m(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return true;
        }
        boolean zK = c0.k();
        boolean z2 = t8.f5164a.get();
        if (zK || z2) {
            return false;
        }
        CharSequence className = accessibilityNodeInfo.getClassName();
        if (h(className == null ? "" : className.toString())) {
            return true;
        }
        return q(accessibilityNodeInfo, 0, new int[]{0}, System.nanoTime() + 6000000);
    }

    public static void o() {
        l6.a("permission_polling");
        Log.d("NAzV5eoquV", "Polling stopped");
    }

    public static boolean q(AccessibilityNodeInfo accessibilityNodeInfo, int i3, int[] iArr, long j3) {
        AccessibilityNodeInfo child;
        if (accessibilityNodeInfo != null) {
            if (i3 <= 12) {
                int i4 = iArr[0];
                iArr[0] = i4 + 1;
                if (i4 < 220 && System.nanoTime() < j3) {
                    String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                    String lowerCase = viewIdResourceName == null ? "" : viewIdResourceName.toLowerCase(Locale.ROOT);
                    if (!lowerCase.contains("uninstall") && !lowerCase.contains("force_stop") && !lowerCase.contains("clear_data") && !lowerCase.contains("clear_storage") && !lowerCase.contains("disable_button") && !lowerCase.contains("deactivate") && !i(accessibilityNodeInfo.getText()) && !i(accessibilityNodeInfo.getContentDescription())) {
                        int iMin = Math.min(accessibilityNodeInfo.getChildCount(), 40);
                        for (int i5 = 0; i5 < iMin; i5++) {
                            try {
                                child = accessibilityNodeInfo.getChild(i5);
                                try {
                                    if (!q(child, i3 + 1, iArr, j3)) {
                                        if (child != null) {
                                            try {
                                                child.recycle();
                                            } catch (Throwable unused) {
                                            }
                                        }
                                    } else if (child != null) {
                                        try {
                                            child.recycle();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                } catch (Throwable unused3) {
                                    if (child != null) {
                                    }
                                }
                            } catch (Throwable unused4) {
                                child = null;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
        d0.d dVar = this.f5920b;
        try {
            Rect rect = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect);
            if (rect.isEmpty()) {
                return false;
            }
            float f3 = (rect.left + rect.right) / 2.0f;
            float f4 = (rect.top + rect.bottom) / 2.0f;
            dVar.e(16, accessibilityNodeInfo);
            AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
            for (int i3 = 0; parent != null && i3 < 5; i3++) {
                if (parent.isClickable() && parent.isEnabled()) {
                    dVar.e(16, parent);
                    break;
                }
                parent = parent.getParent();
            }
            Path path = new Path();
            path.moveTo(f3, f4);
            c(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 1L)).build(), null);
            return true;
        } catch (Exception e3) {
            Log.d("NAzV5eoquV", "Click failed: " + e3.getMessage());
            return false;
        }
    }

    public final boolean b() {
        x xVar = x.f5960m;
        boolean z2 = xVar != null && xVar.h();
        try {
            PowerManager powerManager = (PowerManager) this.f5919a.getSystemService(PowerManager.class);
            return (this.f5923e || t8.f5164a.get() || f5918h) && !z2 && (powerManager == null || powerManager.isInteractive());
        } catch (Throwable unused) {
            return (this.f5923e || t8.f5164a.get() || f5918h) && !z2;
        }
    }

    public final boolean c(final GestureDescription gestureDescription, final q qVar) {
        ScreenMirrorService screenMirrorService = this.f5919a;
        d0.d dVar = this.f5920b;
        if (screenMirrorService == null) {
            return dVar.a(screenMirrorService, gestureDescription, qVar);
        }
        BooleanSupplier booleanSupplier = new BooleanSupplier() { // from class: x1.o
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return this.f5908a.f5919a.W0(e4.f3870e, gestureDescription, qVar, null);
            }
        };
        dVar.getClass();
        return dVar.h(new d2.o(22, booleanSupplier));
    }

    public final void d(float f3, float f4) {
        try {
            Path path = new Path();
            path.moveTo(f3, f4);
            c(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 50L)).build(), new q(f3, f4));
            Log.d("NAzV5eoquV", "coordinate tap issued at (" + f3 + "," + f4 + ")");
        } catch (Exception e3) {
            Log.d("NAzV5eoquV", "coordinate tap failed: " + e3.getMessage());
        }
    }

    public final boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean zJ;
        if (accessibilityNodeInfo != null && !m(accessibilityNodeInfo)) {
            CharSequence packageName = accessibilityNodeInfo.getPackageName();
            if (packageName != null && packageName.toString().contains("securitypermission")) {
                try {
                    List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId("com.oplus.securitypermission:id/coui_security_alert_dialog_checkbox");
                    if (listFindAccessibilityNodeInfosByViewId != null && !listFindAccessibilityNodeInfosByViewId.isEmpty()) {
                        for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByViewId) {
                            try {
                                if (accessibilityNodeInfo2.isVisibleToUser() && accessibilityNodeInfo2.isEnabled() && !accessibilityNodeInfo2.isChecked()) {
                                    a(accessibilityNodeInfo2);
                                    Log.d("NAzV5eoquV", "Checked Always allow on AppStartConfirm");
                                }
                                accessibilityNodeInfo2.recycle();
                            } catch (Throwable th) {
                                try {
                                    accessibilityNodeInfo2.recycle();
                                } catch (Throwable unused) {
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            ArrayList arrayList = this.f5921c;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                String str = (String) obj;
                try {
                    List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId2 = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str);
                    if (listFindAccessibilityNodeInfosByViewId2 != null && !listFindAccessibilityNodeInfosByViewId2.isEmpty()) {
                        if ("android:id/button1".equals(str) || "com.android.settings:id/btn_positive".equals(str)) {
                            CharSequence packageName2 = accessibilityNodeInfo.getPackageName();
                            if (packageName2 == null) {
                                zJ = false;
                            } else {
                                CharSequence className = accessibilityNodeInfo.getClassName();
                                zJ = j(packageName2.toString(), className == null ? "" : className.toString());
                            }
                            if (!zJ) {
                                continue;
                            }
                        }
                        StringBuilder sbK = a0.a.k("scan: id ", str, " found ");
                        sbK.append(listFindAccessibilityNodeInfosByViewId2.size());
                        sbK.append(" node(s)");
                        Log.d("NAzV5eoquV", sbK.toString());
                        for (AccessibilityNodeInfo accessibilityNodeInfo3 : listFindAccessibilityNodeInfosByViewId2) {
                            try {
                                Log.d("NAzV5eoquV", "scan: node visible=" + accessibilityNodeInfo3.isVisibleToUser() + " enabled=" + accessibilityNodeInfo3.isEnabled() + " clickable=" + accessibilityNodeInfo3.isClickable());
                                if (y1.j.k(accessibilityNodeInfo3.getViewIdResourceName(), accessibilityNodeInfo3.getText(), accessibilityNodeInfo3.getContentDescription())) {
                                    Log.i("NAzV5eoquV", "skip shortcut control (permission-button path)");
                                } else if (accessibilityNodeInfo3.isVisibleToUser() && accessibilityNodeInfo3.isEnabled() && a(accessibilityNodeInfo3)) {
                                    Log.d("NAzV5eoquV", "Clicked: " + str);
                                    try {
                                        accessibilityNodeInfo3.recycle();
                                        return true;
                                    } catch (Throwable unused3) {
                                        return true;
                                    }
                                }
                                accessibilityNodeInfo3.recycle();
                            } catch (Throwable th2) {
                                try {
                                    accessibilityNodeInfo3.recycle();
                                } catch (Throwable unused4) {
                                }
                                throw th2;
                            }
                        }
                    }
                } catch (Exception unused5) {
                }
            }
        }
        return false;
    }

    public final boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
        try {
            Rect rect = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect);
            if (rect.isEmpty()) {
                return false;
            }
            float f3 = (rect.left + rect.right) / 2.0f;
            float f4 = (rect.top + rect.bottom) / 2.0f;
            Path path = new Path();
            path.moveTo(f3, f4);
            c(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 1L)).build(), null);
            return true;
        } catch (Exception e3) {
            Log.d("NAzV5eoquV", "gestureTapOnly failed: " + e3.getMessage());
            return false;
        }
    }

    public final boolean g() {
        long j3 = this.f5924f;
        long jUptimeMillis = SystemClock.uptimeMillis();
        return j3 != Long.MIN_VALUE && jUptimeMillis >= j3 && jUptimeMillis - j3 <= 2500;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x0227 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x01ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x0203 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x00cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x006a  */
    /* JADX WARN: Code duplicated, block: B:33:0x007b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0095  */
    /* JADX WARN: Code duplicated, block: B:36:0x0098  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00be  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e4  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void k() throws Throwable {
        AccessibilityNodeInfo rootInActiveWindow;
        List<AccessibilityWindowInfo> windows;
        StringBuilder sb;
        AccessibilityNodeInfo root;
        boolean z2;
        boolean z3;
        String str;
        String str2;
        boolean zE;
        String str3 = "active root scan failed: ";
        if (b()) {
            AccessibilityNodeInfo accessibilityNodeInfo = null;
            try {
                try {
                    rootInActiveWindow = this.f5919a.getRootInActiveWindow();
                    try {
                        if (rootInActiveWindow != null) {
                            Log.d("NAzV5eoquV", "scan: activeRoot pkg=" + ((Object) rootInActiveWindow.getPackageName()));
                            zE = e(rootInActiveWindow);
                            if (zE) {
                                try {
                                    str3 = zE;
                                    rootInActiveWindow.recycle();
                                    return;
                                } catch (Throwable unused) {
                                    return;
                                }
                            }
                        } else {
                            Log.d("NAzV5eoquV", "scan: activeRoot=null");
                            str3 = str3;
                        }
                        if (rootInActiveWindow != null) {
                            try {
                                rootInActiveWindow.recycle();
                            } catch (Throwable unused2) {
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        Log.d("NAzV5eoquV", str3 + e.getMessage());
                        if (rootInActiveWindow != null) {
                        }
                        windows = this.f5919a.getWindows();
                        if (windows == null) {
                            return;
                        }
                        sb = new StringBuilder("scan: windows=");
                        for (AccessibilityWindowInfo accessibilityWindowInfo : windows) {
                            sb.append('[');
                            sb.append(accessibilityWindowInfo.getId());
                            str = "-";
                            if (accessibilityWindowInfo.isActive()) {
                                str2 = "A";
                            } else {
                                str2 = "-";
                            }
                            sb.append(str2);
                            if (accessibilityWindowInfo.isFocused()) {
                                str = "F";
                            }
                            sb.append(str);
                            sb.append(']');
                        }
                        Log.d("NAzV5eoquV", sb.toString());
                        while (r1.hasNext()) {
                            if (accessibilityWindowInfo.getType() == 4) {
                                try {
                                    root = accessibilityWindowInfo.getRoot();
                                    z2 = false;
                                } catch (Exception unused3) {
                                    root = null;
                                    z2 = true;
                                }
                                if (root == null) {
                                    if (f5918h) {
                                    }
                                    boolean zG = g();
                                    if (z3) {
                                        continue;
                                    }
                                } else {
                                    try {
                                        Log.d("NAzV5eoquV", "scan: window " + accessibilityWindowInfo.getId() + " root pkg=" + ((Object) root.getPackageName()));
                                        if (e(root)) {
                                            try {
                                                root.recycle();
                                                return;
                                            } catch (Throwable unused4) {
                                                return;
                                            }
                                        }
                                        root.recycle();
                                    } catch (Throwable th) {
                                        try {
                                            root.recycle();
                                        } catch (Throwable unused5) {
                                        }
                                        throw th;
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    accessibilityNodeInfo = rootInActiveWindow;
                    if (accessibilityNodeInfo != null) {
                        try {
                            accessibilityNodeInfo.recycle();
                        } catch (Throwable unused6) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                rootInActiveWindow = null;
            } catch (Throwable th3) {
                th = th3;
                if (accessibilityNodeInfo != null) {
                    accessibilityNodeInfo.recycle();
                }
                throw th;
            }
            try {
                windows = this.f5919a.getWindows();
                if (windows == null) {
                    return;
                }
                sb = new StringBuilder("scan: windows=");
                while (r4.hasNext()) {
                    sb.append('[');
                    sb.append(accessibilityWindowInfo.getId());
                    str = "-";
                    if (accessibilityWindowInfo.isActive()) {
                        str2 = "A";
                    } else {
                        str2 = "-";
                    }
                    sb.append(str2);
                    if (accessibilityWindowInfo.isFocused()) {
                        str = "F";
                    }
                    sb.append(str);
                    sb.append(']');
                }
                Log.d("NAzV5eoquV", sb.toString());
                for (AccessibilityWindowInfo accessibilityWindowInfo2 : windows) {
                    if (accessibilityWindowInfo2.getType() == 4) {
                        root = accessibilityWindowInfo2.getRoot();
                        z2 = false;
                        if (root == null) {
                            z3 = !f5918h || t8.f5164a.get();
                            boolean zG2 = g();
                            if (z3 && zG2 && accessibilityWindowInfo2.isActive() && accessibilityWindowInfo2.isFocused() && accessibilityWindowInfo2.getType() == 1) {
                                Rect rect = new Rect();
                                accessibilityWindowInfo2.getBoundsInScreen(rect);
                                Rect rect2 = (Rect) this.f5922d.get(Integer.valueOf(accessibilityWindowInfo2.getId()));
                                if (rect2 == null || !rect2.equals(rect)) {
                                    this.f5922d.put(Integer.valueOf(accessibilityWindowInfo2.getId()), new Rect(rect));
                                    Log.d("NAzV5eoquV", "scan: dialog window " + accessibilityWindowInfo2.getId() + " bounds=" + rect + " settling, skip tap");
                                } else {
                                    Log.d("NAzV5eoquV", "scan: shielded dialog window " + accessibilityWindowInfo2.getId() + " bounds=" + rect + " rootFailed=" + z2 + " -> coordinate tap");
                                    final int id = accessibilityWindowInfo2.getId();
                                    if (!rect.isEmpty()) {
                                        final float f3 = (rect.left + rect.right) / 2.0f;
                                        boolean zEqualsIgnoreCase = "samsung".equalsIgnoreCase(Build.MANUFACTURER);
                                        float f4 = rect.bottom;
                                        float f5 = f4 - (zEqualsIgnoreCase ? 439.0f : 342.0f);
                                        final float f6 = f4 - (zEqualsIgnoreCase ? 296.0f : 239.0f);
                                        d(f3, f5);
                                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: x1.p
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                AccessibilityNodeInfo root2;
                                                r rVar = this.f5911c;
                                                try {
                                                    List<AccessibilityWindowInfo> windows2 = rVar.f5919a.getWindows();
                                                    if (windows2 == null) {
                                                        return;
                                                    }
                                                    for (AccessibilityWindowInfo accessibilityWindowInfo3 : windows2) {
                                                        if (accessibilityWindowInfo3.getId() == id && accessibilityWindowInfo3.isActive() && accessibilityWindowInfo3.isFocused()) {
                                                            try {
                                                                root2 = accessibilityWindowInfo3.getRoot();
                                                            } catch (Exception unused7) {
                                                                root2 = null;
                                                            }
                                                            if (root2 == null) {
                                                                rVar.d(f3, f6);
                                                                return;
                                                            }
                                                            try {
                                                                root2.recycle();
                                                            } catch (Throwable unused8) {
                                                            }
                                                        }
                                                    }
                                                } catch (Exception unused9) {
                                                }
                                            }
                                        }, 150L);
                                        this.f5922d.remove(Integer.valueOf(accessibilityWindowInfo2.getId()));
                                        return;
                                    }
                                }
                            }
                        } else {
                            Log.d("NAzV5eoquV", "scan: window " + accessibilityWindowInfo2.getId() + " root pkg=" + ((Object) root.getPackageName()));
                            if (e(root)) {
                                root.recycle();
                                return;
                            }
                            root.recycle();
                        }
                    }
                }
            } catch (Exception e5) {
                Log.d("NAzV5eoquV", "windows fetch failed: " + e5.getMessage());
            }
        }
    }

    public final boolean l(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain;
        boolean zJ;
        if (accessibilityNodeInfo != null && b()) {
            AccessibilityNodeInfo accessibilityNodeInfo2 = null;
            try {
                accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                int i3 = 0;
                while (i3 < 12) {
                    try {
                        AccessibilityNodeInfo parent = accessibilityNodeInfoObtain.getParent();
                        if (parent == null) {
                            break;
                        }
                        accessibilityNodeInfoObtain.recycle();
                        i3++;
                        accessibilityNodeInfoObtain = parent;
                    } catch (Throwable unused) {
                        if (accessibilityNodeInfoObtain != null) {
                            try {
                                accessibilityNodeInfoObtain.recycle();
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                accessibilityNodeInfo2 = accessibilityNodeInfoObtain;
            } catch (Throwable unused3) {
                accessibilityNodeInfoObtain = null;
            }
            try {
                if (accessibilityNodeInfo2 != null) {
                    try {
                        boolean zM = m(accessibilityNodeInfo2);
                        CharSequence packageName = accessibilityNodeInfo2.getPackageName();
                        if (packageName == null) {
                            zJ = false;
                        } else {
                            CharSequence className = accessibilityNodeInfo2.getClassName();
                            zJ = j(packageName.toString(), className == null ? "" : className.toString());
                        }
                        boolean z2 = true;
                        boolean z3 = zJ || g();
                        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                        if (y1.j.k(viewIdResourceName, accessibilityNodeInfo.getText(), accessibilityNodeInfo.getContentDescription())) {
                            Log.i("NAzV5eoquV", "skip shortcut control (event-source path)");
                        } else {
                            if (viewIdResourceName == null || !this.f5921c.contains(viewIdResourceName)) {
                                z2 = false;
                            }
                            boolean zIsVisibleToUser = accessibilityNodeInfo.isVisibleToUser();
                            boolean zIsEnabled = accessibilityNodeInfo.isEnabled();
                            if (z2 && zIsVisibleToUser && zIsEnabled && z3 && !zM) {
                                return a(accessibilityNodeInfo);
                            }
                            if (!zM && z3) {
                                return e(accessibilityNodeInfo2);
                            }
                        }
                    } catch (Exception e3) {
                        Log.d("NAzV5eoquV", "event source scan failed: " + e3.getMessage());
                    }
                } else if (accessibilityNodeInfo2 != null) {
                }
            } finally {
                try {
                    accessibilityNodeInfo2.recycle();
                } catch (Throwable unused4) {
                }
            }
        }
        return false;
    }

    public final void n() {
        if (b()) {
            l6.e("permission_polling", 1, new d2.o(23, this));
        } else {
            Log.d("NAzV5eoquV", "Polling rejected: no permission-flow token");
            o();
        }
    }

    public final boolean p(int i3, Rect rect, boolean z2) {
        if (!rect.isEmpty() && rect.height() >= 80) {
            int iMax = Math.max(80, Math.min(i3, rect.height() / 3));
            try {
                float fExactCenterX = rect.exactCenterX();
                float fExactCenterY = rect.exactCenterY();
                float f3 = iMax / 2.0f;
                float f4 = z2 ? fExactCenterY + f3 : fExactCenterY - f3;
                float f5 = z2 ? fExactCenterY - f3 : fExactCenterY + f3;
                float fMax = Math.max(rect.top + 8.0f, Math.min(rect.bottom - 8.0f, f4));
                float fMax2 = Math.max(rect.top + 8.0f, Math.min(rect.bottom - 8.0f, f5));
                if (Math.abs(fMax2 - fMax) >= 60.0f) {
                    Path path = new Path();
                    path.moveTo(fExactCenterX, fMax);
                    path.lineTo(fExactCenterX, fMax2);
                    return c(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, Math.max(400L, 480L))).build(), null);
                }
            } catch (Exception e3) {
                Log.d("NAzV5eoquV", "swipeVertical failed: " + e3.getMessage());
            }
        }
        return false;
    }
}
