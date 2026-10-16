// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package t;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import p.m;
import q.j;
import q.q;
import y.g;
import y.h;
import y.i;
import y.o;
import y.p;
import z.f;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f3240e = m.f("SystemJobScheduler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JobScheduler f3242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f3243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f3244d;

    public b(Context context, q qVar) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        a aVar = new a(context);
        this.f3241a = context;
        this.f3243c = qVar;
        this.f3242b = jobScheduler;
        this.f3244d = aVar;
    }

    public static void b(JobScheduler jobScheduler, int i3) {
        try {
            jobScheduler.cancel(i3);
        } catch (Throwable th) {
            m.d().c(f3240e, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i3)), th);
        }
    }

    public static ArrayList c(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            m.d().c(f3240e, "getAllPendingJobs() is not reliable on this device.", th);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static y.j d(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new y.j(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // q.j
    public final void a(String str) {
        ArrayList arrayList;
        Context context = this.f3241a;
        JobScheduler jobScheduler = this.f3242b;
        ArrayList arrayListC = c(context, jobScheduler);
        int i3 = 0;
        if (arrayListC == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(2);
            int size = arrayListC.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayListC.get(i4);
                i4++;
                JobInfo jobInfo = (JobInfo) obj;
                y.j jVarD = d(jobInfo);
                if (jVarD != null && str.equals(jVarD.f5987a)) {
                    arrayList2.add(Integer.valueOf(jobInfo.getId()));
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size2 = arrayList.size();
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            b(jobScheduler, ((Integer) obj2).intValue());
        }
        i iVarP = this.f3243c.f3057c.p();
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) iVarP.f5983a;
        workDatabase_Impl.b();
        h hVar = (h) iVarP.f5986d;
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
        } finally {
            workDatabase_Impl.k();
            hVar.m(iVarA);
        }
    }

    @Override // q.j
    public final void e(o... oVarArr) {
        int iIntValue;
        q qVar = this.f3243c;
        WorkDatabase workDatabase = qVar.f3057c;
        final f fVar = new f(workDatabase, 0);
        for (o oVar : oVarArr) {
            workDatabase.c();
            try {
                p pVarT = workDatabase.t();
                String str = oVar.f5999a;
                o oVarH = pVarT.h(str);
                String str2 = f3240e;
                if (oVarH == null) {
                    m.d().g(str2, "Skipping scheduling " + str + " because it's no longer in the DB");
                    workDatabase.o();
                } else if (oVarH.f6000b != 1) {
                    m.d().g(str2, "Skipping scheduling " + str + " because it is no longer enqueued");
                    workDatabase.o();
                } else {
                    y.j jVarH = m0.a.h(oVar);
                    g gVarB = workDatabase.p().b(jVarH);
                    if (gVarB != null) {
                        iIntValue = gVarB.f5981c;
                    } else {
                        qVar.f3056b.getClass();
                        final int i3 = qVar.f3056b.f2828g;
                        Object objN = fVar.f6244a.n(new Callable() { // from class: z.e
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                WorkDatabase workDatabase2 = fVar.f6244a;
                                Long lG = workDatabase2.l().g("next_job_scheduler_id");
                                int i4 = 0;
                                int iLongValue = lG != null ? (int) lG.longValue() : 0;
                                workDatabase2.l().h(new y.d("next_job_scheduler_id", Long.valueOf(iLongValue == Integer.MAX_VALUE ? 0 : iLongValue + 1)));
                                if (iLongValue < 0 || iLongValue > i3) {
                                    workDatabase2.l().h(new y.d("next_job_scheduler_id", Long.valueOf(1)));
                                } else {
                                    i4 = iLongValue;
                                }
                                return Integer.valueOf(i4);
                            }
                        });
                        objN.getClass();
                        iIntValue = ((Number) objN).intValue();
                    }
                    if (gVarB == null) {
                        qVar.f3057c.p().c(new g(jVarH.f5988b, iIntValue, jVarH.f5987a));
                    }
                    g(oVar, iIntValue);
                    workDatabase.o();
                }
                workDatabase.k();
            } catch (Throwable th) {
                workDatabase.k();
                throw th;
            }
        }
    }

    @Override // q.j
    public final boolean f() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(o oVar, int i3) {
        int i4;
        JobScheduler jobScheduler = this.f3242b;
        a aVar = this.f3244d;
        aVar.getClass();
        p.d dVar = oVar.f6008j;
        PersistableBundle persistableBundle = new PersistableBundle();
        String str = oVar.f5999a;
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", str);
        persistableBundle.putInt("EXTRA_WORK_SPEC_GENERATION", oVar.f6017t);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", oVar.d());
        JobInfo.Builder builder = new JobInfo.Builder(i3, aVar.f3239a);
        boolean z2 = dVar.f2834b;
        Set<p.c> set = dVar.f2840h;
        JobInfo.Builder requiresCharging = builder.setRequiresCharging(z2);
        boolean z3 = dVar.f2835c;
        JobInfo.Builder extras = requiresCharging.setRequiresDeviceIdle(z3).setExtras(persistableBundle);
        int i5 = dVar.f2833a;
        if (i5 == 6) {
            extras.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        } else {
            int iA = g.d.a(i5);
            if (iA == 0) {
                i4 = 0;
            } else if (iA == 1) {
                i4 = 1;
            } else if (iA != 2) {
                i4 = 3;
                if (iA != 3) {
                    i4 = 4;
                    if (iA != 4) {
                        m.d().a(a.f3238b, "API version too low. Cannot convert network type value ".concat(a0.a.A(i5)));
                        i4 = 1;
                    }
                }
            } else {
                i4 = 2;
            }
            extras.setRequiredNetworkType(i4);
        }
        if (!z3) {
            extras.setBackoffCriteria(oVar.f6011m, oVar.f6010l == 2 ? 0 : 1);
        }
        long jMax = Math.max(oVar.a() - System.currentTimeMillis(), 0L);
        if (jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!oVar.f6014q) {
            extras.setImportantWhileForeground(true);
        }
        if (!set.isEmpty()) {
            for (p.c cVar : set) {
                extras.addTriggerContentUri(new JobInfo.TriggerContentUri(cVar.f2830a, cVar.f2831b ? 1 : 0));
            }
            extras.setTriggerContentUpdateDelay(dVar.f2838f);
            extras.setTriggerContentMaxDelay(dVar.f2839g);
        }
        extras.setPersisted(false);
        extras.setRequiresBatteryNotLow(dVar.f2836d);
        extras.setRequiresStorageNotLow(dVar.f2837e);
        Object[] objArr = oVar.f6009k > 0;
        Object[] objArr2 = jMax > 0;
        if (Build.VERSION.SDK_INT >= 31 && oVar.f6014q && objArr == false && objArr2 == false) {
            extras.setExpedited(true);
        }
        JobInfo jobInfoBuild = extras.build();
        String str2 = f3240e;
        m.d().a(str2, "Scheduling work ID " + str + "Job ID " + i3);
        try {
            if (jobScheduler.schedule(jobInfoBuild) == 0) {
                m.d().g(str2, "Unable to schedule work ID " + str);
                if (oVar.f6014q && oVar.f6015r == 1) {
                    oVar.f6014q = false;
                    m.d().a(str2, "Scheduling a non-expedited job (work ID " + str + ")");
                    g(oVar, i3);
                }
            }
        } catch (IllegalStateException e3) {
            ArrayList arrayListC = c(this.f3241a, jobScheduler);
            int size = arrayListC != null ? arrayListC.size() : 0;
            Locale locale = Locale.getDefault();
            Integer numValueOf = Integer.valueOf(size);
            q qVar = this.f3243c;
            String str3 = String.format(locale, "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", numValueOf, Integer.valueOf(qVar.f3057c.t().e().size()), Integer.valueOf(qVar.f3056b.f2829h));
            m.d().b(str2, str3);
            IllegalStateException illegalStateException = new IllegalStateException(str3, e3);
            qVar.f3056b.getClass();
            throw illegalStateException;
        } catch (Throwable th) {
            m.d().c(str2, "Unable to schedule " + oVar, th);
        }
    }
}
