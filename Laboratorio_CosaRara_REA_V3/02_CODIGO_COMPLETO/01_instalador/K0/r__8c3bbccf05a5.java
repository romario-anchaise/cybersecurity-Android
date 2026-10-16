// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p018k0;

import p022m0.n;

/* JADX INFO: loaded from: classes.dex */
public final class r extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f3427a = new n(false);

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof r) && ((r) obj).f3427a.equals(this.f3427a));
    }

    public final int hashCode() {
        return this.f3427a.hashCode();
    }
}
