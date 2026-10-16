// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: j.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0157l0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final RectF f3229l = new RectF();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap f3230m = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3231a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3232b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3233c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3234d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3235e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f3236f = new int[0];
    public boolean g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextPaint f3237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f3238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f3239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0151i0 f3240k;

    static {
        new ConcurrentHashMap();
    }

    public C0157l0(TextView textView) {
        this.f3238i = textView;
        this.f3239j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f3240k = new C0153j0();
        } else {
            this.f3240k = new C0151i0();
        }
    }

    public static int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    public static Method d(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f3230m;
            Method declaredMethod = (Method) concurrentHashMap.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, null)) != null) {
                declaredMethod.setAccessible(true);
                concurrentHashMap.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    public static Object e(Object obj, String str, Object obj2) {
        try {
            return d(str).invoke(obj, null);
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e2);
            return obj2;
        }
    }

    public final void a() {
        if (f()) {
            if (this.f3232b) {
                if (this.f3238i.getMeasuredHeight() <= 0 || this.f3238i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f3240k.b(this.f3238i) ? 1048576 : (this.f3238i.getMeasuredWidth() - this.f3238i.getTotalPaddingLeft()) - this.f3238i.getTotalPaddingRight();
                int height = (this.f3238i.getHeight() - this.f3238i.getCompoundPaddingBottom()) - this.f3238i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f3229l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fC = c(rectF);
                        if (fC != this.f3238i.getTextSize()) {
                            g(0, fC);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            this.f3232b = true;
        }
    }

    public final int c(RectF rectF) {
        CharSequence transformation;
        int length = this.f3236f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i2 = length - 1;
        int i3 = 0;
        int i4 = 1;
        while (i4 <= i2) {
            int i5 = (i4 + i2) / 2;
            int i6 = this.f3236f[i5];
            TextView textView = this.f3238i;
            CharSequence text = textView.getText();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, textView)) != null) {
                text = transformation;
            }
            int iB = AbstractC0145f0.b(textView);
            TextPaint textPaint = this.f3237h;
            if (textPaint == null) {
                this.f3237h = new TextPaint();
            } else {
                textPaint.reset();
            }
            this.f3237h.set(textView.getPaint());
            this.f3237h.setTextSize(i6);
            StaticLayout staticLayoutA = AbstractC0149h0.a(text, (Layout.Alignment) e(textView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), iB, this.f3238i, this.f3237h, this.f3240k);
            if ((iB == -1 || (staticLayoutA.getLineCount() <= iB && staticLayoutA.getLineEnd(staticLayoutA.getLineCount() - 1) == text.length())) && staticLayoutA.getHeight() <= rectF.bottom) {
                int i7 = i5 + 1;
                i3 = i4;
                i4 = i7;
            } else {
                i3 = i5 - 1;
                i2 = i3;
            }
        }
        return this.f3236f[i3];
    }

    public final boolean f() {
        return j() && this.f3231a != 0;
    }

    public final void g(int i2, float f2) {
        Context context = this.f3239j;
        float fApplyDimension = TypedValue.applyDimension(i2, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        TextView textView = this.f3238i;
        if (fApplyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(fApplyDimension);
            boolean zA = AbstractC0147g0.a(textView);
            if (textView.getLayout() != null) {
                this.f3232b = false;
                try {
                    Method methodD = d("nullLayouts");
                    if (methodD != null) {
                        methodD.invoke(textView, null);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (zA) {
                    textView.forceLayout();
                } else {
                    textView.requestLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean h() {
        if (j() && this.f3231a == 1) {
            if (!this.g || this.f3236f.length == 0) {
                int iFloor = ((int) Math.floor((this.f3235e - this.f3234d) / this.f3233c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i2 = 0; i2 < iFloor; i2++) {
                    iArr[i2] = Math.round((i2 * this.f3233c) + this.f3234d);
                }
                this.f3236f = b(iArr);
            }
            this.f3232b = true;
        } else {
            this.f3232b = false;
        }
        return this.f3232b;
    }

    public final boolean i() {
        int[] iArr = this.f3236f;
        int length = iArr.length;
        boolean z2 = length > 0;
        this.g = z2;
        if (z2) {
            this.f3231a = 1;
            this.f3234d = iArr[0];
            this.f3235e = iArr[length - 1];
            this.f3233c = -1.0f;
        }
        return z2;
    }

    public final boolean j() {
        return !(this.f3238i instanceof C0175v);
    }

    public final void k(float f2, float f3, float f4) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        }
        if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        }
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
        this.f3231a = 1;
        this.f3234d = f2;
        this.f3235e = f3;
        this.f3233c = f4;
        this.g = false;
    }
}
