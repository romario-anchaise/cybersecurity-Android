// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package L0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f346b;

    public b(c cVar, int i2) {
        this.f345a = cVar;
        this.f346b = i2;
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + '.').toString());
    }

    @Override // L0.c
    public final Iterator iterator() {
        return new F0.a(this);
    }
}
