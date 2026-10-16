// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p001a0;

import A.C0005e;
import E0.p;
import N0.InterfaceC0047t;
import V.c;
import V.k;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import d0.a;
import java.util.LinkedHashMap;
import p010f0.i;
import p010f0.m;
import p010f0.q;
import p016j0.f;
import p029q.j;
import p040w0.d;
import p044y0.h;

/* JADX INFO: loaded from: classes.dex */
public final class g extends h implements p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h f1203f;
    public final /* synthetic */ i g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1204h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ m f1205i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ c f1206j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ a f1207k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ j f1208l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, i iVar, Object obj, m mVar, c cVar, a aVar, j jVar, d dVar) {
        super(dVar);
        this.f1203f = hVar;
        this.g = iVar;
        this.f1204h = obj;
        this.f1205i = mVar;
        this.f1206j = cVar;
        this.f1207k = aVar;
        this.f1208l = jVar;
    }

    @Override // p044y0.a
    public final d a(Object obj, d dVar) {
        return new g(this.f1203f, this.g, this.f1204h, this.f1205i, this.f1206j, this.f1207k, this.f1208l, dVar);
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) {
        return ((g) a((InterfaceC0047t) obj, (d) obj2)).f(p034t0.h.f4132b);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0066  */
    @Override // p044y0.a
    public final Object f(Object obj) throws Throwable {
        p034t0.h hVar;
        d0.c cVarC;
        Bitmap bitmap;
        boolean z2;
        p042x0.a aVar = p042x0.a.f4189a;
        int i2 = this.f1202e;
        if (i2 == 0) {
            j.o(obj);
            h hVar2 = this.f1203f;
            i iVar = this.g;
            Object obj2 = this.f1204h;
            m mVar = this.f1205i;
            c cVar = this.f1206j;
            this.f1202e = 1;
            obj = h.b(hVar2, iVar, obj2, mVar, cVar, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j.o(obj);
        }
        a aVar2 = (a) obj;
        p016j0.m mVar2 = this.f1203f.f1210b;
        synchronized (mVar2) {
            try {
                k kVar = (k) mVar2.f3392a.get();
                if (kVar != null) {
                    if (mVar2.f3393b == null) {
                        Context context = kVar.f679a;
                        mVar2.f3393b = context;
                        context.registerComponentCallbacks(mVar2);
                    }
                    hVar = p034t0.h.f4132b;
                } else {
                    hVar = null;
                }
                if (hVar == null) {
                    mVar2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C0005e c0005e = this.f1203f.f1212d;
        a aVar3 = this.f1207k;
        if (!this.g.f2651n.f2603b || (cVarC = ((k) c0005e.f34b).c()) == null || aVar3 == null) {
            z2 = false;
        } else {
            Drawable drawable = aVar2.f1158a;
            BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
            if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
                z2 = false;
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("coil#is_sampled", Boolean.valueOf(aVar2.f1159b));
                String str = aVar2.f1161d;
                if (str != null) {
                    linkedHashMap.put("coil#disk_cache_key", str);
                }
                cVarC.f2200a.s(new a(aVar3.f2196a, f1.d.E(aVar3.f2197b)), bitmap, f1.d.E(linkedHashMap));
                z2 = true;
            }
        }
        Drawable drawable2 = aVar2.f1158a;
        i iVar2 = this.g;
        W.g gVar = aVar2.f1160c;
        a aVar4 = z2 ? this.f1207k : null;
        String str2 = aVar2.f1161d;
        boolean z3 = aVar2.f1159b;
        j jVar = this.f1208l;
        Bitmap.Config config = f.f3375a;
        return new q(drawable2, iVar2, gVar, aVar4, str2, z3, jVar != null && jVar.g);
    }
}
