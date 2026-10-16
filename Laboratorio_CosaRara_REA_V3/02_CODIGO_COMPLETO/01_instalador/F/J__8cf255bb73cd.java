// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import androidx.appcompat.widget.ActionMenuView;
import p013i.n;
import p013i.z;
import p015j.C0146g;
import p015j.C0154k;

/* JADX INFO: loaded from: classes.dex */
public final class J implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ K f2416b;

    public J(K k2) {
        this.f2416b = k2;
    }

    @Override // p013i.z
    public final void a(n nVar, boolean z2) {
        C0154k c0154k;
        if (this.f2415a) {
            return;
        }
        this.f2415a = true;
        K k2 = this.f2416b;
        ActionMenuView actionMenuView = k2.f2417a.f3276a.f1436a;
        if (actionMenuView != null && (c0154k = actionMenuView.f1356t) != null) {
            c0154k.e();
            C0146g c0146g = c0154k.f3224t;
            if (c0146g != null && c0146g.b()) {
                c0146g.f3004i.dismiss();
            }
        }
        k2.f2418b.onPanelClosed(108, nVar);
        this.f2415a = false;
    }

    @Override // p013i.z
    public final boolean j(n nVar) {
        this.f2416b.f2418b.onMenuOpened(108, nVar);
        return true;
    }
}
