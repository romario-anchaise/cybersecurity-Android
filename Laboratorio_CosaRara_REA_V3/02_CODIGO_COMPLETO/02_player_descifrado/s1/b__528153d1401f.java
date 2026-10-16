// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3235f;

    public b(int i3, int i4, int i5) {
        this.f3232c = i5;
        this.f3233d = i4;
        boolean z2 = false;
        if (i5 <= 0 ? i3 >= i4 : i3 <= i4) {
            z2 = true;
        }
        this.f3234e = z2;
        this.f3235f = z2 ? i3 : i4;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3234e;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i3 = this.f3235f;
        if (i3 != this.f3233d) {
            this.f3235f = this.f3232c + i3;
        } else {
            if (!this.f3234e) {
                throw new NoSuchElementException();
            }
            this.f3234e = false;
        }
        return Integer.valueOf(i3);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
