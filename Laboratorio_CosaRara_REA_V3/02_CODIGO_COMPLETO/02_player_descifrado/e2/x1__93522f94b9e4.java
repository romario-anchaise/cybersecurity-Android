// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.bd;
import w1.cf;
import w1.j6;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class x1 {
    public static void a() {
        bd bdVar;
        g2.m0 m0Var;
        cf cfVarK = cf.K();
        synchronized (cfVarK.C) {
            cfVarK.I = true;
            bdVar = cfVarK.E;
            m0Var = cfVarK.F;
            cfVarK.E = null;
            cfVarK.F = null;
        }
        if (bdVar != null) {
            bdVar.a();
        }
        cf.o(m0Var);
        j6.d("hybrid:h264");
    }
}
