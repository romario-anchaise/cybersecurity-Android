// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.foreground.SystemForegroundService;
import g0.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p.f;
import p.m;
import q.l;
import q.q;
import s.i;
import y.j;
import y.o;
import y.r;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements u.b, q.d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f5818j = m.f("SystemFgDispatcher");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f5819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f5820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5821c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f5822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f5823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f5824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashSet f5825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y.m f5826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SystemForegroundService f5827i;

    public a(Context context) {
        q qVarA = q.a(context);
        this.f5819a = qVarA;
        this.f5820b = qVarA.f3058d;
        this.f5822d = null;
        this.f5823e = new LinkedHashMap();
        this.f5825g = new HashSet();
        this.f5824f = new HashMap();
        this.f5826h = new y.m(qVarA.f3064j, this);
        qVarA.f3060f.a(this);
    }

    public static Intent a(Context context, j jVar, f fVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", fVar.f2844a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", fVar.f2845b);
        intent.putExtra("KEY_NOTIFICATION", fVar.f2846c);
        intent.putExtra("KEY_WORKSPEC_ID", jVar.f5987a);
        intent.putExtra("KEY_GENERATION", jVar.f5988b);
        return intent;
    }

    public static Intent e(Context context, j jVar, f fVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", jVar.f5987a);
        intent.putExtra("KEY_GENERATION", jVar.f5988b);
        intent.putExtra("KEY_NOTIFICATION_ID", fVar.f2844a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", fVar.f2845b);
        intent.putExtra("KEY_NOTIFICATION", fVar.f2846c);
        return intent;
    }

    @Override // q.d
    public final void b(j jVar, boolean z2) {
        Map.Entry entry;
        synchronized (this.f5821c) {
            try {
                o oVar = (o) this.f5824f.remove(jVar);
                if (oVar != null ? this.f5825g.remove(oVar) : false) {
                    this.f5826h.r(this.f5825g);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f fVar = (f) this.f5823e.remove(jVar);
        if (jVar.equals(this.f5822d) && this.f5823e.size() > 0) {
            Iterator it = this.f5823e.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                } else {
                    next = it.next();
                }
            }
            this.f5822d = (j) entry.getKey();
            if (this.f5827i != null) {
                f fVar2 = (f) entry.getValue();
                SystemForegroundService systemForegroundService = this.f5827i;
                systemForegroundService.f237b.post(new b(systemForegroundService, fVar2.f2844a, fVar2.f2846c, fVar2.f2845b));
                SystemForegroundService systemForegroundService2 = this.f5827i;
                systemForegroundService2.f237b.post(new g(systemForegroundService2, fVar2.f2844a, 1));
            }
        }
        SystemForegroundService systemForegroundService3 = this.f5827i;
        if (fVar == null || systemForegroundService3 == null) {
            return;
        }
        m.d().a(f5818j, "Removing Notification (id: " + fVar.f2844a + ", workSpecId: " + jVar + ", notificationType: " + fVar.f2845b);
        systemForegroundService3.f237b.post(new g(systemForegroundService3, fVar.f2844a, 1));
    }

    @Override // u.b
    public final void d(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            o oVar = (o) obj;
            String str = oVar.f5999a;
            m.d().a(f5818j, "Constraints unmet for WorkSpec " + str);
            j jVarH = m0.a.h(oVar);
            q qVar = this.f5819a;
            qVar.f3058d.b(new z.m(qVar, new l(jVarH), true));
        }
    }

    public final void f(Intent intent) {
        int i3 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        j jVar = new j(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        m.d().a(f5818j, "Notifying with (id:" + intExtra + ", workSpecId: " + stringExtra + ", notificationType :" + intExtra2 + ")");
        if (notification == null || this.f5827i == null) {
            return;
        }
        f fVar = new f(intExtra, notification, intExtra2);
        LinkedHashMap linkedHashMap = this.f5823e;
        linkedHashMap.put(jVar, fVar);
        if (this.f5822d == null) {
            this.f5822d = jVar;
            SystemForegroundService systemForegroundService = this.f5827i;
            systemForegroundService.f237b.post(new b(systemForegroundService, intExtra, notification, intExtra2));
            return;
        }
        SystemForegroundService systemForegroundService2 = this.f5827i;
        systemForegroundService2.f237b.post(new i(systemForegroundService2, intExtra, notification));
        if (intExtra2 != 0) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                i3 |= ((f) ((Map.Entry) it.next()).getValue()).f2845b;
            }
            f fVar2 = (f) linkedHashMap.get(this.f5822d);
            if (fVar2 != null) {
                SystemForegroundService systemForegroundService3 = this.f5827i;
                systemForegroundService3.f237b.post(new b(systemForegroundService3, fVar2.f2844a, fVar2.f2846c, i3));
            }
        }
    }

    public final void g() {
        this.f5827i = null;
        synchronized (this.f5821c) {
            this.f5826h.s();
        }
        this.f5819a.f3060f.e(this);
    }

    @Override // u.b
    public final void c(List list) {
    }
}
