// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f1380a;

    public final void a(String[] strArr) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
            parcelObtain.writeStringArray(strArr);
            this.f1380a.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1380a;
    }
}
