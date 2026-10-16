// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

import e2.n1;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements x0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3383c;

    public e(y0.o[] oVarArr, y0.f fVar) {
        this.f3381a = 2;
        this.f3382b = oVarArr;
        this.f3383c = fVar;
    }

    @Override // x0.a
    public final void a(Object... objArr) {
        switch (this.f3381a) {
            case 0:
                k kVar = (k) this.f3382b;
                k.f3393r.fine("open");
                kVar.e();
                kVar.f3408q = 3;
                kVar.a("open", new Object[0]);
                j jVar = kVar.f3405m;
                LinkedList linkedList = kVar.f3403k;
                d dVar = new d(kVar, 1);
                jVar.c("data", dVar);
                linkedList.add(new l(jVar, "data", dVar));
                d dVar2 = new d(kVar, 2);
                jVar.c("error", dVar2);
                linkedList.add(new l(jVar, "error", dVar2));
                d dVar3 = new d(kVar, 3);
                jVar.c("close", dVar3);
                linkedList.add(new l(jVar, "close", dVar3));
                kVar.f3406o.f5977d = new i(kVar);
                n1 n1Var = (n1) ((g0.j) this.f3383c).f1470d;
                if (n1Var != null) {
                    n1Var.h(null);
                }
                break;
            case 1:
                n1 n1Var2 = (n1) ((g0.j) this.f3383c).f1470d;
                k kVar2 = (k) this.f3382b;
                Object obj = objArr.length > 0 ? objArr[0] : null;
                k.f3393r.fine("connect_error");
                kVar2.e();
                kVar2.f3408q = 1;
                kVar2.a("error", obj);
                if (n1Var2 != null) {
                    n1Var2.h(new t("Connection error", obj instanceof Exception ? (Exception) obj : null));
                    break;
                } else if (!kVar2.f3396d && kVar2.f3394b && kVar2.f3399g.f3276d == 0) {
                    kVar2.g();
                    break;
                }
                break;
            default:
                y0.o oVar = (y0.o) objArr[0];
                y0.o[] oVarArr = (y0.o[]) this.f3382b;
                y0.o oVar2 = oVarArr[0];
                if (oVar2 != null && !oVar.f6109c.equals(oVar2.f6109c)) {
                    Logger logger = y0.l.A;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine("'" + oVar.f6109c + "' works - aborting '" + oVarArr[0].f6109c + "'");
                    }
                    ((y0.f) this.f3383c).a(new Object[0]);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ e(g0.j jVar, k kVar, int i3) {
        this.f3381a = i3;
        this.f3383c = jVar;
        this.f3382b = kVar;
    }
}
