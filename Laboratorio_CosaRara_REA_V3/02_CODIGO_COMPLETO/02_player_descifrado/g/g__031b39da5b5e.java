// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.MultiInstanceInvalidationService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f1395a;

    public g(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f1395a = multiInstanceInvalidationService;
        attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
        h hVar;
        if (i3 >= 1 && i3 <= 16777215) {
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
        }
        if (i3 == 1598968902) {
            parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
            return true;
        }
        c cVar = null;
        if (i3 == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) {
                    cVar = new c();
                    cVar.f1380a = strongBinder;
                } else {
                    cVar = (c) iInterfaceQueryLocalInterface;
                }
            }
            String string = parcel.readString();
            cVar.getClass();
            int i5 = 0;
            if (string != null) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = this.f1395a;
                synchronized (multiInstanceInvalidationService.f201c) {
                    try {
                        int i6 = multiInstanceInvalidationService.f199a + 1;
                        multiInstanceInvalidationService.f199a = i6;
                        if (multiInstanceInvalidationService.f201c.register(cVar, Integer.valueOf(i6))) {
                            multiInstanceInvalidationService.f200b.put(Integer.valueOf(i6), string);
                            i5 = i6;
                        } else {
                            multiInstanceInvalidationService.f199a--;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            parcel2.writeNoException();
            parcel2.writeInt(i5);
            return true;
        }
        if (i3 == 2) {
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof c)) {
                    cVar = new c();
                    cVar.f1380a = strongBinder2;
                } else {
                    cVar = (c) iInterfaceQueryLocalInterface2;
                }
            }
            int i7 = parcel.readInt();
            cVar.getClass();
            MultiInstanceInvalidationService multiInstanceInvalidationService2 = this.f1395a;
            synchronized (multiInstanceInvalidationService2.f201c) {
                multiInstanceInvalidationService2.f201c.unregister(cVar);
            }
            parcel2.writeNoException();
            return true;
        }
        if (i3 != 3) {
            return super.onTransact(i3, parcel, parcel2, i4);
        }
        int i8 = parcel.readInt();
        String[] strArrCreateStringArray = parcel.createStringArray();
        strArrCreateStringArray.getClass();
        MultiInstanceInvalidationService multiInstanceInvalidationService3 = this.f1395a;
        synchronized (multiInstanceInvalidationService3.f201c) {
            String str = (String) multiInstanceInvalidationService3.f200b.get(Integer.valueOf(i8));
            if (str == null) {
                Log.w("ROOM", "Remote invalidation client ID not registered");
            } else {
                int iBeginBroadcast = multiInstanceInvalidationService3.f201c.beginBroadcast();
                int i9 = 0;
                while (true) {
                    hVar = multiInstanceInvalidationService3.f201c;
                    if (i9 >= iBeginBroadcast) {
                        break;
                    }
                    try {
                        Object broadcastCookie = hVar.getBroadcastCookie(i9);
                        broadcastCookie.getClass();
                        Integer num = (Integer) broadcastCookie;
                        int iIntValue = num.intValue();
                        String str2 = (String) multiInstanceInvalidationService3.f200b.get(num);
                        if (i8 != iIntValue && str.equals(str2)) {
                            try {
                                ((c) multiInstanceInvalidationService3.f201c.getBroadcastItem(i9)).a(strArrCreateStringArray);
                            } catch (RemoteException e3) {
                                Log.w("ROOM", "Error invoking a remote callback", e3);
                            }
                        }
                        i9++;
                    } catch (Throwable th2) {
                        multiInstanceInvalidationService3.f201c.finishBroadcast();
                        throw th2;
                    }
                }
                hVar.finishBroadcast();
            }
        }
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
