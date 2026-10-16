// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p013i;

import A.C0005e;
import android.view.ActionProvider;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class q implements ActionProvider.VisibilityListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActionProvider f2985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f2986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0005e f2987c;

    public q(u uVar, ActionProvider actionProvider) {
        this.f2986b = uVar;
        this.f2985a = actionProvider;
    }

    public final View a(p pVar) {
        return this.f2985a.onCreateActionView(pVar);
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z2) {
        C0005e c0005e = this.f2987c;
        if (c0005e != null) {
            n nVar = ((p) c0005e.f34b).f2972n;
            nVar.f2937h = true;
            nVar.p(true);
        }
    }
}
