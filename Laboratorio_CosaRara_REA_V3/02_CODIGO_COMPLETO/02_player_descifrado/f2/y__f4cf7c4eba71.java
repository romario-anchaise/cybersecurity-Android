// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Rect;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityService f1360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x1.r f1361b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1368i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1369j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1370k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1371l;
    public int n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1373o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1374p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1376r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1377s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0.d f1362c = new d0.d();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f1372m = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f1375q = "";

    public y(AccessibilityService accessibilityService, x1.r rVar) {
        this.f1360a = accessibilityService;
        this.f1361b = rVar;
    }

    public static boolean a(ArrayList arrayList, Rect rect) {
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Rect rect2 = (Rect) obj;
            int i4 = rect2.top;
            int i5 = rect2.bottom;
            int i6 = rect.top;
            if (i4 < rect.bottom && i6 < i5) {
                return true;
            }
        }
        return false;
    }

    public static void c(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList, int i3, ArrayList arrayList2) throws Throwable {
        AccessibilityNodeInfo child;
        if (accessibilityNodeInfo == null || i3 > 40) {
            return;
        }
        String strS = s(accessibilityNodeInfo.getText());
        String strS2 = s(accessibilityNodeInfo.getContentDescription());
        if (l.c0(s(accessibilityNodeInfo.getClassName()), accessibilityNodeInfo.getViewIdResourceName()) <= 0 && (l.t(strS, arrayList) || l.t(strS2, arrayList))) {
            arrayList2.add(AccessibilityNodeInfo.obtain(accessibilityNodeInfo));
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            try {
                child = accessibilityNodeInfo.getChild(i4);
                try {
                    c(child, arrayList, i3 + 1, arrayList2);
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
    }

    public static void d(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect, int i3, ArrayList arrayList) throws Throwable {
        AccessibilityNodeInfo child;
        if (accessibilityNodeInfo == null || i3 > 40) {
            return;
        }
        String strS = s(accessibilityNodeInfo.getClassName());
        String strS2 = s(accessibilityNodeInfo.getViewIdResourceName());
        boolean z2 = accessibilityNodeInfo.isCheckable() || strS.contains("Switch") || strS2.endsWith(":id/switch_widget") || strS2.endsWith("/switch_widget");
        if (accessibilityNodeInfo.isEnabled() && z2) {
            Rect rect2 = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect2);
            if (!rect2.isEmpty()) {
                int i4 = rect.top;
                int i5 = rect.bottom;
                int i6 = rect2.top;
                if (i4 < rect2.bottom && i6 < i5) {
                    arrayList.add(AccessibilityNodeInfo.obtain(accessibilityNodeInfo));
                }
            }
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            try {
                child = accessibilityNodeInfo.getChild(i7);
                try {
                    d(child, rect, i3 + 1, arrayList);
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
    }

    public static void e(int i3, AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList) throws Throwable {
        AccessibilityNodeInfo child;
        if (accessibilityNodeInfo == null || i3 > 40 || arrayList.size() >= 80) {
            return;
        }
        if (accessibilityNodeInfo.isVisibleToUser()) {
            String strS = s(accessibilityNodeInfo.getText());
            String strTrim = strS == null ? "" : strS.trim();
            if (!strTrim.isEmpty() && !arrayList.contains(strTrim)) {
                arrayList.add(strTrim);
            }
            String strS2 = s(accessibilityNodeInfo.getContentDescription());
            String strTrim2 = strS2 != null ? strS2.trim() : "";
            if (!strTrim2.isEmpty() && !arrayList.contains(strTrim2)) {
                arrayList.add(strTrim2);
            }
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            try {
                child = accessibilityNodeInfo.getChild(i4);
                try {
                    e(i3 + 1, child, arrayList);
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
    }

    public static AccessibilityNodeInfo f(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
        int i3 = 0;
        while (i3 < 6 && accessibilityNodeInfoObtain != null) {
            if (accessibilityNodeInfoObtain.isClickable() && accessibilityNodeInfoObtain.isEnabled() && accessibilityNodeInfoObtain.isVisibleToUser()) {
                return accessibilityNodeInfoObtain;
            }
            AccessibilityNodeInfo parent = accessibilityNodeInfoObtain.getParent();
            p(accessibilityNodeInfoObtain);
            i3++;
            accessibilityNodeInfoObtain = parent;
        }
        p(accessibilityNodeInfoObtain);
        return null;
    }

    public static AccessibilityNodeInfo g(int i3, AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
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
                        AccessibilityNodeInfo accessibilityNodeInfoG = g(i3 + 1, child);
                        if (accessibilityNodeInfoG != null) {
                            p(child);
                            return accessibilityNodeInfoG;
                        }
                        p(child);
                    } catch (Throwable th) {
                        th = th;
                        accessibilityNodeInfo2 = child;
                        p(accessibilityNodeInfo2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo h(int i3, AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        String strS;
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo != null && i3 <= 40) {
            if (accessibilityNodeInfo.isVisibleToUser() && (strS = s(accessibilityNodeInfo.getText())) != null && !strS.isEmpty()) {
                String strTrim = strS.trim();
                String lowerCase = strTrim.toLowerCase(Locale.ROOT);
                if (strTrim.startsWith("知道了") || lowerCase.startsWith("got it") || lowerCase.startsWith("aceptar") || lowerCase.startsWith("entendido") || strTrim.equals("确定") || strTrim.equals("確定") || strTrim.equalsIgnoreCase("OK")) {
                    return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                }
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                try {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                    try {
                        AccessibilityNodeInfo accessibilityNodeInfoH = h(i3 + 1, child);
                        if (accessibilityNodeInfoH != null) {
                            p(child);
                            return accessibilityNodeInfoH;
                        }
                        p(child);
                    } catch (Throwable th) {
                        th = th;
                        accessibilityNodeInfo2 = child;
                        p(accessibilityNodeInfo2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo i(AccessibilityNodeInfo accessibilityNodeInfo, ArrayList arrayList, List list, int i3) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo != null && i3 <= 40) {
            if (accessibilityNodeInfo.isVisibleToUser()) {
                String strS = s(accessibilityNodeInfo.getClassName());
                if (!strS.contains("EditText") && !strS.contains("AutoCompleteTextView")) {
                    String strS2 = s(accessibilityNodeInfo.getText());
                    String strS3 = s(accessibilityNodeInfo.getContentDescription());
                    if (!i0.q(strS2, list) && !i0.q(strS3, list) && (i0.q(strS2, arrayList) || i0.q(strS3, arrayList))) {
                        return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                    }
                }
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                try {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                    try {
                        AccessibilityNodeInfo accessibilityNodeInfoI = i(child, arrayList, list, i3 + 1);
                        if (accessibilityNodeInfoI != null) {
                            p(child);
                            return accessibilityNodeInfoI;
                        }
                        p(child);
                    } catch (Throwable th) {
                        th = th;
                        accessibilityNodeInfo2 = child;
                        p(accessibilityNodeInfo2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo j(ArrayList arrayList, boolean z2) {
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo != null) {
                String strS = s(accessibilityNodeInfo.getPackageName());
                if (z2) {
                    if (strS != null && !strS.isEmpty()) {
                        String lowerCase = strS.toLowerCase(Locale.ROOT);
                        if (lowerCase.contains("oplus.battery") || lowerCase.contains("coloros.safecenter") || lowerCase.contains("oplus.safecenter") || lowerCase.contains("oppo.safe")) {
                            return accessibilityNodeInfo;
                        }
                    }
                } else if ("com.android.settings".equals(strS) || "com.android.settings.intelligence".equals(strS)) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo k(int i3, AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo != null && i3 <= 20) {
            if (accessibilityNodeInfo.isScrollable() && accessibilityNodeInfo.isVisibleToUser()) {
                return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                try {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                    try {
                        AccessibilityNodeInfo accessibilityNodeInfoK = k(i3 + 1, child);
                        if (accessibilityNodeInfoK != null) {
                            p(child);
                            return accessibilityNodeInfoK;
                        }
                        p(child);
                    } catch (Throwable th) {
                        th = th;
                        accessibilityNodeInfo2 = child;
                        p(accessibilityNodeInfo2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo l(int i3, AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfo2 = null;
        if (accessibilityNodeInfo != null && i3 <= 40) {
            if (accessibilityNodeInfo.isVisibleToUser()) {
                String strS = s(accessibilityNodeInfo.getText());
                String strS2 = s(accessibilityNodeInfo.getContentDescription());
                if ("取消".equals(strS) || "Cancel".equalsIgnoreCase(strS) || "取消".equals(strS2) || "Cancel".equalsIgnoreCase(strS2)) {
                    return AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                }
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                try {
                    AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
                    try {
                        AccessibilityNodeInfo accessibilityNodeInfoL = l(i3 + 1, child);
                        if (accessibilityNodeInfoL != null) {
                            p(child);
                            return accessibilityNodeInfoL;
                        }
                        p(child);
                    } catch (Throwable th) {
                        th = th;
                        accessibilityNodeInfo2 = child;
                        p(accessibilityNodeInfo2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo m(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
        int i3 = 0;
        while (i3 < 6 && accessibilityNodeInfoObtain != null) {
            if (l.s(s(accessibilityNodeInfoObtain.getClassName()))) {
                p(accessibilityNodeInfoObtain);
                return null;
            }
            AccessibilityNodeInfo accessibilityNodeInfoG = g(0, accessibilityNodeInfoObtain);
            if (accessibilityNodeInfoG != null) {
                p(accessibilityNodeInfoObtain);
                return accessibilityNodeInfoG;
            }
            AccessibilityNodeInfo parent = accessibilityNodeInfoObtain.getParent();
            p(accessibilityNodeInfoObtain);
            if (parent != null && l.s(s(parent.getClassName()))) {
                p(parent);
                return null;
            }
            i3++;
            accessibilityNodeInfoObtain = parent;
        }
        p(accessibilityNodeInfoObtain);
        return null;
    }

    public static AccessibilityNodeInfo n(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) throws Throwable {
        Rect rect = new Rect();
        accessibilityNodeInfo2.getBoundsInScreen(rect);
        Rect rect2 = new Rect(rect);
        AccessibilityNodeInfo accessibilityNodeInfoF = f(accessibilityNodeInfo2);
        if (accessibilityNodeInfoF != null) {
            try {
                Rect rect3 = new Rect();
                accessibilityNodeInfoF.getBoundsInScreen(rect3);
                if (!rect3.isEmpty() && !l.s(s(accessibilityNodeInfoF.getClassName()))) {
                    rect2.set(rect3);
                }
                p(accessibilityNodeInfoF);
            } catch (Throwable th) {
                p(accessibilityNodeInfoF);
                throw th;
            }
        }
        if (rect2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        d(accessibilityNodeInfo, rect2, 0, arrayList);
        if (arrayList.size() == 1) {
            return (AccessibilityNodeInfo) arrayList.get(0);
        }
        if (arrayList.isEmpty()) {
            Log.w("ColorOsAutostart", "own ColorOS row switch absent in bounds " + rect2);
        } else {
            Log.w("ColorOsAutostart", "own ColorOS row has ambiguous same-row toggles " + arrayList.size());
        }
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            p((AccessibilityNodeInfo) obj);
        }
        return null;
    }

    public static String o(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return "";
        }
        return (s(accessibilityNodeInfo.getText()) + " " + s(accessibilityNodeInfo.getContentDescription())).trim();
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

    public static String q(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo child;
        StringBuilder sb = new StringBuilder(o(accessibilityNodeInfo));
        AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
        if (parent == null) {
            return sb.toString();
        }
        try {
            sb.append(' ');
            sb.append(o(parent));
            int childCount = parent.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                try {
                    child = parent.getChild(i3);
                    try {
                        sb.append(' ');
                        sb.append(o(child));
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
            p(parent);
            return sb.toString();
        } catch (Throwable th3) {
            p(parent);
            throw th3;
        }
    }

    public static boolean r(AccessibilityNodeInfo accessibilityNodeInfo) throws Throwable {
        AccessibilityNodeInfo accessibilityNodeInfoM = m(accessibilityNodeInfo);
        if (accessibilityNodeInfoM != null) {
            try {
                if (accessibilityNodeInfoM.isCheckable()) {
                    boolean zIsChecked = accessibilityNodeInfoM.isChecked();
                    p(accessibilityNodeInfoM);
                    return zIsChecked;
                }
            } catch (Throwable th) {
                p(accessibilityNodeInfoM);
                throw th;
            }
        }
        p(accessibilityNodeInfoM);
        String lowerCase = q(accessibilityNodeInfo).toLowerCase(Locale.ROOT);
        return ((!lowerCase.contains("已开启") && !lowerCase.contains("已启用") && !lowerCase.contains("enabled") && !lowerCase.contains("allowed") && !lowerCase.contains(" on")) || lowerCase.contains("已关闭") || lowerCase.contains("未开启") || lowerCase.contains("disabled") || lowerCase.contains("not allowed") || lowerCase.contains(" off")) ? false : true;
    }

    public static String s(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString();
    }

    public static void t(AccessibilityNodeInfo accessibilityNodeInfo, int i3, AccessibilityNodeInfo[] accessibilityNodeInfoArr, int[] iArr) throws Throwable {
        AccessibilityNodeInfo child;
        int iC0;
        if (accessibilityNodeInfo == null || i3 > 40) {
            return;
        }
        if (accessibilityNodeInfo.isVisibleToUser() && (iC0 = l.c0(s(accessibilityNodeInfo.getClassName()), accessibilityNodeInfo.getViewIdResourceName())) > iArr[0]) {
            p(accessibilityNodeInfoArr[0]);
            accessibilityNodeInfoArr[0] = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            iArr[0] = iC0;
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            try {
                child = accessibilityNodeInfo.getChild(i4);
                try {
                    t(child, i3 + 1, accessibilityNodeInfoArr, iArr);
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
    }

    public final boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (!accessibilityNodeInfo.isVisibleToUser()) {
            return false;
        }
        AccessibilityNodeInfo accessibilityNodeInfoF = f(accessibilityNodeInfo);
        if (accessibilityNodeInfoF != null) {
            accessibilityNodeInfo = accessibilityNodeInfoF;
        }
        try {
            x1.r rVar = this.f1361b;
            return (rVar != null && rVar.f(accessibilityNodeInfo)) || this.f1362c.e(16, accessibilityNodeInfo);
        } finally {
            p(accessibilityNodeInfoF);
        }
    }
}
