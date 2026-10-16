// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.os.Handler;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tb implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5190c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f5191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f5192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f5193f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5194g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f5195h;

    public /* synthetic */ tb(ScreenMirrorService screenMirrorService, float f3, float f4, int i3, long j3) {
        this.f5191d = screenMirrorService;
        this.f5192e = f3;
        this.f5193f = f4;
        this.f5194g = i3;
        this.f5195h = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5190c) {
            case 0:
                ScreenMirrorService screenMirrorService = this.f5191d;
                long j3 = this.f5195h;
                float f3 = this.f5192e;
                float f4 = this.f5193f;
                int i3 = this.f5194g;
                rd rdVar = ScreenMirrorService.n6;
                int iMax = Math.max(i3, 20);
                Handler handler = screenMirrorService.f2541t;
                if (handler != null) {
                    handler.post(new tb(screenMirrorService, f3, f4, iMax, j3));
                }
                break;
            default:
                ScreenMirrorService screenMirrorService2 = this.f5191d;
                float f5 = this.f5192e;
                float f6 = this.f5193f;
                int i4 = this.f5194g;
                long j4 = this.f5195h;
                rd rdVar2 = ScreenMirrorService.n6;
                try {
                    n3 n3Var = screenMirrorService2.R3;
                    if (n3Var != null) {
                        int iA = n3.a(f5, n3Var.f4617a);
                        int iA2 = n3.a(f6, n3Var.f4618b);
                        Path path = new Path();
                        path.moveTo(iA, iA2);
                        screenMirrorService2.e1(j4, new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, i4)).build(), null);
                    }
                } catch (Throwable th) {
                    a0.a.p(th, new StringBuilder("[Unlock] tap fail: "), "ScreenMirror");
                }
                break;
        }
    }

    public /* synthetic */ tb(ScreenMirrorService screenMirrorService, long j3, float f3, float f4, int i3) {
        this.f5191d = screenMirrorService;
        this.f5195h = j3;
        this.f5192e = f3;
        this.f5193f = f4;
        this.f5194g = i3;
    }
}
