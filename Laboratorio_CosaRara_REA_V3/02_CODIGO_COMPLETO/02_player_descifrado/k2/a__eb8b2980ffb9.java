// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k2;

import i2.x;
import i2.y;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final y a(y yVar) {
        if ((yVar != null ? yVar.f2293i : null) == null) {
            return yVar;
        }
        x xVarW = yVar.w();
        xVarW.f2280g = null;
        return xVarW.a();
    }

    public static boolean b(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
