// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.H;
import A.X;
import C.h;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import java.util.WeakHashMap;
import p007e.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class B0 extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3025f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f3027i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f3028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f3029k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3030l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3031m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3032n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3033o;

    public B0(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3020a = true;
        this.f3021b = -1;
        this.f3022c = 0;
        this.f3024e = 8388659;
        int[] iArr = a.f2238n;
        h hVarP = h.p(context, attributeSet, iArr, i2);
        X.g(this, context, iArr, attributeSet, (TypedArray) hVarP.f112b, i2);
        TypedArray typedArray = (TypedArray) hVarP.f112b;
        int i3 = typedArray.getInt(1, -1);
        if (i3 >= 0) {
            setOrientation(i3);
        }
        int i4 = typedArray.getInt(0, -1);
        if (i4 >= 0) {
            setGravity(i4);
        }
        boolean z2 = typedArray.getBoolean(2, true);
        if (!z2) {
            setBaselineAligned(z2);
        }
        this.g = typedArray.getFloat(4, -1.0f);
        this.f3021b = typedArray.getInt(3, -1);
        this.f3026h = typedArray.getBoolean(7, false);
        setDividerDrawable(hVarP.l(5));
        this.f3032n = typedArray.getInt(8, 0);
        this.f3033o = typedArray.getDimensionPixelSize(6, 0);
        hVarP.r();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof A0;
    }

    public final void e(Canvas canvas, int i2) {
        this.f3029k.setBounds(getPaddingLeft() + this.f3033o, i2, (getWidth() - getPaddingRight()) - this.f3033o, this.f3031m + i2);
        this.f3029k.draw(canvas);
    }

    public final void f(Canvas canvas, int i2) {
        this.f3029k.setBounds(i2, getPaddingTop() + this.f3033o, this.f3030l + i2, (getHeight() - getPaddingBottom()) - this.f3033o);
        this.f3029k.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public A0 generateDefaultLayoutParams() {
        int i2 = this.f3023d;
        if (i2 == 0) {
            return new A0(-2, -2);
        }
        if (i2 == 1) {
            return new A0(-1, -2);
        }
        return null;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i2;
        if (this.f3021b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f3021b;
        if (childCount <= i3) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i3);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f3021b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f3022c;
        if (this.f3023d == 1 && (i2 = this.f3024e & 112) != 48) {
            if (i2 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f3025f) / 2;
            } else if (i2 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f3025f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((A0) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f3021b;
    }

    public Drawable getDividerDrawable() {
        return this.f3029k;
    }

    public int getDividerPadding() {
        return this.f3033o;
    }

    public int getDividerWidth() {
        return this.f3030l;
    }

    public int getGravity() {
        return this.f3024e;
    }

    public int getOrientation() {
        return this.f3023d;
    }

    public int getShowDividers() {
        return this.f3032n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public A0 generateLayoutParams(AttributeSet attributeSet) {
        return new A0(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public A0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new A0(layoutParams);
    }

    public final boolean j(int i2) {
        if (i2 == 0) {
            return (this.f3032n & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.f3032n & 4) != 0;
        }
        if ((this.f3032n & 2) == 0) {
            return false;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i2;
        int bottom;
        if (this.f3029k == null) {
            return;
        }
        int i3 = 0;
        if (this.f3023d == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i3 < virtualChildCount) {
                View childAt = getChildAt(i3);
                if (childAt != null && childAt.getVisibility() != 8 && j(i3)) {
                    e(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((A0) childAt.getLayoutParams())).topMargin) - this.f3031m);
                }
                i3++;
            }
            if (j(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                if (childAt2 == null) {
                    bottom = (getHeight() - getPaddingBottom()) - this.f3031m;
                } else {
                    bottom = childAt2.getBottom() + ((LinearLayout.LayoutParams) ((A0) childAt2.getLayoutParams())).bottomMargin;
                }
                e(canvas, bottom);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean zA = y1.a(this);
        while (i3 < virtualChildCount2) {
            View childAt3 = getChildAt(i3);
            if (childAt3 != null && childAt3.getVisibility() != 8 && j(i3)) {
                A0 a2 = (A0) childAt3.getLayoutParams();
                f(canvas, zA ? childAt3.getRight() + ((LinearLayout.LayoutParams) a2).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) a2).leftMargin) - this.f3030l);
            }
            i3++;
        }
        if (j(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                A0 a3 = (A0) childAt4.getLayoutParams();
                if (zA) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) a3).leftMargin;
                    i2 = this.f3030l;
                    right = left - i2;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) a3).rightMargin;
                }
            } else if (zA) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i2 = this.f3030l;
                right = left - i2;
            }
            f(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("j.B0");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("j.B0");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009b  */
    /* JADX WARN: Code duplicated, block: B:57:0x0153  */
    /* JADX WARN: Code duplicated, block: B:60:0x015c  */
    /* JADX WARN: Code duplicated, block: B:62:0x0160  */
    /* JADX WARN: Code duplicated, block: B:64:0x0164  */
    /* JADX WARN: Code duplicated, block: B:65:0x0167  */
    /* JADX WARN: Code duplicated, block: B:67:0x016f  */
    /* JADX WARN: Code duplicated, block: B:68:0x017d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0183  */
    /* JADX WARN: Code duplicated, block: B:71:0x018c  */
    /* JADX WARN: Code duplicated, block: B:74:0x019e  */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int paddingLeft;
        int i6;
        int i7;
        int i8;
        int i9;
        int baseline;
        int i10;
        int i11;
        int measuredHeight;
        int paddingTop;
        int i12;
        int i13;
        int i14;
        int i15 = 8;
        if (this.f3023d == 1) {
            int paddingLeft2 = getPaddingLeft();
            int i16 = i4 - i2;
            int paddingRight = i16 - getPaddingRight();
            int paddingRight2 = (i16 - paddingLeft2) - getPaddingRight();
            int virtualChildCount = getVirtualChildCount();
            int i17 = this.f3024e;
            int i18 = i17 & 112;
            int i19 = 8388615 & i17;
            if (i18 != 16) {
                paddingTop = i18 != 80 ? getPaddingTop() : ((getPaddingTop() + i5) - i3) - this.f3025f;
            } else {
                paddingTop = getPaddingTop() + (((i5 - i3) - this.f3025f) / 2);
            }
            int i20 = 0;
            while (i20 < virtualChildCount) {
                View childAt = getChildAt(i20);
                if (childAt != null && childAt.getVisibility() != i15) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    A0 a2 = (A0) childAt.getLayoutParams();
                    int i21 = ((LinearLayout.LayoutParams) a2).gravity;
                    if (i21 < 0) {
                        i21 = i19;
                    }
                    WeakHashMap weakHashMap = X.f14a;
                    int absoluteGravity = Gravity.getAbsoluteGravity(i21, H.d(this)) & 7;
                    if (absoluteGravity != 1) {
                        if (absoluteGravity != 5) {
                            i14 = ((LinearLayout.LayoutParams) a2).leftMargin + paddingLeft2;
                        } else {
                            i12 = paddingRight - measuredWidth;
                            i13 = ((LinearLayout.LayoutParams) a2).rightMargin;
                        }
                        if (j(i20)) {
                            paddingTop += this.f3031m;
                        }
                        int i22 = paddingTop + ((LinearLayout.LayoutParams) a2).topMargin;
                        childAt.layout(i14, i22, measuredWidth + i14, i22 + measuredHeight2);
                        paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) a2).bottomMargin + i22;
                    } else {
                        i12 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft2 + ((LinearLayout.LayoutParams) a2).leftMargin;
                        i13 = ((LinearLayout.LayoutParams) a2).rightMargin;
                    }
                    i14 = i12 - i13;
                    if (j(i20)) {
                        paddingTop += this.f3031m;
                    }
                    int i23 = paddingTop + ((LinearLayout.LayoutParams) a2).topMargin;
                    childAt.layout(i14, i23, measuredWidth + i14, i23 + measuredHeight2);
                    paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) a2).bottomMargin + i23;
                }
                i20++;
                i15 = 8;
            }
            return;
        }
        boolean zA = y1.a(this);
        int paddingTop2 = getPaddingTop();
        int i24 = i5 - i3;
        int paddingBottom = i24 - getPaddingBottom();
        int paddingBottom2 = (i24 - paddingTop2) - getPaddingBottom();
        int virtualChildCount2 = getVirtualChildCount();
        int i25 = this.f3024e;
        int i26 = 8388615 & i25;
        int i27 = i25 & 112;
        boolean z3 = this.f3020a;
        int[] iArr = this.f3027i;
        int[] iArr2 = this.f3028j;
        WeakHashMap weakHashMap2 = X.f14a;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i26, H.d(this));
        if (absoluteGravity2 != 1) {
            paddingLeft = absoluteGravity2 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i4) - i2) - this.f3025f;
        } else {
            paddingLeft = getPaddingLeft() + (((i4 - i2) - this.f3025f) / 2);
        }
        if (zA) {
            i7 = virtualChildCount2 - 1;
            i6 = -1;
        } else {
            i6 = 1;
            i7 = 0;
        }
        int i28 = 0;
        while (i28 < virtualChildCount2) {
            int i29 = (i6 * i28) + i7;
            View childAt2 = getChildAt(i29);
            if (childAt2 == null) {
                i6 = i6;
                i8 = virtualChildCount2;
                i27 = i27;
                i9 = 1;
            } else {
                if (childAt2.getVisibility() != 8) {
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight3 = childAt2.getMeasuredHeight();
                    A0 a3 = (A0) childAt2.getLayoutParams();
                    if (z3) {
                        i8 = virtualChildCount2;
                        baseline = ((LinearLayout.LayoutParams) a3).height != -1 ? childAt2.getBaseline() : -1;
                        i10 = ((LinearLayout.LayoutParams) a3).gravity;
                        if (i10 < 0) {
                            i10 = i27;
                        }
                        i11 = i10 & 112;
                        if (i11 != 16) {
                            measuredHeight = ((((paddingBottom2 - measuredHeight3) / 2) + paddingTop2) + ((LinearLayout.LayoutParams) a3).topMargin) - ((LinearLayout.LayoutParams) a3).bottomMargin;
                        } else if (i11 != 48) {
                            measuredHeight = ((LinearLayout.LayoutParams) a3).topMargin + paddingTop2;
                            if (baseline != -1) {
                                measuredHeight = (iArr[1] - baseline) + measuredHeight;
                            }
                        } else if (i11 != 80) {
                            measuredHeight = paddingTop2;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) a3).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                            }
                        }
                        if (j(i29)) {
                            paddingLeft += this.f3030l;
                        }
                        int i30 = paddingLeft + ((LinearLayout.LayoutParams) a3).leftMargin;
                        childAt2.layout(i30, measuredHeight, i30 + measuredWidth2, measuredHeight + measuredHeight3);
                        paddingLeft = measuredWidth2 + ((LinearLayout.LayoutParams) a3).rightMargin + i30;
                    } else {
                        i8 = virtualChildCount2;
                    }
                    i10 = ((LinearLayout.LayoutParams) a3).gravity;
                    if (i10 < 0) {
                        i10 = i27;
                    }
                    i11 = i10 & 112;
                    if (i11 != 16) {
                        measuredHeight = ((((paddingBottom2 - measuredHeight3) / 2) + paddingTop2) + ((LinearLayout.LayoutParams) a3).topMargin) - ((LinearLayout.LayoutParams) a3).bottomMargin;
                    } else if (i11 != 48) {
                        measuredHeight = ((LinearLayout.LayoutParams) a3).topMargin + paddingTop2;
                        if (baseline != -1) {
                            measuredHeight = (iArr[1] - baseline) + measuredHeight;
                        }
                    } else if (i11 != 80) {
                        measuredHeight = paddingTop2;
                    } else {
                        measuredHeight = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) a3).bottomMargin;
                        if (baseline != -1) {
                            measuredHeight -= iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                        }
                    }
                    if (j(i29)) {
                        paddingLeft += this.f3030l;
                    }
                    int i31 = paddingLeft + ((LinearLayout.LayoutParams) a3).leftMargin;
                    childAt2.layout(i31, measuredHeight, i31 + measuredWidth2, measuredHeight + measuredHeight3);
                    paddingLeft = measuredWidth2 + ((LinearLayout.LayoutParams) a3).rightMargin + i31;
                } else {
                    i8 = virtualChildCount2;
                }
                i9 = 1;
            }
            i28 += i9;
            i7 = i7;
            i6 = i6;
            virtualChildCount2 = i8;
            i27 = i27;
        }
    }

    /* JADX WARN: Code duplicated, block: B:153:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:213:0x0486  */
    /* JADX WARN: Code duplicated, block: B:214:0x048b  */
    /* JADX WARN: Code duplicated, block: B:217:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:218:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:221:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:222:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:224:0x04de  */
    /* JADX WARN: Code duplicated, block: B:230:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:240:0x0537  */
    /* JADX WARN: Code duplicated, block: B:246:0x0548  */
    /* JADX WARN: Code duplicated, block: B:249:0x0550 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:250:0x0552  */
    /* JADX WARN: Code duplicated, block: B:252:0x055b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:253:0x055d  */
    /* JADX WARN: Code duplicated, block: B:280:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:282:0x05ea  */
    /* JADX WARN: Code duplicated, block: B:283:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:286:0x05f8  */
    /* JADX WARN: Code duplicated, block: B:288:0x0600  */
    /* JADX WARN: Code duplicated, block: B:289:0x060c  */
    /* JADX WARN: Code duplicated, block: B:313:0x0691  */
    /* JADX WARN: Code duplicated, block: B:315:0x0698  */
    /* JADX WARN: Code duplicated, block: B:318:0x06b4  */
    /* JADX WARN: Code duplicated, block: B:320:0x06ba  */
    /* JADX WARN: Code duplicated, block: B:322:0x06c2  */
    /* JADX WARN: Code duplicated, block: B:368:0x07cb  */
    /* JADX WARN: Code duplicated, block: B:373:0x07f5  */
    /* JADX WARN: Code duplicated, block: B:381:0x0806  */
    /* JADX WARN: Code duplicated, block: B:388:0x083d  */
    /* JADX WARN: Code duplicated, block: B:391:0x0860  */
    /* JADX WARN: Code duplicated, block: B:393:0x086e  */
    /* JADX WARN: Code duplicated, block: B:395:0x087a  */
    /* JADX WARN: Code duplicated, block: B:397:0x0886  */
    /* JADX WARN: Code duplicated, block: B:398:0x089b  */
    /* JADX WARN: Code duplicated, block: B:429:0x061c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:437:0x089c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:442:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        char c2;
        int iMax;
        int i4;
        float f2;
        int i5;
        int i6;
        int i7;
        char c3;
        int i8;
        View childAt;
        int i9;
        int i10;
        int i11;
        int baseline;
        int i12;
        int iMakeMeasureSpec;
        int i13;
        View childAt2;
        A0 a2;
        int i14;
        View childAt3;
        A0 a3;
        float f3;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z2;
        boolean z3;
        A0 a4;
        int measuredWidth;
        boolean z4;
        int i21;
        boolean z5;
        int i22;
        int measuredHeight;
        boolean z6;
        int baseline2;
        int i23;
        int i24;
        boolean z7;
        int i25;
        int i26;
        boolean z8;
        A0 a5;
        boolean z9;
        int i27;
        boolean z10;
        int iMax2;
        int i28 = -2;
        int i29 = 1073741824;
        int i30 = 8;
        int i31 = Integer.MIN_VALUE;
        float f4 = 0.0f;
        boolean z11 = true;
        if (this.f3023d == 1) {
            this.f3025f = 0;
            int virtualChildCount = getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int i32 = this.f3021b;
            boolean z12 = this.f3026h;
            boolean z13 = true;
            int i33 = 0;
            int iMax3 = 0;
            int iMax4 = 0;
            boolean z14 = false;
            int iMax5 = 0;
            int i34 = 0;
            int i35 = 0;
            boolean z15 = false;
            float f5 = 0.0f;
            while (i33 < virtualChildCount) {
                View childAt4 = getChildAt(i33);
                if (childAt4 == null) {
                    this.f3025f = this.f3025f;
                } else {
                    if (childAt4.getVisibility() != i30) {
                        if (j(i33)) {
                            this.f3025f += this.f3031m;
                        }
                        A0 a6 = (A0) childAt4.getLayoutParams();
                        float f6 = ((LinearLayout.LayoutParams) a6).weight;
                        f5 += f6;
                        if (mode2 == i29 && ((LinearLayout.LayoutParams) a6).height == 0 && f6 > f4) {
                            int i36 = this.f3025f;
                            this.f3025f = Math.max(i36, ((LinearLayout.LayoutParams) a6).topMargin + i36 + ((LinearLayout.LayoutParams) a6).bottomMargin);
                            a5 = a6;
                            z9 = true;
                            z8 = true;
                        } else {
                            if (((LinearLayout.LayoutParams) a6).height != 0 || f6 <= f4) {
                                i26 = i31;
                            } else {
                                ((LinearLayout.LayoutParams) a6).height = i28;
                                i26 = 0;
                            }
                            int i37 = f5 == f4 ? this.f3025f : 0;
                            z8 = true;
                            a5 = a6;
                            measureChildWithMargins(childAt4, i2, 0, i3, i37);
                            if (i26 != i31) {
                                ((LinearLayout.LayoutParams) a5).height = i26;
                            }
                            int measuredHeight2 = childAt4.getMeasuredHeight();
                            int i38 = this.f3025f;
                            this.f3025f = Math.max(i38, i38 + measuredHeight2 + ((LinearLayout.LayoutParams) a5).topMargin + ((LinearLayout.LayoutParams) a5).bottomMargin);
                            int i39 = iMax5;
                            if (z12) {
                                iMax5 = Math.max(measuredHeight2, i39);
                            }
                            z9 = z14;
                        }
                        if (i32 >= 0 && i32 == i33 + 1) {
                            this.f3022c = this.f3025f;
                        }
                        if (i33 < i32 && ((LinearLayout.LayoutParams) a5).weight > 0.0f) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                        i27 = mode;
                        if (i27 == 1073741824 || ((LinearLayout.LayoutParams) a5).width != -1) {
                            z10 = false;
                        } else {
                            z10 = z8;
                            z15 = z10;
                        }
                        int i40 = ((LinearLayout.LayoutParams) a5).leftMargin + ((LinearLayout.LayoutParams) a5).rightMargin;
                        int measuredWidth2 = childAt4.getMeasuredWidth() + i40;
                        iMax2 = Math.max(i34, measuredWidth2);
                        int iCombineMeasuredStates = View.combineMeasuredStates(i35, childAt4.getMeasuredState());
                        boolean z16 = (z13 && ((LinearLayout.LayoutParams) a5).width == -1) ? z8 : false;
                        if (((LinearLayout.LayoutParams) a5).weight > 0.0f) {
                            if (!z10) {
                                i40 = measuredWidth2;
                            }
                            iMax4 = Math.max(iMax4, i40);
                        } else {
                            int i41 = iMax4;
                            if (!z10) {
                                i40 = measuredWidth2;
                            }
                            iMax3 = Math.max(iMax3, i40);
                            iMax4 = i41;
                        }
                        z14 = z9;
                        i35 = iCombineMeasuredStates;
                        z13 = z16;
                    }
                    i33++;
                    mode = i27;
                    i34 = iMax2;
                    i32 = i32;
                    z11 = z8;
                    mode2 = mode2;
                    virtualChildCount = virtualChildCount;
                    i28 = -2;
                    i29 = 1073741824;
                    i30 = 8;
                    i31 = Integer.MIN_VALUE;
                    f4 = 0.0f;
                }
                i32 = i32;
                mode2 = mode2;
                i27 = mode;
                virtualChildCount = virtualChildCount;
                iMax2 = i34;
                z8 = true;
                i33++;
                mode = i27;
                i34 = iMax2;
                i32 = i32;
                z11 = z8;
                mode2 = mode2;
                virtualChildCount = virtualChildCount;
                i28 = -2;
                i29 = 1073741824;
                i30 = 8;
                i31 = Integer.MIN_VALUE;
                f4 = 0.0f;
            }
            int i42 = mode2;
            int i43 = mode;
            int i44 = virtualChildCount;
            boolean z17 = z11;
            int iMax6 = iMax3;
            int i45 = iMax4;
            int i46 = iMax5;
            int i47 = i34;
            int iCombineMeasuredStates2 = i35;
            if (this.f3025f > 0 && j(i44)) {
                this.f3025f += this.f3031m;
            }
            int i48 = i42;
            if (z12 && (i48 == Integer.MIN_VALUE || i48 == 0)) {
                this.f3025f = 0;
                for (int i49 = 0; i49 < i44; i49++) {
                    View childAt5 = getChildAt(i49);
                    if (childAt5 == null) {
                        this.f3025f = this.f3025f;
                    } else if (childAt5.getVisibility() != 8) {
                        A0 a7 = (A0) childAt5.getLayoutParams();
                        int i50 = this.f3025f;
                        this.f3025f = Math.max(i50, i50 + i46 + ((LinearLayout.LayoutParams) a7).topMargin + ((LinearLayout.LayoutParams) a7).bottomMargin);
                    }
                }
            }
            int paddingBottom = getPaddingBottom() + getPaddingTop() + this.f3025f;
            this.f3025f = paddingBottom;
            int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i3, 0);
            int i51 = (16777215 & iResolveSizeAndState) - this.f3025f;
            if (z14 || (i51 != 0 && f5 > 0.0f)) {
                float f7 = this.g;
                if (f7 > 0.0f) {
                    f5 = f7;
                }
                this.f3025f = 0;
                int i52 = 0;
                while (i52 < i44) {
                    View childAt6 = getChildAt(i52);
                    if (childAt6.getVisibility() == 8) {
                        i23 = i48;
                    } else {
                        A0 a8 = (A0) childAt6.getLayoutParams();
                        float f8 = ((LinearLayout.LayoutParams) a8).weight;
                        if (f8 > 0.0f) {
                            int i53 = (int) ((i51 * f8) / f5);
                            f5 -= f8;
                            int i54 = i51 - i53;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + ((LinearLayout.LayoutParams) a8).leftMargin + ((LinearLayout.LayoutParams) a8).rightMargin, ((LinearLayout.LayoutParams) a8).width);
                            if (((LinearLayout.LayoutParams) a8).height == 0) {
                                i25 = 1073741824;
                                if (i48 == 1073741824) {
                                    if (i53 <= 0) {
                                        i53 = 0;
                                    }
                                    childAt6.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i53, 1073741824));
                                }
                                iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, childAt6.getMeasuredState() & (-256));
                                i51 = i54;
                            } else {
                                i25 = 1073741824;
                            }
                            int measuredHeight3 = childAt6.getMeasuredHeight() + i53;
                            if (measuredHeight3 < 0) {
                                measuredHeight3 = 0;
                            }
                            childAt6.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight3, i25));
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, childAt6.getMeasuredState() & (-256));
                            i51 = i54;
                        }
                        int i55 = ((LinearLayout.LayoutParams) a8).leftMargin + ((LinearLayout.LayoutParams) a8).rightMargin;
                        int measuredWidth3 = childAt6.getMeasuredWidth() + i55;
                        int iMax7 = Math.max(i47, measuredWidth3);
                        if (i43 != 1073741824) {
                            i23 = i48;
                            i24 = -1;
                            if (((LinearLayout.LayoutParams) a8).width != -1) {
                            }
                            iMax6 = Math.max(iMax6, i55);
                            if (z13 || ((LinearLayout.LayoutParams) a8).width != i24) {
                                z7 = false;
                            } else {
                                z7 = z17;
                            }
                            int i56 = this.f3025f;
                            this.f3025f = Math.max(i56, childAt6.getMeasuredHeight() + i56 + ((LinearLayout.LayoutParams) a8).topMargin + ((LinearLayout.LayoutParams) a8).bottomMargin);
                            z13 = z7;
                            i47 = iMax7;
                        } else {
                            i23 = i48;
                            i24 = -1;
                        }
                        i55 = measuredWidth3;
                        iMax6 = Math.max(iMax6, i55);
                        if (z13) {
                            z7 = false;
                        } else {
                            z7 = false;
                        }
                        int i57 = this.f3025f;
                        this.f3025f = Math.max(i57, childAt6.getMeasuredHeight() + i57 + ((LinearLayout.LayoutParams) a8).topMargin + ((LinearLayout.LayoutParams) a8).bottomMargin);
                        z13 = z7;
                        i47 = iMax7;
                    }
                    i52++;
                    i48 = i23;
                }
                this.f3025f = getPaddingBottom() + getPaddingTop() + this.f3025f;
            } else {
                iMax6 = Math.max(iMax6, i45);
                if (z12 && i48 != 1073741824) {
                    for (int i58 = 0; i58 < i44; i58++) {
                        View childAt7 = getChildAt(i58);
                        if (childAt7 != null && childAt7.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((A0) childAt7.getLayoutParams())).weight > 0.0f) {
                            childAt7.measure(View.MeasureSpec.makeMeasureSpec(childAt7.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i46, 1073741824));
                        }
                    }
                }
            }
            int i59 = i47;
            if (z13 || i43 == 1073741824) {
                iMax6 = i59;
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax6, getSuggestedMinimumWidth()), i2, iCombineMeasuredStates2), iResolveSizeAndState);
            if (z15) {
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                for (int i60 = 0; i60 < i44; i60++) {
                    View childAt8 = getChildAt(i60);
                    if (childAt8.getVisibility() != 8) {
                        A0 a9 = (A0) childAt8.getLayoutParams();
                        if (((LinearLayout.LayoutParams) a9).width == -1) {
                            int i61 = ((LinearLayout.LayoutParams) a9).height;
                            ((LinearLayout.LayoutParams) a9).height = childAt8.getMeasuredHeight();
                            measureChildWithMargins(childAt8, iMakeMeasureSpec2, 0, i3, 0);
                            ((LinearLayout.LayoutParams) a9).height = i61;
                        }
                    }
                }
                return;
            }
            return;
        }
        this.f3025f = 0;
        int virtualChildCount2 = getVirtualChildCount();
        int mode3 = View.MeasureSpec.getMode(i2);
        int mode4 = View.MeasureSpec.getMode(i3);
        if (this.f3027i == null || this.f3028j == null) {
            this.f3027i = new int[4];
            this.f3028j = new int[4];
        }
        int[] iArr = this.f3027i;
        int[] iArr2 = this.f3028j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z18 = this.f3020a;
        boolean z19 = this.f3026h;
        boolean z20 = mode3 == 1073741824;
        boolean z21 = true;
        int iMax8 = 0;
        float f9 = 0.0f;
        int i62 = 0;
        int i63 = 0;
        int i64 = 0;
        int iMax9 = 0;
        int iMax10 = 0;
        boolean z22 = false;
        boolean z23 = false;
        while (i63 < virtualChildCount2) {
            View childAt9 = getChildAt(i63);
            if (childAt9 == null) {
                this.f3025f = this.f3025f;
                i20 = i63;
                z2 = z19;
                z3 = z18;
            } else {
                int i65 = iMax8;
                int i66 = i62;
                if (childAt9.getVisibility() == 8) {
                    z3 = z18;
                    iMax8 = i65;
                    i62 = i66;
                    i20 = i63;
                    z2 = z19;
                } else {
                    if (j(i63)) {
                        this.f3025f += this.f3030l;
                    }
                    A0 a10 = (A0) childAt9.getLayoutParams();
                    float f10 = ((LinearLayout.LayoutParams) a10).weight;
                    float f11 = f9 + f10;
                    if (mode3 == 1073741824 && ((LinearLayout.LayoutParams) a10).width == 0 && f10 > 0.0f) {
                        if (z20) {
                            this.f3025f = ((LinearLayout.LayoutParams) a10).leftMargin + ((LinearLayout.LayoutParams) a10).rightMargin + this.f3025f;
                        } else {
                            int i67 = this.f3025f;
                            this.f3025f = Math.max(i67, ((LinearLayout.LayoutParams) a10).leftMargin + i67 + ((LinearLayout.LayoutParams) a10).rightMargin);
                        }
                        if (z18) {
                            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(0, 0);
                            childAt9.measure(iMakeMeasureSpec3, iMakeMeasureSpec3);
                            a4 = a10;
                            i17 = i65;
                            i18 = i66;
                            i20 = i63;
                            z2 = z19;
                            z3 = z18;
                        } else {
                            a4 = a10;
                            i17 = i65;
                            i18 = i66;
                            i20 = i63;
                            i21 = 1073741824;
                            z2 = z19;
                            z3 = z18;
                            z4 = true;
                        }
                        if (mode4 == i21 && ((LinearLayout.LayoutParams) a4).height == -1) {
                            z5 = true;
                            z23 = true;
                        } else {
                            z5 = false;
                        }
                        i22 = ((LinearLayout.LayoutParams) a4).topMargin + ((LinearLayout.LayoutParams) a4).bottomMargin;
                        measuredHeight = childAt9.getMeasuredHeight() + i22;
                        int iCombineMeasuredStates3 = View.combineMeasuredStates(i64, childAt9.getMeasuredState());
                        if (!z3 && (baseline2 = childAt9.getBaseline()) != -1) {
                            int i68 = ((LinearLayout.LayoutParams) a4).gravity;
                            if (i68 < 0) {
                                i68 = this.f3024e;
                            }
                            int i69 = (((i68 & 112) >> 4) & (-2)) >> 1;
                            iArr[i69] = Math.max(iArr[i69], baseline2);
                            iArr2[i69] = Math.max(iArr2[i69], measuredHeight - baseline2);
                        }
                        int iMax11 = Math.max(i18, measuredHeight);
                        if (z21 || ((LinearLayout.LayoutParams) a4).height != -1) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        if (((LinearLayout.LayoutParams) a4).weight > 0.0f) {
                            if (z5) {
                                measuredHeight = i22;
                            }
                            iMax10 = Math.max(iMax10, measuredHeight);
                            iMax8 = i17;
                        } else {
                            if (z5) {
                                measuredHeight = i22;
                            }
                            iMax8 = Math.max(i17, measuredHeight);
                        }
                        i62 = iMax11;
                        i64 = iCombineMeasuredStates3;
                        z22 = z4;
                        z21 = z6;
                        f9 = f11;
                    } else {
                        int i70 = i63;
                        if (((LinearLayout.LayoutParams) a10).width == 0) {
                            f3 = 0.0f;
                            if (f10 > 0.0f) {
                                ((LinearLayout.LayoutParams) a10).width = -2;
                                i15 = 0;
                            }
                            if (f11 == f3) {
                                i16 = this.f3025f;
                            } else {
                                i16 = 0;
                            }
                            i17 = i65;
                            i18 = i66;
                            i19 = i15;
                            i20 = i70;
                            z2 = z19;
                            z3 = z18;
                            measureChildWithMargins(childAt9, i2, i16, i3, 0);
                            if (i19 != Integer.MIN_VALUE) {
                                a4 = a10;
                                ((LinearLayout.LayoutParams) a4).width = i19;
                            } else {
                                a4 = a10;
                            }
                            measuredWidth = childAt9.getMeasuredWidth();
                            if (z20) {
                                this.f3025f = ((LinearLayout.LayoutParams) a4).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) a4).rightMargin + this.f3025f;
                            } else {
                                int i71 = this.f3025f;
                                this.f3025f = Math.max(i71, i71 + measuredWidth + ((LinearLayout.LayoutParams) a4).leftMargin + ((LinearLayout.LayoutParams) a4).rightMargin);
                            }
                            if (z2) {
                                iMax9 = Math.max(measuredWidth, iMax9);
                            }
                        } else {
                            f3 = 0.0f;
                        }
                        i15 = Integer.MIN_VALUE;
                        if (f11 == f3) {
                            i16 = this.f3025f;
                        } else {
                            i16 = 0;
                        }
                        i17 = i65;
                        i18 = i66;
                        i19 = i15;
                        i20 = i70;
                        z2 = z19;
                        z3 = z18;
                        measureChildWithMargins(childAt9, i2, i16, i3, 0);
                        if (i19 != Integer.MIN_VALUE) {
                            a4 = a10;
                            ((LinearLayout.LayoutParams) a4).width = i19;
                        } else {
                            a4 = a10;
                        }
                        measuredWidth = childAt9.getMeasuredWidth();
                        if (z20) {
                            this.f3025f = ((LinearLayout.LayoutParams) a4).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) a4).rightMargin + this.f3025f;
                        } else {
                            int i72 = this.f3025f;
                            this.f3025f = Math.max(i72, i72 + measuredWidth + ((LinearLayout.LayoutParams) a4).leftMargin + ((LinearLayout.LayoutParams) a4).rightMargin);
                        }
                        if (z2) {
                            iMax9 = Math.max(measuredWidth, iMax9);
                        }
                    }
                    z4 = z22;
                    i21 = 1073741824;
                    if (mode4 == i21) {
                        z5 = false;
                    } else {
                        z5 = false;
                    }
                    i22 = ((LinearLayout.LayoutParams) a4).topMargin + ((LinearLayout.LayoutParams) a4).bottomMargin;
                    measuredHeight = childAt9.getMeasuredHeight() + i22;
                    int iCombineMeasuredStates4 = View.combineMeasuredStates(i64, childAt9.getMeasuredState());
                    if (!z3) {
                    }
                    int iMax12 = Math.max(i18, measuredHeight);
                    if (z21) {
                        z6 = false;
                    } else {
                        z6 = false;
                    }
                    if (((LinearLayout.LayoutParams) a4).weight > 0.0f) {
                        if (z5) {
                            measuredHeight = i22;
                        }
                        iMax10 = Math.max(iMax10, measuredHeight);
                        iMax8 = i17;
                    } else {
                        if (z5) {
                            measuredHeight = i22;
                        }
                        iMax8 = Math.max(i17, measuredHeight);
                    }
                    i62 = iMax12;
                    i64 = iCombineMeasuredStates4;
                    z22 = z4;
                    z21 = z6;
                    f9 = f11;
                }
            }
            i63 = i20 + 1;
            z19 = z2;
            z18 = z3;
        }
        int i73 = i62;
        boolean z24 = z19;
        boolean z25 = z18;
        if (this.f3025f > 0 && j(virtualChildCount2)) {
            this.f3025f += this.f3030l;
        }
        int i74 = iArr[1];
        if (i74 == -1 && iArr[0] == -1 && iArr[2] == -1) {
            c2 = 3;
            if (iArr[3] == -1) {
                iMax = i73;
            }
            if (z24 && (mode3 == Integer.MIN_VALUE || mode3 == 0)) {
                this.f3025f = 0;
                for (i14 = 0; i14 < virtualChildCount2; i14++) {
                    childAt3 = getChildAt(i14);
                    if (childAt3 == null) {
                        this.f3025f = this.f3025f;
                    } else if (childAt3.getVisibility() == 8) {
                        a3 = (A0) childAt3.getLayoutParams();
                        if (z20) {
                            this.f3025f = ((LinearLayout.LayoutParams) a3).leftMargin + iMax9 + ((LinearLayout.LayoutParams) a3).rightMargin + this.f3025f;
                        } else {
                            int i75 = this.f3025f;
                            this.f3025f = Math.max(i75, i75 + iMax9 + ((LinearLayout.LayoutParams) a3).leftMargin + ((LinearLayout.LayoutParams) a3).rightMargin);
                        }
                    }
                }
            }
            int paddingRight = getPaddingRight() + getPaddingLeft() + this.f3025f;
            this.f3025f = paddingRight;
            int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i2, 0);
            i4 = (16777215 & iResolveSizeAndState2) - this.f3025f;
            if (!z22 || (i4 != 0 && f9 > 0.0f)) {
                f2 = this.g;
                if (f2 > 0.0f) {
                    f9 = f2;
                }
                iArr[3] = -1;
                iArr[2] = -1;
                iArr[1] = -1;
                iArr[0] = -1;
                iArr2[3] = -1;
                iArr2[2] = -1;
                iArr2[1] = -1;
                iArr2[0] = -1;
                this.f3025f = 0;
                int iCombineMeasuredStates5 = i64;
                iMax = -1;
                i5 = 0;
                while (i5 < virtualChildCount2) {
                    childAt = getChildAt(i5);
                    if (childAt != null || childAt.getVisibility() == 8) {
                        i9 = i4;
                        virtualChildCount2 = virtualChildCount2;
                    } else {
                        A0 a11 = (A0) childAt.getLayoutParams();
                        float f12 = ((LinearLayout.LayoutParams) a11).weight;
                        if (f12 > 0.0f) {
                            int i76 = (int) ((i4 * f12) / f9);
                            float f13 = f9 - f12;
                            int i77 = i4 - i76;
                            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + ((LinearLayout.LayoutParams) a11).topMargin + ((LinearLayout.LayoutParams) a11).bottomMargin, ((LinearLayout.LayoutParams) a11).height);
                            if (((LinearLayout.LayoutParams) a11).width == 0) {
                                i12 = 1073741824;
                                if (mode3 == 1073741824) {
                                    if (i76 <= 0) {
                                        i76 = 0;
                                    }
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i76, 1073741824), childMeasureSpec2);
                                }
                                iCombineMeasuredStates5 = View.combineMeasuredStates(iCombineMeasuredStates5, childAt.getMeasuredState() & (-16777216));
                                f9 = f13;
                                i10 = i77;
                            } else {
                                i12 = 1073741824;
                            }
                            int measuredWidth4 = childAt.getMeasuredWidth() + i76;
                            if (measuredWidth4 < 0) {
                                measuredWidth4 = 0;
                            }
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth4, i12), childMeasureSpec2);
                            iCombineMeasuredStates5 = View.combineMeasuredStates(iCombineMeasuredStates5, childAt.getMeasuredState() & (-16777216));
                            f9 = f13;
                            i10 = i77;
                        } else {
                            i10 = i4;
                        }
                        if (z20) {
                            this.f3025f = childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) a11).leftMargin + ((LinearLayout.LayoutParams) a11).rightMargin + this.f3025f;
                        } else {
                            int i78 = this.f3025f;
                            this.f3025f = Math.max(i78, childAt.getMeasuredWidth() + i78 + ((LinearLayout.LayoutParams) a11).leftMargin + ((LinearLayout.LayoutParams) a11).rightMargin);
                        }
                        boolean z26 = mode4 != 1073741824 && ((LinearLayout.LayoutParams) a11).height == -1;
                        int i79 = ((LinearLayout.LayoutParams) a11).topMargin + ((LinearLayout.LayoutParams) a11).bottomMargin;
                        int measuredHeight4 = childAt.getMeasuredHeight() + i79;
                        iMax = Math.max(iMax, measuredHeight4);
                        if (!z26) {
                            i79 = measuredHeight4;
                        }
                        iMax8 = Math.max(iMax8, i79);
                        if (z21) {
                            i11 = -1;
                            boolean z27 = ((LinearLayout.LayoutParams) a11).height == -1;
                            if (!z25 && (baseline = childAt.getBaseline()) != i11) {
                                int i80 = ((LinearLayout.LayoutParams) a11).gravity;
                                if (i80 < 0) {
                                    i80 = this.f3024e;
                                }
                                int i81 = (((i80 & 112) >> 4) & (-2)) >> 1;
                                iArr[i81] = Math.max(iArr[i81], baseline);
                                iArr2[i81] = Math.max(iArr2[i81], measuredHeight4 - baseline);
                            }
                            z21 = z27;
                            i9 = i10;
                            f9 = f9;
                        } else {
                            i11 = -1;
                        }
                        if (!z25) {
                        }
                        z21 = z27;
                        i9 = i10;
                        f9 = f9;
                    }
                    i5++;
                    i4 = i9;
                    virtualChildCount2 = virtualChildCount2;
                }
                i6 = virtualChildCount2;
                this.f3025f = getPaddingRight() + getPaddingLeft() + this.f3025f;
                i7 = iArr[1];
                if (i7 != -1 && iArr[0] == -1 && iArr[2] == -1) {
                    c3 = 3;
                    if (iArr[3] == -1) {
                        i8 = 0;
                    }
                    i64 = iCombineMeasuredStates5;
                } else {
                    c3 = 3;
                }
                i8 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c3], Math.max(iArr[0], Math.max(i7, iArr[2]))));
                i64 = iCombineMeasuredStates5;
            } else {
                iMax8 = Math.max(iMax8, iMax10);
                if (z24 && mode3 != 1073741824) {
                    for (int i82 = 0; i82 < virtualChildCount2; i82++) {
                        View childAt10 = getChildAt(i82);
                        if (childAt10 != null && childAt10.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((A0) childAt10.getLayoutParams())).weight > 0.0f) {
                            childAt10.measure(View.MeasureSpec.makeMeasureSpec(iMax9, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt10.getMeasuredHeight(), 1073741824));
                        }
                    }
                }
                i6 = virtualChildCount2;
                i8 = 0;
            }
            if (z21 || mode4 == 1073741824) {
                iMax8 = iMax;
            }
            setMeasuredDimension((i64 & (-16777216)) | iResolveSizeAndState2, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax8, getSuggestedMinimumHeight()), i3, i64 << 16));
            if (z23) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
                i13 = i6;
                while (i8 < i13) {
                    childAt2 = getChildAt(i8);
                    if (childAt2.getVisibility() != 8) {
                        a2 = (A0) childAt2.getLayoutParams();
                        if (((LinearLayout.LayoutParams) a2).height == -1) {
                            int i83 = ((LinearLayout.LayoutParams) a2).width;
                            ((LinearLayout.LayoutParams) a2).width = childAt2.getMeasuredWidth();
                            measureChildWithMargins(childAt2, i2, 0, iMakeMeasureSpec, 0);
                            ((LinearLayout.LayoutParams) a2).width = i83;
                        }
                    }
                    i8++;
                }
            }
        }
        c2 = 3;
        iMax = Math.max(i73, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(i74, iArr[2]))));
        if (z24) {
            this.f3025f = 0;
            while (i14 < virtualChildCount2) {
                childAt3 = getChildAt(i14);
                if (childAt3 == null) {
                    this.f3025f = this.f3025f;
                } else if (childAt3.getVisibility() == 8) {
                    a3 = (A0) childAt3.getLayoutParams();
                    if (z20) {
                        this.f3025f = ((LinearLayout.LayoutParams) a3).leftMargin + iMax9 + ((LinearLayout.LayoutParams) a3).rightMargin + this.f3025f;
                    } else {
                        int i710 = this.f3025f;
                        this.f3025f = Math.max(i710, i710 + iMax9 + ((LinearLayout.LayoutParams) a3).leftMargin + ((LinearLayout.LayoutParams) a3).rightMargin);
                    }
                }
            }
        }
        int paddingRight2 = getPaddingRight() + getPaddingLeft() + this.f3025f;
        this.f3025f = paddingRight2;
        int iResolveSizeAndState3 = View.resolveSizeAndState(Math.max(paddingRight2, getSuggestedMinimumWidth()), i2, 0);
        i4 = (16777215 & iResolveSizeAndState3) - this.f3025f;
        if (z22) {
            f2 = this.g;
            if (f2 > 0.0f) {
                f9 = f2;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f3025f = 0;
            int iCombineMeasuredStates6 = i64;
            iMax = -1;
            i5 = 0;
            while (i5 < virtualChildCount2) {
                childAt = getChildAt(i5);
                if (childAt != null) {
                    i9 = i4;
                    virtualChildCount2 = virtualChildCount2;
                } else {
                    i9 = i4;
                    virtualChildCount2 = virtualChildCount2;
                }
                i5++;
                i4 = i9;
                virtualChildCount2 = virtualChildCount2;
            }
            i6 = virtualChildCount2;
            this.f3025f = getPaddingRight() + getPaddingLeft() + this.f3025f;
            i7 = iArr[1];
            if (i7 != -1) {
                c3 = 3;
                i8 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c3], Math.max(iArr[0], Math.max(i7, iArr[2]))));
            } else {
                c3 = 3;
                i8 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c3], Math.max(iArr[0], Math.max(i7, iArr[2]))));
            }
            i64 = iCombineMeasuredStates6;
        } else {
            f2 = this.g;
            if (f2 > 0.0f) {
                f9 = f2;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f3025f = 0;
            int iCombineMeasuredStates7 = i64;
            iMax = -1;
            i5 = 0;
            while (i5 < virtualChildCount2) {
                childAt = getChildAt(i5);
                if (childAt != null) {
                    i9 = i4;
                    virtualChildCount2 = virtualChildCount2;
                } else {
                    i9 = i4;
                    virtualChildCount2 = virtualChildCount2;
                }
                i5++;
                i4 = i9;
                virtualChildCount2 = virtualChildCount2;
            }
            i6 = virtualChildCount2;
            this.f3025f = getPaddingRight() + getPaddingLeft() + this.f3025f;
            i7 = iArr[1];
            if (i7 != -1) {
                c3 = 3;
                i8 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c3], Math.max(iArr[0], Math.max(i7, iArr[2]))));
            } else {
                c3 = 3;
                i8 = 0;
                iMax = Math.max(iMax, Math.max(iArr2[c3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c3], Math.max(iArr[0], Math.max(i7, iArr[2]))));
            }
            i64 = iCombineMeasuredStates7;
        }
        if (z21) {
            iMax8 = iMax;
        } else {
            iMax8 = iMax;
        }
        setMeasuredDimension((i64 & (-16777216)) | iResolveSizeAndState3, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax8, getSuggestedMinimumHeight()), i3, i64 << 16));
        if (z23) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            i13 = i6;
            while (i8 < i13) {
                childAt2 = getChildAt(i8);
                if (childAt2.getVisibility() != 8) {
                    a2 = (A0) childAt2.getLayoutParams();
                    if (((LinearLayout.LayoutParams) a2).height == -1) {
                        int i84 = ((LinearLayout.LayoutParams) a2).width;
                        ((LinearLayout.LayoutParams) a2).width = childAt2.getMeasuredWidth();
                        measureChildWithMargins(childAt2, i2, 0, iMakeMeasureSpec, 0);
                        ((LinearLayout.LayoutParams) a2).width = i84;
                    }
                }
                i8++;
            }
        }
    }

    public void setBaselineAligned(boolean z2) {
        this.f3020a = z2;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 >= 0 && i2 < getChildCount()) {
            this.f3021b = i2;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f3029k) {
            return;
        }
        this.f3029k = drawable;
        if (drawable != null) {
            this.f3030l = drawable.getIntrinsicWidth();
            this.f3031m = drawable.getIntrinsicHeight();
        } else {
            this.f3030l = 0;
            this.f3031m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i2) {
        this.f3033o = i2;
    }

    public void setGravity(int i2) {
        if (this.f3024e != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f3024e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f3024e;
        if ((8388615 & i4) != i3) {
            this.f3024e = i3 | ((-8388616) & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z2) {
        this.f3026h = z2;
    }

    public void setOrientation(int i2) {
        if (this.f3023d != i2) {
            this.f3023d = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.f3032n) {
            requestLayout();
        }
        this.f3032n = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.f3024e;
        if ((i4 & 112) != i3) {
            this.f3024e = i3 | (i4 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.g = Math.max(0.0f, f2);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
