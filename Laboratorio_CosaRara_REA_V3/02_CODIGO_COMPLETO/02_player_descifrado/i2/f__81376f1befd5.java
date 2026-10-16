// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f2143c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f2144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0.a f2145b;

    static {
        Set setSingleton;
        ArrayList arrayList = new ArrayList();
        int size = arrayList.size();
        if (size != 0) {
            int i3 = 0;
            if (size != 1) {
                setSingleton = new LinkedHashSet(q2.c.v(arrayList.size()));
                int size2 = arrayList.size();
                while (i3 < size2) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    setSingleton.add(obj);
                }
            } else {
                setSingleton = Collections.singleton(arrayList.get(0));
                setSingleton.getClass();
            }
        } else {
            setSingleton = i1.s.f2106c;
        }
        f2143c = new f(setSingleton, null);
    }

    public f(Set set, m0.a aVar) {
        this.f2144a = set;
        this.f2145b = aVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return fVar.f2144a.equals(this.f2144a) && q1.e.a(fVar.f2145b, this.f2145b);
    }

    public final int hashCode() {
        int iHashCode = (this.f2144a.hashCode() + 1517) * 41;
        m0.a aVar = this.f2145b;
        return iHashCode + (aVar != null ? aVar.hashCode() : 0);
    }
}
