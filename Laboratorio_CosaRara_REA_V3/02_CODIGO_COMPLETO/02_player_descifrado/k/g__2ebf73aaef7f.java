// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k;

import android.content.Context;
import g.j;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements j.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f2387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f2389e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h1.c f2392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2393i;

    public g(Context context, String str, j jVar, boolean z2, boolean z3) {
        jVar.getClass();
        this.f2387c = context;
        this.f2388d = str;
        this.f2389e = jVar;
        this.f2390f = z2;
        this.f2391g = z3;
        this.f2392h = new h1.c(new b(4, this));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f2392h.f1949d != h1.e.f1952b) {
            d().close();
        }
    }

    public final f d() {
        return (f) this.f2392h.a();
    }

    @Override // j.d
    public final c r() {
        return d().d(true);
    }

    @Override // j.d
    public final void setWriteAheadLoggingEnabled(boolean z2) {
        if (this.f2392h.f1949d != h1.e.f1952b) {
            f fVarD = d();
            fVarD.getClass();
            fVarD.setWriteAheadLoggingEnabled(z2);
        }
        this.f2393i = z2;
    }
}
