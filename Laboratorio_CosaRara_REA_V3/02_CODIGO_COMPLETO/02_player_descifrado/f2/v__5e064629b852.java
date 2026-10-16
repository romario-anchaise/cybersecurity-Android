// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import w1.wf;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1337a;

    public /* synthetic */ v(int i3) {
        this.f1337a = i3;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f1337a) {
            case 0:
                if (motionEvent != null && motionEvent.getAction() == 0) {
                    view.performClick();
                }
                return true;
            case 1:
                if (motionEvent.getAction() == 0) {
                    view.setAlpha(0.4f);
                    return false;
                }
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return false;
                }
                view.setAlpha(1.0f);
                return false;
            default:
                Handler handler = wf.f5438a;
                return true;
        }
    }
}
