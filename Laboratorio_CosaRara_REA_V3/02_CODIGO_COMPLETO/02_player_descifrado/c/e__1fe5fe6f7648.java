// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f377f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i f378g;

    public e(i iVar, int i3) {
        this.f378g = iVar;
        this.f374c = i3;
        this.f375d = iVar.e();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f376e < this.f375d;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objC = this.f378g.c(this.f376e, this.f374c);
        this.f376e++;
        this.f377f = true;
        return objC;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f377f) {
            throw new IllegalStateException();
        }
        int i3 = this.f376e - 1;
        this.f376e = i3;
        this.f375d--;
        this.f377f = false;
        this.f378g.i(i3);
    }
}
