// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j1;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import q2.k;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends i1.e implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f2324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f2327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f2328g;

    public b(Object[] objArr, int i3, int i4, b bVar, c cVar) {
        objArr.getClass();
        cVar.getClass();
        this.f2324c = objArr;
        this.f2325d = i3;
        this.f2326e = i4;
        this.f2327f = bVar;
        this.f2328g = cVar;
        ((AbstractList) this).modCount = ((AbstractList) cVar).modCount;
    }

    @Override // i1.e
    public final int a() {
        f();
        return this.f2326e;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        g();
        f();
        int i4 = this.f2326e;
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, i4, "index: ", ", size: "));
        }
        e(this.f2325d + i3, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i3, Collection collection) {
        collection.getClass();
        g();
        f();
        int i4 = this.f2326e;
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, i4, "index: ", ", size: "));
        }
        int size = collection.size();
        d(this.f2325d + i3, collection, size);
        return size > 0;
    }

    @Override // i1.e
    public final Object b(int i3) {
        g();
        f();
        int i4 = this.f2326e;
        if (i3 < 0 || i3 >= i4) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, i4, "index: ", ", size: "));
        }
        return h(this.f2325d + i3);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        g();
        f();
        i(this.f2325d, this.f2326e);
    }

    public final void d(int i3, Collection collection, int i4) {
        ((AbstractList) this).modCount++;
        c cVar = this.f2328g;
        b bVar = this.f2327f;
        if (bVar != null) {
            bVar.d(i3, collection, i4);
        } else {
            c cVar2 = c.f2329f;
            cVar.d(i3, collection, i4);
        }
        this.f2324c = cVar.f2330c;
        this.f2326e += i4;
    }

    public final void e(int i3, Object obj) {
        ((AbstractList) this).modCount++;
        c cVar = this.f2328g;
        b bVar = this.f2327f;
        if (bVar != null) {
            bVar.e(i3, obj);
        } else {
            c cVar2 = c.f2329f;
            cVar.e(i3, obj);
        }
        this.f2324c = cVar.f2330c;
        this.f2326e++;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        f();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f2324c;
            int i3 = this.f2326e;
            if (i3 == list.size()) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (q1.e.a(objArr[this.f2325d + i4], list.get(i4))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (((AbstractList) this.f2328g).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void g() {
        if (this.f2328g.f2332e) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        f();
        int i4 = this.f2326e;
        if (i3 < 0 || i3 >= i4) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, i4, "index: ", ", size: "));
        }
        return this.f2324c[this.f2325d + i3];
    }

    public final Object h(int i3) {
        Object objH;
        ((AbstractList) this).modCount++;
        b bVar = this.f2327f;
        if (bVar != null) {
            objH = bVar.h(i3);
        } else {
            c cVar = c.f2329f;
            objH = this.f2328g.h(i3);
        }
        this.f2326e--;
        return objH;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        f();
        Object[] objArr = this.f2324c;
        int i3 = this.f2326e;
        int iHashCode = 1;
        for (int i4 = 0; i4 < i3; i4++) {
            Object obj = objArr[this.f2325d + i4];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i3, int i4) {
        if (i4 > 0) {
            ((AbstractList) this).modCount++;
        }
        b bVar = this.f2327f;
        if (bVar != null) {
            bVar.i(i3, i4);
        } else {
            c cVar = c.f2329f;
            this.f2328g.i(i3, i4);
        }
        this.f2326e -= i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        f();
        for (int i3 = 0; i3 < this.f2326e; i3++) {
            if (q1.e.a(this.f2324c[this.f2325d + i3], obj)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        f();
        return this.f2326e == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i3, int i4, Collection collection, boolean z2) {
        int iJ;
        b bVar = this.f2327f;
        if (bVar != null) {
            iJ = bVar.j(i3, i4, collection, z2);
        } else {
            c cVar = c.f2329f;
            iJ = this.f2328g.j(i3, i4, collection, z2);
        }
        if (iJ > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f2326e -= iJ;
        return iJ;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        f();
        for (int i3 = this.f2326e - 1; i3 >= 0; i3--) {
            if (q1.e.a(this.f2324c[this.f2325d + i3], obj)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i3) {
        f();
        int i4 = this.f2326e;
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, i4, "index: ", ", size: "));
        }
        return new a(this, i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        g();
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
        g();
        f();
        return j(this.f2325d, this.f2326e, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        g();
        f();
        return j(this.f2325d, this.f2326e, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i3, Object obj) {
        g();
        f();
        int i4 = this.f2326e;
        if (i3 < 0 || i3 >= i4) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, i4, "index: ", ", size: "));
        }
        Object[] objArr = this.f2324c;
        int i5 = this.f2325d;
        Object obj2 = objArr[i5 + i3];
        objArr[i5 + i3] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i3, int i4) {
        k.d(i3, i4, this.f2326e);
        return new b(this.f2324c, this.f2325d + i3, i4 - i3, this, this.f2328g);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        f();
        int length = objArr.length;
        int i3 = this.f2326e;
        Object[] objArr2 = this.f2324c;
        int i4 = this.f2325d;
        if (length < i3) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, i4, i3 + i4, objArr.getClass());
            objArrCopyOfRange.getClass();
            return objArrCopyOfRange;
        }
        i1.h.t(objArr2, objArr, 0, i4, i3 + i4);
        int i5 = this.f2326e;
        if (i5 < objArr.length) {
            objArr[i5] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        f();
        return m0.a.a(this.f2324c, this.f2325d, this.f2326e, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g();
        f();
        e(this.f2325d + this.f2326e, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        f();
        Object[] objArr = this.f2324c;
        int i3 = this.f2326e;
        int i4 = this.f2325d;
        int i5 = i3 + i4;
        objArr.getClass();
        y.f.g(i5, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i4, i5);
        objArrCopyOfRange.getClass();
        return objArrCopyOfRange;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        g();
        f();
        int size = collection.size();
        d(this.f2325d + this.f2326e, collection, size);
        return size > 0;
    }
}
