// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import c0.b;
import g.k;
import java.util.ArrayList;
import p.d;
import p.e;
import p.j;
import p.m;
import q.q;
import q2.c;
import y.i;
import y.l;
import y.o;
import y.p;
import y.r;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
    }

    @Override // androidx.work.Worker
    public final j g() throws Throwable {
        k kVar;
        i iVar;
        l lVar;
        r rVar;
        WorkDatabase workDatabase = q.a(this.f2850a).f3057c;
        workDatabase.getClass();
        p pVarT = workDatabase.t();
        l lVarR = workDatabase.r();
        r rVarU = workDatabase.u();
        i iVarP = workDatabase.p();
        long jCurrentTimeMillis = System.currentTimeMillis() - 86400000;
        pVarT.getClass();
        k kVarY = k.y("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        kVarY.h(1, jCurrentTimeMillis);
        WorkDatabase_Impl workDatabase_Impl = pVarT.f6018a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(kVarY);
        try {
            int iM = c.m(cursorM, "id");
            int iM2 = c.m(cursorM, "state");
            int iM3 = c.m(cursorM, "worker_class_name");
            int iM4 = c.m(cursorM, "input_merger_class_name");
            int iM5 = c.m(cursorM, "input");
            int iM6 = c.m(cursorM, "output");
            int iM7 = c.m(cursorM, "initial_delay");
            int iM8 = c.m(cursorM, "interval_duration");
            int iM9 = c.m(cursorM, "flex_duration");
            int iM10 = c.m(cursorM, "run_attempt_count");
            int iM11 = c.m(cursorM, "backoff_policy");
            kVar = kVarY;
            try {
                int iM12 = c.m(cursorM, "backoff_delay_duration");
                int iM13 = c.m(cursorM, "last_enqueue_time");
                int iM14 = c.m(cursorM, "minimum_retention_duration");
                int iM15 = c.m(cursorM, "schedule_requested_at");
                int iM16 = c.m(cursorM, "run_in_foreground");
                int iM17 = c.m(cursorM, "out_of_quota_policy");
                int iM18 = c.m(cursorM, "period_count");
                int iM19 = c.m(cursorM, "generation");
                int iM20 = c.m(cursorM, "required_network_type");
                int iM21 = c.m(cursorM, "requires_charging");
                int iM22 = c.m(cursorM, "requires_device_idle");
                int iM23 = c.m(cursorM, "requires_battery_not_low");
                int iM24 = c.m(cursorM, "requires_storage_not_low");
                int iM25 = c.m(cursorM, "trigger_content_update_delay");
                int iM26 = c.m(cursorM, "trigger_max_content_delay");
                int iM27 = c.m(cursorM, "content_uri_triggers");
                int i3 = iM14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorM.isNull(iM) ? null : cursorM.getString(iM);
                    int iQ = c.q(cursorM.getInt(iM2));
                    String string2 = cursorM.isNull(iM3) ? null : cursorM.getString(iM3);
                    String string3 = cursorM.isNull(iM4) ? null : cursorM.getString(iM4);
                    e eVarA = e.a(cursorM.isNull(iM5) ? null : cursorM.getBlob(iM5));
                    e eVarA2 = e.a(cursorM.isNull(iM6) ? null : cursorM.getBlob(iM6));
                    long j3 = cursorM.getLong(iM7);
                    long j4 = cursorM.getLong(iM8);
                    long j5 = cursorM.getLong(iM9);
                    int i4 = cursorM.getInt(iM10);
                    int iN = c.n(cursorM.getInt(iM11));
                    long j6 = cursorM.getLong(iM12);
                    long j7 = cursorM.getLong(iM13);
                    int i5 = i3;
                    long j8 = cursorM.getLong(i5);
                    int i6 = iM13;
                    int i7 = iM15;
                    long j9 = cursorM.getLong(i7);
                    iM15 = i7;
                    int i8 = iM16;
                    boolean z2 = cursorM.getInt(i8) != 0;
                    iM16 = i8;
                    int i9 = iM17;
                    int iP = c.p(cursorM.getInt(i9));
                    iM17 = i9;
                    int i10 = iM18;
                    int i11 = cursorM.getInt(i10);
                    iM18 = i10;
                    int i12 = iM19;
                    int i13 = cursorM.getInt(i12);
                    iM19 = i12;
                    int i14 = iM20;
                    int iO = c.o(cursorM.getInt(i14));
                    iM20 = i14;
                    int i15 = iM21;
                    boolean z3 = cursorM.getInt(i15) != 0;
                    iM21 = i15;
                    int i16 = iM22;
                    boolean z4 = cursorM.getInt(i16) != 0;
                    iM22 = i16;
                    int i17 = iM23;
                    boolean z5 = cursorM.getInt(i17) != 0;
                    iM23 = i17;
                    int i18 = iM24;
                    boolean z6 = cursorM.getInt(i18) != 0;
                    iM24 = i18;
                    int i19 = iM25;
                    long j10 = cursorM.getLong(i19);
                    iM25 = i19;
                    int i20 = iM26;
                    long j11 = cursorM.getLong(i20);
                    iM26 = i20;
                    int i21 = iM27;
                    if (!cursorM.isNull(i21)) {
                        blob = cursorM.getBlob(i21);
                    }
                    iM27 = i21;
                    arrayList.add(new o(string, iQ, string2, string3, eVarA, eVarA2, j3, j4, j5, new d(iO, z3, z4, z5, z6, j10, j11, c.c(blob)), i4, iN, j6, j7, j8, j9, z2, iP, i11, i13));
                    iM13 = i6;
                    i3 = i5;
                }
                cursorM.close();
                kVar.z();
                ArrayList arrayListD = pVarT.d();
                ArrayList arrayListB = pVarT.b();
                if (arrayList.isEmpty()) {
                    iVar = iVarP;
                    lVar = lVarR;
                    rVar = rVarU;
                } else {
                    m mVarD = m.d();
                    String str = b.f397a;
                    mVarD.e(str, "Recently completed work:\n\n");
                    iVar = iVarP;
                    lVar = lVarR;
                    rVar = rVarU;
                    m.d().e(str, b.a(lVar, rVar, iVar, arrayList));
                }
                if (!arrayListD.isEmpty()) {
                    m mVarD2 = m.d();
                    String str2 = b.f397a;
                    mVarD2.e(str2, "Running work:\n\n");
                    m.d().e(str2, b.a(lVar, rVar, iVar, arrayListD));
                }
                if (!arrayListB.isEmpty()) {
                    m mVarD3 = m.d();
                    String str3 = b.f397a;
                    mVarD3.e(str3, "Enqueued work:\n\n");
                    m.d().e(str3, b.a(lVar, rVar, iVar, arrayListB));
                }
                return new j(e.f2842c);
            } catch (Throwable th) {
                th = th;
                cursorM.close();
                kVar.z();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            kVar = kVarY;
        }
    }
}
