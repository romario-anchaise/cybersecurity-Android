// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q;

import android.app.ActivityManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemjob.SystemJobService;
import com.os9sp.yfwkcq0dwfxaf.R;
import e2.n1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static q f3052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static q f3053l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f3054m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.b f3056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WorkDatabase f3057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y.r f3058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f3059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f3060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final z.f f3061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3062h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BroadcastReceiver.PendingResult f3063i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final y.i f3064j;

    static {
        p.m.f("WorkManagerImpl");
        f3052k = null;
        f3053l = null;
        f3054m = new Object();
    }

    public q(Context context, p.b bVar, y.r rVar) {
        g.i iVar;
        boolean zContainsKey;
        boolean z2 = context.getResources().getBoolean(R.bool.workmanager_test_configuration);
        Context applicationContext = context.getApplicationContext();
        z.l lVar = (z.l) rVar.f6032a;
        applicationContext.getClass();
        lVar.getClass();
        if (z2) {
            iVar = new g.i(applicationContext, null);
            iVar.f1405i = true;
        } else {
            if (v1.d.F("androidx.work.workdb")) {
                o2.i("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
                throw null;
            }
            g.i iVar2 = new g.i(applicationContext, "androidx.work.workdb");
            iVar2.f1404h = new n(applicationContext);
            iVar = iVar2;
        }
        ArrayList arrayList = iVar.f1399c;
        iVar.f1402f = lVar;
        arrayList.add(b.f3004a);
        iVar.a(e.f3009g);
        iVar.a(new i(applicationContext, 2, 3));
        iVar.a(e.f3010h);
        iVar.a(e.f3011i);
        iVar.a(new i(applicationContext, 5, 6));
        iVar.a(e.f3012j);
        iVar.a(e.f3013k);
        iVar.a(e.f3014l);
        iVar.a(new i(applicationContext));
        iVar.a(new i(applicationContext, 10, 11));
        iVar.a(e.f3006d);
        iVar.a(e.f3007e);
        iVar.a(e.f3008f);
        iVar.f1407k = false;
        iVar.f1408l = true;
        LinkedHashSet linkedHashSet = iVar.f1410o;
        Executor executor = iVar.f1402f;
        if (executor == null && iVar.f1403g == null) {
            a.a aVar = a.b.f2e;
            iVar.f1403g = aVar;
            iVar.f1402f = aVar;
        } else if (executor != null && iVar.f1403g == null) {
            iVar.f1403g = executor;
        } else if (executor == null) {
            iVar.f1402f = iVar.f1403g;
        }
        HashSet hashSet = iVar.f1411p;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (linkedHashSet.contains(Integer.valueOf(iIntValue))) {
                    o2.h(a0.a.g("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ", iIntValue));
                    throw null;
                }
            }
        }
        Object iVar3 = iVar.f1404h;
        iVar3 = iVar3 == null ? new e0.i() : iVar3;
        if (iVar.f1409m > 0) {
            if (iVar.f1398b != null) {
                o2.i("Required value was null.");
                throw null;
            }
            o2.i("Cannot create auto-closing database for an in-memory database.");
            throw null;
        }
        Context context2 = iVar.f1397a;
        String str = iVar.f1398b;
        n1 n1Var = iVar.n;
        boolean z3 = iVar.f1405i;
        int i3 = iVar.f1406j;
        if (i3 == 0) {
            throw null;
        }
        if (i3 == 1) {
            Object systemService = context2.getSystemService("activity");
            systemService.getClass();
            i3 = !((ActivityManager) systemService).isLowRamDevice() ? 3 : 2;
        }
        Executor executor2 = iVar.f1402f;
        if (executor2 == null) {
            o2.i("Required value was null.");
            throw null;
        }
        Executor executor3 = iVar.f1403g;
        if (executor3 == null) {
            o2.i("Required value was null.");
            throw null;
        }
        boolean z4 = iVar.f1407k;
        boolean z5 = iVar.f1408l;
        ArrayList arrayList2 = iVar.f1400d;
        ArrayList arrayList3 = iVar.f1401e;
        n1Var.getClass();
        if (i3 == 0) {
            throw null;
        }
        executor2.getClass();
        executor3.getClass();
        arrayList2.getClass();
        arrayList3.getClass();
        d.b bVar2 = new d.b();
        bVar2.f511f = context2;
        bVar2.f506a = str;
        bVar2.f512g = iVar3;
        bVar2.f513h = n1Var;
        bVar2.f514i = arrayList;
        bVar2.f507b = z3;
        bVar2.f508c = i3;
        bVar2.f515j = executor2;
        bVar2.f516k = executor3;
        bVar2.f509d = z4;
        bVar2.f510e = z5;
        bVar2.f517l = linkedHashSet;
        Package r6 = WorkDatabase.class.getPackage();
        r6.getClass();
        String name = r6.getName();
        String canonicalName = WorkDatabase.class.getCanonicalName();
        canonicalName.getClass();
        name.getClass();
        String strReplace = (name.length() != 0 ? canonicalName.substring(name.length() + 1) : canonicalName).replace('.', '_');
        strReplace.getClass();
        String strConcat = strReplace.concat("_Impl");
        try {
            Class<?> cls = Class.forName(name.length() == 0 ? strConcat : name + '.' + strConcat, true, WorkDatabase.class.getClassLoader());
            cls.getClass();
            WorkDatabase workDatabase = (WorkDatabase) cls.newInstance();
            g.f fVar = workDatabase.f213d;
            LinkedHashMap linkedHashMap = workDatabase.f216g;
            workDatabase.f212c = workDatabase.e(bVar2);
            Set setI = workDatabase.i();
            BitSet bitSet = new BitSet();
            Iterator it2 = setI.iterator();
            while (true) {
                int i4 = -1;
                if (!it2.hasNext()) {
                    int size = arrayList3.size() - 1;
                    if (size >= 0) {
                        while (true) {
                            int i5 = size - 1;
                            if (!bitSet.get(size)) {
                                o2.i("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                                throw null;
                            }
                            if (i5 < 0) {
                                break;
                            } else {
                                size = i5;
                            }
                        }
                    }
                    for (h.a aVar2 : workDatabase.g(linkedHashMap)) {
                        int i6 = aVar2.f1853a;
                        int i7 = aVar2.f1854b;
                        LinkedHashMap linkedHashMap2 = (LinkedHashMap) n1Var.f905c;
                        if (linkedHashMap2.containsKey(Integer.valueOf(i6))) {
                            Map map = (Map) linkedHashMap2.get(Integer.valueOf(i6));
                            zContainsKey = (map == null ? i1.r.f2105c : map).containsKey(Integer.valueOf(i7));
                        } else {
                            zContainsKey = false;
                        }
                        if (!zContainsKey) {
                            n1Var.e(aVar2);
                        }
                    }
                    workDatabase.h().setWriteAheadLoggingEnabled(bVar2.f508c == 3);
                    workDatabase.f215f = (List) bVar2.f514i;
                    workDatabase.f211b = (Executor) bVar2.f515j;
                    ((Executor) bVar2.f516k).getClass();
                    new ArrayDeque();
                    workDatabase.f214e = bVar2.f507b;
                    Map mapJ = workDatabase.j();
                    BitSet bitSet2 = new BitSet();
                    for (Map.Entry entry : mapJ.entrySet()) {
                        Class cls2 = (Class) entry.getKey();
                        for (Class cls3 : (List) entry.getValue()) {
                            int size2 = arrayList2.size() - 1;
                            if (size2 < 0) {
                                size2 = -1;
                                break;
                            }
                            while (true) {
                                int i8 = size2 - 1;
                                if (cls3.isAssignableFrom(arrayList2.get(size2).getClass())) {
                                    bitSet2.set(size2);
                                    break;
                                } else {
                                    if (i8 < 0) {
                                        size2 = -1;
                                        break;
                                    }
                                    size2 = i8;
                                }
                            }
                            if (!(size2 >= 0)) {
                                StringBuilder sb = new StringBuilder("A required type converter (");
                                sb.append(cls3);
                                String canonicalName2 = cls2.getCanonicalName();
                                sb.append(") for ");
                                sb.append(canonicalName2);
                                sb.append(" is missing in the database configuration.");
                                throw new IllegalArgumentException(sb.toString().toString());
                            }
                            workDatabase.f219j.put(cls3, arrayList2.get(size2));
                        }
                    }
                    int size3 = arrayList2.size() - 1;
                    if (size3 >= 0) {
                        while (true) {
                            int i9 = size3 - 1;
                            if (!bitSet2.get(size3)) {
                                throw new IllegalArgumentException("Unexpected type converter " + arrayList2.get(size3) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                            }
                            if (i9 < 0) {
                                break;
                            } else {
                                size3 = i9;
                            }
                        }
                    }
                    Context applicationContext2 = context.getApplicationContext();
                    p.m mVar = new p.m(bVar.f2827f);
                    synchronized (p.m.f2854b) {
                        p.m.f2855c = mVar;
                    }
                    applicationContext2.getClass();
                    Context applicationContext3 = applicationContext2.getApplicationContext();
                    applicationContext3.getClass();
                    w.a aVar3 = new w.a(applicationContext3, rVar, 0);
                    Context applicationContext4 = applicationContext2.getApplicationContext();
                    applicationContext4.getClass();
                    w.a aVar4 = new w.a(applicationContext4, rVar, 1);
                    Context applicationContext5 = applicationContext2.getApplicationContext();
                    applicationContext5.getClass();
                    String str2 = w.i.f3370a;
                    w.h hVar = new w.h(applicationContext5, rVar);
                    Context applicationContext6 = applicationContext2.getApplicationContext();
                    applicationContext6.getClass();
                    w.a aVar5 = new w.a(applicationContext6, rVar, 2);
                    y.i iVar4 = new y.i();
                    iVar4.f5983a = aVar3;
                    iVar4.f5984b = aVar4;
                    iVar4.f5985c = hVar;
                    iVar4.f5986d = aVar5;
                    this.f3064j = iVar4;
                    String str3 = k.f3038a;
                    t.b bVar3 = new t.b(applicationContext2, this);
                    z.j.a(applicationContext2, SystemJobService.class, true);
                    p.m.d().a(k.f3038a, "Created SystemJobScheduler and enabled SystemJobService");
                    List listAsList = Arrays.asList(bVar3, new r.b(applicationContext2, bVar, iVar4, this));
                    h hVar2 = new h(context, bVar, rVar, workDatabase, listAsList);
                    Context applicationContext7 = context.getApplicationContext();
                    this.f3055a = applicationContext7;
                    this.f3056b = bVar;
                    this.f3058d = rVar;
                    this.f3057c = workDatabase;
                    this.f3059e = listAsList;
                    this.f3060f = hVar2;
                    this.f3061g = new z.f(workDatabase, 1);
                    this.f3062h = false;
                    if (p.a(applicationContext7)) {
                        o2.k("Cannot initialize WorkManager in direct boot mode");
                        throw null;
                    }
                    this.f3058d.b(new z.d(applicationContext7, this));
                    return;
                }
                Class cls4 = (Class) it2.next();
                int size4 = arrayList3.size() - 1;
                if (size4 >= 0) {
                    while (true) {
                        int i10 = size4 - 1;
                        if (cls4.isAssignableFrom(arrayList3.get(size4).getClass())) {
                            bitSet.set(size4);
                            i4 = size4;
                            break;
                        } else if (i10 < 0) {
                            break;
                        } else {
                            size4 = i10;
                        }
                    }
                }
                if (i4 < 0) {
                    throw new IllegalArgumentException(("A required auto migration spec (" + cls4.getCanonicalName() + ") is missing in the database configuration.").toString());
                }
                linkedHashMap.put(cls4, arrayList3.get(i4));
            }
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + WorkDatabase.class.getCanonicalName() + ". " + strConcat + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + WorkDatabase.class + ".canonicalName");
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + WorkDatabase.class + ".canonicalName");
        }
    }

    public static q a(Context context) {
        q qVar;
        Object obj = f3054m;
        synchronized (obj) {
            try {
                synchronized (obj) {
                    try {
                        qVar = f3052k;
                        if (qVar == null) {
                            qVar = f3053l;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return qVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (qVar != null) {
            return qVar;
        }
        context.getApplicationContext();
        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
    }

    public static void b(Context context, p.b bVar) {
        synchronized (f3054m) {
            try {
                q qVar = f3052k;
                if (qVar != null && f3053l != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (qVar == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (f3053l == null) {
                        ExecutorService executorService = bVar.f2823b;
                        y.r rVar = new y.r();
                        rVar.f6033b = new Handler(Looper.getMainLooper());
                        rVar.f6034c = new b0.a(rVar);
                        rVar.f6032a = new z.l(executorService);
                        f3053l = new q(applicationContext, bVar, rVar);
                    }
                    f3052k = f3053l;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        synchronized (f3054m) {
            try {
                this.f3062h = true;
                BroadcastReceiver.PendingResult pendingResult = this.f3063i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.f3063i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        ArrayList arrayListC;
        String str = t.b.f3240e;
        Context context = this.f3055a;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (arrayListC = t.b.c(context, jobScheduler)) != null && !arrayListC.isEmpty()) {
            int size = arrayListC.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayListC.get(i3);
                i3++;
                t.b.b(jobScheduler, ((JobInfo) obj).getId());
            }
        }
        WorkDatabase workDatabase = this.f3057c;
        y.p pVarT = workDatabase.t();
        WorkDatabase_Impl workDatabase_Impl = pVarT.f6018a;
        workDatabase_Impl.b();
        y.h hVar = pVarT.f6029l;
        k.i iVarA = hVar.a();
        workDatabase_Impl.c();
        try {
            iVarA.d();
            workDatabase_Impl.o();
            workDatabase_Impl.k();
            hVar.m(iVarA);
            k.a(this.f3056b, workDatabase, this.f3059e);
        } catch (Throwable th) {
            workDatabase_Impl.k();
            hVar.m(iVarA);
            throw th;
        }
    }

    public final void e(l lVar, h0.g gVar) {
        g gVar2 = new g();
        gVar2.f3020d = this;
        gVar2.f3021e = lVar;
        gVar2.f3022f = gVar;
        this.f3058d.b(gVar2);
    }
}
