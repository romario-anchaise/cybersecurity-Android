// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.view.KeyEvent;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: loaded from: classes.dex */
public final class Y0 implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f3135a;

    public Y0(SearchView searchView) {
        this.f3135a = searchView;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        this.f3135a.r();
        return true;
    }
}
