// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: i.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnAttachStateChangeListenerC0131e implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f2884b;

    public /* synthetic */ ViewOnAttachStateChangeListenerC0131e(v vVar, int i2) {
        this.f2883a = i2;
        this.f2884b = vVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i2 = this.f2883a;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.f2883a) {
            case 0:
                h hVar = (h) this.f2884b;
                ViewTreeObserver viewTreeObserver = hVar.f2913x;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        hVar.f2913x = view.getViewTreeObserver();
                    }
                    hVar.f2913x.removeGlobalOnLayoutListener(hVar.f2898i);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            default:
                F f2 = (F) this.f2884b;
                ViewTreeObserver viewTreeObserver2 = f2.f2856o;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        f2.f2856o = view.getViewTreeObserver();
                    }
                    f2.f2856o.removeGlobalOnLayoutListener(f2.f2850i);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }
}
