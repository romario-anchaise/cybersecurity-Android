// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import java.util.concurrent.atomic.AtomicLong;
import lyr.stable.runtime.keepalive.WakeScreenActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WakeScreenActivity f467d;

    public /* synthetic */ w(WakeScreenActivity wakeScreenActivity, int i3) {
        this.f466c = i3;
        this.f467d = wakeScreenActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f466c;
        WakeScreenActivity wakeScreenActivity = this.f467d;
        switch (i3) {
            case 0:
                WakeScreenActivity.a(wakeScreenActivity);
                break;
            default:
                AtomicLong atomicLong = WakeScreenActivity.f2632e;
                try {
                    wakeScreenActivity.finish();
                } catch (Throwable unused) {
                    return;
                }
                break;
        }
    }
}
