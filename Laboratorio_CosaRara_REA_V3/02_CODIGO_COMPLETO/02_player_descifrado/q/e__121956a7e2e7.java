// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends h.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f3006d = new e(11, 12, 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f3007e = new e(12, 13, 1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f3008f = new e(15, 16, 2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f3009g = new e(1, 2, 3);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f3010h = new e(3, 4, 4);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f3011i = new e(4, 5, 5);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f3012j = new e(6, 7, 6);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f3013k = new e(7, 8, 7);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e f3014l = new e(8, 9, 8);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3015c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e() {
        super(14, 15);
        this.f3015c = 10;
    }

    @Override // h.a
    public final void a(k.c cVar) {
        switch (this.f3015c) {
            case 0:
                cVar.f2373c.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
                return;
            case 1:
                SQLiteDatabase sQLiteDatabase = cVar.f2373c;
                sQLiteDatabase.execSQL("UPDATE workspec SET required_network_type = 0 WHERE required_network_type IS NULL ");
                sQLiteDatabase.execSQL("UPDATE workspec SET content_uri_triggers = x'' WHERE content_uri_triggers is NULL");
                return;
            case 2:
                SQLiteDatabase sQLiteDatabase2 = cVar.f2373c;
                sQLiteDatabase2.execSQL("DELETE FROM SystemIdInfo WHERE work_spec_id IN (SELECT work_spec_id FROM SystemIdInfo LEFT JOIN WorkSpec ON work_spec_id = id WHERE WorkSpec.id IS NULL)");
                sQLiteDatabase2.execSQL("ALTER TABLE `WorkSpec` ADD COLUMN `generation` INTEGER NOT NULL DEFAULT 0");
                sQLiteDatabase2.execSQL("CREATE TABLE IF NOT EXISTS `_new_SystemIdInfo` (\n            `work_spec_id` TEXT NOT NULL, \n            `generation` INTEGER NOT NULL DEFAULT 0, \n            `system_id` INTEGER NOT NULL, \n            PRIMARY KEY(`work_spec_id`, `generation`), \n            FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) \n                ON UPDATE CASCADE ON DELETE CASCADE )");
                sQLiteDatabase2.execSQL("INSERT INTO `_new_SystemIdInfo` (`work_spec_id`,`system_id`) SELECT `work_spec_id`,`system_id` FROM `SystemIdInfo`");
                sQLiteDatabase2.execSQL("DROP TABLE `SystemIdInfo`");
                sQLiteDatabase2.execSQL("ALTER TABLE `_new_SystemIdInfo` RENAME TO `SystemIdInfo`");
                return;
            case 3:
                SQLiteDatabase sQLiteDatabase3 = cVar.f2373c;
                sQLiteDatabase3.execSQL("\n    CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id`\n    INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`)\n    REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )\n    ");
                sQLiteDatabase3.execSQL("\n    INSERT INTO SystemIdInfo(work_spec_id, system_id)\n    SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo\n    ");
                sQLiteDatabase3.execSQL("DROP TABLE IF EXISTS alarmInfo");
                sQLiteDatabase3.execSQL("\n                INSERT OR IGNORE INTO worktag(tag, work_spec_id)\n                SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec\n                ");
                return;
            case 4:
                cVar.f2373c.execSQL("\n    UPDATE workspec SET schedule_requested_at = 0\n    WHERE state NOT IN (2, 3, 5)\n        AND schedule_requested_at = -1\n        AND interval_duration <> 0\n    ");
                return;
            case 5:
                SQLiteDatabase sQLiteDatabase4 = cVar.f2373c;
                sQLiteDatabase4.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
                sQLiteDatabase4.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
                return;
            case 6:
                cVar.f2373c.execSQL("\n    CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress`\n    BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`)\n    REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )\n    ");
                return;
            case 7:
                cVar.f2373c.execSQL("\n    CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec`(`period_start_time`)\n    ");
                return;
            case 8:
                cVar.f2373c.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
                return;
            case 9:
                SQLiteDatabase sQLiteDatabase5 = cVar.f2373c;
                sQLiteDatabase5.execSQL("CREATE TABLE IF NOT EXISTS `_new_WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
                sQLiteDatabase5.execSQL("INSERT INTO `_new_WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) SELECT `id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers` FROM `WorkSpec`");
                sQLiteDatabase5.execSQL("DROP TABLE `WorkSpec`");
                sQLiteDatabase5.execSQL("ALTER TABLE `_new_WorkSpec` RENAME TO `WorkSpec`");
                sQLiteDatabase5.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                sQLiteDatabase5.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
                return;
            default:
                SQLiteDatabase sQLiteDatabase6 = cVar.f2373c;
                sQLiteDatabase6.execSQL("CREATE TABLE IF NOT EXISTS `_new_WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
                sQLiteDatabase6.execSQL("INSERT INTO `_new_WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) SELECT `id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers` FROM `WorkSpec`");
                sQLiteDatabase6.execSQL("DROP TABLE `WorkSpec`");
                sQLiteDatabase6.execSQL("ALTER TABLE `_new_WorkSpec` RENAME TO `WorkSpec`");
                sQLiteDatabase6.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                sQLiteDatabase6.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
                sQLiteDatabase6.execSQL("UPDATE workspec SET period_count = 1 WHERE last_enqueue_time <> 0 AND interval_duration <> 0");
                ContentValues contentValues = new ContentValues(1);
                contentValues.put("last_enqueue_time", Long.valueOf(System.currentTimeMillis()));
                Object[] objArr = new Object[0];
                cVar.getClass();
                if (contentValues.size() == 0) {
                    o2.i("Empty values");
                    return;
                }
                int size = contentValues.size();
                int length = objArr.length + size;
                Object[] objArr2 = new Object[length];
                StringBuilder sb = new StringBuilder("UPDATE ");
                sb.append(k.c.f2371e[3]);
                sb.append("WorkSpec SET ");
                int i3 = 0;
                for (String str : contentValues.keySet()) {
                    sb.append(i3 > 0 ? "," : "");
                    sb.append(str);
                    objArr2[i3] = contentValues.get(str);
                    sb.append("=?");
                    i3++;
                }
                for (int i4 = size; i4 < length; i4++) {
                    objArr2[i4] = objArr[i4 - size];
                }
                if (!TextUtils.isEmpty("last_enqueue_time = 0 AND interval_duration <> 0 ")) {
                    sb.append(" WHERE last_enqueue_time = 0 AND interval_duration <> 0 ");
                }
                k.i iVarY = cVar.y(sb.toString());
                int length2 = objArr2.length;
                int i5 = 0;
                while (i5 < length2) {
                    Object obj = objArr2[i5];
                    i5++;
                    if (obj == null) {
                        iVarY.l(i5);
                    } else if (obj instanceof byte[]) {
                        iVarY.j(i5, (byte[]) obj);
                    } else if (obj instanceof Float) {
                        iVarY.o(i5, ((Number) obj).floatValue());
                    } else if (obj instanceof Double) {
                        iVarY.o(i5, ((Number) obj).doubleValue());
                    } else if (obj instanceof Long) {
                        iVarY.h(i5, ((Number) obj).longValue());
                    } else if (obj instanceof Integer) {
                        iVarY.h(i5, ((Number) obj).intValue());
                    } else if (obj instanceof Short) {
                        iVarY.h(i5, ((Number) obj).shortValue());
                    } else if (obj instanceof Byte) {
                        iVarY.h(i5, ((Number) obj).byteValue());
                    } else if (obj instanceof String) {
                        iVarY.m((String) obj, i5);
                    } else {
                        if (!(obj instanceof Boolean)) {
                            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i5 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
                        }
                        iVarY.h(i5, ((Boolean) obj).booleanValue() ? 1L : 0L);
                    }
                }
                iVarY.f2395d.executeUpdateDelete();
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i3, int i4, int i5) {
        super(i3, i4);
        this.f3015c = i5;
    }
}
