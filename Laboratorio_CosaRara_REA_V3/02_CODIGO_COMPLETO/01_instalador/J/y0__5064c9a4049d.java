// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: renamed from: j.y0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0182y0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractViewOnTouchListenerC0184z0 f3353b;

    public /* synthetic */ RunnableC0182y0(AbstractViewOnTouchListenerC0184z0 abstractViewOnTouchListenerC0184z0, int i2) {
        this.f3352a = i2;
        this.f3353b = abstractViewOnTouchListenerC0184z0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3352a) {
            case 0:
                ViewParent parent = this.f3353b.f3363d.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                break;
            default:
                AbstractViewOnTouchListenerC0184z0 abstractViewOnTouchListenerC0184z0 = this.f3353b;
                abstractViewOnTouchListenerC0184z0.a();
                View view = abstractViewOnTouchListenerC0184z0.f3363d;
                if (view.isEnabled() && !view.isLongClickable() && abstractViewOnTouchListenerC0184z0.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    abstractViewOnTouchListenerC0184z0.g = true;
                    break;
                }
                break;
        }
    }
}
