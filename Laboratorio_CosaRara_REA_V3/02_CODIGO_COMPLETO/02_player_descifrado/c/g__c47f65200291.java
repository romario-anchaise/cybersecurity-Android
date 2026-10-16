// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Iterator, Map.Entry {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f381c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i f384f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f383e = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f382d = -1;

    public g(i iVar) {
        this.f384f = iVar;
        this.f381c = iVar.e() - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f383e) {
            o2.k("This container does not support retaining Map.Entry objects");
            return false;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i3 = this.f382d;
        i iVar = this.f384f;
        Object objC = iVar.c(i3, 0);
        if (key != objC && (key == null || !key.equals(objC))) {
            return false;
        }
        Object value = entry.getValue();
        Object objC2 = iVar.c(this.f382d, 1);
        return value == objC2 || (value != null && value.equals(objC2));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f383e) {
            return this.f384f.c(this.f382d, 0);
        }
        o2.k("This container does not support retaining Map.Entry objects");
        return null;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f383e) {
            return this.f384f.c(this.f382d, 1);
        }
        o2.k("This container does not support retaining Map.Entry objects");
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f382d < this.f381c;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f383e) {
            o2.k("This container does not support retaining Map.Entry objects");
            return 0;
        }
        int i3 = this.f382d;
        i iVar = this.f384f;
        Object objC = iVar.c(i3, 0);
        Object objC2 = iVar.c(this.f382d, 1);
        return (objC == null ? 0 : objC.hashCode()) ^ (objC2 != null ? objC2.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f382d++;
        this.f383e = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f383e) {
            throw new IllegalStateException();
        }
        this.f384f.i(this.f382d);
        this.f382d--;
        this.f381c--;
        this.f383e = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f383e) {
            return this.f384f.j(this.f382d, obj);
        }
        o2.k("This container does not support retaining Map.Entry objects");
        return null;
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
