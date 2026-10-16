// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import p018k0.p;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class I extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        if (aVar.J() == 9) {
            aVar.F();
            return null;
        }
        try {
            String strH = aVar.H();
            if (strH.equals("null")) {
                return null;
            }
            return new URI(strH);
        } catch (URISyntaxException e2) {
            throw new p(e2);
        }
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        URI uri = (URI) obj;
        bVar.D(uri == null ? null : uri.toASCIIString());
    }
}
