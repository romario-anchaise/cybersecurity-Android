// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q0;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ListIterator, Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f3105e;

    public b(e eVar, int i3) {
        int size = eVar.size();
        if (i3 < 0 || i3 > size) {
            throw new IndexOutOfBoundsException(y.f.r(i3, size, "index"));
        }
        this.f3103c = size;
        this.f3104d = i3;
        this.f3105e = eVar;
    }

    public final Object a(int i3) {
        return this.f3105e.get(i3);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f3104d < this.f3103c;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f3104d > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f3104d;
        this.f3104d = i3 + 1;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f3104d;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f3104d - 1;
        this.f3104d = i3;
        return a(i3);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f3104d - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
