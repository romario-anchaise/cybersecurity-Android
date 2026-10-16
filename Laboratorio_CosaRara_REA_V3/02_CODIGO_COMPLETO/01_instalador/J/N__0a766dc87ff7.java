// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: loaded from: classes.dex */
public final class N implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3086b;

    public /* synthetic */ N(int i2, Object obj) {
        this.f3085a = i2;
        this.f3086b = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        switch (this.f3085a) {
            case 0:
                P p2 = (P) this.f3086b;
                p2.f3099F.setSelection(i2);
                T t2 = p2.f3099F;
                if (t2.getOnItemClickListener() != null) {
                    t2.performItemClick(view, i2, p2.f3096C.getItemId(i2));
                }
                p2.dismiss();
                break;
            default:
                ((SearchView) this.f3086b).o(i2);
                break;
        }
    }
}
