// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import androidx.lifecycle.f;
import java.util.LinkedHashMap;
import java.util.Map;
import p.m;
import s.j;
import z.n;
import z.o;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class SystemAlarmService extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f228d = m.f("SystemAlarmService");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f230c;

    public final void a() {
        this.f230c = true;
        m.d().a(f228d, "All commands completed in dispatcher");
        String str = n.f6255a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (o.f6256a) {
            linkedHashMap.putAll(o.f6257b);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str2 = (String) entry.getValue();
            if (wakeLock != null && wakeLock.isHeld()) {
                m.d().g(n.f6255a, "WakeLock held for " + str2);
            }
        }
        stopSelf();
    }

    @Override // androidx.lifecycle.f, android.app.Service
    public final void onCreate() {
        super.onCreate();
        j jVar = new j(this);
        this.f229b = jVar;
        if (jVar.f3227i != null) {
            m.d().b(j.f3218j, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            jVar.f3227i = this;
        }
        this.f230c = false;
    }

    @Override // androidx.lifecycle.f, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f230c = true;
        j jVar = this.f229b;
        jVar.getClass();
        m.d().a(j.f3218j, "Destroying SystemAlarmDispatcher");
        jVar.f3222d.e(jVar);
        jVar.f3227i = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i4) {
        super.onStartCommand(intent, i3, i4);
        if (this.f230c) {
            m.d().e(f228d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            j jVar = this.f229b;
            jVar.getClass();
            m mVarD = m.d();
            String str = j.f3218j;
            mVarD.a(str, "Destroying SystemAlarmDispatcher");
            jVar.f3222d.e(jVar);
            jVar.f3227i = null;
            j jVar2 = new j(this);
            this.f229b = jVar2;
            if (jVar2.f3227i != null) {
                m.d().b(str, "A completion listener for SystemAlarmDispatcher already exists.");
            } else {
                jVar2.f3227i = this;
            }
            this.f230c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f229b.a(intent, i4);
        return 3;
    }
}
