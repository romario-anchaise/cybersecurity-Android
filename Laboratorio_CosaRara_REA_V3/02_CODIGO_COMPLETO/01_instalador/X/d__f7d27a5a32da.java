// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f864c;

    public d(g gVar, c cVar) {
        this.f864c = gVar;
        this.f862a = cVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f863b) {
            return;
        }
        this.f863b = true;
        g gVar = this.f864c;
        synchronized (gVar) {
            c cVar = this.f862a;
            int i2 = cVar.f860h - 1;
            cVar.f860h = i2;
            if (i2 == 0 && cVar.f859f) {
                M0.d dVar = g.f867q;
                gVar.x(cVar);
            }
        }
    }
}
