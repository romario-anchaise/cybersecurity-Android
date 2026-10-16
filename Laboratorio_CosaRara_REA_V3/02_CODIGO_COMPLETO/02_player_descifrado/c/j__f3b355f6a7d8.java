// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Object[] f389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Object[] f391h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f392i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f393c = d.f372a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object[] f394d = d.f373b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f395e = 0;

    public static void b(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (j.class) {
                try {
                    if (f392i < 10) {
                        objArr[0] = f391h;
                        objArr[1] = iArr;
                        for (int i4 = (i3 << 1) - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        f391h = objArr;
                        f392i++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (j.class) {
                try {
                    if (f390g < 10) {
                        objArr[0] = f389f;
                        objArr[1] = iArr;
                        for (int i5 = (i3 << 1) - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        f389f = objArr;
                        f390g++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void a(int i3) {
        if (i3 == 8) {
            synchronized (j.class) {
                try {
                    Object[] objArr = f391h;
                    if (objArr != null) {
                        this.f394d = objArr;
                        f391h = (Object[]) objArr[0];
                        this.f393c = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f392i--;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i3 == 4) {
            synchronized (j.class) {
                try {
                    Object[] objArr2 = f389f;
                    if (objArr2 != null) {
                        this.f394d = objArr2;
                        f389f = (Object[]) objArr2[0];
                        this.f393c = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f390g--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.f393c = new int[i3];
        this.f394d = new Object[i3 << 1];
    }

    public final int c(int i3, Object obj) {
        int i4 = this.f395e;
        if (i4 == 0) {
            return -1;
        }
        try {
            int iA = d.a(this.f393c, i4, i3);
            if (iA < 0 || obj.equals(this.f394d[iA << 1])) {
                return iA;
            }
            int i5 = iA + 1;
            while (i5 < i4 && this.f393c[i5] == i3) {
                if (obj.equals(this.f394d[i5 << 1])) {
                    return i5;
                }
                i5++;
            }
            for (int i6 = iA - 1; i6 >= 0 && this.f393c[i6] == i3; i6--) {
                if (obj.equals(this.f394d[i6 << 1])) {
                    return i6;
                }
            }
            return ~i5;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final void clear() {
        int i3 = this.f395e;
        if (i3 > 0) {
            int[] iArr = this.f393c;
            Object[] objArr = this.f394d;
            this.f393c = d.f372a;
            this.f394d = d.f373b;
            this.f395e = 0;
            b(iArr, objArr, i3);
        }
        if (this.f395e > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return f(obj) >= 0;
    }

    public final int d(Object obj) {
        return obj == null ? e() : c(obj.hashCode(), obj);
    }

    public final int e() {
        int i3 = this.f395e;
        if (i3 == 0) {
            return -1;
        }
        try {
            int iA = d.a(this.f393c, i3, 0);
            if (iA < 0 || this.f394d[iA << 1] == null) {
                return iA;
            }
            int i4 = iA + 1;
            while (i4 < i3 && this.f393c[i4] == 0) {
                if (this.f394d[i4 << 1] == null) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = iA - 1; i5 >= 0 && this.f393c[i5] == 0; i5--) {
                if (this.f394d[i5 << 1] == null) {
                    return i5;
                }
            }
            return ~i4;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean equals(Object obj) {
        int i3;
        int i4;
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof j) {
                j jVar = (j) obj;
                if (this.f395e == jVar.f395e) {
                    for (0; i4 < this.f395e; i4 + 1) {
                        Object obj2 = this.f394d[i4 << 1];
                        Object objH = h(i4);
                        Object orDefault = jVar.getOrDefault(obj2, null);
                        if (objH == null) {
                            i4 = (orDefault == null && jVar.containsKey(obj2)) ? i4 + 1 : 0;
                        } else if (objH.equals(orDefault)) {
                        }
                    }
                    return true;
                }
            } else if (obj instanceof Map) {
                Map map = (Map) obj;
                if (this.f395e == map.size()) {
                    for (0; i3 < this.f395e; i3 + 1) {
                        Object obj3 = this.f394d[i3 << 1];
                        Object objH2 = h(i3);
                        Object obj4 = map.get(obj3);
                        if (objH2 == null) {
                            i3 = (obj4 == null && map.containsKey(obj3)) ? i3 + 1 : 0;
                        } else if (objH2.equals(obj4)) {
                        }
                    }
                    return true;
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final int f(Object obj) {
        int i3 = this.f395e * 2;
        Object[] objArr = this.f394d;
        if (obj == null) {
            for (int i4 = 1; i4 < i3; i4 += 2) {
                if (objArr[i4] == null) {
                    return i4 >> 1;
                }
            }
            return -1;
        }
        for (int i5 = 1; i5 < i3; i5 += 2) {
            if (obj.equals(objArr[i5])) {
                return i5 >> 1;
            }
        }
        return -1;
    }

    public final Object g(int i3) {
        Object[] objArr = this.f394d;
        int i4 = i3 << 1;
        Object obj = objArr[i4 + 1];
        int i5 = this.f395e;
        int[] iArr = this.f393c;
        int i6 = 0;
        if (i5 <= 1) {
            b(iArr, objArr, i5);
            this.f393c = d.f372a;
            this.f394d = d.f373b;
        } else {
            int i7 = i5 - 1;
            if (iArr.length <= 8 || i5 >= iArr.length / 3) {
                if (i3 < i7) {
                    int i8 = i3 + 1;
                    int i9 = i7 - i3;
                    System.arraycopy(iArr, i8, iArr, i3, i9);
                    Object[] objArr2 = this.f394d;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i4, i9 << 1);
                }
                Object[] objArr3 = this.f394d;
                int i10 = i7 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            } else {
                a(i5 > 8 ? i5 + (i5 >> 1) : 8);
                if (i5 != this.f395e) {
                    throw new ConcurrentModificationException();
                }
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.f393c, 0, i3);
                    System.arraycopy(objArr, 0, this.f394d, 0, i4);
                }
                if (i3 < i7) {
                    int i11 = i3 + 1;
                    int i12 = i7 - i3;
                    System.arraycopy(iArr, i11, this.f393c, i3, i12);
                    System.arraycopy(objArr, i11 << 1, this.f394d, i4, i12 << 1);
                }
            }
            i6 = i7;
        }
        if (i5 != this.f395e) {
            throw new ConcurrentModificationException();
        }
        this.f395e = i6;
        return obj;
    }

    public final Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iD = d(obj);
        return iD >= 0 ? this.f394d[(iD << 1) + 1] : obj2;
    }

    public final Object h(int i3) {
        return this.f394d[(i3 << 1) + 1];
    }

    public final int hashCode() {
        int[] iArr = this.f393c;
        Object[] objArr = this.f394d;
        int i3 = this.f395e;
        int i4 = 1;
        int i5 = 0;
        int iHashCode = 0;
        while (i5 < i3) {
            Object obj = objArr[i4];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i5];
            i5++;
            i4 += 2;
        }
        return iHashCode;
    }

    public final boolean isEmpty() {
        return this.f395e <= 0;
    }

    public final Object put(Object obj, Object obj2) {
        int i3;
        int iC;
        int i4 = this.f395e;
        if (obj == null) {
            iC = e();
            i3 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i3 = iHashCode;
            iC = c(iHashCode, obj);
        }
        if (iC >= 0) {
            int i5 = (iC << 1) + 1;
            Object[] objArr = this.f394d;
            Object obj3 = objArr[i5];
            objArr[i5] = obj2;
            return obj3;
        }
        int i6 = ~iC;
        int[] iArr = this.f393c;
        if (i4 >= iArr.length) {
            int i7 = 8;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i7 = 4;
            }
            Object[] objArr2 = this.f394d;
            a(i7);
            if (i4 != this.f395e) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f393c;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f394d, 0, objArr2.length);
            }
            b(iArr, objArr2, i4);
        }
        if (i6 < i4) {
            int[] iArr3 = this.f393c;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr3 = this.f394d;
            System.arraycopy(objArr3, i6 << 1, objArr3, i8 << 1, (this.f395e - i6) << 1);
        }
        int i9 = this.f395e;
        if (i4 == i9) {
            int[] iArr4 = this.f393c;
            if (i6 < iArr4.length) {
                iArr4[i6] = i3;
                Object[] objArr4 = this.f394d;
                int i10 = i6 << 1;
                objArr4[i10] = obj;
                objArr4[i10 + 1] = obj2;
                this.f395e = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object orDefault = getOrDefault(obj, null);
        return orDefault == null ? put(obj, obj2) : orDefault;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD < 0) {
            return false;
        }
        Object objH = h(iD);
        if (obj2 != objH && (obj2 == null || !obj2.equals(objH))) {
            return false;
        }
        g(iD);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iD = d(obj);
        if (iD < 0) {
            return false;
        }
        Object objH = h(iD);
        if (objH != obj2 && (obj2 == null || !obj2.equals(objH))) {
            return false;
        }
        int i3 = (iD << 1) + 1;
        Object[] objArr = this.f394d;
        Object obj4 = objArr[i3];
        objArr[i3] = obj3;
        return true;
    }

    public final int size() {
        return this.f395e;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f395e * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f395e; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = this.f394d[i3 << 1];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objH = h(i3);
            if (objH != this) {
                sb.append(objH);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final Object remove(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return g(iD);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD < 0) {
            return null;
        }
        int i3 = (iD << 1) + 1;
        Object[] objArr = this.f394d;
        Object obj3 = objArr[i3];
        objArr[i3] = obj2;
        return obj3;
    }
}
