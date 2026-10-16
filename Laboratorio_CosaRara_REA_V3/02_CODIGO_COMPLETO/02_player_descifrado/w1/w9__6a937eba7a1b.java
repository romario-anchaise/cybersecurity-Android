// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Rect;
import android.util.Log;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntConsumer;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w9 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5419c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f5420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Serializable f5422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f5423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f5424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5425i;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ w9(ScreenMirrorService screenMirrorService, long j3, int i3, float[] fArr, float[] fArr2, int i4) {
        this.f5420d = screenMirrorService;
        this.f5421e = j3;
        this.f5424h = i3;
        this.f5422f = fArr;
        this.f5423g = fArr2;
        this.f5425i = i4;
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [float[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r8v1, types: [float[], java.io.Serializable] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5419c) {
            case 0:
                ScreenMirrorService screenMirrorService = this.f5420d;
                long j3 = this.f5421e;
                int i3 = this.f5424h;
                ?? r7 = (float[]) this.f5422f;
                ?? r8 = (float[]) this.f5423g;
                int i4 = this.f5425i;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.R2(j3);
                if (!screenMirrorService.J3()) {
                    screenMirrorService.V1 = false;
                    Log.i("ScreenMirror", "[Unlock] stage3 pattern replay success source=saved-seq attempt=" + (i3 + 1));
                } else if (i3 + 1 >= 5) {
                    screenMirrorService.V1 = false;
                    Log.w("ScreenMirror", "[Unlock] stage3 pattern replay failed after retries");
                } else {
                    Log.w("ScreenMirror", "[Unlock] stage3 pattern replay retry " + (i3 + 2) + "/5");
                    screenMirrorService.f2541t.postDelayed(new sa(screenMirrorService, j3, new y9(screenMirrorService, r7, r8, i4, i3, 0), 1), 800L);
                }
                break;
            case 1:
                ScreenMirrorService screenMirrorService2 = this.f5420d;
                long j4 = this.f5421e;
                float[] fArr = (float[]) this.f5422f;
                float[] fArr2 = (float[]) this.f5423g;
                int i5 = this.f5424h;
                int i6 = this.f5425i;
                rd rdVar2 = ScreenMirrorService.n6;
                final w9 w9Var = new w9(screenMirrorService2, fArr, fArr2, i5, i6, j4);
                screenMirrorService2.R7(j4, new IntConsumer() { // from class: w1.wb
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i7) {
                        rd rdVar3 = ScreenMirrorService.n6;
                        this.f5430a.run();
                    }
                }, 0);
                break;
            case 2:
                ScreenMirrorService screenMirrorService3 = this.f5420d;
                float[] fArr3 = (float[]) this.f5422f;
                float[] fArr4 = (float[]) this.f5423g;
                int i7 = this.f5424h;
                int i8 = this.f5425i;
                long j5 = this.f5421e;
                rd rdVar3 = ScreenMirrorService.n6;
                Rect rectK2 = screenMirrorService3.k2();
                screenMirrorService3.K5(rectK2);
                Log.i("ScreenMirror", "[Unlock] stage3 replay raw saved path grid=" + rectK2 + " first=" + ScreenMirrorService.e0((int) (fArr3[0] * screenMirrorService3.O3), screenMirrorService3.O3) + "," + ScreenMirrorService.e0((int) (fArr4[0] * screenMirrorService3.P3), screenMirrorService3.P3) + " last=" + ScreenMirrorService.e0((int) (fArr3[fArr3.length - 1] * screenMirrorService3.O3), screenMirrorService3.O3) + "," + ScreenMirrorService.e0((int) (fArr4[fArr4.length - 1] * screenMirrorService3.P3), screenMirrorService3.P3));
                screenMirrorService3.f2541t.postDelayed(new sa(screenMirrorService3, j5, new ac(screenMirrorService3, j5, ScreenMirrorService.A(fArr3, i8), ScreenMirrorService.A(fArr4, i8), i7, i8, fArr3, fArr4, i7, 0), 1), 600L);
                break;
            default:
                ScreenMirrorService screenMirrorService4 = this.f5420d;
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f5422f;
                long j6 = this.f5421e;
                Runnable runnable = (Runnable) this.f5423g;
                int i9 = this.f5424h;
                int i10 = this.f5425i;
                rd rdVar4 = ScreenMirrorService.n6;
                if (atomicBoolean.compareAndSet(false, true)) {
                    screenMirrorService4.B2.incrementAndGet();
                    screenMirrorService4.e3(j6, runnable, i9, i10, screenMirrorService4.o4(false));
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ w9(ScreenMirrorService screenMirrorService, long j3, float[] fArr, float[] fArr2, int i3, int i4) {
        this.f5420d = screenMirrorService;
        this.f5421e = j3;
        this.f5422f = fArr;
        this.f5423g = fArr2;
        this.f5424h = i3;
        this.f5425i = i4;
    }

    public /* synthetic */ w9(ScreenMirrorService screenMirrorService, AtomicBoolean atomicBoolean, long j3, Runnable runnable, int i3, int i4) {
        this.f5420d = screenMirrorService;
        this.f5422f = atomicBoolean;
        this.f5421e = j3;
        this.f5423g = runnable;
        this.f5424h = i3;
        this.f5425i = i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ w9(ScreenMirrorService screenMirrorService, float[] fArr, float[] fArr2, int i3, int i4, long j3) {
        this.f5420d = screenMirrorService;
        this.f5422f = fArr;
        this.f5423g = fArr2;
        this.f5424h = i3;
        this.f5425i = i4;
        this.f5421e = j3;
    }
}
