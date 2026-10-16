// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p040w0;

import E0.p;
import F0.i;
import F0.j;

/* JADX INFO: loaded from: classes.dex */
public final class b extends j implements p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f4159c = new b(2, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f4160d = new b(2, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4161b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i2, int i3) {
        super(i2);
        this.f4161b = i3;
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) {
        c cVar;
        switch (this.f4161b) {
            case 0:
                String str = (String) obj;
                g gVar = (g) obj2;
                i.e(str, "acc");
                if (str.length() == 0) {
                    return gVar.toString();
                }
                return str + ", " + gVar;
            default:
                i iVar = (i) obj;
                g gVar2 = (g) obj2;
                i.e(iVar, "acc");
                i iVarR = iVar.r(gVar2.getKey());
                j jVar = j.f4165a;
                if (iVarR == jVar) {
                    return gVar2;
                }
                e eVar = e.f4164a;
                f fVar = (f) iVarR.j(eVar);
                if (fVar == null) {
                    cVar = new c(iVarR, gVar2);
                } else {
                    i iVarR2 = iVarR.r(eVar);
                    if (iVarR2 == jVar) {
                        return new c(gVar2, fVar);
                    }
                    cVar = new c(new c(iVarR2, gVar2), fVar);
                }
                return cVar;
        }
    }
}
