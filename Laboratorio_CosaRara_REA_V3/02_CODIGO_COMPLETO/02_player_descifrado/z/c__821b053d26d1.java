// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f6233e = p.m.f("EnqueueRunnable");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q.m f6234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y.c f6235d;

    public c(q.m mVar, y.c cVar) {
        this.f6234c = mVar;
        this.f6235d = cVar;
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0136  */
    /* JADX WARN: Code duplicated, block: B:70:0x013b  */
    /* JADX WARN: Code duplicated, block: B:71:0x013d  */
    /* JADX WARN: Code duplicated, block: B:74:0x0143  */
    /* JADX WARN: Code duplicated, block: B:75:0x0146  */
    /* JADX WARN: Code duplicated, block: B:77:0x0149  */
    /* JADX WARN: Code duplicated, block: B:79:0x0153  */
    /* JADX WARN: Code duplicated, block: B:96:0x01a3  */
    public static boolean a(q.m mVar) {
        boolean z2;
        boolean z3;
        boolean z4;
        List<p.u> list;
        boolean z5;
        WorkDatabase workDatabase;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        char c3;
        int i3;
        boolean z10;
        HashSet hashSetB = q.m.b(mVar);
        q.q qVar = mVar.f3041a;
        List list2 = mVar.f3044d;
        int i4 = 0;
        String[] strArr = (String[]) hashSetB.toArray(new String[0]);
        String str = mVar.f3042b;
        int i5 = mVar.f3043c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        WorkDatabase workDatabase2 = qVar.f3057c;
        boolean z11 = strArr != null && strArr.length > 0;
        if (z11) {
            int length = strArr.length;
            z3 = false;
            z4 = false;
            z2 = true;
            while (true) {
                if (i4 < length) {
                    String str2 = strArr[i4];
                    y.o oVarH = workDatabase2.t().h(str2);
                    if (oVarH == null) {
                        p.m.d().b(f6233e, "Prerequisite " + str2 + " doesn't exist; not enqueuing");
                    } else {
                        int i6 = oVarH.f6000b;
                        z2 &= i6 == 3;
                        if (i6 == 4) {
                            z4 = true;
                        } else if (i6 == 6) {
                            z3 = true;
                        }
                        i4++;
                    }
                }
                z7 = false;
                mVar.f3047g = true;
                return z7;
            }
        }
        z2 = true;
        z3 = false;
        z4 = false;
        boolean zIsEmpty = TextUtils.isEmpty(str);
        if (zIsEmpty || z11) {
            list = list2;
            z5 = zIsEmpty;
            workDatabase = workDatabase2;
            z6 = false;
        } else {
            ArrayList arrayListI = workDatabase2.t().i(str);
            if (arrayListI.isEmpty()) {
                list = list2;
                z5 = zIsEmpty;
                workDatabase = workDatabase2;
            } else if (i5 == 3 || i5 == 4) {
                y.c cVarF = workDatabase2.f();
                ArrayList arrayList = new ArrayList();
                int size = arrayListI.size();
                int i7 = 0;
                while (i7 < size) {
                    Object obj = arrayListI.get(i7);
                    i7++;
                    y.n nVar = (y.n) obj;
                    List list3 = list2;
                    String str3 = nVar.f5996a;
                    boolean z12 = zIsEmpty;
                    WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) cVarF.f5972d;
                    WorkDatabase workDatabase3 = workDatabase2;
                    ArrayList arrayList2 = arrayListI;
                    g.k kVarY = g.k.y("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
                    if (str3 == null) {
                        kVarY.l(1);
                    } else {
                        kVarY.m(str3, 1);
                    }
                    workDatabase_Impl.b();
                    Cursor cursorM = workDatabase_Impl.m(kVarY);
                    try {
                        if (cursorM.moveToFirst()) {
                            z8 = false;
                            if (cursorM.getInt(0) != 0) {
                                z9 = true;
                            }
                            cursorM.close();
                            kVarY.z();
                            if (z9) {
                                c3 = 3;
                            } else {
                                i3 = nVar.f5997b;
                                c3 = 3;
                                if (i3 == 3) {
                                    z10 = true;
                                } else {
                                    z10 = z8;
                                }
                                boolean z13 = z2 & z10;
                                if (i3 == 4) {
                                    z4 = true;
                                } else if (i3 == 6) {
                                    z3 = true;
                                }
                                arrayList.add(nVar.f5996a);
                                z2 = z13;
                            }
                            list2 = list3;
                            zIsEmpty = z12;
                            workDatabase2 = workDatabase3;
                            arrayListI = arrayList2;
                        } else {
                            z8 = false;
                        }
                        z9 = z8;
                        cursorM.close();
                        kVarY.z();
                        if (z9) {
                            i3 = nVar.f5997b;
                            c3 = 3;
                            if (i3 == 3) {
                                z10 = true;
                            } else {
                                z10 = z8;
                            }
                            boolean z14 = z2 & z10;
                            if (i3 == 4) {
                                z4 = true;
                            } else if (i3 == 6) {
                                z3 = true;
                            }
                            arrayList.add(nVar.f5996a);
                            z2 = z14;
                        } else {
                            c3 = 3;
                        }
                        list2 = list3;
                        zIsEmpty = z12;
                        workDatabase2 = workDatabase3;
                        arrayListI = arrayList2;
                    } catch (Throwable th) {
                        cursorM.close();
                        kVarY.z();
                        throw th;
                    }
                }
                list = list2;
                z5 = zIsEmpty;
                workDatabase = workDatabase2;
                List list4 = arrayList;
                list4 = arrayList;
                if (i5 == 4 && (z3 || z4)) {
                    y.p pVarT = workDatabase.t();
                    ArrayList arrayListI2 = pVarT.i(str);
                    int size2 = arrayListI2.size();
                    int i8 = 0;
                    while (i8 < size2) {
                        Object obj2 = arrayListI2.get(i8);
                        i8++;
                        pVarT.a(((y.n) obj2).f5996a);
                    }
                    z3 = false;
                    z4 = false;
                    list4 = Collections.EMPTY_LIST;
                }
                strArr = (String[]) list4.toArray(strArr);
                z11 = strArr.length > 0;
            } else {
                if (i5 == 2) {
                    int size3 = arrayListI.size();
                    int i9 = 0;
                    while (true) {
                        if (i9 < size3) {
                            Object obj3 = arrayListI.get(i9);
                            i9++;
                            int i10 = ((y.n) obj3).f5997b;
                            if (i10 == 1 || i10 == 2) {
                                z7 = false;
                                mVar.f3047g = true;
                                return z7;
                            }
                        }
                    }
                }
                new b(qVar, str, 1).run();
                y.p pVarT2 = workDatabase2.t();
                int size4 = arrayListI.size();
                int i11 = 0;
                while (i11 < size4) {
                    Object obj4 = arrayListI.get(i11);
                    i11++;
                    pVarT2.a(((y.n) obj4).f5996a);
                }
                list = list2;
                z5 = zIsEmpty;
                workDatabase = workDatabase2;
                z6 = true;
            }
            z6 = false;
        }
        boolean z15 = z6;
        for (p.u uVar : list) {
            y.o oVar = uVar.f2866b;
            UUID uuid = uVar.f2865a;
            if (!z11 || z2) {
                oVar.n = jCurrentTimeMillis;
            } else if (z4) {
                oVar.f6000b = 4;
            } else if (z3) {
                oVar.f6000b = 6;
            } else {
                oVar.f6000b = 5;
            }
            if (oVar.f6000b == 1) {
                z15 = true;
            }
            y.p pVarT3 = workDatabase.t();
            qVar.f3059e.getClass();
            WorkDatabase_Impl workDatabase_Impl2 = pVarT3.f6018a;
            workDatabase_Impl2.b();
            workDatabase_Impl2.c();
            try {
                pVarT3.f6019b.p(oVar);
                workDatabase_Impl2.o();
                workDatabase_Impl2.k();
                if (z11) {
                    for (String str4 : strArr) {
                        String string = uuid.toString();
                        string.getClass();
                        y.a aVar = new y.a(string, str4);
                        y.c cVarF2 = workDatabase.f();
                        WorkDatabase_Impl workDatabase_Impl3 = (WorkDatabase_Impl) cVarF2.f5972d;
                        workDatabase_Impl3.b();
                        workDatabase_Impl3.c();
                        try {
                            ((y.b) cVarF2.f5973e).p(aVar);
                            workDatabase_Impl3.o();
                            workDatabase_Impl3.k();
                        } catch (Throwable th2) {
                            workDatabase_Impl3.k();
                            throw th2;
                        }
                    }
                }
                y.r rVarU = workDatabase.u();
                String string2 = uuid.toString();
                string2.getClass();
                rVarU.d(string2, uVar.f2867c);
                if (!z5) {
                    y.l lVarR = workDatabase.r();
                    String string3 = uuid.toString();
                    string3.getClass();
                    y.k kVar = new y.k(str, string3);
                    WorkDatabase_Impl workDatabase_Impl4 = (WorkDatabase_Impl) lVarR.f5991c;
                    workDatabase_Impl4.b();
                    workDatabase_Impl4.c();
                    try {
                        ((y.b) lVarR.f5992d).p(kVar);
                        workDatabase_Impl4.o();
                        workDatabase_Impl4.k();
                    } catch (Throwable th3) {
                        workDatabase_Impl4.k();
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                workDatabase_Impl2.k();
                throw th4;
            }
        }
        z7 = z15;
        mVar.f3047g = true;
        return z7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        y.c cVar = this.f6235d;
        q.m mVar = this.f6234c;
        q.q qVar = mVar.f3041a;
        try {
            HashSet hashSet = new HashSet();
            hashSet.addAll(mVar.f3045e);
            HashSet hashSetB = q.m.b(mVar);
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    hashSet.removeAll(mVar.f3045e);
                    z2 = false;
                    break;
                } else if (hashSetB.contains((String) it.next())) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                throw new IllegalStateException("WorkContinuation has cycles (" + mVar + ")");
            }
            WorkDatabase workDatabase = qVar.f3057c;
            workDatabase.c();
            try {
                boolean zA = a(mVar);
                workDatabase.o();
                workDatabase.k();
                if (zA) {
                    j.a(qVar.f3055a, RescheduleReceiver.class, true);
                    q.k.a(qVar.f3056b, qVar.f3057c, qVar.f3059e);
                }
                cVar.j(p.s.f2863a);
            } catch (Throwable th) {
                workDatabase.k();
                throw th;
            }
        } catch (Throwable th2) {
            cVar.j(new p.p(th2));
        }
    }
}
