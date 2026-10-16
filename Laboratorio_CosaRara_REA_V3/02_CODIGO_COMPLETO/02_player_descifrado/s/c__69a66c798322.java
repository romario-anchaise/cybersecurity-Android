// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p.m;
import q.l;
import q.q;
import y.o;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements q.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f3188e = m.f("CommandHandler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f3190b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3191c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y.e f3192d;

    public c(Context context, y.e eVar) {
        this.f3189a = context;
        this.f3192d = eVar;
    }

    public static y.j c(Intent intent) {
        return new y.j(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static void d(Intent intent, y.j jVar) {
        intent.putExtra("KEY_WORKSPEC_ID", jVar.f5987a);
        intent.putExtra("KEY_WORKSPEC_GENERATION", jVar.f5988b);
    }

    public final void a(int i3, Intent intent, j jVar) throws Throwable {
        List<l> listI;
        ArrayList arrayList;
        String action = intent.getAction();
        int i4 = 0;
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            m.d().a(f3188e, "Handling constraints changed " + intent);
            Context context = this.f3189a;
            e eVar = new e(context, i3, jVar);
            y.m mVar = eVar.f3196b;
            ArrayList arrayListE = jVar.f3223e.f3057c.t().e();
            String str = d.f3193a;
            int size = arrayListE.size();
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayListE.get(i5);
                i5++;
                p.d dVar = ((o) obj).f6008j;
                z2 |= dVar.f2836d;
                z3 |= dVar.f2834b;
                z4 |= dVar.f2837e;
                z5 |= dVar.f2833a != 1;
                if (z2 && z3 && z4 && z5) {
                    break;
                }
            }
            String str2 = ConstraintProxyUpdateReceiver.f226a;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            intent2.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
            intent2.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z2).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z3).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z4).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z5);
            context.sendBroadcast(intent2);
            mVar.r(arrayListE);
            ArrayList arrayList2 = new ArrayList(arrayListE.size());
            long jCurrentTimeMillis = System.currentTimeMillis();
            int size2 = arrayListE.size();
            int i6 = 0;
            while (i6 < size2) {
                Object obj2 = arrayListE.get(i6);
                i6++;
                o oVar = (o) obj2;
                String str3 = oVar.f5999a;
                if (jCurrentTimeMillis >= oVar.a() && (!oVar.c() || mVar.b(str3))) {
                    arrayList2.add(oVar);
                }
            }
            int size3 = arrayList2.size();
            while (i4 < size3) {
                Object obj3 = arrayList2.get(i4);
                i4++;
                o oVar2 = (o) obj3;
                String str4 = oVar2.f5999a;
                y.j jVarH = m0.a.h(oVar2);
                Intent intent3 = new Intent(context, (Class<?>) SystemAlarmService.class);
                intent3.setAction("ACTION_DELAY_MET");
                d(intent3, jVarH);
                m.d().a(e.f3194c, "Creating a delay_met command for workSpec with id (" + str4 + ")");
                ((b0.a) jVar.f3220b.f6034c).execute(new i(eVar.f3195a, intent3, jVar));
            }
            mVar.s();
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            m.d().a(f3188e, "Handling reschedule " + intent + ", " + i3);
            jVar.f3223e.d();
            return;
        }
        Bundle extras = intent.getExtras();
        String[] strArr = {"KEY_WORKSPEC_ID"};
        if (extras == null || extras.isEmpty() || extras.get(strArr[0]) == null) {
            m.d().b(f3188e, "Invalid request for " + action + " , requires KEY_WORKSPEC_ID .");
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            Context context2 = this.f3189a;
            y.j jVarC = c(intent);
            m mVarD = m.d();
            String str5 = f3188e;
            mVarD.a(str5, "Handling schedule work for " + jVarC);
            WorkDatabase workDatabase = jVar.f3223e.f3057c;
            workDatabase.c();
            try {
                o oVarH = workDatabase.t().h(jVarC.f5987a);
                if (oVarH == null) {
                    m.d().g(str5, "Skipping scheduling " + jVarC + " because it's no longer in the DB");
                    return;
                }
                if (a0.a.b(oVarH.f6000b)) {
                    m.d().g(str5, "Skipping scheduling " + jVarC + "because it is finished.");
                    return;
                }
                long jA = oVarH.a();
                if (oVarH.c()) {
                    m.d().a(str5, "Opportunistically setting an alarm for " + jVarC + "at " + jA);
                    b.b(context2, workDatabase, jVarC, jA);
                    Intent intent4 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                    intent4.setAction("ACTION_CONSTRAINTS_CHANGED");
                    ((b0.a) jVar.f3220b.f6034c).execute(new i(i3, intent4, jVar));
                } else {
                    m.d().a(str5, "Setting up Alarms for " + jVarC + "at " + jA);
                    b.b(context2, workDatabase, jVarC, jA);
                }
                workDatabase.o();
                return;
            } finally {
                workDatabase.k();
            }
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            synchronized (this.f3191c) {
                try {
                    y.j jVarC2 = c(intent);
                    m mVarD2 = m.d();
                    String str6 = f3188e;
                    mVarD2.a(str6, "Handing delay met for " + jVarC2);
                    if (this.f3190b.containsKey(jVarC2)) {
                        m.d().a(str6, "WorkSpec " + jVarC2 + " is is already being handled for ACTION_DELAY_MET");
                    } else {
                        g gVar = new g(this.f3189a, i3, jVar, this.f3192d.p(jVarC2));
                        this.f3190b.put(jVarC2, gVar);
                        gVar.e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (!"ACTION_STOP_WORK".equals(action)) {
            if (!"ACTION_EXECUTION_COMPLETED".equals(action)) {
                m.d().g(f3188e, "Ignoring intent " + intent);
                return;
            }
            y.j jVarC3 = c(intent);
            boolean z6 = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
            m.d().a(f3188e, "Handling onExecutionCompleted " + intent + ", " + i3);
            b(jVarC3, z6);
            return;
        }
        y.e eVar2 = this.f3192d;
        Bundle extras2 = intent.getExtras();
        String string = extras2.getString("KEY_WORKSPEC_ID");
        if (extras2.containsKey("KEY_WORKSPEC_GENERATION")) {
            int i7 = extras2.getInt("KEY_WORKSPEC_GENERATION");
            arrayList = new ArrayList(1);
            l lVarJ = eVar2.j(new y.j(string, i7));
            if (lVarJ != null) {
                listI = arrayList;
                arrayList.add(lVarJ);
                listI = arrayList;
            }
        } else {
            listI = eVar2.i(string);
        }
        listI = arrayList;
        for (l lVar : listI) {
            m.d().a(f3188e, "Handing stopWork work for " + string);
            q qVar = jVar.f3223e;
            qVar.f3058d.b(new z.m(qVar, lVar, false));
            Context context3 = this.f3189a;
            WorkDatabase workDatabase2 = jVar.f3223e.f3057c;
            y.j jVar2 = lVar.f3039a;
            String str7 = b.f3187a;
            y.i iVarP = workDatabase2.p();
            y.g gVarB = iVarP.b(jVar2);
            if (gVarB != null) {
                b.a(context3, jVar2, gVarB.f5981c);
                m.d().a(b.f3187a, "Removing SystemIdInfo for workSpecId (" + jVar2 + ")");
                String str8 = jVar2.f5987a;
                int i8 = jVar2.f5988b;
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) iVarP.f5983a;
                workDatabase_Impl.b();
                y.h hVar = (y.h) iVarP.f5985c;
                k.i iVarA = hVar.a();
                if (str8 == null) {
                    iVarA.l(1);
                } else {
                    iVarA.m(str8, 1);
                }
                iVarA.h(2, i8);
                workDatabase_Impl.c();
                try {
                    iVarA.d();
                    workDatabase_Impl.o();
                    workDatabase_Impl.k();
                    hVar.m(iVarA);
                } catch (Throwable th2) {
                    workDatabase_Impl.k();
                    hVar.m(iVarA);
                    throw th2;
                }
            }
            jVar.b(lVar.f3039a, false);
        }
    }

    @Override // q.d
    public final void b(y.j jVar, boolean z2) {
        synchronized (this.f3191c) {
            try {
                g gVar = (g) this.f3190b.remove(jVar);
                this.f3192d.j(jVar);
                if (gVar != null) {
                    gVar.f(z2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
