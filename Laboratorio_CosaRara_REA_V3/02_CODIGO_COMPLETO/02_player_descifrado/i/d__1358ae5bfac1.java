// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i;

import java.util.ArrayList;
import java.util.List;
import v1.l;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f2088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f2089d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.ArrayList] */
    public d(String str, boolean z2, List list, List list2) {
        list.getClass();
        list2.getClass();
        this.f2086a = str;
        this.f2087b = z2;
        this.f2088c = list;
        this.f2089d = list2;
        if (list2.isEmpty()) {
            int size = list.size();
            list2 = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                list2.add("ASC");
            }
        }
        this.f2089d = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str = dVar.f2086a;
            if (this.f2087b == dVar.f2087b && q1.e.a(this.f2088c, dVar.f2088c) && q1.e.a(this.f2089d, dVar.f2089d)) {
                String str2 = this.f2086a;
                return l.z(str2, "index_", false) ? l.z(str, "index_", false) : str2.equals(str);
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f2086a;
        return this.f2089d.hashCode() + ((this.f2088c.hashCode() + ((((l.z(str, "index_", false) ? -1184239155 : str.hashCode()) * 31) + (this.f2087b ? 1 : 0)) * 31)) * 31);
    }

    public final String toString() {
        return "Index{name='" + this.f2086a + "', unique=" + this.f2087b + ", columns=" + this.f2088c + ", orders=" + this.f2089d + "'}";
    }
}
