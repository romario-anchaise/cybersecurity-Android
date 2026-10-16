// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p040w0;

import E0.p;
import F0.i;
import java.io.Serializable;
import p029q.j;

/* JADX INFO: loaded from: classes.dex */
public final class c implements i, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f4162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f4163b;

    public c(i iVar, g gVar) {
        i.e(iVar, "left");
        this.f4162a = iVar;
        this.f4163b = gVar;
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this != obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            cVar.getClass();
            int i2 = 2;
            c cVar2 = cVar;
            int i3 = 2;
            while (true) {
                i iVar = cVar2.f4162a;
                cVar2 = iVar instanceof c ? (c) iVar : null;
                if (cVar2 == null) {
                    break;
                }
                i3++;
            }
            c cVar3 = this;
            while (true) {
                i iVar2 = cVar3.f4162a;
                cVar3 = iVar2 instanceof c ? (c) iVar2 : null;
                if (cVar3 == null) {
                    break;
                }
                i2++;
            }
            if (i3 != i2) {
                return false;
            }
            c cVar4 = this;
            while (true) {
                g gVar = cVar4.f4163b;
                if (!i.a(cVar.j(gVar.getKey()), gVar)) {
                    zA = false;
                    break;
                }
                i iVar3 = cVar4.f4162a;
                if (!(iVar3 instanceof c)) {
                    i.c(iVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    g gVar2 = (g) iVar3;
                    zA = i.a(cVar.j(gVar2.getKey()), gVar2);
                    break;
                }
                cVar4 = (c) iVar3;
            }
            if (!zA) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f4163b.hashCode() + this.f4162a.hashCode();
    }

    @Override // p040w0.i
    public final g j(h hVar) {
        i.e(hVar, "key");
        c cVar = this;
        while (true) {
            g gVarJ = cVar.f4163b.j(hVar);
            if (gVarJ != null) {
                return gVarJ;
            }
            i iVar = cVar.f4162a;
            if (!(iVar instanceof c)) {
                return iVar.j(hVar);
            }
            cVar = (c) iVar;
        }
    }

    @Override // p040w0.i
    public final Object n(Object obj, p pVar) {
        return pVar.c(this.f4162a.n(obj, pVar), this.f4163b);
    }

    @Override // p040w0.i
    public final i r(h hVar) {
        i.e(hVar, "key");
        g gVar = this.f4163b;
        g gVarJ = gVar.j(hVar);
        i iVar = this.f4162a;
        if (gVarJ != null) {
            return iVar;
        }
        i iVarR = iVar.r(hVar);
        if (iVarR == iVar) {
            return this;
        }
        return iVarR == j.f4165a ? gVar : new c(iVarR, gVar);
    }

    @Override // p040w0.i
    public final i t(i iVar) {
        return j.n(this, iVar);
    }

    public final String toString() {
        return "[" + ((String) n("", b.f4159c)) + ']';
    }
}
