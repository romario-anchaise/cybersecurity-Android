// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import k1.C0196l;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0109b[] f2298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f2299b;

    static {
        C0109b c0109b = new C0109b(C0109b.f2280i, "");
        C0196l c0196l = C0109b.f2278f;
        C0109b c0109b2 = new C0109b(c0196l, "GET");
        C0109b c0109b3 = new C0109b(c0196l, "POST");
        C0196l c0196l2 = C0109b.g;
        C0109b c0109b4 = new C0109b(c0196l2, "/");
        C0109b c0109b5 = new C0109b(c0196l2, "/index.html");
        C0196l c0196l3 = C0109b.f2279h;
        C0109b c0109b6 = new C0109b(c0196l3, "http");
        C0109b c0109b7 = new C0109b(c0196l3, "https");
        C0196l c0196l4 = C0109b.f2277e;
        C0109b[] c0109bArr = {c0109b, c0109b2, c0109b3, c0109b4, c0109b5, c0109b6, c0109b7, new C0109b(c0196l4, "200"), new C0109b(c0196l4, "204"), new C0109b(c0196l4, "206"), new C0109b(c0196l4, "304"), new C0109b(c0196l4, "400"), new C0109b(c0196l4, "404"), new C0109b(c0196l4, "500"), new C0109b("accept-charset", ""), new C0109b("accept-encoding", "gzip, deflate"), new C0109b("accept-language", ""), new C0109b("accept-ranges", ""), new C0109b("accept", ""), new C0109b("access-control-allow-origin", ""), new C0109b("age", ""), new C0109b("allow", ""), new C0109b("authorization", ""), new C0109b("cache-control", ""), new C0109b("content-disposition", ""), new C0109b("content-encoding", ""), new C0109b("content-language", ""), new C0109b("content-length", ""), new C0109b("content-location", ""), new C0109b("content-range", ""), new C0109b("content-type", ""), new C0109b("cookie", ""), new C0109b("date", ""), new C0109b("etag", ""), new C0109b("expect", ""), new C0109b("expires", ""), new C0109b("from", ""), new C0109b("host", ""), new C0109b("if-match", ""), new C0109b("if-modified-since", ""), new C0109b("if-none-match", ""), new C0109b("if-range", ""), new C0109b("if-unmodified-since", ""), new C0109b("last-modified", ""), new C0109b("link", ""), new C0109b("location", ""), new C0109b("max-forwards", ""), new C0109b("proxy-authenticate", ""), new C0109b("proxy-authorization", ""), new C0109b("range", ""), new C0109b("referer", ""), new C0109b("refresh", ""), new C0109b("retry-after", ""), new C0109b("server", ""), new C0109b("set-cookie", ""), new C0109b("strict-transport-security", ""), new C0109b("transfer-encoding", ""), new C0109b("user-agent", ""), new C0109b("vary", ""), new C0109b("via", ""), new C0109b("www-authenticate", "")};
        f2298a = c0109bArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i2 = 0; i2 < 61; i2++) {
            if (!linkedHashMap.containsKey(c0109bArr[i2].f2281a)) {
                linkedHashMap.put(c0109bArr[i2].f2281a, Integer.valueOf(i2));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        F0.i.d(mapUnmodifiableMap, "unmodifiableMap(result)");
        f2299b = mapUnmodifiableMap;
    }

    public static void a(C0196l c0196l) throws IOException {
        F0.i.e(c0196l, "name");
        int iC = c0196l.c();
        for (int i2 = 0; i2 < iC; i2++) {
            byte bH = c0196l.h(i2);
            if (65 <= bH && bH < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(c0196l.p()));
            }
        }
    }
}
