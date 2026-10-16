// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

import F0.i;
import W.g;
import android.graphics.drawable.Drawable;
import d0.a;

/* JADX INFO: loaded from: classes.dex */
public final class q extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f2683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f2684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f2685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f2686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2688f;
    public final boolean g;

    public q(Drawable drawable, i iVar, g gVar, a aVar, String str, boolean z2, boolean z3) {
        this.f2683a = drawable;
        this.f2684b = iVar;
        this.f2685c = gVar;
        this.f2686d = aVar;
        this.f2687e = str;
        this.f2688f = z2;
        this.g = z3;
    }

    @Override // p010f0.j
    public final Drawable a() {
        return this.f2683a;
    }

    @Override // p010f0.j
    public final i b() {
        return this.f2684b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (i.a(this.f2683a, qVar.f2683a)) {
                if (i.a(this.f2684b, qVar.f2684b) && this.f2685c == qVar.f2685c && i.a(this.f2686d, qVar.f2686d) && i.a(this.f2687e, qVar.f2687e) && this.f2688f == qVar.f2688f && this.g == qVar.g) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f2685c.hashCode() + ((this.f2684b.hashCode() + (this.f2683a.hashCode() * 31)) * 31)) * 31;
        a aVar = this.f2686d;
        int iHashCode2 = (iHashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str = this.f2687e;
        return Boolean.hashCode(this.g) + ((Boolean.hashCode(this.f2688f) + ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31)) * 31);
    }
}
