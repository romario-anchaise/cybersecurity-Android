// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

import F0.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p034t0.d;

/* JADX INFO: loaded from: classes.dex */
public final class o implements Iterable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f2681b = new o(p036u0.o.f4147a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2682a;

    public o(Map map) {
        this.f2682a = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            if (i.a(this.f2682a, ((o) obj).f2682a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2682a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Map map = this.f2682a;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (entry.getValue() != null) {
                throw new ClassCastException();
            }
            arrayList.add(new d(str, null));
        }
        return arrayList.iterator();
    }

    public final String toString() {
        return "Parameters(entries=" + this.f2682a + ')';
    }
}
