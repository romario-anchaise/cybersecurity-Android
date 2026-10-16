// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f3023m = p.m.f("Processor");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p.b f3026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y.r f3027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WorkDatabase f3028e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f3032i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap f3030g = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f3029f = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashSet f3033j = new HashSet();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f3034k = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f3024a = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f3035l = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f3031h = new HashMap();

    public h(Context context, p.b bVar, y.r rVar, WorkDatabase workDatabase, List list) {
        this.f3025b = context;
        this.f3026c = bVar;
        this.f3027d = rVar;
        this.f3028e = workDatabase;
        this.f3032i = list;
    }

    public static boolean c(String str, u uVar) {
        if (uVar == null) {
            p.m.d().a(f3023m, "WorkerWrapper could not be found for " + str);
            return false;
        }
        uVar.f3101s = true;
        uVar.h();
        uVar.f3100r.cancel(true);
        if (uVar.f3090g == null || !(uVar.f3100r.f32c instanceof a0.b)) {
            p.m.d().a(u.f3085t, "WorkSpec " + uVar.f3089f + " is already done. Not interrupting.");
        } else {
            uVar.f3090g.f();
        }
        p.m.d().a(f3023m, "WorkerWrapper interrupted for " + str);
        return true;
    }

    public final void a(d dVar) {
        synchronized (this.f3035l) {
            this.f3034k.add(dVar);
        }
    }

    @Override // q.d
    public final void b(y.j jVar, boolean z2) {
        synchronized (this.f3035l) {
            try {
                u uVar = (u) this.f3030g.get(jVar.f5987a);
                if (uVar != null && jVar.equals(m0.a.h(uVar.f3089f))) {
                    this.f3030g.remove(jVar.f5987a);
                }
                p.m.d().a(f3023m, h.class.getSimpleName() + " " + jVar.f5987a + " executed; reschedule = " + z2);
                ArrayList arrayList = this.f3034k;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((d) obj).b(jVar, z2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d(String str) {
        boolean z2;
        synchronized (this.f3035l) {
            try {
                z2 = this.f3030g.containsKey(str) || this.f3029f.containsKey(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public final void e(d dVar) {
        synchronized (this.f3035l) {
            this.f3034k.remove(dVar);
        }
    }

    public final void f(String str, p.f fVar) {
        synchronized (this.f3035l) {
            try {
                p.m.d().e(f3023m, "Moving WorkSpec (" + str + ") to the foreground");
                u uVar = (u) this.f3030g.remove(str);
                if (uVar != null) {
                    if (this.f3024a == null) {
                        PowerManager.WakeLock wakeLockA = z.n.a(this.f3025b, "ProcessorForegroundLck");
                        this.f3024a = wakeLockA;
                        wakeLockA.acquire();
                    }
                    this.f3029f.put(str, uVar);
                    e.a.a(this.f3025b, x.a.e(this.f3025b, m0.a.h(uVar.f3089f), fVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean g(l lVar, h0.g gVar) {
        y.j jVar = lVar.f3039a;
        final String str = jVar.f5987a;
        final ArrayList arrayList = new ArrayList();
        y.o oVar = (y.o) this.f3028e.n(new Callable() { // from class: q.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WorkDatabase workDatabase = this.f3016a.f3028e;
                y.r rVarU = workDatabase.u();
                String str2 = str;
                arrayList.addAll(rVarU.c(str2));
                return workDatabase.t().h(str2);
            }
        });
        if (oVar == null) {
            p.m.d().g(f3023m, "Didn't find WorkSpec for id " + jVar);
            ((b0.a) this.f3027d.f6034c).execute(new a2.h(this, jVar, 10));
            return false;
        }
        synchronized (this.f3035l) {
            try {
                if (d(str)) {
                    Set set = (Set) this.f3031h.get(str);
                    if (((l) set.iterator().next()).f3039a.f5988b == jVar.f5988b) {
                        set.add(lVar);
                        p.m.d().a(f3023m, "Work " + jVar + " is already enqueued for processing");
                    } else {
                        ((b0.a) this.f3027d.f6034c).execute(new a2.h(this, jVar, 10));
                    }
                    return false;
                }
                if (oVar.f6017t != jVar.f5988b) {
                    ((b0.a) this.f3027d.f6034c).execute(new a2.h(this, jVar, 10));
                    return false;
                }
                t tVar = new t(this.f3025b, this.f3026c, this.f3027d, this, this.f3028e, oVar, arrayList);
                tVar.f3083g = this.f3032i;
                u uVar = new u(tVar);
                a0.l lVar2 = uVar.f3099q;
                lVar2.b(new g(this, lVar.f3039a, lVar2, 0), (b0.a) this.f3027d.f6034c);
                this.f3030g.put(str, uVar);
                HashSet hashSet = new HashSet();
                hashSet.add(lVar);
                this.f3031h.put(str, hashSet);
                ((z.l) this.f3027d.f6032a).execute(uVar);
                p.m.d().a(f3023m, h.class.getSimpleName() + ": processing " + jVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        synchronized (this.f3035l) {
            try {
                if (this.f3029f.isEmpty()) {
                    Context context = this.f3025b;
                    String str = x.a.f5818j;
                    Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
                    intent.setAction("ACTION_STOP_FOREGROUND");
                    try {
                        this.f3025b.startService(intent);
                    } catch (Throwable th) {
                        p.m.d().c(f3023m, "Unable to stop foreground service", th);
                    }
                    PowerManager.WakeLock wakeLock = this.f3024a;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.f3024a = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
