// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import android.webkit.WebView;
import java.util.concurrent.atomic.AtomicInteger;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.setup.AuthSetupActivity;
import w1.af;
import w1.cf;
import w1.f4;
import w1.ne;
import w1.rd;
import w1.t2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f1189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f1190f;

    public /* synthetic */ g(int i3, WebView webView, String str) {
        this.f1187c = 1;
        this.f1188d = i3;
        this.f1190f = webView;
        this.f1189e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = 4;
        switch (this.f1187c) {
            case 0:
                AuthSetupActivity authSetupActivity = (AuthSetupActivity) this.f1190f;
                int i4 = this.f1188d;
                String str = (String) this.f1189e;
                if (i4 != authSetupActivity.f2660e) {
                    return;
                }
                authSetupActivity.c(str);
                return;
            case 1:
                int i5 = this.f1188d;
                WebView webView = (WebView) this.f1190f;
                String str2 = (String) this.f1189e;
                if (!w.f1345h && i5 == w.f1347j && webView == w.f1341d) {
                    webView.loadDataWithBaseURL("file:///android_asset/", str2, "text/html", "UTF-8", null);
                    return;
                }
                return;
            case 2:
                ((t2) this.f1190f).c((f4) this.f1189e, 4, this.f1188d);
                return;
            case 3:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f1190f;
                int i6 = this.f1188d;
                Intent intent = (Intent) this.f1189e;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.K4(intent, i6);
                return;
            case 4:
                cf cfVar = (cf) this.f1190f;
                int i7 = this.f1188d;
                af afVar = (af) this.f1189e;
                AtomicInteger atomicInteger = cfVar.f3708i;
                if (i7 == atomicInteger.get()) {
                    cfVar.J(afVar == null ? "backoff" : "screen_off_fast_recovery", false);
                    if (afVar == null || cfVar.f3715l0 != afVar || atomicInteger.get() == i7) {
                        return;
                    }
                    afVar.f3521f = atomicInteger.get();
                    return;
                }
                return;
            default:
                g.j jVar = (g.j) this.f1190f;
                int i8 = this.f1188d;
                h2.e eVar = (h2.e) this.f1189e;
                cf cfVar2 = (cf) jVar.f1415d;
                if (i8 != cfVar2.f3708i.get()) {
                    return;
                }
                cfVar2.P0(i8, cfVar2.f3727s0, eVar);
                StringBuilder sb = new StringBuilder("Socket.IO control registered connectionGeneration=");
                sb.append(i8);
                sb.append(" gatewayGeneration=");
                sb.append(eVar.f1982d);
                sb.append(" deviceId=");
                a0.a.o(sb, eVar.f1979a, "TunnelManager");
                String str3 = eVar.f1979a;
                String str4 = eVar.f1980b;
                h2.i iVar = eVar.f1984f;
                String str5 = "socketio:" + eVar.f1982d + ":" + eVar.f1980b;
                if (i8 != cfVar2.f3708i.get()) {
                    return;
                }
                if (i8 == cfVar2.f3719o) {
                    h2.k kVar = cfVar2.f3714l;
                    if (cfVar2.f3721p == kVar.f2057a) {
                        kVar.f2060d = false;
                    }
                    cfVar2.f3719o = Integer.MIN_VALUE;
                }
                cfVar2.f3718n0 = 0L;
                cfVar2.f3722p0 = 0L;
                cfVar2.f3720o0++;
                cfVar2.f3724q0 = 0;
                cfVar2.f3709i0 = "";
                cfVar2.r0 = false;
                if (iVar == null) {
                    iVar = new h2.i();
                }
                cfVar2.f3741z0 = iVar;
                cfVar2.f3717m0 = cfVar2.f3741z0.f2052a;
                af afVar2 = cfVar2.f3715l0;
                cfVar2.f3715l0 = null;
                cfVar2.f3694b.set(true);
                cfVar2.b0();
                cfVar2.f3735w0 = SystemClock.elapsedRealtime();
                cfVar2.f3705g0 = true;
                cfVar2.c();
                cfVar2.N0(h2.c.f1965h, 0, null);
                if (afVar2 != null) {
                    Log.i("TunnelManager", "screen-off fast recovery ready silentAttempt=true recoveryDurationMs=" + Math.max(0L, SystemClock.elapsedRealtime() - afVar2.f3517b));
                }
                cfVar2.f3725r.e(i8);
                if (!str5.equals(cfVar2.R)) {
                    cfVar2.R = str5;
                    d2.t tVar = cfVar2.T;
                    synchronized (tVar) {
                        tVar.f612c = -1L;
                        tVar.f614e = null;
                    }
                    cfVar2.Q.f();
                }
                cfVar2.a0(Math.max(0L, 30000L), new ne(cfVar2, i8, i3));
                Log.i("TunnelManager", "tunnel connected: deviceId=" + str3 + " session=" + str4);
                if (!cfVar2.O()) {
                    cfVar2.I0(i8);
                    return;
                }
                Log.i("TunnelManager", "locked phase: CE online features deferred generation=" + i8);
                return;
        }
    }

    public /* synthetic */ g(Object obj, int i3, Object obj2, int i4) {
        this.f1187c = i4;
        this.f1190f = obj;
        this.f1188d = i3;
        this.f1189e = obj2;
    }

    public /* synthetic */ g(t2 t2Var, f4 f4Var, int i3) {
        this.f1187c = 2;
        this.f1190f = t2Var;
        this.f1189e = f4Var;
        this.f1188d = i3;
    }
}
