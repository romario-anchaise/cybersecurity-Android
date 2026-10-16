// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import E.c;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: loaded from: classes.dex */
public final class V0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f3129b;

    public /* synthetic */ V0(SearchView searchView, int i2) {
        this.f3128a = i2;
        this.f3129b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3128a) {
            case 0:
                this.f3129b.t();
                break;
            default:
                c cVar = this.f3129b.f1389O;
                if (cVar instanceof f1) {
                    cVar.b(null);
                }
                break;
        }
    }
}
