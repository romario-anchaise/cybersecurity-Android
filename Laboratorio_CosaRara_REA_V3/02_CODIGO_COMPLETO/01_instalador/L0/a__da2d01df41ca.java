// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package L0;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f344a;

    public a(g gVar) {
        this.f344a = new AtomicReference(gVar);
    }

    @Override // L0.c
    public final Iterator iterator() {
        c cVar = (c) this.f344a.getAndSet(null);
        if (cVar != null) {
            return cVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
