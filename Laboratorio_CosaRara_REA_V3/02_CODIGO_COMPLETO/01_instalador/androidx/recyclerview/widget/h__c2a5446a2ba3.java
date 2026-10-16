// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: renamed from: androidx.recyclerview.widget.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0090h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0091i f1937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f1938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f1939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0093k f1940e;

    public /* synthetic */ C0090h(C0093k c0093k, C0091i c0091i, ViewPropertyAnimator viewPropertyAnimator, View view, int i2) {
        this.f1936a = i2;
        this.f1940e = c0093k;
        this.f1937b = c0091i;
        this.f1938c = viewPropertyAnimator;
        this.f1939d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f1936a) {
            case 0:
                this.f1938c.setListener(null);
                View view = this.f1939d;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                C0091i c0091i = this.f1937b;
                c0 c0Var = c0091i.f1945a;
                C0093k c0093k = this.f1940e;
                c0093k.c(c0Var);
                c0093k.f1982r.remove(c0091i.f1945a);
                c0093k.i();
                break;
            default:
                this.f1938c.setListener(null);
                View view2 = this.f1939d;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                C0091i c0091i2 = this.f1937b;
                c0 c0Var2 = c0091i2.f1946b;
                C0093k c0093k2 = this.f1940e;
                c0093k2.c(c0Var2);
                c0093k2.f1982r.remove(c0091i2.f1946b);
                c0093k2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f1936a) {
            case 0:
                c0 c0Var = this.f1937b.f1945a;
                this.f1940e.getClass();
                break;
            default:
                c0 c0Var2 = this.f1937b.f1946b;
                this.f1940e.getClass();
                break;
        }
    }
}
