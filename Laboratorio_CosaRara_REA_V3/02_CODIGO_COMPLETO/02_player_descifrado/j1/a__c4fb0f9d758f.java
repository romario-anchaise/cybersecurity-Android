// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j1;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ListIterator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2320d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i1.e f2323g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2319c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2321e = -1;

    public a(c cVar, int i3) {
        this.f2323g = cVar;
        this.f2320d = i3;
        this.f2322f = ((AbstractList) cVar).modCount;
    }

    public void a() {
        if (((AbstractList) ((b) this.f2323g).f2328g).modCount != this.f2322f) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f2319c) {
            case 0:
                a();
                b bVar = (b) this.f2323g;
                int i3 = this.f2320d;
                this.f2320d = i3 + 1;
                bVar.add(i3, obj);
                this.f2321e = -1;
                this.f2322f = ((AbstractList) bVar).modCount;
                break;
            default:
                b();
                c cVar = (c) this.f2323g;
                int i4 = this.f2320d;
                this.f2320d = i4 + 1;
                cVar.add(i4, obj);
                this.f2321e = -1;
                this.f2322f = ((AbstractList) cVar).modCount;
                break;
        }
    }

    public void b() {
        if (((AbstractList) ((c) this.f2323g)).modCount != this.f2322f) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f2319c) {
            case 0:
                return this.f2320d < ((b) this.f2323g).f2326e;
            default:
                return this.f2320d < ((c) this.f2323g).f2331d;
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f2319c) {
            case 0:
                return this.f2320d > 0;
            default:
                return this.f2320d > 0;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f2319c) {
            case 0:
                a();
                int i3 = this.f2320d;
                b bVar = (b) this.f2323g;
                if (i3 >= bVar.f2326e) {
                    throw new NoSuchElementException();
                }
                this.f2320d = i3 + 1;
                this.f2321e = i3;
                return bVar.f2324c[bVar.f2325d + i3];
            default:
                b();
                int i4 = this.f2320d;
                c cVar = (c) this.f2323g;
                if (i4 >= cVar.f2331d) {
                    throw new NoSuchElementException();
                }
                this.f2320d = i4 + 1;
                this.f2321e = i4;
                return cVar.f2330c[i4];
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f2319c) {
            case 0:
                break;
        }
        return this.f2320d;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f2319c) {
            case 0:
                a();
                int i3 = this.f2320d;
                if (i3 <= 0) {
                    throw new NoSuchElementException();
                }
                int i4 = i3 - 1;
                this.f2320d = i4;
                this.f2321e = i4;
                b bVar = (b) this.f2323g;
                return bVar.f2324c[bVar.f2325d + i4];
            default:
                b();
                int i5 = this.f2320d;
                if (i5 <= 0) {
                    throw new NoSuchElementException();
                }
                int i6 = i5 - 1;
                this.f2320d = i6;
                this.f2321e = i6;
                return ((c) this.f2323g).f2330c[i6];
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i3;
        switch (this.f2319c) {
            case 0:
                i3 = this.f2320d;
                break;
            default:
                i3 = this.f2320d;
                break;
        }
        return i3 - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f2319c) {
            case 0:
                b bVar = (b) this.f2323g;
                a();
                int i3 = this.f2321e;
                if (i3 == -1) {
                    o2.k("Call next() or previous() before removing element from the iterator.");
                } else {
                    bVar.b(i3);
                    this.f2320d = this.f2321e;
                    this.f2321e = -1;
                    this.f2322f = ((AbstractList) bVar).modCount;
                }
                break;
            default:
                c cVar = (c) this.f2323g;
                b();
                int i4 = this.f2321e;
                if (i4 == -1) {
                    o2.k("Call next() or previous() before removing element from the iterator.");
                } else {
                    cVar.b(i4);
                    this.f2320d = this.f2321e;
                    this.f2321e = -1;
                    this.f2322f = ((AbstractList) cVar).modCount;
                }
                break;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f2319c) {
            case 0:
                a();
                int i3 = this.f2321e;
                if (i3 == -1) {
                    o2.k("Call next() or previous() before replacing element from the iterator.");
                } else {
                    ((b) this.f2323g).set(i3, obj);
                }
                break;
            default:
                b();
                int i4 = this.f2321e;
                if (i4 == -1) {
                    o2.k("Call next() or previous() before replacing element from the iterator.");
                } else {
                    ((c) this.f2323g).set(i4, obj);
                }
                break;
        }
    }

    public a(b bVar, int i3) {
        this.f2323g = bVar;
        this.f2320d = i3;
        this.f2322f = ((AbstractList) bVar).modCount;
    }
}
