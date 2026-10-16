// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Map, Serializable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final f f2341p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f2342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object[] f2343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f2344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f2345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2350k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f2351l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h f2352m;
    public g n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2353o;

    static {
        f fVar = new f(0);
        fVar.f2353o = true;
        f2341p = fVar;
    }

    public f(int i3) {
        if (i3 < 0) {
            o2.i("capacity must be non-negative.");
            throw null;
        }
        Object[] objArr = new Object[i3];
        int[] iArr = new int[i3];
        int iHighestOneBit = Integer.highestOneBit((i3 < 1 ? 1 : i3) * 3);
        this.f2342c = objArr;
        this.f2343d = null;
        this.f2344e = iArr;
        this.f2345f = new int[iHighestOneBit];
        this.f2346g = 2;
        this.f2347h = 0;
        this.f2348i = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }

    public final int a(Object obj) {
        b();
        while (true) {
            int iH = h(obj);
            int i3 = this.f2346g * 2;
            int length = this.f2345f.length / 2;
            if (i3 > length) {
                i3 = length;
            }
            int i4 = 0;
            while (true) {
                int[] iArr = this.f2345f;
                int i5 = iArr[iH];
                if (i5 <= 0) {
                    int i6 = this.f2347h;
                    Object[] objArr = this.f2342c;
                    if (i6 >= objArr.length) {
                        e(1);
                        break;
                    }
                    int i7 = i6 + 1;
                    this.f2347h = i7;
                    objArr[i6] = obj;
                    this.f2344e[i6] = iH;
                    iArr[iH] = i7;
                    this.f2350k++;
                    this.f2349j++;
                    if (i4 > this.f2346g) {
                        this.f2346g = i4;
                    }
                    return i6;
                }
                if (q1.e.a(this.f2342c[i5 - 1], obj)) {
                    return -i5;
                }
                i4++;
                if (i4 > i3) {
                    i(this.f2345f.length * 2);
                    break;
                }
                iH = iH == 0 ? this.f2345f.length - 1 : iH - 1;
            }
        }
    }

    public final void b() {
        if (this.f2353o) {
            throw new UnsupportedOperationException();
        }
    }

    public final void c(boolean z2) {
        int i3;
        Object[] objArr = this.f2343d;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i3 = this.f2347h;
            if (i4 >= i3) {
                break;
            }
            int[] iArr = this.f2344e;
            int i6 = iArr[i4];
            if (i6 >= 0) {
                Object[] objArr2 = this.f2342c;
                objArr2[i5] = objArr2[i4];
                if (objArr != null) {
                    objArr[i5] = objArr[i4];
                }
                if (z2) {
                    iArr[i5] = i6;
                    this.f2345f[i6] = i5 + 1;
                }
                i5++;
            }
            i4++;
        }
        m0.a.s(this.f2342c, i5, i3);
        if (objArr != null) {
            m0.a.s(objArr, i5, this.f2347h);
        }
        this.f2347h = i5;
    }

    @Override // java.util.Map
    public final void clear() {
        b();
        int i3 = this.f2347h - 1;
        if (i3 >= 0) {
            int i4 = 0;
            while (true) {
                int[] iArr = this.f2344e;
                int i5 = iArr[i4];
                if (i5 >= 0) {
                    this.f2345f[i5] = 0;
                    iArr[i4] = -1;
                }
                if (i4 == i3) {
                    break;
                } else {
                    i4++;
                }
            }
        }
        m0.a.s(this.f2342c, 0, this.f2347h);
        Object[] objArr = this.f2343d;
        if (objArr != null) {
            m0.a.s(objArr, 0, this.f2347h);
        }
        this.f2350k = 0;
        this.f2347h = 0;
        this.f2349j++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final boolean d(Collection collection) {
        boolean zA;
        collection.getClass();
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    Map.Entry entry = (Map.Entry) obj;
                    int iF = f(entry.getKey());
                    if (iF < 0) {
                        zA = false;
                    } else {
                        Object[] objArr = this.f2343d;
                        objArr.getClass();
                        zA = q1.e.a(objArr[iF], entry.getValue());
                    }
                    if (!zA) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final void e(int i3) {
        Object[] objArr = this.f2342c;
        int length = objArr.length;
        int i4 = this.f2347h;
        int i5 = length - i4;
        int i6 = i4 - this.f2350k;
        if (i5 < i3 && i5 + i6 >= i3 && i6 >= objArr.length / 4) {
            c(true);
            return;
        }
        int i7 = i4 + i3;
        if (i7 < 0) {
            throw new OutOfMemoryError();
        }
        if (i7 > objArr.length) {
            int length2 = objArr.length;
            int i8 = length2 + (length2 >> 1);
            if (i8 - i7 < 0) {
                i8 = i7;
            }
            if (i8 - 2147483639 > 0) {
                i8 = i7 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            this.f2342c = Arrays.copyOf(objArr, i8);
            Object[] objArr2 = this.f2343d;
            this.f2343d = objArr2 != null ? Arrays.copyOf(objArr2, i8) : null;
            this.f2344e = Arrays.copyOf(this.f2344e, i8);
            int iHighestOneBit = Integer.highestOneBit((i8 >= 1 ? i8 : 1) * 3);
            if (iHighestOneBit > this.f2345f.length) {
                i(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        g gVar = this.n;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 0);
        this.n = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.f2350k == map.size() && d(map.entrySet());
    }

    public final int f(Object obj) {
        int iH = h(obj);
        int i3 = this.f2346g;
        while (true) {
            int i4 = this.f2345f[iH];
            if (i4 == 0) {
                return -1;
            }
            if (i4 > 0) {
                int i5 = i4 - 1;
                if (q1.e.a(this.f2342c[i5], obj)) {
                    return i5;
                }
            }
            i3--;
            if (i3 < 0) {
                return -1;
            }
            iH = iH == 0 ? this.f2345f.length - 1 : iH - 1;
        }
    }

    public final int g(Object obj) {
        int i3 = this.f2347h;
        while (true) {
            i3--;
            if (i3 < 0) {
                return -1;
            }
            if (this.f2344e[i3] >= 0) {
                Object[] objArr = this.f2343d;
                objArr.getClass();
                if (q1.e.a(objArr[i3], obj)) {
                    return i3;
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iF = f(obj);
        if (iF < 0) {
            return null;
        }
        Object[] objArr = this.f2343d;
        objArr.getClass();
        return objArr[iF];
    }

    public final int h(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f2348i;
    }

    @Override // java.util.Map
    public final int hashCode() {
        d dVar = new d(this, 0);
        int i3 = 0;
        while (dVar.hasNext()) {
            int i4 = dVar.f2334d;
            f fVar = dVar.f2333c;
            if (i4 >= fVar.f2347h) {
                throw new NoSuchElementException();
            }
            dVar.f2334d = i4 + 1;
            dVar.f2335e = i4;
            Object obj = fVar.f2342c[i4];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = fVar.f2343d;
            objArr.getClass();
            Object obj2 = objArr[dVar.f2335e];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            dVar.b();
            i3 += iHashCode ^ iHashCode2;
        }
        return i3;
    }

    public final void i(int i3) {
        int[] iArr;
        this.f2349j++;
        int i4 = 0;
        if (this.f2347h > this.f2350k) {
            c(false);
        }
        this.f2345f = new int[i3];
        this.f2348i = Integer.numberOfLeadingZeros(i3) + 1;
        while (i4 < this.f2347h) {
            int i5 = i4 + 1;
            int iH = h(this.f2342c[i4]);
            int i6 = this.f2346g;
            while (true) {
                iArr = this.f2345f;
                if (iArr[iH] == 0) {
                    break;
                }
                i6--;
                if (i6 < 0) {
                    o2.k("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
                    return;
                }
                iH = iH == 0 ? iArr.length - 1 : iH - 1;
            }
            iArr[iH] = i5;
            this.f2344e[i4] = iH;
            i4 = i5;
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f2350k == 0;
    }

    public final void j(int i3) {
        Object[] objArr = this.f2342c;
        objArr.getClass();
        objArr[i3] = null;
        Object[] objArr2 = this.f2343d;
        if (objArr2 != null) {
            objArr2[i3] = null;
        }
        int length = this.f2344e[i3];
        int i4 = this.f2346g * 2;
        int length2 = this.f2345f.length / 2;
        if (i4 > length2) {
            i4 = length2;
        }
        int i5 = i4;
        int i6 = 0;
        int i7 = length;
        do {
            length = length == 0 ? this.f2345f.length - 1 : length - 1;
            i6++;
            int i8 = this.f2346g;
            int[] iArr = this.f2345f;
            if (i6 > i8) {
                iArr[i7] = 0;
            } else {
                int i9 = iArr[length];
                if (i9 == 0) {
                    iArr[i7] = 0;
                } else {
                    if (i9 < 0) {
                        iArr[i7] = -1;
                    } else {
                        int i10 = i9 - 1;
                        int iH = h(this.f2342c[i10]) - length;
                        int[] iArr2 = this.f2345f;
                        if ((iH & (iArr2.length - 1)) >= i6) {
                            iArr2[i7] = i9;
                            this.f2344e[i10] = i7;
                        }
                        i5--;
                    }
                    i7 = length;
                    i6 = 0;
                    i5--;
                }
            }
            this.f2344e[i3] = -1;
            this.f2350k--;
            this.f2349j++;
        } while (i5 >= 0);
        this.f2345f[i7] = -1;
        this.f2344e[i3] = -1;
        this.f2350k--;
        this.f2349j++;
    }

    @Override // java.util.Map
    public final Set keySet() {
        g gVar = this.f2351l;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 1);
        this.f2351l = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        b();
        int iA = a(obj);
        Object[] objArr = this.f2343d;
        if (objArr == null) {
            int length = this.f2342c.length;
            if (length < 0) {
                o2.i("capacity must be non-negative.");
                return null;
            }
            objArr = new Object[length];
            this.f2343d = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i3 = (-iA) - 1;
        Object obj3 = objArr[i3];
        objArr[i3] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        map.getClass();
        b();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        e(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.f2343d;
            if (objArr == null) {
                int length = this.f2342c.length;
                if (length < 0) {
                    o2.i("capacity must be non-negative.");
                    return;
                } else {
                    objArr = new Object[length];
                    this.f2343d = objArr;
                }
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i3 = (-iA) - 1;
                if (!q1.e.a(entry.getValue(), objArr[i3])) {
                    objArr[i3] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        b();
        int iF = f(obj);
        if (iF < 0) {
            return null;
        }
        Object[] objArr = this.f2343d;
        objArr.getClass();
        Object obj2 = objArr[iF];
        j(iF);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f2350k;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f2350k * 3) + 2);
        sb.append("{");
        d dVar = new d(this, 0);
        int i3 = 0;
        while (dVar.hasNext()) {
            if (i3 > 0) {
                sb.append(", ");
            }
            int i4 = dVar.f2334d;
            f fVar = dVar.f2333c;
            if (i4 >= fVar.f2347h) {
                throw new NoSuchElementException();
            }
            dVar.f2334d = i4 + 1;
            dVar.f2335e = i4;
            Object obj = fVar.f2342c[i4];
            if (obj == fVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = fVar.f2343d;
            objArr.getClass();
            Object obj2 = objArr[dVar.f2335e];
            if (obj2 == fVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            dVar.b();
            i3++;
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        h hVar = this.f2352m;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this);
        this.f2352m = hVar2;
        return hVar2;
    }

    public f() {
        this(8);
    }
}
