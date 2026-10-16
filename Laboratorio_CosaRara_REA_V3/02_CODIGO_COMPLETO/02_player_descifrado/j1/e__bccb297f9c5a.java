// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j1;

import java.util.ConcurrentModificationException;
import java.util.Map;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Map.Entry {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f2338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2340e;

    public e(f fVar, int i3) {
        fVar.getClass();
        this.f2338c = fVar;
        this.f2339d = i3;
        this.f2340e = fVar.f2349j;
    }

    public final void a() {
        if (this.f2338c.f2349j != this.f2340e) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return q1.e.a(entry.getKey(), getKey()) && q1.e.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        a();
        return this.f2338c.f2342c[this.f2339d];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        Object[] objArr = this.f2338c.f2343d;
        objArr.getClass();
        return objArr[this.f2339d];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        f fVar = this.f2338c;
        fVar.b();
        Object[] objArr = fVar.f2343d;
        if (objArr == null) {
            int length = fVar.f2342c.length;
            if (length < 0) {
                o2.i("capacity must be non-negative.");
                return null;
            }
            objArr = new Object[length];
            fVar.f2343d = objArr;
        }
        int i3 = this.f2339d;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
