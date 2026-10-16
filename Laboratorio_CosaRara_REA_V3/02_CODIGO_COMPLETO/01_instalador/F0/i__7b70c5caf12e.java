// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

import N0.AbstractC0045q;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.lifecycle.AbstractC0078p;
import g0.d;
import g0.g;
import java.util.Arrays;
import p012h0.a;
import p014i0.e;
import p036u0.n;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final d f2637A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final c f2638B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f2641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap.Config f2642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f2643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f2644f;
    public final e g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final X0.n f2645h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final r f2646i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f2647j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f2648k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f2649l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f2650m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f2651n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f2652o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f2653p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AbstractC0045q f2654q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AbstractC0045q f2655r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AbstractC0045q f2656s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AbstractC0045q f2657t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AbstractC0078p f2658u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g0.i f2659v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final g f2660w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final o f2661x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Integer f2662y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Integer f2663z;

    public i(Context context, Object obj, a aVar, Bitmap.Config config, d dVar, n nVar, e eVar, X0.n nVar2, r rVar, boolean z2, boolean z3, boolean z4, boolean z5, b bVar, b bVar2, b bVar3, AbstractC0045q abstractC0045q, AbstractC0045q abstractC0045q2, AbstractC0045q abstractC0045q3, AbstractC0045q abstractC0045q4, AbstractC0078p abstractC0078p, g0.i iVar, g gVar, o oVar, Integer num, Integer num2, d dVar2, c cVar) {
        this.f2639a = context;
        this.f2640b = obj;
        this.f2641c = aVar;
        this.f2642d = config;
        this.f2643e = dVar;
        this.f2644f = nVar;
        this.g = eVar;
        this.f2645h = nVar2;
        this.f2646i = rVar;
        this.f2647j = z2;
        this.f2648k = z3;
        this.f2649l = z4;
        this.f2650m = z5;
        this.f2651n = bVar;
        this.f2652o = bVar2;
        this.f2653p = bVar3;
        this.f2654q = abstractC0045q;
        this.f2655r = abstractC0045q2;
        this.f2656s = abstractC0045q3;
        this.f2657t = abstractC0045q4;
        this.f2658u = abstractC0078p;
        this.f2659v = iVar;
        this.f2660w = gVar;
        this.f2661x = oVar;
        this.f2662y = num;
        this.f2663z = num2;
        this.f2637A = dVar2;
        this.f2638B = cVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (F0.i.a(this.f2639a, iVar.f2639a) && this.f2640b.equals(iVar.f2640b) && F0.i.a(this.f2641c, iVar.f2641c) && F0.i.a(null, null) && F0.i.a(null, null) && F0.i.a(null, null) && this.f2642d == iVar.f2642d && ((Build.VERSION.SDK_INT < 26 || F0.i.a(null, null)) && this.f2643e == iVar.f2643e && F0.i.a(null, null) && F0.i.a(null, null) && F0.i.a(this.f2644f, iVar.f2644f) && F0.i.a(this.g, iVar.g) && F0.i.a(this.f2645h, iVar.f2645h) && this.f2646i.equals(iVar.f2646i) && this.f2647j == iVar.f2647j && this.f2648k == iVar.f2648k && this.f2649l == iVar.f2649l && this.f2650m == iVar.f2650m && this.f2651n == iVar.f2651n && this.f2652o == iVar.f2652o && this.f2653p == iVar.f2653p && F0.i.a(this.f2654q, iVar.f2654q) && F0.i.a(this.f2655r, iVar.f2655r) && F0.i.a(this.f2656s, iVar.f2656s) && F0.i.a(this.f2657t, iVar.f2657t) && F0.i.a(null, null) && F0.i.a(this.f2662y, iVar.f2662y) && F0.i.a(null, null) && F0.i.a(this.f2663z, iVar.f2663z) && F0.i.a(null, null) && F0.i.a(null, null) && F0.i.a(null, null) && F0.i.a(this.f2658u, iVar.f2658u) && this.f2659v.equals(iVar.f2659v) && this.f2660w == iVar.f2660w && this.f2661x.equals(iVar.f2661x) && this.f2637A.equals(iVar.f2637A) && F0.i.a(this.f2638B, iVar.f2638B))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f2640b.hashCode() + (this.f2639a.hashCode() * 31)) * 31;
        a aVar = this.f2641c;
        int iHashCode2 = (this.f2643e.hashCode() + ((this.f2642d.hashCode() + ((iHashCode + (aVar != null ? aVar.f2841b.hashCode() : 0)) * 923521)) * 961)) * 29791;
        this.f2644f.getClass();
        int iHashCode3 = (this.f2661x.f2682a.hashCode() + ((this.f2660w.hashCode() + ((this.f2659v.hashCode() + ((this.f2658u.hashCode() + ((this.f2657t.hashCode() + ((this.f2656s.hashCode() + ((this.f2655r.hashCode() + ((this.f2654q.hashCode() + ((this.f2653p.hashCode() + ((this.f2652o.hashCode() + ((this.f2651n.hashCode() + ((Boolean.hashCode(this.f2650m) + ((Boolean.hashCode(this.f2649l) + ((Boolean.hashCode(this.f2648k) + ((Boolean.hashCode(this.f2647j) + ((this.f2646i.f2690a.hashCode() + ((((this.g.hashCode() + ((1 + iHashCode2) * 31)) * 31) + Arrays.hashCode(this.f2645h.f1012a)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 961;
        Integer num = this.f2662y;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 961;
        Integer num2 = this.f2663z;
        return this.f2638B.hashCode() + ((iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 28629151);
    }
}
