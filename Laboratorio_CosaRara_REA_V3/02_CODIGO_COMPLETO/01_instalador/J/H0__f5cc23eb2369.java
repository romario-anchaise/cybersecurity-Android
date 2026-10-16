// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class H0 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I0 f3052a;

    public H0(I0 i1) {
        this.f3052a = i1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        A a2;
        int action = motionEvent.getAction();
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        I0 i1 = this.f3052a;
        if (action == 0 && (a2 = i1.f3078y) != null && a2.isShowing() && x2 >= 0 && x2 < i1.f3078y.getWidth() && y2 >= 0 && y2 < i1.f3078y.getHeight()) {
            i1.f3074u.postDelayed(i1.f3070q, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        i1.f3074u.removeCallbacks(i1.f3070q);
        return false;
    }
}
