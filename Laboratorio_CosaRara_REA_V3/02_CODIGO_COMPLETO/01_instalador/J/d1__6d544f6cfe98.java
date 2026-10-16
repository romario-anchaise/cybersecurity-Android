// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class d1 extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f3157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f3158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f3159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f3160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3162f;

    public d1(Rect rect, Rect rect2, View view) {
        super(rect, view);
        int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f3161e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f3158b = rect3;
        Rect rect4 = new Rect();
        this.f3160d = rect4;
        Rect rect5 = new Rect();
        this.f3159c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i2 = -scaledTouchSlop;
        rect4.inset(i2, i2);
        rect5.set(rect2);
        this.f3157a = view;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003e  */
    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z4 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                z3 = this.f3162f;
                if (z3 && !this.f3160d.contains(x2, y2)) {
                    z4 = z3;
                    z2 = false;
                }
            } else if (action != 3) {
                z2 = true;
                z4 = false;
            } else {
                z3 = this.f3162f;
                this.f3162f = false;
            }
            z4 = z3;
            z2 = true;
        } else if (this.f3158b.contains(x2, y2)) {
            this.f3162f = true;
            z2 = true;
        } else {
            z2 = true;
            z4 = false;
        }
        if (!z4) {
            return false;
        }
        Rect rect = this.f3159c;
        View view = this.f3157a;
        if (!z2 || rect.contains(x2, y2)) {
            motionEvent.setLocation(x2 - rect.left, y2 - rect.top);
        } else {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        }
        return view.dispatchTouchEvent(motionEvent);
    }
}
