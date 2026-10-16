// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.os.Handler;
import android.widget.AbsListView;

/* JADX INFO: loaded from: classes.dex */
public final class G0 implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I0 f3049a;

    public G0(I0 i1) {
        this.f3049a = i1;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 1) {
            I0 i1 = this.f3049a;
            if (i1.f3078y.getInputMethodMode() == 2 || i1.f3078y.getContentView() == null) {
                return;
            }
            Handler handler = i1.f3074u;
            F0 f2 = i1.f3070q;
            handler.removeCallbacks(f2);
            f2.run();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }
}
