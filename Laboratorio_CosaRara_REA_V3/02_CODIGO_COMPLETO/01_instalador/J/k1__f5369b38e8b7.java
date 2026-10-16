// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import java.util.Iterator;
import p009f.I;
import p013i.l;
import p013i.n;

/* JADX INFO: loaded from: classes.dex */
public final class k1 implements InterfaceC0160n, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Toolbar f3228a;

    public /* synthetic */ k1(Toolbar toolbar) {
        this.f3228a = toolbar;
    }

    @Override // p013i.l
    public void f(n nVar) {
        Toolbar toolbar = this.f3228a;
        C0154k c0154k = toolbar.f1436a.f1356t;
        if (c0154k == null || !c0154k.i()) {
            Iterator it = toolbar.f1423G.f65b.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        }
        I i2 = toolbar.f1431O;
        if (i2 != null) {
            i2.f(nVar);
        }
    }

    @Override // p013i.l
    public boolean m(n nVar, MenuItem menuItem) {
        I i2 = this.f3228a.f1431O;
        return false;
    }
}
