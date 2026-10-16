// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import F0.h;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p018k0.m;
import p018k0.x;
import p018k0.y;
import p022m0.n;
import s0.a;
import s0.b;

/* JADX INFO: renamed from: n0.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0231m extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0229k f3936c = new C0229k(1, x.f3429a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f3938b;

    public C0231m(m mVar, x xVar) {
        this.f3937a = mVar;
        this.f3938b = xVar;
    }

    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        Object arrayList;
        Serializable arrayList2;
        int iJ = aVar.J();
        int iB = androidx.fragment.app.y.b(iJ);
        if (iB == 0) {
            aVar.a();
            arrayList = new ArrayList();
        } else if (iB != 2) {
            arrayList = null;
        } else {
            aVar.f();
            arrayList = new n(true);
        }
        if (arrayList == null) {
            return c(aVar, iJ);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.w()) {
                String strD = arrayList instanceof Map ? aVar.D() : null;
                int iJ2 = aVar.J();
                int iB2 = androidx.fragment.app.y.b(iJ2);
                if (iB2 == 0) {
                    aVar.a();
                    arrayList2 = new ArrayList();
                } else if (iB2 != 2) {
                    arrayList2 = null;
                } else {
                    aVar.f();
                    arrayList2 = new n(true);
                }
                boolean z2 = arrayList2 != null;
                if (arrayList2 == null) {
                    arrayList2 = c(aVar, iJ2);
                }
                if (arrayList instanceof List) {
                    ((List) arrayList).add(arrayList2);
                } else {
                    ((Map) arrayList).put(strD, arrayList2);
                }
                if (z2) {
                    arrayDeque.addLast(arrayList);
                    arrayList = arrayList2;
                }
            } else {
                if (arrayList instanceof List) {
                    aVar.r();
                } else {
                    aVar.t();
                }
                if (arrayDeque.isEmpty()) {
                    return arrayList;
                }
                arrayList = arrayDeque.removeLast();
            }
        }
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.w();
            return;
        }
        Class<?> cls = obj.getClass();
        m mVar = this.f3937a;
        mVar.getClass();
        y yVarB = mVar.b(new p032r0.a(cls));
        if (!(yVarB instanceof C0231m)) {
            yVarB.b(bVar, obj);
        } else {
            bVar.j();
            bVar.t();
        }
    }

    public final Serializable c(a aVar, int i2) throws IOException {
        int iB = androidx.fragment.app.y.b(i2);
        if (iB == 5) {
            return aVar.H();
        }
        if (iB == 6) {
            return this.f3938b.a(aVar);
        }
        if (iB == 7) {
            return Boolean.valueOf(aVar.z());
        }
        if (iB != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(h.i(i2)));
        }
        aVar.F();
        return null;
    }
}
