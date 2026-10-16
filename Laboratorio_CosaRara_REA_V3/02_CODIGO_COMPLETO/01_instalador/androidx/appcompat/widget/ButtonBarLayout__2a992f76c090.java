// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.widget;

import A.G;
import A.X;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1366c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1366c = -1;
        int[] iArr = p007e.a.f2235k;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        X.g(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0);
        this.f1364a = typedArrayObtainStyledAttributes.getBoolean(0, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f1364a);
        }
    }

    private void setStacked(boolean z2) {
        if (this.f1365b != z2) {
            if (!z2 || this.f1364a) {
                this.f1365b = z2;
                setOrientation(z2 ? 1 : 0);
                setGravity(z2 ? 8388613 : 80);
                View viewFindViewById = findViewById(R.id.spacer);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z2 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        int iMakeMeasureSpec;
        boolean z2;
        int i4;
        int size = View.MeasureSpec.getSize(i2);
        int paddingBottom = 0;
        if (this.f1364a) {
            if (size > this.f1366c && this.f1365b) {
                setStacked(false);
            }
            this.f1366c = size;
        }
        if (this.f1365b || View.MeasureSpec.getMode(i2) != 1073741824) {
            iMakeMeasureSpec = i2;
            z2 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z2 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i3);
        if (this.f1364a && !this.f1365b && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z2 = true;
        }
        if (z2) {
            super.onMeasure(i2, i3);
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            i4 = -1;
            if (i5 >= childCount) {
                i5 = -1;
                break;
            } else if (getChildAt(i5).getVisibility() == 0) {
                break;
            } else {
                i5++;
            }
        }
        if (i5 >= 0) {
            View childAt = getChildAt(i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f1365b) {
                int childCount2 = getChildCount();
                for (int i6 = i5 + 1; i6 < childCount2; i6++) {
                    if (getChildAt(i6).getVisibility() == 0) {
                        i4 = i6;
                        break;
                    }
                }
                paddingBottom = i4 >= 0 ? getChildAt(i4).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight : measuredHeight;
            } else {
                paddingBottom = getPaddingBottom() + measuredHeight;
            }
        }
        WeakHashMap weakHashMap = X.f14a;
        if (G.d(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i3 == 0) {
                super.onMeasure(i2, i3);
            }
        }
    }

    public void setAllowStacking(boolean z2) {
        if (this.f1364a != z2) {
            this.f1364a = z2;
            if (!z2 && this.f1365b) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
