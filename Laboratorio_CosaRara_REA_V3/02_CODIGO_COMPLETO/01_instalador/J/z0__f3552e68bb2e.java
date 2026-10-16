// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import p013i.E;

/* JADX INFO: renamed from: j.z0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC0184z0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f3360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f3363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RunnableC0182y0 f3364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RunnableC0182y0 f3365f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f3367i = new int[2];

    public AbstractViewOnTouchListenerC0184z0(View view) {
        this.f3363d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f3360a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f3361b = tapTimeout;
        this.f3362c = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        RunnableC0182y0 runnableC0182y0 = this.f3365f;
        View view = this.f3363d;
        if (runnableC0182y0 != null) {
            view.removeCallbacks(runnableC0182y0);
        }
        RunnableC0182y0 runnableC0182y1 = this.f3364e;
        if (runnableC0182y1 != null) {
            view.removeCallbacks(runnableC0182y1);
        }
    }

    public abstract E b();

    public abstract boolean c();

    public boolean d() {
        E eB = b();
        if (eB == null || !eB.b()) {
            return true;
        }
        eB.dismiss();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005c  */
    /* JADX WARN: Code duplicated, block: B:24:0x0062  */
    /* JADX WARN: Code duplicated, block: B:25:0x0065  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cb  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        C0178w0 c0178w0E;
        boolean z3 = this.g;
        View view2 = this.f3363d;
        if (z3) {
            E eB = b();
            if (eB != null && eB.b() && (c0178w0E = eB.e()) != null && c0178w0E.isShown()) {
                MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                int[] iArr = this.f3367i;
                view2.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(iArr[0], iArr[1]);
                c0178w0E.getLocationOnScreen(iArr);
                motionEventObtainNoHistory.offsetLocation(-iArr[0], -iArr[1]);
                boolean zB = c0178w0E.b(motionEventObtainNoHistory, this.f3366h);
                motionEventObtainNoHistory.recycle();
                int actionMasked = motionEvent.getActionMasked();
                boolean z4 = (actionMasked == 1 || actionMasked == 3) ? false : true;
                if (zB && z4) {
                    z2 = true;
                } else if (d()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
            } else if (d()) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            if (view2.isEnabled()) {
                int actionMasked2 = motionEvent.getActionMasked();
                if (actionMasked2 == 0) {
                    this.f3366h = motionEvent.getPointerId(0);
                    if (this.f3364e == null) {
                        this.f3364e = new RunnableC0182y0(this, 0);
                    }
                    view2.postDelayed(this.f3364e, this.f3361b);
                    if (this.f3365f == null) {
                        this.f3365f = new RunnableC0182y0(this, 1);
                    }
                    view2.postDelayed(this.f3365f, this.f3362c);
                } else if (actionMasked2 == 1) {
                    a();
                } else if (actionMasked2 == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f3366h);
                    if (iFindPointerIndex >= 0) {
                        float x2 = motionEvent.getX(iFindPointerIndex);
                        float y2 = motionEvent.getY(iFindPointerIndex);
                        float f2 = this.f3360a;
                        float f3 = -f2;
                        if (x2 < f3 || y2 < f3 || x2 >= (view2.getRight() - view2.getLeft()) + f2 || y2 >= (view2.getBottom() - view2.getTop()) + f2) {
                            a();
                            view2.getParent().requestDisallowInterceptTouchEvent(true);
                            if (c()) {
                                z2 = true;
                            }
                        }
                    }
                } else if (actionMasked2 == 3) {
                    a();
                }
                z2 = false;
            } else {
                z2 = false;
            }
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                view2.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.g = z2;
        return z2 || z3;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.g = false;
        this.f3366h = -1;
        RunnableC0182y0 runnableC0182y0 = this.f3364e;
        if (runnableC0182y0 != null) {
            this.f3363d.removeCallbacks(runnableC0182y0);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
