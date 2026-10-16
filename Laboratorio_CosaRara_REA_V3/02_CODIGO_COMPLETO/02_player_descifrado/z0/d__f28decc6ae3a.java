// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z0;

import e2.n1;
import i2.a0;
import i2.p;
import i2.q;
import i2.s;
import i2.u;
import i2.w;
import i2.y;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import m2.i;
import w2.j;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends x0.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final s f6286g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u f6290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public y f6291f;

    static {
        s sVarF;
        Pattern pattern = s.f2209c;
        try {
            sVarF = i2.c.f("text/plain;charset=UTF-8");
        } catch (IllegalArgumentException unused) {
            sVarF = null;
        }
        f6286g = sVarF;
    }

    public static void e(d dVar) {
        Charset charsetA;
        a0 a0Var = dVar.f6291f.f2293i;
        try {
            j jVarY = a0Var.y();
            try {
                s sVarW = a0Var.w();
                if (sVarW == null || (charsetA = sVarW.a(v1.a.f3277a)) == null) {
                    charsetA = v1.a.f3277a;
                }
                String strV = jVarY.v(j2.b.s(jVarY, charsetA));
                jVarY.close();
                dVar.a("data", strV);
                dVar.a("success", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    y.f.c(jVarY, th);
                    throw th2;
                }
            }
        } catch (IOException e3) {
            dVar.a("error", e3);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [byte[], java.io.Serializable, java.lang.Object] */
    public final void f() {
        g.j jVar;
        String str = this.f6289d;
        String str2 = this.f6288c;
        String str3 = this.f6287b;
        boolean z2 = e.f6293q;
        if (z2) {
            e.f6292p.fine("xhr open " + str3 + ": " + str2);
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        if ("POST".equals(str3)) {
            treeMap.put("Content-type", new LinkedList(Collections.singletonList("text/plain;charset=UTF-8")));
        }
        treeMap.put("Accept", new LinkedList(Collections.singletonList("*/*")));
        a("requestHeaders", treeMap);
        if (z2) {
            e.f6292p.fine("sending xhr with url " + str2 + " | data " + str);
        }
        w wVar = new w(0);
        for (Map.Entry entry : treeMap.entrySet()) {
            for (String str4 : (List) entry.getValue()) {
                String str5 = (String) entry.getKey();
                str5.getClass();
                str4.getClass();
                n1 n1Var = (n1) wVar.f2271c;
                n1Var.getClass();
                str5.getClass();
                str4.getClass();
                i2.c.a(str5);
                i2.c.b(str4, str5);
                n1Var.d(str5, str4);
            }
        }
        q qVarA = null;
        if (str != null) {
            Charset charset = v1.a.f3277a;
            s sVarF = f6286g;
            if (sVarF != null) {
                Pattern pattern = s.f2209c;
                Charset charsetA = sVarF.a(null);
                if (charsetA == null) {
                    try {
                        sVarF = i2.c.f(sVarF + "; charset=utf-8");
                    } catch (IllegalArgumentException unused) {
                        sVarF = null;
                    }
                } else {
                    charset = charsetA;
                }
            }
            ?? bytes = str.getBytes(charset);
            bytes.getClass();
            int length = bytes.length;
            j2.b.c(bytes.length, 0, length);
            jVar = new g.j(sVarF, length, bytes, 1);
        } else {
            jVar = null;
        }
        str2.getClass();
        try {
            p pVar = new p();
            pVar.d(null, str2);
            qVarA = pVar.a();
        } catch (IllegalArgumentException unused2) {
        }
        qVarA.getClass();
        wVar.f2270b = qVarA;
        wVar.c(str3, jVar);
        b2.d dVarA = wVar.a();
        u uVar = this.f6290e;
        uVar.getClass();
        new i(uVar, dVarA, false).e(new n1(this));
    }
}
