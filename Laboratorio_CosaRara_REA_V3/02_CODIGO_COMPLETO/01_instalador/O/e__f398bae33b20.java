// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p025o;

import f1.l;

/* JADX INFO: loaded from: classes.dex */
public final class e extends l {
    @Override // f1.l
    public final void P(f fVar, f fVar2) {
        fVar.f3980b = fVar2;
    }

    @Override // f1.l
    public final void Q(f fVar, Thread thread) {
        fVar.f3979a = thread;
    }

    @Override // f1.l
    public final boolean g(g gVar, c cVar) {
        c cVar2 = c.f3972b;
        synchronized (gVar) {
            try {
                if (gVar.f3985b != cVar) {
                    return false;
                }
                gVar.f3985b = cVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // f1.l
    public final boolean h(g gVar, Object obj, Object obj2) {
        synchronized (gVar) {
            try {
                if (gVar.f3984a != obj) {
                    return false;
                }
                gVar.f3984a = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // f1.l
    public final boolean i(g gVar, f fVar, f fVar2) {
        synchronized (gVar) {
            try {
                if (gVar.f3986c != fVar) {
                    return false;
                }
                gVar.f3986c = fVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
