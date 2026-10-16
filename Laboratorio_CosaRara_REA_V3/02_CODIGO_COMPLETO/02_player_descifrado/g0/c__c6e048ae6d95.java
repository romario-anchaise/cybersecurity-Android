// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import h0.a0;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Handler.Callback {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Status f1434o = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Status f1435p = new Status(4, "The user must be signed in to make this API call.", null, null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f1436q = new Object();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static c f1437r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0.i f1440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j0.c f1441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f1442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e0.e f1443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y.e f1444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f1445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f1446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f1447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c.c f1448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c.c f1449l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p0.e f1450m;
    public volatile boolean n;

    public c(Context context, Looper looper) {
        e0.e eVar = e0.e.f671d;
        this.f1438a = 10000L;
        this.f1439b = false;
        this.f1445h = new AtomicInteger(1);
        this.f1446i = new AtomicInteger(0);
        this.f1447j = new ConcurrentHashMap(5, 0.75f, 1);
        this.f1448k = new c.c();
        this.f1449l = new c.c();
        this.n = true;
        this.f1442e = context;
        p0.e eVar2 = new p0.e(looper, this);
        Looper.getMainLooper();
        this.f1450m = eVar2;
        this.f1443f = eVar;
        this.f1444g = new y.e(6);
        PackageManager packageManager = context.getPackageManager();
        if (q2.k.f3151d == null) {
            q2.k.f3151d = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (q2.k.f3151d.booleanValue()) {
            this.n = false;
        }
        eVar2.sendMessage(eVar2.obtainMessage(6));
    }

    public static Status b(a aVar, e0.b bVar) {
        return new Status(17, "API: " + ((String) aVar.f1426b.f5992d) + " is not available on this device. Connection failed with: " + String.valueOf(bVar), bVar.f660e, bVar);
    }

    public static c d(Context context) {
        c cVar;
        HandlerThread handlerThread;
        synchronized (f1436q) {
            if (f1437r == null) {
                synchronized (a0.f1856g) {
                    try {
                        handlerThread = a0.f1858i;
                        if (handlerThread == null) {
                            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                            a0.f1858i = handlerThread2;
                            handlerThread2.start();
                            handlerThread = a0.f1858i;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = e0.e.f670c;
                f1437r = new c(applicationContext, looper);
            }
            cVar = f1437r;
        }
        return cVar;
    }

    public final boolean a(e0.b bVar, int i3) {
        boolean zBooleanValue;
        Boolean bool;
        e0.e eVar = this.f1443f;
        Context context = this.f1442e;
        eVar.getClass();
        synchronized (m0.a.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = m0.a.f2678a;
            if (context2 == null || (bool = m0.a.f2679b) == null || context2 != applicationContext) {
                m0.a.f2679b = null;
                boolean zIsInstantApp = applicationContext.getPackageManager().isInstantApp();
                m0.a.f2679b = Boolean.valueOf(zIsInstantApp);
                m0.a.f2678a = applicationContext;
                zBooleanValue = zIsInstantApp;
            } else {
                zBooleanValue = bool.booleanValue();
            }
        }
        if (!zBooleanValue) {
            int i4 = bVar.f659d;
            PendingIntent pendingIntentB = i4 != 0 && bVar.f660e != null ? bVar.f660e : eVar.b(i4, context, null);
            if (pendingIntentB != null) {
                int i5 = bVar.f659d;
                int i6 = GoogleApiActivity.f468b;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", pendingIntentB);
                intent.putExtra("failing_client_id", i3);
                intent.putExtra("notify_manager", true);
                eVar.g(context, i5, PendingIntent.getActivity(context, 0, intent, p0.d.f2873a | 134217728));
                return true;
            }
        }
        return false;
    }

    public final h c(j0.c cVar) {
        a aVar = cVar.f2314e;
        ConcurrentHashMap concurrentHashMap = this.f1447j;
        h hVar = (h) concurrentHashMap.get(aVar);
        if (hVar == null) {
            hVar = new h(this, cVar);
            concurrentHashMap.put(aVar, hVar);
        }
        if (hVar.f1457b.l()) {
            this.f1449l.add(aVar);
        }
        hVar.m();
        return hVar;
    }

    public final void e(e0.b bVar, int i3) {
        if (a(bVar, i3)) {
            return;
        }
        p0.e eVar = this.f1450m;
        eVar.sendMessage(eVar.obtainMessage(5, i3, 0, bVar));
    }

    /* JADX WARN: Code duplicated, block: B:210:0x0395  */
    /* JADX WARN: Code duplicated, block: B:212:0x039b  */
    /* JADX WARN: Code duplicated, block: B:214:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:216:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:80:0x011f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0123  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v6 g0.h, still in use, count: 2, list:
          (r2v6 g0.h) from 0x038d: IGET (r2v6 g0.h) A[WRAPPED] (LINE:910) g0.h.g int
          (r2v6 g0.h) from 0x0393: PHI (r2 I:??) = (r2v3 g0.h), (r2v6 g0.h) binds: [B:208:0x0392, B:270:0x0393] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message r11) {
        /*
            Method dump skipped, instruction units count: 1200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.c.handleMessage(android.os.Message):boolean");
    }
}
