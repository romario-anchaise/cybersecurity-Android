// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public final class w implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f2996a;

    public w(y yVar) {
        this.f2996a = yVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f2996a.c();
    }
}
