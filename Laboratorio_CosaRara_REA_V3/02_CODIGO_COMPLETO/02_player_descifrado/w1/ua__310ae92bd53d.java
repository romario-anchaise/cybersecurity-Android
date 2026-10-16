// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ua implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f5240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5241e;

    public /* synthetic */ ua(ScreenMirrorService screenMirrorService, int i3, int i4) {
        this.f5239c = i4;
        this.f5240d = screenMirrorService;
        this.f5241e = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f5239c;
        int i4 = 2;
        int i5 = this.f5241e;
        ScreenMirrorService screenMirrorService = this.f5240d;
        switch (i3) {
            case 0:
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.v6(i5);
                break;
            case 1:
                rd rdVar2 = ScreenMirrorService.n6;
                screenMirrorService.M6(i5);
                break;
            case 2:
                rd rdVar3 = ScreenMirrorService.n6;
                screenMirrorService.f2475a2.postDelayed(new pa(screenMirrorService, i4), 0L);
                Log.i("ScreenMirror", "[Ctrl] LOCKSCREEN_MASK armed mode=" + i5);
                break;
            default:
                rd rdVar4 = ScreenMirrorService.n6;
                if (!screenMirrorService.J3()) {
                    boolean zD = n.D(screenMirrorService);
                    if (i5 == 2) {
                        i4 = 3;
                    } else if (i5 != 3 || !zD) {
                        i4 = 4;
                    }
                    if (i4 == 4) {
                        Log.w("ScreenMirror", "[LockMask] verify: still unlocked, no fallback left");
                    } else {
                        Log.w("ScreenMirror", "[LockMask] verify: still unlocked, fallback ".concat(j4.h(i4)));
                        screenMirrorService.G1(i4);
                    }
                    break;
                }
                break;
        }
    }
}
