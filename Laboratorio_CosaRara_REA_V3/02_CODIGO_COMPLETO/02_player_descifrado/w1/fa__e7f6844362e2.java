// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class fa implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4019c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f4022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f4024h;

    public /* synthetic */ fa(ScreenMirrorService screenMirrorService, String str, Intent intent, String str2, boolean z2) {
        this.f4023g = screenMirrorService;
        this.f4020d = str;
        this.f4024h = intent;
        this.f4021e = str2;
        this.f4022f = z2;
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0131  */
    /* JADX WARN: Code duplicated, block: B:67:0x0137  */
    /* JADX WARN: Code duplicated, block: B:68:0x014a  */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x0137, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:68:0x014a, please report this as an issue */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4019c) {
            case 0:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f4023g;
                String str = this.f4020d;
                Intent intent = (Intent) this.f4024h;
                String str2 = this.f4021e;
                boolean z2 = this.f4022f;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.M(str, intent, str2, z2);
                return;
            default:
                cf cfVar = (cf) this.f4023g;
                String str3 = this.f4020d;
                String str4 = this.f4021e;
                Context context = (Context) this.f4024h;
                boolean z3 = this.f4022f;
                h2.c cVar = cfVar.f3706h;
                g2.a0 a0Var = cfVar.f3727s0;
                h2.c cVar2 = h2.c.f1965h;
                if (cVar == cVar2 || cVar == h2.c.f1967j) {
                    if (a0Var == null || !a0Var.J()) {
                        Log.i("TunnelManager", "keepalive recovery anchors-only state=" + cVar + " reason=" + str3);
                        return;
                    }
                } else if (cVar == h2.c.f1963f || cVar == h2.c.f1964g) {
                    Log.i("TunnelManager", "keepalive recovery held by handshake reason=" + str3);
                    return;
                }
                int i3 = cfVar.f3708i.get();
                c2.t tVar = cfVar.f3710j;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                synchronized (tVar) {
                    if (tVar.f458a == i3) {
                        long j3 = tVar.f459b;
                        if (j3 > 0 && jElapsedRealtime >= j3 && jElapsedRealtime - j3 < 30000) {
                            Log.i("TunnelManager", "keepalive recovery coalesced generation=" + i3 + " reason=" + str3);
                            return;
                        }
                    }
                    tVar.f458a = i3;
                    tVar.f459b = Math.max(1L, jElapsedRealtime);
                    boolean zO0 = false;
                    if (cVar != h2.c.f1960c || cfVar.f3692a.get()) {
                        int i4 = cfVar.f3708i.get();
                        h2.c cVar3 = cfVar.f3706h;
                        g2.a0 a0Var2 = cfVar.f3727s0;
                        if (cfVar.f3706h == cVar2 || cfVar.f3706h == h2.c.f1967j) {
                            g2.a0 a0Var3 = cfVar.f3727s0;
                            if (a0Var3 != null && a0Var3.J()) {
                                StringBuilder sbK = a0.a.k("recovery nudge tearing zombie-online reason=", str3, " inboundAgeMs=");
                                sbK.append(a0Var3.p());
                                Log.w("TunnelManager", sbK.toString());
                                cfVar.J("zombie-online:" + str3, false);
                            } else if (a0Var3 != null && a0Var3.p() >= 45000) {
                                Log.i("TunnelManager", "recovery nudge observed stale Socket.IO control; awaiting force threshold reason=" + str3);
                            }
                            zO0 = cfVar.O0(i4, cVar3, a0Var2);
                        } else if (cfVar.f3706h != h2.c.f1963f && cfVar.f3706h != h2.c.f1964g) {
                            boolean zK = cfVar.k("recovery_nudge");
                            if (cfVar.v0()) {
                                Log.i("TunnelManager", "recovery nudge held by registration retry floor reason=" + str3);
                            } else if (!zK) {
                                boolean z4 = cfVar.f3711j0;
                                long j4 = cfVar.f3703f0;
                                if (z4 && j4 < 15000) {
                                    StringBuilder sbK2 = a0.a.k("recovery nudge ignored (short-life storm) reason=", str3, " lifetimeMs=");
                                    sbK2.append(cfVar.f3703f0);
                                    Log.i("TunnelManager", sbK2.toString());
                                } else if (cfVar.u0()) {
                                    Log.i("TunnelManager", "recovery nudge held by restored backoff reason=" + str3);
                                } else {
                                    StringBuilder sbK3 = a0.a.k("recovery nudged reason=", str3, " state=");
                                    sbK3.append(cfVar.f3706h);
                                    Log.i("TunnelManager", sbK3.toString());
                                    cfVar.f3726s.getClass();
                                    cfVar.W = 0;
                                    cfVar.X = 0L;
                                    cfVar.Y = 0L;
                                    cfVar.i();
                                    cfVar.J("recovery_nudge:" + str3, false);
                                    zO0 = cfVar.O0(i4, cVar3, a0Var2);
                                }
                            } else if (cfVar.u0()) {
                                Log.i("TunnelManager", "recovery nudge held by restored backoff reason=" + str3);
                            } else {
                                StringBuilder sbK4 = a0.a.k("recovery nudged reason=", str3, " state=");
                                sbK4.append(cfVar.f3706h);
                                Log.i("TunnelManager", sbK4.toString());
                                cfVar.f3726s.getClass();
                                cfVar.W = 0;
                                cfVar.X = 0L;
                                cfVar.Y = 0L;
                                cfVar.i();
                                cfVar.J("recovery_nudge:" + str3, false);
                                zO0 = cfVar.O0(i4, cVar3, a0Var2);
                            }
                        }
                    } else {
                        if (str4 != null && cfVar.H0(context, str4)) {
                            zO0 = true;
                        }
                        if (str4 == null) {
                            Log.w("TunnelManager", "bare presence start skipped (no public WSS gateway URL) reason=" + str3);
                        }
                    }
                    if (zO0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(z3 ? "delayed" : "immediate");
                        sb.append(" keepalive recovery admitted reason=");
                        sb.append(str3);
                        Log.i("TunnelManager", sb.toString());
                        return;
                    }
                    c2.t tVar2 = cfVar.f3710j;
                    synchronized (tVar2) {
                        if (tVar2.f458a != i3) {
                            return;
                        }
                        tVar2.f458a = Integer.MIN_VALUE;
                        tVar2.f459b = Long.MIN_VALUE;
                        return;
                    }
                }
        }
    }

    public /* synthetic */ fa(cf cfVar, String str, String str2, Context context, boolean z2) {
        this.f4023g = cfVar;
        this.f4020d = str;
        this.f4021e = str2;
        this.f4024h = context;
        this.f4022f = z2;
    }
}
