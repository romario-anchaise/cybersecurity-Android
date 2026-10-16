// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Set {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f380d;

    public /* synthetic */ f(i iVar, int i3) {
        this.f379c = i3;
        this.f380d = iVar;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f379c) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f379c) {
            case 0:
                i iVar = this.f380d;
                int iE = iVar.e();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    iVar.h(entry.getKey(), entry.getValue());
                }
                return iE != iVar.e();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        switch (this.f379c) {
            case 0:
                this.f380d.b();
                break;
            default:
                this.f380d.b();
                break;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f379c) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                i iVar = this.f380d;
                int iF = iVar.f(key);
                if (iF < 0) {
                    return false;
                }
                Object objC = iVar.c(iF, 1);
                Object value = entry.getValue();
                return objC == value || (objC != null && objC.equals(value));
            default:
                return this.f380d.f(obj) >= 0;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f379c) {
            case 0:
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        return false;
                    }
                }
                return true;
            default:
                Map mapD = this.f380d.d();
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!mapD.containsKey(it2.next())) {
                        return false;
                    }
                }
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        switch (this.f379c) {
            case 0:
                break;
        }
        return i.l(this, obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        switch (this.f379c) {
            case 0:
                i iVar = this.f380d;
                int iHashCode = 0;
                for (int iE = iVar.e() - 1; iE >= 0; iE--) {
                    Object objC = iVar.c(iE, 0);
                    Object objC2 = iVar.c(iE, 1);
                    iHashCode += (objC == null ? 0 : objC.hashCode()) ^ (objC2 == null ? 0 : objC2.hashCode());
                }
                return iHashCode;
            default:
                i iVar2 = this.f380d;
                int iHashCode2 = 0;
                for (int iE2 = iVar2.e() - 1; iE2 >= 0; iE2--) {
                    Object objC3 = iVar2.c(iE2, 0);
                    iHashCode2 += objC3 == null ? 0 : objC3.hashCode();
                }
                return iHashCode2;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f379c) {
            case 0:
                return this.f380d.e() == 0;
            default:
                return this.f380d.e() == 0;
        }
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f379c) {
            case 0:
                return new g(this.f380d);
            default:
                return new e(this.f380d, 0);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.f379c) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                i iVar = this.f380d;
                int iF = iVar.f(obj);
                if (iF < 0) {
                    return false;
                }
                iVar.i(iF);
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f379c) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                Map mapD = this.f380d.d();
                int size = mapD.size();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    mapD.remove(it.next());
                }
                return size != mapD.size();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f379c) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                Map mapD = this.f380d.d();
                int size = mapD.size();
                Iterator it = mapD.keySet().iterator();
                while (it.hasNext()) {
                    if (!collection.contains(it.next())) {
                        it.remove();
                    }
                }
                return size != mapD.size();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        switch (this.f379c) {
            case 0:
                break;
        }
        return this.f380d.e();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        switch (this.f379c) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                i iVar = this.f380d;
                int iE = iVar.e();
                Object[] objArr = new Object[iE];
                for (int i3 = 0; i3 < iE; i3++) {
                    objArr[i3] = iVar.c(i3, 0);
                }
                return objArr;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f379c) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return this.f380d.n(objArr, 0);
        }
    }
}
