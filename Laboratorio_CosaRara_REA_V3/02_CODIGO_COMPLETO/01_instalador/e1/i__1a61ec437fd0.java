// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class i extends a1.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f2306f;
    public final /* synthetic */ Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(String str, Object obj, Object obj2, int i2) {
        super(str, true);
        this.f2305e = i2;
        this.f2306f = obj;
        this.g = obj2;
    }

    @Override // a1.a
    public final long a() {
        long jA;
        w[] wVarArr;
        int i2 = 0;
        switch (this.f2305e) {
            case 0:
                o oVar = (o) this.f2306f;
                oVar.f2320a.a(oVar, (B) ((F0.n) this.g).f180a);
                return -1L;
            case 1:
                try {
                    ((o) this.f2306f).f2320a.b((w) this.g);
                    return -1L;
                } catch (IOException e2) {
                    f1.n nVar = f1.n.f2736a;
                    f1.n nVar2 = f1.n.f2736a;
                    String str = "Http2Connection.Listener failure for " + ((o) this.f2306f).f2322c;
                    nVar2.getClass();
                    f1.n.i(str, 4, e2);
                    try {
                        ((w) this.g).c(2, e2);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            default:
                k kVar = (k) this.f2306f;
                B b2 = (B) this.g;
                kVar.getClass();
                F0.n nVar3 = new F0.n();
                o oVar2 = kVar.f2311b;
                synchronized (oVar2.f2341w) {
                    synchronized (oVar2) {
                        try {
                            B b3 = oVar2.f2335q;
                            B b4 = new B();
                            b4.b(b3);
                            b4.b(b2);
                            nVar3.f180a = b4;
                            jA = ((long) b4.a()) - ((long) b3.a());
                            wVarArr = (jA == 0 || oVar2.f2321b.isEmpty()) ? null : (w[]) oVar2.f2321b.values().toArray(new w[0]);
                            B b5 = (B) nVar3.f180a;
                            F0.i.e(b5, "<set-?>");
                            oVar2.f2335q = b5;
                            oVar2.f2328j.c(new i(oVar2.f2322c + " onSettings", oVar2, nVar3, i2), 0L);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    try {
                        oVar2.f2341w.a((B) nVar3.f180a);
                    } catch (IOException e3) {
                        oVar2.a(2, 2, e3);
                    }
                    break;
                }
                if (wVarArr == null) {
                    return -1L;
                }
                int length = wVarArr.length;
                while (i2 < length) {
                    w wVar = wVarArr[i2];
                    synchronized (wVar) {
                        wVar.f2377f += jA;
                        if (jA > 0) {
                            wVar.notifyAll();
                        }
                        break;
                    }
                    i2++;
                }
                return -1L;
        }
    }
}
