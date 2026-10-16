// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f3721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f3722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f3723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f3724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f3725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f3726f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f3727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3728i;

    public m(boolean z2) {
        this.f3726f = null;
        this.g = z2;
        this.f3725e = this;
        this.f3724d = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f3726f;
        if (obj2 == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!obj2.equals(entry.getKey())) {
            return false;
        }
        Object obj3 = this.f3727h;
        if (obj3 == null) {
            if (entry.getValue() != null) {
                return false;
            }
        } else if (!obj3.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f3726f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f3727h;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f3726f;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f3727h;
        return (obj2 != null ? obj2.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.g) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.f3727h;
        this.f3727h = obj;
        return obj2;
    }

    public final String toString() {
        return this.f3726f + "=" + this.f3727h;
    }

    public m(boolean z2, m mVar, Object obj, m mVar2, m mVar3) {
        this.f3721a = mVar;
        this.f3726f = obj;
        this.g = z2;
        this.f3728i = 1;
        this.f3724d = mVar2;
        this.f3725e = mVar3;
        mVar3.f3724d = this;
        mVar2.f3725e = this;
    }
}
