// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Collection, Set {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f362g = new int[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object[] f363h = new Object[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Object[] f364i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f365j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Object[] f366k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f367l;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f368c = f362g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object[] f369d = f363h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f370e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f371f;

    public static void b(int[] iArr, Object[] objArr, int i3) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                try {
                    if (f367l < 10) {
                        objArr[0] = f366k;
                        objArr[1] = iArr;
                        for (int i4 = i3 - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        f366k = objArr;
                        f367l++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (c.class) {
                try {
                    if (f365j < 10) {
                        objArr[0] = f364i;
                        objArr[1] = iArr;
                        for (int i5 = i3 - 1; i5 >= 2; i5--) {
                            objArr[i5] = null;
                        }
                        f364i = objArr;
                        f365j++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void a(int i3) {
        if (i3 == 8) {
            synchronized (c.class) {
                try {
                    Object[] objArr = f366k;
                    if (objArr != null) {
                        this.f369d = objArr;
                        f366k = (Object[]) objArr[0];
                        this.f368c = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f367l--;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i3 == 4) {
            synchronized (c.class) {
                try {
                    Object[] objArr2 = f364i;
                    if (objArr2 != null) {
                        this.f369d = objArr2;
                        f364i = (Object[]) objArr2[0];
                        this.f368c = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f365j--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.f368c = new int[i3];
        this.f369d = new Object[i3];
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i3;
        int iC;
        if (obj == null) {
            iC = d();
            i3 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i3 = iHashCode;
            iC = c(iHashCode, obj);
        }
        if (iC >= 0) {
            return false;
        }
        int i4 = ~iC;
        int i5 = this.f370e;
        int[] iArr = this.f368c;
        if (i5 >= iArr.length) {
            int i6 = 8;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i6 = 4;
            }
            Object[] objArr = this.f369d;
            a(i6);
            int[] iArr2 = this.f368c;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f369d, 0, objArr.length);
            }
            b(iArr, objArr, this.f370e);
        }
        int i7 = this.f370e;
        if (i4 < i7) {
            int[] iArr3 = this.f368c;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f369d;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f370e - i4);
        }
        this.f368c[i4] = i3;
        this.f369d[i4] = obj;
        this.f370e++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int size = collection.size() + this.f370e;
        int[] iArr = this.f368c;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f369d;
            a(size);
            int i3 = this.f370e;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f368c, 0, i3);
                System.arraycopy(objArr, 0, this.f369d, 0, this.f370e);
            }
            b(iArr, objArr, this.f370e);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final int c(int i3, Object obj) {
        int i4 = this.f370e;
        if (i4 == 0) {
            return -1;
        }
        int iA = d.a(this.f368c, i4, i3);
        if (iA < 0 || obj.equals(this.f369d[iA])) {
            return iA;
        }
        int i5 = iA + 1;
        while (i5 < i4 && this.f368c[i5] == i3) {
            if (obj.equals(this.f369d[i5])) {
                return i5;
            }
            i5++;
        }
        for (int i6 = iA - 1; i6 >= 0 && this.f368c[i6] == i3; i6--) {
            if (obj.equals(this.f369d[i6])) {
                return i6;
            }
        }
        return ~i5;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i3 = this.f370e;
        if (i3 != 0) {
            b(this.f368c, this.f369d, i3);
            this.f368c = f362g;
            this.f369d = f363h;
            this.f370e = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? d() : c(obj.hashCode(), obj)) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int d() {
        int i3 = this.f370e;
        if (i3 == 0) {
            return -1;
        }
        int iA = d.a(this.f368c, i3, 0);
        if (iA < 0 || this.f369d[iA] == null) {
            return iA;
        }
        int i4 = iA + 1;
        while (i4 < i3 && this.f368c[i4] == 0) {
            if (this.f369d[i4] == null) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iA - 1; i5 >= 0 && this.f368c[i5] == 0; i5--) {
            if (this.f369d[i5] == null) {
                return i5;
            }
        }
        return ~i4;
    }

    public final void e(int i3) {
        Object[] objArr = this.f369d;
        Object obj = objArr[i3];
        int i4 = this.f370e;
        int[] iArr = this.f368c;
        if (i4 <= 1) {
            b(iArr, objArr, i4);
            this.f368c = f362g;
            this.f369d = f363h;
            this.f370e = 0;
            return;
        }
        if (iArr.length <= 8 || i4 >= iArr.length / 3) {
            int i5 = i4 - 1;
            this.f370e = i5;
            if (i3 < i5) {
                int i6 = i3 + 1;
                System.arraycopy(iArr, i6, iArr, i3, i5 - i3);
                Object[] objArr2 = this.f369d;
                System.arraycopy(objArr2, i6, objArr2, i3, this.f370e - i3);
            }
            this.f369d[this.f370e] = null;
            return;
        }
        a(i4 > 8 ? i4 + (i4 >> 1) : 8);
        this.f370e--;
        if (i3 > 0) {
            System.arraycopy(iArr, 0, this.f368c, 0, i3);
            System.arraycopy(objArr, 0, this.f369d, 0, i3);
        }
        int i7 = this.f370e;
        if (i3 < i7) {
            int i8 = i3 + 1;
            System.arraycopy(iArr, i8, this.f368c, i3, i7 - i3);
            System.arraycopy(objArr, i8, this.f369d, i3, this.f370e - i3);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f370e != set.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f370e; i3++) {
                try {
                    if (!set.contains(this.f369d[i3])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f368c;
        int i3 = this.f370e;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            i4 += iArr[i5];
        }
        return i4;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f370e <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        if (this.f371f == null) {
            this.f371f = new a(1, this);
        }
        a aVar = this.f371f;
        if (((f) aVar.f387b) == null) {
            aVar.f387b = new f(aVar, 1);
        }
        return ((f) aVar.f387b).iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iD = obj == null ? d() : c(obj.hashCode(), obj);
        if (iD < 0) {
            return false;
        }
        e(iD);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean z2 = false;
        for (int i3 = this.f370e - 1; i3 >= 0; i3--) {
            if (!collection.contains(this.f369d[i3])) {
                e(i3);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f370e;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f370e) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f370e);
        }
        System.arraycopy(this.f369d, 0, objArr, 0, this.f370e);
        int length = objArr.length;
        int i3 = this.f370e;
        if (length > i3) {
            objArr[i3] = null;
        }
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f370e * 14);
        sb.append('{');
        for (int i3 = 0; i3 < this.f370e; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = this.f369d[i3];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i3 = this.f370e;
        Object[] objArr = new Object[i3];
        System.arraycopy(this.f369d, 0, objArr, 0, i3);
        return objArr;
    }
}
