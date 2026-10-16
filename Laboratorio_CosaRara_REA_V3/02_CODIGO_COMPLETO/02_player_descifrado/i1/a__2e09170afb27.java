// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class a implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2094c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f2096e;

    public a(u1.a aVar) {
        this.f2096e = aVar.f3261c.iterator();
        this.f2095d = aVar.f3262d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f2094c) {
            case 0:
                return this.f2095d < ((d) this.f2096e).a();
            case 1:
                return this.f2095d < ((Object[]) this.f2096e).length;
            default:
                Iterator it = (Iterator) this.f2096e;
                while (this.f2095d > 0 && it.hasNext()) {
                    it.next();
                    this.f2095d--;
                }
                return it.hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f2094c) {
            case 0:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                d dVar = (d) this.f2096e;
                int i3 = this.f2095d;
                this.f2095d = i3 + 1;
                return dVar.get(i3);
            case 1:
                try {
                    Object[] objArr = (Object[]) this.f2096e;
                    int i4 = this.f2095d;
                    this.f2095d = i4 + 1;
                    return objArr[i4];
                } catch (ArrayIndexOutOfBoundsException e3) {
                    this.f2095d--;
                    throw new NoSuchElementException(e3.getMessage());
                }
            default:
                Iterator it = (Iterator) this.f2096e;
                while (this.f2095d > 0 && it.hasNext()) {
                    it.next();
                    this.f2095d--;
                }
                return it.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f2094c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public a(d dVar) {
        this.f2096e = dVar;
    }

    public a(Object[] objArr) {
        objArr.getClass();
        this.f2096e = objArr;
    }
}
