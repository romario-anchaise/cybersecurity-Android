// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p008e0;

import C.h;
import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: loaded from: classes.dex */
public final class f extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f2271a;

    public f(h hVar) {
        this.f2271a = hVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        h.h(this.f2271a, network, true);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        h.h(this.f2271a, network, false);
    }
}
