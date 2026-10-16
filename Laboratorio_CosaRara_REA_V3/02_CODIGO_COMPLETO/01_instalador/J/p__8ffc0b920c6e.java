// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.recyclerview.widget.C0084b;
import com.o2s2m.gae1fc3b2uc0u.R;
import f1.d;
import f1.l;

/* JADX INFO: renamed from: j.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0164p extends Button {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0084b f3259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0137b0 f3260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0177w f3261c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0164p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyle);
        h1.a(context);
        g1.a(this, getContext());
        C0084b c0084b = new C0084b(this);
        this.f3259a = c0084b;
        c0084b.k(attributeSet, R.attr.buttonStyle);
        C0137b0 c0137b0 = new C0137b0(this);
        this.f3260b = c0137b0;
        c0137b0.f(attributeSet, R.attr.buttonStyle);
        c0137b0.b();
        getEmojiTextViewHelper().a(attributeSet, R.attr.buttonStyle);
    }

    private C0177w getEmojiTextViewHelper() {
        if (this.f3261c == null) {
            this.f3261c = new C0177w(this);
        }
        return this.f3261c;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0084b c0084b = this.f3259a;
        if (c0084b != null) {
            c0084b.a();
        }
        C0137b0 c0137b0 = this.f3260b;
        if (c0137b0 != null) {
            c0137b0.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (y1.f3355b) {
            return super.getAutoSizeMaxTextSize();
        }
        C0137b0 c0137b0 = this.f3260b;
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
        C0137b0 c0137b0 = this.f3260b;
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
        C0137b0 c0137b0 = this.f3260b;
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
        C0137b0 c0137b0 = this.f3260b;
        return c0137b0 != null ? c0137b0.f3147i.f3236f : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (y1.f3355b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C0137b0 c0137b0 = this.f3260b;
        if (c0137b0 != null) {
            return c0137b0.f3147i.f3231a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return d.G(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0084b c0084b = this.f3259a;
        if (c0084b != null) {
            return c0084b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0084b c0084b = this.f3259a;
        if (c0084b != null) {
            return c0084b.i();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3260b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3260b.e();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        C0137b0 c0137b0 = this.f3260b;
        if (c0137b0 == null || y1.f3355b) {
            return;
        }
        c0137b0.f3147i.a();
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        C0137b0 c0137b0 = this.f3260b;
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
        C0137b0 c0137b0 = this.f3260b;
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
        C0137b0 c0137b0 = this.f3260b;
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
        C0137b0 c0137b0 = this.f3260b;
        if (c0137b0 != null) {
            c0137b0.k(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0084b c0084b = this.f3259a;
        if (c0084b != null) {
            c0084b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0084b c0084b = this.f3259a;
        if (c0084b != null) {
            c0084b.n(i2);
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

    public void setSupportAllCaps(boolean z2) {
        C0137b0 c0137b0 = this.f3260b;
        if (c0137b0 != null) {
            c0137b0.f3140a.setAllCaps(z2);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0084b c0084b = this.f3259a;
        if (c0084b != null) {
            c0084b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0084b c0084b = this.f3259a;
        if (c0084b != null) {
            c0084b.t(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0137b0 c0137b0 = this.f3260b;
        c0137b0.l(colorStateList);
        c0137b0.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0137b0 c0137b0 = this.f3260b;
        c0137b0.m(mode);
        c0137b0.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        C0137b0 c0137b0 = this.f3260b;
        if (c0137b0 != null) {
            c0137b0.g(context, i2);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i2, float f2) {
        boolean z2 = y1.f3355b;
        if (z2) {
            super.setTextSize(i2, f2);
            return;
        }
        C0137b0 c0137b0 = this.f3260b;
        if (c0137b0 == null || z2) {
            return;
        }
        C0157l0 c0157l0 = c0137b0.f3147i;
        if (c0157l0.f()) {
            return;
        }
        c0157l0.g(i2, f2);
    }
}
