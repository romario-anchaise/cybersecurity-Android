// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p021m;

import F0.i;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p022m0.l;

/* JADX INFO: loaded from: classes.dex */
public final class e extends i implements Map {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f3675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f3676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f3677f;

    @Override // java.util.Map
    public final Set entrySet() {
        l lVar = this.f3675d;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this, 2);
        this.f3675d = lVar2;
        return lVar2;
    }

    public final boolean i(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(Collection collection) {
        int i2 = this.f3689c;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i2 != this.f3689c;
    }

    @Override // java.util.Map
    public final Set keySet() {
        b bVar = this.f3676e;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.f3676e = bVar2;
        return bVar2;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        int size = map.size() + this.f3689c;
        int i2 = this.f3689c;
        int[] iArr = this.f3687a;
        if (iArr.length < size) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, size);
            i.d(iArrCopyOf, "copyOf(this, newSize)");
            this.f3687a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f3688b, size * 2);
            i.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f3688b = objArrCopyOf;
        }
        if (this.f3689c != i2) {
            throw new ConcurrentModificationException();
        }
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        d dVar = this.f3677f;
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(0, this);
        this.f3677f = dVar2;
        return dVar2;
    }
}
