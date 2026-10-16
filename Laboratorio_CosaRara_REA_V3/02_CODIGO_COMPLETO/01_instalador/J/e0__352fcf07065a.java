// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.C0005e;
import D.r;
import D.s;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.recyclerview.widget.C0084b;
import f1.d;
import f1.l;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import p029q.j;
import p033t.f;
import p043y.b;
import p043y.c;

/* JADX INFO: renamed from: j.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0143e0 extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0084b f3163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0137b0 f3164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B f3165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0177w f3166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0005e f3168f;
    public Future g;

    public C0143e0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private C0177w getEmojiTextViewHelper() {
        if (this.f3166d == null) {
            this.f3166d = new C0177w(this);
        }
        return this.f3166d;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0084b c0084b = this.f3163a;
        if (c0084b != null) {
            c0084b.a();
        }
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    public final void f() {
        Future future = this.g;
        if (future == null) {
            return;
        }
        try {
            this.g = null;
            if (future.get() != null) {
                throw new ClassCastException();
            }
            if (Build.VERSION.SDK_INT >= 29) {
                throw null;
            }
            d.r(this);
            throw null;
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (y1.f3355b) {
            return super.getAutoSizeMaxTextSize();
        }
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            return Math.round(c0137b0.f3147i.f3235e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (y1.f3355b) {
            return super.getAutoSizeMinTextSize();
        }
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            return Math.round(c0137b0.f3147i.f3234d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (y1.f3355b) {
            return super.getAutoSizeStepGranularity();
        }
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            return Math.round(c0137b0.f3147i.f3233c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (y1.f3355b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0137b0 c0137b0 = this.f3164b;
        return c0137b0 != null ? c0137b0.f3147i.f3236f : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (y1.f3355b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            return c0137b0.f3147i.f3231a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return d.G(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public InterfaceC0139c0 getSuperCaller() {
        if (this.f3168f == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                this.f3168f = new C0141d0(this);
            } else if (i2 >= 26) {
                this.f3168f = new C0005e(21, this);
            }
        }
        return this.f3168f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0084b c0084b = this.f3163a;
        if (c0084b != null) {
            return c0084b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0084b c0084b = this.f3163a;
        if (c0084b != null) {
            return c0084b.i();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3164b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3164b.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        f();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        B b2;
        if (Build.VERSION.SDK_INT >= 28 || (b2 = this.f3165c) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) b2.f3019c;
        return textClassifier == null ? U.a((TextView) b2.f3018b) : textClassifier;
    }

    public b getTextMetricsParamsCompat() {
        return d.r(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f3164b.getClass();
        C0137b0.h(editorInfo, inputConnectionOnCreateInputConnection, this);
        l.H(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 == null || y1.f3355b) {
            return;
        }
        c0137b0.f3147i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        f();
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 == null || y1.f3355b) {
            return;
        }
        C0157l0 c0157l0 = c0137b0.f3147i;
        if (c0157l0.f()) {
            c0157l0.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().b(z2);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) {
        if (y1.f3355b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            c0137b0.i(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        if (y1.f3355b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            c0137b0.j(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (y1.f3355b) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            c0137b0.k(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0084b c0084b = this.f3163a;
        if (c0084b != null) {
            c0084b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0084b c0084b = this.f3163a;
        if (c0084b != null) {
            c0084b.n(i2);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0137b0 c0137b0 = this.f3164b;
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

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((l) getEmojiTextViewHelper().f3333b.f34b).B(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().c(i2);
        } else {
            d.x(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().w(i2);
        } else {
            d.y(this, i2);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        int fontMetricsInt = getPaint().getFontMetricsInt(null);
        if (i2 != fontMetricsInt) {
            setLineSpacing(i2 - fontMetricsInt, 1.0f);
        }
    }

    public void setPrecomputedText(c cVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        d.r(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0084b c0084b = this.f3163a;
        if (c0084b != null) {
            c0084b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0084b c0084b = this.f3163a;
        if (c0084b != null) {
            c0084b.t(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0137b0 c0137b0 = this.f3164b;
        c0137b0.l(colorStateList);
        c0137b0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0137b0 c0137b0 = this.f3164b;
        c0137b0.m(mode);
        c0137b0.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            c0137b0.g(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        B b2;
        if (Build.VERSION.SDK_INT >= 28 || (b2 = this.f3165c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            b2.f3019c = textClassifier;
        }
    }

    public void setTextFuture(Future<c> future) {
        this.g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(b bVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = bVar.f4192b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i2 = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i2 = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i2 = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i2 = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i2 = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i2 = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i2 = 7;
            }
        }
        r.h(this, i2);
        getPaint().set(bVar.f4191a);
        s.e(this, bVar.f4193c);
        s.h(this, bVar.f4194d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i2, float f2) {
        boolean z2 = y1.f3355b;
        if (z2) {
            super.setTextSize(i2, f2);
            return;
        }
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 == null || z2) {
            return;
        }
        C0157l0 c0157l0 = c0137b0.f3147i;
        if (c0157l0.f()) {
            return;
        }
        c0157l0.g(i2, f2);
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i2) {
        Typeface typefaceCreate;
        if (this.f3167e) {
            return;
        }
        if (typeface == null || i2 <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            j jVar = f.f4108a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typefaceCreate = Typeface.create(typeface, i2);
        }
        this.f3167e = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i2);
        } finally {
            this.f3167e = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0143e0(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        h1.a(context);
        this.f3167e = false;
        this.f3168f = null;
        g1.a(this, getContext());
        C0084b c0084b = new C0084b(this);
        this.f3163a = c0084b;
        c0084b.k(attributeSet, i2);
        C0137b0 c0137b0 = new C0137b0(this);
        this.f3164b = c0137b0;
        c0137b0.f(attributeSet, i2);
        c0137b0.b();
        B b2 = new B();
        b2.f3018b = this;
        this.f3165c = b2;
        getEmojiTextViewHelper().a(attributeSet, i2);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i2 != 0 ? l.A(context, i2) : null, i3 != 0 ? l.A(context, i3) : null, i4 != 0 ? l.A(context, i4) : null, i5 != 0 ? l.A(context, i5) : null);
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i2 != 0 ? l.A(context, i2) : null, i3 != 0 ? l.A(context, i3) : null, i4 != 0 ? l.A(context, i4) : null, i5 != 0 ? l.A(context, i5) : null);
        C0137b0 c0137b0 = this.f3164b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }
}
