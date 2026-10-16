// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Z;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f1132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final W.g f1134c;

    public d(Drawable drawable, boolean z2, W.g gVar) {
        this.f1132a = drawable;
        this.f1133b = z2;
        this.f1134c = gVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (F0.i.a(this.f1132a, dVar.f1132a) && this.f1133b == dVar.f1133b && this.f1134c == dVar.f1134c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f1134c.hashCode() + ((Boolean.hashCode(this.f1133b) + (this.f1132a.hashCode() * 31)) * 31);
    }
}
