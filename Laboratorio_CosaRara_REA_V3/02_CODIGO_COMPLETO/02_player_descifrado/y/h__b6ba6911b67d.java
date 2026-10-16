// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

import androidx.work.impl.WorkDatabase;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends c.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f5982d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(WorkDatabase workDatabase, int i3) {
        super(workDatabase);
        this.f5982d = i3;
    }

    @Override // c.i
    public final String k() {
        switch (this.f5982d) {
            case 0:
                return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
            case 1:
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            case 2:
                return "DELETE from WorkProgress where work_spec_id=?";
            case 3:
                return "DELETE FROM WorkProgress";
            case 4:
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            case 5:
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            case 6:
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            case 7:
                return "UPDATE workspec SET generation=generation+1 WHERE id=?";
            case 8:
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
            case 9:
                return "DELETE FROM workspec WHERE id=?";
            case 10:
                return "UPDATE workspec SET state=? WHERE id=?";
            case 11:
                return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
            case 12:
                return "UPDATE workspec SET output=? WHERE id=?";
            case 13:
                return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
            case 14:
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            case 15:
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            default:
                return "DELETE FROM worktag WHERE work_spec_id=?";
        }
    }

    public void o(k.i iVar, Object obj) throws Throwable {
        int i3;
        o oVar = (o) obj;
        String str = oVar.f5999a;
        int i4 = 1;
        if (str == null) {
            iVar.l(1);
        } else {
            iVar.m(str, 1);
        }
        iVar.h(2, q2.c.B(oVar.f6000b));
        String str2 = oVar.f6001c;
        if (str2 == null) {
            iVar.l(3);
        } else {
            iVar.m(str2, 3);
        }
        String str3 = oVar.f6002d;
        if (str3 == null) {
            iVar.l(4);
        } else {
            iVar.m(str3, 4);
        }
        byte[] bArrB = p.e.b(oVar.f6003e);
        if (bArrB == null) {
            iVar.l(5);
        } else {
            iVar.j(5, bArrB);
        }
        byte[] bArrB2 = p.e.b(oVar.f6004f);
        if (bArrB2 == null) {
            iVar.l(6);
        } else {
            iVar.j(6, bArrB2);
        }
        iVar.h(7, oVar.f6005g);
        iVar.h(8, oVar.f6006h);
        iVar.h(9, oVar.f6007i);
        iVar.h(10, oVar.f6009k);
        int i5 = oVar.f6010l;
        if (i5 == 0) {
            throw null;
        }
        int iA = g.d.a(i5);
        if (iA == 0) {
            i3 = 0;
        } else {
            if (iA != 1) {
                throw new h1.a();
            }
            i3 = 1;
        }
        iVar.h(11, i3);
        iVar.h(12, oVar.f6011m);
        iVar.h(13, oVar.n);
        iVar.h(14, oVar.f6012o);
        iVar.h(15, oVar.f6013p);
        iVar.h(16, oVar.f6014q ? 1L : 0L);
        int i6 = oVar.f6015r;
        if (i6 == 0) {
            throw null;
        }
        int iA2 = g.d.a(i6);
        if (iA2 == 0) {
            i4 = 0;
        } else if (iA2 != 1) {
            throw new h1.a();
        }
        iVar.h(17, i4);
        iVar.h(18, oVar.f6016s);
        iVar.h(19, oVar.f6017t);
        p.d dVar = oVar.f6008j;
        if (dVar != null) {
            iVar.h(20, q2.c.w(dVar.f2833a));
            iVar.h(21, dVar.f2834b ? 1L : 0L);
            iVar.h(22, dVar.f2835c ? 1L : 0L);
            iVar.h(23, dVar.f2836d ? 1L : 0L);
            iVar.h(24, dVar.f2837e ? 1L : 0L);
            iVar.h(25, dVar.f2838f);
            iVar.h(26, dVar.f2839g);
            iVar.j(27, q2.c.A(dVar.f2840h));
        } else {
            iVar.l(20);
            iVar.l(21);
            iVar.l(22);
            iVar.l(23);
            iVar.l(24);
            iVar.l(25);
            iVar.l(26);
            iVar.l(27);
        }
        if (str == null) {
            iVar.l(28);
        } else {
            iVar.m(str, 28);
        }
    }
}
