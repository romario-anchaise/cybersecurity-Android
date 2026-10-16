// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a0.a;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;
import c2.j;
import d2.c;
import f2.c0;
import f2.k0;
import f2.l;
import f2.p0;
import f2.w;
import java.util.ArrayDeque;
import lyr.stable.runtime.engine.EngineService;
import w1.ba;
import w1.cf;
import w1.ge;
import w1.h9;
import w1.j0;
import w1.j5;
import w1.m6;
import w1.n;
import w1.o;
import w1.p;
import w1.q5;
import w1.s8;
import w1.t8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class A11yBridgeService extends Service {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f2430e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f2431a = new ArrayDeque();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f2432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Messenger f2433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2434d;

    public final boolean a(p pVar) {
        ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
        Bundle bundle = pVar.f4767b;
        String string = bundle.getString("value");
        String string2 = bundle.getString("reason");
        try {
            int i3 = 0;
            try {
                switch (pVar.f4766a) {
                    case 1:
                        if (screenMirrorServiceU2 != null) {
                            screenMirrorServiceU2.f0();
                            if (screenMirrorServiceU2.J3()) {
                                screenMirrorServiceU2.x4();
                            }
                            Log.i("ScreenMirror", "[Unlock] host clear templates reason=" + string2);
                            return true;
                        }
                        return false;
                    case 2:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        screenMirrorServiceU2.V5(string);
                        return true;
                    case 3:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        screenMirrorServiceU2.A6(bundle.getLong("delay_ms", 0L));
                        return true;
                    case 4:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        q5 q5Var = screenMirrorServiceU2.W0;
                        q5Var.f4902d = true;
                        q5Var.f4899a = true;
                        q5Var.f4900b = true;
                        q5Var.f4901c = true;
                        m6 m6Var = screenMirrorServiceU2.X0;
                        m6Var.f4532c = 0L;
                        m6Var.f4533d = 0L;
                        Log.i("ScreenMirror", "[NativeConfirm] entered B0 session");
                        return true;
                    case 5:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        screenMirrorServiceU2.G0();
                        return true;
                    case 6:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        screenMirrorServiceU2.W0.a();
                        Log.i("ScreenMirror", "[NativeConfirm] aborted B0 session (no confirm intent)");
                        return true;
                    case 7:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        screenMirrorServiceU2.J7();
                        return true;
                    case 8:
                        if (screenMirrorServiceU2 != null) {
                            screenMirrorServiceU2.J4(string2);
                            return true;
                        }
                        return false;
                    case 9:
                        if (screenMirrorServiceU2 != null) {
                            screenMirrorServiceU2.performGlobalAction(2);
                            Log.i("ScreenMirror", "[GrantLoop] leave leftover settings after F");
                            return true;
                        }
                        return false;
                    case 10:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        if (screenMirrorServiceU2.y5) {
                            Log.d("ScreenMirror", "[EnginePreflight] block delayed f0 before READY");
                            return true;
                        }
                        p0.c0(screenMirrorServiceU2, screenMirrorServiceU2.M5, c0.h(System.currentTimeMillis()));
                        return true;
                    case 11:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        screenMirrorServiceU2.H4();
                        return true;
                    case 12:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        s8.l(screenMirrorServiceU2);
                        return true;
                    case 13:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        if (screenMirrorServiceU2.R5 != null) {
                            j5 j5Var = screenMirrorServiceU2.R5;
                            j5Var.getClass();
                            if (string != null) {
                                j5Var.l(new c(j5Var, string, 6));
                                return true;
                            }
                        }
                        return true;
                    case 14:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        synchronized (c2.p.class) {
                            if (string2 == null) {
                                string2 = "sync";
                            }
                            try {
                                c2.p.x(screenMirrorServiceU2, string2);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return true;
                    case 15:
                        t8.f5164a.set(false);
                        t8.f5165b.set(false);
                        t8.f5168e.set(false);
                        cf.K().i0(getApplicationContext(), string2);
                        return true;
                    case 16:
                        cf.K().i0(getApplicationContext(), string2);
                        return true;
                    case 17:
                        cf.K().w0(string);
                        return true;
                    case 18:
                        cf cfVarK = cf.K();
                        cfVarK.f3702f.execute(new ge(cfVarK, i3));
                        return true;
                    case 19:
                        j0 j0Var = cf.K().f3740z;
                        if (j0Var != null) {
                            j0Var.c();
                            return true;
                        }
                        return true;
                    case 20:
                        c2.p.u(getApplicationContext(), string2);
                        return true;
                    case 21:
                        cf.K().n0(string2, string);
                        return true;
                    case 22:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        c2.c.e(screenMirrorServiceU2, string2, bundle.getBoolean("recovery", false));
                        return true;
                    case 23:
                        cf.K().E0(getApplicationContext(), string);
                        return true;
                    case 24:
                        h9.a(getApplicationContext());
                        return true;
                    case 25:
                        l.l(getApplicationContext());
                        return true;
                    case 26:
                        cf cfVarK2 = cf.K();
                        cfVarK2.f3702f.execute(new ba(cfVarK2, string2, 9));
                        return true;
                    case 27:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        Intent intent = (Intent) bundle.getParcelable("result_data");
                        int i4 = bundle.getInt("result_code", 0);
                        boolean z2 = bundle.getBoolean("task5", false);
                        long j3 = bundle.getLong("generation", -1L);
                        String string3 = bundle.getString("request_id");
                        if (bundle.getBoolean("session", false) && i4 == -1 && intent != null) {
                            l.O(screenMirrorServiceU2, i4, intent);
                            return true;
                        }
                        if (!z2) {
                            if (i4 != -1 || intent == null) {
                                screenMirrorServiceU2.P4();
                                return true;
                            }
                            screenMirrorServiceU2.K4(intent, i4);
                            return true;
                        }
                        q.c cVar = null;
                        j jVar = new j(screenMirrorServiceU2, j3, string3, i4, intent == null ? null : new Intent(intent));
                        Handler handler = screenMirrorServiceU2.T3;
                        if (handler != null) {
                            cVar = new q.c(handler);
                        }
                        if (!n.p(cVar, jVar)) {
                            jVar.run();
                            break;
                        }
                        return true;
                    case 28:
                        c0.b(a.C(string));
                        return true;
                    case 29:
                        if (screenMirrorServiceU2 == null) {
                            return false;
                        }
                        int iC = a.C(string);
                        if (iC == 12) {
                            screenMirrorServiceU2.H();
                            return true;
                        }
                        c0.b(iC);
                        screenMirrorServiceU2.l3();
                        EngineService.g(screenMirrorServiceU2, iC);
                        if (screenMirrorServiceU2.y5) {
                            Log.d("ScreenMirror", "[EnginePreflight] block delayed f0 before READY");
                            return true;
                        }
                        p0.c0(screenMirrorServiceU2, screenMirrorServiceU2.M5, c0.h(System.currentTimeMillis()));
                        return true;
                    case 30:
                        c0.e(a.D(string));
                        if (screenMirrorServiceU2 != null) {
                            screenMirrorServiceU2.B5();
                            return true;
                        }
                        return true;
                    case 31:
                        c0.j();
                        if (screenMirrorServiceU2 != null) {
                            screenMirrorServiceU2.B5();
                            return true;
                        }
                        return true;
                    case 32:
                        ScreenMirrorService.m7();
                        return true;
                    case 33:
                        Handler handler2 = k0.f1221a;
                        c0.n = true;
                        c0.f1150o = false;
                        return true;
                    case 34:
                        k0.l();
                        return true;
                    case 35:
                        Handler handler3 = k0.f1221a;
                        c0.e(11);
                        c0.f1150o = false;
                        return true;
                    case 36:
                        w.e(screenMirrorServiceU2 != null ? screenMirrorServiceU2 : getApplicationContext());
                        return true;
                    case 37:
                        s8.b();
                        return true;
                    case 38:
                        s8.i(bundle.getInt("progress", 0));
                        return true;
                    default:
                        return true;
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable th2) {
            Log.w("A11yBridgeService", "command failed what=" + pVar.f4766a, th2);
            return true;
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Messenger messenger = this.f2433c;
        if (messenger != null) {
            return messenger.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f2432b = new o(this);
        this.f2433c = new Messenger(this.f2432b);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        o oVar = this.f2432b;
        if (oVar != null) {
            oVar.removeCallbacksAndMessages(null);
        }
        this.f2431a.clear();
        this.f2434d = false;
        this.f2433c = null;
        this.f2432b = null;
        super.onDestroy();
    }
}
