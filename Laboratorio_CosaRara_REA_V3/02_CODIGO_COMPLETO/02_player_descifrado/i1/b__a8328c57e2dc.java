// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i1;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a implements ListIterator {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d f2097f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, int i3) {
        super(dVar);
        this.f2097f = dVar;
        int iA = dVar.a();
        if (i3 < 0 || i3 > iA) {
            throw new IndexOutOfBoundsException(a0.a.f(i3, iA, "index: ", ", size: "));
        }
        this.f2095d = i3;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f2095d > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f2095d;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i3 = this.f2095d - 1;
        this.f2095d = i3;
        return this.f2097f.get(i3);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f2095d - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
