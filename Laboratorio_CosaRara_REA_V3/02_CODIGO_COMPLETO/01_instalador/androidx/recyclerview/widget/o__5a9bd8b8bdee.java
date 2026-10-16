// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: androidx.recyclerview.widget.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0097o implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0098p f1997a;

    public C0097o(C0098p c0098p) {
        this.f1997a = c0098p;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        C0098p c0098p = this.f1997a;
        c0098p.f2004c.setAlpha(iFloatValue);
        c0098p.f2005d.setAlpha(iFloatValue);
        c0098p.f2019s.invalidate();
    }
}
