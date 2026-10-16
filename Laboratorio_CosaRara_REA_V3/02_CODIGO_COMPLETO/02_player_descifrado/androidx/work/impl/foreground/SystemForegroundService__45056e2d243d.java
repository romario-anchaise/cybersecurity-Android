// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.work.impl.foreground;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.f;
import g0.j;
import java.util.UUID;
import p.m;
import q.q;
import x.a;
import z.b;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundService extends f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f236f = m.f("SystemFgService");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NotificationManager f240e;

    public final void a() {
        this.f237b = new Handler(Looper.getMainLooper());
        this.f240e = (NotificationManager) getApplicationContext().getSystemService("notification");
        a aVar = new a(getApplicationContext());
        this.f239d = aVar;
        if (aVar.f5827i != null) {
            m.d().b(a.f5818j, "A callback already exists.");
        } else {
            aVar.f5827i = this;
        }
    }

    @Override // androidx.lifecycle.f, android.app.Service
    public final void onCreate() {
        super.onCreate();
        a();
    }

    @Override // androidx.lifecycle.f, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f239d.g();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i4) {
        super.onStartCommand(intent, i3, i4);
        boolean z2 = this.f238c;
        String str = f236f;
        if (z2) {
            m.d().e(str, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.f239d.g();
            a();
            this.f238c = false;
        }
        if (intent == null) {
            return 3;
        }
        a aVar = this.f239d;
        aVar.getClass();
        String str2 = a.f5818j;
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            m.d().e(str2, "Started foreground service " + intent);
            aVar.f5820b.b(new j(aVar, intent.getStringExtra("KEY_WORKSPEC_ID"), 11));
            aVar.f(intent);
            return 3;
        }
        if ("ACTION_NOTIFY".equals(action)) {
            aVar.f(intent);
            return 3;
        }
        if (!"ACTION_CANCEL_WORK".equals(action)) {
            if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                return 3;
            }
            m.d().e(str2, "Stopping foreground service");
            SystemForegroundService systemForegroundService = aVar.f5827i;
            if (systemForegroundService == null) {
                return 3;
            }
            systemForegroundService.f238c = true;
            m.d().a(str, "All commands completed.");
            systemForegroundService.stopForeground(true);
            systemForegroundService.stopSelf();
            return 3;
        }
        m.d().e(str2, "Stopping foreground work for " + intent);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return 3;
        }
        q qVar = aVar.f5819a;
        UUID uuidFromString = UUID.fromString(stringExtra);
        qVar.getClass();
        qVar.f3058d.b(new b(qVar, uuidFromString, 0));
        return 3;
    }
}
