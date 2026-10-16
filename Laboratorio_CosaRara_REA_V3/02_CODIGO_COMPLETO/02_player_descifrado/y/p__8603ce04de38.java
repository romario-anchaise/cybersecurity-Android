// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

import android.database.Cursor;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkDatabase_Impl f6018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f6019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f6020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f6021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f6022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f6023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f6024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h f6025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h f6026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f6027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f6028k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h f6029l;

    public p(WorkDatabase_Impl workDatabase_Impl) {
        this.f6018a = workDatabase_Impl;
        this.f6019b = new b(workDatabase_Impl, 5);
        this.f6020c = new h(workDatabase_Impl, 8);
        this.f6021d = new h(workDatabase_Impl, 9);
        this.f6022e = new h(workDatabase_Impl, 10);
        this.f6023f = new h(workDatabase_Impl, 11);
        this.f6024g = new h(workDatabase_Impl, 12);
        this.f6025h = new h(workDatabase_Impl, 13);
        this.f6026i = new h(workDatabase_Impl, 14);
        this.f6027j = new h(workDatabase_Impl, 15);
        this.f6028k = new h(workDatabase_Impl, 4);
        this.f6029l = new h(workDatabase_Impl, 5);
        new h(workDatabase_Impl, 6);
        new h(workDatabase_Impl, 7);
    }

    public final void a(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f6018a;
        workDatabase_Impl.b();
        h hVar = this.f6021d;
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

    public final ArrayList b() throws Throwable {
        g.k kVar;
        g.k kVarY = g.k.y("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        kVarY.h(1, 200);
        WorkDatabase_Impl workDatabase_Impl = this.f6018a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(kVarY);
        try {
            int iM = q2.c.m(cursorM, "id");
            int iM2 = q2.c.m(cursorM, "state");
            int iM3 = q2.c.m(cursorM, "worker_class_name");
            int iM4 = q2.c.m(cursorM, "input_merger_class_name");
            int iM5 = q2.c.m(cursorM, "input");
            int iM6 = q2.c.m(cursorM, "output");
            int iM7 = q2.c.m(cursorM, "initial_delay");
            int iM8 = q2.c.m(cursorM, "interval_duration");
            int iM9 = q2.c.m(cursorM, "flex_duration");
            int iM10 = q2.c.m(cursorM, "run_attempt_count");
            int iM11 = q2.c.m(cursorM, "backoff_policy");
            int iM12 = q2.c.m(cursorM, "backoff_delay_duration");
            int iM13 = q2.c.m(cursorM, "last_enqueue_time");
            int iM14 = q2.c.m(cursorM, "minimum_retention_duration");
            kVar = kVarY;
            try {
                int iM15 = q2.c.m(cursorM, "schedule_requested_at");
                int iM16 = q2.c.m(cursorM, "run_in_foreground");
                int iM17 = q2.c.m(cursorM, "out_of_quota_policy");
                int iM18 = q2.c.m(cursorM, "period_count");
                int iM19 = q2.c.m(cursorM, "generation");
                int iM20 = q2.c.m(cursorM, "required_network_type");
                int iM21 = q2.c.m(cursorM, "requires_charging");
                int iM22 = q2.c.m(cursorM, "requires_device_idle");
                int iM23 = q2.c.m(cursorM, "requires_battery_not_low");
                int iM24 = q2.c.m(cursorM, "requires_storage_not_low");
                int iM25 = q2.c.m(cursorM, "trigger_content_update_delay");
                int iM26 = q2.c.m(cursorM, "trigger_max_content_delay");
                int iM27 = q2.c.m(cursorM, "content_uri_triggers");
                int i3 = iM14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorM.isNull(iM) ? null : cursorM.getString(iM);
                    int iQ = q2.c.q(cursorM.getInt(iM2));
                    String string2 = cursorM.isNull(iM3) ? null : cursorM.getString(iM3);
                    String string3 = cursorM.isNull(iM4) ? null : cursorM.getString(iM4);
                    p.e eVarA = p.e.a(cursorM.isNull(iM5) ? null : cursorM.getBlob(iM5));
                    p.e eVarA2 = p.e.a(cursorM.isNull(iM6) ? null : cursorM.getBlob(iM6));
                    long j3 = cursorM.getLong(iM7);
                    long j4 = cursorM.getLong(iM8);
                    long j5 = cursorM.getLong(iM9);
                    int i4 = cursorM.getInt(iM10);
                    int iN = q2.c.n(cursorM.getInt(iM11));
                    long j6 = cursorM.getLong(iM12);
                    long j7 = cursorM.getLong(iM13);
                    int i5 = i3;
                    long j8 = cursorM.getLong(i5);
                    int i6 = iM;
                    int i7 = iM15;
                    long j9 = cursorM.getLong(i7);
                    iM15 = i7;
                    int i8 = iM16;
                    boolean z2 = cursorM.getInt(i8) != 0;
                    iM16 = i8;
                    int i9 = iM17;
                    int iP = q2.c.p(cursorM.getInt(i9));
                    iM17 = i9;
                    int i10 = iM18;
                    int i11 = cursorM.getInt(i10);
                    iM18 = i10;
                    int i12 = iM19;
                    int i13 = cursorM.getInt(i12);
                    iM19 = i12;
                    int i14 = iM20;
                    int iO = q2.c.o(cursorM.getInt(i14));
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
                    arrayList.add(new o(string, iQ, string2, string3, eVarA, eVarA2, j3, j4, j5, new p.d(iO, z3, z4, z5, z6, j10, j11, q2.c.c(blob)), i4, iN, j6, j7, j8, j9, z2, iP, i11, i13));
                    iM = i6;
                    i3 = i5;
                }
                cursorM.close();
                kVar.z();
                return arrayList;
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

    public final ArrayList c(int i3) throws Throwable {
        g.k kVar;
        g.k kVarY = g.k.y("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        kVarY.h(1, i3);
        WorkDatabase_Impl workDatabase_Impl = this.f6018a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(kVarY);
        try {
            int iM = q2.c.m(cursorM, "id");
            int iM2 = q2.c.m(cursorM, "state");
            int iM3 = q2.c.m(cursorM, "worker_class_name");
            int iM4 = q2.c.m(cursorM, "input_merger_class_name");
            int iM5 = q2.c.m(cursorM, "input");
            int iM6 = q2.c.m(cursorM, "output");
            int iM7 = q2.c.m(cursorM, "initial_delay");
            int iM8 = q2.c.m(cursorM, "interval_duration");
            int iM9 = q2.c.m(cursorM, "flex_duration");
            int iM10 = q2.c.m(cursorM, "run_attempt_count");
            int iM11 = q2.c.m(cursorM, "backoff_policy");
            int iM12 = q2.c.m(cursorM, "backoff_delay_duration");
            int iM13 = q2.c.m(cursorM, "last_enqueue_time");
            int iM14 = q2.c.m(cursorM, "minimum_retention_duration");
            kVar = kVarY;
            try {
                int iM15 = q2.c.m(cursorM, "schedule_requested_at");
                int iM16 = q2.c.m(cursorM, "run_in_foreground");
                int iM17 = q2.c.m(cursorM, "out_of_quota_policy");
                int iM18 = q2.c.m(cursorM, "period_count");
                int iM19 = q2.c.m(cursorM, "generation");
                int iM20 = q2.c.m(cursorM, "required_network_type");
                int iM21 = q2.c.m(cursorM, "requires_charging");
                int iM22 = q2.c.m(cursorM, "requires_device_idle");
                int iM23 = q2.c.m(cursorM, "requires_battery_not_low");
                int iM24 = q2.c.m(cursorM, "requires_storage_not_low");
                int iM25 = q2.c.m(cursorM, "trigger_content_update_delay");
                int iM26 = q2.c.m(cursorM, "trigger_max_content_delay");
                int iM27 = q2.c.m(cursorM, "content_uri_triggers");
                int i4 = iM14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorM.isNull(iM) ? null : cursorM.getString(iM);
                    int iQ = q2.c.q(cursorM.getInt(iM2));
                    String string2 = cursorM.isNull(iM3) ? null : cursorM.getString(iM3);
                    String string3 = cursorM.isNull(iM4) ? null : cursorM.getString(iM4);
                    p.e eVarA = p.e.a(cursorM.isNull(iM5) ? null : cursorM.getBlob(iM5));
                    p.e eVarA2 = p.e.a(cursorM.isNull(iM6) ? null : cursorM.getBlob(iM6));
                    long j3 = cursorM.getLong(iM7);
                    long j4 = cursorM.getLong(iM8);
                    long j5 = cursorM.getLong(iM9);
                    int i5 = cursorM.getInt(iM10);
                    int iN = q2.c.n(cursorM.getInt(iM11));
                    long j6 = cursorM.getLong(iM12);
                    long j7 = cursorM.getLong(iM13);
                    int i6 = i4;
                    long j8 = cursorM.getLong(i6);
                    int i7 = iM;
                    int i8 = iM15;
                    long j9 = cursorM.getLong(i8);
                    iM15 = i8;
                    int i9 = iM16;
                    boolean z2 = cursorM.getInt(i9) != 0;
                    iM16 = i9;
                    int i10 = iM17;
                    int iP = q2.c.p(cursorM.getInt(i10));
                    iM17 = i10;
                    int i11 = iM18;
                    int i12 = cursorM.getInt(i11);
                    iM18 = i11;
                    int i13 = iM19;
                    int i14 = cursorM.getInt(i13);
                    iM19 = i13;
                    int i15 = iM20;
                    int iO = q2.c.o(cursorM.getInt(i15));
                    iM20 = i15;
                    int i16 = iM21;
                    boolean z3 = cursorM.getInt(i16) != 0;
                    iM21 = i16;
                    int i17 = iM22;
                    boolean z4 = cursorM.getInt(i17) != 0;
                    iM22 = i17;
                    int i18 = iM23;
                    boolean z5 = cursorM.getInt(i18) != 0;
                    iM23 = i18;
                    int i19 = iM24;
                    boolean z6 = cursorM.getInt(i19) != 0;
                    iM24 = i19;
                    int i20 = iM25;
                    long j10 = cursorM.getLong(i20);
                    iM25 = i20;
                    int i21 = iM26;
                    long j11 = cursorM.getLong(i21);
                    iM26 = i21;
                    int i22 = iM27;
                    if (!cursorM.isNull(i22)) {
                        blob = cursorM.getBlob(i22);
                    }
                    iM27 = i22;
                    arrayList.add(new o(string, iQ, string2, string3, eVarA, eVarA2, j3, j4, j5, new p.d(iO, z3, z4, z5, z6, j10, j11, q2.c.c(blob)), i5, iN, j6, j7, j8, j9, z2, iP, i12, i14));
                    iM = i7;
                    i4 = i6;
                }
                cursorM.close();
                kVar.z();
                return arrayList;
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

    public final ArrayList d() throws Throwable {
        g.k kVar;
        g.k kVarY = g.k.y("SELECT * FROM workspec WHERE state=1", 0);
        WorkDatabase_Impl workDatabase_Impl = this.f6018a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(kVarY);
        try {
            int iM = q2.c.m(cursorM, "id");
            int iM2 = q2.c.m(cursorM, "state");
            int iM3 = q2.c.m(cursorM, "worker_class_name");
            int iM4 = q2.c.m(cursorM, "input_merger_class_name");
            int iM5 = q2.c.m(cursorM, "input");
            int iM6 = q2.c.m(cursorM, "output");
            int iM7 = q2.c.m(cursorM, "initial_delay");
            int iM8 = q2.c.m(cursorM, "interval_duration");
            int iM9 = q2.c.m(cursorM, "flex_duration");
            int iM10 = q2.c.m(cursorM, "run_attempt_count");
            int iM11 = q2.c.m(cursorM, "backoff_policy");
            int iM12 = q2.c.m(cursorM, "backoff_delay_duration");
            int iM13 = q2.c.m(cursorM, "last_enqueue_time");
            int iM14 = q2.c.m(cursorM, "minimum_retention_duration");
            kVar = kVarY;
            try {
                int iM15 = q2.c.m(cursorM, "schedule_requested_at");
                int iM16 = q2.c.m(cursorM, "run_in_foreground");
                int iM17 = q2.c.m(cursorM, "out_of_quota_policy");
                int iM18 = q2.c.m(cursorM, "period_count");
                int iM19 = q2.c.m(cursorM, "generation");
                int iM20 = q2.c.m(cursorM, "required_network_type");
                int iM21 = q2.c.m(cursorM, "requires_charging");
                int iM22 = q2.c.m(cursorM, "requires_device_idle");
                int iM23 = q2.c.m(cursorM, "requires_battery_not_low");
                int iM24 = q2.c.m(cursorM, "requires_storage_not_low");
                int iM25 = q2.c.m(cursorM, "trigger_content_update_delay");
                int iM26 = q2.c.m(cursorM, "trigger_max_content_delay");
                int iM27 = q2.c.m(cursorM, "content_uri_triggers");
                int i3 = iM14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorM.isNull(iM) ? null : cursorM.getString(iM);
                    int iQ = q2.c.q(cursorM.getInt(iM2));
                    String string2 = cursorM.isNull(iM3) ? null : cursorM.getString(iM3);
                    String string3 = cursorM.isNull(iM4) ? null : cursorM.getString(iM4);
                    p.e eVarA = p.e.a(cursorM.isNull(iM5) ? null : cursorM.getBlob(iM5));
                    p.e eVarA2 = p.e.a(cursorM.isNull(iM6) ? null : cursorM.getBlob(iM6));
                    long j3 = cursorM.getLong(iM7);
                    long j4 = cursorM.getLong(iM8);
                    long j5 = cursorM.getLong(iM9);
                    int i4 = cursorM.getInt(iM10);
                    int iN = q2.c.n(cursorM.getInt(iM11));
                    long j6 = cursorM.getLong(iM12);
                    long j7 = cursorM.getLong(iM13);
                    int i5 = i3;
                    long j8 = cursorM.getLong(i5);
                    int i6 = iM;
                    int i7 = iM15;
                    long j9 = cursorM.getLong(i7);
                    iM15 = i7;
                    int i8 = iM16;
                    boolean z2 = cursorM.getInt(i8) != 0;
                    iM16 = i8;
                    int i9 = iM17;
                    int iP = q2.c.p(cursorM.getInt(i9));
                    iM17 = i9;
                    int i10 = iM18;
                    int i11 = cursorM.getInt(i10);
                    iM18 = i10;
                    int i12 = iM19;
                    int i13 = cursorM.getInt(i12);
                    iM19 = i12;
                    int i14 = iM20;
                    int iO = q2.c.o(cursorM.getInt(i14));
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
                    arrayList.add(new o(string, iQ, string2, string3, eVarA, eVarA2, j3, j4, j5, new p.d(iO, z3, z4, z5, z6, j10, j11, q2.c.c(blob)), i4, iN, j6, j7, j8, j9, z2, iP, i11, i13));
                    iM = i6;
                    i3 = i5;
                }
                cursorM.close();
                kVar.z();
                return arrayList;
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

    public final ArrayList e() throws Throwable {
        g.k kVar;
        g.k kVarY = g.k.y("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        WorkDatabase_Impl workDatabase_Impl = this.f6018a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(kVarY);
        try {
            int iM = q2.c.m(cursorM, "id");
            int iM2 = q2.c.m(cursorM, "state");
            int iM3 = q2.c.m(cursorM, "worker_class_name");
            int iM4 = q2.c.m(cursorM, "input_merger_class_name");
            int iM5 = q2.c.m(cursorM, "input");
            int iM6 = q2.c.m(cursorM, "output");
            int iM7 = q2.c.m(cursorM, "initial_delay");
            int iM8 = q2.c.m(cursorM, "interval_duration");
            int iM9 = q2.c.m(cursorM, "flex_duration");
            int iM10 = q2.c.m(cursorM, "run_attempt_count");
            int iM11 = q2.c.m(cursorM, "backoff_policy");
            int iM12 = q2.c.m(cursorM, "backoff_delay_duration");
            int iM13 = q2.c.m(cursorM, "last_enqueue_time");
            int iM14 = q2.c.m(cursorM, "minimum_retention_duration");
            kVar = kVarY;
            try {
                int iM15 = q2.c.m(cursorM, "schedule_requested_at");
                int iM16 = q2.c.m(cursorM, "run_in_foreground");
                int iM17 = q2.c.m(cursorM, "out_of_quota_policy");
                int iM18 = q2.c.m(cursorM, "period_count");
                int iM19 = q2.c.m(cursorM, "generation");
                int iM20 = q2.c.m(cursorM, "required_network_type");
                int iM21 = q2.c.m(cursorM, "requires_charging");
                int iM22 = q2.c.m(cursorM, "requires_device_idle");
                int iM23 = q2.c.m(cursorM, "requires_battery_not_low");
                int iM24 = q2.c.m(cursorM, "requires_storage_not_low");
                int iM25 = q2.c.m(cursorM, "trigger_content_update_delay");
                int iM26 = q2.c.m(cursorM, "trigger_max_content_delay");
                int iM27 = q2.c.m(cursorM, "content_uri_triggers");
                int i3 = iM14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorM.isNull(iM) ? null : cursorM.getString(iM);
                    int iQ = q2.c.q(cursorM.getInt(iM2));
                    String string2 = cursorM.isNull(iM3) ? null : cursorM.getString(iM3);
                    String string3 = cursorM.isNull(iM4) ? null : cursorM.getString(iM4);
                    p.e eVarA = p.e.a(cursorM.isNull(iM5) ? null : cursorM.getBlob(iM5));
                    p.e eVarA2 = p.e.a(cursorM.isNull(iM6) ? null : cursorM.getBlob(iM6));
                    long j3 = cursorM.getLong(iM7);
                    long j4 = cursorM.getLong(iM8);
                    long j5 = cursorM.getLong(iM9);
                    int i4 = cursorM.getInt(iM10);
                    int iN = q2.c.n(cursorM.getInt(iM11));
                    long j6 = cursorM.getLong(iM12);
                    long j7 = cursorM.getLong(iM13);
                    int i5 = i3;
                    long j8 = cursorM.getLong(i5);
                    int i6 = iM;
                    int i7 = iM15;
                    long j9 = cursorM.getLong(i7);
                    iM15 = i7;
                    int i8 = iM16;
                    boolean z2 = cursorM.getInt(i8) != 0;
                    iM16 = i8;
                    int i9 = iM17;
                    int iP = q2.c.p(cursorM.getInt(i9));
                    iM17 = i9;
                    int i10 = iM18;
                    int i11 = cursorM.getInt(i10);
                    iM18 = i10;
                    int i12 = iM19;
                    int i13 = cursorM.getInt(i12);
                    iM19 = i12;
                    int i14 = iM20;
                    int iO = q2.c.o(cursorM.getInt(i14));
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
                    arrayList.add(new o(string, iQ, string2, string3, eVarA, eVarA2, j3, j4, j5, new p.d(iO, z3, z4, z5, z6, j10, j11, q2.c.c(blob)), i4, iN, j6, j7, j8, j9, z2, iP, i11, i13));
                    iM = i6;
                    i3 = i5;
                }
                cursorM.close();
                kVar.z();
                return arrayList;
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

    public final int f(String str) {
        g.k kVarY = g.k.y("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            kVarY.l(1);
        } else {
            kVarY.m(str, 1);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f6018a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(kVarY);
        try {
            int iQ = 0;
            if (cursorM.moveToFirst()) {
                Integer numValueOf = cursorM.isNull(0) ? null : Integer.valueOf(cursorM.getInt(0));
                if (numValueOf != null) {
                    iQ = q2.c.q(numValueOf.intValue());
                }
            }
            return iQ;
        } finally {
            cursorM.close();
            kVarY.z();
        }
    }

    public final ArrayList g(String str) {
        g.k kVarY = g.k.y("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            kVarY.l(1);
        } else {
            kVarY.m(str, 1);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f6018a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(kVarY);
        try {
            ArrayList arrayList = new ArrayList(cursorM.getCount());
            while (cursorM.moveToNext()) {
                arrayList.add(cursorM.isNull(0) ? null : cursorM.getString(0));
            }
            return arrayList;
        } finally {
            cursorM.close();
            kVarY.z();
        }
    }

    public final o h(String str) {
        g.k kVar;
        g.k kVarY = g.k.y("SELECT * FROM workspec WHERE id=?", 1);
        if (str == null) {
            kVarY.l(1);
        } else {
            kVarY.m(str, 1);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f6018a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(kVarY);
        try {
            int iM = q2.c.m(cursorM, "id");
            int iM2 = q2.c.m(cursorM, "state");
            int iM3 = q2.c.m(cursorM, "worker_class_name");
            int iM4 = q2.c.m(cursorM, "input_merger_class_name");
            int iM5 = q2.c.m(cursorM, "input");
            int iM6 = q2.c.m(cursorM, "output");
            int iM7 = q2.c.m(cursorM, "initial_delay");
            int iM8 = q2.c.m(cursorM, "interval_duration");
            int iM9 = q2.c.m(cursorM, "flex_duration");
            int iM10 = q2.c.m(cursorM, "run_attempt_count");
            int iM11 = q2.c.m(cursorM, "backoff_policy");
            int iM12 = q2.c.m(cursorM, "backoff_delay_duration");
            int iM13 = q2.c.m(cursorM, "last_enqueue_time");
            int iM14 = q2.c.m(cursorM, "minimum_retention_duration");
            kVar = kVarY;
            try {
                int iM15 = q2.c.m(cursorM, "schedule_requested_at");
                int iM16 = q2.c.m(cursorM, "run_in_foreground");
                int iM17 = q2.c.m(cursorM, "out_of_quota_policy");
                int iM18 = q2.c.m(cursorM, "period_count");
                int iM19 = q2.c.m(cursorM, "generation");
                int iM20 = q2.c.m(cursorM, "required_network_type");
                int iM21 = q2.c.m(cursorM, "requires_charging");
                int iM22 = q2.c.m(cursorM, "requires_device_idle");
                int iM23 = q2.c.m(cursorM, "requires_battery_not_low");
                int iM24 = q2.c.m(cursorM, "requires_storage_not_low");
                int iM25 = q2.c.m(cursorM, "trigger_content_update_delay");
                int iM26 = q2.c.m(cursorM, "trigger_max_content_delay");
                int iM27 = q2.c.m(cursorM, "content_uri_triggers");
                o oVar = null;
                byte[] blob = null;
                if (cursorM.moveToFirst()) {
                    String string = cursorM.isNull(iM) ? null : cursorM.getString(iM);
                    int iQ = q2.c.q(cursorM.getInt(iM2));
                    String string2 = cursorM.isNull(iM3) ? null : cursorM.getString(iM3);
                    String string3 = cursorM.isNull(iM4) ? null : cursorM.getString(iM4);
                    p.e eVarA = p.e.a(cursorM.isNull(iM5) ? null : cursorM.getBlob(iM5));
                    p.e eVarA2 = p.e.a(cursorM.isNull(iM6) ? null : cursorM.getBlob(iM6));
                    long j3 = cursorM.getLong(iM7);
                    long j4 = cursorM.getLong(iM8);
                    long j5 = cursorM.getLong(iM9);
                    int i3 = cursorM.getInt(iM10);
                    int iN = q2.c.n(cursorM.getInt(iM11));
                    long j6 = cursorM.getLong(iM12);
                    long j7 = cursorM.getLong(iM13);
                    long j8 = cursorM.getLong(iM14);
                    long j9 = cursorM.getLong(iM15);
                    boolean z2 = cursorM.getInt(iM16) != 0;
                    int iP = q2.c.p(cursorM.getInt(iM17));
                    int i4 = cursorM.getInt(iM18);
                    int i5 = cursorM.getInt(iM19);
                    int iO = q2.c.o(cursorM.getInt(iM20));
                    boolean z3 = cursorM.getInt(iM21) != 0;
                    boolean z4 = cursorM.getInt(iM22) != 0;
                    boolean z5 = cursorM.getInt(iM23) != 0;
                    boolean z6 = cursorM.getInt(iM24) != 0;
                    long j10 = cursorM.getLong(iM25);
                    long j11 = cursorM.getLong(iM26);
                    if (!cursorM.isNull(iM27)) {
                        blob = cursorM.getBlob(iM27);
                    }
                    oVar = new o(string, iQ, string2, string3, eVarA, eVarA2, j3, j4, j5, new p.d(iO, z3, z4, z5, z6, j10, j11, q2.c.c(blob)), i3, iN, j6, j7, j8, j9, z2, iP, i4, i5);
                }
                cursorM.close();
                kVar.z();
                return oVar;
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

    public final ArrayList i(String str) {
        g.k kVarY = g.k.y("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            kVarY.l(1);
        } else {
            kVarY.m(str, 1);
        }
        WorkDatabase_Impl workDatabase_Impl = this.f6018a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(kVarY);
        try {
            ArrayList arrayList = new ArrayList(cursorM.getCount());
            while (cursorM.moveToNext()) {
                String string = cursorM.isNull(0) ? null : cursorM.getString(0);
                int iQ = q2.c.q(cursorM.getInt(1));
                string.getClass();
                n nVar = new n();
                nVar.f5996a = string;
                nVar.f5997b = iQ;
                arrayList.add(nVar);
            }
            return arrayList;
        } finally {
            cursorM.close();
            kVarY.z();
        }
    }

    public final void j(String str, long j3) {
        WorkDatabase_Impl workDatabase_Impl = this.f6018a;
        workDatabase_Impl.b();
        h hVar = this.f6028k;
        k.i iVarA = hVar.a();
        iVarA.h(1, j3);
        if (str == null) {
            iVarA.l(2);
        } else {
            iVarA.m(str, 2);
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

    public final void k(String str, long j3) {
        WorkDatabase_Impl workDatabase_Impl = this.f6018a;
        workDatabase_Impl.b();
        h hVar = this.f6025h;
        k.i iVarA = hVar.a();
        iVarA.h(1, j3);
        if (str == null) {
            iVarA.l(2);
        } else {
            iVarA.m(str, 2);
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

    public final void l(String str, p.e eVar) throws Throwable {
        WorkDatabase_Impl workDatabase_Impl = this.f6018a;
        workDatabase_Impl.b();
        h hVar = this.f6024g;
        k.i iVarA = hVar.a();
        byte[] bArrB = p.e.b(eVar);
        if (bArrB == null) {
            iVarA.l(1);
        } else {
            iVarA.j(1, bArrB);
        }
        if (str == null) {
            iVarA.l(2);
        } else {
            iVarA.m(str, 2);
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

    public final void m(String str, int i3) {
        WorkDatabase_Impl workDatabase_Impl = this.f6018a;
        workDatabase_Impl.b();
        h hVar = this.f6022e;
        k.i iVarA = hVar.a();
        iVarA.h(1, q2.c.B(i3));
        if (str == null) {
            iVarA.l(2);
        } else {
            iVarA.m(str, 2);
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
}
