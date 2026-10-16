// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Collection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f385c;

    public h(i iVar) {
        this.f385c = iVar;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f385c.b();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.f385c.g(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
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
        return this.f385c.e() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new e(this.f385c, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        i iVar = this.f385c;
        int iG = iVar.g(obj);
        if (iG < 0) {
            return false;
        }
        iVar.i(iG);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        i iVar = this.f385c;
        int iE = iVar.e();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < iE) {
            if (collection.contains(iVar.c(i3, 1))) {
                iVar.i(i3);
                i3--;
                iE--;
                z2 = true;
            }
            i3++;
        }
        return z2;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        i iVar = this.f385c;
        int iE = iVar.e();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < iE) {
            if (!collection.contains(iVar.c(i3, 1))) {
                iVar.i(i3);
                i3--;
                iE--;
                z2 = true;
            }
            i3++;
        }
        return z2;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f385c.e();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        i iVar = this.f385c;
        int iE = iVar.e();
        Object[] objArr = new Object[iE];
        for (int i3 = 0; i3 < iE; i3++) {
            objArr[i3] = iVar.c(i3, 1);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.f385c.n(objArr, 1);
    }
}
