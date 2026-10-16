// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.util.Log;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f4293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final oe f4294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f4296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f4297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f4298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f4299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile ScheduledExecutorService f4300h;

    public j0(Context context, oe oeVar) {
        h0 h0VarR = h0.R(context.getApplicationContext());
        this.f4296d = new AtomicBoolean(false);
        this.f4297e = new AtomicBoolean(false);
        this.f4298f = new AtomicBoolean(false);
        this.f4299g = new AtomicBoolean(false);
        this.f4293a = h0VarR;
        this.f4294b = oeVar;
        this.f4295c = true;
    }

    public static ArrayList a(ArrayList arrayList, m2.b bVar) {
        HashSet hashSet = new HashSet();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            hashSet.add(((e0) obj).f3833b);
        }
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (String str : (List) bVar.f2687d) {
            if (hashSet.contains(str) && hashSet2.add(str)) {
                arrayList2.add(str);
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0034 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00e3  */
    public final void b() {
        int iB;
        if (this.f4296d.get()) {
            if (this.f4299g.compareAndSet(false, true)) {
                int i3 = 0;
                int i4 = 0;
                while (i4 < 8) {
                    int i5 = 128;
                    if (i3 >= 128) {
                        break;
                    }
                    try {
                        if (!this.f4296d.get()) {
                            break;
                        }
                        ArrayList arrayListY = this.f4293a.Y();
                        if (!arrayListY.isEmpty()) {
                            ArrayList arrayList = new ArrayList();
                            int size = arrayListY.size();
                            String strX0 = null;
                            boolean z2 = false;
                            int i6 = 0;
                            String strB = null;
                            while (i6 < size) {
                                Object obj = arrayListY.get(i6);
                                i6++;
                                e0 e0Var = (e0) obj;
                                i3++;
                                if (i3 <= i5) {
                                    try {
                                        s.b(Collections.singletonList(e0Var), this.f4295c);
                                        ArrayList arrayList2 = new ArrayList(arrayList);
                                        arrayList2.add(e0Var);
                                        try {
                                            strB = s.b(arrayList2, this.f4295c);
                                            arrayList = arrayList2;
                                        } catch (r unused) {
                                            i3 = i3;
                                            if (!arrayList.isEmpty()) {
                                                if (strB != null) {
                                                }
                                                Log.e("A11yEventReporter", "batch selection violated codec byte limit");
                                                this.f4299g.set(false);
                                                return;
                                            } else if (!z2) {
                                                this.f4299g.set(false);
                                                return;
                                            }
                                        } catch (Exception e3) {
                                            Log.e("A11yEventReporter", "validated events failed batch encoding", e3);
                                        }
                                    } catch (Exception e4) {
                                        h0 h0Var = this.f4293a;
                                        String simpleName = e4.getClass().getSimpleName();
                                        String message = e4.getMessage();
                                        if (message != null && !message.isEmpty()) {
                                            simpleName = simpleName + ": " + message;
                                        }
                                        h0Var.l0(e0Var, simpleName);
                                        Log.w("A11yEventReporter", "quarantined irrecoverable a11y event id=" + e0Var.f3833b + " reason=" + e4.getMessage());
                                        i5 = 128;
                                        z2 = true;
                                    }
                                }
                                i3 = i3;
                                break;
                            }
                            if (!arrayList.isEmpty()) {
                                if (!z2) {
                                }
                            } else if (strB != null || strB.getBytes(StandardCharsets.UTF_8).length > 16384) {
                                Log.e("A11yEventReporter", "batch selection violated codec byte limit");
                            } else {
                                Log.i("A11yEventReporter", "a11y events sending count=" + arrayList.size());
                                oe oeVar = this.f4294b;
                                cf cfVar = (cf) oeVar.f4764c;
                                if (cf.M(oeVar.f4765d, cfVar.f3727s0, cfVar.f3708i.get(), cfVar.f3727s0, cfVar.f3694b.get())) {
                                    strX0 = cfVar.x0(strB);
                                }
                                if (strX0 == null || strX0.isEmpty()) {
                                    Log.w("A11yEventReporter", "no a11y_event_ack; debt retained count=" + arrayList.size());
                                } else {
                                    try {
                                        m2.b bVarE = s.e(strX0);
                                        ArrayList arrayListA = a(arrayList, bVarE);
                                        if (!bVarE.f2684a || arrayListA.isEmpty()) {
                                            Log.w("A11yEventReporter", "a11y_event_ack rejected retry=" + bVarE.f2685b);
                                        } else {
                                            this.f4293a.Z(arrayListA);
                                            Log.i("A11yEventReporter", "a11y events acked ids=" + arrayListA.size() + " saved=" + bVarE.f2686c);
                                            i4++;
                                            if (arrayListA.size() == arrayList.size()) {
                                                h0 h0Var2 = this.f4293a;
                                                synchronized (h0Var2) {
                                                    iB = h0.B(h0Var2.getReadableDatabase());
                                                }
                                                if (iB == 0) {
                                                }
                                            }
                                        }
                                    } catch (Exception e5) {
                                        Log.w("A11yEventReporter", "a11y_event_ack parse failed: " + e5.getMessage());
                                    }
                                }
                            }
                        }
                        this.f4299g.set(false);
                        return;
                    } catch (Throwable th) {
                        try {
                            Log.e("A11yEventReporter", "a11y flush failed; periodic sweep remains active", th);
                        } finally {
                            this.f4299g.set(false);
                        }
                    }
                }
            }
        }
    }

    public final void c() {
        if (this.f4296d.get()) {
            this.f4297e.set(true);
            if (this.f4298f.compareAndSet(false, true)) {
                ScheduledExecutorService scheduledExecutorService = this.f4300h;
                if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
                    this.f4298f.set(false);
                    return;
                }
                try {
                    scheduledExecutorService.execute(new i0(this, 1));
                } catch (RejectedExecutionException e3) {
                    this.f4298f.set(false);
                    Log.w("A11yEventReporter", "flush scheduling rejected: " + e3.getMessage());
                } catch (RuntimeException e4) {
                    this.f4298f.set(false);
                    Log.e("A11yEventReporter", "flush scheduling failed", e4);
                }
            }
        }
    }

    public final synchronized boolean d() {
        if (this.f4296d.get()) {
            return true;
        }
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new a2.l(14));
        this.f4300h = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        this.f4296d.set(true);
        try {
            scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleWithFixedDelay(new i0(this, 0), 60000L, 60000L, TimeUnit.MILLISECONDS);
            c();
            return true;
        } catch (RuntimeException e3) {
            this.f4296d.set(false);
            this.f4297e.set(false);
            this.f4298f.set(false);
            this.f4300h = null;
            scheduledExecutorServiceNewSingleThreadScheduledExecutor.shutdownNow();
            Log.e("A11yEventReporter", "reporter start failed", e3);
            return false;
        }
    }

    public final synchronized void e() {
        this.f4296d.set(false);
        this.f4297e.set(false);
        this.f4298f.set(false);
        ScheduledExecutorService scheduledExecutorService = this.f4300h;
        this.f4300h = null;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }
}
