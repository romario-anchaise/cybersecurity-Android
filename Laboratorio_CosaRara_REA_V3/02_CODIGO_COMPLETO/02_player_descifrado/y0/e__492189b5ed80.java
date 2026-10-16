// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y0;

import java.util.ArrayList;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l f6051d;

    public /* synthetic */ e(l lVar, int i3) {
        this.f6050c = i3;
        this.f6051d = lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f6050c;
        int i4 = 1;
        int i5 = 0;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        l lVar = this.f6051d;
        switch (i3) {
            case 0:
                lVar.getClass();
                lVar.l(new a1.b(null, "pong"));
                break;
            case 1:
                f1.b.a(new a2.i(19, this));
                break;
            case 2:
                Logger logger = l.A;
                lVar.h("forced close", null);
                l.A.fine("socket closing - telling transport to close");
                o oVar = lVar.f6089t;
                oVar.getClass();
                f1.b.a(new m(oVar, i4));
                break;
            case 3:
                int i6 = lVar.f6095z;
                int i7 = 2;
                if (i6 == 1 || i6 == 2) {
                    lVar.f6095z = 3;
                    e eVar = new e(lVar, i7);
                    x0.a[] aVarArr = new x0.a[1];
                    aVarArr[0] = new f(lVar, aVarArr, eVar, objArr2 == true ? 1 : 0);
                    g0.j jVar = new g0.j(lVar, aVarArr, 14, objArr == true ? 1 : 0);
                    if (lVar.f6088s.size() > 0) {
                        lVar.d("drain", new f(this, jVar, eVar));
                    } else if (!lVar.f6075e) {
                        eVar.run();
                    } else {
                        jVar.run();
                    }
                }
                break;
            case 4:
                lVar.a("error", new a("No transports available"));
                break;
            default:
                lVar.getClass();
                ArrayList arrayList = lVar.f6084o;
                if (arrayList.size() != 0) {
                    String str = (String) arrayList.get(0);
                    lVar.f6095z = 1;
                    o oVarF = lVar.f(str);
                    l.e(lVar, oVarF);
                    f1.b.a(new m(oVarF, i5));
                } else {
                    f1.b.b(new e(lVar, 4));
                }
                break;
        }
    }
}
