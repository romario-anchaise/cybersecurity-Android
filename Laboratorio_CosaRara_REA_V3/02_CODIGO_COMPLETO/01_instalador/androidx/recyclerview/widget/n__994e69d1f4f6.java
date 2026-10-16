// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: androidx.recyclerview.widget.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0096n extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1995a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0098p f1996b;

    public C0096n(C0098p c0098p) {
        this.f1996b = c0098p;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f1995a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f1995a) {
            this.f1995a = false;
            return;
        }
        C0098p c0098p = this.f1996b;
        if (((Float) c0098p.f2026z.getAnimatedValue()).floatValue() == 0.0f) {
            c0098p.f2000A = 0;
            c0098p.d(0);
        } else {
            c0098p.f2000A = 2;
            c0098p.f2019s.invalidate();
        }
    }
}
