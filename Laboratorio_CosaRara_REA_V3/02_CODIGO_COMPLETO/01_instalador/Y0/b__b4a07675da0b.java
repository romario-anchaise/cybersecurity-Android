// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Y0;

import F0.i;
import H.C0028c;
import M0.d;
import M0.e;
import M0.m;
import X0.D;
import X0.F;
import X0.n;
import X0.p;
import X0.w;
import e1.C0109b;
import f1.l;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import k1.C;
import k1.C0193i;
import k1.C0196l;
import k1.I;
import k1.y;
import p036u0.f;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f1119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f1120b = l.G(new String[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final F f1121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f1122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeZone f1123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f1124f;
    public static final String g;

    static {
        int i2;
        int iCompareTo;
        byte[] bArr = new byte[0];
        f1119a = bArr;
        C0193i c0193i = new C0193i();
        c0193i.O(bArr, 0, 0);
        long j2 = 0;
        f1121c = new F(null, j2, c0193i, 0);
        c(j2, j2, j2);
        C0196l c0196l = C0196l.f3483d;
        C0196l[] c0196lArr = {C0028c.n("efbbbf"), C0028c.n("feff"), C0028c.n("fffe"), C0028c.n("0000ffff"), C0028c.n("ffff0000")};
        ArrayList arrayList = new ArrayList(new p021m.d(1, c0196lArr));
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList2.add(-1);
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < 5) {
            C0196l c0196l2 = c0196lArr[i4];
            int i6 = i5 + 1;
            int size2 = arrayList.size();
            int size3 = arrayList.size();
            if (size2 < 0) {
                throw new IllegalArgumentException("fromIndex (0) is greater than toIndex (" + size2 + ").");
            }
            if (size2 > size3) {
                throw new IndexOutOfBoundsException("toIndex (" + size2 + ") is greater than size (" + size3 + ").");
            }
            int i7 = size2 - 1;
            int i8 = 0;
            while (true) {
                if (i8 > i7) {
                    i2 = -(i8 + 1);
                    break;
                }
                i2 = (i8 + i7) >>> 1;
                Comparable comparable = (Comparable) arrayList.get(i2);
                if (comparable == c0196l2) {
                    iCompareTo = 0;
                } else if (comparable == null) {
                    iCompareTo = -1;
                } else {
                    iCompareTo = c0196l2 == null ? 1 : comparable.compareTo(c0196l2);
                }
                if (iCompareTo < 0) {
                    i8 = i2 + 1;
                } else if (iCompareTo <= 0) {
                    break;
                } else {
                    i7 = i2 - 1;
                }
            }
            arrayList2.set(i2, Integer.valueOf(i5));
            i4++;
            i5 = i6;
        }
        if (((C0196l) arrayList.get(0)).c() <= 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i9 = 0;
        while (i9 < arrayList.size()) {
            C0196l c0196l3 = (C0196l) arrayList.get(i9);
            int i10 = i9 + 1;
            int i11 = i10;
            while (i11 < arrayList.size()) {
                C0196l c0196l4 = (C0196l) arrayList.get(i11);
                c0196l4.getClass();
                i.e(c0196l3, "prefix");
                if (!c0196l4.k(0, c0196l3, c0196l3.c())) {
                    break;
                }
                if (c0196l4.c() == c0196l3.c()) {
                    throw new IllegalArgumentException(("duplicate option: " + c0196l4).toString());
                }
                if (((Number) arrayList2.get(i11)).intValue() > ((Number) arrayList2.get(i9)).intValue()) {
                    arrayList.remove(i11);
                    arrayList2.remove(i11);
                } else {
                    i11++;
                }
            }
            i9 = i10;
        }
        C0193i c0193i2 = new C0193i();
        f1.d.e(0L, c0193i2, 0, arrayList, 0, arrayList.size(), arrayList2);
        int i12 = (int) (c0193i2.f3482b / ((long) 4));
        int[] iArr = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            iArr[i13] = c0193i2.F();
        }
        Object[] objArrCopyOf = Arrays.copyOf(c0196lArr, 5);
        i.d(objArrCopyOf, "copyOf(...)");
        f1122d = new y((C0196l[]) objArrCopyOf, iArr);
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        i.b(timeZone);
        f1123e = timeZone;
        f1124f = new d("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        String strC0 = e.c0(w.class.getName(), "okhttp3.");
        if (m.L(strC0, "Client", false)) {
            strC0 = strC0.substring(0, strC0.length() - 6);
            i.d(strC0, "substring(...)");
        }
        g = strC0;
    }

    public static final boolean a(p pVar, p pVar2) {
        i.e(pVar, "<this>");
        i.e(pVar2, "other");
        return i.a(pVar.f1024d, pVar2.f1024d) && pVar.f1025e == pVar2.f1025e && i.a(pVar.f1021a, pVar2.f1021a);
    }

    public static final int b(long j2, TimeUnit timeUnit) {
        if (j2 < 0) {
            throw new IllegalStateException("timeout".concat(" < 0").toString());
        }
        long millis = timeUnit.toMillis(j2);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("timeout".concat(" too large.").toString());
        }
        if (millis != 0 || j2 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException("timeout".concat(" too small.").toString());
    }

    public static final void c(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void d(Closeable closeable) {
        i.e(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final void e(Socket socket) {
        i.e(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (!i.a(e3.getMessage(), "bio == null")) {
                throw e3;
            }
        } catch (Exception unused) {
        }
    }

    public static final int f(String str, char c2, int i2, int i3) {
        i.e(str, "<this>");
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static final int g(String str, int i2, int i3, String str2) {
        i.e(str, "<this>");
        while (i2 < i3) {
            if (e.S(str2, str.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static final boolean h(I i2, TimeUnit timeUnit) {
        i.e(timeUnit, "timeUnit");
        try {
            return t(i2, 100, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String i(String str, Object... objArr) {
        i.e(str, "format");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final boolean j(String[] strArr, String[] strArr2, Comparator comparator) {
        i.e(strArr, "<this>");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                int i2 = 0;
                while (true) {
                    if (i2 < strArr2.length) {
                        int i3 = i2 + 1;
                        try {
                            if (comparator.compare(str, strArr2[i2]) == 0) {
                                return true;
                            }
                            i2 = i3;
                        } catch (ArrayIndexOutOfBoundsException e2) {
                            throw new NoSuchElementException(e2.getMessage());
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long k(D d2) {
        String strA = d2.f909f.a("Content-Length");
        if (strA == null) {
            return -1L;
        }
        try {
            return Long.parseLong(strA);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final List l(Object... objArr) {
        i.e(objArr, "elements");
        Object[] objArr2 = (Object[]) objArr.clone();
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
        i.e(objArrCopyOf, "elements");
        List listUnmodifiableList = Collections.unmodifiableList(objArrCopyOf.length > 0 ? p036u0.e.p(objArrCopyOf) : p036u0.n.f4146a);
        i.d(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int m(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (i.f(cCharAt, 31) <= 0 || i.f(cCharAt, 127) >= 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int n(String str, int i2, int i3) {
        i.e(str, "<this>");
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static final int o(String str, int i2, int i3) {
        i.e(str, "<this>");
        int i4 = i3 - 1;
        if (i2 <= i4) {
            while (true) {
                char cCharAt = str.charAt(i4);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i4 + 1;
                }
                if (i4 != i2) {
                    i4--;
                }
            }
        }
        return i2;
    }

    public static final String[] p(String[] strArr, String[] strArr2, Comparator comparator) {
        i.e(strArr2, "other");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean q(String str) {
        i.e(str, "name");
        return str.equalsIgnoreCase("Authorization") || str.equalsIgnoreCase("Cookie") || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase("Set-Cookie");
    }

    public static final int r(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        if ('a' <= c2 && c2 < 'g') {
            return c2 - 'W';
        }
        if ('A' > c2 || c2 >= 'G') {
            return -1;
        }
        return c2 - '7';
    }

    public static final int s(C c2) {
        i.e(c2, "<this>");
        return (c2.j() & 255) | ((c2.j() & 255) << 16) | ((c2.j() & 255) << 8);
    }

    public static final boolean t(I i2, int i3, TimeUnit timeUnit) {
        i.e(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = i2.c().e() ? i2.c().c() - jNanoTime : Long.MAX_VALUE;
        i2.c().d(Math.min(jC, timeUnit.toNanos(i3)) + jNanoTime);
        try {
            C0193i c0193i = new C0193i();
            while (i2.m(c0193i, 8192L) != -1) {
                c0193i.t();
            }
            if (jC == Long.MAX_VALUE) {
                i2.c().a();
            } else {
                i2.c().d(jNanoTime + jC);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                i2.c().a();
            } else {
                i2.c().d(jNanoTime + jC);
            }
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                i2.c().a();
            } else {
                i2.c().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final n u(List list) {
        ArrayList arrayList = new ArrayList(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0109b c0109b = (C0109b) it.next();
            String strP = c0109b.f2281a.p();
            String strP2 = c0109b.f2282b.p();
            arrayList.add(strP);
            arrayList.add(e.j0(strP2).toString());
        }
        return new n((String[]) arrayList.toArray(new String[0]));
    }

    public static final String v(p pVar, boolean z2) {
        int i2;
        i.e(pVar, "<this>");
        String str = pVar.f1024d;
        if (e.T(str, ":")) {
            str = "[" + str + ']';
        }
        int i3 = pVar.f1025e;
        if (!z2) {
            String str2 = pVar.f1021a;
            i.e(str2, "scheme");
            if (str2.equals("http")) {
                i2 = 80;
            } else {
                i2 = str2.equals("https") ? 443 : -1;
            }
            if (i3 == i2) {
                return str;
            }
        }
        return str + ':' + i3;
    }

    public static final List w(List list) {
        i.e(list, "<this>");
        List listUnmodifiableList = Collections.unmodifiableList(f.C(list));
        i.d(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final int x(int i2, String str) {
        if (str == null) {
            return i2;
        }
        try {
            long j2 = Long.parseLong(str);
            if (j2 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j2 < 0) {
                return 0;
            }
            return (int) j2;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static final String y(String str, int i2, int i3) {
        int iN = n(str, i2, i3);
        String strSubstring = str.substring(iN, o(str, iN, i3));
        i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
