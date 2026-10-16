// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.H;
import A.X;
import C.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.o2s2m.gae1fc3b2uc0u.R;
import p007e.a;
import p035u.b;
import p035u.c;

/* JADX INFO: loaded from: classes.dex */
public final class G extends B {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final F f3044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f3045f;
    public ColorStateList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f3046h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3047i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3048j;

    public G(F f2) {
        super(f2);
        this.g = null;
        this.f3046h = null;
        this.f3047i = false;
        this.f3048j = false;
        this.f3044e = f2;
    }

    @Override // p015j.B
    public final void b(AttributeSet attributeSet, int i2) {
        super.b(attributeSet, R.attr.seekBarStyle);
        F f2 = this.f3044e;
        Context context = f2.getContext();
        int[] iArr = a.g;
        h hVarP = h.p(context, attributeSet, iArr, R.attr.seekBarStyle);
        X.g(f2, f2.getContext(), iArr, attributeSet, (TypedArray) hVarP.f112b, R.attr.seekBarStyle);
        Drawable drawableM = hVarP.m(0);
        if (drawableM != null) {
            f2.setThumb(drawableM);
        }
        Drawable drawableL = hVarP.l(1);
        Drawable drawable = this.f3045f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f3045f = drawableL;
        if (drawableL != null) {
            drawableL.setCallback(f2);
            c.b(drawableL, H.d(f2));
            if (drawableL.isStateful()) {
                drawableL.setState(f2.getDrawableState());
            }
            f();
        }
        f2.invalidate();
        TypedArray typedArray = (TypedArray) hVarP.f112b;
        if (typedArray.hasValue(3)) {
            this.f3046h = AbstractC0167q0.b(typedArray.getInt(3, -1), this.f3046h);
            this.f3048j = true;
        }
        if (typedArray.hasValue(2)) {
            this.g = hVarP.k(2);
            this.f3047i = true;
        }
        hVarP.r();
        f();
    }

    public final void f() {
        Drawable drawable = this.f3045f;
        if (drawable != null) {
            if (this.f3047i || this.f3048j) {
                Drawable drawableMutate = drawable.mutate();
                this.f3045f = drawableMutate;
                if (this.f3047i) {
                    b.h(drawableMutate, this.g);
                }
                if (this.f3048j) {
                    b.i(this.f3045f, this.f3046h);
                }
                if (this.f3045f.isStateful()) {
                    this.f3045f.setState(this.f3044e.getDrawableState());
                }
            }
        }
    }

    public final void g(Canvas canvas) {
        if (this.f3045f != null) {
            F f2 = this.f3044e;
            int max = f2.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f3045f.getIntrinsicWidth();
                int intrinsicHeight = this.f3045f.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i3 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f3045f.setBounds(-i2, -i3, i2, i3);
                float width = ((f2.getWidth() - f2.getPaddingLeft()) - f2.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(f2.getPaddingLeft(), f2.getHeight() / 2);
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f3045f.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
