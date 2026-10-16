// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import com.o2s2m.gae1fc3b2uc0u.R;

/* JADX INFO: loaded from: classes.dex */
public final class D extends RatingBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B f3040a;

    public D(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.ratingBarStyle);
        g1.a(this, getContext());
        B b2 = new B(this);
        this.f3040a = b2;
        b2.b(attributeSet, R.attr.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap bitmap = (Bitmap) this.f3040a.f3019c;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }
}
