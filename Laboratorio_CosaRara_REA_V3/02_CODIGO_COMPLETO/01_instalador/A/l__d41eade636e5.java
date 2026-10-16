// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.DisplayCutout;

/* JADX INFO: renamed from: A.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0012l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisplayCutout f46a;

    public C0012l(DisplayCutout displayCutout) {
        this.f46a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0012l.class != obj.getClass()) {
            return false;
        }
        return p045z.b.a(this.f46a, ((C0012l) obj).f46a);
    }

    public final int hashCode() {
        return this.f46a.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f46a + "}";
    }
}
