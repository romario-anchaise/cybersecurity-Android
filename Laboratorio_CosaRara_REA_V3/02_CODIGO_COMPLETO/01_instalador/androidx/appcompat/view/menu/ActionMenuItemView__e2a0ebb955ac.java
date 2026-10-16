// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import f1.d;
import p007e.a;
import p013i.AbstractC0129c;
import p013i.B;
import p013i.C0128b;
import p013i.m;
import p013i.n;
import p013i.p;
import p015j.C0143e0;
import p015j.InterfaceC0156l;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends C0143e0 implements B, View.OnClickListener, InterfaceC0156l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p f1268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f1269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f1270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m f1271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C0128b f1272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AbstractC0129c f1273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1274n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1275o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f1276p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1277q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f1278r;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.f1274n = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f2228c, 0, 0);
        this.f1276p = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f1278r = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1277q = -1;
        setSaveEnabled(false);
    }

    @Override // p015j.InterfaceC0156l
    public final boolean a() {
        return !TextUtils.isEmpty(getText()) && this.f1268h.getIcon() == null;
    }

    @Override // p015j.InterfaceC0156l
    public final boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // p013i.B
    public final void c(p pVar) {
        this.f1268h = pVar;
        setIcon(pVar.getIcon());
        setTitle(pVar.getTitleCondensed());
        setId(pVar.f2960a);
        setVisibility(pVar.isVisible() ? 0 : 8);
        setEnabled(pVar.isEnabled());
        if (pVar.hasSubMenu() && this.f1272l == null) {
            this.f1272l = new C0128b(this);
        }
    }

    public final boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // p013i.B
    public p getItemData() {
        return this.f1268h;
    }

    public final void h() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f1269i);
        if (this.f1270j != null && ((this.f1268h.f2983y & 4) != 4 || (!this.f1274n && !this.f1275o))) {
            z2 = false;
        }
        boolean z4 = z3 & z2;
        setText(z4 ? this.f1269i : null);
        CharSequence charSequence = this.f1268h.f2975q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z4 ? null : this.f1268h.f2964e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f1268h.f2976r;
        if (TextUtils.isEmpty(charSequence2)) {
            d.z(this, z4 ? null : this.f1268h.f2964e);
        } else {
            d.z(this, charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        m mVar = this.f1271k;
        if (mVar != null) {
            mVar.c(this.f1268h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1274n = g();
        h();
    }

    @Override // p015j.C0143e0, android.widget.TextView, android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        boolean zIsEmpty = TextUtils.isEmpty(getText());
        if (!zIsEmpty && (i4 = this.f1277q) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int i5 = this.f1276p;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i5) : i5;
        if (mode != 1073741824 && i5 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i3);
        }
        if (!zIsEmpty || this.f1270j == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f1270j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0128b c0128b;
        if (this.f1268h.hasSubMenu() && (c0128b = this.f1272l) != null && c0128b.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z2) {
    }

    public void setChecked(boolean z2) {
    }

    public void setExpandedFormat(boolean z2) {
        if (this.f1275o != z2) {
            this.f1275o = z2;
            p pVar = this.f1268h;
            if (pVar != null) {
                n nVar = pVar.f2972n;
                nVar.f2940k = true;
                nVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1270j = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.f1278r;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (intrinsicHeight * (i2 / intrinsicWidth));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (intrinsicWidth * (i2 / intrinsicHeight));
            } else {
                i2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(m mVar) {
        this.f1271k = mVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i2, int i3, int i4, int i5) {
        this.f1277q = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(AbstractC0129c abstractC0129c) {
        this.f1273m = abstractC0129c;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1269i = charSequence;
        h();
    }
}
