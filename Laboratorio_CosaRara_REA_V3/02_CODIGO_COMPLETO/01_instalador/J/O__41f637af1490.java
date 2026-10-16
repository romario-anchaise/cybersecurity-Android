// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import p013i.ViewTreeObserverOnGlobalLayoutListenerC0130d;

/* JADX INFO: loaded from: classes.dex */
public final class O implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC0130d f3091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ P f3092b;

    public O(P p2, ViewTreeObserverOnGlobalLayoutListenerC0130d viewTreeObserverOnGlobalLayoutListenerC0130d) {
        this.f3092b = p2;
        this.f3091a = viewTreeObserverOnGlobalLayoutListenerC0130d;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f3092b.f3099F.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f3091a);
        }
    }
}
