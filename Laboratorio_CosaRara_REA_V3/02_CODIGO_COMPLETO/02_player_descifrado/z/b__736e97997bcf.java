// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y.c f6229c = new y.c(8);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f6230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q.q f6231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f6232f;

    public b(q.q qVar, Object obj, int i3) {
        this.f6230d = i3;
        this.f6231e = qVar;
        this.f6232f = obj;
    }

    public static void a(q.q qVar, String str) {
        q.u uVar;
        boolean z2;
        WorkDatabase workDatabase = qVar.f3057c;
        y.p pVarT = workDatabase.t();
        y.c cVarF = workDatabase.f();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            int iF = pVarT.f(str2);
            if (iF != 3 && iF != 4) {
                pVarT.m(str2, 6);
            }
            linkedList.addAll(cVarF.h(str2));
        }
        q.h hVar = qVar.f3060f;
        synchronized (hVar.f3035l) {
            try {
                p.m.d().a(q.h.f3023m, "Processor cancelling " + str);
                hVar.f3033j.add(str);
                uVar = (q.u) hVar.f3029f.remove(str);
                z2 = uVar != null;
                if (uVar == null) {
                    uVar = (q.u) hVar.f3030g.remove(str);
                }
                if (uVar != null) {
                    hVar.f3031h.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        q.h.c(str, uVar);
        if (z2) {
            hVar.h();
        }
        Iterator it = qVar.f3059e.iterator();
        while (it.hasNext()) {
            ((q.j) it.next()).a(str);
        }
    }

    public final void b() {
        switch (this.f6230d) {
            case 0:
                q.q qVar = this.f6231e;
                WorkDatabase workDatabase = qVar.f3057c;
                workDatabase.c();
                try {
                    a(qVar, ((UUID) this.f6232f).toString());
                    workDatabase.o();
                    workDatabase.k();
                    q.k.a(qVar.f3056b, qVar.f3057c, qVar.f3059e);
                    return;
                } catch (Throwable th) {
                    workDatabase.k();
                    throw th;
                }
            default:
                q.q qVar2 = this.f6231e;
                WorkDatabase workDatabase2 = qVar2.f3057c;
                workDatabase2.c();
                try {
                    ArrayList arrayListG = workDatabase2.t().g((String) this.f6232f);
                    int size = arrayListG.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayListG.get(i3);
                        i3++;
                        a(qVar2, (String) obj);
                    }
                    workDatabase2.o();
                    return;
                } finally {
                    workDatabase2.k();
                }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        y.c cVar = this.f6229c;
        try {
            b();
            cVar.j(p.s.f2863a);
        } catch (Throwable th) {
            cVar.j(new p.p(th));
        }
    }
}
