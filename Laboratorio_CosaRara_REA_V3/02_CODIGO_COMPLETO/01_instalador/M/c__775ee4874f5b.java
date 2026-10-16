// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p021m;

import F0.i;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Iterator, Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3670b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f3672d;

    public c(e eVar) {
        this.f3672d = eVar;
        this.f3669a = eVar.f3689c - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f3671c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i2 = this.f3670b;
        e eVar = this.f3672d;
        return i.a(key, eVar.e(i2)) && i.a(entry.getValue(), eVar.h(this.f3670b));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f3671c) {
            return this.f3672d.e(this.f3670b);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f3671c) {
            return this.f3672d.h(this.f3670b);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3670b < this.f3669a;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f3671c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i2 = this.f3670b;
        e eVar = this.f3672d;
        Object objE = eVar.e(i2);
        Object objH = eVar.h(this.f3670b);
        return (objE == null ? 0 : objE.hashCode()) ^ (objH != null ? objH.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f3670b++;
        this.f3671c = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f3671c) {
            throw new IllegalStateException();
        }
        this.f3672d.f(this.f3670b);
        this.f3670b--;
        this.f3669a--;
        this.f3671c = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f3671c) {
            return this.f3672d.g(this.f3670b, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
