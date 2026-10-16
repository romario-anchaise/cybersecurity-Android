// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import p.m;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3370a = m.f("NetworkStateTracker");

    public static final u.a a(ConnectivityManager connectivityManager) {
        boolean zB;
        connectivityManager.getClass();
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        try {
            NetworkCapabilities networkCapabilitiesA = z.g.a(connectivityManager, z.h.a(connectivityManager));
            zB = networkCapabilitiesA != null ? z.g.b(networkCapabilitiesA, 16) : false;
        } catch (SecurityException e3) {
            m.d().c(f3370a, "Unable to validate active network", e3);
        }
        return new u.a(z2, zB, connectivityManager.isActiveNetworkMetered(), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : true);
    }
}
