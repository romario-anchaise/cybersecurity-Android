// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p021m;

import F0.a;
import F0.i;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import p036u0.e;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Collection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3674b;

    public /* synthetic */ d(int i2, Object obj) {
        this.f3673a = i2;
        this.f3674b = obj;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f3673a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f3673a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final void clear() {
        switch (this.f3673a) {
            case 0:
                ((e) this.f3674b).clear();
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f3673a) {
            case 0:
                return ((e) this.f3674b).a(obj) >= 0;
            default:
                return e.q((Object[]) this.f3674b, obj);
        }
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f3673a) {
            case 0:
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        return false;
                    }
                }
                return true;
            default:
                i.e(collection, "elements");
                if (collection.isEmpty()) {
                    return true;
                }
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!e.q((Object[]) this.f3674b, it2.next())) {
                        return false;
                    }
                }
                return true;
        }
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        switch (this.f3673a) {
            case 0:
                return ((e) this.f3674b).isEmpty();
            default:
                return ((Object[]) this.f3674b).length == 0;
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f3673a) {
            case 0:
                return new a((e) this.f3674b, 1);
            default:
                return new a((Object[]) this.f3674b);
        }
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.f3673a) {
            case 0:
                e eVar = (e) this.f3674b;
                int iA = eVar.a(obj);
                if (iA < 0) {
                    return false;
                }
                eVar.f(iA);
                return true;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f3673a) {
            case 0:
                e eVar = (e) this.f3674b;
                int i2 = eVar.f3689c;
                int i3 = 0;
                boolean z2 = false;
                while (i3 < i2) {
                    if (collection.contains(eVar.h(i3))) {
                        eVar.f(i3);
                        i3--;
                        i2--;
                        z2 = true;
                    }
                    i3++;
                }
                return z2;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f3673a) {
            case 0:
                e eVar = (e) this.f3674b;
                int i2 = eVar.f3689c;
                int i3 = 0;
                boolean z2 = false;
                while (i3 < i2) {
                    if (!collection.contains(eVar.h(i3))) {
                        eVar.f(i3);
                        i3--;
                        i2--;
                        z2 = true;
                    }
                    i3++;
                }
                return z2;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final int size() {
        switch (this.f3673a) {
            case 0:
                return ((e) this.f3674b).f3689c;
            default:
                return ((Object[]) this.f3674b).length;
        }
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        switch (this.f3673a) {
            case 0:
                e eVar = (e) this.f3674b;
                int i2 = eVar.f3689c;
                Object[] objArr = new Object[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    objArr[i3] = eVar.h(i3);
                }
                return objArr;
            default:
                Object[] objArr2 = (Object[]) this.f3674b;
                Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length, Object[].class);
                i.d(objArrCopyOf, "copyOf(...)");
                return objArrCopyOf;
        }
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f3673a) {
            case 0:
                e eVar = (e) this.f3674b;
                int i2 = eVar.f3689c;
                if (objArr.length < i2) {
                    objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2);
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    objArr[i3] = eVar.h(i3);
                }
                if (objArr.length > i2) {
                    objArr[i2] = null;
                }
                return objArr;
            default:
                i.e(objArr, "array");
                return i.j(this, objArr);
        }
    }
}
