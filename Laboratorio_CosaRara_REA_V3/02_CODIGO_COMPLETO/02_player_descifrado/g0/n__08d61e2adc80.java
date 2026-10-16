// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1480a;

    public n(int i3) {
        this.f1480a = i3;
    }

    public static Status g(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract boolean a(h hVar);

    public abstract e0.d[] b(h hVar);

    public abstract void c(Status status);

    public abstract void d(Exception exc);

    public abstract void e(h hVar);

    public abstract void f(y.e eVar, boolean z2);
}
