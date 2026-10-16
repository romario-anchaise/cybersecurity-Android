// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p036u0;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class a extends F0.a implements ListIterator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f4137d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, int i2) {
        super(cVar);
        this.f4137d = cVar;
        int iA = cVar.a();
        if (i2 >= 0 && i2 <= iA) {
            this.f162b = i2;
            return;
        }
        throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + iA);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f162b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f162b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f162b - 1;
        this.f162b = i2;
        return this.f4137d.get(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f162b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
