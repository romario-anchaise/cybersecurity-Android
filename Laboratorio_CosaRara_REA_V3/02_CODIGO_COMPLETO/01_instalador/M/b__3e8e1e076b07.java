// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p021m;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Set {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f3668a;

    public b(e eVar) {
        this.f3668a = eVar;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f3668a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f3668a.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.f3668a.i(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        e eVar = this.f3668a;
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (eVar.f3689c == set.size() && eVar.i(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        e eVar = this.f3668a;
        int iHashCode = 0;
        for (int i2 = eVar.f3689c - 1; i2 >= 0; i2--) {
            Object objE = eVar.e(i2);
            iHashCode += objE == null ? 0 : objE.hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f3668a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new a(this.f3668a, 0);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        e eVar = this.f3668a;
        int iC = eVar.c(obj);
        if (iC < 0) {
            return false;
        }
        eVar.f(iC);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        return this.f3668a.j(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        e eVar = this.f3668a;
        int i2 = eVar.f3689c;
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (!collection.contains(eVar.e(i3))) {
                eVar.f(i3);
            }
        }
        return i2 != eVar.f3689c;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f3668a.f3689c;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        e eVar = this.f3668a;
        int i2 = eVar.f3689c;
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = eVar.e(i3);
        }
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        e eVar = this.f3668a;
        int i2 = eVar.f3689c;
        if (objArr.length < i2) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2);
        }
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = eVar.e(i3);
        }
        if (objArr.length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
