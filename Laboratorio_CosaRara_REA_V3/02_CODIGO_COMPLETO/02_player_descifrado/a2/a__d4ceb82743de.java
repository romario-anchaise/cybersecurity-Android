// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import android.app.Service;
import android.content.Context;
import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.engine.CompanionService;
import lyr.stable.runtime.engine.KeepAliveDaemonService;
import w1.rd;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f46c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f47d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f48e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Service f49f;

    public /* synthetic */ a(Service service, boolean z2, long j3, int i3) {
        this.f46c = i3;
        this.f49f = service;
        this.f47d = z2;
        this.f48e = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zD;
        int i3 = this.f46c;
        long j3 = this.f48e;
        boolean z2 = this.f47d;
        Service service = this.f49f;
        switch (i3) {
            case 0:
                CompanionService companionService = (CompanionService) service;
                int i4 = CompanionService.f2584d;
                if (z2) {
                    Context applicationContext = companionService.getApplicationContext();
                    CompanionService.e(applicationContext);
                    Context applicationContext2 = applicationContext.getApplicationContext();
                    if (applicationContext2 != null) {
                        applicationContext = applicationContext2;
                    }
                    zD = v.d(applicationContext, KeepAliveDaemonService.class, true, j3);
                } else {
                    zD = CompanionService.d(companionService.getApplicationContext(), true, j3);
                }
                Log.i("CompanionService", "mesh repair fanout requested repairId=" + j3 + " essentialOnly=" + z2 + " accepted=" + zD);
                break;
            default:
                rd rdVar = ScreenMirrorService.n6;
                ((ScreenMirrorService) service).Y0(j3, z2, false);
                break;
        }
    }
}
