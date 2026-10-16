// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import com.o2s2m.gae1fc3b2uc0u.R;
import p013i.ViewTreeObserverOnGlobalLayoutListenerC0130d;

/* JADX INFO: loaded from: classes.dex */
public final class P extends I0 implements S {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public CharSequence f3095B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public M f3096C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final Rect f3097D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f3098E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final /* synthetic */ T f3099F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(T t2, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle);
        this.f3099F = t2;
        this.f3097D = new Rect();
        this.f3068o = t2;
        this.f3077x = true;
        this.f3078y.setFocusable(true);
        this.f3069p = new N(0, this);
    }

    @Override // p015j.S
    public final CharSequence a() {
        return this.f3095B;
    }

    @Override // p015j.S
    public final void f(int i2, int i3) {
        ViewTreeObserver viewTreeObserver;
        A a2 = this.f3078y;
        boolean zIsShowing = a2.isShowing();
        s();
        this.f3078y.setInputMethodMode(2);
        i();
        C0178w0 c0178w0 = this.f3057c;
        c0178w0.setChoiceMode(1);
        J.d(c0178w0, i2);
        J.c(c0178w0, i3);
        T t2 = this.f3099F;
        int selectedItemPosition = t2.getSelectedItemPosition();
        C0178w0 c0178w1 = this.f3057c;
        if (a2.isShowing() && c0178w1 != null) {
            c0178w1.setListSelectionHidden(false);
            c0178w1.setSelection(selectedItemPosition);
            if (c0178w1.getChoiceMode() != 0) {
                c0178w1.setItemChecked(selectedItemPosition, true);
            }
        }
        if (zIsShowing || (viewTreeObserver = t2.getViewTreeObserver()) == null) {
            return;
        }
        ViewTreeObserverOnGlobalLayoutListenerC0130d viewTreeObserverOnGlobalLayoutListenerC0130d = new ViewTreeObserverOnGlobalLayoutListenerC0130d(3, this);
        viewTreeObserver.addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC0130d);
        this.f3078y.setOnDismissListener(new O(this, viewTreeObserverOnGlobalLayoutListenerC0130d));
    }

    @Override // p015j.S
    public final void g(CharSequence charSequence) {
        this.f3095B = charSequence;
    }

    @Override // p015j.I0, p015j.S
    public final void o(ListAdapter listAdapter) {
        super.o(listAdapter);
        this.f3096C = (M) listAdapter;
    }

    @Override // p015j.S
    public final void p(int i2) {
        this.f3098E = i2;
    }

    public final void s() {
        int i2;
        A a2 = this.f3078y;
        Drawable background = a2.getBackground();
        T t2 = this.f3099F;
        if (background != null) {
            background.getPadding(t2.f3122h);
            boolean zA = y1.a(t2);
            Rect rect = t2.f3122h;
            i2 = zA ? rect.right : -rect.left;
        } else {
            Rect rect2 = t2.f3122h;
            rect2.right = 0;
            rect2.left = 0;
            i2 = 0;
        }
        int paddingLeft = t2.getPaddingLeft();
        int paddingRight = t2.getPaddingRight();
        int width = t2.getWidth();
        int i3 = t2.g;
        if (i3 == -2) {
            int iA = t2.a(this.f3096C, a2.getBackground());
            int i4 = t2.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = t2.f3122h;
            int i5 = (i4 - rect3.left) - rect3.right;
            if (iA > i5) {
                iA = i5;
            }
            r(Math.max(iA, (width - paddingLeft) - paddingRight));
        } else if (i3 == -1) {
            r((width - paddingLeft) - paddingRight);
        } else {
            r(i3);
        }
        this.f3060f = y1.a(t2) ? (((width - paddingRight) - this.f3059e) - this.f3098E) + i2 : paddingLeft + this.f3098E + i2;
    }
}
