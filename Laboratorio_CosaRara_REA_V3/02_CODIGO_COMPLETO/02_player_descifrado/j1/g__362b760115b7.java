// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j1;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends i1.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f2355d;

    public /* synthetic */ g(f fVar, int i3) {
        this.f2354c = i3;
        this.f2355d = fVar;
    }

    @Override // i1.f
    public final int a() {
        switch (this.f2354c) {
            case 0:
                break;
        }
        return this.f2355d.f2350k;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f2354c) {
            case 0:
                ((Map.Entry) obj).getClass();
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int i3 = this.f2354c;
        collection.getClass();
        switch (i3) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f2354c) {
            case 0:
                this.f2355d.clear();
                break;
            default:
                this.f2355d.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f2354c) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                f fVar = this.f2355d;
                fVar.getClass();
                int iF = fVar.f(entry.getKey());
                if (iF < 0) {
                    return false;
                }
                Object[] objArr = fVar.f2343d;
                objArr.getClass();
                return q1.e.a(objArr[iF], entry.getValue());
            default:
                return this.f2355d.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.f2354c) {
            case 0:
                collection.getClass();
                return this.f2355d.d(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f2354c) {
            case 0:
                break;
        }
        return this.f2355d.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f2354c) {
            case 0:
                f fVar = this.f2355d;
                fVar.getClass();
                return new d(fVar, 0);
            default:
                f fVar2 = this.f2355d;
                fVar2.getClass();
                return new d(fVar2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f2354c) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                f fVar = this.f2355d;
                fVar.getClass();
                fVar.b();
                int iF = fVar.f(entry.getKey());
                if (iF < 0) {
                    return false;
                }
                Object[] objArr = fVar.f2343d;
                objArr.getClass();
                if (!q1.e.a(objArr[iF], entry.getValue())) {
                    return false;
                }
                fVar.j(iF);
                return true;
            default:
                f fVar2 = this.f2355d;
                fVar2.b();
                int iF2 = fVar2.f(obj);
                if (iF2 < 0) {
                    return false;
                }
                fVar2.j(iF2);
                return true;
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        int i3 = this.f2354c;
        collection.getClass();
        switch (i3) {
            case 0:
                this.f2355d.b();
                break;
            default:
                this.f2355d.b();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        int i3 = this.f2354c;
        collection.getClass();
        switch (i3) {
            case 0:
                this.f2355d.b();
                break;
            default:
                this.f2355d.b();
                break;
        }
        return super.retainAll(collection);
    }
}
