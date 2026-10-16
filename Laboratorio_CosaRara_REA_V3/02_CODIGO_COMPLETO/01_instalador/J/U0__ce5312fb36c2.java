// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: loaded from: classes.dex */
public final class U0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f3123a;

    public U0(SearchView searchView) {
        this.f3123a = searchView;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        SearchView searchView = this.f3123a;
        Editable text = searchView.f1403p.getText();
        searchView.f1395V = text;
        boolean zIsEmpty = TextUtils.isEmpty(text);
        searchView.w(!zIsEmpty);
        int i5 = 8;
        if (searchView.f1394U && !searchView.f1388N && zIsEmpty) {
            searchView.f1408u.setVisibility(8);
            i5 = 0;
        }
        searchView.f1410w.setVisibility(i5);
        searchView.s();
        searchView.v();
        charSequence.toString();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }
}
