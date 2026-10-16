// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j0;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f2307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2308b;

    public a(IBinder iBinder, String str) {
        this.f2307a = iBinder;
        this.f2308b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f2307a;
    }
}
