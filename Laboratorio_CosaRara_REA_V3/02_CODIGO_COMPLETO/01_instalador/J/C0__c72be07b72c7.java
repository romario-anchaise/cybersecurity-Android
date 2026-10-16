// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: loaded from: classes.dex */
public final class C0 implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3039b;

    public /* synthetic */ C0(int i2, Object obj) {
        this.f3038a = i2;
        this.f3039b = obj;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i2, long j2) {
        C0178w0 c0178w0;
        switch (this.f3038a) {
            case 0:
                if (i2 != -1 && (c0178w0 = ((I0) this.f3039b).f3057c) != null) {
                    c0178w0.setListSelectionHidden(false);
                    break;
                }
                break;
            default:
                ((SearchView) this.f3039b).p(i2);
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i2 = this.f3038a;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }
}
