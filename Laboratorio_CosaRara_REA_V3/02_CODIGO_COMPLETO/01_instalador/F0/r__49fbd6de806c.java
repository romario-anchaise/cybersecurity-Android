// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

import F0.i;
import java.util.Map;
import p036u0.o;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f2689b = new r(o.f4147a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2690a;

    public r(Map map) {
        this.f2690a = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            if (i.a(this.f2690a, ((r) obj).f2690a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2690a.hashCode();
    }

    public final String toString() {
        return "Tags(tags=" + this.f2690a + ')';
    }
}
