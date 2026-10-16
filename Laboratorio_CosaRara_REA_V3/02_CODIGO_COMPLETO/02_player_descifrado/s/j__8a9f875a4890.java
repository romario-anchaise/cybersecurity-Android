// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.ArrayList;
import p.m;
import q.q;
import w1.o2;
import y.r;
import z.n;
import z.u;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements q.d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f3218j = m.f("SystemAlarmDispatcher");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f3220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f3221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q.h f3222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f3223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f3224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f3225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Intent f3226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SystemAlarmService f3227i;

    public j(SystemAlarmService systemAlarmService) {
        Context applicationContext = systemAlarmService.getApplicationContext();
        this.f3219a = applicationContext;
        this.f3224f = new c(applicationContext, new y.e(8));
        q qVarA = q.a(systemAlarmService);
        this.f3223e = qVarA;
        this.f3221c = new u(qVarA.f3056b.f2826e);
        q.h hVar = qVarA.f3060f;
        this.f3222d = hVar;
        this.f3220b = qVarA.f3058d;
        hVar.a(this);
        this.f3225g = new ArrayList();
        this.f3226h = null;
    }

    public static void c() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        o2.k("Needs to be invoked on the main thread.");
    }

    public final void a(Intent intent, int i3) {
        m mVarD = m.d();
        String str = f3218j;
        mVarD.a(str, "Adding command " + intent + " (" + i3 + ")");
        c();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            m.d().g(str, "Unknown command. Ignoring");
            return;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            c();
            synchronized (this.f3225g) {
                try {
                    ArrayList arrayList = this.f3225g;
                    int size = arrayList.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj = arrayList.get(i4);
                        i4++;
                        if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) obj).getAction())) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        intent.putExtra("KEY_START_ID", i3);
        synchronized (this.f3225g) {
            try {
                boolean zIsEmpty = this.f3225g.isEmpty();
                this.f3225g.add(intent);
                if (zIsEmpty) {
                    d();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // q.d
    public final void b(y.j jVar, boolean z2) {
        b0.a aVar = (b0.a) this.f3220b.f6034c;
        String str = c.f3188e;
        Intent intent = new Intent(this.f3219a, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z2);
        c.d(intent, jVar);
        aVar.execute(new i(0, intent, this));
    }

    public final void d() {
        c();
        PowerManager.WakeLock wakeLockA = n.a(this.f3219a, "ProcessCommand");
        try {
            wakeLockA.acquire();
            this.f3223e.f3058d.b(new h(this, 0));
        } finally {
            wakeLockA.release();
        }
    }
}
