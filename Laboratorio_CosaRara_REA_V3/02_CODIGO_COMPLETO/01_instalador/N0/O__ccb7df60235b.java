// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import F0.h;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;
import p018k0.n;
import p018k0.o;
import p018k0.q;
import p018k0.r;
import p018k0.s;
import p018k0.y;
import p022m0.j;
import p022m0.k;
import p022m0.l;
import p022m0.m;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class O extends y {
    public static o c(a aVar, int i2) throws IOException {
        int iB = androidx.fragment.app.y.b(i2);
        if (iB == 5) {
            return new s(aVar.H());
        }
        if (iB == 6) {
            return new s(new j(aVar.H()));
        }
        if (iB == 7) {
            return new s(Boolean.valueOf(aVar.z()));
        }
        if (iB != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(h.i(i2)));
        }
        aVar.F();
        return q.f3426a;
    }

    public static void d(b bVar, o oVar) {
        if (oVar == null || (oVar instanceof q)) {
            bVar.w();
            return;
        }
        boolean z2 = oVar instanceof s;
        if (z2) {
            if (!z2) {
                throw new IllegalStateException("Not a JSON Primitive: " + oVar);
            }
            s sVar = (s) oVar;
            Serializable serializable = sVar.f3428a;
            if (serializable instanceof Number) {
                bVar.C(sVar.b());
                return;
            } else if (serializable instanceof Boolean) {
                bVar.E(serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(sVar.c()));
                return;
            } else {
                bVar.D(sVar.c());
                return;
            }
        }
        boolean z3 = oVar instanceof n;
        if (z3) {
            bVar.f();
            if (!z3) {
                throw new IllegalStateException("Not a JSON Array: " + oVar);
            }
            Iterator it = ((n) oVar).f3425a.iterator();
            while (it.hasNext()) {
                d(bVar, (o) it.next());
            }
            bVar.r();
            return;
        }
        boolean z4 = oVar instanceof r;
        if (!z4) {
            throw new IllegalArgumentException("Couldn't write " + oVar.getClass());
        }
        bVar.j();
        if (!z4) {
            throw new IllegalStateException("Not a JSON Object: " + oVar);
        }
        Iterator it2 = ((l) ((r) oVar).f3427a.entrySet()).iterator();
        while (((k) it2).hasNext()) {
            m mVarB = ((k) it2).b();
            bVar.u((String) mVarB.getKey());
            d(bVar, (o) mVarB.getValue());
        }
        bVar.t();
    }

    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        o nVar;
        o nVar2;
        int iJ = aVar.J();
        int iB = androidx.fragment.app.y.b(iJ);
        if (iB == 0) {
            aVar.a();
            nVar = new n();
        } else if (iB != 2) {
            nVar = null;
        } else {
            aVar.f();
            nVar = new r();
        }
        if (nVar == null) {
            return c(aVar, iJ);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.w()) {
                String strD = nVar instanceof r ? aVar.D() : null;
                int iJ2 = aVar.J();
                int iB2 = androidx.fragment.app.y.b(iJ2);
                if (iB2 == 0) {
                    aVar.a();
                    nVar2 = new n();
                } else if (iB2 != 2) {
                    nVar2 = null;
                } else {
                    aVar.f();
                    nVar2 = new r();
                }
                boolean z2 = nVar2 != null;
                if (nVar2 == null) {
                    nVar2 = c(aVar, iJ2);
                }
                if (nVar instanceof n) {
                    ((n) nVar).f3425a.add(nVar2);
                } else {
                    ((r) nVar).f3427a.put(strD, nVar2);
                }
                if (z2) {
                    arrayDeque.addLast(nVar);
                    nVar = nVar2;
                }
            } else {
                if (nVar instanceof n) {
                    aVar.r();
                } else {
                    aVar.t();
                }
                if (arrayDeque.isEmpty()) {
                    return nVar;
                }
                nVar = (o) arrayDeque.removeLast();
            }
        }
    }

    @Override // p018k0.y
    public final /* bridge */ /* synthetic */ void b(b bVar, Object obj) {
        d(bVar, (o) obj);
    }
}
