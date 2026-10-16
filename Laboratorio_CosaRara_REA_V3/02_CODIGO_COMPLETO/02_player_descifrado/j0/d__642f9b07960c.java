// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j0;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import g0.h;
import h0.j;
import y.m;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends com.google.android.gms.common.internal.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j f2318y;

    public d(Context context, Looper looper, m mVar, j jVar, h hVar, h hVar2) {
        super(context, looper, 270, mVar, hVar, hVar2);
        this.f2318y = jVar;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new a(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    @Override // com.google.android.gms.common.internal.a
    public final e0.d[] c() {
        return p0.c.f2872b;
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle d() {
        j jVar = this.f2318y;
        jVar.getClass();
        Bundle bundle = new Bundle();
        String str = jVar.f1905a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.a
    public final int e() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String g() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String h() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.a
    public final boolean i() {
        return true;
    }
}
