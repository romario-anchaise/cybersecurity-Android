// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import androidx.appcompat.widget.Toolbar;
import p013i.p;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Toolbar f3205b;

    public /* synthetic */ j1(Toolbar toolbar, int i2) {
        this.f3204a = i2;
        this.f3205b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3204a) {
            case 0:
                m1 m1Var = this.f3205b.f1429M;
                p pVar = m1Var == null ? null : m1Var.f3251b;
                if (pVar != null) {
                    pVar.collapseActionView();
                }
                break;
            default:
                this.f3205b.n();
                break;
        }
    }
}
