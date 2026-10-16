// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f4378a;

    public k(m mVar) {
        this.f4378a = mVar;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        this.f4378a.f4480b.post(new j(this, 2));
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName componentName) {
        this.f4378a.f4480b.post(new j(this, 1));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f4378a.f4480b.post(new a2.h(this, iBinder, 14));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f4378a.f4480b.post(new j(this, 0));
    }
}
