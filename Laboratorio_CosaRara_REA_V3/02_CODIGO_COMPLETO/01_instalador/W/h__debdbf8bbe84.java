// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W;

import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitmapDrawable f754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f755b;

    public h(BitmapDrawable bitmapDrawable, boolean z2) {
        this.f754a = bitmapDrawable;
        this.f755b = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f754a.equals(hVar.f754a) && this.f755b == hVar.f755b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f755b) + (this.f754a.hashCode() * 31);
    }
}
