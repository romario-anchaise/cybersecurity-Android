// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import android.view.MenuItem;
import p013i.l;
import p013i.n;
import p015j.o1;

/* JADX INFO: loaded from: classes.dex */
public final class I implements o1, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ K f2414a;

    public /* synthetic */ I(K k2) {
        this.f2414a = k2;
    }

    @Override // p013i.l
    public void f(n nVar) {
        K k2 = this.f2414a;
        boolean zP = k2.f2417a.f3276a.p();
        u uVar = k2.f2418b;
        if (zP) {
            uVar.onPanelClosed(108, nVar);
        } else if (uVar.onPreparePanel(0, null, nVar)) {
            uVar.onMenuOpened(108, nVar);
        }
    }

    @Override // p013i.l
    public boolean m(n nVar, MenuItem menuItem) {
        return false;
    }
}
