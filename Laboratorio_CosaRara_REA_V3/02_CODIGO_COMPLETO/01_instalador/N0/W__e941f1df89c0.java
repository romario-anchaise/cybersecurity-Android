// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import p018k0.p;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class W extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        if (aVar.J() == 9) {
            aVar.F();
            return null;
        }
        try {
            int iB = aVar.B();
            if (iB <= 255 && iB >= -128) {
                return Byte.valueOf((byte) iB);
            }
            throw new p("Lossy conversion from " + iB + " to byte; at path " + aVar.v(true));
        } catch (NumberFormatException e2) {
            throw new p(e2);
        }
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            bVar.w();
        } else {
            bVar.B(number.byteValue());
        }
    }
}
