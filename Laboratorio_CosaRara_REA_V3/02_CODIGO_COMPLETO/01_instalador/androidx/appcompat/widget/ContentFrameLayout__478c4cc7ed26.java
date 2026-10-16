// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.widget;

import A.h0;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import p009f.q;
import p009f.z;
import p013i.n;
import p015j.C0146g;
import p015j.C0154k;
import p015j.InterfaceC0161n0;
import p015j.InterfaceC0163o0;
import p015j.r1;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TypedValue f1367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TypedValue f1368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f1369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TypedValue f1370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f1371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TypedValue f1372f;
    public final Rect g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public InterfaceC0161n0 f1373h;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1371e == null) {
            this.f1371e = new TypedValue();
        }
        return this.f1371e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1372f == null) {
            this.f1372f = new TypedValue();
        }
        return this.f1372f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1369c == null) {
            this.f1369c = new TypedValue();
        }
        return this.f1369c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1370d == null) {
            this.f1370d = new TypedValue();
        }
        return this.f1370d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1367a == null) {
            this.f1367a = new TypedValue();
        }
        return this.f1367a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1368b == null) {
            this.f1368b = new TypedValue();
        }
        return this.f1368b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        InterfaceC0161n0 interfaceC0161n0 = this.f1373h;
        if (interfaceC0161n0 != null) {
            interfaceC0161n0.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        C0154k c0154k;
        super.onDetachedFromWindow();
        InterfaceC0161n0 interfaceC0161n0 = this.f1373h;
        if (interfaceC0161n0 != null) {
            z zVar = ((q) interfaceC0161n0).f2514b;
            InterfaceC0163o0 interfaceC0163o0 = zVar.f2588r;
            if (interfaceC0163o0 != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0163o0;
                actionBarOverlayLayout.k();
                ActionMenuView actionMenuView = ((r1) actionBarOverlayLayout.f1330e).f3276a.f1436a;
                if (actionMenuView != null && (c0154k = actionMenuView.f1356t) != null) {
                    c0154k.e();
                    C0146g c0146g = c0154k.f3224t;
                    if (c0146g != null && c0146g.b()) {
                        c0146g.f3004i.dismiss();
                    }
                }
            }
            if (zVar.f2593w != null) {
                zVar.f2582l.getDecorView().removeCallbacks(zVar.f2594x);
                if (zVar.f2593w.isShowing()) {
                    try {
                        zVar.f2593w.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                zVar.f2593w = null;
            }
            h0 h0Var = zVar.f2595y;
            if (h0Var != null) {
                h0Var.b();
            }
            n nVar = zVar.A(0).f2535h;
            if (nVar != null) {
                nVar.c(true);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x008a  */
    /* JADX WARN: Code duplicated, block: B:38:0x009d  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00de  */
    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        int iMakeMeasureSpec;
        boolean z2;
        int iMakeMeasureSpec2;
        int i4;
        int i5;
        float fraction;
        int i6;
        int i7;
        float fraction2;
        int i8;
        int i9;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z3 = true;
        boolean z4 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        Rect rect = this.g;
        if (mode != Integer.MIN_VALUE) {
            iMakeMeasureSpec = i2;
            z2 = false;
        } else {
            TypedValue typedValue = z4 ? this.f1370d : this.f1369c;
            if (typedValue == null || (i8 = typedValue.type) == 0) {
                iMakeMeasureSpec = i2;
                z2 = false;
            } else {
                if (i8 == 5) {
                    fraction3 = typedValue.getDimension(displayMetrics);
                } else {
                    if (i8 == 6) {
                        int i10 = displayMetrics.widthPixels;
                        fraction3 = typedValue.getFraction(i10, i10);
                    } else {
                        i9 = 0;
                    }
                    if (i9 > 0) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(i9 - (rect.left + rect.right), View.MeasureSpec.getSize(i2)), 1073741824);
                        z2 = true;
                    } else {
                        iMakeMeasureSpec = i2;
                        z2 = false;
                    }
                }
                i9 = (int) fraction3;
                if (i9 > 0) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(i9 - (rect.left + rect.right), View.MeasureSpec.getSize(i2)), 1073741824);
                    z2 = true;
                } else {
                    iMakeMeasureSpec = i2;
                    z2 = false;
                }
            }
        }
        if (mode2 != Integer.MIN_VALUE) {
            iMakeMeasureSpec2 = i3;
        } else {
            TypedValue typedValue2 = z4 ? this.f1371e : this.f1372f;
            if (typedValue2 == null || (i6 = typedValue2.type) == 0) {
                iMakeMeasureSpec2 = i3;
            } else {
                if (i6 == 5) {
                    fraction2 = typedValue2.getDimension(displayMetrics);
                } else {
                    if (i6 == 6) {
                        int i11 = displayMetrics.heightPixels;
                        fraction2 = typedValue2.getFraction(i11, i11);
                    } else {
                        i7 = 0;
                    }
                    if (i7 > 0) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.min(i7 - (rect.top + rect.bottom), View.MeasureSpec.getSize(i3)), 1073741824);
                    } else {
                        iMakeMeasureSpec2 = i3;
                    }
                }
                i7 = (int) fraction2;
                if (i7 > 0) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.min(i7 - (rect.top + rect.bottom), View.MeasureSpec.getSize(i3)), 1073741824);
                } else {
                    iMakeMeasureSpec2 = i3;
                }
            }
        }
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec2);
        int measuredWidth = getMeasuredWidth();
        int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (z2 || mode != Integer.MIN_VALUE) {
            z3 = false;
        } else {
            TypedValue typedValue3 = z4 ? this.f1368b : this.f1367a;
            if (typedValue3 == null || (i4 = typedValue3.type) == 0) {
                z3 = false;
            } else {
                if (i4 == 5) {
                    fraction = typedValue3.getDimension(displayMetrics);
                } else {
                    if (i4 == 6) {
                        int i12 = displayMetrics.widthPixels;
                        fraction = typedValue3.getFraction(i12, i12);
                    } else {
                        i5 = 0;
                    }
                    if (i5 > 0) {
                        i5 -= rect.left + rect.right;
                    }
                    if (measuredWidth < i5) {
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                    } else {
                        z3 = false;
                    }
                }
                i5 = (int) fraction;
                if (i5 > 0) {
                    i5 -= rect.left + rect.right;
                }
                if (measuredWidth < i5) {
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                } else {
                    z3 = false;
                }
            }
        }
        if (z3) {
            super.onMeasure(iMakeMeasureSpec3, iMakeMeasureSpec2);
        }
    }

    public void setAttachListener(InterfaceC0161n0 interfaceC0161n0) {
        this.f1373h = interfaceC0161n0;
    }
}
