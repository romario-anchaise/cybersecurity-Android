// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Collection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f2101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2102d;

    public g(Object[] objArr, boolean z2) {
        this.f2101c = objArr;
        this.f2102d = z2;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        int i3;
        Object[] objArr = this.f2101c;
        if (obj == null) {
            int length = objArr.length;
            i3 = 0;
            while (i3 < length) {
                if (objArr[i3] != null) {
                    i3++;
                }
            }
            i3 = -1;
        } else {
            int length2 = objArr.length;
            for (int i4 = 0; i4 < length2; i4++) {
                if (obj.equals(objArr[i4])) {
                    i3 = i4;
                }
            }
            i3 = -1;
        }
        return i3 >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f2101c.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new a(this.f2101c);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f2101c.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] objArr = this.f2101c;
        if (this.f2102d && objArr.getClass().equals(Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        objArrCopyOf.getClass();
        return objArrCopyOf;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        return q1.e.e(this, objArr);
    }
}
