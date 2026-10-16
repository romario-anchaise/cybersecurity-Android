// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package J0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f284d;

    public b(int i2, int i3, int i4) {
        this.f281a = i4;
        this.f282b = i3;
        boolean z2 = false;
        if (i4 <= 0 ? i2 >= i3 : i2 <= i3) {
            z2 = true;
        }
        this.f283c = z2;
        this.f284d = z2 ? i2 : i3;
    }

    public final int a() {
        int i2 = this.f284d;
        if (i2 != this.f282b) {
            this.f284d = this.f281a + i2;
        } else {
            if (!this.f283c) {
                throw new NoSuchElementException();
            }
            this.f283c = false;
        }
        return i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f283c;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
