// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.view.View;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: loaded from: classes.dex */
public final class W0 implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f3133a;

    public W0(SearchView searchView) {
        this.f3133a = searchView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        SearchView searchView = this.f3133a;
        View.OnFocusChangeListener onFocusChangeListener = searchView.f1385K;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, z2);
        }
    }
}
