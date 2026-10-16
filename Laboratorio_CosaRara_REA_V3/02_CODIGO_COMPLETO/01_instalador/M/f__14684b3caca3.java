// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p021m;

import F0.i;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import p023n.a;
import p036u0.e;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Collection, Set {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f3678a = a.f3877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f3679b = a.f3878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3680c;

    public final Object a(int i2) {
        int i3 = this.f3680c;
        Object[] objArr = this.f3679b;
        Object obj = objArr[i2];
        if (i3 <= 1) {
            clear();
        } else {
            int i4 = i3 - 1;
            int[] iArr = this.f3678a;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i2 < i4) {
                    int i5 = i2 + 1;
                    e.s(i2, i5, i3, iArr, iArr);
                    Object[] objArr2 = this.f3679b;
                    e.t(objArr2, objArr2, i2, i5, i3);
                }
                this.f3679b[i4] = null;
            } else {
                int i6 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArr2 = new int[i6];
                this.f3678a = iArr2;
                this.f3679b = new Object[i6];
                if (i2 > 0) {
                    e.s(0, 0, i2, iArr, iArr2);
                    e.u(objArr, this.f3679b, 0, i2, 6);
                }
                if (i2 < i4) {
                    int i7 = i2 + 1;
                    e.s(i2, i7, i3, iArr, this.f3678a);
                    e.t(objArr, this.f3679b, i2, i7, i3);
                }
            }
            if (i3 != this.f3680c) {
                throw new ConcurrentModificationException();
            }
            this.f3680c = i4;
        }
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i2;
        int iA;
        int i3 = this.f3680c;
        if (obj == null) {
            iA = h.a(this, null, 0);
            i2 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i2 = iHashCode;
            iA = h.a(this, obj, iHashCode);
        }
        if (iA >= 0) {
            return false;
        }
        int i4 = ~iA;
        int[] iArr = this.f3678a;
        if (i3 >= iArr.length) {
            int i5 = 8;
            if (i3 >= 8) {
                i5 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i5 = 4;
            }
            Object[] objArr = this.f3679b;
            int[] iArr2 = new int[i5];
            this.f3678a = iArr2;
            this.f3679b = new Object[i5];
            if (i3 != this.f3680c) {
                throw new ConcurrentModificationException();
            }
            if (iArr2.length != 0) {
                e.s(0, 0, iArr.length, iArr, iArr2);
                e.u(objArr, this.f3679b, 0, objArr.length, 6);
            }
        }
        if (i4 < i3) {
            int[] iArr3 = this.f3678a;
            int i6 = i4 + 1;
            e.s(i6, i4, i3, iArr3, iArr3);
            Object[] objArr2 = this.f3679b;
            e.t(objArr2, objArr2, i6, i4, i3);
        }
        int i7 = this.f3680c;
        if (i3 == i7) {
            int[] iArr4 = this.f3678a;
            if (i4 < iArr4.length) {
                iArr4[i4] = i2;
                this.f3679b[i4] = obj;
                this.f3680c = i7 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        i.e(collection, "elements");
        int size = collection.size() + this.f3680c;
        int i2 = this.f3680c;
        int[] iArr = this.f3678a;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f3679b;
            int[] iArr2 = new int[size];
            this.f3678a = iArr2;
            this.f3679b = new Object[size];
            int i3 = this.f3680c;
            if (i3 > 0) {
                e.s(0, 0, i3, iArr, iArr2);
                e.u(objArr, this.f3679b, 0, this.f3680c, 6);
            }
        }
        if (this.f3680c != i2) {
            throw new ConcurrentModificationException();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f3680c != 0) {
            this.f3678a = a.f3877a;
            this.f3679b = a.f3878b;
            this.f3680c = 0;
        }
        if (this.f3680c != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? h.a(this, null, 0) : h.a(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        i.e(collection, "elements");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Set) && this.f3680c == ((Set) obj).size()) {
            try {
                int i2 = this.f3680c;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (((Set) obj).contains(this.f3679b[i3])) {
                    }
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f3678a;
        int i2 = this.f3680c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f3680c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new a(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iA = obj == null ? h.a(this, null, 0) : h.a(this, obj, obj.hashCode());
        if (iA < 0) {
            return false;
        }
        a(iA);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        i.e(collection, "elements");
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        i.e(collection, "elements");
        boolean z2 = false;
        for (int i2 = this.f3680c - 1; -1 < i2; i2--) {
            if (!collection.contains(this.f3679b[i2])) {
                a(i2);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f3680c;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        Object[] objArr = this.f3679b;
        int i2 = this.f3680c;
        p028p0.a.d(i2, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, 0, i2);
        i.d(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3680c * 14);
        sb.append('{');
        int i2 = this.f3680c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = this.f3679b[i3];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        i.d(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        i.e(objArr, "array");
        int i2 = this.f3680c;
        if (objArr.length < i2) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2);
        } else if (objArr.length > i2) {
            objArr[i2] = null;
        }
        e.t(this.f3679b, objArr, 0, 0, this.f3680c);
        return objArr;
    }
}
