// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: renamed from: androidx.recyclerview.widget.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0089g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f1929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f1931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0093k f1934f;

    public C0089g(C0093k c0093k, c0 c0Var, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1934f = c0093k;
        this.f1929a = c0Var;
        this.f1930b = i2;
        this.f1931c = view;
        this.f1932d = i3;
        this.f1933e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i2 = this.f1930b;
        View view = this.f1931c;
        if (i2 != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f1932d != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f1933e.setListener(null);
        C0093k c0093k = this.f1934f;
        c0 c0Var = this.f1929a;
        c0093k.c(c0Var);
        c0093k.f1980p.remove(c0Var);
        c0093k.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f1934f.getClass();
    }
}
