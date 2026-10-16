// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p036u0;

import F0.i;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class d extends AbstractList implements List {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object[] f4141d = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f4143b = f4141d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4144c;

    public final void a(int i2, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f4143b.length;
        while (i2 < length && it.hasNext()) {
            this.f4143b[i2] = it.next();
            i2++;
        }
        int i3 = this.f4142a;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.f4143b[i4] = it.next();
        }
        this.f4144c = collection.size() + this.f4144c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int length;
        int i3 = this.f4144c;
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
        }
        if (i2 == i3) {
            addLast(obj);
            return;
        }
        if (i2 == 0) {
            addFirst(obj);
            return;
        }
        b(i3 + 1);
        int iD = d(this.f4142a + i2);
        int i4 = this.f4144c;
        if (i2 < ((i4 + 1) >> 1)) {
            if (iD == 0) {
                Object[] objArr = this.f4143b;
                i.e(objArr, "<this>");
                iD = objArr.length;
            }
            int i5 = iD - 1;
            int i6 = this.f4142a;
            if (i6 == 0) {
                Object[] objArr2 = this.f4143b;
                i.e(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i6 - 1;
            }
            int i7 = this.f4142a;
            if (i5 >= i7) {
                Object[] objArr3 = this.f4143b;
                objArr3[length] = objArr3[i7];
                e.t(objArr3, objArr3, i7, i7 + 1, i5 + 1);
            } else {
                Object[] objArr4 = this.f4143b;
                e.t(objArr4, objArr4, i7 - 1, i7, objArr4.length);
                Object[] objArr5 = this.f4143b;
                objArr5[objArr5.length - 1] = objArr5[0];
                e.t(objArr5, objArr5, 0, 1, i5 + 1);
            }
            this.f4143b[i5] = obj;
            this.f4142a = length;
        } else {
            int iD2 = d(this.f4142a + i4);
            if (iD < iD2) {
                Object[] objArr6 = this.f4143b;
                e.t(objArr6, objArr6, iD + 1, iD, iD2);
            } else {
                Object[] objArr7 = this.f4143b;
                e.t(objArr7, objArr7, 1, 0, iD2);
                Object[] objArr8 = this.f4143b;
                objArr8[0] = objArr8[objArr8.length - 1];
                e.t(objArr8, objArr8, iD + 1, iD, objArr8.length - 1);
            }
            this.f4143b[iD] = obj;
        }
        this.f4144c++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        i.e(collection, "elements");
        int i3 = this.f4144c;
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
        }
        if (collection.isEmpty()) {
            return false;
        }
        int i4 = this.f4144c;
        if (i2 == i4) {
            return addAll(collection);
        }
        b(collection.size() + i4);
        int iD = d(this.f4142a + this.f4144c);
        int iD2 = d(this.f4142a + i2);
        int size = collection.size();
        if (i2 < ((this.f4144c + 1) >> 1)) {
            int i5 = this.f4142a;
            int length = i5 - size;
            if (iD2 < i5) {
                Object[] objArr = this.f4143b;
                e.t(objArr, objArr, length, i5, objArr.length);
                if (size >= iD2) {
                    Object[] objArr2 = this.f4143b;
                    e.t(objArr2, objArr2, objArr2.length - size, 0, iD2);
                } else {
                    Object[] objArr3 = this.f4143b;
                    e.t(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f4143b;
                    e.t(objArr4, objArr4, 0, size, iD2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f4143b;
                e.t(objArr5, objArr5, length, i5, iD2);
            } else {
                Object[] objArr6 = this.f4143b;
                length += objArr6.length;
                int i6 = iD2 - i5;
                int length2 = objArr6.length - length;
                if (length2 >= i6) {
                    e.t(objArr6, objArr6, length, i5, iD2);
                } else {
                    e.t(objArr6, objArr6, length, i5, i5 + length2);
                    Object[] objArr7 = this.f4143b;
                    e.t(objArr7, objArr7, 0, this.f4142a + length2, iD2);
                }
            }
            this.f4142a = length;
            int length3 = iD2 - size;
            if (length3 < 0) {
                length3 += this.f4143b.length;
            }
            a(length3, collection);
        } else {
            int i7 = iD2 + size;
            if (iD2 < iD) {
                int i8 = size + iD;
                Object[] objArr8 = this.f4143b;
                if (i8 <= objArr8.length) {
                    e.t(objArr8, objArr8, i7, iD2, iD);
                } else if (i7 >= objArr8.length) {
                    e.t(objArr8, objArr8, i7 - objArr8.length, iD2, iD);
                } else {
                    int length4 = iD - (i8 - objArr8.length);
                    e.t(objArr8, objArr8, 0, length4, iD);
                    Object[] objArr9 = this.f4143b;
                    e.t(objArr9, objArr9, i7, iD2, length4);
                }
            } else {
                Object[] objArr10 = this.f4143b;
                e.t(objArr10, objArr10, size, 0, iD);
                Object[] objArr11 = this.f4143b;
                if (i7 >= objArr11.length) {
                    e.t(objArr11, objArr11, i7 - objArr11.length, iD2, objArr11.length);
                } else {
                    e.t(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f4143b;
                    e.t(objArr12, objArr12, i7, iD2, objArr12.length - size);
                }
            }
            a(iD2, collection);
        }
        return true;
    }

    public final void addFirst(Object obj) {
        b(this.f4144c + 1);
        int length = this.f4142a;
        if (length == 0) {
            Object[] objArr = this.f4143b;
            i.e(objArr, "<this>");
            length = objArr.length;
        }
        int i2 = length - 1;
        this.f4142a = i2;
        this.f4143b[i2] = obj;
        this.f4144c++;
    }

    public final void addLast(Object obj) {
        b(this.f4144c + 1);
        this.f4143b[d(this.f4142a + this.f4144c)] = obj;
        this.f4144c++;
    }

    public final void b(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f4143b;
        if (i2 <= objArr.length) {
            return;
        }
        if (objArr == f4141d) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f4143b = new Object[i2];
            return;
        }
        int length = objArr.length;
        int i3 = length + (length >> 1);
        if (i3 - i2 < 0) {
            i3 = i2;
        }
        if (i3 - 2147483639 > 0) {
            i3 = i2 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i3];
        e.t(objArr, objArr2, 0, this.f4142a, objArr.length);
        Object[] objArr3 = this.f4143b;
        int length2 = objArr3.length;
        int i4 = this.f4142a;
        e.t(objArr3, objArr2, length2 - i4, 0, i4);
        this.f4142a = 0;
        this.f4143b = objArr2;
    }

    public final int c(int i2) {
        Object[] objArr = this.f4143b;
        i.e(objArr, "<this>");
        if (i2 == objArr.length - 1) {
            return 0;
        }
        return i2 + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int iD = d(this.f4142a + this.f4144c);
        int i2 = this.f4142a;
        if (i2 < iD) {
            e.w(this.f4143b, i2, iD);
        } else if (!isEmpty()) {
            Object[] objArr = this.f4143b;
            e.w(objArr, this.f4142a, objArr.length);
            e.w(this.f4143b, 0, iD);
        }
        this.f4142a = 0;
        this.f4144c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int d(int i2) {
        Object[] objArr = this.f4143b;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        int i3 = this.f4144c;
        if (i2 >= 0 && i2 < i3) {
            return this.f4143b[d(this.f4142a + i2)];
        }
        throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i2;
        int iD = d(this.f4142a + this.f4144c);
        int length = this.f4142a;
        if (length < iD) {
            while (length < iD) {
                if (i.a(obj, this.f4143b[length])) {
                    i2 = this.f4142a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iD) {
            return -1;
        }
        int length2 = this.f4143b.length;
        while (length < length2) {
            if (i.a(obj, this.f4143b[length])) {
                i2 = this.f4142a;
            } else {
                length++;
            }
        }
        for (int i3 = 0; i3 < iD; i3++) {
            if (i.a(obj, this.f4143b[i3])) {
                length = i3 + this.f4143b.length;
                i2 = this.f4142a;
            }
        }
        return -1;
        return length - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f4144c == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i2;
        int iD = d(this.f4142a + this.f4144c);
        int i3 = this.f4142a;
        if (i3 < iD) {
            length = iD - 1;
            if (i3 <= length) {
                while (!i.a(obj, this.f4143b[length])) {
                    if (length != i3) {
                        length--;
                    }
                }
                i2 = this.f4142a;
                return length - i2;
            }
            return -1;
        }
        if (i3 > iD) {
            for (int i4 = iD - 1; -1 < i4; i4--) {
                if (i.a(obj, this.f4143b[i4])) {
                    length = i4 + this.f4143b.length;
                    i2 = this.f4142a;
                    return length - i2;
                }
            }
            Object[] objArr = this.f4143b;
            i.e(objArr, "<this>");
            length = objArr.length - 1;
            int i5 = this.f4142a;
            if (i5 <= length) {
                while (!i.a(obj, this.f4143b[length])) {
                    if (length != i5) {
                        length--;
                    }
                }
                i2 = this.f4142a;
                return length - i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        int i3 = this.f4144c;
        if (i2 < 0 || i2 >= i3) {
            throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
        }
        if (i2 == g.p(this)) {
            return removeLast();
        }
        if (i2 == 0) {
            return removeFirst();
        }
        int iD = d(this.f4142a + i2);
        Object[] objArr = this.f4143b;
        Object obj = objArr[iD];
        if (i2 < (this.f4144c >> 1)) {
            int i4 = this.f4142a;
            if (iD >= i4) {
                e.t(objArr, objArr, i4 + 1, i4, iD);
            } else {
                e.t(objArr, objArr, 1, 0, iD);
                Object[] objArr2 = this.f4143b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i5 = this.f4142a;
                e.t(objArr2, objArr2, i5 + 1, i5, objArr2.length - 1);
            }
            Object[] objArr3 = this.f4143b;
            int i6 = this.f4142a;
            objArr3[i6] = null;
            this.f4142a = c(i6);
        } else {
            int iD2 = d(g.p(this) + this.f4142a);
            if (iD <= iD2) {
                Object[] objArr4 = this.f4143b;
                e.t(objArr4, objArr4, iD, iD + 1, iD2 + 1);
            } else {
                Object[] objArr5 = this.f4143b;
                e.t(objArr5, objArr5, iD, iD + 1, objArr5.length);
                Object[] objArr6 = this.f4143b;
                objArr6[objArr6.length - 1] = objArr6[0];
                e.t(objArr6, objArr6, 0, 1, iD2 + 1);
            }
            this.f4143b[iD2] = null;
        }
        this.f4144c--;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iD;
        i.e(collection, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.f4143b.length != 0) {
            int iD2 = d(this.f4142a + this.f4144c);
            int i2 = this.f4142a;
            if (i2 < iD2) {
                iD = i2;
                while (i2 < iD2) {
                    Object obj = this.f4143b[i2];
                    if (collection.contains(obj)) {
                        z2 = true;
                    } else {
                        this.f4143b[iD] = obj;
                        iD++;
                    }
                    i2++;
                }
                e.w(this.f4143b, iD, iD2);
            } else {
                int length = this.f4143b.length;
                boolean z3 = false;
                int i3 = i2;
                while (i2 < length) {
                    Object[] objArr = this.f4143b;
                    Object obj2 = objArr[i2];
                    objArr[i2] = null;
                    if (collection.contains(obj2)) {
                        z3 = true;
                    } else {
                        this.f4143b[i3] = obj2;
                        i3++;
                    }
                    i2++;
                }
                iD = d(i3);
                for (int i4 = 0; i4 < iD2; i4++) {
                    Object[] objArr2 = this.f4143b;
                    Object obj3 = objArr2[i4];
                    objArr2[i4] = null;
                    if (collection.contains(obj3)) {
                        z3 = true;
                    } else {
                        this.f4143b[iD] = obj3;
                        iD = c(iD);
                    }
                }
                z2 = z3;
            }
            if (z2) {
                int length2 = iD - this.f4142a;
                if (length2 < 0) {
                    length2 += this.f4143b.length;
                }
                this.f4144c = length2;
            }
        }
        return z2;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f4143b;
        int i2 = this.f4142a;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.f4142a = c(i2);
        this.f4144c--;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iD = d(g.p(this) + this.f4142a);
        Object[] objArr = this.f4143b;
        Object obj = objArr[iD];
        objArr[iD] = null;
        this.f4144c--;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iD;
        i.e(collection, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.f4143b.length != 0) {
            int iD2 = d(this.f4142a + this.f4144c);
            int i2 = this.f4142a;
            if (i2 < iD2) {
                iD = i2;
                while (i2 < iD2) {
                    Object obj = this.f4143b[i2];
                    if (collection.contains(obj)) {
                        this.f4143b[iD] = obj;
                        iD++;
                    } else {
                        z2 = true;
                    }
                    i2++;
                }
                e.w(this.f4143b, iD, iD2);
            } else {
                int length = this.f4143b.length;
                boolean z3 = false;
                int i3 = i2;
                while (i2 < length) {
                    Object[] objArr = this.f4143b;
                    Object obj2 = objArr[i2];
                    objArr[i2] = null;
                    if (collection.contains(obj2)) {
                        this.f4143b[i3] = obj2;
                        i3++;
                    } else {
                        z3 = true;
                    }
                    i2++;
                }
                iD = d(i3);
                for (int i4 = 0; i4 < iD2; i4++) {
                    Object[] objArr2 = this.f4143b;
                    Object obj3 = objArr2[i4];
                    objArr2[i4] = null;
                    if (collection.contains(obj3)) {
                        this.f4143b[iD] = obj3;
                        iD = c(iD);
                    } else {
                        z3 = true;
                    }
                }
                z2 = z3;
            }
            if (z2) {
                int length2 = iD - this.f4142a;
                if (length2 < 0) {
                    length2 += this.f4143b.length;
                }
                this.f4144c = length2;
            }
        }
        return z2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        int i3 = this.f4144c;
        if (i2 < 0 || i2 >= i3) {
            throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
        }
        int iD = d(this.f4142a + i2);
        Object[] objArr = this.f4143b;
        Object obj2 = objArr[iD];
        objArr[iD] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4144c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[this.f4144c]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        i.e(objArr, "array");
        int length = objArr.length;
        int i2 = this.f4144c;
        if (length < i2) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i2);
            i.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) objNewInstance;
        }
        int iD = d(this.f4142a + this.f4144c);
        int i3 = this.f4142a;
        if (i3 < iD) {
            e.u(this.f4143b, objArr, i3, iD, 2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f4143b;
            e.t(objArr2, objArr, 0, this.f4142a, objArr2.length);
            Object[] objArr3 = this.f4143b;
            e.t(objArr3, objArr, objArr3.length - this.f4142a, 0, iD);
        }
        int i4 = this.f4144c;
        if (i4 < objArr.length) {
            objArr[i4] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        i.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        b(collection.size() + this.f4144c);
        a(d(this.f4142a + this.f4144c), collection);
        return true;
    }
}
