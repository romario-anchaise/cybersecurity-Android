// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r8 implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4999a;

    public r8(String str) {
        this.f4999a = str;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        s8.f5064f.setText(this.f4999a);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(220L);
        s8.f5064f.startAnimation(alphaAnimation);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
