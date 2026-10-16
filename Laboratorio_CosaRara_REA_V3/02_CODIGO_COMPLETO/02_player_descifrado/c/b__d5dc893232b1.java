// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends j implements Map {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f361j;

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.f361j == null) {
            this.f361j = new a(0, this);
        }
        a aVar = this.f361j;
        if (((f) aVar.f386a) == null) {
            aVar.f386a = new f(aVar, 0);
        }
        return (f) aVar.f386a;
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.f361j == null) {
            this.f361j = new a(0, this);
        }
        a aVar = this.f361j;
        if (((f) aVar.f387b) == null) {
            aVar.f387b = new f(aVar, 1);
        }
        return (f) aVar.f387b;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        int size = map.size() + this.f395e;
        int i3 = this.f395e;
        int[] iArr = this.f393c;
        if (iArr.length < size) {
            Object[] objArr = this.f394d;
            a(size);
            if (this.f395e > 0) {
                System.arraycopy(iArr, 0, this.f393c, 0, i3);
                System.arraycopy(objArr, 0, this.f394d, 0, i3 << 1);
            }
            j.b(iArr, objArr, i3);
        }
        if (this.f395e != i3) {
            throw new ConcurrentModificationException();
        }
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        if (this.f361j == null) {
            this.f361j = new a(0, this);
        }
        a aVar = this.f361j;
        if (((h) aVar.f388c) == null) {
            aVar.f388c = new h(aVar);
        }
        return (h) aVar.f388c;
    }
}
