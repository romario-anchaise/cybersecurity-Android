// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q;

import android.content.Context;
import android.database.Cursor;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import p.v;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f3085t = p.m.f("WorkerWrapper");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f3086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f3088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y.o f3089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p.l f3090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y.r f3091h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p.b f3093j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f3094k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final WorkDatabase f3095l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final y.p f3096m;
    public final y.c n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f3097o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f3098p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f3101s;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p.k f3092i = new p.h();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a0.l f3099q = new a0.l();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final a0.l f3100r = new a0.l();

    public u(t tVar) {
        this.f3086c = (Context) tVar.f3077a;
        this.f3091h = (y.r) tVar.f3079c;
        this.f3094k = (h) tVar.f3078b;
        y.o oVar = (y.o) tVar.f3082f;
        this.f3089f = oVar;
        this.f3087d = oVar.f5999a;
        this.f3088e = (List) tVar.f3083g;
        this.f3090g = null;
        this.f3093j = (p.b) tVar.f3080d;
        WorkDatabase workDatabase = (WorkDatabase) tVar.f3081e;
        this.f3095l = workDatabase;
        this.f3096m = workDatabase.t();
        this.n = workDatabase.f();
        this.f3097o = (ArrayList) tVar.f3084h;
    }

    public final void a(p.k kVar) {
        boolean z2 = kVar instanceof p.j;
        y.o oVar = this.f3089f;
        String str = f3085t;
        if (!z2) {
            if (kVar instanceof p.i) {
                p.m.d().e(str, "Worker result RETRY for " + this.f3098p);
                c();
                return;
            }
            p.m.d().e(str, "Worker result FAILURE for " + this.f3098p);
            if (oVar.d()) {
                d();
                return;
            } else {
                g();
                return;
            }
        }
        p.m.d().e(str, "Worker result SUCCESS for " + this.f3098p);
        if (oVar.d()) {
            d();
            return;
        }
        y.c cVar = this.n;
        String str2 = this.f3087d;
        y.p pVar = this.f3096m;
        WorkDatabase workDatabase = this.f3095l;
        workDatabase.c();
        try {
            pVar.m(str2, 3);
            pVar.l(str2, ((p.j) this.f3092i).f2849a);
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayListH = cVar.h(str2);
            int size = arrayListH.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayListH.get(i3);
                i3++;
                String str3 = (String) obj;
                if (pVar.f(str3) == 5) {
                    WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) cVar.f5972d;
                    g.k kVarY = g.k.y("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
                    if (str3 == null) {
                        kVarY.l(1);
                    } else {
                        kVarY.m(str3, 1);
                    }
                    workDatabase_Impl.b();
                    Cursor cursorM = workDatabase_Impl.m(kVarY);
                    try {
                        boolean z3 = cursorM.moveToFirst() && cursorM.getInt(0) != 0;
                        cursorM.close();
                        kVarY.z();
                        if (z3) {
                            p.m.d().e(str, "Setting status to enqueued for " + str3);
                            pVar.m(str3, 1);
                            pVar.k(str3, jCurrentTimeMillis);
                        }
                    } catch (Throwable th) {
                        cursorM.close();
                        kVarY.z();
                        throw th;
                    }
                }
            }
            workDatabase.o();
            workDatabase.k();
            e(false);
        } catch (Throwable th2) {
            workDatabase.k();
            e(false);
            throw th2;
        }
    }

    public final void b() {
        boolean zH = h();
        String str = this.f3087d;
        WorkDatabase workDatabase = this.f3095l;
        if (!zH) {
            workDatabase.c();
            try {
                int iF = this.f3096m.f(str);
                workDatabase.s().g(str);
                if (iF == 0) {
                    e(false);
                } else if (iF == 2) {
                    a(this.f3092i);
                } else if (!a0.a.b(iF)) {
                    c();
                }
                workDatabase.o();
                workDatabase.k();
            } catch (Throwable th) {
                workDatabase.k();
                throw th;
            }
        }
        List list = this.f3088e;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a(str);
            }
            k.a(this.f3093j, workDatabase, list);
        }
    }

    public final void c() {
        String str = this.f3087d;
        y.p pVar = this.f3096m;
        WorkDatabase workDatabase = this.f3095l;
        workDatabase.c();
        try {
            pVar.m(str, 1);
            pVar.k(str, System.currentTimeMillis());
            pVar.j(str, -1L);
            workDatabase.o();
        } finally {
            workDatabase.k();
            e(true);
        }
    }

    public final void d() {
        String str = this.f3087d;
        y.p pVar = this.f3096m;
        WorkDatabase workDatabase = this.f3095l;
        workDatabase.c();
        try {
            pVar.k(str, System.currentTimeMillis());
            WorkDatabase_Impl workDatabase_Impl = pVar.f6018a;
            pVar.m(str, 1);
            workDatabase_Impl.b();
            y.h hVar = pVar.f6027j;
            k.i iVarA = hVar.a();
            if (str == null) {
                iVarA.l(1);
            } else {
                iVarA.m(str, 1);
            }
            workDatabase_Impl.c();
            try {
                iVarA.d();
                workDatabase_Impl.o();
                workDatabase_Impl.k();
                hVar.m(iVarA);
                workDatabase_Impl.b();
                y.h hVar2 = pVar.f6023f;
                k.i iVarA2 = hVar2.a();
                if (str == null) {
                    iVarA2.l(1);
                } else {
                    iVarA2.m(str, 1);
                }
                workDatabase_Impl.c();
                try {
                    iVarA2.d();
                    workDatabase_Impl.o();
                    workDatabase_Impl.k();
                    hVar2.m(iVarA2);
                    pVar.j(str, -1L);
                    workDatabase.o();
                    workDatabase.k();
                    e(false);
                } catch (Throwable th) {
                    workDatabase_Impl.k();
                    hVar2.m(iVarA2);
                    throw th;
                }
            } catch (Throwable th2) {
                workDatabase_Impl.k();
                hVar.m(iVarA);
                throw th2;
            }
        } catch (Throwable th3) {
            workDatabase.k();
            e(false);
            throw th3;
        }
    }

    public final void e(boolean z2) {
        boolean zContainsKey;
        this.f3095l.c();
        try {
            y.p pVarT = this.f3095l.t();
            pVarT.getClass();
            g.k kVarY = g.k.y("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
            WorkDatabase_Impl workDatabase_Impl = pVarT.f6018a;
            workDatabase_Impl.b();
            Cursor cursorM = workDatabase_Impl.m(kVarY);
            try {
                boolean z3 = cursorM.moveToFirst() && cursorM.getInt(0) != 0;
                cursorM.close();
                kVarY.z();
                if (!z3) {
                    z.j.a(this.f3086c, RescheduleReceiver.class, false);
                }
                if (z2) {
                    this.f3096m.m(this.f3087d, 1);
                    this.f3096m.j(this.f3087d, -1L);
                }
                if (this.f3089f != null && this.f3090g != null) {
                    h hVar = this.f3094k;
                    String str = this.f3087d;
                    synchronized (hVar.f3035l) {
                        zContainsKey = hVar.f3029f.containsKey(str);
                    }
                    if (zContainsKey) {
                        h hVar2 = this.f3094k;
                        String str2 = this.f3087d;
                        synchronized (hVar2.f3035l) {
                            hVar2.f3029f.remove(str2);
                            hVar2.h();
                        }
                    }
                }
                this.f3095l.o();
                this.f3095l.k();
                this.f3099q.i(Boolean.valueOf(z2));
            } catch (Throwable th) {
                cursorM.close();
                kVarY.z();
                throw th;
            }
        } catch (Throwable th2) {
            this.f3095l.k();
            throw th2;
        }
    }

    public final void f() {
        y.p pVar = this.f3096m;
        String str = this.f3087d;
        int iF = pVar.f(str);
        String str2 = f3085t;
        if (iF == 2) {
            p.m.d().a(str2, "Status for " + str + " is RUNNING; not doing any work and rescheduling for later execution");
            e(true);
            return;
        }
        p.m mVarD = p.m.d();
        StringBuilder sbK = a0.a.k("Status for ", str, " is ");
        sbK.append(a0.a.B(iF));
        sbK.append(" ; not doing any work");
        mVarD.a(str2, sbK.toString());
        e(false);
    }

    public final void g() {
        String str = this.f3087d;
        WorkDatabase workDatabase = this.f3095l;
        workDatabase.c();
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            while (true) {
                boolean zIsEmpty = linkedList.isEmpty();
                y.p pVar = this.f3096m;
                if (zIsEmpty) {
                    pVar.l(str, ((p.h) this.f3092i).f2848a);
                    workDatabase.o();
                    return;
                } else {
                    String str2 = (String) linkedList.remove();
                    if (pVar.f(str2) != 6) {
                        pVar.m(str2, 4);
                    }
                    linkedList.addAll(this.n.h(str2));
                }
            }
        } finally {
            workDatabase.k();
            e(false);
        }
    }

    public final boolean h() {
        if (!this.f3101s) {
            return false;
        }
        p.m.d().a(f3085t, "Work interrupted for " + this.f3098p);
        int iF = this.f3096m.f(this.f3087d);
        if (iF == 0) {
            e(false);
            return true;
        }
        e(!a0.a.b(iF));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0091 A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:13:0x004f, B:16:0x0059, B:21:0x007e, B:23:0x0084, B:25:0x0088, B:35:0x00bf, B:30:0x0091, B:32:0x009d), top: B:109:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:32:0x009d A[Catch: all -> 0x007b, TRY_LEAVE, TryCatch #3 {all -> 0x007b, blocks: (B:13:0x004f, B:16:0x0059, B:21:0x007e, B:23:0x0084, B:25:0x0088, B:35:0x00bf, B:30:0x0091, B:32:0x009d), top: B:109:0x004f }] */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x009d, please report this as an issue */
    @Override // java.lang.Runnable
    public final void run() {
        p.g gVar;
        boolean z2;
        boolean z3;
        StringBuilder sb = new StringBuilder("Work [ id=");
        String str = this.f3087d;
        sb.append(str);
        sb.append(", tags={ ");
        ArrayList arrayList = this.f3097o;
        int size = arrayList.size();
        boolean z4 = true;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            String str2 = (String) obj;
            if (z4) {
                z4 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str2);
        }
        sb.append(" } ]");
        this.f3098p = sb.toString();
        y.o oVar = this.f3089f;
        if (h()) {
            return;
        }
        WorkDatabase workDatabase = this.f3095l;
        workDatabase.c();
        try {
            int i4 = oVar.f6000b;
            p.e eVarA = oVar.f6003e;
            String str3 = oVar.f6001c;
            String str4 = f3085t;
            if (i4 != 1) {
                f();
                workDatabase.o();
                p.m.d().a(str4, str3 + " is not in ENQUEUED state. Nothing more to do");
                workDatabase.k();
                return;
            }
            if (!oVar.d()) {
                if (oVar.f6000b == 1 && oVar.f6009k > 0) {
                    if (System.currentTimeMillis() < oVar.a()) {
                        p.m.d().a(str4, "Delaying execution for " + str3 + " because it is being executed before schedule.");
                        e(true);
                        workDatabase.o();
                        workDatabase.k();
                        return;
                    }
                }
            } else if (System.currentTimeMillis() < oVar.a()) {
                p.m.d().a(str4, "Delaying execution for " + str3 + " because it is being executed before schedule.");
                e(true);
                workDatabase.o();
                workDatabase.k();
                return;
            }
            workDatabase.o();
            workDatabase.k();
            boolean zD = oVar.d();
            y.p pVar = this.f3096m;
            p.b bVar = this.f3093j;
            if (zD) {
                z2 = false;
            } else {
                e0.i iVar = bVar.f2825d;
                String str5 = oVar.f6002d;
                iVar.getClass();
                String str6 = p.g.f2847a;
                try {
                    gVar = (p.g) Class.forName(str5).getDeclaredConstructor(null).newInstance(null);
                } catch (Exception e3) {
                    p.m.d().c(p.g.f2847a, "Trouble instantiating + " + str5, e3);
                    gVar = null;
                }
                if (gVar == null) {
                    p.m.d().b(str4, "Could not create Input Merger " + oVar.f6002d);
                    g();
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(eVarA);
                WorkDatabase_Impl workDatabase_Impl = pVar.f6018a;
                g.k kVarY = g.k.y("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
                if (str == null) {
                    kVarY.l(1);
                } else {
                    kVarY.m(str, 1);
                }
                workDatabase_Impl.b();
                Cursor cursorM = workDatabase_Impl.m(kVarY);
                try {
                    ArrayList arrayList3 = new ArrayList(cursorM.getCount());
                    while (cursorM.moveToNext()) {
                        arrayList3.add(p.e.a(cursorM.isNull(0) ? null : cursorM.getBlob(0)));
                    }
                    z2 = false;
                    cursorM.close();
                    kVarY.z();
                    arrayList2.addAll(arrayList3);
                    eVarA = gVar.a(arrayList2);
                } catch (Throwable th) {
                    cursorM.close();
                    kVarY.z();
                    throw th;
                }
            }
            UUID uuidFromString = UUID.fromString(str);
            ExecutorService executorService = bVar.f2822a;
            v vVar = bVar.f2824c;
            h hVar = this.f3094k;
            y.r rVar = this.f3091h;
            z.r rVar2 = new z.r(workDatabase, hVar, rVar);
            WorkerParameters workerParameters = new WorkerParameters();
            workerParameters.f206a = uuidFromString;
            workerParameters.f207b = eVarA;
            new HashSet(arrayList);
            workerParameters.f208c = executorService;
            workerParameters.f209d = vVar;
            if (this.f3090g == null) {
                vVar.getClass();
                this.f3090g = v.a(this.f3086c, str3, workerParameters);
            }
            p.l lVar = this.f3090g;
            if (lVar == null) {
                p.m.d().b(str4, "Could not create Worker " + str3);
                g();
                return;
            }
            if (lVar.f2853d) {
                p.m.d().b(str4, "Received an already-used Worker " + str3 + "; Worker Factory should return new instances");
                g();
                return;
            }
            lVar.f2853d = true;
            workDatabase.c();
            try {
                if (pVar.f(str) == 1) {
                    pVar.m(str, 2);
                    WorkDatabase_Impl workDatabase_Impl2 = pVar.f6018a;
                    workDatabase_Impl2.b();
                    y.h hVar2 = pVar.f6026i;
                    k.i iVarA = hVar2.a();
                    if (str == null) {
                        iVarA.l(1);
                    } else {
                        iVarA.m(str, 1);
                    }
                    workDatabase_Impl2.c();
                    try {
                        iVarA.d();
                        workDatabase_Impl2.o();
                        workDatabase_Impl2.k();
                        hVar2.m(iVarA);
                        z3 = true;
                    } catch (Throwable th2) {
                        workDatabase_Impl2.k();
                        hVar2.m(iVarA);
                        throw th2;
                    }
                } else {
                    z3 = z2;
                }
                workDatabase.o();
                workDatabase.k();
                if (!z3) {
                    f();
                    return;
                }
                if (h()) {
                    return;
                }
                z.p pVar2 = new z.p(this.f3086c, this.f3089f, this.f3090g, rVar2, this.f3091h);
                ((b0.a) rVar.f6034c).execute(pVar2);
                a0.l lVar2 = pVar2.f6259c;
                a2.h hVar3 = new a2.h(this, lVar2, 11);
                a.a aVar = new a.a(1);
                a0.l lVar3 = this.f3100r;
                lVar3.b(hVar3, aVar);
                lVar2.b(new g0.j(this, lVar2, 1), (b0.a) rVar.f6034c);
                lVar3.b(new g0.j(this, this.f3098p, 2), (z.l) rVar.f6032a);
            } catch (Throwable th3) {
                workDatabase.k();
                throw th3;
            }
        } catch (Throwable th4) {
            workDatabase.k();
            throw th4;
        }
    }
}
