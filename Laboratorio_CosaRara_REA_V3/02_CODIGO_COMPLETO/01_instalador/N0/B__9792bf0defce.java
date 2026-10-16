// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.math.BigDecimal;
import p018k0.p;
import p018k0.y;
import p022m0.d;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class B extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        if (aVar.J() == 9) {
            aVar.F();
            return null;
        }
        String strH = aVar.H();
        try {
            return d.i(strH);
        } catch (NumberFormatException e2) {
            throw new p("Failed parsing '" + strH + "' as BigDecimal; at path " + aVar.v(true), e2);
        }
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        bVar.C((BigDecimal) obj);
    }
}
