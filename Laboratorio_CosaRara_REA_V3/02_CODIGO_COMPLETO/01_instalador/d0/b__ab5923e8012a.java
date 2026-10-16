// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d0;

import F0.i;
import android.graphics.Bitmap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f2198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f2199b;

    public b(Bitmap bitmap, Map map) {
        this.f2198a = bitmap;
        this.f2199b = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (i.a(this.f2198a, bVar.f2198a) && i.a(this.f2199b, bVar.f2199b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2199b.hashCode() + (this.f2198a.hashCode() * 31);
    }

    public final String toString() {
        return "Value(bitmap=" + this.f2198a + ", extras=" + this.f2199b + ')';
    }
}
