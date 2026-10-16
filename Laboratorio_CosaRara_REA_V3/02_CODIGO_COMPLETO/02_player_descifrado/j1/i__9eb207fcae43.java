// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j1;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends i1.f implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f2357d = new i(f.f2341p);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f2358c;

    public i() {
        this.f2358c = new f();
    }

    @Override // i1.f
    public final int a() {
        return this.f2358c.f2350k;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        return this.f2358c.a(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        collection.getClass();
        this.f2358c.b();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f2358c.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f2358c.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f2358c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        f fVar = this.f2358c;
        fVar.getClass();
        return new d(fVar, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        f fVar = this.f2358c;
        fVar.b();
        int iF = fVar.f(obj);
        if (iF < 0) {
            return false;
        }
        fVar.j(iF);
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        collection.getClass();
        this.f2358c.b();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        this.f2358c.b();
        return super.retainAll(collection);
    }

    public i(f fVar) {
        fVar.getClass();
        this.f2358c = fVar;
    }
}
