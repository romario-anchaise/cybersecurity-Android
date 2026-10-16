// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import e2.n1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f1928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f1929h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(com.google.android.gms.common.internal.a aVar, int i3, IBinder iBinder, Bundle bundle) {
        super(aVar, i3, bundle);
        this.f1929h = aVar;
        this.f1928g = iBinder;
    }

    @Override // h0.m
    public final boolean a() {
        IBinder iBinder = this.f1928g;
        try {
            o.c(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            com.google.android.gms.common.internal.a aVar = this.f1929h;
            if (!aVar.g().equals(interfaceDescriptor)) {
                String strG = aVar.g();
                StringBuilder sb = new StringBuilder(strG.length() + 34 + String.valueOf(interfaceDescriptor).length());
                sb.append("service descriptor mismatch: ");
                sb.append(strG);
                sb.append(" vs. ");
                sb.append(interfaceDescriptor);
                Log.w("GmsClient", sb.toString());
                return false;
            }
            IInterface iInterfaceA = aVar.a(iBinder);
            if (iInterfaceA == null || !(aVar.m(2, 4, iInterfaceA) || aVar.m(3, 4, iInterfaceA))) {
                return false;
            }
            aVar.f494s = null;
            n1 n1Var = aVar.n;
            if (n1Var == null) {
                return true;
            }
            ((f0.c) n1Var.f905c).b();
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }

    @Override // h0.m
    public final void b(e0.b bVar) {
        n1 n1Var = this.f1929h.f490o;
        if (n1Var != null) {
            ((f0.d) n1Var.f905c).c(bVar);
        }
        System.currentTimeMillis();
    }
}
