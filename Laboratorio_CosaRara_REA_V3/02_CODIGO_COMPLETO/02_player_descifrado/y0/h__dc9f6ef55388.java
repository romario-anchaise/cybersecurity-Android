// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y0;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements x0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6059b;

    public /* synthetic */ h(int i3, Object obj) {
        this.f6058a = i3;
        this.f6059b = obj;
    }

    @Override // x0.a
    public final void a(Object... objArr) {
        switch (this.f6058a) {
            case 0:
                i iVar = (i) this.f6059b;
                String str = iVar.f6061b;
                o[] oVarArr = iVar.f6062c;
                l lVar = iVar.f6063d;
                if (!iVar.f6060a[0]) {
                    a1.b bVar = (a1.b) objArr[0];
                    if (!"pong".equals(bVar.f39a) || !"probe".equals(bVar.f40b)) {
                        Logger logger = l.A;
                        if (logger.isLoggable(Level.FINE)) {
                            logger.fine("probe transport '" + str + "' failed");
                        }
                        a aVar = new a("probe error");
                        aVar.f6035c = oVarArr[0].f6109c;
                        lVar.a("upgradeError", aVar);
                        break;
                    } else {
                        Logger logger2 = l.A;
                        Level level = Level.FINE;
                        if (logger2.isLoggable(level)) {
                            logger2.fine("probe transport '" + str + "' pong");
                        }
                        lVar.f6075e = true;
                        lVar.a("upgrading", oVarArr[0]);
                        o oVar = oVarArr[0];
                        if (oVar != null) {
                            "websocket".equals(oVar.f6109c);
                            if (logger2.isLoggable(level)) {
                                logger2.fine("pausing current transport '" + lVar.f6089t.f6109c + "'");
                            }
                            z0.b bVar2 = (z0.b) lVar.f6089t;
                            a2.i iVar2 = new a2.i(20, this);
                            bVar2.getClass();
                            f1.b.a(new g0.j(bVar2, iVar2, 19));
                            break;
                        }
                    }
                }
                break;
            case 1:
                z0.b.f6283o.fine("writing close packet");
                ((z0.b) this.f6059b).g(new a1.b[]{new a1.b(null, "close")});
                break;
            default:
                f1.b.a(new a2.i(22, this));
                break;
        }
    }
}
