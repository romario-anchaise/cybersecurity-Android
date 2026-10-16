// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package u1;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f3261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3262d;

    public a(b bVar, int i3) {
        this.f3261c = bVar;
        this.f3262d = i3;
        if (i3 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i3 + '.').toString());
    }

    @Override // u1.b
    public final Iterator iterator() {
        return new i1.a(this);
    }
}
