// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f extends f1.l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f195c;

    public f(g gVar) {
        this.f195c = gVar;
    }

    @Override // f1.l
    public final void I(Throwable th) {
        this.f195c.f196a.d(th);
    }

    @Override // f1.l
    public final void J(x xVar) {
        g gVar = this.f195c;
        gVar.f198c = xVar;
        gVar.f197b = new s(gVar.f198c, new C0028c(1), gVar.f196a.f212h);
        l lVar = gVar.f196a;
        lVar.getClass();
        ArrayList arrayList = new ArrayList();
        lVar.f206a.writeLock().lock();
        try {
            lVar.f208c = 1;
            arrayList.addAll(lVar.f207b);
            lVar.f207b.clear();
            lVar.f206a.writeLock().unlock();
            lVar.f209d.post(new j(arrayList, lVar.f208c, null));
        } catch (Throwable th) {
            lVar.f206a.writeLock().unlock();
            throw th;
        }
    }
}
