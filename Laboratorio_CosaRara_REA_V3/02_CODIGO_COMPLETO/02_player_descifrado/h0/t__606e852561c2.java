// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f1927b;

    public t(com.google.android.gms.common.internal.a aVar, int i3) {
        this.f1927b = aVar;
        this.f1926a = i3;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i3;
        int i4;
        com.google.android.gms.common.internal.a aVar = this.f1927b;
        if (iBinder == null) {
            synchronized (aVar.f482f) {
                i3 = aVar.f489m;
            }
            if (i3 == 3) {
                aVar.f495t = true;
                i4 = 5;
            } else {
                i4 = 4;
            }
            r rVar = aVar.f481e;
            rVar.sendMessage(rVar.obtainMessage(i4, aVar.f497v.get(), 16));
            return;
        }
        synchronized (aVar.f483g) {
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                aVar.f484h = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof n)) ? new n(iBinder) : (n) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.common.internal.a aVar2 = this.f1927b;
        int i5 = this.f1926a;
        aVar2.getClass();
        v vVar = new v(aVar2, 0, null);
        r rVar2 = aVar2.f481e;
        rVar2.sendMessage(rVar2.obtainMessage(7, i5, -1, vVar));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.common.internal.a aVar = this.f1927b;
        synchronized (aVar.f483g) {
            aVar.f484h = null;
        }
        com.google.android.gms.common.internal.a aVar2 = this.f1927b;
        int i3 = this.f1926a;
        r rVar = aVar2.f481e;
        rVar.sendMessage(rVar.obtainMessage(6, i3, 1));
    }
}
