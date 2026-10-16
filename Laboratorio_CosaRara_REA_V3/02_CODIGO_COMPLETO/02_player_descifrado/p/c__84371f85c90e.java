// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f2830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2831b;

    public c(Uri uri, boolean z2) {
        this.f2830a = uri;
        this.f2831b = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!c.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        c cVar = (c) obj;
        return this.f2830a.equals(cVar.f2830a) && this.f2831b == cVar.f2831b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f2831b) + (this.f2830a.hashCode() * 31);
    }
}
