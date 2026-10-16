// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionBarOverlayLayout;

/* JADX INFO: renamed from: j.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0138c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f3152a;

    public C0138c(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f3152a = actionBarOverlayLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3152a;
        actionBarOverlayLayout.f1347w = null;
        actionBarOverlayLayout.f1335k = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3152a;
        actionBarOverlayLayout.f1347w = null;
        actionBarOverlayLayout.f1335k = false;
    }
}
