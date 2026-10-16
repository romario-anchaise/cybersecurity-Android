// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Status;
import e2.n1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements f0.c, f0.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.common.internal.a f1457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f1458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y.e f1459d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1463h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ c f1466k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f1456a = new LinkedList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet f1460e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f1461f = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f1464i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e0.b f1465j = null;

    public h(c cVar, j0.c cVar2) {
        this.f1466k = cVar;
        Looper looper = cVar.f1450m.getLooper();
        Context context = cVar2.f2310a;
        y.r rVar = new y.r();
        Set set = Collections.EMPTY_SET;
        if (((c.c) rVar.f6032a) == null) {
            rVar.f6032a = new c.c();
        }
        ((c.c) rVar.f6032a).addAll(set);
        rVar.f6034c = context.getClass().getName();
        rVar.f6033b = context.getPackageName();
        y.m mVar = new y.m((Set) rVar.f6032a, (String) rVar.f6033b, (String) rVar.f6034c);
        j0.b bVar = (j0.b) cVar2.f2312c.f5991c;
        h0.o.c(bVar);
        h0.j jVar = cVar2.f2313d;
        Context context2 = cVar2.f2310a;
        bVar.getClass();
        j0.d dVar = new j0.d(context2, looper, mVar, jVar, this, this);
        String str = cVar2.f2311b;
        if (str != null) {
            dVar.f493r = str;
        }
        this.f1457b = dVar;
        this.f1458c = cVar2.f2314e;
        this.f1459d = new y.e(3);
        this.f1462g = cVar2.f2315f;
    }

    @Override // f0.c
    public final void a(int i3) {
        Looper looperMyLooper = Looper.myLooper();
        p0.e eVar = this.f1466k.f1450m;
        if (looperMyLooper == eVar.getLooper()) {
            i(i3);
        } else {
            eVar.post(new g(this, i3, 0));
        }
    }

    @Override // f0.c
    public final void b() {
        Looper looperMyLooper = Looper.myLooper();
        p0.e eVar = this.f1466k.f1450m;
        if (looperMyLooper == eVar.getLooper()) {
            h();
        } else {
            eVar.post(new a2.i(7, this));
        }
    }

    @Override // f0.d
    public final void c(e0.b bVar) {
        o(bVar, null);
    }

    public final void d(e0.b bVar) {
        HashSet hashSet = this.f1460e;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
            return;
        }
        if (it.next() != null) {
            throw new ClassCastException();
        }
        if (h0.o.e(bVar, e0.b.f657h)) {
            com.google.android.gms.common.internal.a aVar = this.f1457b;
            if (!aVar.j() || aVar.f478b == null) {
                throw new RuntimeException("Failed to connect when checking package");
            }
        }
        throw null;
    }

    public final void e(Status status) {
        h0.o.a(this.f1466k.f1450m);
        f(status, null, false);
    }

    public final void f(Status status, Exception exc, boolean z2) {
        h0.o.a(this.f1466k.f1450m);
        if ((status == null) == (exc == null)) {
            o2.i("Status XOR exception should be null");
            return;
        }
        Iterator it = this.f1456a.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            if (!z2 || nVar.f1480a == 2) {
                if (status != null) {
                    nVar.c(status);
                } else {
                    nVar.d(exc);
                }
                it.remove();
            }
        }
    }

    public final void g() {
        LinkedList linkedList = this.f1456a;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = (n) arrayList.get(i3);
            if (!this.f1457b.j()) {
                return;
            }
            if (k(nVar)) {
                linkedList.remove(nVar);
            }
        }
    }

    public final void h() {
        c cVar = this.f1466k;
        h0.o.a(cVar.f1450m);
        this.f1465j = null;
        d(e0.b.f657h);
        p0.e eVar = cVar.f1450m;
        if (this.f1463h) {
            a aVar = this.f1458c;
            eVar.removeMessages(11, aVar);
            eVar.removeMessages(9, aVar);
            this.f1463h = false;
        }
        Iterator it = this.f1461f.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        g();
        j();
    }

    public final void i(int i3) {
        a aVar = this.f1458c;
        c cVar = this.f1466k;
        p0.e eVar = cVar.f1450m;
        h0.o.a(cVar.f1450m);
        this.f1465j = null;
        this.f1463h = true;
        String str = this.f1457b.f477a;
        y.e eVar2 = this.f1459d;
        eVar2.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i3 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i3 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        eVar2.q(true, new Status(20, sb.toString(), null, null));
        eVar.sendMessageDelayed(Message.obtain(eVar, 9, aVar), 5000L);
        eVar.sendMessageDelayed(Message.obtain(eVar, 11, aVar), 120000L);
        ((SparseIntArray) cVar.f1444g.f5976c).clear();
        Iterator it = this.f1461f.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    public final void j() {
        c cVar = this.f1466k;
        p0.e eVar = cVar.f1450m;
        a aVar = this.f1458c;
        eVar.removeMessages(12, aVar);
        eVar.sendMessageDelayed(eVar.obtainMessage(12, aVar), cVar.f1438a);
    }

    public final boolean k(n nVar) {
        e0.d dVar;
        if (nVar == null) {
            y.e eVar = this.f1459d;
            com.google.android.gms.common.internal.a aVar = this.f1457b;
            nVar.f(eVar, aVar.l());
            try {
                nVar.e(this);
                return true;
            } catch (DeadObjectException unused) {
                a(1);
                aVar.b("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        e0.d[] dVarArrB = nVar.b(this);
        if (dVarArrB == null || dVarArrB.length == 0) {
            dVar = null;
            break;
        }
        h0.w wVar = this.f1457b.f496u;
        e0.d[] dVarArr = wVar == null ? null : wVar.f1932d;
        if (dVarArr == null) {
            dVarArr = new e0.d[0];
        }
        int length = dVarArr.length;
        c.b bVar = new c.b();
        if (length == 0) {
            bVar.f393c = c.d.f372a;
            bVar.f394d = c.d.f373b;
        } else {
            bVar.a(length);
        }
        bVar.f395e = 0;
        for (e0.d dVar2 : dVarArr) {
            bVar.put(dVar2.f666c, Long.valueOf(dVar2.a()));
        }
        int length2 = dVarArrB.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length2) {
                dVar = null;
                break;
            }
            dVar = dVarArrB[i3];
            Long l3 = (Long) bVar.getOrDefault(dVar.f666c, null);
            if (l3 == null || l3.longValue() < dVar.a()) {
                break;
            }
            i3++;
        }
        if (dVar == null) {
            y.e eVar2 = this.f1459d;
            com.google.android.gms.common.internal.a aVar2 = this.f1457b;
            nVar.f(eVar2, aVar2.l());
            try {
                nVar.e(this);
                return true;
            } catch (DeadObjectException unused2) {
                a(1);
                aVar2.b("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        Log.w("GoogleApiManager", this.f1457b.getClass().getName() + " could not execute call because it requires feature (" + dVar.f666c + ", " + dVar.a() + ").");
        if (!this.f1466k.n || !nVar.a(this)) {
            nVar.d(new f0.g(dVar));
            return true;
        }
        i iVar = new i(this.f1458c, dVar);
        int iIndexOf = this.f1464i.indexOf(iVar);
        ArrayList arrayList = this.f1464i;
        if (iIndexOf >= 0) {
            i iVar2 = (i) arrayList.get(iIndexOf);
            this.f1466k.f1450m.removeMessages(15, iVar2);
            p0.e eVar3 = this.f1466k.f1450m;
            eVar3.sendMessageDelayed(Message.obtain(eVar3, 15, iVar2), 5000L);
        } else {
            arrayList.add(iVar);
            p0.e eVar4 = this.f1466k.f1450m;
            eVar4.sendMessageDelayed(Message.obtain(eVar4, 15, iVar), 5000L);
            p0.e eVar5 = this.f1466k.f1450m;
            eVar5.sendMessageDelayed(Message.obtain(eVar5, 16, iVar), 120000L);
            e0.b bVar2 = new e0.b(2, null, null);
            if (!l(bVar2)) {
                this.f1466k.a(bVar2, this.f1462g);
            }
        }
        return false;
    }

    public final boolean l(e0.b bVar) {
        synchronized (c.f1436q) {
        }
        return false;
    }

    public final void m() {
        c cVar = this.f1466k;
        h0.o.a(cVar.f1450m);
        com.google.android.gms.common.internal.a aVar = this.f1457b;
        if (aVar.j() || aVar.k()) {
            return;
        }
        try {
            y.e eVar = cVar.f1444g;
            Context context = cVar.f1442e;
            SparseIntArray sparseIntArray = (SparseIntArray) eVar.f5976c;
            h0.o.c(context);
            int iE = aVar.e();
            int iC = ((SparseIntArray) eVar.f5976c).get(iE, -1);
            if (iC == -1) {
                iC = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= sparseIntArray.size()) {
                        iC = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i3);
                    if (iKeyAt > iE && sparseIntArray.get(iKeyAt) == 0) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (iC == -1) {
                    iC = ((e0.e) eVar.f5977d).c(context, iE);
                }
                sparseIntArray.put(iE, iC);
            }
            if (iC == 0) {
                k kVar = new k(cVar, aVar, this.f1458c);
                if (aVar.l()) {
                    h0.o.c(null);
                    throw null;
                }
                try {
                    aVar.f485i = kVar;
                    aVar.n(2, null);
                    return;
                } catch (SecurityException e3) {
                    o(new e0.b(10, null, null), e3);
                    return;
                }
            }
            e0.b bVar = new e0.b(iC, null, null);
            Log.w("GoogleApiManager", "The service for " + aVar.getClass().getName() + " is not available: " + bVar.toString());
            o(bVar, null);
        } catch (IllegalStateException e4) {
            o(new e0.b(10, null, null), e4);
        }
    }

    public final void n(n nVar) {
        h0.o.a(this.f1466k.f1450m);
        boolean zJ = this.f1457b.j();
        LinkedList linkedList = this.f1456a;
        if (zJ) {
            if (k(nVar)) {
                j();
                return;
            } else {
                linkedList.add(nVar);
                return;
            }
        }
        linkedList.add(nVar);
        e0.b bVar = this.f1465j;
        if (bVar == null || bVar.f659d == 0 || bVar.f660e == null) {
            m();
        } else {
            o(bVar, null);
        }
    }

    public final void o(e0.b bVar, RuntimeException runtimeException) {
        h0.o.a(this.f1466k.f1450m);
        h0.o.a(this.f1466k.f1450m);
        this.f1465j = null;
        ((SparseIntArray) this.f1466k.f1444g.f5976c).clear();
        d(bVar);
        if ((this.f1457b instanceof j0.d) && bVar.f659d != 24) {
            c cVar = this.f1466k;
            cVar.f1439b = true;
            p0.e eVar = cVar.f1450m;
            eVar.sendMessageDelayed(eVar.obtainMessage(19), 300000L);
        }
        if (bVar.f659d == 4) {
            e(c.f1435p);
            return;
        }
        if (this.f1456a.isEmpty()) {
            this.f1465j = bVar;
            return;
        }
        c cVar2 = this.f1466k;
        if (runtimeException != null) {
            h0.o.a(cVar2.f1450m);
            f(null, runtimeException, false);
            return;
        }
        boolean z2 = cVar2.n;
        a aVar = this.f1458c;
        if (!z2) {
            e(c.b(aVar, bVar));
            return;
        }
        f(c.b(aVar, bVar), null, true);
        if (this.f1456a.isEmpty() || l(bVar) || this.f1466k.a(bVar, this.f1462g)) {
            return;
        }
        if (bVar.f659d == 18) {
            this.f1463h = true;
        }
        if (!this.f1463h) {
            e(c.b(this.f1458c, bVar));
            return;
        }
        c cVar3 = this.f1466k;
        a aVar2 = this.f1458c;
        p0.e eVar2 = cVar3.f1450m;
        eVar2.sendMessageDelayed(Message.obtain(eVar2, 9, aVar2), 5000L);
    }

    public final void p() {
        h0.o.a(this.f1466k.f1450m);
        Status status = c.f1434o;
        e(status);
        this.f1459d.q(false, status);
        for (d dVar : (d[]) this.f1461f.keySet().toArray(new d[0])) {
            n(new u(new u0.b()));
        }
        d(new e0.b(4, null, null));
        com.google.android.gms.common.internal.a aVar = this.f1457b;
        if (aVar.j()) {
            n1 n1Var = new n1(this);
            aVar.getClass();
            ((h) n1Var.f905c).f1466k.f1450m.post(new a2.i(8, n1Var));
        }
    }
}
