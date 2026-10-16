// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1556a;

    public j(g gVar) {
        this.f1556a = gVar;
    }

    public final void a() {
        s sVar = this.f1556a.f1550c;
        if (sVar.f1580l == null) {
            return;
        }
        sVar.f1587s = false;
        sVar.f1588t = false;
        sVar.f1593y.getClass();
        Iterator it = sVar.f1572c.w().iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
    }
}
