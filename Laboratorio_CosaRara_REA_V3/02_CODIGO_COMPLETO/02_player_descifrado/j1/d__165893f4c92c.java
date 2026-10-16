// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j1;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f2333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f2337g;

    public d(f fVar, int i3) {
        this.f2337g = i3;
        fVar.getClass();
        this.f2333c = fVar;
        this.f2335e = -1;
        this.f2336f = fVar.f2349j;
        b();
    }

    public final void a() {
        if (this.f2333c.f2349j != this.f2336f) {
            throw new ConcurrentModificationException();
        }
    }

    public final void b() {
        while (true) {
            int i3 = this.f2334d;
            f fVar = this.f2333c;
            if (i3 >= fVar.f2347h || fVar.f2344e[i3] >= 0) {
                return;
            } else {
                this.f2334d = i3 + 1;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2334d < this.f2333c.f2347h;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f2337g) {
            case 0:
                a();
                int i3 = this.f2334d;
                f fVar = this.f2333c;
                if (i3 >= fVar.f2347h) {
                    throw new NoSuchElementException();
                }
                this.f2334d = i3 + 1;
                this.f2335e = i3;
                e eVar = new e(fVar, i3);
                b();
                return eVar;
            case 1:
                a();
                int i4 = this.f2334d;
                f fVar2 = this.f2333c;
                if (i4 >= fVar2.f2347h) {
                    throw new NoSuchElementException();
                }
                this.f2334d = i4 + 1;
                this.f2335e = i4;
                Object obj = fVar2.f2342c[i4];
                b();
                return obj;
            default:
                a();
                int i5 = this.f2334d;
                f fVar3 = this.f2333c;
                if (i5 >= fVar3.f2347h) {
                    throw new NoSuchElementException();
                }
                this.f2334d = i5 + 1;
                this.f2335e = i5;
                Object[] objArr = fVar3.f2343d;
                objArr.getClass();
                Object obj2 = objArr[this.f2335e];
                b();
                return obj2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        a();
        if (this.f2335e == -1) {
            o2.k("Call next() before removing element from the iterator.");
            return;
        }
        f fVar = this.f2333c;
        fVar.b();
        fVar.j(this.f2335e);
        this.f2335e = -1;
        this.f2336f = fVar.f2349j;
    }
}
