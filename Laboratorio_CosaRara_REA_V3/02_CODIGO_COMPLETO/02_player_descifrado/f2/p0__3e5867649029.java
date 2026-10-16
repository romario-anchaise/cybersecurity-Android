// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.accessibilityservice.AccessibilityService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import lyr.stable.runtime.MainActivity;
import lyr.stable.runtime.NotificationListener;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.engine.EngineService;
import lyr.stable.runtime.engine.KeepAliveDreamService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0.d f1282a = new d0.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f1283b = {"android.widget.Switch", "androidx.appcompat.widget.SwitchCompat", "com.google.android.material.materialswitch.MaterialSwitch"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f1284c = {"updates", "Allow notifications", "Show notifications", "Allow notification", "Show notification", "允许通知", "显示通知", "允許通知", "顯示通知", "Mostrar notificaciones", "Permitir notificaciones", "السماح بالإشعارات", "إظهار الإشعارات", "通知を許可", "通知を表示", "알림 허용", "알림 표시", "Permitir notificações", "Mostrar notificações", "Разрешить уведомления", "Показывать уведомления", "Bildirimlere izin ver", "Bildirimleri göster", "Benachrichtigungen zulassen", "Benachrichtigungen anzeigen", "Autoriser les notifications", "Afficher les notifications", "Cho phép thông báo", "Izinkan notifikasi"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f1285d = {"com.android.settings:id/left_button", "android:id/button1", "android:id/button1", "com.android.packageinstaller:id/permission_allow_always_button", "com.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.android.permissioncontroller:id/permission_allow_button", "com.android.packageinstaller:id/permission_allow_foreground_only_button", "com.android.packageinstaller:id/permission_allow_button", "com.samsung.android.packageinstaller:id/permission_allow_button", "com.samsung.android.permissioncontroller:id/permission_allow_button", "com.samsung.android.permissioncontroller:id/permission_allow_foreground_only_button", "com.huawei.systemmanager:id/btn_allow", "com.huawei.packageinstaller:id/permission_allow_button", "com.lbe.security.miui:id/permission_allow_foreground_only_button", "com.miui.securitycenter:id/accept", "miui:id/grant", "miui:id/button2", "miui:id/action_positive"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f1286e = {"Allow", "Autoriser", "Erlauben", "Permitir", "允许", "허용", "السماح", "izin ver", "izinkan", "Once", "本次", "kali", "Chấp nhận", "Permitir solo mientras se usa la aplicación", "Permitir apenas enquanto estiver usando o aplicativo"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f1287f = {"No restrictions", "Sin restricciones", "Нет ограничений", "Nenhuma restrição", "Kısıtlama yok", "无限制", "لا توجد قيود"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f1288g = {"Disable", "停用", "Desactivar", "Desativar", "Отключить", "Devre dışı bırak", "تعطيل"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f1289h = {"Disable app", "停用应用", "Desactivar aplicación", "Desativar app", "Отключить приложение", "Uygulamayı devre dışı bırak", "تعطيل التطبيق"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Handler f1290i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f1291j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d2.r f1292k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f1293l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile boolean f1294m;
    public static volatile long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile AccessibilityService f1295o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile x1.r f1296p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile AccessibilityService f1297q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile y.m f1298r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile long f1299s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile AccessibilityService f1300t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile y f1301u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static volatile long f1302v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static volatile long f1303w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static volatile int f1304x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static volatile int f1305y;

    static {
        Handler handler = k0.f1221a;
        f1290i = new Handler(Looper.getMainLooper());
        f1292k = new d2.r(5);
    }

    public static boolean A(AccessibilityService accessibilityService, x1.r rVar, ArrayList arrayList) {
        String strA;
        if (M(accessibilityService)) {
            c0.e(7);
            f1282a.c(accessibilityService);
            Log.i("SampleGrantClicker", "dream already selected");
            return true;
        }
        try {
            CharSequence charSequenceLoadLabel = accessibilityService.getPackageManager().getServiceInfo(new ComponentName(accessibilityService, (Class<?>) KeepAliveDreamService.class), 0).loadLabel(accessibilityService.getPackageManager());
            strA = (charSequenceLoadLabel == null || charSequenceLoadLabel.length() <= 0) ? a(accessibilityService) : charSequenceLoadLabel.toString();
        } catch (Throwable unused) {
        }
        if (strA.isEmpty() || !e(rVar, arrayList, new String[]{strA})) {
            return false;
        }
        Log.i("SampleGrantClicker", "clicked dream row");
        if (M(accessibilityService)) {
            c0.e(7);
            f1290i.postDelayed(new c2.d(accessibilityService, 5), 100L);
        }
        return true;
    }

    public static void B(AccessibilityService accessibilityService, x1.r rVar, ArrayList arrayList, AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean zIsExternalStorageManager;
        boolean z2 = false;
        try {
            zIsExternalStorageManager = Environment.isExternalStorageManager();
        } catch (Throwable unused) {
            zIsExternalStorageManager = false;
        }
        if (zIsExternalStorageManager) {
            c0.e(3);
            return;
        }
        String strS = S(accessibilityNodeInfo);
        if (strS.isEmpty() && !arrayList.isEmpty() && arrayList.get(0) != null) {
            strS = S((AccessibilityNodeInfo) arrayList.get(0));
        }
        if (strS != null && strS.toLowerCase(Locale.ROOT).contains("settings")) {
            z2 = true;
        }
        if (!z2 || c0.f1147k) {
            return;
        }
        c0.f1147k = true;
        f1290i.postDelayed(new n0(accessibilityService, rVar, 1), 800L);
    }

    /* JADX WARN: Code duplicated, block: B:74:0x00f6  */
    public static void C(AccessibilityService accessibilityService, x1.r rVar, ArrayList arrayList, long j3) {
        boolean z2;
        boolean z3;
        AccessibilityNodeInfo accessibilityNodeInfoV;
        boolean z4;
        boolean z5;
        boolean z6 = c0.f1137a;
        synchronized (c0.class) {
            if (c0.f1143g && !c0.f1144h) {
                c0.f1144h = true;
                c0.f1158w = j3;
                c0(accessibilityService, rVar, 1000L);
                return;
            }
            if (c0.g(8)) {
                if (j3 >= c0.f(8) + c0.c(8)) {
                    if (H(arrayList, new o0(0))) {
                        String strX = X(arrayList);
                        String strA = a(accessibilityService);
                        String packageName = accessibilityService.getPackageName();
                        if (strX.isEmpty()) {
                            return;
                        }
                        String[] strArrSplit = strX.split("\\r?\\n");
                        int length = strArrSplit.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                String str = strArrSplit[i3];
                                if (str != null && str.trim().equalsIgnoreCase("updates")) {
                                    z2 = true;
                                    break;
                                }
                                i3++;
                            } else {
                                z2 = false;
                                break;
                            }
                        }
                        String lowerCase = strX.toLowerCase(Locale.ROOT);
                        String[] strArr = f1284c;
                        int length2 = strArr.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length2) {
                                z3 = false;
                                break;
                            }
                            String str2 = strArr[i4];
                            if (!str2.equals("updates") && lowerCase.contains(str2.toLowerCase(Locale.ROOT))) {
                                z3 = true;
                                break;
                            }
                            i4++;
                        }
                        if (!((z2 && o(strX, strA, "", packageName)) || ((z2 && z3) || (z3 && c0.f1143g))) || (accessibilityNodeInfoV = v(arrayList, f1284c)) == null) {
                            return;
                        }
                        try {
                            if (!J(accessibilityNodeInfoV)) {
                                l(8, 0L, accessibilityService);
                                Log.i("SampleGrantClicker", "updates channel already silenced");
                                a0(accessibilityNodeInfoV);
                                return;
                            }
                            AccessibilityNodeInfo accessibilityNodeInfoG = g(accessibilityNodeInfoV);
                            if (accessibilityNodeInfoG != null) {
                                try {
                                    if (f1282a.e(16, accessibilityNodeInfoG)) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                } catch (Throwable unused) {
                                    if (accessibilityNodeInfoG != accessibilityNodeInfoV) {
                                        a0(accessibilityNodeInfoG);
                                    }
                                    z4 = false;
                                }
                            } else {
                                z5 = false;
                            }
                            if (accessibilityNodeInfoG != null && accessibilityNodeInfoG != accessibilityNodeInfoV) {
                                a0(accessibilityNodeInfoG);
                            }
                            z4 = z5;
                            if (!z4) {
                                a0(accessibilityNodeInfoV);
                                return;
                            }
                            n = j3;
                            c0.i(8);
                            l(8, 250L, accessibilityService);
                            Log.i("SampleGrantClicker", "clicked own updates channel switch off");
                            a0(accessibilityNodeInfoV);
                            return;
                        } catch (Throwable th) {
                            a0(accessibilityNodeInfoV);
                            throw th;
                        }
                    }
                    return;
                }
            }
            c0(accessibilityService, rVar, c0.g(8) ? Math.max(0L, (c0.f(8) + c0.c(8)) - j3) : 0L);
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0197  */
    /* JADX WARN: Code duplicated, block: B:136:0x0191 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void D(AccessibilityService accessibilityService, x1.r rVar, ArrayList arrayList, long j3) throws Throwable {
        boolean zV;
        AccessibilityNodeInfo accessibilityNodeInfoObtain;
        Object obj;
        int i3 = 0;
        if (accessibilityService == null) {
            zV = false;
        } else {
            try {
                zV = V(Settings.Secure.getString(accessibilityService.getContentResolver(), "enabled_notification_listeners"), accessibilityService.getPackageName(), NotificationListener.class.getName());
            } catch (Throwable unused) {
                zV = false;
            }
        }
        if (zV) {
            l(2, 0L, accessibilityService);
            Log.i("SampleGrantClicker", "notification listener already enabled");
            return;
        }
        if (H(arrayList, new o0(1))) {
            String strA = a(accessibilityService);
            String string = "";
            if (accessibilityService != null) {
                try {
                    CharSequence charSequenceLoadLabel = accessibilityService.getPackageManager().getServiceInfo(new ComponentName(accessibilityService, (Class<?>) NotificationListener.class), 0).loadLabel(accessibilityService.getPackageManager());
                    if (charSequenceLoadLabel != null) {
                        string = charSequenceLoadLabel.toString();
                    }
                } catch (Throwable unused2) {
                }
            }
            String packageName = accessibilityService.getPackageName();
            if (o(X(arrayList), strA, string, packageName)) {
                String[] strArr = {string, strA, packageName};
                ArrayList arrayList2 = new ArrayList();
                for (int i4 = 0; i4 < 3; i4++) {
                    String str = strArr[i4];
                    if (str != null && !str.trim().isEmpty()) {
                        int size = arrayList2.size();
                        int i5 = 0;
                        do {
                            if (i5 >= size) {
                                arrayList2.add(str.trim());
                                break;
                            } else {
                                obj = arrayList2.get(i5);
                                i5++;
                            }
                        } while (!((String) obj).equalsIgnoreCase(str.trim()));
                    }
                }
                String[] strArr2 = (String[]) arrayList2.toArray(new String[0]);
                AccessibilityNodeInfo accessibilityNodeInfoV = v(arrayList, strArr2);
                if (accessibilityNodeInfoV != null) {
                    try {
                        if (J(accessibilityNodeInfoV)) {
                            c0(accessibilityService, rVar, 400L);
                            a0(accessibilityNodeInfoV);
                            return;
                        } else {
                            if (f(rVar, accessibilityNodeInfoV)) {
                                n = j3;
                                c0.i(2);
                                c0(accessibilityService, rVar, 500L);
                                Log.i("SampleGrantClicker", "clicked own notification-listener switch");
                                a0(accessibilityNodeInfoV);
                                return;
                            }
                            a0(accessibilityNodeInfoV);
                        }
                    } catch (Throwable th) {
                        a0(accessibilityNodeInfoV);
                        throw th;
                    }
                }
                if (strArr2 != null) {
                    int size2 = arrayList.size();
                    int i6 = 0;
                    loop2: while (true) {
                        if (i6 >= size2) {
                            i3 = 0;
                            break;
                        }
                        Object obj2 = arrayList.get(i6);
                        i6++;
                        AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj2;
                        if (accessibilityNodeInfo != null) {
                            int length = strArr2.length;
                            int i7 = i3;
                            while (i7 < length) {
                                String str2 = strArr2[i7];
                                if (str2 != null && !str2.trim().isEmpty()) {
                                    try {
                                        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str2);
                                        if (listFindAccessibilityNodeInfosByText != null) {
                                            Iterator<AccessibilityNodeInfo> it = listFindAccessibilityNodeInfosByText.iterator();
                                            int i8 = i3;
                                            while (it.hasNext()) {
                                                AccessibilityNodeInfo next = it.next();
                                                if (i8 == 0) {
                                                    AccessibilityNodeInfo accessibilityNodeInfo2 = null;
                                                    try {
                                                        if (j0(T(next), str2)) {
                                                            AccessibilityNodeInfo accessibilityNodeInfoObtain2 = next == null ? null : AccessibilityNodeInfo.obtain(next);
                                                            int i9 = 0;
                                                            while (true) {
                                                                if (accessibilityNodeInfoObtain2 != null && i9 <= 6) {
                                                                    try {
                                                                        if (L(accessibilityNodeInfoObtain2)) {
                                                                            a0(accessibilityNodeInfoObtain2);
                                                                            accessibilityNodeInfoObtain = null;
                                                                        } else if (accessibilityNodeInfoObtain2.isClickable() && accessibilityNodeInfoObtain2.isEnabled() && accessibilityNodeInfoObtain2.isVisibleToUser()) {
                                                                            accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfoObtain2);
                                                                            a0(accessibilityNodeInfoObtain2);
                                                                        } else {
                                                                            AccessibilityNodeInfo parent = accessibilityNodeInfoObtain2.getParent();
                                                                            a0(accessibilityNodeInfoObtain2);
                                                                            i9++;
                                                                            accessibilityNodeInfoObtain2 = parent;
                                                                        }
                                                                    } catch (Throwable unused3) {
                                                                        a0(accessibilityNodeInfoObtain2);
                                                                    }
                                                                    if (accessibilityNodeInfoObtain != null) {
                                                                        try {
                                                                            if (f(rVar, accessibilityNodeInfoObtain)) {
                                                                                i8 = 1;
                                                                            }
                                                                        } catch (Throwable th2) {
                                                                            th = th2;
                                                                            accessibilityNodeInfo2 = accessibilityNodeInfoObtain;
                                                                            a0(accessibilityNodeInfo2);
                                                                            a0(next);
                                                                            throw th;
                                                                        }
                                                                    }
                                                                    a0(accessibilityNodeInfoObtain);
                                                                }
                                                                a0(accessibilityNodeInfoObtain2);
                                                                accessibilityNodeInfoObtain = null;
                                                                if (accessibilityNodeInfoObtain != null) {
                                                                    if (f(rVar, accessibilityNodeInfoObtain)) {
                                                                        i8 = 1;
                                                                    }
                                                                }
                                                                a0(accessibilityNodeInfoObtain);
                                                            }
                                                        }
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                    }
                                                }
                                                a0(next);
                                            }
                                            if (i8 != 0) {
                                                i3 = 1;
                                                break loop2;
                                            }
                                        } else {
                                            continue;
                                        }
                                    } catch (Throwable unused4) {
                                        continue;
                                    }
                                }
                                i7++;
                                i3 = 0;
                            }
                        }
                    }
                }
                if (i3 != 0) {
                    n = j3;
                    c0(accessibilityService, rVar, 500L);
                    Log.i("SampleGrantClicker", "opened own notification-listener detail");
                } else if (e(rVar, arrayList, f1286e)) {
                    n = j3;
                    c0(accessibilityService, rVar, 400L);
                    Log.i("SampleGrantClicker", "confirmed own notification-listener access");
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:156:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:159:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:164:0x0302  */
    /* JADX WARN: Code duplicated, block: B:167:0x0310  */
    /* JADX WARN: Code duplicated, block: B:169:0x0319  */
    /* JADX WARN: Code duplicated, block: B:170:0x031b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:171:0x031d  */
    /* JADX WARN: Code duplicated, block: B:172:0x0320  */
    /* JADX WARN: Code duplicated, block: B:175:0x0328  */
    /* JADX WARN: Code duplicated, block: B:176:0x032d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:177:0x032f  */
    /* JADX WARN: Code duplicated, block: B:178:0x0333 A[Catch: all -> 0x0380, TRY_ENTER, TryCatch #1 {all -> 0x0380, blocks: (B:173:0x0322, B:178:0x0333, B:182:0x0354, B:181:0x0346), top: B:528:0x0322 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x0343  */
    /* JADX WARN: Code duplicated, block: B:181:0x0346 A[Catch: all -> 0x0380, TryCatch #1 {all -> 0x0380, blocks: (B:173:0x0322, B:178:0x0333, B:182:0x0354, B:181:0x0346), top: B:528:0x0322 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x035d  */
    /* JADX WARN: Code duplicated, block: B:187:0x0370  */
    /* JADX WARN: Code duplicated, block: B:188:0x0373  */
    /* JADX WARN: Code duplicated, block: B:241:0x049b A[Catch: all -> 0x0498, TRY_LEAVE, TryCatch #5 {all -> 0x0498, blocks: (B:234:0x048b, B:236:0x0491, B:241:0x049b, B:246:0x04b1, B:268:0x04e5, B:249:0x04b9, B:254:0x04c7, B:266:0x04e0, B:273:0x0507, B:274:0x050a, B:275:0x050b, B:252:0x04c1, B:258:0x04ce, B:262:0x04d7), top: B:535:0x048b, outer: #8, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:246:0x04b1 A[Catch: all -> 0x0498, TRY_ENTER, TryCatch #5 {all -> 0x0498, blocks: (B:234:0x048b, B:236:0x0491, B:241:0x049b, B:246:0x04b1, B:268:0x04e5, B:249:0x04b9, B:254:0x04c7, B:266:0x04e0, B:273:0x0507, B:274:0x050a, B:275:0x050b, B:252:0x04c1, B:258:0x04ce, B:262:0x04d7), top: B:535:0x048b, outer: #8, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:248:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:249:0x04b9 A[Catch: all -> 0x0498, TRY_LEAVE, TryCatch #5 {all -> 0x0498, blocks: (B:234:0x048b, B:236:0x0491, B:241:0x049b, B:246:0x04b1, B:268:0x04e5, B:249:0x04b9, B:254:0x04c7, B:266:0x04e0, B:273:0x0507, B:274:0x050a, B:275:0x050b, B:252:0x04c1, B:258:0x04ce, B:262:0x04d7), top: B:535:0x048b, outer: #8, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:254:0x04c7 A[Catch: all -> 0x0498, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x0498, blocks: (B:234:0x048b, B:236:0x0491, B:241:0x049b, B:246:0x04b1, B:268:0x04e5, B:249:0x04b9, B:254:0x04c7, B:266:0x04e0, B:273:0x0507, B:274:0x050a, B:275:0x050b, B:252:0x04c1, B:258:0x04ce, B:262:0x04d7), top: B:535:0x048b, outer: #8, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:258:0x04ce A[Catch: all -> 0x04cc, TRY_ENTER, TryCatch #7 {all -> 0x04cc, blocks: (B:252:0x04c1, B:258:0x04ce, B:262:0x04d7), top: B:538:0x04c1, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:260:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:261:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:262:0x04d7 A[Catch: all -> 0x04cc, TRY_LEAVE, TryCatch #7 {all -> 0x04cc, blocks: (B:252:0x04c1, B:258:0x04ce, B:262:0x04d7), top: B:538:0x04c1, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:265:0x04df  */
    /* JADX WARN: Code duplicated, block: B:268:0x04e5 A[Catch: all -> 0x0498, TRY_LEAVE, TryCatch #5 {all -> 0x0498, blocks: (B:234:0x048b, B:236:0x0491, B:241:0x049b, B:246:0x04b1, B:268:0x04e5, B:249:0x04b9, B:254:0x04c7, B:266:0x04e0, B:273:0x0507, B:274:0x050a, B:275:0x050b, B:252:0x04c1, B:258:0x04ce, B:262:0x04d7), top: B:535:0x048b, outer: #8, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:272:0x04fb A[LOOP:10: B:271:0x04f9->B:272:0x04fb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:279:0x051a A[LOOP:11: B:278:0x0518->B:279:0x051a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:314:0x05de  */
    /* JADX WARN: Code duplicated, block: B:318:0x05eb A[Catch: all -> 0x05ff, TRY_LEAVE, TryCatch #10 {all -> 0x05ff, blocks: (B:316:0x05e5, B:318:0x05eb), top: B:543:0x05e5 }] */
    /* JADX WARN: Code duplicated, block: B:322:0x0601  */
    /* JADX WARN: Code duplicated, block: B:325:0x0609  */
    /* JADX WARN: Code duplicated, block: B:327:0x0610  */
    /* JADX WARN: Code duplicated, block: B:329:0x061a  */
    /* JADX WARN: Code duplicated, block: B:331:0x0622  */
    /* JADX WARN: Code duplicated, block: B:334:0x062f  */
    /* JADX WARN: Code duplicated, block: B:336:0x0641  */
    /* JADX WARN: Code duplicated, block: B:366:0x06b9  */
    /* JADX WARN: Code duplicated, block: B:369:0x06cd  */
    /* JADX WARN: Code duplicated, block: B:370:0x06cf  */
    /* JADX WARN: Code duplicated, block: B:373:0x06d5  */
    /* JADX WARN: Code duplicated, block: B:384:0x06f9  */
    /* JADX WARN: Code duplicated, block: B:386:0x06fe  */
    /* JADX WARN: Code duplicated, block: B:388:0x0705  */
    /* JADX WARN: Code duplicated, block: B:392:0x0714  */
    /* JADX WARN: Code duplicated, block: B:398:0x072f  */
    /* JADX WARN: Code duplicated, block: B:403:0x0742 A[Catch: all -> 0x0756, TryCatch #3 {all -> 0x0756, blocks: (B:401:0x073e, B:403:0x0742, B:405:0x074a, B:409:0x0758, B:411:0x075c, B:417:0x076d, B:419:0x0771, B:420:0x0779, B:422:0x077d, B:424:0x0797), top: B:532:0x073e }] */
    /* JADX WARN: Code duplicated, block: B:405:0x074a A[Catch: all -> 0x0756, TRY_LEAVE, TryCatch #3 {all -> 0x0756, blocks: (B:401:0x073e, B:403:0x0742, B:405:0x074a, B:409:0x0758, B:411:0x075c, B:417:0x076d, B:419:0x0771, B:420:0x0779, B:422:0x077d, B:424:0x0797), top: B:532:0x073e }] */
    /* JADX WARN: Code duplicated, block: B:409:0x0758 A[Catch: all -> 0x0756, TRY_ENTER, TryCatch #3 {all -> 0x0756, blocks: (B:401:0x073e, B:403:0x0742, B:405:0x074a, B:409:0x0758, B:411:0x075c, B:417:0x076d, B:419:0x0771, B:420:0x0779, B:422:0x077d, B:424:0x0797), top: B:532:0x073e }] */
    /* JADX WARN: Code duplicated, block: B:411:0x075c A[Catch: all -> 0x0756, TryCatch #3 {all -> 0x0756, blocks: (B:401:0x073e, B:403:0x0742, B:405:0x074a, B:409:0x0758, B:411:0x075c, B:417:0x076d, B:419:0x0771, B:420:0x0779, B:422:0x077d, B:424:0x0797), top: B:532:0x073e }] */
    /* JADX WARN: Code duplicated, block: B:413:0x0767 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:416:0x076c  */
    /* JADX WARN: Code duplicated, block: B:419:0x0771 A[Catch: all -> 0x0756, TryCatch #3 {all -> 0x0756, blocks: (B:401:0x073e, B:403:0x0742, B:405:0x074a, B:409:0x0758, B:411:0x075c, B:417:0x076d, B:419:0x0771, B:420:0x0779, B:422:0x077d, B:424:0x0797), top: B:532:0x073e }] */
    /* JADX WARN: Code duplicated, block: B:420:0x0779 A[Catch: all -> 0x0756, TryCatch #3 {all -> 0x0756, blocks: (B:401:0x073e, B:403:0x0742, B:405:0x074a, B:409:0x0758, B:411:0x075c, B:417:0x076d, B:419:0x0771, B:420:0x0779, B:422:0x077d, B:424:0x0797), top: B:532:0x073e }] */
    /* JADX WARN: Code duplicated, block: B:422:0x077d A[Catch: all -> 0x0756, TryCatch #3 {all -> 0x0756, blocks: (B:401:0x073e, B:403:0x0742, B:405:0x074a, B:409:0x0758, B:411:0x075c, B:417:0x076d, B:419:0x0771, B:420:0x0779, B:422:0x077d, B:424:0x0797), top: B:532:0x073e }] */
    /* JADX WARN: Code duplicated, block: B:424:0x0797 A[Catch: all -> 0x0756, TRY_LEAVE, TryCatch #3 {all -> 0x0756, blocks: (B:401:0x073e, B:403:0x0742, B:405:0x074a, B:409:0x0758, B:411:0x075c, B:417:0x076d, B:419:0x0771, B:420:0x0779, B:422:0x077d, B:424:0x0797), top: B:532:0x073e }] */
    /* JADX WARN: Code duplicated, block: B:429:0x07aa  */
    /* JADX WARN: Code duplicated, block: B:431:0x07b3  */
    /* JADX WARN: Code duplicated, block: B:436:0x07d7  */
    /* JADX WARN: Code duplicated, block: B:439:0x07de  */
    /* JADX WARN: Code duplicated, block: B:443:0x07ed  */
    /* JADX WARN: Code duplicated, block: B:449:0x07fc  */
    /* JADX WARN: Code duplicated, block: B:451:0x07ff  */
    /* JADX WARN: Code duplicated, block: B:453:0x0802  */
    /* JADX WARN: Code duplicated, block: B:455:0x0805  */
    /* JADX WARN: Code duplicated, block: B:456:0x0808  */
    /* JADX WARN: Code duplicated, block: B:458:0x0815  */
    /* JADX WARN: Code duplicated, block: B:460:0x081d  */
    /* JADX WARN: Code duplicated, block: B:530:0x07e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:532:0x073e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:533:0x0707 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:538:0x04c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:543:0x05e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x04af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0134 A[EDGE_INSN: B:61:0x0134->B:447:0x07f6 BREAK  A[LOOP:2: B:23:0x007d->B:27:0x008d]] */
    /* JADX WARN: Code duplicated, block: B:628:0x06c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x06a9 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:? A[RETURN, SYNTHETIC] */
    public static void E(AccessibilityService accessibilityService, x1.r rVar, ArrayList arrayList, long j3) throws Throwable {
        String str;
        String str2;
        int i3;
        AccessibilityNodeInfo accessibilityNodeInfo;
        Bundle bundle;
        boolean zE;
        boolean z2;
        boolean zB;
        int i4;
        int i5;
        AccessibilityNodeInfo accessibilityNodeInfoK;
        boolean zE2;
        int i6;
        AccessibilityNodeInfo accessibilityNodeInfoL;
        int size;
        int i7;
        AccessibilityNodeInfo accessibilityNodeInfoI;
        boolean z3;
        AccessibilityNodeInfo accessibilityNodeInfoK2;
        boolean zE3;
        AccessibilityNodeInfo accessibilityNodeInfoI2;
        String str3;
        int i8;
        String strTrim;
        String lowerCase;
        int i9;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i10;
        int size2;
        int i11;
        AccessibilityNodeInfo accessibilityNodeInfoF;
        boolean z4;
        int size3;
        int i12;
        boolean z5;
        boolean z6;
        AccessibilityNodeInfo accessibilityNodeInfoK3;
        int i13;
        int iHeight;
        int iMax;
        boolean zP;
        String str4;
        ArrayList arrayList4;
        int i14;
        int i15;
        boolean zB2;
        int iA;
        boolean zM;
        long j4 = c0.f1152q;
        if (j4 == 0 || f1303w != j4) {
            String str5 = Build.MANUFACTURER;
            if (l.k() == 3) {
                y yVar = f1301u;
                if (yVar == null || f1300t != accessibilityService) {
                    yVar = new y(accessibilityService, rVar);
                    f1301u = yVar;
                    f1300t = accessibilityService;
                    f1302v = j4;
                } else if (f1302v != j4) {
                    yVar.f1363d = 0L;
                    yVar.f1364e = 0L;
                    yVar.f1365f = false;
                    yVar.f1366g = false;
                    yVar.f1367h = false;
                    yVar.f1368i = 0;
                    yVar.f1369j = false;
                    yVar.f1370k = 0;
                    yVar.f1371l = 0;
                    yVar.f1372m = "";
                    yVar.n = 0;
                    yVar.f1373o = false;
                    yVar.f1374p = false;
                    yVar.f1375q = "";
                    yVar.f1376r = false;
                    yVar.f1377s = false;
                    f1302v = j4;
                }
                ArrayList arrayListO = y.m.o(accessibilityService);
                AccessibilityService accessibilityService2 = yVar.f1360a;
                d0.d dVar = yVar.f1362c;
                if (arrayList.isEmpty()) {
                    str2 = "SampleGrantClicker";
                } else {
                    int size4 = arrayList.size();
                    int i16 = 0;
                    loop2: while (true) {
                        if (i16 >= size4) {
                            if (!yVar.f1377s) {
                                AccessibilityNodeInfo accessibilityNodeInfoJ = y.j(arrayList, true);
                                if (accessibilityNodeInfoJ == null) {
                                    str2 = "SampleGrantClicker";
                                    AccessibilityNodeInfo accessibilityNodeInfoJ2 = y.j(arrayList, false);
                                    if (accessibilityNodeInfoJ2 != null) {
                                        if (j3 - yVar.f1363d >= 500) {
                                            ArrayList arrayListC = l.C(l.b0(accessibilityService2, "com.oplus.battery", "startup_manager"), l.f1242l);
                                            ArrayList arrayListC2 = l.C(l.b0(accessibilityService2, "com.oplus.battery", "associate_startup_manager"), l.f1243m);
                                            ArrayList arrayListC3 = l.C(l.b0(accessibilityService2, "com.android.settings", "apps_dashboard_title"), l.f1241k);
                                            ArrayList arrayList5 = new ArrayList();
                                            y.e(0, accessibilityNodeInfoJ2, arrayList5);
                                            AccessibilityNodeInfo accessibilityNodeInfoI3 = y.i(accessibilityNodeInfoJ2, arrayListC, arrayListC2, 0);
                                            if (accessibilityNodeInfoI3 != null) {
                                                try {
                                                    if (yVar.b(accessibilityNodeInfoI3)) {
                                                        yVar.f1363d = j3;
                                                        yVar.f1370k = 0;
                                                        Log.i("ColorOsAutostart", "clicked Settings Auto launch hop");
                                                        y.p(accessibilityNodeInfoI3);
                                                    } else {
                                                        y.p(accessibilityNodeInfoI3);
                                                        if (yVar.f1369j) {
                                                            i3 = 1;
                                                        } else {
                                                            accessibilityNodeInfoL = y.l(0, accessibilityNodeInfoJ2);
                                                            if (accessibilityNodeInfoL == null) {
                                                                try {
                                                                    if (yVar.b(accessibilityNodeInfoL)) {
                                                                        yVar.f1365f = false;
                                                                        yVar.f1366g = false;
                                                                        yVar.f1367h = false;
                                                                        yVar.f1370k = 0;
                                                                        yVar.f1363d = j3;
                                                                        Log.i("ColorOsAutostart", "closed stale Settings search");
                                                                        y.p(accessibilityNodeInfoL);
                                                                    } else {
                                                                        y.p(accessibilityNodeInfoL);
                                                                        size = arrayList5.size();
                                                                        i7 = 0;
                                                                        while (true) {
                                                                            if (i7 < size) {
                                                                                Object obj = arrayList5.get(i7);
                                                                                int i17 = i7 + 1;
                                                                                str3 = (String) obj;
                                                                                if (str3 == null) {
                                                                                    i8 = size;
                                                                                } else {
                                                                                    i8 = size;
                                                                                    strTrim = str3.trim();
                                                                                    if (strTrim.isEmpty()) {
                                                                                        lowerCase = strTrim.toLowerCase(Locale.ROOT);
                                                                                        if (!lowerCase.equals("autofill") || lowerCase.equals("assistive ball") || lowerCase.equals("talkback") || lowerCase.equals("select to speak") || lowerCase.equals("installed services") || lowerCase.equals("downloaded apps") || lowerCase.equals("downloaded applications") || lowerCase.equals("aplicaciones descargadas") || lowerCase.equals("servicios instalados") || lowerCase.equals("aplicaciones instaladas") || strTrim.equals("已安装的服务") || strTrim.equals("已下载的应用") || strTrim.equals("已安装的应用") || strTrim.equals("辅助球")) {
                                                                                            if (accessibilityService2.performGlobalAction(1)) {
                                                                                                yVar.f1370k = 0;
                                                                                                yVar.f1363d = j3;
                                                                                                Log.i("ColorOsAutostart", "backed out of Settings accessibility leaf");
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    i7 = i17;
                                                                                    size = i8;
                                                                                    arrayList5 = arrayList5;
                                                                                }
                                                                                i7 = i17;
                                                                                size = i8;
                                                                                arrayList5 = arrayList5;
                                                                            }
                                                                            accessibilityNodeInfoI = y.i(accessibilityNodeInfoJ2, arrayListC2, null, 0);
                                                                            if (accessibilityNodeInfoI != null) {
                                                                                z3 = true;
                                                                            } else {
                                                                                z3 = false;
                                                                            }
                                                                            y.p(accessibilityNodeInfoI);
                                                                            if (!z3 || (accessibilityNodeInfoI2 = y.i(accessibilityNodeInfoJ2, arrayListC3, null, 0)) == null) {
                                                                                if (yVar.f1368i < 3) {
                                                                                    accessibilityNodeInfoK2 = y.k(0, accessibilityNodeInfoJ2);
                                                                                    if (accessibilityNodeInfoK2 == null) {
                                                                                        zE3 = false;
                                                                                    } else {
                                                                                        try {
                                                                                            zE3 = yVar.f1362c.e(4096, accessibilityNodeInfoK2);
                                                                                            y.p(accessibilityNodeInfoK2);
                                                                                        } catch (Throwable th) {
                                                                                            y.p(accessibilityNodeInfoK2);
                                                                                            throw th;
                                                                                        }
                                                                                    }
                                                                                    if (zE3) {
                                                                                        yVar.f1368i++;
                                                                                        yVar.f1363d = j3;
                                                                                        Log.i("ColorOsAutostart", "scrolled Settings for Apps hop");
                                                                                    }
                                                                                }
                                                                                i3 = 1;
                                                                                yVar.f1369j = true;
                                                                            } else {
                                                                                try {
                                                                                    if (yVar.b(accessibilityNodeInfoI2)) {
                                                                                        yVar.f1363d = j3;
                                                                                        yVar.f1370k = 0;
                                                                                        Log.i("ColorOsAutostart", "clicked Settings Apps hop");
                                                                                        y.p(accessibilityNodeInfoI2);
                                                                                    } else {
                                                                                        y.p(accessibilityNodeInfoI2);
                                                                                        if (yVar.f1368i < 3) {
                                                                                            accessibilityNodeInfoK2 = y.k(0, accessibilityNodeInfoJ2);
                                                                                            if (accessibilityNodeInfoK2 == null) {
                                                                                                zE3 = false;
                                                                                            } else {
                                                                                                zE3 = yVar.f1362c.e(4096, accessibilityNodeInfoK2);
                                                                                                y.p(accessibilityNodeInfoK2);
                                                                                            }
                                                                                            if (zE3) {
                                                                                                yVar.f1368i++;
                                                                                                yVar.f1363d = j3;
                                                                                                Log.i("ColorOsAutostart", "scrolled Settings for Apps hop");
                                                                                            }
                                                                                        }
                                                                                        i3 = 1;
                                                                                        yVar.f1369j = true;
                                                                                    }
                                                                                } catch (Throwable th2) {
                                                                                    y.p(accessibilityNodeInfoI2);
                                                                                    throw th2;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } catch (Throwable th3) {
                                                                    y.p(accessibilityNodeInfoL);
                                                                    throw th3;
                                                                }
                                                            } else {
                                                                size = arrayList5.size();
                                                                i7 = 0;
                                                                while (true) {
                                                                    if (i7 < size) {
                                                                        Object obj2 = arrayList5.get(i7);
                                                                        int i18 = i7 + 1;
                                                                        str3 = (String) obj2;
                                                                        if (str3 == null) {
                                                                            i8 = size;
                                                                        } else {
                                                                            i8 = size;
                                                                            strTrim = str3.trim();
                                                                            if (strTrim.isEmpty()) {
                                                                                lowerCase = strTrim.toLowerCase(Locale.ROOT);
                                                                                if (!lowerCase.equals("autofill")) {
                                                                                }
                                                                                if (accessibilityService2.performGlobalAction(1)) {
                                                                                    yVar.f1370k = 0;
                                                                                    yVar.f1363d = j3;
                                                                                    Log.i("ColorOsAutostart", "backed out of Settings accessibility leaf");
                                                                                }
                                                                            }
                                                                            i7 = i18;
                                                                            size = i8;
                                                                            arrayList5 = arrayList5;
                                                                        }
                                                                        i7 = i18;
                                                                        size = i8;
                                                                        arrayList5 = arrayList5;
                                                                    }
                                                                    accessibilityNodeInfoI = y.i(accessibilityNodeInfoJ2, arrayListC2, null, 0);
                                                                    if (accessibilityNodeInfoI != null) {
                                                                        z3 = true;
                                                                    } else {
                                                                        z3 = false;
                                                                    }
                                                                    y.p(accessibilityNodeInfoI);
                                                                    if (z3) {
                                                                        if (yVar.f1368i < 3) {
                                                                            accessibilityNodeInfoK2 = y.k(0, accessibilityNodeInfoJ2);
                                                                            if (accessibilityNodeInfoK2 == null) {
                                                                                zE3 = false;
                                                                            } else {
                                                                                zE3 = yVar.f1362c.e(4096, accessibilityNodeInfoK2);
                                                                                y.p(accessibilityNodeInfoK2);
                                                                            }
                                                                            if (zE3) {
                                                                                yVar.f1368i++;
                                                                                yVar.f1363d = j3;
                                                                                Log.i("ColorOsAutostart", "scrolled Settings for Apps hop");
                                                                            }
                                                                        }
                                                                        i3 = 1;
                                                                        yVar.f1369j = true;
                                                                    } else {
                                                                        if (yVar.f1368i < 3) {
                                                                            accessibilityNodeInfoK2 = y.k(0, accessibilityNodeInfoJ2);
                                                                            if (accessibilityNodeInfoK2 == null) {
                                                                                zE3 = false;
                                                                            } else {
                                                                                zE3 = yVar.f1362c.e(4096, accessibilityNodeInfoK2);
                                                                                y.p(accessibilityNodeInfoK2);
                                                                            }
                                                                            if (zE3) {
                                                                                yVar.f1368i++;
                                                                                yVar.f1363d = j3;
                                                                                Log.i("ColorOsAutostart", "scrolled Settings for Apps hop");
                                                                            }
                                                                        }
                                                                        i3 = 1;
                                                                        yVar.f1369j = true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        AccessibilityNodeInfo[] accessibilityNodeInfoArr = new AccessibilityNodeInfo[i3];
                                                        y.t(accessibilityNodeInfoJ2, 0, accessibilityNodeInfoArr, new int[]{0});
                                                        accessibilityNodeInfo = accessibilityNodeInfoArr[0];
                                                        if (accessibilityNodeInfo != null) {
                                                            try {
                                                                if (!yVar.f1365f) {
                                                                    zB = yVar.b(accessibilityNodeInfo);
                                                                    yVar.f1365f = zB;
                                                                    if (zB) {
                                                                        yVar.f1363d = j3;
                                                                        Log.i("ColorOsAutostart", "opened Settings search");
                                                                    } else if (yVar.f1366g) {
                                                                        if (!yVar.f1367h) {
                                                                            bundle = new Bundle();
                                                                            bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", "自启动");
                                                                            dVar.getClass();
                                                                            if (dVar.h(new d2.c(accessibilityNodeInfo, bundle, 14))) {
                                                                                yVar.f1367h = true;
                                                                                yVar.f1363d = j3;
                                                                                Log.i("ColorOsAutostart", "typed Settings Auto launch query");
                                                                            }
                                                                        }
                                                                        y.p(accessibilityNodeInfo);
                                                                        i4 = yVar.f1370k + 1;
                                                                        yVar.f1370k = i4;
                                                                        if (i4 >= 3) {
                                                                            i5 = 0;
                                                                            accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                            if (accessibilityNodeInfoK == null) {
                                                                                zE2 = false;
                                                                            } else {
                                                                                zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                                y.p(accessibilityNodeInfoK);
                                                                            }
                                                                            if (zE2) {
                                                                                yVar.f1363d = j3;
                                                                            }
                                                                        } else {
                                                                            i5 = 0;
                                                                            accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                            if (accessibilityNodeInfoK == null) {
                                                                                zE2 = false;
                                                                            } else {
                                                                                zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                                y.p(accessibilityNodeInfoK);
                                                                            }
                                                                            if (zE2) {
                                                                                yVar.f1363d = j3;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        zE = dVar.e(1, accessibilityNodeInfo);
                                                                        boolean zB3 = yVar.b(accessibilityNodeInfo);
                                                                        if (!zE || zB3) {
                                                                            z2 = true;
                                                                        } else {
                                                                            z2 = false;
                                                                        }
                                                                        yVar.f1366g = z2;
                                                                        if (z2) {
                                                                            yVar.f1363d = j3;
                                                                            Log.i("ColorOsAutostart", "focused Settings search editor");
                                                                        } else {
                                                                            if (!yVar.f1367h) {
                                                                                bundle = new Bundle();
                                                                                bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", "自启动");
                                                                                dVar.getClass();
                                                                                if (dVar.h(new d2.c(accessibilityNodeInfo, bundle, 14))) {
                                                                                    yVar.f1367h = true;
                                                                                    yVar.f1363d = j3;
                                                                                    Log.i("ColorOsAutostart", "typed Settings Auto launch query");
                                                                                }
                                                                            }
                                                                            y.p(accessibilityNodeInfo);
                                                                            i4 = yVar.f1370k + 1;
                                                                            yVar.f1370k = i4;
                                                                            if (i4 >= 3 || (i6 = yVar.f1371l) >= 2) {
                                                                                i5 = 0;
                                                                            } else {
                                                                                i5 = 0;
                                                                                yVar.f1370k = 0;
                                                                                yVar.f1371l = i6 + 1;
                                                                                if (accessibilityService2.performGlobalAction(1)) {
                                                                                    yVar.f1365f = false;
                                                                                    yVar.f1366g = false;
                                                                                    yVar.f1367h = false;
                                                                                    yVar.f1368i = 0;
                                                                                    yVar.f1369j = false;
                                                                                    yVar.f1363d = j3;
                                                                                    Log.i("ColorOsAutostart", "backed out of stale Settings leaf");
                                                                                }
                                                                            }
                                                                            accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                            if (accessibilityNodeInfoK == null) {
                                                                                zE2 = false;
                                                                            } else {
                                                                                try {
                                                                                    zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                                    y.p(accessibilityNodeInfoK);
                                                                                } catch (Throwable th4) {
                                                                                    y.p(accessibilityNodeInfoK);
                                                                                    throw th4;
                                                                                }
                                                                            }
                                                                            if (zE2) {
                                                                                yVar.f1363d = j3;
                                                                            }
                                                                        }
                                                                    }
                                                                } else if (yVar.f1366g) {
                                                                    zE = dVar.e(1, accessibilityNodeInfo);
                                                                    boolean zB4 = yVar.b(accessibilityNodeInfo);
                                                                    if (zE) {
                                                                        z2 = true;
                                                                    } else {
                                                                        z2 = true;
                                                                    }
                                                                    yVar.f1366g = z2;
                                                                    if (z2) {
                                                                        yVar.f1363d = j3;
                                                                        Log.i("ColorOsAutostart", "focused Settings search editor");
                                                                    } else {
                                                                        if (!yVar.f1367h) {
                                                                            bundle = new Bundle();
                                                                            bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", "自启动");
                                                                            dVar.getClass();
                                                                            if (dVar.h(new d2.c(accessibilityNodeInfo, bundle, 14))) {
                                                                                yVar.f1367h = true;
                                                                                yVar.f1363d = j3;
                                                                                Log.i("ColorOsAutostart", "typed Settings Auto launch query");
                                                                            }
                                                                        }
                                                                        y.p(accessibilityNodeInfo);
                                                                        i4 = yVar.f1370k + 1;
                                                                        yVar.f1370k = i4;
                                                                        if (i4 >= 3) {
                                                                            i5 = 0;
                                                                            accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                            if (accessibilityNodeInfoK == null) {
                                                                                zE2 = false;
                                                                            } else {
                                                                                zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                                y.p(accessibilityNodeInfoK);
                                                                            }
                                                                            if (zE2) {
                                                                                yVar.f1363d = j3;
                                                                            }
                                                                        } else {
                                                                            i5 = 0;
                                                                            accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                            if (accessibilityNodeInfoK == null) {
                                                                                zE2 = false;
                                                                            } else {
                                                                                zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                                y.p(accessibilityNodeInfoK);
                                                                            }
                                                                            if (zE2) {
                                                                                yVar.f1363d = j3;
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (!yVar.f1367h) {
                                                                        bundle = new Bundle();
                                                                        bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", "自启动");
                                                                        dVar.getClass();
                                                                        if (dVar.h(new d2.c(accessibilityNodeInfo, bundle, 14))) {
                                                                            yVar.f1367h = true;
                                                                            yVar.f1363d = j3;
                                                                            Log.i("ColorOsAutostart", "typed Settings Auto launch query");
                                                                        }
                                                                    }
                                                                    y.p(accessibilityNodeInfo);
                                                                    i4 = yVar.f1370k + 1;
                                                                    yVar.f1370k = i4;
                                                                    if (i4 >= 3) {
                                                                        i5 = 0;
                                                                        accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                        if (accessibilityNodeInfoK == null) {
                                                                            zE2 = false;
                                                                        } else {
                                                                            zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                            y.p(accessibilityNodeInfoK);
                                                                        }
                                                                        if (zE2) {
                                                                            yVar.f1363d = j3;
                                                                        }
                                                                    } else {
                                                                        i5 = 0;
                                                                        accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                        if (accessibilityNodeInfoK == null) {
                                                                            zE2 = false;
                                                                        } else {
                                                                            zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                            y.p(accessibilityNodeInfoK);
                                                                        }
                                                                        if (zE2) {
                                                                            yVar.f1363d = j3;
                                                                        }
                                                                    }
                                                                }
                                                                y.p(accessibilityNodeInfo);
                                                            } catch (Throwable th5) {
                                                                y.p(accessibilityNodeInfo);
                                                                throw th5;
                                                            }
                                                        } else {
                                                            i4 = yVar.f1370k + 1;
                                                            yVar.f1370k = i4;
                                                            if (i4 >= 3) {
                                                                i5 = 0;
                                                                accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                if (accessibilityNodeInfoK == null) {
                                                                    zE2 = false;
                                                                } else {
                                                                    zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                    y.p(accessibilityNodeInfoK);
                                                                }
                                                                if (zE2) {
                                                                    yVar.f1363d = j3;
                                                                }
                                                            } else {
                                                                i5 = 0;
                                                                accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                if (accessibilityNodeInfoK == null) {
                                                                    zE2 = false;
                                                                } else {
                                                                    zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                    y.p(accessibilityNodeInfoK);
                                                                }
                                                                if (zE2) {
                                                                    yVar.f1363d = j3;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th6) {
                                                    y.p(accessibilityNodeInfoI3);
                                                    throw th6;
                                                }
                                            } else {
                                                if (yVar.f1369j) {
                                                    accessibilityNodeInfoL = y.l(0, accessibilityNodeInfoJ2);
                                                    if (accessibilityNodeInfoL == null) {
                                                        size = arrayList5.size();
                                                        i7 = 0;
                                                        while (true) {
                                                            if (i7 < size) {
                                                                Object obj3 = arrayList5.get(i7);
                                                                int i19 = i7 + 1;
                                                                str3 = (String) obj3;
                                                                if (str3 == null) {
                                                                    i8 = size;
                                                                } else {
                                                                    i8 = size;
                                                                    strTrim = str3.trim();
                                                                    if (strTrim.isEmpty()) {
                                                                        lowerCase = strTrim.toLowerCase(Locale.ROOT);
                                                                        if (!lowerCase.equals("autofill")) {
                                                                        }
                                                                        if (accessibilityService2.performGlobalAction(1)) {
                                                                            yVar.f1370k = 0;
                                                                            yVar.f1363d = j3;
                                                                            Log.i("ColorOsAutostart", "backed out of Settings accessibility leaf");
                                                                        }
                                                                    }
                                                                    i7 = i19;
                                                                    size = i8;
                                                                    arrayList5 = arrayList5;
                                                                }
                                                                i7 = i19;
                                                                size = i8;
                                                                arrayList5 = arrayList5;
                                                            }
                                                            accessibilityNodeInfoI = y.i(accessibilityNodeInfoJ2, arrayListC2, null, 0);
                                                            if (accessibilityNodeInfoI != null) {
                                                                z3 = true;
                                                            } else {
                                                                z3 = false;
                                                            }
                                                            y.p(accessibilityNodeInfoI);
                                                            if (z3) {
                                                                if (yVar.f1368i < 3) {
                                                                    accessibilityNodeInfoK2 = y.k(0, accessibilityNodeInfoJ2);
                                                                    if (accessibilityNodeInfoK2 == null) {
                                                                        zE3 = false;
                                                                    } else {
                                                                        zE3 = yVar.f1362c.e(4096, accessibilityNodeInfoK2);
                                                                        y.p(accessibilityNodeInfoK2);
                                                                    }
                                                                    if (zE3) {
                                                                        yVar.f1368i++;
                                                                        yVar.f1363d = j3;
                                                                        Log.i("ColorOsAutostart", "scrolled Settings for Apps hop");
                                                                    }
                                                                }
                                                                i3 = 1;
                                                                yVar.f1369j = true;
                                                            } else {
                                                                if (yVar.f1368i < 3) {
                                                                    accessibilityNodeInfoK2 = y.k(0, accessibilityNodeInfoJ2);
                                                                    if (accessibilityNodeInfoK2 == null) {
                                                                        zE3 = false;
                                                                    } else {
                                                                        zE3 = yVar.f1362c.e(4096, accessibilityNodeInfoK2);
                                                                        y.p(accessibilityNodeInfoK2);
                                                                    }
                                                                    if (zE3) {
                                                                        yVar.f1368i++;
                                                                        yVar.f1363d = j3;
                                                                        Log.i("ColorOsAutostart", "scrolled Settings for Apps hop");
                                                                    }
                                                                }
                                                                i3 = 1;
                                                                yVar.f1369j = true;
                                                            }
                                                        }
                                                    } else if (yVar.b(accessibilityNodeInfoL)) {
                                                        yVar.f1365f = false;
                                                        yVar.f1366g = false;
                                                        yVar.f1367h = false;
                                                        yVar.f1370k = 0;
                                                        yVar.f1363d = j3;
                                                        Log.i("ColorOsAutostart", "closed stale Settings search");
                                                        y.p(accessibilityNodeInfoL);
                                                    } else {
                                                        y.p(accessibilityNodeInfoL);
                                                        size = arrayList5.size();
                                                        i7 = 0;
                                                        while (true) {
                                                            if (i7 < size) {
                                                                Object obj4 = arrayList5.get(i7);
                                                                int i110 = i7 + 1;
                                                                str3 = (String) obj4;
                                                                if (str3 == null) {
                                                                    i8 = size;
                                                                } else {
                                                                    i8 = size;
                                                                    strTrim = str3.trim();
                                                                    if (strTrim.isEmpty()) {
                                                                        lowerCase = strTrim.toLowerCase(Locale.ROOT);
                                                                        if (!lowerCase.equals("autofill")) {
                                                                        }
                                                                        if (accessibilityService2.performGlobalAction(1)) {
                                                                            yVar.f1370k = 0;
                                                                            yVar.f1363d = j3;
                                                                            Log.i("ColorOsAutostart", "backed out of Settings accessibility leaf");
                                                                        }
                                                                    }
                                                                    i7 = i110;
                                                                    size = i8;
                                                                    arrayList5 = arrayList5;
                                                                }
                                                                i7 = i110;
                                                                size = i8;
                                                                arrayList5 = arrayList5;
                                                            }
                                                            accessibilityNodeInfoI = y.i(accessibilityNodeInfoJ2, arrayListC2, null, 0);
                                                            if (accessibilityNodeInfoI != null) {
                                                                z3 = true;
                                                            } else {
                                                                z3 = false;
                                                            }
                                                            y.p(accessibilityNodeInfoI);
                                                            if (z3) {
                                                                if (yVar.f1368i < 3) {
                                                                    accessibilityNodeInfoK2 = y.k(0, accessibilityNodeInfoJ2);
                                                                    if (accessibilityNodeInfoK2 == null) {
                                                                        zE3 = false;
                                                                    } else {
                                                                        zE3 = yVar.f1362c.e(4096, accessibilityNodeInfoK2);
                                                                        y.p(accessibilityNodeInfoK2);
                                                                    }
                                                                    if (zE3) {
                                                                        yVar.f1368i++;
                                                                        yVar.f1363d = j3;
                                                                        Log.i("ColorOsAutostart", "scrolled Settings for Apps hop");
                                                                    }
                                                                }
                                                                i3 = 1;
                                                                yVar.f1369j = true;
                                                            } else {
                                                                if (yVar.f1368i < 3) {
                                                                    accessibilityNodeInfoK2 = y.k(0, accessibilityNodeInfoJ2);
                                                                    if (accessibilityNodeInfoK2 == null) {
                                                                        zE3 = false;
                                                                    } else {
                                                                        zE3 = yVar.f1362c.e(4096, accessibilityNodeInfoK2);
                                                                        y.p(accessibilityNodeInfoK2);
                                                                    }
                                                                    if (zE3) {
                                                                        yVar.f1368i++;
                                                                        yVar.f1363d = j3;
                                                                        Log.i("ColorOsAutostart", "scrolled Settings for Apps hop");
                                                                    }
                                                                }
                                                                i3 = 1;
                                                                yVar.f1369j = true;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    i3 = 1;
                                                }
                                                AccessibilityNodeInfo[] accessibilityNodeInfoArr2 = new AccessibilityNodeInfo[i3];
                                                y.t(accessibilityNodeInfoJ2, 0, accessibilityNodeInfoArr2, new int[]{0});
                                                accessibilityNodeInfo = accessibilityNodeInfoArr2[0];
                                                if (accessibilityNodeInfo != null) {
                                                    if (!yVar.f1365f) {
                                                        zB = yVar.b(accessibilityNodeInfo);
                                                        yVar.f1365f = zB;
                                                        if (zB) {
                                                            yVar.f1363d = j3;
                                                            Log.i("ColorOsAutostart", "opened Settings search");
                                                        } else if (yVar.f1366g) {
                                                            zE = dVar.e(1, accessibilityNodeInfo);
                                                            boolean zB5 = yVar.b(accessibilityNodeInfo);
                                                            if (zE) {
                                                                z2 = true;
                                                            } else {
                                                                z2 = true;
                                                            }
                                                            yVar.f1366g = z2;
                                                            if (z2) {
                                                                yVar.f1363d = j3;
                                                                Log.i("ColorOsAutostart", "focused Settings search editor");
                                                            } else {
                                                                if (!yVar.f1367h) {
                                                                    bundle = new Bundle();
                                                                    bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", "自启动");
                                                                    dVar.getClass();
                                                                    if (dVar.h(new d2.c(accessibilityNodeInfo, bundle, 14))) {
                                                                        yVar.f1367h = true;
                                                                        yVar.f1363d = j3;
                                                                        Log.i("ColorOsAutostart", "typed Settings Auto launch query");
                                                                    }
                                                                }
                                                                y.p(accessibilityNodeInfo);
                                                                i4 = yVar.f1370k + 1;
                                                                yVar.f1370k = i4;
                                                                if (i4 >= 3) {
                                                                    i5 = 0;
                                                                    accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                    if (accessibilityNodeInfoK == null) {
                                                                        zE2 = false;
                                                                    } else {
                                                                        zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                        y.p(accessibilityNodeInfoK);
                                                                    }
                                                                    if (zE2) {
                                                                        yVar.f1363d = j3;
                                                                    }
                                                                } else {
                                                                    i5 = 0;
                                                                    accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                    if (accessibilityNodeInfoK == null) {
                                                                        zE2 = false;
                                                                    } else {
                                                                        zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                        y.p(accessibilityNodeInfoK);
                                                                    }
                                                                    if (zE2) {
                                                                        yVar.f1363d = j3;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            if (!yVar.f1367h) {
                                                                bundle = new Bundle();
                                                                bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", "自启动");
                                                                dVar.getClass();
                                                                if (dVar.h(new d2.c(accessibilityNodeInfo, bundle, 14))) {
                                                                    yVar.f1367h = true;
                                                                    yVar.f1363d = j3;
                                                                    Log.i("ColorOsAutostart", "typed Settings Auto launch query");
                                                                }
                                                            }
                                                            y.p(accessibilityNodeInfo);
                                                            i4 = yVar.f1370k + 1;
                                                            yVar.f1370k = i4;
                                                            if (i4 >= 3) {
                                                                i5 = 0;
                                                                accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                if (accessibilityNodeInfoK == null) {
                                                                    zE2 = false;
                                                                } else {
                                                                    zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                    y.p(accessibilityNodeInfoK);
                                                                }
                                                                if (zE2) {
                                                                    yVar.f1363d = j3;
                                                                }
                                                            } else {
                                                                i5 = 0;
                                                                accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                if (accessibilityNodeInfoK == null) {
                                                                    zE2 = false;
                                                                } else {
                                                                    zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                    y.p(accessibilityNodeInfoK);
                                                                }
                                                                if (zE2) {
                                                                    yVar.f1363d = j3;
                                                                }
                                                            }
                                                        }
                                                    } else if (yVar.f1366g) {
                                                        zE = dVar.e(1, accessibilityNodeInfo);
                                                        boolean zB6 = yVar.b(accessibilityNodeInfo);
                                                        if (zE) {
                                                            z2 = true;
                                                        } else {
                                                            z2 = true;
                                                        }
                                                        yVar.f1366g = z2;
                                                        if (z2) {
                                                            yVar.f1363d = j3;
                                                            Log.i("ColorOsAutostart", "focused Settings search editor");
                                                        } else {
                                                            if (!yVar.f1367h) {
                                                                bundle = new Bundle();
                                                                bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", "自启动");
                                                                dVar.getClass();
                                                                if (dVar.h(new d2.c(accessibilityNodeInfo, bundle, 14))) {
                                                                    yVar.f1367h = true;
                                                                    yVar.f1363d = j3;
                                                                    Log.i("ColorOsAutostart", "typed Settings Auto launch query");
                                                                }
                                                            }
                                                            y.p(accessibilityNodeInfo);
                                                            i4 = yVar.f1370k + 1;
                                                            yVar.f1370k = i4;
                                                            if (i4 >= 3) {
                                                                i5 = 0;
                                                                accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                if (accessibilityNodeInfoK == null) {
                                                                    zE2 = false;
                                                                } else {
                                                                    zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                    y.p(accessibilityNodeInfoK);
                                                                }
                                                                if (zE2) {
                                                                    yVar.f1363d = j3;
                                                                }
                                                            } else {
                                                                i5 = 0;
                                                                accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                                if (accessibilityNodeInfoK == null) {
                                                                    zE2 = false;
                                                                } else {
                                                                    zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                    y.p(accessibilityNodeInfoK);
                                                                }
                                                                if (zE2) {
                                                                    yVar.f1363d = j3;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        if (!yVar.f1367h) {
                                                            bundle = new Bundle();
                                                            bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", "自启动");
                                                            dVar.getClass();
                                                            if (dVar.h(new d2.c(accessibilityNodeInfo, bundle, 14))) {
                                                                yVar.f1367h = true;
                                                                yVar.f1363d = j3;
                                                                Log.i("ColorOsAutostart", "typed Settings Auto launch query");
                                                            }
                                                        }
                                                        y.p(accessibilityNodeInfo);
                                                        i4 = yVar.f1370k + 1;
                                                        yVar.f1370k = i4;
                                                        if (i4 >= 3) {
                                                            i5 = 0;
                                                            accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                            if (accessibilityNodeInfoK == null) {
                                                                zE2 = false;
                                                            } else {
                                                                zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                y.p(accessibilityNodeInfoK);
                                                            }
                                                            if (zE2) {
                                                                yVar.f1363d = j3;
                                                            }
                                                        } else {
                                                            i5 = 0;
                                                            accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                            if (accessibilityNodeInfoK == null) {
                                                                zE2 = false;
                                                            } else {
                                                                zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                                y.p(accessibilityNodeInfoK);
                                                            }
                                                            if (zE2) {
                                                                yVar.f1363d = j3;
                                                            }
                                                        }
                                                    }
                                                    y.p(accessibilityNodeInfo);
                                                } else {
                                                    i4 = yVar.f1370k + 1;
                                                    yVar.f1370k = i4;
                                                    if (i4 >= 3) {
                                                        i5 = 0;
                                                        accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                        if (accessibilityNodeInfoK == null) {
                                                            zE2 = false;
                                                        } else {
                                                            zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                            y.p(accessibilityNodeInfoK);
                                                        }
                                                        if (zE2) {
                                                            yVar.f1363d = j3;
                                                        }
                                                    } else {
                                                        i5 = 0;
                                                        accessibilityNodeInfoK = y.k(i5, accessibilityNodeInfoJ2);
                                                        if (accessibilityNodeInfoK == null) {
                                                            zE2 = false;
                                                        } else {
                                                            zE2 = yVar.f1362c.e(4096, accessibilityNodeInfoK);
                                                            y.p(accessibilityNodeInfoK);
                                                        }
                                                        if (zE2) {
                                                            yVar.f1363d = j3;
                                                        }
                                                    }
                                                }
                                            }
                                            i9 = 1;
                                            break;
                                        }
                                        i9 = 2;
                                        break;
                                    }
                                } else {
                                    x1.r rVar2 = yVar.f1361b;
                                    long j5 = yVar.f1364e;
                                    if (j5 != 0) {
                                        if (j3 >= j5) {
                                            ArrayList arrayList6 = new ArrayList();
                                            int size5 = arrayListO.size();
                                            str2 = "SampleGrantClicker";
                                            int i20 = 0;
                                            while (i20 < size5) {
                                                Object obj5 = arrayListO.get(i20);
                                                i20++;
                                                String str6 = (String) obj5;
                                                if (str6 != null) {
                                                    int i21 = size5;
                                                    String strTrim2 = str6.trim();
                                                    if (strTrim2.isEmpty()) {
                                                        size5 = i21;
                                                    } else {
                                                        ArrayList arrayList7 = arrayListO;
                                                        if (!strTrim2.trim().matches("[a-z][a-z0-9_]*(\\.[a-z0-9_]+){2,}") && !arrayList6.contains(strTrim2)) {
                                                            arrayList6.add(strTrim2);
                                                        }
                                                        arrayListO = arrayList7;
                                                        size5 = i21;
                                                        i20 = i20;
                                                    }
                                                }
                                            }
                                            ArrayList arrayList8 = new ArrayList();
                                            arrayList8.add(accessibilityService2.getPackageName());
                                            ArrayList arrayList9 = new ArrayList();
                                            y.c(accessibilityNodeInfoJ, arrayList6, 0, arrayList9);
                                            if (arrayList9.isEmpty()) {
                                                ArrayList arrayList10 = new ArrayList();
                                                y.e(0, accessibilityNodeInfoJ, arrayList10);
                                                StringBuilder sb = new StringBuilder();
                                                int size6 = arrayList10.size();
                                                int i22 = 0;
                                                int i23 = 0;
                                                while (i23 < size6) {
                                                    Object obj6 = arrayList10.get(i23);
                                                    i23++;
                                                    String str7 = (String) obj6;
                                                    if (str7 == null) {
                                                        arrayList4 = arrayList10;
                                                    } else {
                                                        arrayList4 = arrayList10;
                                                        String strTrim3 = str7.trim();
                                                        if (!strTrim3.isEmpty() && !l.u(strTrim3)) {
                                                            i14 = size6;
                                                            String lowerCase2 = strTrim3.toLowerCase(Locale.ROOT);
                                                            i15 = i22;
                                                            if (!lowerCase2.equals("auto launch") && !lowerCase2.equals("autostart") && !lowerCase2.equals("iniciar automáticamente") && !lowerCase2.equals("inicio automático") && !strTrim3.equals("自启动") && !strTrim3.equals("自动启动") && !lowerCase2.startsWith("turning on") && !lowerCase2.startsWith("turning off") && !lowerCase2.startsWith("activando") && !lowerCase2.startsWith("desactivando") && !strTrim3.startsWith("开启以下") && !strTrim3.startsWith("关闭以下")) {
                                                                String strTrim4 = str7.trim();
                                                                if (!strTrim4.isEmpty()) {
                                                                    if (i15 > 0) {
                                                                        sb.append('|');
                                                                    }
                                                                    sb.append(strTrim4);
                                                                    i22 = i15 + 1;
                                                                    if (i22 >= 12) {
                                                                        break;
                                                                    }
                                                                    arrayList10 = arrayList4;
                                                                    size6 = i14;
                                                                }
                                                            }
                                                            arrayList10 = arrayList4;
                                                            size6 = i14;
                                                            i22 = i15;
                                                        }
                                                    }
                                                    i14 = size6;
                                                    i15 = i22;
                                                    arrayList10 = arrayList4;
                                                    size6 = i14;
                                                    i22 = i15;
                                                }
                                                String string = sb.toString();
                                                if (!string.isEmpty()) {
                                                    if (!yVar.f1374p) {
                                                        if (!yVar.f1376r) {
                                                            if (string.isEmpty()) {
                                                                yVar.f1372m = string;
                                                                yVar.n = 1;
                                                            } else {
                                                                yVar.f1372m = string;
                                                                yVar.n = 1;
                                                            }
                                                            if (yVar.n >= Math.max(2, 2)) {
                                                                z6 = yVar.f1373o;
                                                                accessibilityNodeInfoK3 = y.k(0, accessibilityNodeInfoJ);
                                                                if (accessibilityNodeInfoK3 != null) {
                                                                    if (z6) {
                                                                        i13 = 4096;
                                                                    } else {
                                                                        i13 = 8192;
                                                                    }
                                                                    if (dVar.e(i13, accessibilityNodeInfoK3)) {
                                                                        y.p(accessibilityNodeInfoK3);
                                                                        zP = true;
                                                                    } else if (rVar2 == null) {
                                                                        y.p(accessibilityNodeInfoK3);
                                                                        zP = false;
                                                                    } else {
                                                                        Rect rect = new Rect();
                                                                        accessibilityNodeInfoK3.getBoundsInScreen(rect);
                                                                        x1.r rVar3 = yVar.f1361b;
                                                                        iHeight = rect.height();
                                                                        if (iHeight <= 0) {
                                                                            iMax = 200;
                                                                        } else {
                                                                            iMax = Math.max(160, Math.round(iHeight * 0.25f));
                                                                        }
                                                                        zP = rVar3.p(iMax, rect, z6);
                                                                        y.p(accessibilityNodeInfoK3);
                                                                    }
                                                                } else {
                                                                    zP = false;
                                                                }
                                                                if (zP) {
                                                                    yVar.f1374p = true;
                                                                    yVar.f1375q = string;
                                                                    yVar.n = 0;
                                                                    yVar.f1363d = j3;
                                                                    yVar.f1364e = 1000 + j3;
                                                                    if (yVar.f1373o) {
                                                                        str4 = "bottom";
                                                                    } else {
                                                                        str4 = "top";
                                                                    }
                                                                    Log.i("ColorOsAutostart", "scrolled ColorOS auto-start list toward ".concat(str4));
                                                                    i9 = 1;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        yVar.f1374p = false;
                                                        if (!string.equals(yVar.f1375q)) {
                                                            if (!yVar.f1376r) {
                                                                if (string.isEmpty() || !string.equals(yVar.f1372m)) {
                                                                    yVar.f1372m = string;
                                                                    yVar.n = 1;
                                                                } else {
                                                                    yVar.n++;
                                                                }
                                                                if (yVar.n >= Math.max(2, 2)) {
                                                                    z6 = yVar.f1373o;
                                                                    accessibilityNodeInfoK3 = y.k(0, accessibilityNodeInfoJ);
                                                                    if (accessibilityNodeInfoK3 != null) {
                                                                        if (z6) {
                                                                            i13 = 4096;
                                                                        } else {
                                                                            i13 = 8192;
                                                                        }
                                                                        try {
                                                                            if (dVar.e(i13, accessibilityNodeInfoK3)) {
                                                                                y.p(accessibilityNodeInfoK3);
                                                                                zP = true;
                                                                            } else if (rVar2 == null) {
                                                                                y.p(accessibilityNodeInfoK3);
                                                                                zP = false;
                                                                            } else {
                                                                                Rect rect2 = new Rect();
                                                                                accessibilityNodeInfoK3.getBoundsInScreen(rect2);
                                                                                x1.r rVar4 = yVar.f1361b;
                                                                                iHeight = rect2.height();
                                                                                if (iHeight <= 0) {
                                                                                    iMax = 200;
                                                                                } else {
                                                                                    iMax = Math.max(160, Math.round(iHeight * 0.25f));
                                                                                }
                                                                                zP = rVar4.p(iMax, rect2, z6);
                                                                                y.p(accessibilityNodeInfoK3);
                                                                            }
                                                                        } catch (Throwable th7) {
                                                                            y.p(accessibilityNodeInfoK3);
                                                                            throw th7;
                                                                        }
                                                                    } else {
                                                                        zP = false;
                                                                    }
                                                                    if (zP) {
                                                                        yVar.f1374p = true;
                                                                        yVar.f1375q = string;
                                                                        yVar.n = 0;
                                                                        yVar.f1363d = j3;
                                                                        yVar.f1364e = 1000 + j3;
                                                                        if (yVar.f1373o) {
                                                                            str4 = "bottom";
                                                                        } else {
                                                                            str4 = "top";
                                                                        }
                                                                        Log.i("ColorOsAutostart", "scrolled ColorOS auto-start list toward ".concat(str4));
                                                                        i9 = 1;
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            yVar.n = 0;
                                                            yVar.f1372m = string;
                                                            if (!yVar.f1373o) {
                                                                yVar.f1373o = true;
                                                                Log.i("ColorOsAutostart", "reached ColorOS list top; scanning toward bottom");
                                                            } else if (!yVar.f1376r) {
                                                                yVar.f1376r = true;
                                                                Log.w("ColorOsAutostart", "runtime label absent after full ColorOS list traversal");
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                try {
                                                    ArrayList arrayList11 = new ArrayList();
                                                    int size7 = arrayList9.size();
                                                    int i24 = 0;
                                                    while (i24 < size7) {
                                                        Object obj7 = arrayList9.get(i24);
                                                        i24++;
                                                        int i25 = size7;
                                                        Rect rect3 = new Rect();
                                                        ((AccessibilityNodeInfo) obj7).getBoundsInScreen(rect3);
                                                        if (!y.a(arrayList11, rect3)) {
                                                            arrayList11.add(rect3);
                                                        }
                                                        size7 = i25;
                                                    }
                                                    if (arrayList11.size() != 1) {
                                                        Log.w("ColorOsAutostart", "own ColorOS label is ambiguous; refusing to toggle " + arrayList11.size() + " rows");
                                                        int size8 = arrayList9.size();
                                                        int i26 = 0;
                                                        while (i26 < size8) {
                                                            Object obj8 = arrayList9.get(i26);
                                                            i26++;
                                                            y.p((AccessibilityNodeInfo) obj8);
                                                        }
                                                    } else {
                                                        ArrayList arrayList12 = new ArrayList();
                                                        int size9 = arrayList9.size();
                                                        boolean z7 = false;
                                                        int i27 = 0;
                                                        while (true) {
                                                            if (i27 < size9) {
                                                                Object obj9 = arrayList9.get(i27);
                                                                int i28 = i27 + 1;
                                                                size9 = size9;
                                                                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj9;
                                                                boolean z8 = z7;
                                                                Rect rect4 = new Rect();
                                                                accessibilityNodeInfo2.getBoundsInScreen(rect4);
                                                                if (y.a(arrayList12, rect4)) {
                                                                    arrayList2 = arrayList12;
                                                                    arrayList3 = arrayList8;
                                                                    i10 = i28;
                                                                } else {
                                                                    arrayList12.add(rect4);
                                                                    String strQ = y.q(accessibilityNodeInfo2);
                                                                    if (l.T(strQ, arrayList8)) {
                                                                        arrayList2 = arrayList12;
                                                                        String lowerCase3 = strQ.toLowerCase(Locale.ROOT);
                                                                        int size10 = arrayList8.size();
                                                                        i10 = i28;
                                                                        int i29 = 0;
                                                                        while (true) {
                                                                            if (i29 >= size10) {
                                                                                arrayList3 = arrayList8;
                                                                                z5 = false;
                                                                                break;
                                                                            }
                                                                            Object obj10 = arrayList8.get(i29);
                                                                            i29++;
                                                                            arrayList3 = arrayList8;
                                                                            String str8 = (String) obj10;
                                                                            if (str8 != null && !str8.isEmpty()) {
                                                                                if (lowerCase3.contains(str8.toLowerCase(Locale.ROOT))) {
                                                                                    z5 = true;
                                                                                    break;
                                                                                }
                                                                            }
                                                                            size10 = size10;
                                                                            arrayList8 = arrayList3;
                                                                        }
                                                                        if (!z5) {
                                                                            Log.w("ColorOsAutostart", "skipped foreign auto-start row");
                                                                        }
                                                                    } else {
                                                                        arrayList2 = arrayList12;
                                                                        arrayList3 = arrayList8;
                                                                        i10 = i28;
                                                                    }
                                                                    AccessibilityNodeInfo accessibilityNodeInfoM = y.m(accessibilityNodeInfo2);
                                                                    if (accessibilityNodeInfoM == null) {
                                                                        accessibilityNodeInfoM = y.n(accessibilityNodeInfoJ, accessibilityNodeInfo2);
                                                                    }
                                                                    if (accessibilityNodeInfoM != null) {
                                                                        try {
                                                                            if (!accessibilityNodeInfoM.isCheckable() || !accessibilityNodeInfoM.isChecked()) {
                                                                                if (!y.r(accessibilityNodeInfo2)) {
                                                                                    if (accessibilityNodeInfoM != null) {
                                                                                        if (accessibilityNodeInfoM.isVisibleToUser()) {
                                                                                            accessibilityNodeInfoF = y.f(accessibilityNodeInfoM);
                                                                                            if (accessibilityNodeInfoF != null) {
                                                                                                try {
                                                                                                    if (dVar.e(16, accessibilityNodeInfoF)) {
                                                                                                        y.p(accessibilityNodeInfoF);
                                                                                                        z4 = true;
                                                                                                    } else if (dVar.e(16, accessibilityNodeInfoM)) {
                                                                                                        y.p(accessibilityNodeInfoF);
                                                                                                        z4 = true;
                                                                                                    } else {
                                                                                                        if (rVar2 == null && rVar2.f(accessibilityNodeInfoM)) {
                                                                                                            z4 = true;
                                                                                                        } else {
                                                                                                            z4 = false;
                                                                                                        }
                                                                                                        y.p(accessibilityNodeInfoF);
                                                                                                    }
                                                                                                } catch (Throwable th8) {
                                                                                                    y.p(accessibilityNodeInfoF);
                                                                                                    throw th8;
                                                                                                }
                                                                                            } else if (dVar.e(16, accessibilityNodeInfoM)) {
                                                                                                y.p(accessibilityNodeInfoF);
                                                                                                z4 = true;
                                                                                            } else {
                                                                                                if (rVar2 == null) {
                                                                                                    z4 = false;
                                                                                                } else {
                                                                                                    z4 = false;
                                                                                                }
                                                                                                y.p(accessibilityNodeInfoF);
                                                                                            }
                                                                                        } else {
                                                                                            z4 = false;
                                                                                        }
                                                                                        if (z4) {
                                                                                            yVar.f1363d = j3;
                                                                                            yVar.f1364e = 1800 + j3;
                                                                                            Log.i("ColorOsAutostart", "clicked runtime-label own auto-start switch");
                                                                                            y.p(accessibilityNodeInfoM);
                                                                                            size3 = arrayList9.size();
                                                                                            i12 = 0;
                                                                                            while (i12 < size3) {
                                                                                                Object obj11 = arrayList9.get(i12);
                                                                                                i12++;
                                                                                                y.p((AccessibilityNodeInfo) obj11);
                                                                                            }
                                                                                            i9 = 1;
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    Log.w("ColorOsAutostart", "own ColorOS row has no safe in-row toggle");
                                                                                    y.p(accessibilityNodeInfoM);
                                                                                    size2 = arrayList9.size();
                                                                                    i11 = 0;
                                                                                    while (i11 < size2) {
                                                                                        Object obj12 = arrayList9.get(i11);
                                                                                        i11++;
                                                                                        y.p((AccessibilityNodeInfo) obj12);
                                                                                    }
                                                                                }
                                                                            }
                                                                            y.p(accessibilityNodeInfoM);
                                                                            arrayList12 = arrayList2;
                                                                            i27 = i10;
                                                                            arrayList8 = arrayList3;
                                                                            z7 = true;
                                                                        } catch (Throwable th9) {
                                                                            y.p(accessibilityNodeInfoM);
                                                                            throw th9;
                                                                        }
                                                                    } else {
                                                                        if (!y.r(accessibilityNodeInfo2)) {
                                                                            if (accessibilityNodeInfoM != null) {
                                                                                if (accessibilityNodeInfoM.isVisibleToUser()) {
                                                                                    z4 = false;
                                                                                } else {
                                                                                    accessibilityNodeInfoF = y.f(accessibilityNodeInfoM);
                                                                                    if (accessibilityNodeInfoF != null) {
                                                                                        if (dVar.e(16, accessibilityNodeInfoF)) {
                                                                                            y.p(accessibilityNodeInfoF);
                                                                                            z4 = true;
                                                                                        } else if (dVar.e(16, accessibilityNodeInfoM)) {
                                                                                            y.p(accessibilityNodeInfoF);
                                                                                            z4 = true;
                                                                                        } else {
                                                                                            if (rVar2 == null) {
                                                                                                z4 = false;
                                                                                            } else {
                                                                                                z4 = false;
                                                                                            }
                                                                                            y.p(accessibilityNodeInfoF);
                                                                                        }
                                                                                    } else if (dVar.e(16, accessibilityNodeInfoM)) {
                                                                                        y.p(accessibilityNodeInfoF);
                                                                                        z4 = true;
                                                                                    } else {
                                                                                        if (rVar2 == null) {
                                                                                            z4 = false;
                                                                                        } else {
                                                                                            z4 = false;
                                                                                        }
                                                                                        y.p(accessibilityNodeInfoF);
                                                                                    }
                                                                                }
                                                                                if (z4) {
                                                                                    yVar.f1363d = j3;
                                                                                    yVar.f1364e = 1800 + j3;
                                                                                    Log.i("ColorOsAutostart", "clicked runtime-label own auto-start switch");
                                                                                    y.p(accessibilityNodeInfoM);
                                                                                    size3 = arrayList9.size();
                                                                                    i12 = 0;
                                                                                    while (i12 < size3) {
                                                                                        Object obj13 = arrayList9.get(i12);
                                                                                        i12++;
                                                                                        y.p((AccessibilityNodeInfo) obj13);
                                                                                    }
                                                                                    i9 = 1;
                                                                                    break;
                                                                                }
                                                                            }
                                                                            Log.w("ColorOsAutostart", "own ColorOS row has no safe in-row toggle");
                                                                            y.p(accessibilityNodeInfoM);
                                                                            size2 = arrayList9.size();
                                                                            i11 = 0;
                                                                            while (i11 < size2) {
                                                                                Object obj14 = arrayList9.get(i11);
                                                                                i11++;
                                                                                y.p((AccessibilityNodeInfo) obj14);
                                                                            }
                                                                        }
                                                                        y.p(accessibilityNodeInfoM);
                                                                        arrayList12 = arrayList2;
                                                                        i27 = i10;
                                                                        arrayList8 = arrayList3;
                                                                        z7 = true;
                                                                    }
                                                                }
                                                                z7 = z8;
                                                                arrayList12 = arrayList2;
                                                                i27 = i10;
                                                                arrayList8 = arrayList3;
                                                            } else {
                                                                if (z7) {
                                                                    Log.i("ColorOsAutostart", "verified runtime-label own auto-start switch");
                                                                    int size11 = arrayList9.size();
                                                                    int i30 = 0;
                                                                    while (i30 < size11) {
                                                                        Object obj15 = arrayList9.get(i30);
                                                                        i30++;
                                                                        y.p((AccessibilityNodeInfo) obj15);
                                                                    }
                                                                    i9 = 3;
                                                                    break;
                                                                }
                                                                int size12 = arrayList9.size();
                                                                int i31 = 0;
                                                                while (i31 < size12) {
                                                                    Object obj16 = arrayList9.get(i31);
                                                                    i31++;
                                                                    y.p((AccessibilityNodeInfo) obj16);
                                                                }
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th10) {
                                                    int size13 = arrayList9.size();
                                                    int i32 = 0;
                                                    while (i32 < size13) {
                                                        Object obj17 = arrayList9.get(i32);
                                                        i32++;
                                                        y.p((AccessibilityNodeInfo) obj17);
                                                    }
                                                    throw th10;
                                                }
                                            }
                                        }
                                        i9 = 2;
                                        break;
                                    }
                                    yVar.f1364e = 900 + j3;
                                    Log.i("ColorOsAutostart", "ColorOS auto-start list landed; scanning toward top first");
                                    str2 = "SampleGrantClicker";
                                    i9 = 2;
                                    break;
                                }
                            } else {
                                str2 = "SampleGrantClicker";
                                i9 = 4;
                                break;
                            }
                        } else {
                            Object obj18 = arrayList.get(i16);
                            i16++;
                            AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj18;
                            if (accessibilityNodeInfo3 != null) {
                                ArrayList arrayList13 = new ArrayList();
                                int i33 = size4;
                                y.e(0, accessibilityNodeInfo3, arrayList13);
                                int size14 = arrayList13.size();
                                int i34 = 0;
                                while (true) {
                                    if (i34 < size14) {
                                        Object obj19 = arrayList13.get(i34);
                                        int i35 = i34 + 1;
                                        String str9 = (String) obj19;
                                        if (str9 != null && !str9.isEmpty()) {
                                            String strTrim5 = str9.trim();
                                            String lowerCase4 = strTrim5.toLowerCase(Locale.ROOT);
                                            if (strTrim5.contains("系统最多允许") || strTrim5.contains("系統最多允許") || strTrim5.contains("不建议自启动应用减少到") || strTrim5.contains("不建議自動啟動應用程式減少到") || strTrim5.contains("不建议自启动") || lowerCase4.contains("auto startup is limited to") || lowerCase4.contains("not recommended auto-launch") || lowerCase4.contains("allowed but not recommended") || lowerCase4.contains("aplicaciones de inicio automático permitidas pero no recomendadas")) {
                                                yVar.f1377s = true;
                                                AccessibilityNodeInfo accessibilityNodeInfoH = y.h(0, accessibilityNodeInfo3);
                                                if (accessibilityNodeInfoH == null) {
                                                    zB2 = false;
                                                } else {
                                                    try {
                                                        zB2 = yVar.b(accessibilityNodeInfoH);
                                                        y.p(accessibilityNodeInfoH);
                                                    } catch (Throwable th11) {
                                                        y.p(accessibilityNodeInfoH);
                                                        throw th11;
                                                    }
                                                }
                                                if (!zB2) {
                                                    str2 = "SampleGrantClicker";
                                                    i9 = 4;
                                                    break;
                                                } else {
                                                    yVar.f1363d = j3;
                                                    Log.w("ColorOsAutostart", "auto-start limit reached; dismissed warning without changing other apps");
                                                    str2 = "SampleGrantClicker";
                                                    i9 = 1;
                                                    break;
                                                }
                                            }
                                        }
                                        arrayList13 = arrayList13;
                                        i34 = i35;
                                        size14 = size14;
                                    } else {
                                        i16 = i16;
                                        size4 = i33;
                                    }
                                }
                            }
                        }
                    }
                    iA = g.d.a(i9);
                    if (iA != 0) {
                        n = j3;
                        return;
                    }
                    if (iA != 1) {
                        return;
                    }
                    if (iA != 2) {
                        l.N(accessibilityService, "coloros_package_row_checked");
                        zM = m(accessibilityService, j4);
                        n = j3;
                        if (zM) {
                            Log.i(str2, "OEM autostart verified by ColorOS label-filtered row");
                            return;
                        }
                        return;
                    }
                    if (iA != 3) {
                        return;
                    } else {
                        str = str2;
                    }
                }
                i9 = 5;
                iA = g.d.a(i9);
                if (iA != 0) {
                    n = j3;
                    return;
                }
                if (iA != 1) {
                    return;
                }
                if (iA != 2) {
                    l.N(accessibilityService, "coloros_package_row_checked");
                    zM = m(accessibilityService, j4);
                    n = j3;
                    if (zM) {
                        Log.i(str2, "OEM autostart verified by ColorOS label-filtered row");
                        return;
                    }
                    return;
                }
                if (iA != 3) {
                    return;
                } else {
                    str = str2;
                }
            } else {
                str = "SampleGrantClicker";
            }
            ArrayList arrayList14 = new ArrayList();
            int size15 = arrayList.size();
            int i36 = 0;
            while (i36 < size15) {
                Object obj20 = arrayList.get(i36);
                i36++;
                AccessibilityNodeInfo accessibilityNodeInfo4 = (AccessibilityNodeInfo) obj20;
                if (accessibilityNodeInfo4 != null && accessibilityNodeInfo4.getPackageName() != null && l.F(accessibilityNodeInfo4.getPackageName().toString())) {
                    arrayList14.add(accessibilityNodeInfo4);
                }
            }
            if (arrayList14.isEmpty()) {
                return;
            }
            int iE = i0.E(accessibilityService);
            if (iE == 1) {
                l.N(accessibilityService, "miui_appop_allowed");
                boolean zM2 = m(accessibilityService, j4);
                n = j3;
                if (zM2) {
                    Log.i(str, "OEM autostart verified by MIUI AppOp");
                    return;
                }
                return;
            }
            if (d(rVar, arrayList14, true)) {
                n = j3;
                Log.i(str, "clicked OEM autostart confirmation");
                return;
            }
            y.m mVar = f1298r;
            if (mVar == null || f1297q != accessibilityService) {
                mVar = new y.m(accessibilityService);
                f1298r = mVar;
                f1297q = accessibilityService;
                f1299s = j4;
            } else if (f1299s != j4) {
                mVar.t();
                f1299s = j4;
            }
            ArrayList arrayListO2 = y.m.o(accessibilityService);
            int size16 = arrayList14.size();
            int i37 = 0;
            while (i37 < size16) {
                Object obj21 = arrayList14.get(i37);
                i37++;
                AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) obj21;
                int iA2 = g.d.a(mVar.d(accessibilityNodeInfo5, arrayListO2, 4, false));
                if (iA2 == 0) {
                    n = j3;
                    Log.i(str, "clicked own OEM autostart switch; awaiting verification");
                    return;
                }
                if (iA2 == 1) {
                    if (iE != 2) {
                        l.N(accessibilityService, "checked");
                        boolean zM3 = m(accessibilityService, j4);
                        n = j3;
                        if (zM3) {
                            Log.i(str, "OEM autostart verified enabled");
                            return;
                        }
                        return;
                    }
                    if (!mVar.c(accessibilityNodeInfo5, arrayListO2)) {
                        Log.w(str, "OEM row checked but MIUI AppOp denied");
                        return;
                    }
                    c0.i(12);
                    mVar.t();
                    n = j3;
                    Log.w(str, "reconciling checked OEM row with denied AppOp");
                    return;
                }
                if (iA2 == 2) {
                    return;
                }
                if (iA2 == 3) {
                    n = j3;
                    Log.i(str, "scrolled OEM autostart list for own app");
                    return;
                } else if (iA2 == 5) {
                    Log.w(str, "own OEM autostart row click failed");
                    return;
                }
            }
        }
    }

    public static void F(AccessibilityService accessibilityService, x1.r rVar, ArrayList arrayList, long j3) {
        String strS;
        if (Y(accessibilityService)) {
            c0.e(10);
            f1294m = false;
            f1282a.c(accessibilityService);
            Log.i("SampleGrantClicker", "play already disabled");
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo != null && (strS = S(accessibilityNodeInfo)) != null && !strS.isEmpty()) {
                String lowerCase = strS.toLowerCase(Locale.ROOT);
                if (lowerCase.contains("settings") || lowerCase.contains("vending")) {
                    if (!c0.f1148l) {
                        c0.f1148l = true;
                        f1294m = false;
                        c0(accessibilityService, rVar, 800L);
                        return;
                    } else {
                        if (f1294m) {
                            if (e(rVar, arrayList, f1289h)) {
                                n = j3;
                                Log.i("SampleGrantClicker", "clicked play Disable app");
                                f1290i.postDelayed(new c2.d(accessibilityService, 6), 350L);
                                return;
                            }
                            return;
                        }
                        if (e(rVar, arrayList, f1288g)) {
                            f1294m = true;
                            n = j3;
                            Log.i("SampleGrantClicker", "clicked play Disable");
                            c0(accessibilityService, rVar, 800L);
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0060  */
    public static void G(AccessibilityService accessibilityService, x1.r rVar, ArrayList arrayList, long j3) {
        boolean zF;
        try {
            if (Settings.System.canWrite(accessibilityService)) {
                c0.e(6);
                return;
            }
        } catch (Throwable unused) {
        }
        long j4 = c0.f1152q + 600;
        if (j3 < j4) {
            c0(accessibilityService, rVar, j4 - j3);
            return;
        }
        boolean z2 = false;
        if (System.currentTimeMillis() - c0.C[g.d.a(6)] >= 2000) {
            int size = arrayList.size();
            int i3 = 0;
            loop0: while (true) {
                if (i3 >= size) {
                    String[] strArr = {"android:id/switch_widget", "com.miui.settings:id/switch_widget", "android:id/switch_bar"};
                    int size2 = arrayList.size();
                    int i4 = 0;
                    loop2: while (i4 < size2) {
                        Object obj = arrayList.get(i4);
                        i4++;
                        AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
                        if (accessibilityNodeInfo != null) {
                            int i5 = 0;
                            while (true) {
                                if (i5 < 3) {
                                    try {
                                        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(strArr[i5]);
                                        if (listFindAccessibilityNodeInfosByViewId == null) {
                                            continue;
                                        } else {
                                            Iterator<AccessibilityNodeInfo> it = listFindAccessibilityNodeInfosByViewId.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    AccessibilityNodeInfo next = it.next();
                                                    if (next != null) {
                                                        try {
                                                            if (next.isVisibleToUser() && next.isEnabled() && (!next.isCheckable() || !next.isChecked())) {
                                                                if (O(next)) {
                                                                    Log.i("SampleGrantClicker", "skip shortcut switch (unchecked-switch path)");
                                                                } else if (f(rVar, next)) {
                                                                    a0(next);
                                                                    c0.i(6);
                                                                }
                                                            }
                                                        } catch (Throwable th) {
                                                            a0(next);
                                                            throw th;
                                                        }
                                                    }
                                                    a0(next);
                                                } else {
                                                    continue;
                                                }
                                            }
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                    i5++;
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                    break;
                }
                Object obj2 = arrayList.get(i3);
                i3++;
                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj2;
                if (accessibilityNodeInfo2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    h(accessibilityNodeInfo2, arrayList2);
                    try {
                        int size3 = arrayList2.size();
                        int i6 = 0;
                        while (true) {
                            if (i6 < size3) {
                                Object obj3 = arrayList2.get(i6);
                                i6++;
                                AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj3;
                                if (accessibilityNodeInfo3 == null) {
                                    zF = false;
                                } else {
                                    try {
                                        if (!accessibilityNodeInfo3.isVisibleToUser() || !accessibilityNodeInfo3.isEnabled() || !accessibilityNodeInfo3.isCheckable() || accessibilityNodeInfo3.isChecked()) {
                                            zF = false;
                                        } else if (O(accessibilityNodeInfo3)) {
                                            Log.i("SampleGrantClicker", "skip shortcut switch (unchecked-checkable path)");
                                            zF = false;
                                        } else {
                                            zF = f(rVar, accessibilityNodeInfo3);
                                        }
                                    } catch (Throwable unused3) {
                                    }
                                }
                                if (zF) {
                                    try {
                                        c0.i(6);
                                        a0(accessibilityNodeInfo3);
                                        arrayList2.clear();
                                    } catch (Throwable th2) {
                                        a0(accessibilityNodeInfo3);
                                        throw th2;
                                    }
                                } else {
                                    a0(accessibilityNodeInfo3);
                                }
                            } else {
                                arrayList2.clear();
                            }
                        }
                    } catch (Throwable th3) {
                        arrayList2.clear();
                        throw th3;
                    }
                }
                z2 = true;
                break;
            }
        }
        if (z2) {
            n = j3;
            Log.i("SampleGrantClicker", "clicked Switch class flag=WRITE");
            f1290i.postDelayed(new c2.d(accessibilityService, 7), 500L);
        }
    }

    public static boolean H(ArrayList arrayList, Predicate predicate) {
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            if (predicate.test(S((AccessibilityNodeInfo) obj))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x003f  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void I(AccessibilityService accessibilityService, int i3, x1.r rVar) {
        boolean zIsExternalStorageManager;
        AccessibilityNodeInfo rootInActiveWindow;
        if (accessibilityService == null) {
            return;
        }
        boolean zIsExternalStorageManager2 = false;
        try {
            zIsExternalStorageManager = Environment.isExternalStorageManager();
        } catch (Throwable unused) {
            zIsExternalStorageManager = false;
        }
        if (zIsExternalStorageManager) {
            c0.e(3);
            return;
        }
        String str = null;
        try {
            rootInActiveWindow = accessibilityService.getRootInActiveWindow();
            if (rootInActiveWindow != null) {
                try {
                    String str2 = Build.VERSION.SDK_INT < 34 ? "android.widget.Switch" : "android.view.View";
                    zIsExternalStorageManager2 = true;
                    if (h0(rVar, rootInActiveWindow, str2)) {
                        str = str2;
                    } else if (i0(rVar, rootInActiveWindow)) {
                        str = "switch";
                    } else {
                        zIsExternalStorageManager2 = false;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        Log.w("SampleGrantClicker", "i0: " + th.getMessage());
                    } catch (Throwable th2) {
                        a0(rootInActiveWindow);
                        throw th2;
                    }
                }
            } else {
                zIsExternalStorageManager2 = false;
            }
        } catch (Throwable th3) {
            th = th3;
            rootInActiveWindow = null;
        }
        a0(rootInActiveWindow);
        if (zIsExternalStorageManager2) {
            n = System.currentTimeMillis();
            Log.i("SampleGrantClicker", "i0 N0 class=" + str);
            f1290i.postDelayed(new c2.d(accessibilityService, 4), 250L);
        }
        try {
            zIsExternalStorageManager2 = Environment.isExternalStorageManager();
        } catch (Throwable unused2) {
        }
        if (zIsExternalStorageManager2 || i3 >= 3) {
            return;
        }
        f1290i.postDelayed(new l0(accessibilityService, rVar, i3), 1000L);
    }

    public static boolean J(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            try {
                if (accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && accessibilityNodeInfo.isCheckable() && accessibilityNodeInfo.isChecked()) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean K(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            try {
                if (accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && accessibilityNodeInfo.isCheckable() && !accessibilityNodeInfo.isChecked()) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean L(AccessibilityNodeInfo accessibilityNodeInfo) {
        try {
            if (accessibilityNodeInfo.isScrollable()) {
                return true;
            }
            CharSequence className = accessibilityNodeInfo.getClassName();
            if (className == null) {
                return false;
            }
            String string = className.toString();
            return string.contains("RecyclerView") || string.contains("ListView") || string.contains("ScrollView");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean M(AccessibilityService accessibilityService) {
        try {
            int i3 = Settings.Secure.getInt(accessibilityService.getContentResolver(), "screensaver_enabled", 0);
            String string = Settings.Secure.getString(accessibilityService.getContentResolver(), "screensaver_components");
            String strFlattenToString = "";
            try {
                strFlattenToString = new ComponentName(accessibilityService, (Class<?>) KeepAliveDreamService.class).flattenToString();
            } catch (Throwable unused) {
            }
            return r(i3, string, strFlattenToString);
        } catch (Throwable unused2) {
            return false;
        }
    }

    public static boolean N(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String lowerCase = str.trim().toLowerCase(Locale.ROOT);
        if (!str.isEmpty()) {
            String lowerCase2 = str.trim().toLowerCase();
            if (lowerCase2.equals("all files access") || lowerCase2.equals("all files") || lowerCase2.equals("所有文件访问权限") || lowerCase2.equals("所有文件访问") || lowerCase2.equals("acceso a todos los archivos")) {
                return true;
            }
        }
        return lowerCase.equals("usage access") || lowerCase.equals("usage data access") || lowerCase.equals("display over other apps") || lowerCase.equals("appear on top") || lowerCase.equals("modify system settings") || lowerCase.equals("can modify system settings") || lowerCase.equals("screensaver") || lowerCase.equals("screen saver") || lowerCase.equals("notification access") || lowerCase.equals("device & app notifications") || lowerCase.equals("app notifications") || lowerCase.equals("使用情况访问权限") || lowerCase.equals("使用情况访问") || lowerCase.equals("显示在其他应用的上层") || lowerCase.equals("修改系统设置") || lowerCase.equals("屏幕保护程序") || lowerCase.equals("通知使用权") || lowerCase.equals("设备和应用通知") || lowerCase.equals("应用通知") || lowerCase.equals("acceso de uso") || lowerCase.equals("mostrar sobre otras aplicaciones") || lowerCase.equals("modificar ajustes del sistema") || lowerCase.equals("acceso a notificaciones") || lowerCase.equals("notificaciones de aplicaciones");
    }

    public static boolean O(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = accessibilityNodeInfo == null ? null : AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
        int i3 = 0;
        while (accessibilityNodeInfoObtain != null && i3 <= 4) {
            try {
                if (f0(accessibilityNodeInfoObtain, 0, new int[]{0})) {
                    a0(accessibilityNodeInfoObtain);
                    return true;
                }
                AccessibilityNodeInfo parent = accessibilityNodeInfoObtain.getParent();
                a0(accessibilityNodeInfoObtain);
                i3++;
                accessibilityNodeInfoObtain = parent;
            } catch (Throwable unused) {
                a0(accessibilityNodeInfoObtain);
                return false;
            }
        }
        a0(accessibilityNodeInfoObtain);
        return false;
    }

    public static void P(ScreenMirrorService screenMirrorService, x1.r rVar, AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            long j3 = c2.p.e(screenMirrorService, "keepalive_notif_silencer").getLong("settings_open_attempted_at", 0L);
            if (j3 <= 0 || jCurrentTimeMillis - j3 > 60000 || l.x(screenMirrorService) || jCurrentTimeMillis - f1291j < 1500) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            try {
                ArrayList arrayListJ = j(screenMirrorService, accessibilityNodeInfo, accessibilityNodeInfo2, arrayList);
                if (!H(arrayListJ, new o0(0))) {
                    int size = arrayList.size();
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        a0((AccessibilityNodeInfo) obj);
                    }
                    return;
                }
                String strA = a(screenMirrorService);
                if (!strA.isEmpty() && X(arrayListJ).contains(strA)) {
                    AccessibilityNodeInfo accessibilityNodeInfoU = u(arrayListJ);
                    if (accessibilityNodeInfoU == null) {
                        int size2 = arrayList.size();
                        while (i3 < size2) {
                            Object obj2 = arrayList.get(i3);
                            i3++;
                            a0((AccessibilityNodeInfo) obj2);
                        }
                        return;
                    }
                    try {
                        boolean zE = f1282a.e(16, accessibilityNodeInfoU);
                        if (!zE && rVar != null) {
                            zE = rVar.f(accessibilityNodeInfoU);
                        }
                        if (!zE) {
                            a0(accessibilityNodeInfoU);
                            int size3 = arrayList.size();
                            while (i3 < size3) {
                                Object obj3 = arrayList.get(i3);
                                i3++;
                                a0((AccessibilityNodeInfo) obj3);
                            }
                            return;
                        }
                        f1291j = jCurrentTimeMillis;
                        n = jCurrentTimeMillis;
                        Log.i("SampleGrantClicker", "clicked silent keepalive channel switch");
                        f1290i.postDelayed(new t(screenMirrorService, 1), 700L);
                        a0(accessibilityNodeInfoU);
                        int size4 = arrayList.size();
                        while (i3 < size4) {
                            Object obj4 = arrayList.get(i3);
                            i3++;
                            a0((AccessibilityNodeInfo) obj4);
                        }
                        return;
                    } catch (Throwable th) {
                        a0(accessibilityNodeInfoU);
                        throw th;
                    }
                }
                int size5 = arrayList.size();
                while (i3 < size5) {
                    Object obj5 = arrayList.get(i3);
                    i3++;
                    a0((AccessibilityNodeInfo) obj5);
                }
            } catch (Throwable unused) {
                int size6 = arrayList.size();
                while (i3 < size6) {
                    Object obj6 = arrayList.get(i3);
                    i3++;
                    a0((AccessibilityNodeInfo) obj6);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void Q(Context context) {
        if (context == null || SystemClock.elapsedRealtime() >= 300000) {
            return;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable unused) {
        }
    }

    public static boolean R(x1.r rVar, ArrayList arrayList, String str) {
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo != null) {
                ArrayList arrayList2 = new ArrayList();
                i(accessibilityNodeInfo, str, arrayList2);
                try {
                    int size2 = arrayList2.size();
                    int i5 = 0;
                    while (i5 < size2) {
                        Object obj2 = arrayList2.get(i5);
                        i5++;
                        AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj2;
                        if (K(accessibilityNodeInfo2) && w(rVar, accessibilityNodeInfo2)) {
                            int size3 = arrayList2.size();
                            while (i3 < size3) {
                                Object obj3 = arrayList2.get(i3);
                                i3++;
                                a0((AccessibilityNodeInfo) obj3);
                            }
                            return true;
                        }
                    }
                    int size4 = arrayList2.size();
                    int i6 = 0;
                    while (i6 < size4) {
                        Object obj4 = arrayList2.get(i6);
                        i6++;
                        a0((AccessibilityNodeInfo) obj4);
                    }
                } catch (Throwable th) {
                    int size5 = arrayList2.size();
                    while (i3 < size5) {
                        Object obj5 = arrayList2.get(i3);
                        i3++;
                        a0((AccessibilityNodeInfo) obj5);
                    }
                    throw th;
                }
            }
        }
        return false;
    }

    public static String S(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return "";
        }
        try {
            CharSequence packageName = accessibilityNodeInfo.getPackageName();
            if (packageName != null) {
                return packageName.toString();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String T(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return "";
        }
        try {
            CharSequence text = accessibilityNodeInfo.getText();
            if (text != null && text.length() > 0) {
                return text.toString();
            }
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            if (contentDescription != null) {
                return contentDescription.toString();
            }
            return "";
        } catch (Throwable unused) {
        }
    }

    public static void U() {
        f1304x++;
        f1305y = 0;
    }

    public static boolean V(String str, String str2, String str3) {
        String strTrim;
        int iIndexOf;
        if (str != null && str2 != null && !str2.isEmpty() && !str3.isEmpty()) {
            for (String str4 : str.split(":")) {
                if (str4 != null && (iIndexOf = (strTrim = str4.trim()).indexOf(47)) > 0 && str2.equals(strTrim.substring(0, iIndexOf))) {
                    String strSubstring = strTrim.substring(iIndexOf + 1);
                    if (strSubstring.startsWith(".")) {
                        strSubstring = str2.concat(strSubstring);
                    }
                    if (str3.equals(strSubstring)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0073 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x000f A[SYNTHETIC] */
    public static boolean W(AccessibilityService accessibilityService, ArrayList arrayList) {
        boolean z2;
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText;
        String strA = accessibilityService == null ? "" : a(accessibilityService);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo != null) {
                try {
                    CharSequence packageName = accessibilityNodeInfo.getPackageName();
                    if (packageName != null && y1.l.a(packageName.toString()) && g0(accessibilityNodeInfo, 0, new int[]{0}, new b2.a(14))) {
                        if (strA != null && strA.trim().length() >= 2) {
                            try {
                                listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(strA);
                            } catch (Throwable unused) {
                                listFindAccessibilityNodeInfosByText = null;
                            }
                            if (listFindAccessibilityNodeInfosByText != null) {
                                z2 = !listFindAccessibilityNodeInfosByText.isEmpty();
                                Iterator<AccessibilityNodeInfo> it = listFindAccessibilityNodeInfosByText.iterator();
                                while (it.hasNext()) {
                                    a0(it.next());
                                }
                            }
                            if (z2) {
                                return true;
                            }
                        }
                        z2 = false;
                        if (z2) {
                            return true;
                        }
                    }
                } catch (Throwable unused2) {
                    continue;
                }
            }
        }
        return false;
    }

    public static String X(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            b((AccessibilityNodeInfo) obj, sb);
            if (sb.length() >= 12000) {
                break;
            }
        }
        return sb.toString();
    }

    public static boolean Y(Context context) {
        if (context == null) {
            return false;
        }
        try {
            int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.android.vending");
            return applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void Z(long j3, int i3, Runnable runnable) {
        f1290i.postDelayed(new h(i3, runnable), Math.max(0L, j3));
    }

    public static String a(AccessibilityService accessibilityService) {
        try {
            CharSequence charSequenceLoadLabel = accessibilityService.getApplicationInfo().loadLabel(accessibilityService.getPackageManager());
            return (charSequenceLoadLabel == null || charSequenceLoadLabel.length() <= 0) ? "" : charSequenceLoadLabel.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a0(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        try {
            accessibilityNodeInfo.recycle();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.view.accessibility.AccessibilityNodeInfo r3, java.lang.StringBuilder r4) {
        /*
            if (r3 == 0) goto L45
            int r0 = r4.length()
            r1 = 12000(0x2ee0, float:1.6816E-41)
            if (r0 < r1) goto Lb
            goto L45
        Lb:
            java.lang.String r0 = T(r3)     // Catch: java.lang.Throwable -> L45
            boolean r2 = r0.isEmpty()     // Catch: java.lang.Throwable -> L45
            if (r2 != 0) goto L23
            int r2 = r4.length()     // Catch: java.lang.Throwable -> L45
            if (r2 <= 0) goto L20
            r2 = 10
            r4.append(r2)     // Catch: java.lang.Throwable -> L45
        L20:
            r4.append(r0)     // Catch: java.lang.Throwable -> L45
        L23:
            r0 = 0
        L24:
            int r2 = r3.getChildCount()     // Catch: java.lang.Throwable -> L45
            if (r0 >= r2) goto L45
            int r2 = r4.length()     // Catch: java.lang.Throwable -> L45
            if (r2 >= r1) goto L45
            android.view.accessibility.AccessibilityNodeInfo r2 = r3.getChild(r0)     // Catch: java.lang.Throwable -> L45
            if (r2 != 0) goto L37
            goto L3d
        L37:
            b(r2, r4)     // Catch: java.lang.Throwable -> L40
            a0(r2)     // Catch: java.lang.Throwable -> L45
        L3d:
            int r0 = r0 + 1
            goto L24
        L40:
            r3 = move-exception
            a0(r2)     // Catch: java.lang.Throwable -> L45
            throw r3     // Catch: java.lang.Throwable -> L45
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.p0.b(android.view.accessibility.AccessibilityNodeInfo, java.lang.StringBuilder):void");
    }

    public static boolean b0(AccessibilityNodeInfo accessibilityNodeInfo) {
        StringBuilder sb = new StringBuilder(T(accessibilityNodeInfo));
        AccessibilityNodeInfo parent = null;
        try {
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            if (contentDescription != null) {
                sb.append(contentDescription);
            }
            parent = accessibilityNodeInfo.getParent();
            if (parent == null) {
                a0(parent);
                return false;
            }
            for (int i3 = 0; i3 < parent.getChildCount(); i3++) {
                AccessibilityNodeInfo child = parent.getChild(i3);
                if (child != null) {
                    try {
                        sb.append(T(child));
                        CharSequence contentDescription2 = child.getContentDescription();
                        if (contentDescription2 != null) {
                            sb.append(contentDescription2);
                        }
                        a0(child);
                    } catch (Throwable th) {
                        a0(child);
                        throw th;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        a0(parent);
        return sb.toString().trim().isEmpty();
    }

    public static boolean c(String str, boolean z2) {
        if (str != null && !str.isEmpty()) {
            for (String str2 : f1283b) {
                if (str2.equals(str)) {
                    return true;
                }
            }
            if (str.endsWith("Switch") || str.contains("SwitchCompat")) {
                return true;
            }
            if (!z2 && "android.view.View".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void c0(AccessibilityService accessibilityService, x1.r rVar, long j3) {
        if (accessibilityService != null) {
            f1295o = accessibilityService;
        }
        if (rVar != null) {
            f1296p = rVar;
        }
        if (accessibilityService != null) {
            k0.f1230j = accessibilityService;
        } else {
            Handler handler = k0.f1221a;
        }
        x1.x xVar = x1.x.f5960m;
        if (f1295o == null || !c0.k() || (xVar != null && xVar.h())) {
            synchronized (p0.class) {
                f1290i.removeCallbacks(f1292k);
                f1293l = 0L;
            }
            return;
        }
        long jMax = Math.max(50L, j3);
        long jUptimeMillis = SystemClock.uptimeMillis() + jMax;
        synchronized (p0.class) {
            try {
                long j4 = f1293l;
                if (j4 <= 0 || j4 > jUptimeMillis) {
                    Handler handler2 = f1290i;
                    d2.r rVar2 = f1292k;
                    handler2.removeCallbacks(rVar2);
                    f1293l = jUptimeMillis;
                    handler2.postDelayed(rVar2, jMax);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean d(x1.r rVar, ArrayList arrayList, boolean z2) {
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo != null && !x1.r.m(accessibilityNodeInfo)) {
                for (String str : f1285d) {
                    if (z2 || (!"android:id/button1".equals(str) && !"com.android.settings:id/left_button".equals(str) && !"miui:id/button2".equals(str) && !"miui:id/action_positive".equals(str))) {
                        try {
                            List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str);
                            if (listFindAccessibilityNodeInfosByViewId == null) {
                                continue;
                            } else {
                                for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByViewId) {
                                    if (accessibilityNodeInfo2 != null) {
                                        try {
                                            if (accessibilityNodeInfo2.isVisibleToUser() && accessibilityNodeInfo2.isEnabled()) {
                                                if (O(accessibilityNodeInfo2)) {
                                                    Log.i("SampleGrantClicker", "skip shortcut control (allow-id path)");
                                                } else if (f(rVar, accessibilityNodeInfo2)) {
                                                    a0(accessibilityNodeInfo2);
                                                    return true;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            a0(accessibilityNodeInfo2);
                                            throw th;
                                        }
                                    }
                                    a0(accessibilityNodeInfo2);
                                }
                            }
                        } catch (Throwable unused) {
                            continue;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean d0(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        try {
            if (accessibilityNodeInfo.isScrollable() && f1282a.e(4096, accessibilityNodeInfo)) {
                return true;
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i3);
                if (child != null) {
                    try {
                        if (d0(child)) {
                            return true;
                        }
                        a0(child);
                    } finally {
                        a0(child);
                    }
                }
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    public static boolean e(x1.r rVar, ArrayList arrayList, String[] strArr) {
        int i3 = c0.D;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo != null) {
                for (String str : strArr) {
                    try {
                        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
                        if (listFindAccessibilityNodeInfosByText == null) {
                            continue;
                        } else {
                            for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByText) {
                                try {
                                    String strT = T(accessibilityNodeInfo2);
                                    if (!N(strT) && (i3 == 1 || e0(strT, i3) || j0(strT, str))) {
                                        AccessibilityNodeInfo accessibilityNodeInfoG = g(accessibilityNodeInfo2);
                                        if (accessibilityNodeInfoG != null && O(accessibilityNodeInfoG)) {
                                            Log.i("SampleGrantClicker", "skip shortcut row (hint path)");
                                            if (accessibilityNodeInfoG != accessibilityNodeInfo2) {
                                                a0(accessibilityNodeInfoG);
                                            }
                                        } else {
                                            if (accessibilityNodeInfoG != null && f(rVar, accessibilityNodeInfoG)) {
                                                if (accessibilityNodeInfoG != accessibilityNodeInfo2) {
                                                    a0(accessibilityNodeInfoG);
                                                }
                                                a0(accessibilityNodeInfo2);
                                                return true;
                                            }
                                            if (accessibilityNodeInfoG != null && accessibilityNodeInfoG != accessibilityNodeInfo2) {
                                                a0(accessibilityNodeInfoG);
                                            }
                                        }
                                    }
                                    a0(accessibilityNodeInfo2);
                                } catch (Throwable th) {
                                    a0(accessibilityNodeInfo2);
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return false;
    }

    public static boolean e0(String str, int i3) {
        if (i3 != 0 && i3 != 1 && str != null && !str.isEmpty() && !N(str) && i3 != 5 && i3 != 2) {
            if (i3 != 8) {
                String lowerCase = str.trim().toLowerCase(Locale.ROOT);
                for (String str2 : f1286e) {
                    if (lowerCase.contains(str2.toLowerCase(Locale.ROOT))) {
                        return true;
                    }
                }
                if (i3 == 3) {
                    String[] strArr = {"Allow permission", "Allow access to manage all files", "允许访问所有文件", "允许管理所有文件", "Permitir permiso", "Permitir acceso para gestionar todos los archivos"};
                    for (int i4 = 0; i4 < 6; i4++) {
                        if (!lowerCase.equals(strArr[i4].toLowerCase(Locale.ROOT))) {
                        }
                    }
                }
                return true;
            }
            if ("updates".equals(str.trim().toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
    
        if (r0.e(16, r6) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean f(x1.r r5, android.view.accessibility.AccessibilityNodeInfo r6) {
        /*
            d0.d r0 = f2.p0.f1282a
            boolean r1 = O(r6)
            r2 = 0
            if (r1 == 0) goto L11
            java.lang.String r5 = "SampleGrantClicker"
            java.lang.String r6 = "skip shortcut control (clickNode)"
            android.util.Log.i(r5, r6)
            return r2
        L11:
            r1 = 16
            r3 = 1
            boolean r4 = r6.isCheckable()     // Catch: java.lang.Throwable -> L36
            if (r4 == 0) goto L36
            boolean r4 = r6.isChecked()     // Catch: java.lang.Throwable -> L36
            if (r4 == 0) goto L21
            goto L35
        L21:
            boolean r4 = r6.isClickable()     // Catch: java.lang.Throwable -> L36
            if (r4 == 0) goto L2c
            boolean r5 = r0.e(r1, r6)     // Catch: java.lang.Throwable -> L36
            return r5
        L2c:
            if (r5 == 0) goto L35
            boolean r5 = r5.f(r6)     // Catch: java.lang.Throwable -> L36
            if (r5 == 0) goto L35
            goto L3c
        L35:
            return r2
        L36:
            boolean r0 = r0.e(r1, r6)     // Catch: java.lang.Throwable -> L3d
            if (r0 == 0) goto L3d
        L3c:
            return r3
        L3d:
            if (r5 == 0) goto L47
            boolean r5 = r5.f(r6)     // Catch: java.lang.Throwable -> L47
            if (r5 == 0) goto L47
            r2 = r3
        L47:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.p0.f(x1.r, android.view.accessibility.AccessibilityNodeInfo):boolean");
    }

    public static boolean f0(AccessibilityNodeInfo accessibilityNodeInfo, int i3, int[] iArr) {
        if (i3 <= 6) {
            int i4 = iArr[0];
            iArr[0] = i4 + 1;
            if (i4 < 120) {
                try {
                    if (y1.j.k(accessibilityNodeInfo.getViewIdResourceName(), accessibilityNodeInfo.getText(), accessibilityNodeInfo.getContentDescription())) {
                        return true;
                    }
                    int iMin = Math.min(accessibilityNodeInfo.getChildCount(), 24);
                    for (int i5 = 0; i5 < iMin; i5++) {
                        AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i5);
                        if (child != null) {
                            try {
                                if (f0(child, i3 + 1, iArr)) {
                                    return true;
                                }
                                a0(child);
                            } finally {
                                a0(child);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    public static AccessibilityNodeInfo g(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i3 = 0;
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        AccessibilityNodeInfo parent = accessibilityNodeInfo;
        while (parent != null && i3 < 8) {
            try {
                if (parent.isClickable() && parent.isEnabled() && parent.isVisibleToUser()) {
                    return parent == accessibilityNodeInfo ? accessibilityNodeInfo : parent;
                }
            } catch (Throwable unused) {
            }
            try {
                parent = parent.getParent();
                if (accessibilityNodeInfo2 != null && accessibilityNodeInfo2 != accessibilityNodeInfo) {
                    a0(accessibilityNodeInfo2);
                }
                i3++;
                accessibilityNodeInfo2 = parent;
            } catch (Throwable unused2) {
            }
        }
        if (accessibilityNodeInfo2 != null && accessibilityNodeInfo2 != accessibilityNodeInfo) {
            a0(accessibilityNodeInfo2);
        }
        return accessibilityNodeInfo;
    }

    public static boolean g0(AccessibilityNodeInfo accessibilityNodeInfo, int i3, int[] iArr, b2.a aVar) {
        if (i3 <= 8) {
            int i4 = iArr[0];
            iArr[0] = i4 + 1;
            if (i4 < 220) {
                try {
                    String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
                    String str = y1.j.f6206a;
                    if (viewIdResourceName != null && !viewIdResourceName.isEmpty()) {
                        String lowerCase = viewIdResourceName.toLowerCase(Locale.ROOT);
                        if (y1.j.f6218m.contains(lowerCase) || y1.j.f6217l.contains(lowerCase)) {
                            return true;
                        }
                    }
                    int iMin = Math.min(accessibilityNodeInfo.getChildCount(), 40);
                    for (int i5 = 0; i5 < iMin; i5++) {
                        AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i5);
                        if (child != null) {
                            try {
                                if (g0(child, i3 + 1, iArr, aVar)) {
                                    return true;
                                }
                                a0(child);
                            } finally {
                                a0(child);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void h(android.view.accessibility.AccessibilityNodeInfo r3, java.util.ArrayList r4) {
        /*
            java.lang.CharSequence r0 = r3.getClassName()     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto L18
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L34
            r1 = 1
            boolean r0 = c(r0, r1)     // Catch: java.lang.Throwable -> L34
            if (r0 == 0) goto L18
            android.view.accessibility.AccessibilityNodeInfo r0 = android.view.accessibility.AccessibilityNodeInfo.obtain(r3)     // Catch: java.lang.Throwable -> L34
            r4.add(r0)     // Catch: java.lang.Throwable -> L34
        L18:
            int r0 = r3.getChildCount()     // Catch: java.lang.Throwable -> L34
            r1 = 0
        L1d:
            if (r1 >= r0) goto L34
            android.view.accessibility.AccessibilityNodeInfo r2 = r3.getChild(r1)     // Catch: java.lang.Throwable -> L34
            if (r2 != 0) goto L26
            goto L2c
        L26:
            h(r2, r4)     // Catch: java.lang.Throwable -> L2f
            a0(r2)     // Catch: java.lang.Throwable -> L34
        L2c:
            int r1 = r1 + 1
            goto L1d
        L2f:
            r3 = move-exception
            a0(r2)     // Catch: java.lang.Throwable -> L34
            throw r3     // Catch: java.lang.Throwable -> L34
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.p0.h(android.view.accessibility.AccessibilityNodeInfo, java.util.ArrayList):void");
    }

    public static boolean h0(x1.r rVar, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        ArrayList arrayList = new ArrayList();
        i(accessibilityNodeInfo, str, arrayList);
        int i3 = 0;
        try {
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
                if (K(accessibilityNodeInfo2) && w(rVar, accessibilityNodeInfo2)) {
                    int size2 = arrayList.size();
                    while (i3 < size2) {
                        Object obj2 = arrayList.get(i3);
                        i3++;
                        a0((AccessibilityNodeInfo) obj2);
                    }
                    return true;
                }
            }
            int size3 = arrayList.size();
            int i5 = 0;
            while (i5 < size3) {
                Object obj3 = arrayList.get(i5);
                i5++;
                a0((AccessibilityNodeInfo) obj3);
            }
            return false;
        } catch (Throwable th) {
            int size4 = arrayList.size();
            while (i3 < size4) {
                Object obj4 = arrayList.get(i3);
                i3++;
                a0((AccessibilityNodeInfo) obj4);
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void i(android.view.accessibility.AccessibilityNodeInfo r3, java.lang.String r4, java.util.ArrayList r5) {
        /*
            java.lang.CharSequence r0 = r3.getClassName()     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L17
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L33
            boolean r0 = r4.equals(r0)     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L17
            android.view.accessibility.AccessibilityNodeInfo r0 = android.view.accessibility.AccessibilityNodeInfo.obtain(r3)     // Catch: java.lang.Throwable -> L33
            r5.add(r0)     // Catch: java.lang.Throwable -> L33
        L17:
            int r0 = r3.getChildCount()     // Catch: java.lang.Throwable -> L33
            r1 = 0
        L1c:
            if (r1 >= r0) goto L33
            android.view.accessibility.AccessibilityNodeInfo r2 = r3.getChild(r1)     // Catch: java.lang.Throwable -> L33
            if (r2 != 0) goto L25
            goto L2b
        L25:
            i(r2, r4, r5)     // Catch: java.lang.Throwable -> L2e
            a0(r2)     // Catch: java.lang.Throwable -> L33
        L2b:
            int r1 = r1 + 1
            goto L1c
        L2e:
            r3 = move-exception
            a0(r2)     // Catch: java.lang.Throwable -> L33
            throw r3     // Catch: java.lang.Throwable -> L33
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.p0.i(android.view.accessibility.AccessibilityNodeInfo, java.lang.String, java.util.ArrayList):void");
    }

    public static boolean i0(x1.r rVar, AccessibilityNodeInfo accessibilityNodeInfo) {
        ArrayList arrayList = new ArrayList();
        h(accessibilityNodeInfo, arrayList);
        int i3 = 0;
        try {
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
                if (K(accessibilityNodeInfo2) && w(rVar, accessibilityNodeInfo2)) {
                    int size2 = arrayList.size();
                    while (i3 < size2) {
                        Object obj2 = arrayList.get(i3);
                        i3++;
                        a0((AccessibilityNodeInfo) obj2);
                    }
                    return true;
                }
            }
            int size3 = arrayList.size();
            int i5 = 0;
            while (i5 < size3) {
                Object obj3 = arrayList.get(i5);
                i5++;
                a0((AccessibilityNodeInfo) obj3);
            }
            return false;
        } catch (Throwable th) {
            int size4 = arrayList.size();
            while (i3 < size4) {
                Object obj4 = arrayList.get(i3);
                i3++;
                a0((AccessibilityNodeInfo) obj4);
            }
            throw th;
        }
    }

    public static ArrayList j(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (accessibilityNodeInfo2 != null) {
            arrayList2.add(accessibilityNodeInfo2);
        }
        if (accessibilityNodeInfo != null) {
            arrayList2.add(accessibilityNodeInfo);
        }
        try {
            List<AccessibilityWindowInfo> windows = accessibilityService.getWindows();
            if (windows != null) {
                for (AccessibilityWindowInfo accessibilityWindowInfo : windows) {
                    if (accessibilityWindowInfo != null && accessibilityWindowInfo.getType() != 4) {
                        try {
                            AccessibilityNodeInfo root = accessibilityWindowInfo.getRoot();
                            if (root != null) {
                                arrayList.add(root);
                                arrayList2.add(root);
                            } else {
                                continue;
                            }
                        } catch (Throwable unused) {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return arrayList2;
    }

    public static boolean j0(String str, String str2) {
        return (str == null || str2 == null || !str.trim().equalsIgnoreCase(str2.trim())) ? false : true;
    }

    public static void k(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList) {
        try {
            CharSequence className = accessibilityNodeInfo.getClassName();
            if (className != null && c(className.toString(), false) && accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && accessibilityNodeInfo.isCheckable()) {
                arrayList.add(AccessibilityNodeInfo.obtain(accessibilityNodeInfo));
            }
            for (int i3 = 0; i3 < accessibilityNodeInfo.getChildCount(); i3++) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i3);
                if (child != null) {
                    try {
                        k(child, arrayList);
                        a0(child);
                    } catch (Throwable th) {
                        a0(child);
                        throw th;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void l(int i3, long j3, AccessibilityService accessibilityService) {
        c0.e(i3);
        c2.d dVar = new c2.d(accessibilityService, 3);
        if (j3 <= 0) {
            dVar.run();
        } else {
            f1290i.postDelayed(dVar, j3);
        }
    }

    public static boolean m(AccessibilityService accessibilityService, long j3) {
        if (j3 <= 0 || f1303w == j3) {
            return false;
        }
        f1303w = j3;
        f1290i.postDelayed(new m0(1, j3, accessibilityService), 250L);
        return true;
    }

    public static boolean n(String str, String str2) {
        if (str2 == null || str2.trim().isEmpty()) {
            return false;
        }
        Locale locale = Locale.ROOT;
        return str.toLowerCase(locale).contains(str2.trim().toLowerCase(locale));
    }

    public static boolean o(String str, String str2, String str3, String str4) {
        if (str.trim().isEmpty()) {
            return false;
        }
        return n(str, str3) || n(str, str2) || n(str, str4);
    }

    public static int p(int i3, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (i3 <= 0) {
            return 0;
        }
        try {
            CharSequence className = accessibilityNodeInfo.getClassName();
            int iP = (className != null && c(className.toString(), false) && accessibilityNodeInfo.isVisibleToUser() && accessibilityNodeInfo.isEnabled() && accessibilityNodeInfo.isCheckable()) ? 1 : 0;
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount() && iP < i3; i4++) {
                try {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                    if (child != null) {
                        try {
                            iP += p(i3 - iP, child);
                            a0(child);
                        } catch (Throwable th) {
                            a0(child);
                            throw th;
                        }
                    }
                } catch (Throwable unused) {
                    return iP;
                }
            }
            return iP;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static ArrayList q(AccessibilityService accessibilityService) {
        ArrayList arrayList = new ArrayList();
        if (accessibilityService != null) {
            try {
                AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
                if (rootInActiveWindow != null) {
                    arrayList.add(rootInActiveWindow);
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public static boolean r(int i3, String str, String str2) {
        if (i3 != 0 && str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
            for (String str3 : str.split(",")) {
                if (str3 != null && str2.equals(str3.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:250:0x0381  */
    /* JADX WARN: Code duplicated, block: B:276:0x03d6 A[Catch: all -> 0x0220, TRY_ENTER, TryCatch #0 {all -> 0x0220, blocks: (B:153:0x021b, B:167:0x024b, B:169:0x024f, B:178:0x0276, B:180:0x027a, B:189:0x02a1, B:192:0x02a9, B:204:0x02d7, B:207:0x02df, B:209:0x02e5, B:210:0x02e8, B:221:0x0313, B:223:0x0319, B:225:0x031f, B:226:0x0322, B:236:0x034b, B:238:0x0351, B:240:0x0357, B:241:0x035a, B:251:0x0383, B:253:0x038b, B:255:0x0391, B:256:0x0394, B:258:0x0398, B:259:0x039b, B:261:0x039f, B:262:0x03a2, B:264:0x03a6, B:267:0x03ad, B:266:0x03aa, B:276:0x03d6, B:278:0x03da, B:146:0x01fb, B:148:0x0209, B:150:0x0211, B:151:0x0215), top: B:315:0x01da }] */
    /* JADX WARN: Code duplicated, block: B:278:0x03da A[Catch: all -> 0x0220, TRY_LEAVE, TryCatch #0 {all -> 0x0220, blocks: (B:153:0x021b, B:167:0x024b, B:169:0x024f, B:178:0x0276, B:180:0x027a, B:189:0x02a1, B:192:0x02a9, B:204:0x02d7, B:207:0x02df, B:209:0x02e5, B:210:0x02e8, B:221:0x0313, B:223:0x0319, B:225:0x031f, B:226:0x0322, B:236:0x034b, B:238:0x0351, B:240:0x0357, B:241:0x035a, B:251:0x0383, B:253:0x038b, B:255:0x0391, B:256:0x0394, B:258:0x0398, B:259:0x039b, B:261:0x039f, B:262:0x03a2, B:264:0x03a6, B:267:0x03ad, B:266:0x03aa, B:276:0x03d6, B:278:0x03da, B:146:0x01fb, B:148:0x0209, B:150:0x0211, B:151:0x0215), top: B:315:0x01da }] */
    /* JADX WARN: Code duplicated, block: B:288:0x0404  */
    /* JADX WARN: Code duplicated, block: B:290:0x040c A[LOOP:14: B:289:0x040a->B:290:0x040c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:293:0x041e  */
    /* JADX WARN: Code duplicated, block: B:369:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x00f2 A[PHI: r3
  0x00f2: PHI (r3v52 long) = 
  (r3v6 long)
  (r3v9 long)
  (r3v12 long)
  (r3v15 long)
  (r3v18 long)
  (r3v21 long)
  (r3v24 long)
  (r3v27 long)
  (r3v30 long)
  (r3v33 long)
  (r3v36 long)
  (r3v39 long)
  (r3v42 long)
  (r3v45 long)
  (r3v48 long)
  (r3v54 long)
 binds: [B:164:0x0243, B:294:0x0424, B:286:0x0400, B:274:0x03d2, B:248:0x037d, B:233:0x0345, B:217:0x030b, B:199:0x02ce, B:187:0x029d, B:176:0x0272, B:134:0x01d1, B:123:0x01a7, B:112:0x017d, B:101:0x0154, B:88:0x0126, B:74:0x00f0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    public static void s(AccessibilityService accessibilityService, x1.r rVar, AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) throws Throwable {
        int i3;
        int i4;
        boolean zX;
        long jH;
        int size;
        int i5;
        PowerManager powerManager;
        boolean zIsExternalStorageManager;
        x1.x xVar = x1.x.f5960m;
        if (accessibilityService == null || !c0.k()) {
            return;
        }
        if (xVar != null && xVar.h()) {
            return;
        }
        EngineService.d(accessibilityService, "f0_event");
        try {
            if (c0.f1138b) {
                try {
                    zIsExternalStorageManager = Environment.isExternalStorageManager();
                } catch (Throwable unused) {
                    zIsExternalStorageManager = false;
                }
                if (zIsExternalStorageManager) {
                    c0.e(3);
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            if ((c0.f1140d || c0.f1141e) && Settings.canDrawOverlays(accessibilityService)) {
                c0.e(4);
                U();
            }
        } catch (Throwable unused3) {
        }
        try {
            if (c0.f1139c && Settings.System.canWrite(accessibilityService)) {
                c0.e(6);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (c0.f1146j && (powerManager = (PowerManager) accessibilityService.getSystemService("power")) != null && powerManager.isIgnoringBatteryOptimizations(accessibilityService.getPackageName())) {
                c0.e(9);
            }
        } catch (Throwable unused5) {
        }
        try {
            if (c0.f1142f && Y(accessibilityService)) {
                c0.e(10);
            }
        } catch (Throwable unused6) {
        }
        try {
            if (c0.f1145i && M(accessibilityService)) {
                c0.e(7);
            }
        } catch (Throwable unused7) {
        }
        try {
            if (c0.n && w1.n.D(accessibilityService)) {
                c0.e(11);
            }
        } catch (Throwable unused8) {
        }
        if (!c0.k()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!c0.n && jCurrentTimeMillis - n < 800) {
            c0(accessibilityService, rVar, 800 - (jCurrentTimeMillis - n));
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList arrayListJ = j(accessibilityService, accessibilityNodeInfo, accessibilityNodeInfo2, arrayList);
            if (c0.f1137a) {
                D(accessibilityService, rVar, arrayListJ, jCurrentTimeMillis);
                int size2 = arrayList.size();
                int i6 = 0;
                while (i6 < size2) {
                    Object obj = arrayList.get(i6);
                    i6++;
                    a0((AccessibilityNodeInfo) obj);
                }
                if (!c0.k()) {
                    return;
                }
                jH = c0.h(jCurrentTimeMillis);
                if (c0.f1151p) {
                    jH = Math.max(jH, 300L);
                }
            } else if (c0.n) {
                y(accessibilityService, arrayListJ);
                int size3 = arrayList.size();
                int i7 = 0;
                while (i7 < size3) {
                    Object obj2 = arrayList.get(i7);
                    i7++;
                    a0((AccessibilityNodeInfo) obj2);
                }
                if (!c0.k()) {
                    return;
                }
                jH = c0.h(jCurrentTimeMillis);
                if (c0.f1151p) {
                    jH = Math.max(jH, 300L);
                }
            } else if (c0.f1145i) {
                if (A(accessibilityService, rVar, arrayListJ)) {
                    n = jCurrentTimeMillis;
                }
                int size4 = arrayList.size();
                int i8 = 0;
                while (i8 < size4) {
                    Object obj3 = arrayList.get(i8);
                    i8++;
                    a0((AccessibilityNodeInfo) obj3);
                }
                if (!c0.k()) {
                    return;
                }
                jH = c0.h(jCurrentTimeMillis);
                if (c0.f1151p) {
                    jH = Math.max(jH, 300L);
                }
            } else if (c0.f1142f) {
                F(accessibilityService, rVar, arrayListJ, jCurrentTimeMillis);
                int size5 = arrayList.size();
                int i9 = 0;
                while (i9 < size5) {
                    Object obj4 = arrayList.get(i9);
                    i9++;
                    a0((AccessibilityNodeInfo) obj4);
                }
                if (!c0.k()) {
                    return;
                }
                jH = c0.h(jCurrentTimeMillis);
                if (c0.f1151p) {
                    jH = Math.max(jH, 300L);
                }
            } else if (c0.f1138b) {
                B(accessibilityService, rVar, arrayListJ, accessibilityNodeInfo);
                int size6 = arrayList.size();
                int i10 = 0;
                while (i10 < size6) {
                    Object obj5 = arrayList.get(i10);
                    i10++;
                    a0((AccessibilityNodeInfo) obj5);
                }
                if (!c0.k()) {
                    return;
                }
                jH = c0.h(jCurrentTimeMillis);
                if (c0.f1151p) {
                    jH = Math.max(jH, 300L);
                }
            } else if (c0.f1139c) {
                G(accessibilityService, rVar, arrayListJ, jCurrentTimeMillis);
                int size7 = arrayList.size();
                int i11 = 0;
                while (i11 < size7) {
                    Object obj6 = arrayList.get(i11);
                    i11++;
                    a0((AccessibilityNodeInfo) obj6);
                }
                if (!c0.k()) {
                    return;
                }
                jH = c0.h(jCurrentTimeMillis);
                if (c0.f1151p) {
                    jH = Math.max(jH, 300L);
                }
            } else {
                try {
                    if (c0.f1140d) {
                        try {
                            if (Settings.canDrawOverlays(accessibilityService)) {
                                c0.e(4);
                                U();
                                Q(accessibilityService);
                                i3 = 4;
                                zX = false;
                                i4 = 0;
                            } else {
                                i3 = 4;
                                i4 = 0;
                                if (!c0.f1141e) {
                                    c0.f1141e = true;
                                    f1304x++;
                                    f1305y = 0;
                                    c0(accessibilityService, rVar, 1500L);
                                } else if (jCurrentTimeMillis < c0.f1152q + 1500) {
                                    c0(accessibilityService, rVar, 1500L);
                                } else {
                                    zX = x(accessibilityService, rVar, arrayListJ, true);
                                }
                                zX = true;
                            }
                        } catch (Throwable unused9) {
                        }
                        if (zX || c0.f1140d) {
                            int size8 = arrayList.size();
                            int i12 = i4;
                            while (i12 < size8) {
                                Object obj7 = arrayList.get(i12);
                                i12++;
                                a0((AccessibilityNodeInfo) obj7);
                            }
                            if (!c0.k()) {
                                return;
                            }
                            jH = c0.h(jCurrentTimeMillis);
                            if (c0.f1151p) {
                                jH = Math.max(jH, 300L);
                            }
                        }
                    } else {
                        i3 = 4;
                        i4 = 0;
                    }
                    if (c0.f1143g) {
                        C(accessibilityService, rVar, arrayListJ, jCurrentTimeMillis);
                        int size9 = arrayList.size();
                        int i13 = i4;
                        while (i13 < size9) {
                            Object obj8 = arrayList.get(i13);
                            i13++;
                            a0((AccessibilityNodeInfo) obj8);
                        }
                        if (!c0.k()) {
                            return;
                        }
                        jH = c0.h(jCurrentTimeMillis);
                        if (c0.f1151p) {
                            jH = Math.max(jH, 300L);
                        }
                    } else if (c0.f1151p) {
                        E(accessibilityService, rVar, arrayListJ, jCurrentTimeMillis);
                        int size10 = arrayList.size();
                        int i14 = i4;
                        while (i14 < size10) {
                            Object obj9 = arrayList.get(i14);
                            i14++;
                            a0((AccessibilityNodeInfo) obj9);
                        }
                        if (!c0.k()) {
                            return;
                        }
                        jH = c0.h(jCurrentTimeMillis);
                        if (c0.f1151p) {
                            jH = Math.max(jH, 300L);
                        }
                    } else if (W(accessibilityService, arrayListJ)) {
                        Log.i("SampleGrantClicker", "own a11y detail page visible — skip generic clicks");
                        int size11 = arrayList.size();
                        int i15 = i4;
                        while (i15 < size11) {
                            Object obj10 = arrayList.get(i15);
                            i15++;
                            a0((AccessibilityNodeInfo) obj10);
                        }
                        if (!c0.k()) {
                            return;
                        }
                        jH = c0.h(jCurrentTimeMillis);
                        if (c0.f1151p) {
                            jH = Math.max(jH, 300L);
                        }
                    } else {
                        if (d(rVar, arrayListJ, accessibilityNodeInfo2 == null ? i4 : 1)) {
                            n = jCurrentTimeMillis;
                            if (c0.f1146j) {
                                c0.e(9);
                            }
                            Log.i("SampleGrantClicker", "clicked Allow id");
                            int size12 = arrayList.size();
                            int i16 = i4;
                            while (i16 < size12) {
                                Object obj11 = arrayList.get(i16);
                                i16++;
                                a0((AccessibilityNodeInfo) obj11);
                            }
                            if (!c0.k()) {
                                return;
                            }
                            jH = c0.h(jCurrentTimeMillis);
                            if (c0.f1151p) {
                                jH = Math.max(jH, 300L);
                            }
                        } else if (rVar == null) {
                            if (accessibilityNodeInfo2 == null && e(rVar, arrayListJ, f1286e)) {
                                n = jCurrentTimeMillis;
                                if (c0.f1146j) {
                                    c0.e(9);
                                }
                                if (c0.f1138b) {
                                    c0.i(3);
                                }
                                if (c0.f1139c) {
                                    c0.i(6);
                                }
                                if (c0.f1140d || c0.f1141e) {
                                    c0.i(i3);
                                }
                                Log.i("SampleGrantClicker", "clicked Allow text");
                                int size13 = arrayList.size();
                                int i17 = i4;
                                while (i17 < size13) {
                                    Object obj12 = arrayList.get(i17);
                                    i17++;
                                    a0((AccessibilityNodeInfo) obj12);
                                }
                                if (!c0.k()) {
                                    return;
                                }
                                jH = c0.h(jCurrentTimeMillis);
                                if (c0.f1151p) {
                                    jH = Math.max(jH, 300L);
                                }
                            } else if (c0.f1146j || !z(accessibilityService, rVar, arrayListJ, jCurrentTimeMillis)) {
                                size = arrayList.size();
                                i5 = i4;
                                while (i5 < size) {
                                    Object obj13 = arrayList.get(i5);
                                    i5++;
                                    a0((AccessibilityNodeInfo) obj13);
                                }
                                if (!c0.k()) {
                                    return;
                                }
                                jH = c0.h(jCurrentTimeMillis);
                                if (c0.f1151p) {
                                    jH = Math.max(jH, 300L);
                                }
                            } else {
                                int size14 = arrayList.size();
                                int i18 = i4;
                                while (i18 < size14) {
                                    Object obj14 = arrayList.get(i18);
                                    i18++;
                                    a0((AccessibilityNodeInfo) obj14);
                                }
                                if (!c0.k()) {
                                    return;
                                }
                                jH = c0.h(jCurrentTimeMillis);
                                if (c0.f1151p) {
                                    jH = Math.max(jH, 300L);
                                }
                            }
                        } else if (accessibilityNodeInfo != null && rVar.l(accessibilityNodeInfo)) {
                            n = jCurrentTimeMillis;
                            if (c0.f1146j) {
                                c0.e(9);
                            }
                            Log.i("SampleGrantClicker", "clicked Allow id");
                            int size15 = arrayList.size();
                            int i19 = i4;
                            while (i19 < size15) {
                                Object obj15 = arrayList.get(i19);
                                i19++;
                                a0((AccessibilityNodeInfo) obj15);
                            }
                            if (!c0.k()) {
                                return;
                            }
                            jH = c0.h(jCurrentTimeMillis);
                            if (c0.f1151p) {
                                jH = Math.max(jH, 300L);
                            }
                        } else if (accessibilityNodeInfo2 != null && rVar.e(accessibilityNodeInfo2)) {
                            n = jCurrentTimeMillis;
                            if (c0.f1146j) {
                                c0.e(9);
                            }
                            Log.i("SampleGrantClicker", "clicked Allow id");
                            int size16 = arrayList.size();
                            int i20 = i4;
                            while (i20 < size16) {
                                Object obj16 = arrayList.get(i20);
                                i20++;
                                a0((AccessibilityNodeInfo) obj16);
                            }
                            if (!c0.k()) {
                                return;
                            }
                            jH = c0.h(jCurrentTimeMillis);
                            if (c0.f1151p) {
                                jH = Math.max(jH, 300L);
                            }
                        } else if (accessibilityNodeInfo2 == null) {
                            if (c0.f1146j) {
                                size = arrayList.size();
                                i5 = i4;
                                while (i5 < size) {
                                    Object obj17 = arrayList.get(i5);
                                    i5++;
                                    a0((AccessibilityNodeInfo) obj17);
                                }
                                if (!c0.k()) {
                                    return;
                                }
                                jH = c0.h(jCurrentTimeMillis);
                                if (c0.f1151p) {
                                    jH = Math.max(jH, 300L);
                                }
                            } else {
                                size = arrayList.size();
                                i5 = i4;
                                while (i5 < size) {
                                    Object obj18 = arrayList.get(i5);
                                    i5++;
                                    a0((AccessibilityNodeInfo) obj18);
                                }
                                if (!c0.k()) {
                                    return;
                                }
                                jH = c0.h(jCurrentTimeMillis);
                                if (c0.f1151p) {
                                    jH = Math.max(jH, 300L);
                                }
                            }
                        } else if (c0.f1146j) {
                            size = arrayList.size();
                            i5 = i4;
                            while (i5 < size) {
                                Object obj19 = arrayList.get(i5);
                                i5++;
                                a0((AccessibilityNodeInfo) obj19);
                            }
                            if (!c0.k()) {
                                return;
                            }
                            jH = c0.h(jCurrentTimeMillis);
                            if (c0.f1151p) {
                                jH = Math.max(jH, 300L);
                            }
                        } else {
                            size = arrayList.size();
                            i5 = i4;
                            while (i5 < size) {
                                Object obj110 = arrayList.get(i5);
                                i5++;
                                a0((AccessibilityNodeInfo) obj110);
                            }
                            if (!c0.k()) {
                                return;
                            }
                            jH = c0.h(jCurrentTimeMillis);
                            if (c0.f1151p) {
                                jH = Math.max(jH, 300L);
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    int size17 = arrayList.size();
                    int i21 = 0;
                    while (i21 < size17) {
                        Object obj20 = arrayList.get(i21);
                        i21++;
                        a0((AccessibilityNodeInfo) obj20);
                    }
                    if (c0.k()) {
                        long jH2 = c0.h(jCurrentTimeMillis);
                        if (c0.f1151p) {
                            jH2 = Math.max(jH2, 300L);
                        }
                        c0(accessibilityService, rVar, jH2);
                    }
                    throw th;
                }
            }
            c0(accessibilityService, rVar, jH);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static AccessibilityNodeInfo t(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = accessibilityNodeInfo == null ? null : AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
        int i3 = 0;
        while (accessibilityNodeInfoObtain != null && i3 <= 4) {
            try {
                if (L(accessibilityNodeInfoObtain)) {
                    a0(accessibilityNodeInfoObtain);
                    return null;
                }
                int iP = p(3, accessibilityNodeInfoObtain);
                if (iP == 1) {
                    ArrayList arrayList = new ArrayList();
                    k(accessibilityNodeInfoObtain, arrayList);
                    int i4 = -1;
                    int i5 = -1;
                    for (int i6 = 0; i6 < arrayList.size(); i6++) {
                        AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) arrayList.get(i6);
                        if (K(accessibilityNodeInfo3)) {
                            i4 = i6;
                            break;
                        }
                        if (i5 < 0 && J(accessibilityNodeInfo3)) {
                            i5 = i6;
                        }
                    }
                    if (i4 >= 0) {
                        i5 = i4;
                    }
                    for (int i7 = 0; i7 < arrayList.size(); i7++) {
                        if (i7 != i5) {
                            a0((AccessibilityNodeInfo) arrayList.get(i7));
                        }
                    }
                    if (i5 >= 0) {
                        accessibilityNodeInfo2 = (AccessibilityNodeInfo) arrayList.get(i5);
                    }
                    a0(accessibilityNodeInfoObtain);
                    return accessibilityNodeInfo2;
                }
                if (iP > 1) {
                    a0(accessibilityNodeInfoObtain);
                    return null;
                }
                AccessibilityNodeInfo parent = accessibilityNodeInfoObtain.getParent();
                a0(accessibilityNodeInfoObtain);
                i3++;
                accessibilityNodeInfoObtain = parent;
            } catch (Throwable unused) {
                a0(accessibilityNodeInfoObtain);
                return null;
            }
        }
        a0(accessibilityNodeInfoObtain);
        return null;
    }

    public static AccessibilityNodeInfo u(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo != null) {
                arrayList3.add(accessibilityNodeInfo);
            }
        }
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        AccessibilityNodeInfo accessibilityNodeInfo3 = null;
        AccessibilityNodeInfo accessibilityNodeInfo4 = null;
        int i5 = 0;
        while (!arrayList3.isEmpty()) {
            AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) arrayList3.remove(0);
            if (accessibilityNodeInfo5 != null) {
                try {
                    String strValueOf = String.valueOf(accessibilityNodeInfo5.getClassName());
                    if ((strValueOf.contains("Switch") || strValueOf.contains("Toggle")) && accessibilityNodeInfo5.isCheckable() && accessibilityNodeInfo5.isChecked() && accessibilityNodeInfo5.isEnabled() && accessibilityNodeInfo5.isVisibleToUser()) {
                        i5++;
                        if (accessibilityNodeInfo4 == null) {
                            accessibilityNodeInfo4 = accessibilityNodeInfo5;
                        }
                        if (accessibilityNodeInfo3 == null && b0(accessibilityNodeInfo5)) {
                            accessibilityNodeInfo3 = accessibilityNodeInfo5;
                        }
                    }
                    for (int i6 = 0; i6 < accessibilityNodeInfo5.getChildCount(); i6++) {
                        AccessibilityNodeInfo child = accessibilityNodeInfo5.getChild(i6);
                        if (child != null) {
                            arrayList3.add(child);
                            arrayList2.add(child);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        if (accessibilityNodeInfo3 != null) {
            accessibilityNodeInfo2 = accessibilityNodeInfo3;
        } else if (i5 == 1) {
            accessibilityNodeInfo2 = accessibilityNodeInfo4;
        }
        int size2 = arrayList2.size();
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            AccessibilityNodeInfo accessibilityNodeInfo6 = (AccessibilityNodeInfo) obj2;
            if (accessibilityNodeInfo6 != null && accessibilityNodeInfo6 != accessibilityNodeInfo2) {
                a0(accessibilityNodeInfo6);
            }
        }
        return accessibilityNodeInfo2;
    }

    public static AccessibilityNodeInfo v(ArrayList arrayList, String[] strArr) {
        if (strArr != null) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
                if (accessibilityNodeInfo != null) {
                    for (String str : strArr) {
                        if (str != null && !str.trim().isEmpty()) {
                            try {
                                List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
                                if (listFindAccessibilityNodeInfosByText == null) {
                                    continue;
                                } else {
                                    AccessibilityNodeInfo accessibilityNodeInfo2 = null;
                                    for (AccessibilityNodeInfo accessibilityNodeInfo3 : listFindAccessibilityNodeInfosByText) {
                                        if (accessibilityNodeInfo2 == null) {
                                            try {
                                                if (j0(T(accessibilityNodeInfo3), str)) {
                                                    AccessibilityNodeInfo accessibilityNodeInfoT = t(accessibilityNodeInfo3);
                                                    if (accessibilityNodeInfoT == null || !O(accessibilityNodeInfoT)) {
                                                        a0(accessibilityNodeInfo3);
                                                        accessibilityNodeInfo2 = accessibilityNodeInfoT;
                                                    } else {
                                                        Log.i("SampleGrantClicker", "skip shortcut switch (exact-label path)");
                                                        a0(accessibilityNodeInfoT);
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                a0(accessibilityNodeInfo3);
                                                throw th;
                                            }
                                        }
                                        a0(accessibilityNodeInfo3);
                                    }
                                    if (accessibilityNodeInfo2 != null) {
                                        return accessibilityNodeInfo2;
                                    }
                                }
                            } catch (Throwable unused) {
                                continue;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean w(x1.r rVar, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || !O(accessibilityNodeInfo)) {
            return (rVar == null || accessibilityNodeInfo == null || !rVar.f(accessibilityNodeInfo)) ? false : true;
        }
        Log.i("SampleGrantClicker", "skip shortcut control (gestureTapOnly)");
        return false;
    }

    public static boolean x(AccessibilityService accessibilityService, x1.r rVar, ArrayList arrayList, boolean z2) {
        AccessibilityNodeInfo next;
        int size;
        int i3;
        boolean z3;
        boolean zContains;
        if (!c0.g(4) || !c0.k()) {
            return false;
        }
        if (f1305y >= 8) {
            Log.w("SampleGrantClicker", "h0 hunt cap steps=" + f1305y);
            f1304x = f1304x + 1;
            f1305y = 0;
            c0.e(4);
            return false;
        }
        f1305y++;
        try {
            if (Settings.canDrawOverlays(accessibilityService)) {
                c0.e(4);
                U();
                f1282a.c(accessibilityService);
                Q(accessibilityService);
                return true;
            }
            while (true) {
                if (i3 >= size) {
                    z3 = false;
                    break;
                }
                Object obj = arrayList.get(i3);
                i3++;
                if (d0((AccessibilityNodeInfo) obj)) {
                    z3 = true;
                    break;
                }
            }
        } catch (Throwable unused) {
        }
        int i4 = f1304x;
        String lowerCase = a(accessibilityService).toLowerCase(Locale.ROOT);
        if (z2 && lowerCase != null && !lowerCase.isEmpty()) {
            int size2 = arrayList.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size2) {
                    next = null;
                    break;
                }
                Object obj2 = arrayList.get(i5);
                i5++;
                AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj2;
                if (accessibilityNodeInfo != null) {
                    try {
                        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId("android:id/title");
                        if (listFindAccessibilityNodeInfosByViewId != null) {
                            Iterator<AccessibilityNodeInfo> it = listFindAccessibilityNodeInfosByViewId.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it.next();
                                String strT = T(next);
                                if (strT != null && strT.trim().toLowerCase(Locale.ROOT).equals(lowerCase)) {
                                    break;
                                }
                                a0(next);
                            }
                        } else {
                            next = null;
                            break;
                        }
                    } catch (Throwable unused2) {
                    }
                    if (next != null) {
                        break;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    i(accessibilityNodeInfo, "android.widget.TextView", arrayList2);
                    int size3 = arrayList2.size();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= size3) {
                            next = null;
                            break;
                        }
                        Object obj3 = arrayList2.get(i6);
                        i6++;
                        AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj3;
                        String strT2 = T(accessibilityNodeInfo2);
                        if (strT2 != null && strT2.trim().toLowerCase(Locale.ROOT).equals(lowerCase)) {
                            int size4 = arrayList2.size();
                            int i7 = 0;
                            while (i7 < size4) {
                                Object obj4 = arrayList2.get(i7);
                                i7++;
                                AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj4;
                                if (accessibilityNodeInfo3 != accessibilityNodeInfo2) {
                                    a0(accessibilityNodeInfo3);
                                }
                            }
                            next = accessibilityNodeInfo2;
                            break;
                        }
                        a0(accessibilityNodeInfo2);
                    }
                    if (next != null) {
                        break;
                    }
                }
            }
        } else {
            next = null;
            break;
        }
        if (next != null) {
            AccessibilityNodeInfo accessibilityNodeInfo4 = arrayList.isEmpty() ? null : (AccessibilityNodeInfo) arrayList.get(0);
            try {
                if (!next.isVisibleToUser()) {
                    zContains = false;
                } else if (accessibilityNodeInfo4 == null) {
                    zContains = true;
                } else {
                    Rect rect = new Rect();
                    Rect rect2 = new Rect();
                    next.getBoundsInScreen(rect);
                    accessibilityNodeInfo4.getBoundsInScreen(rect2);
                    zContains = rect2.contains(rect);
                }
            } catch (Throwable unused3) {
            }
            if (zContains && w(rVar, next)) {
                a0(next);
                n = System.currentTimeMillis();
                Log.i("SampleGrantClicker", "h0 N0 title row");
                Z(500L, i4, new n0(accessibilityService, rVar, 2));
                return true;
            }
            a0(next);
        }
        size = arrayList.size();
        i3 = 0;
        if (z3) {
            Z(800L, i4, new n0(accessibilityService, rVar, 3));
            return true;
        }
        if (!R(rVar, arrayList, "android.widget.Switch") && !R(rVar, arrayList, "android.view.View")) {
            Z(100L, i4, new l0(accessibilityService, i4, rVar));
            return false;
        }
        n = System.currentTimeMillis();
        Log.i("SampleGrantClicker", "h0 N0 switch/view");
        Z(500L, i4, new c2.d(accessibilityService, 2));
        return true;
    }

    public static void y(AccessibilityService accessibilityService, ArrayList arrayList) {
        if (accessibilityService != null) {
            k0.f1230j = accessibilityService;
        } else {
            Handler handler = k0.f1221a;
        }
        int i3 = 0;
        try {
            if (w1.n.D(accessibilityService)) {
                c0.e(11);
                c0.f1150o = false;
                return;
            }
        } catch (Throwable unused) {
        }
        if (accessibilityService != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                if (k0.c(accessibilityService, (AccessibilityNodeInfo) obj)) {
                    Log.i("SampleAdminClicker", "u0.k event-root hit");
                    k0.f1221a.postDelayed(new c2.d(accessibilityService, 1), 600L);
                    break;
                }
            }
        }
        if (c0.f1150o) {
            return;
        }
        c0.f1150o = true;
        k0.f1221a.postDelayed(new d2.r(4), 150L);
    }

    public static boolean z(AccessibilityService accessibilityService, x1.r rVar, ArrayList arrayList, long j3) {
        try {
            PowerManager powerManager = (PowerManager) accessibilityService.getSystemService("power");
            if (powerManager != null && powerManager.isIgnoringBatteryOptimizations(accessibilityService.getPackageName())) {
                c0.e(9);
                return false;
            }
        } catch (Throwable unused) {
        }
        if (!c0.f1149m) {
            c0.f1149m = true;
            c0(accessibilityService, rVar, 500L);
            return true;
        }
        if (e(rVar, arrayList, f1287f)) {
            n = j3;
            Log.i("SampleGrantClicker", "clicked battery No restrictions");
        }
        return true;
    }
}
