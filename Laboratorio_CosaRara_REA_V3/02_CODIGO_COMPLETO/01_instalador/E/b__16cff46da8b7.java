// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package E;

import android.database.DataSetObserver;
import p015j.I0;
import p015j.f1;

/* JADX INFO: loaded from: classes.dex */
public final class b extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f152b;

    public /* synthetic */ b(int i2, Object obj) {
        this.f151a = i2;
        this.f152b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f151a) {
            case 0:
                f1 f1Var = (f1) this.f152b;
                f1Var.f153a = true;
                f1Var.notifyDataSetChanged();
                break;
            default:
                I0 i1 = (I0) this.f152b;
                if (i1.f3078y.isShowing()) {
                    i1.i();
                }
                break;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f151a) {
            case 0:
                f1 f1Var = (f1) this.f152b;
                f1Var.f153a = false;
                f1Var.notifyDataSetInvalidated();
                break;
            default:
                ((I0) this.f152b).dismiss();
                break;
        }
    }
}
