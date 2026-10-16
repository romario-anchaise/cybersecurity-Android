// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.recyclerview.widget.C0084b;
import f1.l;

/* JADX INFO: renamed from: j.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0159m0 extends ToggleButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0084b f3247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0137b0 f3248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0177w f3249c;

    public C0159m0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        g1.a(this, getContext());
        C0084b c0084b = new C0084b(this);
        this.f3247a = c0084b;
        c0084b.k(attributeSet, R.attr.buttonStyleToggle);
        C0137b0 c0137b0 = new C0137b0(this);
        this.f3248b = c0137b0;
        c0137b0.f(attributeSet, R.attr.buttonStyleToggle);
        getEmojiTextViewHelper().a(attributeSet, R.attr.buttonStyleToggle);
    }

    private C0177w getEmojiTextViewHelper() {
        if (this.f3249c == null) {
            this.f3249c = new C0177w(this);
        }
        return this.f3249c;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0084b c0084b = this.f3247a;
        if (c0084b != null) {
            c0084b.a();
        }
        C0137b0 c0137b0 = this.f3248b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0084b c0084b = this.f3247a;
        if (c0084b != null) {
            return c0084b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0084b c0084b = this.f3247a;
        if (c0084b != null) {
            return c0084b.i();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3248b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3248b.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().b(z2);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0084b c0084b = this.f3247a;
        if (c0084b != null) {
            c0084b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0084b c0084b = this.f3247a;
        if (c0084b != null) {
            c0084b.n(i2);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3248b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3248b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().c(z2);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((l) getEmojiTextViewHelper().f3333b.f34b).B(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0084b c0084b = this.f3247a;
        if (c0084b != null) {
            c0084b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0084b c0084b = this.f3247a;
        if (c0084b != null) {
            c0084b.t(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0137b0 c0137b0 = this.f3248b;
        c0137b0.l(colorStateList);
        c0137b0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0137b0 c0137b0 = this.f3248b;
        c0137b0.m(mode);
        c0137b0.b();
    }
}
