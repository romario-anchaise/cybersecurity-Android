// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package u1;

import java.util.Iterator;
import y.l;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Iterable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f3263c;

    public c(l lVar) {
        this.f3263c = lVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new v1.b(this.f3263c);
    }
}
