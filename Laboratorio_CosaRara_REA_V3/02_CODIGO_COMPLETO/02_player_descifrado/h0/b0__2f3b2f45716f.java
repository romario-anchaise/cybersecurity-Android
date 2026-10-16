// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements e, IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f1865a;

    public b0(IBinder iBinder) {
        this.f1865a = iBinder;
    }

    public final Account a() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
                this.f1865a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                parcelObtain.recycle();
                Account account = (Account) q0.g.a(parcelObtain2, Account.CREATOR);
                parcelObtain2.recycle();
                return account;
            } catch (RuntimeException e3) {
                parcelObtain2.recycle();
                throw e3;
            }
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1865a;
    }
}
