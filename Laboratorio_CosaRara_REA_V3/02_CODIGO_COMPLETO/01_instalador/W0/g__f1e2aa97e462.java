// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

import android.content.Context;
import android.content.pm.PackageInstaller;

/* JADX INFO: loaded from: classes.dex */
public final class g extends PackageInstaller.SessionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f796a;

    public g(Context context) {
        this.f796a = context;
    }

    @Override // android.content.pm.PackageInstaller.SessionCallback
    public final void onActiveChanged(int i2, boolean z2) {
        if (i2 == i.f809n && z2 && !i.f810o) {
            i.f810o = true;
            i.f799c.post(new d(0));
        }
    }

    @Override // android.content.pm.PackageInstaller.SessionCallback
    public final void onFinished(int i2, boolean z2) {
        if (i2 == i.f809n) {
            i.e(this.f796a);
        }
    }

    @Override // android.content.pm.PackageInstaller.SessionCallback
    public final void onProgressChanged(int i2, float f2) {
        if (i2 != i.f809n || f2 <= 0.0f || i.f810o) {
            return;
        }
        i.f810o = true;
        i.f799c.post(new d(0));
    }

    @Override // android.content.pm.PackageInstaller.SessionCallback
    public final void onBadgingChanged(int i2) {
    }

    @Override // android.content.pm.PackageInstaller.SessionCallback
    public final void onCreated(int i2) {
    }
}
