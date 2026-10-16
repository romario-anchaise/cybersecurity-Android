// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package L0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Iterator, p040w0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator f349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p040w0.d f350d;

    public final RuntimeException a() {
        int i2 = this.f347a;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f347a);
    }

    @Override // p040w0.d
    public final void b(Object obj) {
        p029q.j.o(obj);
        this.f347a = 4;
    }

    @Override // p040w0.d
    public final p040w0.i g() {
        return p040w0.j.f4165a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i2 = this.f347a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw a();
                }
                Iterator it = this.f349c;
                F0.i.b(it);
                if (it.hasNext()) {
                    this.f347a = 2;
                    return true;
                }
                this.f349c = null;
            }
            this.f347a = 5;
            p040w0.d dVar = this.f350d;
            F0.i.b(dVar);
            this.f350d = null;
            dVar.b(p034t0.h.f4132b);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f347a;
        if (i2 == 0 || i2 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i2 == 2) {
            this.f347a = 1;
            Iterator it = this.f349c;
            F0.i.b(it);
            return it.next();
        }
        if (i2 != 3) {
            throw a();
        }
        this.f347a = 0;
        Object obj = this.f348b;
        this.f348b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
