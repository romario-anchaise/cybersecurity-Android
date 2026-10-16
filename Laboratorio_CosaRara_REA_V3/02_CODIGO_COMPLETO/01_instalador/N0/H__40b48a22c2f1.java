// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.net.URL;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class H extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        if (aVar.J() == 9) {
            aVar.F();
            return null;
        }
        String strH = aVar.H();
        if (strH.equals("null")) {
            return null;
        }
        return new URL(strH);
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        URL url = (URL) obj;
        bVar.D(url == null ? null : url.toExternalForm());
    }
}
