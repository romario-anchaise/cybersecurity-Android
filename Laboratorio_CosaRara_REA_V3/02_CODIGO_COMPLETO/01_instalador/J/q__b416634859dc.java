// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.recyclerview.widget.C0084b;
import com.o2s2m.gae1fc3b2uc0u.R;
import f1.l;

/* JADX INFO: renamed from: j.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0166q extends CheckBox {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0169s f3264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0084b f3265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0137b0 f3266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0177w f3267d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0166q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.checkboxStyle);
        h1.a(context);
        g1.a(this, getContext());
        C0169s c0169s = new C0169s(this);
        this.f3264a = c0169s;
        c0169s.c(attributeSet, R.attr.checkboxStyle);
        C0084b c0084b = new C0084b(this);
        this.f3265b = c0084b;
        c0084b.k(attributeSet, R.attr.checkboxStyle);
        C0137b0 c0137b0 = new C0137b0(this);
        this.f3266c = c0137b0;
        c0137b0.f(attributeSet, R.attr.checkboxStyle);
        getEmojiTextViewHelper().a(attributeSet, R.attr.checkboxStyle);
    }

    private C0177w getEmojiTextViewHelper() {
        if (this.f3267d == null) {
            this.f3267d = new C0177w(this);
        }
        return this.f3267d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0084b c0084b = this.f3265b;
        if (c0084b != null) {
            c0084b.a();
        }
        C0137b0 c0137b0 = this.f3266c;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0169s c0169s = this.f3264a;
        if (c0169s != null) {
            c0169s.getClass();
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0084b c0084b = this.f3265b;
        if (c0084b != null) {
            return c0084b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0084b c0084b = this.f3265b;
        if (c0084b != null) {
            return c0084b.i();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        C0169s c0169s = this.f3264a;
        if (c0169s != null) {
            return c0169s.f3290a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0169s c0169s = this.f3264a;
        if (c0169s != null) {
            return c0169s.f3291b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3266c.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3266c.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().b(z2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0084b c0084b = this.f3265b;
        if (c0084b != null) {
            c0084b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0084b c0084b = this.f3265b;
        if (c0084b != null) {
            c0084b.n(i2);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0169s c0169s = this.f3264a;
        if (c0169s != null) {
            if (c0169s.f3294e) {
                c0169s.f3294e = false;
            } else {
                c0169s.f3294e = true;
                c0169s.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3266c;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3266c;
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
        C0084b c0084b = this.f3265b;
        if (c0084b != null) {
            c0084b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0084b c0084b = this.f3265b;
        if (c0084b != null) {
            c0084b.t(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0169s c0169s = this.f3264a;
        if (c0169s != null) {
            c0169s.f3290a = colorStateList;
            c0169s.f3292c = true;
            c0169s.a();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0169s c0169s = this.f3264a;
        if (c0169s != null) {
            c0169s.f3291b = mode;
            c0169s.f3293d = true;
            c0169s.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0137b0 c0137b0 = this.f3266c;
        c0137b0.l(colorStateList);
        c0137b0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0137b0 c0137b0 = this.f3266c;
        c0137b0.m(mode);
        c0137b0.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i2) {
        setButtonDrawable(l.A(getContext(), i2));
    }
}
