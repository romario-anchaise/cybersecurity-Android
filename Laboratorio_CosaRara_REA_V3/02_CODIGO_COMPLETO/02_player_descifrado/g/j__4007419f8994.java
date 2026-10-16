// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.ImageReader;
import android.util.Log;
import androidx.work.impl.WorkDatabase_Impl;
import d2.o;
import e2.n1;
import e2.q0;
import g2.a0;
import g2.d0;
import i1.q;
import i2.v;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import lyr.stable.runtime.ScreenMirrorService;
import w1.cf;
import w1.ja;
import w1.o2;
import w1.q9;
import w1.r9;
import w1.se;
import w1.z9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f1415d;

    public j(ImageReader imageReader, d2.b bVar) {
        this.f1412a = 4;
        this.f1413b = 1;
        if (imageReader == null) {
            o2.i("resource and closer required");
            throw null;
        }
        this.f1414c = imageReader;
        this.f1415d = bVar;
    }

    public static void c(String str) {
        if (str.equalsIgnoreCase(":memory:")) {
            return;
        }
        int length = str.length() - 1;
        int i3 = 0;
        boolean z2 = false;
        while (i3 <= length) {
            boolean z3 = q1.e.b(str.charAt(!z2 ? i3 : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                } else {
                    length--;
                }
            } else if (z3) {
                i3++;
            } else {
                z2 = true;
            }
        }
        if (str.subSequence(i3, length + 1).toString().length() == 0) {
            return;
        }
        Log.w("SupportSQLite", "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception e3) {
            Log.w("SupportSQLite", "delete failed: ", e3);
        }
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f1413b != 1) {
                    return;
                }
                this.f1413b = 3;
                ((d2.b) this.f1415d).accept(this.f1414c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.f1414c) {
            try {
                if (this.f1413b == 2) {
                    this.f1413b = 1;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(k.c cVar) throws IOException {
        n1 n1Var = (n1) this.f1415d;
        Cursor cursorE = cVar.E(new j.a("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"));
        try {
            boolean z2 = cursorE.moveToFirst() && cursorE.getInt(0) == 0;
            cursorE.close();
            n1.k(cVar);
            if (!z2) {
                b2.e eVarO = n1.o(cVar);
                if (!eVarO.f272b) {
                    throw new IllegalStateException("Pre-packaged database has an invalid schema: " + eVarO.f273c);
                }
            }
            j(cVar);
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) n1Var.f905c;
            List list = workDatabase_Impl.f215f;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((q.b) workDatabase_Impl.f215f.get(i3)).getClass();
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                y.f.c(cursorE, th);
                throw th2;
            }
        }
    }

    public void f(int i3, d0 d0Var) {
        d0 d0Var2;
        j.b bVar;
        boolean z2;
        if (this.f1413b != ((cf) this.f1415d).f3708i.get()) {
            cf.l(d0Var, "generation_or_service_revoked");
            return;
        }
        cf cfVar = (cf) this.f1415d;
        int i4 = this.f1413b;
        a0 a0Var = (a0) ((AtomicReference) this.f1414c).get();
        Log.i("TunnelManager", "incoming stream channel=0x" + Integer.toHexString(i3));
        if (cfVar.O() && i3 != 255) {
            Log.i("TunnelManager", "locked phase rejected channel=0x" + Integer.toHexString(i3));
            cf.l(d0Var, "service_unavailable_locked");
            return;
        }
        if (i3 == 255) {
            new Thread(new ja(cfVar, d0Var, i4, a0Var), "tunnel-meta").start();
            return;
        }
        try {
            switch (i3) {
                case 1:
                    Log.w("TunnelManager", "unexpected inbound video stream; closing");
                    d0Var.close();
                    return;
                case 2:
                    ScreenMirrorService screenMirrorServiceQ0 = cfVar.Q0(30000L);
                    if (screenMirrorServiceQ0 == null) {
                        Log.w("TunnelManager", "control stream arrived but ScreenMirrorService never bound after 30s; closing");
                        cf.l(d0Var, "service_unbound");
                        return;
                    }
                    try {
                        screenMirrorServiceQ0.Y2(d0Var.f1577j, d0Var.f1578k, "socket/control#" + d0Var.f1571d, new z9(1, d0Var));
                        return;
                    } catch (Throwable th) {
                        Log.w("TunnelManager", "handleControl wiring failed: " + th.getMessage());
                        cf.l(d0Var, "handler_wiring_failed");
                        return;
                    }
                case 3:
                    ScreenMirrorService screenMirrorServiceQ1 = cfVar.Q0(30000L);
                    if (screenMirrorServiceQ1 == null) {
                        Log.w("TunnelManager", "file stream arrived but ScreenMirrorService never bound after 30s; closing");
                        d0Var.close();
                        return;
                    }
                    String str = "socket/file#" + d0Var.f1571d;
                    try {
                        if (screenMirrorServiceQ1.Z2(d0Var.f1577j, d0Var.f1578k, str, new se(1, d0Var))) {
                            return;
                        }
                        Log.w("TunnelManager", "file server rejected attach; closing ".concat(str));
                        d0Var.close();
                        return;
                    } catch (Throwable th2) {
                        a0.a.p(th2, new StringBuilder("handleFile wiring failed: "), "TunnelManager");
                        d0Var.close();
                        return;
                    }
                case 4:
                    ScreenMirrorService screenMirrorServiceQ2 = cfVar.Q0(30000L);
                    if (screenMirrorServiceQ2 == null) {
                        Log.w("TunnelManager", "notif stream arrived but ScreenMirrorService never bound after 30s; closing");
                        d0Var.close();
                        return;
                    }
                    String str2 = "socket/notif#" + d0Var.f1571d;
                    try {
                        if (screenMirrorServiceQ2.c3(d0Var.f1577j, d0Var.f1578k, str2, new se(2, d0Var))) {
                            return;
                        }
                        Log.w("TunnelManager", "notif server rejected attach; closing ".concat(str2));
                        d0Var.close();
                        return;
                    } catch (Throwable th3) {
                        a0.a.p(th3, new StringBuilder("handleNotif wiring failed: "), "TunnelManager");
                        d0Var.close();
                        return;
                    }
                case 5:
                    ScreenMirrorService screenMirrorServiceQ3 = cfVar.Q0(30000L);
                    if (screenMirrorServiceQ3 == null) {
                        Log.w("TunnelManager", "sms stream arrived but ScreenMirrorService never bound after 30s; closing");
                        d0Var.close();
                        return;
                    }
                    String str3 = "socket/sms#" + d0Var.f1571d;
                    try {
                        if (screenMirrorServiceQ3.g3(d0Var.f1577j, d0Var.f1578k, str3, new se(3, d0Var))) {
                            return;
                        }
                        Log.w("TunnelManager", "sms server rejected attach; closing ".concat(str3));
                        d0Var.close();
                        return;
                    } catch (Throwable th4) {
                        a0.a.p(th4, new StringBuilder("handleSms wiring failed: "), "TunnelManager");
                        d0Var.close();
                        return;
                    }
                case 6:
                    ScreenMirrorService screenMirrorServiceQ4 = cfVar.Q0(30000L);
                    if (screenMirrorServiceQ4 == null) {
                        Log.w("TunnelManager", "keylog stream arrived but ScreenMirrorService never bound after 30s; closing");
                        d0Var.close();
                        return;
                    }
                    String str4 = "socket/keylog#" + d0Var.f1571d;
                    try {
                        if (screenMirrorServiceQ4.b3(d0Var.f1577j, d0Var.f1578k, str4, new se(0, d0Var))) {
                            return;
                        }
                        Log.w("TunnelManager", "keylog server rejected attach; closing ".concat(str4));
                        d0Var.close();
                        return;
                    } catch (Throwable th5) {
                        a0.a.p(th5, new StringBuilder("handleKeylog wiring failed: "), "TunnelManager");
                        d0Var.close();
                        return;
                    }
                case 7:
                    Log.w("TunnelManager", "unexpected inbound camera stream; closing");
                    d0Var.close();
                    return;
                case 8:
                    if (!cfVar.f3694b.get() || a0Var == null || a0Var != cfVar.f3727s0 || i4 != cfVar.f3708i.get()) {
                        d0Var.close();
                        return;
                    }
                    r9 r9Var = cfVar.S;
                    synchronized (r9Var) {
                        try {
                            if (r9Var.f5004e != 0 || r9Var.f5005f) {
                                d0Var2 = d0Var;
                                bVar = new j.b(false, (q9) null, (Object) null, (Thread) null, false);
                            } else {
                                if (!r9Var.f5006g || i4 > r9Var.f5008i) {
                                    q9 q9Var = r9Var.f5002c;
                                    if (q9Var != null) {
                                        q9Var.f4934h = true;
                                        long jMax = Math.max(0L, 250L) * 1000000;
                                        long jNanoTime = System.nanoTime() + jMax;
                                        while (q9Var.f4933g > 0 && jMax > 0) {
                                            try {
                                                r9Var.wait(jMax / 1000000, (int) (jMax % 1000000));
                                                jMax = jNanoTime - System.nanoTime();
                                            } catch (InterruptedException unused) {
                                                z2 = true;
                                            }
                                        }
                                        z2 = false;
                                        if (q9Var.f4933g > 0 || z2) {
                                            bVar = new j.b(false, (q9) null, q9Var.f4927a, q9Var.f4935i, z2);
                                        }
                                    }
                                    if (r9Var.f5002c == q9Var && r9Var.f5004e == 0 && !r9Var.f5005f) {
                                        long j3 = r9Var.f5009j + 1;
                                        r9Var.f5009j = j3;
                                        d0Var2 = d0Var;
                                        q9 q9Var2 = new q9(d0Var2, i4, a0Var, j3);
                                        r9Var.f5002c = q9Var2;
                                        r9Var.f5007h = Math.max(r9Var.f5007h, i4);
                                        r9Var.f5006g = false;
                                        bVar = new j.b(true, q9Var2, q9Var == null ? null : q9Var.f4927a, q9Var != null ? q9Var.f4935i : null, false);
                                    } else {
                                        d0Var2 = d0Var;
                                        bVar = q9Var != null ? new j.b(false, (q9) null, q9Var.f4927a, q9Var.f4935i, false) : new j.b(false, (q9) null, (Object) null, (Thread) null, false);
                                    }
                                } else {
                                    bVar = new j.b(false, (q9) null, (Object) null, (Thread) null, false);
                                }
                                d0Var2 = d0Var;
                            }
                        } catch (Throwable th6) {
                            throw th6;
                        }
                    }
                    Thread thread = (Thread) bVar.f2306e;
                    d0 d0Var3 = (d0) bVar.f2305d;
                    if (thread != null) {
                        thread.interrupt();
                    }
                    if (d0Var3 != null) {
                        try {
                            d0Var3.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                    if (!bVar.f2302a) {
                        try {
                            d0Var2.close();
                            break;
                        } catch (IOException unused3) {
                        }
                        if (bVar.f2303b) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                        return;
                    }
                    q9 q9Var3 = (q9) bVar.f2304c;
                    Thread thread2 = new Thread(new q0(cfVar, d0Var2, q9Var3, 18), "rtc-control-plane");
                    r9 r9Var2 = cfVar.S;
                    synchronized (r9Var2) {
                        if (r9Var2.b(q9Var3)) {
                            q9Var3.f4935i = thread2;
                            thread2.start();
                            return;
                        }
                        return;
                    }
                case 9:
                    Log.w("TunnelManager", "unexpected inbound WebP stream; closing");
                    d0Var.close();
                    return;
                case 10:
                    Log.w("TunnelManager", "unexpected inbound nodes stream; closing");
                    d0Var.close();
                    return;
                case 11:
                    Context context = cfVar.B0;
                    if (context == null || !cfVar.f3700e.compareAndSet(false, true)) {
                        d0Var.close();
                        return;
                    }
                    Thread thread3 = new Thread(new q0(cfVar, context, d0Var, 17), "app-inventory");
                    thread3.setDaemon(true);
                    thread3.start();
                    return;
                default:
                    Log.w("TunnelManager", "unknown channel; closing");
                    d0Var.close();
                    return;
            }
        } catch (IOException unused4) {
        }
    }

    public boolean g(final h2.j jVar) {
        final int i3 = this.f1413b;
        final AtomicReference atomicReference = (AtomicReference) this.f1414c;
        FutureTask futureTask = new FutureTask(new Callable() { // from class: w1.we
            /* JADX WARN: Code duplicated, block: B:45:0x00b2 A[DONT_GENERATE] */
            /* JADX WARN: Code duplicated, block: B:47:0x00b4 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:48:0x00b6 A[Catch: all -> 0x006b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x006b, blocks: (B:23:0x0059, B:25:0x0061, B:28:0x006e, B:30:0x0076, B:32:0x007a, B:37:0x008a, B:39:0x008e, B:41:0x00a0, B:42:0x00aa, B:48:0x00b6, B:57:0x00c7), top: B:124:0x0059 }] */
            /* JADX WARN: Code duplicated, block: B:50:0x00bc A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:51:0x00be  */
            /* JADX WARN: Code duplicated, block: B:52:0x00c0 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:53:0x00c2  */
            /* JADX WARN: Code duplicated, block: B:54:0x00c4  */
            /* JADX WARN: Code duplicated, block: B:57:0x00c7 A[Catch: all -> 0x006b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x006b, blocks: (B:23:0x0059, B:25:0x0061, B:28:0x006e, B:30:0x0076, B:32:0x007a, B:37:0x008a, B:39:0x008e, B:41:0x00a0, B:42:0x00aa, B:48:0x00b6, B:57:0x00c7), top: B:124:0x0059 }] */
            /* JADX WARN: Code duplicated, block: B:59:0x00cf  */
            /* JADX WARN: Code duplicated, block: B:60:0x00d1 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:61:0x00d3  */
            /* JADX WARN: Code duplicated, block: B:62:0x00d5  */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                int i4;
                long j3;
                long j4;
                boolean z2;
                boolean z3;
                boolean z4;
                long j5;
                long j6;
                g.j jVar2 = this.f5434a;
                int i5 = i3;
                AtomicReference atomicReference2 = atomicReference;
                h2.j jVar3 = jVar;
                cf cfVar = (cf) jVar2.f1415d;
                g2.a0 a0Var = (g2.a0) atomicReference2.get();
                boolean z5 = false;
                if (i5 == cfVar.f3708i.get() && a0Var != null && a0Var == cfVar.f3727s0 && cfVar.f3694b.get() && ("camera".equals(jVar3.f2055c) || "nodes".equals(jVar3.f2055c))) {
                    boolean zEquals = "nodes".equals(jVar3.f2055c);
                    h6 h6Var = zEquals ? cfVar.O : cfVar.N;
                    long j7 = i5;
                    boolean z6 = zEquals ? cfVar.L : cfVar.J;
                    synchronized (h6Var) {
                        try {
                            if (h6Var.f4200a != j7) {
                                h6Var.f4200a = j7;
                                h6Var.f4201b = -1L;
                                h6Var.f4202c = null;
                                h6Var.f4203d = z6;
                            }
                            Long l3 = (Long) jVar3.f2056d;
                            i4 = 4;
                            if (l3 == null) {
                                j3 = jVar3.f2053a;
                                j4 = h6Var.f4201b;
                                if (j3 < j4) {
                                    if (j3 == j4) {
                                        z3 = jVar3.f2054b;
                                        z4 = h6Var.f4203d;
                                        if (z3 == z4) {
                                            if (z4 == z6) {
                                                i4 = 3;
                                            } else if (z4) {
                                                i4 = 1;
                                            } else {
                                                i4 = 2;
                                            }
                                        }
                                    } else {
                                        h6Var.f4201b = j3;
                                        z2 = jVar3.f2054b;
                                        h6Var.f4203d = z2;
                                        if (z2 == z6) {
                                            i4 = 3;
                                        } else if (z2) {
                                            i4 = 1;
                                        } else {
                                            i4 = 2;
                                        }
                                    }
                                }
                            } else if (h6Var.f4202c == null || l3.longValue() >= h6Var.f4202c.longValue()) {
                                if (h6Var.f4202c == null || ((Long) jVar3.f2056d).longValue() > h6Var.f4202c.longValue()) {
                                    h6Var.f4202c = (Long) jVar3.f2056d;
                                    h6Var.f4201b = -1L;
                                    h6Var.f4203d = z6;
                                }
                                j3 = jVar3.f2053a;
                                j4 = h6Var.f4201b;
                                if (j3 < j4) {
                                    if (j3 == j4) {
                                        z3 = jVar3.f2054b;
                                        z4 = h6Var.f4203d;
                                        if (z3 == z4) {
                                            if (z4 == z6) {
                                                i4 = 3;
                                            } else if (z4) {
                                                i4 = 1;
                                            } else {
                                                i4 = 2;
                                            }
                                        }
                                    } else {
                                        h6Var.f4201b = j3;
                                        z2 = jVar3.f2054b;
                                        h6Var.f4203d = z2;
                                        if (z2 == z6) {
                                            i4 = 3;
                                        } else if (z2) {
                                            i4 = 1;
                                        } else {
                                            i4 = 2;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (zEquals) {
                        int iA = g.d.a(i4);
                        if (iA == 0) {
                            cfVar.X(i5, a0Var, 3);
                        } else if (iA != 1) {
                            if (iA == 3) {
                                StringBuilder sb = new StringBuilder("stale nodes media:demand epoch=");
                                sb.append(jVar3.f2053a);
                                sb.append(" current=");
                                synchronized (h6Var) {
                                    j6 = h6Var.f4201b;
                                }
                                sb.append(j6);
                                Log.w("TunnelManager", sb.toString());
                            } else if (jVar3.f2054b) {
                                long j8 = jVar3.f2053a;
                                if (cf.N(i5, a0Var, cfVar.f3708i.get(), cfVar.f3727s0, cfVar.f3694b.get())) {
                                    cfVar.M = 3;
                                    cfVar.L = true;
                                    long j9 = cfVar.P.get();
                                    if (j9 <= 0) {
                                        cfVar.D0("nodes_demand_replay_repair");
                                    } else {
                                        ScreenMirrorService screenMirrorService = cfVar.f3731u0;
                                        if (screenMirrorService != null) {
                                            screenMirrorService.L4(cfVar.M, j9, true);
                                            screenMirrorService.M4("force_full", "demand-" + j8);
                                        }
                                    }
                                    StringBuilder sbI = a0.a.i(i5, "nodes Socket.IO media route reaffirmed generation=", " protocol=v");
                                    sbI.append(cfVar.M);
                                    sbI.append(" demandEpoch=");
                                    sbI.append(j8);
                                    Log.i("TunnelManager", sbI.toString());
                                } else {
                                    Log.w("TunnelManager", "nodes demand replay requested by stale control session");
                                }
                            }
                        } else if (cf.N(i5, a0Var, cfVar.f3708i.get(), cfVar.f3727s0, cfVar.f3694b.get())) {
                            cfVar.L = false;
                            cfVar.D0("nodes_demand_stopped");
                            cfVar.M = 2;
                            Log.i("TunnelManager", "nodes Socket.IO media route stopped generation=" + i5);
                        } else {
                            Log.w("TunnelManager", "nodes stop requested by stale control session");
                        }
                        z5 = true;
                    } else {
                        int iA2 = g.d.a(i4);
                        if (iA2 != 0) {
                            if (iA2 == 1) {
                                cfVar.m("media:demand");
                            } else if (iA2 != 3) {
                                Log.d("TunnelManager", "media:demand unchanged active=" + jVar3.f2054b + " epoch=" + jVar3.f2053a);
                            } else {
                                StringBuilder sb2 = new StringBuilder("stale media:demand epoch=");
                                sb2.append(jVar3.f2053a);
                                sb2.append(" current=");
                                h6 h6Var2 = cfVar.N;
                                synchronized (h6Var2) {
                                    j5 = h6Var2.f4201b;
                                }
                                sb2.append(j5);
                                Log.w("TunnelManager", sb2.toString());
                            }
                            z5 = true;
                        } else {
                            cfVar.J = true;
                            if (cfVar.f()) {
                                cfVar.d(cfVar.D);
                            } else {
                                Log.w("TunnelManager", "camera push waiting for Socket.IO media registration");
                            }
                            z5 = true;
                        }
                    }
                } else {
                    Log.w("TunnelManager", "stale media:demand ignored");
                }
                return Boolean.valueOf(z5);
            }
        });
        ((cf) this.f1415d).f3702f.execute(futureTask);
        try {
            return ((Boolean) futureTask.get(3L, TimeUnit.SECONDS)).booleanValue();
        } catch (InterruptedException e3) {
            futureTask.cancel(false);
            Thread.currentThread().interrupt();
            throw new IllegalStateException("media demand interrupted", e3);
        } catch (ExecutionException | TimeoutException e4) {
            futureTask.cancel(false);
            throw new IllegalStateException("media demand not applied", e4);
        }
    }

    public void h(k.c cVar) throws IOException {
        Cursor cursorE = cVar.E(new j.a("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"));
        try {
            boolean z2 = cursorE.moveToFirst() && cursorE.getInt(0) != 0;
            cursorE.close();
            if (z2) {
                Cursor cursorE2 = cVar.E(new j.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
                try {
                    String string = cursorE2.moveToFirst() ? cursorE2.getString(0) : null;
                    cursorE2.close();
                    if (!"5181942b9ebc31ce68dacb56c16fd79f".equals(string) && !"ae2044fb577e65ee8bb576ca48a2f06e".equals(string)) {
                        b2.a.f(string, "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: 5181942b9ebc31ce68dacb56c16fd79f, found: ");
                        return;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        y.f.c(cursorE2, th);
                        throw th2;
                    }
                }
            } else {
                b2.e eVarO = n1.o(cVar);
                if (!eVarO.f272b) {
                    throw new IllegalStateException("Pre-packaged database has an invalid schema: " + eVarO.f273c);
                }
                j(cVar);
            }
            n1 n1Var = (n1) this.f1415d;
            ((WorkDatabase_Impl) n1Var.f905c).f210a = cVar;
            cVar.f2373c.execSQL("PRAGMA foreign_keys = ON");
            f fVar = ((WorkDatabase_Impl) n1Var.f905c).f213d;
            fVar.getClass();
            synchronized (fVar.f1393k) {
                if (fVar.f1388f) {
                    Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                } else {
                    cVar.f2373c.execSQL("PRAGMA temp_store = MEMORY;");
                    cVar.f2373c.execSQL("PRAGMA recursive_triggers='ON';");
                    cVar.f2373c.execSQL("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                    fVar.c(cVar);
                    fVar.f1389g = cVar.y("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
                    fVar.f1388f = true;
                }
            }
            List list = ((WorkDatabase_Impl) n1Var.f905c).f215f;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((q.b) ((WorkDatabase_Impl) n1Var.f905c).f215f.get(i3)).getClass();
                    cVar.d();
                    try {
                        cVar.f2373c.execSQL("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < " + (System.currentTimeMillis() - 86400000) + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
                        cVar.F();
                        cVar.z();
                    } catch (Throwable th3) {
                        cVar.z();
                        throw th3;
                    }
                }
            }
            this.f1414c = null;
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                y.f.c(cursorE, th4);
                throw th5;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x008e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x008e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:? A[LOOP:3: B:11:0x002d->B:112:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x008b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x0070 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x0034  */
    /* JADX WARN: Code duplicated, block: B:18:0x0045 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0047  */
    /* JADX WARN: Code duplicated, block: B:20:0x004c  */
    /* JADX WARN: Code duplicated, block: B:24:0x005a  */
    public void i(k.c cVar, int i3, int i4) throws IOException {
        Set set;
        Iterable iterable;
        TreeMap treeMap;
        Set setKeySet;
        Iterator it;
        boolean z2;
        Integer num;
        int i5;
        int iIntValue;
        int iIntValue2;
        SQLiteDatabase sQLiteDatabase = cVar.f2373c;
        n1 n1Var = (n1) this.f1415d;
        d.b bVar = (d.b) this.f1414c;
        if (bVar != null) {
            n1 n1Var2 = (n1) bVar.f513h;
            n1Var2.getClass();
            if (i3 == i4) {
                iterable = q.f2104c;
            } else {
                boolean z3 = i4 > i3;
                ArrayList arrayList = new ArrayList();
                int iIntValue3 = i3;
                while (true) {
                    if (z3) {
                        if (iIntValue3 < i4) {
                            treeMap = (TreeMap) ((LinkedHashMap) n1Var2.f905c).get(Integer.valueOf(iIntValue3));
                            if (treeMap != null) {
                                if (z3) {
                                    setKeySet = treeMap.descendingKeySet();
                                } else {
                                    setKeySet = treeMap.keySet();
                                }
                                it = setKeySet.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        z2 = false;
                                        break;
                                    }
                                    num = (Integer) it.next();
                                    if (z3) {
                                        i5 = iIntValue3 + 1;
                                        num.getClass();
                                        iIntValue = num.intValue();
                                        if (i5 <= iIntValue && iIntValue <= i4) {
                                            Object obj = treeMap.get(num);
                                            obj.getClass();
                                            arrayList.add(obj);
                                            iIntValue3 = num.intValue();
                                            z2 = true;
                                            break;
                                        }
                                    } else {
                                        num.getClass();
                                        iIntValue2 = num.intValue();
                                        if (i4 <= iIntValue2 && iIntValue2 < iIntValue3) {
                                            Object obj2 = treeMap.get(num);
                                            obj2.getClass();
                                            arrayList.add(obj2);
                                            iIntValue3 = num.intValue();
                                            z2 = true;
                                            break;
                                            break;
                                        }
                                    }
                                }
                                if (!z2) {
                                }
                            }
                            iterable = null;
                        } else {
                            iterable = arrayList;
                        }
                    } else if (iIntValue3 > i4) {
                        treeMap = (TreeMap) ((LinkedHashMap) n1Var2.f905c).get(Integer.valueOf(iIntValue3));
                        if (treeMap != null) {
                            if (z3) {
                                setKeySet = treeMap.descendingKeySet();
                            } else {
                                setKeySet = treeMap.keySet();
                            }
                            it = setKeySet.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    z2 = false;
                                    break;
                                    break;
                                }
                                num = (Integer) it.next();
                                if (z3) {
                                    i5 = iIntValue3 + 1;
                                    num.getClass();
                                    iIntValue = num.intValue();
                                    if (i5 <= iIntValue) {
                                        continue;
                                    }
                                } else {
                                    num.getClass();
                                    iIntValue2 = num.intValue();
                                    if (i4 <= iIntValue2) {
                                        continue;
                                    }
                                }
                            }
                            if (!z2) {
                            }
                        }
                        iterable = null;
                    } else {
                        iterable = arrayList;
                    }
                }
            }
            if (iterable != null) {
                j1.c cVar2 = new j1.c(10);
                Cursor cursorE = cVar.E(new j.a("SELECT name FROM sqlite_master WHERE type = 'trigger'"));
                while (cursorE.moveToNext()) {
                    try {
                        cVar2.add(cursorE.getString(0));
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            y.f.c(cursorE, th);
                            throw th2;
                        }
                    }
                }
                cursorE.close();
                cVar2.f();
                cVar2.f2332e = true;
                if (cVar2.f2331d <= 0) {
                    cVar2 = j1.c.f2329f;
                }
                ListIterator listIterator = cVar2.listIterator(0);
                while (true) {
                    j1.a aVar = (j1.a) listIterator;
                    if (!aVar.hasNext()) {
                        break;
                    }
                    String str = (String) aVar.next();
                    str.getClass();
                    if (v1.l.z(str, "room_fts_content_sync_", false)) {
                        sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS ".concat(str));
                    }
                }
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((h.a) it2.next()).a(cVar);
                }
                b2.e eVarO = n1.o(cVar);
                if (eVarO.f272b) {
                    j(cVar);
                    return;
                }
                throw new IllegalStateException("Migration didn't properly handle: " + eVarO.f273c);
            }
        }
        d.b bVar2 = (d.b) this.f1414c;
        if (bVar2 != null) {
            if (!((i3 <= i4 || !bVar2.f510e) && bVar2.f509d && ((set = (Set) bVar2.f517l) == null || !set.contains(Integer.valueOf(i3))))) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Dependency`");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkTag`");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkName`");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Preference`");
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) n1Var.f905c;
                List list = workDatabase_Impl.f215f;
                if (list != null) {
                    int size = list.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        ((q.b) workDatabase_Impl.f215f.get(i6)).getClass();
                    }
                }
                n1.k(cVar);
                return;
            }
        }
        throw new IllegalStateException("A migration from " + i3 + " to " + i4 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    public void j(k.c cVar) {
        SQLiteDatabase sQLiteDatabase = cVar.f2373c;
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        sQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5181942b9ebc31ce68dacb56c16fd79f')");
    }

    public String toString() {
        switch (this.f1412a) {
            case 2:
                StringBuilder sb = new StringBuilder();
                if (((v) this.f1414c) == v.f2261d) {
                    sb.append("HTTP/1.0");
                } else {
                    sb.append("HTTP/1.1");
                }
                sb.append(' ');
                sb.append(this.f1413b);
                sb.append(' ');
                sb.append((String) this.f1415d);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public j(d.b bVar, n1 n1Var) {
        this.f1412a = 0;
        this.f1412a = 0;
        this.f1413b = 16;
        this.f1414c = bVar;
        this.f1415d = n1Var;
    }

    public j(o oVar) {
        this.f1412a = 3;
        this.f1415d = new LinkedHashMap();
        this.f1413b = 64;
        this.f1414c = oVar;
    }

    public /* synthetic */ j(Object obj, int i3, Serializable serializable, int i4) {
        this.f1412a = i4;
        this.f1414c = obj;
        this.f1413b = i3;
        this.f1415d = serializable;
    }

    public j() {
        this.f1412a = 5;
        this.f1414c = new Object();
        this.f1413b = 1;
    }

    public j(cf cfVar, int i3, AtomicReference atomicReference) {
        this.f1412a = 7;
        this.f1415d = cfVar;
        this.f1413b = i3;
        this.f1414c = atomicReference;
    }

    public j(float[] fArr, float[] fArr2, int i3) {
        this.f1412a = 6;
        this.f1414c = fArr;
        this.f1415d = fArr2;
        this.f1413b = i3;
    }

    public void d(k.c cVar) {
    }
}
