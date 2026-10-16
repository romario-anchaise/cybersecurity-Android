// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import C.h;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.recyclerview.widget.C0084b;
import f1.l;
import p007e.a;
import p011h.e;
import p013i.ViewTreeObserverOnGlobalLayoutListenerC0130d;

/* JADX INFO: loaded from: classes.dex */
public final class T extends Spinner {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f3115i = {R.attr.spinnerMode};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0084b f3116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H f3118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SpinnerAdapter f3119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final S f3121f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f3122h;

    /* JADX WARN: Code duplicated, block: B:26:0x0067 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x006a  */
    /* JADX WARN: Code duplicated, block: B:29:0x009d  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d7  */
    public T(Context context, AttributeSet attributeSet) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        CharSequence[] textArray;
        SpinnerAdapter spinnerAdapter;
        super(context, attributeSet, com.o2s2m.gae1fc3b2uc0u.R.attr.spinnerStyle);
        this.f3122h = new Rect();
        g1.a(this, getContext());
        int[] iArr = a.f2246v;
        h hVarP = h.p(context, attributeSet, iArr, com.o2s2m.gae1fc3b2uc0u.R.attr.spinnerStyle);
        this.f3116a = new C0084b(this);
        TypedArray typedArray = (TypedArray) hVarP.f112b;
        int resourceId = typedArray.getResourceId(4, 0);
        if (resourceId != 0) {
            this.f3117b = new e(context, resourceId);
        } else {
            this.f3117b = context;
        }
        int i2 = -1;
        TypedArray typedArray2 = null;
        try {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3115i, com.o2s2m.gae1fc3b2uc0u.R.attr.spinnerStyle, 0);
            try {
                try {
                    if (typedArrayObtainStyledAttributes.hasValue(0)) {
                        i2 = typedArrayObtainStyledAttributes.getInt(0, 0);
                    }
                } catch (Exception e2) {
                    e = e2;
                    Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                    if (typedArrayObtainStyledAttributes != null) {
                    }
                    if (i2 != 0) {
                        L l2 = new L(this);
                        this.f3121f = l2;
                        l2.f3081c = typedArray.getString(2);
                    } else if (i2 == 1) {
                        P p2 = new P(this, this.f3117b, attributeSet);
                        h hVarP2 = h.p(this.f3117b, attributeSet, iArr, com.o2s2m.gae1fc3b2uc0u.R.attr.spinnerStyle);
                        this.g = ((TypedArray) hVarP2.f112b).getLayoutDimension(3, -2);
                        p2.k(hVarP2.l(1));
                        p2.f3095B = typedArray.getString(2);
                        hVarP2.r();
                        this.f3121f = p2;
                        this.f3118c = new H(this, this, p2);
                    }
                    textArray = typedArray.getTextArray(0);
                    if (textArray != null) {
                        ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
                        arrayAdapter.setDropDownViewResource(com.o2s2m.gae1fc3b2uc0u.R.layout.support_simple_spinner_dropdown_item);
                        setAdapter((SpinnerAdapter) arrayAdapter);
                    }
                    hVarP.r();
                    this.f3120e = true;
                    spinnerAdapter = this.f3119d;
                    if (spinnerAdapter != null) {
                        setAdapter(spinnerAdapter);
                        this.f3119d = null;
                    }
                    this.f3116a.k(attributeSet, com.o2s2m.gae1fc3b2uc0u.R.attr.spinnerStyle);
                }
            } catch (Throwable th) {
                th = th;
                typedArray2 = typedArrayObtainStyledAttributes;
                if (typedArray2 != null) {
                    typedArray2.recycle();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            typedArrayObtainStyledAttributes = null;
        } catch (Throwable th2) {
            th = th2;
            if (typedArray2 != null) {
                typedArray2.recycle();
            }
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (i2 != 0) {
            L l3 = new L(this);
            this.f3121f = l3;
            l3.f3081c = typedArray.getString(2);
        } else if (i2 == 1) {
            P p3 = new P(this, this.f3117b, attributeSet);
            h hVarP3 = h.p(this.f3117b, attributeSet, iArr, com.o2s2m.gae1fc3b2uc0u.R.attr.spinnerStyle);
            this.g = ((TypedArray) hVarP3.f112b).getLayoutDimension(3, -2);
            p3.k(hVarP3.l(1));
            p3.f3095B = typedArray.getString(2);
            hVarP3.r();
            this.f3121f = p3;
            this.f3118c = new H(this, this, p3);
        }
        textArray = typedArray.getTextArray(0);
        if (textArray != null) {
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
            arrayAdapter2.setDropDownViewResource(com.o2s2m.gae1fc3b2uc0u.R.layout.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter2);
        }
        hVarP.r();
        this.f3120e = true;
        spinnerAdapter = this.f3119d;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.f3119d = null;
        }
        this.f3116a.k(attributeSet, com.o2s2m.gae1fc3b2uc0u.R.attr.spinnerStyle);
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        Rect rect = this.f3122h;
        drawable.getPadding(rect);
        return iMax2 + rect.left + rect.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0084b c0084b = this.f3116a;
        if (c0084b != null) {
            c0084b.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        S s2 = this.f3121f;
        return s2 != null ? s2.d() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        S s2 = this.f3121f;
        return s2 != null ? s2.j() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f3121f != null ? this.g : super.getDropDownWidth();
    }

    public final S getInternalPopup() {
        return this.f3121f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        S s2 = this.f3121f;
        return s2 != null ? s2.m() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f3117b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        S s2 = this.f3121f;
        return s2 != null ? s2.a() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0084b c0084b = this.f3116a;
        if (c0084b != null) {
            return c0084b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0084b c0084b = this.f3116a;
        if (c0084b != null) {
            return c0084b.i();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        S s2 = this.f3121f;
        if (s2 == null || !s2.b()) {
            return;
        }
        s2.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f3121f == null || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        Q q2 = (Q) parcelable;
        super.onRestoreInstanceState(q2.getSuperState());
        if (!q2.f3100a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0130d(2, this));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        Q q2 = new Q(super.onSaveInstanceState());
        S s2 = this.f3121f;
        q2.f3100a = s2 != null && s2.b();
        return q2;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        H h2 = this.f3118c;
        if (h2 == null || !h2.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        S s2 = this.f3121f;
        if (s2 == null) {
            return super.performClick();
        }
        if (s2.b()) {
            return true;
        }
        this.f3121f.f(J.b(this), J.a(this));
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0084b c0084b = this.f3116a;
        if (c0084b != null) {
            c0084b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        C0084b c0084b = this.f3116a;
        if (c0084b != null) {
            c0084b.n(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i2) {
        S s2 = this.f3121f;
        if (s2 == null) {
            super.setDropDownHorizontalOffset(i2);
        } else {
            s2.p(i2);
            s2.c(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i2) {
        S s2 = this.f3121f;
        if (s2 != null) {
            s2.l(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i2) {
        if (this.f3121f != null) {
            this.g = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        S s2 = this.f3121f;
        if (s2 != null) {
            s2.k(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(l.A(getPopupContext(), i2));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        S s2 = this.f3121f;
        if (s2 != null) {
            s2.g(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0084b c0084b = this.f3116a;
        if (c0084b != null) {
            c0084b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0084b c0084b = this.f3116a;
        if (c0084b != null) {
            c0084b.t(mode);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f3120e) {
            this.f3119d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        S s2 = this.f3121f;
        if (s2 != null) {
            Context context = this.f3117b;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            M m2 = new M();
            m2.f3083a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                m2.f3084b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                K.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            s2.o(m2);
        }
    }
}
