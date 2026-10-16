// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p036u0;

import F0.h;
import F0.i;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class n implements List, Serializable, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f4146a = new n();

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        i.e((Void) obj, "element");
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        i.e(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    @Override // java.util.List
    public final Object get(int i2) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i2 + '.');
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return 1;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        i.e((Void) obj, "element");
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return m.f4145a;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Void)) {
            return -1;
        }
        i.e((Void) obj, "element");
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return m.f4145a;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return 0;
    }

    @Override // java.util.List
    public final List subList(int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return i.i(this);
    }

    public final String toString() {
        return "[]";
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i2) {
        if (i2 == 0) {
            return m.f4145a;
        }
        throw new IndexOutOfBoundsException(h.b(i2, "Index: "));
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        i.e(objArr, "array");
        return i.j(this, objArr);
    }
}
