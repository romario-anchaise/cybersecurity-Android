// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p019l;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f3525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f3526d;

    public c(Object obj, Object obj2) {
        this.f3523a = obj;
        this.f3524b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3523a.equals(cVar.f3523a) && this.f3524b.equals(cVar.f3524b);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f3523a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f3524b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f3523a.hashCode() ^ this.f3524b.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f3523a + "=" + this.f3524b;
    }
}
