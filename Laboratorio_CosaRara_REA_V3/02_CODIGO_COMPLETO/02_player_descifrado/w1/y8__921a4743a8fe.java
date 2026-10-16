// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class y8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5611b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f5613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f5614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5615f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f5619j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5622m;
    public int n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5623o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f5624p;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f5631w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5610a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5612c = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StringBuilder f5616g = new StringBuilder();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f5617h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f5618i = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f5620k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f5621l = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LinkedHashMap f5625q = new LinkedHashMap();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f5626r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f5627s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final StringBuilder f5628t = new StringBuilder();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f5629u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f5630v = "";

    public static String H(String str, int i3) {
        return (i3 <= 1 || str.length() <= i3) ? str : str.substring(0, i3);
    }

    public static sd b(int i3, String str, String str2) {
        if (!l(str) || str.length() < 4 || str.length() > 16 || (i3 > 1 && str.length() < i3)) {
            return null;
        }
        return new sd(str, "pin", str2, null);
    }

    public static boolean e(String str) {
        if (str != null && !str.isEmpty()) {
            for (int i3 = 0; i3 < str.length(); i3++) {
                if (o(str.charAt(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String f(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt >= '0' && cCharAt <= '9') {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static boolean l(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean m(String str) {
        if (str == null) {
            return false;
        }
        String strTrim = str.trim();
        if (strTrim.length() < 4 || strTrim.length() > 64 || p(strTrim)) {
            return false;
        }
        boolean z2 = false;
        for (int i3 = 0; i3 < strTrim.length(); i3++) {
            char cCharAt = strTrim.charAt(i3);
            if (n(cCharAt)) {
                z2 = true;
            } else if (!q(cCharAt)) {
                return false;
            }
        }
        return z2;
    }

    public static boolean n(char c3) {
        if (c3 < 'A' || c3 > 'Z') {
            return c3 >= 'a' && c3 <= 'z';
        }
        return true;
    }

    public static boolean o(char c3) {
        return c3 == 8226 || c3 == 9679 || c3 == '*' || c3 == '?' || c3 == 8226 || c3 == 9679 || c3 == 65533;
    }

    public static boolean p(String str) {
        if (str.isEmpty()) {
            return true;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (!o(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static boolean q(char c3) {
        if (o(c3)) {
            return false;
        }
        if (n(c3) || (c3 >= '0' && c3 <= '9')) {
            return true;
        }
        return c3 >= '!' && c3 <= '~' && c3 != ' ';
    }

    public static boolean r(String str) {
        if (str == null) {
            return false;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty() || strTrim.length() > 64 || p(strTrim)) {
            return false;
        }
        boolean z2 = false;
        for (int i3 = 0; i3 < strTrim.length(); i3++) {
            char cCharAt = strTrim.charAt(i3);
            if (n(cCharAt)) {
                z2 = true;
            } else if (!q(cCharAt)) {
                return false;
            }
        }
        return z2;
    }

    public final void A() {
        B(0L);
        this.f5611b = 0L;
        this.f5614e = 0L;
        this.f5615f = false;
        this.f5626r = "";
        this.f5627s = "";
        this.f5628t.setLength(0);
        this.f5629u = "";
        this.f5630v = "";
        this.f5631w = 0L;
        this.f5624p = 0;
    }

    public final void B(long j3) {
        this.f5616g.setLength(0);
        String str = "";
        this.f5617h = "";
        this.f5618i = "";
        this.f5619j = 0L;
        this.f5620k.clear();
        this.f5621l = "";
        this.f5622m = 0;
        this.n = 0;
        this.f5623o = 0;
        this.f5625q.clear();
        this.f5611b = j3;
        if (j3 > 0) {
            str = Long.toString(j3, 36) + "-" + UUID.randomUUID();
        }
        this.f5612c = str;
        this.f5613d = 0L;
    }

    public final int C() {
        int iMax = this.n;
        ArrayList arrayList = this.f5620k;
        if (iMax <= 1) {
            iMax = Math.max(this.f5622m, Math.max(arrayList.size(), this.f5621l.length()));
        }
        return iMax <= 1 ? Math.max(this.f5616g.length(), Math.max(this.f5617h.length(), arrayList.size())) : iMax;
    }

    public final String D() {
        int iC = C();
        if (m(this.f5626r) && (iC <= 1 || this.f5626r.trim().length() >= iC)) {
            return this.f5626r.trim();
        }
        if (m(this.f5630v) && (iC <= 1 || this.f5630v.trim().length() >= iC)) {
            return this.f5630v.trim();
        }
        String str = this.f5627s;
        if (str == null) {
            str = "";
        }
        if (r(str) || m(str)) {
            if (this.f5629u.length() == 1 && !str.endsWith(this.f5629u)) {
                String str2 = str + this.f5629u;
                if (m(str2) || r(str2)) {
                    str = str2;
                }
            }
            if (m(str) && (iC <= 1 || str.length() >= iC)) {
                return str;
            }
        }
        String string = this.f5628t.toString();
        if (!m(string)) {
            return null;
        }
        if (iC <= 1 || string.length() >= iC) {
            return string;
        }
        return null;
    }

    public final void E(int i3) {
        synchronized (this.f5610a) {
            if (i3 > 1) {
                try {
                    if (i3 > this.n) {
                        this.n = i3;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0050  */
    public final boolean F(long j3, String str, boolean z2, boolean z3) {
        synchronized (this.f5610a) {
            try {
                boolean z4 = true;
                if (!t4.d(str) && (!z2 || (str != null && !str.isEmpty()))) {
                    if (z3 && (str == null || str.isEmpty() || t4.c(str))) {
                        this.f5614e = j3;
                        this.f5615f = true;
                        return true;
                    }
                    if (z2) {
                        return false;
                    }
                    if (str != null && !str.isEmpty()) {
                        return false;
                    }
                    if (this.f5615f) {
                        long j4 = this.f5614e;
                        if (j4 <= 0 || j3 - j4 > 1500) {
                            z4 = false;
                        }
                    } else {
                        z4 = false;
                    }
                    return z4;
                }
                this.f5614e = j3;
                this.f5615f = true;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final LinkedHashMap G() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : this.f5625q.entrySet()) {
            String str = (String) entry.getValue();
            if (str != null && !str.startsWith("-")) {
                linkedHashMap.put((Character) entry.getKey(), str);
            }
        }
        return linkedHashMap;
    }

    public final void a(long j3, String str, String str2) {
        String strSubstring;
        String str3;
        String strTrim = str == null ? "" : str.trim();
        String strTrim2 = str2 == null ? "" : str2.trim();
        int i3 = this.f5624p;
        if (!strTrim.isEmpty() && e(strTrim)) {
            if (this.f5624p > 0 && strTrim.length() < this.f5624p && (str3 = this.f5627s) != null && str3.length() > strTrim.length()) {
                this.f5627s = this.f5627s.substring(0, strTrim.length());
            }
            this.f5624p = strTrim.length();
        } else if (!strTrim.isEmpty() && (r(strTrim) || m(strTrim))) {
            this.f5624p = strTrim.length();
        }
        if (strTrim.length() == 1 && !e(strTrim) && q(strTrim.charAt(0)) && i3 >= 3) {
            this.f5627s = strTrim;
            this.f5626r = m(strTrim) ? strTrim : null;
            this.f5629u = strTrim;
            this.f5624p = 1;
            this.f5631w = j3;
            return;
        }
        if (strTrim.length() == 1 && q(strTrim.charAt(0)) && e(strTrim2)) {
            String str4 = this.f5627s;
            if (str4 == null) {
                str4 = "";
            }
            if (strTrim2.length() == str4.length()) {
                this.f5627s = str4.concat(strTrim);
                this.f5629u = strTrim;
                this.f5631w = j3;
                return;
            }
        }
        if (!e(strTrim) && ((r(strTrim) || m(strTrim)) && strTrim.length() >= this.f5627s.length())) {
            this.f5627s = strTrim;
            if (m(strTrim)) {
                this.f5626r = strTrim;
            }
            this.f5631w = j3;
            return;
        }
        if (!e(strTrim2) && ((r(strTrim2) || m(strTrim2)) && strTrim2.length() >= this.f5627s.length())) {
            this.f5627s = strTrim2;
            this.f5631w = j3;
        }
        if (!strTrim.isEmpty() && e(strTrim)) {
            if (strTrim.isEmpty()) {
                strSubstring = "";
            } else {
                int length = strTrim.length();
                int i4 = length - 1;
                while (i4 >= 0 && q(strTrim.charAt(i4)) && !o(strTrim.charAt(i4))) {
                    i4--;
                }
                strSubstring = strTrim.substring(i4 + 1, length);
            }
            if (!strSubstring.isEmpty()) {
                char cCharAt = strSubstring.charAt(strSubstring.length() - 1);
                String str5 = this.f5627s;
                String strSubstring2 = str5 != null ? str5 : "";
                int iMax = Math.max(strTrim.length(), (strTrim2 == null ? 0 : strTrim2.length()) + 1);
                if (!strSubstring2.isEmpty() && iMax <= strSubstring2.length()) {
                    if (strSubstring2.charAt(strSubstring2.length() - 1) == cCharAt) {
                        this.f5631w = j3;
                        return;
                    }
                    this.f5627s = strSubstring2 + cCharAt;
                    this.f5629u = String.valueOf(cCharAt);
                    this.f5631w = j3;
                    if (m(this.f5627s)) {
                        this.f5626r = this.f5627s;
                        return;
                    }
                    return;
                }
                int iMax2 = Math.max(iMax, strSubstring2.length());
                if (strTrim.length() > iMax2) {
                    iMax2 = strTrim.length();
                }
                if (strSubstring.length() > iMax2) {
                    strSubstring = strSubstring.substring(strSubstring.length() - iMax2);
                }
                int length2 = iMax2 - strSubstring.length();
                if (strSubstring2.length() > iMax2) {
                    strSubstring2 = strSubstring2.substring(0, iMax2);
                }
                if (strSubstring2.length() >= length2) {
                    this.f5627s = strSubstring2.substring(0, length2).concat(strSubstring);
                } else if (strSubstring2.length() == iMax2 - 1) {
                    this.f5627s = strSubstring2 + cCharAt;
                } else if (strSubstring2.length() < iMax2 && strSubstring.length() >= iMax2 - strSubstring2.length()) {
                    this.f5627s = strSubstring2.concat(strSubstring.substring(strSubstring.length() - (iMax2 - strSubstring2.length())));
                }
                this.f5629u = String.valueOf(cCharAt);
                this.f5631w = j3;
                if (m(this.f5627s)) {
                    this.f5626r = this.f5627s;
                    return;
                }
                return;
            }
        } else if (strTrim.length() == 1 && n(strTrim.charAt(0))) {
            this.f5627s = strTrim;
            this.f5629u = strTrim;
            this.f5631w = j3;
            return;
        }
        if ((p(strTrim) || strTrim.isEmpty()) && !e(strTrim2)) {
            if ((r(strTrim2) || m(strTrim2)) && strTrim2.length() >= this.f5627s.length()) {
                this.f5627s = strTrim2;
                this.f5631w = j3;
            }
        }
    }

    public final void c(char c3, long j3) {
        long j4 = this.f5631w;
        StringBuilder sb = this.f5628t;
        if (j4 > 0 && j3 - j4 > 8000 && sb.length() > 0) {
            sb.setLength(0);
            this.f5627s = "";
            this.f5626r = "";
            this.f5630v = "";
            this.f5629u = "";
        }
        sb.append(c3);
        this.f5629u = String.valueOf(c3);
        this.f5631w = j3;
        this.f5613d = j3;
    }

    public final void d() {
        synchronized (this.f5610a) {
            this.f5626r = "";
            this.f5627s = "";
            this.f5628t.setLength(0);
            this.f5629u = "";
            this.f5630v = "";
            this.f5631w = 0L;
            this.f5624p = 0;
        }
    }

    public final void g(long j3) {
        if (this.f5611b <= 0) {
            this.f5611b = j3;
            this.f5612c = Long.toString(j3, 36) + "-" + UUID.randomUUID();
        }
    }

    public final sd h() {
        String str;
        String strD = D();
        if (strD == null) {
            return null;
        }
        if (m(this.f5626r) && this.f5626r.equals(strD)) {
            str = "text";
        } else if (m(this.f5630v) && this.f5630v.equals(strD)) {
            str = "tree";
        } else if (this.f5627s.length() <= 0 || !strD.startsWith(this.f5627s)) {
            StringBuilder sb = this.f5628t;
            str = (sb.length() < 4 || !strD.equals(sb.toString())) ? "password-merge" : "char-click";
        } else {
            str = strD.length() > this.f5627s.length() ? "beforeText-lastChar" : "beforeText";
        }
        return new sd(strD, "password", str, null);
    }

    public final sd i(List list) {
        sd sdVarB;
        sd sdVarB2;
        int iC = C();
        int iMin = iC > 1 ? Math.min(iC, 4) : 4;
        String string = this.f5616g.toString();
        ArrayList arrayList = this.f5620k;
        StringBuilder sb = new StringBuilder(arrayList.size());
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            sb.append((Character) obj);
        }
        String string2 = sb.toString();
        String str = this.f5617h;
        String str2 = this.f5621l;
        if (str2 == null) {
            str2 = "";
        }
        if (l(str2) && iC > 1 && str2.length() == iC) {
            return b(iC, str2, "tree-exact");
        }
        if (l(string) && iC > 1 && string.length() >= iC) {
            return b(iC, H(string, iC), "text-exact");
        }
        if (l(string2) && iC > 1 && string2.length() == iC && (sdVarB2 = b(iC, string2, "click-exact")) != null) {
            return sdVarB2;
        }
        if (this.f5622m > 0 && l(string) && string.length() >= iMin) {
            return b(iC, H(string, iC), "text-longest");
        }
        if (l(str) && !str.isEmpty()) {
            if (iC > 1 && str.length() < iC && this.f5618i.length() == 1) {
                str = str + this.f5618i;
            }
            sd sdVarB3 = b(iC, H(str, iC), "prefix-lastClick");
            if (sdVarB3 != null) {
                return sdVarB3;
            }
        }
        if (l(string) && !string.isEmpty() && this.f5618i.length() == 1) {
            sd sdVarB4 = b(iC, H(string + this.f5618i, iC), "text-lastClick");
            if (sdVarB4 != null) {
                return sdVarB4;
            }
        }
        sd sdVarB5 = b(iC, string, "text-only");
        if (sdVarB5 != null) {
            return sdVarB5;
        }
        if (l(string2) && string2.length() >= iMin && ((str2.isEmpty() || string2.length() >= str2.length()) && (sdVarB = b(iC, H(string2, iC), "click-longest")) != null)) {
            return sdVarB;
        }
        sd sdVarB6 = b(iC, str2, "tree-fallback");
        if (sdVarB6 != null) {
            return sdVarB6;
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (str3 != null && str3.length() == 1 && str3.charAt(0) >= '0' && str3.charAt(0) <= '9') {
                sb2.append(str3.charAt(0));
            }
        }
        sd sdVarB7 = b(iC, sb2.toString(), "db-fragment");
        if (sdVarB7 != null) {
            return sdVarB7;
        }
        return null;
    }

    public final sd j(List list) {
        synchronized (this.f5610a) {
            try {
                sd sdVarH = h();
                if (sdVarH != null) {
                    LinkedHashMap linkedHashMapG = G();
                    A();
                    return new sd((String) sdVarH.f5096b, (String) sdVarH.f5095a, (String) sdVarH.f5097c, linkedHashMapG);
                }
                sd sdVarI = i(list);
                LinkedHashMap linkedHashMapG2 = G();
                A();
                if (sdVarI == null) {
                    return null;
                }
                return new sd((String) sdVarI.f5096b, (String) sdVarI.f5095a, (String) sdVarI.f5097c, linkedHashMapG2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean k() {
        boolean z2;
        synchronized (this.f5610a) {
            try {
                z2 = r(this.f5626r) || r(this.f5627s) || r(this.f5628t.toString()) || r(this.f5629u) || r(this.f5630v);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public final void s() {
        synchronized (this.f5610a) {
            this.f5615f = true;
        }
    }

    public final boolean t(char c3, float f3, float f4, long j3, boolean z2) {
        if (c3 < '0' || c3 > '9') {
            return false;
        }
        synchronized (this.f5610a) {
            try {
                g(j3);
                long j4 = this.f5613d;
                if (j4 > 0 && j3 - j4 > 8000) {
                    B(j3);
                } else if (j4 > 0 && j3 - j4 > 2000) {
                    int length = this.f5616g.length();
                    int length2 = this.f5617h.length();
                    int size = this.f5620k.size();
                    String str = this.f5621l;
                    if (Math.max(length, Math.max(length2, Math.max(size, str == null ? 0 : str.length()))) < 4) {
                        B(j3);
                    }
                }
                if (z2) {
                    long j5 = this.f5619j;
                    if (j5 > 0 && j3 - j5 < 300 && String.valueOf(c3).equals(this.f5618i)) {
                        return false;
                    }
                }
                this.f5620k.add(Character.valueOf(c3));
                this.f5618i = String.valueOf(c3);
                this.f5619j = j3;
                LinkedHashMap linkedHashMap = this.f5625q;
                Character chValueOf = Character.valueOf(c3);
                Locale locale = Locale.US;
                linkedHashMap.put(chValueOf, Float.toString(f3) + "," + Float.toString(f4));
                this.f5613d = j3;
                if (this.n < this.f5620k.size()) {
                    this.n = this.f5620k.size();
                }
                c(c3, j3);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void u(long j3) {
        String strValueOf;
        synchronized (this.f5610a) {
            try {
                if (this.f5620k.isEmpty()) {
                    return;
                }
                ArrayList arrayList = this.f5620k;
                arrayList.remove(arrayList.size() - 1);
                if (this.f5620k.isEmpty()) {
                    strValueOf = "";
                } else {
                    ArrayList arrayList2 = this.f5620k;
                    strValueOf = String.valueOf(arrayList2.get(arrayList2.size() - 1));
                }
                this.f5618i = strValueOf;
                this.f5619j = 0L;
                this.f5613d = j3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void v(char c3, long j3) {
        if (q(c3)) {
            synchronized (this.f5610a) {
                g(j3);
                c(c3, j3);
            }
        }
    }

    public final void w(long j3, String str, String str2) {
        int length;
        synchronized (this.f5610a) {
            try {
                g(j3);
                StringBuilder sb = this.f5616g;
                if (str != null && (length = str.length()) > 0 && (e(str) || l(str))) {
                    int i3 = this.f5623o;
                    if (i3 > 0 && length < i3) {
                        if (sb.length() > length) {
                            sb.setLength(length);
                        }
                        if (this.f5617h.length() > length) {
                            this.f5617h = this.f5617h.substring(0, length);
                        }
                    }
                    this.f5623o = length;
                }
                String strF = f(str);
                String strF2 = f(str2);
                if (!strF2.isEmpty()) {
                    if (strF2.length() > this.f5617h.length()) {
                        this.f5617h = strF2;
                    }
                    if (l(strF2) && strF2.length() >= this.f5616g.length()) {
                        this.f5616g.setLength(0);
                        this.f5616g.append(strF2);
                    }
                }
                if (!strF.isEmpty()) {
                    this.f5622m++;
                    boolean zE = e(str);
                    if (!zE && strF.length() == 1 && e(str2) && f(str2).isEmpty()) {
                        if (!this.f5616g.toString().endsWith(strF)) {
                            this.f5616g.append(strF);
                        }
                        if (this.n < str2.length() + 1) {
                            this.n = str2.length() + 1;
                        }
                    } else if (zE) {
                        if (!this.f5616g.toString().endsWith(strF)) {
                            this.f5616g.append(strF);
                        }
                        if (this.n < str.length()) {
                            this.n = str.length();
                        }
                    } else if (strF.length() >= 1) {
                        this.f5616g.setLength(0);
                        this.f5616g.append(strF);
                    }
                    if (strF.length() > this.f5617h.length()) {
                        this.f5617h = strF;
                    }
                    if (!zE && this.n < strF.length()) {
                        this.n = strF.length();
                    }
                } else if (!strF2.isEmpty() && strF.isEmpty() && str != null) {
                    this.f5622m++;
                }
                this.f5613d = j3;
                a(j3, str, str2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void x(String str, long j3) {
        synchronized (this.f5610a) {
            try {
                if (m(str) || r(str)) {
                    g(j3);
                    String strTrim = str.trim();
                    this.f5630v = strTrim;
                    if (m(strTrim) && strTrim.length() >= this.f5626r.length()) {
                        this.f5626r = strTrim;
                    }
                    this.f5631w = j3;
                    this.f5613d = j3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void y(String str, long j3) {
        synchronized (this.f5610a) {
            try {
                String strF = f(str);
                if (l(strF) && strF.length() >= 2) {
                    g(j3);
                    this.f5621l = strF;
                    if (this.n < strF.length()) {
                        this.n = strF.length();
                    }
                    this.f5613d = j3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String z() {
        String str;
        synchronized (this.f5610a) {
            try {
                if (D() != null) {
                    return "password";
                }
                if (i(null) == null && this.f5616g.length() < 2 && this.f5620k.size() < 2 && ((str = this.f5621l) == null || str.length() < 2)) {
                    return null;
                }
                return "pin";
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
