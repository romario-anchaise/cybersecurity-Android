// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

import F0.i;
import N0.AbstractC0045q;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import g0.d;
import p014i0.e;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0045q f2604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC0045q f2605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC0045q f2606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC0045q f2607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f2608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f2609f;
    public final Bitmap.Config g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2610h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f2611i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Drawable f2612j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Drawable f2613k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Drawable f2614l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f2615m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f2616n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f2617o;

    public c(AbstractC0045q abstractC0045q, AbstractC0045q abstractC0045q2, AbstractC0045q abstractC0045q3, AbstractC0045q abstractC0045q4, e eVar, d dVar, Bitmap.Config config, boolean z2, boolean z3, Drawable drawable, Drawable drawable2, Drawable drawable3, b bVar, b bVar2, b bVar3) {
        this.f2604a = abstractC0045q;
        this.f2605b = abstractC0045q2;
        this.f2606c = abstractC0045q3;
        this.f2607d = abstractC0045q4;
        this.f2608e = eVar;
        this.f2609f = dVar;
        this.g = config;
        this.f2610h = z2;
        this.f2611i = z3;
        this.f2612j = drawable;
        this.f2613k = drawable2;
        this.f2614l = drawable3;
        this.f2615m = bVar;
        this.f2616n = bVar2;
        this.f2617o = bVar3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (i.a(this.f2604a, cVar.f2604a) && i.a(this.f2605b, cVar.f2605b) && i.a(this.f2606c, cVar.f2606c) && i.a(this.f2607d, cVar.f2607d) && i.a(this.f2608e, cVar.f2608e) && this.f2609f == cVar.f2609f && this.g == cVar.g && this.f2610h == cVar.f2610h && this.f2611i == cVar.f2611i && i.a(this.f2612j, cVar.f2612j) && i.a(this.f2613k, cVar.f2613k) && i.a(this.f2614l, cVar.f2614l) && this.f2615m == cVar.f2615m && this.f2616n == cVar.f2616n && this.f2617o == cVar.f2617o) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (Boolean.hashCode(this.f2611i) + ((Boolean.hashCode(this.f2610h) + ((this.g.hashCode() + ((this.f2609f.hashCode() + ((this.f2608e.hashCode() + ((this.f2607d.hashCode() + ((this.f2606c.hashCode() + ((this.f2605b.hashCode() + (this.f2604a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        Drawable drawable = this.f2612j;
        int iHashCode2 = (iHashCode + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Drawable drawable2 = this.f2613k;
        int iHashCode3 = (iHashCode2 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Drawable drawable3 = this.f2614l;
        return this.f2617o.hashCode() + ((this.f2616n.hashCode() + ((this.f2615m.hashCode() + ((iHashCode3 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31)) * 31)) * 31);
    }
}
