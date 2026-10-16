// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ye extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConnectivityManager f5650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cf f5651b;

    public ye(cf cfVar, ConnectivityManager connectivityManager) {
        this.f5651b = cfVar;
        this.f5650a = connectivityManager;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.f5651b.f3702f.execute(new e2.q0(this, this.f5650a, network, 21));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        this.f5651b.f3702f.execute(new q.r(this, this.f5650a, network, networkCapabilities, 6));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.f5651b.f3702f.execute(new ba(this, network, 14));
    }
}
