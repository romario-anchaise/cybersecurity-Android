// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f1917a;

    public n(IBinder iBinder) {
        this.f1917a = iBinder;
    }

    public final void a(s sVar, d dVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(sVar);
            parcelObtain.writeInt(1);
            e0.k.a(dVar, parcelObtain, 0);
            this.f1917a.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1917a;
    }
}
