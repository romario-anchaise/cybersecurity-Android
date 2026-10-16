// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p041x;

import H.s;
import java.util.ArrayList;
import p021m.i;
import p045z.a;

/* JADX INFO: loaded from: classes.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4173b;

    public /* synthetic */ e(int i2, Object obj) {
        this.f4172a = i2;
        this.f4173b = obj;
    }

    @Override // p045z.a
    public final void a(Object obj) {
        switch (this.f4172a) {
            case 0:
                f fVar = (f) obj;
                if (fVar == null) {
                    fVar = new f(-3);
                }
                ((s) this.f4173b).D(fVar);
                return;
            default:
                f fVar2 = (f) obj;
                synchronized (g.f4178c) {
                    try {
                        i iVar = g.f4179d;
                        ArrayList arrayList = (ArrayList) iVar.get((String) this.f4173b);
                        if (arrayList == null) {
                            return;
                        }
                        iVar.remove((String) this.f4173b);
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            ((a) arrayList.get(i2)).a(fVar2);
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
        }
    }
}
