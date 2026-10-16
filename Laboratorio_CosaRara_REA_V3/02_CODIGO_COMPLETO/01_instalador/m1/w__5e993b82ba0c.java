// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.io.IOException;
import k1.InterfaceC0195k;

/* JADX INFO: renamed from: m1.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0218w extends X0.G {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X0.G f3862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k1.C f3863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IOException f3864d;

    public C0218w(X0.G g) {
        this.f3862b = g;
        this.f3863c = f1.l.f(new W.b(this, g.j()));
    }

    @Override // X0.G
    public final long a() {
        return this.f3862b.a();
    }

    @Override // X0.G, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f3862b.close();
    }

    @Override // X0.G
    public final X0.s f() {
        return this.f3862b.f();
    }

    @Override // X0.G
    public final InterfaceC0195k j() {
        return this.f3863c;
    }
}
