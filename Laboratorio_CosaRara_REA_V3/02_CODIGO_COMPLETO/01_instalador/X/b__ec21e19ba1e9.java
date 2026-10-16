// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X;

import k1.z;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean[] f852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f853d;

    public b(g gVar, c cVar) {
        this.f853d = gVar;
        this.f850a = cVar;
        gVar.getClass();
        this.f852c = new boolean[2];
    }

    public final void a(boolean z2) {
        g gVar = this.f853d;
        synchronized (gVar) {
            try {
                if (this.f851b) {
                    throw new IllegalStateException("editor is closed");
                }
                if (F0.i.a(this.f850a.g, this)) {
                    g.a(gVar, this, z2);
                }
                this.f851b = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final z b(int i2) {
        z zVar;
        g gVar = this.f853d;
        synchronized (gVar) {
            if (this.f851b) {
                throw new IllegalStateException("editor is closed");
            }
            this.f852c[i2] = true;
            Object obj = this.f850a.f857d.get(i2);
            e eVar = gVar.f882p;
            z zVar2 = (z) obj;
            if (!eVar.c(zVar2)) {
                p016j0.f.a(eVar.h(zVar2));
            }
            zVar = (z) obj;
        }
        return zVar;
    }
}
