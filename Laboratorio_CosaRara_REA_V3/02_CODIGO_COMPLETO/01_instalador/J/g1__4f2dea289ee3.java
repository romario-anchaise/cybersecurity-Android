// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import f1.l;
import p007e.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f3193a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f3194b = {-16842910};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f3195c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f3196d = {R.attr.state_pressed};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f3197e = {R.attr.state_checked};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f3198f = new int[0];
    public static final int[] g = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(a.f2234j);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(117)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i2) {
        ColorStateList colorStateListD = d(context, i2);
        if (colorStateListD != null && colorStateListD.isStateful()) {
            return colorStateListD.getColorForState(f3194b, colorStateListD.getDefaultColor());
        }
        ThreadLocal threadLocal = f3193a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f2 = typedValue.getFloat();
        int iC = c(context, i2);
        int iRound = Math.round(Color.alpha(iC) * f2);
        int i3 = p033t.a.f4101a;
        if (iRound < 0 || iRound > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (iC & 16777215) | (iRound << 24);
    }

    public static int c(Context context, int i2) {
        int[] iArr = g;
        iArr[0] = i2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return typedArrayObtainStyledAttributes.getColor(0, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList d(Context context, int i2) {
        ColorStateList colorStateList;
        int resourceId;
        int[] iArr = g;
        iArr[0] = i2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = l.y(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
