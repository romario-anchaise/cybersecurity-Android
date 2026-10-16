// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import p.m;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f3367a;

    public g(h hVar) {
        this.f3367a = hVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        network.getClass();
        networkCapabilities.getClass();
        m.d().a(i.f3370a, "Network capabilities changed: " + networkCapabilities);
        h hVar = this.f3367a;
        hVar.c(i.a(hVar.f3368f));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        network.getClass();
        m.d().a(i.f3370a, "Network connection lost");
        h hVar = this.f3367a;
        hVar.c(i.a(hVar.f3368f));
    }
}
