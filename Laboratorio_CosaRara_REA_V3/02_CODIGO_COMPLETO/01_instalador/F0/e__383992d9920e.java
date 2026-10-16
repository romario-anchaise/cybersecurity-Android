// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

import F0.i;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class e extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f2618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f2619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f2620c;

    public e(Drawable drawable, i iVar, Throwable th) {
        this.f2618a = drawable;
        this.f2619b = iVar;
        this.f2620c = th;
    }

    @Override // p010f0.j
    public final Drawable a() {
        return this.f2618a;
    }

    @Override // p010f0.j
    public final i b() {
        return this.f2619b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (i.a(this.f2618a, eVar.f2618a)) {
                if (i.a(this.f2619b, eVar.f2619b) && i.a(this.f2620c, eVar.f2620c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Drawable drawable = this.f2618a;
        return this.f2620c.hashCode() + ((this.f2619b.hashCode() + ((drawable != null ? drawable.hashCode() : 0) * 31)) * 31);
    }
}
