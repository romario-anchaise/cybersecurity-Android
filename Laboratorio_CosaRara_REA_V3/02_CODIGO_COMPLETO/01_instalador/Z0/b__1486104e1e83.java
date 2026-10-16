// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Z0;

import F0.i;
import H.s;
import M0.e;
import M0.m;
import X0.C;
import X0.D;
import X0.G;
import X0.n;
import X0.r;
import X0.x;
import X0.y;
import b1.j;
import c1.f;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class b implements r {
    @Override // X0.r
    public final D a(f fVar) {
        String str;
        String str2;
        System.currentTimeMillis();
        y yVar = fVar.f2188e;
        i.e(yVar, "request");
        s sVar = new s(yVar, 4, (Object) null);
        if (yVar.b().f957j) {
            sVar = new s((Object) null, 4, (Object) null);
        }
        j jVar = fVar.f2184a;
        y yVar2 = (y) sVar.f232b;
        D d2 = (D) sVar.f233c;
        if (yVar2 == null && d2 == null) {
            D d3 = new D(yVar, x.f1091c, "Unsatisfiable Request (only-if-cached)", 504, null, new n((String[]) new ArrayList(20).toArray(new String[0])), Y0.b.f1121c, null, null, null, -1L, System.currentTimeMillis(), null);
            i.e(jVar, "call");
            return d3;
        }
        if (yVar2 == null) {
            i.b(d2);
            C cJ = d2.j();
            D dA = a.a(d2);
            C.b(dA, "cacheResponse");
            cJ.f899i = dA;
            D dA2 = cJ.a();
            i.e(jVar, "call");
            return dA2;
        }
        if (d2 != null) {
            i.e(jVar, "call");
        }
        D dB = fVar.b(yVar2);
        String str3 = "networkResponse";
        if (d2 == null) {
            str = "networkResponse";
        } else {
            if (dB.f907d == 304) {
                C cJ2 = d2.j();
                n nVar = dB.f909f;
                ArrayList arrayList = new ArrayList(20);
                n nVar2 = d2.f909f;
                int size = nVar2.size();
                int i2 = 0;
                while (i2 < size) {
                    String strB = nVar2.b(i2);
                    int i3 = size;
                    String strD = nVar2.d(i2);
                    n nVar3 = nVar2;
                    if ("Warning".equalsIgnoreCase(strB)) {
                        str2 = str3;
                        if (m.R(strD, "1", false)) {
                        }
                        i2++;
                        size = i3;
                        nVar2 = nVar3;
                        str3 = str2;
                    } else {
                        str2 = str3;
                    }
                    if ("Content-Length".equalsIgnoreCase(strB) || "Content-Encoding".equalsIgnoreCase(strB) || "Content-Type".equalsIgnoreCase(strB) || !a.b(strB) || nVar.a(strB) == null) {
                        i.e(strB, "name");
                        i.e(strD, "value");
                        arrayList.add(strB);
                        arrayList.add(e.j0(strD).toString());
                    }
                    i2++;
                    size = i3;
                    nVar2 = nVar3;
                    str3 = str2;
                }
                String str4 = str3;
                int size2 = nVar.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    String strB2 = nVar.b(i4);
                    if (!"Content-Length".equalsIgnoreCase(strB2) && !"Content-Encoding".equalsIgnoreCase(strB2) && !"Content-Type".equalsIgnoreCase(strB2) && a.b(strB2)) {
                        String strD2 = nVar.d(i4);
                        i.e(strB2, "name");
                        i.e(strD2, "value");
                        arrayList.add(strB2);
                        arrayList.add(e.j0(strD2).toString());
                    }
                }
                cJ2.f897f = new n((String[]) arrayList.toArray(new String[0])).c();
                cJ2.f901k = dB.f913k;
                cJ2.f902l = dB.f914l;
                D dA3 = a.a(d2);
                C.b(dA3, "cacheResponse");
                cJ2.f899i = dA3;
                D dA4 = a.a(dB);
                C.b(dA4, str4);
                cJ2.f898h = dA4;
                cJ2.a();
                G g = dB.g;
                i.b(g);
                g.close();
                i.b(null);
                throw null;
            }
            str = "networkResponse";
            G g2 = d2.g;
            if (g2 != null) {
                Y0.b.d(g2);
            }
        }
        C cJ3 = dB.j();
        D dA5 = a.a(d2);
        C.b(dA5, "cacheResponse");
        cJ3.f899i = dA5;
        D dA6 = a.a(dB);
        C.b(dA6, str);
        cJ3.f898h = dA6;
        return cJ3.a();
    }
}
