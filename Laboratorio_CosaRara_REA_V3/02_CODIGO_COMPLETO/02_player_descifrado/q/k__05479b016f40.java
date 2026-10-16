// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q;

import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3038a = p.m.f("Schedulers");

    public static void a(p.b bVar, WorkDatabase workDatabase, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        y.p pVarT = workDatabase.t();
        workDatabase.c();
        try {
            ArrayList arrayListC = pVarT.c(bVar.f2829h);
            ArrayList arrayListB = pVarT.b();
            if (arrayListC.size() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                int size = arrayListC.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayListC.get(i3);
                    i3++;
                    pVarT.j(((y.o) obj).f5999a, jCurrentTimeMillis);
                }
            }
            workDatabase.o();
            workDatabase.k();
            if (arrayListC.size() > 0) {
                y.o[] oVarArr = (y.o[]) arrayListC.toArray(new y.o[arrayListC.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    j jVar = (j) it.next();
                    if (jVar.f()) {
                        jVar.e(oVarArr);
                    }
                }
            }
            if (arrayListB.size() > 0) {
                y.o[] oVarArr2 = (y.o[]) arrayListB.toArray(new y.o[arrayListB.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    j jVar2 = (j) it2.next();
                    if (!jVar2.f()) {
                        jVar2.e(oVarArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.k();
            throw th;
        }
    }
}
