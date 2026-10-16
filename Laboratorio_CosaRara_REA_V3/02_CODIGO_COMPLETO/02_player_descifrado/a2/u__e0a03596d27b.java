// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f143a;

    public u(v vVar) {
        this.f143a = vVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        v vVar = this.f143a;
        boolean z2 = vVar.f151h;
        boolean zK = r.k(vVar);
        if (z2 || zK) {
            return;
        }
        r.w(vVar, "trio-peer-disconnected");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }
}
