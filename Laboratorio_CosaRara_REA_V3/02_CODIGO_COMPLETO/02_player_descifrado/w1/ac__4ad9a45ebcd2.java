// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ac implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f3499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f3500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float[] f3501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ float[] f3502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f3503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f3504i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ float[] f3505j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ float[] f3506k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f3507l;

    public /* synthetic */ ac(ScreenMirrorService screenMirrorService, long j3, float[] fArr, float[] fArr2, int i3, int i4, float[] fArr3, float[] fArr4, int i5, int i6) {
        this.f3498c = i6;
        this.f3499d = screenMirrorService;
        this.f3500e = j3;
        this.f3501f = fArr;
        this.f3502g = fArr2;
        this.f3503h = i3;
        this.f3504i = i4;
        this.f3505j = fArr3;
        this.f3506k = fArr4;
        this.f3507l = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3498c) {
            case 0:
                rd rdVar = ScreenMirrorService.n6;
                ScreenMirrorService screenMirrorService = this.f3499d;
                Handler handler = screenMirrorService.f2541t;
                long j3 = this.f3500e;
                handler.postDelayed(new sa(screenMirrorService, j3, new ac(screenMirrorService, j3, this.f3501f, this.f3502g, this.f3503h, this.f3504i, this.f3505j, this.f3506k, this.f3507l, 1), 1), 100L);
                break;
            default:
                rd rdVar2 = ScreenMirrorService.n6;
                ScreenMirrorService screenMirrorService2 = this.f3499d;
                Handler handler2 = screenMirrorService2.f2541t;
                long j4 = this.f3500e;
                int i3 = this.f3503h;
                int i4 = this.f3504i;
                if (handler2 != null) {
                    float[] fArr = this.f3501f;
                    if (fArr.length >= 2) {
                        int length = fArr.length;
                        float[] fArr2 = this.f3502g;
                        if (length == fArr2.length) {
                            cc ccVar = new cc(screenMirrorService2, fArr, fArr2, i3, "saved-seq", i4, j4);
                            j4 = j4;
                            handler2.post(ccVar);
                        }
                    }
                    j4 = j4;
                }
                screenMirrorService2.f2541t.postDelayed(new sa(screenMirrorService2, j4, new w9(screenMirrorService2, j4, i4, this.f3505j, this.f3506k, this.f3507l), 1), ((long) i3) + 1300);
                break;
        }
    }
}
