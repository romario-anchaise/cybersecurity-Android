// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import com.o2s2m.gae1fc3b2uc0u.R;

/* JADX INFO: loaded from: classes.dex */
public final class X0 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f3134a;

    public X0(SearchView searchView) {
        this.f3134a = searchView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int dimensionPixelSize;
        SearchView searchView = this.f3134a;
        View view2 = searchView.f1411x;
        if (view2.getWidth() > 1) {
            Resources resources = searchView.getContext().getResources();
            int paddingLeft = searchView.f1405r.getPaddingLeft();
            Rect rect = new Rect();
            boolean zA = y1.a(searchView);
            if (searchView.f1387M) {
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
            } else {
                dimensionPixelSize = 0;
            }
            SearchView.SearchAutoComplete searchAutoComplete = searchView.f1403p;
            searchAutoComplete.getDropDownBackground().getPadding(rect);
            searchAutoComplete.setDropDownHorizontalOffset(zA ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }
}
