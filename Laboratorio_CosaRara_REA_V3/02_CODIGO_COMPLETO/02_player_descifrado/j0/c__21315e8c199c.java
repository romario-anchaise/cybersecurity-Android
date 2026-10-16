// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j0;

import android.content.Context;
import e0.i;
import e2.n1;
import g0.p;
import g0.s;
import g0.t;
import h0.j;
import h0.o;
import p0.e;
import y.l;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final l f2309i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f2312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f2313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g0.a f2314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f2316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g0.c f2317h;

    static {
        b bVar = new b();
        l lVar = new l();
        lVar.f5992d = "ClientTelemetry.API";
        lVar.f5991c = bVar;
        f2309i = lVar;
    }

    public c(Context context, j jVar) {
        f0.b bVar = f0.b.f1106b;
        o.d(context, "Null context is not permitted.");
        l lVar = f2309i;
        o.d(lVar, "Api must not be null.");
        o.d(bVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        o.d(applicationContext, "The provided context did not have an application context.");
        this.f2310a = applicationContext;
        String attributionTag = context.getAttributionTag();
        this.f2311b = attributionTag;
        this.f2312c = lVar;
        this.f2313d = jVar;
        this.f2314e = new g0.a(lVar, jVar, attributionTag);
        g0.c cVarD = g0.c.d(applicationContext);
        this.f2317h = cVarD;
        this.f2315f = cVarD.f1445h.getAndIncrement();
        this.f2316g = bVar.f1107a;
        e eVar = cVarD.f1450m;
        eVar.sendMessage(eVar.obtainMessage(7, this));
    }

    public final u0.e a(h0.i iVar) {
        n1 n1Var = new n1();
        e0.d[] dVarArr = {p0.c.f2871a};
        n1Var.f905c = new n1(iVar);
        s sVar = new s();
        sVar.f1487c = n1Var;
        sVar.f1486b = dVarArr;
        sVar.f1485a = false;
        u0.b bVar = new u0.b();
        g0.c cVar = this.f2317h;
        cVar.getClass();
        p pVar = new p(new t(sVar, bVar, this.f2316g), cVar.f1446i.get(), this);
        e eVar = cVar.f1450m;
        eVar.sendMessage(eVar.obtainMessage(4, pVar));
        return bVar.f3250a;
    }
}
