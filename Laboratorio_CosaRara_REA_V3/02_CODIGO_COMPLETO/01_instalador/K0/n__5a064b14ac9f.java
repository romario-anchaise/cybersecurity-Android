// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p018k0;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class n extends o implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3425a = new ArrayList();

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof n) && ((n) obj).f3425a.equals(this.f3425a));
    }

    public final int hashCode() {
        return this.f3425a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f3425a.iterator();
    }
}
