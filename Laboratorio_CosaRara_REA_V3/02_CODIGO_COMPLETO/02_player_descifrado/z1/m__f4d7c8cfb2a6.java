// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f6348a;

    static {
        HashMap map = new HashMap();
        map.put("en", new l(c("uninstall", "uninstall app", "remove app"), c("disable", "disable app", "turn off app"), c("force stop", "force-stop"), c("clear data", "clear storage", "delete app data"), c("storage", "storage and cache"), c("deactivate", "deactivate this device admin app", "remove device admin"), c("stop", "stop app"), c("cancel", "not now", "keep app", "no")));
        map.put("zh", new l(c("卸载", "卸載", "解除安装", "解除安裝"), c("停用", "禁用"), c("强行停止", "強行停止", "强制停止", "強制停止"), c("清除数据", "清除資料", "清除存储空间", "清除儲存空間"), c("存储", "儲存空間", "存储和缓存", "儲存空間和快取"), c("停用此设备管理应用", "停用此裝置管理應用程式", "取消激活"), c("停止"), c("取消", "不卸载", "不解除安裝", "保留应用", "否")));
        map.put("ko", new l(c("삭제", "앱 삭제", "제거", "앱 제거"), c("사용 중지", "사용 안 함"), c("강제 종료"), c("데이터 삭제", "저장공간 삭제", "저장 공간 삭제"), c("저장공간", "저장 공간 및 캐시"), c("기기 관리자 앱 해제", "이 기기 관리자 앱 해제", "비활성화"), c("중지"), c("취소", "아니요", "앱 유지")));
        map.put("ja", new l(c("アンインストール", "アプリをアンインストール"), c("無効にする", "アプリを無効にする"), c("強制停止"), c("データを消去", "ストレージを消去"), c("ストレージ", "ストレージとキャッシュ"), c("このデバイス管理アプリを無効にする", "デバイス管理アプリを無効にする"), c("停止"), c("キャンセル", "取消", "いいえ", "アプリを保持")));
        map.put("es", new l(c("desinstalar", "desinstalar aplicación"), c("inhabilitar", "desactivar aplicación"), c("forzar detención", "forzar cierre"), c("borrar datos", "borrar almacenamiento"), c("almacenamiento", "almacenamiento y caché"), c("desactivar esta aplicación de administración", "desactivar administrador"), c("detener", "parar"), c("cancelar", "ahora no", "conservar aplicación", "no")));
        map.put("pt", new l(c("desinstalar", "desinstalar app"), c("desativar", "desativar app"), c("forçar parada", "forçar interrupção"), c("limpar dados", "limpar armazenamento"), c("armazenamento", "armazenamento e cache"), c("desativar este app de administrador", "remover administrador"), c("parar", "interromper"), c("cancelar", "agora não", "manter app", "não")));
        map.put("ru", new l(c("удалить", "удалить приложение"), c("отключить", "отключить приложение"), c("остановить", "принудительно остановить"), c("очистить данные", "очистить хранилище"), c("хранилище", "хранилище и кеш"), c("отключить администратора устройства", "деактивировать"), c("остановить"), c("отмена", "не сейчас", "оставить приложение", "нет")));
        map.put("ar", new l(c("إلغاء التثبيت", "إزالة التطبيق"), c("تعطيل", "تعطيل التطبيق"), c("فرض الإيقاف", "إيقاف إجباري"), c("محو البيانات", "محو مساحة التخزين"), c("مساحة التخزين", "مساحة التخزين وذاكرة التخزين المؤقت"), c("إلغاء تنشيط تطبيق مشرف الجهاز", "إلغاء تنشيط المشرف"), c("إيقاف"), c("إلغاء", "ليس الآن", "الاحتفاظ بالتطبيق", "لا")));
        f6348a = Collections.unmodifiableMap(map);
    }

    public static int a(CharSequence charSequence, String str) {
        String strM = m0.a.m(charSequence);
        if (strM.isEmpty()) {
            return 8;
        }
        l lVarB = b(str);
        if (lVarB.f6340a.contains(strM)) {
            return 1;
        }
        if (lVarB.f6341b.contains(strM)) {
            return 2;
        }
        if (lVarB.f6342c.contains(strM)) {
            return 3;
        }
        if (lVarB.f6343d.contains(strM)) {
            return 4;
        }
        if (lVarB.f6344e.contains(strM)) {
            return 5;
        }
        if (lVarB.f6345f.contains(strM)) {
            return 6;
        }
        return lVarB.f6346g.contains(strM) ? 7 : 8;
    }

    public static l b(String str) {
        String language;
        String strTrim = str.trim();
        int iIndexOf = strTrim.indexOf(44);
        if (iIndexOf >= 0) {
            strTrim = strTrim.substring(0, iIndexOf);
        }
        try {
            language = Locale.forLanguageTag(strTrim).getLanguage();
        } catch (RuntimeException unused) {
            language = "";
        }
        Map map = f6348a;
        l lVar = (l) map.get(language);
        return lVar != null ? lVar : (l) map.get("en");
    }

    public static Set c(String... strArr) {
        HashSet hashSet = new HashSet();
        Iterator it = Arrays.asList(strArr).iterator();
        while (it.hasNext()) {
            String strM = m0.a.m((String) it.next());
            if (!strM.isEmpty()) {
                hashSet.add(strM);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
