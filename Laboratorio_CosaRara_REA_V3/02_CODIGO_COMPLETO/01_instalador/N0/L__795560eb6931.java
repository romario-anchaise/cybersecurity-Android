// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.util.Currency;
import p018k0.p;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class L extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        String strH = aVar.H();
        try {
            return Currency.getInstance(strH);
        } catch (IllegalArgumentException e2) {
            throw new p("Failed parsing '" + strH + "' as Currency; at path " + aVar.v(true), e2);
        }
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        bVar.D(((Currency) obj).getCurrencyCode());
    }
}
