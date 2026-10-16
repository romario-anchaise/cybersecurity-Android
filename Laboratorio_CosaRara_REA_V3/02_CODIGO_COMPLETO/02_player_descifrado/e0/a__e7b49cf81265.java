// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f655a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue f656b = new LinkedBlockingQueue();

    public final IBinder a() throws TimeoutException {
        h0.o.b("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f655a) {
            o2.k("Cannot call get on this connection more than once");
            return null;
        }
        this.f655a = true;
        IBinder iBinder = (IBinder) this.f656b.poll(10000L, TimeUnit.MILLISECONDS);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f656b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
