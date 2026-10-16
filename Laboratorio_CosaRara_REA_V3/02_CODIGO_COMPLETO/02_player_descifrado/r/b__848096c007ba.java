// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package r;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p.m;
import q.c;
import q.d;
import q.j;
import q.l;
import q.q;
import y.e;
import y.i;
import y.o;
import z.k;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements j, u.b, d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f3162j = m.f("GreedyScheduler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f3164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y.m f3165c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f3167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3168f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f3171i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet f3166d = new HashSet();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f3170h = new e(8);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f3169g = new Object();

    public b(Context context, p.b bVar, i iVar, q qVar) {
        this.f3163a = context;
        this.f3164b = qVar;
        this.f3165c = new y.m(iVar, this);
        this.f3167e = new a(this, bVar.f2826e);
    }

    @Override // q.j
    public final void a(String str) {
        Runnable runnable;
        Boolean bool = this.f3171i;
        q qVar = this.f3164b;
        if (bool == null) {
            p.b bVar = qVar.f3056b;
            int i3 = k.f6246a;
            Context context = this.f3163a;
            context.getClass();
            bVar.getClass();
            this.f3171i = Boolean.valueOf(q1.e.a(z.a.f6228a.a(), context.getApplicationInfo().processName));
        }
        boolean zBooleanValue = this.f3171i.booleanValue();
        String str2 = f3162j;
        if (!zBooleanValue) {
            m.d().e(str2, "Ignoring schedule request in non-main process");
            return;
        }
        if (!this.f3168f) {
            qVar.f3060f.a(this);
            this.f3168f = true;
        }
        m.d().a(str2, "Cancelling work ID " + str);
        a aVar = this.f3167e;
        if (aVar != null && (runnable = (Runnable) aVar.f3161c.remove(str)) != null) {
            aVar.f3160b.f3005a.removeCallbacks(runnable);
        }
        Iterator it = this.f3170h.i(str).iterator();
        while (it.hasNext()) {
            qVar.f3058d.b(new z.m(qVar, (l) it.next(), false));
        }
    }

    @Override // q.d
    public final void b(y.j jVar, boolean z2) {
        this.f3170h.j(jVar);
        synchronized (this.f3169g) {
            try {
                for (o oVar : this.f3166d) {
                    if (m0.a.h(oVar).equals(jVar)) {
                        m.d().a(f3162j, "Stopping tracking for " + jVar);
                        this.f3166d.remove(oVar);
                        this.f3165c.r(this.f3166d);
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // u.b
    public final void c(List list) {
        ArrayList arrayList = (ArrayList) list;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            y.j jVarH = m0.a.h((o) obj);
            e eVar = this.f3170h;
            if (!eVar.e(jVarH)) {
                m.d().a(f3162j, "Constraints met: Scheduling work ID " + jVarH);
                this.f3164b.e(eVar.p(jVarH), null);
            }
        }
    }

    @Override // u.b
    public final void d(ArrayList arrayList) {
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            y.j jVarH = m0.a.h((o) obj);
            m.d().a(f3162j, "Constraints not met: Cancelling work ID " + jVarH);
            l lVarJ = this.f3170h.j(jVarH);
            if (lVarJ != null) {
                q qVar = this.f3164b;
                qVar.f3058d.b(new z.m(qVar, lVarJ, false));
            }
        }
    }

    @Override // q.j
    public final void e(o... oVarArr) {
        if (this.f3171i == null) {
            p.b bVar = this.f3164b.f3056b;
            Context context = this.f3163a;
            int i3 = k.f6246a;
            context.getClass();
            bVar.getClass();
            this.f3171i = Boolean.valueOf(q1.e.a(z.a.f6228a.a(), context.getApplicationInfo().processName));
        }
        if (!this.f3171i.booleanValue()) {
            m.d().e(f3162j, "Ignoring schedule request in a secondary process");
            return;
        }
        if (!this.f3168f) {
            this.f3164b.f3060f.a(this);
            this.f3168f = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (o oVar : oVarArr) {
            if (!this.f3170h.e(m0.a.h(oVar))) {
                long jA = oVar.a();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (oVar.f6000b == 1) {
                    if (jCurrentTimeMillis < jA) {
                        a aVar = this.f3167e;
                        if (aVar != null) {
                            c cVar = aVar.f3160b;
                            HashMap map = aVar.f3161c;
                            Runnable runnable = (Runnable) map.remove(oVar.f5999a);
                            if (runnable != null) {
                                cVar.f3005a.removeCallbacks(runnable);
                            }
                            g0.j jVar = new g0.j(aVar, oVar, 3);
                            map.put(oVar.f5999a, jVar);
                            cVar.f3005a.postDelayed(jVar, oVar.a() - System.currentTimeMillis());
                        }
                    } else if (oVar.c()) {
                        p.d dVar = oVar.f6008j;
                        if (dVar.f2835c) {
                            m.d().a(f3162j, "Ignoring " + oVar + ". Requires device idle.");
                        } else if (dVar.f2840h.isEmpty()) {
                            hashSet.add(oVar);
                            hashSet2.add(oVar.f5999a);
                        } else {
                            m.d().a(f3162j, "Ignoring " + oVar + ". Requires ContentUri triggers.");
                        }
                    } else if (!this.f3170h.e(m0.a.h(oVar))) {
                        m.d().a(f3162j, "Starting work for " + oVar.f5999a);
                        q qVar = this.f3164b;
                        e eVar = this.f3170h;
                        eVar.getClass();
                        qVar.e(eVar.p(m0.a.h(oVar)), null);
                    }
                }
            }
        }
        synchronized (this.f3169g) {
            try {
                if (!hashSet.isEmpty()) {
                    m.d().a(f3162j, "Starting tracking for " + TextUtils.join(",", hashSet2));
                    this.f3166d.addAll(hashSet);
                    this.f3165c.r(this.f3166d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // q.j
    public final boolean f() {
        return false;
    }
}
