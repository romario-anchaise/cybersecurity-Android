// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* JADX INFO: renamed from: j.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0140d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f3155b;

    public /* synthetic */ RunnableC0140d(ActionBarOverlayLayout actionBarOverlayLayout, int i2) {
        this.f3154a = i2;
        this.f3155b = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3154a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f3155b;
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.f1347w = actionBarOverlayLayout.f1329d.animate().translationY(0.0f).setListener(actionBarOverlayLayout.f1348x);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f3155b;
                actionBarOverlayLayout2.h();
                actionBarOverlayLayout2.f1347w = actionBarOverlayLayout2.f1329d.animate().translationY(-actionBarOverlayLayout2.f1329d.getHeight()).setListener(actionBarOverlayLayout2.f1348x);
                break;
        }
    }
}
