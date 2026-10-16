// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z0;

import a2.i;
import i1.r;
import i2.p;
import i2.q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import v1.l;
import y.m;
import y0.o;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends o {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Logger f6295o = Logger.getLogger(e.class.getName());
    public v2.g n;

    @Override // y0.o
    public final void e() {
        v2.g gVar = this.n;
        if (gVar != null) {
            gVar.b("", 1000);
            this.n = null;
        }
    }

    @Override // y0.o
    public final void f() {
        Map mapUnmodifiableMap;
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        a("requestHeaders", treeMap);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList(20);
        HashMap map = this.f6110d;
        if (map == null) {
            map = new HashMap();
        }
        String str = this.f6111e ? "wss" : "ws";
        int i3 = this.f6113g;
        String strG = (i3 <= 0 || ((!"wss".equals(str) || i3 == 443) && (!"ws".equals(str) || i3 == 80))) ? "" : a0.a.g(":", i3);
        if (this.f6112f) {
            map.put(this.f6116j, g1.a.b());
        }
        String strJ = q2.c.j(map);
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
        String string = sb.toString();
        if (l.z(string, "ws:", true)) {
            string = "http:".concat(string.substring(3));
        } else if (l.z(string, "wss:", true)) {
            string = "https:".concat(string.substring(4));
        }
        p pVar = new p();
        pVar.d(null, string);
        q qVarA = pVar.a();
        for (Map.Entry entry : treeMap.entrySet()) {
            for (String str2 : (List) entry.getValue()) {
                String str3 = (String) entry.getKey();
                str3.getClass();
                str2.getClass();
                i2.c.a(str3);
                i2.c.b(str2, str3);
                arrayList.add(str3);
                arrayList.add(v1.d.J(str2).toString());
            }
        }
        i2.o oVar = new i2.o((String[]) arrayList.toArray(new String[0]));
        byte[] bArr = j2.b.f2361a;
        if (linkedHashMap.isEmpty()) {
            mapUnmodifiableMap = r.f2105c;
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
            mapUnmodifiableMap.getClass();
        }
        this.n = this.f6118l.a(new b2.d(qVarA, "GET", oVar, null, mapUnmodifiableMap), new f(this));
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [int[], java.io.Serializable] */
    @Override // y0.o
    public final void g(a1.b[] bVarArr) {
        this.f6108b = false;
        i iVar = new i(25, this);
        ?? r3 = {bVarArr.length};
        for (a1.b bVar : bVarArr) {
            int i3 = this.f6117k;
            if (i3 != 1 && i3 != 2) {
                return;
            }
            a1.f.b(bVar, new m(this, (Serializable) r3, iVar));
        }
    }
}
