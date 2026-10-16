// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class U extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        int iJ = aVar.J();
        if (iJ != 9) {
            return iJ == 6 ? Boolean.valueOf(Boolean.parseBoolean(aVar.H())) : Boolean.valueOf(aVar.z());
        }
        aVar.F();
        return null;
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            bVar.w();
            return;
        }
        bVar.F();
        bVar.a();
        bVar.f4091a.write(bool.booleanValue() ? "true" : "false");
    }
}
