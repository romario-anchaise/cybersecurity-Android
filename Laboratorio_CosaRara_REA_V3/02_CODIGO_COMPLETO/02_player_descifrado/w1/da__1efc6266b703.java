// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.GestureDescription;
import java.util.function.BooleanSupplier;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class da implements BooleanSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f3818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ GestureDescription f3819c;

    public /* synthetic */ da(ScreenMirrorService screenMirrorService, GestureDescription gestureDescription, int i3) {
        this.f3817a = i3;
        this.f3818b = screenMirrorService;
        this.f3819c = gestureDescription;
    }

    @Override // java.util.function.BooleanSupplier
    public final boolean getAsBoolean() {
        int i3 = this.f3817a;
        e4 e4Var = e4.f3870e;
        GestureDescription gestureDescription = this.f3819c;
        ScreenMirrorService screenMirrorService = this.f3818b;
        switch (i3) {
            case 0:
                rd rdVar = ScreenMirrorService.n6;
                return screenMirrorService.W0(e4Var, gestureDescription, new uc(), null);
            default:
                rd rdVar2 = ScreenMirrorService.n6;
                return screenMirrorService.W0(e4Var, gestureDescription, null, null);
        }
    }
}
