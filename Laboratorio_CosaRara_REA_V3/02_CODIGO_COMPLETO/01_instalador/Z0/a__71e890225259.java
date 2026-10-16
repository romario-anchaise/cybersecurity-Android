// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Z0;

import X0.C;
import X0.D;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final D a(D d2) {
        if ((d2 != null ? d2.g : null) == null) {
            return d2;
        }
        C cJ = d2.j();
        cJ.g = null;
        return cJ.a();
    }

    public static boolean b(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
