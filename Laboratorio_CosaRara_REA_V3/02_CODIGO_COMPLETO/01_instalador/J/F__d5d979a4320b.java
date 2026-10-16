// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.o2s2m.gae1fc3b2uc0u.R;

/* JADX INFO: loaded from: classes.dex */
public final class F extends SeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G f3041a;

    public F(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarStyle);
        g1.a(this, getContext());
        G g = new G(this);
        this.f3041a = g;
        g.b(attributeSet, R.attr.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        G g = this.f3041a;
        Drawable drawable = g.f3045f;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        F f2 = g.f3044e;
        if (drawable.setState(f2.getDrawableState())) {
            f2.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f3041a.f3045f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3041a.g(canvas);
    }
}
