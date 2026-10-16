// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.GestureDescription;
import android.os.Handler;
import java.util.function.BooleanSupplier;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eb implements BooleanSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f3907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GestureDescription f3908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ sf f3910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ e2.n1 f3911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Handler f3912f;

    public /* synthetic */ eb(ScreenMirrorService screenMirrorService, GestureDescription gestureDescription, int i3, sf sfVar, e2.n1 n1Var, Handler handler) {
        this.f3907a = screenMirrorService;
        this.f3908b = gestureDescription;
        this.f3909c = i3;
        this.f3910d = sfVar;
        this.f3911e = n1Var;
        this.f3912f = handler;
    }

    @Override // java.util.function.BooleanSupplier
    public final boolean getAsBoolean() {
        rd rdVar = ScreenMirrorService.n6;
        return this.f3907a.dispatchGesture(this.f3908b, new c2.a(this.f3909c, this.f3910d, this.f3911e), this.f3912f);
    }
}
