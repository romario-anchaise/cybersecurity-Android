// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w;

import a2.t;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import p.m;
import y.r;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t f3356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3357g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, r rVar, int i3) {
        super(context, rVar);
        this.f3357g = i3;
        this.f3356f = new t(2, this);
    }

    @Override // w.e
    public final Object a() {
        switch (this.f3357g) {
            case 0:
                Intent intentRegisterReceiver = this.f3362b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (intentRegisterReceiver == null) {
                    m.d().b(b.f3358a, "getInitialState - null intent received");
                    return Boolean.FALSE;
                }
                int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
                return Boolean.valueOf(intExtra == 2 || intExtra == 5);
            case 1:
                Intent intentRegisterReceiver2 = this.f3362b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (intentRegisterReceiver2 == null) {
                    m.d().b(c.f3359a, "getInitialState - null intent received");
                    return Boolean.FALSE;
                }
                int intExtra2 = intentRegisterReceiver2.getIntExtra("status", -1);
                float intExtra3 = intentRegisterReceiver2.getIntExtra("level", -1) / intentRegisterReceiver2.getIntExtra("scale", -1);
                boolean z2 = true;
                if (intExtra2 != 1 && intExtra3 <= 0.15f) {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            default:
                Intent intentRegisterReceiver3 = this.f3362b.registerReceiver(null, f());
                boolean z3 = true;
                if (intentRegisterReceiver3 != null && intentRegisterReceiver3.getAction() != null) {
                    String action = intentRegisterReceiver3.getAction();
                    if (action == null) {
                        z3 = false;
                    } else {
                        int iHashCode = action.hashCode();
                        if (iHashCode == -1181163412) {
                            action.equals("android.intent.action.DEVICE_STORAGE_LOW");
                        } else if (iHashCode != -730838620 || !action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                        }
                        z3 = false;
                    }
                }
                return Boolean.valueOf(z3);
        }
    }

    @Override // w.e
    public final void d() {
        m.d().a(d.f3360a, getClass().getSimpleName().concat(": registering receiver"));
        this.f3362b.registerReceiver(this.f3356f, f());
    }

    @Override // w.e
    public final void e() {
        m.d().a(d.f3360a, getClass().getSimpleName().concat(": unregistering receiver"));
        this.f3362b.unregisterReceiver(this.f3356f);
    }

    public final IntentFilter f() {
        switch (this.f3357g) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.CHARGING");
                intentFilter.addAction("android.os.action.DISCHARGING");
                return intentFilter;
            case 1:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.BATTERY_OKAY");
                intentFilter2.addAction("android.intent.action.BATTERY_LOW");
                return intentFilter2;
            default:
                IntentFilter intentFilter3 = new IntentFilter();
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_OK");
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_LOW");
                return intentFilter3;
        }
    }
}
