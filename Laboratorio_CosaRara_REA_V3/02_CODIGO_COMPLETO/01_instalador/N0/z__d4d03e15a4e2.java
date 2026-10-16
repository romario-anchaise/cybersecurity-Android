// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import p018k0.p;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: renamed from: n0.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0243z extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        if (aVar.J() == 9) {
            aVar.F();
            return null;
        }
        String strH = aVar.H();
        if (strH.length() == 1) {
            return Character.valueOf(strH.charAt(0));
        }
        throw new p("Expecting character, got: " + strH + "; at " + aVar.v(true));
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        Character ch = (Character) obj;
        bVar.D(ch == null ? null : String.valueOf(ch));
    }
}
