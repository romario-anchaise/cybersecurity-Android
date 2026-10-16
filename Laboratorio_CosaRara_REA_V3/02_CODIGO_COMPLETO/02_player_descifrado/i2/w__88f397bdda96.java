// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import e2.n1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f2271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f2272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f2273e;

    public w(int i3) {
        switch (i3) {
            case 1:
                this.f2271c = new ArrayList();
                this.f2272d = new ArrayList();
                this.f2273e = new ArrayList();
                break;
            default:
                this.f2273e = new LinkedHashMap();
                this.f2269a = "GET";
                this.f2271c = new n1(9);
                break;
        }
    }

    public b2.d a() {
        Map mapUnmodifiableMap;
        q qVar = (q) this.f2270b;
        if (qVar == null) {
            o2.k("url == null");
            return null;
        }
        String str = this.f2269a;
        o oVarG = ((n1) this.f2271c).g();
        g.j jVar = (g.j) this.f2272d;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f2273e;
        byte[] bArr = j2.b.f2361a;
        linkedHashMap.getClass();
        if (linkedHashMap.isEmpty()) {
            mapUnmodifiableMap = i1.r.f2105c;
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
            mapUnmodifiableMap.getClass();
        }
        return new b2.d(qVar, str, oVarG, jVar, mapUnmodifiableMap);
    }

    public void b(String str, String str2) {
        str2.getClass();
        n1 n1Var = (n1) this.f2271c;
        n1Var.getClass();
        c.a(str);
        c.b(str2, str);
        n1Var.q(str);
        n1Var.d(str, str2);
    }

    public void c(String str, g.j jVar) {
        str.getClass();
        if (str.length() <= 0) {
            o2.i("method.isEmpty() == true");
            return;
        }
        if (jVar == null) {
            if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT")) {
                o2.h(a0.a.h("method ", str, " must have a request body."));
                return;
            }
        } else if (!m0.a.o(str)) {
            o2.h(a0.a.h("method ", str, " must not have a request body."));
            return;
        }
        this.f2269a = str;
        this.f2272d = jVar;
    }
}
