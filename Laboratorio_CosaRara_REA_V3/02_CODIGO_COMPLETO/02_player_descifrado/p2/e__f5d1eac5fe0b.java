// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b[] f2901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f2902b;

    static {
        b bVar = new b(b.f2881i, "");
        w2.k kVar = b.f2878f;
        b bVar2 = new b(kVar, "GET");
        b bVar3 = new b(kVar, "POST");
        w2.k kVar2 = b.f2879g;
        b bVar4 = new b(kVar2, "/");
        b bVar5 = new b(kVar2, "/index.html");
        w2.k kVar3 = b.f2880h;
        b bVar6 = new b(kVar3, "http");
        b bVar7 = new b(kVar3, "https");
        w2.k kVar4 = b.f2877e;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, new b(kVar4, "200"), new b(kVar4, "204"), new b(kVar4, "206"), new b(kVar4, "304"), new b(kVar4, "400"), new b(kVar4, "404"), new b(kVar4, "500"), new b("accept-charset", ""), new b("accept-encoding", "gzip, deflate"), new b("accept-language", ""), new b("accept-ranges", ""), new b("accept", ""), new b("access-control-allow-origin", ""), new b("age", ""), new b("allow", ""), new b("authorization", ""), new b("cache-control", ""), new b("content-disposition", ""), new b("content-encoding", ""), new b("content-language", ""), new b("content-length", ""), new b("content-location", ""), new b("content-range", ""), new b("content-type", ""), new b("cookie", ""), new b("date", ""), new b("etag", ""), new b("expect", ""), new b("expires", ""), new b("from", ""), new b("host", ""), new b("if-match", ""), new b("if-modified-since", ""), new b("if-none-match", ""), new b("if-range", ""), new b("if-unmodified-since", ""), new b("last-modified", ""), new b("link", ""), new b("location", ""), new b("max-forwards", ""), new b("proxy-authenticate", ""), new b("proxy-authorization", ""), new b("range", ""), new b("referer", ""), new b("refresh", ""), new b("retry-after", ""), new b("server", ""), new b("set-cookie", ""), new b("strict-transport-security", ""), new b("transfer-encoding", ""), new b("user-agent", ""), new b("vary", ""), new b("via", ""), new b("www-authenticate", "")};
        f2901a = bVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i3 = 0; i3 < 61; i3++) {
            if (!linkedHashMap.containsKey(bVarArr[i3].f2882a)) {
                linkedHashMap.put(bVarArr[i3].f2882a, Integer.valueOf(i3));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        mapUnmodifiableMap.getClass();
        f2902b = mapUnmodifiableMap;
    }

    public static void a(w2.k kVar) throws IOException {
        kVar.getClass();
        int iC = kVar.c();
        for (int i3 = 0; i3 < iC; i3++) {
            byte bF = kVar.f(i3);
            if (65 <= bF && bF < 91) {
                o2.l("PROTOCOL_ERROR response malformed: mixed case name: ".concat(kVar.k()));
                return;
            }
        }
    }
}
