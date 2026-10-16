// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final v0[] f1833u = {v0.f1766d, v0.f1767e, v0.f1769g};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque f1835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f1836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EnumMap f1837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EnumMap f1838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f1840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h2.a f1841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r0 f1842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public q0 f1843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f1844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f1845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f1846m;
    public int n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public v0 f1847o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1848p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f1849q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1850r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f1851s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1852t;

    public z0() {
        h2.a aVar = new h2.a(2);
        this.f1834a = new Object();
        this.f1835b = new ArrayDeque();
        this.f1836c = new LinkedHashMap();
        this.f1837d = new EnumMap(v0.class);
        this.f1838e = new EnumMap(v0.class);
        this.f1842i = new r0(false, 1, 1, 1, 1, 33554432);
        this.f1844k = 1L;
        this.f1839f = 256;
        this.f1840g = 67108864L;
        this.f1841h = aVar;
        for (v0 v0Var : v0.values()) {
            this.f1837d.put(v0Var, 0);
            this.f1838e.put(v0Var, new w0());
        }
    }

    public static void d(ArrayList arrayList) {
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.addAll(arrayList);
        Iterator it = setNewSetFromMap.iterator();
        while (it.hasNext()) {
            ((p0) it.next()).a(false);
        }
    }

    public final void a(p0 p0Var) {
        int i3 = this.f1848p;
        List list = p0Var.f1707c;
        this.f1848p = list.size() + i3;
        long j3 = this.f1849q;
        long j4 = p0Var.f1710f;
        this.f1849q = j3 + j4;
        w0 w0Var = (w0) this.f1838e.get(p0Var.f1705a.f1759c);
        w0Var.f1785h = list.size() + w0Var.f1785h;
        w0Var.f1786i += j4;
    }

    public final void b(p0 p0Var, ArrayList arrayList) {
        q0 q0Var;
        u0 u0Var = p0Var.f1705a;
        u0 u0Var2 = u0.f1751j;
        if (u0Var != u0Var2) {
            return;
        }
        EnumMap enumMap = this.f1842i.f1725c;
        v0 v0Var = v0.f1766d;
        Integer num = (Integer) enumMap.get(v0Var);
        int iMax = Math.max(1, num == null ? 1 : num.intValue());
        while (true) {
            ArrayDeque arrayDeque = this.f1835b;
            Iterator it = arrayDeque.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (((q0) it.next()).f1715a.f1705a == u0Var2) {
                    i3++;
                }
            }
            if (i3 < iMax) {
                return;
            }
            Iterator it2 = arrayDeque.iterator();
            do {
                if (!it2.hasNext()) {
                    q0Var = null;
                    break;
                }
                q0Var = (q0) it2.next();
            } while (q0Var.f1715a.f1705a != u0Var2);
            if (q0Var == null) {
                return;
            }
            p0 p0Var2 = q0Var.f1715a;
            arrayDeque.remove(q0Var);
            q(p0Var2);
            EnumMap enumMap2 = this.f1838e;
            ((w0) enumMap2.get(v0Var)).f1779b++;
            ((w0) enumMap2.get(v0Var)).f1784g++;
            this.f1852t = true;
            arrayList.add(p0Var2);
        }
    }

    public final boolean c(int i3, long j3, boolean z2) {
        p0 p0Var;
        p0 p0Var2;
        synchronized (this.f1834a) {
            try {
                t0 t0Var = (t0) this.f1836c.remove(Long.valueOf(j3));
                if (t0Var == null) {
                    return false;
                }
                p((byte[]) t0Var.f1743a.f1715a.f1707c.get(t0Var.f1744b), t0Var.f1743a.f1715a.f1705a.f1759c);
                w0 w0Var = (w0) this.f1838e.get(t0Var.f1743a.f1715a.f1705a.f1759c);
                if (z2 || i3 == 1) {
                    m(t0Var);
                }
                if (i3 == 1) {
                    w0Var.f1792p++;
                }
                if (i3 == 2) {
                    w0Var.f1791o++;
                }
                if (!z2 && t0Var.f1743a.f1715a.f1705a.f1759c == v0.f1766d) {
                    this.f1852t = true;
                }
                if (t0Var.f1745c) {
                    p0Var = t0Var.f1743a.f1715a;
                } else {
                    q0 q0Var = this.f1843j;
                    q0 q0Var2 = t0Var.f1743a;
                    if (q0Var == q0Var2) {
                        p0Var = null;
                        if (z2) {
                            int i4 = q0Var2.f1717c + 1;
                            q0Var2.f1717c = i4;
                            if (i4 == q0Var2.f1715a.f1707c.size()) {
                                p0Var2 = t0Var.f1743a.f1715a;
                                this.f1843j = null;
                            }
                        } else {
                            r(q0Var2, t0Var.f1744b + 1);
                            p0Var2 = t0Var.f1743a.f1715a;
                            this.f1843j = null;
                        }
                        p0Var = p0Var2;
                    } else {
                        p0Var = q0Var2.f1715a;
                    }
                }
                if (p0Var != null) {
                    w0 w0Var2 = (w0) this.f1838e.get(p0Var.f1705a.f1759c);
                    if (z2) {
                        w0Var2.f1782e++;
                    } else {
                        w0Var2.f1784g++;
                    }
                }
                h();
                if (p0Var != null) {
                    p0Var.a(z2);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e(p0 p0Var) {
        return p0Var.f1707c.size() <= (this.f1839f - this.f1848p) - this.f1850r && p0Var.f1710f <= (this.f1840g - this.f1849q) - this.f1851s;
    }

    public final void f(long j3) {
        synchronized (this.f1834a) {
            try {
                t0 t0Var = (t0) this.f1836c.get(Long.valueOf(j3));
                if (t0Var != null && !t0Var.f1747e) {
                    t0Var.f1747e = true;
                    this.f1841h.getClass();
                    long jMax = Math.max(0L, System.nanoTime() - t0Var.f1746d);
                    w0 w0Var = (w0) this.f1838e.get(t0Var.f1743a.f1715a.f1705a.f1759c);
                    long j4 = jMax / 1000;
                    w0Var.f1797u++;
                    w0Var.f1799w = j4;
                    w0Var.f1798v += j4;
                    w0Var.f1800x = Math.max(w0Var.f1800x, j4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(byte[] bArr, v0 v0Var) {
        this.f1848p--;
        this.f1849q -= (long) bArr.length;
        this.f1850r++;
        this.f1851s += (long) bArr.length;
        EnumMap enumMap = this.f1837d;
        enumMap.put(v0Var, Integer.valueOf(((Integer) enumMap.get(v0Var)).intValue() + 1));
        w0 w0Var = (w0) this.f1838e.get(v0Var);
        w0Var.f1785h--;
        w0Var.f1786i -= (long) bArr.length;
        w0Var.f1787j++;
        w0Var.f1788k += (long) bArr.length;
        w0Var.a();
        h();
    }

    public final void h() {
        if (this.f1848p < 0) {
            this.f1848p = 0;
        }
        if (this.f1849q < 0) {
            this.f1849q = 0L;
        }
        if (this.f1850r < 0) {
            this.f1850r = 0;
        }
        if (this.f1851s < 0) {
            this.f1851s = 0L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a9 A[Catch: all -> 0x001e, TryCatch #0 {all -> 0x001e, blocks: (B:4:0x0008, B:6:0x000e, B:9:0x0021, B:11:0x0029, B:13:0x002f, B:14:0x0035, B:16:0x003b, B:18:0x0049, B:20:0x004d, B:22:0x0051, B:41:0x00dc, B:43:0x00e2, B:45:0x00e6, B:47:0x00ea, B:48:0x00f9, B:24:0x0068, B:25:0x006e, B:27:0x0074, B:30:0x007f, B:32:0x00a9, B:33:0x00ab, B:34:0x00af, B:36:0x00b5, B:38:0x00d6), top: B:57:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b5 A[Catch: all -> 0x001e, TryCatch #0 {all -> 0x001e, blocks: (B:4:0x0008, B:6:0x000e, B:9:0x0021, B:11:0x0029, B:13:0x002f, B:14:0x0035, B:16:0x003b, B:18:0x0049, B:20:0x004d, B:22:0x0051, B:41:0x00dc, B:43:0x00e2, B:45:0x00e6, B:47:0x00ea, B:48:0x00f9, B:24:0x0068, B:25:0x006e, B:27:0x0074, B:30:0x007f, B:32:0x00a9, B:33:0x00ab, B:34:0x00af, B:36:0x00b5, B:38:0x00d6), top: B:57:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00d6 A[Catch: all -> 0x001e, TryCatch #0 {all -> 0x001e, blocks: (B:4:0x0008, B:6:0x000e, B:9:0x0021, B:11:0x0029, B:13:0x002f, B:14:0x0035, B:16:0x003b, B:18:0x0049, B:20:0x004d, B:22:0x0051, B:41:0x00dc, B:43:0x00e2, B:45:0x00e6, B:47:0x00ea, B:48:0x00f9, B:24:0x0068, B:25:0x006e, B:27:0x0074, B:30:0x007f, B:32:0x00a9, B:33:0x00ab, B:34:0x00af, B:36:0x00b5, B:38:0x00d6), top: B:57:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ab A[SYNTHETIC] */
    public final boolean i(p0 p0Var) {
        boolean z2;
        u0 u0Var;
        q0 q0VarJ;
        p0 p0Var2;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f1834a) {
            try {
                u0 u0Var2 = p0Var.f1705a;
                if (u0Var2 != null) {
                    ((w0) this.f1838e.get(u0Var2.f1759c)).f1781d++;
                }
                if (v(p0Var)) {
                    if (p0Var.f1705a == u0.f1757q) {
                        Iterator it = this.f1835b.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                u0 u0Var3 = ((q0) it.next()).f1715a.f1705a;
                                if (u0Var3 == u0.n || u0Var3 == u0.f1755o || u0Var3 == u0.f1756p) {
                                    w0 w0Var = (w0) this.f1838e.get(v0.f1768f);
                                    w0Var.f1778a++;
                                    w0Var.f1783f++;
                                }
                            } else {
                                s(p0Var, arrayList);
                                b(p0Var, arrayList);
                                while (!e(p0Var) && (q0VarJ = j(p0Var.f1705a.f1760d)) != null) {
                                    this.f1835b.remove(q0VarJ);
                                    q(q0VarJ.f1715a);
                                    w0 w0Var2 = (w0) this.f1838e.get(q0VarJ.f1715a.f1705a.f1759c);
                                    w0Var2.f1779b++;
                                    w0Var2.f1784g++;
                                    p0Var2 = q0VarJ.f1715a;
                                    if (p0Var2.f1705a == u0.f1751j) {
                                        this.f1852t = true;
                                    }
                                    arrayList.add(p0Var2);
                                }
                                if (e(p0Var)) {
                                    ArrayDeque arrayDeque = this.f1835b;
                                    this.f1845l++;
                                    this.f1841h.getClass();
                                    arrayDeque.addLast(new q0(p0Var, System.nanoTime()));
                                    a(p0Var);
                                    if (p0Var.f1705a == u0.f1750i) {
                                        this.f1852t = false;
                                    }
                                } else {
                                    z2 = false;
                                }
                            }
                        }
                    } else {
                        s(p0Var, arrayList);
                        b(p0Var, arrayList);
                        while (!e(p0Var)) {
                            this.f1835b.remove(q0VarJ);
                            q(q0VarJ.f1715a);
                            w0 w0Var3 = (w0) this.f1838e.get(q0VarJ.f1715a.f1705a.f1759c);
                            w0Var3.f1779b++;
                            w0Var3.f1784g++;
                            p0Var2 = q0VarJ.f1715a;
                            if (p0Var2.f1705a == u0.f1751j) {
                                this.f1852t = true;
                            }
                            arrayList.add(p0Var2);
                        }
                        if (e(p0Var)) {
                            ArrayDeque arrayDeque2 = this.f1835b;
                            this.f1845l++;
                            this.f1841h.getClass();
                            arrayDeque2.addLast(new q0(p0Var, System.nanoTime()));
                            a(p0Var);
                            if (p0Var.f1705a == u0.f1750i) {
                                this.f1852t = false;
                            }
                        } else {
                            z2 = false;
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2 && p0Var.f1705a == u0.f1751j) {
                    this.f1852t = true;
                }
                if (!z2 && (u0Var = p0Var.f1705a) != null) {
                    ((w0) this.f1838e.get(u0Var.f1759c)).f1784g++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((p0) obj).a(false);
        }
        if (!z2) {
            p0Var.a(false);
        }
        return z2;
    }

    public final q0 j(int i3) {
        ArrayDeque<q0> arrayDeque = this.f1835b;
        for (q0 q0Var : arrayDeque) {
            if (q0Var.f1715a.f1705a == u0.f1751j) {
                return q0Var;
            }
        }
        if (i3 <= 0) {
            return null;
        }
        for (q0 q0Var2 : arrayDeque) {
            u0 u0Var = q0Var2.f1715a.f1705a;
            if (!u0Var.f1762f && u0Var.f1760d < i3) {
                return q0Var2;
            }
        }
        return null;
    }

    public final q0 k() {
        q0 q0VarU;
        v0 v0Var = v0.f1766d;
        q0 q0VarU2 = u(v0Var, true);
        if (q0VarU2 != null) {
            this.f1847o = v0Var;
            return q0VarU2;
        }
        v0 v0Var2 = this.f1847o;
        v0 v0Var3 = v0.f1768f;
        if (v0Var2 != v0Var3 && (q0VarU = u(v0Var3, false)) != null) {
            this.f1847o = v0Var3;
            return q0VarU;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = (this.n + i3) % 3;
            v0 v0Var4 = f1833u[i4];
            q0 q0VarU3 = u(v0Var4, false);
            if (q0VarU3 != null) {
                this.n = (i4 + 1) % 3;
                this.f1847o = v0Var4;
                return q0VarU3;
            }
        }
        q0 q0VarU4 = u(v0Var3, false);
        if (q0VarU4 != null) {
            this.f1847o = v0Var3;
        }
        return q0VarU4;
    }

    public final s0 l() {
        q0 q0VarU;
        LinkedHashMap linkedHashMap = this.f1836c;
        if (!linkedHashMap.isEmpty()) {
            return null;
        }
        if (this.f1843j == null) {
            v0 v0Var = v0.f1766d;
            q0 q0VarU2 = u(v0Var, true);
            if (q0VarU2 == null) {
                v0 v0Var2 = this.f1847o;
                v0 v0Var3 = v0.f1768f;
                if (v0Var2 == v0Var3 || (q0VarU = u(v0Var3, false)) == null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < 3) {
                            int i4 = (this.n + i3) % 3;
                            v0 v0Var4 = f1833u[i4];
                            q0 q0VarU3 = u(v0Var4, false);
                            if (q0VarU3 != null) {
                                this.n = (i4 + 1) % 3;
                                this.f1847o = v0Var4;
                                q0VarU2 = q0VarU3;
                                break;
                            }
                            i3++;
                        } else {
                            q0VarU = u(v0Var3, false);
                            if (q0VarU != null) {
                                this.f1847o = v0Var3;
                            }
                        }
                    }
                } else {
                    this.f1847o = v0Var3;
                }
                q0VarU2 = q0VarU;
                break;
            }
            this.f1847o = v0Var;
            this.f1843j = q0VarU2;
        }
        q0 q0Var = this.f1843j;
        if (q0Var == null) {
            return null;
        }
        int i5 = q0Var.f1717c;
        byte[] bArr = (byte[]) q0Var.f1715a.f1707c.get(i5);
        g(bArr, this.f1843j.f1715a.f1705a.f1759c);
        long j3 = this.f1846m + 1;
        this.f1846m = j3;
        this.f1841h.getClass();
        long jNanoTime = System.nanoTime();
        n(this.f1843j, jNanoTime);
        linkedHashMap.put(Long.valueOf(j3), new t0(this.f1843j, i5, false, jNanoTime));
        long j4 = this.f1844k;
        p0 p0Var = this.f1843j.f1715a;
        return new s0(j3, j4, p0Var.f1705a.f1759c, p0Var.f1706b, bArr, false);
    }

    public final void m(t0 t0Var) {
        this.f1841h.getClass();
        long jMax = Math.max(0L, System.nanoTime() - t0Var.f1746d) / 1000000;
        w0 w0Var = (w0) this.f1838e.get(t0Var.f1743a.f1715a.f1705a.f1759c);
        w0Var.f1780c++;
        w0Var.f1790m = jMax;
        w0Var.f1789l += jMax;
        w0Var.n = Math.max(w0Var.n, jMax);
        long[] jArr = w0Var.f1801y;
        int i3 = w0Var.A;
        jArr[i3] = jMax;
        w0Var.A = (i3 + 1) % 64;
        int i4 = w0Var.f1802z;
        if (i4 < 64) {
            w0Var.f1802z = i4 + 1;
        }
    }

    public final void n(q0 q0Var, long j3) {
        long jMax = Math.max(0L, j3 - q0Var.f1716b) / 1000;
        w0 w0Var = (w0) this.f1838e.get(q0Var.f1715a.f1705a.f1759c);
        w0Var.f1793q++;
        w0Var.f1795s = jMax;
        w0Var.f1794r += jMax;
        w0Var.f1796t = Math.max(w0Var.f1796t, jMax);
    }

    public final void o(ArrayList arrayList) {
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.addAll(arrayList);
        Iterator it = setNewSetFromMap.iterator();
        while (it.hasNext()) {
            ((w0) this.f1838e.get(((p0) it.next()).f1705a.f1759c)).f1784g++;
        }
    }

    public final void p(byte[] bArr, v0 v0Var) {
        this.f1850r--;
        this.f1851s -= (long) bArr.length;
        EnumMap enumMap = this.f1837d;
        enumMap.put(v0Var, Integer.valueOf(Math.max(0, ((Integer) enumMap.get(v0Var)).intValue() - 1)));
        w0 w0Var = (w0) this.f1838e.get(v0Var);
        w0Var.f1787j--;
        w0Var.f1788k -= (long) bArr.length;
        w0Var.a();
        h();
    }

    public final void q(p0 p0Var) {
        int i3 = this.f1848p;
        List list = p0Var.f1707c;
        this.f1848p = i3 - list.size();
        long j3 = this.f1849q;
        long j4 = p0Var.f1710f;
        this.f1849q = j3 - j4;
        w0 w0Var = (w0) this.f1838e.get(p0Var.f1705a.f1759c);
        w0Var.f1785h -= list.size();
        w0Var.f1786i -= j4;
        w0Var.a();
        h();
    }

    public final void r(q0 q0Var, int i3) {
        while (true) {
            p0 p0Var = q0Var.f1715a;
            if (i3 >= p0Var.f1707c.size()) {
                return;
            }
            byte[] bArr = (byte[]) p0Var.f1707c.get(i3);
            this.f1848p--;
            this.f1849q -= (long) bArr.length;
            w0 w0Var = (w0) this.f1838e.get(p0Var.f1705a.f1759c);
            w0Var.f1785h--;
            w0Var.f1786i -= (long) bArr.length;
            w0Var.a();
            i3++;
        }
    }

    public final void s(p0 p0Var, ArrayList arrayList) {
        u0 u0Var = p0Var.f1705a;
        if (u0Var.f1761e == null) {
            return;
        }
        Iterator it = this.f1835b.iterator();
        while (it.hasNext()) {
            q0 q0Var = (q0) it.next();
            String str = u0Var.f1761e;
            p0 p0Var2 = q0Var.f1715a;
            u0 u0Var2 = p0Var2.f1705a;
            if (str.equals(p0Var2.f1705a.f1761e)) {
                it.remove();
                q(p0Var2);
                v0 v0Var = u0Var2.f1759c;
                EnumMap enumMap = this.f1838e;
                ((w0) enumMap.get(v0Var)).f1778a++;
                ((w0) enumMap.get(u0Var2.f1759c)).f1783f++;
                arrayList.add(p0Var2);
            }
        }
    }

    public final void t(r0 r0Var) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f1834a) {
            try {
                q0 q0Var = this.f1843j;
                if (q0Var != null) {
                    arrayList.add(q0Var.f1715a);
                }
                Iterator it = this.f1836c.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(((t0) it.next()).f1743a.f1715a);
                }
                Iterator it2 = this.f1835b.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((q0) it2.next()).f1715a);
                }
                this.f1835b.clear();
                this.f1836c.clear();
                this.f1843j = null;
                this.f1848p = 0;
                this.f1849q = 0L;
                this.f1850r = 0;
                this.f1851s = 0L;
                this.f1852t = false;
                this.n = 0;
                this.f1847o = null;
                for (v0 v0Var : v0.values()) {
                    this.f1837d.put(v0Var, 0);
                }
                for (w0 w0Var : this.f1838e.values()) {
                    w0Var.f1785h = 0;
                    w0Var.f1786i = 0L;
                    w0Var.f1787j = 0;
                    w0Var.f1788k = 0L;
                }
                o(arrayList);
                this.f1842i = r0Var;
                this.f1844k++;
            } catch (Throwable th) {
                throw th;
            }
        }
        d(arrayList);
    }

    public final q0 u(v0 v0Var, boolean z2) {
        Integer num = (Integer) this.f1842i.f1725c.get(v0Var);
        int iIntValue = num == null ? 1 : num.intValue();
        if (v0Var == v0.f1767e) {
            iIntValue = Math.min(iIntValue, 1);
        }
        if (((Integer) this.f1837d.get(v0Var)).intValue() >= iIntValue) {
            return null;
        }
        Iterator it = this.f1835b.iterator();
        while (it.hasNext()) {
            q0 q0Var = (q0) it.next();
            u0 u0Var = q0Var.f1715a.f1705a;
            if (u0Var.f1759c == v0Var && (!z2 || u0Var.f1762f)) {
                it.remove();
                return q0Var;
            }
        }
        return null;
    }

    public final boolean v(p0 p0Var) {
        String str;
        List<byte[]> list = p0Var.f1707c;
        if (p0Var.f1705a == null || (str = p0Var.f1706b) == null || str.isEmpty() || list.isEmpty() || list.size() > 240 || list.size() > this.f1839f || p0Var.f1710f > this.f1840g) {
            return false;
        }
        if (this.f1842i.f1723a && list.size() != 1) {
            return false;
        }
        for (byte[] bArr : list) {
            if (bArr == null || bArr.length == 0 || !q2.c.s(bArr.length)) {
                return false;
            }
        }
        return true;
    }
}
