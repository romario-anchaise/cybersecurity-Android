// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryChargingProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$NetworkStateProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$StorageNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f3020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f3021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f3022f;

    public g(w0.s sVar, Object[] objArr, String str) {
        this.f3019c = 2;
        this.f3022f = sVar;
        this.f3020d = objArr;
        this.f3021e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        w0.a aVar;
        switch (this.f3019c) {
            case 0:
                try {
                    zBooleanValue = ((Boolean) ((a0.j) this.f3022f).get()).booleanValue();
                    break;
                } catch (InterruptedException | ExecutionException unused) {
                    zBooleanValue = true;
                }
                ((h) this.f3020d).b((y.j) this.f3021e, zBooleanValue);
                return;
            case 1:
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.f3022f;
                Context context = (Context) this.f3021e;
                Intent intent = (Intent) this.f3020d;
                try {
                    boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                    boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                    p.m.d().a(ConstraintProxyUpdateReceiver.f226a, "Updating proxies: (BatteryNotLowProxy (" + booleanExtra + "), BatteryChargingProxy (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy (" + booleanExtra4 + "), ");
                    z.j.a(context, ConstraintProxy$BatteryNotLowProxy.class, booleanExtra);
                    z.j.a(context, ConstraintProxy$BatteryChargingProxy.class, booleanExtra2);
                    z.j.a(context, ConstraintProxy$StorageNotLowProxy.class, booleanExtra3);
                    z.j.a(context, ConstraintProxy$NetworkStateProxy.class, booleanExtra4);
                    return;
                } finally {
                    pendingResult.finish();
                }
            case 2:
                Object[] objArr = (Object[]) this.f3020d;
                int length = objArr.length - 1;
                if (objArr.length <= 0 || !(objArr[length] instanceof w0.a)) {
                    aVar = null;
                } else {
                    Object[] objArr2 = new Object[length];
                    for (int i3 = 0; i3 < length; i3++) {
                        objArr2[i3] = objArr[i3];
                    }
                    aVar = (w0.a) objArr[length];
                    objArr = objArr2;
                }
                f1.b.a(new w0.q((w0.s) this.f3022f, (String) this.f3021e, objArr, aVar));
                return;
            default:
                ((q) this.f3020d).f3060f.g((l) this.f3021e, (h0.g) this.f3022f);
                return;
        }
    }

    public /* synthetic */ g(Object obj, Object obj2, Object obj3, int i3) {
        this.f3019c = i3;
        this.f3020d = obj;
        this.f3021e = obj2;
        this.f3022f = obj3;
    }

    public /* synthetic */ g() {
        this.f3019c = 3;
    }
}
