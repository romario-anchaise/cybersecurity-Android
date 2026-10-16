// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x;

import android.app.Notification;
import android.os.Build;
import androidx.work.impl.foreground.SystemForegroundService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Notification f5829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ SystemForegroundService f5831f;

    public b(SystemForegroundService systemForegroundService, int i3, Notification notification, int i4) {
        this.f5831f = systemForegroundService;
        this.f5828c = i3;
        this.f5829d = notification;
        this.f5830e = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = Build.VERSION.SDK_INT;
        int i4 = this.f5830e;
        Notification notification = this.f5829d;
        int i5 = this.f5828c;
        SystemForegroundService systemForegroundService = this.f5831f;
        if (i3 >= 31) {
            d.a(systemForegroundService, i5, notification, i4);
        } else {
            c.a(systemForegroundService, i5, notification, i4);
        }
    }
}
