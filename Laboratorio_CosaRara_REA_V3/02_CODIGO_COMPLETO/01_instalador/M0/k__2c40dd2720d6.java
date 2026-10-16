// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f3714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f3715b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n f3717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3718e;

    public k(n nVar, int i2) {
        this.f3718e = i2;
        this.f3717d = nVar;
        this.f3714a = nVar.f3735f.f3724d;
        this.f3716c = nVar.f3734e;
    }

    public final Object a() {
        return b();
    }

    public final m b() {
        m mVar = this.f3714a;
        n nVar = this.f3717d;
        if (mVar == nVar.f3735f) {
            throw new NoSuchElementException();
        }
        if (nVar.f3734e != this.f3716c) {
            throw new ConcurrentModificationException();
        }
        this.f3714a = mVar.f3724d;
        this.f3715b = mVar;
        return mVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3714a != this.f3717d.f3735f;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.f3718e) {
            case 1:
                return b().f3726f;
            default:
                return a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        m mVar = this.f3715b;
        if (mVar == null) {
            throw new IllegalStateException();
        }
        n nVar = this.f3717d;
        nVar.c(mVar, true);
        this.f3715b = null;
        this.f3716c = nVar.f3734e;
    }
}
