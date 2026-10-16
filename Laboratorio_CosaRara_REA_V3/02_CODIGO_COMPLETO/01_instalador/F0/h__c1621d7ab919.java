// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

import A.C0005e;
import N0.AbstractC0045q;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.lifecycle.AbstractC0078p;
import androidx.lifecycle.InterfaceC0082u;
import g0.c;
import g0.g;
import g0.i;
import java.util.LinkedHashMap;
import p012h0.a;
import p014i0.e;
import p016j0.d;
import p016j0.f;
import p036u0.n;
import p036u0.q;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f2624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f2625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f2626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f2627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0005e f2628f;
    public final LinkedHashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2629h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f2630i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final n f2631j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f2632k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f2633l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AbstractC0078p f2634m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public i f2635n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public g f2636o;

    public h(Context context) {
        this.f2623a = context;
        this.f2624b = d.f3373a;
        this.f2625c = null;
        this.f2626d = null;
        this.f2627e = n.f4146a;
        this.f2628f = null;
        this.g = null;
        this.f2629h = true;
        this.f2630i = true;
        this.f2631j = null;
        this.f2632k = null;
        this.f2633l = null;
        this.f2634m = null;
        this.f2635n = null;
        this.f2636o = null;
    }

    public final i a() {
        AbstractC0045q abstractC0045q;
        g gVar;
        ImageView.ScaleType scaleType;
        Object obj = this.f2625c;
        if (obj == null) {
            obj = k.f2664b;
        }
        Object obj2 = obj;
        a aVar = this.f2626d;
        c cVar = this.f2624b;
        Bitmap.Config config = cVar.g;
        g0.d dVar = cVar.f2609f;
        e eVar = cVar.f2608e;
        C0005e c0005e = this.f2628f;
        X0.n nVarB = c0005e != null ? c0005e.B() : null;
        if (nVarB == null) {
            nVarB = f.f3376b;
        } else {
            Bitmap.Config config2 = f.f3375a;
        }
        X0.n nVar = nVarB;
        LinkedHashMap linkedHashMap = this.g;
        r rVar = linkedHashMap != null ? new r(f1.d.E(linkedHashMap)) : null;
        r rVar2 = rVar == null ? r.f2689b : rVar;
        c cVar2 = this.f2624b;
        boolean z2 = cVar2.f2610h;
        boolean z3 = cVar2.f2611i;
        b bVar = cVar2.f2615m;
        b bVar2 = cVar2.f2616n;
        b bVar3 = cVar2.f2617o;
        AbstractC0045q abstractC0045q2 = cVar2.f2604a;
        AbstractC0045q abstractC0045q3 = cVar2.f2605b;
        AbstractC0045q abstractC0045q4 = cVar2.f2606c;
        AbstractC0045q abstractC0045q5 = cVar2.f2607d;
        AbstractC0078p lifecycle = this.f2634m;
        Context context = this.f2623a;
        if (lifecycle == null) {
            a aVar2 = this.f2626d;
            Object context2 = aVar2 != null ? aVar2.f2841b.getContext() : context;
            abstractC0045q = abstractC0045q2;
            while (true) {
                if (context2 instanceof InterfaceC0082u) {
                    lifecycle = ((InterfaceC0082u) context2).getLifecycle();
                    break;
                }
                if (!(context2 instanceof ContextWrapper)) {
                    lifecycle = null;
                    break;
                }
                context2 = ((ContextWrapper) context2).getBaseContext();
            }
            if (lifecycle == null) {
                lifecycle = g.f2621a;
            }
        } else {
            abstractC0045q = abstractC0045q2;
        }
        AbstractC0078p abstractC0078p = lifecycle;
        i cVar3 = this.f2635n;
        if (cVar3 == null) {
            a aVar3 = this.f2626d;
            if (aVar3 != null) {
                ImageView imageView = aVar3.f2841b;
                if (imageView == null || !((scaleType = imageView.getScaleType()) == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX)) {
                    cVar3 = new g0.f(imageView, true);
                } else {
                    g0.h hVar = g0.h.f2748c;
                    cVar3 = new g0.e();
                }
            } else {
                cVar3 = new c(context);
            }
        }
        i iVar = cVar3;
        g gVar2 = this.f2636o;
        if (gVar2 == null) {
            a aVar4 = this.f2626d;
            if (aVar4 == null) {
                aVar4 = null;
            }
            ImageView imageView2 = aVar4 != null ? aVar4.f2841b : null;
            g gVar3 = g.f2746b;
            if (imageView2 != null) {
                Bitmap.Config config3 = f.f3375a;
                ImageView.ScaleType scaleType2 = imageView2.getScaleType();
                int i2 = scaleType2 == null ? -1 : p016j0.e.f3374a[scaleType2.ordinal()];
                if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
                    gVar3 = g.f2745a;
                }
            }
            gVar = gVar3;
        } else {
            gVar = gVar2;
        }
        n nVar2 = this.f2631j;
        o oVar = nVar2 != null ? new o(f1.d.E(nVar2.f2680a)) : null;
        if (oVar == null) {
            oVar = o.f2681b;
        }
        return new i(this.f2623a, obj2, aVar, config, dVar, this.f2627e, eVar, nVar, rVar2, this.f2629h, z2, z3, this.f2630i, bVar, bVar2, bVar3, abstractC0045q, abstractC0045q3, abstractC0045q4, abstractC0045q5, abstractC0078p, iVar, gVar, oVar, this.f2632k, this.f2633l, new d(), this.f2624b);
    }

    public h(i iVar, Context context) {
        this.f2623a = context;
        this.f2624b = iVar.f2638B;
        this.f2625c = iVar.f2640b;
        this.f2626d = iVar.f2641c;
        this.f2627e = iVar.f2644f;
        this.f2628f = iVar.f2645h.c();
        this.g = q.s(iVar.f2646i.f2690a);
        this.f2629h = iVar.f2647j;
        this.f2630i = iVar.f2650m;
        this.f2631j = new n(iVar.f2661x);
        this.f2632k = iVar.f2662y;
        this.f2633l = iVar.f2663z;
        if (iVar.f2639a == context) {
            this.f2634m = iVar.f2658u;
            this.f2635n = iVar.f2659v;
            this.f2636o = iVar.f2660w;
        } else {
            this.f2634m = null;
            this.f2635n = null;
            this.f2636o = null;
        }
    }
}
