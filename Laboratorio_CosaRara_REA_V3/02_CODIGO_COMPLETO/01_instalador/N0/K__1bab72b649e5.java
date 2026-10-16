// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.util.UUID;
import p018k0.p;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class K extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        if (aVar.J() == 9) {
            aVar.F();
            return null;
        }
        String strH = aVar.H();
        try {
            return UUID.fromString(strH);
        } catch (IllegalArgumentException e2) {
            throw new p("Failed parsing '" + strH + "' as UUID; at path " + aVar.v(true), e2);
        }
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        UUID uuid = (UUID) obj;
        bVar.D(uuid == null ? null : uuid.toString());
    }
}
