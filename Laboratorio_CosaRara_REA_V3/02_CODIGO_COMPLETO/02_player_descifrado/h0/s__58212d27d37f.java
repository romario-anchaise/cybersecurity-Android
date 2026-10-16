// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends p0.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.google.android.gms.common.internal.a f1924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1925c;

    public s(com.google.android.gms.common.internal.a aVar, int i3) {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
        this.f1924b = aVar;
        this.f1925c = i3;
    }

    @Override // p0.a
    public final boolean d(int i3, Parcel parcel, Parcel parcel2) {
        if (i3 == 1) {
            int i4 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) q0.g.a(parcel, Bundle.CREATOR);
            q0.g.b(parcel);
            o.d(this.f1924b, "onPostInitComplete can be called only once per call to getRemoteService");
            com.google.android.gms.common.internal.a aVar = this.f1924b;
            int i5 = this.f1925c;
            aVar.getClass();
            u uVar = new u(aVar, i4, strongBinder, bundle);
            r rVar = aVar.f481e;
            rVar.sendMessage(rVar.obtainMessage(1, i5, -1, uVar));
            this.f1924b = null;
        } else if (i3 == 2) {
            parcel.readInt();
            q0.g.b(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i3 != 3) {
                return false;
            }
            int i6 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            w wVar = (w) q0.g.a(parcel, w.CREATOR);
            q0.g.b(parcel);
            com.google.android.gms.common.internal.a aVar2 = this.f1924b;
            o.d(aVar2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            o.c(wVar);
            aVar2.f496u = wVar;
            Bundle bundle2 = wVar.f1931c;
            o.d(this.f1924b, "onPostInitComplete can be called only once per call to getRemoteService");
            com.google.android.gms.common.internal.a aVar3 = this.f1924b;
            int i7 = this.f1925c;
            aVar3.getClass();
            u uVar2 = new u(aVar3, i6, strongBinder2, bundle2);
            r rVar2 = aVar3.f481e;
            rVar2.sendMessage(rVar2.obtainMessage(1, i7, -1, uVar2));
            this.f1924b = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
