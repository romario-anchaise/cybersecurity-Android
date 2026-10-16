// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package L0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f355b;

    public i(j jVar) {
        this.f355b = jVar;
        this.f354a = new M0.b(jVar.f356a);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f354a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f355b.f357b.d(this.f354a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
