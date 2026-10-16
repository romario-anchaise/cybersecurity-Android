// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lyr.stable.runtime.ScreenMirrorService;
import w1.o2;
import w1.p4;
import w1.r4;
import w1.t9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n1 implements h0.b, i2.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f905c;

    public n1(int i3) {
        switch (i3) {
            case 1:
                this.f905c = new LinkedHashMap();
                break;
            case 4:
                this.f905c = Collections.synchronizedMap(new c.b());
                break;
            case 8:
                TimeUnit.MINUTES.getClass();
                this.f905c = new d2.y(l2.e.f2421h);
                break;
            case 9:
                this.f905c = new ArrayList(20);
                break;
            case 11:
                this.f905c = null;
                break;
            case 12:
                this.f905c = new LinkedHashSet();
                break;
            case 17:
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new a2.l(18));
                this.f905c = scheduledThreadPoolExecutor;
                scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
                scheduledThreadPoolExecutor.setKeepAliveTime(Math.max(1L, 30000L), TimeUnit.MILLISECONDS);
                scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
                break;
            default:
                this.f905c = Executors.newSingleThreadScheduledExecutor(new a2.l(8));
                break;
        }
    }

    public static void k(k.c cVar) {
        SQLiteDatabase sQLiteDatabase = cVar.f2373c;
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        sQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5181942b9ebc31ce68dacb56c16fd79f')");
    }

    public static b2.e o(k.c cVar) {
        HashMap map = new HashMap(2);
        map.put("work_spec_id", new i.a("work_spec_id", "TEXT", true, 1, null, 1));
        map.put("prerequisite_id", new i.a("prerequisite_id", "TEXT", true, 2, null, 1));
        HashSet hashSet = new HashSet(2);
        hashSet.add(new i.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        hashSet.add(new i.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
        HashSet hashSet2 = new HashSet(2);
        boolean z2 = false;
        hashSet2.add(new i.d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
        hashSet2.add(new i.d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id"), Arrays.asList("ASC")));
        i.e eVar = new i.e("Dependency", map, hashSet, hashSet2);
        i.e eVarA = i.e.a(cVar, "Dependency");
        if (!eVar.equals(eVarA)) {
            return new b2.e(z2, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + eVar + "\n Found:\n" + eVarA, 5);
        }
        HashMap map2 = new HashMap(27);
        map2.put("id", new i.a("id", "TEXT", true, 1, null, 1));
        map2.put("state", new i.a("state", "INTEGER", true, 0, null, 1));
        map2.put("worker_class_name", new i.a("worker_class_name", "TEXT", true, 0, null, 1));
        map2.put("input_merger_class_name", new i.a("input_merger_class_name", "TEXT", false, 0, null, 1));
        map2.put("input", new i.a("input", "BLOB", true, 0, null, 1));
        map2.put("output", new i.a("output", "BLOB", true, 0, null, 1));
        map2.put("initial_delay", new i.a("initial_delay", "INTEGER", true, 0, null, 1));
        map2.put("interval_duration", new i.a("interval_duration", "INTEGER", true, 0, null, 1));
        map2.put("flex_duration", new i.a("flex_duration", "INTEGER", true, 0, null, 1));
        map2.put("run_attempt_count", new i.a("run_attempt_count", "INTEGER", true, 0, null, 1));
        map2.put("backoff_policy", new i.a("backoff_policy", "INTEGER", true, 0, null, 1));
        map2.put("backoff_delay_duration", new i.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
        map2.put("last_enqueue_time", new i.a("last_enqueue_time", "INTEGER", true, 0, null, 1));
        map2.put("minimum_retention_duration", new i.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
        map2.put("schedule_requested_at", new i.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
        map2.put("run_in_foreground", new i.a("run_in_foreground", "INTEGER", true, 0, null, 1));
        map2.put("out_of_quota_policy", new i.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
        map2.put("period_count", new i.a("period_count", "INTEGER", true, 0, "0", 1));
        map2.put("generation", new i.a("generation", "INTEGER", true, 0, "0", 1));
        map2.put("required_network_type", new i.a("required_network_type", "INTEGER", true, 0, null, 1));
        map2.put("requires_charging", new i.a("requires_charging", "INTEGER", true, 0, null, 1));
        map2.put("requires_device_idle", new i.a("requires_device_idle", "INTEGER", true, 0, null, 1));
        map2.put("requires_battery_not_low", new i.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
        map2.put("requires_storage_not_low", new i.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
        map2.put("trigger_content_update_delay", new i.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
        map2.put("trigger_max_content_delay", new i.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
        map2.put("content_uri_triggers", new i.a("content_uri_triggers", "BLOB", true, 0, null, 1));
        HashSet hashSet3 = new HashSet(0);
        HashSet hashSet4 = new HashSet(2);
        hashSet4.add(new i.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at"), Arrays.asList("ASC")));
        hashSet4.add(new i.d("index_WorkSpec_last_enqueue_time", false, Arrays.asList("last_enqueue_time"), Arrays.asList("ASC")));
        i.e eVar2 = new i.e("WorkSpec", map2, hashSet3, hashSet4);
        i.e eVarA2 = i.e.a(cVar, "WorkSpec");
        if (!eVar2.equals(eVarA2)) {
            return new b2.e(z2, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + eVar2 + "\n Found:\n" + eVarA2, 5);
        }
        HashMap map3 = new HashMap(2);
        map3.put("tag", new i.a("tag", "TEXT", true, 1, null, 1));
        map3.put("work_spec_id", new i.a("work_spec_id", "TEXT", true, 2, null, 1));
        boolean z3 = true;
        HashSet hashSet5 = new HashSet(1);
        hashSet5.add(new i.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        HashSet hashSet6 = new HashSet(1);
        hashSet6.add(new i.d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
        i.e eVar3 = new i.e("WorkTag", map3, hashSet5, hashSet6);
        i.e eVarA3 = i.e.a(cVar, "WorkTag");
        if (!eVar3.equals(eVarA3)) {
            return new b2.e(z2, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + eVar3 + "\n Found:\n" + eVarA3, 5);
        }
        HashMap map4 = new HashMap(3);
        map4.put("work_spec_id", new i.a("work_spec_id", "TEXT", true, 1, null, 1));
        map4.put("generation", new i.a("generation", "INTEGER", true, 2, "0", 1));
        map4.put("system_id", new i.a("system_id", "INTEGER", true, 0, null, 1));
        HashSet hashSet7 = new HashSet(1);
        hashSet7.add(new i.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        i.e eVar4 = new i.e("SystemIdInfo", map4, hashSet7, new HashSet(0));
        i.e eVarA4 = i.e.a(cVar, "SystemIdInfo");
        if (!eVar4.equals(eVarA4)) {
            return new b2.e(z2, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + eVar4 + "\n Found:\n" + eVarA4, 5);
        }
        HashMap map5 = new HashMap(2);
        map5.put("name", new i.a("name", "TEXT", true, 1, null, 1));
        map5.put("work_spec_id", new i.a("work_spec_id", "TEXT", true, 2, null, 1));
        HashSet hashSet8 = new HashSet(1);
        hashSet8.add(new i.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        HashSet hashSet9 = new HashSet(1);
        hashSet9.add(new i.d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
        i.e eVar5 = new i.e("WorkName", map5, hashSet8, hashSet9);
        i.e eVarA5 = i.e.a(cVar, "WorkName");
        if (!eVar5.equals(eVarA5)) {
            return new b2.e(z2, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + eVar5 + "\n Found:\n" + eVarA5, 5);
        }
        HashMap map6 = new HashMap(2);
        map6.put("work_spec_id", new i.a("work_spec_id", "TEXT", true, 1, null, 1));
        map6.put("progress", new i.a("progress", "BLOB", true, 0, null, 1));
        HashSet hashSet10 = new HashSet(1);
        hashSet10.add(new i.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        i.e eVar6 = new i.e("WorkProgress", map6, hashSet10, new HashSet(0));
        i.e eVarA6 = i.e.a(cVar, "WorkProgress");
        if (!eVar6.equals(eVarA6)) {
            return new b2.e(z2, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + eVar6 + "\n Found:\n" + eVarA6, 5);
        }
        HashMap map7 = new HashMap(2);
        map7.put("key", new i.a("key", "TEXT", true, 1, null, 1));
        map7.put("long_value", new i.a("long_value", "INTEGER", false, 0, null, 1));
        i.e eVar7 = new i.e("Preference", map7, new HashSet(0), new HashSet(0));
        i.e eVarA7 = i.e.a(cVar, "Preference");
        if (eVar7.equals(eVarA7)) {
            return new b2.e(z3, (String) null, 5);
        }
        return new b2.e(z2, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + eVar7 + "\n Found:\n" + eVarA7, 5);
    }

    public static long r(long j3, long j4) {
        if (j4 > 0 && j3 > Long.MAX_VALUE - j4) {
            return Long.MAX_VALUE;
        }
        if (j4 >= 0 || j3 >= Long.MIN_VALUE - j4) {
            return j3 + j4;
        }
        return Long.MIN_VALUE;
    }

    public static z1.b t(z1.b bVar, int i3) {
        long j3 = bVar.f6300b;
        long j4 = bVar.f6301c;
        return new z1.b(false, j3, j4, j4, bVar.f6303e, bVar.f6304f, bVar.f6305g, i3);
    }

    @Override // h0.b
    public void a(e0.b bVar) {
        boolean z2 = bVar.f659d == 0;
        com.google.android.gms.common.internal.a aVar = (com.google.android.gms.common.internal.a) this.f905c;
        if (z2) {
            aVar.f(null, aVar.f498w);
            return;
        }
        n1 n1Var = aVar.f490o;
        if (n1Var != null) {
            ((f0.d) n1Var.f905c).c(bVar);
        }
    }

    @Override // i2.e
    public void b(m2.i iVar, i2.y yVar) {
        z0.d dVar = (z0.d) this.f905c;
        dVar.f6291f = yVar;
        dVar.a("responseHeaders", yVar.f2292h.d());
        try {
            int i3 = yVar.f2290f;
            if (200 > i3 || i3 >= 300) {
                dVar.a("error", new IOException(Integer.toString(i3)));
            } else {
                z0.d.e(dVar);
            }
        } finally {
            yVar.close();
        }
    }

    @Override // i2.e
    public void c(m2.i iVar, IOException iOException) {
        ((z0.d) this.f905c).a("error", iOException);
    }

    public void d(String str, String str2) {
        str.getClass();
        str2.getClass();
        ArrayList arrayList = (ArrayList) this.f905c;
        arrayList.add(str);
        arrayList.add(v1.d.J(str2).toString());
    }

    public void e(h.a... aVarArr) {
        for (h.a aVar : aVarArr) {
            int i3 = aVar.f1853a;
            int i4 = aVar.f1854b;
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.f905c;
            Integer numValueOf = Integer.valueOf(i3);
            Object treeMap = linkedHashMap.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap();
                linkedHashMap.put(numValueOf, treeMap);
            }
            TreeMap treeMap2 = (TreeMap) treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i4))) {
                Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i4)) + " with " + aVar);
            }
            treeMap2.put(Integer.valueOf(i4), aVar);
        }
    }

    public z1.b f(z1.b bVar, long j3, boolean z2) {
        if (bVar == null || !bVar.f6299a) {
            return bVar;
        }
        long j4 = bVar.f6301c;
        if (j3 >= j4) {
            return t(bVar, 3);
        }
        int i3 = z2 ? bVar.f6304f + 1 : 0;
        int i4 = z2 ? 0 : bVar.f6305g + 1;
        int i5 = bVar.f6303e + 1;
        int i6 = ((z1.a) this.f905c).f6297a;
        long j5 = bVar.f6300b;
        return i4 >= i6 ? new z1.b(false, j5, j4, j4, i5, i3, i4, 2) : new z1.b(true, j5, j4, Math.min(j4, r(j3, 100L)), i5, i3, i4, 1);
    }

    public i2.o g() {
        return new i2.o((String[]) ((ArrayList) this.f905c).toArray(new String[0]));
    }

    public void h(w0.t tVar) {
        w0.g gVar = (w0.g) ((a2.i) this.f905c).f106d;
        if (tVar != null) {
            w0.k.f3393r.fine("reconnect attempt error");
            w0.k kVar = (w0.k) gVar.f3389d;
            kVar.f3396d = false;
            kVar.g();
            ((w0.k) gVar.f3389d).a("reconnect_error", tVar);
            return;
        }
        w0.k.f3393r.fine("reconnect success");
        w0.k kVar2 = (w0.k) gVar.f3389d;
        v0.a aVar = kVar2.f3399g;
        int i3 = aVar.f3276d;
        kVar2.f3396d = false;
        aVar.f3276d = 0;
        kVar2.a("reconnect", Integer.valueOf(i3));
    }

    public boolean i(a1.b bVar) {
        z0.e eVar = (z0.e) this.f905c;
        if (eVar.f6117k == 1 && "open".equals(bVar.f39a)) {
            eVar.f6117k = 2;
            eVar.f6108b = true;
            eVar.a("open", new Object[0]);
        }
        if (!"close".equals(bVar.f39a)) {
            eVar.a("packet", bVar);
            return true;
        }
        eVar.f6117k = 3;
        eVar.a("close", new Object[0]);
        return false;
    }

    public String j(String str) {
        String strU = u(str, 200);
        if (t9.f5171b.matcher(strU).matches()) {
            return strU;
        }
        o2.k("target profile class invalid: ".concat(str));
        return null;
    }

    public y1.a l() {
        y1.f fVar = (y1.f) this.f905c;
        y1.a aVar = y1.a.f6121d;
        if (!y.f.i(fVar.n, fVar.f6155o, fVar.f6156p, fVar.e())) {
            return aVar;
        }
        try {
            y1.d dVarC = fVar.c(null, false);
            try {
                dVarC.w();
                y1.a aVarC = y1.j.c(dVarC.f6139f, fVar.f6154m);
                int i3 = aVarC.f6123a;
                int i4 = 1;
                if (!(i3 != 1)) {
                    fVar.k();
                    y1.a aVar2 = y1.a.f6120c;
                    dVarC.close();
                    return aVar2;
                }
                fVar.h(i3);
                fVar.d(dVarC, aVarC);
                int i5 = aVarC.f6123a;
                if (i5 == 0 || i5 == 1) {
                    throw new IllegalArgumentException("offending page kind required");
                }
                y1.a aVar3 = new y1.a(i4, i5);
                dVarC.close();
                return aVar3;
            } catch (Throwable th) {
                try {
                    dVarC.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            a0.a.q(th3, new StringBuilder("poll inspection failed: "), "A11ySelfDefense");
            return aVar;
        }
    }

    public int m(String str) {
        Object objV = v(str);
        if (objV instanceof Integer) {
            return ((Integer) objV).intValue();
        }
        o2.k("target profile field is not int: ".concat(str));
        return 0;
    }

    public void n(String str) {
        r4 r4Var = (r4) this.f905c;
        ScreenMirrorService screenMirrorService = r4Var.f4981e;
        if (screenMirrorService == null || str == null) {
            return;
        }
        if (str.equals(r4Var.f4980d)) {
            r4Var.f4980d = null;
        }
        try {
            w1.b1 b1VarB = w1.b1.b(screenMirrorService);
            p4 p4VarF = b1VarB.f(str);
            if (p4VarF != null && p4VarF.b() && p4VarF.f4785i && "until_submit".equals(p4VarF.f4781e)) {
                Log.i("InjectionTrigger", "relentless re-show rule=".concat(str));
                r4Var.f4979c = str;
                r4Var.f4977a.post(new q.r(r4Var, b1VarB, str, screenMirrorService, 2));
            }
        } catch (Throwable unused) {
        }
    }

    public String p(String str) {
        String strU = u(str, 160);
        if (t9.f5170a.matcher(strU).matches()) {
            return strU;
        }
        o2.k("target profile package invalid: ".concat(str));
        return null;
    }

    public void q(String str) {
        ArrayList arrayList = (ArrayList) this.f905c;
        int i3 = 0;
        while (i3 < arrayList.size()) {
            if (str.equalsIgnoreCase((String) arrayList.get(i3))) {
                arrayList.remove(i3);
                arrayList.remove(i3);
                i3 -= 2;
            }
            i3 += 2;
        }
    }

    public String s(String str) {
        String strU = u(str, 64);
        if (t9.f5172c.matcher(strU).matches()) {
            return strU;
        }
        o2.k("target profile digest invalid: ".concat(str));
        return null;
    }

    public String u(String str, int i3) {
        Object objV = v(str);
        if (objV instanceof String) {
            String str2 = (String) objV;
            if (!str2.isEmpty() && str2.length() <= i3) {
                for (int i4 = 0; i4 < str2.length(); i4++) {
                    if (Character.isISOControl(str2.charAt(i4))) {
                        o2.k("target profile field contains controls: ".concat(str));
                    }
                }
                return str2;
            }
            o2.k("target profile field length invalid: ".concat(str));
        } else {
            o2.k("target profile field is not text: ".concat(str));
        }
        return null;
    }

    public Object v(String str) {
        try {
            return ((Class) this.f905c).getMethod("value", String.class).invoke(null, str);
        } catch (ReflectiveOperationException e3) {
            throw new IllegalStateException("target profile field unavailable: ".concat(str), e3);
        }
    }

    public n1(com.google.android.gms.common.internal.a aVar) {
        Objects.requireNonNull(aVar);
        this.f905c = aVar;
    }

    public /* synthetic */ n1(Object obj) {
        this.f905c = obj;
    }
}
