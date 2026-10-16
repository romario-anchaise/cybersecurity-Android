// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p019l;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b extends e implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f3520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f3521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3522c;

    public b(c cVar, c cVar2, int i2) {
        this.f3522c = i2;
        this.f3520a = cVar2;
        this.f3521b = cVar;
    }

    @Override // p019l.e
    public final void a(c cVar) {
        c cVar2;
        c cVarB = null;
        if (this.f3520a == cVar && cVar == this.f3521b) {
            this.f3521b = null;
            this.f3520a = null;
        }
        c cVar3 = this.f3520a;
        if (cVar3 == cVar) {
            switch (this.f3522c) {
                case 0:
                    cVar2 = cVar3.f3526d;
                    break;
                default:
                    cVar2 = cVar3.f3525c;
                    break;
            }
            this.f3520a = cVar2;
        }
        c cVar4 = this.f3521b;
        if (cVar4 == cVar) {
            c cVar5 = this.f3520a;
            if (cVar4 != cVar5 && cVar5 != null) {
                cVarB = b(cVar4);
            }
            this.f3521b = cVarB;
        }
    }

    public final c b(c cVar) {
        switch (this.f3522c) {
            case 0:
                return cVar.f3525c;
            default:
                return cVar.f3526d;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3521b != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar = this.f3521b;
        c cVar2 = this.f3520a;
        this.f3521b = (cVar == cVar2 || cVar2 == null) ? null : b(cVar);
        return cVar;
    }
}
