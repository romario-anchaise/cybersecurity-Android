// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y1;

import i2.w;
import java.text.Normalizer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import w1.t9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6206a = t9.f5173d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f6207b = Pattern.compile("\\p{M}+");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f6208c = Pattern.compile("[\\p{P}\\p{S}\\p{Z}\\p{Cc}\\p{Cf}]+");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f6209d = p("cancel", "not now", "keep on", "keep enabled", "do not stop", "don't stop", "取消", "暂不", "稍后", "不停止", "保持开启", "稍後", "保持開啟", "不要停止", "취소", "나중에", "중지 안 함", "중지하지 않음", "キャンセル", "後で", "停止しない", "cancelar", "ahora no", "mantener activado", "mantener activada", "cancelar", "agora não", "manter ativado", "manter ativada", "отмена", "не сейчас", "оставить включенной", "оставить включенным", "إلغاء", "ليس الآن", "إبقاء مفعلة", "إبقاء مفعلاً");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set f6210e = p("stop", "stop service", "turn off", "turn off service", "disable", "disable service", "停止", "停止服务", "关闭服务", "停用", "确定停止", "停止服務", "關閉服務", "確定停止", "중지", "서비스 중지", "사용 중지", "사용 안 함", "停止", "サービスを停止", "オフにする", "無効にする", "detener", "detener servicio", "desactivar", "parar", "parar serviço", "interromper serviço", "desativar", "остановить", "остановить службу", "отключить", "إيقاف", "إيقاف الخدمة", "تعطيل");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f6211f = p("on", "enabled", "开启", "已开启", "已启用", "開啟", "已開啟", "已啟用", "켜짐", "사용 중", "オン", "有効", "activado", "activada", "ativado", "ativada", "включено", "включена", "включен", "مفعّل", "مفعلة", "قيد التشغيل");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set f6212g = p("shortcut", "accessibility shortcut", "快捷方式", "无障碍快捷方式", "無障礙捷徑", "協助工具捷徑", "快速鍵", "바로가기", "접근성 바로가기", "ショートカット", "ユーザー補助機能のショートカット", "acceso directo", "atajo", "atajo de accesibilidad", "atalho", "atalho de acessibilidade", "ярлык", "быстрое включение", "اختصار", "اختصار إمكانية الوصول");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set f6213h = p("installed services", "downloaded apps", "downloaded applications", "installed apps", "accessibility", "accessibility services", "已下载的应用", "已安裝的應用", "已安装的服务", "已安裝的服務", "无障碍", "無障礙", "辅助功能", "輔助功能", "协助工具", "協助工具", "설치된 서비스", "접근성", "ダウンロード済みのアプリ", "ユーザー補助", "servicios instalados", "aplicaciones descargadas", "accesibilidad", "serviços instalados", "aplicativos baixados", "acessibilidade", "установленные службы", "специальные возможности", "الخدمات المثبتة", "إمكانية الوصول");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set f6214i = m("android:id/button2", "android:id/button_negative", "com.android.settings:id/button2", "com.android.settings:id/button_negative", "com.android.settings:id/cancel_button", "com.android.settings:id/button_cancel", "com.samsung.accessibility:id/button2", "com.samsung.accessibility:id/button_negative", "com.miui.accessibility:id/button2", "com.miui.accessibility:id/negative_button", "com.miui.securitycenter:id/button2", "com.miui.securitycenter:id/negative_button", "miui:id/button2", "miui:id/button_negative", "com.coloros.accessibility:id/button2", "com.coloros.accessibility:id/negative_button", "com.coloros.settings:id/button2", "com.coloros.settings:id/negative_button", "com.oplus.accessibility:id/button2", "com.oplus.accessibility:id/negative_button", "com.oplus.settings:id/button2", "com.oplus.settings:id/negative_button", "com.vivo.accessibility:id/button2", "com.vivo.accessibility:id/negative_button", "com.vivo.settings:id/button2", "com.vivo.settings:id/negative_button", "com.huawei.accessibility:id/button2", "com.huawei.accessibility:id/negative_button", "com.huawei.settings:id/button2", "com.huawei.settings:id/negative_button");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set f6215j = m("android:id/button1", "android:id/button_positive", "com.android.settings:id/button1", "com.android.settings:id/button_positive", "com.android.settings:id/stop_button", "com.samsung.accessibility:id/button1", "com.samsung.accessibility:id/button_positive", "com.miui.accessibility:id/button1", "com.miui.accessibility:id/positive_button", "com.miui.securitycenter:id/button1", "com.miui.securitycenter:id/positive_button", "miui:id/button1", "miui:id/button_positive", "com.coloros.accessibility:id/button1", "com.coloros.accessibility:id/positive_button", "com.coloros.settings:id/button1", "com.coloros.settings:id/positive_button", "com.oplus.accessibility:id/button1", "com.oplus.accessibility:id/positive_button", "com.oplus.settings:id/button1", "com.oplus.settings:id/positive_button", "com.vivo.accessibility:id/button1", "com.vivo.accessibility:id/positive_button", "com.vivo.settings:id/button1", "com.vivo.settings:id/positive_button", "com.huawei.accessibility:id/button1", "com.huawei.accessibility:id/positive_button", "com.huawei.settings:id/button1", "com.huawei.settings:id/positive_button");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set f6216k = m("android:id/switch_widget", "android:id/switch_bar", "com.android.settings:id/switch_widget", "com.android.settings:id/switch_bar", "com.android.settings:id/sesl_switchbar_switch", "com.android.settings:id/service_switch", "com.android.settings:id/accessibility_service_switch", "com.samsung.accessibility:id/switch_widget", "com.samsung.accessibility:id/service_switch", "com.miui.accessibility:id/switch_widget", "com.miui.accessibility:id/service_switch", "com.miui.securitycenter:id/switch_widget", "com.miui.securitycenter:id/service_switch", "com.coloros.accessibility:id/switch_widget", "com.coloros.accessibility:id/service_switch", "com.coloros.settings:id/switch_widget", "com.coloros.settings:id/service_switch", "com.oplus.accessibility:id/switch_widget", "com.oplus.accessibility:id/service_switch", "com.oplus.settings:id/switch_widget", "com.oplus.settings:id/service_switch", "com.vivo.accessibility:id/switch_widget", "com.vivo.accessibility:id/service_switch", "com.vivo.settings:id/switch_widget", "com.vivo.settings:id/service_switch", "com.huawei.accessibility:id/switch_widget", "com.huawei.accessibility:id/service_switch", "com.huawei.settings:id/switch_widget", "com.huawei.settings:id/service_switch");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set f6217l = m("com.android.settings:id/shortcut_preference", "com.android.settings:id/accessibility_shortcut", "com.android.settings:id/shortcut_switch", "com.android.settings:id/switch_layout", "com.samsung.accessibility:id/shortcut_preference", "com.samsung.accessibility:id/accessibility_shortcut", "com.miui.accessibility:id/accessibility_shortcut", "com.miui.securitycenter:id/accessibility_shortcut", "com.coloros.accessibility:id/accessibility_shortcut", "com.coloros.settings:id/accessibility_shortcut", "com.oplus.accessibility:id/accessibility_shortcut", "com.oplus.settings:id/accessibility_shortcut", "com.vivo.accessibility:id/accessibility_shortcut", "com.vivo.settings:id/accessibility_shortcut", "com.huawei.accessibility:id/accessibility_shortcut", "com.huawei.settings:id/accessibility_shortcut");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Set f6218m = m("com.android.settings:id/service_name", "com.android.settings:id/accessibility_service", "com.android.settings:id/entity_header_title", "com.android.settings:id/accessibility_service_settings", "com.android.settings:id/main_switch_bar", "com.samsung.accessibility:id/service_name", "com.samsung.accessibility:id/accessibility_service", "com.miui.accessibility:id/accessibility_service", "com.miui.securitycenter:id/accessibility_service", "com.coloros.accessibility:id/accessibility_service", "com.coloros.settings:id/accessibility_service", "com.oplus.accessibility:id/accessibility_service", "com.oplus.settings:id/accessibility_service", "com.vivo.accessibility:id/accessibility_service", "com.vivo.settings:id/accessibility_service", "com.huawei.accessibility:id/accessibility_service", "com.huawei.settings:id/accessibility_service");

    public static String a(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString().trim();
    }

    public static String b(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString().trim().toLowerCase(Locale.ROOT);
    }

    public static a c(w wVar, y.i iVar) {
        boolean z2;
        char c3;
        a aVar = a.f6122e;
        if (wVar != null) {
            String str = wVar.f2269a;
            if (iVar != null && l.a(str)) {
                if (f6206a.equals((String) iVar.f5983a) && "lyr.stable.runtime.ScreenMirrorService".equals((String) iVar.f5984b)) {
                    i iVarD = d(wVar, iVar);
                    if (!iVarD.f6187c && ((!iVarD.f6188d || iVarD.f6185a) && !(z2 = iVarD.f6197m))) {
                        int i3 = 3;
                        int i4 = 2;
                        if (iVarD.f6185a) {
                            c3 = 2;
                        } else {
                            c3 = iVarD.f6186b ? (char) 3 : (char) 1;
                        }
                        boolean z3 = false;
                        boolean z4 = iVarD.f6192h || c3 != 1;
                        boolean z5 = iVarD.f6204u;
                        int i5 = iVarD.f6205v;
                        boolean z6 = z4 && z5 && (i5 >= 0);
                        if ((c3 != 1 && iVarD.f6193i && iVarD.f6202s && iVarD.f6203t) || (c3 != 1 && z6)) {
                            return new a(i4, i5);
                        }
                        if (z6) {
                            return new a(i4, i5);
                        }
                        boolean z7 = iVarD.n && (iVarD.f6194j || iVarD.f6199p || iVarD.f6201r);
                        boolean z8 = iVarD.f6198o && (iVarD.f6199p || iVarD.f6200q) && (iVarD.f6194j || iVarD.f6189e);
                        int i6 = -1;
                        if ((z7 || z8) && (c3 != 1 || iVarD.f6189e)) {
                            return new a(i3, i6);
                        }
                        if (!z2) {
                            boolean zContains = l.f6227b.contains(str == null ? "" : str.toString().trim().toLowerCase(Locale.ROOT));
                            boolean z9 = iVarD.f6190f;
                            if (z9 && iVarD.f6191g) {
                                z3 = true;
                            }
                            boolean z10 = iVarD.f6195k;
                            boolean z11 = iVarD.f6196l;
                            if (zContains || z10 || z11 || z3) {
                                if (c3 == 1 && z9) {
                                    boolean z12 = iVarD.f6191g;
                                }
                                return new a(4, i6);
                            }
                        }
                    }
                }
            }
        }
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:124:0x0206  */
    /* JADX WARN: Code duplicated, block: B:126:0x020a  */
    /* JADX WARN: Code duplicated, block: B:156:0x0290  */
    /* JADX WARN: Code duplicated, block: B:67:0x0136  */
    public static i d(w wVar, y.i iVar) {
        boolean z2;
        Set set;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean zE;
        boolean z6;
        boolean zE2;
        i iVar2 = new i();
        iVar2.f6205v = -1;
        g((String) wVar.f2270b, iVar2);
        Iterator it = ((List) wVar.f2271c).iterator();
        while (it.hasNext()) {
            h((String) it.next(), iVar, iVar2);
        }
        Iterator it2 = ((List) wVar.f2272d).iterator();
        while (true) {
            z2 = true;
            if (!it2.hasNext()) {
                break;
            }
            String str = (String) it2.next();
            if (str != null && !str.trim().isEmpty()) {
                if (j(str, iVar)) {
                    iVar2.f6186b = true;
                } else {
                    iVar2.f6188d = true;
                }
            }
        }
        List list = (List) wVar.f2273e;
        int i3 = 0;
        while (true) {
            int size = list.size();
            set = f6214i;
            if (i3 >= size) {
                break;
            }
            h hVar = (h) list.get(i3);
            String str2 = hVar.f6175b;
            boolean z7 = hVar.f6183j;
            boolean z8 = hVar.f6182i;
            String str3 = hVar.f6176c;
            boolean z9 = hVar.f6181h;
            boolean z10 = hVar.f6184k;
            String str4 = hVar.f6178e;
            String str5 = hVar.f6177d;
            g(str2, iVar2);
            h(hVar.f6179f, iVar, iVar2);
            String str6 = hVar.f6180g;
            if (str6 != null && !str6.trim().isEmpty()) {
                if (j(str6, iVar)) {
                    iVar2.f6186b = z2;
                } else {
                    iVar2.f6188d = z2;
                }
            }
            if (j(hVar.f6174a, iVar)) {
                iVar2.f6186b = z2;
            }
            String strB = b(str3);
            if (f6218m.contains(strB)) {
                iVar2.f6201r = z2;
            }
            if (f6217l.contains(strB)) {
                iVar2.f6199p = z2;
            }
            Set set2 = f6216k;
            if (set2.contains(strB) && z8 && z7 && z10) {
                iVar2.n = z2;
            }
            Set set3 = f6211f;
            if (z8 && z7 && z10 && ((a(hVar.f6175b).toLowerCase(Locale.ROOT).contains("switch") || set2.contains(b(str3))) && (set3.contains(o(str5)) || set3.contains(o(str4))))) {
                iVar2.f6198o = true;
            }
            String strO = o(str5);
            if (strO.isEmpty() || !((Set) iVar.f5986d).contains(strO)) {
                String strO2 = o(str4);
                if (strO2.isEmpty() || !((Set) iVar.f5986d).contains(strO2)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            } else {
                z3 = true;
            }
            iVar2.f6189e |= z3;
            if (z3 && ("android:id/title".equals(strB) || "com.android.settings:id/title".equals(strB))) {
                iVar2.f6190f = true;
            }
            iVar2.f6192h = (z3 || n(str5, iVar) || n(str4, iVar)) | iVar2.f6192h;
            if (("android:id/summary".equals(strB) || "com.android.settings:id/summary".equals(strB)) && (set3.contains(o(str5)) || set3.contains(o(str4)))) {
                iVar2.f6191g = true;
            }
            boolean z11 = iVar2.f6200q;
            String strO3 = o(str5);
            Set set4 = f6212g;
            iVar2.f6200q = z11 | (set4.contains(strO3) || set4.contains(o(str4)));
            boolean z12 = iVar2.f6196l;
            String strO4 = o(str5);
            boolean zIsEmpty = strO4.isEmpty();
            Set set5 = f6213h;
            if (zIsEmpty || !set5.contains(strO4)) {
                String strO5 = o(str4);
                if (strO5.isEmpty() || !set5.contains(strO5)) {
                    z4 = false;
                } else {
                    z4 = true;
                }
            } else {
                z4 = true;
            }
            iVar2.f6196l = z12 | z4;
            if (z9 && z10 && l(hVar)) {
                if (!set.contains(b(str3))) {
                    String strO6 = o(str5);
                    Set set6 = f6209d;
                    if (set6.contains(strO6) || set6.contains(o(str4))) {
                        if (iVar2.f6205v < 0) {
                            iVar2.f6205v = i3;
                        }
                    }
                } else if (iVar2.f6205v < 0) {
                    iVar2.f6205v = i3;
                }
            }
            if (set.contains(strB) && z9 && z10) {
                z5 = true;
                iVar2.f6202s = true;
            } else {
                z5 = true;
            }
            if (f6215j.contains(strB) && z9 && z10) {
                iVar2.f6203t = z5;
            }
            if (z9 && z10 && l(hVar)) {
                String strO7 = o(str5);
                Set set7 = f6210e;
                if (set7.contains(strO7) || set7.contains(o(str4))) {
                    iVar2.f6204u = true;
                }
            }
            if (str5 == null) {
                zE = false;
            } else {
                String strReplaceAll = str5.toString().replaceAll("\\s+", "");
                Locale locale = Locale.ROOT;
                zE = e(strReplaceAll.toLowerCase(locale), ((String) iVar.f5985c).toLowerCase(locale));
            }
            if (zE) {
                z6 = true;
                iVar2.f6185a = true;
            } else {
                if (str4 == null) {
                    zE2 = false;
                } else {
                    String strReplaceAll2 = str4.toString().replaceAll("\\s+", "");
                    Locale locale2 = Locale.ROOT;
                    zE2 = e(strReplaceAll2.toLowerCase(locale2), ((String) iVar.f5985c).toLowerCase(locale2));
                }
                if (zE2) {
                    z6 = true;
                    iVar2.f6185a = true;
                } else {
                    z6 = true;
                }
            }
            if (j(str5, iVar) || j(str4, iVar)) {
                iVar2.f6186b = z6;
            }
            i3++;
            z2 = z6;
        }
        boolean z13 = z2;
        boolean z14 = iVar2.f6202s;
        int i4 = iVar2.f6205v;
        iVar2.f6202s = z14 | ((i4 < 0 || !set.contains(b(((h) list.get(i4)).f6176c))) ? false : z13);
        return iVar2;
    }

    public static boolean e(String str, String str2) {
        int iIndexOf;
        if (str != null && str2 != null && !str2.isEmpty()) {
            int i3 = 0;
            while (i3 <= str.length() - str2.length() && (iIndexOf = str.indexOf(str2, i3)) >= 0) {
                int i4 = iIndexOf - 1;
                int length = str2.length() + iIndexOf;
                boolean z2 = i4 < 0 || !i(str.charAt(i4));
                boolean z3 = length >= str.length() || !i(str.charAt(length));
                if (z2 && z3) {
                    return true;
                }
                i3 = iIndexOf + 1;
            }
            return false;
        }
        return false;
    }

    public static boolean f(CharSequence charSequence) {
        String strO = o(charSequence);
        if (strO.isEmpty()) {
            return false;
        }
        Iterator it = f6212g.iterator();
        while (it.hasNext()) {
            if (strO.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void g(String str, i iVar) {
        String lowerCase = a(str).toLowerCase(Locale.ROOT);
        if (lowerCase.isEmpty()) {
            return;
        }
        if (lowerCase.contains("installedappdetails") || lowerCase.contains("appinfodashboard") || lowerCase.contains("applicationdetails") || lowerCase.contains("manageexternalstorage") || lowerCase.contains("drawoverotherapps")) {
            iVar.f6197m = true;
        }
        if (lowerCase.contains("accessibilityservicewarning") || lowerCase.contains("accessibilitywarningdialog") || lowerCase.contains("accessibilityservicedisable") || lowerCase.contains("disableaccessibilityservice")) {
            iVar.f6193i = true;
        }
        boolean zContains = lowerCase.contains("accessibility");
        boolean z2 = lowerCase.contains("detail") || lowerCase.contains("toggleaccessibilityservice") || lowerCase.contains("servicepreference");
        if (zContains && z2) {
            iVar.f6194j = true;
        }
        if (!lowerCase.contains("accessibilitysettings") && !lowerCase.contains("installedaccessibilityservice") && !lowerCase.contains("accessibilitymenulist") && !lowerCase.contains("manageaccessibility") && !lowerCase.contains("accessibilityactivity")) {
            if (!zContains || z2) {
                return;
            }
            if (!lowerCase.contains("settings") && !lowerCase.contains("list") && !lowerCase.contains("menu") && !lowerCase.contains("installed") && !lowerCase.contains("shortcut")) {
                return;
            }
        }
        iVar.f6195k = true;
    }

    public static void h(String str, y.i iVar, i iVar2) {
        boolean zEquals;
        if (str == null || str.trim().isEmpty()) {
            return;
        }
        if (iVar == null) {
            zEquals = false;
        } else {
            String strTrim = str.toString().trim();
            if ((strTrim.startsWith("ComponentInfo{") || strTrim.startsWith("ComponentName{")) && strTrim.endsWith("}")) {
                strTrim = strTrim.substring(strTrim.indexOf(123) + 1, strTrim.length() - 1);
            }
            zEquals = ((String) iVar.f5985c).equals(strTrim.replaceAll("\\s+", ""));
        }
        if (zEquals) {
            iVar2.f6185a = true;
        } else {
            iVar2.f6187c = true;
        }
    }

    public static boolean i(char c3) {
        if (c3 >= 'a' && c3 <= 'z') {
            return true;
        }
        if (c3 < 'A' || c3 > 'Z') {
            return (c3 >= '0' && c3 <= '9') || c3 == '_';
        }
        return true;
    }

    public static boolean j(String str, y.i iVar) {
        if (iVar != null) {
            return ((String) iVar.f5983a).equals(str == null ? "" : str.toString().trim().toLowerCase(Locale.ROOT));
        }
        return false;
    }

    public static boolean k(String str, CharSequence charSequence, CharSequence charSequence2) {
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.ROOT);
        return (!lowerCase.isEmpty() && (f6217l.contains(lowerCase) || lowerCase.contains("shortcut"))) || f(charSequence) || f(charSequence2);
    }

    public static boolean l(h hVar) {
        String lowerCase = a(hVar.f6175b).toLowerCase(Locale.ROOT);
        String strB = b(hVar.f6176c);
        return lowerCase.endsWith("button") || strB.contains("button") || f6214i.contains(strB) || f6215j.contains(strB);
    }

    public static Set m(String... strArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : strArr) {
            linkedHashSet.add(str.toLowerCase(Locale.ROOT));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public static boolean n(String str, y.i iVar) {
        String strO = o(str);
        if (strO.isEmpty()) {
            return false;
        }
        Iterator it = ((Set) iVar.f5986d).iterator();
        while (it.hasNext()) {
            if (e(strO, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String o(CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        String string = charSequence.toString();
        Normalizer.Form form = Normalizer.Form.NFKC;
        return f6208c.matcher(Normalizer.normalize(f6207b.matcher(Normalizer.normalize(Normalizer.normalize(string, form).toLowerCase(Locale.ROOT), Normalizer.Form.NFD)).replaceAll(""), form)).replaceAll(" ").trim().replaceAll("\\s+", " ");
    }

    public static Set p(String... strArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : strArr) {
            linkedHashSet.add(o(str));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public static String q(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString();
    }
}
