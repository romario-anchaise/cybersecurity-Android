// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static final Network a(ConnectivityManager connectivityManager) {
        connectivityManager.getClass();
        return connectivityManager.getActiveNetwork();
    }
}
