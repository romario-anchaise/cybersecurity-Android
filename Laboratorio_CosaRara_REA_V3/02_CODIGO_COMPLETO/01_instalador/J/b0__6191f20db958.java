// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.X;
import C.b;
import C.c;
import C.h;
import D.s;
import X0.C0062i;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import f1.d;
import f1.l;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p007e.a;

/* JADX INFO: renamed from: j.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0137b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f3140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0062i f3141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0062i f3142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0062i f3143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0062i f3144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0062i f3145f;
    public C0062i g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C0062i f3146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C0157l0 f3147i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3148j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3149k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Typeface f3150l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3151m;

    public C0137b0(TextView textView) {
        this.f3140a = textView;
        this.f3147i = new C0157l0(textView);
    }

    public static C0062i c(Context context, C0171t c0171t, int i2) {
        ColorStateList colorStateListF;
        synchronized (c0171t) {
            colorStateListF = c0171t.f3302a.f(context, i2);
        }
        if (colorStateListF == null) {
            return null;
        }
        C0062i c0062i = new C0062i();
        c0062i.f984b = true;
        c0062i.f985c = colorStateListF;
        return c0062i;
    }

    public static void h(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i2 >= 30) {
            b.a(editorInfo, text);
            return;
        }
        text.getClass();
        if (i2 >= 30) {
            b.a(editorInfo, text);
            return;
        }
        int i3 = editorInfo.initialSelStart;
        int i4 = editorInfo.initialSelEnd;
        int i5 = i3 > i4 ? i4 : i3;
        if (i3 <= i4) {
            i3 = i4;
        }
        int length = text.length();
        if (i5 < 0 || i3 > length) {
            c.a(editorInfo, null, 0, 0);
            return;
        }
        int i6 = editorInfo.inputType & 4095;
        if (i6 == 129 || i6 == 225 || i6 == 18) {
            c.a(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            c.a(editorInfo, text, i5, i3);
            return;
        }
        int i7 = i3 - i5;
        int i8 = i7 > 1024 ? 0 : i7;
        int i9 = 2048 - i8;
        int iMin = Math.min(text.length() - i3, i9 - Math.min(i5, (int) (((double) i9) * 0.8d)));
        int iMin2 = Math.min(i5, i9 - iMin);
        int i10 = i5 - iMin2;
        if (Character.isLowSurrogate(text.charAt(i10))) {
            i10++;
            iMin2--;
        }
        if (Character.isHighSurrogate(text.charAt((i3 + iMin) - 1))) {
            iMin--;
        }
        int i11 = iMin2 + i8;
        c.a(editorInfo, i8 != i7 ? TextUtils.concat(text.subSequence(i10, i10 + iMin2), text.subSequence(i3, iMin + i3)) : text.subSequence(i10, i11 + iMin + i10), iMin2, i11);
    }

    public final void a(Drawable drawable, C0062i c0062i) {
        if (drawable == null || c0062i == null) {
            return;
        }
        C0171t.d(drawable, c0062i, this.f3140a.getDrawableState());
    }

    public final void b() {
        C0062i c0062i = this.f3141b;
        TextView textView = this.f3140a;
        if (c0062i != null || this.f3142c != null || this.f3143d != null || this.f3144e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f3141b);
            a(compoundDrawables[1], this.f3142c);
            a(compoundDrawables[2], this.f3143d);
            a(compoundDrawables[3], this.f3144e);
        }
        if (this.f3145f == null && this.g == null) {
            return;
        }
        Drawable[] drawableArrA = X.a(textView);
        a(drawableArrA[0], this.f3145f);
        a(drawableArrA[2], this.g);
    }

    public final ColorStateList d() {
        C0062i c0062i = this.f3146h;
        if (c0062i != null) {
            return (ColorStateList) c0062i.f985c;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        C0062i c0062i = this.f3146h;
        if (c0062i != null) {
            return (PorterDuff.Mode) c0062i.f986d;
        }
        return null;
    }

    public final void f(AttributeSet attributeSet, int i2) {
        boolean z2;
        boolean z3;
        String string;
        String string2;
        boolean z4;
        int i3;
        ColorStateList colorStateList;
        int resourceId;
        int i4;
        int resourceId2;
        TextView textView = this.f3140a;
        Context context = textView.getContext();
        C0171t c0171tA = C0171t.a();
        int[] iArr = a.f2232h;
        h hVarP = h.p(context, attributeSet, iArr, i2);
        X.g(textView, textView.getContext(), iArr, attributeSet, (TypedArray) hVarP.f112b, i2);
        TypedArray typedArray = (TypedArray) hVarP.f112b;
        int resourceId3 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.f3141b = c(context, c0171tA, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.f3142c = c(context, c0171tA, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.f3143d = c(context, c0171tA, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.f3144e = c(context, c0171tA, typedArray.getResourceId(2, 0));
        }
        int i5 = Build.VERSION.SDK_INT;
        if (typedArray.hasValue(5)) {
            this.f3145f = c(context, c0171tA, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.g = c(context, c0171tA, typedArray.getResourceId(6, 0));
        }
        hVarP.r();
        boolean z5 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = a.f2247w;
        if (resourceId3 != -1) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId3, iArr2);
            h hVar = new h(context, typedArrayObtainStyledAttributes);
            if (z5 || !typedArrayObtainStyledAttributes.hasValue(14)) {
                z2 = false;
                z3 = false;
            } else {
                z2 = typedArrayObtainStyledAttributes.getBoolean(14, false);
                z3 = true;
            }
            n(context, hVar);
            string2 = typedArrayObtainStyledAttributes.hasValue(15) ? typedArrayObtainStyledAttributes.getString(15) : null;
            string = (i5 < 26 || !typedArrayObtainStyledAttributes.hasValue(13)) ? null : typedArrayObtainStyledAttributes.getString(13);
            hVar.r();
        } else {
            z2 = false;
            z3 = false;
            string = null;
            string2 = null;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i2, 0);
        h hVar2 = new h(context, typedArrayObtainStyledAttributes2);
        if (z5 || !typedArrayObtainStyledAttributes2.hasValue(14)) {
            z4 = z2;
        } else {
            z4 = typedArrayObtainStyledAttributes2.getBoolean(14, false);
            z3 = true;
        }
        if (typedArrayObtainStyledAttributes2.hasValue(15)) {
            string2 = typedArrayObtainStyledAttributes2.getString(15);
        }
        if (i5 >= 26 && typedArrayObtainStyledAttributes2.hasValue(13)) {
            string = typedArrayObtainStyledAttributes2.getString(13);
        }
        if (i5 >= 28 && typedArrayObtainStyledAttributes2.hasValue(0) && typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, hVar2);
        hVar2.r();
        if (!z5 && z3) {
            textView.setAllCaps(z4);
        }
        Typeface typeface = this.f3150l;
        if (typeface != null) {
            if (this.f3149k == -1) {
                textView.setTypeface(typeface, this.f3148j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (string != null) {
            Z.d(textView, string);
        }
        if (string2 != null) {
            Y.b(textView, Y.a(string2));
        }
        int[] iArr3 = a.f2233i;
        C0157l0 c0157l0 = this.f3147i;
        Context context2 = c0157l0.f3239j;
        TypedArray typedArrayObtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr3, i2, 0);
        TextView textView2 = c0157l0.f3238i;
        X.g(textView2, textView2.getContext(), iArr3, attributeSet, typedArrayObtainStyledAttributes3, i2);
        if (typedArrayObtainStyledAttributes3.hasValue(5)) {
            c0157l0.f3231a = typedArrayObtainStyledAttributes3.getInt(5, 0);
        }
        float dimension = typedArrayObtainStyledAttributes3.hasValue(4) ? typedArrayObtainStyledAttributes3.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes3.hasValue(2) ? typedArrayObtainStyledAttributes3.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes3.hasValue(1) ? typedArrayObtainStyledAttributes3.getDimension(1, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes3.hasValue(3) && (resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(3, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = typedArrayObtainTypedArray.length();
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i6 = 0; i6 < length; i6++) {
                    iArr4[i6] = typedArrayObtainTypedArray.getDimensionPixelSize(i6, -1);
                }
                c0157l0.f3236f = C0157l0.b(iArr4);
                c0157l0.i();
            }
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes3.recycle();
        if (!c0157l0.j()) {
            c0157l0.f3231a = 0;
        } else if (c0157l0.f3231a == 1) {
            if (!c0157l0.g) {
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    i4 = 2;
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                } else {
                    i4 = 2;
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(i4, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                c0157l0.k(dimension2, dimension3, dimension);
            }
            c0157l0.h();
        }
        if (y1.f3355b && c0157l0.f3231a != 0) {
            int[] iArr5 = c0157l0.f3236f;
            if (iArr5.length > 0) {
                if (Z.a(textView) != -1.0f) {
                    Z.b(textView, Math.round(c0157l0.f3234d), Math.round(c0157l0.f3235e), Math.round(c0157l0.f3233c), 0);
                } else {
                    Z.c(textView, iArr5, 0);
                }
            }
        }
        TypedArray typedArrayObtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr3);
        int resourceId4 = typedArrayObtainStyledAttributes4.getResourceId(8, -1);
        Drawable drawableB = resourceId4 != -1 ? c0171tA.b(context, resourceId4) : null;
        int resourceId5 = typedArrayObtainStyledAttributes4.getResourceId(13, -1);
        Drawable drawableB2 = resourceId5 != -1 ? c0171tA.b(context, resourceId5) : null;
        int resourceId6 = typedArrayObtainStyledAttributes4.getResourceId(9, -1);
        Drawable drawableB3 = resourceId6 != -1 ? c0171tA.b(context, resourceId6) : null;
        int resourceId7 = typedArrayObtainStyledAttributes4.getResourceId(6, -1);
        Drawable drawableB4 = resourceId7 != -1 ? c0171tA.b(context, resourceId7) : null;
        int resourceId8 = typedArrayObtainStyledAttributes4.getResourceId(10, -1);
        Drawable drawableB5 = resourceId8 != -1 ? c0171tA.b(context, resourceId8) : null;
        int resourceId9 = typedArrayObtainStyledAttributes4.getResourceId(7, -1);
        Drawable drawableB6 = resourceId9 != -1 ? c0171tA.b(context, resourceId9) : null;
        if (drawableB5 != null || drawableB6 != null) {
            Drawable[] drawableArrA = X.a(textView);
            if (drawableB5 == null) {
                drawableB5 = drawableArrA[0];
            }
            if (drawableB2 == null) {
                drawableB2 = drawableArrA[1];
            }
            if (drawableB6 == null) {
                drawableB6 = drawableArrA[2];
            }
            if (drawableB4 == null) {
                drawableB4 = drawableArrA[3];
            }
            X.b(textView, drawableB5, drawableB2, drawableB6, drawableB4);
        } else if (drawableB != null || drawableB2 != null || drawableB3 != null || drawableB4 != null) {
            Drawable[] drawableArrA2 = X.a(textView);
            Drawable drawable = drawableArrA2[0];
            if (drawable == null && drawableArrA2[2] == null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (drawableB == null) {
                    drawableB = compoundDrawables[0];
                }
                if (drawableB2 == null) {
                    drawableB2 = compoundDrawables[1];
                }
                if (drawableB3 == null) {
                    drawableB3 = compoundDrawables[2];
                }
                if (drawableB4 == null) {
                    drawableB4 = compoundDrawables[3];
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawableB, drawableB2, drawableB3, drawableB4);
            } else {
                if (drawableB2 == null) {
                    drawableB2 = drawableArrA2[1];
                }
                Drawable drawable2 = drawableArrA2[2];
                if (drawableB4 == null) {
                    drawableB4 = drawableArrA2[3];
                }
                X.b(textView, drawable, drawableB2, drawable2, drawableB4);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(11)) {
            if (!typedArrayObtainStyledAttributes4.hasValue(11) || (resourceId = typedArrayObtainStyledAttributes4.getResourceId(11, 0)) == 0 || (colorStateList = l.y(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes4.getColorStateList(11);
            }
            s.f(textView, colorStateList);
        }
        if (typedArrayObtainStyledAttributes4.hasValue(12)) {
            i3 = -1;
            s.g(textView, AbstractC0167q0.b(typedArrayObtainStyledAttributes4.getInt(12, -1), null));
        } else {
            i3 = -1;
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes4.getDimensionPixelSize(15, i3);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(18, i3);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(19, i3);
        typedArrayObtainStyledAttributes4.recycle();
        if (dimensionPixelSize != i3) {
            d.x(textView, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != i3) {
            d.y(textView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != i3) {
            if (dimensionPixelSize3 < 0) {
                throw new IllegalArgumentException();
            }
            int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
            if (dimensionPixelSize3 != fontMetricsInt) {
                textView.setLineSpacing(dimensionPixelSize3 - fontMetricsInt, 1.0f);
            }
        }
    }

    public final void g(Context context, int i2) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, a.f2247w);
        h hVar = new h(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.f3140a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, hVar);
        if (i3 >= 26 && typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            Z.d(textView, string);
        }
        hVar.r();
        Typeface typeface = this.f3150l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f3148j);
        }
    }

    public final void i(int i2, int i3, int i4, int i5) {
        C0157l0 c0157l0 = this.f3147i;
        if (c0157l0.j()) {
            DisplayMetrics displayMetrics = c0157l0.f3239j.getResources().getDisplayMetrics();
            c0157l0.k(TypedValue.applyDimension(i5, i2, displayMetrics), TypedValue.applyDimension(i5, i3, displayMetrics), TypedValue.applyDimension(i5, i4, displayMetrics));
            if (c0157l0.h()) {
                c0157l0.a();
            }
        }
    }

    public final void j(int[] iArr, int i2) {
        C0157l0 c0157l0 = this.f3147i;
        if (c0157l0.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i2 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = c0157l0.f3239j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArrCopyOf[i3] = Math.round(TypedValue.applyDimension(i2, iArr[i3], displayMetrics));
                    }
                }
                c0157l0.f3236f = C0157l0.b(iArrCopyOf);
                if (!c0157l0.i()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                c0157l0.g = false;
            }
            if (c0157l0.h()) {
                c0157l0.a();
            }
        }
    }

    public final void k(int i2) {
        C0157l0 c0157l0 = this.f3147i;
        if (c0157l0.j()) {
            if (i2 == 0) {
                c0157l0.f3231a = 0;
                c0157l0.f3234d = -1.0f;
                c0157l0.f3235e = -1.0f;
                c0157l0.f3233c = -1.0f;
                c0157l0.f3236f = new int[0];
                c0157l0.f3232b = false;
                return;
            }
            if (i2 != 1) {
                throw new IllegalArgumentException(F0.h.b(i2, "Unknown auto-size text type: "));
            }
            DisplayMetrics displayMetrics = c0157l0.f3239j.getResources().getDisplayMetrics();
            c0157l0.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (c0157l0.h()) {
                c0157l0.a();
            }
        }
    }

    public final void l(ColorStateList colorStateList) {
        if (this.f3146h == null) {
            this.f3146h = new C0062i();
        }
        C0062i c0062i = this.f3146h;
        c0062i.f985c = colorStateList;
        c0062i.f984b = colorStateList != null;
        this.f3141b = c0062i;
        this.f3142c = c0062i;
        this.f3143d = c0062i;
        this.f3144e = c0062i;
        this.f3145f = c0062i;
        this.g = c0062i;
    }

    public final void m(PorterDuff.Mode mode) {
        if (this.f3146h == null) {
            this.f3146h = new C0062i();
        }
        C0062i c0062i = this.f3146h;
        c0062i.f986d = mode;
        c0062i.f983a = mode != null;
        this.f3141b = c0062i;
        this.f3142c = c0062i;
        this.f3143d = c0062i;
        this.f3144e = c0062i;
        this.f3145f = c0062i;
        this.g = c0062i;
    }

    public final void n(Context context, h hVar) {
        String string;
        int i2 = this.f3148j;
        TypedArray typedArray = (TypedArray) hVar.f112b;
        this.f3148j = typedArray.getInt(2, i2);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            int i4 = typedArray.getInt(11, -1);
            this.f3149k = i4;
            if (i4 != -1) {
                this.f3148j &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f3151m = false;
                int i5 = typedArray.getInt(1, 1);
                if (i5 == 1) {
                    this.f3150l = Typeface.SANS_SERIF;
                    return;
                } else if (i5 == 2) {
                    this.f3150l = Typeface.SERIF;
                    return;
                } else {
                    if (i5 != 3) {
                        return;
                    }
                    this.f3150l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f3150l = null;
        int i6 = typedArray.hasValue(12) ? 12 : 10;
        int i7 = this.f3149k;
        int i8 = this.f3148j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceN = hVar.n(i6, this.f3148j, new V(this, i7, i8, new WeakReference(this.f3140a)));
                if (typefaceN != null) {
                    if (i3 < 28 || this.f3149k == -1) {
                        this.f3150l = typefaceN;
                    } else {
                        this.f3150l = AbstractC0135a0.a(Typeface.create(typefaceN, 0), this.f3149k, (this.f3148j & 2) != 0);
                    }
                }
                this.f3151m = this.f3150l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f3150l != null || (string = typedArray.getString(i6)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f3149k == -1) {
            this.f3150l = Typeface.create(string, this.f3148j);
        } else {
            this.f3150l = AbstractC0135a0.a(Typeface.create(string, 0), this.f3149k, (this.f3148j & 2) != 0);
        }
    }
}
