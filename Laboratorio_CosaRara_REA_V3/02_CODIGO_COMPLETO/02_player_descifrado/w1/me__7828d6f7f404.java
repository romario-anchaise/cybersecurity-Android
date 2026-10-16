// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class me implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ cf f4556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f4557e;

    public /* synthetic */ me(cf cfVar, Context context, int i3) {
        this.f4555c = i3;
        this.f4556d = cfVar;
        this.f4557e = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4555c) {
            case 0:
                cf cfVar = this.f4556d;
                if (!n.p0(this.f4557e).a()) {
                    Log.i("TunnelManager", "a11y_enabled skipped: service not in Secure list");
                } else {
                    cfVar.k0(cfVar.B0);
                }
                break;
            default:
                cf cfVar2 = this.f4556d;
                Context context = this.f4557e;
                boolean z2 = false;
                cfVar2.f3698d.set(false);
                try {
                    z2 = c2.p.e(context, "a11y_telemetry").getBoolean("enabled_reported_v2", false);
                    break;
                } catch (Throwable unused) {
                }
                if (!z2 && cfVar2.f3694b.get()) {
                    cfVar2.k0(context);
                    break;
                }
                break;
        }
    }
}
