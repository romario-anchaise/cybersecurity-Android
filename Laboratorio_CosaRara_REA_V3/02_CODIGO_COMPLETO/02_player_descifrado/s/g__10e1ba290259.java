// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p.m;
import y.o;
import y.r;
import z.l;
import z.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements u.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f3199m = m.f("DelayMetCommandHandler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y.j f3202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f3203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y.m f3204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f3205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l f3207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b0.a f3208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PowerManager.WakeLock f3209j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3210k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final q.l f3211l;

    public g(Context context, int i3, j jVar, q.l lVar) {
        this.f3200a = context;
        this.f3201b = i3;
        this.f3203d = jVar;
        this.f3202c = lVar.f3039a;
        this.f3211l = lVar;
        y.i iVar = jVar.f3223e.f3064j;
        r rVar = jVar.f3220b;
        this.f3207h = (l) rVar.f6032a;
        this.f3208i = (b0.a) rVar.f6034c;
        this.f3204e = new y.m(iVar, this);
        this.f3210k = false;
        this.f3206g = 0;
        this.f3205f = new Object();
    }

    public static void a(g gVar) {
        int i3 = gVar.f3201b;
        b0.a aVar = gVar.f3208i;
        Context context = gVar.f3200a;
        j jVar = gVar.f3203d;
        y.j jVar2 = gVar.f3202c;
        String str = jVar2.f5987a;
        int i4 = gVar.f3206g;
        String str2 = f3199m;
        if (i4 >= 2) {
            m.d().a(str2, "Already stopped work for " + str);
            return;
        }
        gVar.f3206g = 2;
        m.d().a(str2, "Stopping work for WorkSpec " + str);
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        c.d(intent, jVar2);
        aVar.execute(new i(i3, intent, jVar));
        if (!jVar.f3222d.d(str)) {
            m.d().a(str2, "Processor does not have WorkSpec " + str + ". No need to reschedule");
            return;
        }
        m.d().a(str2, "WorkSpec " + str + " needs to be rescheduled");
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_SCHEDULE_WORK");
        c.d(intent2, jVar2);
        aVar.execute(new i(i3, intent2, jVar));
    }

    public final void b() {
        synchronized (this.f3205f) {
            try {
                this.f3204e.s();
                this.f3203d.f3221c.a(this.f3202c);
                PowerManager.WakeLock wakeLock = this.f3209j;
                if (wakeLock != null && wakeLock.isHeld()) {
                    m.d().a(f3199m, "Releasing wakelock " + this.f3209j + "for WorkSpec " + this.f3202c);
                    this.f3209j.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // u.b
    public final void c(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (m0.a.h((o) it.next()).equals(this.f3202c)) {
                this.f3207h.execute(new f(this, 1));
                return;
            }
        }
    }

    @Override // u.b
    public final void d(ArrayList arrayList) {
        this.f3207h.execute(new f(this, 0));
    }

    public final void e() {
        String str = this.f3202c.f5987a;
        this.f3209j = n.a(this.f3200a, str + " (" + this.f3201b + ")");
        m mVarD = m.d();
        String str2 = "Acquiring wakelock " + this.f3209j + "for WorkSpec " + str;
        String str3 = f3199m;
        mVarD.a(str3, str2);
        this.f3209j.acquire();
        o oVarH = this.f3203d.f3223e.f3057c.t().h(str);
        if (oVarH == null) {
            this.f3207h.execute(new f(this, 0));
            return;
        }
        boolean zC = oVarH.c();
        this.f3210k = zC;
        if (zC) {
            this.f3204e.r(Collections.singletonList(oVarH));
            return;
        }
        m.d().a(str3, "No constraints for " + str);
        c(Collections.singletonList(oVarH));
    }

    public final void f(boolean z2) {
        m mVarD = m.d();
        StringBuilder sb = new StringBuilder("onExecuted ");
        y.j jVar = this.f3202c;
        sb.append(jVar);
        sb.append(", ");
        sb.append(z2);
        mVarD.a(f3199m, sb.toString());
        b();
        int i3 = this.f3201b;
        j jVar2 = this.f3203d;
        b0.a aVar = this.f3208i;
        Context context = this.f3200a;
        if (z2) {
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_SCHEDULE_WORK");
            c.d(intent, jVar);
            aVar.execute(new i(i3, intent, jVar2));
        }
        if (this.f3210k) {
            Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent2.setAction("ACTION_CONSTRAINTS_CHANGED");
            aVar.execute(new i(i3, intent2, jVar2));
        }
    }
}
