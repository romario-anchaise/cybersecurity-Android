// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2869a = 1;

    public a(String str) {
        attachInterface(this, str);
    }

    public boolean d(int i3, Parcel parcel, Parcel parcel2) {
        return false;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
        switch (this.f2869a) {
            case 1:
                if (i3 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i3, parcel, parcel2, i4)) {
                    return true;
                }
                return d(i3, parcel, parcel2);
            default:
                return super.onTransact(i3, parcel, parcel2, i4);
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
