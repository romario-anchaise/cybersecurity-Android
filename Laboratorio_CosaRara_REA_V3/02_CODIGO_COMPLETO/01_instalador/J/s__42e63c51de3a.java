// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.X;
import C.h;
import D.c;
import D.d;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.TextView;
import f1.l;
import p007e.a;
import p035u.b;

/* JADX INFO: renamed from: j.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0169s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f3290a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PorterDuff.Mode f3291b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3292c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3293d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f3295f;

    public /* synthetic */ C0169s(TextView textView) {
        this.f3295f = textView;
    }

    public void a() {
        CompoundButton compoundButton = (CompoundButton) this.f3295f;
        Drawable drawableA = d.a(compoundButton);
        if (drawableA != null) {
            if (this.f3292c || this.f3293d) {
                Drawable drawableMutate = drawableA.mutate();
                if (this.f3292c) {
                    b.h(drawableMutate, this.f3290a);
                }
                if (this.f3293d) {
                    b.i(drawableMutate, this.f3291b);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public void b() {
        r rVar = (r) this.f3295f;
        Drawable checkMarkDrawable = rVar.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f3292c || this.f3293d) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.f3292c) {
                    b.h(drawableMutate, this.f3290a);
                }
                if (this.f3293d) {
                    b.i(drawableMutate, this.f3291b);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(rVar.getDrawableState());
                }
                rVar.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public void c(AttributeSet attributeSet, int i2) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.f3295f;
        Context context = compoundButton.getContext();
        int[] iArr = a.f2237m;
        h hVarP = h.p(context, attributeSet, iArr, i2);
        TypedArray typedArray = (TypedArray) hVarP.f112b;
        X.g(compoundButton, compoundButton.getContext(), iArr, attributeSet, (TypedArray) hVarP.f112b, i2);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(l.A(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        compoundButton.setButtonDrawable(l.A(compoundButton.getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(l.A(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                c.c(compoundButton, hVarP.k(2));
            }
            if (typedArray.hasValue(3)) {
                c.d(compoundButton, AbstractC0167q0.b(typedArray.getInt(3, -1), null));
            }
        } finally {
            hVarP.r();
        }
    }
}
