// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.X;
import C.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.recyclerview.widget.C0084b;
import com.o2s2m.gae1fc3b2uc0u.R;
import f1.d;
import f1.l;
import p007e.a;

/* JADX INFO: loaded from: classes.dex */
public final class r extends CheckedTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0169s f3272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0084b f3273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0137b0 f3274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0177w f3275d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        h1.a(context);
        g1.a(this, getContext());
        C0137b0 c0137b0 = new C0137b0(this);
        this.f3274c = c0137b0;
        c0137b0.f(attributeSet, R.attr.checkedTextViewStyle);
        c0137b0.b();
        C0084b c0084b = new C0084b(this);
        this.f3273b = c0084b;
        c0084b.k(attributeSet, R.attr.checkedTextViewStyle);
        this.f3272a = new C0169s(this);
        Context context2 = getContext();
        int[] iArr = a.f2236l;
        h hVarP = h.p(context2, attributeSet, iArr, R.attr.checkedTextViewStyle);
        TypedArray typedArray = (TypedArray) hVarP.f112b;
        X.g(this, getContext(), iArr, attributeSet, (TypedArray) hVarP.f112b, R.attr.checkedTextViewStyle);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(l.A(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        setCheckMarkDrawable(l.A(getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(l.A(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                setCheckMarkTintList(hVarP.k(2));
            }
            if (typedArray.hasValue(3)) {
                setCheckMarkTintMode(AbstractC0167q0.b(typedArray.getInt(3, -1), null));
            }
            hVarP.r();
            getEmojiTextViewHelper().a(attributeSet, R.attr.checkedTextViewStyle);
        } catch (Throwable th) {
            hVarP.r();
            throw th;
        }
    }

    private C0177w getEmojiTextViewHelper() {
        if (this.f3275d == null) {
            this.f3275d = new C0177w(this);
        }
        return this.f3275d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0137b0 c0137b0 = this.f3274c;
        if (c0137b0 != null) {
            c0137b0.b();
        }
        C0084b c0084b = this.f3273b;
        if (c0084b != null) {
            c0084b.a();
        }
        C0169s c0169s = this.f3272a;
        if (c0169s != null) {
            c0169s.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return d.G(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0084b c0084b = this.f3273b;
        if (c0084b != null) {
            return c0084b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0084b c0084b = this.f3273b;
        if (c0084b != null) {
            return c0084b.i();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C0169s c0169s = this.f3272a;
        if (c0169s != null) {
            return c0169s.f3290a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0169s c0169s = this.f3272a;
        if (c0169s != null) {
            return c0169s.f3291b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3274c.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3274c.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        l.H(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().b(z2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0084b c0084b = this.f3273b;
        if (c0084b != null) {
            c0084b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0084b c0084b = this.f3273b;
        if (c0084b != null) {
            c0084b.n(i2);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0169s c0169s = this.f3272a;
        if (c0169s != null) {
            if (c0169s.f3294e) {
                c0169s.f3294e = false;
            } else {
                c0169s.f3294e = true;
                c0169s.b();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3274c;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3274c;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(d.H(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().c(z2);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0084b c0084b = this.f3273b;
        if (c0084b != null) {
            c0084b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0084b c0084b = this.f3273b;
        if (c0084b != null) {
            c0084b.t(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C0169s c0169s = this.f3272a;
        if (c0169s != null) {
            c0169s.f3290a = colorStateList;
            c0169s.f3292c = true;
            c0169s.b();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C0169s c0169s = this.f3272a;
        if (c0169s != null) {
            c0169s.f3291b = mode;
            c0169s.f3293d = true;
            c0169s.b();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0137b0 c0137b0 = this.f3274c;
        c0137b0.l(colorStateList);
        c0137b0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0137b0 c0137b0 = this.f3274c;
        c0137b0.m(mode);
        c0137b0.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        C0137b0 c0137b0 = this.f3274c;
        if (c0137b0 != null) {
            c0137b0.g(context, i2);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(l.A(getContext(), i2));
    }
}
