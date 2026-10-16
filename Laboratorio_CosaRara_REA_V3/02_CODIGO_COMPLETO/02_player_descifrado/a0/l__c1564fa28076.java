// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends j {
    public final boolean i(Object obj) {
        if (obj == null) {
            obj = j.f31i;
        }
        if (!j.f30h.e(this, null, obj)) {
            return false;
        }
        j.c(this);
        return true;
    }

    public final boolean j(Throwable th) {
        if (!j.f30h.e(this, null, new d(th))) {
            return false;
        }
        j.c(this);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    public final boolean k(j jVar) {
        d dVar;
        jVar.getClass();
        Object obj = this.f32c;
        if (obj != null) {
            if (obj instanceof b) {
                jVar.cancel(((b) obj).f10a);
            }
        } else if (jVar.isDone()) {
            if (j.f30h.e(this, null, j.f(jVar))) {
                j.c(this);
                return true;
            }
        } else {
            g gVar = new g(this, jVar);
            if (j.f30h.e(this, null, gVar)) {
                try {
                    jVar.b(gVar, k.f35c);
                    return true;
                } catch (Throwable th) {
                    try {
                        dVar = new d(th);
                    } catch (Throwable unused) {
                        dVar = d.f12b;
                    }
                    j.f30h.e(this, gVar, dVar);
                    return true;
                }
            }
            obj = this.f32c;
            if (obj instanceof b) {
                jVar.cancel(((b) obj).f10a);
            }
        }
        return false;
    }
}
