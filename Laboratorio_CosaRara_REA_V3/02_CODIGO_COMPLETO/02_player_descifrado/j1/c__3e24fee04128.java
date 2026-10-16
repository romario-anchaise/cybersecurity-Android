// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j1;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import q2.k;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends i1.e implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f2329f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f2330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2332e;

    static {
        c cVar = new c(0);
        cVar.f2332e = true;
        f2329f = cVar;
    }

    public c(int i3) {
        if (i3 >= 0) {
            this.f2330c = new Object[i3];
        } else {
            o2.i("capacity must be non-negative.");
            throw null;
        }
    }

    @Override // i1.e
    public final int a() {
        return this.f2331d;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        f();
        int i4 = this.f2331d;
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, i4, "index: ", ", size: "));
        }
        ((AbstractList) this).modCount++;
        g(i3, 1);
        this.f2330c[i3] = obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i3, Collection collection) {
        collection.getClass();
        f();
        int i4 = this.f2331d;
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, i4, "index: ", ", size: "));
        }
        int size = collection.size();
        d(i3, collection, size);
        return size > 0;
    }

    @Override // i1.e
    public final Object b(int i3) {
        f();
        int i4 = this.f2331d;
        if (i3 < 0 || i3 >= i4) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, i4, "index: ", ", size: "));
        }
        return h(i3);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        i(0, this.f2331d);
    }

    public final void d(int i3, Collection collection, int i4) {
        ((AbstractList) this).modCount++;
        g(i3, i4);
        Iterator it = collection.iterator();
        for (int i5 = 0; i5 < i4; i5++) {
            this.f2330c[i3 + i5] = it.next();
        }
    }

    public final void e(int i3, Object obj) {
        ((AbstractList) this).modCount++;
        g(i3, 1);
        this.f2330c[i3] = obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f2330c;
            int i3 = this.f2331d;
            if (i3 == list.size()) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (q1.e.a(objArr[i4], list.get(i4))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (this.f2332e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void g(int i3, int i4) {
        int i5 = this.f2331d + i4;
        if (i5 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f2330c;
        if (i5 > objArr.length) {
            int length = objArr.length;
            int i6 = length + (length >> 1);
            if (i6 - i5 < 0) {
                i6 = i5;
            }
            if (i6 - 2147483639 > 0) {
                i6 = i5 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            this.f2330c = Arrays.copyOf(objArr, i6);
        }
        Object[] objArr2 = this.f2330c;
        i1.h.t(objArr2, objArr2, i3 + i4, i3, this.f2331d);
        this.f2331d += i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        int i4 = this.f2331d;
        if (i3 < 0 || i3 >= i4) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, i4, "index: ", ", size: "));
        }
        return this.f2330c[i3];
    }

    public final Object h(int i3) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f2330c;
        Object obj = objArr[i3];
        i1.h.t(objArr, objArr, i3, i3 + 1, this.f2331d);
        Object[] objArr2 = this.f2330c;
        int i4 = this.f2331d - 1;
        objArr2.getClass();
        objArr2[i4] = null;
        this.f2331d--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f2330c;
        int i3 = this.f2331d;
        int iHashCode = 1;
        for (int i4 = 0; i4 < i3; i4++) {
            Object obj = objArr[i4];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i3, int i4) {
        if (i4 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.f2330c;
        i1.h.t(objArr, objArr, i3, i3 + i4, this.f2331d);
        Object[] objArr2 = this.f2330c;
        int i5 = this.f2331d;
        m0.a.s(objArr2, i5 - i4, i5);
        this.f2331d -= i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i3 = 0; i3 < this.f2331d; i3++) {
            if (q1.e.a(this.f2330c[i3], obj)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f2331d == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i3, int i4, Collection collection, boolean z2) {
        Object[] objArr;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            objArr = this.f2330c;
            if (i5 >= i4) {
                break;
            }
            int i7 = i3 + i5;
            if (collection.contains(objArr[i7]) == z2) {
                Object[] objArr2 = this.f2330c;
                i5++;
                objArr2[i6 + i3] = objArr2[i7];
                i6++;
            } else {
                i5++;
            }
        }
        int i8 = i4 - i6;
        i1.h.t(objArr, objArr, i3 + i6, i4 + i3, this.f2331d);
        Object[] objArr3 = this.f2330c;
        int i9 = this.f2331d;
        m0.a.s(objArr3, i9 - i8, i9);
        if (i8 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f2331d -= i8;
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i3 = this.f2331d - 1; i3 >= 0; i3--) {
            if (q1.e.a(this.f2330c[i3], obj)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i3) {
        int i4 = this.f2331d;
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, i4, "index: ", ", size: "));
        }
        return new a(this, i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        f();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        collection.getClass();
        f();
        return j(0, this.f2331d, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        f();
        return j(0, this.f2331d, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i3, Object obj) {
        f();
        int i4 = this.f2331d;
        if (i3 < 0 || i3 >= i4) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, i4, "index: ", ", size: "));
        }
        Object[] objArr = this.f2330c;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i3, int i4) {
        k.d(i3, i4, this.f2331d);
        return new b(this.f2330c, i3, i4 - i3, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        int i3 = this.f2331d;
        Object[] objArr2 = this.f2330c;
        if (length < i3) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, 0, i3, objArr.getClass());
            objArrCopyOfRange.getClass();
            return objArrCopyOfRange;
        }
        i1.h.t(objArr2, objArr, 0, 0, i3);
        int i4 = this.f2331d;
        if (i4 < objArr.length) {
            objArr[i4] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return m0.a.a(this.f2330c, 0, this.f2331d, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        Object[] objArr = this.f2330c;
        int i3 = this.f2331d;
        objArr.getClass();
        y.f.g(i3, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, 0, i3);
        objArrCopyOfRange.getClass();
        return objArrCopyOfRange;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        f();
        int i3 = this.f2331d;
        ((AbstractList) this).modCount++;
        g(i3, 1);
        this.f2330c[i3] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        f();
        int size = collection.size();
        d(this.f2331d, collection, size);
        return size > 0;
    }
}
