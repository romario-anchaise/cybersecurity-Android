// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q1;

import e2.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import p1.l;
import p1.m;
import p1.n;
import p1.o;
import p1.p;
import p1.q;
import p1.r;
import p1.s;
import p1.t;
import p1.u;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3116a;

    static {
        List listAsList = Arrays.asList(p1.a.class, l.class, p.class, z.class, k.b.class, q.class, r.class, s.class, t.class, u.class, p1.b.class, p1.c.class, p1.d.class, p1.e.class, p1.f.class, p1.g.class, p1.h.class, p1.i.class, p1.j.class, p1.k.class, m.class, n.class, o.class);
        listAsList.getClass();
        ArrayList arrayList = new ArrayList(i1.k.A(listAsList));
        int i3 = 0;
        int i4 = 0;
        for (Object obj : listAsList) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new h1.b((Class) obj, Integer.valueOf(i4)));
            i4 = i5;
        }
        int size = arrayList.size();
        if (size != 0) {
            if (size == 1) {
                h1.b bVar = (h1.b) arrayList.get(0);
                bVar.getClass();
                Collections.singletonMap(bVar.f1946c, bVar.f1947d).getClass();
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(q2.c.v(arrayList.size()));
            int size2 = arrayList.size();
            while (i3 < size2) {
                Object obj2 = arrayList.get(i3);
                i3++;
                h1.b bVar2 = (h1.b) obj2;
                linkedHashMap.put(bVar2.f1946c, bVar2.f1947d);
            }
        }
    }

    public c(Class cls) {
        this.f3116a = cls;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && q2.k.g(this).equals(q2.k.g((c) obj));
    }

    public final int hashCode() {
        return q2.k.g(this).hashCode();
    }

    public final String toString() {
        return this.f3116a + " (Kotlin reflection is not available)";
    }
}
