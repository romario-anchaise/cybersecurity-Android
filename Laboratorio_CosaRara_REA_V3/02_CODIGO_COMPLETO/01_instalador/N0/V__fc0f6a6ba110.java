// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class V extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        if (aVar.J() != 9) {
            return Boolean.valueOf(aVar.H());
        }
        aVar.F();
        return null;
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        Boolean bool = (Boolean) obj;
        bVar.D(bool == null ? "null" : bool.toString());
    }
}
