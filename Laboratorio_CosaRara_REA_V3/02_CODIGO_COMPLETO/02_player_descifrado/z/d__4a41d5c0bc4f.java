// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.utils.ForceStopRunnable$BroadcastReceiver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f6236g = p.m.f("ForceStopRunnable");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f6237h = 315360000000L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f6238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q.q f6239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f6240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6241f = 0;

    public d(Context context, q.q qVar) {
        this.f6238c = context.getApplicationContext();
        this.f6239d = qVar;
        this.f6240e = qVar.f3061g;
    }

    public final void a() {
        boolean z2;
        boolean z3;
        f fVar = this.f6240e;
        String str = t.b.f3240e;
        Context context = this.f6238c;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        ArrayList arrayListC = t.b.c(context, jobScheduler);
        q.q qVar = this.f6239d;
        y.i iVarP = qVar.f3057c.p();
        iVarP.getClass();
        int i3 = 0;
        g.k kVarY = g.k.y("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) iVarP.f5983a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(kVarY);
        try {
            ArrayList arrayList = new ArrayList(cursorM.getCount());
            while (cursorM.moveToNext()) {
                arrayList.add(cursorM.isNull(0) ? null : cursorM.getString(0));
            }
            cursorM.close();
            kVarY.z();
            HashSet hashSet = new HashSet(arrayListC != null ? arrayListC.size() : 0);
            if (arrayListC != null && !arrayListC.isEmpty()) {
                int size = arrayListC.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayListC.get(i4);
                    i4++;
                    JobInfo jobInfo = (JobInfo) obj;
                    y.j jVarD = t.b.d(jobInfo);
                    if (jVarD != null) {
                        hashSet.add(jVarD.f5987a);
                    } else {
                        t.b.b(jobScheduler, jobInfo.getId());
                    }
                }
            }
            int size2 = arrayList.size();
            int i5 = 0;
            while (true) {
                z2 = true;
                if (i5 >= size2) {
                    z3 = false;
                    break;
                }
                Object obj2 = arrayList.get(i5);
                i5++;
                if (!hashSet.contains((String) obj2)) {
                    p.m.d().a(t.b.f3240e, "Reconciling jobs");
                    z3 = true;
                    break;
                }
            }
            if (z3) {
                WorkDatabase workDatabase = qVar.f3057c;
                workDatabase.c();
                try {
                    y.p pVarT = workDatabase.t();
                    int size3 = arrayList.size();
                    int i6 = 0;
                    while (i6 < size3) {
                        Object obj3 = arrayList.get(i6);
                        i6++;
                        pVarT.j((String) obj3, -1L);
                    }
                    workDatabase.o();
                    workDatabase.k();
                } catch (Throwable th) {
                    workDatabase.k();
                    throw th;
                }
            }
            WorkDatabase workDatabase2 = qVar.f3057c;
            y.p pVarT2 = workDatabase2.t();
            y.m mVarS = workDatabase2.s();
            workDatabase2.c();
            try {
                ArrayList arrayListD = pVarT2.d();
                boolean zIsEmpty = arrayListD.isEmpty();
                if (!zIsEmpty) {
                    int size4 = arrayListD.size();
                    while (i3 < size4) {
                        Object obj4 = arrayListD.get(i3);
                        i3++;
                        y.o oVar = (y.o) obj4;
                        pVarT2.m(oVar.f5999a, 1);
                        pVarT2.j(oVar.f5999a, -1L);
                    }
                }
                WorkDatabase_Impl workDatabase_Impl2 = (WorkDatabase_Impl) mVarS.f5993c;
                workDatabase_Impl2.b();
                y.h hVar = (y.h) mVarS.f5995e;
                k.i iVarA = hVar.a();
                workDatabase_Impl2.c();
                try {
                    iVarA.d();
                    workDatabase_Impl2.o();
                    workDatabase_Impl2.k();
                    hVar.m(iVarA);
                    workDatabase2.o();
                    workDatabase2.k();
                    if (zIsEmpty && !z3) {
                        z2 = false;
                    }
                    Long lG = qVar.f3061g.f6244a.l().g("reschedule_needed");
                    String str2 = f6236g;
                    if (lG != null && lG.longValue() == 1) {
                        p.m.d().a(str2, "Rescheduling Workers.");
                        qVar.d();
                        f fVar2 = qVar.f3061g;
                        fVar2.getClass();
                        fVar2.f6244a.l().h(new y.d("reschedule_needed", 0L));
                        return;
                    }
                    try {
                        int i7 = Build.VERSION.SDK_INT >= 31 ? 570425344 : 536870912;
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(context, (Class<?>) ForceStopRunnable$BroadcastReceiver.class));
                        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
                        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i7);
                        if (broadcast != null) {
                            broadcast.cancel();
                        }
                        List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) context.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                        if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                            Long lG2 = fVar.f6244a.l().g("last_force_stop_ms");
                            long jLongValue = lG2 != null ? lG2.longValue() : 0L;
                            for (int i8 = 0; i8 < historicalProcessExitReasons.size(); i8++) {
                                ApplicationExitInfo applicationExitInfo = historicalProcessExitReasons.get(i8);
                                if (applicationExitInfo.getReason() == 10 && applicationExitInfo.getTimestamp() >= jLongValue) {
                                    p.m.d().a(str2, "Application was force-stopped, rescheduling.");
                                    qVar.d();
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    fVar.getClass();
                                    fVar.f6244a.l().h(new y.d("last_force_stop_ms", Long.valueOf(jCurrentTimeMillis)));
                                    return;
                                }
                            }
                        }
                        if (z2) {
                            p.m.d().a(str2, "Found unfinished work, scheduling it.");
                            q.k.a(qVar.f3056b, qVar.f3057c, qVar.f3059e);
                        }
                    } catch (IllegalArgumentException | SecurityException e3) {
                        if (p.m.d().f2856a <= 5) {
                            Log.w(str2, "Ignoring exception", e3);
                        }
                    }
                } catch (Throwable th2) {
                    workDatabase_Impl2.k();
                    hVar.m(iVarA);
                    throw th2;
                }
            } catch (Throwable th3) {
                workDatabase2.k();
                throw th3;
            }
        } catch (Throwable th4) {
            cursorM.close();
            kVarY.z();
            throw th4;
        }
    }

    public final boolean b() {
        this.f6239d.f3056b.getClass();
        boolean zIsEmpty = TextUtils.isEmpty(null);
        String str = f6236g;
        if (zIsEmpty) {
            p.m.d().a(str, "The default process name was not specified.");
            return true;
        }
        int i3 = k.f6246a;
        Context context = this.f6238c;
        context.getClass();
        boolean zA = q1.e.a(a.f6228a.a(), context.getApplicationInfo().processName);
        p.m.d().a(str, "Is default app process = " + zA);
        return zA;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = f6236g;
        q.q qVar = this.f6239d;
        try {
            if (!b()) {
                qVar.c();
                return;
            }
            while (true) {
                try {
                    m0.a.l(this.f6238c);
                    p.m.d().a(str, "Performing cleanup operations.");
                    try {
                        a();
                        qVar.c();
                        return;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteTableLockedException e3) {
                        int i3 = this.f6241f + 1;
                        this.f6241f = i3;
                        if (i3 >= 3) {
                            p.m.d().c(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e3);
                            IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e3);
                            qVar.f3056b.getClass();
                            throw illegalStateException;
                        }
                        long j3 = ((long) i3) * 300;
                        String str2 = "Retrying after " + j3;
                        if (p.m.d().f2856a <= 3) {
                            Log.d(str, str2, e3);
                        }
                        try {
                            Thread.sleep(((long) this.f6241f) * 300);
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (SQLiteException e4) {
                    p.m.d().b(str, "Unexpected SQLite exception during migrations");
                    IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e4);
                    qVar.f3056b.getClass();
                    throw illegalStateException2;
                }
            }
        } catch (Throwable th) {
            qVar.c();
            throw th;
        }
    }
}
