// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: renamed from: androidx.recyclerview.widget.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0088f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1918a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0 f1919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f1920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0093k f1922e;

    public C0088f(C0093k c0093k, c0 c0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1922e = c0093k;
        this.f1919b = c0Var;
        this.f1921d = viewPropertyAnimator;
        this.f1920c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f1918a) {
            case 1:
                this.f1920c.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f1918a) {
            case 0:
                this.f1921d.setListener(null);
                this.f1920c.setAlpha(1.0f);
                C0093k c0093k = this.f1922e;
                c0 c0Var = this.f1919b;
                c0093k.c(c0Var);
                c0093k.f1981q.remove(c0Var);
                c0093k.i();
                break;
            default:
                this.f1921d.setListener(null);
                C0093k c0093k2 = this.f1922e;
                c0 c0Var2 = this.f1919b;
                c0093k2.c(c0Var2);
                c0093k2.f1979o.remove(c0Var2);
                c0093k2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f1918a) {
            case 0:
                this.f1922e.getClass();
                break;
            default:
                this.f1922e.getClass();
                break;
        }
    }

    public C0088f(C0093k c0093k, c0 c0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1922e = c0093k;
        this.f1919b = c0Var;
        this.f1920c = view;
        this.f1921d = viewPropertyAnimator;
    }
}
