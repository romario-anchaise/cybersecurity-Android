// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z0;

import i2.u;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import y.i;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Logger f6292p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final boolean f6293q;

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        f6292p = logger;
        f6293q = logger.isLoggable(Level.FINE);
    }

    public final d i(i iVar) {
        if (iVar == null) {
            iVar = new i();
        }
        HashMap map = this.f6110d;
        if (map == null) {
            map = new HashMap();
        }
        String str = this.f6111e ? "https" : "http";
        if (this.f6112f) {
            map.put(this.f6116j, g1.a.b());
        }
        String strJ = q2.c.j(map);
        int i3 = this.f6113g;
        String strG = (i3 <= 0 || ((!"https".equals(str) || i3 == 443) && (!"http".equals(str) || i3 == 80))) ? "" : a0.a.g(":", i3);
        if (strJ.length() > 0) {
            strJ = "?".concat(strJ);
        }
        String strH = this.f6115i;
        boolean zContains = strH.contains(":");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("://");
        if (zContains) {
            strH = a0.a.h("[", strH, "]");
        }
        sb.append(strH);
        sb.append(strG);
        sb.append(this.f6114h);
        sb.append(strJ);
        iVar.f5983a = sb.toString();
        iVar.f5986d = this.f6119m;
        d dVar = new d();
        String str2 = (String) iVar.f5984b;
        if (str2 == null) {
            str2 = "GET";
        }
        dVar.f6287b = str2;
        dVar.f6288c = (String) iVar.f5983a;
        dVar.f6289d = (String) iVar.f5985c;
        dVar.f6290e = (u) iVar.f5986d;
        dVar.c("requestHeaders", new c(this, 1));
        dVar.c("responseHeaders", new c(this, 0));
        return dVar;
    }
}
