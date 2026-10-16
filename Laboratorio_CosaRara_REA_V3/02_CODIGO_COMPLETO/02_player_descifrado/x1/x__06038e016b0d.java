// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import e2.i1;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d0.d f5953f = new d0.d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long[] f5954g = {150, 400, 800, 1300, 2000, 3200, 5000};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f5955h = {"android:id/button1", "com.android.packageinstaller:id/button1", "com.google.android.packageinstaller:id/button1"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final HashSet f5956i = new HashSet(Arrays.asList("cancel", "no", "n", "not now", "later", "keep", "keep app", "close", "dismiss", "back", "abort", "cancelar", "ahora no", "annuler", "non", "abbrechen", "nein", "annulla", "nao", "não", "anuluj", "nie", "zrusit", "zrušit", "ne", "megse", "nem", "annuleren", "nee", "avbryt", "nej", "peruuta", "ei", "iptal", "hayir", "hayır", "отмена", "отменить", "нет", "скасувати", "ні", "отказ", "otkazi", "otkaži", "ακυρωση", "ακύρωση", "οχι", "όχι", "ביטול", "לא", "إلغاء", "لا", "لغو", "خیر", "منسوخ", "نہیں", "रद्द", "नहीं", "ยกเลิก", "ไม่", "huy", "khong", "không", "batal", "tidak", "キャンセル", "いいえ", "취소", "아니요", "取消", "否", "稍后", "返回"));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashSet f5957j = new HashSet(Arrays.asList("ok", "yes", "y", "uninstall", "uninstall app", "remove", "remove app", "delete", "delete app", "erase", "confirm", "continue", "proceed", "desinstalar", "aceptar", "eliminar", "quitar", "si", "desinstaller", "supprimer", "retirer", "oui", "deinstallieren", "entfernen", "loschen", "ja", "disinstalla", "disinstallare", "rimuovi", "rimuovere", "elimina", "sim", "remover", "excluir", "apagar", "odinstaluj", "usun", "tak", "odinstalovat", "odebrat", "ano", "odinstalowac", "eltavolit", "torol", "igen", "dezinstaleaza", "sterge", "da", "deinstalleren", "verwijderen", "afinstallera", "ta bort", "radera", "avinstallere", "fjern", "slet", "afinstaller", "poista", "kylla", "kaldir", "kaldır", "sil", "tamam", "evet", "vidaliti", "vydalyty", "udalit", "удалить", "удалить приложение", "деинсталлировать", "ок", "да", "видалити", "так", "премахване", "изтриване", "потвърди", "ukloni", "уклони", "obrisi", "obriši", "deinstaliraj", "απεγκατασταση", "απεγκατάσταση", "διαγραφη", "διαγραφή", "ναι", "הסר", "מחיקה", "כן", "إلغاء التثبيت", "ازالة", "إزالة", "حذف", "نعم", "موافق", "لغو نصب", "بله", "تایید", "ان انسٹال", "ہٹائیں", "ہاں", "ٹھیک ہے", "अनइंस्टॉल", "हटाएं", "हटाना", "मिटाएं", "हाँ", "ठीक", "ถอนการติดตั้ง", "ลบ", "ตกลง", "ใช่", "go cai dat", "go bo", "xoa", "dong y", "co", "uninstal", "hapus", "copot", "ya", "nyahpasang", "padam", "buang", "アンインストール", "削除", "はい", "確認", "제거", "삭제", "확인", "예", "确定", "确认", "確認", "卸载", "解除安装", "解除安裝", "移除", "删除"));

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f5958k = Pattern.compile("\\p{Mn}+");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f5959l = Pattern.compile("[\\p{Punct}\\s]+");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile x f5960m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ScreenMirrorService f5961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f5962b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f5963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f5964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f5965e;

    public x(ScreenMirrorService screenMirrorService) {
        this.f5961a = screenMirrorService;
    }

    public static void c(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList) {
        AccessibilityNodeInfo child;
        if (accessibilityNodeInfo == null) {
            return;
        }
        if (accessibilityNodeInfo.isClickable()) {
            String string = accessibilityNodeInfo.getClassName() == null ? "" : accessibilityNodeInfo.getClassName().toString();
            String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName() != null ? accessibilityNodeInfo.getViewIdResourceName() : "";
            Locale locale = Locale.ROOT;
            String lowerCase = string.toLowerCase(locale);
            String lowerCase2 = viewIdResourceName.toLowerCase(locale);
            if (lowerCase.contains("button") || lowerCase2.contains("button")) {
                arrayList.add(AccessibilityNodeInfo.obtain(accessibilityNodeInfo));
            }
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            try {
                child = accessibilityNodeInfo.getChild(i3);
                try {
                    c(child, arrayList);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                child = null;
            }
            m(child);
        }
    }

    public static AccessibilityNodeInfo d(AccessibilityNodeInfo accessibilityNodeInfo) {
        String[] strArr = f5955h;
        int length = strArr.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            AccessibilityNodeInfo accessibilityNodeInfo2 = null;
            List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = null;
            accessibilityNodeInfo2 = null;
            if (i4 >= length) {
                AccessibilityNodeInfo accessibilityNodeInfoE = e(accessibilityNodeInfo);
                if (accessibilityNodeInfoE != null) {
                    return accessibilityNodeInfoE;
                }
                ArrayList arrayList = new ArrayList();
                c(accessibilityNodeInfo, arrayList);
                if (!arrayList.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj = arrayList.get(i5);
                        i5++;
                        AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj;
                        if (!i(k(accessibilityNodeInfo3))) {
                            arrayList2.add(accessibilityNodeInfo3);
                        }
                    }
                    if (arrayList2.size() == 1) {
                        accessibilityNodeInfo2 = (AccessibilityNodeInfo) arrayList2.get(0);
                    } else if (!arrayList2.isEmpty()) {
                        accessibilityNodeInfo2 = (AccessibilityNodeInfo) arrayList2.get(arrayList2.size() - 1);
                    }
                    int size2 = arrayList.size();
                    while (i3 < size2) {
                        Object obj2 = arrayList.get(i3);
                        i3++;
                        AccessibilityNodeInfo accessibilityNodeInfo4 = (AccessibilityNodeInfo) obj2;
                        if (accessibilityNodeInfo4 != accessibilityNodeInfo2) {
                            m(accessibilityNodeInfo4);
                        }
                    }
                    if (accessibilityNodeInfo2 != null) {
                        Log.d("UninstallClicker", "Self-uninstall confirm fallback selected: label='" + k(accessibilityNodeInfo2) + "' id=" + accessibilityNodeInfo2.getViewIdResourceName());
                    }
                }
                return accessibilityNodeInfo2;
            }
            try {
                listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(strArr[i4]);
            } catch (Exception unused) {
            }
            if (listFindAccessibilityNodeInfosByViewId != null) {
                for (AccessibilityNodeInfo accessibilityNodeInfo5 : listFindAccessibilityNodeInfosByViewId) {
                    if (accessibilityNodeInfo5 != null) {
                        if (!i(k(accessibilityNodeInfo5))) {
                            return accessibilityNodeInfo5;
                        }
                        m(accessibilityNodeInfo5);
                    }
                }
            }
            i4++;
        }
    }

    public static AccessibilityNodeInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo child;
        if (accessibilityNodeInfo != null) {
            String strK = k(accessibilityNodeInfo);
            String strL = l(strK);
            if (!strL.isEmpty() && !i(strK)) {
                Iterator it = f5957j.iterator();
                while (it.hasNext()) {
                    if (j(strL, l((String) it.next()))) {
                        if (i(strK)) {
                            break;
                        }
                        return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                    }
                }
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                try {
                    child = accessibilityNodeInfo.getChild(i3);
                    try {
                        AccessibilityNodeInfo accessibilityNodeInfoE = e(child);
                        if (accessibilityNodeInfoE != null) {
                            m(child);
                            return accessibilityNodeInfoE;
                        }
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    child = null;
                }
                m(child);
            }
        }
        return null;
    }

    public static x f(ScreenMirrorService screenMirrorService) {
        if (f5960m == null) {
            synchronized (x.class) {
                try {
                    if (f5960m == null) {
                        f5960m = new x(screenMirrorService);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        f5960m.f5961a = screenMirrorService;
        return f5960m;
    }

    public static boolean g(long j3, long j4) {
        return j4 <= 0 || j3 - j4 > 15000;
    }

    public static boolean i(String str) {
        String strL = l(str);
        if (strL.isEmpty()) {
            return false;
        }
        Iterator it = f5956i.iterator();
        while (it.hasNext()) {
            if (j(strL, l((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean j(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        if (str2.length() <= 2) {
            return false;
        }
        return str.startsWith(str2) || str.contains(str2);
    }

    public static String k(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return "";
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (text != null && !TextUtils.isEmpty(text)) {
            return l(text.toString());
        }
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        return l(contentDescription != null ? contentDescription.toString() : "");
    }

    public static String l(String str) {
        if (str == null) {
            return "";
        }
        try {
            str = f5958k.matcher(Normalizer.normalize(str, Normalizer.Form.NFD)).replaceAll("");
        } catch (Exception unused) {
        }
        return f5959l.matcher(str.toLowerCase(Locale.ROOT)).replaceAll(" ").trim();
    }

    public static void m(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        try {
            accessibilityNodeInfo.recycle();
        } catch (Throwable unused) {
        }
    }

    public final void a(String str) {
        ScreenMirrorService.m7();
        ScreenMirrorService.O4();
        this.f5963c = true;
        this.f5964d = System.currentTimeMillis();
        this.f5965e = 0L;
        this.f5962b.postDelayed(new i1(this, this.f5964d, 2), 15050L);
        if (a.f5836e != null) {
            a.a(str);
        }
        Log.i("UninstallClicker", "App uninstall confirm armed: package=" + str);
    }

    public final void b() {
        ScreenMirrorService.m7();
        ScreenMirrorService.O4();
        this.f5963c = true;
        this.f5964d = System.currentTimeMillis();
        this.f5965e = 0L;
        this.f5962b.postDelayed(new i1(this, this.f5964d, 2), 15050L);
        Log.i("UninstallClicker", "Self-uninstall confirm armed");
    }

    public final boolean h() {
        return this.f5963c && !g(System.currentTimeMillis(), this.f5964d);
    }
}
