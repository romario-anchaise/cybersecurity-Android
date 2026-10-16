// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package o0;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d, IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f2787a;

    public b(IBinder iBinder) {
        this.f2787a = iBinder;
    }

    public final Parcel a(Parcel parcel, int i3) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f2787a.transact(i3, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e3) {
                parcelObtain.recycle();
                throw e3;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f2787a;
    }
}
