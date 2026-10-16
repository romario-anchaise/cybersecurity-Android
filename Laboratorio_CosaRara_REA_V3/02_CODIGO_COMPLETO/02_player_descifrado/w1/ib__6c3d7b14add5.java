// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.io.OutputStream;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ib {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OutputStream f4280b;

    public /* synthetic */ ib(ScreenMirrorService screenMirrorService, OutputStream outputStream) {
        this.f4279a = screenMirrorService;
        this.f4280b = outputStream;
    }

    public void a(int i3, int i4, int i5) {
        rd rdVar = ScreenMirrorService.n6;
        this.f4279a.F6(this.f4280b, i3, 28, i4, i4 == 0 ? 0 : 100, 6, i5);
    }
}
