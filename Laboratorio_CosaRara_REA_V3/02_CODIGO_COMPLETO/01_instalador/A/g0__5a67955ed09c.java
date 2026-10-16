// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.animation.ValueAnimator;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes.dex */
public abstract class g0 {
    public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
    }
}
