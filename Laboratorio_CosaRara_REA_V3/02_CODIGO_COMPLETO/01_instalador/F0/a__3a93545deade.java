// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package F0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class a implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f161a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f163c;

    public a(Object[] objArr) {
        i.e(objArr, "array");
        this.f163c = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        switch (this.f161a) {
            case 0:
                return this.f162b < ((Object[]) this.f163c).length;
            case 1:
                break;
            default:
                return this.f162b < ((p036u0.c) this.f163c).a();
        }
        while (true) {
            int i2 = this.f162b;
            it = (Iterator) this.f163c;
            if (i2 > 0 && it.hasNext()) {
                it.next();
                this.f162b--;
            }
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        switch (this.f161a) {
            case 0:
                try {
                    Object[] objArr = (Object[]) this.f163c;
                    int i2 = this.f162b;
                    this.f162b = i2 + 1;
                    return objArr[i2];
                } catch (ArrayIndexOutOfBoundsException e2) {
                    this.f162b--;
                    throw new NoSuchElementException(e2.getMessage());
                }
            case 1:
                break;
            default:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i3 = this.f162b;
                this.f162b = i3 + 1;
                return ((p036u0.c) this.f163c).get(i3);
        }
        while (true) {
            int i4 = this.f162b;
            it = (Iterator) this.f163c;
            if (i4 > 0 && it.hasNext()) {
                it.next();
                this.f162b--;
            }
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f161a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public a(p036u0.c cVar) {
        this.f163c = cVar;
    }

    public a(L0.b bVar) {
        this.f163c = bVar.f345a.iterator();
        this.f162b = bVar.f346b;
    }
}
