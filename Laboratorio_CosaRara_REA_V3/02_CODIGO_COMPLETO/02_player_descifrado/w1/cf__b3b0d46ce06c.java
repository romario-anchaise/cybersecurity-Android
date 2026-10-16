// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.SocketFactory;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.defense.RemoteControlReceiver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class cf {
    public static final long D0 = Math.max(1L, System.currentTimeMillis());
    public static final long E0 = SystemClock.elapsedRealtime();
    public static final Pattern F0 = Pattern.compile("[A-Za-z0-9_-]{1,64}");
    public static final Pattern G0 = Pattern.compile("[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?:[eE][+-]?\\d+)?");
    public static volatile cf H0;
    public final AtomicBoolean A;
    public volatile String A0;
    public int B;
    public volatile Context B0;
    public final Object C;
    public boolean C0;
    public volatile g2.k0 D;
    public volatile bd E;
    public volatile g2.m0 F;
    public volatile g2.m0 G;
    public volatile boolean H;
    public volatile boolean I;
    public volatile boolean J;
    public volatile boolean K;
    public volatile boolean L;
    public volatile int M;
    public final h6 N;
    public final h6 O;
    public final AtomicLong P;
    public volatile e2.g1 Q;
    public String R;
    public final r9 S;
    public final d2.t T;
    public volatile n6 U;
    public volatile long V;
    public int W;
    public long X;
    public long Y;
    public h2.b Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f3693a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public long f3695b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f3697c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f3699d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public long f3701e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ue f3702f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f3703f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f3704g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f3705g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public d0.d f3707h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public String f3709i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c2.t f3710j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f3711j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f3712k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public long f3713k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h2.k f3714l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public af f3715l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Network f3716m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f3717m0;
    public int n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public long f3718n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3719o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f3720o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3721p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public long f3722p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f3723q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f3724q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final j2 f3725r;
    public boolean r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final h2.b f3726s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public volatile g2.a0 f3727s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final n1 f3728t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public h2.g f3729t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final l2.d f3730u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public volatile ScreenMirrorService f3731u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l2.d f3732v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public volatile f3 f3733v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicReference f3734w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public volatile long f3735w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicBoolean f3736x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f3737x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile q.t f3738y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public volatile h2.e f3739y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile j0 f3740z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public volatile h2.i f3741z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f3692a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f3694b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f3696c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f3698d = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f3700e = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile h2.c f3706h = h2.c.f1960c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f3708i = new AtomicInteger();

    public cf() {
        c2.t tVar = new c2.t();
        tVar.f458a = Integer.MIN_VALUE;
        tVar.f459b = Long.MIN_VALUE;
        this.f3710j = tVar;
        this.f3712k = new AtomicInteger();
        h2.k kVar = new h2.k();
        kVar.f2057a = Integer.MIN_VALUE;
        this.f3714l = kVar;
        this.f3719o = Integer.MIN_VALUE;
        this.f3721p = Integer.MIN_VALUE;
        this.f3723q = new AtomicInteger(-1);
        this.f3725r = new j2();
        this.f3726s = new h2.b();
        this.f3728t = new n1(1);
        this.f3730u = new l2.d("telemetry-report");
        this.f3732v = new l2.d("app-guard-report");
        this.f3734w = new AtomicReference();
        this.f3736x = new AtomicBoolean();
        this.A = new AtomicBoolean();
        this.B = Integer.MIN_VALUE;
        this.C = new Object();
        this.M = 2;
        this.N = new h6();
        this.O = new h6();
        this.P = new AtomicLong();
        this.Q = new m0(6);
        this.R = "";
        this.S = new r9(new ge(this, 4), new ge(this, 7));
        ve veVar = new ve(this);
        d2.t tVar2 = new d2.t();
        tVar2.f613d = veVar;
        tVar2.f612c = -1L;
        this.T = tVar2;
        this.U = new n6(0, "", false, false);
        this.f3703f0 = -1L;
        this.f3709i0 = "";
        this.f3737x0 = -1;
        this.f3741z0 = new h2.i();
        this.A0 = "";
        this.C0 = false;
        HandlerThread handlerThread = new HandlerThread("tunnel-state");
        handlerThread.start();
        this.f3704g = new Handler(handlerThread.getLooper());
        this.f3702f = new ue(this);
    }

    public static boolean C0(h2.c cVar) {
        return cVar == h2.c.f1965h || cVar == h2.c.f1967j || cVar == h2.c.f1963f || cVar == h2.c.f1964g || cVar == h2.c.f1966i || cVar == h2.c.f1961d || cVar == h2.c.f1962e;
    }

    public static void F(Context context, String str, String str2) {
        String str3;
        String strR = R(str2, "packageName");
        String strR2 = R(str2, "requestId");
        if (strR.isEmpty() && str.contains(":")) {
            strR = str.substring(str.indexOf(58) + 1).trim();
        }
        String str4 = strR;
        x1.w wVarB = x1.w.b(context);
        if (str4 != null) {
            wVarB.getClass();
            if (!str4.trim().isEmpty()) {
                if (!wVarB.d(str4)) {
                    wVarB.k("not_installed", str4, strR2, "package is not installed", "connection_service");
                    return;
                }
                wVarB.k("received", str4, strR2, null, "connection_service");
                x1.x xVar = x1.x.f5960m;
                if (xVar != null) {
                    xVar.a(str4);
                } else if (x1.a.f5836e != null) {
                    x1.a.a(str4);
                }
                if (x1.w.e(str4, strR2)) {
                    str3 = "trampoline_start_requested_accessibility";
                } else {
                    try {
                        Context context2 = wVarB.f5943a;
                        context2.startActivity(y.f.b(context2, str4, strR2));
                        str3 = "trampoline_start_requested_service";
                    } catch (Exception e3) {
                        String message = e3.getMessage();
                        if (message == null) {
                            message = e3.getClass().getSimpleName();
                        }
                        wVarB.k("error", str4, strR2, message, "connection_service");
                        return;
                    }
                }
                wVarB.k(str3, str4, strR2, null, "connection_service");
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (wVarB.f5945c.put(str4, Long.valueOf(jCurrentTimeMillis)) != null) {
                    return;
                }
                wVarB.f5944b.postDelayed(new x1.t(wVarB, str4, jCurrentTimeMillis, strR2, 0), 3000L);
                return;
            }
        }
        wVarB.k("error", "", strR2, "missing packageName", "connection_service");
    }

    public static cf K() {
        cf cfVar;
        cf cfVar2 = H0;
        if (cfVar2 != null) {
            return cfVar2;
        }
        synchronized (cf.class) {
            try {
                if (H0 == null) {
                    H0 = new cf();
                }
                cfVar = H0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cfVar;
    }

    public static boolean M(int i3, Object obj, int i4, Object obj2, boolean z2) {
        return z2 && i3 == i4 && obj == obj2;
    }

    public static String M0(String str) {
        if (!str.startsWith("telemetry:ping:")) {
            return null;
        }
        String strSubstring = str.substring(15);
        if (F0.matcher(strSubstring).matches()) {
            return a0.a.h("{\"type\":\"telemetry_pong\",\"nonce\":\"", strSubstring, "\"}");
        }
        return null;
    }

    public static boolean N(int i3, g2.a0 a0Var, int i4, Object obj, boolean z2) {
        return z2 && i3 == i4 && a0Var != null && a0Var == obj;
    }

    public static boolean Q(String str) {
        return (str == null || str.contains("\n") || str.contains("\r") || str.getBytes(StandardCharsets.UTF_8).length > 16384) ? false : true;
    }

    public static String R(String str, String str2) {
        if (str != null && !str.isEmpty()) {
            try {
                return new JSONObject(str).optString(str2, "");
            } catch (JSONException unused) {
            }
        }
        return "";
    }

    public static String Y(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ok", false);
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "{\"ok\":false,\"error\":\"unknown\"}";
        }
    }

    public static void a(final cf cfVar, n6 n6Var) {
        if (n6Var == null) {
            cfVar.getClass();
            return;
        }
        int i3 = cfVar.f3712k.get();
        int i4 = n6Var.f4634a;
        if (i4 < i3) {
            Log.i("TunnelManager", "ignoring stale network snapshot gen=" + n6Var.f4634a + " current=" + i3);
            return;
        }
        if (i4 == i3 && n6Var.equals(cfVar.U)) {
            return;
        }
        if (n6Var.f4634a != i3 || n6Var.f4635b != cfVar.U.f4635b) {
            cfVar.k("network_changed");
        }
        cfVar.n++;
        boolean z2 = !cfVar.U.f4635b && n6Var.f4635b;
        cfVar.f3712k.set(n6Var.f4634a);
        cfVar.U = n6Var;
        if (n6Var.f4635b && n6Var.f4636c) {
            cfVar.V = SystemClock.elapsedRealtime();
        }
        if (cfVar.r0) {
            Log.i("TunnelManager", "registration terminal rejection remains parked across same-network capability change gen=" + n6Var.f4634a + " validated=" + n6Var.f4636c);
            return;
        }
        if (n6Var.f4635b && (cfVar.f3706h == h2.c.f1965h || cfVar.f3706h == h2.c.f1967j)) {
            h2.k kVar = cfVar.f3714l;
            int i5 = n6Var.f4634a;
            boolean z3 = n6Var.f4636c;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            kVar.getClass();
            long jMax = Math.max(0L, jElapsedRealtime);
            if (i5 != kVar.f2057a) {
                kVar.f2057a = i5;
                kVar.f2058b = z3 ? jMax : h2.k.c(jMax, 8000L);
                kVar.f2059c = 0L;
                kVar.f2061e = true;
                kVar.f2062f = z3;
            } else if (!kVar.f2061e || kVar.f2062f != z3) {
                kVar.f2058b = z3 ? jMax : h2.k.c(jMax, 8000L);
            }
            kVar.f2060d = false;
            if (z3) {
                kVar.f2058b = jMax;
                kVar.f2059c = 0L;
            }
            kVar.f2061e = true;
            kVar.f2062f = z3;
            Log.d("TunnelManager", "network snapshot changed while ONLINE; keep session (gen=" + n6Var.f4634a + " validated=" + n6Var.f4636c + ")");
            return;
        }
        c2.t tVarB = cfVar.f3714l.b(n6Var.f4634a, n6Var.f4635b, n6Var.f4636c, SystemClock.elapsedRealtime());
        boolean z4 = n6Var.f4635b;
        h2.c cVar = cfVar.f3706h;
        if (!z4) {
            if (cVar != h2.c.f1965h) {
                h2.c cVar2 = cfVar.f3706h;
                h2.c cVar3 = h2.c.f1967j;
                if (cVar2 != cVar3) {
                    if (cfVar.f3705g0 || cfVar.f3706h == h2.c.f1963f || cfVar.f3706h == h2.c.f1964g || cfVar.f3706h == cVar3) {
                        cfVar.T();
                    }
                    int i6 = cfVar.f3708i.get();
                    cfVar.f3725r.d(i6);
                    int iIncrementAndGet = cfVar.f3708i.incrementAndGet();
                    cfVar.f3725r.e(iIncrementAndGet);
                    cfVar.L0(1, i6, "network_changed");
                    h2.g gVar = cfVar.f3729t0;
                    cfVar.f3729t0 = null;
                    cfVar.f3694b.set(false);
                    cfVar.f3721p = Integer.MIN_VALUE;
                    cfVar.f3719o = Integer.MIN_VALUE;
                    h2.c cVar4 = cfVar.f3706h;
                    h2.c cVar5 = h2.c.f1961d;
                    if (cVar4 != cVar5) {
                        cfVar.N0(cVar5, 1, gVar);
                    }
                    cfVar.h0(1, gVar, false, false, 0, 0L);
                    Log.i("TunnelManager", "network unusable; invalidated tunnel generation=" + iIncrementAndGet);
                    return;
                }
            }
            cfVar.a0(3000L, new ne(cfVar, n6Var.f4634a, 3));
            return;
        }
        h2.c cVar6 = h2.c.f1963f;
        if ((cVar == cVar6 || cfVar.f3706h == h2.c.f1964g) && n6Var.f4634a == cfVar.f3721p) {
            Log.d("TunnelManager", "network capability changed during connection attempt; keep generation=" + cfVar.f3708i.get() + " networkGeneration=" + n6Var.f4634a);
            return;
        }
        if (tVarB.f458a == 2) {
            if (tVarB.f459b < 0) {
                return;
            }
            cfVar.I(h2.c.f1962e, 1, "network_validation");
            cfVar.t0(n6Var.f4634a, tVarB.f459b);
            return;
        }
        if (z2 && !cfVar.f3711j0 && !cfVar.f3697c0) {
            cfVar.f3726s.getClass();
            cfVar.W = 0;
            cfVar.X = 0L;
            cfVar.Y = 0L;
            cfVar.i();
        }
        final boolean z5 = tVarB.f458a == 4;
        if (cfVar.f3706h == h2.c.f1960c || cfVar.f3706h == h2.c.f1961d || cfVar.f3706h == h2.c.f1962e) {
            final int i7 = n6Var.f4634a;
            final int i8 = cfVar.f3708i.get();
            final int i9 = 0;
            cfVar.a0(0L, new Runnable(cfVar) { // from class: w1.re

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ cf f5031d;

                {
                    this.f5031d = cfVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i9) {
                        case 0:
                            cf cfVar2 = this.f5031d;
                            int i10 = cfVar2.f3708i.get();
                            int i11 = i8;
                            int i12 = i7;
                            boolean z6 = z5;
                            if (i10 == i11 && cfVar2.f3712k.get() == i12 && cfVar2.L(i12, z6)) {
                                cfVar2.G0("network_changed", z6);
                            } else if (z6) {
                                cfVar2.f3714l.a(i12);
                            }
                            break;
                        default:
                            cf cfVar3 = this.f5031d;
                            int i13 = cfVar3.f3708i.get();
                            int i14 = i8;
                            int i15 = i7;
                            boolean z7 = z5;
                            if (i13 == i14 && cfVar3.f3712k.get() == i15 && cfVar3.L(i15, z7)) {
                                cfVar3.G0("network_changed", z7);
                            } else if (z7) {
                                cfVar3.f3714l.a(i15);
                            }
                            break;
                    }
                }
            });
            return;
        }
        if (cfVar.f3706h == h2.c.f1966i) {
            final int i10 = n6Var.f4634a;
            final int i11 = cfVar.f3708i.get();
            final int i12 = 1;
            cfVar.a0(0L, new Runnable(cfVar) { // from class: w1.re

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ cf f5031d;

                {
                    this.f5031d = cfVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i12) {
                        case 0:
                            cf cfVar2 = this.f5031d;
                            int i13 = cfVar2.f3708i.get();
                            int i14 = i11;
                            int i15 = i10;
                            boolean z6 = z5;
                            if (i13 == i14 && cfVar2.f3712k.get() == i15 && cfVar2.L(i15, z6)) {
                                cfVar2.G0("network_changed", z6);
                            } else if (z6) {
                                cfVar2.f3714l.a(i15);
                            }
                            break;
                        default:
                            cf cfVar3 = this.f5031d;
                            int i16 = cfVar3.f3708i.get();
                            int i17 = i11;
                            int i18 = i10;
                            boolean z7 = z5;
                            if (i16 == i17 && cfVar3.f3712k.get() == i18 && cfVar3.L(i18, z7)) {
                                cfVar3.G0("network_changed", z7);
                            } else if (z7) {
                                cfVar3.f3714l.a(i18);
                            }
                            break;
                    }
                }
            });
            return;
        }
        if (cfVar.f3706h == h2.c.f1964g || cfVar.f3706h == cVar6) {
            final int i13 = n6Var.f4634a;
            final int i14 = cfVar.f3708i.get();
            final int i15 = 1;
            cfVar.a0(0L, new Runnable(cfVar) { // from class: w1.re

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ cf f5031d;

                {
                    this.f5031d = cfVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i15) {
                        case 0:
                            cf cfVar2 = this.f5031d;
                            int i16 = cfVar2.f3708i.get();
                            int i17 = i14;
                            int i18 = i13;
                            boolean z6 = z5;
                            if (i16 == i17 && cfVar2.f3712k.get() == i18 && cfVar2.L(i18, z6)) {
                                cfVar2.G0("network_changed", z6);
                            } else if (z6) {
                                cfVar2.f3714l.a(i18);
                            }
                            break;
                        default:
                            cf cfVar3 = this.f5031d;
                            int i19 = cfVar3.f3708i.get();
                            int i110 = i14;
                            int i111 = i13;
                            boolean z7 = z5;
                            if (i19 == i110 && cfVar3.f3712k.get() == i111 && cfVar3.L(i111, z7)) {
                                cfVar3.G0("network_changed", z7);
                            } else if (z7) {
                                cfVar3.f3714l.a(i111);
                            }
                            break;
                    }
                }
            });
        }
    }

    public static n6 b(cf cfVar, ConnectivityManager connectivityManager, Network network, NetworkCapabilities networkCapabilities) {
        String str;
        AtomicInteger atomicInteger = cfVar.f3712k;
        if (network == null) {
            return new n6(atomicInteger.get(), "", false, false);
        }
        if (!network.equals(cfVar.f3716m)) {
            cfVar.f3716m = network;
            atomicInteger.incrementAndGet();
        }
        if (networkCapabilities == null) {
            networkCapabilities = connectivityManager.getNetworkCapabilities(network);
        }
        if (networkCapabilities == null) {
            return new n6(atomicInteger.get(), "", false, false);
        }
        boolean zHasCapability = networkCapabilities.hasCapability(12);
        boolean zHasCapability2 = networkCapabilities.hasCapability(16);
        if (networkCapabilities.hasTransport(1)) {
            str = "wifi";
        } else if (networkCapabilities.hasTransport(0)) {
            str = "cellular";
        } else {
            str = networkCapabilities.hasTransport(3) ? "ethernet" : "other";
        }
        return new n6(atomicInteger.get(), str, zHasCapability, zHasCapability2);
    }

    public static void c0(JSONObject jSONObject, String str, g2.i0 i0Var) throws JSONException {
        if (i0Var == null) {
            return;
        }
        String strConcat = "media".concat(str);
        jSONObject.put(strConcat.concat("Produced"), i0Var.f1612a);
        jSONObject.put(strConcat.concat("Sent"), i0Var.f1613b);
        jSONObject.put(strConcat.concat("Superseded"), i0Var.f1614c);
        jSONObject.put(strConcat.concat("Failed"), i0Var.f1615d);
        jSONObject.put(strConcat.concat("Timeouts"), i0Var.f1625o);
        jSONObject.put(strConcat.concat("Nacks"), i0Var.f1626p);
        jSONObject.put(strConcat.concat("EnqueueToSendLastUs"), ScreenMirrorService.Q(i0Var.f1627q));
        jSONObject.put(strConcat.concat("EnqueueToSendAvgUs"), ScreenMirrorService.Q(i0Var.f1628r));
        jSONObject.put(strConcat.concat("EnqueueToSendMaxUs"), ScreenMirrorService.Q(i0Var.f1629s));
        jSONObject.put(strConcat.concat("SendLastUs"), ScreenMirrorService.Q(i0Var.f1630t));
        jSONObject.put(strConcat.concat("SendAvgUs"), ScreenMirrorService.Q(i0Var.f1631u));
        jSONObject.put(strConcat.concat("SendMaxUs"), ScreenMirrorService.Q(i0Var.f1632v));
        jSONObject.put(strConcat.concat("AckLastMs"), ScreenMirrorService.P(i0Var.f1621j));
        jSONObject.put(strConcat.concat("AckAvgMs"), ScreenMirrorService.P(i0Var.f1622k));
        jSONObject.put(strConcat.concat("AckP95Ms"), ScreenMirrorService.P(i0Var.n));
        jSONObject.put(strConcat.concat("AckMaxMs"), ScreenMirrorService.P(i0Var.f1623l));
    }

    public static String e0(g2.d0 d0Var) throws IOException {
        FutureTask futureTask = new FutureTask(new pe(d0Var));
        Thread thread = new Thread(futureTask, "a11y-enabled-ack-read");
        thread.setDaemon(true);
        thread.start();
        try {
            return (String) futureTask.get(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e3) {
            futureTask.cancel(true);
            Thread.currentThread().interrupt();
            throw new IOException("a11y_enabled ACK interrupted", e3);
        } catch (ExecutionException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            throw new IOException("a11y_enabled ACK failed", cause);
        } catch (TimeoutException e5) {
            futureTask.cancel(true);
            try {
                d0Var.close();
            } catch (IOException unused) {
            }
            throw new IOException("a11y_enabled ACK timeout", e5);
        }
    }

    public static String f0(g2.b0 b0Var) throws IOException {
        int i3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] bArr = new byte[4096];
        while (byteArrayOutputStream.size() < 262144 && (i3 = b0Var.read(bArr, 0, Math.min(4096, 262144 - byteArrayOutputStream.size()))) >= 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    i4 = -1;
                    break;
                }
                if (bArr[i4] == 10) {
                    break;
                }
                i4++;
            }
            if (i4 >= 0) {
                i3 = i4;
            }
            byteArrayOutputStream.write(bArr, 0, i3);
            if (i4 >= 0) {
                break;
            }
        }
        if (byteArrayOutputStream.size() < 262144) {
            return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8).trim();
        }
        o2.l("meta_command_too_large");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX WARN: Code duplicated, block: B:9:0x003b  */
    public static h2.h g(Context context) {
        boolean z2;
        boolean z3;
        boolean z4;
        h2.h hVar = new h2.h();
        hVar.f2027a = 2;
        boolean z5 = true;
        hVar.f2028b = true;
        hVar.f2029c = true;
        hVar.f2030d = true;
        hVar.f2031e = true;
        hVar.f2032f = true;
        hVar.f2033g = true;
        int i3 = Build.VERSION.SDK_INT;
        hVar.f2034h = true;
        hVar.f2035i = true;
        hVar.f2036j = true;
        hVar.f2037k = true;
        hVar.f2038l = true;
        hVar.f2039m = true;
        hVar.n = true;
        hVar.f2040o = true;
        hVar.f2041p = true;
        try {
            if (context.checkSelfPermission("android.permission.READ_SMS") == 0) {
                z2 = true;
            } else {
                try {
                    if (context.checkSelfPermission("android.permission.SEND_SMS") == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
        hVar.f2042q = z2;
        hVar.f2043r = false;
        hVar.f2044s = true;
        try {
            z3 = context.checkSelfPermission("android.permission.CAMERA") == 0;
        } catch (Throwable unused3) {
        }
        hVar.f2045t = z3;
        hVar.f2046u = n.F(context);
        hVar.f2047v = n.D(context);
        if (i3 >= 33) {
            try {
                if (context.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
            } catch (Throwable unused4) {
            }
        } else {
            z4 = true;
        }
        hVar.f2048w = z4;
        hVar.f2049x = context.getPackageManager().canRequestPackageInstalls();
        hVar.f2050y = true;
        hVar.f2051z = true;
        synchronized (f2.l.f1249t) {
            try {
                if (f2.l.f1251v != -1 || f2.l.f1250u == null) {
                    z5 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        hVar.A = z5;
        return hVar;
    }

    public static int h(h2.h hVar) {
        int i3 = hVar.f2039m ? 7 : 3;
        int i4 = i3 | 24;
        if (hVar.f2042q) {
            i4 = i3 | 56;
        }
        if (hVar.f2043r) {
            i4 |= 64;
        }
        if (hVar.f2044s) {
            i4 |= 128;
        }
        if (hVar.f2045t) {
            i4 |= 256;
        }
        if (hVar.f2046u) {
            i4 |= 512;
        }
        if (hVar.f2047v) {
            i4 |= 1024;
        }
        if (hVar.f2048w) {
            i4 |= 2048;
        }
        if (hVar.f2049x) {
            i4 |= 4096;
        }
        if (hVar.f2050y) {
            i4 |= 16384;
        }
        if (hVar.f2032f) {
            i4 |= 32768;
        }
        if (hVar.f2051z) {
            i4 |= 65536;
        }
        if (hVar.A) {
            i4 |= 131072;
        }
        if (hVar.f2041p) {
            i4 |= 262144;
        }
        if (hVar.f2035i) {
            i4 |= 524288;
        }
        if (hVar.f2027a == 2) {
            i4 |= 1048576;
        }
        if (hVar.f2028b) {
            i4 |= 2097152;
        }
        if (hVar.f2029c) {
            i4 |= 4194304;
        }
        if (hVar.f2030d) {
            i4 |= 8388608;
        }
        if (hVar.f2031e) {
            i4 |= 16777216;
        }
        if (hVar.f2037k) {
            i4 |= 67108864;
        }
        if (hVar.f2036j) {
            i4 |= 134217728;
        }
        if (hVar.n) {
            i4 |= 8192;
        }
        if (hVar.f2040o) {
            i4 |= 268435456;
        }
        if (hVar.f2034h) {
            i4 |= 536870912;
        }
        if (hVar.f2033g) {
            i4 |= 1073741824;
        }
        return hVar.f2038l ? Integer.MIN_VALUE | i4 : i4;
    }

    public static void l(g2.d0 d0Var, String str) {
        if (d0Var == null) {
            return;
        }
        if (str != null) {
            try {
                if (!str.isEmpty() && !"closed".equals(str) && !"eof".equals(str)) {
                    if (str.length() > 256) {
                        str = str.substring(0, 256);
                    }
                    d0Var.d(new IOException(str), true);
                    return;
                }
            } catch (IOException unused) {
                return;
            }
        }
        d0Var.d(null, true);
    }

    public static void o(OutputStream outputStream) {
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException unused) {
        }
    }

    public static void q(e3 e3Var, boolean z2) {
        try {
            e3Var.b(z2);
        } catch (RuntimeException e3) {
            Log.w("TunnelManager", "meta report completion failed: " + e3.getMessage());
        }
    }

    public static int r(String str) {
        return ("network_changed".equals(str) || "network_validation".equals(str)) ? 1 : 10;
    }

    public static void r0(String str, Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            Log.e("TunnelManager", "unlocked online feature failed name=".concat(str), th);
        }
    }

    public final String A(String str) {
        if (str.startsWith("sync:")) {
            try {
                byte[] bArrDecode = Base64.decode(str.substring(5).trim(), 11);
                if (bArrDecode.length > 1048576) {
                    return "{\"ok\":false,\"error\":\"inject_payload_too_large\"}";
                }
                Context context = this.B0;
                return context == null ? "{\"ok\":false,\"error\":\"no_context\"}" : b1.b(context).a(new String(bArrDecode, StandardCharsets.UTF_8));
            } catch (Throwable unused) {
                return "{\"ok\":false,\"error\":\"invalid_inject_payload\"}";
            }
        }
        if (!str.startsWith("disarm:")) {
            return "{\"ok\":false,\"error\":\"unknown_inject_action\"}";
        }
        String strTrim = str.substring(7).trim();
        if (strTrim.isEmpty() || strTrim.length() > 64) {
            return "{\"ok\":false,\"error\":\"invalid_rule_id\"}";
        }
        Context context2 = this.B0;
        if (context2 != null) {
            try {
                b1 b1VarB = b1.b(context2);
                synchronized (b1VarB) {
                    b1VarB.c(strTrim);
                }
            } catch (Throwable unused2) {
            }
        }
        ScreenMirrorService screenMirrorServiceQ0 = Q0(2000L);
        if (screenMirrorServiceQ0 == null) {
            return "{\"ok\":true}";
        }
        r4 r4VarB = r4.b();
        try {
            b1 b1VarB2 = b1.b(screenMirrorServiceQ0);
            synchronized (b1VarB2) {
                b1VarB2.c(strTrim);
            }
        } catch (Throwable unused3) {
        }
        if (strTrim.equals(r4VarB.f4979c)) {
            r4VarB.f4979c = null;
        }
        if (!strTrim.equals(r4VarB.f4980d)) {
            return "{\"ok\":true}";
        }
        r4VarB.f4980d = null;
        p9.o(new o2(7));
        return "{\"ok\":true}";
    }

    public final void A0(String str, JSONObject jSONObject) {
        w0(str + "\t" + jSONObject.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ac, code lost:
    
        if (r5.equals(r2) == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String B(java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.cf.B(java.lang.String):java.lang.String");
    }

    public final void B0(d2.t tVar) {
        e2.g1 m0Var = tVar == null ? new m0(7) : tVar;
        synchronized (this.T) {
            try {
                this.Q = m0Var;
                if (tVar != null) {
                    d2.t tVar2 = this.T;
                    synchronized (tVar2) {
                        long j3 = tVar2.f612c;
                        if (j3 >= 0) {
                            try {
                                m0Var.g(j3);
                                e2.c1 c1Var = (e2.c1) tVar2.f614e;
                                if (c1Var != null) {
                                    m0Var.a(c1Var);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:277:0x0489, code lost:
    
        if (r18.equals("show") != false) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x048c, code lost:
    
        r3 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0494, code lost:
    
        if (r18.equals("mute") != false) goto L283;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0497, code lost:
    
        r3 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x049f, code lost:
    
        if (r18.equals("hide") != false) goto L287;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x04a2, code lost:
    
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x04aa, code lost:
    
        if (r18.equals("unmute") != false) goto L291;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x04ad, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x04b5, code lost:
    
        if (r18.equals("status") != false) goto L295;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x04b8, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x04b9, code lost:
    
        switch(r3) {
            case 0: goto L315;
            case 1: goto L313;
            case 2: goto L311;
            case 3: goto L305;
            case 4: goto L299;
            default: goto L297;
        };
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v35 int, still in use, count: 2, list:
  (r3v35 int) from 0x009b: INVOKE (r1v50 android.media.AudioManager), (r3v35 int) VIRTUAL call: android.media.AudioManager.getStreamMaxVolume(int):int A[Catch: all -> 0x00b1, MD:(int):int (c), WRAPPED] (LINE:156)
  (r3v35 int) from 0x00a8: INVOKE 
  (r1v50 android.media.AudioManager)
  (r3v35 int)
  (wrap int:0x00a4: INVOKE 
  (wrap float:0x00a3: ARITH (wrap float:0x00a0: CAST (float) (wrap int:0x009f: ARITH (wrap int:0x009b: INVOKE (r1v50 android.media.AudioManager), (r3v35 int) VIRTUAL call: android.media.AudioManager.getStreamMaxVolume(int):int A[Catch: all -> 0x00b1, MD:(int):int (c), WRAPPED] (LINE:156)) * (r2v67 int) A[Catch: all -> 0x00b1, WRAPPED] (LINE:160))) / (100.0f float) A[Catch: all -> 0x00b1, WRAPPED] (LINE:164))
 STATIC call: java.lang.Math.round(float):int A[Catch: all -> 0x00b1, MD:(float):int (c), WRAPPED] (LINE:165))
  (0 int)
 VIRTUAL call: android.media.AudioManager.setStreamVolume(int, int, int):void A[Catch: all -> 0x00b1, MD:(int, int, int):void (c)] (LINE:169)
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
    	at jadx.core.utils.InsnRemover.removeAllMarked(InsnRemover.java:276)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:354)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String C(java.lang.String r18) {
        /*
            Method dump skipped, instruction units count: 1484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.cf.C(java.lang.String):java.lang.String");
    }

    public final String D() {
        boolean z2;
        ScreenMirrorService screenMirrorServiceQ0 = Q0(30000L);
        if (screenMirrorServiceQ0 == null) {
            return "{\"ok\":false,\"error\":\"service_not_bound\"}";
        }
        boolean zI4 = screenMirrorServiceQ0.i4();
        screenMirrorServiceQ0.o("operator_disabled_h264");
        if (zI4) {
            long j3 = screenMirrorServiceQ0.d4;
            if (j3 >= 0) {
                screenMirrorServiceQ0.d4 = -1L;
                screenMirrorServiceQ0.i7();
                e2.s1 s1Var = screenMirrorServiceQ0.a4;
                if (s1Var != null) {
                    s1Var.g(j3);
                }
                Log.i("ScreenMirror", "H.264 disabled by operator; accessibility WebP fallback requested");
            } else {
                screenMirrorServiceQ0.j7();
                screenMirrorServiceQ0.i7();
                screenMirrorServiceQ0.X6();
                Log.i("ScreenMirror", "H.264 disabled by operator; JPEG fallback active");
            }
            z2 = true;
        } else {
            z2 = false;
        }
        return "{\"ok\":true,\"codec\":\"JPEG\",\"changed\":" + z2 + "}";
    }

    public final void D0(String str) {
        long jIncrementAndGet = this.P.incrementAndGet();
        ScreenMirrorService screenMirrorService = this.f3731u0;
        if (screenMirrorService != null) {
            screenMirrorService.L4(this.M, jIncrementAndGet, this.L);
        }
        StringBuilder sbJ = a0.a.j(jIncrementAndGet, "node publisher cycle=", " protocol=v");
        sbJ.append(this.M);
        sbJ.append(" reason=");
        sbJ.append(str);
        Log.i("TunnelManager", sbJ.toString());
    }

    public final String E(String str) {
        String strS;
        if ("hide".equals(str)) {
            return p9.o(new o2(7));
        }
        if ("status".equals(str)) {
            synchronized (p9.f4838b) {
                strS = p9.s();
            }
            return strS;
        }
        if (!str.startsWith("show:")) {
            return "{\"ok\":false,\"error\":\"unknown_reminder_action\"}";
        }
        ScreenMirrorService screenMirrorServiceQ0 = Q0(5000L);
        if (screenMirrorServiceQ0 == null) {
            return "{\"ok\":false,\"error\":\"service_not_bound\"}";
        }
        try {
            byte[] bArrDecode = Base64.decode(str.substring(5).trim(), 11);
            return bArrDecode.length > 204800 ? "{\"ok\":false,\"error\":\"reminder_payload_too_large\"}" : p9.o(new d2.c(screenMirrorServiceQ0, new String(bArrDecode, StandardCharsets.UTF_8), 7));
        } catch (Throwable unused) {
            return "{\"ok\":false,\"error\":\"invalid_reminder_payload\"}";
        }
    }

    public final void E0(Context context, String str) {
        String strA = a4.a(str);
        if (strA == null) {
            Log.w("TunnelManager", "refusing to start tunnel with non-public WSS gateway URL");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.f3702f.execute(new ke(this, context, strA, 0));
    }

    public final void F0(int i3) {
        j0 j0Var;
        j0 j0Var2 = this.f3740z;
        this.f3740z = null;
        if (j0Var2 != null) {
            j0Var2.e();
        }
        Context context = this.B0;
        if (context == null) {
            return;
        }
        try {
            n.W(context);
            j0Var = new j0(context, new oe(i3, this));
            try {
                if (!j0Var.d()) {
                    throw new IllegalStateException("a11y reporter executor did not start");
                }
                this.f3740z = j0Var;
            } catch (Throwable th) {
                th = th;
                if (j0Var != null) {
                    j0Var.e();
                }
                this.f3740z = null;
                Log.e("TunnelManager", "a11y reporter start failed; scheduling retry", th);
                if (this.A.compareAndSet(false, true)) {
                    a0(5000L, new ge(this, 5));
                }
            }
        } catch (Throwable th2) {
            th = th2;
            j0Var = null;
        }
    }

    public final String G(String str) {
        if (str == null || str.isEmpty()) {
            return "{\"error\":\"empty_action\"}";
        }
        switch (str) {
            case "enable":
                y("wireless_adb");
                return "{\"ok\":true,\"action\":\"enable\"}";
            case "status":
                cg.h();
                return cg.f3745d.b().toString();
            case "pair":
                ScreenMirrorService screenMirrorServiceQ0 = Q0(30000L);
                if (screenMirrorServiceQ0 == null) {
                    return "{\"error\":\"service_not_bound\"}";
                }
                cg.i();
                screenMirrorServiceQ0.getApplicationContext().getMainExecutor().execute(new pa(screenMirrorServiceQ0, 26));
                long jCurrentTimeMillis = System.currentTimeMillis() + 45000;
                while (System.currentTimeMillis() < jCurrentTimeMillis) {
                    bg bgVar = cg.f3745d;
                    if (bgVar != null && bgVar.a()) {
                        return bgVar.b().toString();
                    }
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                cg.h();
                return cg.f3745d.b().toString();
            default:
                return "{\"error\":\"unknown_wireless_adb_action\",\"action\":\"" + str.replace("\"", "\\\"") + "\"}";
        }
    }

    public final void G0(String str, boolean z2) {
        n6 n6Var;
        String str2;
        String str3;
        String strTrim;
        String str4;
        if (v0()) {
            if (z2) {
                this.f3714l.a(this.f3712k.get());
                return;
            }
            return;
        }
        if (u0()) {
            if (z2) {
                this.f3714l.a(this.f3712k.get());
                return;
            }
            return;
        }
        if (!L(this.f3712k.get(), z2)) {
            if (z2) {
                this.f3714l.a(this.f3712k.get());
                return;
            }
            return;
        }
        if (this.f3705g0) {
            T();
        }
        int i3 = this.f3708i.get();
        this.f3725r.d(i3);
        int iIncrementAndGet = this.f3708i.incrementAndGet();
        this.f3725r.e(iIncrementAndGet);
        L0(r(str), i3, str);
        h2.g gVar = this.f3729t0;
        this.f3729t0 = null;
        int i4 = 0;
        this.f3694b.set(false);
        this.f3721p = this.f3712k.get();
        this.f3719o = z2 ? iIncrementAndGet : Integer.MIN_VALUE;
        S(r(str), gVar);
        h0(r(str), gVar, false, false, 0, 0L);
        if (iIncrementAndGet == this.f3708i.get() && (n6Var = this.U) != null && n6Var.f4635b) {
            if (!n6Var.f4636c) {
                h2.k kVar = this.f3714l;
                if (n6Var.f4634a != kVar.f2057a || !kVar.f2060d) {
                    return;
                }
            }
            if (z2 != (iIncrementAndGet == this.f3719o)) {
                return;
            }
            S(0, null);
            Context context = this.B0;
            String strA = a4.a(o0());
            if (context == null || strA == null || iIncrementAndGet != this.f3708i.get()) {
                if (strA == null) {
                    Log.w("TunnelManager", "connection generation rejected non-public WSS gateway URL");
                    return;
                }
                return;
            }
            this.A0 = strA;
            h2.h hVarG = g(context);
            this.f3737x0 = h(hVarG);
            try {
                str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Throwable unused) {
                str2 = "unknown";
            }
            y.c cVar = new y.c(strA, str2);
            AtomicReference atomicReference = new AtomicReference();
            SocketFactory socketFactoryP0 = (iIncrementAndGet != this.f3719o || this.U.f4636c) ? p0() : null;
            try {
                Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, "ro.vendor.oplus.market.name");
                str3 = objInvoke instanceof String ? (String) objInvoke : "";
            } catch (Throwable unused2) {
            }
            try {
                strTrim = str3.trim();
            } catch (Throwable unused3) {
                strTrim = "";
            }
            if (strTrim == null || strTrim.isEmpty()) {
                String str5 = Build.MODEL;
                str4 = str5 != null ? str5 : "";
            } else {
                str4 = strTrim;
            }
            g2.a0 a0Var = new g2.a0(context, cVar, hVarG, str4, new g.j(this, iIncrementAndGet, atomicReference), socketFactoryP0);
            atomicReference.set(a0Var);
            this.f3727s0 = a0Var;
            h2.c cVar2 = h2.c.f1964g;
            h2.g gVar2 = this.f3729t0;
            this.f3729t0 = null;
            N0(cVar2, 0, gVar2);
            g2.a0 a0Var2 = this.f3727s0;
            if (a0Var2.f1528s.compareAndSet(false, true)) {
                a0Var2.f1529t.set(false);
                a0Var2.f1530u.set(false);
                a0Var2.f1516h.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                a0Var2.V = jElapsedRealtime;
                a0Var2.I(g2.t.f1734d, jElapsedRealtime);
                a0Var2.D.set(jElapsedRealtime);
                a0Var2.E.set(jElapsedRealtime);
                a0Var2.J.set(jElapsedRealtime);
                a0Var2.K.set(g2.v.f1763c);
                y.l lVar = a0Var2.f1518i;
                synchronized (lVar) {
                    g2.e eVarK = lVar.k();
                    lVar.f5992d = new g2.e(eVarK.f1584a, -1L, eVarK.f1586c, eVarK.f1587d);
                }
                y.c cVar3 = a0Var2.f1520j;
                ((AtomicReference) cVar3.f5973e).set(g2.b.f1539e);
                ((AtomicBoolean) cVar3.f5972d).set(false);
                a0Var2.f1525p.scheduleWithFixedDelay(new g2.n(i4, a0Var2), 1000L, 1000L, TimeUnit.MILLISECONDS);
                w0.s sVar = a0Var2.f1514g;
                sVar.getClass();
                f1.b.a(new w0.p(sVar, i4));
            }
            this.f3692a.set(true);
            b0();
            a0.a.o(new StringBuilder("Socket.IO control started -> "), this.A0, "TunnelManager");
        }
    }

    public final void H(long j3) {
        if (c() != null || this.B0 == null) {
            return;
        }
        try {
            this.f3707h0 = k3.z(this.B0).D(j3);
        } catch (Throwable unused) {
            Log.w("TunnelManager", "open reconnect instability episode failed");
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0066  */
    /* JADX WARN: Code duplicated, block: B:20:0x0069  */
    /* JADX WARN: Code duplicated, block: B:26:0x0076 A[Catch: RuntimeException -> 0x00a3, TRY_LEAVE, TryCatch #2 {RuntimeException -> 0x00a3, blocks: (B:16:0x0058, B:17:0x005e, B:21:0x006a, B:23:0x0070, B:26:0x0076), top: B:80:0x0058 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x0076, please report this as an issue */
    public final boolean H0(Context context, String str) {
        boolean z2;
        boolean z3;
        long j3;
        boolean z4;
        int i3 = this.f3708i.get();
        h2.c cVar = this.f3706h;
        g2.a0 a0Var = this.f3727s0;
        String str2 = this.A0;
        this.B0 = context;
        if (this.f3693a0) {
            z2 = true;
            z3 = false;
        } else {
            this.f3693a0 = true;
            try {
                this.Z = new h2.b(context, 2);
                long jCurrentTimeMillis = System.currentTimeMillis();
                h2.l lVarA = this.Z.a(jCurrentTimeMillis);
                this.W = Math.max(this.W, lVarA.f2063a);
                this.f3711j0 = this.f3711j0 || lVarA.f2064b;
                long j4 = lVarA.f2065c;
                this.Y = j4;
                z2 = true;
                z3 = false;
                if (j4 > 0) {
                    try {
                        this.X = SystemClock.elapsedRealtime();
                        j3 = lVarA.f2066d;
                        this.f3695b0 = j3;
                        if (j3 > jCurrentTimeMillis) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        this.f3697c0 = z4;
                        if (this.W <= 0 || this.f3711j0 || j3 > jCurrentTimeMillis) {
                            Log.i("TunnelManager", "reconnect backoff restored attempt=" + this.W + " storm=" + this.f3711j0 + " remainingMs=" + Math.max(0L, this.f3695b0 - jCurrentTimeMillis));
                        }
                    } catch (RuntimeException unused) {
                        this.Z = null;
                        Log.w("TunnelManager", "reconnect backoff persistence unavailable");
                    }
                } else {
                    j3 = lVarA.f2066d;
                    this.f3695b0 = j3;
                    if (j3 > jCurrentTimeMillis) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    this.f3697c0 = z4;
                    if (this.W <= 0) {
                        Log.i("TunnelManager", "reconnect backoff restored attempt=" + this.W + " storm=" + this.f3711j0 + " remainingMs=" + Math.max(0L, this.f3695b0 - jCurrentTimeMillis));
                    } else {
                        Log.i("TunnelManager", "reconnect backoff restored attempt=" + this.W + " storm=" + this.f3711j0 + " remainingMs=" + Math.max(0L, this.f3695b0 - jCurrentTimeMillis));
                    }
                }
            } catch (RuntimeException unused2) {
                z2 = true;
                z3 = false;
            }
        }
        this.A0 = str;
        try {
            String strO0 = o0();
            this.A0 = str2;
            if (strO0.isEmpty()) {
                Log.w("TunnelManager", "refusing to start tunnel with unresolved gateway URL");
                return z3;
            }
            if ((this.f3706h == h2.c.f1965h || this.f3706h == h2.c.f1967j) && this.f3727s0 != null && !this.f3727s0.J() && strO0.equals(this.A0)) {
                Log.i("TunnelManager", "Socket.IO control already held -> ".concat(strO0));
                return z3;
            }
            h2.c cVar2 = this.f3706h;
            g2.a0 a0Var2 = this.f3727s0;
            String str3 = this.A0;
            if ((cVar2 == h2.c.f1963f || cVar2 == h2.c.f1964g) && a0Var2 != null && strO0.equals(str3)) {
                Log.i("TunnelManager", "Socket.IO handshake already in flight -> ".concat(strO0));
                return z3;
            }
            if (!O()) {
                r0("launcher-inventory", new a2.m(context, 14));
            }
            boolean z5 = !strO0.equals(str2);
            this.A0 = strO0;
            if (!this.C0) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager != null) {
                        connectivityManager.registerDefaultNetworkCallback(new ye(this, connectivityManager));
                        this.C0 = z2;
                        Log.i("TunnelManager", "network callback registered");
                    }
                } catch (Throwable th) {
                    a0.a.p(th, new StringBuilder("registerNetworkCallback failed: "), "TunnelManager");
                }
            }
            k("start");
            J("start", z5);
            return O0(i3, cVar, a0Var);
        } catch (Throwable th2) {
            this.A0 = str2;
            throw th2;
        }
    }

    public final void I(h2.c cVar, int i3, String str) {
        if (this.f3706h == cVar && this.f3727s0 == null) {
            return;
        }
        int i4 = this.f3708i.get();
        this.f3725r.d(i4);
        this.f3725r.e(this.f3708i.incrementAndGet());
        L0(i3, i4, str);
        h2.g gVar = this.f3729t0;
        this.f3729t0 = null;
        this.f3694b.set(false);
        this.f3721p = Integer.MIN_VALUE;
        this.f3719o = Integer.MIN_VALUE;
        if (this.f3706h != cVar) {
            N0(cVar, i3, gVar);
        }
        h0(i3, gVar, false, false, 0, 0L);
    }

    public final void I0(int i3) {
        boolean zO = O();
        boolean z2 = this.f3694b.get();
        int i4 = this.f3708i.get();
        int i5 = this.B;
        if (zO || !z2 || i3 != i4 || i3 == i5) {
            if (zO) {
                Log.i("TunnelManager", "unlock continuation deferred: user still locked");
                return;
            }
            return;
        }
        this.B = i3;
        Context context = this.B0;
        r0("launcher-inventory", new a2.m(context, 15));
        r0("telemetry-reporter", new ne(this, i3, 0));
        r0("credential-outbox-reporter", new ne(this, i3, 1));
        r0("a11y-event-outbox-reporter", new ne(this, i3, 2));
        r0("app-guard-status-flush", new ge(this, 1));
        r0("stats-flush", new ge(this, 2));
        if (context != null) {
            r0("process-exit-report", new a2.m(context, 16));
            r0("disconnect-incident-report", new a2.m(context, 17));
            r0("socket-connected-keepalive", new a2.m(context, 18));
            r0("authorization-route-flush", new a2.m(context, 19));
            r0("a11y-enabled-report", new me(this, context, 0));
        }
        Log.i("TunnelManager", "unlocked online features started generation=" + i3);
    }

    public final void J(String str, boolean z2) {
        boolean z3;
        n6 n6VarD0;
        h2.c cVar = this.f3706h;
        g2.a0 a0Var = this.f3727s0;
        int i3 = this.f3712k.get();
        int i4 = this.f3721p;
        if ((cVar != h2.c.f1963f && cVar != h2.c.f1964g) || a0Var == null || z2) {
            z3 = false;
        } else {
            z3 = !(("network_changed".equals(str) || "network_validation".equals(str)) && i3 != i4);
        }
        if (z3) {
            Log.i("TunnelManager", "connection already in flight; reconnect coalesced reason=" + str);
            return;
        }
        if (this.r0) {
            Log.i("TunnelManager", "registration terminal rejection parked reason=" + str);
            return;
        }
        if (v0() || u0()) {
            return;
        }
        n6 n6Var = this.U;
        if ((n6Var == null || !n6Var.f4635b) && (n6VarD0 = d0()) != null) {
            this.U = n6VarD0;
            n6Var = n6VarD0;
        }
        c2.t tVarB = this.f3714l.b(n6Var == null ? this.f3712k.get() : n6Var.f4634a, n6Var != null && n6Var.f4635b, n6Var != null && n6Var.f4636c, SystemClock.elapsedRealtime());
        int i5 = tVarB.f458a;
        if (i5 == 1) {
            I(h2.c.f1961d, r(str), str);
            return;
        }
        if (i5 != 2) {
            G0(str, i5 == 4);
        } else {
            if (tVarB.f459b < 0) {
                return;
            }
            I(h2.c.f1962e, r(str), str);
            t0(n6Var.f4634a, tVarB.f459b);
        }
    }

    public final void J0() {
        q.t tVar = this.f3738y;
        this.f3738y = null;
        if (tVar != null) {
            ((AtomicBoolean) tVar.f3081e).set(false);
            Handler handler = (Handler) tVar.f3079c;
            handler.removeCallbacks((a2.i) tVar.f3083g);
            handler.removeCallbacks((x2) tVar.f3084h);
            ((ExecutorService) tVar.f3080d).shutdownNow();
        }
    }

    public final void K0() {
        Runnable runnable;
        f3 f3Var = this.f3733v0;
        this.f3733v0 = null;
        if (f3Var != null) {
            synchronized (f3Var.f3974j) {
                try {
                    f3Var.f3979p++;
                    e2.g gVar = f3Var.f3976l;
                    if (gVar != null) {
                        gVar.a();
                        f3Var.f3976l = null;
                        e2.g gVar2 = f3Var.f3977m;
                        if (gVar2 != null) {
                            gVar2.f806b.cancel(false);
                            f3Var.f3977m = null;
                        }
                        f3Var.n = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        l2.d dVar = this.f3730u;
        synchronized (dVar) {
            while (true) {
                Runnable runnablePoll = dVar.f2420a.getQueue().poll();
                if (runnablePoll != null) {
                    if (runnablePoll instanceof bf) {
                        bf bfVar = (bf) runnablePoll;
                        if (bfVar.f3630e.compareAndSet(false, true) && (runnable = bfVar.f3629d) != null) {
                            runnable.run();
                        }
                    }
                }
            }
        }
    }

    public final boolean L(int i3, boolean z2) {
        n6 n6Var = this.U;
        if (n6Var != null && n6Var.f4634a == i3 && n6Var.f4635b) {
            boolean z3 = n6Var.f4636c;
            if (!z2) {
                return z3;
            }
            if (!z3) {
                h2.k kVar = this.f3714l;
                return i3 == kVar.f2057a && kVar.f2060d;
            }
        }
        return false;
    }

    public final void L0(int i3, int i4, String str) {
        boolean z2;
        int i5;
        boolean z3;
        this.f3729t0 = null;
        this.f3694b.set(false);
        synchronized (this.C) {
            try {
                this.H = false;
                this.K = false;
                z2 = this.L;
                this.L = false;
                i5 = 2;
                this.M = 2;
                z3 = this.J || this.G != null;
                this.J = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z3) {
            m(str);
        }
        if (z2) {
            D0("nodes_session_reset");
        }
        n();
        K0();
        J0();
        j0 j0Var = this.f3740z;
        this.f3740z = null;
        if (j0Var != null) {
            j0Var.e();
        }
        p(i4);
        g2.a0 a0Var = this.f3727s0;
        this.f3739y0 = null;
        n();
        this.f3727s0 = null;
        if (!"stop".equals(str)) {
            i5 = (i3 == 1 || "network_changed".equals(str) || "network_validation".equals(str)) ? 3 : 1;
        }
        if (a0Var != null) {
            this.f3729t0 = R0(a0Var.g(i5), null, i4);
        }
        this.f3692a.set(false);
        b0();
    }

    public final boolean N0(h2.c cVar, int i3, h2.g gVar) {
        WifiManager.WifiLock wifiLock;
        h2.c cVar2 = this.f3706h;
        if (cVar2 == cVar) {
            return true;
        }
        Set set = (Set) h2.c.f1968k.get(cVar2);
        if (set == null || !set.contains(cVar)) {
            Log.w("TunnelManager", "illegal state transition " + cVar2 + " -> " + cVar);
            return false;
        }
        this.f3706h = cVar;
        long jMax = 0;
        if (cVar == h2.c.f1965h && this.V > 0) {
            jMax = Math.max(0L, SystemClock.elapsedRealtime() - this.V);
        }
        long j3 = jMax;
        n1 n1Var = this.f3728t;
        int i4 = this.f3708i.get();
        synchronized (n1Var) {
            try {
                if (((ArrayDeque) n1Var.f4597d).size() >= n1Var.f4594a) {
                    ((ArrayDeque) n1Var.f4597d).removeFirst();
                }
                ((h2.a) n1Var.f4596c).getClass();
                td tdVar = new td(i4, cVar2, cVar, i3, gVar, j3, System.currentTimeMillis());
                ((ArrayDeque) n1Var.f4597d).addLast(tdVar);
                if (((ArrayDeque) n1Var.f4598e).size() >= n1Var.f4594a) {
                    ((ArrayDeque) n1Var.f4598e).removeFirst();
                }
                ((ArrayDeque) n1Var.f4598e).addLast(tdVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        Log.i("TunnelManager", "TunnelStats stateFrom=" + cVar2 + " stateTo=" + cVar + " connectionGeneration=" + this.f3708i.get());
        Context context = this.B0;
        if (context != null) {
            if (C0(cVar)) {
                PowerManager.WakeLock wakeLock = j6.f4332a;
                Context applicationContext = context.getApplicationContext();
                try {
                    PowerManager powerManager = (PowerManager) applicationContext.getSystemService("power");
                    if (powerManager != null) {
                        synchronized (j6.class) {
                            try {
                                PowerManager.WakeLock wakeLock2 = j6.f4332a;
                                if (wakeLock2 == null || !wakeLock2.isHeld()) {
                                    PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, applicationContext.getPackageName() + ":TunnelSession");
                                    j6.f4332a = wakeLockNewWakeLock;
                                    wakeLockNewWakeLock.setReferenceCounted(false);
                                    j6.f4332a.acquire();
                                }
                                WifiManager wifiManager = (WifiManager) applicationContext.getSystemService("wifi");
                                if (wifiManager != null && ((wifiLock = j6.f4333b) == null || !wifiLock.isHeld())) {
                                    WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, applicationContext.getPackageName() + ":TunnelSessionWifi");
                                    j6.f4333b = wifiLockCreateWifiLock;
                                    wifiLockCreateWifiLock.setReferenceCounted(false);
                                    j6.f4333b.acquire();
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        Log.d("MirrorRecovery", "control tunnel CPU+WiFi HIGH_PERF held");
                    }
                } catch (Throwable th3) {
                    Log.w("MirrorRecovery", "tunnel session lock acquire failed", th3);
                }
            } else {
                PowerManager.WakeLock wakeLock3 = j6.f4332a;
                synchronized (j6.class) {
                    PowerManager.WakeLock wakeLock4 = j6.f4332a;
                    if (wakeLock4 != null && wakeLock4.isHeld()) {
                        try {
                            j6.f4332a.release();
                        } catch (Throwable unused) {
                        }
                    }
                    j6.f4332a = null;
                    WifiManager.WifiLock wifiLock2 = j6.f4333b;
                    if (wifiLock2 != null && wifiLock2.isHeld()) {
                        try {
                            j6.f4333b.release();
                        } catch (Throwable unused2) {
                        }
                    }
                    j6.f4333b = null;
                }
            }
        }
        b0();
        return true;
    }

    public final boolean O() {
        Context context = this.B0;
        return (context == null || c2.p.k(context)) ? false : true;
    }

    public final boolean O0(int i3, h2.c cVar, g2.a0 a0Var) {
        return (this.f3708i.get() == i3 && this.f3706h == cVar && this.f3727s0 == a0Var) ? false : true;
    }

    public final boolean P() {
        return this.f3692a.get() && this.f3694b.get();
    }

    public final void P0(int i3, g2.a0 a0Var, h2.e eVar) {
        if (i3 == this.f3708i.get() && a0Var != null && a0Var == this.f3727s0) {
            if (eVar == null) {
                this.f3739y0 = null;
                n();
                return;
            }
            this.f3739y0 = eVar;
            g2.k0 k0Var = this.D;
            if (k0Var == null || !k0Var.V(eVar)) {
                n();
                try {
                    g2.k0 k0Var2 = new g2.k0(this.A0, eVar, new ve(this), p0());
                    synchronized (this.C) {
                        if (this.f3739y0 == eVar && this.D == null) {
                            this.D = k0Var2;
                            if (!k0Var2.f1658k.get() && k0Var2.f1657j.compareAndSet(false, true)) {
                                w0.s sVar = k0Var2.f1651d;
                                sVar.getClass();
                                f1.b.a(new w0.p(sVar, 0));
                                return;
                            }
                            return;
                        }
                        k0Var2.close();
                    }
                } catch (RuntimeException e3) {
                    Log.w("TunnelManager", "Socket.IO media client creation failed: ".concat(e3.getClass().getSimpleName()));
                }
            }
        }
    }

    public final ScreenMirrorService Q0(long j3) {
        ScreenMirrorService screenMirrorService = this.f3731u0;
        if (screenMirrorService != null) {
            return screenMirrorService;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() + j3;
        while (System.currentTimeMillis() < jCurrentTimeMillis) {
            try {
                Thread.sleep(250L);
                ScreenMirrorService screenMirrorService2 = this.f3731u0;
                if (screenMirrorService2 != null) {
                    Log.i("TunnelManager", "boundService became available after waiting");
                    return screenMirrorService2;
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        return null;
    }

    public final h2.g R0(h2.g gVar, IOException iOException, int i3) {
        h2.g gVar2;
        Throwable cause;
        h2.g gVar3 = gVar;
        String str = "";
        if (gVar3 == null) {
            if (iOException == null) {
                cause = null;
            } else {
                AtomicLong atomicLong = h2.g.P;
                cause = iOException.getCause();
            }
            gVar2 = new h2.g(h2.g.P.incrementAndGet(), h2.g.c(iOException), "", h2.g.b(iOException), iOException == null ? "" : iOException.getMessage(), h2.g.b(cause), cause == null ? "" : cause.getMessage(), -1L, -1L);
            str = "";
        } else {
            String message = gVar3.f2010i;
            String strB = gVar3.f2009h;
            if (iOException != null) {
                int iC = gVar3.O;
                if (iC == 9) {
                    iC = h2.g.c(iOException);
                }
                int i4 = iC;
                Throwable cause2 = iOException.getCause();
                if (strB.isEmpty()) {
                    strB = h2.g.b(cause2);
                }
                String str2 = strB;
                if (message.isEmpty()) {
                    message = cause2 == null ? "" : cause2.getMessage();
                }
                gVar3 = new h2.g(gVar3.f2002a, i4, gVar3.f2003b, gVar3.f2004c, gVar3.f2005d, gVar3.f2006e, h2.g.b(iOException), iOException.getMessage(), str2, message, gVar3.f2011j, gVar3.f2012k, gVar3.f2013l, gVar3.f2014m, gVar3.n, gVar3.f2015o, gVar3.f2016p, gVar3.f2017q, gVar3.f2018r, gVar3.f2019s, gVar3.f2020t, gVar3.f2021u, gVar3.f2022v, gVar3.f2023w, gVar3.f2024x, gVar3.f2025y, gVar3.f2026z, gVar3.A, gVar3.B, gVar3.C, gVar3.D, gVar3.E, gVar3.F, gVar3.G, gVar3.H, gVar3.I, gVar3.J, gVar3.K, gVar3.L, gVar3.M, gVar3.N);
            }
            gVar2 = gVar3;
        }
        n6 n6Var = this.U;
        return new h2.g(gVar2.f2002a, gVar2.O, gVar2.f2003b, gVar2.f2004c, gVar2.f2005d, gVar2.f2006e, gVar2.f2007f, gVar2.f2008g, gVar2.f2009h, gVar2.f2010i, gVar2.f2011j, gVar2.f2012k, gVar2.f2013l, gVar2.f2014m, i3, n6Var == null ? -1 : n6Var.f4634a, n6Var == null ? str : n6Var.f4637d, gVar2.f2017q, gVar2.f2018r, gVar2.f2019s, gVar2.f2020t, gVar2.f2021u, gVar2.f2022v, gVar2.f2023w, gVar2.f2024x, gVar2.f2025y, gVar2.f2026z, gVar2.A, gVar2.B, gVar2.C, gVar2.D, gVar2.E, gVar2.F, gVar2.G, gVar2.H, gVar2.I, gVar2.J, gVar2.K, gVar2.L, gVar2.M, gVar2.N);
    }

    public final void S(int i3, h2.g gVar) {
        h2.c cVar = this.f3706h;
        h2.c cVar2 = h2.c.f1963f;
        if (cVar == cVar2) {
            if (gVar != null) {
                this.f3729t0 = gVar;
            }
        } else {
            if (this.f3706h == h2.c.f1967j || this.f3706h == h2.c.f1965h || this.f3706h == h2.c.f1964g) {
                N0(h2.c.f1966i, i3, gVar);
                gVar = null;
            }
            N0(cVar2, 0, gVar);
        }
    }

    public final long S0() {
        long j3;
        g2.k0 k0Var = this.D;
        if (k0Var != null) {
            g2.z0 z0Var = k0Var.f1652e;
            synchronized (z0Var.f1834a) {
                j3 = z0Var.f1849q + z0Var.f1851s;
            }
        } else {
            j3 = 0;
        }
        if (0 > Long.MAX_VALUE - j3) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    public final void T() {
        long jN = m0.a.n(this.f3735w0, SystemClock.elapsedRealtime(), this.f3705g0);
        if (jN < 15000) {
            H(System.currentTimeMillis());
        }
        this.f3703f0 = jN;
        this.f3705g0 = false;
        this.f3735w0 = 0L;
    }

    public final void U(int i3, int i4, IOException iOException, h2.g gVar) {
        long j3;
        boolean z2;
        long j4;
        long jMin;
        h2.g gVarD;
        int i5;
        h2.c cVar;
        h2.g gVar2;
        boolean z3;
        boolean z4;
        long jB;
        long j5;
        long j6;
        af afVar;
        boolean z5;
        boolean zL;
        c2.i iVar;
        long jMax;
        long j7;
        if (i3 != this.f3708i.get()) {
            return;
        }
        if (this.f3723q.get() == i3) {
            Log.i("TunnelManager", "ignoring duplicate disconnect for generation=" + i3);
            return;
        }
        int i6 = this.f3721p;
        boolean z6 = i3 == this.f3719o;
        af afVar2 = this.f3715l0;
        boolean z7 = afVar2 != null && afVar2.f3521f == i3;
        boolean z8 = this.f3717m0;
        boolean z9 = iOException instanceof h2.m;
        if (z9) {
            j3 = 5000;
            h2.m mVar = (h2.m) iOException;
            z2 = true;
            if ("duplicate_session".equals(mVar.f2067c)) {
                int i7 = this.f3724q0;
                int i8 = i7 + 1;
                this.f3724q0 = i8;
                if (i8 <= 0) {
                    jMin = 0;
                    j4 = 0;
                } else {
                    j4 = 0;
                    jMin = 120000;
                    if (i8 < 4) {
                        jMin = Math.min(120000L, 5000 << Math.min(20, i7));
                    }
                }
                if (this.f3724q0 >= 4) {
                    Log.w("TunnelManager", "duplicate session retries parked count=" + this.f3724q0 + " retryMs=" + jMin);
                }
            } else {
                afVar2 = afVar2;
                j4 = 0;
                this.f3724q0 = 0;
                jMin = 0;
            }
            if (mVar.f2068d) {
                long jMax2 = Math.max(mVar.f2069e, jMin);
                if (jMax2 > j4) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long j8 = jElapsedRealtime <= Long.MAX_VALUE - jMax2 ? jElapsedRealtime + jMax2 : Long.MAX_VALUE;
                    if (j8 > this.f3718n0) {
                        this.f3718n0 = j8;
                        this.f3722p0 = j4;
                        this.f3720o0++;
                    }
                }
            }
        } else {
            this.f3724q0 = 0;
            afVar2 = afVar2;
            j3 = 5000;
            z2 = true;
        }
        this.f3694b.set(false);
        this.f3721p = Integer.MIN_VALUE;
        this.f3719o = Integer.MIN_VALUE;
        this.f3741z0 = new h2.i();
        this.f3717m0 = false;
        P0(i3, this.f3727s0, null);
        p(i3);
        K0();
        J0();
        j0 j0Var = this.f3740z;
        this.f3740z = null;
        if (j0Var != null) {
            j0Var.e();
        }
        this.f3723q.set(i3);
        this.f3725r.d(i3);
        if (gVar == null && i4 == 10) {
            gVarD = h2.g.d(2, this.f3735w0 > 0 ? Math.max(0L, SystemClock.elapsedRealtime() - this.f3735w0) : -1L);
        } else {
            gVarD = gVar;
        }
        h2.g gVarR0 = R0(gVarD, iOException, i3);
        if (i4 == 10) {
            j("local_stop");
            this.f3715l0 = null;
            this.f3717m0 = false;
            this.f3703f0 = -1L;
            this.f3705g0 = false;
            this.f3735w0 = 0L;
            N0(h2.c.f1960c, i4, gVarR0);
            h0(i4, gVarR0, false, false, 0, 0L);
            return;
        }
        h2.m mVar2 = z9 ? (h2.m) iOException : null;
        if (mVar2 != null && !mVar2.f2068d) {
            this.f3715l0 = null;
            long jN = m0.a.n(this.f3735w0, SystemClock.elapsedRealtime(), this.f3705g0);
            if (jN < 15000) {
                H(System.currentTimeMillis());
            }
            this.f3703f0 = jN;
            this.f3705g0 = false;
            this.f3735w0 = 0L;
            this.f3714l.a(i6);
            this.n++;
            this.f3718n0 = 0L;
            this.f3722p0 = 0L;
            this.f3720o0++;
            this.r0 = z2;
            N0(h2.c.f1960c, i4, gVarR0);
            h0(i4, gVarR0, false, false, 0, 0L);
            Log.w("TunnelManager", "terminal registration rejection parked code=" + mVar2.f2067c);
            return;
        }
        af afVar3 = afVar2;
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        if (z6 && !this.f3705g0 && i6 != Integer.MIN_VALUE && this.f3712k.get() == i6 && this.U != null && this.U.f4634a == i6 && !this.U.f4636c) {
            this.f3715l0 = null;
            long jN2 = m0.a.n(this.f3735w0, jElapsedRealtime2, this.f3705g0);
            if (jN2 < 15000) {
                H(System.currentTimeMillis());
            }
            this.f3703f0 = jN2;
            this.f3705g0 = false;
            this.f3735w0 = 0L;
            h2.k kVar = this.f3714l;
            if (i6 != kVar.f2057a) {
                j7 = -1;
            } else {
                kVar.f2060d = false;
                kVar.f2061e = true;
                kVar.f2062f = false;
                kVar.f2059c = h2.k.c(Math.max(0L, jElapsedRealtime2), 60000L);
                j7 = 60000;
            }
            N0(h2.c.f1962e, i4, gVarR0);
            h0(i4, gVarR0, false, false, 0, Math.max(0L, j7));
            t0(i6, j7);
            Log.w("TunnelManager", "unvalidated network probe failed; cooldownMs=" + j7 + " networkGeneration=" + i6);
            return;
        }
        if (this.B0 != null) {
            i5 = 1;
            c2.c.e(this.B0, "socket-terminal:".concat(a0.a.z(i4)), true);
        } else {
            i5 = 1;
        }
        int iA = g.d.a(i4);
        if (iA != i5) {
            cVar = iA != 9 ? h2.c.f1966i : h2.c.f1960c;
        } else {
            cVar = h2.c.f1967j;
        }
        h2.c cVar2 = h2.c.f1967j;
        if (cVar == cVar2) {
            Set set = (Set) h2.c.f1968k.get(this.f3706h);
            if (set == null || !set.contains(cVar2)) {
                cVar = h2.c.f1966i;
            }
        }
        h2.c cVar3 = h2.c.f1960c;
        if (cVar == cVar3) {
            this.f3715l0 = null;
            N0(cVar3, i4, gVarR0);
            h0(i4, gVarR0, false, false, 0, 0L);
            return;
        }
        if (cVar == cVar2) {
            N0(cVar2, i4, gVarR0);
            gVar2 = null;
        } else {
            gVar2 = gVarR0;
        }
        boolean z10 = this.f3705g0;
        long jN3 = m0.a.n(this.f3735w0, jElapsedRealtime2, z10);
        if (jN3 < 15000) {
            H(System.currentTimeMillis());
        }
        this.f3703f0 = jN3;
        this.f3705g0 = false;
        this.f3735w0 = 0L;
        if (jN3 >= 30000) {
            j("long_life_disconnect");
        } else {
            this.f3711j0 = true;
        }
        N0(h2.c.f1966i, i4, gVar2);
        if (this.X == 0) {
            this.X = jElapsedRealtime2;
            this.Y = System.currentTimeMillis();
        }
        boolean z11 = this.f3711j0 || jN3 < 15000;
        int i9 = this.W;
        this.W = i9 + 1;
        h2.b bVar = this.f3726s;
        if (z11) {
            bVar.getClass();
            jElapsedRealtime2 = jElapsedRealtime2;
            z4 = true;
            jB = bVar.b(h2.b.f1958d, Math.min(Math.max(0, i9), 3), 20000L);
            z3 = false;
        } else {
            long j9 = this.X;
            long jMax3 = Math.max(j9 <= 0 ? 0L : Math.max(0L, jElapsedRealtime2 - j9), this.Y <= 0 ? 0L : Math.max(0L, System.currentTimeMillis() - this.Y));
            bVar.getClass();
            long[] jArr = jMax3 >= 60000 ? h2.b.f1957c : h2.b.f1956b;
            z3 = false;
            z4 = true;
            jB = bVar.b(jArr, Math.min(Math.max(0, i9), jArr.length - 1), 30000L);
        }
        if (z7) {
            long jMax4 = Math.max(0L, jElapsedRealtime2 - afVar3.f3517b);
            zL = c2.p.l(this.B0, i4, gVarR0, afVar3.f3516a);
            this.f3715l0 = null;
            Log.i("TunnelManager", "screen-off silent reconnect failed pulseArmed=" + zL + " recoveryAgeMs=" + jMax4);
            z5 = z3;
            z11 = z11;
            j5 = jB;
            jElapsedRealtime2 = jElapsedRealtime2;
            j6 = 0;
            afVar = null;
        } else {
            if (afVar3 == 0) {
                long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                synchronized (c2.p.f450c) {
                    try {
                        long j10 = c2.p.f452e;
                        iVar = (j10 < 0 || jElapsedRealtime3 < j10) ? c2.i.f427c : new c2.i(c2.p.f451d, jElapsedRealtime3 - j10);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                long j11 = j3;
                long j12 = jB;
                long j13 = iVar.f428a;
                boolean z12 = (j13 <= 0 || j13 == this.f3713k0) ? z4 : false;
                long j14 = iVar.f429b;
                if (!z8 || z12) {
                    j5 = j12;
                } else if (j14 < 0 || j14 > j11 || !(i4 == 3 || i4 == 4 || i4 == 5 || i4 == 2)) {
                    j5 = j12;
                    j6 = 0;
                    afVar = null;
                    z5 = false;
                } else {
                    this.f3713k0 = j13;
                    j6 = 0;
                    jElapsedRealtime2 = jElapsedRealtime2;
                    afVar = new af(j13, jElapsedRealtime2, i4, gVarR0, j12);
                    j5 = j12;
                    this.f3715l0 = afVar;
                    a0(1500L, new ba(this, afVar, 11));
                    z5 = z4;
                }
                zL = false;
            } else {
                z11 = z11;
                j5 = jB;
            }
            j6 = 0;
            afVar = null;
            z5 = false;
            zL = false;
        }
        if (zL) {
            jMax = 200;
        } else {
            jMax = z5 ? 750L : Math.max(j6, j5);
        }
        if (afVar != null) {
            jMax = Math.floorMod(((long) i3) ^ jElapsedRealtime2, 551L) + 200;
        }
        long j15 = this.f3718n0;
        long jMax5 = Math.max(jMax, j15 > jElapsedRealtime2 ? j15 - jElapsedRealtime2 : 0L);
        Z(jMax5);
        boolean z13 = z5;
        h0(i4, gVarR0, zL, z13, i9, jMax5);
        a0(jMax5, new f2.g(this, i3, afVar, 4));
        StringBuilder sb = new StringBuilder("tunnel disconnected: reason=");
        sb.append(a0.a.z(i4));
        sb.append(" ");
        sb.append(gVarR0.e());
        sb.append(" internet=");
        sb.append(this.U.f4635b);
        sb.append(" validated=");
        sb.append(this.U.f4636c);
        sb.append(" reachedOnline=");
        sb.append(z10);
        sb.append(" lifetimeMs=");
        sb.append(jN3);
        sb.append(" stormActive=");
        sb.append(this.f3711j0);
        sb.append(" inStorm=");
        sb.append(z11);
        sb.append(" flashed=");
        sb.append(zL);
        sb.append(" fastRetry=");
        sb.append(z13);
        sb.append(" screenOffCorrelated=");
        sb.append((afVar != null || z7) ? z4 : false);
        sb.append(" recoveryDelayMs=");
        sb.append(jMax5);
        Log.w("TunnelManager", sb.toString());
    }

    public final void V() {
        this.H = true;
        if (this.I) {
            Log.i("TunnelManager", "H264/JPEG producer suppressed while WebP capture is active");
        } else if (f()) {
            e(this.D);
        } else {
            Log.w("TunnelManager", "video push waiting for Socket.IO media registration");
        }
    }

    public final void W(int i3, g2.a0 a0Var) {
        if (!N(i3, a0Var, this.f3708i.get(), this.f3727s0, this.f3694b.get())) {
            Log.w("TunnelManager", "WebP push requested by stale control session");
            return;
        }
        this.K = true;
        if (!f()) {
            Log.w("TunnelManager", "WebP push waiting for Socket.IO media registration");
            return;
        }
        j6.b(this.B0, "hybrid:webp");
        Log.i("TunnelManager", "WebP Socket.IO media route ready generation=" + i3);
    }

    public final void X(int i3, g2.a0 a0Var, int i4) {
        if (!N(i3, a0Var, this.f3708i.get(), this.f3727s0, this.f3694b.get())) {
            Log.w("TunnelManager", "nodes push requested by stale control session");
            return;
        }
        this.M = i4 < 3 ? 2 : 3;
        this.L = true;
        D0("nodes_demand");
        Log.i("TunnelManager", "nodes Socket.IO media route requested generation=" + i3 + " protocol=v" + this.M);
    }

    public final void Z(long j3) {
        long j4;
        long jMin;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.Y <= 0) {
            this.Y = jCurrentTimeMillis;
        }
        long jMax = Math.max(0L, Math.min(j3, 120000L));
        long j5 = Long.MAX_VALUE;
        if (jMax <= 0) {
            j4 = 0;
        } else {
            j4 = jCurrentTimeMillis > Long.MAX_VALUE - jMax ? Long.MAX_VALUE : jMax + jCurrentTimeMillis;
        }
        this.f3695b0 = j4;
        this.f3697c0 = false;
        this.f3701e0 = 0L;
        this.f3699d0++;
        h2.b bVar = this.Z;
        if (bVar != null) {
            int i3 = this.W;
            boolean z2 = this.f3711j0;
            long j6 = this.Y;
            synchronized (bVar) {
                long jMax2 = Math.max(1L, jCurrentTimeMillis);
                if (j6 <= 0 || j6 > jMax2) {
                    j6 = jMax2;
                }
                if (j4 <= jMax2) {
                    jMin = 0;
                } else {
                    if (jMax2 <= 9223372036854655807L) {
                        j5 = jMax2 + 120000;
                    }
                    jMin = Math.min(j4, j5);
                }
                ((SharedPreferences) bVar.f1959a).edit().clear().putInt("version", 1).putInt("attempt", Math.max(0, i3)).putBoolean("storm", z2).putLong("first_failure_at_ms", j6).putLong("retry_not_before_ms", jMin).putLong("updated_at_ms", jMax2).commit();
            }
        }
    }

    public final void a0(long j3, Runnable runnable) {
        Handler handler = this.f3704g;
        if (handler != null) {
            handler.postDelayed(runnable, j3);
        } else {
            this.f3702f.execute(runnable);
        }
    }

    public final void b0() {
        int iOrdinal;
        Context context = this.B0;
        if (context == null) {
            return;
        }
        h2.c cVar = this.f3706h;
        boolean z2 = this.f3692a.get();
        boolean z3 = this.f3694b.get();
        Object obj = d0.f3746a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (d0.f3746a) {
            try {
                File fileC = d0.c(context);
                if (fileC == null) {
                    return;
                }
                File parentFile = fileC.getParentFile();
                if (parentFile == null || parentFile.exists() || parentFile.mkdirs() || parentFile.isDirectory()) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(fileC, "rw");
                    try {
                        FileChannel channel = randomAccessFile.getChannel();
                        try {
                            FileLock fileLockLock = channel.lock();
                            try {
                                randomAccessFile.setLength(0L);
                                randomAccessFile.seek(0L);
                                randomAccessFile.writeInt(1093751601);
                                randomAccessFile.writeInt(1);
                                if (cVar != null) {
                                    iOrdinal = cVar.ordinal();
                                } else {
                                    h2.c cVar2 = h2.c.f1960c;
                                    iOrdinal = 0;
                                }
                                randomAccessFile.writeInt(iOrdinal);
                                randomAccessFile.writeBoolean(z2);
                                randomAccessFile.writeBoolean(z3);
                                randomAccessFile.writeLong(jElapsedRealtime);
                                randomAccessFile.getFD().sync();
                                if (fileLockLock != null) {
                                    fileLockLock.close();
                                }
                                channel.close();
                                randomAccessFile.close();
                                AtomicReference atomicReference = d0.f3747b;
                                if (cVar == null) {
                                    cVar = h2.c.f1960c;
                                }
                                atomicReference.set(new c0(cVar));
                            } catch (Throwable th) {
                                if (fileLockLock != null) {
                                    try {
                                        fileLockLock.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            throw th3;
                        }
                    } catch (Throwable th5) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                Log.w("A11yRuntimeState", "publish failed: " + th7.getMessage());
            }
        }
    }

    public final d0.d c() {
        if (this.f3707h0 != null || this.B0 == null) {
            return this.f3707h0;
        }
        try {
            this.f3707h0 = k3.z(this.B0).d();
        } catch (Throwable unused) {
            Log.w("TunnelManager", "load reconnect instability episode failed");
        }
        return this.f3707h0;
    }

    public final void d(g2.k0 k0Var) {
        ScreenMirrorService screenMirrorService = this.f3731u0;
        if (k0Var == null || k0Var != this.D || !k0Var.C() || screenMirrorService == null) {
            Log.w("TunnelManager", "camera push requested but Socket.IO media/service not ready");
            return;
        }
        try {
            g2.m0 m0VarI = k0Var.I(2);
            synchronized (this.C) {
                if (k0Var == this.D && k0Var.C() && this.J) {
                    g2.m0 m0Var = this.G;
                    this.G = m0VarI;
                    o(m0Var);
                    j6.b(this.B0, "hybrid:camera");
                    ie ieVar = new ie(this, m0VarI, k0Var, 0);
                    e2 e2VarV2 = screenMirrorService.V2();
                    if (e2VarV2 == null || e2VarV2.f3853g.get()) {
                        try {
                            m0VarI.close();
                        } catch (IOException unused) {
                        }
                        try {
                            ieVar.run();
                        } catch (Throwable unused2) {
                        }
                    } else {
                        a2.o oVar = e2VarV2.f3850d;
                        synchronized (oVar) {
                            if (oVar.f123b) {
                                m0VarI.close();
                                ieVar.run();
                            } else {
                                d2.t tVar = (d2.t) oVar.f124c;
                                if (tVar == null || ((g2.m0) tVar.f613d) != m0VarI) {
                                    long j3 = oVar.f122a + 1;
                                    oVar.f122a = j3;
                                    d2.t tVar2 = new d2.t();
                                    tVar2.f612c = j3;
                                    tVar2.f613d = m0VarI;
                                    tVar2.f614e = ieVar;
                                    oVar.f124c = tVar2;
                                    e2.a(e2VarV2, new y.e(tVar, tVar2));
                                }
                            }
                        }
                    }
                    Log.i("TunnelManager", "camera producer attached to Socket.IO media");
                    return;
                }
                o(m0VarI);
            }
        } catch (IOException e3) {
            a0.a.m(e3, new StringBuilder("camera Socket.IO sink unavailable: "), "TunnelManager");
        }
    }

    public final n6 d0() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        String str;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.B0.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return null;
            }
            boolean zHasCapability = networkCapabilities.hasCapability(12);
            boolean zHasCapability2 = networkCapabilities.hasCapability(16);
            if (networkCapabilities.hasTransport(1)) {
                str = "wifi";
            } else if (networkCapabilities.hasTransport(0)) {
                str = "cellular";
            } else {
                str = networkCapabilities.hasTransport(3) ? "ethernet" : "other";
            }
            if (!activeNetwork.equals(this.f3716m)) {
                this.f3716m = activeNetwork;
                this.f3712k.incrementAndGet();
            }
            return new n6(this.f3712k.get(), str, zHasCapability, zHasCapability2);
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("queryCurrentNetwork failed: "), "TunnelManager");
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00b3  */
    public final void e(g2.k0 k0Var) {
        bd bdVar;
        g2.m0 m0Var;
        ScreenMirrorService screenMirrorService = this.f3731u0;
        if (k0Var == null || k0Var != this.D || !k0Var.C() || screenMirrorService == null || this.I) {
            Log.w("TunnelManager", "video push requested but Socket.IO media/service not ready");
            return;
        }
        synchronized (this.C) {
            try {
                if (k0Var == this.D && this.E != null && this.F != null) {
                    Log.i("TunnelManager", "H264 Socket.IO producer already attached");
                    return;
                }
                boolean z2 = true;
                try {
                    g2.m0 m0VarI = k0Var.I(1);
                    ie ieVar = new ie(this, m0VarI, k0Var, 3);
                    cf cfVarK = K();
                    j2 j2Var = cfVarK.f3725r;
                    int i3 = j2Var != null ? j2Var.f4303b : -1;
                    ta taVar = new ta(new AtomicBoolean(), j2Var, i3, m0VarI, cfVarK, ieVar);
                    bd bdVar2 = null;
                    if (j2Var == null || j2Var.c(i3, m0VarI, taVar)) {
                        bdVar = new bd(screenMirrorService, m0VarI, new v8(1, taVar), j2Var, i3);
                        screenMirrorService.L3.add(bdVar);
                        screenMirrorService.Y5("client_attached", true);
                        new Thread(new v8(7, bdVar), "client-writer").start();
                    } else {
                        bdVar = null;
                    }
                    if (bdVar == null) {
                        o(m0VarI);
                        j6.d("hybrid:h264");
                        return;
                    }
                    synchronized (this.C) {
                        try {
                            if (k0Var == this.D && k0Var.C()) {
                                if (!(this.H && !this.I)) {
                                    z2 = false;
                                }
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                bdVar2 = this.E;
                                m0Var = this.F;
                                this.E = bdVar;
                                this.F = m0VarI;
                            } else {
                                m0Var = null;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (!z2) {
                        bdVar.a();
                        o(m0VarI);
                        return;
                    }
                    if (bdVar2 != null) {
                        bdVar2.a();
                    }
                    o(m0Var);
                    j6.b(this.B0, "hybrid:h264");
                    Log.i("TunnelManager", "H264 producer attached to Socket.IO media");
                } catch (IOException e3) {
                    a0.a.m(e3, new StringBuilder("H264 Socket.IO sink unavailable: "), "TunnelManager");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean f() {
        g2.k0 k0Var = this.D;
        return this.B0 != null && this.f3694b.get() && k0Var != null && k0Var.C();
    }

    public final String g0(g2.d0 d0Var) throws IOException {
        FutureTask futureTask = new FutureTask(new pe(this, d0Var));
        Thread thread = new Thread(futureTask, "meta-exchange-read");
        thread.setDaemon(true);
        thread.start();
        try {
            return (String) futureTask.get(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e3) {
            futureTask.cancel(true);
            Thread.currentThread().interrupt();
            throw new IOException("meta response interrupted", e3);
        } catch (ExecutionException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            throw new IOException("meta response failed", cause);
        } catch (TimeoutException e5) {
            futureTask.cancel(true);
            try {
                d0Var.close();
            } catch (IOException unused) {
            }
            throw new IOException("meta response timeout", e5);
        }
    }

    public final void h0(final int i3, final h2.g gVar, final boolean z2, final boolean z3, final int i4, final long j3) {
        final String string;
        final String str;
        if (this.B0 == null || i3 == 0 || gVar == null) {
            return;
        }
        final d0.d dVarC = c();
        String str2 = this.f3709i0;
        boolean z4 = true;
        final boolean z5 = i3 == 10 && gVar.O == 1 && str2 != null && !str2.isEmpty();
        final String str3 = z5 ? this.f3709i0 : "";
        Context context = this.B0;
        final n6 n6Var = this.U;
        n1 n1Var = this.f3728t;
        synchronized (n1Var) {
            try {
                StringBuilder sb = new StringBuilder("[");
                for (td tdVar : (ArrayDeque) n1Var.f4598e) {
                    if (!z4) {
                        sb.append(',');
                    }
                    sb.append("{\"gen\":");
                    sb.append(tdVar.f5199a);
                    sb.append(",\"from\":\"");
                    sb.append(tdVar.f5200b.name());
                    sb.append("\",\"to\":\"");
                    sb.append(tdVar.f5201c.name());
                    sb.append("\",\"atMs\":");
                    sb.append(tdVar.f5205g);
                    sb.append(",\"validatedToOnlineMs\":");
                    sb.append(tdVar.f5204f);
                    if (tdVar.f5202d != 0) {
                        sb.append(",\"reason\":\"");
                        sb.append(a0.a.v(tdVar.f5202d));
                        sb.append('\"');
                    }
                    sb.append('}');
                    z4 = false;
                }
                sb.append(']');
                string = sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        final boolean z6 = this.f3711j0;
        AtomicBoolean atomicBoolean = i3.f4238a;
        final Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext != null) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            str = "dinc:" + UUID.randomUUID();
            i3.f4239b.execute(new Runnable() { // from class: w1.h3
                /* JADX WARN: Code duplicated, block: B:18:0x00a4 A[PHI: r16
  0x00a4: PHI (r16v7 d0.d) = (r16v2 d0.d), (r16v3 d0.d), (r16v4 d0.d), (r16v5 d0.d), (r16v8 d0.d) binds: [B:31:0x00d6, B:27:0x00c8, B:24:0x00bd, B:20:0x00af, B:17:0x00a2] A[DONT_GENERATE, DONT_INLINE]] */
                @Override // java.lang.Runnable
                public final void run() {
                    d0.d dVar;
                    String lowerCase;
                    String str4;
                    String str5 = str;
                    long j4 = jCurrentTimeMillis;
                    h2.g gVar2 = gVar;
                    int i5 = i3;
                    boolean z7 = z6;
                    boolean z8 = z2;
                    boolean z9 = z3;
                    int i6 = i4;
                    long j5 = j3;
                    String str6 = string;
                    Context context2 = applicationContext;
                    n6 n6Var2 = n6Var;
                    if (n6Var2 == null) {
                        try {
                            n6Var2 = new n6(0, "", false, false);
                        } catch (Throwable th2) {
                            Log.e("DisconnectIncident", "record failed", th2);
                            return;
                        }
                    }
                    JSONObject jSONObject = new JSONObject();
                    byte b3 = 2;
                    d0.d dVar2 = dVarC;
                    JSONObject jSONObjectPut = jSONObject.put("version", dVar2 == null ? 1 : 2).put("eventId", str5).put("occurredAtMs", j4).put("connectionGeneration", Math.max(0, gVar2.n));
                    int i7 = gVar2.f2015o;
                    if (i7 < 0) {
                        i7 = n6Var2.f4634a;
                    }
                    JSONObject jSONObjectPut2 = jSONObjectPut.put("networkEpoch", Math.max(0, i7));
                    String strV = a0.a.v(i5);
                    Locale locale = Locale.ROOT;
                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("reason", strV.toLowerCase(locale)).put("diagnostic", gVar2.m());
                    JSONObject jSONObject2 = new JSONObject();
                    String str7 = n6Var2.f4637d;
                    String lowerCase2 = str7.toLowerCase(locale);
                    lowerCase2.getClass();
                    switch (lowerCase2.hashCode()) {
                        case -1419358249:
                            dVar = dVar2;
                            if (!lowerCase2.equals("ethernet")) {
                                b3 = -1;
                            } else {
                                b3 = 0;
                            }
                            break;
                        case -916596374:
                            dVar = dVar2;
                            if (!lowerCase2.equals("cellular")) {
                                b3 = -1;
                            } else {
                                b3 = 1;
                            }
                            break;
                        case 3649301:
                            dVar = dVar2;
                            if (!lowerCase2.equals("wifi")) {
                                b3 = -1;
                            }
                            break;
                        case 106069776:
                            dVar = dVar2;
                            if (!lowerCase2.equals("other")) {
                                b3 = -1;
                            } else {
                                b3 = 3;
                            }
                            break;
                        default:
                            dVar = dVar2;
                            b3 = -1;
                            break;
                    }
                    switch (b3) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            lowerCase = str7.toLowerCase(locale);
                            break;
                        default:
                            lowerCase = "";
                            break;
                    }
                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("network", jSONObject2.put("type", lowerCase).put("internet", n6Var2.f4635b).put("validated", n6Var2.f4636c)).put("decision", new JSONObject().put("storm", z7).put("screenPulse", z8).put("fastRetry", z9).put("backoffAttempt", Math.max(0, i6)).put("recoveryDelayMs", Math.max(0L, j5))).put("events", new JSONArray(str6.isEmpty() ? "[]" : str6));
                    if (z5 && (str4 = str3) != null && !str4.isEmpty()) {
                        jSONObjectPut4.put("cleanup", true);
                        jSONObjectPut4.put("supersedesEventId", str4);
                    }
                    if (dVar != null) {
                        d0.d dVar3 = dVar;
                        jSONObjectPut4.put("reconnectInstabilityEpisodeId", (String) dVar3.f532b);
                        jSONObjectPut4.put("episodeOpenedAtMs", dVar3.f531a);
                    }
                    JSONObject jSONObjectD = e9.d(context2);
                    if (jSONObjectD != null) {
                        jSONObjectPut4.put("processExit", jSONObjectD);
                    }
                    if (k3.z(context2).y(jSONObjectPut4)) {
                        i3.a(context2);
                    }
                }
            });
        } else {
            str = "";
        }
        if (z5 || i3 == 10 || str.isEmpty()) {
            return;
        }
        this.f3709i0 = str;
    }

    public final void i() {
        this.f3695b0 = 0L;
        this.f3697c0 = false;
        this.f3701e0 = 0L;
        this.f3699d0++;
        h2.b bVar = this.Z;
        if (bVar != null) {
            synchronized (bVar) {
                ((SharedPreferences) bVar.f1959a).edit().clear().commit();
            }
        }
    }

    public final void i0(Context context, String str) {
        Context applicationContext = context != null ? context.getApplicationContext() : this.B0;
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.f3702f.execute(new ke(this, context, str, 1));
    }

    public final void j(String str) {
        this.f3726s.getClass();
        this.W = 0;
        this.X = 0L;
        this.Y = 0L;
        this.f3711j0 = false;
        i();
        Log.i("TunnelManager", "storm backoff cleared reason=".concat(str));
    }

    public final y.e j0(int i3, g2.a0 a0Var, s7 s7Var) {
        if (!N(i3, a0Var, this.f3708i.get(), this.f3727s0, this.f3694b.get())) {
            return y.e.m(s7Var.a("stale_control_session", false));
        }
        ScreenMirrorService screenMirrorService = this.f3731u0;
        if (!this.L || this.M < 3 || screenMirrorService == null) {
            return y.e.m(s7Var.a("nodes_v3_inactive", false));
        }
        boolean zM4 = screenMirrorService.M4(s7Var.f5057b, s7Var.f5058c);
        return y.e.m(s7Var.a(zM4 ? "" : "node_publisher_unavailable", zM4));
    }

    public final boolean k(String str) {
        if (!this.r0) {
            return false;
        }
        this.r0 = false;
        Log.i("TunnelManager", "registration terminal park cleared trigger=".concat(str));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001b  */
    /* JADX WARN: Code duplicated, block: B:18:0x0021  */
    /* JADX WARN: Code duplicated, block: B:24:0x0033  */
    /* JADX WARN: Code duplicated, block: B:29:0x0042  */
    /* JADX WARN: Code duplicated, block: B:31:0x0045  */
    /* JADX WARN: Code duplicated, block: B:33:0x004d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x004e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    public final void k0(Context context) {
        Context context2;
        boolean z2;
        g2.a0 a0Var;
        boolean z3;
        if (context == null) {
            context = this.B0;
        }
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    if (this.B0 == null) {
                        this.B0 = applicationContext;
                    }
                    context2 = applicationContext;
                }
            } catch (RuntimeException unused) {
            }
            if (context2 == null) {
                Log.i("TunnelManager", "a11y_enabled skipped: no context");
                return;
            }
            try {
                z2 = c2.p.e(context2, "a11y_telemetry").getBoolean("enabled_reported_v2", false);
            } catch (Throwable unused2) {
                z2 = false;
            }
            if (z2) {
                return;
            }
            a0Var = this.f3727s0;
            if (a0Var == null && this.f3694b.get()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                Log.i("TunnelManager", "a11y_enabled deferred until tunnel online");
            } else {
                if (this.f3696c.compareAndSet(false, true)) {
                    new Thread(new q.r(this, a0Var, context2, context2, 4), "a11y-enabled-report").start();
                }
                return;
            }
        }
        context = null;
        context2 = context;
        if (context2 == null) {
            Log.i("TunnelManager", "a11y_enabled skipped: no context");
            return;
        }
        z2 = c2.p.e(context2, "a11y_telemetry").getBoolean("enabled_reported_v2", false);
        if (z2) {
            return;
        }
        a0Var = this.f3727s0;
        if (a0Var == null) {
            z3 = false;
        } else {
            z3 = false;
        }
        if (z3) {
            Log.i("TunnelManager", "a11y_enabled deferred until tunnel online");
        } else {
            if (this.f3696c.compareAndSet(false, true)) {
                return;
            }
            new Thread(new q.r(this, a0Var, context2, context2, 4), "a11y-enabled-report").start();
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #1 {all -> 0x0052, blocks: (B:14:0x001f, B:15:0x0023, B:20:0x0032, B:21:0x0033, B:23:0x0048, B:30:0x0051, B:16:0x0024, B:17:0x0028, B:19:0x0031, B:27:0x004e), top: B:37:0x001f, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    public final void l0(boolean z2) {
        String strJ;
        j0 j0Var;
        Context context = this.B0;
        if (context == null) {
            context = null;
        } else {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    if (this.B0 == null) {
                        this.B0 = applicationContext;
                    }
                    context = applicationContext;
                }
            } catch (RuntimeException unused) {
            }
        }
        if (context == null) {
            Log.w("TunnelManager", "a11y lifecycle event skipped: no context");
            return;
        }
        try {
            h0 h0VarR = h0.R(context);
            synchronized (h0VarR) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                synchronized (h0VarR) {
                    strJ = h0VarR.J(Boolean.valueOf(z2), jCurrentTimeMillis);
                }
                Log.i("TunnelManager", "a11y_unbind queued id=" + strJ);
                j0Var = this.f3740z;
                if (j0Var != null) {
                    j0Var.c();
                }
            }
            Log.i("TunnelManager", "a11y_unbind queued id=" + strJ);
            j0Var = this.f3740z;
            if (j0Var != null) {
                j0Var.c();
            }
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("queue a11y lifecycle event failed: "), "TunnelManager");
        }
    }

    public final void m(String str) {
        g2.m0 m0Var;
        synchronized (this.C) {
            this.J = false;
            m0Var = this.G;
            this.G = null;
        }
        o(m0Var);
        ScreenMirrorService screenMirrorService = this.f3731u0;
        if (screenMirrorService != null) {
            screenMirrorService.F(false, new he(this, screenMirrorService, 0));
        }
        j6.d("hybrid:camera");
        Log.i("TunnelManager", "camera producer stopped reason=" + str);
    }

    public final void m0(String str) {
        long jOptLong;
        int i3;
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("configured")) {
                jSONObject.put("configured", jSONObject.optLong("revision", -1L) >= 0);
            }
            jSONObject.put("timestamp", System.currentTimeMillis());
            String str2 = "event:app_guard_status\t" + jSONObject;
            long jOptLong2 = jSONObject.optLong("statusSequence", Long.MIN_VALUE);
            AtomicReference atomicReference = this.f3734w;
            if (!Q(str2)) {
                return;
            }
            while (true) {
                String str3 = (String) atomicReference.get();
                if (str3 != null) {
                    int iIndexOf = str3.indexOf(9);
                    if (iIndexOf < 0 || (i3 = iIndexOf + 1) >= str3.length()) {
                        jOptLong = Long.MIN_VALUE;
                    } else {
                        try {
                            jOptLong = new JSONObject(str3.substring(i3)).optLong("statusSequence", Long.MIN_VALUE);
                        } catch (JSONException unused) {
                            jOptLong = Long.MIN_VALUE;
                        }
                    }
                    if (jOptLong > jOptLong2) {
                        return;
                    }
                }
                do {
                    if (atomicReference.compareAndSet(str3, str2)) {
                        s0();
                        return;
                    }
                } while (atomicReference.get() == str3);
            }
        } catch (JSONException e3) {
            Log.w("TunnelManager", "invalid app guard status: " + e3.getMessage());
        }
    }

    public final void n() {
        g2.k0 k0Var;
        synchronized (this.C) {
            k0Var = this.D;
            this.D = null;
        }
        q0(null);
        if (k0Var != null) {
            k0Var.close();
        }
    }

    public final void n0(String str, String str2) {
        StringBuilder sb = new StringBuilder("[SecurityEvent] ");
        sb.append(str);
        sb.append(str2 != null ? " detail=".concat(str2) : "");
        Log.w("TunnelManager", sb.toString());
        g2.a0 a0Var = this.f3727s0;
        if (a0Var == null || !this.f3694b.get()) {
            return;
        }
        new Thread(new e2.q0(a0Var, str, str2, 16), "sec-event-report").start();
    }

    public final String o0() {
        Context context = this.B0;
        if (context == null) {
            String strA = a4.a(this.A0);
            if (strA != null) {
                return strA;
            }
        } else {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            String strA2 = a4.a(c2.u.n(context, "gatewayUrl"));
            if (strA2 == null || strA2.isEmpty()) {
                strA2 = this.A0;
            }
            String strA3 = a4.a(strA2);
            if (strA3 != null) {
                return strA3;
            }
        }
        return "";
    }

    public final void p(int i3) {
        y.l lVar;
        r9 r9Var = this.S;
        synchronized (r9Var) {
            try {
                q9 q9Var = r9Var.f5002c;
                q9 q9Var2 = q9Var != null ? q9Var : r9Var.f5003d;
                Thread thread = null;
                if (q9Var2 == null || q9Var2.f4928b <= i3) {
                    r9Var.f5008i = Math.max(r9Var.f5008i, i3);
                    if (r9Var.f5006g) {
                        Object obj = q9Var == null ? null : q9Var.f4927a;
                        if (q9Var != null) {
                            thread = q9Var.f4935i;
                        }
                        lVar = new y.l(obj, thread);
                    } else {
                        r9Var.f5006g = true;
                        r9Var.f5002c = null;
                        r9Var.f5009j++;
                        if (q9Var != null) {
                            q9Var.f4934h = true;
                            r9Var.d(q9Var, 2);
                        } else if (r9Var.f5004e != 0) {
                            r9Var.f5004e = 2;
                        } else {
                            r9Var.d(null, 2);
                        }
                        r9Var.a();
                        lVar = new y.l(q9Var == null ? null : q9Var.f4927a, q9Var != null ? q9Var.f4935i : null);
                    }
                } else {
                    lVar = new y.l(thread, thread);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Thread thread2 = (Thread) lVar.f5992d;
        g2.d0 d0Var = (g2.d0) lVar.f5991c;
        if (thread2 != null) {
            thread2.interrupt();
        }
        if (d0Var != null) {
            try {
                d0Var.close();
            } catch (IOException unused) {
            }
        }
    }

    public final SocketFactory p0() {
        SocketFactory socketFactory;
        ConnectivityManager connectivityManager;
        int i3;
        SocketFactory socketFactory2 = null;
        try {
            Context context = this.B0;
            if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return null;
            }
            Network activeNetwork = connectivityManager.getActiveNetwork();
            Network[] allNetworks = connectivityManager.getAllNetworks();
            int length = allNetworks.length;
            Network network = null;
            int i4 = 0;
            boolean z2 = false;
            int i5 = -1;
            while (i4 < length) {
                Network network2 = allNetworks[i4];
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network2);
                if (networkCapabilities == null) {
                    socketFactory = socketFactory2;
                } else if (networkCapabilities.hasTransport(4)) {
                    socketFactory = socketFactory2;
                    z2 = true;
                } else {
                    boolean zEquals = network2.equals(activeNetwork);
                    socketFactory = socketFactory2;
                    boolean zHasCapability = networkCapabilities.hasCapability(12);
                    boolean zHasCapability2 = networkCapabilities.hasCapability(16);
                    boolean zHasTransport = networkCapabilities.hasTransport(1);
                    int i6 = 3;
                    boolean zHasTransport2 = networkCapabilities.hasTransport(3);
                    boolean zHasTransport3 = networkCapabilities.hasTransport(0);
                    if (zHasCapability && zHasCapability2) {
                        if (!zHasTransport) {
                            if (zHasTransport2) {
                                i6 = 2;
                            } else {
                                i6 = zHasTransport3 ? 1 : 0;
                            }
                        }
                        i3 = (zEquals ? 100 : 0) + i6;
                    } else {
                        i3 = -1;
                    }
                    if (i3 >= 0 && i3 > i5) {
                        i5 = i3;
                        network = network2;
                    }
                }
                try {
                    i4++;
                    socketFactory2 = socketFactory;
                } catch (Throwable th) {
                    th = th;
                }
            }
            SocketFactory socketFactory3 = socketFactory2;
            if (z2) {
                Log.i("TunnelManager", "tunnel socketFactory: VPN active, using default routing");
                return socketFactory3;
            }
            if (network == null) {
                Log.i("TunnelManager", "tunnel socketFactory: no validated network, using default routing");
                return socketFactory3;
            }
            Log.i("TunnelManager", "tunnel socketFactory bound network=" + network);
            return network.getSocketFactory();
        } catch (Throwable th2) {
            th = th2;
            socketFactory = socketFactory2;
        }
        a0.a.p(th, new StringBuilder("tunnel socketFactory resolve failed: "), "TunnelManager");
        return socketFactory;
    }

    public final void q0(g2.k0 k0Var) {
        synchronized (this.C) {
            if (k0Var != null) {
                try {
                    if (this.D != k0Var) {
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            bd bdVar = this.E;
            g2.m0 m0Var = this.F;
            g2.m0 m0Var2 = this.G;
            this.E = null;
            this.F = null;
            this.G = null;
            if (bdVar != null) {
                bdVar.a();
            }
            o(m0Var);
            o(m0Var2);
            j6.d("hybrid:h264");
            j6.d("hybrid:webp");
            j6.d("hybrid:camera");
        }
    }

    public final y.e s(String str) {
        String strSubstring;
        String string;
        b2.c cVarE;
        String strY;
        boolean zOptBoolean;
        boolean zOptBoolean2;
        String strY2;
        boolean zCommit;
        String strTrim = str == null ? "" : str;
        byte b3 = 9;
        int iIndexOf = strTrim.indexOf(9);
        boolean zEquals = "lock".equals(iIndexOf >= 0 ? strTrim.substring(0, iIndexOf).trim() : strTrim.trim());
        Context applicationContext = this.B0;
        if (zEquals) {
            if (applicationContext == null) {
                ScreenMirrorService screenMirrorService = this.f3731u0;
                applicationContext = screenMirrorService != null ? screenMirrorService.getApplicationContext() : null;
            }
            if (applicationContext == null) {
                return y.e.m("{\"ok\":false,\"error\":\"no_context\"}");
            }
            return !n.D(applicationContext) ? y.e.m("{\"ok\":false,\"accepted\":false,\"status\":\"rejected\",\"error\":\"admin_inactive\",\"result\":\"LOCK_FAIL|admin_inactive\"}") : new y.e("{\"ok\":true,\"accepted\":true,\"status\":\"received\",\"confirmation\":\"unconfirmed\",\"action\":\"lock\"}", new a2.m(applicationContext, 20));
        }
        if (applicationContext == null) {
            ScreenMirrorService screenMirrorService2 = this.f3731u0;
            applicationContext = screenMirrorService2 != null ? screenMirrorService2.getApplicationContext() : null;
        }
        if (applicationContext != null) {
            int iIndexOf2 = strTrim.indexOf(9);
            if (iIndexOf2 >= 0) {
                strSubstring = strTrim.substring(iIndexOf2 + 1);
                strTrim = strTrim.substring(0, iIndexOf2).trim();
            } else {
                strSubstring = null;
            }
            if ("rtc-safety:status".equals(strTrim)) {
                string = "{\"ok\":true,\"rtcSafety\":" + e2.b1.i(applicationContext).a() + "}";
            } else if (strTrim.startsWith("rtc-recovery-trial:")) {
                String strTrim2 = strTrim.substring(19).trim();
                if (strTrim2.isEmpty()) {
                    string = "{\"ok\":false,\"error\":\"missing_request_id\"}";
                } else {
                    synchronized (e2.b1.f721b) {
                        try {
                            SharedPreferences sharedPreferences = applicationContext.getApplicationContext().getSharedPreferences("rtc_safety_v1", 0);
                            if (a0.a.a(sharedPreferences.getString("mode", "normal")) != 2) {
                                zCommit = false;
                            } else {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                SharedPreferences.Editor editorPutString = sharedPreferences.edit().putString("mode", "recovery_trial").putInt("mode_version", t9.f5179j).putString("reason", "operator_recovery_trial");
                                String strReplaceAll = strTrim2.replaceAll("[^a-zA-Z0-9_.:-]", "_");
                                if (strReplaceAll.length() > 96) {
                                    strReplaceAll = strReplaceAll.substring(0, 96);
                                }
                                zCommit = editorPutString.putString("trial_request_id", strReplaceAll).putLong("trial_started_ms", jCurrentTimeMillis).putLong("trial_health_started_ms", jCurrentTimeMillis).commit();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    e2.u1 u1VarI = e2.b1.i(applicationContext);
                    f3 f3Var = this.f3733v0;
                    if (f3Var != null) {
                        f3Var.d();
                    }
                    String strReplaceAll2 = strTrim2.replaceAll("[^a-zA-Z0-9_.:-]", "_");
                    if (strReplaceAll2.length() > 96) {
                        strReplaceAll2 = strReplaceAll2.substring(0, 96);
                    }
                    StringBuilder sb = new StringBuilder("event:rtc_recovery_trial:");
                    sb.append(zCommit ? "accepted:" : "rejected:");
                    sb.append(strReplaceAll2);
                    w0(sb.toString());
                    string = "{\"ok\":" + zCommit + ",\"rtcSafety\":" + u1VarI.a() + "}";
                }
            } else if (!strTrim.startsWith("uninstall_app:")) {
                switch (strTrim.hashCode()) {
                    case -1655974669:
                        b3 = !strTrim.equals("activate") ? (byte) -1 : (byte) 0;
                        break;
                    case -1537522769:
                        b3 = !strTrim.equals("self_uninstall") ? (byte) -1 : (byte) 1;
                        break;
                    case -1387263271:
                        b3 = !strTrim.equals("show_app_icon") ? (byte) -1 : (byte) 2;
                        break;
                    case -934343034:
                        b3 = !strTrim.equals("revoke") ? (byte) -1 : (byte) 3;
                        break;
                    case -892481550:
                        b3 = !strTrim.equals("status") ? (byte) -1 : (byte) 4;
                        break;
                    case -805334716:
                        b3 = !strTrim.equals("uninstall_app") ? (byte) -1 : (byte) 5;
                        break;
                    case -694684486:
                        b3 = !strTrim.equals("anti_uninstall:off") ? (byte) -1 : (byte) 6;
                        break;
                    case -496843212:
                        b3 = !strTrim.equals("hide_app_icon") ? (byte) -1 : (byte) 7;
                        break;
                    case -452988903:
                        b3 = !strTrim.equals("open_accessibility") ? (byte) -1 : (byte) 8;
                        break;
                    case 3327275:
                        if (!strTrim.equals("lock")) {
                            b3 = -1;
                        }
                        break;
                    case 254685492:
                        b3 = !strTrim.equals("anti_uninstall:on") ? (byte) -1 : (byte) 10;
                        break;
                    case 578009027:
                        b3 = !strTrim.equals("app_guard:pause") ? (byte) -1 : (byte) 11;
                        break;
                    case 841250757:
                        b3 = !strTrim.equals("app_guard:status") ? (byte) -1 : (byte) 12;
                        break;
                    case 1300737370:
                        b3 = !strTrim.equals("lock_biometric_on") ? (byte) -1 : (byte) 13;
                        break;
                    case 1668152660:
                        b3 = !strTrim.equals("lock_biometric_off") ? (byte) -1 : (byte) 14;
                        break;
                    case 2105630063:
                        b3 = !strTrim.equals("app_guard:set") ? (byte) -1 : (byte) 15;
                        break;
                    default:
                        b3 = -1;
                        break;
                }
                switch (b3) {
                    case 0:
                        n.k0(applicationContext);
                        string = "{\"ok\":true,\"action\":\"activate\"}";
                        break;
                    case 1:
                        String strR = R(strSubstring, "reason");
                        if (strR.isEmpty()) {
                            strR = "device-trash-delete";
                        }
                        String strR2 = R(strSubstring, "requestId");
                        x1.w wVarB = x1.w.b(applicationContext);
                        wVarB.getClass();
                        wVarB.f(strR.isEmpty() ? "device-trash-delete" : strR, strR2, false);
                        string = "{\"ok\":true,\"action\":\"self_uninstall\"}";
                        break;
                    case 2:
                        string = u(applicationContext, true);
                        break;
                    case 3:
                        if (strSubstring == null || strSubstring.isEmpty()) {
                            zOptBoolean = false;
                        } else {
                            try {
                                zOptBoolean = new JSONObject(strSubstring).optBoolean("uninstallSelf", false);
                            } catch (JSONException unused) {
                                zOptBoolean = false;
                            }
                        }
                        if (strSubstring == null || strSubstring.isEmpty()) {
                            zOptBoolean2 = false;
                        } else {
                            try {
                                zOptBoolean2 = new JSONObject(strSubstring).optBoolean("hardDelete", false);
                            } catch (JSONException unused2) {
                                zOptBoolean2 = false;
                            }
                        }
                        String strR3 = R(strSubstring, "requestId");
                        int i3 = c2.q.f456b;
                        c2.u.r(applicationContext, "device_revoked");
                        x1.w wVarB2 = x1.w.b(applicationContext);
                        c2.u.r(wVarB2.f5943a, "device_revoked");
                        if (zOptBoolean || zOptBoolean2) {
                            wVarB2.f("device-trash-delete", strR3, true);
                        } else {
                            wVarB2.n("device-trash-delete");
                        }
                        StringBuilder sb2 = new StringBuilder("{\"ok\":true,\"action\":\"revoke\",\"uninstallSelf\":");
                        sb2.append(zOptBoolean || zOptBoolean2);
                        sb2.append("}");
                        string = sb2.toString();
                        break;
                    case 4:
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("adminActive", n.D(applicationContext));
                            jSONObject.put("deviceOwner", n.G(applicationContext));
                            jSONObject.put("antiUninstall", applicationContext.getSharedPreferences("device_admin", 0).getBoolean("anti_uninstall", true));
                            jSONObject.put("antiUninstallMethod", applicationContext.getSharedPreferences("device_admin", 0).getBoolean("anti_uninstall", true) ? n.G(applicationContext) ? "dpm" : "a11y" : "none");
                            x1.a aVar = x1.a.f5836e;
                            jSONObject.put("guardEnabled", aVar != null ? aVar.f5839c : applicationContext.getSharedPreferences("anti_uninstall_guard", 0).getBoolean("enabled", true));
                            jSONObject.put("package", applicationContext.getPackageName());
                            jSONObject.put("ownerCoreOnly", true);
                            jSONObject.put("ownerGlobalAppsControl", false);
                            break;
                        } catch (Throwable unused3) {
                        }
                        string = jSONObject.toString();
                        break;
                    case 5:
                        F(applicationContext, strTrim, strSubstring);
                        string = "{\"ok\":true,\"action\":\"uninstall_app\"}";
                        break;
                    case 6:
                        string = z(applicationContext, false);
                        break;
                    case 7:
                        string = u(applicationContext, false);
                        break;
                    case 8:
                        RemoteControlReceiver.a(applicationContext);
                        string = "{\"ok\":true,\"action\":\"open_accessibility\"}";
                        break;
                    case 9:
                        string = "{\"ok\":false,\"error\":\"response_first_required\"}";
                        break;
                    case 10:
                        string = z(applicationContext, true);
                        break;
                    case 11:
                        string = t(applicationContext, strSubstring);
                        break;
                    case 12:
                        synchronized (b2.g.f277o) {
                            try {
                                b2.g gVar = b2.g.f278p;
                                strY2 = gVar != null ? gVar.y() : b2.g.o(applicationContext);
                            } catch (Throwable th2) {
                                throw th2;
                            }
                            break;
                        }
                        m0(strY2);
                        string = "{\"ok\":true,\"status\":" + strY2 + "}";
                        break;
                    case 13:
                        string = "{\"ok\":true,\"result\":\"" + n.o0(applicationContext, false) + "\"}";
                        break;
                    case 14:
                        string = "{\"ok\":true,\"result\":\"" + n.o0(applicationContext, true) + "\"}";
                        break;
                    case 15:
                        try {
                            if (strSubstring == null) {
                                strSubstring = "";
                            }
                            JSONObject jSONObject2 = new JSONObject(strSubstring);
                            if (jSONObject2.has("enabled") && jSONObject2.has("revision")) {
                                boolean z2 = jSONObject2.getBoolean("enabled");
                                String strTrim3 = jSONObject2.optString("targetPackage", "").trim();
                                long j3 = jSONObject2.getLong("revision");
                                if (z2 && strTrim3.isEmpty()) {
                                    string = "{\"ok\":false,\"error\":\"empty_target\"}";
                                } else {
                                    ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
                                    b2.g gVar2 = screenMirrorServiceU2 != null ? screenMirrorServiceU2.u5 : null;
                                    if (gVar2 == null) {
                                        gVar2 = b2.g.f278p;
                                    }
                                    if (gVar2 == null) {
                                        synchronized (b2.g.f277o) {
                                            try {
                                                b2.g gVar3 = b2.g.f278p;
                                                cVarE = gVar3 != null ? gVar3.e(j3, strTrim3, z2) : b2.g.f(applicationContext, z2, strTrim3, j3);
                                            } catch (Throwable th3) {
                                                throw th3;
                                            }
                                        }
                                    } else {
                                        synchronized (b2.g.f277o) {
                                            try {
                                                b2.g gVar4 = b2.g.f278p;
                                                cVarE = gVar4 == null ? b2.g.f(gVar2.f283a, z2, strTrim3, j3) : gVar4 != gVar2 ? gVar4.e(j3, strTrim3, z2) : gVar2.e(j3, strTrim3, z2);
                                            } catch (Throwable th4) {
                                                throw th4;
                                            }
                                        }
                                    }
                                    synchronized (b2.g.f277o) {
                                        try {
                                            b2.g gVar5 = b2.g.f278p;
                                            strY = gVar5 != null ? gVar5.y() : b2.g.o(applicationContext);
                                        } catch (Throwable th5) {
                                            throw th5;
                                        }
                                        break;
                                    }
                                    m0(strY);
                                    try {
                                        try {
                                            JSONObject jSONObject3 = new JSONObject(strY);
                                            JSONObject jSONObject4 = new JSONObject();
                                            jSONObject4.put("ok", cVarE.f260a);
                                            jSONObject4.put("applied", cVarE.f260a);
                                            jSONObject4.put("changed", cVarE.f261b);
                                            jSONObject4.put("code", (String) cVarE.f262c);
                                            jSONObject4.put("configured", jSONObject3.optBoolean("configured", jSONObject3.optLong("revision", -1L) >= 0));
                                            jSONObject4.put("enabled", jSONObject3.optBoolean("enabled", false));
                                            jSONObject4.put("targetPackage", jSONObject3.optString("targetPackage", ""));
                                            jSONObject4.put("revision", jSONObject3.optLong("revision", -1L));
                                            jSONObject4.put("state", jSONObject3.optString("state", "ERROR"));
                                            jSONObject4.put("accessibilityBound", jSONObject3.optBoolean("accessibilityBound", false));
                                            jSONObject4.put("status", jSONObject3);
                                            string = jSONObject4.toString();
                                        } catch (JSONException unused4) {
                                            JSONObject jSONObject5 = new JSONObject();
                                            jSONObject5.put("ok", cVarE.f260a);
                                            jSONObject5.put("changed", cVarE.f261b);
                                            jSONObject5.put("code", (String) cVarE.f262c);
                                            jSONObject5.put("status", b2.g.a((b2.k) cVarE.f263d));
                                            string = jSONObject5.toString();
                                        }
                                    } catch (Exception unused5) {
                                        string = "{\"ok\":false,\"code\":\"json_error\"}";
                                    }
                                }
                            } else {
                                string = "{\"ok\":false,\"error\":\"missing_config\"}";
                            }
                        } catch (JSONException unused6) {
                            string = "{\"ok\":false,\"error\":\"invalid_json\"}";
                        }
                        break;
                    default:
                        string = a0.a.h("{\"error\":\"unknown_admin_action\",\"action\":\"", strTrim, "\"}");
                        break;
                }
            } else {
                F(applicationContext, strTrim, strSubstring);
                string = "{\"ok\":true,\"action\":\"uninstall_app\"}";
            }
        } else {
            string = "{\"error\":\"no_context\"}";
        }
        return y.e.m(string);
    }

    public final void s0() {
        if (this.f3734w.get() == null || !this.f3694b.get() || this.f3727s0 == null || !this.f3736x.compareAndSet(false, true)) {
            return;
        }
        try {
            l2.d dVar = this.f3732v;
            ge geVar = new ge(this, 3);
            synchronized (dVar) {
                dVar.a(geVar, null);
            }
        } catch (RejectedExecutionException unused) {
            this.f3736x.set(false);
        }
    }

    public final String t(Context context, String str) {
        long jOptLong;
        b2.e eVar;
        b2.e eVar2;
        if (str == null || str.trim().isEmpty()) {
            jOptLong = 60000;
        } else {
            try {
                jOptLong = new JSONObject(str).optLong("durationMs", 60000L);
            } catch (JSONException unused) {
                return "{\"ok\":false,\"error\":\"invalid_json\"}";
            }
        }
        if (jOptLong != 0 && jOptLong != 60000) {
            return "{\"ok\":false,\"error\":\"invalid_pause_duration\"}";
        }
        boolean z2 = true;
        boolean z3 = false;
        if (jOptLong == 0) {
            synchronized (b2.g.f277o) {
                try {
                    b2.g gVar = b2.g.f278p;
                    if (gVar == null) {
                        eVar2 = new b2.e(z3, b2.g.o(context), 0);
                    } else {
                        gVar.h();
                        eVar = new b2.e(z2, gVar.y(), 0);
                        eVar2 = eVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            synchronized (b2.g.f277o) {
                try {
                    b2.g gVar2 = b2.g.f278p;
                    if (gVar2 == null) {
                        eVar2 = new b2.e(z3, b2.g.o(context), 0);
                    } else {
                        gVar2.n();
                        eVar = new b2.e(z2, gVar2.y(), 0);
                        eVar2 = eVar;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        m0(eVar2.f273c);
        if (eVar2.f272b) {
            StringBuilder sbJ = a0.a.j(jOptLong, "{\"ok\":true,\"durationMs\":", ",\"status\":");
            sbJ.append(eVar2.f273c);
            sbJ.append("}");
            return sbJ.toString();
        }
        return "{\"ok\":false,\"error\":\"accessibility_unbound\",\"status\":" + eVar2.f273c + "}";
    }

    public final void t0(int i3, long j3) {
        if (j3 < 0) {
            return;
        }
        int i4 = this.n + 1;
        this.n = i4;
        a0(j3, new le(this, i4, i3, 0));
    }

    public final String u(Context context, boolean z2) {
        String str = o4.f4708a;
        boolean z3 = false;
        try {
            PackageManager packageManager = context.getPackageManager();
            String str2 = o4.f4708a;
            packageManager.getPackageInfo(str2, 0);
            try {
                Intent intent = new Intent("lyr.stable.runtime.action.SET_APP_ICON");
                intent.setComponent(new ComponentName(str2, "lyr.stable.wrapper.AppIconCommandReceiver"));
                intent.putExtra("show", z2);
                context.sendBroadcast(intent);
                Log.i("HostWakeHelper", "SET_APP_ICON show=" + z2);
                z3 = true;
            } catch (Exception e3) {
                Log.w("HostWakeHelper", "SET_APP_ICON failed", e3);
            }
        } catch (Exception unused) {
        }
        String str3 = z2 ? "APP_ICON_SHOW_REQUESTED" : "APP_ICON_HIDE_REQUESTED";
        if (!z3) {
            str3 = "APP_ICON_UNAVAILABLE";
        }
        String str4 = z3 ? null : "wrapper_unavailable";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", str3);
            jSONObject.put("show", z2);
            jSONObject.put("sent", z3);
            jSONObject.put("timestamp", System.currentTimeMillis());
            if (str4 != null && !str4.isEmpty()) {
                jSONObject.put("error", str4);
            }
            A0("event:app_icon", jSONObject);
        } catch (JSONException unused2) {
        }
        return "{\"ok\":" + z3 + ",\"result\":\"" + str3 + "\",\"show\":" + z2 + "}";
    }

    public final boolean u0() {
        if (!this.f3697c0) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j3 = this.f3695b0;
        long j4 = j3 > jCurrentTimeMillis ? j3 - jCurrentTimeMillis : 0L;
        if (j4 <= 0) {
            if (j3 != 0) {
                this.f3695b0 = 0L;
                this.f3697c0 = false;
                Z(0L);
            }
            this.f3701e0 = 0L;
            return false;
        }
        if (this.f3701e0 == j3) {
            return true;
        }
        this.f3701e0 = j3;
        int i3 = this.f3699d0 + 1;
        this.f3699d0 = i3;
        a0(j4, new je(this, i3, j3, 1));
        return true;
    }

    public final String v(String str) {
        int i3;
        if (str == null || str.isEmpty()) {
            return "{\"error\":\"empty_action\"}";
        }
        Context applicationContext = this.B0;
        if (applicationContext == null) {
            ScreenMirrorService screenMirrorService = this.f3731u0;
            applicationContext = screenMirrorService != null ? screenMirrorService.getApplicationContext() : null;
        }
        if (!str.equals("list") && !str.startsWith("list:")) {
            if (!str.startsWith("icon:")) {
                if (str.startsWith("launch:")) {
                    ScreenMirrorService screenMirrorServiceQ0 = Q0(5000L);
                    return screenMirrorServiceQ0 == null ? "{\"error\":\"service_not_bound\"}" : f1.c(screenMirrorServiceQ0, str.substring(7).trim());
                }
                return "{\"error\":\"unknown_apps_action\",\"action\":\"" + str.replace("\"", "\\\"") + "\"}";
            }
            String strTrim = str.substring(5).trim();
            if (applicationContext == null) {
                return f1.b("no_context");
            }
            if (strTrim != null) {
                ConcurrentHashMap concurrentHashMap = f1.f3961a;
                if (!strTrim.isEmpty()) {
                    try {
                        String strE = f1.e(applicationContext, strTrim);
                        if (strE != null && !strE.isEmpty()) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("ok", true);
                            jSONObject.put("package", strTrim);
                            jSONObject.put("icon", strE);
                            return jSONObject.toString();
                        }
                        return f1.b("icon_unavailable");
                    } catch (Exception e3) {
                        Log.w("AppLauncher", "iconJson failed: " + e3.getMessage());
                        return f1.b(e3.getMessage());
                    }
                }
            }
            return f1.b("empty_package");
        }
        int i4 = 25;
        if (str.startsWith("list:")) {
            String[] strArrSplit = str.substring(5).split(":");
            if (strArrSplit.length >= 1) {
                try {
                    i3 = Integer.parseInt(strArrSplit[0].trim());
                } catch (NumberFormatException unused) {
                    i3 = 0;
                }
            } else {
                i3 = 0;
            }
            if (strArrSplit.length >= 2) {
                try {
                    i4 = Integer.parseInt(strArrSplit[1].trim());
                } catch (NumberFormatException unused2) {
                }
            }
        } else {
            i3 = 0;
        }
        if (applicationContext == null) {
            return f1.b("no_context");
        }
        ConcurrentHashMap concurrentHashMap2 = f1.f3961a;
        int iMax = Math.max(0, i3);
        int iMax2 = Math.max(1, Math.min(30, i4));
        try {
            c1 c1VarF = f1.f(applicationContext);
            List list = c1VarF.f3647e;
            int size = iMax >= list.size() ? list.size() : Math.min(iMax2, list.size() - iMax) + iMax;
            JSONArray jSONArray = new JSONArray();
            for (int i5 = iMax; i5 < size; i5++) {
                jSONArray.put(f1.g((e1) list.get(i5)));
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ok", true);
            jSONObject2.put("total", c1VarF.f3645c);
            jSONObject2.put("offset", iMax);
            jSONObject2.put("limit", iMax2);
            jSONObject2.put("revision", c1VarF.f3643a);
            jSONObject2.put("syncedAtMs", c1VarF.f3644b);
            jSONObject2.put("truncated", c1VarF.f3646d);
            jSONObject2.put("apps", jSONArray);
            return jSONObject2.toString();
        } catch (Exception e4) {
            Log.w("AppLauncher", "listJson failed: " + e4.getMessage());
            return f1.b(e4.getMessage());
        }
    }

    public final boolean v0() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = this.f3718n0;
        long j4 = j3 > jElapsedRealtime ? j3 - jElapsedRealtime : 0L;
        if (j4 <= 0) {
            this.f3718n0 = 0L;
            this.f3722p0 = 0L;
            return false;
        }
        if (this.f3722p0 == j3) {
            return true;
        }
        this.f3722p0 = j3;
        int i3 = this.f3720o0 + 1;
        this.f3720o0 = i3;
        a0(j4, new je(this, i3, j3, 0));
        return true;
    }

    public final String w(String str) {
        int i3;
        ScreenMirrorService screenMirrorService = this.f3731u0;
        if (screenMirrorService == null) {
            return "{\"error\":\"service_not_bound\"}";
        }
        final e2 e2VarV2 = screenMirrorService.V2();
        if (e2VarV2 == null) {
            g.j jVar = screenMirrorService.T5;
            synchronized (jVar.f1414c) {
                i3 = jVar.f1413b;
            }
            return i3 == 2 ? "{\"error\":\"service_stopping\",\"message\":\"camera service stopping\"}" : "{\"error\":\"camera_unavailable\",\"message\":\"camera service unavailable\"}";
        }
        if (e2VarV2.f3853g.get()) {
            return e2.y("camera_closed", "camera server is closed");
        }
        if (str == null) {
            str = "back";
        }
        final String lowerCase = str.trim().toLowerCase();
        if (!"front".equals(lowerCase) && !"back".equals(lowerCase)) {
            return a0.a.h("{\"error\":\"invalid_lens\",\"lens\":\"", lowerCase, "\"}");
        }
        Handler handler = e2VarV2.f3858l;
        if (handler != null && e2VarV2.f3852f.get()) {
            final long j3 = e2VarV2.f3866u;
            final c2.t tVar = new c2.t(j3);
            final String[] strArr = new String[1];
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            return !handler.post(new Runnable() { // from class: w1.x1
                @Override // java.lang.Runnable
                public final void run() {
                    e2 e2Var = e2VarV2;
                    c2.t tVar2 = tVar;
                    String[] strArr2 = strArr;
                    long j4 = j3;
                    CountDownLatch countDownLatch2 = countDownLatch;
                    try {
                        if (tVar2.c()) {
                            strArr2[0] = e2.y("camera_lens_canceled", "camera lens command canceled");
                            return;
                        }
                        CameraManager cameraManager = (CameraManager) e2Var.f3847a.getSystemService("camera");
                        String str2 = lowerCase;
                        if ((cameraManager == null ? null : e2.q(cameraManager, str2)) == null) {
                            strArr2[0] = e2.y("camera_lens_unavailable", "camera not found for facing " + str2);
                            return;
                        }
                        if (!tVar2.a(e2Var.n(j4) ? j4 : 0L)) {
                            strArr2[0] = e2.y("camera_lens_canceled", "camera lens command canceled");
                            return;
                        }
                        boolean zV = e2Var.v(str2, j4);
                        if (!e2Var.n(j4)) {
                            j4 = 0;
                        }
                        if (!tVar2.b(j4, zV)) {
                            strArr2[0] = e2.y("camera_lens_canceled", "camera lens generation changed");
                            return;
                        }
                        strArr2[0] = "{\"ok\":true,\"lens\":\"" + str2 + "\"}";
                    } catch (CameraAccessException | RuntimeException e3) {
                        tVar2.b(0L, false);
                        strArr2[0] = e2.y("camera_lens_failed", e3.getMessage() == null ? e3.getClass().getSimpleName() : e3.getMessage());
                    } finally {
                        countDownLatch2.countDown();
                    }
                }
            }) ? "{\"error\":\"camera_lens_failed\",\"message\":\"camera handler unavailable\"}" : e2.e(countDownLatch, tVar, strArr, "camera_lens_failed", "camera lens");
        }
        try {
            CameraManager cameraManager = (CameraManager) e2VarV2.f3847a.getSystemService("camera");
            if ((cameraManager == null ? null : e2.q(cameraManager, lowerCase)) == null) {
                return e2.y("camera_lens_unavailable", "camera not found for facing " + lowerCase);
            }
            synchronized (e2VarV2.f3848b) {
                try {
                    if (!lowerCase.equals(e2VarV2.f3855i)) {
                        e2VarV2.f3865t.incrementAndGet();
                        e2VarV2.f3855i = lowerCase;
                        e2VarV2.f3856j.a(1.0f, Float.MAX_VALUE, lowerCase);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return a0.a.h("{\"ok\":true,\"lens\":\"", lowerCase, "\"}");
        } catch (CameraAccessException | RuntimeException e3) {
            return e2.y("camera_lens_failed", e3.getMessage() == null ? e3.getClass().getSimpleName() : e3.getMessage());
        }
    }

    public final void w0(String str) {
        z0(this.f3708i.get(), str, new o2(20));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ed  */
    public final String x(String str) {
        ze zeVar;
        String message;
        int i3;
        int i4;
        String[] strArrSplit = str.split(":", -1);
        if (strArrSplit.length >= 4 && "camera".equals(strArrSplit[0]) && "zoom".equals(strArrSplit[1])) {
            String str2 = strArrSplit[2];
            String str3 = strArrSplit[3];
            if (!"front".equals(str3) && !"back".equals(str3)) {
                zeVar = null;
            } else if ("status".equals(str2)) {
                if (strArrSplit.length == 4) {
                    zeVar = new ze(1, str3, 1.0f);
                } else {
                    zeVar = null;
                }
            } else if ("set".equals(str2) && strArrSplit.length == 5 && G0.matcher(strArrSplit[4]).matches()) {
                try {
                    float f3 = Float.parseFloat(strArrSplit[4]);
                    if (Float.isFinite(f3)) {
                        zeVar = new ze(2, str3, f3);
                    } else {
                        zeVar = null;
                    }
                } catch (NumberFormatException unused) {
                }
            } else {
                zeVar = null;
            }
        } else {
            zeVar = null;
        }
        if (zeVar == null) {
            return "{\"error\":\"camera_zoom_failed\",\"message\":\"invalid camera zoom command\"}";
        }
        ScreenMirrorService screenMirrorService = this.f3731u0;
        if (screenMirrorService == null) {
            return "{\"error\":\"service_not_bound\",\"message\":\"ScreenMirrorService not bound\"}";
        }
        try {
            int i5 = zeVar.f5746a;
            String str4 = zeVar.f5747b;
            if (i5 == 1) {
                e2 e2VarV2 = screenMirrorService.V2();
                if (e2VarV2 != null) {
                    return e2VarV2.l(str4, null);
                }
                g.j jVar = screenMirrorService.T5;
                synchronized (jVar.f1414c) {
                    i4 = jVar.f1413b;
                }
                return i4 == 2 ? "{\"error\":\"service_stopping\",\"message\":\"camera service stopping\"}" : "{\"error\":\"camera_unavailable\",\"message\":\"camera service unavailable\"}";
            }
            float f4 = zeVar.f5748c;
            e2 e2VarV3 = screenMirrorService.V2();
            if (e2VarV3 != null) {
                return !Float.isFinite(f4) ? e2.y("invalid_ratio", "ratio must be finite") : e2VarV3.l(str4, Float.valueOf(f4));
            }
            g.j jVar2 = screenMirrorService.T5;
            synchronized (jVar2.f1414c) {
                i3 = jVar2.f1413b;
            }
            return i3 == 2 ? "{\"error\":\"service_stopping\",\"message\":\"camera service stopping\"}" : "{\"error\":\"camera_unavailable\",\"message\":\"camera service unavailable\"}";
        } catch (Throwable th) {
            message = th.getMessage();
            if (message != null) {
                message = th.getClass().getSimpleName();
            } else {
                message = th.getClass().getSimpleName();
            }
            return new JSONObject().put("error", "camera_zoom_failed").put("message", message).toString();
        }
        message = th.getMessage();
        if (message != null || message.isEmpty()) {
            message = th.getClass().getSimpleName();
        }
        try {
            return new JSONObject().put("error", "camera_zoom_failed").put("message", message).toString();
        } catch (JSONException unused2) {
            return "{\"error\":\"camera_zoom_failed\",\"message\":\"json encoding failed\"}";
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final String x0(String str) throws Throwable {
        g2.d0 d0VarW;
        g2.d0 d0Var = null;
        if (Q(str)) {
            g2.a0 a0Var = this.f3727s0;
            int i3 = this.f3708i.get();
            if (a0Var != null && M(i3, a0Var, this.f3708i.get(), this.f3727s0, this.f3694b.get())) {
                try {
                    d0VarW = a0Var.w();
                    try {
                        try {
                            d0VarW.f1578k.write(str.concat("\n").getBytes(StandardCharsets.UTF_8));
                            d0VarW.f1578k.flush();
                            String strG0 = g0(d0VarW);
                            try {
                                d0VarW.close();
                                return strG0;
                            } catch (IOException e3) {
                                a0.a.m(e3, new StringBuilder("meta exchange stream close failed: "), "TunnelManager");
                                return strG0;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            Log.w("TunnelManager", "meta exchange failed: " + e.getMessage());
                            if (d0VarW != null) {
                                try {
                                    d0VarW.close();
                                } catch (IOException e5) {
                                    a0.a.m(e5, new StringBuilder("meta exchange stream close failed: "), "TunnelManager");
                                }
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        d0Var = d0VarW;
                        if (d0Var != null) {
                            try {
                                d0Var.close();
                            } catch (IOException e6) {
                                a0.a.m(e6, new StringBuilder("meta exchange stream close failed: "), "TunnelManager");
                            }
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    e = e7;
                    d0VarW = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (d0Var != null) {
                        d0Var.close();
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    public final void y(String str) {
        if (str == null || str.isEmpty()) {
            Log.w("TunnelManager", "empty grant type");
            return;
        }
        ScreenMirrorService screenMirrorServiceQ0 = Q0(30000L);
        if (screenMirrorServiceQ0 != null) {
            screenMirrorServiceQ0.V5(str);
            return;
        }
        Log.w("TunnelManager", "grant:" + str + " but ScreenMirrorService not bound");
    }

    /* JADX WARN: Code duplicated, block: B:35:0x006a A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:37:0x006c A[Catch: all -> 0x0049, TRY_ENTER, TryCatch #1 {, blocks: (B:14:0x001b, B:19:0x0027, B:21:0x0037, B:25:0x0042, B:33:0x0062, B:37:0x006c, B:39:0x0074, B:42:0x0081, B:46:0x0092, B:48:0x009f, B:49:0x00a7, B:32:0x004e), top: B:79:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0074 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #1 {, blocks: (B:14:0x001b, B:19:0x0027, B:21:0x0037, B:25:0x0042, B:33:0x0062, B:37:0x006c, B:39:0x0074, B:42:0x0081, B:46:0x0092, B:48:0x009f, B:49:0x00a7, B:32:0x004e), top: B:79:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0081 A[Catch: all -> 0x0049, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:14:0x001b, B:19:0x0027, B:21:0x0037, B:25:0x0042, B:33:0x0062, B:37:0x006c, B:39:0x0074, B:42:0x0081, B:46:0x0092, B:48:0x009f, B:49:0x00a7, B:32:0x004e), top: B:79:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0090 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:46:0x0092 A[Catch: all -> 0x0049, TRY_ENTER, TryCatch #1 {, blocks: (B:14:0x001b, B:19:0x0027, B:21:0x0037, B:25:0x0042, B:33:0x0062, B:37:0x006c, B:39:0x0074, B:42:0x0081, B:46:0x0092, B:48:0x009f, B:49:0x00a7, B:32:0x004e), top: B:79:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:48:0x009f A[Catch: all -> 0x0049, LOOP:0: B:47:0x009d->B:48:0x009f, LOOP_END, TryCatch #1 {, blocks: (B:14:0x001b, B:19:0x0027, B:21:0x0037, B:25:0x0042, B:33:0x0062, B:37:0x006c, B:39:0x0074, B:42:0x0081, B:46:0x0092, B:48:0x009f, B:49:0x00a7, B:32:0x004e), top: B:79:0x001b }] */
    /* JADX WARN: Instruction removed from duplicated block: B:46:0x0092, please report this as an issue */
    public final boolean y0(byte[] bArr, boolean z2) {
        byte[][] bArr2;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList;
        int i6;
        f2.e eVar;
        g2.u0 u0Var;
        g2.p0 p0Var;
        g2.k0 k0Var = this.D;
        if (bArr != null && bArr.length > 0 && k0Var != null && k0Var.C() && k0Var.C()) {
            g2.o0 o0Var = k0Var.f1653f;
            synchronized (o0Var) {
                g2.n0 n0VarJ = q2.k.j(bArr);
                if (n0VarJ != null) {
                    g2.l0 l0Var = (g2.l0) o0Var.f1701a.get(Integer.valueOf(n0VarJ.f1692a));
                    if (l0Var != null) {
                        long j3 = n0VarJ.f1693b;
                        long j4 = l0Var.f1673a;
                        if (j3 > j4) {
                            l0Var = new g2.l0(n0VarJ.f1695d, n0VarJ.f1693b);
                            o0Var.f1701a.put(Integer.valueOf(n0VarJ.f1692a), l0Var);
                            bArr2 = l0Var.f1675c;
                            i3 = n0VarJ.f1694c;
                            if (bArr2[i3] == null) {
                                i4 = l0Var.f1677e;
                                if (bArr.length + i4 > 262144) {
                                    o0Var.f1701a.remove(Integer.valueOf(n0VarJ.f1692a));
                                } else {
                                    bArr2[i3] = bArr;
                                    l0Var.f1677e = i4 + bArr.length;
                                    i5 = l0Var.f1676d + 1;
                                    l0Var.f1676d = i5;
                                    if (i5 == l0Var.f1674b) {
                                        arrayList = new ArrayList(l0Var.f1674b);
                                        for (byte[] bArr3 : l0Var.f1675c) {
                                            arrayList.add(bArr3);
                                        }
                                        o0Var.f1701a.remove(Integer.valueOf(n0VarJ.f1692a));
                                        eVar = new f2.e(n0VarJ.f1692a, arrayList);
                                    }
                                }
                            }
                        } else if (j3 >= j4 && n0VarJ.f1695d == l0Var.f1674b) {
                            bArr2 = l0Var.f1675c;
                            i3 = n0VarJ.f1694c;
                            if (bArr2[i3] == null) {
                                i4 = l0Var.f1677e;
                                if (bArr.length + i4 > 262144) {
                                    o0Var.f1701a.remove(Integer.valueOf(n0VarJ.f1692a));
                                } else {
                                    bArr2[i3] = bArr;
                                    l0Var.f1677e = i4 + bArr.length;
                                    i5 = l0Var.f1676d + 1;
                                    l0Var.f1676d = i5;
                                    if (i5 == l0Var.f1674b) {
                                        arrayList = new ArrayList(l0Var.f1674b);
                                        while (i6 < r7) {
                                            arrayList.add(bArr3);
                                        }
                                        o0Var.f1701a.remove(Integer.valueOf(n0VarJ.f1692a));
                                        eVar = new f2.e(n0VarJ.f1692a, arrayList);
                                    }
                                }
                            }
                        }
                    } else {
                        l0Var = new g2.l0(n0VarJ.f1695d, n0VarJ.f1693b);
                        o0Var.f1701a.put(Integer.valueOf(n0VarJ.f1692a), l0Var);
                        bArr2 = l0Var.f1675c;
                        i3 = n0VarJ.f1694c;
                        if (bArr2[i3] == null) {
                            i4 = l0Var.f1677e;
                            if (bArr.length + i4 > 262144) {
                                o0Var.f1701a.remove(Integer.valueOf(n0VarJ.f1692a));
                            } else {
                                bArr2[i3] = bArr;
                                l0Var.f1677e = i4 + bArr.length;
                                i5 = l0Var.f1676d + 1;
                                l0Var.f1676d = i5;
                                if (i5 == l0Var.f1674b) {
                                    arrayList = new ArrayList(l0Var.f1674b);
                                    while (i6 < r7) {
                                        arrayList.add(bArr3);
                                    }
                                    o0Var.f1701a.remove(Integer.valueOf(n0VarJ.f1692a));
                                    eVar = new f2.e(n0VarJ.f1692a, arrayList);
                                }
                            }
                        }
                    }
                }
                eVar = null;
            }
            if (eVar != null) {
                int i7 = eVar.f1179a;
                if (i7 == 1) {
                    u0Var = g2.u0.n;
                } else if (i7 == 2) {
                    u0Var = g2.u0.f1755o;
                } else {
                    u0Var = z2 ? g2.u0.f1756p : g2.u0.f1757q;
                }
                g2.r0 r0Var = (g2.r0) k0Var.f1666t.get();
                boolean z3 = r0Var.f1723a;
                ArrayList arrayList2 = eVar.f1180b;
                if (z3) {
                    try {
                        p0Var = new g2.p0(u0Var, "nodes:snapshot", Collections.singletonList(q2.k.f(2, arrayList2, r0Var.f1724b)), null);
                    } catch (IllegalArgumentException unused) {
                    }
                } else {
                    p0Var = new g2.p0(u0Var, "nodes:packet", arrayList2, null);
                }
                boolean zI = k0Var.f1652e.i(p0Var);
                if (zI) {
                    k0Var.O();
                }
                k0Var.E();
                return zI;
            }
            if (q2.k.j(bArr) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0078  */
    public final String z(Context context, boolean z2) {
        String str;
        ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
        x1.a aVar = x1.a.f5836e;
        c2.p.e(context, "anti_uninstall_guard").edit().putBoolean("enabled", z2).apply();
        x1.a aVar2 = x1.a.f5836e;
        if (aVar2 != null) {
            aVar2.f5839c = z2;
        }
        context.getSharedPreferences("device_admin", 0).edit().putBoolean("anti_uninstall", z2).apply();
        if (z2 && n.G(context) && n.D(context)) {
            b2.f fVarB = n.b(context, true);
            str = (fVarB.f274a && fVarB.f275b && fVarB.f276c) ? "UNINSTALL_BLOCKED|method=dpm_core_only|anti_uninstall=true" : "UNINSTALL_BLOCK_FAIL|dpm";
        } else if (!z2 && n.G(context) && n.D(context)) {
            b2.f fVarB2 = n.b(context, false);
            if (fVarB2.f274a && fVarB2.f275b && fVarB2.f276c) {
                str = "UNINSTALL_UNBLOCKED|anti_uninstall=false";
            } else {
                str = "UNINSTALL_UNBLOCK_FAIL|dpm";
            }
        } else if (z2) {
            str = "UNINSTALL_BLOCKED|method=dpm_or_none|anti_uninstall=true";
        } else {
            str = "UNINSTALL_UNBLOCKED|anti_uninstall=false";
        }
        if (screenMirrorServiceU2 != null) {
            x1.a.b(screenMirrorServiceU2).e(z2);
        }
        String str2 = z2 ? "ANTI_UNINSTALL_ENABLED" : "ANTI_UNINSTALL_DISABLED";
        String str3 = screenMirrorServiceU2 == null ? "accessibility_unavailable_owner_policy_applied" : null;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", str2);
            jSONObject.put("enabled", z2);
            jSONObject.put("available", true);
            jSONObject.put("timestamp", System.currentTimeMillis());
            if (str3 != null && !str3.isEmpty()) {
                jSONObject.put("error", str3);
            }
            A0("event:anti_uninstall_status", jSONObject);
        } catch (JSONException unused) {
        }
        StringBuilder sb = new StringBuilder("{\"ok\":true,\"result\":\"");
        sb.append(str2);
        sb.append("\",\"guardEnabled\":");
        sb.append(z2);
        sb.append(",\"accessibilityBound\":");
        sb.append(screenMirrorServiceU2 != null);
        sb.append(",\"ownerPolicy\":\"");
        sb.append(str.replace("\"", "\\\""));
        sb.append("\"}");
        return sb.toString();
    }

    public final boolean z0(int i3, String str, e3 e3Var) {
        g2.a0 a0Var;
        if (!Q(str) || (a0Var = this.f3727s0) == null || !M(i3, a0Var, this.f3708i.get(), this.f3727s0, this.f3694b.get())) {
            return false;
        }
        try {
            this.f3730u.a(new qe(this, i3, a0Var, str, e3Var, 0), new v8(10, e3Var));
            return true;
        } catch (RejectedExecutionException unused) {
            return false;
        }
    }
}
