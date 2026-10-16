// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p019l;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class d extends e implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f3527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3528b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f3529c;

    public d(f fVar) {
        this.f3529c = fVar;
    }

    @Override // p019l.e
    public final void a(c cVar) {
        c cVar2 = this.f3527a;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f3526d;
            this.f3527a = cVar3;
            this.f3528b = cVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f3528b) {
            return this.f3529c.f3530a != null;
        }
        c cVar = this.f3527a;
        return (cVar == null || cVar.f3525c == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f3528b) {
            this.f3528b = false;
            this.f3527a = this.f3529c.f3530a;
        } else {
            c cVar = this.f3527a;
            this.f3527a = cVar != null ? cVar.f3525c : null;
        }
        return this.f3527a;
    }
}
