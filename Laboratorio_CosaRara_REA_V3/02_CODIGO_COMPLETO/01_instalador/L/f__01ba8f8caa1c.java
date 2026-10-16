// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p019l;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class f implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f3530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f3531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap f3532c = new WeakHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3533d = 0;

    public final boolean equals(Object obj) {
        b bVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f3533d != fVar.f3533d) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = fVar.iterator();
        while (true) {
            bVar = (b) it;
            if (!bVar.hasNext()) {
                break;
            }
            b bVar2 = (b) it2;
            if (!bVar2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) bVar.next();
            Object next = bVar2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (bVar.hasNext() || ((b) it2).hasNext()) ? false : true;
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) bVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        b bVar = new b(this.f3530a, this.f3531b, 0);
        this.f3532c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) bVar.next()).toString());
            if (bVar.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
