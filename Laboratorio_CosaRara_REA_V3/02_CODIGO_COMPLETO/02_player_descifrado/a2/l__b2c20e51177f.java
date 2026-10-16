// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.keepalive.ConnectionRecoveryReceiver;
import lyr.stable.runtime.keepalive.WatchdogService;
import w1.rd;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f114a;

    public /* synthetic */ l(int i3) {
        this.f114a = i3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str;
        switch (this.f114a) {
            case 0:
                str = "mesh-restart-gate";
                break;
            case 1:
                str = "app-foreground-guard";
                break;
            case 2:
                str = "remote-wake-poll";
                break;
            case 3:
                ThreadPoolExecutor threadPoolExecutor = ConnectionRecoveryReceiver.f2631a;
                str = "connection-recovery-receiver";
                break;
            case 4:
                str = "gateway-heartbeat-reader";
                break;
            case 5:
                boolean z2 = WatchdogService.f2639e;
                str = "runtime-watchdog";
                break;
            case 6:
                str = "rtc-a11y-capture";
                break;
            case 7:
                str = "rtc-a11y-webp-encode";
                break;
            case 8:
                str = "capture-fallback-lifecycle";
                break;
            case 9:
                str = "socket-logical-stream";
                break;
            case 10:
                str = "socket-media-sender";
                break;
            case 11:
                str = "socket-media-timer";
                break;
            case 12:
                str = "a11y-lease-io";
                break;
            case 13:
                str = "a11y-runtime-state-reader";
                break;
            case 14:
                str = "a11y-event-outbox";
                break;
            case 15:
                str = "camera-lifecycle";
                break;
            case 16:
                str = "control-action-deadline";
                break;
            case 17:
                str = "credential-outbox";
                break;
            case 18:
                str = "device-telemetry";
                break;
            case 19:
                str = "disconnect-incident-outbox";
                break;
            case 20:
                str = "gesture-arbiter-watchdog";
                break;
            case 21:
                str = "process-exit-reporter";
                break;
            case 22:
                rd rdVar = ScreenMirrorService.n6;
                str = "jpeg-frame-encode";
                break;
            case 23:
                rd rdVar2 = ScreenMirrorService.n6;
                str = "mirror-gesture-watchdog";
                break;
            case 24:
                rd rdVar3 = ScreenMirrorService.n6;
                str = "jpeg-screenshot-callback";
                break;
            case 25:
                rd rdVar4 = ScreenMirrorService.n6;
                str = "rtc-a11y-screenshot";
                break;
            default:
                Thread threadL = a0.a.l(runnable, "core-protection-poller", true);
                try {
                    threadL.setPriority(6);
                    break;
                } catch (Throwable unused) {
                }
                return threadL;
        }
        return a0.a.l(runnable, str, true);
    }
}
