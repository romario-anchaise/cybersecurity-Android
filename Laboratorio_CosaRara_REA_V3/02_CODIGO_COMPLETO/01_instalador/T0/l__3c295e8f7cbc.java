// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package T0;

import N0.AbstractC0045q;

/* JADX INFO: loaded from: classes.dex */
public final class l extends AbstractC0045q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f618c = new l();

    @Override // N0.AbstractC0045q
    public final void u(p040w0.i iVar, Runnable runnable) {
        d dVar = d.f604d;
        dVar.f606c.f(runnable, k.f617h, false);
    }

    public final AbstractC0045q w(int i2) {
        R0.a.a(i2);
        if (i2 >= k.f614d) {
            return this;
        }
        R0.a.a(i2);
        return new R0.i(this, i2);
    }
}
