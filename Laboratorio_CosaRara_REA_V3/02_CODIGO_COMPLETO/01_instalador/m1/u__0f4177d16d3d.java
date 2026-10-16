// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import N0.C0033e;
import N0.C0041m;
import java.util.Map;
import lyr.stable.wrapper.wallpaper.BingWallpaperApi;

/* JADX INFO: renamed from: m1.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0216u implements InterfaceC0204h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0033e f3859b;

    public /* synthetic */ C0216u(C0033e c0033e, int i2) {
        this.f3858a = i2;
        this.f3859b = c0033e;
    }

    @Override // m1.InterfaceC0204h
    public final void b(InterfaceC0201e interfaceC0201e, O o2) {
        switch (this.f3858a) {
            case 0:
                F0.i.e(interfaceC0201e, "call");
                boolean zF = o2.f3818a.f();
                C0033e c0033e = this.f3859b;
                if (!zF) {
                    c0033e.b(p029q.j.b(new C0041m(o2)));
                } else {
                    Object obj = o2.f3819b;
                    if (obj != null) {
                        c0033e.b(obj);
                    } else {
                        X0.y yVarA = interfaceC0201e.a();
                        yVarA.getClass();
                        Object objCast = C0214s.class.cast(((Map) yVarA.f1102f).get(C0214s.class));
                        F0.i.b(objCast);
                        c0033e.b(p029q.j.b(new p034t0.a("Response from " + BingWallpaperApi.class.getName() + '.' + ((C0214s) objCast).f3854b.getName() + " was null but response body type was declared as non-null")));
                    }
                }
                break;
            case 1:
                F0.i.e(interfaceC0201e, "call");
                boolean zF2 = o2.f3818a.f();
                C0033e c0033e2 = this.f3859b;
                if (!zF2) {
                    c0033e2.b(p029q.j.b(new C0041m(o2)));
                } else {
                    c0033e2.b(o2.f3819b);
                }
                break;
            default:
                F0.i.e(interfaceC0201e, "call");
                this.f3859b.b(o2);
                break;
        }
    }

    @Override // m1.InterfaceC0204h
    public final void j(InterfaceC0201e interfaceC0201e, Throwable th) {
        switch (this.f3858a) {
            case 0:
                F0.i.e(interfaceC0201e, "call");
                this.f3859b.b(p029q.j.b(th));
                break;
            case 1:
                F0.i.e(interfaceC0201e, "call");
                this.f3859b.b(p029q.j.b(th));
                break;
            default:
                F0.i.e(interfaceC0201e, "call");
                this.f3859b.b(p029q.j.b(th));
                break;
        }
    }
}
