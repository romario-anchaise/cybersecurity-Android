// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import C.h;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.recyclerview.widget.C0084b;
import f1.d;
import f1.l;

/* JADX INFO: renamed from: j.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0162o extends AutoCompleteTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f3255d = {R.attr.popupBackground};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0084b f3256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0137b0 f3257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B f3258c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0162o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.o2s2m.gae1fc3b2uc0u.R.attr.autoCompleteTextViewStyle);
        h1.a(context);
        g1.a(this, getContext());
        h hVarP = h.p(getContext(), attributeSet, f3255d, com.o2s2m.gae1fc3b2uc0u.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) hVarP.f112b).hasValue(0)) {
            setDropDownBackgroundDrawable(hVarP.l(0));
        }
        hVarP.r();
        C0084b c0084b = new C0084b(this);
        this.f3256a = c0084b;
        c0084b.k(attributeSet, com.o2s2m.gae1fc3b2uc0u.R.attr.autoCompleteTextViewStyle);
        C0137b0 c0137b0 = new C0137b0(this);
        this.f3257b = c0137b0;
        c0137b0.f(attributeSet, com.o2s2m.gae1fc3b2uc0u.R.attr.autoCompleteTextViewStyle);
        c0137b0.b();
        B b2 = new B(this);
        this.f3258c = b2;
        b2.b(attributeSet, com.o2s2m.gae1fc3b2uc0u.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListenerA = b2.a(keyListener);
        if (keyListenerA == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerA);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0084b c0084b = this.f3256a;
        if (c0084b != null) {
            c0084b.a();
        }
        C0137b0 c0137b0 = this.f3257b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return d.G(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0084b c0084b = this.f3256a;
        if (c0084b != null) {
            return c0084b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0084b c0084b = this.f3256a;
        if (c0084b != null) {
            return c0084b.i();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3257b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3257b.e();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        l.H(editorInfo, inputConnectionOnCreateInputConnection, this);
        return this.f3258c.c(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0084b c0084b = this.f3256a;
        if (c0084b != null) {
            c0084b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0084b c0084b = this.f3256a;
        if (c0084b != null) {
            c0084b.n(i2);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3257b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3257b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(d.H(callback, this));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(l.A(getContext(), i2));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        this.f3258c.d(z2);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f3258c.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0084b c0084b = this.f3256a;
        if (c0084b != null) {
            c0084b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0084b c0084b = this.f3256a;
        if (c0084b != null) {
            c0084b.t(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0137b0 c0137b0 = this.f3257b;
        c0137b0.l(colorStateList);
        c0137b0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0137b0 c0137b0 = this.f3257b;
        c0137b0.m(mode);
        c0137b0.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        C0137b0 c0137b0 = this.f3257b;
        if (c0137b0 != null) {
            c0137b0.g(context, i2);
        }
    }
}
