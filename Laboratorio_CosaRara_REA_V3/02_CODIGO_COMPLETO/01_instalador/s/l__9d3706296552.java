// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s;

import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f4059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources.Theme f4060b;

    public l(Resources resources, Resources.Theme theme) {
        this.f4059a = resources;
        this.f4060b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f4059a.equals(lVar.f4059a) && p045z.b.a(this.f4060b, lVar.f4060b);
    }

    public final int hashCode() {
        return p045z.b.b(this.f4059a, this.f4060b);
    }
}
