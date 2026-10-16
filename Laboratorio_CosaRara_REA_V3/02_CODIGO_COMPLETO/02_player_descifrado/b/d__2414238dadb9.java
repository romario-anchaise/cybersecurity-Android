// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f249c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f250d;

    public d(e eVar) {
        this.f250d = eVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f249c) {
            return null;
        }
        this.f249c = false;
        return null;
    }
}
