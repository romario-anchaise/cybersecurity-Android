// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

import androidx.work.impl.WorkDatabase;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c.i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f5970d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(WorkDatabase workDatabase) {
        super(workDatabase);
        this.f5970d = 1;
        workDatabase.getClass();
    }

    @Override // c.i
    public final String k() {
        switch (this.f5970d) {
            case 0:
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            case 1:
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            case 2:
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
            case 3:
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            case 4:
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            case 5:
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            default:
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public final void o(k.i iVar, Object obj) throws Throwable {
        int i3;
        switch (this.f5970d) {
            case 0:
                a aVar = (a) obj;
                iVar.m(aVar.f5968a, 1);
                String str = aVar.f5969b;
                if (str == null) {
                    iVar.l(2);
                    return;
                } else {
                    iVar.m(str, 2);
                    return;
                }
            case 1:
                d dVar = (d) obj;
                iVar.m(dVar.f5974a, 1);
                iVar.h(2, dVar.f5975b.longValue());
                return;
            case 2:
                g gVar = (g) obj;
                String str2 = gVar.f5979a;
                if (str2 == null) {
                    iVar.l(1);
                } else {
                    iVar.m(str2, 1);
                }
                iVar.h(2, gVar.f5980b);
                iVar.h(3, gVar.f5981c);
                return;
            case 3:
                k kVar = (k) obj;
                String str3 = kVar.f5989a;
                if (str3 == null) {
                    iVar.l(1);
                } else {
                    iVar.m(str3, 1);
                }
                iVar.m(kVar.f5990b, 2);
                return;
            case 4:
                obj.getClass();
                throw new ClassCastException();
            case 5:
                o oVar = (o) obj;
                String str4 = oVar.f5999a;
                int i4 = 1;
                if (str4 == null) {
                    iVar.l(1);
                } else {
                    iVar.m(str4, 1);
                }
                iVar.h(2, q2.c.B(oVar.f6000b));
                String str5 = oVar.f6001c;
                if (str5 == null) {
                    iVar.l(3);
                } else {
                    iVar.m(str5, 3);
                }
                String str6 = oVar.f6002d;
                if (str6 == null) {
                    iVar.l(4);
                } else {
                    iVar.m(str6, 4);
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
                p.d dVar2 = oVar.f6008j;
                if (dVar2 != null) {
                    iVar.h(20, q2.c.w(dVar2.f2833a));
                    iVar.h(21, dVar2.f2834b ? 1L : 0L);
                    iVar.h(22, dVar2.f2835c ? 1L : 0L);
                    iVar.h(23, dVar2.f2836d ? 1L : 0L);
                    iVar.h(24, dVar2.f2837e ? 1L : 0L);
                    iVar.h(25, dVar2.f2838f);
                    iVar.h(26, dVar2.f2839g);
                    iVar.j(27, q2.c.A(dVar2.f2840h));
                    return;
                }
                iVar.l(20);
                iVar.l(21);
                iVar.l(22);
                iVar.l(23);
                iVar.l(24);
                iVar.l(25);
                iVar.l(26);
                iVar.l(27);
                return;
            default:
                q qVar = (q) obj;
                String str7 = qVar.f6030a;
                if (str7 == null) {
                    iVar.l(1);
                } else {
                    iVar.m(str7, 1);
                }
                String str8 = qVar.f6031b;
                if (str8 == null) {
                    iVar.l(2);
                    return;
                } else {
                    iVar.m(str8, 2);
                    return;
                }
        }
    }

    public final void p(Object obj) {
        k.i iVarA = a();
        try {
            o(iVarA, obj);
            iVarA.f2395d.executeInsert();
        } finally {
            m(iVarA);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(WorkDatabase workDatabase, int i3) {
        super(workDatabase);
        this.f5970d = i3;
    }
}
