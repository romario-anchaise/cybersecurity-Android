// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package T0;

import N0.I;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends I {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f606c;

    @Override // N0.AbstractC0045q
    public final void u(p040w0.i iVar, Runnable runnable) {
        b bVar = this.f606c;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b.f592h;
        bVar.f(runnable, k.g, false);
    }
}
