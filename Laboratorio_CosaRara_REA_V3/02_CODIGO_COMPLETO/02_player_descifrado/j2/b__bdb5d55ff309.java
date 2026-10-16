// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j2;

import i1.g;
import i2.c;
import i2.o;
import i2.q;
import i2.u;
import i2.y;
import i2.z;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
import q1.e;
import q1.i;
import v1.d;
import v1.l;
import w1.j4;
import w1.o2;
import w2.h;
import w2.j;
import w2.k;
import w2.p;
import w2.x;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f2361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f2362b = c.h(new String[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z f2363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f2364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeZone f2365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i f2366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f2367g;

    static {
        int i3;
        int iCompareTo;
        byte[] bArr = new byte[0];
        f2361a = bArr;
        h hVar = new h();
        hVar.G(0, bArr);
        long j3 = 0;
        f2363c = new z(j3, hVar);
        c(j3, j3, j3);
        k kVar = k.f5778f;
        k[] kVarArr = {e0.i.b("efbbbf"), e0.i.b("feff"), e0.i.b("fffe"), e0.i.b("0000ffff"), e0.i.b("ffff0000")};
        ArrayList arrayList = new ArrayList(new g(kVarArr, false));
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(5);
        for (int i4 = 0; i4 < 5; i4++) {
            k kVar2 = kVarArr[i4];
            arrayList2.add(-1);
        }
        Integer[] numArr = (Integer[]) arrayList2.toArray(new Integer[0]);
        Object[] objArrCopyOf = Arrays.copyOf(numArr, numArr.length);
        ArrayList arrayList3 = objArrCopyOf.length == 0 ? new ArrayList() : new ArrayList(new g(objArrCopyOf, true));
        int i5 = 0;
        int i6 = 0;
        while (i5 < 5) {
            k kVar3 = kVarArr[i5];
            int i7 = i6 + 1;
            int size = arrayList.size();
            int size2 = arrayList.size();
            if (size < 0) {
                o2.i(j4.c(size, "fromIndex (0) is greater than toIndex (", ")."));
                return;
            }
            if (size > size2) {
                throw new IndexOutOfBoundsException("toIndex (" + size + ") is greater than size (" + size2 + ").");
            }
            int i8 = size - 1;
            int i9 = 0;
            while (true) {
                if (i9 > i8) {
                    i3 = -(i9 + 1);
                    break;
                }
                i3 = (i9 + i8) >>> 1;
                Comparable comparable = (Comparable) arrayList.get(i3);
                if (comparable == kVar3) {
                    iCompareTo = 0;
                } else if (comparable == null) {
                    iCompareTo = -1;
                } else {
                    iCompareTo = kVar3 == null ? 1 : comparable.compareTo(kVar3);
                }
                if (iCompareTo < 0) {
                    i9 = i3 + 1;
                } else if (iCompareTo <= 0) {
                    break;
                } else {
                    i8 = i3 - 1;
                }
            }
            arrayList3.set(i3, Integer.valueOf(i6));
            i5++;
            i6 = i7;
        }
        if (((k) arrayList.get(0)).c() <= 0) {
            o2.i("the empty byte string is not a supported option");
            return;
        }
        int i10 = 0;
        while (i10 < arrayList.size()) {
            k kVar4 = (k) arrayList.get(i10);
            int i11 = i10 + 1;
            int i12 = i11;
            while (i12 < arrayList.size()) {
                k kVar5 = (k) arrayList.get(i12);
                kVar5.getClass();
                kVar4.getClass();
                if (!kVar5.g(kVar4.c(), kVar4)) {
                    break;
                }
                if (kVar5.c() == kVar4.c()) {
                    b2.a.l(kVar5, "duplicate option: ");
                    return;
                } else if (((Number) arrayList3.get(i12)).intValue() > ((Number) arrayList3.get(i10)).intValue()) {
                    arrayList.remove(i12);
                    arrayList3.remove(i12);
                } else {
                    i12++;
                }
            }
            i10 = i11;
        }
        h hVar2 = new h();
        w2.b.b(0L, hVar2, 0, arrayList, 0, arrayList.size(), arrayList3);
        int[] iArr = new int[(int) (hVar2.f5777d / ((long) 4))];
        int i13 = 0;
        while (!hVar2.w()) {
            iArr[i13] = hVar2.readInt();
            i13++;
        }
        f2364d = new p((k[]) Arrays.copyOf(kVarArr, 5), iArr);
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        timeZone.getClass();
        f2365e = timeZone;
        f2366f = new i(1);
        String name = u.class.getName();
        if (l.z(name, "okhttp3.", false)) {
            name = name.substring("okhttp3.".length());
        }
        if (name.endsWith("Client")) {
            name = name.substring(0, name.length() - 6);
        }
        f2367g = name;
    }

    public static final boolean a(q qVar, q qVar2) {
        qVar.getClass();
        qVar2.getClass();
        return e.a(qVar.f2203d, qVar2.f2203d) && qVar.f2204e == qVar2.f2204e && e.a(qVar.f2200a, qVar2.f2200a);
    }

    public static final int b(long j3, TimeUnit timeUnit) {
        if (j3 < 0) {
            b2.a.b("timeout".concat(" < 0"));
            return 0;
        }
        if (timeUnit == null) {
            o2.k("unit == null");
            return 0;
        }
        long millis = timeUnit.toMillis(j3);
        if (millis > 2147483647L) {
            o2.h("timeout".concat(" too large."));
            return 0;
        }
        if (millis != 0 || j3 <= 0) {
            return (int) millis;
        }
        o2.h("timeout".concat(" too small."));
        return 0;
    }

    public static final void c(long j3, long j4, long j5) {
        if ((j4 | j5) < 0 || j4 > j3 || j3 - j4 < j5) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void d(Closeable closeable) {
        closeable.getClass();
        try {
            closeable.close();
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception unused) {
        }
    }

    public static final void e(Socket socket) {
        socket.getClass();
        try {
            socket.close();
        } catch (AssertionError e3) {
            throw e3;
        } catch (RuntimeException e4) {
            if (!e.a(e4.getMessage(), "bio == null")) {
                throw e4;
            }
        } catch (Exception unused) {
        }
    }

    public static final int f(int i3, int i4, String str, String str2) {
        str.getClass();
        while (i3 < i4) {
            if (d.A(str2, str.charAt(i3))) {
                return i3;
            }
            i3++;
        }
        return i4;
    }

    public static final int g(String str, char c3, int i3, int i4) {
        str.getClass();
        while (i3 < i4) {
            if (str.charAt(i3) == c3) {
                return i3;
            }
            i3++;
        }
        return i4;
    }

    public static /* synthetic */ int h(String str, char c3, int i3, int i4, int i5) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = str.length();
        }
        return g(str, c3, i3, i4);
    }

    public static final String i(String str, Object... objArr) {
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final boolean j(String[] strArr, String[] strArr2, Comparator comparator) {
        strArr.getClass();
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                int i3 = 0;
                while (true) {
                    if (i3 < strArr2.length) {
                        int i4 = i3 + 1;
                        try {
                            if (comparator.compare(str, strArr2[i3]) == 0) {
                                return true;
                            }
                            i3 = i4;
                        } catch (ArrayIndexOutOfBoundsException e3) {
                            throw new NoSuchElementException(e3.getMessage());
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long k(y yVar) {
        String strA = yVar.f2292h.a("Content-Length");
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
        List listAsList;
        Object[] objArr2 = (Object[]) objArr.clone();
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
        if (objArrCopyOf.length > 0) {
            listAsList = Arrays.asList(objArrCopyOf);
            listAsList.getClass();
        } else {
            listAsList = i1.q.f2104c;
        }
        List listUnmodifiableList = Collections.unmodifiableList(listAsList);
        listUnmodifiableList.getClass();
        return listUnmodifiableList;
    }

    public static final int m(String str) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (e.b(cCharAt, 31) <= 0 || e.b(cCharAt, 127) >= 0) {
                return i3;
            }
        }
        return -1;
    }

    public static final int n(int i3, int i4, String str) {
        str.getClass();
        while (i3 < i4) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i3;
            }
            i3++;
        }
        return i4;
    }

    public static final int o(int i3, int i4, String str) {
        str.getClass();
        int i5 = i4 - 1;
        if (i3 <= i5) {
            while (true) {
                char cCharAt = str.charAt(i5);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i5 + 1;
                }
                if (i5 != i3) {
                    i5--;
                }
            }
        }
        return i3;
    }

    public static final String[] p(String[] strArr, String[] strArr2, Comparator comparator) {
        strArr2.getClass();
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
        str.getClass();
        return str.equalsIgnoreCase("Authorization") || str.equalsIgnoreCase("Cookie") || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase("Set-Cookie");
    }

    public static final int r(char c3) {
        if ('0' <= c3 && c3 < ':') {
            return c3 - '0';
        }
        if ('a' <= c3 && c3 < 'g') {
            return c3 - 'W';
        }
        if ('A' > c3 || c3 >= 'G') {
            return -1;
        }
        return c3 - '7';
    }

    public static final Charset s(j jVar, Charset charset) {
        jVar.getClass();
        charset.getClass();
        int iK = jVar.k(f2364d);
        if (iK == -1) {
            return charset;
        }
        if (iK == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            charset2.getClass();
            return charset2;
        }
        if (iK == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            charset3.getClass();
            return charset3;
        }
        if (iK == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            charset4.getClass();
            return charset4;
        }
        if (iK == 3) {
            Charset charset5 = v1.a.f3277a;
            Charset charset6 = v1.a.f3279c;
            if (charset6 != null) {
                return charset6;
            }
            Charset charsetForName = Charset.forName("UTF-32BE");
            charsetForName.getClass();
            v1.a.f3279c = charsetForName;
            return charsetForName;
        }
        if (iK != 4) {
            throw new AssertionError();
        }
        Charset charset7 = v1.a.f3277a;
        Charset charset8 = v1.a.f3278b;
        if (charset8 != null) {
            return charset8;
        }
        Charset charsetForName2 = Charset.forName("UTF-32LE");
        charsetForName2.getClass();
        v1.a.f3278b = charsetForName2;
        return charsetForName2;
    }

    public static final int t(j jVar) {
        jVar.getClass();
        return (jVar.readByte() & 255) | ((jVar.readByte() & 255) << 16) | ((jVar.readByte() & 255) << 8);
    }

    public static final boolean u(x xVar, int i3) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.getClass();
        long jNanoTime = System.nanoTime();
        long jC = xVar.a().e() ? xVar.a().c() - jNanoTime : Long.MAX_VALUE;
        xVar.a().d(Math.min(jC, timeUnit.toNanos(i3)) + jNanoTime);
        try {
            h hVar = new h();
            while (xVar.f(8192L, hVar) != -1) {
                hVar.skip(hVar.f5777d);
            }
            if (jC == Long.MAX_VALUE) {
                xVar.a().a();
                return true;
            }
            xVar.a().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                xVar.a().a();
                return false;
            }
            xVar.a().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                xVar.a().a();
            } else {
                xVar.a().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final o v(List list) {
        ArrayList arrayList = new ArrayList(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p2.b bVar = (p2.b) it.next();
            k kVar = bVar.f2882a;
            k kVar2 = bVar.f2883b;
            String strK = kVar.k();
            String strK2 = kVar2.k();
            arrayList.add(strK);
            arrayList.add(d.J(strK2).toString());
        }
        return new o((String[]) arrayList.toArray(new String[0]));
    }

    public static final String w(q qVar, boolean z2) {
        int i3;
        qVar.getClass();
        int i4 = qVar.f2204e;
        String str = qVar.f2203d;
        if (d.B(str, ":")) {
            str = "[" + str + ']';
        }
        if (!z2) {
            String str2 = qVar.f2200a;
            str2.getClass();
            if (str2.equals("http")) {
                i3 = 80;
            } else {
                i3 = str2.equals("https") ? 443 : -1;
            }
            if (i4 == i3) {
                return str;
            }
        }
        return str + ':' + i4;
    }

    public static final List x(List list) {
        list.getClass();
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        listUnmodifiableList.getClass();
        return listUnmodifiableList;
    }

    public static final int y(String str, int i3) {
        if (str != null) {
            try {
                long j3 = Long.parseLong(str);
                if (j3 > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (j3 < 0) {
                    return 0;
                }
                return (int) j3;
            } catch (NumberFormatException unused) {
            }
        }
        return i3;
    }
}
