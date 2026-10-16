// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cc implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f3682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float[] f3683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float[] f3684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f3686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f3687h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f3688i;

    public /* synthetic */ cc(ScreenMirrorService screenMirrorService, float[] fArr, float[] fArr2, int i3, String str, int i4, long j3) {
        this.f3682c = screenMirrorService;
        this.f3683d = fArr;
        this.f3684e = fArr2;
        this.f3685f = i3;
        this.f3686g = str;
        this.f3687h = i4;
        this.f3688i = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenMirrorService screenMirrorService = this.f3682c;
        float[] fArr = this.f3683d;
        float[] fArr2 = this.f3684e;
        int i3 = this.f3685f;
        String str = this.f3686g;
        int i4 = this.f3687h;
        long j3 = this.f3688i;
        rd rdVar = ScreenMirrorService.n6;
        try {
            n3 n3Var = screenMirrorService.R3;
            if (n3Var == null) {
                return;
            }
            int iA = n3.a(fArr[0], n3Var.f4617a);
            int iA2 = n3.a(fArr2[0], n3Var.f4618b);
            int i5 = 1;
            int iA3 = n3.a(fArr[fArr.length - 1], n3Var.f4617a);
            int iA4 = n3.a(fArr2[fArr2.length - 1], n3Var.f4618b);
            Path path = new Path();
            path.moveTo(iA, iA2);
            int i6 = 1;
            while (i6 < fArr.length) {
                int i7 = i6;
                path.lineTo(n3.a(fArr[i6], n3Var.f4617a), n3.a(fArr2[i7], n3Var.f4618b));
                i6 = i7 + 1;
                j3 = j3;
            }
            GestureDescription gestureDescriptionBuild = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, i3)).build();
            Log.i("ScreenMirror", "[Inject] PATH points=" + fArr.length + " " + iA + "," + iA2 + "->" + iA3 + "," + iA4 + " dur=" + i3 + " locked=" + screenMirrorService.J3() + " src=" + str + " attempt=" + (i4 + 1));
            if (screenMirrorService.e1(j3, gestureDescriptionBuild, new lc(screenMirrorService, str, i5))) {
                return;
            }
            Log.w("ScreenMirror", "[Inject] dispatchGesture rejected src=" + str + " (service not connected or gesture pending?)");
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("[Ctrl] unlock path fail: "), "ScreenMirror");
        }
    }
}
