// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class f0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f36a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f37b;

    public f0(i0 i0Var, View view) {
        this.f36a = i0Var;
        this.f37b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f36a.b(this.f37b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f36a.a();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f36a.c();
    }
}
