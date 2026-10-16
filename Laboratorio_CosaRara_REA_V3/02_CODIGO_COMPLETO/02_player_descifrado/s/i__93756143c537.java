// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s;

import android.app.Notification;
import android.content.Intent;
import androidx.work.impl.foreground.SystemForegroundService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3214c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f3216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f3217f;

    public i(SystemForegroundService systemForegroundService, int i3, Notification notification) {
        this.f3217f = systemForegroundService;
        this.f3215d = i3;
        this.f3216e = notification;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3214c) {
            case 0:
                ((j) this.f3216e).a((Intent) this.f3217f, this.f3215d);
                break;
            default:
                ((SystemForegroundService) this.f3217f).f240e.notify(this.f3215d, (Notification) this.f3216e);
                break;
        }
    }

    public i(int i3, Intent intent, j jVar) {
        this.f3216e = jVar;
        this.f3217f = intent;
        this.f3215d = i3;
    }
}
