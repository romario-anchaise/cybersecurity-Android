// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;
import f1.l;
import p011h.e;

/* JADX INFO: loaded from: classes.dex */
public final class x extends ContentFrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ z f2528i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(z zVar, e eVar) {
        super(eVar, null);
        this.f2528i = zVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f2528i.v(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (x2 < -5 || y2 < -5 || x2 > getWidth() + 5 || y2 > getHeight() + 5) {
                z zVar = this.f2528i;
                zVar.t(zVar.A(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i2) {
        setBackgroundDrawable(l.A(getContext(), i2));
    }
}
