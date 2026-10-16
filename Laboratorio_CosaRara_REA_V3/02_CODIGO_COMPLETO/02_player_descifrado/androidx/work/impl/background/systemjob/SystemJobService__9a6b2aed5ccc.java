// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import h0.g;
import java.util.Arrays;
import java.util.HashMap;
import p.m;
import q.d;
import q.h;
import q.l;
import q.q;
import t.c;
import w1.o2;
import y.e;
import y.j;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class SystemJobService extends JobService implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f231d = m.f("SystemJobService");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f233b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f234c = new e(8);

    public static j a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new j(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // q.d
    public final void b(j jVar, boolean z2) {
        JobParameters jobParameters;
        m.d().a(f231d, jVar.f5987a + " executed on JobScheduler");
        synchronized (this.f233b) {
            jobParameters = (JobParameters) this.f233b.remove(jVar);
        }
        this.f234c.j(jVar);
        if (jobParameters != null) {
            jobFinished(jobParameters, z2);
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            q qVarA = q.a(getApplicationContext());
            this.f232a = qVarA;
            qVarA.f3060f.a(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                m.d().g(f231d, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
            } else {
                o2.k("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        q qVar = this.f232a;
        if (qVar != null) {
            qVar.f3060f.e(this);
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        if (this.f232a == null) {
            m.d().a(f231d, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        j jVarA = a(jobParameters);
        if (jVarA == null) {
            m.d().b(f231d, "WorkSpec id not found!");
            return false;
        }
        synchronized (this.f233b) {
            try {
                if (this.f233b.containsKey(jVarA)) {
                    m.d().a(f231d, "Job is already being executed by SystemJobService: " + jVarA);
                    return false;
                }
                m.d().a(f231d, "onStartJob for " + jVarA);
                this.f233b.put(jVarA, jobParameters);
                g gVar = new g();
                if (c.b(jobParameters) != null) {
                    Arrays.asList(c.b(jobParameters));
                }
                if (c.a(jobParameters) != null) {
                    Arrays.asList(c.a(jobParameters));
                }
                t.d.a(jobParameters);
                this.f232a.e(this.f234c.p(jVarA), gVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        boolean zContains;
        if (this.f232a == null) {
            m.d().a(f231d, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        j jVarA = a(jobParameters);
        if (jVarA == null) {
            m.d().b(f231d, "WorkSpec id not found!");
            return false;
        }
        m.d().a(f231d, "onStopJob for " + jVarA);
        synchronized (this.f233b) {
            this.f233b.remove(jVarA);
        }
        l lVarJ = this.f234c.j(jVarA);
        if (lVarJ != null) {
            q qVar = this.f232a;
            qVar.f3058d.b(new z.m(qVar, lVarJ, false));
        }
        h hVar = this.f232a.f3060f;
        String str = jVarA.f5987a;
        synchronized (hVar.f3035l) {
            zContains = hVar.f3033j.contains(str);
        }
        return !zContains;
    }
}
