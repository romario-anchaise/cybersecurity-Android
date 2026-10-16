// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends q2.c {
    @Override // q2.c
    public final boolean d(j jVar, e eVar, e eVar2) {
        synchronized (jVar) {
            try {
                if (jVar.f33d != eVar) {
                    return false;
                }
                jVar.f33d = eVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // q2.c
    public final boolean e(j jVar, Object obj, Object obj2) {
        synchronized (jVar) {
            try {
                if (jVar.f32c != obj) {
                    return false;
                }
                jVar.f32c = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // q2.c
    public final boolean f(j jVar, i iVar, i iVar2) {
        synchronized (jVar) {
            try {
                if (jVar.f34e != iVar) {
                    return false;
                }
                jVar.f34e = iVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // q2.c
    public final void y(i iVar, i iVar2) {
        iVar.f27b = iVar2;
    }

    @Override // q2.c
    public final void z(i iVar, Thread thread) {
        iVar.f26a = thread;
    }
}
