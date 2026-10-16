// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v1;

import d2.o;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3280c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s1.c f3283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ y.l f3284g;

    public b(y.l lVar) {
        this.f3284g = lVar;
        int iE = y.f.e(0, ((String) lVar.f5991c).length());
        this.f3281d = iE;
        this.f3282e = iE;
    }

    public final void a() {
        h1.b bVar;
        y.l lVar = this.f3284g;
        String str = (String) lVar.f5991c;
        int i3 = this.f3282e;
        if (i3 < 0) {
            this.f3280c = 0;
            this.f3283f = null;
            return;
        }
        if (i3 <= str.length() && (bVar = (h1.b) ((o) lVar.f5992d).e(str, Integer.valueOf(this.f3282e))) != null) {
            int iIntValue = ((Number) bVar.f1946c).intValue();
            int iIntValue2 = ((Number) bVar.f1947d).intValue();
            this.f3283f = y.f.o(this.f3281d, iIntValue);
            int i4 = iIntValue + iIntValue2;
            this.f3281d = i4;
            this.f3282e = i4 + (iIntValue2 == 0 ? 1 : 0);
        } else {
            this.f3283f = new s1.c(this.f3281d, str.length() - 1, 1);
            this.f3282e = -1;
        }
        this.f3280c = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f3280c == -1) {
            a();
        }
        return this.f3280c == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f3280c == -1) {
            a();
        }
        if (this.f3280c == 0) {
            throw new NoSuchElementException();
        }
        s1.c cVar = this.f3283f;
        cVar.getClass();
        this.f3283f = null;
        this.f3280c = -1;
        return cVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
