// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.accessibilityservice.GestureDescription;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import lyr.stable.runtime.MediaProjectionRequestActivity;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONObject;
import w1.b6;
import w1.be;
import w1.cf;
import w1.d4;
import w1.d8;
import w1.dc;
import w1.e5;
import w1.ee;
import w1.f9;
import w1.g6;
import w1.h5;
import w1.j5;
import w1.j6;
import w1.k6;
import w1.l6;
import w1.m4;
import w1.n3;
import w1.n4;
import w1.n5;
import w1.n9;
import w1.nc;
import w1.of;
import w1.p5;
import w1.pa;
import w1.q9;
import w1.r9;
import w1.rd;
import w1.sf;
import w1.te;
import w1.ve;
import w1.w4;
import w1.wc;
import w1.wf;
import w1.ye;
import w1.zd;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q0 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f929f;

    public /* synthetic */ q0(Object obj, Object obj2, Object obj3, int i3) {
        this.f926c = i3;
        this.f927d = obj;
        this.f928e = obj2;
        this.f929f = obj3;
    }

    private final void a() {
        long jMax;
        ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f927d;
        String str = (String) this.f928e;
        String str2 = (String) this.f929f;
        if (screenMirrorService.a3 < 3) {
            return;
        }
        screenMirrorService.c3 = str;
        if (!"force_full".equals(str2)) {
            screenMirrorService.Y5("remote_if_changed", false);
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        a2.o oVar = screenMirrorService.j3;
        synchronized (oVar) {
            try {
                long jMax2 = Math.max(0L, jUptimeMillis);
                long j3 = oVar.f122a;
                if (jMax2 > j3 && j3 == Long.MAX_VALUE) {
                    oVar.f122a = jMax2;
                }
                oVar.f123b = true;
                oVar.f124c = n4.r(str, 96);
                jMax = Math.max(0L, oVar.f122a - jMax2);
            } catch (Throwable th) {
                throw th;
            }
        }
        screenMirrorService.y6(jMax);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0142  */
    private final void b() {
        p5 p5Var;
        d4 d4VarB;
        ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f927d;
        n5 n5Var = (n5) this.f928e;
        Handler handler = (Handler) this.f929f;
        if (!screenMirrorService.f2515l0.f(n5Var)) {
            return;
        }
        n3 n3Var = screenMirrorService.R3;
        if (n3Var == null) {
            n5Var.f4625e.c(5, 26);
            screenMirrorService.X(n5Var.f4621a);
            return;
        }
        d0.d dVar = screenMirrorService.f2519m0;
        synchronized (dVar) {
            dVar.f532b = null;
        }
        screenMirrorService.h0(2);
        synchronized (screenMirrorService.f2556x0) {
            try {
                if (!screenMirrorService.f2515l0.f(n5Var)) {
                    return;
                }
                screenMirrorService.f2560y0 = n5Var.f4621a;
                screenMirrorService.A0 = n5Var.f4622b;
                long j3 = screenMirrorService.f2563z0 + 1;
                screenMirrorService.f2563z0 = j3;
                screenMirrorService.f2544u0 = n5Var.f4624d;
                screenMirrorService.f2548v0 = screenMirrorService.I0();
                d0.d dVar2 = screenMirrorService.f2519m0;
                Object obj = n5Var.f4621a;
                long j4 = n5Var.f4622b;
                synchronized (dVar2) {
                    long j5 = dVar2.f531a + 1;
                    dVar2.f531a = j5;
                    p5Var = new p5(obj, j5, j3, j4);
                    dVar2.f532b = p5Var;
                }
                d4 d4Var = screenMirrorService.f2528p0;
                screenMirrorService.f2528p0 = null;
                if (d4Var != null) {
                    d4Var.b();
                }
                m4 m4Var = screenMirrorService.f2547v;
                Object obj2 = screenMirrorService.f2511k0;
                synchronized (m4Var) {
                    d4VarB = m4Var.b(obj2);
                }
                screenMirrorService.f2528p0 = d4VarB;
                sf sfVarL = wf.l(screenMirrorService, j3, n5Var.f4625e.f4756b, n5Var.f4622b, 10000L, new h(screenMirrorService, p5Var, n5Var));
                screenMirrorService.f2525o0 = sfVarL;
                int iA = n3.a(n5Var.f4623c, n3Var.f4617a);
                int iA2 = n3.a(n5Var.f4624d, n3Var.f4618b);
                float f3 = iA;
                screenMirrorService.f2538s0 = f3;
                float f4 = iA2;
                screenMirrorService.f2542t0 = f4;
                Path path = new Path();
                path.moveTo(f3, f4);
                path.lineTo(f3, f4);
                try {
                    GestureDescription.StrokeDescription strokeDescription = new GestureDescription.StrokeDescription(path, 0L, 80L, true);
                    screenMirrorService.f2522n0 = strokeDescription;
                    boolean z2 = true;
                    screenMirrorService.f2532q0 = true;
                    screenMirrorService.r0 = 1;
                    GestureDescription gestureDescriptionBuild = new GestureDescription.Builder().addStroke(strokeDescription).build();
                    if (screenMirrorService.N3(p5Var) && screenMirrorService.f2515l0.f(n5Var) && screenMirrorService.f2525o0 == sfVarL && screenMirrorService.f2522n0 != null) {
                        StringBuilder sb = new StringBuilder("[Live] DOWN ");
                        sb.append(iA);
                        sb.append(",");
                        sb.append(iA2);
                        sb.append(" sequence=");
                        sb.append(n5Var.f4622b);
                        sb.append(" punchTopologyBarrier=");
                        if (sfVarL.f5107i == null || Looper.myLooper() != Looper.getMainLooper()) {
                            z2 = false;
                        } else {
                            d8 d8Var = wf.P;
                            d8Var.r();
                            if (d8Var.f3800c != 2) {
                                z2 = false;
                            }
                        }
                        sb.append(z2);
                        Log.d("ScreenMirror", sb.toString());
                        try {
                            if (screenMirrorService.c1(p5Var, gestureDescriptionBuild, n5Var.f4625e, new nc(screenMirrorService, n5Var, p5Var), handler)) {
                                return;
                            }
                            n5Var.f4625e.c(5, 10);
                            screenMirrorService.p(p5Var, "down_dispatch_rejected_or_stale");
                            return;
                        } catch (Throwable th) {
                            th = th;
                            p5Var = p5Var;
                            a0.a.p(th, new StringBuilder("[Live] DOWN fail: "), "ScreenMirror");
                            n5Var.f4625e.c(5, 4);
                            screenMirrorService.p(p5Var, "down_exception:".concat(th.getClass().getSimpleName()));
                            return;
                        }
                    }
                    screenMirrorService.p(p5Var, "down_dispatch_stale");
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    private final void c() {
        d2.t tVar = (d2.t) this.f927d;
        v1 v1Var = (v1) this.f928e;
        m1 m1Var = (m1) this.f929f;
        ((ScreenMirrorService) tVar.f614e).c4 = v1Var;
        ScreenMirrorService.f((ScreenMirrorService) tVar.f614e, "rtc.start");
        v1Var.getClass();
        boolean zH = m1Var.h();
        synchronized (m1Var) {
            if (!m1Var.n && v1Var.f1051a >= m1Var.f875f) {
                k1 k1VarF = m1Var.f();
                m1Var.f875f = v1Var.f1051a;
                m1Var.f876g = v1Var;
                m1Var.f882m = 0;
                m1Var.k();
                if (zH) {
                    m1Var.f883o = j0.f830g;
                    m1Var.f884p = l1.f863f;
                    m1Var.f888t = k0.f843f;
                    m1Var.f890v = i0.f821f;
                    m1Var.f892x = h0.f814e;
                }
                m1.c(k1VarF);
                if (zH) {
                    m1Var.j();
                    m1Var.b("bootstrap", v1Var.f1051a);
                    return;
                }
                s1 s1Var = m1Var.f870a;
                synchronized (s1Var) {
                    if (!s1Var.f997k && v1Var.f1051a >= s1Var.f989c) {
                        r1 r1VarD = s1Var.d();
                        s1Var.f989c = v1Var.f1051a;
                        s1Var.h(r1VarD, "projection_required");
                        d2.t tVar2 = s1Var.f987a;
                        ScreenMirrorService.h((ScreenMirrorService) tVar2.f614e, tVar2.f612c, new wc(v1Var.f1051a, (m1[]) tVar2.f613d, 0));
                    }
                }
            }
        }
    }

    private final void d() {
        boolean z2;
        boolean z3;
        boolean z4;
        Intent intentM;
        g gVarE;
        j0 j0Var;
        ScreenMirrorService screenMirrorService;
        Handler handler;
        d2.t tVar = (d2.t) this.f927d;
        c1 c1Var = (c1) this.f928e;
        m1 m1Var = (m1) this.f929f;
        StringBuilder sb = new StringBuilder("RTC capture set generation=");
        sb.append(c1Var.f731a);
        sb.append(" requestId=");
        sb.append(c1Var.f732b);
        sb.append(" mode=");
        sb.append(c1Var.f733c);
        sb.append(" transport=");
        a0.a.o(sb, c1Var.f734d, "ScreenMirror");
        boolean zEquals = "screenshot".equals(c1Var.f733c);
        boolean z5 = false;
        boolean z6 = ((ScreenMirrorService) tVar.f614e).f2505i2 != zEquals;
        ((ScreenMirrorService) tVar.f614e).f2505i2 = zEquals;
        if (!zEquals && z6 && (handler = (screenMirrorService = (ScreenMirrorService) tVar.f614e).f2541t) != null) {
            handler.post(new pa(screenMirrorService, 22));
        }
        if ("realtime".equals(c1Var.f733c)) {
            String str = c1Var.f733c;
            if (((ScreenMirrorService) tVar.f614e).m4 != null && "realtime".equals(str)) {
                ScreenMirrorService.f((ScreenMirrorService) tVar.f614e, "rtc.capture.set");
            }
        } else {
            ((ScreenMirrorService) tVar.f614e).Y();
            String str2 = ((ScreenMirrorService) tVar.f614e).Q4;
            String str3 = c1Var.f733c;
            if ("projection".equals(str2) && !"realtime".equals(str3)) {
                ((ScreenMirrorService) tVar.f614e).o("rtc capture mode changed to ".concat(c1Var.f733c));
            }
        }
        boolean zH = m1Var.h();
        synchronized (m1Var) {
            try {
                if (m1Var.n) {
                    z2 = false;
                    z3 = false;
                    z4 = false;
                    intentM = null;
                    gVarE = null;
                } else {
                    long j3 = m1Var.f875f;
                    if (j3 < 0 || c1Var.f731a == j3) {
                        gVarE = m1Var.e();
                        if (m1Var.f875f < 0) {
                            m1Var.f875f = c1Var.f731a;
                        }
                        if (m1Var.f876g == null) {
                            m1Var.f876g = new v1(c1Var.f731a, "", "", "", "");
                        }
                        m1Var.f887s = c1Var.f732b;
                        m1Var.f891w = c1Var.f736f;
                        m1Var.f892x = null;
                        m1Var.f889u = l0.f851d;
                        if (zH) {
                            m1Var.f883o = j0.f830g;
                            l1 l1Var = l1.f863f;
                            m1Var.f884p = l1Var;
                            m1Var.f890v = i0.f821f;
                            h0 h0Var = m1Var.f885q;
                            h0 h0Var2 = h0.f814e;
                            if (h0Var == h0Var2 && m1Var.f886r == l1Var) {
                                m1Var.f888t = k0.f841d;
                                z2 = false;
                                z3 = false;
                                intentM = null;
                            } else {
                                m1Var.f888t = k0.f843f;
                                m1Var.f892x = h0Var2;
                                z3 = false;
                                z2 = true;
                                intentM = null;
                            }
                        } else {
                            x1 x1Var = j0.f827d;
                            String str4 = c1Var.f733c;
                            x1Var.getClass();
                            j0[] j0VarArrValues = j0.values();
                            int length = j0VarArrValues.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length) {
                                    j0Var = null;
                                    break;
                                }
                                j0Var = j0VarArrValues[i3];
                                if (j0Var.f832c.equals(str4)) {
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                            if (j0Var == null) {
                                throw new IllegalArgumentException("Unknown capture mode: ".concat(str4));
                            }
                            m1Var.f883o = j0Var;
                            x1 x1Var2 = l1.f861d;
                            String str5 = c1Var.f734d;
                            x1Var2.getClass();
                            if (!str5.equals("h264")) {
                                str5.equals("webp");
                            }
                            l1 l1Var2 = l1.f863f;
                            m1Var.f884p = l1Var2;
                            m1Var.f890v = i0.f819d;
                            int iOrdinal = m1Var.f883o.ordinal();
                            if (iOrdinal == 0) {
                                m1Var.f888t = k0.f841d;
                            } else if (iOrdinal == 1) {
                                h0 h0Var3 = m1Var.f885q;
                                h0 h0Var4 = h0.f813d;
                                if (h0Var3 == h0Var4) {
                                    m1Var.f888t = k0.f841d;
                                } else if (c1Var.f736f.equals("existing_only")) {
                                    try {
                                        intentM = m1Var.f873d.m();
                                    } catch (Throwable unused) {
                                        intentM = null;
                                    }
                                    if (intentM != null) {
                                        m1Var.f888t = k0.f843f;
                                        m1Var.f892x = h0.f813d;
                                    } else {
                                        m1Var.f888t = k0.f842e;
                                        m1Var.f890v = i0.f820e;
                                    }
                                    z2 = false;
                                    z3 = false;
                                } else {
                                    m1Var.f888t = k0.f842e;
                                    m1Var.f890v = i0.f820e;
                                    m1Var.f892x = h0Var4;
                                    if (!q1.e.a(m1Var.f893y, c1Var.f732b)) {
                                        m1Var.f893y = c1Var.f732b;
                                        z2 = false;
                                        z3 = true;
                                    }
                                    intentM = null;
                                }
                            } else {
                                if (iOrdinal != 2) {
                                    throw new h1.a();
                                }
                                h0 h0Var5 = m1Var.f885q;
                                h0 h0Var6 = h0.f814e;
                                if (h0Var5 == h0Var6 && m1Var.f886r == l1Var2) {
                                    m1Var.f888t = k0.f841d;
                                } else {
                                    m1Var.f888t = k0.f843f;
                                    m1Var.f892x = h0Var6;
                                    z3 = false;
                                    z2 = true;
                                    intentM = null;
                                }
                            }
                            z2 = false;
                            z3 = false;
                            intentM = null;
                        }
                        z4 = true;
                    } else {
                        z2 = false;
                        z3 = false;
                        z4 = false;
                        intentM = null;
                        gVarE = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (gVarE != null) {
            gVarE.a();
        }
        if (z4) {
            m1Var.j();
            if (intentM != null && !m1Var.f870a.i(c1Var.f731a, intentM)) {
                synchronized (m1Var) {
                    if (!m1Var.n && m1Var.f875f == c1Var.f731a && q1.e.a(m1Var.f887s, c1Var.f732b)) {
                        m1Var.f888t = k0.f842e;
                        m1Var.f889u = l0.f851d;
                        m1Var.f890v = i0.f820e;
                        m1Var.f892x = null;
                        z5 = true;
                    }
                }
                if (z5) {
                    m1Var.j();
                }
            }
            if (z3) {
                dc dcVar = m1Var.f873d;
                long j4 = c1Var.f731a;
                String str6 = c1Var.f732b;
                ScreenMirrorService screenMirrorService2 = dcVar.f3821a;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService2.I("projection");
                screenMirrorService2.Y();
                f9 f9Var = new f9(str6, j4);
                d2.t tVar2 = screenMirrorService2.e4;
                synchronized (tVar2) {
                    try {
                        if (tVar2.f612c != j4) {
                            ((LinkedHashSet) tVar2.f614e).clear();
                            tVar2.f612c = j4;
                        }
                        tVar2.f613d = f9Var;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                w1.n.D0(screenMirrorService2, true, j4, str6, SystemClock.elapsedRealtime());
                g2.m mVar = new g2.m(screenMirrorService2, f9Var, j4, str6, 1);
                screenMirrorService2.f4 = mVar;
                (screenMirrorService2.T3 != null ? screenMirrorService2.T3 : new Handler(Looper.getMainLooper())).postDelayed(mVar, 30000L);
                Context applicationContext = screenMirrorService2.getApplicationContext();
                int i4 = MediaProjectionRequestActivity.f2448d;
                n4.h0(screenMirrorService2, new Intent(applicationContext, (Class<?>) MediaProjectionRequestActivity.class).putExtra("task5_projection_result", true).putExtra("task5_generation", j4).putExtra("task5_request_id", str6));
                if (!screenMirrorService2.b1(new pa(screenMirrorService2, 10))) {
                    screenMirrorService2.Q4 = "projection";
                    screenMirrorService2.v6(2);
                }
            }
            if (z2) {
                m1Var.b(c1Var.f732b, c1Var.f731a);
            }
        }
    }

    private final void e() {
        ee eeVar = (ee) this.f927d;
        be beVar = (be) this.f928e;
        zd zdVar = (zd) this.f929f;
        synchronized (eeVar.f3928c) {
            try {
                if (beVar.f3627l == zdVar) {
                    eeVar.f3929d.getClass();
                    if (SystemClock.uptimeMillis() >= zdVar.f5744f) {
                        beVar.f3627l = null;
                        zdVar.f5745g = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:294:0x05aa  */
    @Override // java.lang.Runnable
    public final void run() {
        long j3;
        JSONObject jSONObjectA;
        IOException iOException;
        StringBuilder sb;
        g2.d0 d0VarW = null;
        boolean z2 = false;
        switch (this.f926c) {
            case 0:
                p1.a aVar = (p1.a) this.f927d;
                AtomicReference atomicReference = (AtomicReference) this.f928e;
                CountDownLatch countDownLatch = (CountDownLatch) this.f929f;
                try {
                    aVar.d();
                    break;
                } catch (Throwable th) {
                    try {
                        atomicReference.set(th);
                    } finally {
                        countDownLatch.countDown();
                    }
                    break;
                }
                return;
            case 1:
                g2.a0 a0Var = (g2.a0) this.f927d;
                g2.b1 b1Var = (g2.b1) this.f928e;
                g2.d0 d0Var = (g2.d0) ((y.l) this.f929f).f5992d;
                try {
                    if (a0Var.Q.get() != b1Var) {
                        d0Var.d(new IOException("logical stream generation retired"), true);
                    } else {
                        g.j jVar = a0Var.f1508d;
                        if (jVar != null) {
                            jVar.f(d0Var.f1572e, d0Var);
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    d0Var.d(new IOException("logical stream dispatch failed", th2), true);
                    return;
                }
            case 2:
                g2.k0 k0Var = (g2.k0) this.f927d;
                g2.s0 s0Var = (g2.s0) this.f928e;
                Object[] objArr = (Object[]) this.f929f;
                long j4 = s0Var.f1728a;
                g2.z0 z0Var = k0Var.f1652e;
                g2.h0 h0VarW = k0Var.w(j4);
                if (h0VarW == null) {
                    return;
                }
                g2.s0 s0Var2 = h0VarW.f1605a;
                h2.e eVar = h0VarW.f1606b;
                if (k0Var.f1657j.get() && k0Var.f1659l.get()) {
                    long j5 = s0Var2.f1729b;
                    synchronized (z0Var.f1834a) {
                        j3 = z0Var.f1844k;
                        break;
                    }
                    if (j5 == j3 && g2.k0.Q((h2.e) k0Var.f1656i.get(), eVar) && (jSONObjectA = g2.k0.A(objArr)) != null && Boolean.TRUE.equals(jSONObjectA.opt("ok"))) {
                        Object objOpt = jSONObjectA.opt("generation");
                        if ((objOpt instanceof Number) && ((Number) objOpt).longValue() == eVar.f1982d) {
                            boolean z3 = s0Var2.f1733f;
                            g2.v0 v0Var = s0Var2.f1730c;
                            if (z3) {
                                try {
                                    int iS = g2.k0.S("credits", jSONObjectA);
                                    if (g2.k0.S("version", jSONObjectA) == 1 && g2.k0.T("generation", jSONObjectA) == eVar.f1982d && g2.k0.U("kind", jSONObjectA).equals(v0Var.f1771c) && iS >= 0) {
                                        Integer num = (Integer) h0VarW.f1607c.f1725c.get(v0Var);
                                        if (iS <= (num != null ? num.intValue() : 1)) {
                                        }
                                    }
                                    break;
                                } catch (IOException unused) {
                                }
                                k0Var.z(h0VarW, 1);
                                k0Var.G("ack_rejected");
                            }
                            z0Var.c(0, j4, true);
                        } else {
                            k0Var.z(h0VarW, 1);
                            k0Var.G("ack_rejected");
                        }
                    } else {
                        k0Var.z(h0VarW, 1);
                        k0Var.G("ack_rejected");
                    }
                } else {
                    k0Var.z(h0VarW, 1);
                    k0Var.G("ack_rejected");
                }
                k0Var.D();
                k0Var.K();
                return;
            case 3:
                j5 j5Var = (j5) this.f927d;
                h5 h5Var = (h5) this.f928e;
                String str = h5Var.f4190b;
                String str2 = h5Var.f4192d;
                String str3 = h5Var.f4189a;
                y.e eVar2 = (y.e) this.f929f;
                j5Var.getClass();
                boolean z4 = h5Var.f4198j;
                boolean z5 = h5Var.f4199k;
                String str4 = h5Var.f4193e;
                String str5 = h5Var.f4191c;
                if (z4) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    d2.y yVar = j5Var.f4309c;
                    if (yVar.b(jCurrentTimeMillis)) {
                        String strTrim = str5.trim();
                        if (strTrim.isEmpty()) {
                            return;
                        }
                        if (strTrim.length() == 1) {
                            char cCharAt = strTrim.charAt(0);
                            if (Character.isISOControl(cCharAt)) {
                                return;
                            }
                            yVar.e(cCharAt, jCurrentTimeMillis);
                            return;
                        }
                        if (j5.J.matcher(strTrim).matches()) {
                            yVar.d();
                            return;
                        } else if (j5.K.matcher(strTrim).matches()) {
                            yVar.e(' ', jCurrentTimeMillis);
                            return;
                        } else {
                            if (j5.u(strTrim)) {
                                j5Var.y();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (ScreenMirrorService.d4(str5) || ScreenMirrorService.d4(str4)) {
                    return;
                }
                if (h5Var.f4197i && !z5) {
                    j5Var.x(j5.m(str3, h5Var.f4195g, str2, str, h5Var.f4196h, h5Var.f4194f), eVar2);
                    if (str5.trim().isEmpty() || j5.v(str5) || j5.H.matcher(str5.trim()).matches()) {
                        return;
                    }
                    eVar2.n(new w4(j5Var, j5.g("CLICK", str3, str, str5, str2, str4, 0, false), 4));
                    return;
                }
                if (j5.u(str5) || j5.u(str4)) {
                    j5Var.y();
                    eVar2.n(new w4(j5Var, j5.g("CLICK", str3, str, str5, str2, str4, 0, false), 5));
                    return;
                }
                j5Var.p(eVar2);
                j5Var.k();
                int i3 = 6;
                eVar2.n(new w4(j5Var, j5.g("CLICK", str3, str, str5, str2, str4, 0, false), i3));
                if (z5) {
                    ((h2.i) eVar2.f5976c).a(new q0(eVar2, j5Var.n, j5Var.f4318l, i3));
                    return;
                }
                return;
            case 4:
                ((j5) this.f927d).q((String) this.f928e, (y.e) this.f929f, false);
                return;
            case 5:
                j5 j5Var2 = (j5) this.f927d;
                y.e eVar3 = (y.e) this.f928e;
                CountDownLatch countDownLatch2 = (CountDownLatch) this.f929f;
                try {
                    j5Var2.p(eVar3);
                    j5Var2.k();
                    return;
                } finally {
                    countDownLatch2.countDown();
                }
            case 6:
                y.e eVar4 = (y.e) this.f927d;
                Runnable runnable = (Runnable) this.f928e;
                e5 e5Var = (e5) this.f929f;
                eVar4.getClass();
                g0.j jVar2 = new g0.j(eVar4, runnable, 9, z2);
                HashSet hashSet = (HashSet) eVar4.f5977d;
                hashSet.add(jVar2);
                if (e5Var.a(jVar2)) {
                    return;
                }
                hashSet.remove(jVar2);
                return;
            case 7:
                g6 g6Var = (g6) this.f927d;
                d0.d dVar = (d0.d) this.f928e;
                b6 b6Var = (b6) this.f929f;
                if (dVar.f531a != g6Var.f4086g.getAsLong()) {
                    g6Var.f4095q.incrementAndGet();
                    return;
                } else {
                    ((Consumer) dVar.f532b).accept(b6Var);
                    return;
                }
            case 8:
                k6 k6Var = (k6) this.f927d;
                Runnable runnable2 = (Runnable) this.f928e;
                String str6 = (String) this.f929f;
                if (k6Var.f4397b.get()) {
                    try {
                        runnable2.run();
                        synchronized (l6.f4448a) {
                            l6.f4449b.remove(str6);
                            break;
                        }
                    } catch (Throwable th3) {
                        try {
                            if (k6Var.f4397b.get()) {
                                Log.e("P90n4iTtpm", "[" + str6 + "] Error: " + th3.getMessage(), th3);
                            } else {
                                Log.d("P90n4iTtpm", "[" + str6 + "] Cancelled gracefully");
                            }
                        } finally {
                            synchronized (l6.f4448a) {
                                l6.f4449b.remove(str6);
                                k6Var.f4397b.set(false);
                            }
                        }
                    }
                    return;
                }
                return;
            case 9:
                String[] strArr = (String[]) this.f927d;
                n9 n9Var = (n9) this.f928e;
                CountDownLatch countDownLatch3 = (CountDownLatch) this.f929f;
                try {
                    strArr[0] = n9Var.run();
                    return;
                } finally {
                    countDownLatch3.countDown();
                }
            case 10:
                d2.b bVar = (d2.b) this.f927d;
                Object obj = this.f928e;
                pa paVar = (pa) this.f929f;
                rd rdVar = ScreenMirrorService.n6;
                try {
                    bVar.accept(obj);
                    return;
                } finally {
                    paVar.run();
                }
            case 11:
                a();
                return;
            case 12:
                b();
                return;
            case 13:
                c();
                return;
            case 14:
                d();
                return;
            case 15:
                e();
                return;
            case 16:
                g2.a0 a0Var2 = (g2.a0) this.f927d;
                String str7 = (String) this.f928e;
                String str8 = (String) this.f929f;
                try {
                    try {
                        d0VarW = a0Var2.w();
                        g2.c0 c0Var = d0VarW.f1578k;
                        StringBuilder sb2 = new StringBuilder("event:security_");
                        sb2.append(str7);
                        sb2.append((str8 == null || str8.isEmpty()) ? "" : "\t".concat(str8));
                        sb2.append("\n");
                        c0Var.write(sb2.toString().getBytes(StandardCharsets.UTF_8));
                        c0Var.flush();
                        Log.i("TunnelManager", "security_" + str7 + " reported to gateway");
                        try {
                            d0VarW.close();
                            return;
                        } catch (IOException e3) {
                            iOException = e3;
                            sb = new StringBuilder("stream close failed: ");
                            a0.a.m(iOException, sb, "TunnelManager");
                            return;
                        }
                    } catch (Throwable th4) {
                        if (d0VarW == null) {
                            throw th4;
                        }
                        try {
                            d0VarW.close();
                            throw th4;
                        } catch (IOException e4) {
                            a0.a.m(e4, new StringBuilder("stream close failed: "), "TunnelManager");
                            throw th4;
                        }
                    }
                } catch (Exception e5) {
                    Log.w("TunnelManager", "security event report failed: " + e5.getMessage());
                    if (d0VarW != null) {
                        try {
                            d0VarW.close();
                            return;
                        } catch (IOException e6) {
                            iOException = e6;
                            sb = new StringBuilder("stream close failed: ");
                            a0.a.m(iOException, sb, "TunnelManager");
                            return;
                        }
                    }
                    return;
                }
            case 17:
                cf cfVar = (cf) this.f927d;
                Context context = (Context) this.f928e;
                g2.d0 d0Var2 = (g2.d0) this.f929f;
                AtomicBoolean atomicBoolean = cfVar.f3700e;
                try {
                    try {
                        w1.n.n0(context, d0Var2.f1577j, d0Var2.f1578k);
                    } catch (IOException e7) {
                        Log.w("TunnelManager", "APP1 stream failed: " + e7.getMessage());
                    }
                    try {
                        return;
                    } catch (IOException unused2) {
                        return;
                    }
                } finally {
                    atomicBoolean.set(false);
                    try {
                        d0Var2.close();
                        break;
                    } catch (IOException unused3) {
                    }
                }
                break;
            case 18:
                cf cfVar2 = (cf) this.f927d;
                g2.d0 d0Var3 = (g2.d0) this.f928e;
                q9 q9Var = (q9) this.f929f;
                r9 r9Var = cfVar2.S;
                try {
                    try {
                        f1.c(d0Var3.f1577j, new te(cfVar2, q9Var), new te(cfVar2, q9Var));
                        break;
                    } catch (IOException e8) {
                        Log.w("TunnelManager", "RTC control-plane reader ended: ".concat(e8.getClass().getSimpleName()));
                        break;
                    }
                    try {
                        break;
                    } catch (IOException unused4) {
                    }
                    return;
                } finally {
                    try {
                        d0Var3.close();
                        break;
                    } catch (IOException unused5) {
                    }
                    r9Var.c(q9Var);
                }
            case 19:
                ve veVar = (ve) this.f927d;
                g2.k0 k0Var2 = (g2.k0) this.f928e;
                h2.e eVar5 = (h2.e) this.f929f;
                cf cfVar3 = veVar.f5338c;
                if (k0Var2 == cfVar3.D && cfVar3.f3739y0 != null && k0Var2.V(cfVar3.f3739y0) && eVar5.f1982d == cfVar3.f3739y0.f1982d) {
                    StringBuilder sb3 = new StringBuilder("Socket.IO media registered connectionGeneration=");
                    sb3.append(cfVar3.f3708i.get());
                    sb3.append(" gatewayGeneration=");
                    sb3.append(eVar5.f1982d);
                    sb3.append(" mediaTransport=");
                    sb3.append(k0Var2.R().f1641c ? "v2" : "v1");
                    Log.i("TunnelManager", sb3.toString());
                    cfVar3.D0("media_registered");
                    boolean z6 = cfVar3.H;
                    boolean z7 = cfVar3.I;
                    if (z6 && !z7) {
                        cfVar3.e(k0Var2);
                    }
                    if (cfVar3.J) {
                        cfVar3.d(k0Var2);
                    }
                    if (cfVar3.K) {
                        j6.b(cfVar3.B0, "hybrid:webp");
                        return;
                    }
                    return;
                }
                return;
            case 20:
                ve veVar2 = (ve) this.f927d;
                g2.k0 k0Var3 = (g2.k0) this.f928e;
                String str9 = (String) this.f929f;
                if (k0Var3 == veVar2.f5338c.D) {
                    StringBuilder sbK = a0.a.k("Socket.IO media degraded reason=", str9, " stats=");
                    sbK.append(k0Var3.R());
                    Log.w("TunnelManager", sbK.toString());
                    return;
                }
                return;
            case 21:
                ye yeVar = (ye) this.f927d;
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f928e;
                Network network = (Network) this.f929f;
                cf cfVar4 = yeVar.f5651b;
                cf.a(cfVar4, cf.b(cfVar4, connectivityManager, network, null));
                return;
            case 22:
                String[] strArr2 = (String[]) this.f927d;
                of ofVar = (of) this.f928e;
                CountDownLatch countDownLatch4 = (CountDownLatch) this.f929f;
                try {
                    strArr2[0] = ofVar.run();
                    return;
                } finally {
                    countDownLatch4.countDown();
                }
            default:
                x1.r rVar = (x1.r) this.f927d;
                k6 k6Var2 = (k6) this.f928e;
                Handler handler = (Handler) this.f929f;
                AtomicBoolean atomicBoolean2 = k6Var2.f4397b;
                if (atomicBoolean2.get() && l6.c("permission_polling")) {
                    if (!rVar.b()) {
                        x1.r.o();
                        return;
                    }
                    rVar.k();
                    if (atomicBoolean2.get() && l6.c("permission_polling")) {
                        q0 q0Var = new q0(rVar, k6Var2, handler, 23);
                        if (!atomicBoolean2.get() || handler == null) {
                            return;
                        }
                        try {
                            if (handler.postDelayed(new a2.h(k6Var2, q0Var, 26), 180L)) {
                                return;
                            }
                            k6Var2.b(new IllegalStateException("handler rejected delayed job"));
                            return;
                        } catch (Throwable th5) {
                            k6Var2.b(th5);
                            return;
                        }
                    }
                    return;
                }
                return;
        }
    }
}
